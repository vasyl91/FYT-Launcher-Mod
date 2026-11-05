package org.apache.poi.ss.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class NormalisedDecimal {
    private static final BigDecimal BD_2_POW_24 = new BigDecimal(BigInteger.ONE.shiftLeft(24));
    private static final int C_2_POW_19 = 524288;
    private static final int EXPONENT_OFFSET = 14;
    private static final int FRAC_HALF = 8388608;
    private static final int LOG_BASE_10_OF_2_TIMES_2_POW_20 = 315653;
    private static final long MAX_REP_WHOLE_PART = 1000000000000000L;
    private final int _fractionalPart;
    private final int _relativeDecimalExponent;
    private final long _wholePart;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0050  */
    /* JADX WARN: Code duplicated, block: B:23:0x005e  */
    public static NormalisedDecimal create(BigInteger bigInteger, int i) {
        int i2 = (i > 49 || i < 46) ? -(((15204352 - (LOG_BASE_10_OF_2_TIMES_2_POW_20 * i)) + C_2_POW_19) >> 20) : 0;
        MutableFPNumber mutableFPNumber = new MutableFPNumber(bigInteger, i);
        if (i2 != 0) {
            mutableFPNumber.multiplyByPowerOfTen(-i2);
        }
        switch (mutableFPNumber.get64BitNormalisedExponent()) {
            case 44:
            case 45:
                mutableFPNumber.multiplyByPowerOfTen(1);
                i2--;
                mutableFPNumber.normalise64bit();
                return mutableFPNumber.createNormalisedDecimal(i2);
            case 46:
                if (!mutableFPNumber.isAboveMinRep()) {
                    mutableFPNumber.multiplyByPowerOfTen(1);
                    i2--;
                }
                mutableFPNumber.normalise64bit();
                return mutableFPNumber.createNormalisedDecimal(i2);
            case 47:
            case 48:
                mutableFPNumber.normalise64bit();
                return mutableFPNumber.createNormalisedDecimal(i2);
            case 49:
                if (!mutableFPNumber.isBelowMaxRep()) {
                    mutableFPNumber.multiplyByPowerOfTen(-1);
                    i2++;
                }
                mutableFPNumber.normalise64bit();
                return mutableFPNumber.createNormalisedDecimal(i2);
            case 50:
                mutableFPNumber.multiplyByPowerOfTen(-1);
                i2++;
                mutableFPNumber.normalise64bit();
                return mutableFPNumber.createNormalisedDecimal(i2);
            default:
                throw new IllegalStateException("Bad binary exp " + mutableFPNumber.get64BitNormalisedExponent() + ".");
        }
    }

    public NormalisedDecimal roundUnits() {
        long j = this._wholePart;
        if (this._fractionalPart >= FRAC_HALF) {
            j++;
        }
        int i = this._relativeDecimalExponent;
        if (j < MAX_REP_WHOLE_PART) {
            return new NormalisedDecimal(j, 0, i);
        }
        return new NormalisedDecimal(j / 10, 0, i + 1);
    }

    NormalisedDecimal(long j, int i, int i2) {
        this._wholePart = j;
        this._fractionalPart = i;
        this._relativeDecimalExponent = i2;
    }

    public ExpandedDouble normaliseBaseTwo() {
        MutableFPNumber mutableFPNumber = new MutableFPNumber(composeFrac(), 39);
        mutableFPNumber.multiplyByPowerOfTen(this._relativeDecimalExponent);
        mutableFPNumber.normalise64bit();
        return mutableFPNumber.createExpandedDouble();
    }

    BigInteger composeFrac() {
        long j = this._wholePart;
        int i = this._fractionalPart;
        return new BigInteger(new byte[]{(byte) (j >> 56), (byte) (j >> 48), (byte) (j >> 40), (byte) (j >> 32), (byte) (j >> 24), (byte) (j >> 16), (byte) (j >> 8), (byte) (j >> 0), (byte) (i >> 16), (byte) (i >> 8), (byte) (i >> 0)});
    }

    public String getSignificantDecimalDigits() {
        return Long.toString(this._wholePart);
    }

    public String getSignificantDecimalDigitsLastDigitRounded() {
        long j = this._wholePart + 5;
        StringBuilder sb = new StringBuilder(24);
        sb.append(j);
        sb.setCharAt(sb.length() - 1, '0');
        return sb.toString();
    }

    public int getDecimalExponent() {
        return this._relativeDecimalExponent + 14;
    }

    public int compareNormalised(NormalisedDecimal normalisedDecimal) {
        int i = this._relativeDecimalExponent - normalisedDecimal._relativeDecimalExponent;
        if (i != 0) {
            return i;
        }
        long j = this._wholePart;
        long j2 = normalisedDecimal._wholePart;
        if (j > j2) {
            return 1;
        }
        if (j < j2) {
            return -1;
        }
        return this._fractionalPart - normalisedDecimal._fractionalPart;
    }

    public BigDecimal getFractionalPart() {
        return new BigDecimal(this._fractionalPart).divide(BD_2_POW_24);
    }

    private String getFractionalDigits() {
        return this._fractionalPart == 0 ? "0" : getFractionalPart().toString().substring(2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(" [");
        String strValueOf = String.valueOf(this._wholePart);
        sb.append(strValueOf.charAt(0));
        sb.append('.');
        sb.append(strValueOf.substring(1));
        sb.append(' ');
        sb.append(getFractionalDigits());
        sb.append("E");
        sb.append(getDecimalExponent());
        sb.append("]");
        return sb.toString();
    }
}
