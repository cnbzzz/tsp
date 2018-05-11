package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_platform_signout")
public class TPlatformSignout extends BaseDto {
    @Id
    private String oid;

    private String signOutTime;

    private Integer signOutFormNum;

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
     * @return signOutTime
     */
    public String getSignOutTime() {
        return signOutTime;
    }

    /**
     * @param signOutTime
     */
    public void setSignOutTime(String signOutTime) {
        this.signOutTime = signOutTime == null ? null : signOutTime.trim();
    }

    /**
     * @return signOutFormNum
     */
    public Integer getSignOutFormNum() {
        return signOutFormNum;
    }

    /**
     * @param signOutFormNum
     */
    public void setSignOutFormNum(Integer signOutFormNum) {
        this.signOutFormNum = signOutFormNum;
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