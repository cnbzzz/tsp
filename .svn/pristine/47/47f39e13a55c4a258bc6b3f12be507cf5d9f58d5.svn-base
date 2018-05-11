package cn.spacewalker.tsp.bg.receiver.service.impl;

import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960MsgUtils;
import cn.spacewalker.tsp.common.base.BaseDto;
import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;
import cn.spacewalker.tsp.bg.pojo.mapper.TPlatformSigninMapper;
import cn.spacewalker.tsp.bg.pojo.model.TPlatformSignin;
import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960ReadByteBuf;
import cn.spacewalker.tsp.bg.receiver.service.ICommandService;
import com.google.common.base.Preconditions;

import javax.annotation.Resource;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/21 15:30
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class PlatformSignInServiceImpl implements ICommandService {

    @Resource
    private TPlatformSigninMapper mapper;

    @Override
    public BaseDto handler(Gbt32960Msg msg) {
        Preconditions.checkArgument(msg != null, "msg is null");
        byte[] bytes = msg.getContent();
        Preconditions.checkArgument(bytes != null && bytes.length == 41, "bytes is not legal");

        Gbt32960ReadByteBuf buf = new Gbt32960ReadByteBuf(bytes);
        String signInTime = Gbt32960MsgUtils.getGatherTimeStr(buf);

        int signInFormNum = buf.readWord();
        System.err.println(String.format("signInFormNum is [%s]", signInFormNum));

        String userName = buf.readString(12, "GBK");
        String passwd = buf.readString(20, "GBK");

        int encRule = buf.readByte2Int();

        TPlatformSignin data = new TPlatformSignin();
        data.setOid(msg.getFormNum());
        data.setSignInTime(signInTime);
        data.setSignInFormNum(signInFormNum);
        data.setFormNum(msg.getFormNum());
        data.setUserName(userName);
        data.setPasswd(passwd);
        data.setEncRule(encRule);
        data.setVin(msg.getVin());

        mapper.insertSelective(data);

        return data;
    }
}
