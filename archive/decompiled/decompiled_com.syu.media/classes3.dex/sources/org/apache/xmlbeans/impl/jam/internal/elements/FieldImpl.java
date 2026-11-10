package org.apache.xmlbeans.impl.jam.internal.elements;

import java.io.StringWriter;
import java.lang.reflect.Modifier;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.internal.classrefs.DirectJClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.UnqualifiedJClassRef;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class FieldImpl extends MemberImpl implements MField {
    private JClassRef mTypeClassRef;

    FieldImpl(String str, ClassImpl classImpl, String str2) {
        super(classImpl);
        super.setSimpleName(str);
        this.mTypeClassRef = QualifiedJClassRef.create(str2, classImpl);
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MField
    public void setType(JClass jClass) {
        if (jClass == null) {
            throw new IllegalArgumentException("null type");
        }
        this.mTypeClassRef = DirectJClassRef.create(jClass);
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MField
    public void setType(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null qcname");
        }
        this.mTypeClassRef = QualifiedJClassRef.create(str, (ClassImpl) getContainingClass());
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MField
    public void setUnqualifiedType(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null ucname");
        }
        this.mTypeClassRef = UnqualifiedJClassRef.create(str, (ClassImpl) getContainingClass());
    }

    @Override // org.apache.xmlbeans.impl.jam.JField
    public JClass getType() {
        JClassRef jClassRef = this.mTypeClassRef;
        if (jClassRef == null) {
            throw new IllegalStateException();
        }
        return jClassRef.getRefClass();
    }

    @Override // org.apache.xmlbeans.impl.jam.JField
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JField
    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JField
    public boolean isVolatile() {
        return Modifier.isVolatile(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JField
    public boolean isTransient() {
        return Modifier.isTransient(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public void accept(MVisitor mVisitor) {
        mVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public void accept(JVisitor jVisitor) {
        jVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write(Modifier.toString(getModifiers()));
        stringWriter.write(32);
        stringWriter.write(getType().getQualifiedName());
        stringWriter.write(32);
        stringWriter.write(getContainingClass().getQualifiedName());
        stringWriter.write(46);
        stringWriter.write(getSimpleName());
        return stringWriter.toString();
    }
}
