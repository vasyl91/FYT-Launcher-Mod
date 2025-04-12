package com.android.launcher66;

import android.widget.ScrollView;

import androidx.core.widget.AutoScrollHelper;

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

    @Override
    public void scrollTargetBy(int deltaX, int deltaY) {
        this.mTarget.scrollBy(deltaX, deltaY);
    }

    @Override
    public boolean canTargetScrollHorizontally(int direction) {
        return false;
    }

    @Override
    public boolean canTargetScrollVertically(int direction) {
        return this.mTarget.canScrollVertically(direction);
    }
}
