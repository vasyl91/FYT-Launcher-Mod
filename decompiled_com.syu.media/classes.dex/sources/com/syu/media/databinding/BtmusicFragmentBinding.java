package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextClock;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;
import com.syu.media.companion.view.DigitClock;
import com.syu.media.companion.view.fons.CompasseTextView;
import com.syu.media.companion.view.fons.FaceMyingheiTextClock;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;
import com.syu.media.companion.view.fons.SemiboldTextView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class BtmusicFragmentBinding implements ViewBinding {
    public final SemiboldTextView btmusicArtist;
    public final ImageView btmusicBtBatteryBk;
    public final FaceMyingheiTextView btmusicBtConnect;
    public final ImageView btmusicBtConnectAlbum;
    public final ImageView btmusicBtConnectImg;
    public final FaceMyingheiTextView btmusicBtName;
    public final FaceMyingheiTextView btmusicBtPhoneArtist;
    public final FaceMyingheiTextView btmusicBtPhoneName;
    public final TextClock btmusicClock;
    public final DigitClock btmusicClock1;
    public final ConstraintLayout btmusicConstraintBattery;
    public final ConstraintLayout btmusicConstraintConnectInfo;
    public final ConstraintLayout btmusicConstraintLeft;
    public final ConstraintLayout btmusicConstraintMusicInfo;
    public final ConstraintLayout btmusicConstraintPhone;
    public final ImageView btmusicCtrNext;
    public final ImageView btmusicCtrPlayPause;
    public final ImageView btmusicCtrPrev;
    public final FaceMyingheiTextClock btmusicDateWeek;
    public final FaceMyingheiTextView btmusicDevices;
    public final FragmentContainerView btmusicFragBlurImg;
    public final ImageView btmusicLogoIcon;
    public final ImageView btmusicLogoIconBk;
    public final SemiboldTextView btmusicName;
    public final ProgressBar btmusicPhoneBattery;
    public final ImageView btmusicPhoneImg;
    public final ImageView btmusicPhoneImgBk;
    public final ProgressBar btmusicPhoneMiniBattery;
    public final ProgressBar btmusicPlayProgressbar;
    public final CompasseTextView btmusicPlayTime;
    public final CompasseTextView btmusicTotalTime;
    public final ImageView imageView2;
    private final ConstraintLayout rootView;

    private BtmusicFragmentBinding(ConstraintLayout constraintLayout, SemiboldTextView semiboldTextView, ImageView imageView, FaceMyingheiTextView faceMyingheiTextView, ImageView imageView2, ImageView imageView3, FaceMyingheiTextView faceMyingheiTextView2, FaceMyingheiTextView faceMyingheiTextView3, FaceMyingheiTextView faceMyingheiTextView4, TextClock textClock, DigitClock digitClock, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ImageView imageView4, ImageView imageView5, ImageView imageView6, FaceMyingheiTextClock faceMyingheiTextClock, FaceMyingheiTextView faceMyingheiTextView5, FragmentContainerView fragmentContainerView, ImageView imageView7, ImageView imageView8, SemiboldTextView semiboldTextView2, ProgressBar progressBar, ImageView imageView9, ImageView imageView10, ProgressBar progressBar2, ProgressBar progressBar3, CompasseTextView compasseTextView, CompasseTextView compasseTextView2, ImageView imageView11) {
        this.rootView = constraintLayout;
        this.btmusicArtist = semiboldTextView;
        this.btmusicBtBatteryBk = imageView;
        this.btmusicBtConnect = faceMyingheiTextView;
        this.btmusicBtConnectAlbum = imageView2;
        this.btmusicBtConnectImg = imageView3;
        this.btmusicBtName = faceMyingheiTextView2;
        this.btmusicBtPhoneArtist = faceMyingheiTextView3;
        this.btmusicBtPhoneName = faceMyingheiTextView4;
        this.btmusicClock = textClock;
        this.btmusicClock1 = digitClock;
        this.btmusicConstraintBattery = constraintLayout2;
        this.btmusicConstraintConnectInfo = constraintLayout3;
        this.btmusicConstraintLeft = constraintLayout4;
        this.btmusicConstraintMusicInfo = constraintLayout5;
        this.btmusicConstraintPhone = constraintLayout6;
        this.btmusicCtrNext = imageView4;
        this.btmusicCtrPlayPause = imageView5;
        this.btmusicCtrPrev = imageView6;
        this.btmusicDateWeek = faceMyingheiTextClock;
        this.btmusicDevices = faceMyingheiTextView5;
        this.btmusicFragBlurImg = fragmentContainerView;
        this.btmusicLogoIcon = imageView7;
        this.btmusicLogoIconBk = imageView8;
        this.btmusicName = semiboldTextView2;
        this.btmusicPhoneBattery = progressBar;
        this.btmusicPhoneImg = imageView9;
        this.btmusicPhoneImgBk = imageView10;
        this.btmusicPhoneMiniBattery = progressBar2;
        this.btmusicPlayProgressbar = progressBar3;
        this.btmusicPlayTime = compasseTextView;
        this.btmusicTotalTime = compasseTextView2;
        this.imageView2 = imageView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BtmusicFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BtmusicFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.btmusic_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BtmusicFragmentBinding bind(View view) {
        int i = R.id.btmusic_artist;
        SemiboldTextView semiboldTextView = (SemiboldTextView) ViewBindings.findChildViewById(view, i);
        if (semiboldTextView != null) {
            i = R.id.btmusic_bt_battery_bk;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.btmusic_bt_connect;
                FaceMyingheiTextView faceMyingheiTextView = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                if (faceMyingheiTextView != null) {
                    i = R.id.btmusic_bt_connect_album;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.btmusic_bt_connect_img;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.btmusic_bt_name;
                            FaceMyingheiTextView faceMyingheiTextView2 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                            if (faceMyingheiTextView2 != null) {
                                i = R.id.btmusic_bt_phone_artist;
                                FaceMyingheiTextView faceMyingheiTextView3 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                if (faceMyingheiTextView3 != null) {
                                    i = R.id.btmusic_bt_phone_name;
                                    FaceMyingheiTextView faceMyingheiTextView4 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                    if (faceMyingheiTextView4 != null) {
                                        i = R.id.btmusic_clock;
                                        TextClock textClock = (TextClock) ViewBindings.findChildViewById(view, i);
                                        if (textClock != null) {
                                            i = R.id.btmusic_clock1;
                                            DigitClock digitClock = (DigitClock) ViewBindings.findChildViewById(view, i);
                                            if (digitClock != null) {
                                                i = R.id.btmusic_constraint_battery;
                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout != null) {
                                                    i = R.id.btmusic_constraint_connect_info;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout2 != null) {
                                                        i = R.id.btmusic_constraint_left;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout3 != null) {
                                                            i = R.id.btmusic_constraint_music_info;
                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout4 != null) {
                                                                i = R.id.btmusic_constraint_phone;
                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout5 != null) {
                                                                    i = R.id.btmusic_ctr_next;
                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView4 != null) {
                                                                        i = R.id.btmusic_ctr_play_pause;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView5 != null) {
                                                                            i = R.id.btmusic_ctr_prev;
                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView6 != null) {
                                                                                i = R.id.btmusic_date_week;
                                                                                FaceMyingheiTextClock faceMyingheiTextClock = (FaceMyingheiTextClock) ViewBindings.findChildViewById(view, i);
                                                                                if (faceMyingheiTextClock != null) {
                                                                                    i = R.id.btmusic_devices;
                                                                                    FaceMyingheiTextView faceMyingheiTextView5 = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (faceMyingheiTextView5 != null) {
                                                                                        i = R.id.btmusic_frag_blur_img;
                                                                                        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                                                                                        if (fragmentContainerView != null) {
                                                                                            i = R.id.btmusic_logo_icon;
                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView7 != null) {
                                                                                                i = R.id.btmusic_logo_icon_bk;
                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView8 != null) {
                                                                                                    i = R.id.btmusic_name;
                                                                                                    SemiboldTextView semiboldTextView2 = (SemiboldTextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (semiboldTextView2 != null) {
                                                                                                        i = R.id.btmusic_phone_battery;
                                                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                                        if (progressBar != null) {
                                                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, R.id.btmusic_phone_img);
                                                                                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, R.id.btmusic_phone_img_bk);
                                                                                                            i = R.id.btmusic_phone_mini_battery;
                                                                                                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                                            if (progressBar2 != null) {
                                                                                                                i = R.id.btmusic_play_progressbar;
                                                                                                                ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                                                if (progressBar3 != null) {
                                                                                                                    i = R.id.btmusic_play_time;
                                                                                                                    CompasseTextView compasseTextView = (CompasseTextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (compasseTextView != null) {
                                                                                                                        i = R.id.btmusic_total_time;
                                                                                                                        CompasseTextView compasseTextView2 = (CompasseTextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (compasseTextView2 != null) {
                                                                                                                            i = R.id.imageView2;
                                                                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (imageView11 != null) {
                                                                                                                                return new BtmusicFragmentBinding((ConstraintLayout) view, semiboldTextView, imageView, faceMyingheiTextView, imageView2, imageView3, faceMyingheiTextView2, faceMyingheiTextView3, faceMyingheiTextView4, textClock, digitClock, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, imageView4, imageView5, imageView6, faceMyingheiTextClock, faceMyingheiTextView5, fragmentContainerView, imageView7, imageView8, semiboldTextView2, progressBar, imageView9, imageView10, progressBar2, progressBar3, compasseTextView, compasseTextView2, imageView11);
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
