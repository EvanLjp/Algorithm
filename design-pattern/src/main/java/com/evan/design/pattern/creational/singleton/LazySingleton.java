package com.evan.design.pattern.creational.singleton;

/**
 * @author :evan
 * @date :2018-08-28 17:34
 **/
public class LazySingleton {

    private LazySingleton() {
        if(lazySingleton != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    private static LazySingleton lazySingleton = null;

    public synchronized static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
