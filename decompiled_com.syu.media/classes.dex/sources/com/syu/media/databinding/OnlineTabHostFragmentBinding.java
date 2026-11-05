package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class OnlineTabHostFragmentBinding implements ViewBinding {
    public final RecyclerView onlineDetailRecyclerview;
    public final FaceMyingheiTextView onlineMainAudioEmpty;
    private final ConstraintLayout rootView;

    private OnlineTabHostFragmentBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, FaceMyingheiTextView faceMyingheiTextView) {
        this.rootView = constraintLayout;
        this.onlineDetailRecyclerview = recyclerView;
        this.onlineMainAudioEmpty = faceMyingheiTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static OnlineTabHostFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OnlineTabHostFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.online_tab_host_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static OnlineTabHostFragmentBinding bind(View view) {
        int i = R.id.online_detail_recyclerview;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.online_main_audio_empty;
            FaceMyingheiTextView faceMyingheiTextView = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
            if (faceMyingheiTextView != null) {
                return new OnlineTabHostFragmentBinding((ConstraintLayout) view, recyclerView, faceMyingheiTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
