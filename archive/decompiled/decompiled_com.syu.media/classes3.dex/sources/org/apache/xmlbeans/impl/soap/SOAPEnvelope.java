package org.apache.xmlbeans.impl.soap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface SOAPEnvelope extends SOAPElement {
    SOAPBody addBody() throws SOAPException;

    SOAPHeader addHeader() throws SOAPException;

    Name createName(String str) throws SOAPException;

    Name createName(String str, String str2, String str3) throws SOAPException;

    SOAPBody getBody() throws SOAPException;

    SOAPHeader getHeader() throws SOAPException;
}
