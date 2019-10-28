package com.os.model;

/**
 * 懒汉式
 */
public class Singleton_2 {
    //声明单例对象
    private static Singleton_2 singleton_2;

    //私有化构造方法
    private Singleton_2() {
    }

    //同步该方法获取单例对象
    public static synchronized Singleton_2 getInstance() {
        //当该对象为空的时候创建该对象
        if (singleton_2 == null) {
            singleton_2 = new Singleton_2();
        }
        //返回该对象实例
        return singleton_2;
    }
}
