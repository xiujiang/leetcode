package com.sf.code.producerAndConsumer;

import java.util.concurrent.BlockingQueue;

//生产者
public class Producer implements Runnable{

    protected BlockingQueue<Object> queue;

    Producer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while(true){
                Object justProduced = getResource();
                queue.put(justProduced);
                System.out.println("生产者队列大小"+queue.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    Object getResource(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("xx");
        }
        return new Object();
    }
}
