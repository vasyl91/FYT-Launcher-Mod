package org.apache.xmlbeans.impl.jam.internal.classrefs;

import org.apache.xmlbeans.impl.jam.JClass;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class DirectJClassRef implements JClassRef {
    private JClass mClass;

    public static JClassRef create(JClass jClass) {
        return jClass instanceof JClassRef ? (JClassRef) jClass : new DirectJClassRef(jClass);
    }

    private DirectJClassRef(JClass jClass) {
        if (jClass == null) {
            throw new IllegalArgumentException("null clazz");
        }
        this.mClass = jClass;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef
    public JClass getRefClass() {
        return this.mClass;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef
    public String getQualifiedName() {
        return this.mClass.getQualifiedName();
    }
}
