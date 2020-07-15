package concurrent.collhigh;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Tong
 * @date: 2020-03-16 19:14
 */
public class T01_ConcurrentMap {

    public static void main(String[] args) {
//        Map<String,String> map = new ConcurrentHashMap<>();
//        Map<String,String> map = new ConcurrentSkipListMap<>();//高并发且排序

        Map<String,String> map = new Hashtable<>();
//        Map<String,String> map = new HashMap<>();//Conllections.synchronizedXXX->返回一个带锁的容器
        //TreeMap
        Random r = new Random();
        Thread[] ths = new Thread[100];
        CountDownLatch latch = new CountDownLatch(ths.length);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    map.put("a"+r.nextInt(100000),"a"+r.nextInt(100000));
                    latch.countDown();
                }
            });
        }

        Arrays.asList(ths).forEach(t->t.start());

        try{
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
