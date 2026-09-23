/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.launcher66;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import com.android.photos.BitmapRegionTileSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class SavedWallpaperImages extends BaseAdapter implements ListAdapter {
    private static String TAG = "launcher66.SavedWallpaperImages";
    private ImageDb mDb;
    ArrayList<SavedWallpaperTile> mImages;
    Context mContext;
    LayoutInflater mLayoutInflater;

    public static class SavedWallpaperTile extends WallpaperPickerActivity.WallpaperTileInfo {
        private int mDbId;
        private Drawable mThumb;
        public SavedWallpaperTile(int dbId, Drawable thumb) {
            mDbId = dbId;
            mThumb = thumb;
        }
        @Override
        public void onClick(final WallpaperPickerActivity a) {
            final int dbId = mDbId;
            // The database lookup, EXIF read and decoding run on the loader thread, like for
            // the other tiles; they used to block the UI thread on every tap.
            a.loadTileSourceAsync(
                    () -> {
                        String imageFilename = a.getSavedImages().getImageFilename(dbId);
                        if (imageFilename == null) {
                            Log.w(TAG, "No saved wallpaper with id " + dbId);
                            return null;
                        }
                        String path = new File(a.getFilesDir(), imageFilename).getAbsolutePath();
                        int rotation = WallpaperCropActivity.getRotationFromExif(path);
                        return new BitmapRegionTileSource(a, path, 1024, rotation);
                    },
                    source -> {
                        CropView v = a.getCropView();
                        v.setTileSource(source, null);
                        v.moveToLeft();
                        v.setTouchEnabled(false);
                    },
                    null);
        }
        @Override
        public void onSave(WallpaperPickerActivity a) {
            boolean finishActivityWhenDone = true;
            String imageFilename = a.getSavedImages().getImageFilename(mDbId);
            a.setWallpaper(imageFilename, finishActivityWhenDone);
        }
        @Override
        public void onDelete(WallpaperPickerActivity a) {
            a.getSavedImages().deleteImage(mDbId);
        }
        @Override
        public boolean isSelectable() {
            return true;
        }
        @Override
        public boolean isNamelessWallpaper() {
            return true;
        }
    }

    public SavedWallpaperImages(Activity context) {
        mDb = new ImageDb(context);
        mContext = context;
        mLayoutInflater = context.getLayoutInflater();
    }

    /**
     * Reads the list and decodes the thumbnails. Called on the picker's loader thread; the
     * adapter is only used on the UI thread after this has returned.
     */
    public void loadThumbnailsAndImageIdList() {
        mImages = new ArrayList<SavedWallpaperTile>();
        SQLiteDatabase db = mDb.getReadableDatabase();
        Cursor result = db.query(ImageDb.TABLE_NAME,
                new String[] { ImageDb.COLUMN_ID,
                    ImageDb.COLUMN_IMAGE_THUMBNAIL_FILENAME }, // cols to return
                null, // select query
                null, // args to select query
                null,
                null,
                ImageDb.COLUMN_ID + " DESC",
                null);

        try {
            while (result.moveToNext()) {
                String filename = result.getString(1);
                File file = new File(mContext.getFilesDir(), filename);

                Bitmap thumb = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (thumb != null) {
                    mImages.add(new SavedWallpaperTile(result.getInt(0), new BitmapDrawable(mContext.getResources(), thumb)));
                }
            }
        } finally {
            // A failure here is now logged by the picker instead of crashing it, so the
            // cursor must not leak either way.
            result.close();
        }
    }

    public int getCount() {
        return mImages.size();
    }

    public SavedWallpaperTile getItem(int position) {
        return mImages.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Drawable thumbDrawable = mImages.get(position).mThumb;
        if (thumbDrawable == null) {
            Log.e(TAG, "Error decoding thumbnail for wallpaper #" + position);
        }
        return WallpaperPickerActivity.createImageTileView(
                mLayoutInflater, position, convertView, parent, thumbDrawable);
    }

    public String getImageFilename(int id) {
        Pair<String, String> filenames = getImageFilenames(id);
        if (filenames != null) {
            return filenames.second;
        }
        return null;
    }

    private Pair<String, String> getImageFilenames(int id) {
        SQLiteDatabase db = mDb.getReadableDatabase();
        Cursor result = db.query(ImageDb.TABLE_NAME,
                new String[] { ImageDb.COLUMN_IMAGE_THUMBNAIL_FILENAME,
                    ImageDb.COLUMN_IMAGE_FILENAME }, // cols to return
                ImageDb.COLUMN_ID + " = ?", // select query
                new String[] { Integer.toString(id) }, // args to select query
                null,
                null,
                null,
                null);
        try {
            if (result.moveToFirst()) {
                String thumbFilename = result.getString(0);
                String imageFilename = result.getString(1);
                return new Pair<String, String>(thumbFilename, imageFilename);
            }
            return null;
        } finally {
            // Closed on every path: the cursor used to leak when no row matched.
            result.close();
        }
    }

    public void deleteImage(int id) {
        Pair<String, String> filenames = getImageFilenames(id);
        File imageFile = new File(mContext.getFilesDir(), filenames.first);
        imageFile.delete();
        File thumbFile = new File(mContext.getFilesDir(), filenames.second);
        thumbFile.delete();
        SQLiteDatabase db = mDb.getWritableDatabase();
        db.delete(ImageDb.TABLE_NAME,
                ImageDb.COLUMN_ID + " = ?", // SELECT query
                new String[] {
                    Integer.toString(id) // args to SELECT query
                });
    }

    public void writeImage(Bitmap thumbnail, byte[] imageBytes) {
        if (thumbnail == null) {
            // createThumbnail() returns null when cropping fails. This runs on the crop task's
            // thread after the wallpaper has been set, so the NPE it used to cause killed the
            // launcher process. Without a thumbnail the entry would never be listed anyway.
            Log.e(TAG, "No thumbnail, not saving the wallpaper to the recent list");
            return;
        }
        try {
            File imageFile = File.createTempFile("wallpaper", "", mContext.getFilesDir());
            // try-with-resources: a failed write used to leave the stream open.
            try (FileOutputStream imageFileStream =
                    mContext.openFileOutput(imageFile.getName(), Context.MODE_PRIVATE)) {
                imageFileStream.write(imageBytes);
            }

            File thumbFile = File.createTempFile("wallpaperthumb", "", mContext.getFilesDir());
            try (FileOutputStream thumbFileStream =
                    mContext.openFileOutput(thumbFile.getName(), Context.MODE_PRIVATE)) {
                thumbnail.compress(Bitmap.CompressFormat.JPEG, 95, thumbFileStream);
            }

            SQLiteDatabase db = mDb.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(ImageDb.COLUMN_IMAGE_THUMBNAIL_FILENAME, thumbFile.getName());
            values.put(ImageDb.COLUMN_IMAGE_FILENAME, imageFile.getName());
            db.insert(ImageDb.TABLE_NAME, null, values);
        } catch (IOException e) {
            Log.e(TAG, "Failed writing images to storage " + e);
        }
    }

    static class ImageDb extends SQLiteOpenHelper {
        final static int DB_VERSION = 1;
        final static String DB_NAME = "saved_wallpaper_images.db";
        final static String TABLE_NAME = "saved_wallpaper_images";
        final static String COLUMN_ID = "id";
        final static String COLUMN_IMAGE_THUMBNAIL_FILENAME = "image_thumbnail";
        final static String COLUMN_IMAGE_FILENAME = "image";

        Context mContext;

        public ImageDb(Context context) {
            super(context, new File(context.getCacheDir(), DB_NAME).getPath(), null, DB_VERSION);
            // Store the context for later use
            mContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER NOT NULL, " +
                    COLUMN_IMAGE_THUMBNAIL_FILENAME + " TEXT NOT NULL, " +
                    COLUMN_IMAGE_FILENAME + " TEXT NOT NULL, " +
                    "PRIMARY KEY (" + COLUMN_ID + " ASC) " +
                    ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion != newVersion) {
                // Delete all the records; they'll be repopulated as this is a cache
                db.execSQL("DELETE FROM " + TABLE_NAME);
            }
        }
    }
}
