package com.example.hr_thema.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProcessRequest {
    @SerializedName("Previews")
    @Expose
    private List<Preview> previews = null;
    @SerializedName("State")
    @Expose
    private Integer state;
    @SerializedName("RequestId")
    @Expose
    private Integer requestId;
    @SerializedName("RequestNumber")
    @Expose
    private String requestNumber;
    @SerializedName("Creator")
    @Expose
    private String creator;
    @SerializedName("LastUpdate")
    @Expose
    private String lastUpdate;
    @SerializedName("WorkflowType")
    @Expose
    private Integer workflowType;
    @SerializedName("EntityId")
    @Expose
    private Integer entityId;
    @SerializedName("CreatedDate")
    @Expose
    private String createdDate;

    public List<Preview> getPreviews() {
        return previews;
    }

    public void setPreviews(List<Preview> previews) {
        this.previews = previews;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getWorkflowType() {
        return workflowType;
    }

    public void setWorkflowType(Integer workflowType) {
        this.workflowType = workflowType;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
