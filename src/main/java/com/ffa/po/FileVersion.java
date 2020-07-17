package com.ffa.po;

import java.util.Date;

public class FileVersion {
    private Integer serialNumber;

    private Integer fileId;

    private Date fileModifyTime;

    private String fileModifyPersonName;

    private String perfile;

    private String nowfile;

    private Date lastFixTime;

    private Date createTime;

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Date getFileModifyTime() {
        return fileModifyTime;
    }

    public void setFileModifyTime(Date fileModifyTime) {
        this.fileModifyTime = fileModifyTime;
    }

    public String getFileModifyPersonName() {
        return fileModifyPersonName;
    }

    public void setFileModifyPersonName(String fileModifyPersonName) {
        this.fileModifyPersonName = fileModifyPersonName == null ? null : fileModifyPersonName.trim();
    }

    public String getPerfile() {
        return perfile;
    }

    public void setPerfile(String perfile) {
        this.perfile = perfile == null ? null : perfile.trim();
    }

    public String getNowfile() {
        return nowfile;
    }

    public void setNowfile(String nowfile) {
        this.nowfile = nowfile == null ? null : nowfile.trim();
    }

    public Date getLastFixTime() {
        return lastFixTime;
    }

    public void setLastFixTime(Date lastFixTime) {
        this.lastFixTime = lastFixTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}