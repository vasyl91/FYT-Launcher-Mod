package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Space;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;
import com.syu.media.companion.view.fons.FaceMyingheiButton;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;
import com.syu.media.companion.view.fons.SemiboldTextView;
import com.syu.media.music.widget.SpinRecyclerView;
import qin.widgets.JRecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class OnlineFragmentBinding implements ViewBinding {
    public final FaceMyingheiButton onlineArea;
    public final CardView onlineAudioEmptyAlbum;
    public final FaceMyingheiButton onlineCountry;
    public final CheckBox onlineFavorite;
    public final FragmentContainerView onlineFragBlurImg;
    public final ImageView onlineImportStep;
    public final FaceMyingheiTextView onlineList;
    public final ConstraintLayout onlineMainContain;
    public final ConstraintLayout onlineMainListContain;
    public final SemiboldTextView onlineName;
    public final Space onlineNameLeftMargin;
    public final JRecyclerView onlinePlayListRecycler;
    public final ImageView onlinePlayerNext;
    public final ImageView onlinePlayerPlaypause;
    public final ImageView onlinePlayerPrev;
    public final ConstraintLayout onlineSeekbarGroup;
    public final SpinRecyclerView onlineSpinListRecycler;
    public final Space onlineSpinMargin;
    public final FaceMyingheiButton onlineType;
    private final ConstraintLayout rootView;

    private OnlineFragmentBinding(ConstraintLayout constraintLayout, FaceMyingheiButton faceMyingheiButton, CardView cardView, FaceMyingheiButton faceMyingheiButton2, CheckBox checkBox, FragmentContainerView fragmentContainerView, ImageView imageView, FaceMyingheiTextView faceMyingheiTextView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, SemiboldTextView semiboldTextView, Space space, JRecyclerView jRecyclerView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout4, SpinRecyclerView spinRecyclerView, Space space2, FaceMyingheiButton faceMyingheiButton3) {
        this.rootView = constraintLayout;
        this.onlineArea = faceMyingheiButton;
        this.onlineAudioEmptyAlbum = cardView;
        this.onlineCountry = faceMyingheiButton2;
        this.onlineFavorite = checkBox;
        this.onlineFragBlurImg = fragmentContainerView;
        this.onlineImportStep = imageView;
        this.onlineList = faceMyingheiTextView;
        this.onlineMainContain = constraintLayout2;
        this.onlineMainListContain = constraintLayout3;
        this.onlineName = semiboldTextView;
        this.onlineNameLeftMargin = space;
        this.onlinePlayListRecycler = jRecyclerView;
        this.onlinePlayerNext = imageView2;
        this.onlinePlayerPlaypause = imageView3;
        this.onlinePlayerPrev = imageView4;
        this.onlineSeekbarGroup = constraintLayout4;
        this.onlineSpinListRecycler = spinRecyclerView;
        this.onlineSpinMargin = space2;
        this.onlineType = faceMyingheiButton3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static OnlineFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OnlineFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.online_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static OnlineFragmentBinding bind(View view) {
        JRecyclerView jRecyclerViewFindChildViewById;
        int i = R.id.online_area;
        FaceMyingheiButton faceMyingheiButton = (FaceMyingheiButton) ViewBindings.findChildViewById(view, i);
        if (faceMyingheiButton != null) {
            i = R.id.online_audio_empty_album;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R.id.online_country;
                FaceMyingheiButton faceMyingheiButton2 = (FaceMyingheiButton) ViewBindings.findChildViewById(view, i);
                if (faceMyingheiButton2 != null) {
                    i = R.id.online_favorite;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                    if (checkBox != null) {
                        i = R.id.online_frag_blur_img;
                        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                        if (fragmentContainerView != null) {
                            i = R.id.online_import_step;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.online_list;
                                FaceMyingheiTextView faceMyingheiTextView = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                if (faceMyingheiTextView != null) {
                                    i = R.id.online_main_contain;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout != null) {
                                        i = R.id.online_main_list_contain;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout2 != null) {
                                            i = R.id.online_name;
                                            SemiboldTextView semiboldTextView = (SemiboldTextView) ViewBindings.findChildViewById(view, i);
                                            if (semiboldTextView != null) {
                                                i = R.id.online_name_left_margin;
                                                Space space = (Space) ViewBindings.findChildViewById(view, i);
                                                if (space != null && (jRecyclerViewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.online_play_list_recycler))) != null) {
                                                    i = R.id.online_player_next;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView2 != null) {
                                                        i = R.id.online_player_playpause;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView3 != null) {
                                                            i = R.id.online_player_prev;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView4 != null) {
                                                                i = R.id.online_seekbar_group;
                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout3 != null) {
                                                                    i = R.id.online_spin_list_recycler;
                                                                    SpinRecyclerView spinRecyclerView = (SpinRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                    if (spinRecyclerView != null) {
                                                                        i = R.id.online_spin_margin;
                                                                        Space space2 = (Space) ViewBindings.findChildViewById(view, i);
                                                                        if (space2 != null) {
                                                                            i = R.id.online_type;
                                                                            FaceMyingheiButton faceMyingheiButton3 = (FaceMyingheiButton) ViewBindings.findChildViewById(view, i);
                                                                            if (faceMyingheiButton3 != null) {
                                                                                return new OnlineFragmentBinding((ConstraintLayout) view, faceMyingheiButton, cardView, faceMyingheiButton2, checkBox, fragmentContainerView, imageView, faceMyingheiTextView, constraintLayout, constraintLayout2, semiboldTextView, space, jRecyclerViewFindChildViewById, imageView2, imageView3, imageView4, constraintLayout3, spinRecyclerView, space2, faceMyingheiButton3);
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
