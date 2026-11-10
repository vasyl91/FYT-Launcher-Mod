package com.syu.radio.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQueryBuilder;
import com.syu.radio.database.RadioDatabase;
import com.syu.utils.MessageCursor;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016JQ\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J3\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J=\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/syu/radio/provider/RadioProvider;", "Landroid/content/ContentProvider;", "", "onCreate", "Landroid/net/Uri;", "uri", "", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "Landroid/content/ContentValues;", "values", "insert", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Lcom/syu/radio/database/RadioDatabase;", "a", "Lcom/syu/radio/database/RadioDatabase;", "getRadioDatabase", "()Lcom/syu/radio/database/RadioDatabase;", "setRadioDatabase", "(Lcom/syu/radio/database/RadioDatabase;)V", "radioDatabase", "<init>", "()V", "Companion", "radiolib_release"}, k = 1, mv = {1, 7, 1})
public final class RadioProvider extends ContentProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static MessageCursor c = new MessageCursor(new String[]{"freq", "cover_path", "title"});

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public RadioDatabase radioDatabase;
    public final UriMatcher b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/syu/radio/provider/RadioProvider$Companion;", "", "Lcom/syu/utils/MessageCursor;", "mLocalAssertCursor", "Lcom/syu/utils/MessageCursor;", "getMLocalAssertCursor", "()Lcom/syu/utils/MessageCursor;", "setMLocalAssertCursor", "(Lcom/syu/utils/MessageCursor;)V", "radiolib_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MessageCursor getMLocalAssertCursor() {
            return RadioProvider.c;
        }

        public final void setMLocalAssertCursor(MessageCursor messageCursor) {
            Intrinsics.checkNotNullParameter(messageCursor, "<set-?>");
            RadioProvider.c = messageCursor;
        }
    }

    public RadioProvider() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.syu.radio", "city_station", 1);
        uriMatcher.addURI("com.syu.radio", "city_station/*/#", 2);
        uriMatcher.addURI("com.syu.radio", "local_assert", 3);
        this.b = uriMatcher;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return -1;
    }

    public final RadioDatabase getRadioDatabase() {
        return this.radioDatabase;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        RadioDatabase companion = RadioDatabase.Companion.getInstance();
        this.radioDatabase = companion;
        return companion != null;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00ca  */
    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SupportSQLiteOpenHelper openHelper;
        SupportSQLiteDatabase readableDatabase;
        boolean z;
        SupportSQLiteOpenHelper openHelper2;
        SupportSQLiteDatabase readableDatabase2;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (this.radioDatabase == null) {
            this.radioDatabase = RadioDatabase.Companion.getInstance();
        }
        String str = selection == null ? "" : selection;
        StringBuilder sbAppend = new StringBuilder("----------------- ").append(uri).append("  ");
        String string = Arrays.toString(projection);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        StringBuilder sbAppend2 = sbAppend.append(string).append(' ').append(selection).append(' ');
        String string2 = Arrays.toString(selectionArgs);
        Intrinsics.checkNotNullExpressionValue(string2, "toString(this)");
        Log.e("radio", sbAppend2.append(string2).append(' ').append(sortOrder).toString());
        int iMatch = this.b.match(uri);
        if (iMatch == 1) {
            RadioDatabase radioDatabase = this.radioDatabase;
            if (radioDatabase != null && (openHelper = radioDatabase.getOpenHelper()) != null && (readableDatabase = openHelper.getReadableDatabase()) != null) {
                SupportSQLiteQueryBuilder supportSQLiteQueryBuilderBuilder = SupportSQLiteQueryBuilder.builder("city_station");
                if (projection != null) {
                    supportSQLiteQueryBuilderBuilder.columns(projection);
                }
                if (str.length() > 0) {
                    Intrinsics.checkNotNull(selectionArgs);
                    supportSQLiteQueryBuilderBuilder.selection(str, selectionArgs);
                }
                if (sortOrder != null) {
                    z = sortOrder.length() > 0;
                }
                if (z) {
                    supportSQLiteQueryBuilderBuilder.orderBy(sortOrder);
                }
                return readableDatabase.query(supportSQLiteQueryBuilderBuilder.create());
            }
        } else if (iMatch == 2) {
            RadioDatabase radioDatabase2 = this.radioDatabase;
            if (radioDatabase2 != null && (openHelper2 = radioDatabase2.getOpenHelper()) != null && (readableDatabase2 = openHelper2.getReadableDatabase()) != null) {
                return readableDatabase2.query("");
            }
        } else if (iMatch == 3) {
            return c;
        }
        return null;
    }

    public final void setRadioDatabase(RadioDatabase radioDatabase) {
        this.radioDatabase = radioDatabase;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return -1;
    }
}
