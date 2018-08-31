package com.evan.design.pattern.creational.factorymethod;

/**
 * @author :evan
 * @date :2018-08-27 14:56
 **/
public class PythonVedioFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
