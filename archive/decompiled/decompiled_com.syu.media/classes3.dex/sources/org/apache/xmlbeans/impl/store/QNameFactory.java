package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface QNameFactory {
    QName getQName(String str, String str2);

    QName getQName(String str, String str2, String str3);

    QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4);

    QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6);
}
