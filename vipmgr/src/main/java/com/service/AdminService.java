package com.service;

import com.dao.AdminVoMapper;
import com.domain.vo.AdminVo;
import com.domain.vo.AdminVoExample;
import com.exception.TipException;
import com.util.EncUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: tangJ
 * @Date: 2018/11/1 14:07
 * @description: 管理员service
 */
@Service
public class AdminService {



    @Resource
    private AdminVoMapper adminDao;

    public AdminVo login(String username, String password){
        // 1.校验参数是否为空
        if (StringUtils.isBlank(username)&& StringUtils.isBlank(password)){
            throw new TipException("用户名和密码不能为空");
        }
        // 2.查询该用户是否存在
        AdminVoExample example = new AdminVoExample();
        AdminVoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        long count = adminDao.countByExample(example);
        if (count == 0){
            throw new TipException("该管理员不存在");
        }
        String encPwd = EncUtil.encodeSha256(password);
        criteria.andPasswordEqualTo(encPwd);
        // 3.验证用户名和密码
        List<AdminVo> adminVoList = adminDao.selectByExample(example);
        return adminVoList.get(0);
    }

    public void registerAdmin(AdminVo adminVo){
        String pwd = adminVo.getPassword();
        String encPwd = EncUtil.encodeSha256(pwd);
        adminVo.setPassword(encPwd);
        adminDao.insert(adminVo);
    }
}
