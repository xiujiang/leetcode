package com.sf.code.producerAndConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 */
public class Consumer implements Runnable{

    protected BlockingQueue<Object> queue;

    Consumer(BlockingQueue<Object> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while(true){
                Object obj = queue.take();
                System.out.println("消费者资源大小"+queue.size());
                take(obj);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void take(Object obj) {
        try {
            Thread.sleep(100); // simulate time passing
        } catch (InterruptedException ex) {
            System.out.println("消费者 读 中断");
        }
        System.out.println("消费对象 " + obj);
    }
}
