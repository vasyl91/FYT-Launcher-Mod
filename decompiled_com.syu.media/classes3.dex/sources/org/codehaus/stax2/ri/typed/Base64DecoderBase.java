package org.codehaus.stax2.ri.typed;

import org.codehaus.stax2.ri.Stax2Util;
import org.codehaus.stax2.typed.Base64Variant;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class Base64DecoderBase {
    static final int INT_SPACE = 32;
    static final int STATE_INITIAL = 0;
    static final int STATE_OUTPUT_1 = 6;
    static final int STATE_OUTPUT_2 = 5;
    static final int STATE_OUTPUT_3 = 4;
    static final int STATE_VALID_1 = 1;
    static final int STATE_VALID_2 = 2;
    static final int STATE_VALID_2_AND_PADDING = 7;
    static final int STATE_VALID_3 = 3;
    int _decodedData;
    Base64Variant _variant;
    int _state = 0;
    Stax2Util.ByteAggregator _byteAggr = null;

    public abstract int decode(byte[] bArr, int i, int i2) throws IllegalArgumentException;

    protected Base64DecoderBase() {
    }

    public final boolean hasData() {
        int i = this._state;
        return i >= 4 && i <= 6;
    }

    public final int endOfContent() {
        int i = this._state;
        if (i == 0 || i == 4 || i == 5 || i == 6) {
            return 0;
        }
        if (this._variant.usesPadding()) {
            return -1;
        }
        int i2 = this._state;
        if (i2 == 2) {
            this._state = 6;
            this._decodedData >>= 4;
            return 1;
        }
        if (i2 != 3) {
            return -1;
        }
        this._decodedData >>= 2;
        this._state = 5;
        return 2;
    }

    public byte[] decodeCompletely() {
        Stax2Util.ByteAggregator byteAggregator = getByteAggregator();
        byte[] bArrStartAggregation = byteAggregator.startAggregation();
        while (true) {
            int length = bArrStartAggregation.length;
            int i = 0;
            do {
                int iDecode = decode(bArrStartAggregation, i, length);
                if (iDecode < 1) {
                    int iEndOfContent = endOfContent();
                    if (iEndOfContent < 0) {
                        throw new IllegalArgumentException("Incomplete base64 triplet at the end of decoded content");
                    }
                    if (iEndOfContent <= 0) {
                        return byteAggregator.aggregateAll(bArrStartAggregation, i);
                    }
                } else {
                    i += iDecode;
                    length -= iDecode;
                }
            } while (length > 0);
            bArrStartAggregation = byteAggregator.addFullBlock(bArrStartAggregation);
        }
    }

    public Stax2Util.ByteAggregator getByteAggregator() {
        if (this._byteAggr == null) {
            this._byteAggr = new Stax2Util.ByteAggregator();
        }
        return this._byteAggr;
    }

    protected IllegalArgumentException reportInvalidChar(char c, int i) throws IllegalArgumentException {
        return reportInvalidChar(c, i, null);
    }

    protected IllegalArgumentException reportInvalidChar(char c, int i, String str) throws IllegalArgumentException {
        String str2;
        if (c <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (this._variant.usesPaddingChar(c)) {
            str2 = "Unexpected padding character ('" + this._variant.getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }
}
