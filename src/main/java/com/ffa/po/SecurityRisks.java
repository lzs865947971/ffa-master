package com.ffa.po;

public class SecurityRisks {
    private Integer riskRegisterId;

    private Integer unitId;

    private String riskTypeId;

    private Integer riskKeyPartId;

    private String unitName;

    private Integer state;

    private String riskKeyPartName;

    public String getRiskKeyPartName() {
        return riskKeyPartName;
    }

    public void setRiskKeyPartName(String riskKeyPartName) {
        this.riskKeyPartName = riskKeyPartName;
    }
//    private KeyPartInf keyPartInf;
//
//    public KeyPartInf getKeyPartInf() {
//        return keyPartInf;
//    }
//
//    public void setKeyPartInf(KeyPartInf keyPartInf) {
//        this.keyPartInf = keyPartInf;
//    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


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

    public String getRiskTypeId() {
        return riskTypeId;
    }

    public void setRiskTypeId(String riskTypeId) {
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
