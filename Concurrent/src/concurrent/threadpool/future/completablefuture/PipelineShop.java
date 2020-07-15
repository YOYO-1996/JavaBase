package concurrent.threadpool.future.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class PipelineShop {
    private String name;

    public PipelineShop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPrice(String product) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        double price = calculatePrice(product);
        Discount.DiscountCode code = Discount.DiscountCode.values()[random.nextInt(Discount.DiscountCode.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }
    
    private double calculatePrice(String product) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        // 模拟耗时操作
        delay();
        // 随机
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Discount {
    public enum DiscountCode{
        NONE(0),SILVER(5),GOLD(10),PLATINUM(15),DIAMOND(20);
        private int percentage;
        DiscountCode(int percentage){
            this.percentage = percentage;    
        }
    }
    
     public static String applyDiscount(Quote quote){
        return quote.getShopName()+ " price is " + apply(quote.getPrice(), quote.getDiscountCode());
     }

    private static double apply(double price, DiscountCode discountCode) {
        // 模拟调用远程服务的延迟
        PipelineShop.delay();
        return price * ( 100 - discountCode.percentage ) / 100 ; 
    }

}

class Quote {
    private String shopName;
    private double price;
    private Discount.DiscountCode discountCode;

    public Quote(String shopName, double price, Discount.DiscountCode discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }
    
    public static Quote parse(String str){
        String [] slices = str.split(":");
        return new Quote(slices[0],Double.parseDouble(slices[1]),Discount.DiscountCode.valueOf(slices[2]));
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.DiscountCode getDiscountCode() {
        return discountCode;
    }
}


class BestProductPriceWithDiscountCalculator {
    private List<PipelineShop> shops = Arrays.asList(
            new PipelineShop("BestPrice"),
            new PipelineShop("LetsSaveBig"),
            new PipelineShop("MyFavoriteShop"),
            new PipelineShop("BuyItAll")
    );

    public List<String> findPricesWithPipeline(String product) {
        List<CompletableFuture<String>> futures = shops
                .stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(
                        quote -> CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote)
                        )
                ))
                .collect(Collectors.toList());
        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
}