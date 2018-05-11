package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_veh_drivemotor")
public class TVehDrivemotor extends BaseDto {
    @Id
    private String oid;

    private Integer driveMotorCount;

    private Integer driveMotorIndex;

    private Integer driveMotorNum;

    private Integer driveMotorStatus;

    private Integer driveMotorCtrlTemper;

    private Integer driveMotorSpeed;

    private Integer driveMotorTorque;

    private Integer driveMotorTemper;

    private Integer driveMotorInputVoltage;

    private Integer driveMotorCurrent;

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
     * @return driveMotorCount
     */
    public Integer getDriveMotorCount() {
        return driveMotorCount;
    }

    /**
     * @param driveMotorCount
     */
    public void setDriveMotorCount(Integer driveMotorCount) {
        this.driveMotorCount = driveMotorCount;
    }

    /**
     * @return driveMotorIndex
     */
    public Integer getDriveMotorIndex() {
        return driveMotorIndex;
    }

    /**
     * @param driveMotorIndex
     */
    public void setDriveMotorIndex(Integer driveMotorIndex) {
        this.driveMotorIndex = driveMotorIndex;
    }

    /**
     * @return driveMotorNum
     */
    public Integer getDriveMotorNum() {
        return driveMotorNum;
    }

    /**
     * @param driveMotorNum
     */
    public void setDriveMotorNum(Integer driveMotorNum) {
        this.driveMotorNum = driveMotorNum;
    }

    /**
     * @return driveMotorStatus
     */
    public Integer getDriveMotorStatus() {
        return driveMotorStatus;
    }

    /**
     * @param driveMotorStatus
     */
    public void setDriveMotorStatus(Integer driveMotorStatus) {
        this.driveMotorStatus = driveMotorStatus;
    }

    /**
     * @return driveMotorCtrlTemper
     */
    public Integer getDriveMotorCtrlTemper() {
        return driveMotorCtrlTemper;
    }

    /**
     * @param driveMotorCtrlTemper
     */
    public void setDriveMotorCtrlTemper(Integer driveMotorCtrlTemper) {
        this.driveMotorCtrlTemper = driveMotorCtrlTemper;
    }

    /**
     * @return driveMotorSpeed
     */
    public Integer getDriveMotorSpeed() {
        return driveMotorSpeed;
    }

    /**
     * @param driveMotorSpeed
     */
    public void setDriveMotorSpeed(Integer driveMotorSpeed) {
        this.driveMotorSpeed = driveMotorSpeed;
    }

    /**
     * @return driveMotorTorque
     */
    public Integer getDriveMotorTorque() {
        return driveMotorTorque;
    }

    /**
     * @param driveMotorTorque
     */
    public void setDriveMotorTorque(Integer driveMotorTorque) {
        this.driveMotorTorque = driveMotorTorque;
    }

    /**
     * @return driveMotorTemper
     */
    public Integer getDriveMotorTemper() {
        return driveMotorTemper;
    }

    /**
     * @param driveMotorTemper
     */
    public void setDriveMotorTemper(Integer driveMotorTemper) {
        this.driveMotorTemper = driveMotorTemper;
    }

    /**
     * @return driveMotorInputVoltage
     */
    public Integer getDriveMotorInputVoltage() {
        return driveMotorInputVoltage;
    }

    /**
     * @param driveMotorInputVoltage
     */
    public void setDriveMotorInputVoltage(Integer driveMotorInputVoltage) {
        this.driveMotorInputVoltage = driveMotorInputVoltage;
    }

    /**
     * @return driveMotorCurrent
     */
    public Integer getDriveMotorCurrent() {
        return driveMotorCurrent;
    }

    /**
     * @param driveMotorCurrent
     */
    public void setDriveMotorCurrent(Integer driveMotorCurrent) {
        this.driveMotorCurrent = driveMotorCurrent;
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