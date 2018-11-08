package com.service;

import com.domain.vo.UserVo;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tangj
 * @date 2018/11/8 23:39
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testFindAll(){
        int page = 1;
        int limit = 10;
        PageInfo<UserVo> pageInfo = userService.searchAll(page,limit);
        System.out.println(pageInfo);
    }
}
