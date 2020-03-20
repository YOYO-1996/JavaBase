package concurrent.ex3;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Tong
 * @date: 2020-03-13 22:53
 */
public class MyContainer2 {
    final private LinkedList<String> list = new LinkedList();
    final private int MAX = 10;

    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition customer = lock.newCondition();


    public void put(String str) {
        lock.lock();
        while (list.size() == MAX) {
            try {
                producer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(str);
        ++count;
        customer.signalAll();
        lock.unlock();
    }

    public String get() {
        lock.lock();
        while (list.size() == 0) {
            try {
                customer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String re = list.removeFirst();
        --count;
        producer.signalAll();
        lock.unlock();
        return re;
    }

    public static void main(String[] args) {
        MyContainer2 container2 = new MyContainer2();

        new Thread(() -> {
            for (int j = 0; j < 25; j++) {
                System.out.println("线程：" + Thread.currentThread().getName() + "get====" + "结果为：" + container2.get());
            }
        }, "customer").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            for (int j = 0; j < 25; j++) {
                System.out.println("线程：" + Thread.currentThread().getName() + "put====" + "str" + j);
                container2.put("str[" + Thread.currentThread().getName() + "]" + "[" + j + "]");
            }
        }, "producer").start();

    }
}
