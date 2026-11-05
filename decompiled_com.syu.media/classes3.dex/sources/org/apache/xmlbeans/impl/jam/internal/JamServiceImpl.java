package org.apache.xmlbeans.impl.jam.internal;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JamClassIterator;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.JamService;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JamServiceImpl implements JamService {
    private String[] mClassNames;
    private ElementContext mContext;

    public JamServiceImpl(ElementContext elementContext, String[] strArr) {
        if (elementContext == null) {
            throw new IllegalArgumentException("null jcl");
        }
        if (strArr == null) {
            throw new IllegalArgumentException("null classes");
        }
        this.mContext = elementContext;
        this.mClassNames = strArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JamService
    public JamClassLoader getClassLoader() {
        return this.mContext.getClassLoader();
    }

    @Override // org.apache.xmlbeans.impl.jam.JamService
    public String[] getClassNames() {
        return this.mClassNames;
    }

    @Override // org.apache.xmlbeans.impl.jam.JamService
    public JamClassIterator getClasses() {
        return new JamClassIterator(getClassLoader(), getClassNames());
    }

    @Override // org.apache.xmlbeans.impl.jam.JamService
    public JClass[] getAllClasses() {
        int length = this.mClassNames.length;
        JClass[] jClassArr = new JClass[length];
        for (int i = 0; i < length; i++) {
            jClassArr[i] = getClassLoader().loadClass(this.mClassNames[i]);
        }
        return jClassArr;
    }

    public void setClassNames(String[] strArr) {
        this.mClassNames = strArr;
    }
}
