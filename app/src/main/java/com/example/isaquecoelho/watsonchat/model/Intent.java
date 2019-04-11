package com.example.isaquecoelho.watsonchat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Intent {

    @SerializedName("intent")
    @Expose
    private String intent;
    @SerializedName("confidence")
    @Expose
    private Double confidence;

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

}