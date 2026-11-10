package okhttp3.internal.http;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HttpMethod {
    public static boolean invalidatesCache(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean permitsRequestBody(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static boolean redirectsWithBody(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean redirectsToGet(String str) {
        return !str.equals("PROPFIND");
    }

    private HttpMethod() {
    }
}
