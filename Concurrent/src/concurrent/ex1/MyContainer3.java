package concurrent.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description: 变量可见性 ---
 *   wait 会释放锁，notify不会释放锁
 * @author: Tong
 * @date: 2020-03-13 21:22
 */
public class MyContainer3 {
    List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer3 container3 = new MyContainer3();

        final Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2---start");
                if (container3.getSize() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2---end");
            }
        }, "t2").start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1---start");
                for (int i = 0; i < 10; i++) {
                    container3.add(new Object());
                    System.out.println("add" + i);
                    if (container3.getSize() == 5) {
                        lock.notify();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t1---end");
            }
        }, "t1").start();

    }
}
