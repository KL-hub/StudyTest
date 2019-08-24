package com.lixiang.Sort;

import java.util.Arrays;

/**
 * 插入排序
 * 把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表只包含一个元素，无序
 * 表中包含n-1个元素。排序过程中每次从无序表中取出一个元素，把他的排序码依次与有序表的排序码进行比较
 * 将它插入到有序表的适当位置，使之成为新的有序表。
 */
public class ChaRuSort {
    public static void main(String[] args) {
        int arr[]=new int[]{9,3,-1,10,20};
        insertSort(arr);
    }
     public static  void insertSort(int [] arr){
         for (int i = 0; i < arr.length; i++) {
             int insertval=arr[i];
             int insertIndex=i-1;
             //还没找到位置
             while (insertIndex >=0 && arr[insertIndex]>insertval){
                 arr[insertIndex+1]=arr[insertIndex];
                 insertIndex--;
             }
             //退出循环，则说明找到插入位置，为
             arr[insertIndex+1]=insertval;
         }
         System.out.println(Arrays.toString(arr));
     }
}
