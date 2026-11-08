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
        // The bars of the page of the statistics, as the home screen has them: the window is moved out of their way
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        int page = Math.max(0, prefs.getInt(Keys.STATS_SCREEN, 1) - 1);
        CreatorPage description = CreatorPage.of(page, new CreatorPage.Snapshot() {
            @Override
            public boolean bool(String key) {
                return prefs.getBoolean(key, false);
            }

            @Override
            public boolean boolOr(String key, boolean defaultValue) {
                return prefs.getBoolean(key, defaultValue);
            }

            @Override
            public int screenOf(String screenKey) {
                return prefs.getInt(screenKey, 1);
            }
        });
        if (rootView instanceof ConstraintLayout) {
            ConstraintLayout root = (ConstraintLayout) rootView;
            if (description.bars.top) {
                com.android.launcher66.BarConstraints.apply(root, R.id.creator_bar, R.id.creator_screen, true, false);
            }
            float share = verticalShare(mContext, prefs);
            if (description.verticalOnPage) {
                CreatorBarBand.add(mContext, prefs, root, layout, description.bars, share, page);
            }
            canvas.setBars(CreatorBarMarks.install(root, rootView.findViewById(R.id.creator_bar), description.bars, share),
                    description.horizontalOnPage && !description.bars.collapsible && description.bars.top
                            ? HorizontalBarDimensions.boxBarHeight(mContext, prefs) : 0);
        }
        canvas.addRectangle("AppStats", "appStats", "#0ca7f5", false);
        if (layout != null) {
            layout.addView(canvas);
        }
        return rootView;
    }

    /** The vertical bar's width as a share of the launcher's box, as CreatorScreen works it out. */
    private static float verticalShare(Context context, SharedPreferences prefs) {
        boolean portrait = HorizontalBarDimensions.isPortrait(context);
        android.graphics.Point screen = HorizontalBarDimensions.resolveScreenSize(context);
        int statusBarHeight = HorizontalBarDimensions.getStatusBarHeight(context.getResources());
        int rootWidth = HorizontalBarDimensions.getBarRootWidth(screen.x);
        int rootHeight = HorizontalBarDimensions.getBarRootHeight(screen.y, statusBarHeight);
        int legacy = HorizontalBarDimensions.computeLegacyBarHeight(portrait, rootWidth, rootHeight, 0);
        int width = com.android.launcher66.Launcher.calculatedVerticalBarWidth > 0
                ? com.android.launcher66.Launcher.calculatedVerticalBarWidth
                : (int) HorizontalBarDimensions.computeVerticalBarWidth(portrait, rootWidth, rootHeight, legacy);
        return rootWidth > 0 ? Math.min(0.5f, width / (float) rootWidth) : 0.071f;
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