package Java8.lambda.stream;

import Java8.lambda.Demo;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description: 创建Stream
 * @author: Tong
 * @date: 2020-07-14 13:57
 */
public class StreamBase {
    /**
     * 创建Stream的方式：1.通过集合
     */
    @Test
    public void streamTest1() {
        List<Demo> list = DemoFactory.getDemoList();
        //顺序流
        Stream<Demo> stream = list.stream();

        //并行流
        Stream<Demo> parallelStream = list.parallelStream();

    }

    /**
     * 2.通过数组
     */
    public void streamTest2() {
        int[] intArr = new int[]{1, 2, 3, 4, 5, 6};

        IntStream stream = Arrays.stream(intArr);

    }

    /**
     * 3.通过Stream of
     */
    public void streamTest3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }


    /**
     * 4.生成无限流
     */
    @Test
    public void streamTest4() {
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
