package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JMethod;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface MMethod extends JMethod, MInvokable {
    void setReturnType(String str);

    void setReturnType(JClass jClass);

    void setUnqualifiedReturnType(String str);
}
