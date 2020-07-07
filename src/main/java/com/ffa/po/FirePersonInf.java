package com.ffa.po;

public class FirePersonInf {
    private Integer firePersonId;

    private Integer unitid;

    private String firePersonName;

    private Integer firePersonPicId;

    public Integer getFirePersonId() {
        return firePersonId;
    }

    public void setFirePersonId(Integer firePersonId) {
        this.firePersonId = firePersonId;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getFirePersonName() {
        return firePersonName;
    }

    public void setFirePersonName(String firePersonName) {
        this.firePersonName = firePersonName == null ? null : firePersonName.trim();
    }

    public Integer getFirePersonPicId() {
        return firePersonPicId;
    }

    public void setFirePersonPicId(Integer firePersonPicId) {
        this.firePersonPicId = firePersonPicId;
    }
}