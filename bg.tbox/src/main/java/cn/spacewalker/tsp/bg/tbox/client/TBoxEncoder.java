package cn.spacewalker.tsp.bg.tbox.client;

import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/11 11:18
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class TBoxEncoder extends MessageToByteEncoder<Gbt32960Msg> {

    private Logger log = LogManager.getLogger(this.getClass().getName());

    private static int count = 0;
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Gbt32960Msg gbt32960Msg, ByteBuf byteBuf) throws Exception {
        byteBuf.writeBytes(gbt32960Msg.getStartSymbol().getBytes());
        byteBuf.writeByte(gbt32960Msg.getCommandSymbol());
        byteBuf.writeByte(gbt32960Msg.getResponseSymbol());
        byteBuf.writeBytes(gbt32960Msg.getVin().getBytes());
        byteBuf.writeByte(gbt32960Msg.getEncryptWay());

        byte[] contentBytes = gbt32960Msg.getContent();
        byteBuf.writeShort(contentBytes.length);
        byteBuf.writeBytes(contentBytes);
        byteBuf.writeByte(gbt32960Msg.getCheckPoint());

        log.info("{}写数据channelHandlerContext {}, gbt32960Msg {}, byteBuf.writeableBytes {}", count++, channelHandlerContext, gbt32960Msg, byteBuf.writableBytes());
    }
}
