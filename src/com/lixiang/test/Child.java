package com.lixiang.test;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2019/9/5
 * @Version 1.0
 */
class Parent {
    public float aFun(float a,float b){
        return a+b;
    }
}
public class Child extends Parent{
     //float aFun(float a, float b){return a+b;}
    public int paFun(int  a, int b) { return a+b; }
    public float paFun(float  a, float b) { return a+b; }
    private int aFun(int a,int b){return a+b;}

    public static void main(String[] args) {
        Child c=new Child();
        System.out.println(c.paFun(0.1f,0.2f));
    }
}
