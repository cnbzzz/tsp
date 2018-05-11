package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_veh_limit")
public class TVehLimit extends BaseDto {
    @Id
    private String oid;

    private Integer maxVoltageSubsystemNum;

    private Integer maxVoltagefullCellNum;

    private Integer maxVoltagefullCell;

    private Integer minVoltageSubsystemNum;

    private Integer minVoltagefullCellNum;

    private Integer minVoltagefullCell;

    private Integer maxTemperSubsystemNum;

    private Integer maxTemperProbeNum;

    private Integer maxTemper;

    private Integer minTemperSubsystemNum;

    private Integer minTemperProbeNum;

    private Integer minTemper;

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
     * @return maxVoltageSubsystemNum
     */
    public Integer getMaxVoltageSubsystemNum() {
        return maxVoltageSubsystemNum;
    }

    /**
     * @param maxVoltageSubsystemNum
     */
    public void setMaxVoltageSubsystemNum(Integer maxVoltageSubsystemNum) {
        this.maxVoltageSubsystemNum = maxVoltageSubsystemNum;
    }

    /**
     * @return maxVoltagefullCellNum
     */
    public Integer getMaxVoltagefullCellNum() {
        return maxVoltagefullCellNum;
    }

    /**
     * @param maxVoltagefullCellNum
     */
    public void setMaxVoltagefullCellNum(Integer maxVoltagefullCellNum) {
        this.maxVoltagefullCellNum = maxVoltagefullCellNum;
    }

    /**
     * @return maxVoltagefullCell
     */
    public Integer getMaxVoltagefullCell() {
        return maxVoltagefullCell;
    }

    /**
     * @param maxVoltagefullCell
     */
    public void setMaxVoltagefullCell(Integer maxVoltagefullCell) {
        this.maxVoltagefullCell = maxVoltagefullCell;
    }

    /**
     * @return minVoltageSubsystemNum
     */
    public Integer getMinVoltageSubsystemNum() {
        return minVoltageSubsystemNum;
    }

    /**
     * @param minVoltageSubsystemNum
     */
    public void setMinVoltageSubsystemNum(Integer minVoltageSubsystemNum) {
        this.minVoltageSubsystemNum = minVoltageSubsystemNum;
    }

    /**
     * @return minVoltagefullCellNum
     */
    public Integer getMinVoltagefullCellNum() {
        return minVoltagefullCellNum;
    }

    /**
     * @param minVoltagefullCellNum
     */
    public void setMinVoltagefullCellNum(Integer minVoltagefullCellNum) {
        this.minVoltagefullCellNum = minVoltagefullCellNum;
    }

    /**
     * @return minVoltagefullCell
     */
    public Integer getMinVoltagefullCell() {
        return minVoltagefullCell;
    }

    /**
     * @param minVoltagefullCell
     */
    public void setMinVoltagefullCell(Integer minVoltagefullCell) {
        this.minVoltagefullCell = minVoltagefullCell;
    }

    /**
     * @return maxTemperSubsystemNum
     */
    public Integer getMaxTemperSubsystemNum() {
        return maxTemperSubsystemNum;
    }

    /**
     * @param maxTemperSubsystemNum
     */
    public void setMaxTemperSubsystemNum(Integer maxTemperSubsystemNum) {
        this.maxTemperSubsystemNum = maxTemperSubsystemNum;
    }

    /**
     * @return maxTemperProbeNum
     */
    public Integer getMaxTemperProbeNum() {
        return maxTemperProbeNum;
    }

    /**
     * @param maxTemperProbeNum
     */
    public void setMaxTemperProbeNum(Integer maxTemperProbeNum) {
        this.maxTemperProbeNum = maxTemperProbeNum;
    }

    /**
     * @return maxTemper
     */
    public Integer getMaxTemper() {
        return maxTemper;
    }

    /**
     * @param maxTemper
     */
    public void setMaxTemper(Integer maxTemper) {
        this.maxTemper = maxTemper;
    }

    /**
     * @return minTemperSubsystemNum
     */
    public Integer getMinTemperSubsystemNum() {
        return minTemperSubsystemNum;
    }

    /**
     * @param minTemperSubsystemNum
     */
    public void setMinTemperSubsystemNum(Integer minTemperSubsystemNum) {
        this.minTemperSubsystemNum = minTemperSubsystemNum;
    }

    /**
     * @return minTemperProbeNum
     */
    public Integer getMinTemperProbeNum() {
        return minTemperProbeNum;
    }

    /**
     * @param minTemperProbeNum
     */
    public void setMinTemperProbeNum(Integer minTemperProbeNum) {
        this.minTemperProbeNum = minTemperProbeNum;
    }

    /**
     * @return minTemper
     */
    public Integer getMinTemper() {
        return minTemper;
    }

    /**
     * @param minTemper
     */
    public void setMinTemper(Integer minTemper) {
        this.minTemper = minTemper;
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