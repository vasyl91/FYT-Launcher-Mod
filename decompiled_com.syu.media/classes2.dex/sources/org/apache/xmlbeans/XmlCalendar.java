package org.apache.xmlbeans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XmlCalendar extends GregorianCalendar {
    private static final int DEFAULT_DEFAULT_YEAR = 0;
    private static Date _beginningOfTime = new Date(Long.MIN_VALUE);
    private static int defaultYear = Integer.MIN_VALUE;

    public XmlCalendar(String str) {
        this(new GDate(str));
    }

    public XmlCalendar(GDateSpecification gDateSpecification) {
        this(GDate.timeZoneForGDate(gDateSpecification), gDateSpecification);
    }

    private XmlCalendar(TimeZone timeZone, GDateSpecification gDateSpecification) {
        super(timeZone);
        setGregorianChange(_beginningOfTime);
        clear();
        if (gDateSpecification.hasYear()) {
            int year = gDateSpecification.getYear();
            if (year > 0) {
                set(0, 1);
            } else {
                set(0, 0);
                year = -year;
            }
            set(1, year);
        }
        if (gDateSpecification.hasMonth()) {
            set(2, gDateSpecification.getMonth() - 1);
        }
        if (gDateSpecification.hasDay()) {
            set(5, gDateSpecification.getDay());
        }
        if (gDateSpecification.hasTime()) {
            set(11, gDateSpecification.getHour());
            set(12, gDateSpecification.getMinute());
            set(13, gDateSpecification.getSecond());
            if (gDateSpecification.getFraction().scale() > 0) {
                set(14, gDateSpecification.getMillisecond());
            }
        }
        if (gDateSpecification.hasTimeZone()) {
            set(15, gDateSpecification.getTimeZoneSign() * 1000 * 60 * ((gDateSpecification.getTimeZoneHour() * 60) + gDateSpecification.getTimeZoneMinute()));
            set(16, 0);
        }
    }

    public XmlCalendar(Date date) {
        this(TimeZone.getDefault(), new GDate(date));
        complete();
    }

    public XmlCalendar(int i, int i2, int i3, int i4, int i5, int i6, BigDecimal bigDecimal) {
        this(TimeZone.getDefault(), new GDate(i, i2, i3, i4, i5, i6, bigDecimal));
    }

    public XmlCalendar(int i, int i2, int i3, int i4, int i5, int i6, BigDecimal bigDecimal, int i7, int i8, int i9) {
        this(new GDate(i, i2, i3, i4, i5, i6, bigDecimal, i7, i8, i9));
    }

    @Override // java.util.Calendar
    public int get(int i) {
        if (!isSet(i) || this.isTimeSet) {
            return super.get(i);
        }
        return internalGet(i);
    }

    public XmlCalendar() {
        setGregorianChange(_beginningOfTime);
        clear();
    }

    public static int getDefaultYear() {
        if (defaultYear == Integer.MIN_VALUE) {
            try {
                String property = SystemProperties.getProperty("user.defaultyear");
                if (property != null) {
                    defaultYear = Integer.parseInt(property);
                } else {
                    defaultYear = 0;
                }
            } catch (Throwable unused) {
                defaultYear = 0;
            }
        }
        return defaultYear;
    }

    public static void setDefaultYear(int i) {
        defaultYear = i;
    }

    @Override // java.util.GregorianCalendar, java.util.Calendar
    protected void computeTime() {
        boolean z = !isSet(1);
        if (z) {
            set(1, getDefaultYear());
        }
        try {
            super.computeTime();
        } finally {
            if (z) {
                clear(1);
            }
        }
    }

    @Override // java.util.Calendar
    public String toString() {
        return new GDate(this).toString();
    }
}
