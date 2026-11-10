package net.lingala.zip4j.io;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ZipIn2 extends ZipIn {
    static Field mFieldMarkPos = null;
    AssetManager.AssetInputStream inputStream;
    int lenInputStream;

    public ZipIn2(Context context, String strAsset) {
        this.strAsset = strAsset;
        try {
            AssetManager assetManager = context.getAssets();
            this.inputStream = (AssetManager.AssetInputStream) assetManager.open(strAsset);
            this.lenInputStream = this.inputStream.available();
        } catch (Exception e) {
        }
        if (mFieldMarkPos == null) {
            try {
                mFieldMarkPos = AssetManager.AssetInputStream.class.getDeclaredField("mMarkPos");
                mFieldMarkPos.setAccessible(true);
            } catch (Exception e2) {
            }
        }
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public void skip(long pos) throws IOException {
        long nSkip = this.inputStream.skip(pos);
        while (true) {
            long dN = pos - nSkip;
            if (dN > 0) {
                nSkip += this.inputStream.skip(dN);
            } else {
                return;
            }
        }
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public void seek(long pos) throws IOException {
        int curPos = this.lenInputStream - this.inputStream.available();
        if (curPos <= pos) {
            skip(pos - ((long) curPos));
            return;
        }
        try {
            if (mFieldMarkPos != null) {
                mFieldMarkPos.set(this.inputStream, Long.valueOf(pos));
                this.inputStream.reset();
            }
        } catch (Exception e) {
        }
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public long length() throws IOException {
        return this.inputStream.available();
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public int read(byte[] b, int off, int len) throws IOException {
        return this.inputStream.read(b, off, len);
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public long readLeInt(byte[] b) throws IOException {
        this.inputStream.read(b, 0, 4);
        return readLongLittleEndian(b);
    }

    @Override // net.lingala.zip4j.io.ZipIn
    public void close() throws IOException {
        this.inputStream.close();
    }
}
