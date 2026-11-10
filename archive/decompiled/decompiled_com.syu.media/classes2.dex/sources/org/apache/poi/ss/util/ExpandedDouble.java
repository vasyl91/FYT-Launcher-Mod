package org.apache.poi.ss.util;

import java.math.BigInteger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class ExpandedDouble {
    private static final BigInteger BI_FRAC_MASK = BigInteger.valueOf(IEEEDouble.FRAC_MASK);
    private static final BigInteger BI_IMPLIED_FRAC_MSB = BigInteger.valueOf(IEEEDouble.FRAC_ASSUMED_HIGH_BIT);
    private final int _binaryExponent;
    private final BigInteger _significand;

    private static BigInteger getFrac(long j) {
        return BigInteger.valueOf(j).and(BI_FRAC_MASK).or(BI_IMPLIED_FRAC_MSB).shiftLeft(11);
    }

    public static ExpandedDouble fromRawBitsAndExponent(long j, int i) {
        return new ExpandedDouble(getFrac(j), i);
    }

    public ExpandedDouble(long j) {
        int i = (int) (j >> 52);
        if (i == 0) {
            BigInteger bigIntegerAnd = BigInteger.valueOf(j).and(BI_FRAC_MASK);
            int iBitLength = 64 - bigIntegerAnd.bitLength();
            this._significand = bigIntegerAnd.shiftLeft(iBitLength);
            this._binaryExponent = ((i & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE) - 1023) - iBitLength;
            return;
        }
        this._significand = getFrac(j);
        this._binaryExponent = (i & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE) - 1023;
    }

    ExpandedDouble(BigInteger bigInteger, int i) {
        if (bigInteger.bitLength() != 64) {
            throw new IllegalArgumentException("bad bit length");
        }
        this._significand = bigInteger;
        this._binaryExponent = i;
    }

    public NormalisedDecimal normaliseBaseTen() {
        return NormalisedDecimal.create(this._significand, this._binaryExponent);
    }

    public int getBinaryExponent() {
        return this._binaryExponent;
    }

    public BigInteger getSignificand() {
        return this._significand;
    }
}
