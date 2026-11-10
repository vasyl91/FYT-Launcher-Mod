package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.common.SystemCache;
import org.apache.xmlbeans.impl.schema.StscState;
import org.apache.xmlbeans.impl.store.CharUtil;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.values.NamespaceContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ThreadLocalUtil {
    public static void clearAllThreadLocals() {
        XmlBeans.clearThreadLocals();
        XmlFactoryHook.ThreadContext.clearThreadLocals();
        StscState.clearThreadLocals();
        CharUtil.clearThreadLocals();
        Locale.clearThreadLocals();
        NamespaceContext.clearThreadLocals();
        SystemCache.get().clearThreadLocals();
    }
}
