package org.apache.xmlbeans.impl.jam;

import org.apache.xmlbeans.impl.jam.visitor.JVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface JElement {
    void accept(JVisitor jVisitor);

    Object getArtifact();

    JElement getParent();

    String getQualifiedName();

    String getSimpleName();

    JSourcePosition getSourcePosition();

    String toString();
}
