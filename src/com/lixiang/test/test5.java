package com.lixiang.test;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2019/9/5
 * @Version 1.0
 */
class Base{
public Base(String s){
    System.out.println("B");
    }
}
public class test5 extends Base{

    public test5(String s) {
        super(s);
        System.out.println("D");
    }
    public static void main(String[] args) {
        new test5("C");
    }
}

