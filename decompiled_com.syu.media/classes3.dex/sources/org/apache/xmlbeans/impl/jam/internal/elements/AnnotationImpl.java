package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.JAnnotationValue;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class AnnotationImpl extends ElementImpl implements MAnnotation {
    private Object mAnnotationInstance;
    private AnnotationProxy mProxy;
    private String mQualifiedName;

    AnnotationImpl(ElementContext elementContext, AnnotationProxy annotationProxy, String str) {
        super(elementContext);
        this.mAnnotationInstance = null;
        this.mQualifiedName = null;
        if (annotationProxy == null) {
            throw new IllegalArgumentException("null proxy");
        }
        if (str == null) {
            throw new IllegalArgumentException("null qn");
        }
        this.mProxy = annotationProxy;
        setSimpleName(str.substring(str.lastIndexOf(46) + 1));
        this.mQualifiedName = str;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotation
    public Object getProxy() {
        return this.mProxy;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotation
    public JAnnotationValue[] getValues() {
        return this.mProxy.getValues();
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotation
    public JAnnotationValue getValue(String str) {
        return this.mProxy.getValue(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotation
    public Object getAnnotationInstance() {
        return this.mAnnotationInstance;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MAnnotation
    public void setAnnotationInstance(Object obj) {
        this.mAnnotationInstance = obj;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MAnnotation
    public void setSimpleValue(String str, Object obj, JClass jClass) {
        if (str == null) {
            throw new IllegalArgumentException("null name");
        }
        if (jClass == null) {
            throw new IllegalArgumentException("null type");
        }
        if (obj == null) {
            throw new IllegalArgumentException("null value");
        }
        this.mProxy.setValue(str, obj, jClass);
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MAnnotation
    public MAnnotation createNestedValue(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("null name");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("null typename");
        }
        AnnotationImpl annotationImpl = new AnnotationImpl(getContext(), getContext().createAnnotationProxy(str2), str2);
        this.mProxy.setValue(str, annotationImpl, getContext().getClassLoader().loadClass(str2));
        return annotationImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MAnnotation
    public MAnnotation[] createNestedValueArray(String str, String str2, int i) {
        if (str == null) {
            throw new IllegalArgumentException("null name");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("null typename");
        }
        if (i < 0) {
            throw new IllegalArgumentException("dimensions = " + i);
        }
        MAnnotation[] mAnnotationArr = new MAnnotation[i];
        for (int i2 = 0; i2 < i; i2++) {
            mAnnotationArr[i2] = new AnnotationImpl(getContext(), getContext().createAnnotationProxy(str2), str2);
        }
        this.mProxy.setValue(str, mAnnotationArr, getContext().getClassLoader().loadClass("[L" + str2 + ";"));
        return mAnnotationArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        return this.mQualifiedName;
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
