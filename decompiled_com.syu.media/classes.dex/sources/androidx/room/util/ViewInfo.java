package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ViewInfo {
    public final String name;
    public final String sql;

    public ViewInfo(String name, String sql) {
        this.name = name;
        this.sql = sql;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) o;
        String str = this.name;
        if (str == null ? viewInfo.name == null : str.equals(viewInfo.name)) {
            String str2 = this.sql;
            if (str2 != null) {
                if (str2.equals(viewInfo.sql)) {
                    return true;
                }
            } else if (viewInfo.sql == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sql;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }

    public static ViewInfo read(SupportSQLiteDatabase database, String viewName) {
        Cursor cursorQuery = database.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + viewName + "'");
        try {
            if (cursorQuery.moveToFirst()) {
                return new ViewInfo(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return new ViewInfo(viewName, null);
        } finally {
            cursorQuery.close();
        }
    }
}
