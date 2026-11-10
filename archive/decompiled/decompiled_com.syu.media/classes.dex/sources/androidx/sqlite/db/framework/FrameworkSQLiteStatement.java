package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {
    private final SQLiteStatement mDelegate;

    FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.mDelegate = sQLiteStatement;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.mDelegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        return this.mDelegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        return this.mDelegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        return this.mDelegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        return this.mDelegate.simpleQueryForString();
    }
}
