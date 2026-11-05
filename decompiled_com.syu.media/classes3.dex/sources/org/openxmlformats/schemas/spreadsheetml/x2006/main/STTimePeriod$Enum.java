package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STTimePeriod$Enum extends StringEnumAbstractBase {
    static final int INT_LAST_7_DAYS = 4;
    static final int INT_LAST_MONTH = 6;
    static final int INT_LAST_WEEK = 9;
    static final int INT_NEXT_MONTH = 7;
    static final int INT_NEXT_WEEK = 10;
    static final int INT_THIS_MONTH = 5;
    static final int INT_THIS_WEEK = 8;
    static final int INT_TODAY = 1;
    static final int INT_TOMORROW = 3;
    static final int INT_YESTERDAY = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTimePeriod$Enum[]{new STTimePeriod$Enum("today", 1), new STTimePeriod$Enum("yesterday", 2), new STTimePeriod$Enum("tomorrow", 3), new STTimePeriod$Enum("last7Days", 4), new STTimePeriod$Enum("thisMonth", 5), new STTimePeriod$Enum("lastMonth", 6), new STTimePeriod$Enum("nextMonth", 7), new STTimePeriod$Enum("thisWeek", 8), new STTimePeriod$Enum("lastWeek", 9), new STTimePeriod$Enum("nextWeek", 10)});

    private STTimePeriod$Enum(String str, int i) {
        super(str, i);
    }

    public static STTimePeriod$Enum forInt(int i) {
        return (STTimePeriod$Enum) table.forInt(i);
    }

    public static STTimePeriod$Enum forString(String str) {
        return (STTimePeriod$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
