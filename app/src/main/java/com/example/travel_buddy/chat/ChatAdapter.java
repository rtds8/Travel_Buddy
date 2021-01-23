package com.example.travel_buddy.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travel_buddy.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder>{
    private Context context;
    private ArrayList<ChatDetails> chatList;

    public ChatAdapter(Context context, ArrayList<ChatDetails> chatList){
        this.context = context;
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatViewHolder(
                LayoutInflater.from(context).inflate(R.layout.chat_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        holder.setChatDetails(chatList.get(position));
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }
}
