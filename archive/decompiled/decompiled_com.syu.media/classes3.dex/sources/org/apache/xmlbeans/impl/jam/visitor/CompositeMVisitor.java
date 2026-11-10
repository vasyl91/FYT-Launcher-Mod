package org.apache.xmlbeans.impl.jam.visitor;

import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MComment;
import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CompositeMVisitor extends MVisitor {
    private MVisitor[] mVisitors;

    public CompositeMVisitor(MVisitor[] mVisitorArr) {
        if (mVisitorArr == null) {
            throw new IllegalArgumentException("null visitors");
        }
        this.mVisitors = mVisitorArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MPackage mPackage) {
        int i = 0;
        while (true) {
            MVisitor[] mVisitorArr = this.mVisitors;
            if (i >= mVisitorArr.length) {
                return;
            }
            mVisitorArr[i].visit(mPackage);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MClass mClass) {
        int i = 0;
        while (true) {
            MVisitor[] mVisitorArr = this.mVisitors;
            if (i >= mVisitorArr.length) {
                return;
            }
            mVisitorArr[i].visit(mClass);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MConstructor mConstructor) {
        int i = 0;
        while (true) {
            MVisitor[] mVisitorArr = this.mVisitors;
            if (i >= mVisitorArr.length) {
                return;
            }
            mVisitorArr[i].visit(mConstructor);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MField mField) {
        int i = 0;
        while (true) {
            MVisitor[] mVisitorArr = this.mVisitors;
            if (i >= mVisitorArr.length) {
                return;
            }
            mVisitorArr[i].visit(mField);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MMethod mMethod) {
        int i = 0;
        while (true) {
            MVisitor[] mVisitorArr = this.mVisitors;
            if (i >= mVisitorArr.length) {
                return;
            }
            mVisitorArr[i].visit(mMethod);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MParameter mParameter) {
        int i = 0;
        while (true) {
            MVisitor[] mVisitorArr = this.mVisitors;
            if (i >= mVisitorArr.length) {
                return;
            }
            mVisitorArr[i].visit(mParameter);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MAnnotation mAnnotation) {
        int i = 0;
        while (true) {
            MVisitor[] mVisitorArr = this.mVisitors;
            if (i >= mVisitorArr.length) {
                return;
            }
            mVisitorArr[i].visit(mAnnotation);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MComment mComment) {
        int i = 0;
        while (true) {
            MVisitor[] mVisitorArr = this.mVisitors;
            if (i >= mVisitorArr.length) {
                return;
            }
            mVisitorArr[i].visit(mComment);
            i++;
        }
    }
}
