package org.apache.poi.ss.format;

import java.util.Formatter;
import java.util.Locale;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CellGeneralFormatter extends CellFormatter {
    public CellGeneralFormatter() {
        this(LocaleUtil.getUserLocale());
    }

    public CellGeneralFormatter(Locale locale) {
        super(locale, "General");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:25:0x005b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0060  */
    /* JADX WARN: Code duplicated, block: B:30:0x006b A[LOOP:0: B:28:0x0065->B:30:0x006b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer stringBuffer, Object obj) {
        String str;
        boolean z;
        Formatter formatter;
        int length;
        int i;
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            if (dDoubleValue == 0.0d) {
                stringBuffer.append('0');
                return;
            }
            double dLog10 = Math.log10(Math.abs(dDoubleValue));
            try {
                if (dLog10 <= 10.0d && dLog10 >= -9.0d) {
                    if (((long) dDoubleValue) != dDoubleValue) {
                        str = "%1.9f";
                    } else {
                        str = "%1.0f";
                        z = false;
                    }
                    formatter = new Formatter(stringBuffer, this.locale);
                    formatter.format(this.locale, str, obj);
                    formatter.close();
                    if (z) {
                        if (str.endsWith("E")) {
                            length = stringBuffer.lastIndexOf("E");
                        } else {
                            length = stringBuffer.length();
                        }
                        i = length - 1;
                        while (stringBuffer.charAt(i) == '0') {
                            stringBuffer.deleteCharAt(i);
                            i--;
                        }
                        if (stringBuffer.charAt(i) == '.') {
                            stringBuffer.deleteCharAt(i);
                            return;
                        }
                        return;
                    }
                    return;
                }
                str = "%1.5E";
                formatter.format(this.locale, str, obj);
                formatter.close();
                if (z) {
                    if (str.endsWith("E")) {
                        length = stringBuffer.lastIndexOf("E");
                    } else {
                        length = stringBuffer.length();
                    }
                    i = length - 1;
                    while (stringBuffer.charAt(i) == '0') {
                        stringBuffer.deleteCharAt(i);
                        i--;
                    }
                    if (stringBuffer.charAt(i) == '.') {
                        stringBuffer.deleteCharAt(i);
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                formatter.close();
                throw th;
            }
            z = true;
            formatter = new Formatter(stringBuffer, this.locale);
        } else if (obj instanceof Boolean) {
            stringBuffer.append(obj.toString().toUpperCase(Locale.ROOT));
        } else {
            stringBuffer.append(obj);
        }
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        formatValue(stringBuffer, obj);
    }
}
