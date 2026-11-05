package org.apache.poi.hssf.record.common;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FeatProtection implements SharedFeature {
    public static long HAS_SELF_RELATIVE_SECURITY_FEATURE = 1;
    public static long NO_SELF_RELATIVE_SECURITY_FEATURE;
    private int fSD;
    private int passwordVerifier;
    private byte[] securityDescriptor;
    private String title;

    public FeatProtection() {
        this.securityDescriptor = new byte[0];
    }

    public FeatProtection(RecordInputStream recordInputStream) {
        this.fSD = recordInputStream.readInt();
        this.passwordVerifier = recordInputStream.readInt();
        this.title = StringUtil.readUnicodeString(recordInputStream);
        this.securityDescriptor = recordInputStream.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(" [FEATURE PROTECTION]\n");
        stringBuffer.append("   Self Relative = " + this.fSD);
        stringBuffer.append("   Password Verifier = " + this.passwordVerifier);
        stringBuffer.append("   Title = " + this.title);
        stringBuffer.append("   Security Descriptor Size = " + this.securityDescriptor.length);
        stringBuffer.append(" [/FEATURE PROTECTION]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.fSD);
        littleEndianOutput.writeInt(this.passwordVerifier);
        StringUtil.writeUnicodeString(littleEndianOutput, this.title);
        littleEndianOutput.write(this.securityDescriptor);
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public int getDataSize() {
        return StringUtil.getEncodedSize(this.title) + 8 + this.securityDescriptor.length;
    }

    public int getPasswordVerifier() {
        return this.passwordVerifier;
    }

    public void setPasswordVerifier(int i) {
        this.passwordVerifier = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getFSD() {
        return this.fSD;
    }
}
