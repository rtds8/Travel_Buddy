package com.example.travel_buddy;

public class ChatDetails {
    private String message, time, name;

    public ChatDetails(String name, String message, String time){
        this.name=name;
        this.message=message;
        this.time=time;
    }

    public String getName() {
        return this.name;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTime() {
        return this.time;
    }
}
