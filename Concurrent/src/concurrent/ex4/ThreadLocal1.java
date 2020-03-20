package concurrent.ex4;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Tong
 * @date: 2020-03-14 9:14
 */
public class ThreadLocal1 {
    volatile static Person person = new Person();

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(person.name);
            }
        }).start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                person.name="lisi";
            }
        });
    }
}

class Person {
    String name = "zhangsan";
}