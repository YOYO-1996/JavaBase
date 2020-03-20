package concurrent.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description: 变量可见性---volatile
 * @author: Tong
 * @date: 2020-03-13 21:22
 */
public class MyContainer2 {
    volatile List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer2 container2 = new MyContainer2();

        new Thread(() -> {
            System.out.println("t1---start");
            for (int i = 0; i < 10; i++) {
                container2.add(new Object());
                System.out.println("add" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1---end");
        }, "t1").start();

        new Thread(() -> {
            System.out.println("t2---start");
            while (true) {
                if (container2.getSize() == 5) {
                    break;
                }
            }
            System.out.println("t2---end");
        }, "t2").start();

    }
}
