package org.apache.xmlbeans.impl.soap;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface SOAPHeader extends SOAPElement {
    SOAPHeaderElement addHeaderElement(Name name) throws SOAPException;

    Iterator examineAllHeaderElements();

    Iterator examineHeaderElements(String str);

    Iterator examineMustUnderstandHeaderElements(String str);

    Iterator extractAllHeaderElements();

    Iterator extractHeaderElements(String str);
}
