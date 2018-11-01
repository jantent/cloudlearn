package com.controller;

import com.constant.LogActions;
import com.constant.WebConst;
import com.domain.bo.RestResult;
import com.domain.vo.AdminVo;
import com.exception.TipException;
import com.service.AdminService;
import com.service.LogService;
import com.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: tangJ
 * @Date: 2018/11/1 13:47
 * @description:
 */
@Controller
@RequestMapping("/admin")
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AdminService adminService;

    @Resource
    private LogService logService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("login")
    @ResponseBody
    public ModelMap doLogin(@RequestParam String username,
                            @RequestParam String password,
                            HttpServletRequest request,
                            HttpServletResponse response){
        try {
            // 判断登录
            AdminVo adminVo = adminService.login(username,password);
            // 添加session
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, adminVo);
            // 添加cookie
            WebUtil.setCookie(response,adminVo.getId());
            // 记录日志
            logService.log(LogActions.LOGIN.getAction(),null,request.getRemoteAddr(),adminVo.getId());
        }catch (Exception e){
            String msg = "登录失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            }
            logger.error(msg, e);
            return RestResult.fail(msg);
        }
        return RestResult.ok();
    }
}
