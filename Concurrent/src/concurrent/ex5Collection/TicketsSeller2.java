package concurrent.ex5Collection;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @description: 虽然为同步容器，但判断与操作分离
 * @author: Tong
 * @date: 2020-03-16 19:04
 */
public class TicketsSeller2 {
    static Vector<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号:" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    try{
                        TimeUnit.MILLISECONDS.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("销售了：" + tickets.remove(0));
                }
            }).start();
        }
    }

}
