package com.example.travel_buddy;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ChatViewHolder extends RecyclerView.ViewHolder {

    private ChatDetails chatDetails;
    private TextView name;
    private TextView messsage;
    private TextView time;

    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.sender_name);
        messsage = itemView.findViewById(R.id.message);
        time = itemView.findViewById(R.id.time);

    }

    public void setChatDetails(ChatDetails chatDetails){
        this.chatDetails=chatDetails;
        //put details from chat details on the view
        this.name.setText(chatDetails.getName());
        this.messsage.setText(chatDetails.getMessage());
        this.time.setText(chatDetails.getTime());
    }
}
