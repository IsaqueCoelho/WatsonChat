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

}
