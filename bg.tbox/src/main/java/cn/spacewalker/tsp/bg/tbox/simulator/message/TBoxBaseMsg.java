package cn.spacewalker.tsp.bg.tbox.simulator.message;

import cn.spacewalker.tsp.bg.pojo.dto.Gbt32960Msg;

/**
 * Created by steven ma
 * 2017/8/22 16:44
 */

public class TBoxBaseMsg {

    //设置数据包头
    public static Gbt32960Msg setGbtMsgHead(int command, String vin) {
        Gbt32960Msg msg = new Gbt32960Msg();

        //报头数据
        msg.setCommandSymbol(command);
        msg.setResponseSymbol(254); //0xFE
        msg.setVin(vin);
        msg.setEncryptWay(1);
        /**数据单元长度及数据单元在TBoxEncoder调置*/
        msg.setCheckPoint(1);

        return msg;
    }


}
