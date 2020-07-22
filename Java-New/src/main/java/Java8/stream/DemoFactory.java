package Java8.stream;

import Java8.lambda.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-14 14:04
 */
public class DemoFactory {
    public static List<Demo> getDemoList(){
        List<Demo> list = new ArrayList<>();
        list.add(new Demo("demo1",18,1));
        list.add(new Demo("demo2",18,0));
        list.add(new Demo("demo3",19,1));
        list.add(new Demo("demo4",18,0));
        list.add(new Demo("demo5",24,1));
        return list;
    }
}
