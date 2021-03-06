package cn.spacewalker.tsp.ft.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "m_rep_chargingintervalsum")
public class MRepChargingintervalsum extends BaseDto {
    @Id
    private String oid;

    private Integer interval2dayCount;

    private Integer interval3dayCount;

    private Integer interval4dayCount;

    private Integer interval5dayCount;

    private Integer interval6dayCount;

    private Integer interval7dayCount;

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
     * @return interval2dayCount
     */
    public Integer getInterval2dayCount() {
        return interval2dayCount;
    }

    /**
     * @param interval2dayCount
     */
    public void setInterval2dayCount(Integer interval2dayCount) {
        this.interval2dayCount = interval2dayCount;
    }

    /**
     * @return interval3dayCount
     */
    public Integer getInterval3dayCount() {
        return interval3dayCount;
    }

    /**
     * @param interval3dayCount
     */
    public void setInterval3dayCount(Integer interval3dayCount) {
        this.interval3dayCount = interval3dayCount;
    }

    /**
     * @return interval4dayCount
     */
    public Integer getInterval4dayCount() {
        return interval4dayCount;
    }

    /**
     * @param interval4dayCount
     */
    public void setInterval4dayCount(Integer interval4dayCount) {
        this.interval4dayCount = interval4dayCount;
    }

    /**
     * @return interval5dayCount
     */
    public Integer getInterval5dayCount() {
        return interval5dayCount;
    }

    /**
     * @param interval5dayCount
     */
    public void setInterval5dayCount(Integer interval5dayCount) {
        this.interval5dayCount = interval5dayCount;
    }

    /**
     * @return interval6dayCount
     */
    public Integer getInterval6dayCount() {
        return interval6dayCount;
    }

    /**
     * @param interval6dayCount
     */
    public void setInterval6dayCount(Integer interval6dayCount) {
        this.interval6dayCount = interval6dayCount;
    }

    /**
     * @return interval7dayCount
     */
    public Integer getInterval7dayCount() {
        return interval7dayCount;
    }

    /**
     * @param interval7dayCount
     */
    public void setInterval7dayCount(Integer interval7dayCount) {
        this.interval7dayCount = interval7dayCount;
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