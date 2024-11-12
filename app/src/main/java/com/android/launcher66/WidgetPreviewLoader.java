package com.android.launcher66;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class WidgetPreviewLoader {
    private static final String SHORTCUT_PREFIX = "Shortcut:";
    static final String TAG = "WidgetPreviewLoader";
    private static final String WIDGET_PREFIX = "Widget:";
    private static HashSet<String> sInvalidPackages = new HashSet<>();
    private int mAppIconSize;
    private String mCachedSelectQuery;
    private Context mContext;
    private CacheDb mDb;
    private IconCache mIconCache;
    private HashMap<String, WeakReference<Bitmap>> mLoadedPreviews;
    private PackageManager mPackageManager;
    private int mPreviewBitmapHeight;
    private int mPreviewBitmapWidth;
    private String mSize;
    private ArrayList<SoftReference<Bitmap>> mUnusedBitmaps;
    private PagedViewCellLayout mWidgetSpacingLayout;
    private BitmapCache mCachedShortcutPreviewBitmap = new BitmapCache();
    private PaintCache mCachedShortcutPreviewPaint = new PaintCache();
    private CanvasCache mCachedShortcutPreviewCanvas = new CanvasCache();
    private CanvasCache mCachedAppWidgetPreviewCanvas = new CanvasCache();
    private RectCache mCachedAppWidgetPreviewSrcRect = new RectCache();
    private RectCache mCachedAppWidgetPreviewDestRect = new RectCache();
    private PaintCache mCachedAppWidgetPreviewPaint = new PaintCache();
    private BitmapFactoryOptionsCache mCachedBitmapFactoryOptions = new BitmapFactoryOptionsCache();
    private final float sWidgetPreviewIconPaddingPercentage = 0.25f;

    public WidgetPreviewLoader(Context context) {
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        this.mContext = context;
        this.mPackageManager = this.mContext.getPackageManager();
        this.mAppIconSize = grid.iconSizePx;
        this.mIconCache = app.getIconCache();
        this.mDb = app.getWidgetPreviewCacheDb();
        this.mLoadedPreviews = new HashMap<>();
        this.mUnusedBitmaps = new ArrayList<>();
    }

    public void setPreviewSize(int previewWidth, int previewHeight, PagedViewCellLayout widgetSpacingLayout) {
        this.mPreviewBitmapWidth = previewWidth;
        this.mPreviewBitmapHeight = previewHeight;
        this.mSize = String.valueOf(previewWidth) + "x" + previewHeight;
        this.mWidgetSpacingLayout = widgetSpacingLayout;
    }

    /* JADX WARN: Type inference failed for: r7v9, types: [com.android.launcher66.WidgetPreviewLoader$1] */
    public Bitmap getPreview(final Object o) {
        boolean packageValid;
        String name = getObjectName(o);
        String packageName = getObjectPackage(o);
        synchronized (sInvalidPackages) {
            packageValid = !sInvalidPackages.contains(packageName);
        }
        if (!packageValid) {
            return null;
        }
        if (packageValid) {
            synchronized (this.mLoadedPreviews) {
                if (this.mLoadedPreviews.containsKey(name) && this.mLoadedPreviews.get(name).get() != null) {
                    return this.mLoadedPreviews.get(name).get();
                }
            }
        }
        Bitmap unusedBitmap = null;
        synchronized (this.mUnusedBitmaps) {
            while (true) {
                if (unusedBitmap != null) {
                    if (unusedBitmap.isMutable() && unusedBitmap.getWidth() == this.mPreviewBitmapWidth && unusedBitmap.getHeight() == this.mPreviewBitmapHeight) {
                        break;
                    }
                }
                if (this.mUnusedBitmaps.size() <= 0) {
                    break;
                }
                Bitmap unusedBitmap2 = this.mUnusedBitmaps.remove(0).get();
                unusedBitmap = unusedBitmap2;
            }
            if (unusedBitmap != null) {
                Canvas c = this.mCachedAppWidgetPreviewCanvas.get();
                c.setBitmap(unusedBitmap);
                c.drawColor(0, PorterDuff.Mode.CLEAR);
                c.setBitmap(null);
            }
        }
        if (unusedBitmap == null) {
            unusedBitmap = Bitmap.createBitmap(this.mPreviewBitmapWidth, this.mPreviewBitmapHeight, Bitmap.Config.ARGB_8888);
        }
        Bitmap preview = null;
        if (packageValid) {
            preview = readFromDb(name, unusedBitmap);
        }
        if (preview != null) {
            synchronized (this.mLoadedPreviews) {
                this.mLoadedPreviews.put(name, new WeakReference<>(preview));
            }
            return preview;
        }
        final Bitmap generatedPreview = generatePreview(o, unusedBitmap);
        if (generatedPreview != unusedBitmap) {
            throw new RuntimeException("generatePreview is not recycling the bitmap " + o);
        }
        synchronized (this.mLoadedPreviews) {
            this.mLoadedPreviews.put(name, new WeakReference<>(generatedPreview));
        }
        new AsyncTask<Void, Void, Void>() { // from class: com.android.launcher66.WidgetPreviewLoader.1
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... args) {
                WidgetPreviewLoader.this.writeToDb(o, generatedPreview);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void) null);
        return generatedPreview;
    }

    public void recycleBitmap(Object o, Bitmap bitmapToRecycle) {
        String name = getObjectName(o);
        synchronized (this.mLoadedPreviews) {
            if (this.mLoadedPreviews.containsKey(name)) {
                Bitmap b = this.mLoadedPreviews.get(name).get();
                if (b == bitmapToRecycle) {
                    this.mLoadedPreviews.remove(name);
                    if (bitmapToRecycle.isMutable()) {
                        synchronized (this.mUnusedBitmaps) {
                            this.mUnusedBitmaps.add(new SoftReference<>(b));
                        }
                    }
                } else {
                    throw new RuntimeException("Bitmap passed in doesn't match up");
                }
            }
        }
    }

    static class CacheDb extends SQLiteOpenHelper {
        static final String COLUMN_NAME = "name";
        static final String COLUMN_PREVIEW_BITMAP = "preview_bitmap";
        static final String COLUMN_SIZE = "size";
        static final String DB_NAME = "widgetpreviews.db";
        static final int DB_VERSION = 2;
        static final String TABLE_NAME = "shortcut_and_widget_previews";
        Context mContext;

        public CacheDb(Context context) {
            super(context, new File(context.getCacheDir(), DB_NAME).getPath(), (SQLiteDatabase.CursorFactory) null, 2);
            this.mContext = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS shortcut_and_widget_previews (name TEXT NOT NULL, size TEXT NOT NULL, preview_bitmap BLOB NOT NULL, PRIMARY KEY (name, size) );");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion != newVersion) {
                db.execSQL("DELETE FROM shortcut_and_widget_previews");
            }
        }
    }

    private static String getObjectName(Object o) {
        StringBuilder sb = new StringBuilder();
        if (o instanceof AppWidgetProviderInfo) {
            sb.append(WIDGET_PREFIX);
            sb.append(((AppWidgetProviderInfo) o).provider.flattenToString());
            String output = sb.toString();
            sb.setLength(0);
            return output;
        }
        sb.append(SHORTCUT_PREFIX);
        ResolveInfo info = (ResolveInfo) o;
        sb.append(new ComponentName(info.activityInfo.packageName, info.activityInfo.name).flattenToString());
        String output2 = sb.toString();
        sb.setLength(0);
        return output2;
    }

    private String getObjectPackage(Object o) {
        if (o instanceof AppWidgetProviderInfo) {
            return ((AppWidgetProviderInfo) o).provider.getPackageName();
        }
        ResolveInfo info = (ResolveInfo) o;
        return info.activityInfo.packageName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToDb(Object o, Bitmap preview) {
        String name = getObjectName(o);
        SQLiteDatabase db = this.mDb.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        preview.compress(Bitmap.CompressFormat.PNG, 100, stream);
        values.put("preview_bitmap", stream.toByteArray());
        values.put("size", this.mSize);
        db.insert("shortcut_and_widget_previews", null, values);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.android.launcher66.WidgetPreviewLoader$2] */
    public static void removePackageFromDb(final CacheDb cacheDb, final String packageName) {
        synchronized(sInvalidPackages) {
            sInvalidPackages.add(packageName);
        }
        new AsyncTask<Void, Void, Void>() { // from class: com.android.launcher66.WidgetPreviewLoader.2
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... args) {
                SQLiteDatabase db = cacheDb.getWritableDatabase();
                db.delete("shortcut_and_widget_previews", "name LIKE ? OR name LIKE ?", new String[]{WidgetPreviewLoader.WIDGET_PREFIX + packageName + "/%", WidgetPreviewLoader.SHORTCUT_PREFIX + packageName + "/%"});
                synchronized (WidgetPreviewLoader.sInvalidPackages) {
                    WidgetPreviewLoader.sInvalidPackages.remove(packageName);
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void) null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.launcher66.WidgetPreviewLoader$3] */
    public static void removeItemFromDb(final CacheDb cacheDb, final String objectName) {
        new AsyncTask<Void, Void, Void>() { // from class: com.android.launcher66.WidgetPreviewLoader.3
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... args) {
                SQLiteDatabase db = cacheDb.getWritableDatabase();
                db.delete("shortcut_and_widget_previews", "name = ? ", new String[]{objectName});
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void) null);
    }

    private Bitmap readFromDb(String name, Bitmap b) {
        if (this.mCachedSelectQuery == null) {
            this.mCachedSelectQuery = "name = ? AND size = ?";
        }
        SQLiteDatabase db = this.mDb.getReadableDatabase();
        Cursor result = db.query("shortcut_and_widget_previews", new String[]{"preview_bitmap"}, this.mCachedSelectQuery, new String[]{name, this.mSize}, null, null, null, null);
        if (result.getCount() > 0) {
            result.moveToFirst();
            byte[] blob = result.getBlob(0);
            result.close();
            BitmapFactory.Options opts = this.mCachedBitmapFactoryOptions.get();
            opts.inBitmap = b;
            opts.inSampleSize = 1;
            try {
                return BitmapFactory.decodeByteArray(blob, 0, blob.length, opts);
            } catch (IllegalArgumentException e) {
                removeItemFromDb(this.mDb, name);
                return null;
            }
        }
        result.close();
        return null;
    }

    public Bitmap generatePreview(Object info, Bitmap preview) {
        if (preview != null && (preview.getWidth() != this.mPreviewBitmapWidth || preview.getHeight() != this.mPreviewBitmapHeight)) {
            throw new RuntimeException("Improperly sized bitmap passed as argument");
        }
        if (info instanceof AppWidgetProviderInfo) {
            return generateWidgetPreview((AppWidgetProviderInfo) info, preview);
        }
        return generateShortcutPreview((ResolveInfo) info, this.mPreviewBitmapWidth, this.mPreviewBitmapHeight, preview);
    }

    public Bitmap generateWidgetPreview(AppWidgetProviderInfo info, Bitmap preview) {
        int[] cellSpans = Launcher.getSpanForWidget(this.mContext, info);
        int maxWidth = maxWidthForWidgetPreview(cellSpans[0]);
        int maxHeight = maxHeightForWidgetPreview(cellSpans[1]);
        return generateWidgetPreview(info.provider, info.previewImage, info.icon, cellSpans[0], cellSpans[1], maxWidth, maxHeight, preview, null);
    }

    public int maxWidthForWidgetPreview(int spanX) {
        return Math.min(this.mPreviewBitmapWidth, this.mWidgetSpacingLayout.estimateCellWidth(spanX));
    }

    public int maxHeightForWidgetPreview(int spanY) {
        return Math.min(this.mPreviewBitmapHeight, this.mWidgetSpacingLayout.estimateCellHeight(spanY));
    }

    public Bitmap generateWidgetPreview(ComponentName provider, int previewImage, int iconId, int cellHSpan, int cellVSpan, int maxPreviewWidth, int maxPreviewHeight, Bitmap preview, int[] preScaledWidthOut) {
        int previewWidth;
        int previewHeight;
        String packageName = provider.getPackageName();
        if (maxPreviewWidth < 0) {
            maxPreviewWidth = Integer.MAX_VALUE;
        }
        if (maxPreviewHeight < 0) {
        }
        Drawable drawable = null;
        if (previewImage != 0 && (drawable = this.mPackageManager.getDrawable(packageName, previewImage, null)) == null) {
            Log.w(TAG, "Can't load widget preview drawable 0x" + Integer.toHexString(previewImage) + " for provider: " + provider);
        }
        Bitmap defaultPreview = null;
        boolean widgetPreviewExists = drawable != null;
        if (widgetPreviewExists) {
            previewWidth = drawable.getIntrinsicWidth();
            previewHeight = drawable.getIntrinsicHeight();
        } else {
            if (cellHSpan < 1) {
                cellHSpan = 1;
            }
            if (cellVSpan < 1) {
                cellVSpan = 1;
            }
            BitmapDrawable previewDrawable = (BitmapDrawable) this.mContext.getResources().getDrawable(R.drawable.widget_tile);
            int previewDrawableWidth = previewDrawable.getIntrinsicWidth();
            int previewDrawableHeight = previewDrawable.getIntrinsicHeight();
            previewWidth = previewDrawableWidth * cellHSpan;
            previewHeight = previewDrawableHeight * cellVSpan;
            defaultPreview = Bitmap.createBitmap(previewWidth, previewHeight, Bitmap.Config.ARGB_8888);
            Canvas c = this.mCachedAppWidgetPreviewCanvas.get();
            c.setBitmap(defaultPreview);
            previewDrawable.setBounds(0, 0, previewWidth, previewHeight);
            previewDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            previewDrawable.draw(c);
            c.setBitmap(null);
            int minOffset = (int) (this.mAppIconSize * 0.25f);
            int smallestSide = Math.min(previewWidth, previewHeight);
            float iconScale = Math.min(smallestSide / (this.mAppIconSize + (minOffset * 2)), 1.0f);
            Drawable icon = null;
            try {
                int hoffset = (int) ((previewDrawableWidth - (this.mAppIconSize * iconScale)) / 2.0f);
                int yoffset = (int) ((previewDrawableHeight - (this.mAppIconSize * iconScale)) / 2.0f);
                if (iconId > 0) {
                    icon = this.mIconCache.getFullResIcon(packageName, iconId);
                }
                if (icon != null) {
                    renderDrawableToBitmap(icon, defaultPreview, hoffset, yoffset, (int) (this.mAppIconSize * iconScale), (int) (this.mAppIconSize * iconScale));
                }
            } catch (Resources.NotFoundException e) {
            }
        }
        float scale = 1.0f;
        if (preScaledWidthOut != null) {
            preScaledWidthOut[0] = previewWidth;
        }
        if (previewWidth > maxPreviewWidth) {
            scale = maxPreviewWidth / previewWidth;
        }
        if (scale != 1.0f) {
            previewWidth = (int) (previewWidth * scale);
            previewHeight = (int) (previewHeight * scale);
        }
        if (preview == null) {
            preview = Bitmap.createBitmap(previewWidth, previewHeight, Bitmap.Config.ARGB_8888);
        }
        int x = (preview.getWidth() - previewWidth) / 2;
        if (widgetPreviewExists) {
            renderDrawableToBitmap(drawable, preview, x, 0, previewWidth, previewHeight);
        } else {
            Canvas c2 = this.mCachedAppWidgetPreviewCanvas.get();
            Rect src = this.mCachedAppWidgetPreviewSrcRect.get();
            Rect dest = this.mCachedAppWidgetPreviewDestRect.get();
            c2.setBitmap(preview);
            src.set(0, 0, defaultPreview.getWidth(), defaultPreview.getHeight());
            dest.set(x, 0, x + previewWidth, previewHeight);
            Paint p = this.mCachedAppWidgetPreviewPaint.get();
            if (p == null) {
                p = new Paint();
                p.setFilterBitmap(true);
                this.mCachedAppWidgetPreviewPaint.set(p);
            }
            c2.drawBitmap(defaultPreview, src, dest, p);
            c2.setBitmap(null);
        }
        return preview;
    }

    private Bitmap generateShortcutPreview(ResolveInfo info, int maxWidth, int maxHeight, Bitmap preview) {
        Bitmap tempBitmap = this.mCachedShortcutPreviewBitmap.get();
        Canvas c = this.mCachedShortcutPreviewCanvas.get();
        if (tempBitmap == null || tempBitmap.getWidth() != maxWidth || tempBitmap.getHeight() != maxHeight) {
            tempBitmap = Bitmap.createBitmap(maxWidth, maxHeight, Bitmap.Config.ARGB_8888);
            this.mCachedShortcutPreviewBitmap.set(tempBitmap);
        } else {
            c.setBitmap(tempBitmap);
            c.drawColor(0, PorterDuff.Mode.CLEAR);
            c.setBitmap(null);
        }
        Drawable icon = this.mIconCache.getFullResIcon(info);
        int paddingTop = this.mContext.getResources().getDimensionPixelOffset(R.dimen.shortcut_preview_padding_top);
        int paddingLeft = this.mContext.getResources().getDimensionPixelOffset(R.dimen.shortcut_preview_padding_left);
        int paddingRight = this.mContext.getResources().getDimensionPixelOffset(R.dimen.shortcut_preview_padding_right);
        int scaledIconWidth = (maxWidth - paddingLeft) - paddingRight;
        renderDrawableToBitmap(icon, tempBitmap, paddingLeft, paddingTop, scaledIconWidth, scaledIconWidth);
        if (preview != null && (preview.getWidth() != maxWidth || preview.getHeight() != maxHeight)) {
            throw new RuntimeException("Improperly sized bitmap passed as argument");
        }
        if (preview == null) {
            preview = Bitmap.createBitmap(maxWidth, maxHeight, Bitmap.Config.ARGB_8888);
        }
        c.setBitmap(preview);
        Paint p = this.mCachedShortcutPreviewPaint.get();
        if (p == null) {
            p = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            p.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            p.setAlpha(15);
            this.mCachedShortcutPreviewPaint.set(p);
        }
        c.drawBitmap(tempBitmap, 0.0f, 0.0f, p);
        c.setBitmap(null);
        renderDrawableToBitmap(icon, preview, 0, 0, this.mAppIconSize, this.mAppIconSize);
        return preview;
    }

    public static void renderDrawableToBitmap(Drawable d, Bitmap bitmap, int x, int y, int w, int h) {
        renderDrawableToBitmap(d, bitmap, x, y, w, h, 1.0f);
    }

    private static void renderDrawableToBitmap(Drawable d, Bitmap bitmap, int x, int y, int w, int h, float scale) {
        if (bitmap != null) {
            Canvas c = new Canvas(bitmap);
            c.scale(scale, scale);
            Rect oldBounds = d.copyBounds();
            d.setBounds(x, y, x + w, y + h);
            d.draw(c);
            d.setBounds(oldBounds);
            c.setBitmap(null);
        }
    }
}
