package org.apache.poi.ddf;

import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherOptRecord extends AbstractEscherOptRecord {
    public static final String RECORD_DESCRIPTION = "msofbtOPT";
    public static final short RECORD_ID = -4085;

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Opt";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getInstance() {
        setInstance((short) getEscherProperties().size());
        return super.getInstance();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    @Internal
    public short getOptions() {
        getInstance();
        getVersion();
        return super.getOptions();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getVersion() {
        setVersion((short) 3);
        return super.getVersion();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public void setVersion(short s) {
        if (s != 3) {
            throw new IllegalArgumentException("msofbtOPT can have only '0x3' version");
        }
        super.setVersion(s);
    }
}
