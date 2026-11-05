package org.apache.xmlbeans.impl.soap;

import java.util.Iterator;
import javax.xml.transform.Source;
import org.w3c.dom.Document;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class SOAPPart implements Document {
    public abstract void addMimeHeader(String str, String str2);

    public abstract Iterator getAllMimeHeaders();

    public abstract Source getContent() throws SOAPException;

    public abstract SOAPEnvelope getEnvelope() throws SOAPException;

    public abstract Iterator getMatchingMimeHeaders(String[] strArr);

    public abstract String[] getMimeHeader(String str);

    public abstract Iterator getNonMatchingMimeHeaders(String[] strArr);

    public abstract void removeAllMimeHeaders();

    public abstract void removeMimeHeader(String str);

    public abstract void setContent(Source source) throws SOAPException;

    public abstract void setMimeHeader(String str, String str2);

    public String getContentId() {
        String[] mimeHeader = getMimeHeader("Content-Id");
        if (mimeHeader == null || mimeHeader.length <= 0) {
            return null;
        }
        return mimeHeader[0];
    }

    public String getContentLocation() {
        String[] mimeHeader = getMimeHeader("Content-Location");
        if (mimeHeader == null || mimeHeader.length <= 0) {
            return null;
        }
        return mimeHeader[0];
    }

    public void setContentId(String str) {
        setMimeHeader("Content-Id", str);
    }

    public void setContentLocation(String str) {
        setMimeHeader("Content-Location", str);
    }
}
