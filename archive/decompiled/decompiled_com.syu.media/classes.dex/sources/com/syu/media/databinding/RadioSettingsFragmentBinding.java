package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;
import com.syu.media.companion.view.fons.FaceMyingheiButton;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class RadioSettingsFragmentBinding implements ViewBinding {
    public final ConstraintLayout amSensitivityLayout;
    public final ConstraintLayout constraintLayout;
    public final ConstraintLayout constraintLayout3;
    public final ConstraintLayout fmSensitivityLayout;
    public final AppCompatEditText radioAmSensity;
    public final ConstraintLayout radioAreaLayout;
    public final AppCompatEditText radioFmSensity;
    public final Guideline radioGuideCenter;
    public final ConstraintLayout radioRadioCityLayout;
    public final ConstraintLayout radioRadioEditorLayout;
    public final FaceMyingheiButton radioReset;
    public final ConstraintLayout radioSensitivityLayout;
    public final FaceMyingheiTextView radioSettingsAreaSelect;
    public final SwitchCompat radioSettingsAutoStop;
    public final FaceMyingheiButton radioSettingsCitySelect;
    public final FragmentContainerView radioSettingsFragBlurImg;
    public final Button radioSettingsRadioEditor;
    public final SwitchCompat radioSettingsRdsEnable;
    public final ConstraintLayout radioSettingsRoot;
    public final ConstraintLayout rdsEnableLayout;
    private final ConstraintLayout rootView;
    public final View textView10;
    public final View textView12;
    public final View textView13;
    public final View textView15;
    public final View textView17;
    public final View textView8;
    public final View textView9;

    private RadioSettingsFragmentBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, AppCompatEditText appCompatEditText, ConstraintLayout constraintLayout6, AppCompatEditText appCompatEditText2, Guideline guideline, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, FaceMyingheiButton faceMyingheiButton, ConstraintLayout constraintLayout9, FaceMyingheiTextView faceMyingheiTextView, SwitchCompat switchCompat, FaceMyingheiButton faceMyingheiButton2, FragmentContainerView fragmentContainerView, Button button, SwitchCompat switchCompat2, ConstraintLayout constraintLayout10, ConstraintLayout constraintLayout11, View view, View view2, View view3, View view4, View view5, View view6, View view7) {
        this.rootView = constraintLayout;
        this.amSensitivityLayout = constraintLayout2;
        this.constraintLayout = constraintLayout3;
        this.constraintLayout3 = constraintLayout4;
        this.fmSensitivityLayout = constraintLayout5;
        this.radioAmSensity = appCompatEditText;
        this.radioAreaLayout = constraintLayout6;
        this.radioFmSensity = appCompatEditText2;
        this.radioGuideCenter = guideline;
        this.radioRadioCityLayout = constraintLayout7;
        this.radioRadioEditorLayout = constraintLayout8;
        this.radioReset = faceMyingheiButton;
        this.radioSensitivityLayout = constraintLayout9;
        this.radioSettingsAreaSelect = faceMyingheiTextView;
        this.radioSettingsAutoStop = switchCompat;
        this.radioSettingsCitySelect = faceMyingheiButton2;
        this.radioSettingsFragBlurImg = fragmentContainerView;
        this.radioSettingsRadioEditor = button;
        this.radioSettingsRdsEnable = switchCompat2;
        this.radioSettingsRoot = constraintLayout10;
        this.rdsEnableLayout = constraintLayout11;
        this.textView10 = view;
        this.textView12 = view2;
        this.textView13 = view3;
        this.textView15 = view4;
        this.textView17 = view5;
        this.textView8 = view6;
        this.textView9 = view7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RadioSettingsFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RadioSettingsFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.radio_settings_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RadioSettingsFragmentBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        View viewFindChildViewById6;
        View viewFindChildViewById7;
        int i = R.id.am_sensitivity_layout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.constraintLayout;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout2 != null) {
                i = R.id.constraintLayout3;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout3 != null) {
                    i = R.id.fm_sensitivity_layout;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout4 != null) {
                        i = R.id.radio_am_sensity;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                        if (appCompatEditText != null) {
                            i = R.id.radio_area_layout;
                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout5 != null) {
                                i = R.id.radio_fm_sensity;
                                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                                if (appCompatEditText2 != null) {
                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.radio_guide_center);
                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.radio_radio_city_layout);
                                    i = R.id.radio_radio_editor_layout;
                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout7 != null) {
                                        i = R.id.radio_reset;
                                        FaceMyingheiButton faceMyingheiButton = (FaceMyingheiButton) ViewBindings.findChildViewById(view, i);
                                        if (faceMyingheiButton != null) {
                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.radio_sensitivity_layout);
                                            i = R.id.radio_settings_area_select;
                                            FaceMyingheiTextView faceMyingheiTextView = (FaceMyingheiTextView) ViewBindings.findChildViewById(view, i);
                                            if (faceMyingheiTextView != null) {
                                                i = R.id.radio_settings_auto_stop;
                                                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                if (switchCompat != null) {
                                                    FaceMyingheiButton faceMyingheiButton2 = (FaceMyingheiButton) ViewBindings.findChildViewById(view, R.id.radio_settings_city_select);
                                                    i = R.id.radio_settings_frag_blur_img;
                                                    FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                                                    if (fragmentContainerView != null) {
                                                        i = R.id.radio_settings_radio_editor;
                                                        Button button = (Button) ViewBindings.findChildViewById(view, i);
                                                        if (button != null) {
                                                            i = R.id.radio_settings_rds_enable;
                                                            SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                            if (switchCompat2 != null) {
                                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) view;
                                                                i = R.id.rds_enable_layout;
                                                                ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout10 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.textView10))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.textView12))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.textView13))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.textView15))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.textView17))) != null && (viewFindChildViewById6 = ViewBindings.findChildViewById(view, (i = R.id.textView8))) != null && (viewFindChildViewById7 = ViewBindings.findChildViewById(view, (i = R.id.textView9))) != null) {
                                                                    return new RadioSettingsFragmentBinding(constraintLayout9, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, appCompatEditText, constraintLayout5, appCompatEditText2, guideline, constraintLayout6, constraintLayout7, faceMyingheiButton, constraintLayout8, faceMyingheiTextView, switchCompat, faceMyingheiButton2, fragmentContainerView, button, switchCompat2, constraintLayout9, constraintLayout10, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7);
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
