package org.apache.xmlbeans.impl.jam.internal.parser;

import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.impl.jam.mutable.MInvokable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ParamStructPool {
    private static final boolean VERBOSE = true;
    private List mList = new ArrayList();
    private int mLength = 0;

    public void setParametersOn(MInvokable mInvokable) {
        for (int i = 0; i < this.mLength; i++) {
            ((ParamStruct) this.mList.get(i)).createParameter(mInvokable);
        }
    }

    public void add(String str, String str2) {
        int i = this.mLength + 1;
        this.mLength = i;
        if (i >= this.mList.size()) {
            this.mList.add(new ParamStruct(str, str2));
        } else {
            ((ParamStruct) this.mList.get(this.mLength)).init(str, str2);
        }
    }

    public void clear() {
        this.mLength = 0;
    }
}
