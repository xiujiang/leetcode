package com.sf.code.producerAndConsumer;

import java.util.concurrent.*;

public class producerAndConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        int numProducers = 4;
        int numConsumers = 3;

        BlockingQueue<Object> myQueue = new LinkedBlockingQueue<Object>(5);

        for(int i = 0; i < numProducers; i++){
            new Thread(new Producer(myQueue)).start();
        }

        for(int i = 0; i < numConsumers; i++){
            new Thread(new Consumer(myQueue)).start();
        }
        Thread.sleep(100);
    }
}
