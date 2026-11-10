package org.apache.xmlbeans.impl.common;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class XBLogFactory {
    private static final Map<String, XBLogger> _loggers = new HashMap();
    private static final XBLogger _nullLogger = new NullLogger();
    static String _loggerClassName = null;

    private XBLogFactory() {
    }

    public static XBLogger getLogger(Class<?> cls) {
        return getLogger(cls.getName());
    }

    public static XBLogger getLogger(String str) {
        if (_loggerClassName == null) {
            try {
                _loggerClassName = System.getProperty("org.apache.xmlbeans.impl.store.XBLogger");
            } catch (Exception unused) {
            }
            if (_loggerClassName == null) {
                _loggerClassName = _nullLogger.getClass().getName();
            }
        }
        String str2 = _loggerClassName;
        XBLogger xBLogger = _nullLogger;
        if (str2.equals(xBLogger.getClass().getName())) {
            return xBLogger;
        }
        XBLogger xBLogger2 = _loggers.get(str);
        if (xBLogger2 == null) {
            try {
                xBLogger2 = (XBLogger) Class.forName(_loggerClassName).newInstance();
                xBLogger2.initialize(str);
            } catch (Exception unused2) {
                xBLogger2 = _nullLogger;
                _loggerClassName = xBLogger2.getClass().getName();
            }
            _loggers.put(str, xBLogger2);
        }
        return xBLogger2;
    }
}
