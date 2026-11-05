package org.apache.xmlbeans.impl.soap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class SOAPConnection {
    public abstract SOAPMessage call(SOAPMessage sOAPMessage, Object obj) throws SOAPException;

    public abstract void close() throws SOAPException;
}
