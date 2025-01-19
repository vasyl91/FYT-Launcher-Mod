package share;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

public class ShareHandler {
    public static final Uri URI = Uri.parse("content://com.syu.ms.provider");

    public static int getInt(ContentResolver resolver, int key, int valueIfNotFound) {
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
