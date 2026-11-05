package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JComment;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JProperty;
import org.apache.xmlbeans.impl.jam.JSourcePosition;
import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class PropertyImpl extends AnnotatedElementImpl implements JProperty {
    private JMethod mGetter;
    private String mName;
    private JMethod mSetter;
    private JClassRef mTypeRef;

    public PropertyImpl(String str, JMethod jMethod, JMethod jMethod2, String str2) {
        super((ElementImpl) (jMethod != null ? jMethod.getParent() : jMethod2.getParent()));
        this.mName = str;
        this.mGetter = jMethod;
        this.mSetter = jMethod2;
        this.mTypeRef = QualifiedJClassRef.create(str2, (ClassImpl) (jMethod != null ? jMethod.getContainingClass() : jMethod2.getContainingClass()));
        initAnnotations();
    }

    @Override // org.apache.xmlbeans.impl.jam.JProperty
    public JClass getType() {
        return this.mTypeRef.getRefClass();
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementImpl, org.apache.xmlbeans.impl.jam.JElement
    public String getSimpleName() {
        return this.mName;
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        return getParent().getQualifiedName() + "." + getSimpleName();
    }

    @Override // org.apache.xmlbeans.impl.jam.JProperty
    public JMethod getSetter() {
        return this.mSetter;
    }

    @Override // org.apache.xmlbeans.impl.jam.JProperty
    public JMethod getGetter() {
        return this.mGetter;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.AnnotatedElementImpl, org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotation[] getAnnotations() {
        JMethod jMethod = this.mGetter;
        JAnnotation[] annotations = jMethod == null ? ElementImpl.NO_ANNOTATION : jMethod.getAnnotations();
        JMethod jMethod2 = this.mSetter;
        return combine(annotations, jMethod2 == null ? ElementImpl.NO_ANNOTATION : jMethod2.getAnnotations());
    }

    public void setSetter(JMethod jMethod) {
        this.mSetter = jMethod;
    }

    public void setGetter(JMethod jMethod) {
        this.mGetter = jMethod;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.AnnotatedElementImpl, org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotation getAnnotation(String str) {
        JMethod jMethod = this.mGetter;
        JAnnotation annotation = jMethod != null ? jMethod.getAnnotation(str) : null;
        if (annotation != null) {
            return annotation;
        }
        JMethod jMethod2 = this.mSetter;
        if (jMethod2 != null) {
            return jMethod2.getAnnotation(str);
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.AnnotatedElementImpl, org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JComment getComment() {
        JMethod jMethod = this.mGetter;
        if (jMethod != null) {
            return jMethod.getComment();
        }
        JMethod jMethod2 = this.mSetter;
        if (jMethod2 != null) {
            return jMethod2.getComment();
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementImpl, org.apache.xmlbeans.impl.jam.JElement
    public JSourcePosition getSourcePosition() {
        JMethod jMethod = this.mGetter;
        if (jMethod == null) {
            jMethod = this.mSetter;
        }
        return jMethod.getSourcePosition();
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public void accept(JVisitor jVisitor) {
        JMethod jMethod = this.mGetter;
        if (jMethod != null) {
            jVisitor.visit(jMethod);
        }
        JMethod jMethod2 = this.mSetter;
        if (jMethod2 != null) {
            jVisitor.visit(jMethod2);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementImpl, org.apache.xmlbeans.impl.jam.JElement
    public String toString() {
        return getQualifiedName();
    }

    private void initAnnotations() {
        JMethod jMethod = this.mSetter;
        if (jMethod != null) {
            for (JAnnotation jAnnotation : jMethod.getAnnotations()) {
                super.addAnnotation(jAnnotation);
            }
            for (JAnnotation jAnnotation2 : this.mSetter.getAllJavadocTags()) {
                super.addAnnotation(jAnnotation2);
            }
        }
        JMethod jMethod2 = this.mGetter;
        if (jMethod2 != null) {
            for (JAnnotation jAnnotation3 : jMethod2.getAnnotations()) {
                super.addAnnotation(jAnnotation3);
            }
            for (JAnnotation jAnnotation4 : this.mGetter.getAllJavadocTags()) {
                super.addAnnotation(jAnnotation4);
            }
        }
    }

    private JAnnotation[] combine(JAnnotation[] jAnnotationArr, JAnnotation[] jAnnotationArr2) {
        if (jAnnotationArr.length == 0) {
            return jAnnotationArr2;
        }
        if (jAnnotationArr2.length == 0) {
            return jAnnotationArr;
        }
        JAnnotation[] jAnnotationArr3 = new JAnnotation[jAnnotationArr.length + jAnnotationArr2.length];
        System.arraycopy(jAnnotationArr, 0, jAnnotationArr3, 0, jAnnotationArr.length);
        System.arraycopy(jAnnotationArr2, 0, jAnnotationArr3, jAnnotationArr.length, jAnnotationArr2.length);
        return jAnnotationArr3;
    }

    private JComment[] combine(JComment[] jCommentArr, JComment[] jCommentArr2) {
        if (jCommentArr.length == 0) {
            return jCommentArr2;
        }
        if (jCommentArr2.length == 0) {
            return jCommentArr;
        }
        JComment[] jCommentArr3 = new JComment[jCommentArr.length + jCommentArr2.length];
        System.arraycopy(jCommentArr, 0, jCommentArr3, 0, jCommentArr.length);
        System.arraycopy(jCommentArr2, 0, jCommentArr3, jCommentArr.length, jCommentArr2.length);
        return jCommentArr3;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public void accept(MVisitor mVisitor) {
        JMethod jMethod = this.mGetter;
        if (jMethod != null) {
            mVisitor.visit((MMethod) jMethod);
        }
        JMethod jMethod2 = this.mSetter;
        if (jMethod2 != null) {
            mVisitor.visit((MMethod) jMethod2);
        }
    }
}
