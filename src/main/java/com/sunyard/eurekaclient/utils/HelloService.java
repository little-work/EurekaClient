package com.sunyard.eurekaclient.utils;


import org.springframework.stereotype.Component;

//为了验证springboot自动配置原理才会添加的类

//@Component 值得注意的是  这个注解如果加上的话那么spring容器里面就会有这个bean了
// 那么MyAutoConfiguration这个自动配置类就不会帮我们按照我们自定义去 实例化这个HelloService类了
public class HelloService {

    private String name="没有就默认一个名字";
    private String age="没有就默认一个年龄28";

    public String who(){
        return  "这个人是："+name+age;
    }

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
