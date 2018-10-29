package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: tangJ
 * @Date: 2018/10/29 13:46
 * @description:
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String helloWd(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
}
