package com.lixiang.linkedlist;

import java.security.PublicKey;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建几个节点
        HeroNode hero1=new HeroNode(1,"hero","1");
        HeroNode hero2=new HeroNode(2,"hero2","1");
        HeroNode hero3=new HeroNode(3,"hero3","1");
        HeroNode hero4=new HeroNode(4,"hero4","1");
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();
    }

}
//定义SigleLinkedList管理我们的英雄
class SingleLinkedList{
    //初始化一个头结点，不存放数据
    private  HeroNode head=new HeroNode(0,"","");
    //添加节点到单向链表
    //不考虑编号顺序时
    // 1找到链表的最后节点
    // 2将最后这个节点的next  指向新的节点
    public  void  add(HeroNode heroNode){
       HeroNode temp=head;
       while (true){
            if (temp.next == null){
                break;
            }
            temp=temp.next;
       }
       temp.next=heroNode;
    }

    //插入到指定位置(有则添加失败)
    public void addByOrder(HeroNode heroNode){
        HeroNode temp=head;
        boolean flag=false; //添加的编号是否存在
        while (true){
            if (temp.next ==null){
                break;
            }else if(temp.next.no >heroNode.no){
                break;
            }else if (temp.next.no==heroNode.no){
                flag=true;
                break;
            }
        }
        if(flag){
            System.out.println("准备插入的编号已经存在了，不能加入"+heroNode.no);
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }
    //显示链表（遍历）
    public void  list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head.next;
        while (true){
            //判断是否是链表最后
            if(temp.next ==null){
                break;
            }
            System.out.println("temp"+temp);
            temp=temp.next;
        }
    }

}
class HeroNode{
    public  int no;
    public  String name;
    public  String nickname;
    public  HeroNode next;
    //构造器
    public  HeroNode(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

