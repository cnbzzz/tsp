package cn.spacewalker.tsp.bg.pojo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/9 16:36
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public abstract class EndPoint{

    protected Channel channel;
    protected Connection connection;
    protected String endPointName;

    public EndPoint(String endpointName) throws Exception {
        this.endPointName = endpointName;

        //Create a connection factory
        ConnectionFactory factory = new ConnectionFactory();

        //hostname of your rabbitmq server
        factory.setHost("112.74.180.11");

        //getting a connection
        connection = factory.newConnection();

        //creating a channel
        channel = connection.createChannel();

        //declaring a queue for this channel. If queue does not exist,
        //it will be created on the server.
        channel.queueDeclare(endpointName, false, false, false, null);
    }


    /**
     * 关闭channel和connection。并非必须，因为隐含是自动调用的。
     * @throws IOException
     */
    public void close() throws Exception{
        this.channel.close();
        this.connection.close();
    }
}