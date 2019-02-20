package com.sunyard.eurekaclient.controller;

import com.sunyard.eurekaclient.utils.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBoot {


    @Autowired
    private DiscoveryClient client;

    //验证springboot自动配置原理
    @Autowired
    private HelloService helloService;
    //验证springboot自动配置原理
    @RequestMapping("/auto")
    public String home(){
        return helloService.who();
    }

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
