package okhttp3;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Request {

    @Nullable
    final RequestBody body;

    @Nullable
    private volatile CacheControl cacheControl;
    final Headers headers;
    final String method;
    final Map<Class<?>, Object> tags;
    final HttpUrl url;

    Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.tags = Util.immutableMap(builder.tags);
    }

    public HttpUrl url() {
        return this.url;
    }

    public String method() {
        return this.method;
    }

    public Headers headers() {
        return this.headers;
    }

    @Nullable
    public String header(String str) {
        return this.headers.get(str);
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    @Nullable
    public RequestBody body() {
        return this.body;
    }

    @Nullable
    public Object tag() {
        return tag(Object.class);
    }

    @Nullable
    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.tags.get(cls));
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.parse(this.headers);
        this.cacheControl = cacheControl2;
        return cacheControl2;
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public String toString() {
        return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
    }

    public static class Builder {

        @Nullable
        RequestBody body;
        Headers.Builder headers;
        String method;
        Map<Class<?>, Object> tags;

        @Nullable
        HttpUrl url;

        public Builder() {
            this.tags = Collections.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        Builder(Request request) {
            Map<Class<?>, Object> linkedHashMap;
            this.tags = Collections.emptyMap();
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            if (request.tags.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(request.tags);
            }
            this.tags = linkedHashMap;
            this.headers = request.headers.newBuilder();
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new NullPointerException("url == null");
            }
            this.url = httpUrl;
            return this;
        }

        public Builder url(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return url(HttpUrl.get(str));
        }

        public Builder url(URL url) {
            if (url == null) {
                throw new NullPointerException("url == null");
            }
            return url(HttpUrl.get(url.toString()));
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String string = cacheControl.toString();
            return string.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder delete(@Nullable RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder delete() {
            return delete(Util.EMPTY_REQUEST);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder method(String str, @Nullable RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (requestBody == null && HttpMethod.requiresRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.method = str;
            this.body = requestBody;
            return this;
        }

        public Builder tag(@Nullable Object obj) {
            return tag(Object.class, obj);
        }

        public <T> Builder tag(Class<? super T> cls, @Nullable T t) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            if (t == null) {
                this.tags.remove(cls);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                this.tags.put(cls, cls.cast(t));
            }
            return this;
        }

        public Request build() {
            if (this.url == null) {
                throw new IllegalStateException("url == null");
            }
            return new Request(this);
        }
    }
}
