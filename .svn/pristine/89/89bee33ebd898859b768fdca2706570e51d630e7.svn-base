package cn.spacewalker.tsp.bg.pojo.rabbitmq;

import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960MsgDto;
import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960Msg2Bytes;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/9 16:37
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class Gbt32960QueueConsumer extends EndPoint implements Runnable, Consumer{

    private static Map<String, ChannelHandlerContext> ctxMap = new ConcurrentHashMap<>();

    public static Map<String, ChannelHandlerContext> getCtxMap() {
        return ctxMap;
    }

    public Gbt32960QueueConsumer(String endPointName) throws Exception {
        super(endPointName);
    }

    public void run() {
        try {
            //start consuming messages. Auto acknowledge messages.
            channel.basicConsume(endPointName, true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when consumer is registered.
     */
    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer "+consumerTag +" registered");
    }

    /**
     * Called when new message is available.
     */
    public void handleDelivery(String consumerTag, Envelope env,
                               BasicProperties props, byte[] body) throws IOException {
        String json = SerializationUtils.deserialize(body);
        Gbt32960MsgDto dto = JSON.parseObject(json, Gbt32960MsgDto.class);
        byte[] bytes = Gbt32960Msg2Bytes.msg2Bytes(dto);

        System.err.println(String.format("commandSymbol is [%s], bytes length is [%s]", dto.getCommandSymbol(), bytes.length));


        Map<String, ChannelHandlerContext> ctxMap = getCtxMap();
        if(ctxMap.size() < 1){
            long deliveryTag = env.getDeliveryTag();
            channel.basicAck(deliveryTag, false);
        } else{
        }
    }

    public void handleCancel(String consumerTag) {}
    public void handleCancelOk(String consumerTag) {}
    public void handleRecoverOk(String consumerTag) {}
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {}

    public static void main(String[] args) throws Exception {
        Gbt32960QueueConsumer queueConsumer = new Gbt32960QueueConsumer("queue");
        Thread thread = new Thread(queueConsumer);
        thread.start();
    }
}
