package concurrent.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @description: 变量可见性 ---
 * CountDownLatch
 * 当只涉及线程通信，不涉及同步时CountDownLatch比wait/notify更高效
 * @author: Tong
 * @date: 2020-03-13 21:22
 */
public class MyContainer5 {
    List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer5 container5 = new MyContainer5();

        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2---start");
            if (container5.getSize() != 5) {
                try {
                    latch.await();//
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2---end");
        }, "t2").start();

        new Thread(() -> {
                System.out.println("t1---start");
                for (int i = 0; i < 10; i++) {
                    container5.add(new Object());
                    System.out.println("add" + i);
                    if (container5.getSize() == 5) {
                        latch.countDown();//
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t1---end");

        }, "t1").start();

    }
}
