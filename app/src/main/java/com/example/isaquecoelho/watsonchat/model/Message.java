package com.example.isaquecoelho.watsonchat.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("intents")
    @Expose
    private List<Intent> intents = null;
    @SerializedName("input")
    @Expose
    private Input input;
    @SerializedName("output")
    @Expose
    private Output output;
    @SerializedName("context")
    @Expose
    private Context context;

    public List<Intent> getIntents() {
        return intents;
    }

    public void setIntents(List<Intent> intents) {
        this.intents = intents;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
