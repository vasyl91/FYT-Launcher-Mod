package com.nostra13.universalimageloader.core.download;

import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SlowNetworkImageDownloader implements ImageDownloader {
    private final ImageDownloader wrappedDownloader;

    public SlowNetworkImageDownloader(ImageDownloader wrappedDownloader) {
        this.wrappedDownloader = wrappedDownloader;
    }

    @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String imageUri, Object extra) throws IOException {
        InputStream imageStream = this.wrappedDownloader.getStream(imageUri, extra);
        switch (ImageDownloader.Scheme.ofUri(imageUri)) {
            case HTTP:
            case HTTPS:
                return new FlushedInputStream(imageStream);
            default:
                return imageStream;
        }
    }
}
