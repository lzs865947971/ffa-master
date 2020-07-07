package com.ffa.po;

public class SecurityRisks {
    private Integer unitid;

    private Integer riskRegisterId;

    private Integer riskTypeId;

    private Integer riskKeyPartId;

    private String unitname;

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public Integer getRiskRegisterId() {
        return riskRegisterId;
    }

    public void setRiskRegisterId(Integer riskRegisterId) {
        this.riskRegisterId = riskRegisterId;
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

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }
}