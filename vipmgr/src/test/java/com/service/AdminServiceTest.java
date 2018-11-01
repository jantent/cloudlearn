package com.service;

import com.domain.vo.AdminVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author: tangJ
 * @Date: 2018/11/1 15:13
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

    private static String userName = "admin";
    private static String pwd = "123";
    private static String email = "jantent@foxmail.com";

    @Autowired
    AdminService adminService;

    @Test
    public void inserTest(){
        AdminVo adminVo = new AdminVo();
        adminVo.setPassword(pwd);
        adminVo.setEmail(email);
        adminVo.setUsername(userName);
        adminVo.setCreatedTime(new Date());
        adminService.registerAdmin(adminVo);
    }

    @Test
    public void login(){
        AdminVo adminVo = adminService.login(userName,pwd);
        System.out.println(adminVo);
    }
}
