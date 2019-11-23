package com.lixiang.jdk8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Description //stream
 * @Author 李项
 * @Date 2019/11/23
 * @Version 1.0
 */
public class Stream {
    public static void main(String[] args) {
        //生成流
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
        //forEach
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        //map
        List<Integer> list=Arrays.asList(1,2,3,4);
        List<Integer> squaresList =list.stream().map(i->i*i).collect(Collectors.toList());
        System.out.println("squaresList"+squaresList);
        //filter
        List<String>string1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = string1.stream().filter(string -> string.isEmpty()).count();
        System.out.println("count"+count);
        //sorted
        Random random1 = new Random();
        random1.ints().limit(10).sorted().forEach(System.out::println);
        //parallelStream
        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count3 = strings2.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count3);
        //统计
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());


    }
}
