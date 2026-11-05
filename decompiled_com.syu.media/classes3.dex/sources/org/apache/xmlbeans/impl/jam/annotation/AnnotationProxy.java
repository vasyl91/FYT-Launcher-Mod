package org.apache.xmlbeans.impl.jam.annotation;

import org.apache.xmlbeans.impl.jam.JAnnotationValue;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;
import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class AnnotationProxy {
    private static final String DEFAULT_NVPAIR_DELIMS = "\n\r";
    public static final String SINGLE_MEMBER_NAME = "value";
    protected JamServiceContext mContext;

    public abstract JAnnotationValue[] getValues();

    public abstract void setValue(String str, Object obj, JClass jClass);

    public void init(JamServiceContext jamServiceContext) {
        if (jamServiceContext == null) {
            throw new IllegalArgumentException("null logger");
        }
        this.mContext = jamServiceContext;
    }

    public JAnnotationValue getValue(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null name");
        }
        String strTrim = str.trim();
        JAnnotationValue[] values = getValues();
        for (int i = 0; i < values.length; i++) {
            if (strTrim.equals(values[i].getName())) {
                return values[i];
            }
        }
        return null;
    }

    protected JamLogger getLogger() {
        return this.mContext.getLogger();
    }
}
