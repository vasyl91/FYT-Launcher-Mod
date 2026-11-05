package org.apache.xmlbeans.impl.jam.annotation;

import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.impl.jam.JAnnotationValue;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.internal.elements.AnnotationValueImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class DefaultAnnotationProxy extends AnnotationProxy {
    private List mValues = new ArrayList();

    @Override // org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy
    public JAnnotationValue[] getValues() {
        JAnnotationValue[] jAnnotationValueArr = new JAnnotationValue[this.mValues.size()];
        this.mValues.toArray(jAnnotationValueArr);
        return jAnnotationValueArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy
    public void setValue(String str, Object obj, JClass jClass) {
        if (str == null) {
            throw new IllegalArgumentException("null name");
        }
        if (jClass == null) {
            throw new IllegalArgumentException("null type");
        }
        if (obj == null) {
            throw new IllegalArgumentException("null value");
        }
        this.mValues.add(new AnnotationValueImpl((ElementContext) getLogger(), str.trim(), obj, jClass));
    }
}
