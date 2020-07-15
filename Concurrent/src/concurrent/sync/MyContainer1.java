package concurrent.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description: 变量可见性
 * @author: Tong
 * @date: 2020-03-13 21:22
 */
public class MyContainer1 {
    List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer1 container1 = new MyContainer1();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                container1.add(new Object());
                System.out.println("add" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while (true){
                if (container1.getSize()==5){
                    break;
                }
            }
        }, "t2").start();

    }
}
