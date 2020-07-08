package com.ffa.po;

public class FireRecord {
    private Integer fireId;

    private String unitName;

    private Integer unitId;

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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
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