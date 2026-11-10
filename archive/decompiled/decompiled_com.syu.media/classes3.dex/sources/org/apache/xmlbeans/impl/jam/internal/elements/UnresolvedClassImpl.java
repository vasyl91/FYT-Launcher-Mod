package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JPackage;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class UnresolvedClassImpl extends BuiltinClassImpl {
    private String mPackageName;

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public JPackage getContainingPackage() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAssignableFrom(JClass jClass) {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public boolean isUnresolvedType() {
        return true;
    }

    public UnresolvedClassImpl(String str, String str2, ElementContext elementContext) {
        super(elementContext);
        if (str == null) {
            throw new IllegalArgumentException("null pkg");
        }
        this.mPackageName = str;
        reallySetSimpleName(str2);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        return (this.mPackageName.length() > 0 ? this.mPackageName + NameUtil.PERIOD : "") + this.mSimpleName;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public String getFieldDescriptor() {
        return getQualifiedName();
    }
}
