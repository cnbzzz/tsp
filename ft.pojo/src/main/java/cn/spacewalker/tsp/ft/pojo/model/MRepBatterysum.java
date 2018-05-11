package cn.spacewalker.tsp.ft.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "m_rep_batterysum")
public class MRepBatterysum extends BaseDto {
    @Id
    private String oid;

    private Integer percent80;

    private Integer percent6080;

    private Integer percent4060;

    private Integer percent40;

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
     * @return percent80
     */
    public Integer getPercent80() {
        return percent80;
    }

    /**
     * @param percent80
     */
    public void setPercent80(Integer percent80) {
        this.percent80 = percent80;
    }

    /**
     * @return percent6080
     */
    public Integer getPercent6080() {
        return percent6080;
    }

    /**
     * @param percent6080
     */
    public void setPercent6080(Integer percent6080) {
        this.percent6080 = percent6080;
    }

    /**
     * @return percent4060
     */
    public Integer getPercent4060() {
        return percent4060;
    }

    /**
     * @param percent4060
     */
    public void setPercent4060(Integer percent4060) {
        this.percent4060 = percent4060;
    }

    /**
     * @return percent40
     */
    public Integer getPercent40() {
        return percent40;
    }

    /**
     * @param percent40
     */
    public void setPercent40(Integer percent40) {
        this.percent40 = percent40;
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