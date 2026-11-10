package org.apache.xmlbeans.impl.soap;

import java.util.Locale;
import org.w3c.dom.Document;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface SOAPBody extends SOAPElement {
    SOAPBodyElement addBodyElement(Name name) throws SOAPException;

    SOAPBodyElement addDocument(Document document) throws SOAPException;

    SOAPFault addFault() throws SOAPException;

    SOAPFault addFault(Name name, String str) throws SOAPException;

    SOAPFault addFault(Name name, String str, Locale locale) throws SOAPException;

    SOAPFault getFault();

    boolean hasFault();
}
