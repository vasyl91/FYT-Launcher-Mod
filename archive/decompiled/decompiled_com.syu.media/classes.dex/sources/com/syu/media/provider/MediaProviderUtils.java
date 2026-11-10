package com.syu.media.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import chip.FinalChip;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.MediaSource;
import com.syu.media.entities.RadioSource;
import com.syu.media.entities.VideoSource;
import com.syu.radio.Radio;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"Lcom/syu/media/provider/MediaProviderUtils;", FinalChip.BSP_PLATFORM_Null, "Landroid/content/ContentResolver;", "resolver", FinalChip.BSP_PLATFORM_Null, Radio.URL, "Lcom/syu/media/entities/RadioSource;", "queryRadio", "Lcom/syu/media/entities/MediaSource;", "source", FinalChip.BSP_PLATFORM_Null, "update", FinalChip.BSP_PLATFORM_Null, "playListRadios", "Lcom/syu/media/entities/AudioSource;", "playListAudios", "allAudios", "favoriteAudios", "Lcom/syu/media/entities/VideoSource;", "allVideos", "favoriteVideos", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class MediaProviderUtils {
    public static final MediaProviderUtils INSTANCE = new MediaProviderUtils();

    public final List<AudioSource> allAudios(ContentResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return a(this, resolver, null, null, 14);
    }

    public final List<VideoSource> allVideos(ContentResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return b(this, resolver, null, null, 14);
    }

    public final List<AudioSource> favoriteAudios(ContentResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return a(this, resolver, "favorite=?", new String[]{"1"}, 2);
    }

    public final List<VideoSource> favoriteVideos(ContentResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return b(this, resolver, "favorite=?", new String[]{"1"}, 2);
    }

    public final List<AudioSource> playListAudios(ContentResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Cursor cursorQuery = resolver.query(Uri.parse("content://com.syu.media/list/1"), null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    if (cursorQuery.getCount() > 0 && cursorQuery.getColumnCount() > 0) {
                        do {
                            AudioSource audioSource = new AudioSource();
                            audioSource.setId(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))));
                            audioSource.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                            audioSource.setDisplayName(cursorQuery.getString(cursorQuery.getColumnIndex(Media.DISPLAY_NAME)));
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex(Media.PATH));
                            Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndex(Media.PATH))");
                            audioSource.setPath(string);
                            audioSource.setArtist(cursorQuery.getString(cursorQuery.getColumnIndex(Media.ARTIST)));
                            audioSource.setAlbum(cursorQuery.getString(cursorQuery.getColumnIndex(Media.ALBUM)));
                            audioSource.setDuration(cursorQuery.getInt(cursorQuery.getColumnIndex(Media.DURATION)));
                            boolean z = true;
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex("favorite")) != 1) {
                                z = false;
                            }
                            audioSource.setFavorite(z);
                            audioSource.setLength(cursorQuery.getInt(cursorQuery.getColumnIndex(Media.LENGTH)));
                            arrayList.add(audioSource);
                        } while (cursorQuery.moveToNext());
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, (Throwable) null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    public final List<RadioSource> playListRadios(ContentResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Cursor cursorQuery = resolver.query(Uri.parse("content://com.syu.media/list/8"), null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    if (cursorQuery.getCount() > 0 && cursorQuery.getColumnCount() > 0) {
                        do {
                            RadioSource radioSource = new RadioSource();
                            radioSource.setId(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))));
                            radioSource.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                            radioSource.setDisplayName(cursorQuery.getString(cursorQuery.getColumnIndex(Media.DISPLAY_NAME)));
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex(Media.PATH));
                            Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndex(Media.PATH))");
                            radioSource.setPath(string);
                            radioSource.setArtist(cursorQuery.getString(cursorQuery.getColumnIndex(Media.ARTIST)));
                            radioSource.setAlbum(cursorQuery.getString(cursorQuery.getColumnIndex(Media.ALBUM)));
                            radioSource.setDuration(cursorQuery.getInt(cursorQuery.getColumnIndex(Media.DURATION)));
                            boolean z = true;
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex("favorite")) != 1) {
                                z = false;
                            }
                            radioSource.setFavorite(z);
                            radioSource.setLength(cursorQuery.getInt(cursorQuery.getColumnIndex(Media.LENGTH)));
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(Media.TYPE));
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(getColumnIndex(Media.TYPE))");
                            radioSource.setType(string2);
                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(Media.COUNTRY));
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(getColumnIndex(Media.COUNTRY))");
                            radioSource.setCountry(string3);
                            String string4 = cursorQuery.getString(cursorQuery.getColumnIndex(Media.LOCAL));
                            Intrinsics.checkNotNullExpressionValue(string4, "getString(getColumnIndex(Media.LOCAL))");
                            radioSource.setLocal(string4);
                            String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("freq"));
                            Intrinsics.checkNotNullExpressionValue(string5, "getString(getColumnIndex(Media.FREQ))");
                            radioSource.setFreqTitle(string5);
                            String string6 = cursorQuery.getString(cursorQuery.getColumnIndex(Media.ICON));
                            Intrinsics.checkNotNullExpressionValue(string6, "getString(getColumnIndex(Media.ICON))");
                            radioSource.setIcon(string6);
                            arrayList.add(radioSource);
                        } while (cursorQuery.moveToNext());
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, (Throwable) null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    public final RadioSource queryRadio(ContentResolver resolver, String url) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(url, Radio.URL);
        Cursor cursorQuery = resolver.query(Uri.parse(MediaConstant.ONLINE_TABLE_URI), null, "path=?", new String[]{url}, "_id");
        ArrayList arrayList = new ArrayList();
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    Log.e("music", "------------>> columnCount  " + cursorQuery.getColumnCount());
                    if (cursorQuery.getColumnCount() > 0) {
                        do {
                            RadioSource radioSource = new RadioSource();
                            radioSource.setId(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))));
                            radioSource.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                            radioSource.setDisplayName(cursorQuery.getString(cursorQuery.getColumnIndex(Media.DISPLAY_NAME)));
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex(Media.PATH));
                            Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndex(Media.PATH))");
                            radioSource.setPath(string);
                            radioSource.setArtist(cursorQuery.getString(cursorQuery.getColumnIndex(Media.ARTIST)));
                            radioSource.setAlbum(cursorQuery.getString(cursorQuery.getColumnIndex(Media.ALBUM)));
                            radioSource.setDuration(cursorQuery.getInt(cursorQuery.getColumnIndex(Media.DURATION)));
                            radioSource.setFavorite(cursorQuery.getInt(cursorQuery.getColumnIndex("favorite")) == 1);
                            radioSource.setLength(cursorQuery.getInt(cursorQuery.getColumnIndex(Media.LENGTH)));
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(Media.TYPE));
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(getColumnIndex(Media.TYPE))");
                            radioSource.setType(string2);
                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(Media.COUNTRY));
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(getColumnIndex(Media.COUNTRY))");
                            radioSource.setCountry(string3);
                            String string4 = cursorQuery.getString(cursorQuery.getColumnIndex(Media.LOCAL));
                            Intrinsics.checkNotNullExpressionValue(string4, "getString(getColumnIndex(Media.LOCAL))");
                            radioSource.setLocal(string4);
                            String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("freq"));
                            Intrinsics.checkNotNullExpressionValue(string5, "getString(getColumnIndex(Media.FREQ))");
                            radioSource.setFreqTitle(string5);
                            String string6 = cursorQuery.getString(cursorQuery.getColumnIndex(Media.ICON));
                            Intrinsics.checkNotNullExpressionValue(string6, "getString(getColumnIndex(Media.ICON))");
                            radioSource.setIcon(string6);
                            arrayList.add(radioSource);
                        } while (cursorQuery.moveToNext());
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, (Throwable) null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (RadioSource) arrayList.get(0);
    }

    public final void update(ContentResolver resolver, MediaSource source) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(source, "source");
        Uri uri = Uri.parse(MediaConstant.SONG_TABLE_URI);
        ContentValues contentValues = new ContentValues();
        contentValues.put("favorite", Boolean.valueOf(source.getFavorite()));
        try {
            resolver.update(uri, contentValues, "_id=? AND path=?", new String[]{String.valueOf(source.getId()), source.getCom.syu.media.provider.Media.PATH java.lang.String()});
        } catch (Exception unused) {
        }
    }

    public static ArrayList a(MediaProviderUtils mediaProviderUtils, ContentResolver contentResolver, String str, String[] strArr, int i) {
        String str2 = (i & 4) != 0 ? null : str;
        String[] strArr2 = (i & 8) != 0 ? null : strArr;
        String str3 = (i & 16) != 0 ? null : "_id";
        mediaProviderUtils.getClass();
        Cursor cursorQuery = contentResolver.query(Uri.parse(MediaConstant.SONG_TABLE_URI), null, str2, strArr2, str3);
        ArrayList arrayList = new ArrayList();
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    if (cursorQuery.getColumnCount() > 0) {
                        do {
                            AudioSource audioSource = new AudioSource();
                            audioSource.setId(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))));
                            audioSource.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                            audioSource.setDisplayName(cursorQuery.getString(cursorQuery.getColumnIndex(Media.DISPLAY_NAME)));
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex(Media.PATH));
                            Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndex(Media.PATH))");
                            audioSource.setPath(string);
                            audioSource.setArtist(cursorQuery.getString(cursorQuery.getColumnIndex(Media.ARTIST)));
                            audioSource.setAlbum(cursorQuery.getString(cursorQuery.getColumnIndex(Media.ALBUM)));
                            audioSource.setDuration(cursorQuery.getInt(cursorQuery.getColumnIndex(Media.DURATION)));
                            boolean z = true;
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex("favorite")) != 1) {
                                z = false;
                            }
                            audioSource.setFavorite(z);
                            audioSource.setLength(cursorQuery.getInt(cursorQuery.getColumnIndex(Media.LENGTH)));
                            arrayList.add(audioSource);
                        } while (cursorQuery.moveToNext());
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, (Throwable) null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    public static ArrayList b(MediaProviderUtils mediaProviderUtils, ContentResolver contentResolver, String str, String[] strArr, int i) {
        String str2 = (i & 4) != 0 ? null : str;
        String[] strArr2 = (i & 8) != 0 ? null : strArr;
        String str3 = (i & 16) != 0 ? null : "_id";
        mediaProviderUtils.getClass();
        Cursor cursorQuery = contentResolver.query(Uri.parse(MediaConstant.VIDEO_TABLE_URI), null, str2, strArr2, str3);
        ArrayList arrayList = new ArrayList();
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    Log.e("music", "------------>> columnCount  " + cursorQuery.getColumnCount());
                    if (cursorQuery.getColumnCount() > 0) {
                        do {
                            VideoSource videoSource = new VideoSource(cursorQuery.getInt(cursorQuery.getColumnIndex(Media.VIDEO_WIDTH)), cursorQuery.getInt(cursorQuery.getColumnIndex(Media.VIDEO_HEIGHT)));
                            videoSource.setId(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))));
                            videoSource.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                            videoSource.setDisplayName(cursorQuery.getString(cursorQuery.getColumnIndex(Media.DISPLAY_NAME)));
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex(Media.PATH));
                            Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndex(Media.PATH))");
                            videoSource.setPath(string);
                            videoSource.setArtist(cursorQuery.getString(cursorQuery.getColumnIndex(Media.ARTIST)));
                            videoSource.setAlbum(cursorQuery.getString(cursorQuery.getColumnIndex(Media.ALBUM)));
                            videoSource.setDuration(cursorQuery.getInt(cursorQuery.getColumnIndex(Media.DURATION)));
                            boolean z = true;
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex("favorite")) != 1) {
                                z = false;
                            }
                            videoSource.setFavorite(z);
                            videoSource.setLength(cursorQuery.getInt(cursorQuery.getColumnIndex(Media.LENGTH)));
                            arrayList.add(videoSource);
                        } while (cursorQuery.moveToNext());
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, (Throwable) null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        return arrayList;
    }
}
