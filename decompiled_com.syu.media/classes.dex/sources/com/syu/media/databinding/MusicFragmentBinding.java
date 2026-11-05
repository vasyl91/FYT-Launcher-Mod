package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;
import com.syu.media.companion.view.fons.CompasseTextView;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;
import com.syu.media.companion.view.fons.SemiboldTextView;
import com.syu.media.music.widget.SpinRecyclerView;
import qin.widgets.JRecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class MusicFragmentBinding implements ViewBinding {
    public final AppCompatImageView ivListEmpty;
    public final FaceMyingheiTextView musicAlbumTitle;
    public final SemiboldTextView musicArtist;
    public final CardView musicAudioEmptyAlbum;
    public final CheckBox musicFavorite;
    public final FragmentContainerView musicFragBlurImg;
    public final FaceMyingheiTextView musicList;
    public final View musicListFoldTransform;
    public final ImageView musicListUnfoldTransform;
    public final ConstraintLayout musicMainContain;
    public final ConstraintLayout musicMainListContain;
    public final ConstraintLayout musicMainListEmpty;
    public final ImageView musicMode;
    public final SemiboldTextView musicName;
    public final View musicNameLeftMargin;
    public final JRecyclerView musicPlayListRecycler;
    public final AppCompatSeekBar musicPlaySeekbar;
    public final CompasseTextView musicPlayTime;
    public final ImageView musicPlayerNext;
    public final ImageView musicPlayerPlaypause;
    public final ImageView musicPlayerPrev;
    public final ConstraintLayout musicSeekbarGroup;
    public final SpinRecyclerView musicSpinListRecycler;
    public final View musicSpinMargin;
    public final CompasseTextView musicTotalTime;
    private final ConstraintLayout rootView;

    private MusicFragmentBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, FaceMyingheiTextView faceMyingheiTextView, SemiboldTextView semiboldTextView, CardView cardView, CheckBox checkBox, FragmentContainerView fragmentContainerView, FaceMyingheiTextView faceMyingheiTextView2, View view, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView2, SemiboldTextView semiboldTextView2, View view2, JRecyclerView jRecyclerView, AppCompatSeekBar appCompatSeekBar, CompasseTextView compasseTextView, ImageView imageView3, ImageView imageView4, ImageView imageView5, ConstraintLayout constraintLayout5, SpinRecyclerView spinRecyclerView, View view3, CompasseTextView compasseTextView2) {
        this.rootView = constraintLayout;
        this.ivListEmpty = appCompatImageView;
        this.musicAlbumTitle = faceMyingheiTextView;
        this.musicArtist = semiboldTextView;
        this.musicAudioEmptyAlbum = cardView;
        this.musicFavorite = checkBox;
        this.musicFragBlurImg = fragmentContainerView;
        this.musicList = faceMyingheiTextView2;
        this.musicListFoldTransform = view;
        this.musicListUnfoldTransform = imageView;
        this.musicMainContain = constraintLayout2;
        this.musicMainListContain = constraintLayout3;
        this.musicMainListEmpty = constraintLayout4;
        this.musicMode = imageView2;
        this.musicName = semiboldTextView2;
        this.musicNameLeftMargin = view2;
        this.musicPlayListRecycler = jRecyclerView;
        this.musicPlaySeekbar = appCompatSeekBar;
        this.musicPlayTime = compasseTextView;
        this.musicPlayerNext = imageView3;
        this.musicPlayerPlaypause = imageView4;
        this.musicPlayerPrev = imageView5;
        this.musicSeekbarGroup = constraintLayout5;
        this.musicSpinListRecycler = spinRecyclerView;
        this.musicSpinMargin = view3;
        this.musicTotalTime = compasseTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MusicFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MusicFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.music_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MusicFragmentBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        JRecyclerView jRecyclerViewFindChildViewById;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, R.id.iv_list_empty);
        FaceMyingheiTextView faceMyingheiTextView = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, R.id.music_album_title);
        int i = R.id.music_artist;
        SemiboldTextView semiboldTextView = (SemiboldTextView) ViewBindings.findChildViewById(view, i);
        if (semiboldTextView != null) {
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.music_audio_empty_album);
            i = R.id.music_favorite;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
            if (checkBox != null) {
                i = R.id.music_frag_blur_img;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                if (fragmentContainerView != null) {
                    i = R.id.music_list;
                    FaceMyingheiTextView faceMyingheiTextView2 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                    if (faceMyingheiTextView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.music_list_fold_transform))) != null) {
                        i = R.id.music_list_unfold_transform;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.music_main_contain;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = R.id.music_main_list_contain;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout2 != null) {
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.music_main_list_empty);
                                    i = R.id.music_mode;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = R.id.music_name;
                                        SemiboldTextView semiboldTextView2 = (SemiboldTextView) ViewBindings.findChildViewById(view, i);
                                        if (semiboldTextView2 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.music_name_left_margin))) != null && (jRecyclerViewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.music_play_list_recycler))) != null) {
                                            i = R.id.music_play_seekbar;
                                            AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) ViewBindings.findChildViewById(view, i);
                                            if (appCompatSeekBar != null) {
                                                i = R.id.music_play_time;
                                                CompasseTextView compasseTextView = (CompasseTextView) ViewBindings.findChildViewById(view, i);
                                                if (compasseTextView != null) {
                                                    i = R.id.music_player_next;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView3 != null) {
                                                        i = R.id.music_player_playpause;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView4 != null) {
                                                            i = R.id.music_player_prev;
                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView5 != null) {
                                                                i = R.id.music_seekbar_group;
                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout4 != null) {
                                                                    i = R.id.music_spin_list_recycler;
                                                                    SpinRecyclerView spinRecyclerView = (SpinRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                    if (spinRecyclerView != null) {
                                                                        View viewFindChildViewById3 = ViewBindings.findChildViewById(view, R.id.music_spin_margin);
                                                                        i = R.id.music_total_time;
                                                                        CompasseTextView compasseTextView2 = (CompasseTextView) ViewBindings.findChildViewById(view, i);
                                                                        if (compasseTextView2 != null) {
                                                                            return new MusicFragmentBinding((ConstraintLayout) view, appCompatImageView, faceMyingheiTextView, semiboldTextView, cardView, checkBox, fragmentContainerView, faceMyingheiTextView2, viewFindChildViewById, imageView, constraintLayout, constraintLayout2, constraintLayout3, imageView2, semiboldTextView2, viewFindChildViewById2, jRecyclerViewFindChildViewById, appCompatSeekBar, compasseTextView, imageView3, imageView4, imageView5, constraintLayout4, spinRecyclerView, viewFindChildViewById3, compasseTextView2);
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
