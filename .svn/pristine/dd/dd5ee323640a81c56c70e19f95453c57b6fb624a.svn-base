package cn.spacewalker.tsp.bg.tbox.util;

import cn.spacewalker.tsp.bg.tbox.simulator.model.Vehicle;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by steven ma
 * 2017/8/24 11:30
 */

//随机产生字符串
public class RandomStringUtil {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();

        // 去掉"-"符号
        String result = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return result.toUpperCase();
    }

    //长度为17
    public static String getVin(){
        return getUUID().substring(0, 17);
    }

    //长度为20
    public static String getIccid(){
        return getUUID().substring(0, 20);
    }


    public static void main(String[] args) {
        int i = 500;
        List<Vehicle> vehicleList = new ArrayList<>();
        while(i-- > 0){
            String vin = getVin();
            String iccid = getIccid();
            Vehicle vehicle = new Vehicle();
            vehicle.setVin(vin);
            vehicle.setIccid(iccid);
            vehicle.setGatherTime(null);
            vehicleList.add(vehicle);
        }
        System.err.println(vehicleList.size());
        System.err.println(JSON.toJSONString(vehicleList));
    }

}
