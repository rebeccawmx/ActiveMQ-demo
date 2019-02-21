package com.example.demo;

/**
 * @Description TODO
 * @Author wumengxuan
 * @Date 2019/2/21 15:13
 */

public class TestConsumer {
    public static void main(String[] args){
        Consumer Consumer = new Consumer();
        Consumer.init();
        TestConsumer testConsumer = new TestConsumer();
        new Thread(testConsumer.new ConsumerMq(Consumer)).start();
        new Thread(testConsumer.new ConsumerMq(Consumer)).start();
        new Thread(testConsumer.new ConsumerMq(Consumer)).start();
        new Thread(testConsumer.new ConsumerMq(Consumer)).start();
    }

    private class ConsumerMq implements Runnable{
        Consumer Consumer;
        public ConsumerMq(Consumer Consumer){
            this.Consumer = Consumer;
        }

        @Override
        public void run() {
            while(true){
                try {
                    Consumer.getMessage("Jaycekon-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
