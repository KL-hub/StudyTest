package com.lixiang.disruptor;

import com.lmax.disruptor.RingBuffer;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2019/11/23
 * @Version 1.0
 */
public class Producer {
    private final RingBuffer<Order> ringBuffer;
    public Producer(RingBuffer<Order> ringBuffer){
        this.ringBuffer = ringBuffer;
    }
    public void onData(String data){
        Long sequence =ringBuffer.next();
        Order order=ringBuffer.get(sequence);
        order.setId(data);
        ringBuffer.publish(sequence);
    }
}
