package com.example.travel_buddy;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatViewHolder extends RecyclerView.ViewHolder {

    private ChatDetails chatDetails;

    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);

    }

    public void setChatDetails(ChatDetails chatDetails){
        this.chatDetails=chatDetails;
        //put details from chat details on the view

        //itemView.setContentDescription(chatDetails.getName());
        //itemView.setContentDescription(chatDetails.getMessage());
        //itemView.setContentDescription(chatDetails.getTime());
        //itemView.setContentDescription(chatDetails.toString());
        itemView.setContentDescription((CharSequence) chatDetails);
    }
}
