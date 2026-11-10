package org.apache.xmlbeans.impl.jam.internal.elements;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JParameter;
import org.apache.xmlbeans.impl.jam.internal.classrefs.DirectJClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.UnqualifiedJClassRef;
import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class InvokableImpl extends MemberImpl implements MInvokable {
    private List mExceptionClassRefs;
    private List mParameters;

    protected InvokableImpl(ClassImpl classImpl) {
        super(classImpl);
        this.mExceptionClassRefs = null;
        this.mParameters = null;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MInvokable
    public void addException(JClass jClass) {
        if (jClass == null) {
            throw new IllegalArgumentException("null exception class");
        }
        if (this.mExceptionClassRefs == null) {
            this.mExceptionClassRefs = new ArrayList();
        }
        this.mExceptionClassRefs.add(DirectJClassRef.create(jClass));
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MInvokable
    public void addException(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null qcname");
        }
        if (this.mExceptionClassRefs == null) {
            this.mExceptionClassRefs = new ArrayList();
        }
        this.mExceptionClassRefs.add(QualifiedJClassRef.create(str, (ClassImpl) getContainingClass()));
    }

    public void addUnqualifiedException(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null qcname");
        }
        if (this.mExceptionClassRefs == null) {
            this.mExceptionClassRefs = new ArrayList();
        }
        this.mExceptionClassRefs.add(UnqualifiedJClassRef.create(str, (ClassImpl) getContainingClass()));
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MInvokable
    public void removeException(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null classname");
        }
        List list = this.mExceptionClassRefs;
        if (list != null) {
            list.remove(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MInvokable
    public void removeException(JClass jClass) {
        removeException(jClass.getQualifiedName());
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MInvokable
    public MParameter addNewParameter() {
        if (this.mParameters == null) {
            this.mParameters = new ArrayList();
        }
        ParameterImpl parameterImpl = new ParameterImpl(defaultName(this.mParameters.size()), this, "java.lang.Object");
        this.mParameters.add(parameterImpl);
        return parameterImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MInvokable
    public void removeParameter(MParameter mParameter) {
        List list = this.mParameters;
        if (list != null) {
            list.remove(mParameter);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MInvokable
    public MParameter[] getMutableParameters() {
        List list = this.mParameters;
        if (list == null || list.size() == 0) {
            return new MParameter[0];
        }
        MParameter[] mParameterArr = new MParameter[this.mParameters.size()];
        this.mParameters.toArray(mParameterArr);
        return mParameterArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JInvokable
    public JParameter[] getParameters() {
        return getMutableParameters();
    }

    @Override // org.apache.xmlbeans.impl.jam.JInvokable
    public JClass[] getExceptionTypes() {
        List list = this.mExceptionClassRefs;
        if (list == null || list.size() == 0) {
            return new JClass[0];
        }
        int size = this.mExceptionClassRefs.size();
        JClass[] jClassArr = new JClass[size];
        for (int i = 0; i < size; i++) {
            jClassArr[i] = ((JClassRef) this.mExceptionClassRefs.get(i)).getRefClass();
        }
        return jClassArr;
    }

    public String getQualifiedName() {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write(getContainingClass().getQualifiedName());
        stringWriter.write(46);
        stringWriter.write(getSimpleName());
        stringWriter.write(40);
        JParameter[] parameters = getParameters();
        for (int i = 0; i < parameters.length; i++) {
            stringWriter.write(parameters[i].getType().getQualifiedName());
            if (i < parameters.length - 1) {
                stringWriter.write(", ");
            }
        }
        stringWriter.write(41);
        return stringWriter.toString();
    }

    public void setUnqualifiedThrows(List list) {
        if (list == null || list.size() == 0) {
            this.mExceptionClassRefs = null;
            return;
        }
        this.mExceptionClassRefs = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.mExceptionClassRefs.add(UnqualifiedJClassRef.create((String) list.get(i), (ClassImpl) getContainingClass()));
        }
    }
}
