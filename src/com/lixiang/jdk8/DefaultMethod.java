package com.lixiang.jdk8;

/**
 * @Description //jdk8接口中默人实现
 * @Author 李项
 * @Date 2019/11/23
 * @Version 1.0
 */
public class DefaultMethod {
    public static void main(String[] args) {
        Vehicle vehicle = new Cars();
        vehicle.print();
    }

    interface  Vehicle{
        default void print(){
            System.out.println("我是一辆汽车");
        }
        static void blowHorn(){
            System.out.println("按喇叭!!!");
        }
    }

    interface FourWheeler {
        default void print(){
            System.out.println("我是一辆四轮车!");
        }
    }


}
class  Cars implements DefaultMethod.Vehicle, DefaultMethod.FourWheeler {

    @Override
    public void print() {
        DefaultMethod.Vehicle.super.print();
        DefaultMethod.FourWheeler.super.print();
        DefaultMethod.Vehicle.blowHorn();
        System.out.println("我是一辆汽车!");
    }
}
