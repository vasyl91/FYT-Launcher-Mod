package org.apache.poi.ss.formula.atp;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class WorkdayCalculator {
    public static final WorkdayCalculator instance = new WorkdayCalculator();

    protected boolean isInARange(double d, double d2, double d3) {
        return d3 >= d && d3 <= d2;
    }

    private WorkdayCalculator() {
    }

    public int calculateWorkdays(double d, double d2, double[] dArr) {
        int iPastDaysOfWeek = pastDaysOfWeek(d, d2, 7);
        int iPastDaysOfWeek2 = pastDaysOfWeek(d, d2, 1);
        return ((((int) ((d2 - d) + 1.0d)) - iPastDaysOfWeek) - iPastDaysOfWeek2) - calculateNonWeekendHolidays(d, d2, dArr);
    }

    public Date calculateWorkdays(double d, int i, double[] dArr) {
        Date javaDate = DateUtil.getJavaDate(d);
        int i2 = i < 0 ? -1 : 1;
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
        localeCalendar.setTime(javaDate);
        double excelDate = DateUtil.getExcelDate(localeCalendar.getTime());
        while (i != 0) {
            localeCalendar.add(6, i2);
            excelDate += (double) i2;
            if (localeCalendar.get(7) != 7 && localeCalendar.get(7) != 1 && !isHoliday(excelDate, dArr)) {
                i -= i2;
            }
        }
        return localeCalendar.getTime();
    }

    protected int pastDaysOfWeek(double d, double d2, int i) {
        if (d2 > d) {
            d = d2;
        }
        int iFloor = (int) Math.floor(d);
        int i2 = 0;
        for (int iFloor2 = (int) Math.floor(d < d2 ? d : d2); iFloor2 <= iFloor; iFloor2++) {
            Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
            localeCalendar.setTime(DateUtil.getJavaDate(iFloor2));
            if (localeCalendar.get(7) == i) {
                i2++;
            }
        }
        return d <= d2 ? i2 : -i2;
    }

    protected int calculateNonWeekendHolidays(double d, double d2, double[] dArr) {
        double d3 = d < d2 ? d : d2;
        double d4 = d2 > d ? d2 : d;
        int i = 0;
        for (double d5 : dArr) {
            if (isInARange(d3, d4, d5) && !isWeekend(d5)) {
                i++;
            }
        }
        return d <= d2 ? i : -i;
    }

    protected boolean isWeekend(double d) {
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
        localeCalendar.setTime(DateUtil.getJavaDate(d));
        return localeCalendar.get(7) == 7 || localeCalendar.get(7) == 1;
    }

    protected boolean isHoliday(double d, double[] dArr) {
        for (double d2 : dArr) {
            if (Math.round(d2) == Math.round(d)) {
                return true;
            }
        }
        return false;
    }

    @Removal(version = "3.18")
    protected int isNonWorkday(double d, double[] dArr) {
        return (isWeekend(d) || isHoliday(d, dArr)) ? 1 : 0;
    }
}
