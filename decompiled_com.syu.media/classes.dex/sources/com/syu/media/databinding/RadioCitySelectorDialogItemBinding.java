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
public final class RadioCitySelectorDialogItemBinding implements ViewBinding {
    public final FaceMyingheiTextView onlineCityDialogItem;
    private final FrameLayout rootView;

    private RadioCitySelectorDialogItemBinding(FrameLayout frameLayout, FaceMyingheiTextView faceMyingheiTextView) {
        this.rootView = frameLayout;
        this.onlineCityDialogItem = faceMyingheiTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static RadioCitySelectorDialogItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RadioCitySelectorDialogItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.radio_city_selector_dialog_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RadioCitySelectorDialogItemBinding bind(View view) {
        int i = R.id.online_city_dialog_item;
        FaceMyingheiTextView faceMyingheiTextView = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
        if (faceMyingheiTextView != null) {
            return new RadioCitySelectorDialogItemBinding((FrameLayout) view, faceMyingheiTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
