package concurrent.threadpool;

import java.util.concurrent.*;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-12 20:53
 */
public class T01_future {

    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(callable);
        try {
            System.out.println(future.get());//阻塞
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
