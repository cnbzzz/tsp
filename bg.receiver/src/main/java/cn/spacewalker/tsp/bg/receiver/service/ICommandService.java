package cn.spacewalker.tsp.bg.receiver.service;

import cn.spacewalker.tsp.common.base.BaseDto;
import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/17 17:17
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public interface ICommandService {

    BaseDto handler(Gbt32960Msg msg);

}
