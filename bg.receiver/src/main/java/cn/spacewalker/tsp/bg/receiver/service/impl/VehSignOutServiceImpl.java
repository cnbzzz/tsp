package cn.spacewalker.tsp.bg.receiver.service.impl;

import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;
import cn.spacewalker.tsp.bg.pojo.mapper.TVehSignoutMapper;
import cn.spacewalker.tsp.bg.pojo.model.TVehSignout;
import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960MsgUtils;
import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960ReadByteBuf;
import cn.spacewalker.tsp.bg.receiver.service.ICommandService;
import com.google.common.base.Preconditions;

import javax.annotation.Resource;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/21 11:50
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class VehSignOutServiceImpl implements ICommandService {

    @Resource
    private TVehSignoutMapper mapper;

    @Override
    public TVehSignout handler(Gbt32960Msg msg) {
        Preconditions.checkArgument(msg != null, "msg is null");
        byte[] bytes = msg.getContent();
        Preconditions.checkArgument(bytes != null && bytes.length == 8, "bytes is not legal");

        Gbt32960ReadByteBuf buf = new Gbt32960ReadByteBuf(bytes);
        String signOutTime = Gbt32960MsgUtils.getGatherTimeStr(buf);

        int signOutFormNum = buf.readWord();

        TVehSignout data = new TVehSignout();
        data.setSignOutTime(signOutTime);
        data.setSignOutFormNum(signOutFormNum);
        String vin = msg.getVin();
        data.setVin(msg.getVin());
        String formNum = msg.getFormNum();
        data.setFormNum(formNum);
        data.setOid(formNum);

        mapper.insertSelective(data);

        return data;
    }
}
