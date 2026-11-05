package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.internal.classrefs.DirectJClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.UnqualifiedJClassRef;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;
import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ParameterImpl extends MemberImpl implements MParameter {
    private JClassRef mTypeClassRef;

    ParameterImpl(String str, InvokableImpl invokableImpl, String str2) {
        super(invokableImpl);
        setSimpleName(str);
        setType(str2);
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        return getSimpleName();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MParameter
    public void setType(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null typename");
        }
        this.mTypeClassRef = QualifiedJClassRef.create(str, (ClassImpl) getContainingClass());
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MParameter
    public void setType(JClass jClass) {
        if (jClass == null) {
            throw new IllegalArgumentException("null qcname");
        }
        this.mTypeClassRef = DirectJClassRef.create(jClass);
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MParameter
    public void setUnqualifiedType(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null ucname");
        }
        this.mTypeClassRef = UnqualifiedJClassRef.create(str, (ClassImpl) getContainingClass());
    }

    @Override // org.apache.xmlbeans.impl.jam.JParameter
    public JClass getType() {
        return this.mTypeClassRef.getRefClass();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public void accept(MVisitor mVisitor) {
        mVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public void accept(JVisitor jVisitor) {
        jVisitor.visit(this);
    }
}
