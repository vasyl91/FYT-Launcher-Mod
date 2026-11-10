package com.alibaba.fastjson.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ServiceLoader {
    private static final String PREFIX = "META-INF/services/";
    private static final Set<String> loadedUrls = new HashSet();

    public static <T> Set<T> load(Class<T> clazz, ClassLoader classLoader) throws Throwable {
        if (classLoader == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        String className = clazz.getName();
        String path = PREFIX + className;
        Set<String> serviceNames = new HashSet<>();
        try {
            Enumeration<URL> urls = classLoader.getResources(path);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (!loadedUrls.contains(url.toString())) {
                    load(url, serviceNames);
                    loadedUrls.add(url.toString());
                }
            }
        } catch (IOException e) {
        }
        for (String serviceName : serviceNames) {
            try {
                Class<?> serviceClass = classLoader.loadClass(serviceName);
                hashSet.add(serviceClass.newInstance());
            } catch (Exception e2) {
            }
        }
        return hashSet;
    }

    public static void load(URL url, Set<String> set) throws Throwable {
        InputStream is = null;
        BufferedReader reader = null;
        try {
            is = url.openStream();
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(is, "utf-8"));
            while (true) {
                try {
                    String line = reader2.readLine();
                    if (line != null) {
                        int ci = line.indexOf(35);
                        if (ci >= 0) {
                            line = line.substring(0, ci);
                        }
                        String line2 = line.trim();
                        if (line2.length() != 0) {
                            set.add(line2);
                        }
                    } else {
                        IOUtils.close(reader2);
                        IOUtils.close(is);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    reader = reader2;
                    IOUtils.close(reader);
                    IOUtils.close(is);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
