package com.example.travel_buddy;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ChatRequestAsyncTask extends AsyncTask<Void, Void, Void> {

    private ChatRequestListener listener;

    private ArrayList<ChatDetails> chatDetails = new ArrayList<>();

    private String errormsg;
    public static final String API = "https://gmd-507.herokuapp.com/chat";

    public ChatRequestAsyncTask(ChatRequestListener listener){
        this.listener=listener;
    }

    private void parseResponse(String response) throws Exception {

        if (response != null && !response.isEmpty()) {
            JSONObject responseObject = new JSONObject(response);

            if (responseObject.has("data")) {

                JSONArray chatArray = responseObject.getJSONArray("data");
                ChatDetails chat = null;
                if (chatArray.length() > 0) {
                    for (int i = 0; i < chatArray.length(); i++) {

                        JSONObject chatObject = chatArray.getJSONObject(i);
                        chat = new ChatDetails(
                                chatObject.getString("sender_name"),
                                chatObject.getString("message"),
                                chatObject.getString("time")
                        );
                        chatDetails.add(chat);
                    }

                }
            }
        }
    }

    private void networkCall() throws Exception {
        // call the API
        // get the response JSON String
        String url = String.format(API);
        System.out.println("Weather API URL: " + url);

        // create url object
        URL urlObject = new URL(url);
        // get connection object
        HttpURLConnection httpConnection = (HttpURLConnection) urlObject.openConnection();
        // set request method
        httpConnection.setRequestMethod("GET");
        // create connection
        httpConnection.connect();
        // get input stream from connection to get output from the server
        if (httpConnection.getResponseCode() == 200) {
            BufferedInputStream bis = new BufferedInputStream(httpConnection.getInputStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int res = bis.read();
            // read response from the server
            while (res != -1) {
                baos.write((byte) res);
                res = bis.read();
            }

            parseResponse(baos.toString());
        } else {
            BufferedInputStream bis = new BufferedInputStream(httpConnection.getErrorStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int res = bis.read();
            // read response from the server
            while (res != -1) {
                baos.write((byte) res);
                res = bis.read();
            }
            // finally return response when reading from server is completed
            errormsg = baos.toString();
        }
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            networkCall();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        try {
            listener.onSuccess(chatDetails);
        } catch (Exception e) {
            listener.onError(errormsg);
        }
    }
}
