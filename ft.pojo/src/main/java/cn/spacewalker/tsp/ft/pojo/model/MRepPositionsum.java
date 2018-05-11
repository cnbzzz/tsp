package cn.spacewalker.tsp.ft.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "m_rep_positionsum")
public class MRepPositionsum extends BaseDto {
    @Id
    private String oid;

    private String city;

    private Long drivingCount;

    private Long chargingCount;

    private Long offlineCount;

    private Long totalCount;

    private String region;

    private String calcFormnum;

    private Date calcDate;

    private Date updateTime;

    /**
     * @return oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid
     */
    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return drivingCount
     */
    public Long getDrivingCount() {
        return drivingCount;
    }

    /**
     * @param drivingCount
     */
    public void setDrivingCount(Long drivingCount) {
        this.drivingCount = drivingCount;
    }

    /**
     * @return chargingCount
     */
    public Long getChargingCount() {
        return chargingCount;
    }

    /**
     * @param chargingCount
     */
    public void setChargingCount(Long chargingCount) {
        this.chargingCount = chargingCount;
    }

    /**
     * @return offlineCount
     */
    public Long getOfflineCount() {
        return offlineCount;
    }

    /**
     * @param offlineCount
     */
    public void setOfflineCount(Long offlineCount) {
        this.offlineCount = offlineCount;
    }

    /**
     * @return totalCount
     */
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount
     */
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * @return calcFormnum
     */
    public String getCalcFormnum() {
        return calcFormnum;
    }

    /**
     * @param calcFormnum
     */
    public void setCalcFormnum(String calcFormnum) {
        this.calcFormnum = calcFormnum == null ? null : calcFormnum.trim();
    }

    /**
     * @return calcDate
     */
    public Date getCalcDate() {
        return calcDate;
    }

    /**
     * @param calcDate
     */
    public void setCalcDate(Date calcDate) {
        this.calcDate = calcDate;
    }

    /**
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}