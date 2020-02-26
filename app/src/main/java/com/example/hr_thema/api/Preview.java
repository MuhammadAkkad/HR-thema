package com.example.hr_thema.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Preview {
    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("Content")
    @Expose
    private String content;

    @SerializedName("LangId")
    @Expose
    private Integer langId;

    @SerializedName("LangCode")
    @Expose
    private Object langCode;

    @SerializedName("Previews")
    @Expose
    private ProcessRequest processRequest;

    public ProcessRequest getProcessRequest() {
        return processRequest;
    }

    public void setProcessRequest(ProcessRequest processRequest) {
        this.processRequest = processRequest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Object getLangCode() {
        return langCode;
    }

    public void setLangCode(Object langCode) {
        this.langCode = langCode;
    }
}
