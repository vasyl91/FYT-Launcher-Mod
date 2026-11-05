package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.collections4.iterators.EnumerationIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EnumerationUtils {
    private EnumerationUtils() {
    }

    public static <T> T get(Enumeration<T> enumeration, int i) {
        CollectionUtils.checkIndexBounds(i);
        while (enumeration.hasMoreElements()) {
            i--;
            if (i == -1) {
                return enumeration.nextElement();
            }
            enumeration.nextElement();
        }
        throw new IndexOutOfBoundsException("Entry does not exist: " + i);
    }

    public static <E> List<E> toList(Enumeration<? extends E> enumeration) {
        return IteratorUtils.toList(new EnumerationIterator(enumeration));
    }

    public static List<String> toList(StringTokenizer stringTokenizer) {
        ArrayList arrayList = new ArrayList(stringTokenizer.countTokens());
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }
}
