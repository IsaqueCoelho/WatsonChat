package com.example.isaquecoelho.watsonchat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Context {

    @SerializedName("conversation_id")
    @Expose
    private String conversationId;
    @SerializedName("system")
    @Expose
    private System system;
    @SerializedName("sabor")
    @Expose
    private String sabor;
    @SerializedName("acompanhamento")
    @Expose
    private String acompanhamento;
    @SerializedName("cep")
    @Expose
    private String cep;
}
