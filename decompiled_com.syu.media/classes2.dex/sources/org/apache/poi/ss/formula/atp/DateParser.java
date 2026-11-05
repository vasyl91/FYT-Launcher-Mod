package org.apache.poi.ss.formula.atp;

import java.util.Calendar;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DateParser {
    private DateParser() {
    }

    public static Calendar parseDate(String str) throws EvaluationException {
        String[] strArrSplit = Pattern.compile("/").split(str);
        if (strArrSplit.length != 3) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        String strSubstring = strArrSplit[2];
        int iIndexOf = strSubstring.indexOf(32);
        if (iIndexOf > 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        try {
            int i = Integer.parseInt(strArrSplit[0]);
            int i2 = Integer.parseInt(strArrSplit[1]);
            int i3 = Integer.parseInt(strSubstring);
            if (i < 0 || i2 < 0 || i3 < 0 || (i > 12 && i2 > 12 && i3 > 12)) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            if (i >= 1900 && i < 9999) {
                return makeDate(i, i2, i3);
            }
            throw new RuntimeException("Unable to determine date format for text '" + str + "'");
        } catch (NumberFormatException unused) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
    }

    private static Calendar makeDate(int i, int i2, int i3) throws EvaluationException {
        if (i2 < 1 || i2 > 12) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar(i, i2 - 1, 1, 0, 0, 0);
        if (i3 < 1 || i3 > localeCalendar.getActualMaximum(5)) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        localeCalendar.set(5, i3);
        return localeCalendar;
    }
}
