package com.example.demo;

/**
 * @Description TODO
 * @Author wumengxuan
 * @Date 2019/2/21 15:54
 */

public class TestProducer {
        public static void main(String[] args){
            Producer Producer = new Producer();
            Producer.init();
            TestProducer testMq = new TestProducer();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Thread 1
            new Thread(testMq.new ProductorMq(Producer)).start();
            //Thread 2
            new Thread(testMq.new ProductorMq(Producer)).start();
            //Thread 3
            new Thread(testMq.new ProductorMq(Producer)).start();
            //Thread 4
            new Thread(testMq.new ProductorMq(Producer)).start();
            //Thread 5
            new Thread(testMq.new ProductorMq(Producer)).start();
        }

        private class ProductorMq implements Runnable{
            Producer Producer;
            public ProductorMq(Producer Producer){
                this.Producer = Producer;
            }

            @Override
            public void run() {
                while(true){
                    try {
                        Producer.sendMessage("Jaycekon-MQ");
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}

