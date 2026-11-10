package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class HeaderFooterBase extends StandardRecord {
    private boolean field_2_hasMultibyte;
    private String field_3_text;

    protected HeaderFooterBase(String str) {
        setText(str);
    }

    protected HeaderFooterBase(RecordInputStream recordInputStream) {
        if (recordInputStream.remaining() > 0) {
            short s = recordInputStream.readShort();
            if (s == 0) {
                this.field_3_text = "";
                if (recordInputStream.remaining() == 0) {
                    return;
                }
            }
            boolean z = recordInputStream.readByte() != 0;
            this.field_2_hasMultibyte = z;
            if (z) {
                this.field_3_text = recordInputStream.readUnicodeLEString(s);
                return;
            } else {
                this.field_3_text = recordInputStream.readCompressedUnicode(s);
                return;
            }
        }
        this.field_3_text = "";
    }

    public final void setText(String str) {
        if (str == null) {
            throw new IllegalArgumentException("text must not be null");
        }
        this.field_2_hasMultibyte = StringUtil.hasMultibyte(str);
        this.field_3_text = str;
        if (getDataSize() > 8224) {
            throw new IllegalArgumentException("Header/Footer string too long (limit is 8224 bytes)");
        }
    }

    private int getTextLength() {
        return this.field_3_text.length();
    }

    public final String getText() {
        return this.field_3_text;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final void serialize(LittleEndianOutput littleEndianOutput) {
        if (getTextLength() > 0) {
            littleEndianOutput.writeShort(getTextLength());
            littleEndianOutput.writeByte(this.field_2_hasMultibyte ? 1 : 0);
            if (this.field_2_hasMultibyte) {
                StringUtil.putUnicodeLE(this.field_3_text, littleEndianOutput);
            } else {
                StringUtil.putCompressedUnicode(this.field_3_text, littleEndianOutput);
            }
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected final int getDataSize() {
        if (getTextLength() < 1) {
            return 0;
        }
        return (getTextLength() * (this.field_2_hasMultibyte ? 2 : 1)) + 3;
    }
}
