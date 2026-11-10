package com.fasterxml.aalto.stax;

import javax.xml.namespace.QName;
import org.codehaus.stax2.ri.Stax2EventFactoryImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class EventFactoryImpl extends Stax2EventFactoryImpl {
    protected QName createQName(String str, String str2) {
        return new QName(str, str2);
    }

    protected QName createQName(String str, String str2, String str3) {
        return new QName(str, str2, str3);
    }
}
