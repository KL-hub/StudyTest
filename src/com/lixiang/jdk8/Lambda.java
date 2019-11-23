package com.lixiang.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2019/11/23
 * @Version 1.0
 */
public class Lambda {
    public static void main(String[] args) {
        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");
        Collections.sort(names2,(s1,s2) ->s1.compareTo(s2));
        System.out.println(names2);


        List names = new ArrayList();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
    }
}
