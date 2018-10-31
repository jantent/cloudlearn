package com.controller;

import com.domain.bo.LayRespBo;
import com.domain.vo.UserVo;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author tangj
 * @date 2018/10/30 21:50
 * @description:
 */
@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/")
    public String index(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "10") int limit) {
        return this.index(request, 1, limit);
    }

    @GetMapping(value = "/p/{p}")
    public String index(HttpServletRequest request, @PathVariable int p, @RequestParam(value = "limit", defaultValue = "10") int limit) {
        PageInfo<UserVo> users = userService.searchAll(p, limit);
        request.setAttribute("users", users);
        return "laytable";
    }

    @GetMapping(value = "/table/data")
    @ResponseBody
    public LayRespBo table(HttpServletRequest request){
        PageInfo<UserVo> users = userService.searchAll(0, 10);
        LayRespBo layRespBo = LayRespBo.data(users.getList());
        return layRespBo;
    }
}
