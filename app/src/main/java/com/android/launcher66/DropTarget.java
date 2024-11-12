package com.android.launcher66;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import com.android.launcher66.DragController;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public interface DropTarget {
    public static final String TAG = "DropTarget";

    public static class DragObject {
        public int x = -1;
        public int y = -1;
        public int xOffset = -1;
        public int yOffset = -1;
        public boolean dragComplete = false;
        public DragView dragView = null;
        public Object dragInfo = null;
        public DragSource dragSource = null;
        public Runnable postAnimationRunnable = null;
        public boolean cancelled = false;
        public boolean deferDragViewCleanupPostAnimation = true;
    }

    boolean acceptDrop(DragObject dragObject);

    void getHitRectRelativeToDragLayer(Rect rect);

    int getLeft();

    void getLocationInDragLayer(int[] iArr);

    int getTop();

    boolean isDropEnabled();

    void onDragEnter(DragObject dragObject);

    void onDragExit(DragObject dragObject);

    void onDragOver(DragObject dragObject);

    void onDrop(DragObject dragObject);

    void onFlingToDelete(DragObject dragObject, int i, int i2, PointF pointF);

    public static class DragEnforcer implements DragController.DragListener {
        int dragParity = 0;

        public DragEnforcer(Context context) {
            Launcher launcher = (Launcher) context;
            launcher.getDragController().addDragListener(this);
        }

        void onDragEnter() {
            this.dragParity++;
            if (this.dragParity != 1) {
                Log.e(DropTarget.TAG, "onDragEnter: Drag contract violated: " + this.dragParity);
            }
        }

        void onDragExit() {
            this.dragParity--;
            if (this.dragParity != 0) {
                Log.e(DropTarget.TAG, "onDragExit: Drag contract violated: " + this.dragParity);
            }
        }

        @Override // com.android.launcher66.DragController.DragListener
        public void onDragStart(DragSource source, Object info, int dragAction) {
            if (this.dragParity != 0) {
                Log.e(DropTarget.TAG, "onDragEnter: Drag contract violated: " + this.dragParity);
            }
        }

        @Override // com.android.launcher66.DragController.DragListener
        public void onDragEnd() {
            if (this.dragParity != 0) {
                Log.e(DropTarget.TAG, "onDragExit: Drag contract violated: " + this.dragParity);
            }
        }
    }
}
