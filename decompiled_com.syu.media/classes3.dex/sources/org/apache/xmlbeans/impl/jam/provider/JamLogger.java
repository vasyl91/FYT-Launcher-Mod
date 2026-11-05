package org.apache.xmlbeans.impl.jam.provider;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface JamLogger {
    void error(String str);

    void error(Throwable th);

    boolean isVerbose();

    boolean isVerbose(Class cls);

    boolean isVerbose(Object obj);

    void setShowWarnings(boolean z);

    void setVerbose(Class cls);

    void verbose(String str);

    void verbose(String str, Object obj);

    void verbose(Throwable th);

    void verbose(Throwable th, Object obj);

    void warning(String str);

    void warning(Throwable th);
}
