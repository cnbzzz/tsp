package cn.spacewalker.tsp.bg.pojo.rabbitmq;

import java.util.HashMap;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/9 16:38
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class Main {

    public static void main(String[] args) throws Exception {

        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        Producer producer = new Producer("queue");

        for (int i = 0; i < 100000; i++) {
            HashMap message = new HashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("Message Number "+ i +" sent.");
        }

    }
}
