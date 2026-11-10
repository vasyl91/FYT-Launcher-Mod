package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface HostNameResolver {
    InetAddress resolve(String str) throws IOException;
}
