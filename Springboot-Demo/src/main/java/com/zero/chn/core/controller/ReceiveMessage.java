package com.zero.chn.core.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class ReceiveMessage {

    @JmsListener(destination = "itcast")
    public void ReceiveMap(Map map){
        System.out.println("姓名"+map.get("name"));
        System.out.println("年龄"+map.get("age"));
    }
}
