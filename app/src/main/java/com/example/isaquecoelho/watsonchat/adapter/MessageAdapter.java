package com.example.isaquecoelho.watsonchat.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.isaquecoelho.watsonchat.R;
import com.example.isaquecoelho.watsonchat.model.MessageItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<MessageItem> mMessageList;

    public MessageAdapter(List<MessageItem> mMessageList) {
        this.mMessageList = mMessageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View messageView;

        switch (position){
            case 0:
                messageView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_message_sended, viewGroup, false);
                break;
            case 1:
                messageView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_message_received, viewGroup, false);
                break;
            default:
                messageView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_message_sended, viewGroup, false);
        }

        return new MessageViewHolder(messageView);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int position) {
        MessageItem messageItem = mMessageList.get(position);

        messageViewHolder.textViewTitle.setText(messageItem.getTitle());
        messageViewHolder.textViewMessage.setText(messageItem.getMessage());
    }

    @Override
    public int getItemCount() {
        return ( mMessageList == null ) ? 0 : mMessageList.size();
    }

    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);

        return mMessageList.get(position).isAssistent() ? 1 : 0;
    }

    public void updateMessageDataList(List<MessageItem> messageItemList){
        this.mMessageList = messageItemList;
        notifyDataSetChanged();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textview_title)
        TextView textViewTitle;

        @BindView(R.id.textview_message)
        TextView textViewMessage;

        MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
