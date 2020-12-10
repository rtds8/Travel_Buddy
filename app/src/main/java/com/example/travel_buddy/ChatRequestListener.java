package com.example.travel_buddy;

public interface ChatRequestListener {
    void onSuccess(String chatResponse) throws Exception;

    void onError(String errorMsg);
}
