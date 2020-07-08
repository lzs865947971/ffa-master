package com.ffa.po;

public class FirePersonInf {
    private Integer firePersonId;

    private Integer fireOrgId;

    private String firePersonName;

    private Integer firePersonPicId;

    private Integer fireRecordId;

    public Integer getFirePersonId() {
        return firePersonId;
    }

    public void setFirePersonId(Integer firePersonId) {
        this.firePersonId = firePersonId;
    }

    public Integer getFireOrgId() {
        return fireOrgId;
    }

    public void setFireOrgId(Integer fireOrgId) {
        this.fireOrgId = fireOrgId;
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

    public Integer getFireRecordId() {
        return fireRecordId;
    }

    public void setFireRecordId(Integer fireRecordId) {
        this.fireRecordId = fireRecordId;
    }
}