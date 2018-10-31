package com.service;

import com.dao.UserVoMapper;
import com.domain.vo.UserVo;
import com.domain.vo.UserVoExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: tangJ
 * @Date: 2018/10/31 11:32
 * @description:
 */
@Service
public class UserService {

    @Autowired
    UserVoMapper userDao;

    public PageInfo<UserVo> searchAll(Integer p, Integer limit){
        UserVoExample example = new UserVoExample();
        example.setOrderByClause("created_time desc");
        PageHelper.startPage(p,limit);
        List<UserVo> userVoList = userDao.selectByExample(example);
        PageInfo<UserVo> pageInfo = new PageInfo<>(userVoList);
        return pageInfo;
    }
}
