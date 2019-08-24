package com.lixiang.stack;

/**
 * 中缀表达式;
 * 1)通过一个index值（索引），来遍历我们的表达式
 * 2）如果我们发现是一个数字，就直接入数栈
 * 3）如果我们发现是一个符号，就分以下情况
 * 3.1）如果符号栈为空，就直接入栈。
 * 3.2)如果符号栈有操作符，如果当前对的操作符的优先级小于等于栈中的操作符，就从数栈中取出两个元素，从符号栈中pop出一个元素运算得到结果，，入数栈
 * 然后将当前的操作符入符号栈。
 * 如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈。
 *  4)当表达式扫描完毕，就顺利的从数栈和符号栈中pop出相应的数和符号，运行。
 *  5）最后在数栈中只有一个数字，就是表达式的结果。
 */
public class Calculator {
    //思路如上
}
class  ArrayStack2{
    private int maxSize;
    private  int[] stack;
    private  int top=-1;
    public  ArrayStack2(int maxSize){
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }
    //栈满
    public boolean isFull(){
        return  top==maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return  top==-1;
    }
    //入栈  push
    public  void push(int value){
        if(isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top]=value;

    }
    //出栈
    public int  pop(){
        if(isEmpty()){
            System.out.println("栈已空");
            throw  new RuntimeException("栈空");
        }
        int value=stack[top];
        top--;
        return value;
    }
    //遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈为空，没有数据");
            return;
        }
        for(int i=top;i>-1;i--){
            System.out.println(stack[top]);
        }
    }
    public int priority(int oper){
        if(oper == '*'|| oper =='/'){
            return 1;
        }else  if (oper == '+'|| oper =='-') {
            return 0;
        }else
            return -1;
    }
}