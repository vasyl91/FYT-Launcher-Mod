package com.lsec.core.sharememory;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class BufferBean {
    public ByteBuffer mBuffer;
    public long mTicks = 0;
    public byte[] isCanRead = new byte[1];

    public BufferBean(int bufferSize) {
        if (bufferSize > 0) {
            this.mBuffer = ByteBuffer.allocateDirect(bufferSize);
        }
    }
}
