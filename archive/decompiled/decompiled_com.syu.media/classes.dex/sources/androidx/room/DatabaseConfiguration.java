package androidx.room;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;
    public final String name;
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List<Object> typeConverters;

    @Deprecated
    public DatabaseConfiguration(Context context, String name, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, RoomDatabase.JournalMode journalMode, Executor queryExecutor, boolean requireMigration, Set<Integer> migrationNotRequiredFrom) {
        this(context, name, sqliteOpenHelperFactory, migrationContainer, callbacks, allowMainThreadQueries, journalMode, queryExecutor, queryExecutor, false, requireMigration, false, migrationNotRequiredFrom, null, null, null, null, null);
    }

    @Deprecated
    public DatabaseConfiguration(Context context, String name, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean multiInstanceInvalidation, boolean requireMigration, boolean allowDestructiveMigrationOnDowngrade, Set<Integer> migrationNotRequiredFrom) {
        this(context, name, sqliteOpenHelperFactory, migrationContainer, callbacks, allowMainThreadQueries, journalMode, queryExecutor, transactionExecutor, multiInstanceInvalidation, requireMigration, allowDestructiveMigrationOnDowngrade, migrationNotRequiredFrom, null, null, null, null, null);
    }

    @Deprecated
    public DatabaseConfiguration(Context context, String name, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean multiInstanceInvalidation, boolean requireMigration, boolean allowDestructiveMigrationOnDowngrade, Set<Integer> migrationNotRequiredFrom, String copyFromAssetPath, File copyFromFile) {
        this(context, name, sqliteOpenHelperFactory, migrationContainer, callbacks, allowMainThreadQueries, journalMode, queryExecutor, transactionExecutor, multiInstanceInvalidation, requireMigration, allowDestructiveMigrationOnDowngrade, migrationNotRequiredFrom, copyFromAssetPath, copyFromFile, null, null, null);
    }

    @Deprecated
    public DatabaseConfiguration(Context context, String name, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean multiInstanceInvalidation, boolean requireMigration, boolean allowDestructiveMigrationOnDowngrade, Set<Integer> migrationNotRequiredFrom, String copyFromAssetPath, File copyFromFile, Callable<InputStream> copyFromInputStream) {
        this(context, name, sqliteOpenHelperFactory, migrationContainer, callbacks, allowMainThreadQueries, journalMode, queryExecutor, transactionExecutor, multiInstanceInvalidation, requireMigration, allowDestructiveMigrationOnDowngrade, migrationNotRequiredFrom, copyFromAssetPath, copyFromFile, copyFromInputStream, null, null);
    }

    @Deprecated
    public DatabaseConfiguration(Context context, String name, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean multiInstanceInvalidation, boolean requireMigration, boolean allowDestructiveMigrationOnDowngrade, Set<Integer> migrationNotRequiredFrom, String copyFromAssetPath, File copyFromFile, Callable<InputStream> copyFromInputStream, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        this(context, name, sqliteOpenHelperFactory, migrationContainer, callbacks, allowMainThreadQueries, journalMode, queryExecutor, transactionExecutor, multiInstanceInvalidation, requireMigration, allowDestructiveMigrationOnDowngrade, migrationNotRequiredFrom, copyFromAssetPath, copyFromFile, copyFromInputStream, prepackagedDatabaseCallback, null);
    }

    public DatabaseConfiguration(Context context, String name, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean multiInstanceInvalidation, boolean requireMigration, boolean allowDestructiveMigrationOnDowngrade, Set<Integer> migrationNotRequiredFrom, String copyFromAssetPath, File copyFromFile, Callable<InputStream> copyFromInputStream, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<Object> typeConverters) {
        this.sqliteOpenHelperFactory = sqliteOpenHelperFactory;
        this.context = context;
        this.name = name;
        this.migrationContainer = migrationContainer;
        this.callbacks = callbacks;
        this.allowMainThreadQueries = allowMainThreadQueries;
        this.journalMode = journalMode;
        this.queryExecutor = queryExecutor;
        this.transactionExecutor = transactionExecutor;
        this.multiInstanceInvalidation = multiInstanceInvalidation;
        this.requireMigration = requireMigration;
        this.allowDestructiveMigrationOnDowngrade = allowDestructiveMigrationOnDowngrade;
        this.mMigrationNotRequiredFrom = migrationNotRequiredFrom;
        this.copyFromAssetPath = copyFromAssetPath;
        this.copyFromFile = copyFromFile;
        this.copyFromInputStream = copyFromInputStream;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = typeConverters == null ? Collections.emptyList() : typeConverters;
    }

    @Deprecated
    public boolean isMigrationRequiredFrom(int version) {
        return isMigrationRequired(version, version + 1);
    }

    public boolean isMigrationRequired(int fromVersion, int toVersion) {
        Set<Integer> set;
        if ((fromVersion > toVersion) && this.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        return this.requireMigration && ((set = this.mMigrationNotRequiredFrom) == null || !set.contains(Integer.valueOf(fromVersion)));
    }
}
