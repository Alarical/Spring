package com.itheima.proxy.jdk;

public class Advice {

    public void before(){
        System.out.println("增强前");
    }

    public void after(){
        System.out.println("增强后。。。。");
    }

}
