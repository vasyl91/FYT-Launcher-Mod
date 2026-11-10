package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class BaseImageDownloader implements ImageDownloader {
    protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    protected static final int BUFFER_SIZE = 32768;
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    protected static final int MAX_REDIRECT_COUNT = 5;
    protected final int connectTimeout;
    protected final Context context;
    protected final int readTimeout;

    public BaseImageDownloader(Context context) {
        this.context = context.getApplicationContext();
        this.connectTimeout = DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.readTimeout = DEFAULT_HTTP_READ_TIMEOUT;
    }

    public BaseImageDownloader(Context context, int connectTimeout, int readTimeout) {
        this.context = context.getApplicationContext();
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String imageUri, Object extra) throws IOException {
        switch (ImageDownloader.Scheme.ofUri(imageUri)) {
            case HTTP:
            case HTTPS:
                return getStreamFromNetwork(imageUri, extra);
            case FILE:
                return getStreamFromFile(imageUri, extra);
            case CONTENT:
                return getStreamFromContent(imageUri, extra);
            case ASSETS:
                return getStreamFromAssets(imageUri, extra);
            case DRAWABLE:
                return getStreamFromDrawable(imageUri, extra);
            default:
                return getStreamFromOtherSource(imageUri, extra);
        }
    }

    protected InputStream getStreamFromNetwork(String imageUri, Object extra) throws IOException {
        HttpURLConnection conn = createConnection(imageUri, extra);
        for (int redirectCount = 0; conn.getResponseCode() / 100 == 3 && redirectCount < 5; redirectCount++) {
            conn = createConnection(conn.getHeaderField("Location"), extra);
        }
        return new BufferedInputStream(conn.getInputStream(), 32768);
    }

    protected HttpURLConnection createConnection(String url, Object extra) throws IOException {
        String encodedUrl = Uri.encode(url, ALLOWED_URI_CHARS);
        HttpURLConnection conn = (HttpURLConnection) new URL(encodedUrl).openConnection();
        conn.setConnectTimeout(this.connectTimeout);
        conn.setReadTimeout(this.readTimeout);
        return conn;
    }

    protected InputStream getStreamFromFile(String imageUri, Object extra) throws IOException {
        String filePath = ImageDownloader.Scheme.FILE.crop(imageUri);
        return new BufferedInputStream(new FileInputStream(filePath), 32768);
    }

    protected InputStream getStreamFromContent(String imageUri, Object extra) throws FileNotFoundException {
        ContentResolver res = this.context.getContentResolver();
        Uri uri = Uri.parse(imageUri);
        return res.openInputStream(uri);
    }

    protected InputStream getStreamFromAssets(String imageUri, Object extra) throws IOException {
        String filePath = ImageDownloader.Scheme.ASSETS.crop(imageUri);
        return this.context.getAssets().open(filePath);
    }

    protected InputStream getStreamFromDrawable(String imageUri, Object extra) {
        String drawableIdString = ImageDownloader.Scheme.DRAWABLE.crop(imageUri);
        int drawableId = Integer.parseInt(drawableIdString);
        BitmapDrawable drawable = (BitmapDrawable) this.context.getResources().getDrawable(drawableId);
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, os);
        return new ByteArrayInputStream(os.toByteArray());
    }

    protected InputStream getStreamFromOtherSource(String imageUri, Object extra) throws IOException {
        throw new UnsupportedOperationException(String.format(ERROR_UNSUPPORTED_SCHEME, imageUri));
    }
}
