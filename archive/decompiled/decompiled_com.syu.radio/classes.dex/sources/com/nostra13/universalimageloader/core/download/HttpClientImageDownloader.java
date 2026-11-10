package com.nostra13.universalimageloader.core.download;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class HttpClientImageDownloader extends BaseImageDownloader {
    private HttpClient httpClient;

    public HttpClientImageDownloader(Context context, HttpClient httpClient) {
        super(context);
        this.httpClient = httpClient;
    }

    @Override // com.nostra13.universalimageloader.core.download.BaseImageDownloader
    protected InputStream getStreamFromNetwork(String imageUri, Object extra) throws IOException {
        HttpGet httpRequest = new HttpGet(imageUri);
        HttpResponse response = this.httpClient.execute(httpRequest);
        HttpEntity entity = response.getEntity();
        BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);
        return bufHttpEntity.getContent();
    }
}
