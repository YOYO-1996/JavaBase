package concurrent.threadpool.future.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 *
 */

public class BestProductPriceCalculator {
    static public class SyncShop {
        private String name;

        public SyncShop(String name) {
            this.name = name;
        }

        public static void delay() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public double getPrice(String product) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            delay();
            return random.nextDouble() * product.charAt(0) + product.charAt(1);
        }

        public String getName() {
            return name;
        }
    }

    private List<SyncShop> shops = Arrays.asList(
            new SyncShop("BestPrice"),
            new SyncShop("LetsSaveBig"),
            new SyncShop("MyFavoriteShop"),
            new SyncShop("BuyItAll")
    );

    public List<String> findPricesWithParallelStream(String product) {
        return shops
                .parallelStream()
                .map(shop -> shop.getName() + ":" + shop.getPrice(product))
                .collect(Collectors.toList());
    }

    public List<String> findPricesWithCompletableFuture(String product) {
        List<CompletableFuture<String>> futures = shops
                .stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + ":" + shop.getPrice(product)))
                .collect(Collectors.toList());
        // join方法和Future的get方法有相同的含义，并且也声明在Future接口中，它们唯一的不同就是join不会抛出任何检测到的异常。
        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }


    static class FutureTest {
        private BestProductPriceCalculator calculator = new BestProductPriceCalculator();

        // 1s
        public void testParallelStream() {
            calculator.findPricesWithParallelStream("my favorite product");
        }

        //2s
        public void testCompletableFuture() {
            calculator.findPricesWithCompletableFuture("my favorite product");
        }
    }

    public static void main(String[] args) {
        FutureTest test = new FutureTest();
//        test.testCompletableFuture();
        test.testParallelStream();

    }
}


