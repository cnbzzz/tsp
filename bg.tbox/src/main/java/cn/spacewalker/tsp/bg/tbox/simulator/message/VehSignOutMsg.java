package cn.spacewalker.tsp.bg.tbox.simulator.message;

import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;
import cn.spacewalker.tsp.bg.pojo.model.TVehSignout;
import cn.spacewalker.tsp.bg.pojo.utils.Gbt32960Msg2Bytes;
import cn.spacewalker.tsp.bg.tbox.constant.CommandConstant;

/**
 * Created by steven ma
 * 2017/8/22 18:01
 */

public class VehSignOutMsg extends TBoxBaseMsg {

    private TVehSignout tVehSignout;

    //构造函数先初始化默认值
    public VehSignOutMsg() {

        tVehSignout = new TVehSignout();

        //必须设置VIN
        tVehSignout.setVin("1234567890ABCDEFG");

        //登出时间
        tVehSignout.setSignOutTime("17 8 24 11 23 58"); //
        //登出流水号(暂时没用到)
        tVehSignout.setSignOutFormNum(65531); //65531
    }

    //外部重新设置变量
    public void setParam(String vin, String time) {
        tVehSignout.setVin(vin);
        //登出时间
        tVehSignout.setSignOutTime(time); //"17 8 24 11 23 58"
    }

    public  Gbt32960Msg getGbtMsg() {

        Gbt32960Msg msg = setGbtMsgHead(CommandConstant.VEH_SIGNOUT,
                    tVehSignout.getVin());
        msg.setContent(Gbt32960Msg2Bytes.vehSignout2Bytes(tVehSignout));

        return msg;
}
}
