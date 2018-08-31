package com.evan.design.pattern.creational.singleton;

/**
 * @author :evan
 * @date :2018-08-28 18:32
 **/
public class HungrySingleton {

    private final static HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton() {
        if(HUNGRY_SINGLETON != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }
}
