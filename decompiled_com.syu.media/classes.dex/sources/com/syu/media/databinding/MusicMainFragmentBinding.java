package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;
import com.syu.media.companion.view.CircleImageView;
import com.syu.media.companion.view.fons.CompasseTextView;
import com.syu.media.companion.view.fons.FaceMyingheiRadioButton;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;
import com.syu.media.companion.view.fons.SemiboldTextView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class MusicMainFragmentBinding implements ViewBinding {
    public final RecyclerView browserList;
    public final ConstraintLayout fragmentContainerView2;
    public final Guideline guide1;
    public final Guideline guide2;
    public final Guideline guide3;
    public final CircleImageView musicCtrAlbum;
    public final SemiboldTextView musicCtrArtist;
    public final ImageView musicCtrNext;
    public final ImageView musicCtrPlay;
    public final ImageView musicCtrPrev;
    public final SemiboldTextView musicCtrTitle;
    public final ProgressBar musicListPlayProgressbar;
    public final CompasseTextView musicListPlayTime;
    public final FaceMyingheiRadioButton musicListStyleAlbum;
    public final FaceMyingheiRadioButton musicListStyleArtist;
    public final FaceMyingheiRadioButton musicListStyleFolder;
    public final RadioGroup musicListStyleGroup;
    public final FaceMyingheiRadioButton musicListStyleTrack;
    public final CompasseTextView musicListTotalTime;
    public final FaceMyingheiTextView musicMainAudioEmpty;
    public final FragmentContainerView musicMainFragBlurImg;
    public final FaceMyingheiRadioButton musicStorageAll;
    public final FaceMyingheiRadioButton musicStorageFavorite;
    public final RadioGroup musicStorageGroup;
    public final FaceMyingheiRadioButton musicStorageHost;
    public final ScrollView musicStorageScrollview;
    private final ConstraintLayout rootView;

    private MusicMainFragmentBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout2, Guideline guideline, Guideline guideline2, Guideline guideline3, CircleImageView circleImageView, SemiboldTextView semiboldTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, SemiboldTextView semiboldTextView2, ProgressBar progressBar, CompasseTextView compasseTextView, FaceMyingheiRadioButton faceMyingheiRadioButton, FaceMyingheiRadioButton faceMyingheiRadioButton2, FaceMyingheiRadioButton faceMyingheiRadioButton3, RadioGroup radioGroup, FaceMyingheiRadioButton faceMyingheiRadioButton4, CompasseTextView compasseTextView2, FaceMyingheiTextView faceMyingheiTextView, FragmentContainerView fragmentContainerView, FaceMyingheiRadioButton faceMyingheiRadioButton5, FaceMyingheiRadioButton faceMyingheiRadioButton6, RadioGroup radioGroup2, FaceMyingheiRadioButton faceMyingheiRadioButton7, ScrollView scrollView) {
        this.rootView = constraintLayout;
        this.browserList = recyclerView;
        this.fragmentContainerView2 = constraintLayout2;
        this.guide1 = guideline;
        this.guide2 = guideline2;
        this.guide3 = guideline3;
        this.musicCtrAlbum = circleImageView;
        this.musicCtrArtist = semiboldTextView;
        this.musicCtrNext = imageView;
        this.musicCtrPlay = imageView2;
        this.musicCtrPrev = imageView3;
        this.musicCtrTitle = semiboldTextView2;
        this.musicListPlayProgressbar = progressBar;
        this.musicListPlayTime = compasseTextView;
        this.musicListStyleAlbum = faceMyingheiRadioButton;
        this.musicListStyleArtist = faceMyingheiRadioButton2;
        this.musicListStyleFolder = faceMyingheiRadioButton3;
        this.musicListStyleGroup = radioGroup;
        this.musicListStyleTrack = faceMyingheiRadioButton4;
        this.musicListTotalTime = compasseTextView2;
        this.musicMainAudioEmpty = faceMyingheiTextView;
        this.musicMainFragBlurImg = fragmentContainerView;
        this.musicStorageAll = faceMyingheiRadioButton5;
        this.musicStorageFavorite = faceMyingheiRadioButton6;
        this.musicStorageGroup = radioGroup2;
        this.musicStorageHost = faceMyingheiRadioButton7;
        this.musicStorageScrollview = scrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MusicMainFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MusicMainFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.music_main_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MusicMainFragmentBinding bind(View view) {
        int i = R.id.browser_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.fragmentContainerView2;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guide1);
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, R.id.guide2);
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, R.id.guide3);
                i = R.id.music_ctr_album;
                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i);
                if (circleImageView != null) {
                    i = R.id.music_ctr_artist;
                    SemiboldTextView semiboldTextView = (SemiboldTextView) ViewBindings.findChildViewById(view, i);
                    if (semiboldTextView != null) {
                        i = R.id.music_ctr_next;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.music_ctr_play;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.music_ctr_prev;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.music_ctr_title;
                                    SemiboldTextView semiboldTextView2 = (SemiboldTextView) ViewBindings.findChildViewById(view, i);
                                    if (semiboldTextView2 != null) {
                                        i = R.id.music_list_play_progressbar;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                        if (progressBar != null) {
                                            i = R.id.music_list_play_time;
                                            CompasseTextView compasseTextView = (CompasseTextView) ViewBindings.findChildViewById(view, i);
                                            if (compasseTextView != null) {
                                                i = R.id.music_list_style_album;
                                                FaceMyingheiRadioButton faceMyingheiRadioButton = (FaceMyingheiRadioButton) ViewBindings.findChildViewById(view, i);
                                                if (faceMyingheiRadioButton != null) {
                                                    i = R.id.music_list_style_artist;
                                                    FaceMyingheiRadioButton faceMyingheiRadioButton2 = (FaceMyingheiRadioButton) ViewBindings.findChildViewById(view, i);
                                                    if (faceMyingheiRadioButton2 != null) {
                                                        i = R.id.music_list_style_folder;
                                                        FaceMyingheiRadioButton faceMyingheiRadioButton3 = (FaceMyingheiRadioButton) ViewBindings.findChildViewById(view, i);
                                                        if (faceMyingheiRadioButton3 != null) {
                                                            i = R.id.music_list_style_group;
                                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                                            if (radioGroup != null) {
                                                                i = R.id.music_list_style_track;
                                                                FaceMyingheiRadioButton faceMyingheiRadioButton4 = (FaceMyingheiRadioButton) ViewBindings.findChildViewById(view, i);
                                                                if (faceMyingheiRadioButton4 != null) {
                                                                    i = R.id.music_list_total_time;
                                                                    CompasseTextView compasseTextView2 = (CompasseTextView) ViewBindings.findChildViewById(view, i);
                                                                    if (compasseTextView2 != null) {
                                                                        i = R.id.music_main_audio_empty;
                                                                        FaceMyingheiTextView faceMyingheiTextView = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                        if (faceMyingheiTextView != null) {
                                                                            i = R.id.music_main_frag_blur_img;
                                                                            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                                                                            if (fragmentContainerView != null) {
                                                                                i = R.id.music_storage_all;
                                                                                FaceMyingheiRadioButton faceMyingheiRadioButton5 = (FaceMyingheiRadioButton) ViewBindings.findChildViewById(view, i);
                                                                                if (faceMyingheiRadioButton5 != null) {
                                                                                    i = R.id.music_storage_favorite;
                                                                                    FaceMyingheiRadioButton faceMyingheiRadioButton6 = (FaceMyingheiRadioButton) ViewBindings.findChildViewById(view, i);
                                                                                    if (faceMyingheiRadioButton6 != null) {
                                                                                        i = R.id.music_storage_group;
                                                                                        RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                                                                        if (radioGroup2 != null) {
                                                                                            i = R.id.music_storage_host;
                                                                                            FaceMyingheiRadioButton faceMyingheiRadioButton7 = (FaceMyingheiRadioButton) ViewBindings.findChildViewById(view, i);
                                                                                            if (faceMyingheiRadioButton7 != null) {
                                                                                                i = R.id.music_storage_scrollview;
                                                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                                if (scrollView != null) {
                                                                                                    return new MusicMainFragmentBinding((ConstraintLayout) view, recyclerView, constraintLayout, guideline, guideline2, guideline3, circleImageView, semiboldTextView, imageView, imageView2, imageView3, semiboldTextView2, progressBar, compasseTextView, faceMyingheiRadioButton, faceMyingheiRadioButton2, faceMyingheiRadioButton3, radioGroup, faceMyingheiRadioButton4, compasseTextView2, faceMyingheiTextView, fragmentContainerView, faceMyingheiRadioButton5, faceMyingheiRadioButton6, radioGroup2, faceMyingheiRadioButton7, scrollView);
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
