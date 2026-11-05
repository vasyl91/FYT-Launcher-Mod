package org.apache.poi.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface DelayableLittleEndianOutput extends LittleEndianOutput {
    LittleEndianOutput createDelayedOutput(int i);
}
