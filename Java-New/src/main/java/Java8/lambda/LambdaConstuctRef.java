package Java8.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-14 13:49
 */
public class LambdaConstuctRef {

    /**
     * 构造器引用
     * 参数列表需相同
     *
     * @return
     */
    public void constructTest1() {
        /**
         * 第1种写法
         */
        Supplier<Demo> supplier = new Supplier<Demo>() {
            @Override
            public Demo get() {
                return new Demo();
            }
        };
        System.out.println("*************************************");
        /**
         * 第2种写法
         */
        Supplier<Demo> supplier1 = () -> new Demo();

        System.out.println("************************************");
        /**
         * 第3种写法
         */
        Supplier<Demo> supplier2 = Demo::new;
    }

    /**
     * 数组引用
     * 参数列表需相同
     *
     * @return
     */
    public void arrayTest1() {
        Function<Integer, String[]> function1 = length -> new String[length];

        System.out.println("****************************");

        Function<Integer, String[]> function2 = String[]::new;
    }
}
