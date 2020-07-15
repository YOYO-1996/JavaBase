package concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-12 21:24
 */
public class T02_CachedPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
    }
}
