package cn.spacewalker.tsp.ft.bigscreen.index.service;

import cn.spacewalker.tsp.common.base.BaseResp;
import cn.spacewalker.tsp.ft.bigscreen.index.dto.HeatMapDto;
import cn.spacewalker.tsp.ft.pojo.dto.*;
import cn.spacewalker.tsp.ft.pojo.model.*;

import java.util.List;
import java.util.Map;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/14 20:29
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public interface IIndexService {

    BaseResp<IndexDto> queryIndex();

    BaseResp<List<OnlineVehDto>> listVehsumByTime(String startDatetime, Integer interval, Integer limit);

    BaseResp<List<ColCurveDto>> listColCurve(String startDatetime, Integer interval, Integer limit);

    BaseResp<List<Map<String, String>>> listVehinfoCurve(String startDatetime, Integer interval, Integer limit);

    BaseResp<MRepErrorsum> queryErrorsum();

    BaseResp<List<MRepPositionsum>> listPositionsum();

    BaseResp<VehPercentDto> listVehRegionPercent();

    BaseResp<MRepErrorsum> queryBatterysum();

    BaseResp<MRepChargingintervalsum> queryChargingintervalsum();

    BaseResp<List<MRepVehinfo>> listVehinfo(String status);

    BaseResp<MRepLastvehinfo> queryVehinfo(String vin);

    BaseResp<List<MRepErrorlog>> listErrorlog(String errorType, String errorGrade);

    BaseResp<List<MRepChargelog>> listChargelog(String vin, Integer limit);

    BaseResp<HeatMapDto> listVehHeatMapData();

    BaseResp<List<MRepErrorlog>> queryErrorlog(String vin, String startDate, String endDate, String errorType, Integer limit);

    BaseResp<List<Map<String, String>>> listVehMile(String vin, String startDateTime, Integer interval, Integer limit);

    BaseResp<List<Map<String, String>>> listVehinfoDayCurve(String startDatetime, Integer interval, String vin);

    BaseResp<List<Map<String, String>>> listVehinfoMonthCurve(String startDatetime, Integer interval, String vin);
}
