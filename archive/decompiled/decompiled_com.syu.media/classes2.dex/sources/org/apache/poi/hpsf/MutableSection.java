package org.apache.poi.hpsf;

import java.io.UnsupportedEncodingException;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
public class MutableSection extends Section {
    public MutableSection() {
    }

    public MutableSection(Section section) {
        super(section);
    }

    public MutableSection(byte[] bArr, int i) throws UnsupportedEncodingException {
        super(bArr, i);
    }
}
