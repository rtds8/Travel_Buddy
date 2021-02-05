package com.example.travel_buddy.login;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkHelper extends AsyncTask<Void, Void, Void> {

        private String apiUrl;

        /*
         * {"email": "test@email.com", "password": "test1234"}
         * */
        private String jsonBody;

        private NetworkType networkType;

        private NetworkResponseHandler handler;

        private String successResp, errorResp;

        // Default networkType is GET
        // Default jsonBody is null
        public NetworkHelper(String apiUrl, NetworkResponseHandler handler) {
            this.apiUrl = apiUrl;
            this.handler = handler;
            networkType = NetworkType.GET;
            jsonBody = null;
        }

        public NetworkHelper(String apiUrl, String jsonBody, NetworkResponseHandler handler) {
            this.apiUrl = apiUrl;
            this.jsonBody = jsonBody;
            this.handler = handler;
            this.networkType = NetworkType.POST;
        }

        public NetworkHelper(String apiUrl, String jsonBody, NetworkType networkType, NetworkResponseHandler handler) {
            this.apiUrl = apiUrl;
            this.jsonBody = jsonBody;
            this.networkType = networkType;
            this.handler = handler;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                // create url object
                URL urlObject = new URL(this.apiUrl);
                // get connection object
                HttpURLConnection httpConnection = (HttpURLConnection) urlObject.openConnection();
                // set request method
                httpConnection.setRequestMethod(networkType == NetworkType.GET ? "GET" : "POST");

                if (this.networkType == NetworkType.POST) {
                    httpConnection.setDoOutput(true);
                    // get output stream and write payload content
                    if (this.jsonBody != null) {
                        OutputStream os = httpConnection.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
                        osw.write(this.jsonBody);
                        osw.flush();
                        osw.close();
                        os.close();
                    }
                }

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

                    this.successResp = baos.toString();
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
                    this.errorResp = baos.toString();
                }
            } catch (Exception e) {
                errorResp = e.getMessage();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (errorResp != null) {
                handler.onError(errorResp);
            } else if (successResp != null) {
                handler.onSuccess(successResp);
            } else {
                handler.onError("Uncrossable entity");
            }
        }
}
