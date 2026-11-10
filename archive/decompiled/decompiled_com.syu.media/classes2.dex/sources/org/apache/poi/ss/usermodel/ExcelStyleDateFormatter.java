package org.apache.poi.ss.usermodel;

import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import module.canbus.FinalCanbus;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ExcelStyleDateFormatter extends SimpleDateFormat {
    public static final char HH_BRACKET_SYMBOL = 57361;
    public static final char H_BRACKET_SYMBOL = 57360;
    public static final char LL_BRACKET_SYMBOL = 57367;
    public static final char L_BRACKET_SYMBOL = 57366;
    public static final char MMMMM_START_SYMBOL = 57345;
    public static final char MMMMM_TRUNCATE_SYMBOL = 57346;
    public static final char MM_BRACKET_SYMBOL = 57363;
    public static final char M_BRACKET_SYMBOL = 57362;
    public static final char SS_BRACKET_SYMBOL = 57365;
    public static final char S_BRACKET_SYMBOL = 57364;
    private static final DecimalFormat format1digit;
    private static final DecimalFormat format2digits;
    private static final DecimalFormat format3digit;
    private static final DecimalFormat format4digits;
    private double dateToBeFormatted;

    static {
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.ROOT);
        DecimalFormat decimalFormat = new DecimalFormat("0", decimalFormatSymbols);
        format1digit = decimalFormat;
        DecimalFormat decimalFormat2 = new DecimalFormat("00", decimalFormatSymbols);
        format2digits = decimalFormat2;
        DecimalFormat decimalFormat3 = new DecimalFormat("0", decimalFormatSymbols);
        format3digit = decimalFormat3;
        DecimalFormat decimalFormat4 = new DecimalFormat("00", decimalFormatSymbols);
        format4digits = decimalFormat4;
        DataFormatter.setExcelStyleRoundingMode(decimalFormat, RoundingMode.DOWN);
        DataFormatter.setExcelStyleRoundingMode(decimalFormat2, RoundingMode.DOWN);
        DataFormatter.setExcelStyleRoundingMode(decimalFormat3);
        DataFormatter.setExcelStyleRoundingMode(decimalFormat4);
    }

    public ExcelStyleDateFormatter(String str) {
        super(processFormatPattern(str), LocaleUtil.getUserLocale());
        setTimeZone(LocaleUtil.getUserTimeZone());
    }

    public ExcelStyleDateFormatter(String str, DateFormatSymbols dateFormatSymbols) {
        super(processFormatPattern(str), dateFormatSymbols);
        setTimeZone(LocaleUtil.getUserTimeZone());
    }

    public ExcelStyleDateFormatter(String str, Locale locale) {
        super(processFormatPattern(str), locale);
        setTimeZone(LocaleUtil.getUserTimeZone());
    }

    private static String processFormatPattern(String str) {
        return str.replaceAll("MMMMM", "\ue001MMM\ue002").replaceAll("\\[H]", String.valueOf(H_BRACKET_SYMBOL)).replaceAll("\\[HH]", String.valueOf(HH_BRACKET_SYMBOL)).replaceAll("\\[m]", String.valueOf(M_BRACKET_SYMBOL)).replaceAll("\\[mm]", String.valueOf(MM_BRACKET_SYMBOL)).replaceAll("\\[s]", String.valueOf(S_BRACKET_SYMBOL)).replaceAll("\\[ss]", String.valueOf(SS_BRACKET_SYMBOL)).replaceAll("s.000", "s.SSS").replaceAll("s.00", "s.\ue017").replaceAll("s.0", "s.\ue016");
    }

    public void setDateToBeFormatted(double d) {
        this.dateToBeFormatted = d;
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        String string = super.format(date, stringBuffer, fieldPosition).toString();
        if (string.indexOf(FinalCanbus.CAR_E001_BENZ) != -1) {
            string = string.replaceAll("\ue001(\\p{L}|\\p{P})[\\p{L}\\p{P}]+\ue002", "$1");
        }
        if (string.indexOf(57360) != -1 || string.indexOf(57361) != -1) {
            double d = ((float) this.dateToBeFormatted) * 24.0f;
            string = string.replaceAll(String.valueOf(H_BRACKET_SYMBOL), format1digit.format(d)).replaceAll(String.valueOf(HH_BRACKET_SYMBOL), format2digits.format(d));
        }
        if (string.indexOf(57362) != -1 || string.indexOf(57363) != -1) {
            double d2 = ((float) this.dateToBeFormatted) * 24.0f * 60.0f;
            string = string.replaceAll(String.valueOf(M_BRACKET_SYMBOL), format1digit.format(d2)).replaceAll(String.valueOf(MM_BRACKET_SYMBOL), format2digits.format(d2));
        }
        if (string.indexOf(57364) != -1 || string.indexOf(57365) != -1) {
            double d3 = (float) (this.dateToBeFormatted * 24.0d * 60.0d * 60.0d);
            string = string.replaceAll(String.valueOf(S_BRACKET_SYMBOL), format1digit.format(d3)).replaceAll(String.valueOf(SS_BRACKET_SYMBOL), format2digits.format(d3));
        }
        if (string.indexOf(57366) != -1 || string.indexOf(57367) != -1) {
            double d4 = this.dateToBeFormatted;
            float fFloor = (float) ((d4 - Math.floor(d4)) * 24.0d * 60.0d * 60.0d);
            float f = fFloor - ((int) fFloor);
            string = string.replaceAll(String.valueOf(L_BRACKET_SYMBOL), format3digit.format(10.0f * f)).replaceAll(String.valueOf(LL_BRACKET_SYMBOL), format4digits.format(f * 100.0f));
        }
        return new StringBuffer(string);
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public boolean equals(Object obj) {
        return (obj instanceof ExcelStyleDateFormatter) && this.dateToBeFormatted == ((ExcelStyleDateFormatter) obj).dateToBeFormatted;
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public int hashCode() {
        return new Double(this.dateToBeFormatted).hashCode();
    }
}
