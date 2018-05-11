package cn.spacewalker.tsp.ft.pojo.dto;

import cn.spacewalker.tsp.common.base.BaseDto;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/15 20:29
 * Copyright (c) 2017 www.space-walker.cn
 */
public class OnlineVehDto extends BaseDto {

    private String datetime;

    private Integer model1OnlineCount;

    private Integer model2OnlineCount;

    private Integer model3OnlineCount;

    private Integer onlineVehCount;

    private Integer accMile;

    public Integer getAccMile() {
        return accMile;
    }

    public void setAccMile(Integer accMile) {
        this.accMile = accMile;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getModel1OnlineCount() {
        return model1OnlineCount;
    }

    public void setModel1OnlineCount(Integer model1OnlineCount) {
        this.model1OnlineCount = model1OnlineCount;
    }

    public Integer getModel2OnlineCount() {
        return model2OnlineCount;
    }

    public void setModel2OnlineCount(Integer model2OnlineCount) {
        this.model2OnlineCount = model2OnlineCount;
    }

    public Integer getModel3OnlineCount() {
        return model3OnlineCount;
    }

    public void setModel3OnlineCount(Integer model3OnlineCount) {
        this.model3OnlineCount = model3OnlineCount;
    }

    public Integer getOnlineVehCount() {
        return onlineVehCount;
    }

    public void setOnlineVehCount(Integer onlineVehCount) {
        this.onlineVehCount = onlineVehCount;
    }
}
