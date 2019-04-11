package com.example.isaquecoelho.watsonchat.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class System {

    @SerializedName("initialized")
    @Expose
    private Boolean initialized;
    @SerializedName("dialog_stack")
    @Expose
    private List<DialogStack> dialogStack = null;
    @SerializedName("dialog_turn_counter")
    @Expose
    private Integer dialogTurnCounter;
    @SerializedName("dialog_request_counter")
    @Expose
    private Integer dialogRequestCounter;
    @SerializedName("branch_exited")
    @Expose
    private Boolean branchExited;
    @SerializedName("branch_exited_reason")
    @Expose
    private String branchExitedReason;

    public Boolean getInitialized() {
        return initialized;
    }

    public void setInitialized(Boolean initialized) {
        this.initialized = initialized;
    }

    public List<DialogStack> getDialogStack() {
        return dialogStack;
    }

    public void setDialogStack(List<DialogStack> dialogStack) {
        this.dialogStack = dialogStack;
    }

    public Integer getDialogTurnCounter() {
        return dialogTurnCounter;
    }

    public void setDialogTurnCounter(Integer dialogTurnCounter) {
        this.dialogTurnCounter = dialogTurnCounter;
    }

    public Integer getDialogRequestCounter() {
        return dialogRequestCounter;
    }

    public void setDialogRequestCounter(Integer dialogRequestCounter) {
        this.dialogRequestCounter = dialogRequestCounter;
    }

    public Boolean getBranchExited() {
        return branchExited;
    }

    public void setBranchExited(Boolean branchExited) {
        this.branchExited = branchExited;
    }

    public String getBranchExitedReason() {
        return branchExitedReason;
    }

    public void setBranchExitedReason(String branchExitedReason) {
        this.branchExitedReason = branchExitedReason;
    }

}
