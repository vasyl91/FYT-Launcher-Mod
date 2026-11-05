package syu.utils;

import android.content.Context;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import syu.reflex.ReflexMethod;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001d\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lsyu/utils/StorageUtils;", "", "Landroid/content/Context;", "context", "", "Lsyu/utils/StorageUtils$StorageInfo;", "getMountedStorages", "", "", "getAllStoragePaths", "(Landroid/content/Context;)[Ljava/lang/String;", "StorageInfo", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class StorageUtils {
    public static final StorageUtils INSTANCE = new StorageUtils();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001R$\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\t¨\u0006 "}, d2 = {"Lsyu/utils/StorageUtils$StorageInfo;", "", "other", "", "equals", "", "component1", "component2", "component3", "()Ljava/lang/Boolean;", "path", "state", "removable", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lsyu/utils/StorageUtils$StorageInfo;", "toString", "", "hashCode", "a", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "b", "getState", "setState", "c", "Ljava/lang/Boolean;", "getRemovable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Library_release"}, k = 1, mv = {1, 7, 1})
    public static final /* data */ class StorageInfo {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public String path;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public String state;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final Boolean removable;

        public StorageInfo(String str, String str2, Boolean bool) {
            this.path = str;
            this.state = str2;
            this.removable = bool;
        }

        public static /* synthetic */ StorageInfo copy$default(StorageInfo storageInfo, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = storageInfo.path;
            }
            if ((i & 2) != 0) {
                str2 = storageInfo.state;
            }
            if ((i & 4) != 0) {
                bool = storageInfo.removable;
            }
            return storageInfo.copy(str, str2, bool);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getRemovable() {
            return this.removable;
        }

        public final StorageInfo copy(String path, String state, Boolean removable) {
            return new StorageInfo(path, state, removable);
        }

        public boolean equals(Object other) {
            String str;
            if (!(other instanceof StorageInfo)) {
                return super.equals(other);
            }
            String str2 = this.path;
            if (str2 == null || (str = ((StorageInfo) other).path) == null) {
                return false;
            }
            return Intrinsics.areEqual(str2, str);
        }

        public final String getPath() {
            return this.path;
        }

        public final Boolean getRemovable() {
            return this.removable;
        }

        public final String getState() {
            return this.state;
        }

        public int hashCode() {
            String str = this.path;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.state;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.removable;
            return iHashCode2 + (bool != null ? bool.hashCode() : 0);
        }

        public final void setPath(String str) {
            this.path = str;
        }

        public final void setState(String str) {
            this.state = str;
        }

        public String toString() {
            return "StorageInfo(path=" + this.path + ", state=" + this.state + ", removable=" + this.removable + ')';
        }
    }

    public final String[] getAllStoragePaths(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("storage");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.storage.StorageManager");
        return (String[]) new ReflexMethod("getVolumePaths").target((StorageManager) systemService).call();
    }

    public final List<StorageInfo> getMountedStorages(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        Object systemService = context.getApplicationContext().getSystemService("storage");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.storage.StorageManager");
        StorageVolume[] storageVolumeArr = (StorageVolume[]) new ReflexMethod("getVolumeList").target((StorageManager) systemService).call();
        if (storageVolumeArr != null) {
            for (StorageVolume storageVolume : storageVolumeArr) {
                String str = (String) new ReflexMethod("getPath").target(storageVolume).call();
                String str2 = (String) new ReflexMethod("getState").target(storageVolume).call();
                Boolean bool = (Boolean) new ReflexMethod("isRemovable").target(storageVolume).call();
                if (str != null) {
                    if (str.length() > 0) {
                        arrayList.add(new StorageInfo(str, str2, bool));
                    }
                }
            }
        }
        return arrayList;
    }
}
