package com.sunyard.eurekaclient.utils;


import org.springframework.boot.context.properties.ConfigurationProperties;

//为了验证springboot自动配置原理才会添加的类
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}
