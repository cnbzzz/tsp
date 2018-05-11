package cn.spacewalker.tsp.bg.receiver.service.impl;

import cn.spacewalker.tsp.bg.receiver.service.ICommandService;

import javax.annotation.Resource;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/17 16:55
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class CommandHandlerFactory {

    @Resource(name = "vehSignInServiceImpl")
    private ICommandService vehSignInServiceImpl;

    @Resource(name = "uploadRealTimeServiceImpl")
    private ICommandService uploadRealTimeServiceImpl;

    @Resource(name = "vehSignOutServiceImpl")
    private ICommandService vehSignOutServiceImpl;

    @Resource(name = "platformSignInServiceImpl")
    private ICommandService platformSignInServiceImpl;

    @Resource(name = "platformSignOutServiceImpl")
    private ICommandService platformSignOutService;

    public ICommandService getCommandHandler(int commandSymbol){
        switch (commandSymbol){
            case 0x01:
                return vehSignInServiceImpl;

            case 0x02:
                return uploadRealTimeServiceImpl;

            case 0x04:
                return vehSignOutServiceImpl;

            case 0x05:
                return platformSignInServiceImpl;

            case 0x06:
                return platformSignOutService;

            case 0x80:
                return platformSignOutService;

            case 0x81:
                return platformSignOutService;

            case 0x82:
                return platformSignOutService;

            default:
                return null;
        }
    }

}
