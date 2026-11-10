package org.apache.poi.ss.util;

import java.math.BigInteger;
import module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class MutableFPNumber {
    private static final int C_64 = 64;
    private static final int MIN_PRECISION = 72;
    private int _binaryExponent;
    private BigInteger _significand;
    private static final BigInteger BI_MIN_BASE = new BigInteger("0B5E620F47FFFE666", 16);
    private static final BigInteger BI_MAX_BASE = new BigInteger("0E35FA9319FFFE000", 16);

    public MutableFPNumber(BigInteger bigInteger, int i) {
        this._significand = bigInteger;
        this._binaryExponent = i;
    }

    public MutableFPNumber copy() {
        return new MutableFPNumber(this._significand, this._binaryExponent);
    }

    public void normalise64bit() {
        int iBitLength = this._significand.bitLength();
        int i = iBitLength - 64;
        if (i == 0) {
            return;
        }
        if (i < 0) {
            throw new IllegalStateException("Not enough precision");
        }
        this._binaryExponent += i;
        if (i > 32) {
            int i2 = (i - 1) & 16777184;
            this._significand = this._significand.shiftRight(i2);
            i -= i2;
            iBitLength -= i2;
        }
        if (i < 1) {
            throw new IllegalStateException();
        }
        BigInteger bigIntegerRound = Rounder.round(this._significand, i);
        this._significand = bigIntegerRound;
        if (bigIntegerRound.bitLength() > iBitLength) {
            i++;
            this._binaryExponent++;
        }
        this._significand = this._significand.shiftRight(i);
    }

    public int get64BitNormalisedExponent() {
        return (this._binaryExponent + this._significand.bitLength()) - 64;
    }

    public boolean isBelowMaxRep() {
        return this._significand.compareTo(BI_MAX_BASE.shiftLeft(this._significand.bitLength() + (-64))) < 0;
    }

    public boolean isAboveMinRep() {
        return this._significand.compareTo(BI_MIN_BASE.shiftLeft(this._significand.bitLength() + (-64))) > 0;
    }

    public NormalisedDecimal createNormalisedDecimal(int i) {
        return new NormalisedDecimal(this._significand.shiftRight((64 - this._binaryExponent) - 1).longValue(), (this._significand.intValue() << (this._binaryExponent - 39)) & 16777088, i);
    }

    public void multiplyByPowerOfTen(int i) {
        TenPower tenPower = TenPower.getInstance(Math.abs(i));
        if (i < 0) {
            mulShift(tenPower._divisor, tenPower._divisorShift);
        } else {
            mulShift(tenPower._multiplicand, tenPower._multiplierShift);
        }
    }

    private void mulShift(BigInteger bigInteger, int i) {
        BigInteger bigIntegerMultiply = this._significand.multiply(bigInteger);
        this._significand = bigIntegerMultiply;
        this._binaryExponent += i;
        int iBitLength = (bigIntegerMultiply.bitLength() - 72) & (-32);
        if (iBitLength > 0) {
            this._significand = this._significand.shiftRight(iBitLength);
            this._binaryExponent += iBitLength;
        }
    }

    private static final class Rounder {
        private static final BigInteger[] HALF_BITS;

        private Rounder() {
        }

        static {
            BigInteger[] bigIntegerArr = new BigInteger[33];
            long j = 1;
            for (int i = 1; i < 33; i++) {
                bigIntegerArr[i] = BigInteger.valueOf(j);
                j <<= 1;
            }
            HALF_BITS = bigIntegerArr;
        }

        public static BigInteger round(BigInteger bigInteger, int i) {
            return i < 1 ? bigInteger : bigInteger.add(HALF_BITS[i]);
        }
    }

    private static final class TenPower {
        private static final BigInteger FIVE = new BigInteger("5");
        private static final TenPower[] _cache = new TenPower[FinalCanbus.CAR_HAOZHENG_XP1_BmwSeries];
        public final BigInteger _divisor;
        public final int _divisorShift;
        public final BigInteger _multiplicand;
        public final int _multiplierShift;

        private TenPower(int i) {
            BigInteger bigIntegerPow = FIVE.pow(i);
            int iBitLength = bigIntegerPow.bitLength();
            BigInteger bigIntegerDivide = BigInteger.ONE.shiftLeft(iBitLength + 80).divide(bigIntegerPow);
            int iBitLength2 = bigIntegerDivide.bitLength() - 80;
            this._divisor = bigIntegerDivide.shiftRight(iBitLength2);
            this._divisorShift = -((iBitLength - iBitLength2) + i + 80);
            int iBitLength3 = bigIntegerPow.bitLength() - 68;
            if (iBitLength3 > 0) {
                this._multiplierShift = i + iBitLength3;
                this._multiplicand = bigIntegerPow.shiftRight(iBitLength3);
            } else {
                this._multiplierShift = i;
                this._multiplicand = bigIntegerPow;
            }
        }

        static TenPower getInstance(int i) {
            TenPower[] tenPowerArr = _cache;
            TenPower tenPower = tenPowerArr[i];
            if (tenPower != null) {
                return tenPower;
            }
            TenPower tenPower2 = new TenPower(i);
            tenPowerArr[i] = tenPower2;
            return tenPower2;
        }
    }

    public ExpandedDouble createExpandedDouble() {
        return new ExpandedDouble(this._significand, this._binaryExponent);
    }
}
