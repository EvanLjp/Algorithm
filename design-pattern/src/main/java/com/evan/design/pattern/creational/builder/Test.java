package com.evan.design.pattern.creational.builder;


/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = Computer.newBuilder().builderCpu("intel").builderDisplayCard("sumsung").build();
        System.out.println(computer);


    }
}
