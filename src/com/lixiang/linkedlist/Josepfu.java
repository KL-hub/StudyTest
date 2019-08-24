package com.lixiang.linkedlist;

/**
 * 约瑟夫问题
 * 解决丢手帕问题
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        CircleSingleLinkedList.countBoy(1,2,5);
    }
}
//创建一个环形的单向链表
class  CircleSingleLinkedList{
    private static Boy first=new Boy(-1);
    public void  addBoy(int nums){
        if(nums <1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy=null;  //辅助指针
        for(int i=1; i<=nums;i++){
            Boy boy=new Boy(i);     //根据编号，创建节点
            if(i==1){   //首节点指向自身
//                boy.setNext(first);
//                curBoy=boy;
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }
    ///遍历当前的环形链表
    public  void showBoy(){
        //判断链表是否为空
        if(first  == null){
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy=first;
        while(true){
            System.out.println("小孩当前的编号"+curBoy.getNo());
            if (curBoy.getNext() ==first){
                break;
            }
            curBoy=curBoy.getNext();
        }
    }

    //根据用户的输入，计算出小孩出圈的顺序

    /**
     *
     * @param startNo   表示从第一个小孩开始数数
     * @param countNum   表示数几下
     * @param nums        表示最初有几个小孩在圈中
     */
    public static  void countBoy(int startNo,int countNum,int nums) {
        if(first == null || startNo <1  || startNo>nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        Boy helper=first;   ///辅助指针，事先指向环形链表的最后这个节点
        while (true){
            if( helper.getNext() == first){
                break;
            }
            helper=helper.getNext();
        }
        ///小孩报数前，让first和helper移动k-1次
        for(int j=0;j<startNo;j++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //报数时，让first和helper指针同时移动m-1次，然后出圈
        while (true){
            if(helper ==first){  //圈中只有一个元素
                break;
            }
            for (int j=0;j<countNum-1;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println("小孩出圈"+first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的编号"+first.getNo());
    }
}


//创建一个Boy类，表示一个节点
class Boy{
    private   int no;
    private  Boy next;

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no){
        this.no=no;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}