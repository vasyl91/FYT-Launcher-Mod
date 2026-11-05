package org.apache.xmlbeans.impl.jam.internal.elements;

import java.lang.reflect.Modifier;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JElement;
import org.apache.xmlbeans.impl.jam.JMember;
import org.apache.xmlbeans.impl.jam.mutable.MMember;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class MemberImpl extends AnnotatedElementImpl implements MMember {
    private int mModifiers;

    protected MemberImpl(ElementImpl elementImpl) {
        super(elementImpl);
        this.mModifiers = 0;
    }

    protected MemberImpl(ElementContext elementContext) {
        super(elementContext);
        this.mModifiers = 0;
    }

    @Override // org.apache.xmlbeans.impl.jam.JMember
    public JClass getContainingClass() {
        JElement parent = getParent();
        if (parent instanceof JClass) {
            return (JClass) parent;
        }
        if (parent instanceof JMember) {
            return ((JMember) parent).getContainingClass();
        }
        return null;
    }

    public int getModifiers() {
        return this.mModifiers;
    }

    @Override // org.apache.xmlbeans.impl.jam.JMember
    public boolean isPackagePrivate() {
        return (isPrivate() || isPublic() || isProtected()) ? false : true;
    }

    @Override // org.apache.xmlbeans.impl.jam.JMember
    public boolean isPrivate() {
        return Modifier.isPrivate(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JMember
    public boolean isProtected() {
        return Modifier.isProtected(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JMember
    public boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MMember
    public void setModifiers(int i) {
        this.mModifiers = i;
    }
}
