package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_veh_data")
public class TVehData extends BaseDto {
    @Id
    private String oid;

    private Integer vehStatus;

    private Integer chargeStatus;

    private Integer runMode;

    private Integer speed;

    private Long accMile;

    private Integer totalVoltage;

    private Integer totalCurrent;

    private Integer soc;

    private Integer dcStatus;

    private Integer gear;

    private Integer insRes;

    private Integer blank;

    private Integer accePedalVal;

    private Integer brakePedalStatus;

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
     * @return vehStatus
     */
    public Integer getVehStatus() {
        return vehStatus;
    }

    /**
     * @param vehStatus
     */
    public void setVehStatus(Integer vehStatus) {
        this.vehStatus = vehStatus;
    }

    /**
     * @return chargeStatus
     */
    public Integer getChargeStatus() {
        return chargeStatus;
    }

    /**
     * @param chargeStatus
     */
    public void setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
    }

    /**
     * @return runMode
     */
    public Integer getRunMode() {
        return runMode;
    }

    /**
     * @param runMode
     */
    public void setRunMode(Integer runMode) {
        this.runMode = runMode;
    }

    /**
     * @return speed
     */
    public Integer getSpeed() {
        return speed;
    }

    /**
     * @param speed
     */
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    /**
     * @return accMile
     */
    public Long getAccMile() {
        return accMile;
    }

    /**
     * @param accMile
     */
    public void setAccMile(Long accMile) {
        this.accMile = accMile;
    }

    /**
     * @return totalVoltage
     */
    public Integer getTotalVoltage() {
        return totalVoltage;
    }

    /**
     * @param totalVoltage
     */
    public void setTotalVoltage(Integer totalVoltage) {
        this.totalVoltage = totalVoltage;
    }

    /**
     * @return totalCurrent
     */
    public Integer getTotalCurrent() {
        return totalCurrent;
    }

    /**
     * @param totalCurrent
     */
    public void setTotalCurrent(Integer totalCurrent) {
        this.totalCurrent = totalCurrent;
    }

    /**
     * @return soc
     */
    public Integer getSoc() {
        return soc;
    }

    /**
     * @param soc
     */
    public void setSoc(Integer soc) {
        this.soc = soc;
    }

    /**
     * @return dcStatus
     */
    public Integer getDcStatus() {
        return dcStatus;
    }

    /**
     * @param dcStatus
     */
    public void setDcStatus(Integer dcStatus) {
        this.dcStatus = dcStatus;
    }

    /**
     * @return gear
     */
    public Integer getGear() {
        return gear;
    }

    /**
     * @param gear
     */
    public void setGear(Integer gear) {
        this.gear = gear;
    }

    /**
     * @return insRes
     */
    public Integer getInsRes() {
        return insRes;
    }

    /**
     * @param insRes
     */
    public void setInsRes(Integer insRes) {
        this.insRes = insRes;
    }

    /**
     * @return blank
     */
    public Integer getBlank() {
        return blank;
    }

    /**
     * @param blank
     */
    public void setBlank(Integer blank) {
        this.blank = blank;
    }

    /**
     * @return accePedalVal
     */
    public Integer getAccePedalVal() {
        return accePedalVal;
    }

    /**
     * @param accePedalVal
     */
    public void setAccePedalVal(Integer accePedalVal) {
        this.accePedalVal = accePedalVal;
    }

    /**
     * @return brakePedalStatus
     */
    public Integer getBrakePedalStatus() {
        return brakePedalStatus;
    }

    /**
     * @param brakePedalStatus
     */
    public void setBrakePedalStatus(Integer brakePedalStatus) {
        this.brakePedalStatus = brakePedalStatus;
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