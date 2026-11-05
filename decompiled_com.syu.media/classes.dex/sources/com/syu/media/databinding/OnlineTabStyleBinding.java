package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.syu.media.R;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class OnlineTabStyleBinding implements ViewBinding {
    public final FaceMyingheiTextView onlineTabText;
    private final FaceMyingheiTextView rootView;

    private OnlineTabStyleBinding(FaceMyingheiTextView faceMyingheiTextView, FaceMyingheiTextView faceMyingheiTextView2) {
        this.rootView = faceMyingheiTextView;
        this.onlineTabText = faceMyingheiTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FaceMyingheiTextView getRoot() {
        return this.rootView;
    }

    public static OnlineTabStyleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OnlineTabStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.online_tab_style, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static OnlineTabStyleBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FaceMyingheiTextView faceMyingheiTextView = (FaceMyingheiTextView) view;
        return new OnlineTabStyleBinding(faceMyingheiTextView, faceMyingheiTextView);
    }
}
