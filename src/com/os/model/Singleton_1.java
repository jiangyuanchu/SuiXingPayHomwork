package com.os.model;

/**
 * 饿汉式
 */
public class Singleton_1 {
    //生成单例对象
    private static final Singleton_1 singleton_1 = new Singleton_1();

    //私有化构造方法
    private Singleton_1() {
    }

    //获取单例对象
    public static Singleton_1 getInstance() {
        return singleton_1;
    }
}
