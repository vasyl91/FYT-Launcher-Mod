package com.syu.radio.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import chip.FinalChip;
import com.syu.radio.dao.RadioDao;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/syu/radio/database/RadioDatabase;", "Landroidx/room/RoomDatabase;", "()V", "radioDao", "Lcom/syu/radio/dao/RadioDao;", "Companion", "radiolib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class RadioDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static RadioDatabase a;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/syu/radio/database/RadioDatabase$Companion;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/radio/database/RadioDatabase;", "requireDatabase", "Landroid/content/Context;", "context", "getDatabase", "instance", "Lcom/syu/radio/database/RadioDatabase;", "getInstance", "()Lcom/syu/radio/database/RadioDatabase;", "setInstance", "(Lcom/syu/radio/database/RadioDatabase;)V", "radiolib_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RadioDatabase getDatabase(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            RadioDatabase companion = getInstance();
            if (companion == null) {
                synchronized (this) {
                    Companion companion2 = RadioDatabase.INSTANCE;
                    companion2.setInstance((RadioDatabase) Room.databaseBuilder(context, RadioDatabase.class, "radio_database.db").build());
                    companion = companion2.getInstance();
                    Intrinsics.checkNotNull(companion);
                }
            }
            return companion;
        }

        public final RadioDatabase getInstance() {
            return RadioDatabase.a;
        }

        public final RadioDatabase requireDatabase() {
            if (getInstance() == null) {
                throw new IllegalStateException("RadioDatabase instance not be created!!");
            }
            RadioDatabase companion = getInstance();
            Intrinsics.checkNotNull(companion);
            return companion;
        }

        public final void setInstance(RadioDatabase radioDatabase) {
            RadioDatabase.a = radioDatabase;
        }
    }

    public abstract RadioDao radioDao();
}
