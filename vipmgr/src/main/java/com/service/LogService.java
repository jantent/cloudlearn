package com.service;

import com.dao.LogVoMapper;
import com.domain.vo.LogVo;
import com.domain.vo.LogVoExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: tangJ
 * @Date: 2018/11/1 15:50
 * @description: 日志service
 */
@Service
public class LogService {

    @Autowired
    private LogVoMapper logDao;


    public void log(LogVo logVo) {
        logDao.insert(logVo);
    }

    public void log(String action, String data, String ip, Integer adminId) {
        LogVo logs = new LogVo();
        logs.setAction(action);
        logs.setDetail(data);
        logs.setClientIp(ip);
        logs.setLogWhen(new Date());
        logs.setWho(adminId);
        logDao.insert(logs);
    }

    public List<LogVo> getLogs(int page, int limit) {
        if (page <= 0) {
            page = 1;
        }
        LogVoExample logVoExample = new LogVoExample();
        logVoExample.setOrderByClause("id desc");
        PageHelper.startPage((page - 1) * limit, limit);
        List<LogVo> logVos = logDao.selectByExample(logVoExample);
        return logVos;
    }
}
