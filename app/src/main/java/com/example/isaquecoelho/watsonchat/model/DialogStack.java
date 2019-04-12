package com.example.isaquecoelho.watsonchat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DialogStack {

    @SerializedName("dialog_node")
    @Expose
    private String dialogNode;
    @SerializedName("state")
    @Expose
    private String state;
}
