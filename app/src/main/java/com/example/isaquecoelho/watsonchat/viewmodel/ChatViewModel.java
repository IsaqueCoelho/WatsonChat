package com.example.isaquecoelho.watsonchat.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.isaquecoelho.watsonchat.model.Context;
import com.example.isaquecoelho.watsonchat.model.Input;
import com.example.isaquecoelho.watsonchat.model.Message;
import com.example.isaquecoelho.watsonchat.model.MessageItem;
import com.example.isaquecoelho.watsonchat.utils.RequestUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatViewModel extends ViewModel {

    private static final String LOG_TAG = "ChatViewModel";
    // TODO: Implement the ViewModel

    private List<MessageItem> messageList = new ArrayList<>();
    private MutableLiveData<List<MessageItem>> messageData = new MutableLiveData<>();
    private static Context mMessageContext = new Context();

    private Call<Message> mRequestMessage;

    private Message mMessage = new Message();


    public MutableLiveData<List<MessageItem>> getMessageData() {
        return messageData;
    }

    private void settingRequest(){
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(RequestUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestUtils mrRequestUtils = mRetrofit.create(RequestUtils.class);
        mRequestMessage = mrRequestUtils.messageData(mMessage);
    }

    private void settingMessage(String messageText){
        if(messageText != null){
            mMessage.setInput(new Input(messageText));
            mMessage.setContext(mMessageContext);
        }
    }

    public void requestMessage(final String messageInputText){
        settingRequest();
        settingMessage(messageInputText);
        sendingRequest();
    }

    private void sendingRequest() {
        mRequestMessage.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {

                if(!response.isSuccessful()){
                    Log.e(LOG_TAG, "error: " + response.raw());
                } else {
                    Message message = response.body();
                    mMessageContext = message.getContext();

                    if(messageData.getValue() != null){
                        messageList.add(new MessageItem("Você", message.getInput().getText(), false));
                    }

                    for (int countResponse = 0; countResponse < message.getOutput().getText().size(); countResponse++) {
                        messageList.add(new MessageItem("Assistente", message.getOutput().getText().get(countResponse), true));
                    }

                    messageData.postValue(messageList);
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.e(LOG_TAG, "failure: " + t.getMessage());
            }
        });
    }
}
