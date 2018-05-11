package cn.spacewalker.tsp.bg.receiver.server;

import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960MsgUtils;
import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960WriteByteBuf;
import cn.spacewalker.tsp.bg.receiver.service.IGbt32960ServerService;
import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;
import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960MsgDto;
import cn.spacewalker.tsp.bg.pojo.rabbitmq.Producer;
import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.*;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/10 15:03
 * Copyright (c) 2017 www.space-walker.cn
 */
public class Gbt32960ServerHandler extends ChannelHandlerAdapter {

    @Resource
    private IGbt32960ServerService service;

    private Logger log = LogManager.getLogger(this.getClass().getName());

    private volatile long count = 0;

//    private final static ExecutorService workerThreadService = newBlockingExecutorsUseCallerRun(Runtime.getRuntime().availableProcessors() * 2);
    private final static ExecutorService workerThreadService = Executors.newFixedThreadPool(60);

    public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception {
        log.error(var2.getMessage(), var2);
        super.exceptionCaught(var1, var2);
        var2.printStackTrace();
        var1.close();
    }

    public void channelActive(ChannelHandlerContext var1) throws Exception {
        log.info(String.format("[%s] channelActive...", var1.name()));
    }

    public void channelInactive(ChannelHandlerContext var1) throws Exception {
        log.info(String.format("[%s] channelInactive...", var1.name()));
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof Gbt32960Msg) {
            Gbt32960Msg gbt32960Msg = (Gbt32960Msg) msg;
            log.info(String.format("receiver data is [%s]", JSON.toJSONString(gbt32960Msg)));
//            doTask(ctx, gbt32960Msg);

            workerThreadService.execute(new Runnable() {
                @Override
                public void run() {
                    doTask(ctx, gbt32960Msg);
                }
            });
            ReferenceCountUtil.release(gbt32960Msg);
        }

    }


    private void doTask(ChannelHandlerContext ctx, Gbt32960Msg msg) {
        Gbt32960Msg gbt32960Msg = msg;
        try {
            Gbt32960MsgDto dto = service.execute(gbt32960Msg);

            System.err.println(String.format("count is %s, data is %s", count++, JSON.toJSONString(dto)));

//                Producer producer = new Producer("queue");
//                String jsonString = JSON.toJSONString(dto);
//                producer.sendMessage(jsonString);
            respClient(ctx, gbt32960Msg, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

    private void respClient(ChannelHandlerContext ctx, Gbt32960Msg gbt32960Msg, Gbt32960MsgDto dto) {
        int respSymbol = gbt32960Msg.getResponseSymbol();
        if (respSymbol == 254) {
            byte[] contentBytes = gbt32960Msg.getContent();
            byte[] newContentBytes = new byte[6];
            System.arraycopy(contentBytes, 0, newContentBytes, 0, 6);

            Gbt32960WriteByteBuf buf = new Gbt32960WriteByteBuf();
            buf.writeBytes(gbt32960Msg.getStartSymbol().getBytes());
            buf.writeByte((byte) gbt32960Msg.getCommandSymbol());
            int newRespSymbol = 1;
            if (dto == null) {
                newRespSymbol = 2;
            }
            buf.writeByte((byte) newRespSymbol);
            buf.writeBytes(gbt32960Msg.getVin().getBytes());
            buf.writeByte((byte) gbt32960Msg.getEncryptWay());

            buf.writeShort((short) newContentBytes.length);
            buf.writeBytes(newContentBytes);
            byte xorByte = Gbt32960MsgUtils.xorCheckPoint(buf.getBytes());
            buf.writeByte(xorByte);
            //                buf.writeByte(gbt32960Msg.getCheckPoint());
            ByteBuf resp = Unpooled.copiedBuffer(buf.getBytes());
            ctx.writeAndFlush(resp);
        }
    }

    public static ExecutorService newBlockingExecutorsUseCallerRun(int size) {
        return new ThreadPoolExecutor(size, size, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        try {
                            executor.getQueue().put(r);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }

    public static void main(String[] args) {
        byte[] contentBytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        byte[] newContentBytes = new byte[6];
        System.arraycopy(contentBytes, 0, newContentBytes, 0, 6);
        System.err.println(Arrays.toString(newContentBytes));
    }
}
