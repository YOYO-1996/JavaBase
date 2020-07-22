package Java8.stream;

import Java8.lambda.Demo;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: 流中间筛选
 * @author: Tong
 * @date: 2020-07-14 14:21
 */
public class StreamFilter {
    /**
     * 1.过滤
     */
    @Test
    public void streamTest1() {
        List<Demo> list = DemoFactory.getDemoList();
        //顺序流
        Stream<Demo> stream = list.stream();
        stream.filter(currDemo -> currDemo.getAge() > 18).forEach(System.out::println);
        System.out.println();
        list.stream().limit(2).forEach(System.out::println);
        System.out.println();
        list.stream().skip(2).forEach(System.out::println);
        System.out.println();
        list.stream().distinct().forEach(System.out::println);
        //并行流
        Stream<Demo> parallelStream = list.parallelStream();

    }

    /**
     * 2.映射---流转换
     */
    @Test
    public void streamTest2() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        //map接受一个函数作为参数
        //该函数接受一个参数，返回一个参数
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //ex1: Demo流--转--String流
        List<Demo> demos = DemoFactory.getDemoList();
        Stream<String> nameStream = demos.stream().map(Demo::getName);

        nameStream.filter(name -> name.charAt(4) == '5').forEach(System.out::println);
        //ex2: String流--转--字符流流
        Stream<Stream<Character>> streamStream = list.stream().map(StreamFilter::fromStringToCharStream);
        streamStream.forEach(s -> s.forEach(System.out::println));

    }

    public static Stream<Character> fromStringToCharStream(String str) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            characters.add(str.charAt(i));
        }
        return characters.stream();
    }

    /**
     * 3.排序
     */
    @Test
    public void streamTest3() {
        //自然排序
        List<Integer> integers = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        integers.stream().sorted().forEach(System.out::println);
        //重写comparator  (a,b)-> a.getAge()-b.getAge()
        List<Demo> demos = DemoFactory.getDemoList();
        demos.stream().sorted(Comparator.comparingInt(Demo::getAge).thenComparing(Demo::getSex)).forEach(System.out::println);
    }

    /**
     * 4.查找
     */
    @Test
    public void streamTest4() {
        List<Demo> demos = DemoFactory.getDemoList();
        //流中元素是否全部匹配
        boolean isAllMatch = demos.stream().allMatch(demo -> demo.getAge() > 18);
        System.out.println(isAllMatch);
        //流中元素是否有一个匹配
        boolean isAnyMatch = demos.stream().anyMatch(demo -> demo.getAge() > 18);
        System.out.println(isAnyMatch);
        //流中元素是否没有一个匹配
        boolean noneMatch = demos.stream().noneMatch(demo -> demo.getAge() > 18);
        System.out.println(noneMatch);
        //流中元素是否有一个匹配
        Optional<Demo> findFirst = demos.parallelStream().findFirst();
        System.out.println(findFirst);
        //流中元素是否有一个匹配
        Optional<Demo> findAny = demos.parallelStream().findAny();
        System.out.println(findAny);
    }

    /**
     * 4.查找
     */
    @Test
    public void streamTest5() {
        List<Demo> demos = DemoFactory.getDemoList();
        //数量
        long isAllMatch = demos.stream().filter(demo -> demo.getAge() > 18).count();
        System.out.println(isAllMatch);
        //最大
        Optional<Demo> maxDemo = demos.stream().max(Comparator.comparing(Demo::getAge));
        System.out.println(maxDemo);
        //foreach
        demos.stream().forEach(System.out::println);
    }

    /**
     * 5.规约
     */
    @Test
    public void streamTest6() {
        //计算1-10累加
        Stream<Integer> integers = Stream.iterate(1, t -> t + 1).limit(10);
        int res = integers.reduce(0, Integer::sum);
        System.out.println(res);

        //计算年龄综合
        List<Demo> demos = DemoFactory.getDemoList();
        Optional<Integer> ageSum = demos.stream().map(Demo::getAge).reduce(Integer::sum);
        System.out.println(ageSum);
    }

    /**
     * 6.收集
     */
    public void streamTest7(){
        List<Demo> demos = DemoFactory.getDemoList();
        Map<String, Integer> integerMap = demos.stream().filter(demo -> demo.getAge() > 18).collect(Collectors.toMap(Demo::getName, Demo::getAge));
    }
}
