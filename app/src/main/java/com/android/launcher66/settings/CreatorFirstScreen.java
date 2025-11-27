package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.activity.OnBackPressedCallback;
import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

public class CreatorFirstScreen extends Fragment {

    // Fragment that opens DrawViewFirstScreen.java where user can create the layout

    private Helpers helpers;
    private SharedPreferences sharedPrefs;
    private ConstraintLayout layout;
    private DrawViewFirstScreen canvas;
    private OnBackPressedCallback backPressedCallback;

    public static boolean pip = false;
    public static boolean dualPip = false;
    public static boolean firstPip = false;
    public static boolean secondPip = false;
    public static boolean thirdPip = false;
    public static boolean fourthPip = false;
    public static boolean date = false;
    public static boolean music = false;
    public static boolean radio = false;
    public static boolean stats = false; 

    public CreatorFirstScreen() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helpers = new Helpers();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            AppCompatActivity act = (AppCompatActivity) getActivity();
            if (act != null && act.getSupportActionBar() != null) {
                act.getSupportActionBar().hide();
            }
        } catch (Exception ignore) {}
        
        Context mContext = getContext();
        if (mContext == null) {
            return null;
        }
        
        View rootView;
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        boolean leftBar = sharedPrefs.getBoolean(Keys.LEFT_BAR, false);
        pip = sharedPrefs.getBoolean(Keys.DISPLAY_PIP, false);
        dualPip = sharedPrefs.getBoolean(Keys.PIP_DUAL, false);
        firstPip = sharedPrefs.getBoolean(Keys.PIP_FIRST, false);
        secondPip = sharedPrefs.getBoolean(Keys.PIP_SECOND, false);
        thirdPip = sharedPrefs.getBoolean(Keys.PIP_THIRD, false);
        fourthPip = sharedPrefs.getBoolean(Keys.PIP_FOURTH, false);
        String firstPkg = sharedPrefs.getString(Keys.PIP_FIRST_PACKAGE, "");
        String secondPkg = sharedPrefs.getString(Keys.PIP_SECOND_PACKAGE, "");
        String thirdPkg = sharedPrefs.getString(Keys.PIP_THIRD_PACKAGE, "");
        String fourthPkg = sharedPrefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
        String pipFirstName = getAppNameFromPackage(firstPkg);
        String pipSecondName = getAppNameFromPackage(secondPkg);
        date = sharedPrefs.getBoolean(Keys.USER_DATE, true);
        music = sharedPrefs.getBoolean(Keys.USER_MUSIC, true);
        radio = sharedPrefs.getBoolean(Keys.USER_RADIO, true); 
        stats = sharedPrefs.getBoolean(Keys.USER_STATS, true);        
        if (leftBar) {           
            rootView = inflater.inflate(R.layout.creator_left, container, false);
        } else {
            rootView = inflater.inflate(R.layout.creator, container, false);
        }
        layout = rootView.findViewById(R.id.creator_first_screen);
        canvas = new DrawViewFirstScreen(inflater, rootView, mContext);
        if (pip && dualPip && !firstPip && !secondPip && compareScreens(Keys.PIP_DUAL_SCREEN)) {
            String pipDualName;
            if (TextUtils.isEmpty(pipFirstName) || TextUtils.isEmpty(pipSecondName)) {
                pipDualName = (mContext.getString(R.string.pref_dual_pip_title));
            } else {
                pipDualName = pipFirstName + " / " + pipSecondName;
            }
            canvas.addRectangle(pipDualName, "pipDual", "#55FFFFFF", true); 
        }
        if (pip && firstPip && !dualPip && compareScreens(Keys.PIP_FIRST_SCREEN)) {
            if (TextUtils.isEmpty(pipFirstName)) {
                pipFirstName = (mContext.getString(R.string.pref_first_pip_title));
            }
            canvas.addRectangle(pipFirstName, "pipFirst", "#55FFFFFF", true); 
        }
        if (pip && secondPip && !dualPip && compareScreens(Keys.PIP_SECOND_SCREEN)) {
            if (TextUtils.isEmpty(pipSecondName)) {
                pipSecondName = (mContext.getString(R.string.pref_second_pip_title));
            }
            canvas.addRectangle(pipSecondName, "pipSecond", "#55FFFFFF", true); 
        }
        if (pip && thirdPip && compareScreens(Keys.PIP_THIRD_SCREEN)) {
            String pipThirdName = getAppNameFromPackage(thirdPkg);
            if (TextUtils.isEmpty(pipThirdName)) {
                pipThirdName = (mContext.getString(R.string.pref_third_pip_title));
            }
            canvas.addRectangle(pipThirdName, "pipThird", "#55FFFFFF", true); 
        }
        if (pip && fourthPip && compareScreens(Keys.PIP_FOURTH_SCREEN)) {
            String pipFourthName = getAppNameFromPackage(fourthPkg);
            if (TextUtils.isEmpty(pipFourthName)) {
                pipFourthName = (mContext.getString(R.string.pref_fourth_pip_title));
            }
            canvas.addRectangle(pipFourthName, "pipFourth", "#55FFFFFF", true); 
        }
        if (date && compareScreens(Keys.DATE_SCREEN)) {
            canvas.addRectangle("Date", "date", "#ff4285f4", true);
        }
        if (music && compareScreens(Keys.MUSIC_SCREEN)) {
            canvas.addRectangle("Music", "music", "#FFBB86FC", true); 
        }
        if (radio && compareScreens(Keys.RADIO_SCREEN)) {
            canvas.addRectangle("Radio", "radio", "#e2e732", true);
        }
        if (stats && compareScreens(Keys.STATS_SCREEN)) {
            canvas.addRectangle("Stats", "stats", "#0ca7f5", false);
        }
        if (layout != null) {
            layout.addView(canvas);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backPressedCallback = new OnBackPressedCallback(true) {
            @Override 
            public void handleOnBackPressed() {
                if (helpers != null) {
                    helpers.setBackFromCreator(true);
                }
                if (getActivity() != null && !getActivity().isDestroyed() && !getActivity().isFinishing()) {
                    requireActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(android.R.id.content, new SettingsFragmentSecond())
                            .commit();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), backPressedCallback);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        
        // Clear all listeners and references
        try {
            if (layout != null) {
                layout.setOnClickListener(null);
                layout.setOnTouchListener(null);
                layout.removeAllViews();
                layout = null;
            }
            if (canvas != null) {
                canvas.setOnClickListener(null);
                canvas.setOnTouchListener(null);
                canvas.clearAnimation();
                canvas = null;
            }
        } catch (Exception ignore) {}
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        
        // Clean up callback
        if (backPressedCallback != null) {
            backPressedCallback.remove();
            backPressedCallback = null;
        }
        
        // Clear references
        helpers = null;
        sharedPrefs = null;
    }

    private static String getAppNameFromPackage(String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return "";
        }
        
        try {
            Context appContext = LauncherApplication.sApp;
            if (appContext != null) {
                PackageManager packageManager = appContext.getPackageManager();
                ApplicationInfo appInfo = packageManager.getApplicationInfo(packageName, 0);
                return packageManager.getApplicationLabel(appInfo).toString();
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            Log.e("CreatorFirstScreen", "Error getting app name", e);
        }
        return "";
    }

    private boolean compareScreens(String pipScreenKey) {
        int pipScreen = sharedPrefs.getInt(pipScreenKey, 1) - 1;
        int screen = 0;
        if (screen == pipScreen) {
            return true;
        } else {
            return false;
        }
    }
}