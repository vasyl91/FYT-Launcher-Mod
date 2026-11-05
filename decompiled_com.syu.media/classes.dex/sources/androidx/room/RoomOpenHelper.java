package androidx.room;

import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import chip.FinalChip;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    private DatabaseConfiguration mConfiguration;
    private final Delegate mDelegate;
    private final String mIdentityHash;
    private final String mLegacyHash;

    public RoomOpenHelper(DatabaseConfiguration configuration, Delegate delegate, String identityHash, String legacyHash) {
        super(delegate.version);
        this.mConfiguration = configuration;
        this.mDelegate = delegate;
        this.mIdentityHash = identityHash;
        this.mLegacyHash = legacyHash;
    }

    public RoomOpenHelper(DatabaseConfiguration configuration, Delegate delegate, String legacyHash) {
        this(configuration, delegate, FinalChip.BSP_PLATFORM_Null, legacyHash);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(SupportSQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(SupportSQLiteDatabase db) {
        boolean zHasEmptySchema = hasEmptySchema(db);
        this.mDelegate.createAllTables(db);
        if (!zHasEmptySchema) {
            ValidationResult validationResultOnValidateSchema = this.mDelegate.onValidateSchema(db);
            if (!validationResultOnValidateSchema.isValid) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg);
            }
        }
        updateIdentity(db);
        this.mDelegate.onCreate(db);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {
        boolean z;
        List<Migration> listFindMigrationPath;
        DatabaseConfiguration databaseConfiguration = this.mConfiguration;
        if (databaseConfiguration == null || (listFindMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(oldVersion, newVersion)) == null) {
            z = false;
        } else {
            this.mDelegate.onPreMigrate(db);
            Iterator<Migration> it = listFindMigrationPath.iterator();
            while (it.hasNext()) {
                it.next().migrate(db);
            }
            ValidationResult validationResultOnValidateSchema = this.mDelegate.onValidateSchema(db);
            if (!validationResultOnValidateSchema.isValid) {
                throw new IllegalStateException("Migration didn't properly handle: " + validationResultOnValidateSchema.expectedFoundMsg);
            }
            this.mDelegate.onPostMigrate(db);
            updateIdentity(db);
            z = true;
        }
        if (z) {
            return;
        }
        DatabaseConfiguration databaseConfiguration2 = this.mConfiguration;
        if (databaseConfiguration2 != null && !databaseConfiguration2.isMigrationRequired(oldVersion, newVersion)) {
            this.mDelegate.dropAllTables(db);
            this.mDelegate.createAllTables(db);
            return;
        }
        throw new IllegalStateException("A migration from " + oldVersion + " to " + newVersion + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(SupportSQLiteDatabase db) {
        super.onOpen(db);
        checkIdentity(db);
        this.mDelegate.onOpen(db);
        this.mConfiguration = null;
    }

    private void checkIdentity(SupportSQLiteDatabase db) {
        if (hasRoomMasterTable(db)) {
            Cursor cursorQuery = db.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
            try {
                String string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
                cursorQuery.close();
                if (!this.mIdentityHash.equals(string) && !this.mLegacyHash.equals(string)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
                return;
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        ValidationResult validationResultOnValidateSchema = this.mDelegate.onValidateSchema(db);
        if (!validationResultOnValidateSchema.isValid) {
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg);
        }
        this.mDelegate.onPostMigrate(db);
        updateIdentity(db);
    }

    private void updateIdentity(SupportSQLiteDatabase db) {
        createMasterTableIfNotExists(db);
        db.execSQL(RoomMasterTable.createInsertQuery(this.mIdentityHash));
    }

    private void createMasterTableIfNotExists(SupportSQLiteDatabase db) {
        db.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private static boolean hasRoomMasterTable(SupportSQLiteDatabase db) {
        Cursor cursorQuery = db.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (cursorQuery.moveToFirst() && cursorQuery.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            cursorQuery.close();
        }
    }

    private static boolean hasEmptySchema(SupportSQLiteDatabase db) {
        Cursor cursorQuery = db.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (cursorQuery.moveToFirst() && cursorQuery.getInt(0) == 0) {
                z = true;
            }
            return z;
        } finally {
            cursorQuery.close();
        }
    }

    public static abstract class Delegate {
        public final int version;

        protected abstract void createAllTables(SupportSQLiteDatabase database);

        protected abstract void dropAllTables(SupportSQLiteDatabase database);

        protected abstract void onCreate(SupportSQLiteDatabase database);

        protected abstract void onOpen(SupportSQLiteDatabase database);

        protected void onPostMigrate(SupportSQLiteDatabase database) {
        }

        protected void onPreMigrate(SupportSQLiteDatabase database) {
        }

        public Delegate(int version) {
            this.version = version;
        }

        @Deprecated
        protected void validateMigration(SupportSQLiteDatabase db) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        protected ValidationResult onValidateSchema(SupportSQLiteDatabase db) {
            validateMigration(db);
            return new ValidationResult(true, null);
        }
    }

    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean isValid, String expectedFoundMsg) {
            this.isValid = isValid;
            this.expectedFoundMsg = expectedFoundMsg;
        }
    }
}
