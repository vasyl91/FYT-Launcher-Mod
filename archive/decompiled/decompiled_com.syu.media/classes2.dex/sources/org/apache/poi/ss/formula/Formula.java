package org.apache.poi.ss.formula;

import java.util.Arrays;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Formula {
    private static final Formula EMPTY = new Formula(new byte[0], 0);
    private final byte[] _byteEncoding;
    private final int _encodedTokenLen;

    public Formula copy() {
        return this;
    }

    private Formula(byte[] bArr, int i) {
        this._byteEncoding = (byte[]) bArr.clone();
        this._encodedTokenLen = i;
    }

    public static Formula read(int i, LittleEndianInput littleEndianInput) {
        return read(i, littleEndianInput, i);
    }

    public static Formula read(int i, LittleEndianInput littleEndianInput, int i2) {
        byte[] bArr = new byte[i2];
        littleEndianInput.readFully(bArr);
        return new Formula(bArr, i);
    }

    public Ptg[] getTokens() {
        return Ptg.readTokens(this._encodedTokenLen, new LittleEndianByteArrayInputStream(this._byteEncoding));
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._encodedTokenLen);
        littleEndianOutput.write(this._byteEncoding);
    }

    public void serializeTokens(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(this._byteEncoding, 0, this._encodedTokenLen);
    }

    public void serializeArrayConstantData(LittleEndianOutput littleEndianOutput) {
        byte[] bArr = this._byteEncoding;
        int length = bArr.length;
        int i = this._encodedTokenLen;
        littleEndianOutput.write(bArr, i, length - i);
    }

    public int getEncodedSize() {
        return this._byteEncoding.length + 2;
    }

    public int getEncodedTokenSize() {
        return this._encodedTokenLen;
    }

    public static Formula create(Ptg[] ptgArr) {
        if (ptgArr == null || ptgArr.length < 1) {
            return EMPTY;
        }
        byte[] bArr = new byte[Ptg.getEncodedSize(ptgArr)];
        Ptg.serializePtgs(ptgArr, bArr, 0);
        return new Formula(bArr, Ptg.getEncodedSizeWithoutArrayData(ptgArr));
    }

    public static Ptg[] getTokens(Formula formula) {
        if (formula == null) {
            return null;
        }
        return formula.getTokens();
    }

    public CellReference getExpReference() {
        byte[] bArr = this._byteEncoding;
        if (bArr.length != 5) {
            return null;
        }
        byte b = bArr[0];
        if (b == 1 || b == 2) {
            return new CellReference(LittleEndian.getUShort(bArr, 1), LittleEndian.getUShort(bArr, 3));
        }
        return null;
    }

    public boolean isSame(Formula formula) {
        return Arrays.equals(this._byteEncoding, formula._byteEncoding);
    }
}
