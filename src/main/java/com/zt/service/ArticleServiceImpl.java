package com.zt.service;

import com.zt.aspect.Log;
import com.zt.dao.ArticleDao;
import com.zt.entity.Article;
import com.zt.entity.ArticlePageDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Article)表服务实现类
 *
 * @author makejava
 * @since 2019-12-03 17:33:20
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    @Override
    public ArticlePageDto queryByPage(int curPage, int pageSize) {
        ArticlePageDto dto = new ArticlePageDto();
        //调用dao
        dto.setPage(curPage);//设置当前页
        int totalCount = articleDao.selectTotalCount();
        dto.setRecords(totalCount);//设置总行数
        //总页数
        dto.setTotal(totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
        dto.setRows(articleDao.selectByPage(curPage, pageSize));//设置当前页的数据行
        return dto;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Article queryById(Integer id) {
        return this.articleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Article> queryAllByLimit(int offset, int limit) {
        return this.articleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Log(name = "用户的添加")
    @Override
    public void insert(Article article) {
        this.articleDao.insert(article);
    }

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Log(name = "用户的修改")
    @Override
    public void update(Article article) {
        this.articleDao.update(article);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Log(name = "用户删除")
    @Override
    public void deleteById(Integer id) {
        this.articleDao.deleteById(id);
    }

    @Override
    public List<Article> selectAll(Article article) {
        return this.articleDao.queryAll(article);
    }
}