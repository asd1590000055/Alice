package com.zt.controller;

import com.zt.entity.Article;
import com.zt.entity.ArticlePageDto;
import com.zt.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (Article)表控制层
 *
 * @author makejava
 * @since 2019-12-03 17:33:20
 */
@Controller
@RequestMapping("article")
public class ArticleController {
    /**
     * 服务对象
     */
    @Autowired
    private ArticleService articleService;

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */

    @GetMapping("insert")
    public String insert(Article article, HttpServletRequest request) {
        this.articleService.insert(article);
        return "jsp/main";
    }

    @RequestMapping("selectOne")
    public String selectOne(int id, HttpServletRequest request) {
        Article article = articleService.queryById(id);
        request.setAttribute("article", article);
        System.out.println("lalalalalalala");
        return "jsp/article";
    }

    @RequestMapping("edit")
    @ResponseBody
    public void edit(String oper, int id) {
        if (oper.equals("del")) {
            articleService.deleteById(id);
        }
    }

    @RequestMapping("selectAll")
    public String selectAll(Article article, HttpServletRequest request) {
        List<Article> articles = articleService.selectAll(article);
        request.setAttribute("list", articles);
        return "jsp/index";
    }

    @RequestMapping("findAll")
    @ResponseBody
    // 当前页和每页显示的行数，必须是page和rows（jqgrid控制封装好的参数）
    public ArticlePageDto queryByPage(Integer page, Integer rows) {
        return this.articleService.queryByPage(page, rows);
    }

    // jqgrid的增删改处理
    @RequestMapping("/insertEdit")
    @ResponseBody  // 返回值是void，相当于把空字符 响应ajax回client
    // 参数oper，代表增删改的具体操作类型，名称 固定（jqgrid控制封装好的参数）
    public void save(Article article, String oper) {
        System.out.println("....in save.....");
        if ("add".equals(oper)) {
            this.articleService.insert(article);
        } else if ("edit".equals(oper)) {
            this.articleService.update(article);
        } else {
            this.articleService.deleteById(article.getId());
        }
    }

}