package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;
import chip.FinalChip;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CursorUtil {
    private static int findColumnIndexBySuffix(Cursor cursor, String name) {
        return -1;
    }

    public static Cursor copyAndClose(Cursor c) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(c.getColumnNames(), c.getCount());
            while (c.moveToNext()) {
                Object[] objArr = new Object[c.getColumnCount()];
                for (int i = 0; i < c.getColumnCount(); i++) {
                    int type = c.getType(i);
                    if (type == 0) {
                        objArr[i] = null;
                    } else if (type == 1) {
                        objArr[i] = Long.valueOf(c.getLong(i));
                    } else if (type == 2) {
                        objArr[i] = Double.valueOf(c.getDouble(i));
                    } else if (type == 3) {
                        objArr[i] = c.getString(i);
                    } else if (type == 4) {
                        objArr[i] = c.getBlob(i);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            c.close();
            return matrixCursor;
        } catch (Throwable th) {
            c.close();
            throw th;
        }
    }

    public static int getColumnIndex(Cursor c, String name) {
        int columnIndex = c.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c.getColumnIndex("`" + name + "`");
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(c, name);
    }

    public static int getColumnIndexOrThrow(Cursor c, String name) {
        String string;
        int columnIndex = getColumnIndex(c, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            string = Arrays.toString(c.getColumnNames());
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            string = FinalChip.BSP_PLATFORM_Null;
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + string);
    }

    static int findColumnIndexBySuffix(String[] columnNames, String name) {
        String str = "." + name;
        String str2 = "." + name + "`";
        for (int i = 0; i < columnNames.length; i++) {
            String str3 = columnNames[i];
            if (str3.length() >= name.length() + 2) {
                if (str3.endsWith(str)) {
                    return i;
                }
                if (str3.charAt(0) == '`' && str3.endsWith(str2)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private CursorUtil() {
    }
}
