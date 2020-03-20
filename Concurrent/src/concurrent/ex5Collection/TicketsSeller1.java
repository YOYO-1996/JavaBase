package concurrent.ex5Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @description:
 * @author: Tong
 * @date: 2020-03-16 19:00
 */
public class TicketsSeller1 {
    static List<String> tickets = new ArrayList<>();
    
    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号:"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (tickets.size()>0){
                    System.out.println("销售了："+tickets.remove(0));
                }
            }).start();
        }
    }

}
