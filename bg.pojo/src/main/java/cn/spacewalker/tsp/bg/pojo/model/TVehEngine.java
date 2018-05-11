package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_veh_engine")
public class TVehEngine extends BaseDto {
    @Id
    private String oid;

    private Integer engineStatus;

    private Integer crankshaftSpeed;

    private Integer fuelCellPower;

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
     * @return engineStatus
     */
    public Integer getEngineStatus() {
        return engineStatus;
    }

    /**
     * @param engineStatus
     */
    public void setEngineStatus(Integer engineStatus) {
        this.engineStatus = engineStatus;
    }

    /**
     * @return crankshaftSpeed
     */
    public Integer getCrankshaftSpeed() {
        return crankshaftSpeed;
    }

    /**
     * @param crankshaftSpeed
     */
    public void setCrankshaftSpeed(Integer crankshaftSpeed) {
        this.crankshaftSpeed = crankshaftSpeed;
    }

    /**
     * @return fuelCellPower
     */
    public Integer getFuelCellPower() {
        return fuelCellPower;
    }

    /**
     * @param fuelCellPower
     */
    public void setFuelCellPower(Integer fuelCellPower) {
        this.fuelCellPower = fuelCellPower;
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