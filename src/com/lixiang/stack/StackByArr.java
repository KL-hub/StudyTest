package com.lixiang.stack;

import java.util.Scanner;

/**思路：
 * 1）使用数组来模拟栈
 * 2）定义一个top来表示栈顶，初始化-1
 * 3) 入栈： top++;stack[top]=data;
 * 4)出栈：  int  value=stack[top];top--,return value;
 */
public class StackByArr {
    public static void main(String[] args) {
        ArrayStack arrayStack=new ArrayStack(4);
        String key="";
        boolean loop=true;
        Scanner scanner=new Scanner(System.in);
        while (loop){
            System.out.println("show :显示栈");
            System.out.println("exit :退出");
            System.out.println("push :入栈");
            System.out.println("pop : 出栈");
            key=scanner.next();
            switch (key){
                case "show":{
                    arrayStack.list();
                    break;
                }
                case "push":{
                    System.out.println("请输入一个整数");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                }
                case "pop":{
                    int value = arrayStack.pop();
                    System.out.println("出栈的数据是"+value);
                    break;
                }
                case "exit":{
                    scanner.close();
                    loop=false;
                    break;
                }
            }

        }
        System.out.println("程序退出了----------");
    }
}
class  ArrayStack{
        private int maxSize;
        private  int[] stack;
        private  int top=-1;
        public  ArrayStack(int maxSize){
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
}