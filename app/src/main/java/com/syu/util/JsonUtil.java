package com.syu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class JsonUtil {
    public static String getRequestStr(String urlServer) {
        String str = "";
        try {
            URL url = new URL(urlServer);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setDoOutput(false);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod("GET");
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("Charset", StandardCharsets.UTF_8.name());
            httpConn.setReadTimeout(10000);
            httpConn.setConnectTimeout(10000);
            httpConn.connect();
            OutputStream outputStream = httpConn.getOutputStream();
            outputStream.close();
            int responseCode = httpConn.getResponseCode();
            if (200 != responseCode) {
                return "";
            }
            StringBuffer sb = new StringBuffer();
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), StandardCharsets.UTF_8));
            while (true) {
                String readLine = responseReader.readLine();
                if (readLine != null) {
                    sb.append(readLine).append("\n");
                } else {
                    responseReader.close();
                    str = sb.toString();
                    return str;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return str;
        } catch (IOException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String doPostStr(Map<String, String> params, String str_http) {
        try {
            FormBody.Builder formBuilder = new FormBody.Builder(StandardCharsets.UTF_8);
            for (Map.Entry<String, String> entry : params.entrySet()) {
                formBuilder.add(entry.getKey(), entry.getValue());
            }
            RequestBody formBody = formBuilder.build();

            Request request = new Request.Builder()
                    .url(str_http)
                    .post(formBody)
                    .build();

            OkHttpClient client = new OkHttpClient();
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful() || response.body() == null) {
                    return "";
                }
                return response.body().string();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
