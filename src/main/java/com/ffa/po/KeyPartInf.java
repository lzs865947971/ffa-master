package com.ffa.po;

public class KeyPartInf {
    private Integer keyPartId;

    private Integer unitid;

    private String keyPartName;

    private Integer keyPartPicId;

    public Integer getKeyPartId() {
        return keyPartId;
    }

    public void setKeyPartId(Integer keyPartId) {
        this.keyPartId = keyPartId;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
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