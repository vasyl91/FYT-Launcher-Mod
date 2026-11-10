package org.apache.xmlbeans.impl.jam;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface JAnnotation extends JElement {
    public static final String SINGLE_VALUE_NAME = "value";

    Object getAnnotationInstance();

    Object getProxy();

    @Override // org.apache.xmlbeans.impl.jam.JElement
    String getSimpleName();

    JAnnotationValue getValue(String str);

    JAnnotationValue[] getValues();
}
