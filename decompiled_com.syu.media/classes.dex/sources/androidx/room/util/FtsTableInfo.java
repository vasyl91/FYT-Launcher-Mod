package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import chip.FinalChip;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class FtsTableInfo {
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    public FtsTableInfo(String name, Set<String> columns, Set<String> options) {
        this.name = name;
        this.columns = columns;
        this.options = options;
    }

    public FtsTableInfo(String name, Set<String> columns, String createSql) {
        this.name = name;
        this.columns = columns;
        this.options = parseOptions(createSql);
    }

    public static FtsTableInfo read(SupportSQLiteDatabase database, String tableName) {
        return new FtsTableInfo(tableName, readColumns(database, tableName), readOptions(database, tableName));
    }

    private static Set<String> readColumns(SupportSQLiteDatabase database, String tableName) {
        Cursor cursorQuery = database.query("PRAGMA table_info(`" + tableName + "`)");
        HashSet hashSet = new HashSet();
        try {
            if (cursorQuery.getColumnCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("name");
                while (cursorQuery.moveToNext()) {
                    hashSet.add(cursorQuery.getString(columnIndex));
                }
            }
            return hashSet;
        } finally {
            cursorQuery.close();
        }
    }

    private static Set<String> readOptions(SupportSQLiteDatabase database, String tableName) {
        Cursor cursorQuery = database.query("SELECT * FROM sqlite_master WHERE `name` = '" + tableName + "'");
        try {
            return parseOptions(cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("sql")) : FinalChip.BSP_PLATFORM_Null);
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0087  */
    /* JADX WARN: Code duplicated, block: B:35:0x008d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0095  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4 A[SYNTHETIC] */
    static Set<String> parseOptions(String createStatement) {
        if (createStatement.isEmpty()) {
            return new HashSet();
        }
        String strSubstring = createStatement.substring(createStatement.indexOf(40) + 1, createStatement.lastIndexOf(41));
        ArrayList<String> arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        int i = -1;
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt == '\"' || cCharAt == '\'') {
                if (arrayDeque.isEmpty()) {
                    arrayDeque.push(Character.valueOf(cCharAt));
                } else if (((Character) arrayDeque.peek()).charValue() == cCharAt) {
                    arrayDeque.pop();
                }
            } else if (cCharAt != ',') {
                if (cCharAt != '[') {
                    if (cCharAt != ']') {
                        if (cCharAt == '`') {
                            if (arrayDeque.isEmpty()) {
                                arrayDeque.push(Character.valueOf(cCharAt));
                            } else if (((Character) arrayDeque.peek()).charValue() == cCharAt) {
                                arrayDeque.pop();
                            }
                        }
                    } else if (!arrayDeque.isEmpty() && ((Character) arrayDeque.peek()).charValue() == '[') {
                        arrayDeque.pop();
                    }
                } else if (arrayDeque.isEmpty()) {
                    arrayDeque.push(Character.valueOf(cCharAt));
                }
            } else if (arrayDeque.isEmpty()) {
                arrayList.add(strSubstring.substring(i + 1, i2).trim());
                i = i2;
            }
        }
        arrayList.add(strSubstring.substring(i + 1).trim());
        HashSet hashSet = new HashSet();
        for (String str : arrayList) {
            for (String str2 : FTS_OPTIONS) {
                if (str.startsWith(str2)) {
                    hashSet.add(str);
                }
            }
        }
        return hashSet;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo = (FtsTableInfo) o;
        String str = this.name;
        if (str == null ? ftsTableInfo.name != null : !str.equals(ftsTableInfo.name)) {
            return false;
        }
        Set<String> set = this.columns;
        if (set == null ? ftsTableInfo.columns != null : !set.equals(ftsTableInfo.columns)) {
            return false;
        }
        Set<String> set2 = this.options;
        Set<String> set3 = ftsTableInfo.options;
        if (set2 != null) {
            return set2.equals(set3);
        }
        return set3 == null;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Set<String> set = this.columns;
        int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
        Set<String> set2 = this.options;
        return iHashCode2 + (set2 != null ? set2.hashCode() : 0);
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + '}';
    }
}
