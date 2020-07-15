package concurrent.collhigh;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: Tong
 * @date: 2020-03-16 19:14
 */
public class T02_CopyOnWriteList {
    CopyOnWriteArrayList list = new CopyOnWriteArrayList();
    public void get(){
        list.get(1);
    }
}
