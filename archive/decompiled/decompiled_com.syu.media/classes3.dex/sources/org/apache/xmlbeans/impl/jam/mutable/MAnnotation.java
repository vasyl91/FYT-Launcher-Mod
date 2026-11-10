package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JClass;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface MAnnotation extends JAnnotation, MElement {
    MAnnotation createNestedValue(String str, String str2);

    MAnnotation[] createNestedValueArray(String str, String str2, int i);

    void setAnnotationInstance(Object obj);

    void setSimpleValue(String str, Object obj, JClass jClass);
}
