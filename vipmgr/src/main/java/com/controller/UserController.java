package com.controller;

import com.domain.vo.UserVo;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author tangj
 * @date 2018/10/30 21:50
 * @description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "")
    public String index(Model model){
        return "mgrindex";
    }

    @GetMapping(value = "/list")
    public String list(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "10") int size, @Valid UserVo user) {

        PageInfo<UserVo> users = userService.searchAll(page, size, user);
        request.setAttribute("userList", users.getList());
        request.setAttribute("user", user);
        return "usermgr";
    }

    @GetMapping(value = "/detail")
    public String detail(HttpServletRequest request, @RequestParam String userId) {
        UserVo userVo = userService.getOne(userId);
        request.setAttribute("user", userVo);
        return "userDetail";
    }

    @GetMapping(value = "/edit")
    public String edit(HttpServletRequest request, @RequestParam(required = false) String userId) {
        UserVo userVo = new UserVo();
        if (userId != null) {
            userVo = userService.getOne(userId);
        }
        request.setAttribute("user", userVo);
        return "useredit";
    }

    @PostMapping(value = "/edit/save")
    @ResponseBody
    public ModelMap editSave(HttpServletRequest request, UserVo userVo) {
        ModelMap modelMap = userService.saveOne(userVo);
        return modelMap;
    }

    @GetMapping(value = "/del")
    @ResponseBody
    public ModelMap del(HttpServletRequest request, @RequestParam Integer userId){
        ModelMap modelMap = userService.delOne(userId);
        return modelMap;
    }
}
