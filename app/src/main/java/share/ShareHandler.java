package share;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.android.launcher66.LauncherApplication;

public class ShareHandler {
    public static final Uri URI = Uri.parse("content://com.syu.ms.provider");

    public static int getInt(ContentResolver resolver, int key, int valueIfNotFound) {
        // The FYT unit's own provider: anywhere else the lookup only logs "Failed to find
        // provider info for com.syu.ms.provider".
        if (!LauncherApplication.isFytDevice()) {
            return valueIfNotFound;
        }
        Cursor cursor;
        int result = valueIfNotFound;
        if (resolver != null && (cursor = resolver.query(URI, null, Integer.toString(key), null, null)) != null) {
            try {
                if (cursor.moveToFirst()) {
                    result = cursor.getInt(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            cursor.close();
            return result;
        }
        return result;
    }
}
