package org.apache.poi.hpsf;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class VariantTypeException extends HPSFException {
    private Object value;
    private long variantType;

    public VariantTypeException(long j, Object obj, String str) {
        super(str);
        this.variantType = j;
        this.value = obj;
    }

    public long getVariantType() {
        return this.variantType;
    }

    public Object getValue() {
        return this.value;
    }
}
