package com.lixiang.Sort;

import java.util.Arrays;

/**
 * 选择排序
 * 第一次：arr[0] 与  n-1 中的最小的，交换
 * 第二次  arr[1] 与  n-2 中的最小值交换
 *
 * 第n-1次，arr[n-2] 与 n个元素的最小值交换
 */

public class XuanZeSort {
    public static void main(String[] args) {
        int arr[]=new int[]{3,9,-1,10,20};
        for(int i=0;i<arr.length-1;i++){
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
