package org.apache.xmlbeans.impl.jam.internal.elements;

import java.io.StringWriter;
import java.lang.reflect.Modifier;
import org.apache.xmlbeans.impl.jam.JParameter;
import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class ConstructorImpl extends InvokableImpl implements MConstructor {
    ConstructorImpl(ClassImpl classImpl) {
        super(classImpl);
        setSimpleName(classImpl.getSimpleName());
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
        return stringWriter.toString();
    }
}
