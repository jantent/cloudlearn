package com.service;

import com.dao.UserVoMapper;
import com.domain.bo.RestResult;
import com.domain.vo.UserVo;
import com.domain.vo.UserVoExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Date;
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

    /**
     * 查询所有记录
     *
     * @param p
     * @param limit
     * @return
     */
    public PageInfo<UserVo> searchAll(Integer p, Integer limit) {
        UserVoExample example = new UserVoExample();
        example.setOrderByClause("created_time desc");
        PageHelper.startPage(p, limit);
        List<UserVo> userVoList = userDao.selectByExample(example);
        PageInfo<UserVo> pageInfo = new PageInfo<>(userVoList);
        return pageInfo;
    }

    /**
     * 获取一条用户信息
     *
     * @param uid
     * @return
     */
    public UserVo getOne(String uid) {
        Integer id = new Integer(uid);
        UserVo userVo = userDao.selectByPrimaryKey(id);
        return userVo;
    }

    /**
     * 存储或更新一条记录
     * @param userVo
     * @return
     */
    public ModelMap saveOne(UserVo userVo){
        UserVoExample example = new UserVoExample();

        // 校验账户是否唯一
        String account = userVo.getAccount();
        example.createCriteria().andAccountEqualTo(account);

        long count = userDao.countByExample(example);

        userVo.setModifiedTime(new Date());
        if (count>0){
            userDao.updateByExampleSelective(userVo,example);
        }else {
            int result = userDao.insert(userVo);
        }
        return RestResult.ok();
    }
}
