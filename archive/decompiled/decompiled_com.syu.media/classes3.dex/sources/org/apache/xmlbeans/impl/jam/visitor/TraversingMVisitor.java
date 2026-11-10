package org.apache.xmlbeans.impl.jam.visitor;

import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MComment;
import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class TraversingMVisitor extends MVisitor {
    private MVisitor mDelegate;

    public TraversingMVisitor(MVisitor mVisitor) {
        if (mVisitor == null) {
            throw new IllegalArgumentException("null jv");
        }
        this.mDelegate = mVisitor;
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MPackage mPackage) {
        mPackage.accept(this.mDelegate);
        for (MClass mClass : mPackage.getMutableClasses()) {
            visit(mClass);
        }
        visitAnnotations(mPackage);
        visitComment(mPackage);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MClass mClass) {
        mClass.accept(this.mDelegate);
        for (MField mField : mClass.getMutableFields()) {
            visit(mField);
        }
        for (MConstructor mConstructor : mClass.getMutableConstructors()) {
            visit(mConstructor);
        }
        for (MMethod mMethod : mClass.getMutableMethods()) {
            visit(mMethod);
        }
        visitAnnotations(mClass);
        visitComment(mClass);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MField mField) {
        mField.accept(this.mDelegate);
        visitAnnotations(mField);
        visitComment(mField);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MConstructor mConstructor) {
        mConstructor.accept(this.mDelegate);
        visitParameters(mConstructor);
        visitAnnotations(mConstructor);
        visitComment(mConstructor);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MMethod mMethod) {
        mMethod.accept(this.mDelegate);
        visitParameters(mMethod);
        visitAnnotations(mMethod);
        visitComment(mMethod);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MParameter mParameter) {
        mParameter.accept(this.mDelegate);
        visitAnnotations(mParameter);
        visitComment(mParameter);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MAnnotation mAnnotation) {
        mAnnotation.accept(this.mDelegate);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MComment mComment) {
        mComment.accept(this.mDelegate);
    }

    private void visitParameters(MInvokable mInvokable) {
        for (MParameter mParameter : mInvokable.getMutableParameters()) {
            visit(mParameter);
        }
    }

    private void visitAnnotations(MAnnotatedElement mAnnotatedElement) {
        for (MAnnotation mAnnotation : mAnnotatedElement.getMutableAnnotations()) {
            visit(mAnnotation);
        }
    }

    private void visitComment(MAnnotatedElement mAnnotatedElement) {
        MComment mutableComment = mAnnotatedElement.getMutableComment();
        if (mutableComment != null) {
            visit(mutableComment);
        }
    }
}
