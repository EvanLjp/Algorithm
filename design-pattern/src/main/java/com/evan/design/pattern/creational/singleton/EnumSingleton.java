package com.evan.design.pattern.creational.singleton;


/**
 * @description: 枚举模式
 * @author: evan
 * @create: 2018-07-14 19:52
 **/
public enum EnumSingleton {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

}
