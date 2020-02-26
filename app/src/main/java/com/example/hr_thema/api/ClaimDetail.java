package com.example.hr_thema.api;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ClaimDetail {
    @SerializedName("Issuer")
    @Expose
    private String issuer;
    @SerializedName("OriginalIssuer")
    @Expose
    private String originalIssuer;
    @SerializedName("Properties")
    @Expose
    private Proporties properties;
    @SerializedName("Subject")
    @Expose
    private Object subject;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Value")
    @Expose
    private String value;
    @SerializedName("ValueType")
    @Expose
    private String valueType;

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getOriginalIssuer() {
        return originalIssuer;
    }

    public void setOriginalIssuer(String originalIssuer) {
        this.originalIssuer = originalIssuer;
    }

    public Proporties getProperties() {
        return properties;
    }

    public void setProperties(Proporties properties) {
        this.properties = properties;
    }

    public Object getSubject() {
        return subject;
    }

    public void setSubject(Object subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }
}
