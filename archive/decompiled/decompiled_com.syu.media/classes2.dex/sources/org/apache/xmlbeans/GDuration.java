package org.apache.xmlbeans;

import java.io.Serializable;
import java.math.BigDecimal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class GDuration implements GDurationSpecification, Serializable {
    private static final int SEEN_DAY = 3;
    private static final int SEEN_HOUR = 4;
    private static final int SEEN_MINUTE = 5;
    private static final int SEEN_MONTH = 2;
    private static final int SEEN_NOTHING = 0;
    private static final int SEEN_SECOND = 6;
    private static final int SEEN_YEAR = 1;
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _sign;

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final boolean isImmutable() {
        return true;
    }

    public GDuration() {
        this._sign = 1;
        this._fs = GDate._zero;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x010b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x011c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:79:0x0103 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x0105 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0107  */
    /* JADX WARN: Code duplicated, block: B:84:0x0111 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x0113 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x0115  */
    public GDuration(CharSequence charSequence) {
        char cCharAt;
        int length = charSequence.length();
        while (length > 0 && GDate.isSpace(charSequence.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        while (i < length && GDate.isSpace(charSequence.charAt(i))) {
            i++;
        }
        this._sign = 1;
        if (i < length && charSequence.charAt(i) == '-') {
            this._sign = -1;
            i++;
        }
        if (i >= length || charSequence.charAt(i) != 'P') {
            throw new IllegalArgumentException("duration must begin with P");
        }
        int i2 = i + 1;
        this._fs = GDate._zero;
        char c = 0;
        boolean z = false;
        while (i2 < length) {
            char cCharAt2 = charSequence.charAt(i2);
            if (cCharAt2 == 'T') {
                if (z) {
                    throw new IllegalArgumentException("duration must have no more than one T'");
                }
                if (c > 3) {
                    throw new IllegalArgumentException("T in duration must precede time fields");
                }
                i2++;
                if (i2 >= length) {
                    throw new IllegalArgumentException("illegal duration");
                }
                cCharAt2 = charSequence.charAt(i2);
                z = true;
                c = 3;
            }
            if (!GDate.isDigit(cCharAt2)) {
                throw new IllegalArgumentException("illegal duration at char[" + i2 + "]: '" + cCharAt2 + "'");
            }
            int iDigitVal = GDate.digitVal(cCharAt2);
            while (true) {
                i2++;
                cCharAt = i2 < length ? charSequence.charAt(i2) : (char) 0;
                if (!GDate.isDigit(cCharAt)) {
                    break;
                } else {
                    iDigitVal = (iDigitVal * 10) + GDate.digitVal(cCharAt);
                }
            }
            if (cCharAt == '.') {
                int i3 = i2;
                do {
                    i3++;
                    if (i3 >= length) {
                        break;
                    } else {
                        cCharAt = charSequence.charAt(i3);
                    }
                } while (GDate.isDigit(cCharAt));
                this._fs = new BigDecimal(charSequence.subSequence(i2, i3).toString());
                if (i3 >= length || cCharAt != 'S') {
                    throw new IllegalArgumentException("illegal duration");
                }
                i2 = i3;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c != 4) {
                                if (c == 5) {
                                }
                                throw new IllegalArgumentException("duration must specify Y M D T H M S in order");
                            }
                            if (cCharAt != 'S') {
                                throw new IllegalArgumentException("duration must specify Y M D T H M S in order");
                            }
                            if (!z) {
                                throw new IllegalArgumentException("time in duration must follow T");
                            }
                            this._s = iDigitVal;
                            c = 6;
                            i2++;
                        }
                        if (cCharAt == 'M') {
                            if (z) {
                                throw new IllegalArgumentException("time in duration must follow T");
                            }
                            this._m = iDigitVal;
                            c = 5;
                        } else {
                            if (cCharAt != 'S') {
                                throw new IllegalArgumentException("duration must specify Y M D T H M S in order");
                            }
                            if (!z) {
                                throw new IllegalArgumentException("time in duration must follow T");
                            }
                            this._s = iDigitVal;
                            c = 6;
                        }
                        i2++;
                    }
                    if (cCharAt == 'H') {
                        if (!z) {
                            throw new IllegalArgumentException("time in duration must follow T");
                        }
                        this._h = iDigitVal;
                        c = 4;
                    } else if (cCharAt == 'M') {
                        if (z) {
                            throw new IllegalArgumentException("time in duration must follow T");
                        }
                        this._m = iDigitVal;
                        c = 5;
                    } else {
                        if (cCharAt != 'S') {
                            throw new IllegalArgumentException("duration must specify Y M D T H M S in order");
                        }
                        if (!z) {
                            throw new IllegalArgumentException("time in duration must follow T");
                        }
                        this._s = iDigitVal;
                        c = 6;
                    }
                    i2++;
                }
                if (cCharAt == 'D') {
                    this._D = iDigitVal;
                    c = 3;
                } else if (cCharAt == 'H') {
                    if (!z) {
                        throw new IllegalArgumentException("time in duration must follow T");
                    }
                    this._h = iDigitVal;
                    c = 4;
                } else if (cCharAt == 'M') {
                    if (z) {
                        throw new IllegalArgumentException("time in duration must follow T");
                    }
                    this._m = iDigitVal;
                    c = 5;
                } else {
                    if (cCharAt != 'S') {
                        throw new IllegalArgumentException("duration must specify Y M D T H M S in order");
                    }
                    if (!z) {
                        throw new IllegalArgumentException("time in duration must follow T");
                    }
                    this._s = iDigitVal;
                    c = 6;
                }
                i2++;
            } else {
                if (cCharAt == 'Y') {
                    this._CY = iDigitVal;
                    c = 1;
                }
                i2++;
            }
            if (cCharAt == 'M') {
                this._M = iDigitVal;
                c = 2;
            } else if (cCharAt == 'D') {
                this._D = iDigitVal;
                c = 3;
            } else if (cCharAt == 'H') {
                if (!z) {
                    throw new IllegalArgumentException("time in duration must follow T");
                }
                this._h = iDigitVal;
                c = 4;
            } else if (cCharAt == 'M') {
                if (z) {
                    throw new IllegalArgumentException("time in duration must follow T");
                }
                this._m = iDigitVal;
                c = 5;
            } else {
                if (cCharAt != 'S') {
                    throw new IllegalArgumentException("duration must specify Y M D T H M S in order");
                }
                if (!z) {
                    throw new IllegalArgumentException("time in duration must follow T");
                }
                this._s = iDigitVal;
                c = 6;
            }
            i2++;
        }
        if (c == 0) {
            throw new IllegalArgumentException("duration must contain at least one number and its designator: " + ((Object) charSequence));
        }
    }

    public GDuration(int i, int i2, int i3, int i4, int i5, int i6, int i7, BigDecimal bigDecimal) {
        if (i != 1 && i != -1) {
            throw new IllegalArgumentException();
        }
        this._sign = i;
        this._CY = i2;
        this._M = i3;
        this._D = i4;
        this._h = i5;
        this._m = i6;
        this._s = i7;
        this._fs = bigDecimal == null ? GDate._zero : bigDecimal;
    }

    public GDuration(GDurationSpecification gDurationSpecification) {
        this._sign = gDurationSpecification.getSign();
        this._CY = gDurationSpecification.getYear();
        this._M = gDurationSpecification.getMonth();
        this._D = gDurationSpecification.getDay();
        this._h = gDurationSpecification.getHour();
        this._m = gDurationSpecification.getMinute();
        this._s = gDurationSpecification.getSecond();
        this._fs = gDurationSpecification.getFraction();
    }

    public Object clone() {
        return new GDuration(this);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getSign() {
        return this._sign;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getYear() {
        return this._CY;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getMonth() {
        return this._M;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getDay() {
        return this._D;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getHour() {
        return this._h;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getMinute() {
        return this._m;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getSecond() {
        return this._s;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public BigDecimal getFraction() {
        return this._fs;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public boolean isValid() {
        return GDurationBuilder.isValidDuration(this);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int compareToGDuration(GDurationSpecification gDurationSpecification) {
        return GDurationBuilder.compareDurations(this, gDurationSpecification);
    }

    public String toString() {
        return GDurationBuilder.formatDuration(this);
    }

    public GDuration add(GDurationSpecification gDurationSpecification) {
        return _add(gDurationSpecification, this._sign * gDurationSpecification.getSign());
    }

    public GDuration subtract(GDurationSpecification gDurationSpecification) {
        return _add(gDurationSpecification, (-this._sign) * gDurationSpecification.getSign());
    }

    private GDuration _add(GDurationSpecification gDurationSpecification, int i) {
        GDuration gDuration = new GDuration(this);
        gDuration._CY += gDurationSpecification.getYear() * i;
        gDuration._M += gDurationSpecification.getMonth() * i;
        gDuration._D += gDurationSpecification.getDay() * i;
        gDuration._h += gDurationSpecification.getHour() * i;
        gDuration._m += gDurationSpecification.getMinute() * i;
        gDuration._s += gDurationSpecification.getSecond() * i;
        if (gDurationSpecification.getFraction().signum() == 0) {
            return gDuration;
        }
        if (gDuration._fs.signum() == 0 && i == 1) {
            gDuration._fs = gDurationSpecification.getFraction();
        } else {
            gDuration._fs = i > 0 ? gDuration._fs.add(gDurationSpecification.getFraction()) : gDuration._fs.subtract(gDurationSpecification.getFraction());
        }
        return gDuration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GDuration)) {
            return false;
        }
        GDuration gDuration = (GDuration) obj;
        return this._sign == gDuration.getSign() && this._CY == gDuration.getYear() && this._M == gDuration.getMonth() && this._D == gDuration.getDay() && this._h == gDuration.getHour() && this._m == gDuration.getMinute() && this._s == gDuration.getSecond() && this._fs.equals(gDuration.getFraction());
    }

    public int hashCode() {
        return this._s + (this._m * 67) + (this._h * 3607) + (this._D * 86407) + (this._M * 2678407) + (this._CY * 32140807) + (this._sign * 11917049);
    }
}
