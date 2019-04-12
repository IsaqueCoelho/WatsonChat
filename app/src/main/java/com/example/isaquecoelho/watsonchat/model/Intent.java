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

}