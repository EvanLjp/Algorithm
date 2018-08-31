package com.evan.design.pattern.creational.factorymethod;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
//        VideoFactory videoFactory = new VideoFactory();
//        Video video = videoFactory.getVideo("java");
//        if(video == null){
//            return;
//        }
//        video.produce();

        VideoFactory videoFactory = new JavaVedioFactory();
        Video video = videoFactory.getVideo();
        video.produce();


    }

}
