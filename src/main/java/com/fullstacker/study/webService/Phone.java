package com.fullstacker.study.webService;

import java.util.Date;

/**
 * @description:
 * @time: 2021/4/14 18:39
 */
public class Phone {

    private String name;

    private String produce;

    private Date  time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
