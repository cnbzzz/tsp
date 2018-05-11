package cn.spacewalker.tsp.ft.bigscreen.index.service.impl;

import cn.spacewalker.tsp.common.base.BaseResp;
import cn.spacewalker.tsp.common.base.BaseServiceImpl;
import cn.spacewalker.tsp.common.dto.NameValDto;
import cn.spacewalker.tsp.common.util.CommUtils;
import cn.spacewalker.tsp.ft.bigscreen.index.dto.HeatMapDto;
import cn.spacewalker.tsp.ft.bigscreen.index.service.IIndexService;
import cn.spacewalker.tsp.ft.pojo.dto.*;
import cn.spacewalker.tsp.ft.pojo.mapper.*;
import cn.spacewalker.tsp.ft.pojo.model.*;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.persistence.Table;
import java.util.*;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/15 15:31
 * Copyright (c) 2017 www.space-walker.cn
 */
public class IndexServiceImpl extends BaseServiceImpl implements IIndexService {

    @Resource
    private MRepVehsumMapper vehsumMapper;

    @Resource
    private MRepDatauploadsumMapper datauploadsumMapper;

    @Resource
    private MRepErrorsumMapper errorsumMapper;

    @Resource
    private MRepPositionsumMapper positionsumMapper;

    @Resource
    private MRepBatterysumMapper batterysumMapper;

    @Resource
    private MRepChargingintervalsumMapper chargingintervalsumMapper;

    @Resource
    private MRepErrorlogMapper errorlogMapper;

    @Resource
    private MRepChargelogMapper chargelogMapper;

    @Resource
    private MRepVehinfoMapper vehinfoMapper;

    @Resource
    private MRepDrivinglogMapper drivinglogMapper;

    @Resource
    private MRepLastvehinfoMapper lastvehinfoMapper;

