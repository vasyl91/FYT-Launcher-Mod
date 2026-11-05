package org.apache.poi.ss.format;

import java.util.Locale;
import java.util.logging.Logger;
import kotlin.text.Typography;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class CellFormatter {
    static final Logger logger = Logger.getLogger(CellFormatter.class.getName());
    protected final String format;
    protected final Locale locale;

    public abstract void formatValue(StringBuffer stringBuffer, Object obj);

    public abstract void simpleValue(StringBuffer stringBuffer, Object obj);

    public CellFormatter(String str) {
        this(LocaleUtil.getUserLocale(), str);
    }

    public CellFormatter(Locale locale, String str) {
        this.locale = locale;
        this.format = str;
    }

    public String format(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        formatValue(stringBuffer, obj);
        return stringBuffer.toString();
    }

    public String simpleFormat(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        simpleValue(stringBuffer, obj);
        return stringBuffer.toString();
    }

    static String quote(String str) {
        return "\"" + str + Typography.quote;
    }
}
