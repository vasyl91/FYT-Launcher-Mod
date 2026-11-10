package org.apache.poi;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Version {
    private static final String RELEASE_DATE = "20170915";
    private static final String VERSION_STRING = "3.17";

    public static String getImplementationLanguage() {
        return "Java";
    }

    public static String getProduct() {
        return "POI";
    }

    public static String getReleaseDate() {
        return RELEASE_DATE;
    }

    public static String getVersion() {
        return VERSION_STRING;
    }

    public static void main(String[] strArr) {
        System.out.println("Apache " + getProduct() + " " + getVersion() + " (" + getReleaseDate() + ")");
    }
}
