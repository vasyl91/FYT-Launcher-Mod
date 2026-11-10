package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    protected abstract void bind(SupportSQLiteStatement statement, T entity);

    public EntityInsertionAdapter(RoomDatabase database) {
        super(database);
    }

    public final void insert(T entity) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, entity);
            supportSQLiteStatementAcquire.executeInsert();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final void insert(T[] entities) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            for (T t : entities) {
                bind(supportSQLiteStatementAcquire, t);
                supportSQLiteStatementAcquire.executeInsert();
            }
            release(supportSQLiteStatementAcquire);
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final void insert(Iterable<? extends T> entities) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            Iterator<? extends T> it = entities.iterator();
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                supportSQLiteStatementAcquire.executeInsert();
            }
            release(supportSQLiteStatementAcquire);
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final long insertAndReturnId(T entity) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, entity);
            return supportSQLiteStatementAcquire.executeInsert();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> entities) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            long[] jArr = new long[entities.size()];
            Iterator<? extends T> it = entities.iterator();
            int i = 0;
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                jArr[i] = supportSQLiteStatementAcquire.executeInsert();
                i++;
            }
            release(supportSQLiteStatementAcquire);
            return jArr;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final long[] insertAndReturnIdsArray(T[] entities) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            long[] jArr = new long[entities.length];
            int i = 0;
            for (T t : entities) {
                bind(supportSQLiteStatementAcquire, t);
                jArr[i] = supportSQLiteStatementAcquire.executeInsert();
                i++;
            }
            release(supportSQLiteStatementAcquire);
            return jArr;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> entities) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            Long[] lArr = new Long[entities.size()];
            Iterator<? extends T> it = entities.iterator();
            int i = 0;
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                lArr[i] = Long.valueOf(supportSQLiteStatementAcquire.executeInsert());
                i++;
            }
            release(supportSQLiteStatementAcquire);
            return lArr;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] entities) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            Long[] lArr = new Long[entities.length];
            int i = 0;
            for (T t : entities) {
                bind(supportSQLiteStatementAcquire, t);
                lArr[i] = Long.valueOf(supportSQLiteStatementAcquire.executeInsert());
                i++;
            }
            release(supportSQLiteStatementAcquire);
            return lArr;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] entities) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(entities.length);
            int i = 0;
            for (T t : entities) {
                bind(supportSQLiteStatementAcquire, t);
                arrayList.add(i, Long.valueOf(supportSQLiteStatementAcquire.executeInsert()));
                i++;
            }
            release(supportSQLiteStatementAcquire);
            return arrayList;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> entities) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(entities.size());
            Iterator<? extends T> it = entities.iterator();
            int i = 0;
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                arrayList.add(i, Long.valueOf(supportSQLiteStatementAcquire.executeInsert()));
                i++;
            }
            release(supportSQLiteStatementAcquire);
            return arrayList;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }
}
