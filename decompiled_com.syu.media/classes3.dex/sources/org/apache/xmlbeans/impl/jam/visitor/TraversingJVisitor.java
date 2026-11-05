package org.apache.xmlbeans.impl.jam.visitor;

import org.apache.xmlbeans.impl.jam.JAnnotatedElement;
import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JComment;
import org.apache.xmlbeans.impl.jam.JConstructor;
import org.apache.xmlbeans.impl.jam.JField;
import org.apache.xmlbeans.impl.jam.JInvokable;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JPackage;
import org.apache.xmlbeans.impl.jam.JParameter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class TraversingJVisitor extends JVisitor {
    private JVisitor mDelegate;

    public TraversingJVisitor(JVisitor jVisitor) {
        if (jVisitor == null) {
            throw new IllegalArgumentException("null jv");
        }
        this.mDelegate = jVisitor;
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JPackage jPackage) {
        jPackage.accept(this.mDelegate);
        for (JClass jClass : jPackage.getClasses()) {
            visit(jClass);
        }
        visitAnnotations(jPackage);
        visitComment(jPackage);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JClass jClass) {
        jClass.accept(this.mDelegate);
        for (JField jField : jClass.getDeclaredFields()) {
            visit(jField);
        }
        for (JConstructor jConstructor : jClass.getConstructors()) {
            visit(jConstructor);
        }
        for (JMethod jMethod : jClass.getMethods()) {
            visit(jMethod);
        }
        visitAnnotations(jClass);
        visitComment(jClass);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JField jField) {
        jField.accept(this.mDelegate);
        visitAnnotations(jField);
        visitComment(jField);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JConstructor jConstructor) {
        jConstructor.accept(this.mDelegate);
        visitParameters(jConstructor);
        visitAnnotations(jConstructor);
        visitComment(jConstructor);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JMethod jMethod) {
        jMethod.accept(this.mDelegate);
        visitParameters(jMethod);
        visitAnnotations(jMethod);
        visitComment(jMethod);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JParameter jParameter) {
        jParameter.accept(this.mDelegate);
        visitAnnotations(jParameter);
        visitComment(jParameter);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JAnnotation jAnnotation) {
        jAnnotation.accept(this.mDelegate);
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JComment jComment) {
        jComment.accept(this.mDelegate);
    }

    private void visitParameters(JInvokable jInvokable) {
        for (JParameter jParameter : jInvokable.getParameters()) {
            visit(jParameter);
        }
    }

    private void visitAnnotations(JAnnotatedElement jAnnotatedElement) {
        for (JAnnotation jAnnotation : jAnnotatedElement.getAnnotations()) {
            visit(jAnnotation);
        }
    }

    private void visitComment(JAnnotatedElement jAnnotatedElement) {
        JComment comment = jAnnotatedElement.getComment();
        if (comment != null) {
            visit(comment);
        }
    }
}
