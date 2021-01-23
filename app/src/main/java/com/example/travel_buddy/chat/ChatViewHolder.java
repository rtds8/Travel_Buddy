package com.example.travel_buddy.chat;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travel_buddy.R;


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
        this.chatDetails = chatDetails;
        //put details from chat details on the view
        if(chatDetails.getName().contentEquals("Ritwik")){
            this.name.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            this.name.setText(chatDetails.getName());
            this.messsage.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            this.messsage.setText(chatDetails.getMessage());
            this.time.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            this.time.setText(chatDetails.getTime());
        }
        else{
            this.name.setText(chatDetails.getName());
            this.messsage.setText(chatDetails.getMessage());
            this.time.setText(chatDetails.getTime());
        }
    }
}
