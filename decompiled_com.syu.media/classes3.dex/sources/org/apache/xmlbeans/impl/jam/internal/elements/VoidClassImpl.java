package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.JClass;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class VoidClassImpl extends BuiltinClassImpl {
    private static final String SIMPLE_NAME = "void";

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAssignableFrom(JClass jClass) {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public boolean isVoidType() {
        return true;
    }

    public static boolean isVoid(String str) {
        return str.equals(SIMPLE_NAME);
    }

    public VoidClassImpl(ElementContext elementContext) {
        super(elementContext);
        super.reallySetSimpleName(SIMPLE_NAME);
    }
}
