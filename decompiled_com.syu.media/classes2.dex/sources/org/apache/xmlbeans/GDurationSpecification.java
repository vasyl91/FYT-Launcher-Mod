package org.apache.xmlbeans;

import java.math.BigDecimal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface GDurationSpecification {
    int compareToGDuration(GDurationSpecification gDurationSpecification);

    int getDay();

    BigDecimal getFraction();

    int getHour();

    int getMinute();

    int getMonth();

    int getSecond();

    int getSign();

    int getYear();

    boolean isImmutable();

    boolean isValid();
}
