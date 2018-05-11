package cn.spacewalker.tsp.bg.pojo.utils;

import java.io.UnsupportedEncodingException;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/19 17:31
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class Gbt32960ReadByteBuf {

    private byte[] bytes;

    private int offset = 0;

    public Gbt32960ReadByteBuf(byte[] bytes){
        this.bytes = bytes;
    }

    public byte readByte(){
        return bytes[offset++];
    }

    public int readByte2Int(){
        return bytes[offset++] & 0xFF;
    }

    public byte[] readBytes(int length){
        byte[] b = new byte[length];
        System.arraycopy(bytes, this.offset, b, 0, length);
        this.offset += length;
        return b;
    }

    public short readShort(){
        byte[] b = readBytes(2);
        return (short) (((b[0] & 0xff) << 8) | (b[1] & 0xff));
    }

    public int readInt(){
        byte[] b = readBytes(4);
        return ((b[0] & 0xff) << 24) | ((b[1] & 0xff) << 16)
                | ((b[2] & 0xff) << 8) | (b[3] & 0xff);
    }

    public long readLong(){
        byte[] b = readBytes(8);
        return ((b[0]&0xff)<<56)|
                ((b[1]&0xff)<<48)|
                ((b[2]&0xff)<<40)|
                ((b[3]&0xff)<<32)|
                ((b[4]&0xff)<<24)|
                ((b[5]&0xff)<<16)|
                ((b[6]&0xff)<<8)|
                (b[7]&0xff);
    }

    public int readWord(){
        return readShort() & 0x0FFFF;
    }

    public long readDword(){
        return readInt() & 0x0FFFFFFFFl;
    }

    public String readString(int length, String charset){
        byte[] b = readBytes(length);
        String str = null;
        try {
            str =  new String(b, charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
        return str;
    }

    public static void main(String[] args) {
        byte[] b = new byte[8];
        b[0] = 0;
        b[1] = 1;
        b[2] = 2;
        b[3] = 3;
        b[4] = 4;
        b[5] = 5;
        b[6] = 6;
        b[7] = 7;

        Gbt32960ReadByteBuf buf = new Gbt32960ReadByteBuf(b);
        System.err.println(buf.readByte());
        System.err.println(buf.readByte());
        System.err.println(buf.readByte());
        System.err.println(buf.readByte());
        byte[] bb = buf.readBytes(2);
        System.err.println(bb[0]);
        System.err.println(bb[1]);

        byte[] bb2 = buf.readBytes(2);
        System.err.println(bb2[0]);
        System.err.println(bb2[1]);
    }

    public boolean isReadLast(){
        return offset == bytes.length;
    }
}
