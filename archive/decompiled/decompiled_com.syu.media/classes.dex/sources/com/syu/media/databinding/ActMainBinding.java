package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ActMainBinding implements ViewBinding {
    public final ConstraintLayout actMainTats;
    public final ImageView ivTabBtmusic;
    public final ImageView ivTabEq;
    public final ImageView ivTabFm;
    public final ImageView ivTabMusic;
    public final ImageView ivTabRadio;
    public final FragmentContainerView mainFrag;
    private final CardView rootView;

    private ActMainBinding(CardView cardView, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, FragmentContainerView fragmentContainerView) {
        this.rootView = cardView;
        this.actMainTats = constraintLayout;
        this.ivTabBtmusic = imageView;
        this.ivTabEq = imageView2;
        this.ivTabFm = imageView3;
        this.ivTabMusic = imageView4;
        this.ivTabRadio = imageView5;
        this.mainFrag = fragmentContainerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ActMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.act_main, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActMainBinding bind(View view) {
        int i = R.id.act_main_tats;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.iv_tab_btmusic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_tab_eq;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.iv_tab_fm;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.iv_tab_music;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.iv_tab_radio;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView5 != null) {
                                i = R.id.main_frag;
                                FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                                if (fragmentContainerView != null) {
                                    return new ActMainBinding((CardView) view, constraintLayout, imageView, imageView2, imageView3, imageView4, imageView5, fragmentContainerView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
