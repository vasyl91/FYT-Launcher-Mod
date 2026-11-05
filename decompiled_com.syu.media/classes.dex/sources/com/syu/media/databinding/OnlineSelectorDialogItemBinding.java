package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class OnlineSelectorDialogItemBinding implements ViewBinding {
    public final FaceMyingheiTextView onlineCityDialogItem;
    private final FrameLayout rootView;

    private OnlineSelectorDialogItemBinding(FrameLayout frameLayout, FaceMyingheiTextView faceMyingheiTextView) {
        this.rootView = frameLayout;
        this.onlineCityDialogItem = faceMyingheiTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static OnlineSelectorDialogItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OnlineSelectorDialogItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.online_selector_dialog_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static OnlineSelectorDialogItemBinding bind(View view) {
        int i = R.id.online_city_dialog_item;
        FaceMyingheiTextView faceMyingheiTextView = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
        if (faceMyingheiTextView != null) {
            return new OnlineSelectorDialogItemBinding((FrameLayout) view, faceMyingheiTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
