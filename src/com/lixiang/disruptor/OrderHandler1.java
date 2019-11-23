package com.lixiang.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2019/11/23
 * @Version 1.0
 */
public class OrderHandler1  implements EventHandler<Order>, WorkHandler<Order> {
    private String consumerId;
    public OrderHandler1(String consumerId){
        this.consumerId = consumerId;
    }
    @Override
    public void onEvent(Order order, long l, boolean b) throws Exception {
        System.out.println("OrderHandler1 " + this.consumerId + "，消费信息：" + order.getId());
    }

    @Override
    public void onEvent(Order order) throws Exception {
        System.out.println("OrderHandler1 " + this.consumerId + "，消费信息：" + order.getId());
    }
}
