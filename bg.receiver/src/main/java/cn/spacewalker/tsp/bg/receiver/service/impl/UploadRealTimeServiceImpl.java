package cn.spacewalker.tsp.bg.receiver.service.impl;

import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960MsgUtils;
import cn.spacewalker.tsp.bg.receiver.service.ICommandService;
import cn.spacewalker.tsp.common.base.BaseDto;
import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;
import cn.spacewalker.tsp.bg.pojo.dto.UploadRealTimeDto;
import cn.spacewalker.tsp.bg.pojo.mapper.*;
import cn.spacewalker.tsp.bg.pojo.model.*;
import cn.spacewalker.tsp.bg.pojo.utils.ByteUtils;
import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960ReadByteBuf;
import cn.spacewalker.tsp.bg.pojo.utils.SnowflakeIdWorker;
import cn.spacewalker.tsp.common.geo.GetLocation;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/18 16:56
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class UploadRealTimeServiceImpl implements ICommandService {

    private Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private TVehUploadrealtimeMapper uploadrealtimeMapper;

    @Resource
    private TVehDataMapper vehDataMapper;

    @Resource
    private TVehDrivemotorMapper vehDrivemotorMapper;

    @Resource
    private TVehFuelcellMapper vehFuelcellMapper;

    @Resource
    private TVehEngineMapper engineMapper;

    @Resource
    private TVehPositionMapper vehPositionMapper;

    @Resource
    private TVehLimitMapper vehLimitMapper;

    @Resource
    private TVehErrorMapper vehErrorMapper;

    @Resource
    private TVehChargestorvoltMapper vehChargestorvoltMapper;

    @Resource
    private TVehChargestortempeMapper vehChargestortempeMapper;

    @Resource
    private TVehChargestorvoltitemMapper vehChargestorvoltitemMapper;

    @Resource
    private TVehErroritemMapper vehErroritemMapper;

    @Override
    public BaseDto handler(Gbt32960Msg msg) {
        Preconditions.checkArgument(msg != null, "msg is null");
        byte[] bytes = msg.getContent();
        Preconditions.checkArgument(bytes != null && bytes.length > 8, "bytes is not legal");

        Gbt32960ReadByteBuf buf = new Gbt32960ReadByteBuf(bytes);
        String gatherTime = Gbt32960MsgUtils.getGatherTimeStr(buf);

        TVehUploadrealtime data = new TVehUploadrealtime();
        data.setGatherTime(gatherTime);
        String formNum = msg.getFormNum();
        data.setFormnum(formNum);
        String vin = msg.getVin();
        data.setVin(vin);
        data.setOid(formNum);
        uploadrealtimeMapper.insertSelective(data);

        UploadRealTimeDto dto = new UploadRealTimeDto();
        try {
            BeanUtils.copyProperties(dto, data);
        } catch (IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }

        while (!buf.isReadLast()) {
            int flag = buf.readByte2Int();
            switch (flag) {
                case 0x01: //整车数据
                    long l1 = System.currentTimeMillis();
                    log.info(String.format("TVehData start..."));
                    dto.setVehData(getTVehData(buf, formNum, vin));
                    long l2 = System.currentTimeMillis();
                    log.info(String.format("TVehData end...cost [%s] ms", l2 - l1));
                    break;

                case 0x02: //驱动电机数据
                    long l3 = System.currentTimeMillis();
                    log.info(String.format("TVehDrivemotor start..."));
                    dto.setVehDrivemotorList(getTVehDrivemotor(buf, formNum, vin));
                    long l4 = System.currentTimeMillis();
                    log.info(String.format("TVehDrivemotor end...cost [%s] ms", l4 - l3));
                    break;

                case 0x03: //燃料电池
                    long l5 = System.currentTimeMillis();
                    log.info(String.format("VehFuelcell start..."));
                    dto.setVehFuelcell(getFuelCell(buf, formNum, vin));
                    long l6 = System.currentTimeMillis();
                    log.info(String.format("VehFuelcell end...cost [%s] ms", l6 - l5));
                    break;

                case 0x04: //发动机
                    long l7 = System.currentTimeMillis();
                    log.info(String.format("VehEngine start..."));
                    dto.setVehEngine(getEngine(buf, formNum, vin));
                    long l8 = System.currentTimeMillis();
                    log.info(String.format("VehEngine end...cost [%s] ms", l8 - l7));
                    break;

                case 0x05: //车辆位置
                    long l9 = System.currentTimeMillis();
                    log.info(String.format("VehPosition start..."));
                    dto.setVehPosition(getPosition(buf, formNum, vin));
                    long l10 = System.currentTimeMillis();
                    log.info(String.format("VehPosition end...cost [%s] ms", l10 - l9));
                    break;

                case 0x06: //极值数据
                    long l11 = System.currentTimeMillis();
                    log.info(String.format("VehLimit start..."));
                    dto.setVehLimit(getVehLimit(buf, formNum, vin));
                    long l12 = System.currentTimeMillis();
                    log.info(String.format("VehLimit end...cost [%s] ms", l12 - l11));
                    break;

                case 0x07: //报警数据
                    long l13 = System.currentTimeMillis();
                    log.info(String.format("VehError start..."));
                    dto.setVehError(getVehError(buf, formNum, vin));
                    long l14 = System.currentTimeMillis();
                    log.info(String.format("VehError end...cost [%s] ms", l14 - l13));
                    break;

                case 0x08: //可充电储能装置电压数据
                    long l15 = System.currentTimeMillis();
                    log.info(String.format("VehChargeStorVolt start..."));
                    getVehChargeStorVolt(buf, formNum, vin);
                    long l16 = System.currentTimeMillis();
                    log.info(String.format("VehChargeStorVolt end...cost [%s] ms", l16 - l15));
                    break;

                case 0x09: //可充电储能装置温度数据
                    long l17 = System.currentTimeMillis();
                    log.info(String.format("VehChargeStorTempe start..."));
                    getVehChargeStorTempe(buf, formNum, vin);
                    long l18 = System.currentTimeMillis();
                    log.info(String.format("VehChargeStorTempe end...cost [%s] ms", l18 - l17));
                    break;

                default:
                    Preconditions.checkArgument(1 != 1, "flag is not found [%s]", flag);
            }
        }
        return dto;
    }

    private TVehData getTVehData(Gbt32960ReadByteBuf buf, String formNum, String vin) {
        int vechStatus = buf.readByte2Int();
        int chargeStatus = buf.readByte2Int();
        int runMode = buf.readByte2Int();
        int speed = buf.readWord();
        long accMile = buf.readDword();
        int totalVoltage = buf.readWord();
        int totalCurrent = buf.readWord();
        int soc = buf.readByte2Int();
        int dcStatus = buf.readByte2Int();
        int gear = buf.readByte2Int();
        int insRes = buf.readWord();
        int blank = buf.readWord();

        TVehData data = new TVehData();
        data.setVehStatus(vechStatus);
        data.setChargeStatus(chargeStatus);
        data.setRunMode(runMode);
        data.setSpeed(speed);
        data.setAccMile(accMile);
        data.setTotalVoltage(totalVoltage);
        data.setTotalCurrent(totalCurrent);
        data.setSoc(soc);
        data.setDcStatus(dcStatus);
        data.setGear(gear);
        data.setInsRes(insRes);
        data.setBlank(blank);

        data.setFormnum(formNum);
        data.setVin(vin);
        data.setOid(formNum);

        vehDataMapper.insertSelective(data);
        return data;
    }

    public List<TVehDrivemotor> getTVehDrivemotor(Gbt32960ReadByteBuf buf, String formNum, String vin) {
        int driveMotorCount = buf.readByte2Int();

        List<TVehDrivemotor> list = new ArrayList<>();

        for (int i = 0; i < driveMotorCount; i++) {
            int driveMotorNum = buf.readByte2Int();
            int driveMotorStatus = buf.readByte2Int();
            int driveMotorCtrlTemper = buf.readByte2Int();
            int driveMotorSpeed = buf.readWord();
            int driveMotorTorque = buf.readWord();
            int driveMotorTemper = buf.readByte2Int();
            int driveMotorInputVoltage = buf.readWord();
            int driveMotorCurrent = buf.readWord();

            TVehDrivemotor data = new TVehDrivemotor();
            data.setDriveMotorCount(driveMotorCount);
            data.setDriveMotorIndex(i + 1);
            data.setDriveMotorNum(driveMotorNum);
            data.setDriveMotorStatus(driveMotorStatus);
            data.setDriveMotorCtrlTemper(driveMotorCtrlTemper);
            data.setDriveMotorSpeed(driveMotorSpeed);
            data.setDriveMotorTorque(driveMotorTorque);
            data.setDriveMotorTemper(driveMotorTemper);
            data.setDriveMotorInputVoltage(driveMotorInputVoltage);
            data.setDriveMotorCurrent(driveMotorCurrent);
            data.setFormnum(formNum);
            data.setVin(vin);
            data.setOid(SnowflakeIdWorker.genId());
            vehDrivemotorMapper.insertSelective(data);
            list.add(data);
        }
        return list;
    }

    public TVehFuelcell getFuelCell(Gbt32960ReadByteBuf buf, String formNum, String vin){
        int fuelCellVoltage = buf.readWord();
        int fuelCellCurrent = buf.readWord();
        int fuelCellPower = buf.readWord();
        int fuelCellProbeCount = buf.readWord();
        String fuelCellProbeTemper = "";
        if(fuelCellProbeCount > 0 || fuelCellProbeCount < 65531){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < fuelCellProbeCount; i++) {
                list.add(String.valueOf(buf.readByte2Int()));
            }
            fuelCellProbeTemper = String.join(",", list);
        }

        int hydMaxTemper = buf.readWord();

        int hydMaxTemperProbe = buf.readByte2Int();

        int hydMaxConc = buf.readWord();

        int hydMaxConcSensorNum = buf.readByte2Int();

        int hydMaxPress = buf.readWord();

        int hydMaxPressSensorNum = buf.readByte2Int();

        int dcStatus = buf.readByte2Int();

        TVehFuelcell data = new TVehFuelcell();
        data.setFuelCellVoltage(fuelCellVoltage);
        data.setFuelCellCurrent(fuelCellCurrent);
        data.setFuelCellPower(fuelCellPower);
        data.setFuelCellProbeCount(fuelCellProbeCount);
        data.setFuelCellProbeTemper(fuelCellProbeTemper);
        data.setHydMaxTemper(hydMaxTemper);
        data.setHydMaxTemperProbe(hydMaxTemperProbe);
        data.setHydMaxConc(hydMaxConc);
        data.setHydMaxConcSensorNum(hydMaxConcSensorNum);
        data.setHydMaxPress(hydMaxPress);
        data.setHydMaxPressSensorNum(hydMaxPressSensorNum);
        data.setDcStatus(dcStatus);

        data.setFormnum(formNum);
        data.setVin(vin);
        data.setOid(formNum);
        vehFuelcellMapper.insertSelective(data);

        return data;
    }

    public TVehEngine getEngine(Gbt32960ReadByteBuf buf, String formNum, String vin){
        int engineStatus = buf.readByte2Int();
        int crankshaftSpeed = buf.readWord();
        int fuelCellPower = buf.readWord();

        TVehEngine data = new TVehEngine();
        data.setEngineStatus(engineStatus);
        data.setCrankshaftSpeed(crankshaftSpeed);
        data.setFuelCellPower(fuelCellPower);

        data.setFormnum(formNum);
        data.setVin(vin);
        data.setOid(formNum);

        engineMapper.insertSelective(data);

        return data;
    }

    public TVehPosition getPosition(Gbt32960ReadByteBuf buf, String formNum, String vin){
        String posStatus = ByteUtils.byteToBit(buf.readByte());
        long longitude = buf.readDword();
        long latitude = buf.readDword();

        TVehPosition data = new TVehPosition();
        data.setPosStatus(posStatus);

        String lon = insertDot(String.valueOf(longitude));
        String lat = insertDot(String.valueOf(latitude));
        if(StringUtils.isNotBlank(lon) && StringUtils.isNotBlank(lat)){
            Map<String, String> regionInfo = getRegionInfo(lon, lat);
            if(!regionInfo.isEmpty()){
                data.setCity(regionInfo.get("cityName"));
                data.setProvince(regionInfo.get("provinceName"));
                data.setRegion(regionInfo.get("regionName"));
            }
        }

        data.setLongitude(lon);
        data.setLatitude(lat);

        data.setFormnum(formNum);
        data.setVin(vin);
        data.setOid(formNum);
        vehPositionMapper.insertSelective(data);

        return data;
    }

    public static String insertDot(String str){
        if(StringUtils.isBlank(str) || str.length() < 6){
            return null;
        }

        if(str.length() == 6){
            str = "0"+str;
        }
        if(str.length() == 7){
            str = str + "0";
        }

        StringBuilder sb = new StringBuilder(str);
        sb.insert(str.length() - 6, ".");
        return  sb.toString();
    }


    static Map<String, String> REGION_DICT = new HashMap<>();

    static {
        REGION_DICT.put("华东", "山东、江苏、安徽、浙江、福建、上海");
        REGION_DICT.put("华南", "广东、广西、海南");
        REGION_DICT.put("华中", "湖北、湖南、河南、江西");
        REGION_DICT.put("华北", "北京、天津、河北、山西、内蒙古");
        REGION_DICT.put("西北", "宁夏、新疆、青海、陕西、甘肃");
        REGION_DICT.put("西南", "四川、云南、贵州、西藏、重庆");
        REGION_DICT.put("东北", "辽宁、吉林、黑龙江");
        REGION_DICT.put("港澳台", "台湾、香港、澳门");
    }

    private static Map<String, String> getRegionInfo(String lon, String lat){
        Map<String, String> result = new HashMap<>();

        String add = GetLocation.getAdd(lon, lat);
        HashMap map = JSON.parseObject(add, HashMap.class);
        List<Map<String, String>> addrList = (List<Map<String,String>>) map.get("addrList");
        String admName = addrList.get(0).get("admName");
        if(StringUtils.isNotBlank(admName)){
            String[] split = StringUtils.split(admName, ",");
            if(split.length > 2){
                String provinceName = split[0];
                String cityName = split[1];
                if(StringUtils.isNotBlank(cityName)){
                    int lastIdx = cityName.lastIndexOf("市");
                    if(lastIdx == cityName.length() - 1){
                        cityName = cityName.substring(0, cityName.length() - 1);
                    }
                }
                String regionName = "华东";
                String provinceStr = provinceName.substring(0, 2);

                Set<Map.Entry<String, String>> entries = REGION_DICT.entrySet();
                for (Map.Entry<String, String> entry : entries) {
                    String val = entry.getValue();
                    if(val.indexOf(provinceStr) != -1){
                        regionName = entry.getKey();
                        break;
                    }
                }

                result.put("cityName", cityName);
                result.put("provinceName", provinceName);
                result.put("regionName", regionName);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String lon = "113.316447";
        String lat = "22.812481";
        Map<String, String> regionInfo = getRegionInfo(lon, lat);
        System.err.println(JSON.toJSONString(regionInfo));
    }

    public TVehLimit getVehLimit(Gbt32960ReadByteBuf buf, String formNum, String vin){
        int maxVoltageSubsystemNum = buf.readByte2Int();
        int maxVoltagefullCellNum = buf.readByte2Int();
        int maxVoltagefullCell = buf.readWord();
        int minVoltageSubsystemNum = buf.readByte2Int();
        int minVoltagefullCellNum = buf.readByte2Int();
        int minVoltagefullCell = buf.readWord();
        int maxTemperSubsystemNum = buf.readByte2Int();
        int maxTemperProbeNum = buf.readByte2Int();
        int maxTemper = buf.readByte2Int();
        int minTemperSubsystemNum = buf.readByte2Int();
        int minTemperProbeNum = buf.readByte2Int();
        int minTemper = buf.readByte2Int();

        TVehLimit data = new TVehLimit();
        data.setMaxVoltageSubsystemNum(maxVoltageSubsystemNum);
        data.setMaxVoltagefullCellNum(maxVoltagefullCellNum);
        data.setMaxVoltagefullCell(maxVoltagefullCell);
        data.setMinVoltageSubsystemNum(minVoltageSubsystemNum);
        data.setMinVoltagefullCellNum(minVoltagefullCellNum);
        data.setMinVoltagefullCell(minVoltagefullCell);
        data.setMaxTemperSubsystemNum(maxTemperSubsystemNum);
        data.setMaxTemperProbeNum(maxTemperProbeNum);
        data.setMaxTemper(maxTemper);
        data.setMinTemperSubsystemNum(minTemperSubsystemNum);
        data.setMinTemperProbeNum(minTemperProbeNum);
        data.setMinTemper(minTemper);

        data.setFormnum(formNum);
        data.setVin(vin);
        data.setOid(formNum);

        vehLimitMapper.insertSelective(data);

        return data;
    }

    public TVehError getVehError(Gbt32960ReadByteBuf buf, String formNum, String vin){
        int maxErrorLevel = buf.readByte2Int();
        String currencyErrorLevel = ByteUtils.intToBit((int)buf.readDword());
        int fullCellErrorCount = buf.readByte2Int();

        List<Long> fullCellErrorList = readErrorList(buf, fullCellErrorCount);

        int driveMotorErrorCount = buf.readByte2Int();

        List<Long> driveMotorErrorList = readErrorList(buf, driveMotorErrorCount);

        int engineErrorCount = buf.readByte2Int();

        List<Long> engineErrorList = readErrorList(buf, engineErrorCount);

        int otherErrorCount = buf.readByte2Int();

        List<Long> otherErrorList = readErrorList(buf, otherErrorCount);

        TVehError data = new TVehError();
        data.setMaxErrorLevel(maxErrorLevel);
        data.setCurrencyErrorLevel(currencyErrorLevel);
        data.setFullCellErrorCount(fullCellErrorCount);

        Integer errorType = 1;
        genErroritem(fullCellErrorList, errorType, formNum, vin);

        data.setDriveMotorErrorCount(driveMotorErrorCount);

        errorType = 2;
        genErroritem(driveMotorErrorList, errorType, formNum, vin);

        data.setEngineErrorCount(engineErrorCount);

        errorType = 3;
        genErroritem(engineErrorList, errorType, formNum, vin);

        data.setOtherErrorCount(otherErrorCount);

        errorType = 4;
        genErroritem(otherErrorList, errorType, formNum, vin);

        data.setFormnum(formNum);
        data.setVin(vin);
        data.setOid(formNum);

        vehErrorMapper.insertSelective(data);

        return data;
    }

    private void genErroritem(List<Long> errorCodeList, Integer errorType, String formNum, String vin) {
        List<TVehErroritem> list = new ArrayList<>();
        for (Long errorCode: errorCodeList) {
            TVehErroritem item = new TVehErroritem();
            item.setErrorCode(errorCode);
            item.setErrorType(errorType);
            item.setFormnum(formNum);
            item.setVin(vin);
            item.setOid(SnowflakeIdWorker.genId());
            list.add(item);
        }
        if(CollectionUtils.isNotEmpty(list)){
            uploadrealtimeMapper.insertBatchErroritem(list);
        }
    }

    private List<Long> readErrorList(Gbt32960ReadByteBuf buf, int errorCount) {
        List<Long> errorList = new ArrayList<>();
        for (int i = 0; i < errorCount; i++) {
            long errorCode = buf.readDword();
            errorList.add(errorCode);
        }
        return errorList;
    }


    public List<TVehChargestorvolt> getVehChargeStorVolt(Gbt32960ReadByteBuf buf, String formNum, String vin){
        int chargeStorCount = buf.readByte2Int();

        List<TVehChargestorvolt> list = new ArrayList<>();
        for (int i = 0; i < chargeStorCount; i++) {
            int chargeStorNum = buf.readByte2Int();
            int chargeStorVoltage = buf.readWord();
            int chargeStorCurrent = buf.readWord();
            int batteryCount = buf.readWord();
            int batteryNum = buf.readWord();
            int frameBatteryCount = buf.readByte2Int();

            List<Integer> batteryVoltageList = new ArrayList<>();
            for (int j = 0; j < frameBatteryCount; j++) {
                int batteryVoltage = buf.readWord();
                batteryVoltageList.add(batteryVoltage);
            }


            TVehChargestorvolt data = new TVehChargestorvolt();
            data.setChargeStorCount(chargeStorCount);
            data.setChargeStorIndex(i);
            data.setChargeStorNum(chargeStorNum);
            data.setChargeStorVoltage(chargeStorVoltage);
            data.setChargeStorCurrent(chargeStorCurrent);
            data.setBatteryCount(batteryCount);
            data.setBatteryNum(batteryNum);
            data.setFrameBatteryCount(frameBatteryCount);

            List<TVehChargestorvoltitem> insertList = new ArrayList<>();
            for (Integer batteryVoltage : batteryVoltageList) {
                TVehChargestorvoltitem item = new TVehChargestorvoltitem();
                item.setBatteryVoltage(batteryVoltage);
                item.setFormnum(formNum);
                item.setOid(SnowflakeIdWorker.genId());
                item.setVin(vin);
                insertList.add(item);
            }
            if(CollectionUtils.isNotEmpty(insertList)){
                uploadrealtimeMapper.insertBatchVoltitem(insertList);
            }

            data.setFormnum(formNum);
            data.setVin(vin);
            data.setOid(formNum);

            vehChargestorvoltMapper.insertSelective(data);
            list.add(data);
        }

        return list;
    }

    public List<TVehChargestortempe> getVehChargeStorTempe(Gbt32960ReadByteBuf buf, String formNum, String vin){
        int chargeStorCount = buf.readByte2Int();

        List<TVehChargestortempe> list = new ArrayList<>();
        for (int i = 0; i < chargeStorCount; i++) {
            int chargeStorNum = buf.readByte2Int();
            int chargeStorProbeCount = buf.readWord();

            String chargeStorTempeVal = null;
            List<String> valList = new ArrayList<>();
            if(0 < chargeStorProbeCount && chargeStorProbeCount < 65531){
                for (int j = 0; j < chargeStorProbeCount; j++) {
                    valList.add(String.valueOf(buf.readByte2Int()));
                }
                chargeStorTempeVal = String.join(",", valList);
            }

            TVehChargestortempe data = new TVehChargestortempe();
            data.setChargeStorCount(chargeStorCount);
            data.setChargeStorIndex(i);
            data.setChargeStorNum(chargeStorNum);
            data.setChargeStorProbeCount(chargeStorProbeCount);
            data.setChargeStorTempeVal(chargeStorTempeVal);

            data.setFormnum(formNum);
            data.setVin(vin);
            data.setOid(formNum);

            vehChargestortempeMapper.insertSelective(data);
            list.add(data);
        }

        return list;
    }

}
