package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ConstantTransformer<I, O> implements Transformer<I, O>, Serializable {
    public static final Transformer NULL_INSTANCE = new ConstantTransformer(null);
    private static final long serialVersionUID = 6374440726369055124L;
    private final O iConstant;

    public static <I, O> Transformer<I, O> nullTransformer() {
        return NULL_INSTANCE;
    }

    public static <I, O> Transformer<I, O> constantTransformer(O o) {
        if (o == null) {
            return nullTransformer();
        }
        return new ConstantTransformer(o);
    }

    public ConstantTransformer(O o) {
        this.iConstant = o;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i) {
        return this.iConstant;
    }

    public O getConstant() {
        return this.iConstant;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConstantTransformer)) {
            return false;
        }
        Object constant = ((ConstantTransformer) obj).getConstant();
        if (constant != getConstant()) {
            return constant != null && constant.equals(getConstant());
        }
        return true;
    }

    public int hashCode() {
        if (getConstant() != null) {
            return (-144463148) | getConstant().hashCode();
        }
        return -144463148;
    }
}
