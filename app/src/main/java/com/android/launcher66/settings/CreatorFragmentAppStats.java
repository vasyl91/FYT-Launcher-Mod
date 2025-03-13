package com.android.launcher66.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.activity.OnBackPressedCallback;

import com.google.android.flexbox.FlexboxLayout;
import com.android.launcher66.R;

public class CreatorFragmentAppStats extends Fragment implements HomeWatcher.OnHomePressedListener {

    // Fragment that opens DrawViewAppStats.java where user specifies positon for in-app stats window

    private HomeWatcher mHomeWatcher;
    private Context mContext;
    private final Helpers helpers = new Helpers();

    public CreatorFragmentAppStats() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        mContext = container.getContext();
        View rooView = inflater.inflate(R.layout.creator_stats, container, false);
        FlexboxLayout layout = rooView.findViewById(R.id.creator_second);
        DrawViewAppStats canvas = new DrawViewAppStats(inflater, rooView, mContext);
        layout.addView(canvas);
        return rooView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mHomeWatcher = new HomeWatcher(context);
        mHomeWatcher.setOnHomePressedListener(this);
        mHomeWatcher.startWatch();

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                helpers.setBackFromCreator(true);
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFragmentFirst()).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public void onStop() {
        super.onStop();
        mHomeWatcher.setOnHomePressedListener(null);
        mHomeWatcher.stopWatch();
    }
}