    public BaseResp<IndexDto> queryIndex(){
        BaseResp resp = succ();
        try {
            PageHelper.startPage(1, 5);
            List<MRepVehsum> vehsumList = getListByExample(vehsumMapper, MRepVehsum.class, null);

            PageHelper.startPage(1, 5);
            List<MRepDatauploadsum> datauploadsumList = getListByExample(datauploadsumMapper, MRepDatauploadsum.class, null);

            PageHelper.startPage(1, 5);
            List<MRepErrorsum> errorsumList = getListByExample(errorsumMapper, MRepErrorsum.class, null);

            PageHelper.startPage(1, 5);
            List<MRepPositionsum> positionsumList = getListByExample(positionsumMapper, MRepPositionsum.class, null);

            PageHelper.startPage(1, 5);
            List<MRepBatterysum> batterysumList = getListByExample(batterysumMapper, MRepBatterysum.class, null);

            IndexDto dto = new IndexDto();
            dto.setVehsum(vehsumList.size() > 0 ? vehsumList.get(0) : null);
            dto.setDatauploadsum(datauploadsumList.size() > 0 ? datauploadsumList.get(0) : null);
            dto.setErrorsum(errorsumList.size() > 0 ? errorsumList.get(0) : null);
            dto.setPositionsum(positionsumList.size() > 0 ? positionsumList.get(0) : null);
            dto.setBatterysum(batterysumList.size() > 0 ? batterysumList.get(0) : null);

            resp.setData(dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<List<OnlineVehDto>> listVehsumByTime(String startDatetime, Integer interval, Integer limit){
        BaseResp resp = succ();
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(startDatetime), "startDatetime is null");

            Date date = CommUtils.str2timestamp(startDatetime);
            Preconditions.checkArgument(date != null, "startDatetime format error, startDatetime is [%s]", startDatetime);

            List<OnlineVehDto> list = vehsumMapper.listOnlineVeh(startDatetime, interval, limit);

            resp.setData(list);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<List<ColCurveDto>> listColCurve(String startDatetime, Integer interval, Integer limit){
        BaseResp resp = succ();
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(startDatetime), "startDatetime is null");

            Date date = CommUtils.str2timestamp(startDatetime);
            Preconditions.checkArgument(date != null, "startDatetime format error, startDatetime is [%s]", startDatetime);

            List<ColCurveDto> list = vehsumMapper.listColCurve(startDatetime, interval, limit);

            resp.setData(list);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<List<Map<String, String>>> listVehinfoCurve(String startDatetime, Integer interval, Integer limit){
        BaseResp resp = succ();
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(startDatetime), "startDatetime is null");

            Date date = CommUtils.str2timestamp(startDatetime);
            Preconditions.checkArgument(date != null, "startDatetime format error, startDatetime is [%s]", startDatetime);

            List<Map<String, String>> list = vehsumMapper.listVehinfoCurve(startDatetime, interval, limit);

            resp.setData(list);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<List<Map<String, String>>> listVehinfoDayCurve(String startDatetime, Integer interval, String vin){
        BaseResp resp = succ();
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(vin), "vin is null");

            if(StringUtils.isBlank(startDatetime)){
                startDatetime = CommUtils.timestamp2str(new Date());
            }

            if(interval == null || interval == 0){
                interval = 30;
            }

            Date date = CommUtils.str2timestamp(startDatetime);
            Preconditions.checkArgument(date != null, "startDatetime format error, startDatetime is [%s]", startDatetime);

            List<Map<String, String>> list = vehsumMapper.listVehinfoDayCurve(startDatetime, interval, vin);

            if(list.size() < interval){//要补数据
                Collection<Map<String, String>> values = supData(startDatetime, interval,null, list);
                list = new ArrayList<>(values);
            }

            resp.setData(list);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    private Collection<Map<String, String>> supData(String startDatetime, Integer interval, String type, List<Map<String, String>> list) {
        List<String> keyList = getKeyList(startDatetime, interval, type);
        Map<String, Map<String, String>> map = new TreeMap<>();
        for (String str: keyList) {
            Map<String, String> valMap = new HashMap<>();
            valMap.put("datetime", str);
            valMap.put("accMile", "0");
            map.put(str, valMap);
        }

        for (Map<String, String> dataMap : list) {
            String datetime = dataMap.get("datetime");
            map.put(datetime, dataMap);
        }

        return map.values();
    }

    public BaseResp<List<Map<String, String>>> listVehinfoMonthCurve(String startDatetime, Integer interval, String vin){
        BaseResp resp = succ();
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(vin), "vin is null");

            if(StringUtils.isBlank(startDatetime)){
                startDatetime = CommUtils.timestamp2str(new Date());
            }

            if(interval == null || interval == 0){
                interval = 12;
            }

            Date date = CommUtils.str2timestamp(startDatetime);
            Preconditions.checkArgument(date != null, "startDatetime format error, startDatetime is [%s]", startDatetime);

            List<Map<String, String>> list = vehsumMapper.listVehinfoMonthCurve(startDatetime, interval, vin);


            if(list.size() < interval){//要补数据
                Collection<Map<String, String>> values = supData(startDatetime, interval,"MONTH", list);
                list = new ArrayList<>(values);
            }

            resp.setData(list);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<List<MRepErrorlog>> queryErrorlog(String vin, String startDate, String endDate, String errorType, Integer limit){
        BaseResp resp = succ();
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(vin), "vin is null.");
            if(StringUtils.isBlank(endDate)){
                endDate = CommUtils.date2str(new Date());
            }
            if(StringUtils.isBlank(startDate)){
                Date date = DateUtils.addDays(new Date(), -7);
                startDate = CommUtils.date2str(date);
            }
            if(limit == null){
                limit = 10;
            }
            List<MRepErrorlog> list = drivinglogMapper.queryErrorlogByVin(vin, startDate, endDate, errorType, limit);
            resp.setData(list);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<List<Map<String, String>>> listVehMile(String vin, String startDateTime, Integer interval, Integer limit){
        BaseResp resp = succ();
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(vin), "vin is null");
            if(StringUtils.isBlank(startDateTime)){
                startDateTime = CommUtils.date2str(new Date());
            }
            if(interval == null){
                interval = 3600 * 24;
            }
            if(limit == null){
                limit = 30;
            }
            List<Map<String, String>> list = vehsumMapper.listVehMile(vin, startDateTime, interval, limit);
            resp.setData(list);
        } catch (Exception e){
            resp = fail();
        }
        return  resp;
    }

    public BaseResp<MRepErrorsum> queryErrorsum(){
        BaseResp resp = succ();
        try {
            List<MRepErrorsum> list = getListByExample(errorsumMapper, MRepErrorsum.class, null);
            resp.setData(list.size() > 0 ? list.get(0) : null);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<MRepErrorsum> queryBatterysum(){
        BaseResp resp = succ();
        try {
            List<MRepBatterysum> list = getListByExample(batterysumMapper, MRepBatterysum.class, null);
            resp.setData(list.size() > 0 ? list.get(0) : null);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<MRepChargingintervalsum> queryChargingintervalsum(){
        BaseResp resp = succ();
        try {
            List<MRepChargingintervalsum> list = getListByExample(chargingintervalsumMapper, MRepChargingintervalsum.class, null);
            resp.setData(list.size() > 0 ? list.get(0) : null);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<List<MRepPositionsum>> listPositionsum(){
        BaseResp resp = succ();
        try {
            List<MRepPositionsum> list = getListByExample(positionsumMapper, MRepPositionsum.class, null);
            resp.setData(list);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<MRepLastvehinfo> queryVehinfo(String vin){
        Preconditions.checkArgument(StringUtils.isNotBlank(vin), "vin is null.");
        BaseResp resp = succ();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("vin", vin);

        try {
            List<MRepLastvehinfo> list = getListByExample(lastvehinfoMapper, MRepLastvehinfo.class, paramMap);
            resp.setData(list.size() > 0 ? list.get(0) : null);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<List<MRepVehinfo>> listVehinfo(String status){
        BaseResp resp = succ();
        try {
            PageHelper.startPage(1, 9);
            Map<String, String> paramMap = new HashMap<>();
            if(StringUtils.isNotBlank(status)){
                paramMap.put("status", status);
            }
            List<MRepLastvehinfo> list = getListByExample(lastvehinfoMapper, MRepLastvehinfo.class, paramMap);
            resp.setData(list);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<List<MRepChargelog>> listChargelog(String vin, Integer limit){
        BaseResp resp = succ();
        try {
            if(limit == null || limit == 0){
                limit = 10;
            }
            PageHelper.startPage(1, limit);
            Map<String, String> paramMap = new HashMap<>();
            if(StringUtils.isNotBlank(vin)){
                paramMap.put("vin", vin);
            }
            List<MRepChargelog> list = getListByExample(chargelogMapper, MRepChargelog.class, paramMap);
            resp.setData(list);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<List<MRepErrorlog>> listErrorlog(String errorType, String errorGrade){
        BaseResp resp = succ();
        try {
            PageHelper.startPage(1, 7);
            Map<String, String> paramMap = new HashMap<>();
            if(StringUtils.isNotBlank(errorType)){
                paramMap.put("errorType", errorType);
            }

            if(StringUtils.isNotBlank(errorType)){
                paramMap.put("errorGrade", errorGrade);
            }

            List<MRepErrorlog> list = getListByExample(errorlogMapper, MRepErrorlog.class, paramMap);
            resp.setData(list);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<VehPercentDto> listVehRegionPercent(){
        BaseResp resp = succ();
        try {
            List<VehRegionPercentDto> list = vehsumMapper.listVehRegionPercent();
            Integer totalChargingCount = 0;
            Integer totalDrivingCount = 0;
            Integer totalOfflineCount = 0;
            for (VehRegionPercentDto dto : list) {
                totalChargingCount += dto.getChargingCount();
                totalDrivingCount += dto.getDrivingCount();
                totalOfflineCount += dto.getOfflineCount();
            }
            VehPercentDto dto = new VehPercentDto();
            dto.setTotalChargingCount(totalChargingCount);
            dto.setTotalDrivingCount(totalDrivingCount);
            dto.setTotalOfflineCount(totalOfflineCount);
            dto.setList(list);
            resp.setData(dto);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public BaseResp<HeatMapDto> listVehHeatMapData(){
        BaseResp resp = succ();
        try {
            List<NameValDto> list = vehsumMapper.listVehHeatMapData();

            HeatMapDto heatMapDto = new HeatMapDto();
            if(CollectionUtils.isNotEmpty(list)){
                List<Integer> valList = new ArrayList<>();
                for (NameValDto dto : list) {
                    valList.add(dto.getValue());
                }
                heatMapDto.setMax(Collections.max(valList));
            }

            heatMapDto.setDataList(list);
            resp.setData(heatMapDto);
        } catch (Exception e) {
            resp = fail();
            log.error(e.getMessage(), e);
        }

        return resp;
    }

    public static void main(String[] args) {
        List<String> keyList = getKeyList(CommUtils.date2str(new Date()), 30, null);
        System.err.println(JSON.toJSONString(keyList));

        keyList = getKeyList(CommUtils.date2str(new Date()), 12, "MONTH");
        System.err.println(JSON.toJSONString(keyList));
    }

    private static List<String> getKeyList(String startTime, Integer interval, String type) {
        List<String> keyList = new ArrayList<>();
        int i = interval;
        while(i-- > 0){
            Date date = CommUtils.str2date(startTime);
            Date newDate = null;
            String newStr = null;
            if(StringUtils.equalsIgnoreCase("MONTH", type)){
                newDate = DateUtils.addMonths(date, -i);
                newStr = DateFormatUtils.format(newDate, "yyyy-MM");
            } else{
                newDate = DateUtils.addDays(date, -i);
                newStr = CommUtils.date2str(newDate);
            }

            keyList.add(newStr);
        }
        return keyList;
    }

    private List getListByExample(Mapper mapper, Class clazz, Map<String, String> paramMap) throws Exception {
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();

        if(paramMap != null && !paramMap.isEmpty()){
            Set<Map.Entry<String, String>> entries = paramMap.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entries.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                criteria.andEqualTo(next.getKey(), next.getValue());
            }
        }

        example.setOrderByClause("calcFormnum desc");
        return mapper.selectByExample(example);
    }
}
