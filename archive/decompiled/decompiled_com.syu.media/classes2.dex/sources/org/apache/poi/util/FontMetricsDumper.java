package org.apache.poi.util;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FontMetricsDumper {
    public static void main(String[] strArr) throws IOException {
        Properties properties = new Properties();
        for (Font font : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
            String fontName = font.getFontName();
            FontMetrics fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(new Font(fontName, 1, 10));
            properties.setProperty("font." + fontName + ".height", fontMetrics.getHeight() + "");
            StringBuilder sb = new StringBuilder();
            for (char c = 'a'; c <= 'z'; c = (char) (c + 1)) {
                sb.append(c).append(", ");
            }
            for (char c2 = 'A'; c2 <= 'Z'; c2 = (char) (c2 + 1)) {
                sb.append(c2).append(", ");
            }
            for (char c3 = '0'; c3 <= '9'; c3 = (char) (c3 + 1)) {
                sb.append(c3).append(", ");
            }
            StringBuilder sb2 = new StringBuilder();
            for (char c4 = 'a'; c4 <= 'z'; c4 = (char) (c4 + 1)) {
                sb2.append(fontMetrics.getWidths()[c4]).append(", ");
            }
            for (char c5 = 'A'; c5 <= 'Z'; c5 = (char) (c5 + 1)) {
                sb2.append(fontMetrics.getWidths()[c5]).append(", ");
            }
            for (char c6 = '0'; c6 <= '9'; c6 = (char) (c6 + 1)) {
                sb2.append(fontMetrics.getWidths()[c6]).append(", ");
            }
            properties.setProperty("font." + fontName + ".characters", sb.toString());
            properties.setProperty("font." + fontName + ".widths", sb2.toString());
        }
        FileOutputStream fileOutputStream = new FileOutputStream("font_metrics.properties");
        try {
            properties.store(fileOutputStream, "Font Metrics");
        } finally {
            fileOutputStream.close();
        }
    }
}
