package cn.spacewalker.tsp.bg.tbox.config;

import cn.spacewalker.tsp.bg.tbox.util.TimeFormatUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by steven ma
 * 2017/8/24 17:36
 */

@Component
@ConfigurationProperties(prefix = "simulator.many_veh" )
public class SimulatorConfig {
    //--------------配置部分-----------------------
    //车辆总数
    private    int vehCont = 1000;
    //一小时发车频率(一个车有N个包)

    private    int packagePerHour  = 360;

    private    String startTime = "2017-08-30 15:00:00";

    //默认结束时间为当前时间
    private    String endTime ;  //"2017-08-24 02:00:00";

    public SimulatorConfig() {

        try {
            Date endDate = new Date();
            endTime = TimeFormatUtil.formatDate(endDate);
            Date startDate = DateUtils.addMonths(endDate, -1);
            startTime = TimeFormatUtil.formatDate(startDate);;
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
    //-------------------------------------------


    //根据频率算出间隔时间
    public int getIntervalTime() {

        intervalTime = 3600 / packagePerHour;

        return intervalTime;
    }

    private  int intervalTime ; //间隔发送时间


    public int getVehCont() {
        return vehCont;
    }

    public void setVehCont(int vehCont) {
        this.vehCont = vehCont;
    }

    public int getPackagePerHour() {
        return packagePerHour;
    }

    public void setPackagePerHour(int packagePerHour) {
        this.packagePerHour = packagePerHour;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    @Override
    public String toString() {
        return "SimulatorConfig{" +
                "vehCont=" + vehCont +
                ", packagePerHour=" + packagePerHour +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", intervalTime=" + intervalTime +
                '}';
    }
}
