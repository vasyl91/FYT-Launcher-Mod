package com.android.launcher66;

import androidx.core.widget.AutoScrollHelper;
import android.widget.ScrollView;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class FolderAutoScrollHelper extends AutoScrollHelper {
    private static final float MAX_SCROLL_VELOCITY = 1500.0f;
    private final ScrollView mTarget;

    public FolderAutoScrollHelper(ScrollView target) {
        super(target);
        this.mTarget = target;
        setActivationDelay(0);
        setEdgeType(1);
        setExclusive(true);
        setMaximumVelocity(MAX_SCROLL_VELOCITY, MAX_SCROLL_VELOCITY);
        setRampDownDuration(0);
        setRampUpDuration(0);
    }

    @Override // android.support.v4.widget.AutoScrollHelper
    public void scrollTargetBy(int deltaX, int deltaY) {
        this.mTarget.scrollBy(deltaX, deltaY);
    }

    @Override // android.support.v4.widget.AutoScrollHelper
    public boolean canTargetScrollHorizontally(int direction) {
        return false;
    }

    @Override // android.support.v4.widget.AutoScrollHelper
    public boolean canTargetScrollVertically(int direction) {
        return this.mTarget.canScrollVertically(direction);
    }
}
