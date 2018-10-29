package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tangJ
 * @Date: 2018/10/29 17:27
 * @description:
 */
@RestController
public class HiController {
    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String helloHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }

}
