package com.lixiang.Sort;

import java.util.Arrays;

/**
 * 基数排序（稳定的）
 * 1、将各个元素的个位数取出，然后看这个数应该放在哪个对应得桶
 * 2、按照这个桶的顺序（一维数组的下标依次取出，放入原来数组）
 * 后依次取十位、百位等。
 *
 * 1、是对传统桶排序的扩展，速度很快
 * 2、用空间换时间的经典算法，占用内存大，当对海量数据进行排序时，容易造成OutOfMemoryError
 * 3、基数排序是稳定的。
 * 负数不支持。
 */

public class RadixSort {
    public static void main(String[] args) {
        //定义一个二维数组，表示是个桶，每个桶就是一个一维数组
        int [] arr={34,5,67,89,1,0,9,2};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static  void radixSort(int [] arr){
        //得到数组中最大的数的位数
        int max=arr[0];
        for (int i = 0; i <arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int maxLength=(max+"").length();
        //定义一个桶，表示十个桶，每个桶就是一个一维数组
        int [][] bucket=new int[10][arr.length];
        //记录每个桶的数量
        int [] bucketElementCounts=new int[10];
        for (int k = 0,n=1; k < maxLength; k++,n*=10) {  //针对每个元素的位数进行排序处理
        for (int i = 0;i < arr.length; i++) {
            int deightElement=arr[i]/n %10;
            bucket[deightElement][bucketElementCounts[deightElement]]=arr[i];
            bucketElementCounts[deightElement]++;
        }
        //遍历每个桶，并将桶中的数据放入到原数组中
        int index=0;
        for (int i = 0; i <bucketElementCounts.length ; i++) {
            if(bucketElementCounts[i]!=0){
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++]=bucket[i][j];
                  //  index++;
                }
                bucketElementCounts[i]=0;
            }

        }
    }
    }
}
