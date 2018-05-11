package cn.spacewalker.tsp.bg.tbox.simulator.message;

import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;
import cn.spacewalker.tsp.bg.pojo.model.TVehSignin;
import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960Msg2Bytes;
import cn.spacewalker.tsp.bg.tbox.constant.CommandConstant;

/**
 * Created by steven ma
 * 2017/8/22 18:01
 */

public class VehSignInMsg extends TBoxBaseMsg {

    private TVehSignin tVehSignin;

    //构造函数先初始化默认值
    public VehSignInMsg() {
        tVehSignin = new TVehSignin();

        //必须设置VIN
        tVehSignin.setVin("1234567890ABCDEFG");

        //数据采集时间
        tVehSignin.setGatherTime("17 8 24 11 23 58");
        //登入流水号(暂时没用到)
        tVehSignin.setSignInFormNum(65531);
        //ICCID
        tVehSignin.setIccid("1234567890ABCDEFGQWE");
        //可充电储能子系统数
        tVehSignin.setChargeNum(10);
        //可充电储能系统编码长度
        tVehSignin.setSystemCodeLength(3);
        //可充电储能系统编码
        tVehSignin.setSystemCode("qwertyuiopqwertyuiopqwertyuiop");


    }

    //外部重新设置变量
    public  void setParam(String vin, String iccid, String time) {
        tVehSignin.setGatherTime(time);
        tVehSignin.setIccid(iccid);
        tVehSignin.setVin(vin);
    }


//    private TVehSignin getObject() {
//        return this.tVehSignin;
//    }


    public  Gbt32960Msg getGbtMsg() {

        Gbt32960Msg msg = setGbtMsgHead(CommandConstant.VEH_SIGNIN,
                        tVehSignin.getVin());
        msg.setContent(Gbt32960Msg2Bytes.vehSignin2Bytes(tVehSignin));

        return msg;
    }
}
