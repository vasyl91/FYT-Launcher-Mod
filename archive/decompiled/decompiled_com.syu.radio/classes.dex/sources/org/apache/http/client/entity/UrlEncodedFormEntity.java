package org.apache.http.client.entity;

import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class UrlEncodedFormEntity extends StringEntity {
    public UrlEncodedFormEntity(List<? extends NameValuePair> parameters, String encoding) throws UnsupportedEncodingException {
        super((String) null);
        throw new RuntimeException("Stub!");
    }

    public UrlEncodedFormEntity(List<? extends NameValuePair> parameters) throws UnsupportedEncodingException {
        super((String) null);
        throw new RuntimeException("Stub!");
    }
}
