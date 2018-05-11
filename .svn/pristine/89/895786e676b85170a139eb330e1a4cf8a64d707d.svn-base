package cn.spacewalker.tsp.common.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/15 15:32
 * Copyright (c) 2017 www.space-walker.cn
 */
public class BaseServiceImpl {

    protected Logger log = LogManager.getLogger(this.getClass().getName());


    protected BaseResp succ(){
        return BaseResp.succResp();
    }

    protected BaseResp fail(){
        return BaseResp.failResp();
    }

    protected BaseResp succ(String msg){
        return BaseResp.succResp(msg);
    }

    protected BaseResp fail(String msg){
        return BaseResp.failResp(msg);
    }

}
