package cn.spacewalker.tsp.bg.pojo.dto;


import cn.spacewalker.tsp.bg.pojo.model.TPlatformSignin;
import cn.spacewalker.tsp.bg.pojo.model.TPlatformSignout;
import cn.spacewalker.tsp.bg.pojo.model.TVehSignin;
import cn.spacewalker.tsp.bg.pojo.model.TVehSignout;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/7 11:19
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class Gbt32960MsgDto extends Gbt32960Msg {

    private TVehSignin vehSignin;

    private TVehSignout vehSignout;

    private TPlatformSignin platformSignin;

    private TPlatformSignout platformSignout;

    private UploadRealTimeDto uploadRealTimeDto;

    public TVehSignin getVehSignin() {
        return vehSignin;
    }

    public void setVehSignin(TVehSignin vehSignin) {
        this.vehSignin = vehSignin;
    }

    public TVehSignout getVehSignout() {
        return vehSignout;
    }

    public void setVehSignout(TVehSignout vehSignout) {
        this.vehSignout = vehSignout;
    }

    public TPlatformSignin getPlatformSignin() {
        return platformSignin;
    }

    public void setPlatformSignin(TPlatformSignin platformSignin) {
        this.platformSignin = platformSignin;
    }

    public TPlatformSignout getPlatformSignout() {
        return platformSignout;
    }

    public void setPlatformSignout(TPlatformSignout platformSignout) {
        this.platformSignout = platformSignout;
    }

    public UploadRealTimeDto getUploadRealTimeDto() {
        return uploadRealTimeDto;
    }

    public void setUploadRealTimeDto(UploadRealTimeDto uploadRealTimeDto) {
        this.uploadRealTimeDto = uploadRealTimeDto;
    }
}
