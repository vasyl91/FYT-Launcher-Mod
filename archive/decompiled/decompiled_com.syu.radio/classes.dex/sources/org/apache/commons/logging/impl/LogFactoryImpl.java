package org.apache.commons.logging.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class LogFactoryImpl extends LogFactory {
    public static final String ALLOW_FLAWED_CONTEXT_PROPERTY = "org.apache.commons.logging.Log.allowFlawedContext";
    public static final String ALLOW_FLAWED_DISCOVERY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedDiscovery";
    public static final String ALLOW_FLAWED_HIERARCHY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedHierarchy";
    public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
    protected static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
    protected Hashtable attributes;
    protected Hashtable instances;
    protected Constructor logConstructor;
    protected Method logMethod;
    protected Class[] logConstructorSignature = null;
    protected Class[] logMethodSignature = null;

    public LogFactoryImpl() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public Object getAttribute(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public String[] getAttributeNames() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(Class clazz) throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(String name) throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public void release() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public void removeAttribute(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public void setAttribute(String name, Object value) {
        throw new RuntimeException("Stub!");
    }

    protected static ClassLoader getContextClassLoader() throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    protected static boolean isDiagnosticsEnabled() {
        throw new RuntimeException("Stub!");
    }

    protected static ClassLoader getClassLoader(Class clazz) {
        throw new RuntimeException("Stub!");
    }

    protected void logDiagnostic(String msg) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected String getLogClassName() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected Constructor getLogConstructor() throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected boolean isJdk13LumberjackAvailable() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected boolean isJdk14Available() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected boolean isLog4JAvailable() {
        throw new RuntimeException("Stub!");
    }

    protected Log newInstance(String name) throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }
}
