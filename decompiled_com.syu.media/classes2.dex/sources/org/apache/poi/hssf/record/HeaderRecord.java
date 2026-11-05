package org.apache.poi.hssf.record;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HeaderRecord extends HeaderFooterBase implements Cloneable {
    public static final short sid = 20;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 20;
    }

    public HeaderRecord(String str) {
        super(str);
    }

    public HeaderRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[HEADER]\n    .header = ");
        stringBuffer.append(getText()).append("\n[/HEADER]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public HeaderRecord clone() {
        return new HeaderRecord(getText());
    }
}
