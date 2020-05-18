package com.zt.controller;

import com.zt.entity.Admin;
import com.zt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2019-12-03 17:24:25
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Admin selectOne(Integer id) {
        return this.adminService.queryById(id);
    }

    @GetMapping("login")
    public String selectByName(String name, String password, HttpSession session) {
        System.out.println(name);
        System.out.println(password);
        List<Admin> admins = this.adminService.queryByName(name);
        session.setAttribute("admin", name);
        for (Admin admin : admins) {
            if (admin == null) {
                return "redirect:/jsp/login.jsp";
            } else {
                if (admin.getPassword().equals(password)) {
                    return "redirect:/jsp/main.jsp";
                } else {
                    return "redirect:/jsp/login.jsp";
                }
            }
        }
        return null;
    }
}
