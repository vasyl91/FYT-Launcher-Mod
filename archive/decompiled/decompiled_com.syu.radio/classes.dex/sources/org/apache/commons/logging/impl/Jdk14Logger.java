package org.apache.commons.logging.impl;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class Jdk14Logger implements Log, Serializable {
    protected static final Level dummyLevel = null;
    protected transient Logger logger;
    protected String name;

    public Jdk14Logger(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object message, Throwable exception) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object message, Throwable exception) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object message, Throwable exception) {
        throw new RuntimeException("Stub!");
    }

    public Logger getLogger() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object message, Throwable exception) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public boolean isDebugEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public boolean isErrorEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public boolean isFatalEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public boolean isInfoEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public boolean isTraceEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public boolean isWarnEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object message, Throwable exception) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object message, Throwable exception) {
        throw new RuntimeException("Stub!");
    }
}
