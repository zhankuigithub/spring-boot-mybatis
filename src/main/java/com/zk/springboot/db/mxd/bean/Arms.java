package com.zk.springboot.db.mxd.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Arms implements Serializable {

    @JsonProperty("arms_id")
    private int armsID;

    @JsonProperty("arms_name")
    private String armsName;

    @JsonProperty("insert_dt")
    private String insertDT;

    public Arms(int armsID, String armsName, String insertDT) {
        this.armsID = armsID;
        this.armsName = armsName;
        this.insertDT = insertDT;
    }

    public int getArmsID() {
        return armsID;
    }

    public void setArmsID(int armsID) {
        this.armsID = armsID;
    }

    public String getArmsName() {
        return armsName;
    }

    public void setArmsName(String armsName) {
        this.armsName = armsName;
    }

    public String getInsertDT() {
        return insertDT;
    }

    public void setInsertDT(String insertDT) {
        this.insertDT = insertDT;
    }
}
