package com.lixiang.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2019/11/23
 * @Version 1.0
 */
public class OrderFactory implements EventFactory<Order> {

    @Override
    public Order newInstance() {
        return new Order();
    }
}
