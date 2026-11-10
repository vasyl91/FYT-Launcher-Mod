package org.apache.xmlbeans.impl.jam.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.impl.jam.JAnnotationValue;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.internal.elements.AnnotationValueImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class TypedAnnotationProxyBase extends AnnotationProxy {
    private List mValues = null;

    protected TypedAnnotationProxyBase() {
    }

    @Override // org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy
    public void setValue(String str, Object obj, JClass jClass) {
        if (str == null) {
            throw new IllegalArgumentException("null name");
        }
        if (obj == null) {
            throw new IllegalArgumentException("null value");
        }
        if (this.mValues == null) {
            this.mValues = new ArrayList();
        }
        this.mValues.add(new AnnotationValueImpl((ElementContext) this.mContext, str, obj, jClass));
        Method setterFor = getSetterFor(str, obj.getClass());
        if (setterFor == null) {
            return;
        }
        try {
            setterFor.invoke(this, obj);
        } catch (IllegalAccessException e) {
            getLogger().warning(e);
        } catch (InvocationTargetException e2) {
            getLogger().warning(e2);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy
    public JAnnotationValue[] getValues() {
        List list = this.mValues;
        if (list == null) {
            return new JAnnotationValue[0];
        }
        JAnnotationValue[] jAnnotationValueArr = new JAnnotationValue[list.size()];
        this.mValues.toArray(jAnnotationValueArr);
        return jAnnotationValueArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Method getSetterFor(String str, Class cls) {
        try {
            return getClass().getMethod("set" + str, cls);
        } catch (NoSuchMethodException e) {
            getLogger().warning(e);
            return null;
        }
    }
}
