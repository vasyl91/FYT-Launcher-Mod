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
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.android.launcher66.WallpaperPickerActivity;
import com.android.photos.BitmapRegionTileSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class SavedWallpaperImages extends BaseAdapter implements ListAdapter {
    private static String TAG = "Launcher3.SavedWallpaperImages";
    Context mContext;
    private ImageDb mDb;
    ArrayList<SavedWallpaperTile> mImages;
    LayoutInflater mLayoutInflater;

    public static class SavedWallpaperTile extends WallpaperPickerActivity.WallpaperTileInfo {
        private int mDbId;
        private Drawable mThumb;

        public SavedWallpaperTile(int dbId, Drawable thumb) {
            this.mDbId = dbId;
            this.mThumb = thumb;
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public void onClick(WallpaperPickerActivity a) {
            String imageFilename = a.getSavedImages().getImageFilename(this.mDbId);
            File file = new File(a.getFilesDir(), imageFilename);
            CropView v = a.getCropView();
            int rotation = WallpaperCropActivity.getRotationFromExif(file.getAbsolutePath());
            Uri myUri = Uri.parse(file.getAbsolutePath());
            v.setTileSource(new BitmapRegionTileSource(a, myUri, 1024, rotation), null);
            v.moveToLeft();
            v.setTouchEnabled(false);
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public void onSave(WallpaperPickerActivity a) {
            String imageFilename = a.getSavedImages().getImageFilename(this.mDbId);
            a.setWallpaper(imageFilename, true);
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public void onDelete(WallpaperPickerActivity a) {
            a.getSavedImages().deleteImage(this.mDbId);
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public boolean isSelectable() {
            return true;
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public boolean isNamelessWallpaper() {
            return true;
        }
    }

    public SavedWallpaperImages(Activity context) {
        this.mDb = new ImageDb(context);
        this.mContext = context;
        this.mLayoutInflater = context.getLayoutInflater();
    }

    public void loadThumbnailsAndImageIdList() {
        this.mImages = new ArrayList<>();
        SQLiteDatabase db = this.mDb.getReadableDatabase();
        Cursor result = db.query("saved_wallpaper_images", new String[]{"id", "image_thumbnail"}, null, null, null, null, "id DESC", null);
        while (result.moveToNext()) {
            String filename = result.getString(1);
            File file = new File(this.mContext.getFilesDir(), filename);
            Bitmap thumb = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (thumb != null) {
                this.mImages.add(new SavedWallpaperTile(result.getInt(0), new BitmapDrawable(thumb)));
            }
        }
        result.close();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mImages.size();
    }

    @Override // android.widget.Adapter
    public SavedWallpaperTile getItem(int position) {
        return this.mImages.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Drawable thumbDrawable = this.mImages.get(position).mThumb;
        if (thumbDrawable == null) {
            Log.e(TAG, "Error decoding thumbnail for wallpaper #" + position);
        }
        return WallpaperPickerActivity.createImageTileView(this.mLayoutInflater, position, convertView, parent, thumbDrawable);
    }

    public String getImageFilename(int id) {
        Pair<String, String> filenames = getImageFilenames(id);
        if (filenames != null) {
            return (String) filenames.second;
        }
        return null;
    }

    private Pair<String, String> getImageFilenames(int id) {
        SQLiteDatabase db = this.mDb.getReadableDatabase();
        Cursor result = db.query("saved_wallpaper_images", new String[]{"image_thumbnail", "image"}, "id = ?", new String[]{Integer.toString(id)}, null, null, null, null);
        if (result.getCount() <= 0) {
            return null;
        }
        result.moveToFirst();
        String thumbFilename = result.getString(0);
        String imageFilename = result.getString(1);
        result.close();
        return new Pair<>(thumbFilename, imageFilename);
    }

    public void deleteImage(int id) {
        Pair<String, String> filenames = getImageFilenames(id);
        File imageFile = new File(this.mContext.getFilesDir(), (String) filenames.first);
        imageFile.delete();
        File thumbFile = new File(this.mContext.getFilesDir(), (String) filenames.second);
        thumbFile.delete();
        SQLiteDatabase db = this.mDb.getWritableDatabase();
        db.delete("saved_wallpaper_images", "id = ?", new String[]{Integer.toString(id)});
    }

    public void writeImage(Bitmap thumbnail, byte[] imageBytes) {
        try {
            File imageFile = File.createTempFile("wallpaper", "", this.mContext.getFilesDir());
            FileOutputStream imageFileStream = this.mContext.openFileOutput(imageFile.getName(), 0);
            imageFileStream.write(imageBytes);
            imageFileStream.close();
            File thumbFile = File.createTempFile("wallpaperthumb", "", this.mContext.getFilesDir());
            FileOutputStream thumbFileStream = this.mContext.openFileOutput(thumbFile.getName(), 0);
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 95, thumbFileStream);
            thumbFileStream.close();
            SQLiteDatabase db = this.mDb.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("image_thumbnail", thumbFile.getName());
            values.put("image", imageFile.getName());
            db.insert("saved_wallpaper_images", null, values);
        } catch (IOException e) {
            Log.e(TAG, "Failed writing images to storage " + e);
        }
    }

    static class ImageDb extends SQLiteOpenHelper {
        static final String COLUMN_ID = "id";
        static final String COLUMN_IMAGE_FILENAME = "image";
        static final String COLUMN_IMAGE_THUMBNAIL_FILENAME = "image_thumbnail";
        static final String DB_NAME = "saved_wallpaper_images.db";
        static final int DB_VERSION = 1;
        static final String TABLE_NAME = "saved_wallpaper_images";
        Context mContext;

        public ImageDb(Context context) {
            super(context, new File(context.getCacheDir(), DB_NAME).getPath(), (SQLiteDatabase.CursorFactory) null, 1);
            this.mContext = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS saved_wallpaper_images (id INTEGER NOT NULL, image_thumbnail TEXT NOT NULL, image TEXT NOT NULL, PRIMARY KEY (id ASC) );");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion != newVersion) {
                db.execSQL("DELETE FROM saved_wallpaper_images");
            }
        }
    }
}
