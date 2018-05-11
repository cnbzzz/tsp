package cn.spacewalker.tsp.bg.pojo.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/19 18:58
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class Gbt32960WriteByteBuf {

    private byte[] bytes;

    private int offset = 0;

    public void writeByte(byte b){
        if(bytes == null){
            bytes = new byte[1];
            offset = 0;
            bytes[0] = b;
        } else{
            bytes = ArrayUtils.add(bytes, b);
        }
        offset++;
    }

    public void writeBytes(byte[] b){
        if(bytes == null){
            bytes = b;
        } else{
            bytes = ArrayUtils.addAll(bytes, b);
        }
        offset += b.length;
    }

    public void writeShort(short s){
        byte[] b = ByteUtils.short2Byte(s);
        writeBytes(b);
    }

    public void writeInt(int i){
        byte[] b = ByteUtils.int2Byte(i);
        writeBytes(b);
    }

    public void writeLong(long l){
        byte[] b = ByteUtils.long2Byte(l);
        writeBytes(b);
    }

    public void writeWord(int i){
        byte[] b = ByteUtils.short2Byte((short) i);
        writeBytes(b);
    }

    public void writeDword(long l){
        byte[] b = ByteUtils.int2Byte((int) l);
        writeBytes(b);
    }

    public void writeString(String str, String charsetName){
        if(StringUtils.isBlank(charsetName)){
            charsetName = "UTF-8";
        }
        try {
            byte[] b = str.getBytes(charsetName);
            writeBytes(b);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public static void main(String[] args) {
        Gbt32960WriteByteBuf writeByteBuf = new Gbt32960WriteByteBuf();
        writeByteBuf.writeByte((byte) 0x01);
        byte[] b = new byte[2];
        b[0] = 0x02;
        b[1] = 0x03;
        writeByteBuf.writeBytes(b);
        writeByteBuf.writeShort((short) 12);
        writeByteBuf.writeInt(65530);
        writeByteBuf.writeLong(1111111111111111111l);
        writeByteBuf.writeWord(65530);
        writeByteBuf.writeDword(Long.MAX_VALUE);
        byte[] bytes = writeByteBuf.getBytes();
        System.err.println(bytes.length);

        Gbt32960ReadByteBuf readByteBuf = new Gbt32960ReadByteBuf(bytes);
        System.err.println(readByteBuf.readByte());
        System.err.println(readByteBuf.readByte());
        System.err.println(readByteBuf.readByte());
        System.err.println(readByteBuf.readShort());
        System.err.println(readByteBuf.readInt());
        System.err.println(readByteBuf.readLong());
        System.err.println(readByteBuf.readWord());
        System.err.println(readByteBuf.readDword());
    }
}
