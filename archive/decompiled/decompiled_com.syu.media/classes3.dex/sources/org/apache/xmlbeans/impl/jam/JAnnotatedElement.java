package org.apache.xmlbeans.impl.jam;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface JAnnotatedElement extends JElement {
    JAnnotation[] getAllJavadocTags();

    JAnnotation getAnnotation(Class cls);

    JAnnotation getAnnotation(String str);

    Object getAnnotationProxy(Class cls);

    JAnnotationValue getAnnotationValue(String str);

    JAnnotation[] getAnnotations();

    JComment getComment();
}
