package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.syu.media.R;
import com.syu.media.companion.view.CircleImageView;
import com.syu.media.companion.view.fons.SemiboldTextView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class OnlineDetailFragmentBinding implements ViewBinding {
    public final ConstraintLayout fragmentContainerView2;
    public final Guideline guide1;
    public final Guideline guide2;
    public final Guideline guide3;
    public final CircleImageView onlineCtrAlbum;
    public final SemiboldTextView onlineCtrArtist;
    public final ImageView onlineCtrNext;
    public final ImageView onlineCtrPlay;
    public final ImageView onlineCtrPrev;
    public final FragmentContainerView onlineDetailFragBlurImg;
    public final SemiboldTextView onlineDetailName;
    public final TabLayout onlineDetailTablayout;
    public final ViewPager2 onlineDetailViewpager2;
    private final ConstraintLayout rootView;

    private OnlineDetailFragmentBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Guideline guideline, Guideline guideline2, Guideline guideline3, CircleImageView circleImageView, SemiboldTextView semiboldTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, FragmentContainerView fragmentContainerView, SemiboldTextView semiboldTextView2, TabLayout tabLayout, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.fragmentContainerView2 = constraintLayout2;
        this.guide1 = guideline;
        this.guide2 = guideline2;
        this.guide3 = guideline3;
        this.onlineCtrAlbum = circleImageView;
        this.onlineCtrArtist = semiboldTextView;
        this.onlineCtrNext = imageView;
        this.onlineCtrPlay = imageView2;
        this.onlineCtrPrev = imageView3;
        this.onlineDetailFragBlurImg = fragmentContainerView;
        this.onlineDetailName = semiboldTextView2;
        this.onlineDetailTablayout = tabLayout;
        this.onlineDetailViewpager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static OnlineDetailFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OnlineDetailFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.online_detail_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static OnlineDetailFragmentBinding bind(View view) {
        int i = R.id.fragmentContainerView2;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.guide1;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.guide2;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline2 != null) {
                    i = R.id.guide3;
                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline3 != null) {
                        i = R.id.online_ctr_album;
                        CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i);
                        if (circleImageView != null) {
                            i = R.id.online_ctr_artist;
                            SemiboldTextView semiboldTextView = (SemiboldTextView) ViewBindings.findChildViewById(view, i);
                            if (semiboldTextView != null) {
                                i = R.id.online_ctr_next;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.online_ctr_play;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = R.id.online_ctr_prev;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.online_detail_frag_blur_img;
                                            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                                            if (fragmentContainerView != null) {
                                                i = R.id.online_detail_name;
                                                SemiboldTextView semiboldTextView2 = (SemiboldTextView) ViewBindings.findChildViewById(view, i);
                                                if (semiboldTextView2 != null) {
                                                    i = R.id.online_detail_tablayout;
                                                    TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
                                                    if (tabLayout != null) {
                                                        i = R.id.online_detail_viewpager2;
                                                        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                                                        if (viewPager2 != null) {
                                                            return new OnlineDetailFragmentBinding((ConstraintLayout) view, constraintLayout, guideline, guideline2, guideline3, circleImageView, semiboldTextView, imageView, imageView2, imageView3, fragmentContainerView, semiboldTextView2, tabLayout, viewPager2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
