package com.lsec.core.sharememory;

import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MyShareMemoryFile {
    public BufferBean mBufferBean;
    public MemoryFile mMemoryFile;
    public ParcelFileDescriptor mParcelFileDescriptor;

    public void initMemoryFile(String name, int len) {
        this.mBufferBean = new BufferBean(len);
        if (this.mMemoryFile == null) {
            this.mMemoryFile = MemoryFileHelper.createMemoryFile(name, len);
            if (this.mMemoryFile != null) {
                this.mParcelFileDescriptor = MemoryFileHelper.getParcelFileDescriptor(this.mMemoryFile);
            }
        }
    }

    public void writeBytes(byte[] data, int len) {
        if (this.mMemoryFile != null) {
            try {
                this.mMemoryFile.readBytes(this.mBufferBean.isCanRead, 0, 0, 1);
                if (this.mBufferBean.isCanRead[0] == 0) {
                    if (data != null) {
                        this.mMemoryFile.writeBytes(data, 0, 0, len);
                    }
                    this.mBufferBean.isCanRead[0] = 1;
                    this.mMemoryFile.writeBytes(this.mBufferBean.isCanRead, 0, 0, 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
