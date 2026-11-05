package org.apache.xmlbeans.xml.stream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface ReferenceResolver {
    String getId(String str);

    XMLInputStream resolve(String str) throws XMLStreamException;
}
