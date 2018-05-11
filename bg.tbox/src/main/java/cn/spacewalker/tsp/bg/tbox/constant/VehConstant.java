package cn.spacewalker.tsp.bg.tbox.constant;

/**
 * Created by steven ma
 * 2017/8/23 20:23
 */

public class VehConstant {
    public static final int VEH_STATUS_START = 0x01;  //启动
    public static final int VEH_STATUS_STOP  = 0x02;  //熄火
    public static final int VEH_STATUS_OTHER = 0x03;  //其他
    public static final int VEH_STATUS_ERROR = 0x0FE;  //异常
    public static final int VEH_STATUS_NULL = 0x0FF;   //无效

    public static final int CHARGE_STATUS_STOP  = 0x01;  //停车充电
    public static final int CHARGE_STATUS_DRIVE = 0x02;  //行驶充电
    public static final int CHARGE_STATUS_NOCHARGE = 0x03; //未充电
    public static final int CHARGE_STATUS_DONE = 0x04;  //充电完成
    public static final int CHARGE_STATUS_ERROR = 0x0FE;  //异常
    public static final int CHARGE_STATUS_NULL = 0x0FF;   //无效

}
