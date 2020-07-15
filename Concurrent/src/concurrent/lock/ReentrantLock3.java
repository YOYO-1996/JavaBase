package concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 公平锁
 * @author: Tong
 * @date: 2020-03-13 22:02
 */
public class ReentrantLock3 extends Thread{
    static Lock lock = new ReentrantLock(true);

    public void run(){
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"--getLock");
            }finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        ReentrantLock3 reentrantLock3 = new ReentrantLock3();
        Thread thread1 = new Thread(reentrantLock3);
        Thread thread2 = new Thread(reentrantLock3);

        thread1.start();
        thread2.start();
    }
}
