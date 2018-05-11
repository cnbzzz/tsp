package cn.spacewalker.tsp.ft.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "m_rep_vehinfo")
public class MRepVehinfo extends BaseDto {
    @Id
    private String oid;

    private String iccid;

    private String vin;

    private String model;

    private String termCode;

    private String vehId;

    private Long accMile;

    private Long driveTimes;

    private Long speed;

    private String engineStatus;

    private Long crankshaftSpeed;

    private Long driveMotorSpeed;

    private Long soc;

    private Long fuelCellVoltage;

    private Long fuelCellCurrent;

    private Long fuelCellProbeTemper;

    private Long hydMaxConc;

    private String dcStatus;

    private String currencyErrorLevel;

    private Long charingError;

    private Long driveMotorError;

    private Long engineError;

    private Long otherError;

    private String longitude;

    private String latitude;

    private String city;

    private String region;

    private String vehStatus;

    private String batteryStatus;

    private String status;

    private String calcFormnum;

    private Date lastUpTime;

    private Date createDate;

    private Date calcDate;

    private String gatherTime;

    private String driveMotorCtrlTemper;

    private String driveMotorTemper;

    public String getDriveMotorCtrlTemper() {
        return driveMotorCtrlTemper;
    }

    public void setDriveMotorCtrlTemper(String driveMotorCtrlTemper) {
        this.driveMotorCtrlTemper = driveMotorCtrlTemper;
    }

    public String getDriveMotorTemper() {
        return driveMotorTemper;
    }

    public void setDriveMotorTemper(String driveMotorTemper) {
        this.driveMotorTemper = driveMotorTemper;
    }

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
     * @return iccid
     */
    public String getIccid() {
        return iccid;
    }

    /**
     * @param iccid
     */
    public void setIccid(String iccid) {
        this.iccid = iccid == null ? null : iccid.trim();
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
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * @return termCode
     */
    public String getTermCode() {
        return termCode;
    }

    /**
     * @param termCode
     */
    public void setTermCode(String termCode) {
        this.termCode = termCode == null ? null : termCode.trim();
    }

    /**
     * @return vehId
     */
    public String getVehId() {
        return vehId;
    }

    /**
     * @param vehId
     */
    public void setVehId(String vehId) {
        this.vehId = vehId == null ? null : vehId.trim();
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
     * @return driveTimes
     */
    public Long getDriveTimes() {
        return driveTimes;
    }

    /**
     * @param driveTimes
     */
    public void setDriveTimes(Long driveTimes) {
        this.driveTimes = driveTimes;
    }

    /**
     * @return speed
     */
    public Long getSpeed() {
        return speed;
    }

    /**
     * @param speed
     */
    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    /**
     * @return engineStatus
     */
    public String getEngineStatus() {
        return engineStatus;
    }

    /**
     * @param engineStatus
     */
    public void setEngineStatus(String engineStatus) {
        this.engineStatus = engineStatus == null ? null : engineStatus.trim();
    }

    /**
     * @return crankshaftSpeed
     */
    public Long getCrankshaftSpeed() {
        return crankshaftSpeed;
    }

    /**
     * @param crankshaftSpeed
     */
    public void setCrankshaftSpeed(Long crankshaftSpeed) {
        this.crankshaftSpeed = crankshaftSpeed;
    }

    /**
     * @return driveMotorSpeed
     */
    public Long getDriveMotorSpeed() {
        return driveMotorSpeed;
    }

    /**
     * @param driveMotorSpeed
     */
    public void setDriveMotorSpeed(Long driveMotorSpeed) {
        this.driveMotorSpeed = driveMotorSpeed;
    }

    /**
     * @return soc
     */
    public Long getSoc() {
        return soc;
    }

    /**
     * @param soc
     */
    public void setSoc(Long soc) {
        this.soc = soc;
    }

    /**
     * @return fuelCellVoltage
     */
    public Long getFuelCellVoltage() {
        return fuelCellVoltage;
    }

    /**
     * @param fuelCellVoltage
     */
    public void setFuelCellVoltage(Long fuelCellVoltage) {
        this.fuelCellVoltage = fuelCellVoltage;
    }

    /**
     * @return fuelCellCurrent
     */
    public Long getFuelCellCurrent() {
        return fuelCellCurrent;
    }

    /**
     * @param fuelCellCurrent
     */
    public void setFuelCellCurrent(Long fuelCellCurrent) {
        this.fuelCellCurrent = fuelCellCurrent;
    }

    /**
     * @return fuelCellProbeTemper
     */
    public Long getFuelCellProbeTemper() {
        return fuelCellProbeTemper;
    }

    /**
     * @param fuelCellProbeTemper
     */
    public void setFuelCellProbeTemper(Long fuelCellProbeTemper) {
        this.fuelCellProbeTemper = fuelCellProbeTemper;
    }

    /**
     * @return hydMaxConc
     */
    public Long getHydMaxConc() {
        return hydMaxConc;
    }

    /**
     * @param hydMaxConc
     */
    public void setHydMaxConc(Long hydMaxConc) {
        this.hydMaxConc = hydMaxConc;
    }

    /**
     * @return dcStatus
     */
    public String getDcStatus() {
        return dcStatus;
    }

    /**
     * @param dcStatus
     */
    public void setDcStatus(String dcStatus) {
        this.dcStatus = dcStatus == null ? null : dcStatus.trim();
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
     * @return charingError
     */
    public Long getCharingError() {
        return charingError;
    }

    /**
     * @param charingError
     */
    public void setCharingError(Long charingError) {
        this.charingError = charingError;
    }

    /**
     * @return driveMotorError
     */
    public Long getDriveMotorError() {
        return driveMotorError;
    }

    /**
     * @param driveMotorError
     */
    public void setDriveMotorError(Long driveMotorError) {
        this.driveMotorError = driveMotorError;
    }

    /**
     * @return engineError
     */
    public Long getEngineError() {
        return engineError;
    }

    /**
     * @param engineError
     */
    public void setEngineError(Long engineError) {
        this.engineError = engineError;
    }

    /**
     * @return otherError
     */
    public Long getOtherError() {
        return otherError;
    }

    /**
     * @param otherError
     */
    public void setOtherError(Long otherError) {
        this.otherError = otherError;
    }

    /**
     * @return longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * @return vehStatus
     */
    public String getVehStatus() {
        return vehStatus;
    }

    /**
     * @param vehStatus
     */
    public void setVehStatus(String vehStatus) {
        this.vehStatus = vehStatus == null ? null : vehStatus.trim();
    }

    /**
     * @return batteryStatus
     */
    public String getBatteryStatus() {
        return batteryStatus;
    }

    /**
     * @param batteryStatus
     */
    public void setBatteryStatus(String batteryStatus) {
        this.batteryStatus = batteryStatus == null ? null : batteryStatus.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * @return lastUpTime
     */
    public Date getLastUpTime() {
        return lastUpTime;
    }

    /**
     * @param lastUpTime
     */
    public void setLastUpTime(Date lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    /**
     * @return createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
     * @return gatherTime
     */
    public String getGatherTime() {
        return gatherTime;
    }

    /**
     * @param gatherTime
     */
    public void setGatherTime(String gatherTime) {
        this.gatherTime = gatherTime == null ? null : gatherTime.trim();
    }
}