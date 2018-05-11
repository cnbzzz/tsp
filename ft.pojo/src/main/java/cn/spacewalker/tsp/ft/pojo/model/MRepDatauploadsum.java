package cn.spacewalker.tsp.ft.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "m_rep_datauploadsum")
public class MRepDatauploadsum extends BaseDto {
    @Id
    private String oid;

    private Long currColData;

    private Long totalColData;

    private Long totalUpData;

    private Long succUpData;

    private String calcFormnum;

    private Date calcDate;

    private Date updateTime;

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
     * @return currColData
     */
    public Long getCurrColData() {
        return currColData;
    }

    /**
     * @param currColData
     */
    public void setCurrColData(Long currColData) {
        this.currColData = currColData;
    }

    /**
     * @return totalColData
     */
    public Long getTotalColData() {
        return totalColData;
    }

    /**
     * @param totalColData
     */
    public void setTotalColData(Long totalColData) {
        this.totalColData = totalColData;
    }

    /**
     * @return totalUpData
     */
    public Long getTotalUpData() {
        return totalUpData;
    }

    /**
     * @param totalUpData
     */
    public void setTotalUpData(Long totalUpData) {
        this.totalUpData = totalUpData;
    }

    /**
     * @return succUpData
     */
    public Long getSuccUpData() {
        return succUpData;
    }

    /**
     * @param succUpData
     */
    public void setSuccUpData(Long succUpData) {
        this.succUpData = succUpData;
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
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}