package com.evan.design.pattern.creational.factorymethod;

/**
 * @author :evan
 * @date :2018-08-27 14:58
 **/
public class FEVedioFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new FEVedio();
    }
}
