package com.example.isaquecoelho.watsonchat.view;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.isaquecoelho.watsonchat.R;
import com.example.isaquecoelho.watsonchat.adapter.MessageAdapter;
import com.example.isaquecoelho.watsonchat.model.MessageItem;
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
    private MessageAdapter mMessageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View chatView = inflater.inflate(R.layout.chat_fragment, container, false);

        ButterKnife.bind(this, chatView);

        listeningView();

        return chatView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mChatViewModel = ViewModelProviders.of(this).get(ChatViewModel.class);
        // TODO: Use the ViewModel

        mChatViewModel.getMessageData().observe(this, new Observer<List<MessageItem>>() {
            @Override
            public void onChanged(@Nullable List<MessageItem> messageList) {
                mMessageAdapter.updateMessageDataList(messageList);
                recyclerViewChat.smoothScrollToPosition(mMessageAdapter.getItemCount() - 1);
            }
        });

        initChatList();
        mChatViewModel.requestMessage(null);
    }

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    private void listeningView() {
        floatingActionButtonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChatViewModel.requestMessage(editTextMessage.getText().toString());
                editTextMessage.setText(null);
                InputMethodManager inputMethodManager =
                        (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(editTextMessage.getWindowToken(), 0);
            }
        });
    }

    private void initChatList() {

        mMessageAdapter = new MessageAdapter(mChatViewModel.getMessageData().getValue());

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerViewChat.setLayoutManager(linearLayoutManager);
        recyclerViewChat.setAdapter(mMessageAdapter);
    }

}
