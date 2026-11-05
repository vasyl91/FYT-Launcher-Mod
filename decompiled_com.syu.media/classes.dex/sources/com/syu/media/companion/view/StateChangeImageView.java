package com.syu.media.companion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class StateChangeImageView extends AppCompatImageView {
    public StateChangeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public StateChangeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StateChangeImageView(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        Log.d("LZP", "drawableStateChanged" + isPressed());
        if (isPressed()) {
            setAlpha(0.5f);
        } else {
            setAlpha(1.0f);
        }
        super.drawableStateChanged();
    }
}
