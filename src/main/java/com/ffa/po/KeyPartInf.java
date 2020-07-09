package com.ffa.po;

public class KeyPartInf {
    private Integer keyPartId;

    private Integer unitId;

    private String unitName;

    private String keyPartName;

    private Integer keyPartPicId;

    public Integer getKeyPartId() {
        return keyPartId;
    }

    public void setKeyPartId(Integer keyPartId) {
        this.keyPartId = keyPartId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getKeyPartName() {
        return keyPartName;
    }

    public void setKeyPartName(String keyPartName) {
        this.keyPartName = keyPartName == null ? null : keyPartName.trim();
    }

    public Integer getKeyPartPicId() {
        return keyPartPicId;
    }

    public void setKeyPartPicId(Integer keyPartPicId) {
        this.keyPartPicId = keyPartPicId;
    }
}