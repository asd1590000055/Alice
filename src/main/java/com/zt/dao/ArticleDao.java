package com.zt.dao;

import com.zt.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-03 17:33:20
 */
public interface ArticleDao {
    //分页查
    public List<Article> selectByPage(@Param("curPage") int curPage, @Param("pageSize") int pageSize);

    //查总行数
    public int selectTotalCount();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Article queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Article> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param article 实例对象
     * @return 对象列表
     */
    List<Article> queryAll(Article article);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}