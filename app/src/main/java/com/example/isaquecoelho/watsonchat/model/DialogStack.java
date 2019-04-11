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

    public String getDialogNode() {
        return dialogNode;
    }

    public void setDialogNode(String dialogNode) {
        this.dialogNode = dialogNode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
