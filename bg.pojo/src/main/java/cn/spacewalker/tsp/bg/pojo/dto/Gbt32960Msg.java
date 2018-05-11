package cn.spacewalker.tsp.bg.pojo.dto;

import cn.spacewalker.tsp.common.base.BaseDto;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/3 11:40
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class Gbt32960Msg extends BaseDto {

    private String startSymbol = "##";

    private int commandSymbol;

    private int responseSymbol;

    private String vin;

    private int encryptWay;

    private int contentLength;

    private byte[] content;

    private int checkPoint;

    private byte[] rawData;

    private String formNum;

    public Gbt32960Msg(){}

    public Gbt32960Msg(String startSymbol, int commandSymbol, int responseSymbol, String vin, int encryptWay, int contentLength, byte[] content, int checkPoint, byte[] rawData) {
        this.startSymbol = startSymbol;
        this.commandSymbol = commandSymbol;
        this.responseSymbol = responseSymbol;
        this.vin = vin;
        this.encryptWay = encryptWay;
        this.contentLength = contentLength;
        this.content = content;
        this.checkPoint = checkPoint;
        this.rawData = rawData;
    }

    public String getFormNum() {
        return formNum;
    }

    public void setFormNum(String formNum) {
        this.formNum = formNum;
    }

    public String getStartSymbol() {
        return startSymbol;
    }

    public void setStartSymbol(String startSymbol) {
        this.startSymbol = startSymbol;
    }

    public int getCommandSymbol() {
        return commandSymbol;
    }

    public void setCommandSymbol(int commandSymbol) {
        this.commandSymbol = commandSymbol;
    }

    public int getResponseSymbol() {
        return responseSymbol;
    }

    public void setResponseSymbol(int responseSymbol) {
        this.responseSymbol = responseSymbol;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getEncryptWay() {
        return encryptWay;
    }

    public void setEncryptWay(int encryptWay) {
        this.encryptWay = encryptWay;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(int checkPoint) {
        this.checkPoint = checkPoint;
    }

    public byte[] getRawData() {
        return rawData;
    }

    public void setRawData(byte[] rawData) {
        this.rawData = rawData;
    }

}
