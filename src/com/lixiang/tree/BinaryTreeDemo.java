package com.lixiang.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建一个二叉树
        BinaryTree binaryTree=new BinaryTree();
        //创建需要的节点
        HeroNode root=new HeroNode(1,"宋江");
        HeroNode node2=new HeroNode(2,"吴用");
        HeroNode node3=new HeroNode(3,"卢俊义");
        HeroNode node4=new HeroNode(4,"林冲");
        HeroNode node5=new HeroNode(5,"关胜");
        root.setLeft(node2);
        root.setRights(node3);
        node3.setRights(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //  先序遍历
        System.out.println("二叉树的前序遍历");
        binaryTree.preOrder();

        //中序遍历
        System.out.println("二叉树的中序遍历");
        binaryTree.infixOrder();

        //后序遍历
        System.out.println("二叉树的后序遍历");
        binaryTree.postOrder();

        //前序查找
        System.out.println("前序遍历方式-----");
        HeroNode heroNode=binaryTree.preOderSearch(5);
        if(heroNode != null){
            System.out.println("找到了，信息为  no="+heroNode.getNo()+"      name="+heroNode.getName());
        }else{
            System.out.println("没有找到------");
        }

    }
}
//定义一个BinaryTree   二叉树
class  BinaryTree{
    private  HeroNode root;
    public  void setRoot(HeroNode root){
        this.root=root;
    }
    //删除节点
    public  void delNode(int no){
        if(root != null){
            //如果只有一个节点，判断root是不是要删除的节点
            if(root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }
    }
    //前序遍历
    public  void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public  void  infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //前序查找
    public  HeroNode preOderSearch(int no){
        if(root != null){
            return  root.preOrderSearch(no);
        }else{
            return  null;
        }
    }
    //中序查找
    public HeroNode infixOrderSearch(int no){
        if(root != null){
            return  root.infixOrderSearch(no);
        }else{
            return  null;
        }
    }
    //后序遍历
    public  HeroNode postOrderSearch(int no){
        if(root != null){
            return  root.postOrderSearch(no);
        }else{
            return  null;
        }
    }
}
class HeroNode{
    private int no;
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRights() {
        return rights;
    }

    public void setRights(HeroNode rights) {
        this.rights = rights;
    }

    private HeroNode left;
    private HeroNode rights;

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public  HeroNode(int no, String name){
        super();
        this.no=no;
        this.name=name;
    }
    public  void delNode(int no){
        if(this.left != null && this.left.no==no){
            this.left=null;
            return;
        }
        if(this.rights != null && this.rights.no==no){
            this.rights=null;
            return;
        }
        if(this.left!= null){
            this.left.delNode(no);
        }
        if(this.rights!= null){
            this.rights.delNode(no);
        }
    }

    //编写前序遍历
    public  void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.rights!=null){
            this.rights.preOrder();
        }
    }
    //中序遍历
    public  void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.rights!=null){
            this.rights.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.rights !=null){
            this.rights.postOrder();
        }
        System.out.println(this);
    }

/**
 * 使用前序的方式来查询指定的节点
 *  前序查找思路
 *      1、先判断当前节点的no是否等于要查找的
 *      2、如果是相等，则返回当前节点
 *      3、如果不等，则判断当前的左节点是否为空，如果不为空，则递归前序查找
 *      4、如果左递归前序，找到节点，则返回。否则继续判断，当前节点的右子节点是否为空，如果不为空向右递归前序查找
 **/
    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序遍历=========");
        //比较当前节点是不是
        if(this.no==no){
            return this;
        }
        //1、判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //2、如果左递归前序查找，找到节点，则返回
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.preOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        //1、左递归前序查找，找到节点，则返回，否则继续判断
        //2、当前的节点的右子节点是否为空，如果不为空，则继续向右递归前序查找
        if(this.rights !=null){
            resNode=this.rights.preOrderSearch(no);
        }
        if(resNode !=null){
            return  resNode;
        }
        return null;
    }
//中序查找
    public  HeroNode infixOrderSearch(int no){
        //判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode=null;
        if(this.left !=null){
            resNode= this.left.infixOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        //父节点
        if(this.getNo()==no){
            return this;
        }
        if(this.rights !=null){
            resNode= this.rights.infixOrderSearch(no);
        }
        return resNode;
    }
    //后序查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode=null;
        if (this.left !=null){
            resNode=this.left.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.rights!=null){
            resNode=this.rights.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.getNo()==no){
            return this;
        }
        return null;
    }
}