package org.apache.poi.ss.usermodel;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;
import module.canbus.FinalCanbus;
import org.apache.poi.ss.formula.ConditionalFormattingEvaluator;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DateUtil {
    private static final int BAD_DATE = -1;
    public static final long DAY_MILLISECONDS = 86400000;
    public static final int HOURS_PER_DAY = 24;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_MINUTE = 60;
    private static final Pattern TIME_SEPARATOR_PATTERN = Pattern.compile(":");
    private static final Pattern date_ptrn1 = Pattern.compile("^\\[\\$\\-.*?\\]");
    private static final Pattern date_ptrn2 = Pattern.compile("^\\[[a-zA-Z]+\\]");
    private static final Pattern date_ptrn3a = Pattern.compile("[yYmMdDhHsS]");
    private static final Pattern date_ptrn3b = Pattern.compile("^[\\[\\]yYmMdDhHsS\\-T/年月日,. :\"\\\\]+0*[ampAMP/]*$");
    private static final Pattern date_ptrn4 = Pattern.compile("^\\[([hH]+|[mM]+|[sS]+)\\]");
    private static final Pattern date_ptrn5 = Pattern.compile("^\\[DBNum(1|2|3)\\]");
    private static ThreadLocal<Integer> lastFormatIndex = new ThreadLocal<Integer>() { // from class: org.apache.poi.ss.usermodel.DateUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Integer initialValue() {
            return -1;
        }
    };
    private static ThreadLocal<String> lastFormatString = new ThreadLocal<>();
    private static ThreadLocal<Boolean> lastCachedResult = new ThreadLocal<>();

    public static boolean isInternalDateFormat(int i) {
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return true;
            default:
                switch (i) {
                    case 45:
                    case 46:
                    case 47:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public static boolean isValidExcelDate(double d) {
        return d > -4.9E-324d;
    }

    protected DateUtil() {
    }

    public static double getExcelDate(Date date) {
        return getExcelDate(date, false);
    }

    public static double getExcelDate(Date date, boolean z) {
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
        localeCalendar.setTime(date);
        return internalGetExcelDate(localeCalendar, z);
    }

    public static double getExcelDate(Calendar calendar, boolean z) {
        return internalGetExcelDate((Calendar) calendar.clone(), z);
    }

    private static double internalGetExcelDate(Calendar calendar, boolean z) {
        if (!z && calendar.get(1) < 1900) {
            return -1.0d;
        }
        if (z && calendar.get(1) < 1904) {
            return -1.0d;
        }
        double dAbsoluteDay = (((double) ((((((calendar.get(11) * 60) + calendar.get(12)) * 60) + calendar.get(13)) * 1000) + calendar.get(14))) / 8.64E7d) + ((double) absoluteDay(dayStart(calendar), z));
        if (z || dAbsoluteDay < 60.0d) {
            return z ? dAbsoluteDay - 1.0d : dAbsoluteDay;
        }
        return dAbsoluteDay + 1.0d;
    }

    public static Date getJavaDate(double d, TimeZone timeZone) {
        return getJavaDate(d, false, timeZone, false);
    }

    public static Date getJavaDate(double d) {
        return getJavaDate(d, false, null, false);
    }

    public static Date getJavaDate(double d, boolean z, TimeZone timeZone) {
        return getJavaDate(d, z, timeZone, false);
    }

    public static Date getJavaDate(double d, boolean z, TimeZone timeZone, boolean z2) {
        Calendar javaCalendar = getJavaCalendar(d, z, timeZone, z2);
        if (javaCalendar == null) {
            return null;
        }
        return javaCalendar.getTime();
    }

    public static Date getJavaDate(double d, boolean z) {
        return getJavaDate(d, z, null, false);
    }

    public static void setCalendar(Calendar calendar, int i, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        if (z) {
            i4 = 1;
            i3 = 1904;
        } else {
            i3 = 1900;
            i4 = i < 61 ? 0 : -1;
        }
        calendar.set(i3, 0, i + i4, 0, 0, 0);
        calendar.set(14, i2);
        if (calendar.get(14) == 0) {
            calendar.clear(14);
        }
        if (z2) {
            calendar.add(14, 500);
            calendar.clear(14);
        }
    }

    public static Calendar getJavaCalendar(double d) {
        return getJavaCalendar(d, false, null, false);
    }

    public static Calendar getJavaCalendar(double d, boolean z) {
        return getJavaCalendar(d, z, null, false);
    }

    public static Calendar getJavaCalendarUTC(double d, boolean z) {
        return getJavaCalendar(d, z, LocaleUtil.TIMEZONE_UTC, false);
    }

    public static Calendar getJavaCalendar(double d, boolean z, TimeZone timeZone) {
        return getJavaCalendar(d, z, timeZone, false);
    }

    public static Calendar getJavaCalendar(double d, boolean z, TimeZone timeZone, boolean z2) {
        Calendar localeCalendar;
        if (!isValidExcelDate(d)) {
            return null;
        }
        int iFloor = (int) Math.floor(d);
        int i = (int) (((d - ((double) iFloor)) * 8.64E7d) + 0.5d);
        if (timeZone != null) {
            localeCalendar = LocaleUtil.getLocaleCalendar(timeZone);
        } else {
            localeCalendar = LocaleUtil.getLocaleCalendar();
        }
        setCalendar(localeCalendar, iFloor, i, z, z2);
        return localeCalendar;
    }

    private static boolean isCached(String str, int i) {
        String str2 = lastFormatString.get();
        return str2 != null && i == lastFormatIndex.get().intValue() && str.equals(str2);
    }

    private static void cache(String str, int i, boolean z) {
        lastFormatIndex.set(Integer.valueOf(i));
        lastFormatString.set(str);
        lastCachedResult.set(Boolean.valueOf(z));
    }

    public static boolean isADateFormat(ExcelNumberFormat excelNumberFormat) {
        if (excelNumberFormat == null) {
            return false;
        }
        return isADateFormat(excelNumberFormat.getIdx(), excelNumberFormat.getFormat());
    }

    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    public static boolean isADateFormat(int i, String str) {
        if (isInternalDateFormat(i)) {
            cache(str, i, true);
            return true;
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        if (isCached(str, i)) {
            return lastCachedResult.get().booleanValue();
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (i2 < length - 1) {
                int i3 = i2 + 1;
                char cCharAt2 = str.charAt(i3);
                if (cCharAt == '\\') {
                    if (cCharAt2 != ' ' && cCharAt2 != '\\') {
                        switch (cCharAt2) {
                            case ',':
                            case '-':
                            case '.':
                                break;
                            default:
                                sb.append(cCharAt);
                                break;
                        }
                    }
                } else if (cCharAt == ';' && cCharAt2 == '@') {
                    i2 = i3;
                } else {
                    sb.append(cCharAt);
                }
            } else {
                sb.append(cCharAt);
            }
            i2++;
        }
        String string = sb.toString();
        if (date_ptrn4.matcher(string).matches()) {
            cache(str, i, true);
            return true;
        }
        String strReplaceAll = date_ptrn2.matcher(date_ptrn1.matcher(date_ptrn5.matcher(string).replaceAll("")).replaceAll("")).replaceAll("");
        int iIndexOf = strReplaceAll.indexOf(59);
        if (iIndexOf > 0 && iIndexOf < strReplaceAll.length() - 1) {
            strReplaceAll = strReplaceAll.substring(0, iIndexOf);
        }
        if (!date_ptrn3a.matcher(strReplaceAll).find()) {
            return false;
        }
        boolean zMatches = date_ptrn3b.matcher(strReplaceAll).matches();
        cache(str, i, zMatches);
        return zMatches;
    }

    public static boolean isCellDateFormatted(Cell cell) {
        return isCellDateFormatted(cell, null);
    }

    public static boolean isCellDateFormatted(Cell cell, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        ExcelNumberFormat excelNumberFormatFrom;
        if (cell == null || !isValidExcelDate(cell.getNumericCellValue()) || (excelNumberFormatFrom = ExcelNumberFormat.from(cell, conditionalFormattingEvaluator)) == null) {
            return false;
        }
        return isADateFormat(excelNumberFormatFrom);
    }

    public static boolean isCellInternalDateFormatted(Cell cell) {
        if (cell != null && isValidExcelDate(cell.getNumericCellValue())) {
            return isInternalDateFormat(cell.getCellStyle().getDataFormat());
        }
        return false;
    }

    protected static int absoluteDay(Calendar calendar, boolean z) {
        return calendar.get(6) + daysInPriorYears(calendar.get(1), z);
    }

    private static int daysInPriorYears(int i, boolean z) {
        if ((!z && i < 1900) || (z && i < 1904)) {
            throw new IllegalArgumentException("'year' must be 1900 or greater");
        }
        int i2 = i - 1;
        return ((i - (z ? 1904 : 1900)) * FinalCanbus.CAR_AY1_JeepZiYouGuang) + ((((i2 / 4) - (i2 / 100)) + (i2 / FinalCanbus.CAR_FYTA_JILI_XiongMiao)) - 460);
    }

    private static Calendar dayStart(Calendar calendar) {
        calendar.get(11);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.get(11);
        return calendar;
    }

    private static final class FormatException extends Exception {
        public FormatException(String str) {
            super(str);
        }
    }

    public static double convertTime(String str) {
        try {
            return convertTimeInternal(str);
        } catch (FormatException e) {
            throw new IllegalArgumentException("Bad time format '" + str + "' expected 'HH:MM' or 'HH:MM:SS' - " + e.getMessage());
        }
    }

    private static double convertTimeInternal(String str) throws FormatException {
        String str2;
        int length = str.length();
        if (length < 4 || length > 8) {
            throw new FormatException("Bad length");
        }
        String[] strArrSplit = TIME_SEPARATOR_PATTERN.split(str);
        int length2 = strArrSplit.length;
        if (length2 == 2) {
            str2 = "00";
        } else if (length2 == 3) {
            str2 = strArrSplit[2];
        } else {
            throw new FormatException("Expected 2 or 3 fields but got (" + strArrSplit.length + ")");
        }
        String str3 = strArrSplit[0];
        return ((double) (parseInt(str2, "second", 60) + ((parseInt(strArrSplit[1], "minute", 60) + (parseInt(str3, "hour", 24) * 60)) * 60))) / 86400.0d;
    }

    public static Date parseYYYYMMDDDate(String str) {
        try {
            return parseYYYYMMDDDateInternal(str);
        } catch (FormatException e) {
            throw new IllegalArgumentException("Bad time format " + str + " expected 'YYYY/MM/DD' - " + e.getMessage());
        }
    }

    private static Date parseYYYYMMDDDateInternal(String str) throws FormatException {
        if (str.length() != 10) {
            throw new FormatException("Bad length");
        }
        String strSubstring = str.substring(0, 4);
        String strSubstring2 = str.substring(5, 7);
        String strSubstring3 = str.substring(8, 10);
        return LocaleUtil.getLocaleCalendar(parseInt(strSubstring, "year", -32768, 32767), parseInt(strSubstring2, "month", 1, 12) - 1, parseInt(strSubstring3, "day", 1, 31)).getTime();
    }

    private static int parseInt(String str, String str2, int i) throws FormatException {
        return parseInt(str, str2, 0, i - 1);
    }

    private static int parseInt(String str, String str2, int i, int i2) throws FormatException {
        try {
            int i3 = Integer.parseInt(str);
            if (i3 < i || i3 > i2) {
                throw new FormatException(str2 + " value (" + i3 + ") is outside the allowable range(0.." + i2 + ")");
            }
            return i3;
        } catch (NumberFormatException unused) {
            throw new FormatException("Bad int format '" + str + "' for " + str2 + " field");
        }
    }
}
