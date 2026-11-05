package com.google.gson.internal.bind.util;

import chip.FinalChip;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int iAbs = Math.abs(i / 60);
            int iAbs2 = Math.abs(i % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, iAbs, 2);
            sb.append(':');
            padInt(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00d4 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:3:0x000a, B:5:0x001c, B:6:0x001e, B:8:0x002a, B:9:0x002c, B:11:0x003b, B:13:0x0041, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:23:0x0075, B:25:0x007b, B:29:0x0085, B:34:0x0095, B:36:0x009d, B:48:0x00ce, B:50:0x00d4, B:52:0x00db, B:78:0x0186, B:58:0x00ea, B:59:0x0102, B:60:0x0103, B:64:0x0121, B:66:0x012e, B:69:0x0137, B:71:0x0152, B:74:0x0161, B:75:0x0181, B:77:0x0184, B:63:0x010e, B:80:0x01b8, B:81:0x01bf, B:41:0x00b6, B:42:0x00b9), top: B:97:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00db A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:3:0x000a, B:5:0x001c, B:6:0x001e, B:8:0x002a, B:9:0x002c, B:11:0x003b, B:13:0x0041, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:23:0x0075, B:25:0x007b, B:29:0x0085, B:34:0x0095, B:36:0x009d, B:48:0x00ce, B:50:0x00d4, B:52:0x00db, B:78:0x0186, B:58:0x00ea, B:59:0x0102, B:60:0x0103, B:64:0x0121, B:66:0x012e, B:69:0x0137, B:71:0x0152, B:74:0x0161, B:75:0x0181, B:77:0x0184, B:63:0x010e, B:80:0x01b8, B:81:0x01bf, B:41:0x00b6, B:42:0x00b9), top: B:97:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:62:0x010d  */
    /* JADX WARN: Code duplicated, block: B:63:0x010e A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:3:0x000a, B:5:0x001c, B:6:0x001e, B:8:0x002a, B:9:0x002c, B:11:0x003b, B:13:0x0041, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:23:0x0075, B:25:0x007b, B:29:0x0085, B:34:0x0095, B:36:0x009d, B:48:0x00ce, B:50:0x00d4, B:52:0x00db, B:78:0x0186, B:58:0x00ea, B:59:0x0102, B:60:0x0103, B:64:0x0121, B:66:0x012e, B:69:0x0137, B:71:0x0152, B:74:0x0161, B:75:0x0181, B:77:0x0184, B:63:0x010e, B:80:0x01b8, B:81:0x01bf, B:41:0x00b6, B:42:0x00b9), top: B:97:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0184 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:3:0x000a, B:5:0x001c, B:6:0x001e, B:8:0x002a, B:9:0x002c, B:11:0x003b, B:13:0x0041, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:23:0x0075, B:25:0x007b, B:29:0x0085, B:34:0x0095, B:36:0x009d, B:48:0x00ce, B:50:0x00d4, B:52:0x00db, B:78:0x0186, B:58:0x00ea, B:59:0x0102, B:60:0x0103, B:64:0x0121, B:66:0x012e, B:69:0x0137, B:71:0x0152, B:74:0x0161, B:75:0x0181, B:77:0x0184, B:63:0x010e, B:80:0x01b8, B:81:0x01bf, B:41:0x00b6, B:42:0x00b9), top: B:97:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01b8 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:3:0x000a, B:5:0x001c, B:6:0x001e, B:8:0x002a, B:9:0x002c, B:11:0x003b, B:13:0x0041, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:23:0x0075, B:25:0x007b, B:29:0x0085, B:34:0x0095, B:36:0x009d, B:48:0x00ce, B:50:0x00d4, B:52:0x00db, B:78:0x0186, B:58:0x00ea, B:59:0x0102, B:60:0x0103, B:64:0x0121, B:66:0x012e, B:69:0x0137, B:71:0x0152, B:74:0x0161, B:75:0x0181, B:77:0x0184, B:63:0x010e, B:80:0x01b8, B:81:0x01bf, B:41:0x00b6, B:42:0x00b9), top: B:97:0x000a }] */
    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        int i;
        int i2;
        int i3;
        int i4;
        char cCharAt;
        String strSubstring;
        int length;
        TimeZone timeZone;
        char cCharAt2;
        try {
            int index = parsePosition.getIndex();
            int i5 = index + 4;
            int i6 = parseInt(str, index, i5);
            if (checkOffset(str, i5, '-')) {
                i5++;
            }
            int i7 = i5 + 2;
            int i8 = parseInt(str, i5, i7);
            if (checkOffset(str, i7, '-')) {
                i7++;
            }
            int i9 = i7 + 2;
            int i10 = parseInt(str, i7, i9);
            boolean zCheckOffset = checkOffset(str, i9, 'T');
            if (!zCheckOffset && str.length() <= i9) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(i6, i8 - 1, i10);
                parsePosition.setIndex(i9);
                return gregorianCalendar.getTime();
            }
            if (zCheckOffset) {
                int i11 = i9 + 1;
                int i12 = i11 + 2;
                int i13 = parseInt(str, i11, i12);
                if (checkOffset(str, i12, ':')) {
                    i12++;
                }
                int i14 = i12 + 2;
                i2 = parseInt(str, i12, i14);
                if (checkOffset(str, i14, ':')) {
                    i14++;
                }
                if (str.length() <= i14 || (cCharAt2 = str.charAt(i14)) == 'Z' || cCharAt2 == '+' || cCharAt2 == '-') {
                    i = i13;
                    i9 = i14;
                } else {
                    int i15 = i14 + 2;
                    i4 = parseInt(str, i14, i15);
                    if (i4 > 59 && i4 < 63) {
                        i4 = 59;
                    }
                    if (checkOffset(str, i15, '.')) {
                        int i16 = i15 + 1;
                        int iIndexOfNonDigit = indexOfNonDigit(str, i16 + 1);
                        int iMin = Math.min(iIndexOfNonDigit, i16 + 3);
                        int i17 = parseInt(str, i16, iMin);
                        int i18 = iMin - i16;
                        if (i18 == 1) {
                            i17 *= 100;
                        } else if (i18 == 2) {
                            i17 *= 10;
                        }
                        i3 = i17;
                        i9 = iIndexOfNonDigit;
                        i = i13;
                    } else {
                        i = i13;
                        i9 = i15;
                        i3 = 0;
                    }
                }
                if (str.length() > i9) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                cCharAt = str.charAt(i9);
                if (cCharAt == 'Z') {
                    timeZone = TIMEZONE_UTC;
                    length = i9 + 1;
                } else {
                    if (cCharAt != '+' && cCharAt != '-') {
                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                    }
                    strSubstring = str.substring(i9);
                    if (strSubstring.length() >= 5) {
                        strSubstring = strSubstring + "00";
                    }
                    length = i9 + strSubstring.length();
                    if (!"+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                        timeZone = TIMEZONE_UTC;
                    } else {
                        String str2 = "GMT" + strSubstring;
                        TimeZone timeZone2 = TimeZone.getTimeZone(str2);
                        String id = timeZone2.getID();
                        if (!id.equals(str2) && !id.replace(":", FinalChip.BSP_PLATFORM_Null).equals(str2)) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone2.getID());
                        }
                        timeZone = timeZone2;
                    }
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                gregorianCalendar2.setLenient(false);
                gregorianCalendar2.set(1, i6);
                gregorianCalendar2.set(2, i8 - 1);
                gregorianCalendar2.set(5, i10);
                gregorianCalendar2.set(11, i);
                gregorianCalendar2.set(12, i2);
                gregorianCalendar2.set(13, i4);
                gregorianCalendar2.set(14, i3);
                parsePosition.setIndex(length);
                return gregorianCalendar2.getTime();
            }
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            if (str.length() > i9) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            cCharAt = str.charAt(i9);
            if (cCharAt == 'Z') {
                timeZone = TIMEZONE_UTC;
                length = i9 + 1;
            } else {
                if (cCharAt != '+') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                }
                strSubstring = str.substring(i9);
                if (strSubstring.length() >= 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i9 + strSubstring.length();
                if (!"+0000".equals(strSubstring)) {
                    timeZone = TIMEZONE_UTC;
                } else {
                    timeZone = TIMEZONE_UTC;
                }
            }
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(timeZone);
            gregorianCalendar3.setLenient(false);
            gregorianCalendar3.set(1, i6);
            gregorianCalendar3.set(2, i8 - 1);
            gregorianCalendar3.set(5, i10);
            gregorianCalendar3.set(11, i);
            gregorianCalendar3.set(12, i2);
            gregorianCalendar3.set(13, i4);
            gregorianCalendar3.set(14, i3);
            parsePosition.setIndex(length);
            return gregorianCalendar3.getTime();
        } catch (IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException e) {
            String str3 = str == null ? null : "\"" + str + '\"';
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str3 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - iDigit2;
            i4 = i5;
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String string = Integer.toString(i);
        for (int length = i2 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
