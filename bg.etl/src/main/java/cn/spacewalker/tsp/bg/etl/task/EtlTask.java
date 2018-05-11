package cn.spacewalker.tsp.bg.etl.task;

import cn.spacewalker.tsp.bg.etl.service.IEtlService;
import cn.spacewalker.tsp.common.util.CommUtils;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/17 22:43
 * Copyright (c) 2017 www.space-walker.cn
 */
public class EtlTask {

    @Resource
    private IEtlService etlService;

    public void task1(){
        System.err.println("task1执行" + CommUtils.timestamp2str(new Date()));
        try {
            etlService.etlVehinfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void task2(){
        System.err.println("task2执行" + CommUtils.timestamp2str(new Date()));
        try {
            etlService.etlVehsum();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("目前时间：" + calendar.getTime());
        System.out.println("Calendar时区：：" + calendar.getTimeZone().getID());
        System.out.println("user.timezone：" + System.getProperty("user.timezone"));
        System.out.println("user.country：" + System.getProperty("user.country"));
        System.out.println("默认时区：" + TimeZone.getDefault().getID());
    }
}
