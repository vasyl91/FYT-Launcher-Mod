package okhttp3;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new CookieJar() { // from class: okhttp3.CookieJar.1
        @Override // okhttp3.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        }

        @Override // okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            return Collections.emptyList();
        }
    };

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
