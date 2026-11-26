package com.android.launcher66;

import static org.junit.Assert.assertEquals;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * A package broadcast must never build the launcher's state: the receiver only drops the cached widget
 * previews of the package, from a worker thread, with the preview database opened by its file name.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class PackageChangedReceiverTest {

    private static void insert(SQLiteDatabase db, String name) {
        ContentValues values = new ContentValues();
        values.put(WidgetPreviewLoader.CacheDb.COLUMN_NAME, name);
        values.put(WidgetPreviewLoader.CacheDb.COLUMN_SIZE, "10x10");
        values.put(WidgetPreviewLoader.CacheDb.COLUMN_PREVIEW_BITMAP, new byte[] {1, 2, 3});
        db.insert(WidgetPreviewLoader.CacheDb.TABLE_NAME, null, values);
    }

    private static int rows(SQLiteDatabase db) {
        android.database.Cursor c = db.rawQuery("SELECT COUNT(*) FROM "
                + WidgetPreviewLoader.CacheDb.TABLE_NAME, null);
        try {
            c.moveToFirst();
            return c.getInt(0);
        } finally {
            c.close();
        }
    }

    @Test
    public void theRowsOfThePackageGoAndTheOthersStay() {
        Context context = RuntimeEnvironment.getApplication();
        WidgetPreviewLoader.CacheDb helper = new WidgetPreviewLoader.CacheDb(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        insert(db, "Widget:com.example.a/com.example.a.Provider");
        insert(db, "Shortcut:com.example.a/com.example.a.Main");
        insert(db, "Widget:com.example.b/com.example.b.Provider");
        helper.close();

        PackageChangedReceiver.removeFromPreviewDb(context, "com.example.a");

        WidgetPreviewLoader.CacheDb again = new WidgetPreviewLoader.CacheDb(context);
        assertEquals(1, rows(again.getReadableDatabase()));
        again.close();
    }

    @Test
    public void aBroadcastWithoutALauncherDoesNotThrow() throws Exception {
        Context context = RuntimeEnvironment.getApplication();
        Intent intent = new Intent(Intent.ACTION_PACKAGE_REMOVED, Uri.parse("package:com.example.a"));
        // No LauncherAppState is created by the receiver: the call returns and its worker finishes by itself.
        new PackageChangedReceiver().onReceive(context, intent);
        // and no package, no data: nothing to do
        new PackageChangedReceiver().onReceive(context, new Intent(Intent.ACTION_PACKAGE_REMOVED));
    }
}
