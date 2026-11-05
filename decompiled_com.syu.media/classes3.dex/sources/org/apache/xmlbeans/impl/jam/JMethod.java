package org.apache.xmlbeans.impl.jam;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface JMethod extends JInvokable {
    @Override // org.apache.xmlbeans.impl.jam.JElement
    String getQualifiedName();

    JClass getReturnType();

    boolean isAbstract();

    boolean isFinal();

    boolean isNative();

    boolean isStatic();

    boolean isSynchronized();
}
