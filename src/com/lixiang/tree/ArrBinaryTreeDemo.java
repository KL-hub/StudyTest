package com.lixiang.tree;

/**
 * 顺序存储二叉树遍历
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {

    }
}
class  ArrBinaryTree{
    private  int [] arr;
    public  ArrBinaryTree(int [] arr){
        this.arr=arr;
    }
    //编写一个方法，完成顺序存储二叉树的前序遍历
    /**
     *
     * @param index  数组的下标
     */
    public  void preOrder(int index){
        if (arr == null || arr.length==0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前的元素
        System.out.println(arr[index]);
        //向左递归遍历
        if (index*2+1<arr.length){
            preOrder(index*2+1);
        }
        if (index*2+2<arr.length){
            preOrder(index*2+2);
        }

    }
}