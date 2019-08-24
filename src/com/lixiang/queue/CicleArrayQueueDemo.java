package com.lixiang.queue;
/**
 * 环形数组：
 *         思路：front就指向队列的第一个元素，也就是说队列的第一个元素是front=0;
 *               rear指向队列的最后一个元素的后一个位置，也就是rear的初始值为rear=0;
 *               当队列满时，条件为（rear+1）%maxSize==front
 *               当队列为空时，条件为rear==front空
 *               队列中有效的数据的个数为（rear+maxSize-front）%maxSize
 */
public class CicleArrayQueueDemo {
    private  int maxSize;
    private  int front; //对头
    private  int rear;   //队尾
    private  int [] arr;
    //创建队列的构造器
    public  CicleArrayQueueDemo(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
    }
    //判断对列是否为满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
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
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }
    //获取队列的数据，出队列
    public int getQueue(){
        if(isEmpty()){
            System.out.println("对列为空，不能去数据");
            throw new RuntimeException("队列空，不能取数据");
            // return -1;   不能return-1 ，如果队列包含-1 ，容易造成误解，
        }
       int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }
    //显示Queue的所有数据
    public  void  showQueue(){
        if (isEmpty()){
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = front; i < size1(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
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
    //求出当前队列中有效数据的个数
    public int size1(){
        return (rear+maxSize-front)%maxSize;
    }
}
