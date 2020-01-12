package com.lixiang.test;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2019/9/5
 * @Version 1.0
 */
public class Test3 {

    public static void main(String[] args) {
        int count=0;
        int num=0;
        for (int i = 0; i <=100 ; i++) {
            num = num + i;
            count=count++;
        }
        System.out.println(num*count);
    }
}
