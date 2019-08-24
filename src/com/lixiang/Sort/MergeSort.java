package com.lixiang.Sort;

import java.util.Arrays;

/**
 * 归并排序
 * 分治策略
 * 先分成一系列小问题，再递归求解。
 */
public class MergeSort {
    public static void main(String[] args) {
        int [] arr={2,34,5,6,78,5,9};
        int temp[]=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));

    }
    //分+合的方法
    public static  void mergeSort(int [] arr,int left,int right,int [] temp){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }
    //合并的方法
    public static void merge(int [] arr ,int left,int mid ,int right,int[] temp){
        int i=left;  //左边有序序列的初始索引
        int j=mid+1;    //右边有序序列的初始索引
        int t=0;        ///指向temp的当前索引

        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                t++;
                i++;
            }else{
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        //将剩余部分填充到temp数组
        while (i<=mid){
            temp[t]=arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t]=arr[j];
            t++;
            j++;
        }
        //temp数组拷贝回去
        t=0;
        int temppLeft=left;
        while ( temppLeft <= right){
            arr[temppLeft]=temp[t];
            t++;
            temppLeft++;
        }
    }
}
