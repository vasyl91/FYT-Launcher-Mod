package androidx.core.view;

import android.app.Activity;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class DragAndDropPermissionsCompat {
    private Object mDragAndDropPermissions;

    private DragAndDropPermissionsCompat(Object obj) {
        this.mDragAndDropPermissions = obj;
    }

    public static DragAndDropPermissionsCompat request(Activity activity, DragEvent dragEvent) {
        DragAndDropPermissions dragAndDropPermissionsRequestDragAndDropPermissions = activity.requestDragAndDropPermissions(dragEvent);
        if (dragAndDropPermissionsRequestDragAndDropPermissions != null) {
            return new DragAndDropPermissionsCompat(dragAndDropPermissionsRequestDragAndDropPermissions);
        }
        return null;
    }

    public void release() {
        ((DragAndDropPermissions) this.mDragAndDropPermissions).release();
    }
}
