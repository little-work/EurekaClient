package com.sunyard.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBoot {


    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "hello")
    public String helloCloud(){
        return "helloword";
    }

    @RequestMapping(value = "info")
    public String getInfo(){
        ServiceInstance instance=client.getLocalServiceInstance();
        return "主机是:"+instance.getHost()+"URL是:"+instance.getUri();
    }
}
