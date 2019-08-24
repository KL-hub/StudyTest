package com.lixiang.hash;

import java.util.HashMap;

public class HashTabDemo {
    public static void main(String[] args) {

    }
}

class  Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class HashTab{
    private  EmpLinkedList []empLinkedArray;
    private int size;
    //构造器
    public HashTab(int size){
        empLinkedArray=new EmpLinkedList[size];
    }
    public  void add(Emp emp){
        int emLinkedListNO=hashFun(emp.id);
        empLinkedArray[emLinkedListNO].add(emp);
    }
    //遍历
    public void list(){
        for (int i = 0; i < size ; i++) {
            empLinkedArray[i].list();
        }
    }
    //编写一个散列函数
    public  int hashFun(int id){
        return id%size;
    }

}
//创建EmpLinkedList，表示链表
class EmpLinkedList{
    private Emp head;
    //1、当添加雇员时，id是自增的。添加到最后
    public  void add(Emp emp){
        if(head==null){
            head=emp;
        }
        Emp  curEmp=head;
        while (true){
            if (curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        curEmp.next=emp;
    }

    public  void list(){
        if(head==null){
            System.out.println("链表为空");
            return;
        }
        Emp curEmp=head;
        while (true){
            System.out.println("ID="+curEmp.id);
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
    }

}