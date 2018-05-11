package cn.spacewalker.tsp.ft.pojo.mapper;

import cn.spacewalker.tsp.common.base.BaseMapper;
import cn.spacewalker.tsp.common.dto.NameValDto;
import cn.spacewalker.tsp.ft.pojo.dto.ColCurveDto;
import cn.spacewalker.tsp.ft.pojo.dto.OnlineVehDto;
import cn.spacewalker.tsp.ft.pojo.dto.VehRegionPercentDto;
import cn.spacewalker.tsp.ft.pojo.model.MRepVehsum;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MRepVehsumMapper extends BaseMapper<MRepVehsum> {

    List<OnlineVehDto> listOnlineVeh(@Param("startDatetime") String startDatetime, @Param("interval") Integer interval, @Param("limit") Integer limit);

    List<ColCurveDto> listColCurve(@Param("startDatetime") String startDatetime, @Param("interval") Integer interval, @Param("limit") Integer limit);

    List<Map<String, String>> listVehinfoDayCurve(@Param("startDatetime") String startDatetime, @Param("interval") Integer interval, @Param("vin") String vin);

    List<Map<String, String>> listVehinfoMonthCurve(@Param("startDatetime") String startDatetime, @Param("interval") Integer interval, @Param("vin") String vin);

    List<Map<String, String>> listVehinfoCurve(@Param("startDatetime") String startDatetime, @Param("interval") Integer interval, @Param("limit") Integer limit);

    List<NameValDto> listVehHeatMapData();

    List<VehRegionPercentDto> listVehRegionPercent();

    List<Map<String, String>> listVehMile(@Param("vin") String vin, @Param("startDatetime") String startDatetime, @Param("interval") Integer interval, @Param("limit") Integer limit);
}