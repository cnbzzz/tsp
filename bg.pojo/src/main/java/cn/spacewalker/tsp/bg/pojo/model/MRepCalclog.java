package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "m_rep_calclog")
public class MRepCalclog extends BaseDto {
    @Id
    private String oid;

    private Long calcType;

    private Long currColData;

    private Long succColData;

    private Long lastFormnum;

    private String calcMin;

    private String calcHour;

    private String calcDay;

    private String calcMonth;

    private String calcYear;

    private Date calcTime;

    private String calcFormnum;

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
     * @return calcType
     */
    public Long getCalcType() {
        return calcType;
    }

    /**
     * @param calcType
     */
    public void setCalcType(Long calcType) {
        this.calcType = calcType;
    }

    /**
     * @return currColData
     */
    public Long getCurrColData() {
        return currColData;
    }

    /**
     * @param currColData
     */
    public void setCurrColData(Long currColData) {
        this.currColData = currColData;
    }

    /**
     * @return succColData
     */
    public Long getSuccColData() {
        return succColData;
    }

    /**
     * @param succColData
     */
    public void setSuccColData(Long succColData) {
        this.succColData = succColData;
    }

    /**
     * @return lastFormnum
     */
    public Long getLastFormnum() {
        return lastFormnum;
    }

    /**
     * @param lastFormnum
     */
    public void setLastFormnum(Long lastFormnum) {
        this.lastFormnum = lastFormnum;
    }

    /**
     * @return calcMin
     */
    public String getCalcMin() {
        return calcMin;
    }

    /**
     * @param calcMin
     */
    public void setCalcMin(String calcMin) {
        this.calcMin = calcMin == null ? null : calcMin.trim();
    }

    /**
     * @return calcHour
     */
    public String getCalcHour() {
        return calcHour;
    }

    /**
     * @param calcHour
     */
    public void setCalcHour(String calcHour) {
        this.calcHour = calcHour == null ? null : calcHour.trim();
    }

    /**
     * @return calcDay
     */
    public String getCalcDay() {
        return calcDay;
    }

    /**
     * @param calcDay
     */
    public void setCalcDay(String calcDay) {
        this.calcDay = calcDay == null ? null : calcDay.trim();
    }

    /**
     * @return calcMonth
     */
    public String getCalcMonth() {
        return calcMonth;
    }

    /**
     * @param calcMonth
     */
    public void setCalcMonth(String calcMonth) {
        this.calcMonth = calcMonth == null ? null : calcMonth.trim();
    }

    /**
     * @return calcYear
     */
    public String getCalcYear() {
        return calcYear;
    }

    /**
     * @param calcYear
     */
    public void setCalcYear(String calcYear) {
        this.calcYear = calcYear == null ? null : calcYear.trim();
    }

    /**
     * @return calcTime
     */
    public Date getCalcTime() {
        return calcTime;
    }

    /**
     * @param calcTime
     */
    public void setCalcTime(Date calcTime) {
        this.calcTime = calcTime;
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
}