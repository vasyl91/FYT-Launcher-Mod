package org.apache.xmlbeans;

import java.math.BigDecimal;
import java.util.Date;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface GDateSpecification {
    public static final int HAS_DAY = 8;
    public static final int HAS_MONTH = 4;
    public static final int HAS_TIME = 16;
    public static final int HAS_TIMEZONE = 1;
    public static final int HAS_YEAR = 2;

    String canonicalString();

    int compareToGDate(GDateSpecification gDateSpecification);

    int getBuiltinTypeCode();

    XmlCalendar getCalendar();

    Date getDate();

    int getDay();

    int getFlags();

    BigDecimal getFraction();

    int getHour();

    int getJulianDate();

    int getMillisecond();

    int getMinute();

    int getMonth();

    int getSecond();

    int getTimeZoneHour();

    int getTimeZoneMinute();

    int getTimeZoneSign();

    int getYear();

    boolean hasDate();

    boolean hasDay();

    boolean hasMonth();

    boolean hasTime();

    boolean hasTimeZone();

    boolean hasYear();

    boolean isImmutable();

    boolean isValid();

    String toString();
}
