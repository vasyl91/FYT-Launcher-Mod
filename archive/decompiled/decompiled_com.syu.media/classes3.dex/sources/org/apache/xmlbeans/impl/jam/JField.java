package org.apache.xmlbeans.impl.jam;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface JField extends JMember {
    @Override // org.apache.xmlbeans.impl.jam.JElement
    String getQualifiedName();

    JClass getType();

    boolean isFinal();

    boolean isStatic();

    boolean isTransient();

    boolean isVolatile();
}
