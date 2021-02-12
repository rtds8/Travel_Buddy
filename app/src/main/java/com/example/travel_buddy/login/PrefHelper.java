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
    public void setPassword(String password){pref.edit().putString("Password", password).apply();}
    public void setName(String user_name){pref.edit().putString("User Name", user_name).apply();}
    public void setEmail(String email){pref.edit().putString("Email", email).apply();}
    public void setPhone(String phone){pref.edit().putString("Phone", phone).apply();}

    public String getUserId(){return pref.getString("User ID", null);}
    public String getPassword(){ return pref.getString("Password", null); }
    public String getEmail(){return pref.getString("Email", null); }
    public String getName(){return pref.getString("User Name", null); }
    public String getPhone(){return pref.getString("Phone", null); }

}
