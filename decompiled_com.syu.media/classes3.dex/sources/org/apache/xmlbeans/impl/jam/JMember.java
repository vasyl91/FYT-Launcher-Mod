package org.apache.xmlbeans.impl.jam;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface JMember extends JAnnotatedElement {
    JClass getContainingClass();

    int getModifiers();

    boolean isPackagePrivate();

    boolean isPrivate();

    boolean isProtected();

    boolean isPublic();
}
