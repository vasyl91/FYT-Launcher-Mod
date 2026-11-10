package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram mDelegate;

    FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.mDelegate = sQLiteProgram;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        this.mDelegate.bindNull(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        this.mDelegate.bindLong(i, j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        this.mDelegate.bindDouble(i, d);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        this.mDelegate.bindString(i, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        this.mDelegate.bindBlob(i, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }
}
