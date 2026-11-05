package org.apache.xmlbeans.impl.soap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.apache.xmlbeans.SystemProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
class FactoryFinder {
    FactoryFinder() {
    }

    private static Object newInstance(String str) throws SOAPException {
        Class<?> clsLoadClass;
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            try {
                if (contextClassLoader == null) {
                    try {
                        clsLoadClass = Class.forName(str);
                    } catch (ClassNotFoundException e) {
                        throw new SOAPException("Provider " + str + " not found", e);
                    }
                } else {
                    try {
                        clsLoadClass = contextClassLoader.loadClass(str);
                    } catch (ClassNotFoundException unused) {
                        clsLoadClass = null;
                    }
                }
                if (clsLoadClass == null) {
                    clsLoadClass = FactoryFinder.class.getClassLoader().loadClass(str);
                }
                return clsLoadClass.newInstance();
            } catch (Exception e2) {
                throw new SOAPException("Provider " + str + " could not be instantiated: " + e2, e2);
            }
        } catch (Exception e3) {
            throw new SOAPException(e3.toString(), e3);
        }
    }

    static Object find(String str, String str2) throws SOAPException {
        try {
            String property = SystemProperties.getProperty(str);
            if (property != null) {
                return newInstance(property);
            }
        } catch (SecurityException unused) {
        }
        try {
            File file = new File(SystemProperties.getProperty("java.home") + File.separator + "lib" + File.separator + "jaxm.properties");
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                fileInputStream.close();
                return newInstance(properties.getProperty(str));
            }
        } catch (Exception unused2) {
        }
        try {
            InputStream resource = getResource("META-INF/services/" + str);
            if (resource != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource, "UTF-8"));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                if (line != null && !"".equals(line)) {
                    return newInstance(line);
                }
            }
        } catch (Exception unused3) {
        }
        if (str2 == null) {
            throw new SOAPException("Provider for " + str + " cannot be found", null);
        }
        return newInstance(str2);
    }

    private static InputStream getResource(String str) {
        ClassLoader contextClassLoader;
        InputStream resourceAsStream;
        try {
            contextClassLoader = Thread.currentThread().getContextClassLoader();
        } catch (SecurityException unused) {
            contextClassLoader = null;
        }
        if (contextClassLoader == null) {
            resourceAsStream = ClassLoader.getSystemResourceAsStream(str);
        } else {
            resourceAsStream = contextClassLoader.getResourceAsStream(str);
        }
        if (resourceAsStream == null) {
            resourceAsStream = FactoryFinder.class.getResourceAsStream(str);
        }
        return (resourceAsStream != null || FactoryFinder.class.getClassLoader() == null) ? resourceAsStream : FactoryFinder.class.getClassLoader().getResourceAsStream(str);
    }
}
