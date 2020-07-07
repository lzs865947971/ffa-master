package com.ffa.po;

public class FireOrgInf {
    private Integer fireOrgId;

    private Integer unitid;

    private String fireOrgName;

    private Integer fireOrgTypeId;

    private String fireOrgTypeName;

    private String fireOrgDate;

    private String fireOrgRegister;

    private String note;

    public Integer getFireOrgId() {
        return fireOrgId;
    }

    public void setFireOrgId(Integer fireOrgId) {
        this.fireOrgId = fireOrgId;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getFireOrgName() {
        return fireOrgName;
    }

    public void setFireOrgName(String fireOrgName) {
        this.fireOrgName = fireOrgName == null ? null : fireOrgName.trim();
    }

    public Integer getFireOrgTypeId() {
        return fireOrgTypeId;
    }

    public void setFireOrgTypeId(Integer fireOrgTypeId) {
        this.fireOrgTypeId = fireOrgTypeId;
    }

    public String getFireOrgTypeName() {
        return fireOrgTypeName;
    }

    public void setFireOrgTypeName(String fireOrgTypeName) {
        this.fireOrgTypeName = fireOrgTypeName == null ? null : fireOrgTypeName.trim();
    }

    public String getFireOrgDate() {
        return fireOrgDate;
    }

    public void setFireOrgDate(String fireOrgDate) {
        this.fireOrgDate = fireOrgDate == null ? null : fireOrgDate.trim();
    }

    public String getFireOrgRegister() {
        return fireOrgRegister;
    }

    public void setFireOrgRegister(String fireOrgRegister) {
        this.fireOrgRegister = fireOrgRegister == null ? null : fireOrgRegister.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}