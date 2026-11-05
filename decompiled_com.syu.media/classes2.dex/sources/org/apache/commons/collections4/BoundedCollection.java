package org.apache.commons.collections4;

import java.util.Collection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface BoundedCollection<E> extends Collection<E> {
    boolean isFull();

    int maxSize();
}
