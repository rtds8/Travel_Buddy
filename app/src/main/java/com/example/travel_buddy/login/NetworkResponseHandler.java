package com.example.travel_buddy.login;

public interface NetworkResponseHandler {
    void onSuccess(String response);
    void onError(String error);
}
