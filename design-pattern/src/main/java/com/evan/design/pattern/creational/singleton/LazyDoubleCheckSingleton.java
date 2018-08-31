package com.evan.design.pattern.creational.singleton;

/**
 * @author :evan
 * @date :2018-08-28 17:37
 **/
public class LazyDoubleCheckSingleton {

    private LazyDoubleCheckSingleton() {

    }

    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;


    public static LazyDoubleCheckSingleton getInstance() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
