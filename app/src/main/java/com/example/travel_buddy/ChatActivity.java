package com.example.travel_buddy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


//        - Setup the RecyclerView
//        - Set the data to recycler view

        ChatRequestAsyncTask task = new ChatRequestAsyncTask(new ChatRequestListener() {
            @Override
            public void onSuccess(String chatResponse) throws Exception {
                // set data to recycler view

                parseResponse(chatResponse);
            }

            @Override
            public void onError(String errorMsg) {
                // show error message
            }
        });

        this.chatAdapter = new ChatAdapter(this, this.chatDetails);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(this.chatAdapter);
    }

    private void parseResponse(String response) throws Exception {

        if(response != null && !response.isEmpty()){
            JSONObject responseObject = new JSONObject(response);

            if(responseObject.has("data")){

                JSONArray chatArray = responseObject.getJSONArray("data");
                ChatDetails chat = null;
                if(chatArray.length() > 0){
                    for(int i=0; i<chatArray.length();i++){

                        JSONObject chatObject = chatArray.getJSONObject(i);
                        chat = new ChatDetails(
                                chatObject.getString("sender_name"),
                                chatObject.getString("message"),
                                chatObject.getString("time")
                        );
                    }
                    chatDetails.add(chat);
                }
            }
        }

        this.chatAdapter.notifyDataSetChanged();
    }
}