package com.lixiang.stack;

import com.sun.org.apache.xml.internal.utils.SuballocatedByteVector;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 后缀表达式的计算
 *
 */
public class PolandNotation {
    public static void main(String[] args) {
        String expression = "300 4 + 5 * 6 -";    //(3+4)*5-6
        List<String> list = new ArrayList<>();
        String[] strings = expression.split(" ");
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }
        Stack<String> stack = new Stack<>();
        for (String s : list) {
           // System.out.println(s);
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")) {
                    res = num1 + num2;
                } else if (s.equals("-")) {
                    res = num1 - num2;
                } else if (s.equals("*")) {
                    res = num1 * num2;
                } else if (s.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);
            }
        }
        System.out.println("--"+stack.pop());
    }

    /**
     * 中缀表达式转后缀表达式
     *     1）初始化两个栈：运算符栈s1和存储中间结果的栈s2
     *     2)从左至右扫描中缀表达式
     *     3)遇到操作数时，将其压入s2
     *     4）遇到操作符时，比较运算符与栈顶元素的优先级
     *     1、如果s1为空或者栈顶运算符为左括号（，则直接将次运算符入栈。
     *     2、否则，若优先级比栈顶运算符的高，也将运算符压入s1
     *     3、否则，将s1栈顶的运算符弹出并压入到s2中，再次转到4.1与s1中新的运算符相比较。
     *     5）遇到括号时：
     *     1、如果是左括号（，则直接压入s1
     *     2、如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时一对括号丢弃。
     *     6）重复步骤2-5，直到表达式的最右边。
     *     7）将s1中剩余的运算符依次弹出并压入s2
     *     8)依次弹出s2中的元素并输出，结果的逆序即为中缀表达式的后缀表达式。
     *
     */
    @Test
    public void test1(){
        String expression="1+((2+3)*4)-5";
        List<String> list=toINfixExpressionList(expression);
        System.out.println("中缀表达式"+list);
        List <String>list2=parseSuffixExpression(list);
        System.out.println("中缀表达式"+list);
        System.out.println("后缀表达式"+list2);

    }
    //将中缀表达式转出对应得List
    public  static  List<String> toINfixExpressionList(String s){
        List<String> list=new ArrayList<>();
        int  i=0;
        String str=new String();
        char c;
        do {
            if((c=s.charAt(i))<48 || (c=s.charAt(i))>57){
                list.add(""+c);
                i++;
            }else {    //考虑多位数
                str="";
                while (i<s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                list.add(str);
            }
        }while (i<s.length());
        return list;
    }
    //将中缀表达式List转换为后缀表达式list
    public List<String> parseSuffixExpression(List<String> list){
        //定义两个栈
        Stack<String> s1=new Stack<>();     //运算符栈
        List<String> s2=new ArrayList<String>();  //模拟栈，没有出栈的操作
        //遍历list
        for (String s : list) {
            if(s.matches("\\d+")){
                s2.add(s);
            }else if(s.equals("(")){
                s1.push(s);
            }else  if(s.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();           //消除小括号
            }else{
                //当s的优先级小于或者等于栈顶的运算符
                //
                while (s1.size() !=0 && Operstion.getValue(s1.peek()) >= Operstion.getValue(s)){
                    s2.add(s1.pop());
                }
                s1.push(s);
            }
        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }

        return s2;
    }

}
//比较优先级
class  Operstion{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    public  static  int getValue(String s){
        int result =0;
        switch (s){
            case "+":{
                result=ADD;
                break;
            } case "-":{
                result= SUB;
                break;
            } case "*":{
                result=MUL;
                break;
            } case "/":{
                result=DIV;
                break;
            }default:
                System.out.println("不存在运算符");
                break;

        }
        return  result;
    }
}