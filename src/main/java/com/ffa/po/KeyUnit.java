package com.ffa.po;

public class KeyUnit {
    private Integer unitid;

    private String unitname;

    private Integer principalid;

    private String principalname;

    private String unitAddress;

    private String unitTel;

    private Integer supervisionId;

    private Integer overallPictureId;

    private Integer facilitiyId;

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public Integer getPrincipalid() {
        return principalid;
    }

    public void setPrincipalid(Integer principalid) {
        this.principalid = principalid;
    }

    public String getPrincipalname() {
        return principalname;
    }

    public void setPrincipalname(String principalname) {
        this.principalname = principalname == null ? null : principalname.trim();
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

    public Integer getFacilitiyId() {
        return facilitiyId;
    }

    public void setFacilitiyId(Integer facilitiyId) {
        this.facilitiyId = facilitiyId;
    }
}