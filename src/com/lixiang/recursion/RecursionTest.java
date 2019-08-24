package com.lixiang.recursion;

/**
 * 递归
 *1、当程序执行到一个方法时，就会开辟一个独立的空间（栈）
 * 2、每个空间的数据（局部变量），是独立的。
 *
 */
public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(factorial(6));
    }
    public  static  int factorial(int n){
        if(n==1)
            return 1;
        return factorial(n-1)*n;
    }
}
