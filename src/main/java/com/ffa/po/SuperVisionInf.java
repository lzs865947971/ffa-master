package com.ffa.po;

public class SuperVisionInf {
    private Integer supervisionId;

    private String supervisionName;

    public Integer getSupervisionId() {
        return supervisionId;
    }

    public void setSupervisionId(Integer supervisionId) {
        this.supervisionId = supervisionId;
    }

    public String getSupervisionName() {
        return supervisionName;
    }

    public void setSupervisionName(String supervisionName) {
        this.supervisionName = supervisionName == null ? null : supervisionName.trim();
    }
}