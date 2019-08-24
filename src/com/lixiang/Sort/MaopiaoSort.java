package com.lixiang.Sort;

/**
 * 冒泡排序
 */
public class MaopiaoSort {
    public static void main(String[] args) {
        int arr[]=new int[]{3,9,-1,10,20};
        boolean flag=false;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
            if(!flag)
                break;
            else
                flag=false;
       }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
