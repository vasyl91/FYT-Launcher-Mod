package com.android.launcher66.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.activity.OnBackPressedCallback;

import com.android.launcher66.R;

public class CreatorAppStats extends Fragment {

    // Fragment that opens DrawViewAppStats.java where user specifies positon for in-app stats window

    private Context mContext;
    private final Helpers helpers = new Helpers();

    public CreatorAppStats() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        mContext = container.getContext();
        View rooView = inflater.inflate(R.layout.creator_stats, container, false);
        ConstraintLayout layout = rooView.findViewById(R.id.creator_stats_screen);
        DrawViewAppStats canvas = new DrawViewAppStats(inflater, rooView, mContext);
        layout.addView(canvas);
        return rooView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                helpers.setBackFromCreator(true);
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragmentSecond()).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }
}