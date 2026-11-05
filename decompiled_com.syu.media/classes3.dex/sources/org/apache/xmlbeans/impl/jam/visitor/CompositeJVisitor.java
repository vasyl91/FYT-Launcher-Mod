package org.apache.xmlbeans.impl.jam.visitor;

import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JComment;
import org.apache.xmlbeans.impl.jam.JConstructor;
import org.apache.xmlbeans.impl.jam.JField;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JPackage;
import org.apache.xmlbeans.impl.jam.JParameter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CompositeJVisitor extends JVisitor {
    private JVisitor[] mVisitors;

    public CompositeJVisitor(JVisitor[] jVisitorArr) {
        if (jVisitorArr == null) {
            throw new IllegalArgumentException("null visitors");
        }
        this.mVisitors = jVisitorArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JPackage jPackage) {
        int i = 0;
        while (true) {
            JVisitor[] jVisitorArr = this.mVisitors;
            if (i >= jVisitorArr.length) {
                return;
            }
            jVisitorArr[i].visit(jPackage);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JClass jClass) {
        int i = 0;
        while (true) {
            JVisitor[] jVisitorArr = this.mVisitors;
            if (i >= jVisitorArr.length) {
                return;
            }
            jVisitorArr[i].visit(jClass);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JConstructor jConstructor) {
        int i = 0;
        while (true) {
            JVisitor[] jVisitorArr = this.mVisitors;
            if (i >= jVisitorArr.length) {
                return;
            }
            jVisitorArr[i].visit(jConstructor);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JField jField) {
        int i = 0;
        while (true) {
            JVisitor[] jVisitorArr = this.mVisitors;
            if (i >= jVisitorArr.length) {
                return;
            }
            jVisitorArr[i].visit(jField);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JMethod jMethod) {
        int i = 0;
        while (true) {
            JVisitor[] jVisitorArr = this.mVisitors;
            if (i >= jVisitorArr.length) {
                return;
            }
            jVisitorArr[i].visit(jMethod);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JParameter jParameter) {
        int i = 0;
        while (true) {
            JVisitor[] jVisitorArr = this.mVisitors;
            if (i >= jVisitorArr.length) {
                return;
            }
            jVisitorArr[i].visit(jParameter);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JAnnotation jAnnotation) {
        int i = 0;
        while (true) {
            JVisitor[] jVisitorArr = this.mVisitors;
            if (i >= jVisitorArr.length) {
                return;
            }
            jVisitorArr[i].visit(jAnnotation);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.JVisitor
    public void visit(JComment jComment) {
        int i = 0;
        while (true) {
            JVisitor[] jVisitorArr = this.mVisitors;
            if (i >= jVisitorArr.length) {
                return;
            }
            jVisitorArr[i].visit(jComment);
            i++;
        }
    }
}
