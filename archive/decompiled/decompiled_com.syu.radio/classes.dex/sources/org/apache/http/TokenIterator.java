package org.apache.http;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface TokenIterator extends Iterator {
    @Override // java.util.Iterator
    boolean hasNext();

    String nextToken();
}
