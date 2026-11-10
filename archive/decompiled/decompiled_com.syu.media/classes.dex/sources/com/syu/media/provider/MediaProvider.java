package com.syu.media.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQueryBuilder;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.database.MediaDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016JQ\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J3\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J=\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/syu/media/provider/MediaProvider;", "Landroid/content/ContentProvider;", FinalChip.BSP_PLATFORM_Null, "onCreate", "Landroid/net/Uri;", "uri", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "Landroid/content/ContentValues;", "values", "insert", FinalChip.BSP_PLATFORM_Null, "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "<init>", "()V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class MediaProvider extends ContentProvider {
    public final UriMatcher a;
    public MediaDatabase b;

    public MediaProvider() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI(MediaConstant.AUTHORITY, Media.SONG_TABLE, 1);
        uriMatcher.addURI(MediaConstant.AUTHORITY, "list/#", 2);
        uriMatcher.addURI(MediaConstant.AUTHORITY, Media.VIDEO_TABLE, 3);
        uriMatcher.addURI(MediaConstant.AUTHORITY, "Folder/#", 4);
        uriMatcher.addURI(MediaConstant.AUTHORITY, Media.ONLINE_TABLE, 5);
        this.a = uriMatcher;
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        SupportSQLiteOpenHelper openHelper;
        SupportSQLiteDatabase readableDatabase;
        MediaDatabase mediaDatabase = this.b;
        if (mediaDatabase == null || (openHelper = mediaDatabase.getOpenHelper()) == null || (readableDatabase = openHelper.getReadableDatabase()) == null) {
            return null;
        }
        SupportSQLiteQueryBuilder supportSQLiteQueryBuilderBuilder = SupportSQLiteQueryBuilder.builder(str);
        if (strArr != null) {
            supportSQLiteQueryBuilderBuilder.columns(strArr);
        }
        boolean z = false;
        if (str2.length() > 0) {
            Intrinsics.checkNotNull(strArr2);
            supportSQLiteQueryBuilderBuilder.selection(str2, strArr2);
        }
        if (str3 != null) {
            if (str3.length() > 0) {
                z = true;
            }
        }
        if (z) {
            supportSQLiteQueryBuilderBuilder.orderBy(str3);
        }
        return readableDatabase.query(supportSQLiteQueryBuilderBuilder.create());
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String str;
        MediaDatabase mediaDatabase;
        SupportSQLiteOpenHelper openHelper;
        SupportSQLiteDatabase writableDatabase;
        Intrinsics.checkNotNullParameter(uri, "uri");
        int iMatch = this.a.match(uri);
        if (iMatch == 1) {
            str = Media.SONG_TABLE;
        } else if (iMatch != 3) {
            str = iMatch != 5 ? null : Media.ONLINE_TABLE;
        } else {
            str = Media.VIDEO_TABLE;
        }
        int iDelete = 0;
        if (str != null && (mediaDatabase = this.b) != null && (openHelper = mediaDatabase.getOpenHelper()) != null && (writableDatabase = openHelper.getWritableDatabase()) != null) {
            writableDatabase.beginTransaction();
            try {
                try {
                    iDelete = writableDatabase.delete(str, selection, selectionArgs);
                    writableDatabase.setTransactionSuccessful();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                writableDatabase.endTransaction();
            }
        }
        return iDelete;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        String str;
        long jInsert;
        MediaDatabase mediaDatabase;
        SupportSQLiteOpenHelper openHelper;
        SupportSQLiteDatabase writableDatabase;
        Intrinsics.checkNotNullParameter(uri, "uri");
        int iMatch = this.a.match(uri);
        if (iMatch == 1) {
            str = Media.SONG_TABLE;
        } else if (iMatch != 3) {
            str = iMatch != 5 ? null : Media.ONLINE_TABLE;
        } else {
            str = Media.VIDEO_TABLE;
        }
        if (str == null || (mediaDatabase = this.b) == null || (openHelper = mediaDatabase.getOpenHelper()) == null || (writableDatabase = openHelper.getWritableDatabase()) == null) {
            jInsert = -1;
        } else {
            writableDatabase.beginTransaction();
            try {
                try {
                    jInsert = writableDatabase.insert(str, 5, values);
                    try {
                        writableDatabase.setTransactionSuccessful();
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                jInsert = -1;
            }
            writableDatabase.endTransaction();
        }
        if (jInsert == -1) {
            return null;
        }
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.b = MediaDatabase.INSTANCE.getInstance();
        Log.e("test", "MediaProvider onCreate ---------------->> " + (this.b != null));
        return this.b != null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SupportSQLiteOpenHelper openHelper;
        SupportSQLiteDatabase readableDatabase;
        SupportSQLiteOpenHelper openHelper2;
        SupportSQLiteDatabase readableDatabase2;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Log.e("music", "------------>> MediaProvider query uri:  " + uri + XmlConsts.CHAR_SPACE + this.a.match(uri));
        if (this.b == null) {
            this.b = MediaDatabase.INSTANCE.getInstance();
        }
        if (selection == null) {
            selection = FinalChip.BSP_PLATFORM_Null;
        }
        String str = selection;
        int iMatch = this.a.match(uri);
        if (iMatch == 1) {
            return a(Media.SONG_TABLE, projection, str, selectionArgs, sortOrder);
        }
        if (iMatch == 2) {
            Log.e("music", "00 ------------>> uri.lastPathSegment  " + uri.getLastPathSegment());
            String lastPathSegment = uri.getLastPathSegment();
            if (Intrinsics.areEqual(lastPathSegment, "1")) {
                String lastPathSegment2 = uri.getLastPathSegment();
                Intrinsics.checkNotNullExpressionValue(lastPathSegment2, "uri.lastPathSegment");
                String str2 = "SELECT audio._id, audio.title, audio.artist, audio.album, audio.displayName, audio.path, audio.length, audio.favorite, audio.duration FROM song audio, PlaylistAudioCrossRef ref WHERE audio._id = ref._id AND ref.playlist_id=" + lastPathSegment2 + " ORDER BY audio._id";
                MediaDatabase mediaDatabase = this.b;
                if (mediaDatabase != null && (openHelper2 = mediaDatabase.getOpenHelper()) != null && (readableDatabase2 = openHelper2.getReadableDatabase()) != null) {
                    return readableDatabase2.query(str2);
                }
            } else if (Intrinsics.areEqual(lastPathSegment, "8")) {
                String lastPathSegment3 = uri.getLastPathSegment();
                Intrinsics.checkNotNullExpressionValue(lastPathSegment3, "uri.lastPathSegment");
                String str3 = "SELECT entry._id, entry.title, entry.artist, entry.album, entry.displayName, entry.path, entry.length, entry.favorite, entry.duration, entry.type, entry.country, entry.local, entry.freq, entry.icon FROM radio entry, PlaylistRadioCrossRef ref WHERE entry._id = ref._id AND ref.playlist_id=" + lastPathSegment3 + " ORDER BY entry._id";
                MediaDatabase mediaDatabase2 = this.b;
                if (mediaDatabase2 != null && (openHelper = mediaDatabase2.getOpenHelper()) != null && (readableDatabase = openHelper.getReadableDatabase()) != null) {
                    return readableDatabase.query(str3);
                }
            }
        } else {
            if (iMatch == 3) {
                return a(Media.SONG_TABLE, projection, str, selectionArgs, sortOrder);
            }
            if (iMatch == 5) {
                return a(Media.ONLINE_TABLE, projection, str, selectionArgs, sortOrder);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        String str;
        MediaDatabase mediaDatabase;
        SupportSQLiteOpenHelper openHelper;
        SupportSQLiteDatabase writableDatabase;
        Intrinsics.checkNotNullParameter(uri, "uri");
        int iMatch = this.a.match(uri);
        if (iMatch == 1) {
            str = Media.SONG_TABLE;
        } else if (iMatch != 3) {
            str = iMatch != 5 ? null : Media.ONLINE_TABLE;
        } else {
            str = Media.VIDEO_TABLE;
        }
        String str2 = str;
        int iUpdate = 0;
        if (str2 != null && (mediaDatabase = this.b) != null && (openHelper = mediaDatabase.getOpenHelper()) != null && (writableDatabase = openHelper.getWritableDatabase()) != null) {
            writableDatabase.beginTransaction();
            try {
                try {
                    iUpdate = writableDatabase.update(str2, 5, values, selection, selectionArgs);
                    writableDatabase.setTransactionSuccessful();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                writableDatabase.endTransaction();
            }
        }
        return iUpdate;
    }
}
