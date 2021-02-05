package com.example.travel_buddy.chat;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travel_buddy.R;


public class ChatViewHolder extends RecyclerView.ViewHolder {

    private ChatDetails chatDetails;
    private TextView message_sender, message_receiver;
    private TextView time_sender, time_receiver;
    private LinearLayout sender, receiver;
    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);
        sender = itemView.findViewById(R.id.sender_side);
        receiver = itemView.findViewById(R.id.receiver_side);
        message_sender = itemView.findViewById(R.id.message_sender);
        time_sender = itemView.findViewById(R.id.time_sender);

    }

    public void setChatDetails(ChatDetails chatDetails){
        this.chatDetails = chatDetails;
        //put details from chat details on the view

        if(chatDetails.getName().equals("Ritwik")){
            sender.setVisibility(View.VISIBLE);
            receiver.setVisibility(View.GONE);
            this.message_sender.setText(chatDetails.getMessage());
            this.time_sender.setText(chatDetails.getTime());
        }
    }
}
