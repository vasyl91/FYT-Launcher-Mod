package org.apache.commons.logging.impl;

import java.io.Serializable;
import org.apache.commons.logging.Log;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class NoOpLog implements Log, Serializable {
    public NoOpLog() {
        throw new RuntimeException("Stub!");
    }

    public NoOpLog(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isDebugEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isErrorEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isFatalEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isInfoEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isTraceEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isWarnEnabled() {
        throw new RuntimeException("Stub!");
    }
}
