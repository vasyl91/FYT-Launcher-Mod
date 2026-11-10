package com.syu.utils;

import android.database.AbstractCursor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015J \u0010\u001c\u001a\u00020\u00182\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u00150\u001aJ\u0006\u0010\u001d\u001a\u00020\u0018R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007RV\u0010*\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u00150\"j\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015`#8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/syu/utils/MessageCursor;", "Landroid/database/AbstractCursor;", "", "getCount", "", "", "getColumnNames", "()[Ljava/lang/String;", "column", "getString", "", "getShort", "getInt", "", "getLong", "", "getFloat", "", "getDouble", "", "isNull", "", "", "data", "", "push", "", XmlErrorCodes.LIST, "addAll", "clear", "a", "[Ljava/lang/String;", "getMColumnNames", "mColumnNames", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getMUpdatedRows", "()Ljava/util/HashMap;", "setMUpdatedRows", "(Ljava/util/HashMap;)V", "mUpdatedRows", "<init>", "([Ljava/lang/String;)V", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class MessageCursor extends AbstractCursor {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String[] mColumnNames;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public HashMap mUpdatedRows;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageCursor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void addAll(List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            push((Map) it.next());
        }
    }

    public final void clear() {
        this.mUpdatedRows.clear();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return (String[]) this.mColumnNames.clone();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.mUpdatedRows.size();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int column) {
        if (column >= 0 && column < this.mColumnNames.length) {
            String str = this.mColumnNames[column];
            Map map = (Map) this.mUpdatedRows.get(Integer.valueOf(getPosition()));
            Object obj = map != null ? map.get(str) : null;
            Double d = obj instanceof Double ? (Double) obj : null;
            if (d != null) {
                return d.doubleValue();
            }
        }
        return Double.MIN_VALUE;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int column) {
        if (column >= 0 && column < this.mColumnNames.length) {
            String str = this.mColumnNames[column];
            Map map = (Map) this.mUpdatedRows.get(Integer.valueOf(getPosition()));
            Object obj = map != null ? map.get(str) : null;
            Float f = obj instanceof Float ? (Float) obj : null;
            if (f != null) {
                return f.floatValue();
            }
        }
        return Float.MIN_VALUE;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int column) {
        if (column >= 0 && column < this.mColumnNames.length) {
            String str = this.mColumnNames[column];
            Map map = (Map) this.mUpdatedRows.get(Integer.valueOf(getPosition()));
            Object obj = map != null ? map.get(str) : null;
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            if (num != null) {
                return num.intValue();
            }
        }
        return Integer.MIN_VALUE;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int column) {
        if (column >= 0 && column < this.mColumnNames.length) {
            String str = this.mColumnNames[column];
            Map map = (Map) this.mUpdatedRows.get(Integer.valueOf(getPosition()));
            Object obj = map != null ? map.get(str) : null;
            Long l = obj instanceof Long ? (Long) obj : null;
            if (l != null) {
                return l.longValue();
            }
        }
        return Long.MIN_VALUE;
    }

    public final String[] getMColumnNames() {
        return this.mColumnNames;
    }

    public final HashMap<Integer, Map<String, Object>> getMUpdatedRows() {
        return this.mUpdatedRows;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int column) {
        if (column >= 0 && column < this.mColumnNames.length) {
            String str = this.mColumnNames[column];
            Map map = (Map) this.mUpdatedRows.get(Integer.valueOf(getPosition()));
            Object obj = map != null ? map.get(str) : null;
            Short sh = obj instanceof Short ? (Short) obj : null;
            if (sh != null) {
                return sh.shortValue();
            }
        }
        return ShortCompanionObject.MIN_VALUE;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int column) {
        if (column >= 0 && column < this.mColumnNames.length) {
            String str = this.mColumnNames[column];
            Map map = (Map) this.mUpdatedRows.get(Integer.valueOf(getPosition()));
            if (map != null) {
                return String.valueOf(map.get(str));
            }
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0011  */
    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int column) {
        boolean z;
        String[] strArr = this.mColumnNames;
        if (strArr == null) {
            z = true;
        } else {
            if (strArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            return !(column >= 0 && column < strArr.length);
        }
        return false;
    }

    public final void push(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        HashMap map = this.mUpdatedRows;
        map.put(Integer.valueOf(map.size()), data);
    }

    public final void setMUpdatedRows(HashMap<Integer, Map<String, Object>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.mUpdatedRows = map;
    }

    public MessageCursor(String[] mColumnNames) {
        Intrinsics.checkNotNullParameter(mColumnNames, "mColumnNames");
        this.mColumnNames = mColumnNames;
        this.mUpdatedRows = new HashMap();
    }

    public /* synthetic */ MessageCursor(String[] strArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new String[0] : strArr);
    }
}
