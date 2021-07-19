package com.sf.code.producerAndConsumer;

public class Print100Test {

    public static class test1 implements Runnable{
        private static Object lock = new Object();
        private static int count = 0;
        int no ;
        public test1(int no){
            this.no = no;
        }
        @Override
        public void run() {
            while(true){
                synchronized (lock){
                    if(count > 100){
                        break;
                    }
                    if(count % 3 == no){
                        System.out.println(this.no + " ---- > " + count);
                        count++;
                    }else{
                        try {
                            lock.wait();
                            System.out.println(this.no+"释放");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new test1(0));
        Thread t2 = new Thread(new test1(1));
        Thread t3 = new Thread(new test1(2));
        t1.start();
        t2.start();
        t3.start();
    }
}
