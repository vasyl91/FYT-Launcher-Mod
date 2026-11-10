package org.apache.poi.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Configurator {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) Configurator.class);

    public static int getIntValue(String str, int i) {
        String property = System.getProperty(str);
        try {
            return Integer.parseInt(property);
        } catch (Exception unused) {
            logger.log(7, "System property -D" + str + " do not contains a valid integer " + property);
            return i;
        }
    }
}
