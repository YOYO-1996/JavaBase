package concurrent.ex3;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Tong
 * @date: 2020-03-13 22:53
 */
public class MyContainer1 {
    final private LinkedList<String> list = new LinkedList();
    final private int MAX = 10;

    private int count = 0;

    public synchronized void put(String str){
        while(list.size()==MAX){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        list.add(str);
        ++count;
        this.notifyAll();
    }

    public synchronized String get(){
        while(list.size()==0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        String re = list.removeFirst();
        --count;
        this.notifyAll();
        return re;
    }

    public static void main(String[] args) {
        MyContainer1 container1 = new MyContainer1();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName()+"get");
                    System.out.println(container1.get());
                }
            },"c"+i).start();
        }

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    System.out.println(Thread.currentThread().getName()+"put  "+"str"+j);
                    container1.put(Thread.currentThread().getName()+"str"+j);
                }
            },"p"+i).start();
        }
    }
}
