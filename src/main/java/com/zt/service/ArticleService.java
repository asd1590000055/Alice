package com.zt.service;

import com.zt.entity.Article;
import com.zt.entity.ArticlePageDto;

import java.util.List;

/**
 * (Article)表服务接口
 *
 * @author makejava
 * @since 2019-12-03 17:33:20
 */
public interface ArticleService {
    //分页查
    public ArticlePageDto queryByPage(int curPage, int pageSize);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Article queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Article> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    void insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    void update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(Integer id);

    public List<Article> selectAll(Article article);

}