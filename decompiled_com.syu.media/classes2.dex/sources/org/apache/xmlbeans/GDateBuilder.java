package org.apache.xmlbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import module.canbus.FinalCanbus;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class GDateBuilder implements GDateSpecification, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final BigInteger TEN = BigInteger.valueOf(10);
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private int _bits;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _tzh;
    private int _tzm;
    private int _tzsign;

    private static int _maxDayInMonth(int i) {
        if (i == 4 || i == 6 || i == 9 || i == 11) {
            return 30;
        }
        return i == 2 ? 29 : 31;
    }

    private static int _mod(long j, int i, long j2) {
        return (int) (j - (j2 * ((long) i)));
    }

    static int btcForFlags(int i) {
        int i2 = i & 30;
        if (i2 == 2) {
            return 18;
        }
        if (i2 == 4) {
            return 21;
        }
        if (i2 == 6) {
            return 17;
        }
        if (i2 == 8) {
            return 20;
        }
        if (i2 == 12) {
            return 19;
        }
        if (i2 == 14) {
            return 16;
        }
        if (i2 != 16) {
            return i2 != 30 ? 0 : 14;
        }
        return 15;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public boolean isImmutable() {
        return false;
    }

    public GDateBuilder() {
    }

    public Object clone() {
        return new GDateBuilder(this);
    }

    public GDate toGDate() {
        return new GDate(this);
    }

    public GDateBuilder(GDateSpecification gDateSpecification) {
        if (gDateSpecification.hasTimeZone()) {
            setTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
        }
        if (gDateSpecification.hasTime()) {
            setTime(gDateSpecification.getHour(), gDateSpecification.getMinute(), gDateSpecification.getSecond(), gDateSpecification.getFraction());
        }
        if (gDateSpecification.hasDay()) {
            setDay(gDateSpecification.getDay());
        }
        if (gDateSpecification.hasMonth()) {
            setMonth(gDateSpecification.getMonth());
        }
        if (gDateSpecification.hasYear()) {
            setYear(gDateSpecification.getYear());
        }
    }

    public GDateBuilder(CharSequence charSequence) {
        this(new GDate(charSequence));
    }

    public GDateBuilder(Calendar calendar) {
        this(new GDate(calendar));
    }

    public GDateBuilder(int i, int i2, int i3, int i4, int i5, int i6, BigDecimal bigDecimal) {
        this._bits = 30;
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        this._CY = i <= 0 ? i + 1 : i;
        this._M = i2;
        this._D = i3;
        this._h = i4;
        this._m = i5;
        this._s = i6;
        this._fs = bigDecimal == null ? GDate._zero : bigDecimal;
        if (!isValid()) {
            throw new IllegalArgumentException();
        }
    }

    public GDateBuilder(int i, int i2, int i3, int i4, int i5, int i6, BigDecimal bigDecimal, int i7, int i8, int i9) {
        this._bits = 31;
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        this._CY = i <= 0 ? i + 1 : i;
        this._M = i2;
        this._D = i3;
        this._h = i4;
        this._m = i5;
        this._s = i6;
        this._fs = bigDecimal == null ? GDate._zero : bigDecimal;
        this._tzsign = i7;
        this._tzh = i8;
        this._tzm = i9;
        if (!isValid()) {
            throw new IllegalArgumentException();
        }
    }

    public GDateBuilder(Date date) {
        setDate(date);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getFlags() {
        return this._bits;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasTimeZone() {
        return (this._bits & 1) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasYear() {
        return (this._bits & 2) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasMonth() {
        return (this._bits & 4) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasDay() {
        return (this._bits & 8) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasTime() {
        return (this._bits & 16) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasDate() {
        return (this._bits & 14) == 14;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getYear() {
        int i = this._CY;
        return i > 0 ? i : i - 1;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMonth() {
        return this._M;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getDay() {
        return this._D;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getHour() {
        return this._h;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMinute() {
        return this._m;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getSecond() {
        return this._s;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final BigDecimal getFraction() {
        return this._fs;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMillisecond() {
        BigDecimal bigDecimal = this._fs;
        if (bigDecimal == null || bigDecimal == GDate._zero) {
            return 0;
        }
        return this._fs.setScale(3, 4).unscaledValue().intValue();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneSign() {
        return this._tzsign;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneHour() {
        return this._tzh;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneMinute() {
        return this._tzm;
    }

    public void setYear(int i) {
        if (i < -292275295 || i > 292277265) {
            throw new IllegalArgumentException("year out of range");
        }
        if (i == 0) {
            throw new IllegalArgumentException("year cannot be 0");
        }
        this._bits |= 2;
        if (i <= 0) {
            i++;
        }
        this._CY = i;
    }

    public void setMonth(int i) {
        if (i < 1 || i > 12) {
            throw new IllegalArgumentException("month out of range");
        }
        this._bits |= 4;
        this._M = i;
    }

    public void setDay(int i) {
        if (i < 1 || i > 31) {
            throw new IllegalArgumentException("day out of range");
        }
        this._bits |= 8;
        this._D = i;
    }

    public void setTime(int i, int i2, int i3, BigDecimal bigDecimal) {
        if (i < 0 || i > 24) {
            throw new IllegalArgumentException("hour out of range");
        }
        if (i2 < 0 || i2 > 59) {
            throw new IllegalArgumentException("minute out of range");
        }
        if (i3 < 0 || i3 > 59) {
            throw new IllegalArgumentException("second out of range");
        }
        if (bigDecimal != null && (bigDecimal.signum() < 0 || bigDecimal.compareTo(GDate._one) > 1)) {
            throw new IllegalArgumentException("fraction out of range");
        }
        if (i == 24 && (i2 != 0 || i3 != 0 || (bigDecimal != null && GDate._zero.compareTo(bigDecimal) != 0))) {
            throw new IllegalArgumentException("when hour is 24, min sec and fracton must be 0");
        }
        this._bits |= 16;
        this._h = i;
        this._m = i2;
        this._s = i3;
        if (bigDecimal == null) {
            bigDecimal = GDate._zero;
        }
        this._fs = bigDecimal;
    }

    public void setTimeZone(int i, int i2, int i3) {
        if ((i != 0 || i2 != 0 || i3 != 0) && ((i != -1 && i != 1) || i2 < 0 || i3 < 0 || ((i2 != 14 || i3 != 0) && (i2 >= 14 || i3 >= 60)))) {
            throw new IllegalArgumentException("time zone out of range (-14:00 to +14:00). (" + (i < 0 ? "-" : "+") + i2 + ":" + i3 + ")");
        }
        this._bits = 1 | this._bits;
        this._tzsign = i;
        this._tzh = i2;
        this._tzm = i3;
    }

    public void setTimeZone(int i) {
        int i2;
        if (i < -840 || i > 840) {
            throw new IllegalArgumentException("time zone out of range (-840 to 840 minutes). (" + i + ")");
        }
        if (i < 0) {
            i2 = -1;
        } else {
            i2 = i > 0 ? 1 : 0;
        }
        int i3 = i * i2;
        int i4 = i3 / 60;
        setTimeZone(i2, i4, i3 - (i4 * 60));
    }

    public void clearYear() {
        this._bits &= -3;
        this._CY = 0;
    }

    public void clearMonth() {
        this._bits &= -5;
        this._M = 0;
    }

    public void clearDay() {
        this._bits &= -9;
        this._D = 0;
    }

    public void clearTime() {
        this._bits &= -17;
        this._h = 0;
        this._m = 0;
        this._s = 0;
        this._fs = null;
    }

    public void clearTimeZone() {
        this._bits &= -2;
        this._tzsign = 0;
        this._tzh = 0;
        this._tzm = 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public boolean isValid() {
        return isValidGDate(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
    
        if (r5.getDay() > _maxDayInMonthFor(r5.getYear() > 0 ? r5.getYear() : r5.getYear() + 1, r5.getMonth())) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
    
        if (r5.getDay() > _maxDayInMonth(r5.getMonth())) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final boolean isValidGDate(org.apache.xmlbeans.GDateSpecification r5) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.GDateBuilder.isValidGDate(org.apache.xmlbeans.GDateSpecification):boolean");
    }

    public void normalize() {
        BigDecimal bigDecimal;
        if (hasDay() == hasMonth() && hasDay() == hasYear() && hasTimeZone() && hasTime()) {
            normalizeToTimeZone(0, 0, 0);
        } else {
            _normalizeTimeAndDate();
        }
        if (!hasTime() || (bigDecimal = this._fs) == null || bigDecimal.scale() <= 0) {
            return;
        }
        if (this._fs.signum() == 0) {
            this._fs = GDate._zero;
            return;
        }
        String string = this._fs.unscaledValue().toString();
        int length = string.length();
        while (length > 0 && string.charAt(length - 1) == '0') {
            length--;
        }
        if (length < string.length()) {
            BigDecimal bigDecimal2 = this._fs;
            this._fs = bigDecimal2.setScale((bigDecimal2.scale() - string.length()) + length);
        }
    }

    void normalize24h() {
        if (hasTime() && getHour() == 24) {
            _normalizeTimeAndDate();
        }
    }

    private void _normalizeTimeAndDate() {
        long j_normalizeTime = hasTime() ? _normalizeTime() : 0L;
        if (hasDay()) {
            this._D = (int) (((long) this._D) + j_normalizeTime);
        }
        if (hasDate()) {
            _normalizeDate();
            return;
        }
        if (hasMonth()) {
            int i = this._M;
            if (i < 1 || i > 12) {
                long j = i;
                this._M = _modulo(j, 1, 13);
                if (hasYear()) {
                    this._CY += (int) _fQuotient(j, 1, 13);
                }
            }
        }
    }

    public void normalizeToTimeZone(int i, int i2, int i3) {
        if ((i != 0 || i2 != 0 || i3 != 0) && ((i != -1 && i != 1) || i2 < 0 || i3 < 0 || ((i2 != 14 || i3 != 0) && (i2 >= 14 || i3 >= 60)))) {
            throw new IllegalArgumentException("time zone must be between -14:00 and +14:00");
        }
        if (!hasTimeZone() || !hasTime()) {
            throw new IllegalStateException("cannot normalize time zone without both time and timezone");
        }
        if (hasDay() != hasMonth() || hasDay() != hasYear()) {
            throw new IllegalStateException("cannot do date math without a complete date");
        }
        int i4 = this._tzsign;
        int i5 = (i * i2) - (this._tzh * i4);
        int i6 = (i * i3) - (i4 * this._tzm);
        this._tzsign = i;
        this._tzh = i2;
        this._tzm = i3;
        addDuration(1, 0, 0, 0, i5, i6, 0, null);
    }

    public void normalizeToTimeZone(int i) {
        int i2;
        if (i < -840 || i > 840) {
            throw new IllegalArgumentException("time zone out of range (-840 to 840 minutes). (" + i + ")");
        }
        if (i < 0) {
            i2 = -1;
        } else {
            i2 = i > 0 ? 1 : 0;
        }
        int i3 = i * i2;
        int i4 = i3 / 60;
        normalizeToTimeZone(i2, i4, i3 - (i4 * 60));
    }

    public void addGDuration(GDurationSpecification gDurationSpecification) {
        addDuration(gDurationSpecification.getSign(), gDurationSpecification.getYear(), gDurationSpecification.getMonth(), gDurationSpecification.getDay(), gDurationSpecification.getHour(), gDurationSpecification.getMinute(), gDurationSpecification.getSecond(), gDurationSpecification.getFraction());
    }

    public void subtractGDuration(GDurationSpecification gDurationSpecification) {
        addDuration(-gDurationSpecification.getSign(), gDurationSpecification.getYear(), gDurationSpecification.getMonth(), gDurationSpecification.getDay(), gDurationSpecification.getHour(), gDurationSpecification.getMinute(), gDurationSpecification.getSecond(), gDurationSpecification.getFraction());
    }

    private void _normalizeDate() {
        int i;
        int i2 = this._M;
        if (i2 < 1 || i2 > 12 || (i = this._D) < 1 || i > _maxDayInMonthFor(this._CY, i2)) {
            long j = this._M;
            this._M = _modulo(j, 1, 13);
            this._CY += (int) _fQuotient(j, 1, 13);
            int i3 = this._D - 1;
            this._D = 1;
            setJulianDate(getJulianDate() + i3);
        }
    }

    private long _normalizeTime() {
        long jLongValue;
        int i;
        int i2;
        int i3;
        BigDecimal bigDecimal = this._fs;
        if (bigDecimal == null || (bigDecimal.signum() >= 0 && this._fs.compareTo(GDate._one) < 0)) {
            jLongValue = 0;
        } else {
            BigDecimal scale = this._fs.setScale(0, 3);
            this._fs = this._fs.subtract(scale);
            jLongValue = scale.longValue();
        }
        if (jLongValue == 0 && (i = this._s) >= 0 && i <= 59 && (i2 = this._m) >= 0 && i2 <= 50 && (i3 = this._h) >= 0 && i3 <= 23) {
            return jLongValue;
        }
        long j = ((long) this._s) + jLongValue;
        long j_fQuotient = _fQuotient(j, 60);
        this._s = _mod(j, 60, j_fQuotient);
        long j2 = ((long) this._m) + j_fQuotient;
        long j_fQuotient2 = _fQuotient(j2, 60);
        this._m = _mod(j2, 60, j_fQuotient2);
        long j3 = ((long) this._h) + j_fQuotient2;
        long j_fQuotient3 = _fQuotient(j3, 24);
        this._h = _mod(j3, 24, j_fQuotient3);
        return j_fQuotient3;
    }

    public void addDuration(int i, int i2, int i3, int i4, int i5, int i6, int i7, BigDecimal bigDecimal) {
        int i_maxDayInMonthFor;
        long j_normalizeTime;
        boolean z = false;
        boolean z2 = (i5 == 0 && i6 == 0 && i7 == 0 && (bigDecimal == null || bigDecimal.signum() == 0)) ? false : true;
        if (z2 && !hasTime()) {
            throw new IllegalStateException("cannot do time math without a complete time");
        }
        if (hasDay() && (i4 != 0 || z2)) {
            z = true;
        }
        if (z && !hasDate()) {
            throw new IllegalStateException("cannot do date math without a complete date");
        }
        if (i3 != 0 || i2 != 0) {
            if (hasDay()) {
                _normalizeDate();
            }
            long j = this._M + (i3 * i);
            this._M = _modulo(j, 1, 13);
            this._CY = this._CY + (i2 * i) + ((int) _fQuotient(j, 1, 13));
            if (hasDay() && this._D > (i_maxDayInMonthFor = _maxDayInMonthFor(this._CY, this._M))) {
                this._D = i_maxDayInMonthFor;
            }
        }
        if (z2) {
            if (bigDecimal != null && bigDecimal.signum() != 0) {
                if (this._fs.signum() == 0 && i == 1) {
                    this._fs = bigDecimal;
                } else {
                    BigDecimal bigDecimal2 = this._fs;
                    this._fs = i == 1 ? bigDecimal2.add(bigDecimal) : bigDecimal2.subtract(bigDecimal);
                }
            }
            this._s += i7 * i;
            this._m += i6 * i;
            this._h += i5 * i;
            j_normalizeTime = _normalizeTime();
        } else {
            j_normalizeTime = 0;
        }
        if (z) {
            this._D = (int) (((long) this._D) + ((long) (i * i4)) + j_normalizeTime);
            _normalizeDate();
        }
    }

    private static int _maxDayInMonthFor(int i, int i2) {
        if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            return 30;
        }
        if (i2 == 2) {
            return _isLeapYear(i) ? 29 : 28;
        }
        return 31;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getJulianDate() {
        return julianDateForGDate(this);
    }

    public void setJulianDate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("date before year -4713");
        }
        int i2 = i + 68569;
        int i3 = (i2 * 4) / 146097;
        int i4 = i2 - (((146097 * i3) + 3) / 4);
        int i5 = ((i4 + 1) * 4000) / 1461001;
        this._CY = i5;
        int i6 = (i4 - ((i5 * 1461) / 4)) + 31;
        int i7 = (i6 * 80) / 2447;
        this._M = i7;
        this._D = i6 - ((i7 * 2447) / 80);
        int i8 = i7 / 11;
        this._M = (i7 + 2) - (i8 * 12);
        this._CY = ((i3 - 49) * 100) + i5 + i8;
        this._bits |= 14;
    }

    public void setDate(Date date) {
        int i;
        int offset = TimeZone.getDefault().getOffset(date.getTime());
        if (offset < 0) {
            offset = -offset;
            i = -1;
        } else {
            i = 1;
        }
        int i2 = offset / 60000;
        int i3 = i2 / 60;
        int i4 = i3 * 60;
        int i5 = i2 - i4;
        setTimeZone(i, i3, i5);
        setTime(0, 0, 0, GDate._zero);
        this._bits |= 14;
        this._CY = 1970;
        this._M = 1;
        this._D = 1;
        addGDuration(new GDuration(1, 0, 0, 0, 0, 0, 0, BigDecimal.valueOf(date.getTime() + ((long) (i * (i4 + i5) * 60 * 1000)), 3)));
        if (this._fs.signum() == 0) {
            this._fs = GDate._zero;
        }
    }

    public void setGDate(GDateSpecification gDateSpecification) {
        this._bits = gDateSpecification.getFlags() & 31;
        int year = gDateSpecification.getYear();
        if (year <= 0) {
            year++;
        }
        this._CY = year;
        this._M = gDateSpecification.getMonth();
        this._D = gDateSpecification.getDay();
        this._h = gDateSpecification.getHour();
        this._m = gDateSpecification.getMinute();
        this._s = gDateSpecification.getSecond();
        this._fs = gDateSpecification.getFraction();
        this._tzsign = gDateSpecification.getTimeZoneSign();
        this._tzh = gDateSpecification.getTimeZoneHour();
        this._tzm = gDateSpecification.getTimeZoneMinute();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public XmlCalendar getCalendar() {
        return new XmlCalendar(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public Date getDate() {
        return dateForGDate(this);
    }

    static int julianDateForGDate(GDateSpecification gDateSpecification) {
        if (!gDateSpecification.hasDate()) {
            throw new IllegalStateException("cannot do date math without a complete date");
        }
        int day = gDateSpecification.getDay();
        int month = gDateSpecification.getMonth();
        int year = gDateSpecification.getYear();
        if (year <= 0) {
            year++;
        }
        int i = (month - 14) / 12;
        int i2 = (((day - 32075) + ((((year + 4800) + i) * 1461) / 4)) + ((((month - 2) - (i * 12)) * FinalCanbus.CAR_XP1_16_TuSheng) / 12)) - (((((year + 4900) + i) / 100) * 3) / 4);
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalStateException("date too far in the past (year allowed to -4713)");
    }

    static Date dateForGDate(GDateSpecification gDateSpecification) {
        long offset;
        long jJulianDateForGDate = ((((long) julianDateForGDate(gDateSpecification)) - 2440588) * DateUtil.DAY_MILLISECONDS) + ((long) gDateSpecification.getMillisecond()) + ((long) (gDateSpecification.getSecond() * 1000)) + ((long) (gDateSpecification.getMinute() * 60 * 1000)) + ((long) (gDateSpecification.getHour() * 60 * 60 * 1000));
        if (gDateSpecification.hasTimeZone()) {
            jJulianDateForGDate -= (long) (((gDateSpecification.getTimeZoneMinute() * gDateSpecification.getTimeZoneSign()) * 60) * 1000);
            offset = gDateSpecification.getTimeZoneHour() * gDateSpecification.getTimeZoneSign() * 60 * 60 * 1000;
        } else {
            offset = TimeZone.getDefault().getOffset(jJulianDateForGDate);
        }
        return new Date(jJulianDateForGDate - offset);
    }

    private static boolean _isLeapYear(int i) {
        return i % 4 == 0 && (i % 100 != 0 || i % FinalCanbus.CAR_FYTA_JILI_XiongMiao == 0);
    }

    private static final long _fQuotient(long j, int i) {
        if ((j < 0) == (i < 0)) {
            return j / ((long) i);
        }
        long j2 = i;
        return -(((j2 - j) - serialVersionUID) / j2);
    }

    private static final int _modulo(long j, int i, int i2) {
        long j2 = j - ((long) i);
        int i3 = i2 - i;
        return _mod(j2, i3, _fQuotient(j2, i3)) + i;
    }

    private static final long _fQuotient(long j, int i, int i2) {
        return _fQuotient(j - ((long) i), i2 - i);
    }

    private void _setToFirstMoment() {
        if (!hasYear()) {
            setYear(1584);
        }
        if (!hasMonth()) {
            setMonth(1);
        }
        if (!hasDay()) {
            setDay(1);
        }
        if (hasTime()) {
            return;
        }
        setTime(0, 0, 0, GDate._zero);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int compareToGDate(GDateSpecification gDateSpecification) {
        return compareGDate(this, gDateSpecification);
    }

    static final int compareGDate(GDateSpecification gDateSpecification, GDateSpecification gDateSpecification2) {
        int flags = gDateSpecification.getFlags() ^ gDateSpecification2.getFlags();
        if ((flags & 31) == 0) {
            if (gDateSpecification.hasTimeZone() && (gDateSpecification2.getTimeZoneHour() != gDateSpecification.getTimeZoneHour() || gDateSpecification2.getTimeZoneMinute() != gDateSpecification.getTimeZoneMinute() || gDateSpecification2.getTimeZoneSign() != gDateSpecification.getTimeZoneSign())) {
                GDateBuilder gDateBuilder = new GDateBuilder(gDateSpecification2);
                int flags2 = gDateSpecification.getFlags() & 14;
                if ((flags2 != 0 && flags2 != 14) || !gDateSpecification.hasTime()) {
                    gDateBuilder._setToFirstMoment();
                    GDateBuilder gDateBuilder2 = new GDateBuilder(gDateSpecification);
                    gDateBuilder2._setToFirstMoment();
                    gDateSpecification = gDateBuilder2;
                }
                gDateBuilder.normalizeToTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
                gDateSpecification2 = gDateBuilder;
            }
            return fieldwiseCompare(gDateSpecification, gDateSpecification2);
        }
        if ((flags & 30) != 0) {
            return 2;
        }
        if (!gDateSpecification.hasTimeZone()) {
            int iCompareGDate = compareGDate(gDateSpecification2, gDateSpecification);
            if (iCompareGDate == 2) {
                return 2;
            }
            return -iCompareGDate;
        }
        GDateBuilder gDateBuilder3 = new GDateBuilder(gDateSpecification);
        if ((gDateSpecification.getFlags() & 14) == 12) {
            if (gDateSpecification.getDay() == 28 && gDateSpecification.getMonth() == 2) {
                if (gDateSpecification2.getDay() == 1 && gDateSpecification2.getMonth() == 3) {
                    gDateBuilder3.setDay(29);
                }
            } else if (gDateSpecification2.getDay() == 28 && gDateSpecification2.getMonth() == 2 && gDateSpecification.getDay() == 1 && gDateSpecification.getMonth() == 3) {
                gDateBuilder3.setMonth(2);
                gDateBuilder3.setDay(29);
            }
        }
        gDateBuilder3._setToFirstMoment();
        GDateBuilder gDateBuilder4 = new GDateBuilder(gDateSpecification2);
        gDateBuilder4._setToFirstMoment();
        gDateBuilder4.setTimeZone(1, 14, 0);
        gDateBuilder4.normalizeToTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
        if (fieldwiseCompare(gDateBuilder3, gDateBuilder4) == -1) {
            return -1;
        }
        gDateBuilder4.setGDate(gDateSpecification2);
        gDateBuilder4._setToFirstMoment();
        gDateBuilder4.setTimeZone(-1, 14, 0);
        gDateBuilder4.normalizeToTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
        return fieldwiseCompare(gDateBuilder3, gDateBuilder4) == 1 ? 1 : 2;
    }

    private static int fieldwiseCompare(GDateSpecification gDateSpecification, GDateSpecification gDateSpecification2) {
        if (gDateSpecification.hasYear()) {
            int year = gDateSpecification2.getYear();
            int year2 = gDateSpecification.getYear();
            if (year2 < year) {
                return -1;
            }
            if (year2 > year) {
                return 1;
            }
        }
        if (gDateSpecification.hasMonth()) {
            int month = gDateSpecification2.getMonth();
            int month2 = gDateSpecification.getMonth();
            if (month2 < month) {
                return -1;
            }
            if (month2 > month) {
                return 1;
            }
        }
        if (gDateSpecification.hasDay()) {
            int day = gDateSpecification2.getDay();
            int day2 = gDateSpecification.getDay();
            if (day2 < day) {
                return -1;
            }
            if (day2 > day) {
                return 1;
            }
        }
        if (!gDateSpecification.hasTime()) {
            return 0;
        }
        int hour = gDateSpecification2.getHour();
        int hour2 = gDateSpecification.getHour();
        if (hour2 < hour) {
            return -1;
        }
        if (hour2 > hour) {
            return 1;
        }
        int minute = gDateSpecification2.getMinute();
        int minute2 = gDateSpecification.getMinute();
        if (minute2 < minute) {
            return -1;
        }
        if (minute2 > minute) {
            return 1;
        }
        int second = gDateSpecification2.getSecond();
        int second2 = gDateSpecification.getSecond();
        if (second2 < second) {
            return -1;
        }
        if (second2 > second) {
            return 1;
        }
        BigDecimal fraction = gDateSpecification2.getFraction();
        BigDecimal fraction2 = gDateSpecification.getFraction();
        if (fraction2 == null && fraction == null) {
            return 0;
        }
        if (fraction2 == null) {
            fraction2 = GDate._zero;
        }
        if (fraction == null) {
            fraction = GDate._zero;
        }
        return fraction2.compareTo(fraction);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getBuiltinTypeCode() {
        return btcForFlags(this._bits);
    }

    public void setBuiltinTypeCode(int i) {
        switch (i) {
            case 14:
                return;
            case 15:
                clearYear();
                clearMonth();
                clearDay();
                return;
            case 16:
                clearTime();
                return;
            case 17:
                clearDay();
                clearTime();
                return;
            case 18:
                clearMonth();
                clearDay();
                clearTime();
                return;
            case 19:
                clearYear();
                clearTime();
                return;
            case 20:
                clearYear();
                clearMonth();
                clearTime();
                return;
            case 21:
                clearYear();
                clearDay();
                clearTime();
                return;
            default:
                throw new IllegalArgumentException("codeType must be one of SchemaType BTC_  DATE TIME related types.");
        }
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public String canonicalString() {
        boolean z = hasTimeZone() && getTimeZoneSign() != 0 && hasTime() && hasDay() == hasMonth() && hasDay() == hasYear();
        if (!z && getFraction() != null && getFraction().scale() > 0) {
            z = getFraction().unscaledValue().mod(TEN).signum() == 0;
        }
        if (!z) {
            return toString();
        }
        GDateBuilder gDateBuilder = new GDateBuilder(this);
        gDateBuilder.normalize();
        return gDateBuilder.toString();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final String toString() {
        return GDate.formatGDate(this);
    }
}
