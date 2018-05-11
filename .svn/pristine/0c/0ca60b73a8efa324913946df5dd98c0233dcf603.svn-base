package cn.spacewalker.tsp.bg.receiver.service.impl;

import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960MsgUtils;
import cn.spacewalker.tsp.common.base.BaseDto;
import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;
import cn.spacewalker.tsp.bg.pojo.mapper.TPlatformSignoutMapper;
import cn.spacewalker.tsp.bg.pojo.model.TPlatformSignout;
import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960ReadByteBuf;
import cn.spacewalker.tsp.bg.receiver.service.ICommandService;
import com.google.common.base.Preconditions;

import javax.annotation.Resource;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/21 15:59
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class PlatformSignOutServiceImpl implements ICommandService {

    @Resource
    private TPlatformSignoutMapper mapper;

    @Override
    public BaseDto handler(Gbt32960Msg msg) {
        Preconditions.checkArgument(msg != null, "msg is null");
        byte[] bytes = msg.getContent();
        Preconditions.checkArgument(bytes != null && bytes.length == 8, "bytes is not legal");

        Gbt32960ReadByteBuf buf = new Gbt32960ReadByteBuf(bytes);
        String signOutTime = Gbt32960MsgUtils.getGatherTimeStr(buf);

        int signOutFormNum = buf.readWord();
        System.err.println(String.format("signOutFormNum is [%s]", signOutFormNum));

        TPlatformSignout data = new TPlatformSignout();
        String formNum = msg.getFormNum();
        data.setOid(formNum);
        data.setSignOutTime(signOutTime);
        data.setSignOutFormNum(signOutFormNum);
        data.setFormNum(formNum);
        data.setVin(msg.getVin());

        mapper.insertSelective(data);

        return data;
    }
}
