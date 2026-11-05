package org.apache.xmlbeans.impl.jam.internal.parser;

import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
class ParamStruct {
    private String mName;
    private String mType;

    public ParamStruct(String str, String str2) {
        init(str, str2);
    }

    public void init(String str, String str2) {
        this.mType = str;
        this.mName = str2;
    }

    public MParameter createParameter(MInvokable mInvokable) {
        if (mInvokable == null) {
            throw new IllegalArgumentException("null invokable");
        }
        MParameter mParameterAddNewParameter = mInvokable.addNewParameter();
        mParameterAddNewParameter.setSimpleName(this.mName);
        mParameterAddNewParameter.setUnqualifiedType(this.mType);
        return mParameterAddNewParameter;
    }
}
