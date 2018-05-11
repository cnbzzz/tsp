package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_platform_signin")
public class TPlatformSignin extends BaseDto {
    @Id
    private String oid;

    private String signInTime;

    private Integer signInFormNum;

    private String userName;

    private String passwd;

    private Integer encRule;

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
     * @return signInTime
     */
    public String getSignInTime() {
        return signInTime;
    }

    /**
     * @param signInTime
     */
    public void setSignInTime(String signInTime) {
        this.signInTime = signInTime == null ? null : signInTime.trim();
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
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    /**
     * @return encRule
     */
    public Integer getEncRule() {
        return encRule;
    }

    /**
     * @param encRule
     */
    public void setEncRule(Integer encRule) {
        this.encRule = encRule;
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