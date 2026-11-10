package org.apache.http.client;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface ResponseHandler<T> {
    T handleResponse(HttpResponse httpResponse) throws IOException;
}
