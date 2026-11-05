package org.apache.commons.collections4;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface OrderedIterator<E> extends Iterator<E> {
    boolean hasPrevious();

    E previous();
}
