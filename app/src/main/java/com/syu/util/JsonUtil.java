package com.syu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class JsonUtil {
    public static String getRequestStr(String urlServer) {
        String str = "";
        try {
            URL url = new URL(urlServer);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod(HttpPost.METHOD_NAME);
            httpConn.setRequestProperty(HTTP.CONTENT_TYPE, "application/json");
            httpConn.setRequestProperty("Charset", HTTP.UTF_8);
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
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), HTTP.UTF_8));
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

    public static String doPostStr(List<NameValuePair> params, String str_http) {
        HttpPost httpPost = new HttpPost(str_http);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                return "";
            }
            String str = EntityUtils.toString(httpResponse.getEntity());
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
