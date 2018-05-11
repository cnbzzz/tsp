package cn.spacewalker.tsp.common.base;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/11 15:43
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class BaseResp<T> implements Serializable {

    public final static String SUCC = "1";

    public final static String FAIL = "0";

    public final static String FAIL_MSG = "fail";

    public final static String SUCC_MSG = "succ";

    protected String retCode;

    protected String retMsg;

    protected T data;


    public static BaseResp succResp(){
        return new BaseResp(SUCC, SUCC_MSG);
    }

    public static BaseResp succResp(String msg){
        return new BaseResp(SUCC, msg);
    }

    public static BaseResp failResp(){
        return new BaseResp(FAIL, FAIL_MSG);
    }

    public static BaseResp failResp(String msg){
        return new BaseResp(FAIL, msg);
    }

    public BaseResp() {}

    public BaseResp(String retCode) {
        this.retCode = retCode;
    }

    public BaseResp(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public BaseResp(String retCode, String retMsg, T data) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
