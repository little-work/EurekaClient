package com.sunyard.eurekaclient.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//为了验证springboot自动配置原理才会添加的类

@Configuration  //让他成为配置类
@EnableConfigurationProperties(HelloProperties.class) //无需多解释 可以配置@ConfigurationProperties注解来注入配置文件中的属性
@ConditionalOnClass(HelloService.class)  //注意是 类路径下面没有HelloService这个类的时候才不会加在这配置类  不是spring容器
public class MyAutoConfiguration {



    @Autowired
    HelloProperties helloProperties;

    //如果spring容器中没有HelloService这个类的时候才会去按照我们自定义的意思去在spring中添加这个HelloService  bean
    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService auto(){
        HelloService helloService =new HelloService();
        helloService.setName(helloProperties.getName());
        helloService.setAge(helloProperties.getAge());
        return helloService;
    }

}
