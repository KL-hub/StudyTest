package com.lixiang.recursion;

/**
 * 八皇后问题
 */
public class Queue8 {
    int max =8;
    int [] arr=new int[max];
     static  int count=0;
    public static void main(String[] args) {
        Queue8 queue8=new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种解法",count);

    }
    //编写一个方法，放置n个元素
    private  void check(int n){
        if (n== max){  // 已经放好
            print();
            return;
        }
        //依次放入皇后，放到该行的第一列
        for (int i = 0; i < max; i++) {
            arr[n]=i;   //放到该行的第一列
            if(judge(n)){   //不冲突
                check(n+1);
            }

        }
    }
    //查看当我们放置n个皇后，就去检测皇后是否和前面已经摆放的皇后冲突
    private  boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //Math.abs(n-i)==Math.abs(arr[n]-arr[i] 判断是否在同一斜线
            //arr[i]==arr[n]   判断是否在同一列
            if(arr[i]==arr[n] || Math.abs(n-i)==Math.abs(arr[n]-arr[i]))
                return false;
        }
        return   true;
    }
    private  void print(){
        count++;
        for (int i =0; i <arr.length ;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
