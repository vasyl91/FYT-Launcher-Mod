package org.apache.xmlbeans.impl.jam.internal.elements;

import java.io.StringWriter;
import java.lang.reflect.Modifier;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JParameter;
import org.apache.xmlbeans.impl.jam.internal.classrefs.DirectJClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.UnqualifiedJClassRef;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class MethodImpl extends InvokableImpl implements MMethod {
    private JClassRef mReturnTypeRef;

    MethodImpl(String str, ClassImpl classImpl) {
        super(classImpl);
        this.mReturnTypeRef = null;
        setSimpleName(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MMethod
    public void setReturnType(String str) {
        this.mReturnTypeRef = QualifiedJClassRef.create(str, (ClassImpl) getContainingClass());
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MMethod
    public void setUnqualifiedReturnType(String str) {
        this.mReturnTypeRef = UnqualifiedJClassRef.create(str, (ClassImpl) getContainingClass());
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MMethod
    public void setReturnType(JClass jClass) {
        this.mReturnTypeRef = DirectJClassRef.create(jClass);
    }

    @Override // org.apache.xmlbeans.impl.jam.JMethod
    public JClass getReturnType() {
        JClassRef jClassRef = this.mReturnTypeRef;
        if (jClassRef == null) {
            return getClassLoader().loadClass("void");
        }
        return jClassRef.getRefClass();
    }

    @Override // org.apache.xmlbeans.impl.jam.JMethod
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JMethod
    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JMethod
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JMethod
    public boolean isNative() {
        return Modifier.isNative(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JMethod
    public boolean isSynchronized() {
        return Modifier.isSynchronized(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public void accept(MVisitor mVisitor) {
        mVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public void accept(JVisitor jVisitor) {
        jVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.InvokableImpl, org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write(Modifier.toString(getModifiers()));
        stringWriter.write(32);
        JClass returnType = getReturnType();
        if (returnType == null) {
            stringWriter.write("void ");
        } else {
            stringWriter.write(returnType.getQualifiedName());
            stringWriter.write(32);
        }
        stringWriter.write(getSimpleName());
        stringWriter.write(40);
        JParameter[] parameters = getParameters();
        if (parameters != null && parameters.length > 0) {
            for (int i = 0; i < parameters.length; i++) {
                stringWriter.write(parameters[i].getType().getQualifiedName());
                if (i < parameters.length - 1) {
                    stringWriter.write(44);
                }
            }
        }
        stringWriter.write(41);
        JClass[] exceptionTypes = getExceptionTypes();
        if (exceptionTypes != null && exceptionTypes.length > 0) {
            stringWriter.write(" throws ");
            for (int i2 = 0; i2 < exceptionTypes.length; i2++) {
                stringWriter.write(exceptionTypes[i2].getQualifiedName());
                if (i2 < exceptionTypes.length - 1) {
                    stringWriter.write(44);
                }
            }
        }
        return stringWriter.toString();
    }
}
