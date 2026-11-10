package com.syu.media.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.syu.media.R;
import com.syu.media.companion.view.fons.FaceMyingheiRadioButton;
import qin.widgets.JRecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class RadioListFragmentBinding implements ViewBinding {
    public final Guideline guide1;
    public final Guideline guide2;
    public final FaceMyingheiRadioButton radioListAm;
    public final FaceMyingheiRadioButton radioListFavorite;
    public final FaceMyingheiRadioButton radioListFm;
    public final RadioGroup radioListGroup;
    public final JRecyclerView radioStationList;
    private final ConstraintLayout rootView;

    private RadioListFragmentBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, FaceMyingheiRadioButton faceMyingheiRadioButton, FaceMyingheiRadioButton faceMyingheiRadioButton2, FaceMyingheiRadioButton faceMyingheiRadioButton3, RadioGroup radioGroup, JRecyclerView jRecyclerView) {
        this.rootView = constraintLayout;
        this.guide1 = guideline;
        this.guide2 = guideline2;
        this.radioListAm = faceMyingheiRadioButton;
        this.radioListFavorite = faceMyingheiRadioButton2;
        this.radioListFm = faceMyingheiRadioButton3;
        this.radioListGroup = radioGroup;
        this.radioStationList = jRecyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RadioListFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RadioListFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.radio_list_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RadioListFragmentBinding bind(View view) {
        JRecyclerView jRecyclerViewFindChildViewById;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guide1);
        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, R.id.guide2);
        int i = R.id.radio_list_am;
        FaceMyingheiRadioButton faceMyingheiRadioButton = (FaceMyingheiRadioButton) ViewBindings.findChildViewById(view, i);
        if (faceMyingheiRadioButton != null) {
            i = R.id.radio_list_favorite;
            FaceMyingheiRadioButton faceMyingheiRadioButton2 = (FaceMyingheiRadioButton) ViewBindings.findChildViewById(view, i);
            if (faceMyingheiRadioButton2 != null) {
                i = R.id.radio_list_fm;
                FaceMyingheiRadioButton faceMyingheiRadioButton3 = (FaceMyingheiRadioButton) ViewBindings.findChildViewById(view, i);
                if (faceMyingheiRadioButton3 != null) {
                    i = R.id.radio_list_group;
                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                    if (radioGroup != null && (jRecyclerViewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.radio_station_list))) != null) {
                        return new RadioListFragmentBinding((ConstraintLayout) view, guideline, guideline2, faceMyingheiRadioButton, faceMyingheiRadioButton2, faceMyingheiRadioButton3, radioGroup, jRecyclerViewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
