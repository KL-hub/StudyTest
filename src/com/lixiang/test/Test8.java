package com.lixiang.test;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2019/9/5
 * @Version 1.0
 */
public class Test8 {
    int i;
    int j;
    public void doSomething() {
        System.out.println(++j+i);
    }

    public static void main(String[] args) {
        new Test8().doSomething();
    }

}
