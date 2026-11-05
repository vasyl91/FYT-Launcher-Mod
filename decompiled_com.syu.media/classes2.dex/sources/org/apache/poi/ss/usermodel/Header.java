package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Header extends HeaderFooter {
    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    String getCenter();

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    String getLeft();

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    String getRight();

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    void setCenter(String str);

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    void setLeft(String str);

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    void setRight(String str);
}
