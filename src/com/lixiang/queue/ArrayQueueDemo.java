package com.lixiang.queue;

/**
 * 用数组模拟队列，存在的弊端，队列只能使用一次，指针一直上移，没有到达复用的效果。
 */
public class ArrayQueueDemo {
    private  int maxSize;
    private  int front; //对头
    private  int rear;   //队尾
    private  int [] arr;
    //创建队列的构造器
    public  ArrayQueueDemo(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;   //指向队列头前的一个位置
        rear=-1;   //指向队尾，指向队尾的数据
    }
    //判断对列是否为满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断对列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满，不能添加数据");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    //获取队列的数据，出队列
    public int getQueue(){
        if(isEmpty()){
            System.out.println("对列为空，不能去数据");
            throw new RuntimeException("队列空，不能取数据");
           // return -1;   不能return-1 ，如果队列包含-1 ，容易造成误解，
        }
        front++;
        return arr[front];
    }
    //显示Queue的所有数据
    public  void  showQueue(){
        if (isEmpty()){
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //获取队列头的元素
    public  int getFront(){
        if(isEmpty()){
            throw new RuntimeException("空队列，没有元素");
        }
        front++;
        return arr[front];
    }

}
