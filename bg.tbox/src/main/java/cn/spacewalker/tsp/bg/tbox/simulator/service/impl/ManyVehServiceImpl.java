package cn.spacewalker.tsp.bg.tbox.simulator.service.impl;

import cn.spacewalker.tsp.bg.tbox.config.SimulatorConfig;
import cn.spacewalker.tsp.bg.tbox.constant.ActionConstant;
import cn.spacewalker.tsp.bg.tbox.simulator.model.Vehicle;
import cn.spacewalker.tsp.bg.tbox.simulator.service.ScriptService;
import cn.spacewalker.tsp.bg.tbox.util.RandomStringUtil;
import cn.spacewalker.tsp.bg.tbox.util.TimeFormatUtil;
import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cn.spacewalker.tsp.common.util.CommUtils.readJson;

/**
 * Created by steven ma
 * 2017/8/24 9:40
 */

@Component
public class ManyVehServiceImpl implements ScriptService {

    private Logger log = LogManager.getLogger(this.getClass().getName());

    //配置信息
    @Autowired
    private SimulatorConfig config;

    //车辆列表
    private List<Vehicle> vehicleList = new ArrayList<>();

    private ChannelHandlerContext ctx;

    //初始化所有车辆
    private void initVehList(ChannelHandlerContext ctx) {
        try {
            List<Vehicle> list = readJson("veh.txt", Vehicle.class);

            for (Vehicle vehicle : list) {
                String vin = vehicle.getVin();
                String iccid = vehicle.getIccid();
                Date date = new Date();
                String time = TimeFormatUtil.tboxDate2Str(date);

                this.ctx = ctx;
                Vehicle veh = new Vehicle(vin, iccid, time, ctx);
                vehicleList.add(veh);
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

    //打印所有辆信息
    private void showVeh() {
        int num = 0;
        log.info("---------show veh-------------");
        for(Vehicle veh: vehicleList) {
            log.info("[" + num + "]: " + veh);
            num ++;
        }
        log.info("---------show veh-------------");
    }


    @Override
    public void action(ChannelHandlerContext ctx) {

        log.info("config:{}", config);

        log.info("Run:ManyVehServiceImpl....");
        //初始化辆
        initVehList(ctx);

        //打印车辆
//        showVeh();

        try {
            runByDate();
        } catch (Exception e) {
            log.error("action: {}", e);
        }


    }

    //根据 "开始时间" 至 "结束时间" 按频率进行发送
    public  void runByDate() throws Exception {

        //登录
        for (int i = 0; i < vehicleList.size(); i++) {
            Vehicle vehicle = vehicleList.get(i);
            vehicle.login();
            System.err.println(String.format("第%s条数据是%s", i, JSON.toJSONString(vehicle)));
        }
        int sec = 30;
        Thread.sleep(sec * 1000);

        //当“当前时间”早于结束时间
        while (true) {
            //开始
            for (int i = 0; i < vehicleList.size(); i++) {
                Vehicle vehicle = vehicleList.get(i);
                vehicle.doAction(-1);
                vehicle.addTimeBySec(sec);
            }
            log.error("ctx.channel().isActive()" + ctx.channel().isActive());
            Thread.sleep(sec * 1000);
        }

    }
    //随机取得车辆进行发送
    private void randomGetVehSend(String time) {

        //随机从列表里取一辆车进行发送
        int vehNum = (int) (Math.random() * vehicleList.size());
        //log.info("size: " + vehicleList.size());

        Vehicle vehicle = vehicleList.get(vehNum);
        log.info("[" + vehNum + "] Veh Run.....\n" + vehicle);

        vehicle.setGatherTime(time);
        doVehSolo(vehicle);
    }


    //取一个小时级别的随机时间
    private int randomHours() {
        return  (int) (Math.random() * 3600 * 5);
    }

    //取一个分钟级别的随机时间
    private int randomMin() {
        return  (int) (Math.random() * 3600 );
    }



    //单辆车进行solo
    private void doVehSolo(Vehicle vehicle) {

        vehicle.login();
        vehicle.doAction(ActionConstant.START);

        vehicle.addTimeBySec(randomMin());
        vehicle.doAction(ActionConstant.STOP_AND_CHARGE);

        vehicle.addTimeBySec(randomHours());
        vehicle.doAction(ActionConstant.CHARGE_DONE);

        vehicle.addTimeBySec(10);
        vehicle.doAction(ActionConstant.MOVE);

        vehicle.addTimeBySec(10);
        vehicle.doAction(ActionConstant.MOVE);

        vehicle.addTimeBySec(10);
        vehicle.doAction(ActionConstant.STOP);

        vehicle.logout();
    }


    public static void main(String[] args) {
        System.err.println(JSON.toJSONString(readJson("vin.txt", String.class)));
    }
}
