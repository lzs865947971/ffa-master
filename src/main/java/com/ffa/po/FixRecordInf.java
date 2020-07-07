package com.ffa.po;

public class FixRecordInf {
    private Integer facilityId;

    private String facilityName;

    private Integer unitid;

    private String fixTime;

    private Integer fixState;

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName == null ? null : facilityName.trim();
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getFixTime() {
        return fixTime;
    }

    public void setFixTime(String fixTime) {
        this.fixTime = fixTime == null ? null : fixTime.trim();
    }

    public Integer getFixState() {
        return fixState;
    }

    public void setFixState(Integer fixState) {
        this.fixState = fixState;
    }
}