package concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: tryLock
 * @author: Tong
 * @date: 2020-03-13 22:02
 */
public class ReentrantLock2 {
    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();
            System.out.println("t1---start");
            for (int i = 0; i < 10; i++) {
                System.out.println("add" + i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//手动释放锁，synchnized中jvm发生异常会自动释放锁
            System.out.println("t1---end");
        }
    }

    void m2() {
        System.out.println("t2---start");
        boolean locked = false;
        try{
            locked = lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2------"+locked);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if(locked){
                lock.unlock();
            }
        }
        System.out.println("t2---end");
    }


    public static void main(String[] args) {
        ReentrantLock2 reentrantLock2 = new ReentrantLock2();
        new Thread(reentrantLock2::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(reentrantLock2::m2).start();
    }
}
