package com.lixiang.Sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] ={8,9,9,1,3,4,5,2,1,1,3};
        shellSort2(arr);

    }
    //交换法
    public static void  shellSort(int [] arr){

        for(int gap=arr.length;gap>0;gap/=2){
            for (int i = gap; i <arr.length; i++) {
                for (int j = i-gap; j >=0 ; j-=gap) {
                    if (arr[i]>arr[j]){
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }

            }
        }
        System.out.println("排序后的数组"+ Arrays.toString(arr));
    }

    //位移法
    public  static  void shellSort2(int [] arr){

        for(int gap=arr.length/2;gap>0;gap/=2){
            for (int i = gap; i < arr.length; i++) {
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0 && temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }

            }
        }
        System.out.println("排序后的数组"+ Arrays.toString(arr));
    }
}
