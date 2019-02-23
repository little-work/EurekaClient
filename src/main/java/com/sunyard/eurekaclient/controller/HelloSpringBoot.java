package com.sunyard.eurekaclient.controller;

import com.sunyard.eurekaclient.bean.User;
import com.sunyard.eurekaclient.utils.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 不带参数一个接口
     * @return
     */
    @RequestMapping(value = "hello")
    public String helloservice(){
        return "分布式服务中一个不带参数的接口验证";
    }


    /**
     * get请求参数
     * @return
     */
    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    public String HelloService2(@RequestParam String name){
        return "GET请求方式，传进来的参数是："+name;
    }

    /**
     * post的请求方式
     * @param user
     * @return
     */
    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    public String helloservice3(@RequestBody User user){
        return "POST请求方式，传进来的参数是："+user.getName()+user.getAge();
    }

    @RequestMapping(value = "info")
    public String getInfo(){
        ServiceInstance instance=client.getLocalServiceInstance();
        return "主机是:"+instance.getHost()+"URL是:"+instance.getUri();
    }


}
