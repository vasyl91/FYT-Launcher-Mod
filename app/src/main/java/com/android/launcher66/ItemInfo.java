package com.android.launcher66;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import com.android.launcher66.LauncherSettings;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class ItemInfo {
    static final int NO_ID = -1;
    int cellX;
    int cellY;
    long container;
    int[] dropPos;
    long id;
    int itemType;
    int minSpanX;
    int minSpanY;
    boolean requiresDbUpdate;
    long screenId;
    int spanX;
    int spanY;
    public CharSequence title;

    ItemInfo() {
        this.id = -1L;
        this.container = -1L;
        this.screenId = -1L;
        this.cellX = -1;
        this.cellY = -1;
        this.spanX = 1;
        this.spanY = 1;
        this.minSpanX = 1;
        this.minSpanY = 1;
        this.requiresDbUpdate = false;
        this.dropPos = null;
    }

    ItemInfo(ItemInfo info) {
        this.id = -1L;
        this.container = -1L;
        this.screenId = -1L;
        this.cellX = -1;
        this.cellY = -1;
        this.spanX = 1;
        this.spanY = 1;
        this.minSpanX = 1;
        this.minSpanY = 1;
        this.requiresDbUpdate = false;
        this.dropPos = null;
        this.id = info.id;
        this.cellX = info.cellX;
        this.cellY = info.cellY;
        this.spanX = info.spanX;
        this.spanY = info.spanY;
        this.screenId = info.screenId;
        this.itemType = info.itemType;
        this.container = info.container;
        LauncherModel.checkItemInfo(this);
    }

    protected Intent getIntent() {
        throw new RuntimeException("Unexpected Intent");
    }

    void onAddToDatabase(ContentValues values) {
        values.put(LauncherSettings.BaseLauncherColumns.ITEM_TYPE, Integer.valueOf(this.itemType));
        values.put(Stats.EXTRA_CONTAINER, Long.valueOf(this.container));
        values.put(Stats.EXTRA_SCREEN, Long.valueOf(this.screenId));
        values.put(Stats.EXTRA_CELLX, Integer.valueOf(this.cellX));
        values.put(Stats.EXTRA_CELLY, Integer.valueOf(this.cellY));
        values.put("spanX", Integer.valueOf(this.spanX));
        values.put("spanY", Integer.valueOf(this.spanY));
    }

    void updateValuesWithCoordinates(ContentValues values, int cellX, int cellY) {
        values.put(Stats.EXTRA_CELLX, Integer.valueOf(cellX));
        values.put(Stats.EXTRA_CELLY, Integer.valueOf(cellY));
    }

    static byte[] flattenBitmap(Bitmap bitmap) {
        int size = bitmap.getWidth() * bitmap.getHeight() * 4;
        ByteArrayOutputStream out = new ByteArrayOutputStream(size);
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
            Log.w("Favorite", "Could not write icon");
            return null;
        }
    }

    static void writeBitmap(ContentValues values, Bitmap bitmap) {
        if (bitmap != null) {
            byte[] data = flattenBitmap(bitmap);
            values.put("icon", data);
        }
    }

    void unbind() {
    }

    public String toString() {
        return "Item(id=" + this.id + " type=" + this.itemType + " container=" + this.container + " screen=" + this.screenId + " cellX=" + this.cellX + " cellY=" + this.cellY + " spanX=" + this.spanX + " spanY=" + this.spanY + " dropPos=" + this.dropPos + ")";
    }
}
