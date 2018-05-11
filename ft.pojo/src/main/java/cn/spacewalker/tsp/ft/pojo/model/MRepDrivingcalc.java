package cn.spacewalker.tsp.ft.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "m_rep_drivingcalc")
public class MRepDrivingcalc extends BaseDto {
    @Id
    private String oid;

    private String vin;

    private Long drivingMile;

    private String calcMin;

    private String calcHour;

    private String calcDay;

    private String calcMonth;

    private String calcYear;

    private String calcFormnum;

    private Date calcDate;

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
     * @return vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * @param vin
     */
    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    /**
     * @return drivingMile
     */
    public Long getDrivingMile() {
        return drivingMile;
    }

    /**
     * @param drivingMile
     */
    public void setDrivingMile(Long drivingMile) {
        this.drivingMile = drivingMile;
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
}