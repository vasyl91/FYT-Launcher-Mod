package com.syu.radio.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.syu.radio.entities.RadioStation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/syu/radio/provider/RadioProviderUtils;", "", "Landroid/content/ContentResolver;", "resolver", "", "freq", "", "city", "", "Lcom/syu/radio/entities/RadioStation;", "queryByCityAndFreq", "queryLocalAssert", "station", "", "update", "findRadioByCityAndFreq", "favoritesByCity", "radiolib_release"}, k = 1, mv = {1, 7, 1})
public final class RadioProviderUtils {
    public static final RadioProviderUtils INSTANCE = new RadioProviderUtils();

    public final List<RadioStation> favoritesByCity(ContentResolver resolver, String city) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(city, "city");
        return a(this, resolver, "city LIKE ? || '%' AND favorite=?", new String[]{city, "1"});
    }

    public final List<RadioStation> findRadioByCityAndFreq(ContentResolver resolver, String city, int freq) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(city, "city");
        return a(this, resolver, "city LIKE ? || '%' AND freq=?", new String[]{city, String.valueOf(freq)});
    }

    public final List<RadioStation> queryByCityAndFreq(ContentResolver resolver, int freq, String city) throws IOException {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(city, "city");
        Cursor cursorQuery = resolver.query(Uri.parse("content://com.syu.radio/city_station/" + city + '/' + freq), null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    if (cursorQuery.getColumnCount() > 0) {
                        do {
                            RadioStation radioStation = new RadioStation();
                            radioStation.setId(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))));
                            radioStation.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                            radioStation.setFreq(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("freq"))));
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("city"));
                            Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndex(Radio.CITY))");
                            radioStation.setCity(string);
                            radioStation.setFavorite(cursorQuery.getInt(cursorQuery.getColumnIndex("favorite")) == 1);
                            int columnIndex = cursorQuery.getColumnIndex("cover_path");
                            if (columnIndex >= 0) {
                                radioStation.setCover(cursorQuery.getString(columnIndex));
                            }
                            int columnIndex2 = cursorQuery.getColumnIndex("url");
                            if (columnIndex2 >= 0) {
                                radioStation.setUrl(cursorQuery.getString(columnIndex2));
                            }
                            int columnIndex3 = cursorQuery.getColumnIndex("online");
                            if (columnIndex3 >= 0) {
                                radioStation.setOnline(cursorQuery.getInt(columnIndex3) >= 0);
                            }
                            arrayList.add(radioStation);
                        } while (cursorQuery.moveToNext());
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
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

    public final List<RadioStation> queryLocalAssert(ContentResolver resolver) throws IOException {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Cursor cursorQuery = resolver.query(Uri.parse("content://com.syu.radio/local_assert"), null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    if (cursorQuery.getColumnCount() > 0) {
                        do {
                            RadioStation radioStation = new RadioStation();
                            radioStation.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                            radioStation.setFreq(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("freq"))));
                            radioStation.setCover(cursorQuery.getString(cursorQuery.getColumnIndex("cover_path")));
                            arrayList.add(radioStation);
                        } while (cursorQuery.moveToNext());
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
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

    public final void update(ContentResolver resolver, RadioStation station) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(station, "station");
        Uri uri = Uri.parse("content://com.syu.radio/city_station");
        ContentValues contentValues = new ContentValues();
        contentValues.put("favorite", Integer.valueOf(station.getFavorite() ? 1 : 0));
        try {
            resolver.update(uri, contentValues, "_id=? AND freq=?", new String[]{String.valueOf(station.getId()), String.valueOf(station.getFreq())});
        } catch (Exception unused) {
        }
    }

    public static ArrayList a(RadioProviderUtils radioProviderUtils, ContentResolver contentResolver, String str, String[] strArr) throws IOException {
        radioProviderUtils.getClass();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = contentResolver.query(Uri.parse("content://com.syu.radio/city_station"), null, str, strArr, "_id");
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    if (cursorQuery.getColumnCount() > 0) {
                        do {
                            RadioStation radioStation = new RadioStation();
                            radioStation.setId(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))));
                            radioStation.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                            radioStation.setFreq(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("freq"))));
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("city"));
                            Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndex(Radio.CITY))");
                            radioStation.setCity(string);
                            radioStation.setFavorite(cursorQuery.getInt(cursorQuery.getColumnIndex("favorite")) == 1);
                            int columnIndex = cursorQuery.getColumnIndex("cover_path");
                            if (columnIndex >= 0) {
                                radioStation.setCover(cursorQuery.getString(columnIndex));
                            }
                            int columnIndex2 = cursorQuery.getColumnIndex("url");
                            if (columnIndex2 >= 0) {
                                radioStation.setUrl(cursorQuery.getString(columnIndex2));
                            }
                            int columnIndex3 = cursorQuery.getColumnIndex("online");
                            if (columnIndex3 >= 0) {
                                radioStation.setOnline(cursorQuery.getInt(columnIndex3) >= 0);
                            }
                            arrayList.add(radioStation);
                        } while (cursorQuery.moveToNext());
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
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
