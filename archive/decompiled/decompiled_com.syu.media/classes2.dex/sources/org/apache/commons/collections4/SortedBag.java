package org.apache.commons.collections4;

import java.util.Comparator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SortedBag<E> extends Bag<E> {
    Comparator<? super E> comparator();

    E first();

    E last();
}
