package org.apache.xmlbeans.impl.soap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SOAPElementFactory {
    private SOAPFactory sf;

    private SOAPElementFactory(SOAPFactory sOAPFactory) {
        this.sf = sOAPFactory;
    }

    public SOAPElement create(Name name) throws SOAPException {
        return this.sf.createElement(name);
    }

    public SOAPElement create(String str) throws SOAPException {
        return this.sf.createElement(str);
    }

    public SOAPElement create(String str, String str2, String str3) throws SOAPException {
        return this.sf.createElement(str, str2, str3);
    }

    public static SOAPElementFactory newInstance() throws SOAPException {
        try {
            return new SOAPElementFactory(SOAPFactory.newInstance());
        } catch (Exception e) {
            throw new SOAPException("Unable to create SOAP Element Factory: " + e.getMessage());
        }
    }
}
