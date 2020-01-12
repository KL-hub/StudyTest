package com.lixiang.test;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2019/9/5
 * @Version 1.0
 */
public class Test9 {
    int a(int i){
        return ++i;
    }
    int b( int i){
        return ++i;
    }
    int c(Integer i){
        return ++i;
    }

    public static void main(String[] args) {
        new Test9().a(0);
        new Test9().b(0);
        new Test9().c(0);
    }
}
