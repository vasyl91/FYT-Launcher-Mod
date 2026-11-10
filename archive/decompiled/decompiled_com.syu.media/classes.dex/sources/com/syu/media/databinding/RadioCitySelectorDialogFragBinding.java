package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class RadioCitySelectorDialogFragBinding implements ViewBinding {
    public final RecyclerView onlineDialogSelectorRecycler;
    public final ConstraintLayout radioSelectorFrag;
    private final ConstraintLayout rootView;

    private RadioCitySelectorDialogFragBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.onlineDialogSelectorRecycler = recyclerView;
        this.radioSelectorFrag = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RadioCitySelectorDialogFragBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RadioCitySelectorDialogFragBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.radio_city_selector_dialog_frag, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RadioCitySelectorDialogFragBinding bind(View view) {
        int i = R.id.online_dialog_selector_recycler;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new RadioCitySelectorDialogFragBinding(constraintLayout, recyclerView, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
