package org.apache.poi.ss.formula.functions;

import java.util.Calendar;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Today extends Fixed0ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function0Arg
    public ValueEval evaluate(int i, int i2) {
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
        localeCalendar.clear(10);
        localeCalendar.set(11, 0);
        localeCalendar.clear(12);
        localeCalendar.clear(13);
        localeCalendar.clear(14);
        return new NumberEval(DateUtil.getExcelDate(localeCalendar.getTime()));
    }
}
