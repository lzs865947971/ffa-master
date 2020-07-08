package com.ffa.po;

public class FileVersion {
    private Integer serialNumber;

    private Integer fileId;

    private String fileModifyTime;

    private String fileModifyPersonName;

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

    public String getFileModifyTime() {
        return fileModifyTime;
    }

    public void setFileModifyTime(String fileModifyTime) {
        this.fileModifyTime = fileModifyTime == null ? null : fileModifyTime.trim();
    }

    public String getFileModifyPersonName() {
        return fileModifyPersonName;
    }

    public void setFileModifyPersonName(String fileModifyPersonName) {
        this.fileModifyPersonName = fileModifyPersonName == null ? null : fileModifyPersonName.trim();
    }
}