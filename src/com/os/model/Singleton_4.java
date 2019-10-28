package com.os.model;

/**
 * 静态内部类单例
 */
public class Singleton_4 {
    //私有化构造方法
    private Singleton_4() {
    }

    //获取单例对象
    public static Singleton_4 getInstance() {
        //返回内部类中的singleton对象
        return SingletonHolder.singleton_4;
    }

    /**
     * 静态内部类
     * 第一次加载类的时候不用调用该类，创建singleton对象，
     * 只有调用getInstance()方法时才会创建该对象。
     */
    private static class SingletonHolder {
        private static final Singleton_4 singleton_4 = new Singleton_4();
    }
}
