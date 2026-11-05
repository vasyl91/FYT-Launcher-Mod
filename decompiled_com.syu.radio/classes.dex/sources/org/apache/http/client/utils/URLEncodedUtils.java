package org.apache.http.client.utils;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    public URLEncodedUtils() {
        throw new RuntimeException("Stub!");
    }

    public static List<NameValuePair> parse(URI uri, String encoding) {
        throw new RuntimeException("Stub!");
    }

    public static List<NameValuePair> parse(HttpEntity entity) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public static boolean isEncoded(HttpEntity entity) {
        throw new RuntimeException("Stub!");
    }

    public static void parse(List<NameValuePair> parameters, Scanner scanner, String encoding) {
        throw new RuntimeException("Stub!");
    }

    public static String format(List<? extends NameValuePair> parameters, String encoding) {
        throw new RuntimeException("Stub!");
    }
}
