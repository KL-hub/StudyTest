package com.lixiang.tree;

/**
 * @Description //二叉排序树
 * @Author 李项
 * @Date 2020/1/4
 * @Version 1.0
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int []arr={1,3,5,32,1,5,2,5};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
      binarySortTree.infixOrder();
    }

}
//创建二叉排序树
class BinarySortTree{
    private Node root;
    public void add(Node node){
        if(root == null){
            root=node;
        }else{
            root.add(node);
        }
    }
    public void infixOrder(){
        if ( root != null) {
            root.infixorder();
        }else{
            System.out.println("二叉排序树为空");
        }
    }
}
class  Node{
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }
    //查找要删除的结点
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            } else {
                return this.left.search(value);
            }
        } else {
            if (this.right == null) {
                return null;
            } else {
                return this.right.search(value);
            }
        }
    }
    //查找要删除结点的父节点
    public Node searchParent(int value){
        if((this.left!= null && this.left.value==value)||
                (this.right!= null && this.right.value==value)){
            return this;
        }else{
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if(value >= this.value && this.right != null){
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点的方法
    //递归地添加节点，注意满足二叉排序树的要求
    public void add(Node node){
        if(node == null){
            return;
        }
        if(node.value < this.value){
            if(this.left == null){
                this.left =node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }
    //中序遍历
    public void infixorder(){
        if(this.left != null){
            this.left.infixorder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixorder();
        }
    }
}