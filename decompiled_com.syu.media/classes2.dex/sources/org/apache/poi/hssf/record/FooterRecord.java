package org.apache.poi.hssf.record;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FooterRecord extends HeaderFooterBase implements Cloneable {
    public static final short sid = 21;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 21;
    }

    public FooterRecord(String str) {
        super(str);
    }

    public FooterRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[FOOTER]\n    .footer = ");
        stringBuffer.append(getText()).append("\n[/FOOTER]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public FooterRecord clone() {
        return new FooterRecord(getText());
    }
}
