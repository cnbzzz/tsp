package cn.spacewalker.tsp.ft.bigscreen.index.ctrl;

import cn.spacewalker.tsp.common.base.BaseResp;
import cn.spacewalker.tsp.common.util.CommUtils;
import cn.spacewalker.tsp.ft.bigscreen.index.service.IIndexService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/14 15:40
 * Copyright (c) 2017 www.space-walker.cn
 */
@RestController
@RequestMapping("/tsp")
public class IndexCtrl {

    protected Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private IIndexService indexService;

    @RequestMapping("/index")
    public String index() {
        return indexService.queryIndex().toString();
    }

    @RequestMapping("/queryErrorsum")
    public String queryErrorsum() {
        return indexService.queryErrorsum().toString();
    }

    @RequestMapping("/listVehsumByTime")
    public String listVehsumByTime(@RequestParam(value = "datetime", required = false) String datetime, @RequestParam(value = "interval", required = false) Integer interval, @RequestParam(value = "limit", required = false) Integer limit) {
        datetime = StringUtils.isNotBlank(datetime) ? datetime : CommUtils.timestamp2str(new Date());
        interval = interval != null ? interval : 10;
        limit = limit != null ? limit : 10;
        return indexService.listVehsumByTime(datetime, interval, limit).toString();
    }

    @RequestMapping("/listColCurve")
    public String listColCurve(@RequestParam(value = "datetime", required = false) String datetime, @RequestParam(value = "interval", required = false) Integer interval, @RequestParam(value = "limit", required = false) Integer limit) {
        datetime = StringUtils.isNotBlank(datetime) ? datetime : CommUtils.timestamp2str(new Date());
        interval = interval != null ? interval : 10;
        limit = limit != null ? limit : 10;
        return indexService.listColCurve(datetime, interval, limit).toString();
    }

    @RequestMapping("/listPositionsum")
    public String listPositionsum() {
        return indexService.listPositionsum().toString();
    }

    @RequestMapping("/listVehRegionPercent")
    public String listVehRegionPercent() {
        return indexService.listVehRegionPercent().toString();
    }

    @RequestMapping("/listVehHeatMapData")
    public String listVehHeatMapData() {
        return indexService.listVehHeatMapData().toString();
    }

    @RequestMapping("/queryBatterysum")
    public String queryBatterysum() {
        return indexService.queryBatterysum().toString();
    }

    @RequestMapping("/queryChargingintervalsum")
    public String queryChargingintervalsum() {
        return indexService.queryChargingintervalsum().toString();
    }

    @RequestMapping("/listVehinfo")
    public String listVehinfo(@RequestParam(value = "status", required = false) String status) {
        return indexService.listVehinfo(status).toString();
    }

    @RequestMapping("/queryVehinfo")
    public String queryVehinfo(@RequestParam(value = "vin", required = false) String vin) {
        return indexService.queryVehinfo(vin).toString();
    }

    @RequestMapping("/listErrorlog")
    public String listErrorlog(@RequestParam(value = "errorType", required = false) String errorType, @RequestParam(value = "errorGrade", required = false) String errorGrade) {
        return indexService.listErrorlog(errorType, errorGrade).toString();
    }

    @RequestMapping("/listVehinfoCurve")
    public String listVehinfoCurve(@RequestParam(value = "datetime", required = false) String datetime, @RequestParam(value = "interval", required = false) Integer interval, @RequestParam(value = "limit", required = false) Integer limit) {
        datetime = StringUtils.isNotBlank(datetime) ? datetime : CommUtils.timestamp2str(new Date());
        interval = interval != null ? interval : 10;
        limit = limit != null ? limit : 10;
        return indexService.listVehinfoCurve(datetime, interval, limit).toString();
    }

    @RequestMapping("/listVehinfoMonthCurve")
    public String listVehinfoMonthCurve(@RequestParam(value = "datetime", required = false) String datetime, @RequestParam(value = "interval", required = false) Integer interval, @RequestParam(value = "vin") String vin) {
        return indexService.listVehinfoMonthCurve(datetime, interval, vin).toString();
    }

    @RequestMapping("/listVehinfoDayCurve")
    public String listVehinfoDayCurve(@RequestParam(value = "datetime", required = false) String datetime, @RequestParam(value = "interval", required = false) Integer interval, @RequestParam(value = "vin") String vin) {
        return indexService.listVehinfoDayCurve(datetime, interval, vin).toString();
    }

    @RequestMapping("/listChargelog")
    public String listChargelog(@RequestParam(value = "vin", required = false) String vin, @RequestParam(value = "limit", required = false) Integer limit) {
        return indexService.listChargelog(vin, limit).toString();
    }

    @RequestMapping("/queryErrorlog")
    public String queryErrorlog(@RequestParam("vin") String vin, @RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate, @RequestParam(value = "errorType", required = false) String errorType, @RequestParam(value = "limit", required = false) Integer limit) {
        return indexService.queryErrorlog(vin, startDate, endDate, errorType, limit).toString();
    }

    @RequestMapping("/listVehMile")
    public String listVehMile(@RequestParam("vin") String vin, @RequestParam(value = "startDateTime", required = false) String startDateTime, @RequestParam(value = "interval", required = false) Integer interval, @RequestParam(value = "errorType", required = false) String errorType, @RequestParam(value = "limit", required = false) Integer limit) {
        return indexService.listVehMile(vin, startDateTime, interval, limit).toString();
    }

    @ExceptionHandler
    public String exception(Exception e) {
        log.error("error:{}", e);
        // 根据不同错误转向不同页面
        return BaseResp.failResp("服务器忙，请稍后再试").toString();
    }
}
