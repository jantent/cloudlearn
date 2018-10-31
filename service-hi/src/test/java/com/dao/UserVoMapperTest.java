package com.dao;

import com.domain.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author: tangJ
 * @Date: 2018/10/31 11:13
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserVoMapperTest {

    private String userName = "小王";

    private String userPassword = "aadfa";

    private String phoneNumber = "12345679888";

    private String email = "test@qq.com";

    @Autowired
    UserVoMapper userVoMapper;

    @Test
    public void insert(){
        UserVo userVo = new UserVo();

        userVo.setEmail(email);
        userVo.setPhoneNumber(phoneNumber);
        userVo.setUserName(userName);
        userVo.setUserPassword(userPassword);

        userVoMapper.insert(userVo);


    }
}