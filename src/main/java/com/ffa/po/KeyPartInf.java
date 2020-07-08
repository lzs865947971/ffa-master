package com.ffa.po;

public class KeyPartInf {
    private Integer keyPartId;

    private Integer unitId;

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