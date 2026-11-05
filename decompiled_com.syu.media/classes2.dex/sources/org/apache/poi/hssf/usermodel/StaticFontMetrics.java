package org.apache.poi.hssf.usermodel;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class StaticFontMetrics {
    private static final POILogger LOGGER = POILogFactory.getLogger((Class<?>) StaticFontMetrics.class);
    private static final Map<String, FontDetails> fontDetailsMap = new HashMap();
    private static Properties fontMetricsProps;

    private StaticFontMetrics() {
    }

    public static synchronized FontDetails getFontDetails(Font font) {
        FontDetails fontDetailsCreate;
        if (fontMetricsProps == null) {
            try {
                fontMetricsProps = loadMetrics();
            } catch (IOException e) {
                throw new RuntimeException("Could not load font metrics", e);
            }
        }
        String name = font.getName();
        String str = font.isPlain() ? "plain" : "";
        if (font.isBold()) {
            str = str + "bold";
        }
        if (font.isItalic()) {
            str = str + "italic";
        }
        String strBuildFontHeightProperty = FontDetails.buildFontHeightProperty(name);
        String strBuildFontHeightProperty2 = FontDetails.buildFontHeightProperty(name + "." + str);
        if (fontMetricsProps.get(strBuildFontHeightProperty) == null && fontMetricsProps.get(strBuildFontHeightProperty2) != null) {
            name = name + "." + str;
        }
        Map<String, FontDetails> map = fontDetailsMap;
        fontDetailsCreate = map.get(name);
        if (fontDetailsCreate == null) {
            fontDetailsCreate = FontDetails.create(name, fontMetricsProps);
            map.put(name, fontDetailsCreate);
        }
        return fontDetailsCreate;
    }

    private static Properties loadMetrics() throws IOException {
        File file;
        InputStream resourceAsStream;
        InputStream inputStream = null;
        try {
            String property = System.getProperty("font.metrics.filename");
            if (property != null) {
                file = new File(property);
                try {
                    if (!file.exists()) {
                        LOGGER.log(5, "font_metrics.properties not found at path " + file.getAbsolutePath());
                        file = null;
                    }
                } catch (SecurityException e) {
                    e = e;
                    LOGGER.log(5, "Can't access font.metrics.filename system property", e);
                }
            } else {
                file = null;
            }
        } catch (SecurityException e2) {
            e = e2;
            file = null;
        }
        try {
            if (file != null) {
                resourceAsStream = new FileInputStream(file);
            } else {
                resourceAsStream = FontDetails.class.getResourceAsStream("/font_metrics.properties");
                if (resourceAsStream == null) {
                    throw new IOException("font_metrics.properties not found in classpath");
                }
            }
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return properties;
        } catch (Throwable th) {
            if (0 != 0) {
                inputStream.close();
            }
            throw th;
        }
    }
}
