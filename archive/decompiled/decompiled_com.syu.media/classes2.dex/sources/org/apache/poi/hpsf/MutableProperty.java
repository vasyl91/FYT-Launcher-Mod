package org.apache.poi.hpsf;

import java.io.UnsupportedEncodingException;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
@Deprecated
public class MutableProperty extends Property {
    public MutableProperty() {
    }

    public MutableProperty(Property property) {
        super(property);
    }

    public MutableProperty(long j, long j2, Object obj) {
        super(j, j2, obj);
    }

    public MutableProperty(long j, byte[] bArr, long j2, int i, int i2) throws UnsupportedEncodingException {
        super(j, bArr, j2, i, i2);
    }

    public MutableProperty(long j, LittleEndianByteArrayInputStream littleEndianByteArrayInputStream, int i, int i2) throws UnsupportedEncodingException {
        super(j, littleEndianByteArrayInputStream, i, i2);
    }
}
