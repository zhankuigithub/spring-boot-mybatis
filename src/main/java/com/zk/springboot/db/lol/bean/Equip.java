package com.zk.springboot.db.lol.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Equip implements Serializable {

    @JsonProperty("equip_id")
    private int equipID;

    @JsonProperty("equip_name")
    private String equipName;

    @JsonProperty("insert_dt")
    private String insertDT;


    public int getEquipID() {
        return equipID;
    }

    public void setEquipID(int equipID) {
        this.equipID = equipID;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getInsertDT() {
        return insertDT;
    }

    public void setInsertDT(String insertDT) {
        this.insertDT = insertDT;
    }
}
