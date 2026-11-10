package org.apache.xmlbeans.impl.soap;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface Detail extends SOAPFaultElement {
    DetailEntry addDetailEntry(Name name) throws SOAPException;

    Iterator getDetailEntries();
}
