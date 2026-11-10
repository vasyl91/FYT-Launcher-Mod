package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class RadioFragmentBinding implements ViewBinding {
    public final FragmentContainerView radioCtrlLayout;
    public final FragmentContainerView radioFragBlurImg;
    public final FragmentContainerView radioListLayout;
    private final ConstraintLayout rootView;

    private RadioFragmentBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, FragmentContainerView fragmentContainerView2, FragmentContainerView fragmentContainerView3) {
        this.rootView = constraintLayout;
        this.radioCtrlLayout = fragmentContainerView;
        this.radioFragBlurImg = fragmentContainerView2;
        this.radioListLayout = fragmentContainerView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RadioFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RadioFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.radio_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RadioFragmentBinding bind(View view) {
        int i = R.id.radio_ctrl_layout;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
        if (fragmentContainerView != null) {
            i = R.id.radio_frag_blur_img;
            FragmentContainerView fragmentContainerView2 = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
            if (fragmentContainerView2 != null) {
                return new RadioFragmentBinding((ConstraintLayout) view, fragmentContainerView, fragmentContainerView2, (FragmentContainerView) ViewBindings.findChildViewById(view, R.id.radio_list_layout));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
