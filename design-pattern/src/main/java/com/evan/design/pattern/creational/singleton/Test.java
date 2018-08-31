package com.evan.design.pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @author :evan
 * @date :2018-08-28 18:38
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        //lazySingleton不能避免反射攻击
        Class<LazySingleton> lazySingletonClass = LazySingleton.class;
        Constructor<LazySingleton> constructor = lazySingletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazySingleton lazySingleton = constructor.newInstance();
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(instance);
        System.out.println(lazySingleton);
        System.out.println(instance == lazySingleton);

        //lazyDoubleCheck不能避免反射攻击
        Class<LazyDoubleCheckSingleton> lazyDoubleCheckSingletonClass = LazyDoubleCheckSingleton.class;
        Constructor<LazyDoubleCheckSingleton> lazyDoubleCheckSingletonClassDeclaredConstructor = lazyDoubleCheckSingletonClass.getDeclaredConstructor();
        lazyDoubleCheckSingletonClassDeclaredConstructor.setAccessible(true);
        LazyDoubleCheckSingleton lazyDoubleCheckSingleton = lazyDoubleCheckSingletonClassDeclaredConstructor.newInstance();
        LazyDoubleCheckSingleton instance1 = LazyDoubleCheckSingleton.getInstance();
        System.out.println(lazyDoubleCheckSingleton);
        System.out.println(instance1);
        System.out.println(lazyDoubleCheckSingleton == instance1);

        //staticInnerClassSingletonClass可以避免
        StaticInnerClassSingleton innerClassSingleton = StaticInnerClassSingleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(innerClassSingleton);

        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        StaticInnerClassSingleton newInstance = (StaticInnerClassSingleton) ois.readObject();
        System.out.println(innerClassSingleton);
        System.out.println(newInstance);
        System.out.println(innerClassSingleton == newInstance);



        Class<StaticInnerClassSingleton> staticInnerClassSingletonClass = StaticInnerClassSingleton.class;
        Constructor<StaticInnerClassSingleton> staticInnerClassSingletonClassDeclaredConstructor = staticInnerClassSingletonClass.getDeclaredConstructor();
        staticInnerClassSingletonClassDeclaredConstructor.setAccessible(true);
        StaticInnerClassSingleton staticInnerClassSingleton = staticInnerClassSingletonClassDeclaredConstructor.newInstance();
        StaticInnerClassSingleton instance2 = StaticInnerClassSingleton.getInstance();
        System.out.println(staticInnerClassSingleton);
        System.out.println(instance2);
        System.out.println(staticInnerClassSingleton == instance2);

        //hungrySingleton可以避免
        //enum可以避免


    }


}
