package com.os.model;

/**
 * DCL单例
 */
public class Singleton_3 {
    //声明单例对象
    private static Singleton_3 singleton_3;

    //私有化构造方法
    private Singleton_3() {
    }

    //同步该方法获取单例对象
    public static synchronized Singleton_3 getInstance() {
        //当该对象为空的时候先同步这个对象
        if (singleton_3 == null) {
            synchronized (Singleton_3.class) {
                //再判断是否为空
                if (singleton_3 == null) {
                    //如果还空的话 就创建对象
                    singleton_3 = new Singleton_3();
                }
            }
        }
        //返回该对象实例
        return singleton_3;
    }
}
