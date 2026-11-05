package com.nostra13.universalimageloader.core.assist;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FlushedInputStream extends FilterInputStream {
    public FlushedInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n) throws IOException {
        long totalBytesSkipped = 0;
        while (totalBytesSkipped < n) {
            long bytesSkipped = this.in.skip(n - totalBytesSkipped);
            if (bytesSkipped == 0) {
                int by_te = read();
                if (by_te < 0) {
                    break;
                }
                bytesSkipped = 1;
            }
            totalBytesSkipped += bytesSkipped;
        }
        return totalBytesSkipped;
    }
}
