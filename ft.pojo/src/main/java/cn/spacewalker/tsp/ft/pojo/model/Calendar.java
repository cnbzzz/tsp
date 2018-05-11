package cn.spacewalker.tsp.ft.pojo.model;

import cn.spacewalker.tsp.common.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

public class Calendar extends BaseDto {
    private Date datelist;

    /**
     * @return datelist
     */
    public Date getDatelist() {
        return datelist;
    }

    /**
     * @param datelist
     */
    public void setDatelist(Date datelist) {
        this.datelist = datelist;
    }
}