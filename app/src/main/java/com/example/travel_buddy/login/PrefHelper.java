package com.example.travel_buddy.login;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefHelper {

    private static PrefHelper instance;
    private static SharedPreferences pref;

    private PrefHelper(){
        //private constructor for singleton
    }

    public static PrefHelper getInstance(Context context){
        if(instance == null){
            instance = new PrefHelper();
            pref = context.getSharedPreferences("Travel_Buddy", Context.MODE_PRIVATE);
        }
        return instance;
    }

    public void putString(String key, String val){
        pref.edit().putString(key,val).apply();
    }

    public void setUserId(String userId){
        pref.edit().putString("User ID", userId).apply();
    }

    public String getUserId(){
        return pref.getString("User ID", null);
    }
}