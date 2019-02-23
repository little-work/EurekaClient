package com.sunyard.eurekaclient.bean;

public class User {


    private String name;
    private String age;

    //值得注意的是  spring Cloud Feign要有默认的构造函数  不然的话 JSON转换成User对账会报错的
    public User() {
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
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
