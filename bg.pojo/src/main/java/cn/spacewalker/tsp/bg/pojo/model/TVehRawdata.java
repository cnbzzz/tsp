package cn.spacewalker.tsp.bg.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_veh_rawdata")
public class TVehRawdata extends BaseDto {
    @Id
    private String oid;

    private String vin;

    private String formnum;

    private Integer commond;

    private Date inputTime;

    private Date uploadTime;

    private byte[] rawData;

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
     * @return commond
     */
    public Integer getCommond() {
        return commond;
    }

    /**
     * @param commond
     */
    public void setCommond(Integer commond) {
        this.commond = commond;
    }

    /**
     * @return inputTime
     */
    public Date getInputTime() {
        return inputTime;
    }

    /**
     * @param inputTime
     */
    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
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
     * @return rawData
     */
    public byte[] getRawData() {
        return rawData;
    }

    /**
     * @param rawData
     */
    public void setRawData(byte[] rawData) {
        this.rawData = rawData;
    }
}