package com.zero.chn.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("send")
public class sendController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("sendMessage")
    public String sendMessage(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","zero");
        map.put("age",18);
        jmsMessagingTemplate.convertAndSend("itcast",map);
        return "OK";
    }
}
