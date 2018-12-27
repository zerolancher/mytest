package com.zero.chn.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("User")
public class UserController {
      @Autowired
      private Environment ev;

    @RequestMapping("getName")
    public String sendMessage(){
       return "hah"+ev.getProperty("url");
    }

}
