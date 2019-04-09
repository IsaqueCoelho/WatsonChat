package com.example.isaquecoelho.watsonchat.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.isaquecoelho.watsonchat.R;
import com.example.isaquecoelho.watsonchat.model.Message;
import com.example.isaquecoelho.watsonchat.viewmodel.ChatViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatFragment extends Fragment {

    @BindView(R.id.recyclerview_chat)
    RecyclerView recyclerViewChat;

    @BindView(R.id.edittext__message)
    EditText editTextMessage;

    @BindView(R.id.fab_sendmessage)
    FloatingActionButton floatingActionButtonSendMessage;

    private ChatViewModel mChatViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View chatView = inflater.inflate(R.layout.chat_fragment, container, false);

        ButterKnife.bind(this, chatView);

        return chatView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mChatViewModel = ViewModelProviders.of(this).get(ChatViewModel.class);
        // TODO: Use the ViewModel

        mChatViewModel.getMessageData().observe(this, new Observer<List<Message>>() {
            @Override
            public void onChanged(@Nullable List<Message> messages) {

            }
        });

        initChatList();

    }

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    private void initChatList() {

    }

}
