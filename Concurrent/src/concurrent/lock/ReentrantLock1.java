package concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ReentrantLock--手动上锁，手动释放；synchronized，手动上锁，自动释放
 * @author: Tong
 * @date: 2020-03-13 22:02
 */
public class ReentrantLock1 {
    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();
            System.out.println("t1---start");
            for (int i = 0; i < 10; i++) {
                System.out.println("add" + i);
            }
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//手动释放锁，synchnized中jvm发生异常会自动释放锁
            System.out.println("t1---end");
        }
    }

    void m2() {
        lock.lock();
        System.out.println("t2---start");
        System.out.println("t2---end");
        lock.unlock();
    }


    public static void main(String[] args) {
        ReentrantLock1 reentrantLock1 = new ReentrantLock1();
        new Thread(reentrantLock1::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(reentrantLock1::m2).start();
    }
}
