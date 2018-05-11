package cn.spacewalker.tsp.common.dto;

import cn.spacewalker.tsp.common.base.BaseDto;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/23 11:00
 * Copyright (c) 2017 www.space-walker.cn
 */
public class NameValDto extends BaseDto {

    private String name;

    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
