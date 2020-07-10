package com.ffa.po;

public class KeyUnit {
    private Integer unitId;

    private String unitName;

    private Integer principalId;

    private String principalName;

    private String unitAddress;

    private String unitTel;

    private Integer supervisionId;

    private Integer overallPictureId;

    private Integer facilitiyNum;

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

    public Integer getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(Integer principalId) {
        this.principalId = principalId;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName == null ? null : principalName.trim();
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress == null ? null : unitAddress.trim();
    }

    public String getUnitTel() {
        return unitTel;
    }

    public void setUnitTel(String unitTel) {
        this.unitTel = unitTel == null ? null : unitTel.trim();
    }

    public Integer getSupervisionId() {
        return supervisionId;
    }

    public void setSupervisionId(Integer supervisionId) {
        this.supervisionId = supervisionId;
    }

    public Integer getOverallPictureId() {
        return overallPictureId;
    }

    public void setOverallPictureId(Integer overallPictureId) {
        this.overallPictureId = overallPictureId;
    }

    public Integer getFacilitiyNum() {
        return facilitiyNum;
    }

    public void setFacilitiyNum(Integer facilitiyNum) {
        this.facilitiyNum = facilitiyNum;
    }
}
