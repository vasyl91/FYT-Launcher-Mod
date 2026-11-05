package org.apache.xmlbeans.impl.jam.internal.classrefs;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JamClassLoader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class QualifiedJClassRef implements JClassRef {
    private JamClassLoader mClassLoader;
    private String mQualifiedClassname;

    public static JClassRef create(JClass jClass) {
        if (jClass == null) {
            throw new IllegalArgumentException("null clazz");
        }
        return new QualifiedJClassRef(jClass.getFieldDescriptor(), jClass.getClassLoader());
    }

    public static JClassRef create(String str, JClassRefContext jClassRefContext) {
        if (str == null) {
            throw new IllegalArgumentException("null qcname");
        }
        if (jClassRefContext == null) {
            throw new IllegalArgumentException("null ctx");
        }
        return create(str, jClassRefContext.getClassLoader());
    }

    public static JClassRef create(String str, JamClassLoader jamClassLoader) {
        if (str == null) {
            throw new IllegalArgumentException("null qcname");
        }
        if (jamClassLoader == null) {
            throw new IllegalArgumentException("null classloader");
        }
        return new QualifiedJClassRef(str, jamClassLoader);
    }

    private QualifiedJClassRef(String str, JamClassLoader jamClassLoader) {
        this.mClassLoader = jamClassLoader;
        this.mQualifiedClassname = str;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef
    public JClass getRefClass() {
        return this.mClassLoader.loadClass(this.mQualifiedClassname);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef
    public String getQualifiedName() {
        return this.mQualifiedClassname;
    }

    public String toString() {
        return "(QualifiedJClassRef '" + this.mQualifiedClassname + "')";
    }
}
