package com.zt;

import com.zt.entity.Admin;
import com.zt.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(value = "SpringbootApplication.class")
//启动测试
@RunWith(value = SpringRunner.class)
public class TestAdminSelectByName {
    @Autowired
    AdminService adminService;

    @Test
    public void testSelectByName() {
        List<Admin> admin = adminService.queryByName("admin");
        System.out.println(admin);
    }
}
