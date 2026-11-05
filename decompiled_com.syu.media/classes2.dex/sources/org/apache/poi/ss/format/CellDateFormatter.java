package org.apache.poi.ss.format;

import java.text.AttributedCharacterIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.regex.Matcher;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CellDateFormatter extends CellFormatter {
    private static CellDateFormatter SIMPLE_DATE;
    private final Calendar EXCEL_EPOCH_CAL;
    private boolean amPmUpper;
    private final DateFormat dateFmt;
    private String sFmt;
    private boolean showAmPm;
    private boolean showM;

    private class DatePartHandler implements CellFormatPart.PartHandler {
        private int hLen;
        private int hStart;
        private int mLen;
        private int mStart;

        private DatePartHandler() {
            this.mStart = -1;
            this.hStart = -1;
        }

        @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
        public String handlePart(Matcher matcher, String str, CellFormatType cellFormatType, StringBuffer stringBuffer) {
            int length = stringBuffer.length();
            switch (str.charAt(0)) {
                case '0':
                    this.mStart = -1;
                    int length2 = str.length();
                    CellDateFormatter.this.sFmt = "%0" + (length2 + 2) + "." + length2 + "f";
                    return str.replace('0', 'S');
                case 'A':
                case 'P':
                case 'a':
                case 'p':
                    if (str.length() <= 1) {
                        return null;
                    }
                    this.mStart = -1;
                    CellDateFormatter.this.showAmPm = true;
                    CellDateFormatter.this.showM = Character.toLowerCase(str.charAt(1)) == 'm';
                    CellDateFormatter cellDateFormatter = CellDateFormatter.this;
                    cellDateFormatter.amPmUpper = cellDateFormatter.showM || Character.isUpperCase(str.charAt(0));
                    return "a";
                case 'D':
                case 'd':
                    this.mStart = -1;
                    if (str.length() <= 2) {
                        return str.toLowerCase(Locale.ROOT);
                    }
                    return str.toLowerCase(Locale.ROOT).replace('d', 'E');
                case 'H':
                case 'h':
                    this.mStart = -1;
                    this.hStart = length;
                    this.hLen = str.length();
                    return str.toLowerCase(Locale.ROOT);
                case 'M':
                case 'm':
                    this.mStart = length;
                    this.mLen = str.length();
                    if (this.hStart >= 0) {
                        return str.toLowerCase(Locale.ROOT);
                    }
                    return str.toUpperCase(Locale.ROOT);
                case 'S':
                case 's':
                    if (this.mStart >= 0) {
                        for (int i = 0; i < this.mLen; i++) {
                            stringBuffer.setCharAt(this.mStart + i, 'm');
                        }
                        this.mStart = -1;
                    }
                    return str.toLowerCase(Locale.ROOT);
                case 'Y':
                case 'y':
                    this.mStart = -1;
                    if (str.length() == 3) {
                        str = "yyyy";
                    }
                    return str.toLowerCase(Locale.ROOT);
                default:
                    return null;
            }
        }

        public void finish(StringBuffer stringBuffer) {
            if (this.hStart < 0 || CellDateFormatter.this.showAmPm) {
                return;
            }
            for (int i = 0; i < this.hLen; i++) {
                stringBuffer.setCharAt(this.hStart + i, 'H');
            }
        }
    }

    public CellDateFormatter(String str) {
        this(LocaleUtil.getUserLocale(), str);
    }

    public CellDateFormatter(Locale locale, String str) {
        super(str);
        this.EXCEL_EPOCH_CAL = LocaleUtil.getLocaleCalendar(1904, 0, 1);
        DatePartHandler datePartHandler = new DatePartHandler();
        StringBuffer format = CellFormatPart.parseFormat(str, CellFormatType.DATE, datePartHandler);
        datePartHandler.finish(format);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format.toString().replaceAll("((y)(?!y))(?<!yy)", "yy"), locale);
        this.dateFmt = simpleDateFormat;
        simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer stringBuffer, Object obj) {
        Object objValueOf = obj == null ? Double.valueOf(0.0d) : obj;
        if (objValueOf instanceof Number) {
            long jLongValue = ((Number) objValueOf).longValue();
            if (jLongValue == 0) {
                objValueOf = this.EXCEL_EPOCH_CAL.getTime();
            } else {
                Calendar calendar = (Calendar) this.EXCEL_EPOCH_CAL.clone();
                calendar.add(13, (int) (jLongValue / 1000));
                calendar.add(14, (int) (jLongValue % 1000));
                objValueOf = calendar.getTime();
            }
        }
        AttributedCharacterIterator toCharacterIterator = this.dateFmt.formatToCharacterIterator(objValueOf);
        toCharacterIterator.first();
        boolean z = false;
        boolean z2 = false;
        for (char cFirst = toCharacterIterator.first(); cFirst != 65535; cFirst = toCharacterIterator.next()) {
            if (toCharacterIterator.getAttribute(DateFormat.Field.MILLISECOND) != null) {
                if (z) {
                    continue;
                } else {
                    Date date = (Date) objValueOf;
                    int length = stringBuffer.length();
                    Formatter formatter = new Formatter(stringBuffer, Locale.ROOT);
                    try {
                        formatter.format(this.locale, this.sFmt, Double.valueOf((date.getTime() % 1000) / 1000.0d));
                        formatter.close();
                        stringBuffer.delete(length, length + 2);
                        z = true;
                    } catch (Throwable th) {
                        formatter.close();
                        throw th;
                    }
                }
            } else if (toCharacterIterator.getAttribute(DateFormat.Field.AM_PM) == null) {
                stringBuffer.append(cFirst);
            } else if (!z2) {
                if (this.showAmPm) {
                    if (this.amPmUpper) {
                        stringBuffer.append(Character.toUpperCase(cFirst));
                        if (this.showM) {
                            stringBuffer.append('M');
                        }
                    } else {
                        stringBuffer.append(Character.toLowerCase(cFirst));
                        if (this.showM) {
                            stringBuffer.append('m');
                        }
                    }
                }
                z2 = true;
            }
        }
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        synchronized (CellDateFormatter.class) {
            CellDateFormatter cellDateFormatter = SIMPLE_DATE;
            if (cellDateFormatter == null || !cellDateFormatter.EXCEL_EPOCH_CAL.equals(this.EXCEL_EPOCH_CAL)) {
                SIMPLE_DATE = new CellDateFormatter("mm/d/y");
            }
        }
        SIMPLE_DATE.formatValue(stringBuffer, obj);
    }
}
