package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class DrawableCrossFadeTransition implements Transition<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;

    public DrawableCrossFadeTransition(int i, boolean z) {
        this.duration = i;
        this.isCrossFadeEnabled = z;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        Drawable currentDrawable = viewAdapter.getCurrentDrawable();
        if (currentDrawable == null) {
            currentDrawable = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, drawable});
        transitionDrawable.setCrossFadeEnabled(this.isCrossFadeEnabled);
        transitionDrawable.startTransition(this.duration);
        viewAdapter.setDrawable(transitionDrawable);
        return true;
    }
}
