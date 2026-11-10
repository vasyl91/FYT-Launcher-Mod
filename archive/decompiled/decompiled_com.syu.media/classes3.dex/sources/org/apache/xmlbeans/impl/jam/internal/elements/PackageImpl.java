package org.apache.xmlbeans.impl.jam.internal.elements;

import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class PackageImpl extends AnnotatedElementImpl implements MPackage {
    private String mName;
    private List mRootClasses;

    public PackageImpl(ElementContext elementContext, String str) {
        super(elementContext);
        this.mRootClasses = new ArrayList();
        this.mName = str;
        int iLastIndexOf = str.lastIndexOf(46);
        setSimpleName(iLastIndexOf == -1 ? this.mName : this.mName.substring(iLastIndexOf + 1));
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        return this.mName;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public void accept(MVisitor mVisitor) {
        mVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public void accept(JVisitor jVisitor) {
        jVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.JPackage
    public JClass[] getClasses() {
        JClass[] jClassArr = new JClass[this.mRootClasses.size()];
        this.mRootClasses.toArray(jClassArr);
        return jClassArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MPackage
    public MClass[] getMutableClasses() {
        MClass[] mClassArr = new MClass[this.mRootClasses.size()];
        this.mRootClasses.toArray(mClassArr);
        return mClassArr;
    }
}
