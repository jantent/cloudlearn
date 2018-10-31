package com.service;

import com.domain.vo.UserVo;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author: tangJ
 * @Date: 2018/10/31 11:59
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    UserService userService;

    @Test
    public void searchAll() {
        PageInfo<UserVo> users = userService.searchAll(1,10);
        System.out.println(users);
    }
}