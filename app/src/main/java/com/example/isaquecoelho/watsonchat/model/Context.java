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

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
