package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface SocketFactory {
    Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) throws IOException;

    Socket createSocket() throws IOException;

    boolean isSecure(Socket socket) throws IllegalArgumentException;
}
