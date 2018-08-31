package com.evan.design.pattern.creational.factorymethod;

/**
 * @author :evan
 * @date :2018-08-27 14:55
 **/
public class JavaVedioFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
