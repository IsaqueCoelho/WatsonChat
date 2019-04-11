package com.example.isaquecoelho.watsonchat.model;

public class MessageItem {

    private String title;
    private String message;
    private boolean assistent;

    public MessageItem(String title, String message, boolean assistent) {
        this.title = title;
        this.message = message;
        this.assistent = assistent;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public boolean isAssistent() {
        return assistent;
    }
}
