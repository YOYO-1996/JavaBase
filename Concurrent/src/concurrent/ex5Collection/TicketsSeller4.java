package concurrent.ex5Collection;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @description:
 * @author: Tong
 * @date: 2020-03-16 19:07
 */
public class TicketsSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedDeque<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号:" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    String str = tickets.poll();
                    if (null == str) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "销售了：" + str);
                }

            }).start();
        }
    }
}
