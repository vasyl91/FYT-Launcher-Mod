package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JAnnotatedElement;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface MAnnotatedElement extends MElement, JAnnotatedElement {
    MAnnotation addLiteralAnnotation(String str);

    MComment createComment();

    MAnnotation findOrCreateAnnotation(String str);

    MAnnotation getMutableAnnotation(String str);

    MAnnotation[] getMutableAnnotations();

    MComment getMutableComment();

    void removeComment();
}
