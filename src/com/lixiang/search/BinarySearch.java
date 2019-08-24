package com.lixiang.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 前提：数组是有序的
 * 1、确定该数组中间的下标mid
 * 2、findVal与arr[mid]，比较  findVal与arr大的话，则向后查找。否则向前查找
 * 3、findVal与arr[mid]相等，则说明找到，就返回。
 *
 * 退出条件
 * //1、找到就结束递归
 * 2递归完整个数组，仍然没有找到findval,  当left>right就需要退出。
 */
public class BinarySearch {
    public static void main(String[] args) {
      int [] arr={1,234,567,890,890,890,890,10000};    //数组有序
      List<Integer> list=binarySearch2(arr,0,arr.length-1,890);
      System.out.println("______"+list.size());
    }
    public  static  int binarySearch(int [] arr,int left,int right,int findVal){
        int mid=(left+right)/2;
        if(left>right){
            return -1;
        }
        if(arr[mid]>findVal){
            return  binarySearch(arr,mid+1,right,findVal);
        }else if(arr[mid]<findVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else {
            return  mid;
        }
    }
    //如果有重复元素，则返回一个数组
    public  static List<Integer> binarySearch2(int [] arr, int left, int right, int findVal){
        int mid=(left+right)/2;
        if(left>right){
            return new ArrayList<Integer>();
        }
        if(arr[mid]>findVal){
            return  binarySearch2(arr,left,mid-1,findVal);
        }else if(arr[mid]<findVal){
            return binarySearch2(arr,mid+1,right,findVal);
        }else {
            ArrayList list=new ArrayList<Integer>();
           //向左右扫描
            int temp=mid-1;
            while ( true ){
                if( temp <0 ||  arr[temp]!= findVal){
                    break;
                }
                list.add(temp);
                temp--;
            }
            temp=mid+1;
            while ( true ){
                if( temp >arr.length-1 ||  arr[temp]!= findVal){
                    break;
                }
                list.add(temp);
                temp++;
            }
            list.add(mid);
            return list;

        }
    }
}
