package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_veh_rawdataresult")
public class TVehRawdataresult extends BaseDto {
    @Id
    private String oid;

    private String vin;

    private String formnum;

    private String commondType;

    private Date uploadTime;

    private Integer retryTime;

    private String result;

    private String respData;

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
     * @return commondType
     */
    public String getCommondType() {
        return commondType;
    }

    /**
     * @param commondType
     */
    public void setCommondType(String commondType) {
        this.commondType = commondType == null ? null : commondType.trim();
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

    /**
     * @return retryTime
     */
    public Integer getRetryTime() {
        return retryTime;
    }

    /**
     * @param retryTime
     */
    public void setRetryTime(Integer retryTime) {
        this.retryTime = retryTime;
    }

    /**
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * @return respData
     */
    public String getRespData() {
        return respData;
    }

    /**
     * @param respData
     */
    public void setRespData(String respData) {
        this.respData = respData == null ? null : respData.trim();
    }
}