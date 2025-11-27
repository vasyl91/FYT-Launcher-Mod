package com.android.launcher66;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;

import com.syu.log.LogPreview;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LauncherProvider extends ContentProvider {
    private static final String ACTION_APPWIDGET_DEFAULT_WORKSPACE_CONFIGURE = "com.android.launcher.action.APPWIDGET_DEFAULT_WORKSPACE_CONFIGURE";
    static final String AUTHORITY = "com.android.launcher66.settings";
    static final Uri CONTENT_APPWIDGET_RESET_URI = Uri.parse("content://com.android.launcher66.settings/appWidgetReset");
    private static final String DATABASE_NAME = "launcher66.db";
    private static final int DATABASE_VERSION = 15;
    static final String DEFAULT_WORKSPACE_RESOURCE_ID = "DEFAULT_WORKSPACE_RESOURCE_ID";
    static final String EMPTY_DATABASE_CREATED = "EMPTY_DATABASE_CREATED";
    private static final boolean LOGD = false;
    static final String OLD_AUTHORITY = "com.android.launcher66.settings";
    static final String PARAMETER_NOTIFY = "notify";
    static final String TABLE_FAVORITES = "favorites";
    static final String TABLE_WORKSPACE_SCREENS = "workspaceScreens";
    private static final String TAG = "Launcher.LauncherProvider";
    static final String UPGRADED_FROM_OLD_DATABASE = "UPGRADED_FROM_OLD_DATABASE";
    private static boolean sJustLoadedFromOldDb;
    private DatabaseHelper mOpenHelper;

    private interface ContentValuesCallback {
        void onRow(ContentValues contentValues);
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        this.mOpenHelper = new DatabaseHelper(context);
        LauncherAppState.setLauncherProvider(this);
        return true;
    }

    @Override
    public String getType(Uri uri) {
        SqlArguments args = new SqlArguments(uri, null, null);
        return TextUtils.isEmpty(args.where) ? "vnd.android.cursor.dir/" + args.table : "vnd.android.cursor.item/" + args.table;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SqlArguments args = new SqlArguments(uri, selection, selectionArgs);
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(args.table);
        SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
        Cursor result = qb.query(db, projection, args.where, args.args, null, null, sortOrder);
        result.setNotificationUri(getContext().getContentResolver(), uri);
        return result;
    }

    
    public static long dbInsertAndCheck(DatabaseHelper helper, SQLiteDatabase db, String table, String nullColumnHack, ContentValues values) {
        if (!values.containsKey("_id")) {
            throw new RuntimeException("Error: attempting to add item without specifying an id");
        }
        return db.insert(table, nullColumnHack, values);
    }

    
    public static void deleteId(SQLiteDatabase db, long id) {
        Uri uri = LauncherSettings.Favorites.getContentUri(id, false);
        SqlArguments args = new SqlArguments(uri, null, null);
        db.delete(args.table, args.where, args.args);
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        SqlArguments args = new SqlArguments(uri);
        SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
        addModifiedTime(initialValues);
        long rowId = dbInsertAndCheck(this.mOpenHelper, db, args.table, null, initialValues);
        if (rowId <= 0) {
            return null;
        }
        Uri uri2 = ContentUris.withAppendedId(uri, rowId);
        sendNotify(uri2);
        return uri2;
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        SqlArguments args = new SqlArguments(uri);
        SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
        db.beginTransaction();
        try {
            int numValues = values.length;
            for (int i = 0; i < numValues; i++) {
                addModifiedTime(values[i]);
                if (dbInsertAndCheck(this.mOpenHelper, db, args.table, null, values[i]) < 0) {
                    db.endTransaction();
                    return 0;
                }
            }
            db.setTransactionSuccessful();
            db.endTransaction();
            sendNotify(uri);
            return values.length;
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        LogPreview.show("delete");
        SqlArguments args = new SqlArguments(uri, selection, selectionArgs);
        SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
        int count = db.delete(args.table, args.where, args.args);
        if (count > 0) {
            sendNotify(uri);
        }
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        LogPreview.show("update");
        SqlArguments args = new SqlArguments(uri, selection, selectionArgs);
        addModifiedTime(values);
        SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
        int count = db.update(args.table, values, args.where, args.args);
        if (count > 0) {
            sendNotify(uri);
        }
        return count;
    }

    private void sendNotify(Uri uri) {
        String notify = uri.getQueryParameter(PARAMETER_NOTIFY);
        if (notify == null || "true".equals(notify)) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
    }

    private void addModifiedTime(ContentValues values) {
        values.put(LauncherSettings.ChangeLogColumns.MODIFIED, Long.valueOf(System.currentTimeMillis()));
    }

    public long generateNewItemId() {
        return this.mOpenHelper.generateNewItemId();
    }

    public void updateMaxItemId(long id) {
        this.mOpenHelper.updateMaxItemId(id);
    }

    public long generateNewScreenId() {
        return this.mOpenHelper.generateNewScreenId();
    }

    public void updateMaxScreenId(long maxScreenId) {
        this.mOpenHelper.updateMaxScreenId(maxScreenId);
    }

    public synchronized boolean justLoadedOldDb() {
        boolean loadedOldDb;
        synchronized (this) {
            String spKey = LauncherAppState.getSharedPreferencesKey();
            SharedPreferences sp = getContext().getSharedPreferences(spKey, 0);
            loadedOldDb = sJustLoadedFromOldDb;
            sJustLoadedFromOldDb = false;
            if (sp.getBoolean(UPGRADED_FROM_OLD_DATABASE, false)) {
                SharedPreferences.Editor editor = sp.edit();
                editor.remove(UPGRADED_FROM_OLD_DATABASE);
                editor.apply();
                loadedOldDb = true;
            }
        }
        return loadedOldDb;
    }

    public synchronized void loadDefaultFavoritesIfNecessary(int origWorkspaceResId) {
        String spKey = LauncherAppState.getSharedPreferencesKey();
        SharedPreferences sp = getContext().getSharedPreferences(spKey, 0);
        if (sp.getBoolean(EMPTY_DATABASE_CREATED, false)) {
            int workspaceResId = origWorkspaceResId;
            if (workspaceResId == 0) {
                workspaceResId = sp.getInt(DEFAULT_WORKSPACE_RESOURCE_ID, R.xml.default_workspace);
            }
            SharedPreferences.Editor editor = sp.edit();
            editor.remove(EMPTY_DATABASE_CREATED);
            if (origWorkspaceResId != 0) {
                editor.putInt(DEFAULT_WORKSPACE_RESOURCE_ID, origWorkspaceResId);
            }
            this.mOpenHelper.loadFavorites(this.mOpenHelper.getWritableDatabase(), workspaceResId);
            this.mOpenHelper.setFlagJustLoadedOldDb();
            editor.apply();
        }
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String TAG_APPWIDGET = "appwidget";
        private static final String TAG_CLOCK = "clock";
        private static final String TAG_EXTRA = "extra";
        private static final String TAG_FAVORITE = "favorite";
        private static final String TAG_FAVORITES = "favorites";
        private static final String TAG_FOLDER = "folder";
        private static final String TAG_INCLUDE = "include";
        private static final String TAG_SEARCH = "search";
        private static final String TAG_SHORTCUT = "shortcut";
        private final AppWidgetHost mAppWidgetHost;
        private final Context mContext;
        private long mMaxItemId;
        private long mMaxScreenId;

        DatabaseHelper(Context context) {
            super(context, LauncherProvider.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 15);
            this.mMaxItemId = -1L;
            this.mMaxScreenId = -1L;
            this.mContext = context;
            this.mAppWidgetHost = new AppWidgetHost(context, Launcher.APPWIDGET_HOST_ID);
            if (this.mMaxItemId == -1) {
                this.mMaxItemId = initializeMaxItemId(getWritableDatabase());
            }
            if (this.mMaxScreenId == -1) {
                this.mMaxScreenId = initializeMaxScreenId(getWritableDatabase());
            }
        }

        private void sendAppWidgetResetNotify() {
            ContentResolver resolver = this.mContext.getContentResolver();
            resolver.notifyChange(LauncherProvider.CONTENT_APPWIDGET_RESET_URI, null);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            this.mMaxItemId = 1L;
            this.mMaxScreenId = 0L;
            db.execSQL("CREATE TABLE favorites (_id INTEGER PRIMARY KEY,title TEXT,intent TEXT,container INTEGER,screen INTEGER,cellX INTEGER,cellY INTEGER,spanX INTEGER,spanY INTEGER,itemType INTEGER,appWidgetId INTEGER NOT NULL DEFAULT -1,isShortcut INTEGER,iconType INTEGER,iconPackage TEXT,iconResource TEXT,icon BLOB,uri TEXT,displayMode INTEGER,appWidgetProvider TEXT,modified INTEGER NOT NULL DEFAULT 0);");
            addWorkspacesTable(db);
            if (this.mAppWidgetHost != null) {
                this.mAppWidgetHost.deleteHost();
                sendAppWidgetResetNotify();
            }
            ContentValuesCallback permuteScreensCb = new ContentValuesCallback() { 
                @Override
                public void onRow(ContentValues values) {
                    int container = values.getAsInteger(Stats.EXTRA_CONTAINER).intValue();
                    if (container == -100) {
                        int screen = values.getAsInteger(Stats.EXTRA_SCREEN).intValue();
                        values.put(Stats.EXTRA_SCREEN, Integer.valueOf((int) DatabaseHelper.this.upgradeLauncherDb_permuteScreens(screen)));
                    }
                }
            };
            Uri uri = Uri.parse("content://settings/old_favorites?notify=true");
            if (!convertDatabase(db, uri, permuteScreensCb, true)) {
                Uri uri2 = LauncherSettings.Favorites.OLD_CONTENT_URI;
                if (!convertDatabase(db, uri2, permuteScreensCb, false)) {
                    setFlagEmptyDbCreated();
                    return;
                }
            }
            setFlagJustLoadedOldDb();
        }

        private void addWorkspacesTable(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE workspaceScreens (_id INTEGER,screenRank INTEGER,modified INTEGER NOT NULL DEFAULT 0);");
        }

        
        public void setFlagJustLoadedOldDb() {
            String spKey = LauncherAppState.getSharedPreferencesKey();
            SharedPreferences sp = this.mContext.getSharedPreferences(spKey, 0);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(LauncherProvider.UPGRADED_FROM_OLD_DATABASE, true);
            editor.putBoolean(LauncherProvider.EMPTY_DATABASE_CREATED, false);
            editor.apply();
        }

        private void setFlagEmptyDbCreated() {
            String spKey = LauncherAppState.getSharedPreferencesKey();
            SharedPreferences sp = this.mContext.getSharedPreferences(spKey, 0);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(LauncherProvider.EMPTY_DATABASE_CREATED, true);
            editor.putBoolean(LauncherProvider.UPGRADED_FROM_OLD_DATABASE, false);
            editor.apply();
        }

        
        public long upgradeLauncherDb_permuteScreens(long screen) {
            return screen >= 2 ? screen - 2 : 3 + screen;
        }

        private boolean convertDatabase(SQLiteDatabase db, Uri uri, ContentValuesCallback cb, boolean deleteRows) {
            boolean converted = false;
            ContentResolver resolver = this.mContext.getContentResolver();
            Cursor cursor = null;
            try {
                cursor = resolver.query(uri, null, null, null, null);
            } catch (Exception e) {
            }
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        converted = copyFromCursor(db, cursor, cb) > 0;
                        if (converted && deleteRows) {
                            resolver.delete(uri, null, null);
                        }
                    }
                } finally {
                    cursor.close();
                }
            }
            if (converted) {
                convertWidgets(db);
                this.mMaxItemId = initializeMaxItemId(db);
            }
            return converted;
        }

        private int copyFromCursor(SQLiteDatabase db, Cursor c, ContentValuesCallback cb) {
            int idIndex = c.getColumnIndexOrThrow("_id");
            int intentIndex = c.getColumnIndexOrThrow("intent");
            int titleIndex = c.getColumnIndexOrThrow("title");
            int iconTypeIndex = c.getColumnIndexOrThrow(LauncherSettings.BaseLauncherColumns.ICON_TYPE);
            int iconIndex = c.getColumnIndexOrThrow("icon");
            int iconPackageIndex = c.getColumnIndexOrThrow(LauncherSettings.BaseLauncherColumns.ICON_PACKAGE);
            int iconResourceIndex = c.getColumnIndexOrThrow("iconResource");
            int containerIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CONTAINER);
            int itemTypeIndex = c.getColumnIndexOrThrow(LauncherSettings.BaseLauncherColumns.ITEM_TYPE);
            int screenIndex = c.getColumnIndexOrThrow(Stats.EXTRA_SCREEN);
            int cellXIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CELLX);
            int cellYIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CELLY);
            int uriIndex = c.getColumnIndexOrThrow("uri");
            int displayModeIndex = c.getColumnIndexOrThrow("displayMode");
            ContentValues[] rows = new ContentValues[c.getCount()];
            int i = 0;
            while (c.moveToNext()) {
                ContentValues values = new ContentValues(c.getColumnCount());
                values.put("_id", Long.valueOf(c.getLong(idIndex)));
                values.put("intent", c.getString(intentIndex));
                values.put("title", c.getString(titleIndex));
                values.put(LauncherSettings.BaseLauncherColumns.ICON_TYPE, Integer.valueOf(c.getInt(iconTypeIndex)));
                values.put("icon", c.getBlob(iconIndex));
                values.put(LauncherSettings.BaseLauncherColumns.ICON_PACKAGE, c.getString(iconPackageIndex));
                values.put("iconResource", c.getString(iconResourceIndex));
                values.put(Stats.EXTRA_CONTAINER, Integer.valueOf(c.getInt(containerIndex)));
                values.put(LauncherSettings.BaseLauncherColumns.ITEM_TYPE, Integer.valueOf(c.getInt(itemTypeIndex)));
                values.put("appWidgetId", (Integer) (-1));
                values.put(Stats.EXTRA_SCREEN, Integer.valueOf(c.getInt(screenIndex)));
                values.put(Stats.EXTRA_CELLX, Integer.valueOf(c.getInt(cellXIndex)));
                values.put(Stats.EXTRA_CELLY, Integer.valueOf(c.getInt(cellYIndex)));
                values.put("uri", c.getString(uriIndex));
                values.put("displayMode", Integer.valueOf(c.getInt(displayModeIndex)));
                if (cb != null) {
                    cb.onRow(values);
                }
                rows[i] = values;
                i++;
            }
            int total = 0;
            if (i > 0) {
                db.beginTransaction();
                try {
                    for (ContentValues contentValues : rows) {
                        if (LauncherProvider.dbInsertAndCheck(this, db, TAG_FAVORITES, null, contentValues) >= 0) {
                            total++;
                        } else {
                            db.endTransaction();
                            return 0;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
            }
            return total;
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            int version = oldVersion;
            if (version < 3) {
                db.beginTransaction();
                try {
                    db.execSQL("ALTER TABLE favorites ADD COLUMN appWidgetId INTEGER NOT NULL DEFAULT -1;");
                    db.setTransactionSuccessful();
                    version = 3;
                    db.endTransaction();
                } catch (SQLException ex) {
                    Log.e(LauncherProvider.TAG, ex.getMessage(), ex);
                } finally {
                }
                if (version == 3) {
                    convertWidgets(db);
                }
            }
            if (version < 4) {
                version = 4;
            }
            if (version < 6) {
                db.beginTransaction();
                try {
                    db.execSQL("UPDATE favorites SET screen=(screen + 1);");
                    db.setTransactionSuccessful();
                    db.endTransaction();
                } catch (SQLException ex2) {
                    Log.e(LauncherProvider.TAG, ex2.getMessage(), ex2);
                } finally {
                }
                if (updateContactsShortcuts(db)) {
                    version = 6;
                }
            }
            if (version < 7) {
                convertWidgets(db);
                version = 7;
            }
            if (version < 8) {
                normalizeIcons(db);
                version = 8;
            }
            if (version < 9) {
                if (this.mMaxItemId == -1) {
                    this.mMaxItemId = initializeMaxItemId(db);
                }
                loadFavorites(db, R.xml.update_workspace);
                version = 9;
            }
            if (version < 12) {
                updateContactsShortcuts(db);
                version = 12;
            }
            if (version < 13) {
                this.mMaxScreenId = 0L;
                LauncherProvider.sJustLoadedFromOldDb = true;
                addWorkspacesTable(db);
                version = 13;
            }
            if (version < 14) {
                db.beginTransaction();
                try {
                    db.execSQL("ALTER TABLE favorites ADD COLUMN appWidgetProvider TEXT;");
                    db.setTransactionSuccessful();
                    version = 14;
                } catch (SQLException ex3) {
                    Log.e(LauncherProvider.TAG, ex3.getMessage(), ex3);
                } finally {
                }
            }
            if (version < 15) {
                db.beginTransaction();
                try {
                    db.execSQL("ALTER TABLE favorites ADD COLUMN modified INTEGER NOT NULL DEFAULT 0;");
                    db.execSQL("ALTER TABLE workspaceScreens ADD COLUMN modified INTEGER NOT NULL DEFAULT 0;");
                    db.setTransactionSuccessful();
                    version = 15;
                } catch (SQLException ex4) {
                    Log.e(LauncherProvider.TAG, ex4.getMessage(), ex4);
                } finally {
                }
            }
            if (version != 15) {
                Log.w(LauncherProvider.TAG, "Destroying all old data.");
                db.execSQL("DROP TABLE IF EXISTS favorites");
                db.execSQL("DROP TABLE IF EXISTS workspaceScreens");
                onCreate(db);
            }
        }

        @SuppressLint("WrongConstant")
        private boolean updateContactsShortcuts(SQLiteDatabase db) {
            String selectWhere = LauncherProvider.buildOrWhereString(LauncherSettings.BaseLauncherColumns.ITEM_TYPE, new int[]{1});
            Cursor c = null;
            db.beginTransaction();
            try {
                try {
                    Cursor c2 = db.query(TAG_FAVORITES, new String[]{"_id", "intent"}, selectWhere, null, null, null, null);
                    if (c2 == null) {
                        db.endTransaction();
                        if (c2 != null) {
                            c2.close();
                        }
                        return false;
                    }
                    int idIndex = c2.getColumnIndex("_id");
                    int intentIndex = c2.getColumnIndex("intent");
                    while (c2.moveToNext()) {
                        long favoriteId = c2.getLong(idIndex);
                        String intentUri = c2.getString(intentIndex);
                        if (intentUri != null) {
                            try {
                                Intent intent = Intent.parseUri(intentUri, 0);
                                Log.d("Home", intent.toString());
                                Uri uri = intent.getData();
                                if (uri != null) {
                                    String data = uri.toString();
                                    if ("android.intent.action.VIEW".equals(intent.getAction()) || "com.android.contacts.action.QUICK_CONTACT".equals(intent.getAction())) {
                                        if (data.startsWith("content://contacts/people/") || data.startsWith("content://com.android.contacts/contacts/lookup/")) {
                                            Intent newIntent = new Intent("com.android.contacts.action.QUICK_CONTACT");
                                            newIntent.addFlags(268468224);
                                            newIntent.putExtra("com.android.launcher66.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION", true);
                                            newIntent.setData(uri);
                                            newIntent.setDataAndType(uri, newIntent.resolveType(this.mContext));
                                            ContentValues values = new ContentValues();
                                            values.put("intent", newIntent.toUri(0));
                                            String updateWhere = "_id=" + favoriteId;
                                            db.update(TAG_FAVORITES, values, updateWhere, null);
                                        }
                                    }
                                }
                            } catch (RuntimeException ex) {
                                Log.e(LauncherProvider.TAG, "Problem upgrading shortcut", ex);
                            } catch (URISyntaxException e) {
                                Log.e(LauncherProvider.TAG, "Problem upgrading shortcut", e);
                            }
                        }
                    }
                    db.setTransactionSuccessful();
                    db.endTransaction();
                    if (c2 != null) {
                        c2.close();
                    }
                    return true;
                } catch (SQLException ex2) {
                    Log.w(LauncherProvider.TAG, "Problem while upgrading contacts", ex2);
                    db.endTransaction();
                    if (0 != 0) {
                        c.close();
                    }
                    return false;
                }
            } catch (Throwable th) {
                db.endTransaction();
                if (0 != 0) {
                    c.close();
                }
                throw th;
            }
        }

        private void normalizeIcons(SQLiteDatabase db) {
            Log.d(LauncherProvider.TAG, "normalizing icons");
            db.beginTransaction();
            Cursor c = null;
            SQLiteStatement update = null;
            boolean logged = false;
            try {
                try {
                    update = db.compileStatement("UPDATE favorites SET icon=? WHERE _id=?");
                    c = db.rawQuery("SELECT _id, icon FROM favorites WHERE iconType=1", null);
                    int idIndex = c.getColumnIndexOrThrow("_id");
                    int iconIndex = c.getColumnIndexOrThrow("icon");
                    while (c.moveToNext()) {
                        long id = c.getLong(idIndex);
                        byte[] data = c.getBlob(iconIndex);
                        try {
                            Bitmap bitmap = Utilities.resampleIconBitmap(BitmapFactory.decodeByteArray(data, 0, data.length), this.mContext);
                            if (bitmap != null) {
                                update.bindLong(1, id);
                                byte[] data2 = ItemInfo.flattenBitmap(bitmap);
                                if (data2 != null) {
                                    update.bindBlob(2, data2);
                                    update.execute();
                                }
                                bitmap.recycle();
                            }
                        } catch (Exception e) {
                            if (!logged) {
                                Log.e(LauncherProvider.TAG, "Failed normalizing icon " + id, e);
                            } else {
                                Log.e(LauncherProvider.TAG, "Also failed normalizing icon " + id);
                            }
                            logged = true;
                        }
                    }
                    db.setTransactionSuccessful();
                    db.endTransaction();
                    if (update != null) {
                        update.close();
                    }
                    if (c != null) {
                        c.close();
                    }
                } catch (SQLException ex) {
                    Log.w(LauncherProvider.TAG, "Problem while allocating appWidgetIds for existing widgets", ex);
                    db.endTransaction();
                    if (update != null) {
                        update.close();
                    }
                    if (c != null) {
                        c.close();
                    }
                }
            } catch (Throwable th) {
                db.endTransaction();
                if (update != null) {
                    update.close();
                }
                if (c != null) {
                    c.close();
                }
                throw th;
            }
        }

        public long generateNewItemId() {
            if (this.mMaxItemId < 0) {
                throw new RuntimeException("Error: max item id was not initialized");
            }
            this.mMaxItemId++;
            return this.mMaxItemId;
        }

        public void updateMaxItemId(long id) {
            this.mMaxItemId = 1 + id;
        }

        private long initializeMaxItemId(SQLiteDatabase db) {
            Cursor c = db.rawQuery("SELECT MAX(_id) FROM favorites", null);
            long id = -1;
            if (c != null && c.moveToNext()) {
                id = c.getLong(0);
            }
            if (c != null) {
                c.close();
            }
            if (id == -1) {
                throw new RuntimeException("Error: could not query max item id");
            }
            return id;
        }

        public long generateNewScreenId() {
            if (this.mMaxScreenId < 0) {
                throw new RuntimeException("Error: max screen id was not initialized");
            }
            this.mMaxScreenId++;
            ArrayList<Long> workspaceScreens = Launcher.getModel().sBgWorkspaceScreens;
            if (workspaceScreens != null && workspaceScreens.contains(mMaxScreenId)) {
                Long maxScreen = Math.abs(Collections.max(workspaceScreens));
                if (maxScreen == 302) {
                    this.mMaxScreenId = 1;
                } else {
                    this.mMaxScreenId = maxScreen + 1;
                } 
            }
            return this.mMaxScreenId;
        }

        public void updateMaxScreenId(long maxScreenId) {
            this.mMaxScreenId = maxScreenId;
        }

        private long initializeMaxScreenId(SQLiteDatabase db) {
            Cursor c = db.rawQuery("SELECT MAX(_id) FROM workspaceScreens", null);
            long id = -1;
            if (c != null && c.moveToNext()) {
                id = c.getLong(0);
            }
            if (c != null) {
                c.close();
            }
            if (id == -1) {
                throw new RuntimeException("Error: could not query max screen id");
            }
            return id;
        }

        private void convertWidgets(SQLiteDatabase db) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.mContext);
            int[] bindSources = {1000, 1002, 1001};
            String selectWhere = LauncherProvider.buildOrWhereString(LauncherSettings.BaseLauncherColumns.ITEM_TYPE, bindSources);
            Cursor c = null;
            db.beginTransaction();
            try {
                try {
                    c = db.query(TAG_FAVORITES, new String[]{"_id", LauncherSettings.BaseLauncherColumns.ITEM_TYPE}, selectWhere, null, null, null, null);
                    ContentValues values = new ContentValues();
                    while (c != null && c.moveToNext()) {
                        long favoriteId = c.getLong(0);
                        int favoriteType = c.getInt(1);
                        try {
                            int appWidgetId = this.mAppWidgetHost.allocateAppWidgetId();
                            values.clear();
                            values.put(LauncherSettings.BaseLauncherColumns.ITEM_TYPE, (Integer) 4);
                            values.put("appWidgetId", Integer.valueOf(appWidgetId));
                            if (favoriteType == 1001) {
                                values.put("spanX", (Integer) 4);
                                values.put("spanY", (Integer) 1);
                            } else {
                                values.put("spanX", (Integer) 2);
                                values.put("spanY", (Integer) 2);
                            }
                            String updateWhere = "_id=" + favoriteId;
                            db.update(TAG_FAVORITES, values, updateWhere, null);
                            if (favoriteType == 1000) {
                                appWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, new ComponentName("com.android.alarmclock", "com.android.alarmclock.AnalogAppWidgetProvider"));
                            } else if (favoriteType == 1002) {
                                appWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, new ComponentName("com.android.camera", "com.android.camera.PhotoAppWidgetProvider"));
                            } else if (favoriteType == 1001) {
                                appWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, getSearchWidgetProvider());
                            }
                        } catch (RuntimeException ex) {
                            Log.e(LauncherProvider.TAG, "Problem allocating appWidgetId", ex);
                        }
                    }
                    db.setTransactionSuccessful();
                } catch (SQLException ex2) {
                    Log.w(LauncherProvider.TAG, "Problem while allocating appWidgetIds for existing widgets", ex2);
                    db.endTransaction();
                    if (c != null) {
                        c.close();
                    }
                }
                this.mMaxItemId = initializeMaxItemId(db);
            } finally {
                db.endTransaction();
                if (c != null) {
                    c.close();
                }
            }
        }

        private static final void beginDocument(XmlPullParser parser, String firstElementName) throws XmlPullParserException, IOException {
            int type;
            do {
                type = parser.next();
                if (type == 2) {
                    break;
                }
            } while (type != 1);
            if (type != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (!parser.getName().equals(firstElementName)) {
                throw new XmlPullParserException("Unexpected start tag: found " + parser.getName() + ", expected " + firstElementName);
            }
        }

        public int loadFavorites(SQLiteDatabase db, int workspaceResourceId) {
            String title;
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            ContentValues values = new ContentValues();
            PackageManager packageManager = this.mContext.getPackageManager();
            int i = 0;
            try {
                XmlResourceParser parser = this.mContext.getResources().getXml(workspaceResourceId);
                AttributeSet attrs = Xml.asAttributeSet(parser);
                beginDocument(parser, TAG_FAVORITES);
                int depth = parser.getDepth();
                loop0: while (true) {
                    int type = parser.next();
                    if ((type == 3 && parser.getDepth() <= depth) || type == 1) {
                        break;
                    }
                    if (type == 2) {
                        boolean added = false;
                        String name = parser.getName();
                        if (TAG_INCLUDE.equals(name)) {
                            TypedArray a = this.mContext.obtainStyledAttributes(attrs, R.styleable.Include);
                            int resId = a.getResourceId(R.styleable.Include_workspace, 0);
                            if (resId != 0 && resId != workspaceResourceId) {
                                i += loadFavorites(db, resId);
                                this.mMaxItemId = -1L;
                            } else {
                                Log.w(LauncherProvider.TAG, String.format("Skipping <include workspace=0x%08x>", Integer.valueOf(resId)));
                            }
                            a.recycle();
                        } else {
                            TypedArray a2 = this.mContext.obtainStyledAttributes(attrs, R.styleable.Favorite);
                            long container = -100;
                            if (a2.hasValue(R.styleable.Favorite_container)) {
                                container = Long.valueOf(a2.getString(R.styleable.Favorite_container)).longValue();
                            }
                            String screen = a2.getString(R.styleable.Favorite_screen);
                            String x = a2.getString(R.styleable.Favorite_x);
                            String y = a2.getString(R.styleable.Favorite_y);
                            values.clear();
                            values.put(Stats.EXTRA_CONTAINER, Long.valueOf(container));
                            values.put(Stats.EXTRA_SCREEN, screen);
                            values.put(Stats.EXTRA_CELLX, x);
                            values.put(Stats.EXTRA_CELLY, y);
                            if (TAG_FAVORITE.equals(name)) {
                                added = addAppShortcut(db, values, a2, packageManager, intent) >= 0;
                            } else if (TAG_SEARCH.equals(name)) {
                                added = addSearchWidget(db, values);
                            } else if (TAG_CLOCK.equals(name)) {
                                added = addClockWidget(db, values);
                            } else if (TAG_APPWIDGET.equals(name)) {
                                added = addAppWidget(parser, attrs, type, db, values, a2, packageManager);
                            } else if (TAG_SHORTCUT.equals(name)) {
                                added = addUriShortcut(db, values, a2) >= 0;
                            } else if (TAG_FOLDER.equals(name)) {
                                int titleResId = a2.getResourceId(R.styleable.Favorite_favTitle, -1);
                                if (titleResId != -1) {
                                    title = this.mContext.getResources().getString(titleResId);
                                } else {
                                    title = this.mContext.getResources().getString(R.string.folder_name);
                                }
                                values.put("title", title);
                                long folderId = addFolder(db, values);
                                added = folderId >= 0;
                                ArrayList<Long> folderItems = new ArrayList<>();
                                int folderDepth = parser.getDepth();
                                while (true) {
                                    int type2 = parser.next();
                                    if (type2 != 3 || parser.getDepth() > folderDepth) {
                                        if (type2 == 2) {
                                            String folder_item_name = parser.getName();
                                            TypedArray ar = this.mContext.obtainStyledAttributes(attrs, R.styleable.Favorite);
                                            values.clear();
                                            values.put(Stats.EXTRA_CONTAINER, Long.valueOf(folderId));
                                            if (TAG_FAVORITE.equals(folder_item_name) && folderId >= 0) {
                                                long id = addAppShortcut(db, values, ar, packageManager, intent);
                                                if (id >= 0) {
                                                    folderItems.add(Long.valueOf(id));
                                                }
                                            } else {
                                                if (!TAG_SHORTCUT.equals(folder_item_name) || folderId < 0) {
                                                    break loop0;
                                                }
                                                long id2 = addUriShortcut(db, values, ar);
                                                if (id2 >= 0) {
                                                    folderItems.add(Long.valueOf(id2));
                                                }
                                            }
                                            ar.recycle();
                                        }
                                    } else if (folderItems.size() < 2 && folderId >= 0) {
                                        LauncherProvider.deleteId(db, folderId);
                                        if (folderItems.size() > 0) {
                                            LauncherProvider.deleteId(db, folderItems.get(0).longValue());
                                        }
                                        added = false;
                                    }
                                }
                            }
                            if (added) {
                                i++;
                            }
                            a2.recycle();
                        }
                    }
                }
                throw new RuntimeException("Folders can contain only shortcuts");
            } catch (IOException e) {
                Log.w(LauncherProvider.TAG, "Got exception parsing favorites.", e);
            } catch (RuntimeException e2) {
                Log.w(LauncherProvider.TAG, "Got exception parsing favorites.", e2);
            } catch (XmlPullParserException e3) {
                Log.w(LauncherProvider.TAG, "Got exception parsing favorites.", e3);
            }
            if (this.mMaxItemId == -1) {
                this.mMaxItemId = initializeMaxItemId(db);
            }
            return i;
        }

        private long addAppShortcut(SQLiteDatabase db, ContentValues values, TypedArray a, PackageManager packageManager, Intent intent) {
            ComponentName cn2;
            ActivityInfo info;
            long id = -1;
            String packageName = a.getString(R.styleable.Favorite_packageName);
            String className = a.getString(R.styleable.Favorite_className);
            try {
                try {
                    cn2 = new ComponentName(packageName, className);
                    info = packageManager.getActivityInfo(cn2, 0);
                } catch (PackageManager.NameNotFoundException e) {
                    String[] packages = packageManager.currentToCanonicalPackageNames(new String[]{packageName});
                    cn2 = new ComponentName(packages[0], className);
                    info = packageManager.getActivityInfo(cn2, 0);
                }
                id = generateNewItemId();
                intent.setComponent(cn2);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                values.put("intent", intent.toUri(0));
                values.put("title", info.loadLabel(packageManager).toString());
                values.put(LauncherSettings.BaseLauncherColumns.ITEM_TYPE, (Integer) 0);
                values.put("spanX", (Integer) 1);
                values.put("spanY", (Integer) 1);
                values.put("_id", Long.valueOf(generateNewItemId()));
                if (LauncherProvider.dbInsertAndCheck(this, db, TAG_FAVORITES, null, values) < 0) {
                    return -1L;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w(LauncherProvider.TAG, "Unable to add favorite: " + packageName + "/" + className, e2);
            }
            return id;
        }

        private long addFolder(SQLiteDatabase db, ContentValues values) {
            values.put(LauncherSettings.BaseLauncherColumns.ITEM_TYPE, (Integer) 2);
            values.put("spanX", (Integer) 1);
            values.put("spanY", (Integer) 1);
            long id = generateNewItemId();
            values.put("_id", Long.valueOf(id));
            if (LauncherProvider.dbInsertAndCheck(this, db, TAG_FAVORITES, null, values) <= 0) {
                return -1L;
            }
            return id;
        }

        private ComponentName getSearchWidgetProvider() {
            SearchManager searchManager = (SearchManager) this.mContext.getSystemService(Context.SEARCH_SERVICE);
            ComponentName searchComponent = searchManager.getGlobalSearchActivity();
            if (searchComponent == null) {
                return null;
            }
            return getProviderInPackage(searchComponent.getPackageName());
        }

        private ComponentName getProviderInPackage(String packageName) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.mContext);
            List<AppWidgetProviderInfo> providers = appWidgetManager.getInstalledProviders();
            if (providers == null) {
                return null;
            }
            int providerCount = providers.size();
            for (int i = 0; i < providerCount; i++) {
                ComponentName provider = providers.get(i).provider;
                if (provider != null && provider.getPackageName().equals(packageName)) {
                    return provider;
                }
            }
            return null;
        }

        private boolean addSearchWidget(SQLiteDatabase db, ContentValues values) {
            ComponentName cn2 = getSearchWidgetProvider();
            return addAppWidget(db, values, cn2, 4, 1, null);
        }

        private boolean addClockWidget(SQLiteDatabase db, ContentValues values) {
            ComponentName cn2 = new ComponentName("com.android.alarmclock", "com.android.alarmclock.AnalogAppWidgetProvider");
            return addAppWidget(db, values, cn2, 2, 2, null);
        }

        private boolean addAppWidget(XmlResourceParser parser, AttributeSet attrs, int type, SQLiteDatabase db, ContentValues values, TypedArray a, PackageManager packageManager) throws XmlPullParserException, IOException {
            String packageName = a.getString(R.styleable.Favorite_packageName);
            String className = a.getString(R.styleable.Favorite_className);
            if (packageName == null || className == null) {
                return false;
            }
            boolean hasPackage = true;
            ComponentName cn2 = new ComponentName(packageName, className);
            try {
                packageManager.getReceiverInfo(cn2, 0);
            } catch (Exception e) {
                String[] packages = packageManager.currentToCanonicalPackageNames(new String[]{packageName});
                cn2 = new ComponentName(packages[0], className);
                try {
                    packageManager.getReceiverInfo(cn2, 0);
                } catch (Exception e2) {
                    hasPackage = false;
                }
            }
            if (hasPackage) {
                int spanX = a.getInt(R.styleable.Favorite_spanX, 0);
                int spanY = a.getInt(R.styleable.Favorite_spanY, 0);
                Bundle extras = new Bundle();
                int widgetDepth = parser.getDepth();
                while (true) {
                    int type2 = parser.next();
                    if (type2 != 3 || parser.getDepth() > widgetDepth) {
                        if (type2 == 2) {
                            TypedArray ar = this.mContext.obtainStyledAttributes(attrs, R.styleable.Extra);
                            if (TAG_EXTRA.equals(parser.getName())) {
                                String key = ar.getString(R.styleable.Extra_key);
                                String value = ar.getString(R.styleable.Extra_value);
                                if (key == null || value == null) {
                                    break;
                                }
                                extras.putString(key, value);
                                ar.recycle();
                            } else {
                                throw new RuntimeException("Widgets can contain only extras");
                            }
                        }
                    } else {
                        return addAppWidget(db, values, cn2, spanX, spanY, extras);
                    }
                }
                throw new RuntimeException("Widget extras must have a key and value");
            }
            return false;
        }

        private boolean addAppWidget(SQLiteDatabase db, ContentValues values, ComponentName cn2, int spanX, int spanY, Bundle extras) {
            boolean allocatedAppWidgets = false;
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.mContext);
            try {
                int appWidgetId = this.mAppWidgetHost.allocateAppWidgetId();
                values.put(LauncherSettings.BaseLauncherColumns.ITEM_TYPE, (Integer) 4);
                values.put("spanX", Integer.valueOf(spanX));
                values.put("spanY", Integer.valueOf(spanY));
                values.put("appWidgetId", Integer.valueOf(appWidgetId));
                values.put(LauncherSettings.Favorites.APPWIDGET_PROVIDER, cn2.flattenToString());
                values.put("_id", Long.valueOf(generateNewItemId()));
                LauncherProvider.dbInsertAndCheck(this, db, TAG_FAVORITES, null, values);
                allocatedAppWidgets = true;
                appWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, cn2);
                if (extras != null && !extras.isEmpty()) {
                    Intent intent = new Intent(LauncherProvider.ACTION_APPWIDGET_DEFAULT_WORKSPACE_CONFIGURE);
                    intent.setComponent(cn2);
                    intent.putExtras(extras);
                    intent.putExtra("appWidgetId", appWidgetId);
                    this.mContext.sendBroadcast(intent);
                }
            } catch (RuntimeException ex) {
                Log.e(LauncherProvider.TAG, "Problem allocating appWidgetId", ex);
            }
            return allocatedAppWidgets;
        }

        private long addUriShortcut(SQLiteDatabase db, ContentValues values, TypedArray a) {
            Resources r = this.mContext.getResources();
            final int iconResId = a.getResourceId(R.styleable.Favorite_icon, 0);
            final int titleResId = a.getResourceId(R.styleable.Favorite_favTitle, 0);
            String uri = null;
            try {
                uri = a.getString(R.styleable.Favorite_uri);
                Intent intent = Intent.parseUri(uri, 0);
                if (iconResId == 0 || titleResId == 0) {
                    Log.w(LauncherProvider.TAG, "Shortcut is missing title or icon resource ID");
                    return -1L;
                }
                long id = generateNewItemId();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                values.put("intent", intent.toUri(0));
                values.put("title", r.getString(titleResId));
                values.put(LauncherSettings.BaseLauncherColumns.ITEM_TYPE, (Integer) 1);
                values.put("spanX", (Integer) 1);
                values.put("spanY", (Integer) 1);
                values.put(LauncherSettings.BaseLauncherColumns.ICON_TYPE, (Integer) 0);
                values.put(LauncherSettings.BaseLauncherColumns.ICON_PACKAGE, this.mContext.getPackageName());
                values.put("iconResource", r.getResourceName(iconResId));
                values.put("_id", Long.valueOf(id));
                if (LauncherProvider.dbInsertAndCheck(this, db, TAG_FAVORITES, null, values) < 0) {
                    return -1L;
                }
                return id;
            } catch (URISyntaxException e) {
                Log.w(LauncherProvider.TAG, "Shortcut has malformed uri: " + uri);
                return -1L;
            }
        }
    }

    static String buildOrWhereString(String column, int[] values) {
        StringBuilder selectWhere = new StringBuilder();
        for (int i = values.length - 1; i >= 0; i--) {
            selectWhere.append(column).append("=").append(values[i]);
            if (i > 0) {
                selectWhere.append(" OR ");
            }
        }
        return selectWhere.toString();
    }

    static class SqlArguments {
        public final String[] args;
        public final String table;
        public final String where;

        SqlArguments(Uri url, String where, String[] args) {
            if (url.getPathSegments().size() == 1) {
                this.table = url.getPathSegments().get(0);
                this.where = where;
                this.args = args;
            } else {
                if (url.getPathSegments().size() != 2) {
                    throw new IllegalArgumentException("Invalid URI: " + url);
                }
                if (!TextUtils.isEmpty(where)) {
                    throw new UnsupportedOperationException("WHERE clause not supported: " + url);
                }
                this.table = url.getPathSegments().get(0);
                this.where = "_id=" + ContentUris.parseId(url);
                this.args = null;
            }
        }

        SqlArguments(Uri url) {
            if (url.getPathSegments().size() == 1) {
                this.table = url.getPathSegments().get(0);
                this.where = null;
                this.args = null;
                return;
            }
            throw new IllegalArgumentException("Invalid URI: " + url);
        }
    }
}
