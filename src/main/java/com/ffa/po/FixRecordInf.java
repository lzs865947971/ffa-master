package com.ffa.po;

public class FixRecordInf {
    private Integer serialNumber;

    private Integer facilityId;

    private String facilityName;

    private Integer unitId;

    private String unitName;

    private String fixTime;

    private Integer fixState;

    private Integer facilityState;

    public Integer getFacilityState(){
        return facilityState;
    }

    public void setFacilityState(Integer facilityState){
        this.facilityState = facilityState;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

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
