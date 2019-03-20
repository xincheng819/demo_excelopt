package com.nhnchina.demoexcelopt.model;

import java.io.Serializable;

public class DeptIncomeModel implements Serializable {

    private static final long serialVersionUID = 3406040194315271580L;

    private String orderJobNo;
    private String taskNo;
    private String subTaskSeq;
    private String taskNm;
    private String uprSubTaskSeq;
    private String taskLevel;
    private String userNm;
    private String userId;
    private String tmData;
    private String cntData;
    private String ymd;
    private String userOrgId;

    public String getOrderJobNo() {
        return orderJobNo;
    }

    public void setOrderJobNo(String orderJobNo) {
        this.orderJobNo = orderJobNo;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getSubTaskSeq() {
        return subTaskSeq;
    }

    public void setSubTaskSeq(String subTaskSeq) {
        this.subTaskSeq = subTaskSeq;
    }

    public String getTaskNm() {
        return taskNm;
    }

    public void setTaskNm(String taskNm) {
        this.taskNm = taskNm;
    }

    public String getUprSubTaskSeq() {
        return uprSubTaskSeq;
    }

    public void setUprSubTaskSeq(String uprSubTaskSeq) {
        this.uprSubTaskSeq = uprSubTaskSeq;
    }

    public String getTaskLevel() {
        return taskLevel;
    }

    public void setTaskLevel(String taskLevel) {
        this.taskLevel = taskLevel;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTmData() {
        return tmData;
    }

    public void setTmData(String tmData) {
        this.tmData = tmData;
    }

    public String getCntData() {
        return cntData;
    }

    public void setCntData(String cntData) {
        this.cntData = cntData;
    }

    public String getYmd() {
        return ymd;
    }

    public void setYmd(String ymd) {
        this.ymd = ymd;
    }

    public String getUserOrgId() {
        return userOrgId;
    }

    public void setUserOrgId(String userOrgId) {
        this.userOrgId = userOrgId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cntData == null) ? 0 : cntData.hashCode());
        result = prime * result
                + ((orderJobNo == null) ? 0 : orderJobNo.hashCode());
        result = prime * result
                + ((subTaskSeq == null) ? 0 : subTaskSeq.hashCode());
        result = prime * result
                + ((taskLevel == null) ? 0 : taskLevel.hashCode());
        result = prime * result + ((taskNm == null) ? 0 : taskNm.hashCode());
        result = prime * result + ((taskNo == null) ? 0 : taskNo.hashCode());
        result = prime * result + ((tmData == null) ? 0 : tmData.hashCode());
        result = prime * result
                + ((uprSubTaskSeq == null) ? 0 : uprSubTaskSeq.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((userNm == null) ? 0 : userNm.hashCode());
        result = prime * result
                + ((userOrgId == null) ? 0 : userOrgId.hashCode());
        result = prime * result + ((ymd == null) ? 0 : ymd.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeptIncomeModel other = (DeptIncomeModel) obj;
        if (cntData == null) {
            if (other.cntData != null)
                return false;
        } else if (!cntData.equals(other.cntData))
            return false;
        if (orderJobNo == null) {
            if (other.orderJobNo != null)
                return false;
        } else if (!orderJobNo.equals(other.orderJobNo))
            return false;
        if (subTaskSeq == null) {
            if (other.subTaskSeq != null)
                return false;
        } else if (!subTaskSeq.equals(other.subTaskSeq))
            return false;
        if (taskLevel == null) {
            if (other.taskLevel != null)
                return false;
        } else if (!taskLevel.equals(other.taskLevel))
            return false;
        if (taskNm == null) {
            if (other.taskNm != null)
                return false;
        } else if (!taskNm.equals(other.taskNm))
            return false;
        if (taskNo == null) {
            if (other.taskNo != null)
                return false;
        } else if (!taskNo.equals(other.taskNo))
            return false;
        if (tmData == null) {
            if (other.tmData != null)
                return false;
        } else if (!tmData.equals(other.tmData))
            return false;
        if (uprSubTaskSeq == null) {
            if (other.uprSubTaskSeq != null)
                return false;
        } else if (!uprSubTaskSeq.equals(other.uprSubTaskSeq))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (userNm == null) {
            if (other.userNm != null)
                return false;
        } else if (!userNm.equals(other.userNm))
            return false;
        if (userOrgId == null) {
            if (other.userOrgId != null)
                return false;
        } else if (!userOrgId.equals(other.userOrgId))
            return false;
        if (ymd == null) {
            if (other.ymd != null)
                return false;
        } else if (!ymd.equals(other.ymd))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DeptIncomeModel [orderJobNo=" + orderJobNo + ", taskNo="
                + taskNo + ", subTaskSeq=" + subTaskSeq + ", taskNm=" + taskNm
                + ", uprSubTaskSeq=" + uprSubTaskSeq + ", taskLevel="
                + taskLevel + ", userNm=" + userNm + ", userId=" + userId
                + ", tmData=" + tmData + ", cntData=" + cntData + ", ymd="
                + ymd + ", userOrgId=" + userOrgId + "]";
    }


}
