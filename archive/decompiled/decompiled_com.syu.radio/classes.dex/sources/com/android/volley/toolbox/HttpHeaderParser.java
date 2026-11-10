package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class HttpHeaderParser {
    public static Cache.Entry parseCacheHeaders(NetworkResponse response) {
        long now = System.currentTimeMillis();
        Map<String, String> headers = response.headers;
        long serverDate = 0;
        long lastModified = 0;
        long serverExpires = 0;
        long softExpire = 0;
        long finalExpire = 0;
        long maxAge = 0;
        long staleWhileRevalidate = 0;
        boolean hasCacheControl = false;
        String headerValue = headers.get(HTTP.DATE_HEADER);
        if (headerValue != null) {
            serverDate = parseDateAsEpoch(headerValue);
        }
        String headerValue2 = headers.get("Cache-Control");
        if (headerValue2 != null) {
            hasCacheControl = true;
            String[] tokens = headerValue2.split(",");
            for (String str : tokens) {
                String token = str.trim();
                if (token.equals("no-cache") || token.equals("no-store")) {
                    return null;
                }
                if (token.startsWith("max-age=")) {
                    try {
                        maxAge = Long.parseLong(token.substring(8));
                    } catch (Exception e) {
                    }
                } else if (token.startsWith("stale-while-revalidate=")) {
                    try {
                        staleWhileRevalidate = Long.parseLong(token.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (token.equals("must-revalidate") || token.equals("proxy-revalidate")) {
                    maxAge = 0;
                }
            }
        }
        String headerValue3 = headers.get("Expires");
        if (headerValue3 != null) {
            serverExpires = parseDateAsEpoch(headerValue3);
        }
        String headerValue4 = headers.get("Last-Modified");
        if (headerValue4 != null) {
            lastModified = parseDateAsEpoch(headerValue4);
        }
        String serverEtag = headers.get("ETag");
        String serverEtag2 = serverEtag;
        if (hasCacheControl) {
            softExpire = now + (1000 * maxAge);
            finalExpire = softExpire + (1000 * staleWhileRevalidate);
        } else if (serverDate > 0 && serverExpires >= serverDate) {
            softExpire = now + (serverExpires - serverDate);
            finalExpire = softExpire;
        }
        Cache.Entry entry = new Cache.Entry();
        entry.data = response.data;
        entry.etag = serverEtag2;
        entry.softTtl = softExpire;
        entry.ttl = finalExpire;
        entry.serverDate = serverDate;
        entry.lastModified = lastModified;
        entry.responseHeaders = headers;
        return entry;
    }

    public static long parseDateAsEpoch(String dateStr) {
        try {
            return DateUtils.parseDate(dateStr).getTime();
        } catch (DateParseException e) {
            return 0L;
        }
    }

    public static String parseCharset(Map<String, String> headers, String defaultCharset) {
        String contentType = headers.get(HTTP.CONTENT_TYPE);
        if (contentType != null) {
            String[] params = contentType.split(";");
            for (int i = 1; i < params.length; i++) {
                String[] pair = params[i].trim().split("=");
                if (pair.length == 2 && pair[0].equals("charset")) {
                    return pair[1];
                }
            }
            return defaultCharset;
        }
        return defaultCharset;
    }

    public static String parseCharset(Map<String, String> headers) {
        return parseCharset(headers, "ISO-8859-1");
    }
}
