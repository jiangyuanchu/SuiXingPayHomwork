package com.os.model;

/**
 * 静态代码块单例
 */
public class Singleton_5 {
    private static Singleton_5 singleton_5 = null;

    private Singleton_5() {
    }

    static {
        singleton_5 = new Singleton_5();
    }

    public static Singleton_5 getInstance() {
        return singleton_5;
    }

}
