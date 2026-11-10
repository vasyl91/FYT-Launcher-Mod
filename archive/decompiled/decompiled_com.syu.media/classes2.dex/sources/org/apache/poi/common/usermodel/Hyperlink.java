package org.apache.poi.common.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Hyperlink {
    String getAddress();

    String getLabel();

    int getType();

    HyperlinkType getTypeEnum();

    void setAddress(String str);

    void setLabel(String str);
}
