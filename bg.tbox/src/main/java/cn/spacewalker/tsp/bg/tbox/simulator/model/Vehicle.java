package cn.spacewalker.tsp.bg.tbox.simulator.model;

import cn.spacewalker.tsp.bg.tbox.constant.ActionConstant;
import cn.spacewalker.tsp.bg.tbox.constant.VehConstant;
import cn.spacewalker.tsp.bg.tbox.simulator.message.UploadRealTimeMsg;
import cn.spacewalker.tsp.bg.tbox.simulator.message.VehSignInMsg;
import cn.spacewalker.tsp.bg.tbox.simulator.message.VehSignOutMsg;
import cn.spacewalker.tsp.bg.tbox.util.ProvPositionUtil;
import cn.spacewalker.tsp.bg.tbox.util.TimeFormatUtil;
import cn.spacewalker.tsp.common.util.CommUtils;
import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by steven ma
 * 2017/8/23 14:06
 */

public class Vehicle {

    private Logger log = LogManager.getLogger(this.getClass().getName());

    private static Integer LINE_FILE_INDEX = 0;

    private static Integer LINE_FILE_MAX_INDEX = 2;

    private static Map<Integer, String> LINE_MAP_MAPPING = new HashMap<>();

    static {
        LINE_MAP_MAPPING.put(0, "131.txt");
        LINE_MAP_MAPPING.put(1, "metro2.txt");
    }

    private List<Integer> actionList = Arrays.asList(ActionConstant.START,  ActionConstant.MOVE, ActionConstant.MOVE, ActionConstant.MOVE, ActionConstant.MOVE, ActionConstant.STOP);

    private Integer currActionIndex = 0;

    private String vin;
    private String iccid;
    private String gatherTime = TimeFormatUtil.tboxDate2Str(new Date()); //上报时间
    private ChannelHandlerContext ctx;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    //实时上报消息
    private UploadRealTimeMsg realTimeMsg;

    //车辆位置
    private ProvPosition vehPos;

    private List<ProvPosition> wayLineList = new ArrayList<>();

    private Integer index = 0;

    public Vehicle(){}

    public Vehicle(String vin, String iccid, String gatherTime, ChannelHandlerContext ctx) {
        this.vin = vin;
        this.iccid = iccid;
        this.gatherTime = gatherTime;
        this.ctx = ctx;

        realTimeMsg = new UploadRealTimeMsg();


        //得到行驶线路
        this.wayLineList = getLineStationList();

        //设置车辆初始位置
        vehPos = this.wayLineList.get(index++);
        realTimeMsg.setPosition(vehPos.getLng(), vehPos.getLat());
        //设置车辆初始总里程(1w公里以下的随机值)
        realTimeMsg.setAccMile((long)(Math.random() * 10000));

        realTimeMsg.setParam(vin, gatherTime);
    }


    //登入
    public void login() {

        VehSignInMsg signIn = new VehSignInMsg();
        signIn.setParam(vin, iccid, gatherTime);

        ctx.writeAndFlush(signIn.getGbtMsg());
    }

    //登出
    public void logout() {


        VehSignOutMsg signOut = new VehSignOutMsg();
        signOut.setParam(vin, gatherTime);

        log.info("logout:" +
                realTimeMsg.getGbtMsg().getVin());
        ctx.writeAndFlush(signOut.getGbtMsg());
    }

    //经度或纬度加上一个随机值，让其移动
    private String addPos(String lnglat) {
        long rlnglat = (long) (Math.random() * 1000);
        long llnglat = Long.parseLong(lnglat) + rlnglat;
        return Long.toString(llnglat);
    }

    //随机取得车辆启动位置
    private ProvPosition getPosRandom() {
        //全国经纬度
        List<ProvPosition> provs = ProvPositionUtil.readFile();

        int index = (int) (Math.random() * provs.size());

        ProvPosition pos = provs.get(index);

        pos.setLng(addPos(pos.getLng()));
        pos.setLat(addPos(pos.getLat()));

        log.info("pos: " + pos);

        return pos;
    }

