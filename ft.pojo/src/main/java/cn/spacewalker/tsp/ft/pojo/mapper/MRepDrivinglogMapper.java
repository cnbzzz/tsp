package cn.spacewalker.tsp.ft.pojo.mapper;

import cn.spacewalker.tsp.common.base.BaseMapper;
import cn.spacewalker.tsp.ft.pojo.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MRepDrivinglogMapper extends BaseMapper<MRepDrivinglog> {

    Long queryDriveTimes(@Param("vin") String vin);

    MRepVehsum queryVehsum();

    MRepErrorsum countErrorsum();

    MRepBatterysum countBatterysum();

    MRepChargingintervalsum countChargingIntervalsum();

    List<MRepPositionsum> countPositionsum();

    List<MRepErrorlog> queryErrorlogByVin(@Param("vin") String vin, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("errorType") String errorType, @Param("limit") Integer limit);

    void insertDrivingCalcByMinute(@Param("gatherTime") String gatherTime);

    void insertVehinfoList(List<MRepVehinfo> list);

    void insertErrorlogList(List<MRepErrorlog> list);
}