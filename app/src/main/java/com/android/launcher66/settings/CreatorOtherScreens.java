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

public class CreatorOtherScreens extends Fragment {

    // Fragment that opens DrawViewOtherScreens.java where user can create the layout

    private Helpers helpers;
    private SharedPreferences sharedPrefs;
    private ConstraintLayout layout;
    private DrawViewOtherScreens canvas;
    private OnBackPressedCallback backPressedCallback;
    private int mSelectedScreen;

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
    public static boolean overlappingMargins = false;

    public CreatorOtherScreens(int selectedScreen) {
        super();
        this.mSelectedScreen = selectedScreen;
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
        checkIfOverlappingMargins();
        if (overlappingMargins) {
            Log.i("DrawViewOtherScreens", String.valueOf(overlappingMargins));
            if (helpers != null) {
                helpers.checkAndResetIfOverlappingOnScreen(-1); 
            }
            overlappingMargins = false; 
        }
        rootView = inflater.inflate(R.layout.creator_other, container, false);
        layout = rootView.findViewById(R.id.creator_other_screens);
        canvas = new DrawViewOtherScreens(inflater, rootView, mContext, mSelectedScreen);
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
            Log.e("DrawViewOtherScreens", "Error getting app name", e);
        }
        return "";
    }

    private boolean compareScreens(String pipScreenKey) {
        int pipScreen = sharedPrefs.getInt(pipScreenKey, 1) - 1;
        if (mSelectedScreen == pipScreen) {
            return true;
        } else {
            return false;
        }
    }

    private void checkIfOverlappingMargins() {
        if (sharedPrefs == null) {
            return;
        }
        
        // Default values are set to 0 because they are basically not essential, resetPrefs overwrites them if they are all 0
        int height = getResources().getDisplayMetrics().heightPixels;
        int width = getResources().getDisplayMetrics().widthPixels;
        int margin = Integer.valueOf(sharedPrefs.getString("layout_margin", "10"));

        if (dualPip && !firstPip && !secondPip && compareScreens(Keys.PIP_DUAL_SCREEN)) {
            int pipDualTopLeftX = sharedPrefs.getInt("pipDualTopLeftX", 0);
            int pipDualTopLeftY = sharedPrefs.getInt("pipDualTopLeftY", 0);
            int pipDualTopRightX = sharedPrefs.getInt("pipDualTopRightX", 0);
            int pipDualTopRightY = sharedPrefs.getInt("pipDualTopRightY", 0);
            int pipDualBottomRightX = sharedPrefs.getInt("pipDualBottomRightX", 0);
            int pipDualBottomRightY = sharedPrefs.getInt("pipDualBottomRightY", 0);
            int pipDualBottomLeftX = sharedPrefs.getInt("pipDualBottomLeftX", 0);
            int pipDualBottomLeftY = sharedPrefs.getInt("pipDualBottomLeftY", 0);

            if (pipDualTopLeftX < margin || pipDualTopLeftY < margin 
                || pipDualTopRightX > (width - margin) || pipDualTopRightY < margin 
                || pipDualBottomRightX > (width - margin) || pipDualBottomRightY > (height - margin) 
                || pipDualBottomLeftX < margin || pipDualBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            }
        }

        if (firstPip && !dualPip && compareScreens(Keys.PIP_FIRST_SCREEN)) {
            int pipFirstTopLeftX = sharedPrefs.getInt("pipFirstTopLeftX", 0);
            int pipFirstTopLeftY = sharedPrefs.getInt("pipFirstTopLeftY", 0);
            int pipFirstTopRightX = sharedPrefs.getInt("pipFirstTopRightX", 0);
            int pipFirstTopRightY = sharedPrefs.getInt("pipFirstTopRightY", 0);
            int pipFirstBottomRightX = sharedPrefs.getInt("pipFirstBottomRightX", 0);
            int pipFirstBottomRightY = sharedPrefs.getInt("pipFirstBottomRightY", 0);
            int pipFirstBottomLeftX = sharedPrefs.getInt("pipFirstBottomLeftX", 0);
            int pipFirstBottomLeftY = sharedPrefs.getInt("pipFirstBottomLeftY", 0);

            if (pipFirstTopLeftX < margin || pipFirstTopLeftY < margin 
                || pipFirstTopRightX > (width - margin) || pipFirstTopRightY < margin 
                || pipFirstBottomRightX > (width - margin) || pipFirstBottomRightY > (height - margin) 
                || pipFirstBottomLeftX < margin || pipFirstBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            }
        }

        if (secondPip && !dualPip && compareScreens(Keys.PIP_SECOND_SCREEN)) {
            int pipSecondTopLeftX = sharedPrefs.getInt("pipSecondTopLeftX", 0);
            int pipSecondTopLeftY = sharedPrefs.getInt("pipSecondTopLeftY", 0);
            int pipSecondTopRightX = sharedPrefs.getInt("pipSecondTopRightX", 0);
            int pipSecondTopRightY = sharedPrefs.getInt("pipSecondTopRightY", 0);
            int pipSecondBottomRightX = sharedPrefs.getInt("pipSecondBottomRightX", 0);
            int pipSecondBottomRightY = sharedPrefs.getInt("pipSecondBottomRightY", 0);
            int pipSecondBottomLeftX = sharedPrefs.getInt("pipSecondBottomLeftX", 0);
            int pipSecondBottomLeftY = sharedPrefs.getInt("pipSecondBottomLeftY", 0);

            if (pipSecondTopLeftX < margin || pipSecondTopLeftY < margin 
                || pipSecondTopRightX > (width - margin) || pipSecondTopRightY < margin 
                || pipSecondBottomRightX > (width - margin) || pipSecondBottomRightY > (height - margin) 
                || pipSecondBottomLeftX < margin || pipSecondBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            }
        }

        if (thirdPip && compareScreens(Keys.PIP_THIRD_SCREEN)) {
            int pipThirdTopLeftX = sharedPrefs.getInt("pipThirdTopLeftX", 0);
            int pipThirdTopLeftY = sharedPrefs.getInt("pipThirdTopLeftY", 0);
            int pipThirdTopRightX = sharedPrefs.getInt("pipThirdTopRightX", 0);
            int pipThirdTopRightY = sharedPrefs.getInt("pipThirdTopRightY", 0);
            int pipThirdBottomRightX = sharedPrefs.getInt("pipThirdBottomRightX", 0);
            int pipThirdBottomRightY = sharedPrefs.getInt("pipThirdBottomRightY", 0);
            int pipThirdBottomLeftX = sharedPrefs.getInt("pipThirdBottomLeftX", 0);
            int pipThirdBottomLeftY = sharedPrefs.getInt("pipThirdBottomLeftY", 0);

            if (pipThirdTopLeftX < margin || pipThirdTopLeftY < margin 
                || pipThirdTopRightX > (width - margin) || pipThirdTopRightY < margin 
                || pipThirdBottomRightX > (width - margin) || pipThirdBottomRightY > (height - margin) 
                || pipThirdBottomLeftX < margin || pipThirdBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            }
        }

        if (fourthPip && compareScreens(Keys.PIP_FOURTH_SCREEN)) {
            int pipFourthTopLeftX = sharedPrefs.getInt("pipFourthTopLeftX", 0);
            int pipFourthTopLeftY = sharedPrefs.getInt("pipFourthTopLeftY", 0);
            int pipFourthTopRightX = sharedPrefs.getInt("pipFourthTopRightX", 0);
            int pipFourthTopRightY = sharedPrefs.getInt("pipFourthTopRightY", 0);
            int pipFourthBottomRightX = sharedPrefs.getInt("pipFourthBottomRightX", 0);
            int pipFourthBottomRightY = sharedPrefs.getInt("pipFourthBottomRightY", 0);
            int pipFourthBottomLeftX = sharedPrefs.getInt("pipFourthBottomLeftX", 0);
            int pipFourthBottomLeftY = sharedPrefs.getInt("pipFourthBottomLeftY", 0);

            if (pipFourthTopLeftX < margin || pipFourthTopLeftY < margin 
                || pipFourthTopRightX > (width - margin) || pipFourthTopRightY < margin 
                || pipFourthBottomRightX > (width - margin) || pipFourthBottomRightY > (height - margin) 
                || pipFourthBottomLeftX < margin || pipFourthBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            }
        }

        if (date && compareScreens(Keys.DATE_SCREEN)) {
            int dateTopLeftX = sharedPrefs.getInt("dateTopLeftX", 0);
            int dateTopLeftY = sharedPrefs.getInt("dateTopLeftY", 0);    
            int dateTopRightX = sharedPrefs.getInt("dateTopRightX", 0);
            int dateTopRightY = sharedPrefs.getInt("dateTopRightY", 0);
            int dateBottomRightX = sharedPrefs.getInt("dateBottomRightX", 0);
            int dateBottomRightY = sharedPrefs.getInt("dateBottomRightY", 0);
            int dateBottomLeftX = sharedPrefs.getInt("dateBottomLeftX", 0);
            int dateBottomLeftY = sharedPrefs.getInt("dateBottomLeftY", 0);

            if (dateTopLeftX < margin || dateTopLeftY < margin 
                || dateTopRightX > (width - margin) || dateTopRightY < margin 
                || dateBottomRightX > (width - margin) || dateBottomRightY > (height - margin) 
                || dateBottomLeftX < margin || dateBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            } 
        }

        if (music && compareScreens(Keys.MUSIC_SCREEN)) {
            int musicTopLeftX = sharedPrefs.getInt("musicTopLeftX", 0);
            int musicTopLeftY = sharedPrefs.getInt("musicTopLeftY", 0);  
            int musicTopRightX = sharedPrefs.getInt("musicTopRightX", 0);
            int musicTopRightY = sharedPrefs.getInt("musicTopRightY", 0);
            int musicBottomRightX = sharedPrefs.getInt("musicBottomRightX", 0);
            int musicBottomRightY = sharedPrefs.getInt("musicBottomRightY", 0);
            int musicBottomLeftX = sharedPrefs.getInt("musicBottomLeftX", 0);
            int musicBottomLeftY = sharedPrefs.getInt("musicBottomLeftY", 0);

            if (musicTopLeftX < margin || musicTopLeftY < margin
                || musicTopRightX > (width - margin) || musicTopRightY < margin 
                || musicBottomRightX > (width - margin) || musicBottomRightY > (height - margin) 
                || musicBottomLeftX < margin || musicBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            } 
        } 

        if (radio && compareScreens(Keys.RADIO_SCREEN)) {
            int radioTopLeftX = sharedPrefs.getInt("radioTopLeftX", 0);
            int radioTopLeftY = sharedPrefs.getInt("radioTopLeftY", 0); 
            int radioTopRightX = sharedPrefs.getInt("radioTopRightX", 0);
            int radioTopRightY = sharedPrefs.getInt("radioTopRightY", 0);
            int radioBottomRightX = sharedPrefs.getInt("radioBottomRightX", 0);
            int radioBottomRightY = sharedPrefs.getInt("radioBottomRightY", 0);
            int radioBottomLeftX = sharedPrefs.getInt("radioBottomLeftX", 0);
            int radioBottomLeftY = sharedPrefs.getInt("radioBottomLeftY", 0);

            if (radioTopLeftX < margin || radioTopLeftY < margin
                || radioTopRightX > (width - margin) || radioTopRightY < margin 
                || radioBottomRightX > (width - margin) || radioBottomRightY > (height - margin) 
                || radioBottomLeftX < margin || radioBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            } 
        }  
    }
}