    //车辆动作
    public void doAction(int action) {

        if(action <= 0){
            if(currActionIndex >= actionList.size()){
                currActionIndex = 0;
            }
            action = actionList.get(currActionIndex++);
        }

        if (realTimeMsg == null) {
            realTimeMsg = new UploadRealTimeMsg();
        }

        realTimeMsg.setParam(vin, gatherTime);
        //随机错误
        realTimeMsg.randomError();

        switch (action) {

            //启动
            case ActionConstant.START: {

                realTimeMsg.setNoCharge();
                realTimeMsg.setVehStatus(VehConstant.VEH_STATUS_START);

                break;
            }

            //停车充电
            case ActionConstant.STOP_AND_CHARGE: {

                realTimeMsg.setStopAndCharge();
                break;
            }

            //充电停止
            case ActionConstant.CHARGE_DONE: {

                realTimeMsg.setDoneCharge();
                break;
            }

            //移动
            case ActionConstant.MOVE: {

                ProvPosition next = getNext(this.wayLineList);
                vehPos.setLng(next.getLng());
                vehPos.setLat(next.getLat());

                //只要移动了就对里程数加个随机值
                realTimeMsg.addAccMile();
                //只要移动了就对soc减少一个值
                realTimeMsg.subtSoc();
                //随机车速
                realTimeMsg.randomSpeed();
                //随机电流
                realTimeMsg.randomCurrent();
                //随机电压
                realTimeMsg.randomVoltage();
                //随机温度
                realTimeMsg.randomTemper();
                //随机浓度
                realTimeMsg.randomConc();

                realTimeMsg.setPosition(vehPos.getLng(), vehPos.getLat());

                break;
            }

            //熄火
            case ActionConstant.STOP: {

                realTimeMsg.setNoCharge();
                realTimeMsg.setVehStatus(VehConstant.VEH_STATUS_STOP);

                break;
            }

            default: {
                log.error("Error Action: " + action);
            }

        }

        //发送报文
        ctx.writeAndFlush(realTimeMsg.getGbtMsg());

    }


    //给时间加个秒数
    public void addTimeBySec(int inSec) {


        gatherTime = TimeFormatUtil.addTimeBySec(gatherTime, inSec);
//        //计算上报时间
//        String patterns = "yy MM dd HH mm ss";
//
//        try {
//            Date dTime = DateUtils.parseDate(gatherTime, patterns);
//            log.info("time:" + dTime);
//
//            dTime = DateUtils.addSeconds(dTime, inSec);
//            log.info("time:" + dTime);
//
//            gatherTime = TimeFormatUtil.tboxDate2Str(dTime);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

    }

    public static String getNextLineFile(){
        Integer nextLine = LINE_FILE_INDEX++;
        if(LINE_FILE_INDEX >= LINE_FILE_MAX_INDEX){
            LINE_FILE_INDEX = 0;
        }
        return LINE_MAP_MAPPING.get(nextLine);
    }

    public ProvPosition getNext(List<ProvPosition> list){
        int idx = this.index++;
        if(this.index >= list.size()){
            this.index = 0;
        }
        return list.get(idx);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", iccid='" + iccid + '\'' +
                ", gatherTime='" + gatherTime + '\'' +
                //", realTimeMsg=" + realTimeMsg +
                ", vehPos=" + vehPos +
                '}';
    }

    public void setGatherTime(String time) {
        if(StringUtils.isBlank(time)){
            this.gatherTime = time;
            return;
        }
        //如果传过来的时候在本车时间之前不处理
        Date inTime = TimeFormatUtil.tboxStr2Date(time);
        Date myTime = TimeFormatUtil.tboxStr2Date(gatherTime);

        if(inTime.compareTo(myTime) < 0) {
            log.info("setGatherTime: {} => {}" , time, gatherTime);
            return;
        }

        this.gatherTime = time;
    }

    public String getGatherTime() {
        return gatherTime;
    }

    public static void main(String[] args) {


    }

    private static List<ProvPosition> getLineStationList() {
        String path = Vehicle.class.getClassLoader().getResource(getNextLineFile()).getPath();
        try {
            path = CommUtils.urlParamDecode(path);
            String json = FileUtils.readFileToString(new File(path), "UTF-8");
            List<ProvPosition> list = JSON.parseArray(json, ProvPosition.class);
            for (ProvPosition prov : list) {
                String lng = prov.getLng();
                prov.setLng(plusZero(lng));
                String lat = prov.getLat();
                prov.setLat(plusZero(lat));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String plusZero(String str){
        String[] split = StringUtils.split(str, ".");
        if(split.length > 1){
            int zz = 6 - split[1].length();
            for (int i = 0; i < zz; i++){
                str += "0";
            }
        }
        return str;
    }
}
