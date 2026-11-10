package org.apache.poi.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public final class POILogFactory {
    private static final Map<String, POILogger> _loggers = new HashMap();
    private static final POILogger _nullLogger = new NullLogger();
    static String _loggerClassName = null;

    private POILogFactory() {
    }

    public static POILogger getLogger(Class<?> cls) {
        return getLogger(cls.getName());
    }

    public static POILogger getLogger(String str) {
        if (_loggerClassName == null) {
            try {
                _loggerClassName = System.getProperty("org.apache.poi.util.POILogger");
            } catch (Exception unused) {
            }
            if (_loggerClassName == null) {
                _loggerClassName = _nullLogger.getClass().getName();
            }
        }
        String str2 = _loggerClassName;
        POILogger pOILogger = _nullLogger;
        if (str2.equals(pOILogger.getClass().getName())) {
            return pOILogger;
        }
        POILogger pOILogger2 = _loggers.get(str);
        if (pOILogger2 == null) {
            try {
                pOILogger2 = (POILogger) Class.forName(_loggerClassName).newInstance();
                pOILogger2.initialize(str);
            } catch (Exception unused2) {
                pOILogger2 = _nullLogger;
                _loggerClassName = pOILogger2.getClass().getName();
            }
            _loggers.put(str, pOILogger2);
        }
        return pOILogger2;
    }
}
