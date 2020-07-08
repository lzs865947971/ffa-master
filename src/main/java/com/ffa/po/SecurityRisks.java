package com.ffa.po;

public class SecurityRisks {
    private Integer riskRegisterId;

    private Integer unitId;

    private Integer riskTypeId;

    private Integer riskKeyPartId;

    private String unitName;

    public Integer getRiskRegisterId() {
        return riskRegisterId;
    }

    public void setRiskRegisterId(Integer riskRegisterId) {
        this.riskRegisterId = riskRegisterId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getRiskTypeId() {
        return riskTypeId;
    }

    public void setRiskTypeId(Integer riskTypeId) {
        this.riskTypeId = riskTypeId;
    }

    public Integer getRiskKeyPartId() {
        return riskKeyPartId;
    }

    public void setRiskKeyPartId(Integer riskKeyPartId) {
        this.riskKeyPartId = riskKeyPartId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }
}