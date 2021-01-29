package com.example.travel_buddy.chat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.travel_buddy.R;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private ArrayList<ChatDetails> chatDetails = new ArrayList<>();
    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chat_window);
        recyclerView = findViewById(R.id.chatRecycler);

        ChatRequestAsyncTask task = new ChatRequestAsyncTask(new ChatRequestListener() {
            @Override
            public void onSuccess(ArrayList<ChatDetails> chatResponse) throws Exception {
                chatDetails.clear();
                chatDetails.addAll(chatResponse);
                chatAdapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(recyclerView.getAdapter().getItemCount());
            }

            @Override
            public void onError(String errorMsg) {
                // show error message
            }
        });
        task.execute();

        this.chatAdapter = new ChatAdapter(this, this.chatDetails);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(this.chatAdapter);
    }
}
