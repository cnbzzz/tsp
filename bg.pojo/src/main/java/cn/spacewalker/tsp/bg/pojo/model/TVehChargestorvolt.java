package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_veh_chargestorvolt")
public class TVehChargestorvolt extends BaseDto {
    @Id
    private String oid;

    private Integer chargeStorCount;

    private Integer chargeStorIndex;

    private Integer chargeStorNum;

    private Integer chargeStorVoltage;

    private Integer chargeStorCurrent;

    private Integer batteryCount;

    private Integer batteryNum;

    private Integer frameBatteryCount;

    private String vin;

    private String formnum;

    private Date uploadTime;

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
     * @return chargeStorCount
     */
    public Integer getChargeStorCount() {
        return chargeStorCount;
    }

    /**
     * @param chargeStorCount
     */
    public void setChargeStorCount(Integer chargeStorCount) {
        this.chargeStorCount = chargeStorCount;
    }

    /**
     * @return chargeStorIndex
     */
    public Integer getChargeStorIndex() {
        return chargeStorIndex;
    }

    /**
     * @param chargeStorIndex
     */
    public void setChargeStorIndex(Integer chargeStorIndex) {
        this.chargeStorIndex = chargeStorIndex;
    }

    /**
     * @return chargeStorNum
     */
    public Integer getChargeStorNum() {
        return chargeStorNum;
    }

    /**
     * @param chargeStorNum
     */
    public void setChargeStorNum(Integer chargeStorNum) {
        this.chargeStorNum = chargeStorNum;
    }

    /**
     * @return chargeStorVoltage
     */
    public Integer getChargeStorVoltage() {
        return chargeStorVoltage;
    }

    /**
     * @param chargeStorVoltage
     */
    public void setChargeStorVoltage(Integer chargeStorVoltage) {
        this.chargeStorVoltage = chargeStorVoltage;
    }

    /**
     * @return chargeStorCurrent
     */
    public Integer getChargeStorCurrent() {
        return chargeStorCurrent;
    }

    /**
     * @param chargeStorCurrent
     */
    public void setChargeStorCurrent(Integer chargeStorCurrent) {
        this.chargeStorCurrent = chargeStorCurrent;
    }

    /**
     * @return batteryCount
     */
    public Integer getBatteryCount() {
        return batteryCount;
    }

    /**
     * @param batteryCount
     */
    public void setBatteryCount(Integer batteryCount) {
        this.batteryCount = batteryCount;
    }

    /**
     * @return batteryNum
     */
    public Integer getBatteryNum() {
        return batteryNum;
    }

    /**
     * @param batteryNum
     */
    public void setBatteryNum(Integer batteryNum) {
        this.batteryNum = batteryNum;
    }

    /**
     * @return frameBatteryCount
     */
    public Integer getFrameBatteryCount() {
        return frameBatteryCount;
    }

    /**
     * @param frameBatteryCount
     */
    public void setFrameBatteryCount(Integer frameBatteryCount) {
        this.frameBatteryCount = frameBatteryCount;
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
     * @return formnum
     */
    public String getFormnum() {
        return formnum;
    }

    /**
     * @param formnum
     */
    public void setFormnum(String formnum) {
        this.formnum = formnum == null ? null : formnum.trim();
    }

    /**
     * @return uploadTime
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * @param uploadTime
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}