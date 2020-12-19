package com.example.travel_buddy;

import java.util.ArrayList;

public interface ChatRequestListener {
    void onSuccess(ArrayList<ChatDetails> chatResponse) throws Exception;

    void onError(String errorMsg);
}
