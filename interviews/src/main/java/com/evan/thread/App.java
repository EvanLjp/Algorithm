package com.evan.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :evan
 * @date :2018-08-18 18:05
 **/
public class App {
    static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread1");
        }
    });
    static Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread2");
        }
    });
    static Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread3");
        }
    });
    static ExecutorService executorService=Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
        //join方法,让主线程等待子线程执行完毕继续执行
        /*thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();*/

        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        executorService.shutdown();
    }
}
