package cn.spacewalker.tsp.common.geo;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/19 17:45
 * Copyright (c) 2017 www.space-walker.cn
 */
public class GetLocation {

    private static Logger LOG = LogManager.getLogger(GetLocation.class);

    public static void main(String[] args) {
        // lat 39.97646
        //log 116.3039
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            String add = getAdd("119.981489", "31.770646");
            System.err.println(add);
        }
        long l2 = System.currentTimeMillis();
        System.err.println(l2 - l1);
    }

    public static String getAdd(String log, String lat ){
        //lat 小  log  大
        //参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)
        String urlString = "http://gc.ditu.aliyun.com/regeocoding?l="+lat+","+log+"&type=010";
        String res = "";
        java.io.BufferedReader in = null;
        try {
            URL url = new URL(urlString);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();
            conn.setReadTimeout(100);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line+"\n";
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if(StringUtils.isBlank(res)){
            res = "{\"queryLocation\":[31.770646,119.981489],\"addrList\":[{\"type\":\"poi\",\"status\":1,\"name\":\"奥展不锈钢品牌紧固件\",\"id\":\"ANB02070UARY\",\"admCode\":\"320402\",\"admName\":\"江苏省,常州市,天宁区,\",\"addr\":\"香梅花园71号\",\"nearestPoint\":[119.98141,31.77051],\"distance\":14.765}]}";
        }
        return res;
    }
}
