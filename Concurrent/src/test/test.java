package test;

import concurrent.point1;

/**
 * @description:
 * @author: Tong
 * @date: 2020-03-13 17:58
 */
public class test {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                point1.m4();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
