package com.example.isaquecoelho.watsonchat.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.isaquecoelho.watsonchat.model.Message;

import java.util.List;

public class ChatViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<List<Message>> messageData = new MutableLiveData<>();

    public MutableLiveData<List<Message>> getMessageData() {
        return messageData;
    }
}
