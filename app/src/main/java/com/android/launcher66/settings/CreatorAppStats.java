package com.android.launcher66.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

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
        View rootView = inflater.inflate(R.layout.creator_other, container, false);
        ConstraintLayout layout = rootView.findViewById(R.id.creator_other_screens);
        DrawViewAppStats canvas = new DrawViewAppStats(inflater, rootView, mContext);
        canvas.addRectangle("AppStats", "appStats", "#0ca7f5", false);
        if (layout != null) {
            layout.addView(canvas);
        }
        return rootView;
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