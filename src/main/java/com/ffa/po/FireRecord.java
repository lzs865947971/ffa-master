package com.ffa.po;

public class FireRecord {
    private Integer fireId;

    private String unitname;

    private Integer unitid;

    private String fireName;

    private String fireTime;

    private Integer fireCost;

    private Integer deathNum;

    private Integer injuredNum;

    private String fireRecordPersonName;

    private String description;

    public Integer getFireId() {
        return fireId;
    }

    public void setFireId(Integer fireId) {
        this.fireId = fireId;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getFireName() {
        return fireName;
    }

    public void setFireName(String fireName) {
        this.fireName = fireName == null ? null : fireName.trim();
    }

    public String getFireTime() {
        return fireTime;
    }

    public void setFireTime(String fireTime) {
        this.fireTime = fireTime == null ? null : fireTime.trim();
    }

    public Integer getFireCost() {
        return fireCost;
    }

    public void setFireCost(Integer fireCost) {
        this.fireCost = fireCost;
    }

    public Integer getDeathNum() {
        return deathNum;
    }

    public void setDeathNum(Integer deathNum) {
        this.deathNum = deathNum;
    }

    public Integer getInjuredNum() {
        return injuredNum;
    }

    public void setInjuredNum(Integer injuredNum) {
        this.injuredNum = injuredNum;
    }

    public String getFireRecordPersonName() {
        return fireRecordPersonName;
    }

    public void setFireRecordPersonName(String fireRecordPersonName) {
        this.fireRecordPersonName = fireRecordPersonName == null ? null : fireRecordPersonName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}