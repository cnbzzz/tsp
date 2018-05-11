package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_veh_error")
public class TVehError extends BaseDto {
    @Id
    private String oid;

    private Integer maxErrorLevel;

    private String currencyErrorLevel;

    private Integer fullCellErrorCount;

    private Integer driveMotorErrorCount;

    private Integer engineErrorCount;

    private Integer otherErrorCount;

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
     * @return maxErrorLevel
     */
    public Integer getMaxErrorLevel() {
        return maxErrorLevel;
    }

    /**
     * @param maxErrorLevel
     */
    public void setMaxErrorLevel(Integer maxErrorLevel) {
        this.maxErrorLevel = maxErrorLevel;
    }

    /**
     * @return currencyErrorLevel
     */
    public String getCurrencyErrorLevel() {
        return currencyErrorLevel;
    }

    /**
     * @param currencyErrorLevel
     */
    public void setCurrencyErrorLevel(String currencyErrorLevel) {
        this.currencyErrorLevel = currencyErrorLevel == null ? null : currencyErrorLevel.trim();
    }

    /**
     * @return fullCellErrorCount
     */
    public Integer getFullCellErrorCount() {
        return fullCellErrorCount;
    }

    /**
     * @param fullCellErrorCount
     */
    public void setFullCellErrorCount(Integer fullCellErrorCount) {
        this.fullCellErrorCount = fullCellErrorCount;
    }

    /**
     * @return driveMotorErrorCount
     */
    public Integer getDriveMotorErrorCount() {
        return driveMotorErrorCount;
    }

    /**
     * @param driveMotorErrorCount
     */
    public void setDriveMotorErrorCount(Integer driveMotorErrorCount) {
        this.driveMotorErrorCount = driveMotorErrorCount;
    }

    /**
     * @return engineErrorCount
     */
    public Integer getEngineErrorCount() {
        return engineErrorCount;
    }

    /**
     * @param engineErrorCount
     */
    public void setEngineErrorCount(Integer engineErrorCount) {
        this.engineErrorCount = engineErrorCount;
    }

    /**
     * @return otherErrorCount
     */
    public Integer getOtherErrorCount() {
        return otherErrorCount;
    }

    /**
     * @param otherErrorCount
     */
    public void setOtherErrorCount(Integer otherErrorCount) {
        this.otherErrorCount = otherErrorCount;
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