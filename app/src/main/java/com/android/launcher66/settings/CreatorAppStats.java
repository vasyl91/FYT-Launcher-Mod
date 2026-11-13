package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;
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
        View rootView = inflater.inflate(R.layout.creator_screen, container, false);
        ConstraintLayout layout = rootView.findViewById(R.id.creator_screen);
        DrawViewAppStats canvas = new DrawViewAppStats(inflater, rootView, mContext);
        // No bar of the launcher is drawn here and none is counted with: this window is shown inside the apps
        // the user chose, where the launcher's bars do not exist, so its place is a place on the bare screen,
        // whatever the bars are set to (CanbusService puts it at the stored screen coordinates as they are).
        // The strip of the controls stays at the bottom and a double tap beside the rectangle always hides it.
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