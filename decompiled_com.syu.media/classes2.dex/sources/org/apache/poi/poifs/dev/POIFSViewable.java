package org.apache.poi.poifs.dev;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface POIFSViewable {
    String getShortDescription();

    Object[] getViewableArray();

    Iterator<Object> getViewableIterator();

    boolean preferArray();
}
