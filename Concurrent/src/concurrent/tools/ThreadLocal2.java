package concurrent.tools;

import java.util.concurrent.TimeUnit;

/**
 * @description: 当前线程局部变量
 * @author: Tong
 * @date: 2020-03-14 9:14
 */
public class ThreadLocal2 {
//    volatile static Person person = new Person();

    static ThreadLocal<Person> temp = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(temp.get());
            }
        }).start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                temp.set(new Person());
            }
        });
    }

    static class Person {
        String name = "zhangsan";
    }
}

