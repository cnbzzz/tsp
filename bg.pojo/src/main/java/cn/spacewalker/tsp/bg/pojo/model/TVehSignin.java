package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_veh_signin")
public class TVehSignin extends BaseDto {
    @Id
    private String oid;

    private String gatherTime;

    private Integer signInFormNum;

    private String iccid;

    private Integer chargeNum;

    private Integer systemCodeLength;

    private String systemCode;

    private String vin;

    private String formNum;

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

    /**
     * @return signInFormNum
     */
    public Integer getSignInFormNum() {
        return signInFormNum;
    }

    /**
     * @param signInFormNum
     */
    public void setSignInFormNum(Integer signInFormNum) {
        this.signInFormNum = signInFormNum;
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
     * @return chargeNum
     */
    public Integer getChargeNum() {
        return chargeNum;
    }

    /**
     * @param chargeNum
     */
    public void setChargeNum(Integer chargeNum) {
        this.chargeNum = chargeNum;
    }

    /**
     * @return systemCodeLength
     */
    public Integer getSystemCodeLength() {
        return systemCodeLength;
    }

    /**
     * @param systemCodeLength
     */
    public void setSystemCodeLength(Integer systemCodeLength) {
        this.systemCodeLength = systemCodeLength;
    }

    /**
     * @return systemCode
     */
    public String getSystemCode() {
        return systemCode;
    }

    /**
     * @param systemCode
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode == null ? null : systemCode.trim();
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
     * @return formNum
     */
    public String getFormNum() {
        return formNum;
    }

    /**
     * @param formNum
     */
    public void setFormNum(String formNum) {
        this.formNum = formNum == null ? null : formNum.trim();
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