package org.apache.xmlbeans.xml.stream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface StartDocument extends XMLEvent {
    String getCharacterEncodingScheme();

    String getSystemId();

    String getVersion();

    boolean isStandalone();
}
