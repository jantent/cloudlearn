package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tangj
 * @date 2018/10/30 21:50
 * @description:
 */
@Controller
public class IndexController {

    @GetMapping(value = "")
    public String index(){
        return "timeline";
    }
}
