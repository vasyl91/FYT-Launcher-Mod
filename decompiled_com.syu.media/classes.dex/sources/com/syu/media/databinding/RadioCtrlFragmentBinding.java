package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;
import com.syu.media.companion.view.fons.SemiboldTextView;
import qin.widgets.VernierRulerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class RadioCtrlFragmentBinding implements ViewBinding {
    public final ConstraintLayout constraintLayoutFreq;
    public final HorizontalScrollView horizontalScrollView;
    public final ImageView radioAlbum;
    public final CardView radioAlbumCardview;
    public final ImageView radioAlbumCover;
    public final ImageView radioCtrAf;
    public final ImageView radioCtrBand;
    public final CheckBox radioCtrFavorite;
    public final ImageView radioCtrLoc;
    public final ImageView radioCtrNext;
    public final ImageView radioCtrPrev;
    public final ImageView radioCtrPty;
    public final ImageView radioCtrRdsEnable;
    public final VernierRulerView radioCtrRuler;
    public final ImageView radioCtrSave;
    public final ImageView radioCtrScan;
    public final ImageView radioCtrSettings;
    public final ImageView radioCtrSt;
    public final ImageView radioCtrTa;
    public final FaceMyingheiTextView radioCtrTitle;
    public final FaceMyingheiTextView radioCtrUnit;
    public final FaceMyingheiTextView radioCurrAf;
    public final FaceMyingheiTextView radioCurrBand;
    public final SemiboldTextView radioCurrFreq;
    public final FaceMyingheiTextView radioCurrLoc;
    public final FaceMyingheiTextView radioCurrPs;
    public final FaceMyingheiTextView radioCurrPty;
    public final FaceMyingheiTextView radioCurrRds;
    public final FaceMyingheiTextView radioCurrScan;
    public final FaceMyingheiTextView radioCurrSt;
    public final FaceMyingheiTextView radioCurrTa;
    public final FaceMyingheiTextView radioCurrTp;
    private final ConstraintLayout rootView;
    public final FaceMyingheiTextView textView10;

    private RadioCtrlFragmentBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, HorizontalScrollView horizontalScrollView, ImageView imageView, CardView cardView, ImageView imageView2, ImageView imageView3, ImageView imageView4, CheckBox checkBox, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, VernierRulerView vernierRulerView, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, FaceMyingheiTextView faceMyingheiTextView, FaceMyingheiTextView faceMyingheiTextView2, FaceMyingheiTextView faceMyingheiTextView3, FaceMyingheiTextView faceMyingheiTextView4, SemiboldTextView semiboldTextView, FaceMyingheiTextView faceMyingheiTextView5, FaceMyingheiTextView faceMyingheiTextView6, FaceMyingheiTextView faceMyingheiTextView7, FaceMyingheiTextView faceMyingheiTextView8, FaceMyingheiTextView faceMyingheiTextView9, FaceMyingheiTextView faceMyingheiTextView10, FaceMyingheiTextView faceMyingheiTextView11, FaceMyingheiTextView faceMyingheiTextView12, FaceMyingheiTextView faceMyingheiTextView13) {
        this.rootView = constraintLayout;
        this.constraintLayoutFreq = constraintLayout2;
        this.horizontalScrollView = horizontalScrollView;
        this.radioAlbum = imageView;
        this.radioAlbumCardview = cardView;
        this.radioAlbumCover = imageView2;
        this.radioCtrAf = imageView3;
        this.radioCtrBand = imageView4;
        this.radioCtrFavorite = checkBox;
        this.radioCtrLoc = imageView5;
        this.radioCtrNext = imageView6;
        this.radioCtrPrev = imageView7;
        this.radioCtrPty = imageView8;
        this.radioCtrRdsEnable = imageView9;
        this.radioCtrRuler = vernierRulerView;
        this.radioCtrSave = imageView10;
        this.radioCtrScan = imageView11;
        this.radioCtrSettings = imageView12;
        this.radioCtrSt = imageView13;
        this.radioCtrTa = imageView14;
        this.radioCtrTitle = faceMyingheiTextView;
        this.radioCtrUnit = faceMyingheiTextView2;
        this.radioCurrAf = faceMyingheiTextView3;
        this.radioCurrBand = faceMyingheiTextView4;
        this.radioCurrFreq = semiboldTextView;
        this.radioCurrLoc = faceMyingheiTextView5;
        this.radioCurrPs = faceMyingheiTextView6;
        this.radioCurrPty = faceMyingheiTextView7;
        this.radioCurrRds = faceMyingheiTextView8;
        this.radioCurrScan = faceMyingheiTextView9;
        this.radioCurrSt = faceMyingheiTextView10;
        this.radioCurrTa = faceMyingheiTextView11;
        this.radioCurrTp = faceMyingheiTextView12;
        this.textView10 = faceMyingheiTextView13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RadioCtrlFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RadioCtrlFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.radio_ctrl_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RadioCtrlFragmentBinding bind(View view) {
        VernierRulerView vernierRulerViewFindChildViewById;
        int i = R.id.constraintLayout_freq;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.horizontalScrollView;
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
            if (horizontalScrollView != null) {
                i = R.id.radio_album;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.radio_album_cardview;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView != null) {
                        i = R.id.radio_album_cover;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.radio_ctr_af;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.radio_ctr_band;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView4 != null) {
                                    i = R.id.radio_ctr_favorite;
                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                                    if (checkBox != null) {
                                        i = R.id.radio_ctr_loc;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView5 != null) {
                                            i = R.id.radio_ctr_next;
                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView6 != null) {
                                                i = R.id.radio_ctr_prev;
                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView7 != null) {
                                                    i = R.id.radio_ctr_pty;
                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView8 != null) {
                                                        i = R.id.radio_ctr_rds_enable;
                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView9 != null && (vernierRulerViewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.radio_ctr_ruler))) != null) {
                                                            i = R.id.radio_ctr_save;
                                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView10 != null) {
                                                                i = R.id.radio_ctr_scan;
                                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView11 != null) {
                                                                    i = R.id.radio_ctr_settings;
                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView12 != null) {
                                                                        i = R.id.radio_ctr_st;
                                                                        ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView13 != null) {
                                                                            i = R.id.radio_ctr_ta;
                                                                            ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView14 != null) {
                                                                                i = R.id.radio_ctr_title;
                                                                                FaceMyingheiTextView faceMyingheiTextView = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                if (faceMyingheiTextView != null) {
                                                                                    FaceMyingheiTextView faceMyingheiTextView2 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, R.id.radio_ctr_unit);
                                                                                    i = R.id.radio_curr_af;
                                                                                    FaceMyingheiTextView faceMyingheiTextView3 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (faceMyingheiTextView3 != null) {
                                                                                        i = R.id.radio_curr_band;
                                                                                        FaceMyingheiTextView faceMyingheiTextView4 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (faceMyingheiTextView4 != null) {
                                                                                            i = R.id.radio_curr_freq;
                                                                                            SemiboldTextView semiboldTextView = (SemiboldTextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (semiboldTextView != null) {
                                                                                                i = R.id.radio_curr_loc;
                                                                                                FaceMyingheiTextView faceMyingheiTextView5 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (faceMyingheiTextView5 != null) {
                                                                                                    i = R.id.radio_curr_ps;
                                                                                                    FaceMyingheiTextView faceMyingheiTextView6 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (faceMyingheiTextView6 != null) {
                                                                                                        i = R.id.radio_curr_pty;
                                                                                                        FaceMyingheiTextView faceMyingheiTextView7 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (faceMyingheiTextView7 != null) {
                                                                                                            i = R.id.radio_curr_rds;
                                                                                                            FaceMyingheiTextView faceMyingheiTextView8 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (faceMyingheiTextView8 != null) {
                                                                                                                i = R.id.radio_curr_scan;
                                                                                                                FaceMyingheiTextView faceMyingheiTextView9 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (faceMyingheiTextView9 != null) {
                                                                                                                    i = R.id.radio_curr_st;
                                                                                                                    FaceMyingheiTextView faceMyingheiTextView10 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (faceMyingheiTextView10 != null) {
                                                                                                                        i = R.id.radio_curr_ta;
                                                                                                                        FaceMyingheiTextView faceMyingheiTextView11 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (faceMyingheiTextView11 != null) {
                                                                                                                            i = R.id.radio_curr_tp;
                                                                                                                            FaceMyingheiTextView faceMyingheiTextView12 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (faceMyingheiTextView12 != null) {
                                                                                                                                return new RadioCtrlFragmentBinding((ConstraintLayout) view, constraintLayout, horizontalScrollView, imageView, cardView, imageView2, imageView3, imageView4, checkBox, imageView5, imageView6, imageView7, imageView8, imageView9, vernierRulerViewFindChildViewById, imageView10, imageView11, imageView12, imageView13, imageView14, faceMyingheiTextView, faceMyingheiTextView2, faceMyingheiTextView3, faceMyingheiTextView4, semiboldTextView, faceMyingheiTextView5, faceMyingheiTextView6, faceMyingheiTextView7, faceMyingheiTextView8, faceMyingheiTextView9, faceMyingheiTextView10, faceMyingheiTextView11, faceMyingheiTextView12, (FaceMyingheiTextView) ViewBindings.findChildViewById(view, R.id.textView10));
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
