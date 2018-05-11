package cn.spacewalker.tsp.bg.pojo.rabbitmq;

import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/9 16:37
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class Producer extends EndPoint{

    public Producer(String endPointName) throws Exception {
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
    }
}
