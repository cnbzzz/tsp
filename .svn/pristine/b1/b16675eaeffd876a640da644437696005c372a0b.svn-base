package cn.spacewalker.tsp.bg.receiver.service.impl;

import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;
import cn.spacewalker.tsp.bg.pojo.mapper.TVehSigninMapper;
import cn.spacewalker.tsp.bg.pojo.model.TVehSignin;
import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960MsgUtils;
import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960ReadByteBuf;
import cn.spacewalker.tsp.bg.receiver.service.ICommandService;
import com.google.common.base.Preconditions;

import javax.annotation.Resource;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/17 17:18
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class VehSignInServiceImpl implements ICommandService {

    @Resource
    private TVehSigninMapper mapper;

    public TVehSignin handler(Gbt32960Msg msg){
        Preconditions.checkArgument(msg != null, "msg is null");
        byte[] bytes = msg.getContent();
        Preconditions.checkArgument(bytes != null && bytes.length >= 30, "bytes is not legal");

        Gbt32960ReadByteBuf buf = new Gbt32960ReadByteBuf(bytes);
        String gatherTime = Gbt32960MsgUtils.getGatherTimeStr(buf);

        int signInFormNum = buf.readWord();

        String iccid = buf.readString(20, "GBK");

        int chargeNum = buf.readByte2Int();

        int systemCodeLength = buf.readByte2Int();

        int i = chargeNum * systemCodeLength;

        String systemCode = null;
        if(i > 0){
            systemCode = buf.readString(i, "GBK");
        }

        TVehSignin data = new TVehSignin();
        data.setGatherTime(gatherTime);
        data.setSignInFormNum(signInFormNum);
        data.setIccid(iccid);
        data.setChargeNum(chargeNum);
        data.setSystemCodeLength(systemCodeLength);
        data.setSystemCode(systemCode);
        String formNum = msg.getFormNum();

        data.setOid(formNum);
        String vin = msg.getVin();
        data.setVin(vin);
        data.setFormNum(formNum);

        mapper.insertSelective(data);

        return data;
    }
}
