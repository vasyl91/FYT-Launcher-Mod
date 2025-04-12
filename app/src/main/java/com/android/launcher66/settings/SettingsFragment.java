package com.android.launcher66.settings;

import android.app.Dialog;
import android.app.WallpaperManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.TwoStatePreference;

import com.android.async.AsyncTask;
import com.android.launcher66.DeviceProfile;
import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherAppState;
import com.android.launcher66.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SettingsFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceClickListener, HomeWatcher.OnHomePressedListener {

    // Fragment for the first window in the settings

    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor editor;
    private HomeWatcher mHomeWatcher;
    private Context mContext;
    private final Helpers helpers = new Helpers();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private View rootView;
    private static final String STATUSBAR = "transparent_statusbar";
    private static final String USER_LAYOUT = "user_layout";
    private static final String USER_INIT_LAYOUT = "user_init_layout";
    private static final String CREATOR_FIRST = "launcher_creator_first";
    private static final String FYT_DATA = "fyt_data"; 
    private static final String DEVICE_SETTINGS = "device_settings";
    private static final String NOTIFICATION_SETTINGS = "notification_settings";
    private static final String ACCESSIBILITY_SETTINGS = "accessibility_settings";
    private static final String WALLPAPER_PICKER = "wallpaper_picker";  
    private static final String ALL_APPS_TEXT_SIZE = "all_apps_textSize"; 
    private static final String WORKSPACE_TEXT_SIZE = "workspace_textSize"; 
    private static final String NIGHT_MODE = "night_mode";     
    private static final String DEFAULT_WALLPAPERS = "default_wallpapers";
    private static final String SAVE_DAY_WALLPAPER = "save_day_wallpaper";    
    private static final String SAVE_NIGHT_WALLPAPER = "save_night_wallpaper";
    private static final String BRIGHTNESS_PREF = "brightness";
    private static final String DAY_SEEK_BAR = "day_seek_bar";
    private static final String NIGHT_SEEK_BAR = "night_seek_bar";
    private static final String SUNRISE_CORRECTION = "sunrise_correction";
    private static final String SUNSET_CORRECTION = "sunset_correction";
    private boolean initLayout;
    private boolean userLayoutBool;
    private boolean initStatusbar;
    private boolean userStatusbarBool;
    private boolean initFyt;
    private boolean userFytBool;
    private boolean nightModeBool;
    private boolean defaultWallpapersBool;
    private boolean wallpaperSet = false;
    private boolean brightnessBool;    
    private Preference allAppsTextSize; 
    private EditText allAppsTextSizeEditText;
    private AlertDialog alertAllAppsTextSizeDialog;
    private Preference workspaceTextSize;
    private EditText workspaceTextSizeEditText;
    private AlertDialog alertWorkspaceTextSizeDialog;
    private Preference nightMode;
    private PreferenceCategory wallpapersCategory;
    private Preference defaultWallpapers;
    private Preference saveDayWallpaper;
    private Preference saveNightWallpaper;
    private Preference brightnessPref;
    private PreferenceCategory brightnessCategory;
    private Preference dayTitle;
    private Preference nightTitle;
    private BrightnessSeekBarPreference daySeekBar;
    private BrightnessSeekBarPreference nightSeekBar;
    private PreferenceCategory correctionCategory;
    private Preference sunriseTitleAndSummary;
    private Preference sunsetTitleAndSummary;
    private CorrectionSeekBarPreference sunriseCorrectionSeekBar;
    private CorrectionSeekBarPreference sunsetCorrectionSeekBar;
    private static Dialog loadingDialog;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        this.mContext = this.getContext();
        helpers.setLayoutTypeChanged(false);
        mHomeWatcher = new HomeWatcher(getActivity());
        mHomeWatcher.setOnHomePressedListener(this);
        mHomeWatcher.startWatch();
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.requireContext());
        editor = sharedPrefs.edit();
        initStatusbar = sharedPrefs.getBoolean(STATUSBAR, false);
        initLayout = sharedPrefs.getBoolean(USER_INIT_LAYOUT, false);
        initFyt = sharedPrefs.getBoolean(FYT_DATA, false);
        addPreferencesFromResource(R.xml.launcher_preferences);
        Preference transparentStatusbar = findPreference(STATUSBAR);
        Preference userLayout = findPreference(USER_LAYOUT);
        Preference launcherCreatorFirst = findPreference(CREATOR_FIRST);
        Preference fytData = findPreference(FYT_DATA);
        Preference deviceSettings = findPreference(DEVICE_SETTINGS);
        Preference notificationPreference = findPreference(NOTIFICATION_SETTINGS);
        Preference accessibilityPreference = findPreference(ACCESSIBILITY_SETTINGS);
        Preference wallpaperPicker = findPreference(WALLPAPER_PICKER);

        allAppsTextSize = findPreference(ALL_APPS_TEXT_SIZE);
        String allAppsTextSizeStr = sharedPrefs.getString(ALL_APPS_TEXT_SIZE, "18");
        allAppsTextSize.setSummary(allAppsTextSizeStr);
        dialogAllAppsTextSizeEditText();


        workspaceTextSize = findPreference(WORKSPACE_TEXT_SIZE);
        String workspaceTextSizeStr = sharedPrefs.getString(WORKSPACE_TEXT_SIZE, "28");
        workspaceTextSize.setSummary(workspaceTextSizeStr);
        dialogWorkspaceTextSizeEditText();

        nightMode = findPreference(NIGHT_MODE);
        wallpapersCategory = findPreference("wallpapers_category");
        defaultWallpapers = findPreference(DEFAULT_WALLPAPERS);
        saveDayWallpaper = findPreference(SAVE_DAY_WALLPAPER);
        saveNightWallpaper = findPreference(SAVE_NIGHT_WALLPAPER);        
        brightnessPref = findPreference(BRIGHTNESS_PREF);
        brightnessCategory = findPreference("brightness_category");
        dayTitle = findPreference("day_title");
        nightTitle = findPreference("night_title");
        daySeekBar = findPreference(DAY_SEEK_BAR);
        nightSeekBar = findPreference(NIGHT_SEEK_BAR);
        correctionCategory = findPreference("correction_category");
        sunriseTitleAndSummary = findPreference("sunrise_title_and_summary");
        sunsetTitleAndSummary = findPreference("sunset_title_and_summary");
        sunriseCorrectionSeekBar = findPreference(SUNRISE_CORRECTION);
        sunsetCorrectionSeekBar = findPreference(SUNSET_CORRECTION);

        if (userLayout != null) {
            userLayout.setOnPreferenceClickListener(this);
        }
        if (launcherCreatorFirst != null) {
            launcherCreatorFirst.setOnPreferenceClickListener(this);
            userLayoutBool = sharedPrefs.getBoolean(USER_LAYOUT, false);
            getPreferenceScreen().findPreference(CREATOR_FIRST).setEnabled(userLayoutBool);
        }
        if (transparentStatusbar != null) {
            transparentStatusbar.setOnPreferenceClickListener(this);
        }
        if (fytData != null) {
            fytData.setOnPreferenceClickListener(this);
        }
        if (deviceSettings != null) {
            deviceSettings.setOnPreferenceClickListener(this);
        }
        if (notificationPreference != null) {
            notificationPreference.setOnPreferenceClickListener(this);
        }
        if (accessibilityPreference != null) {
            accessibilityPreference.setOnPreferenceClickListener(this);
        }
        if (wallpaperPicker != null) {
            wallpaperPicker.setOnPreferenceClickListener(this);
        }
        if (allAppsTextSize != null) {
            allAppsTextSize.setOnPreferenceClickListener(this);
        }
        if (workspaceTextSize != null) {
            workspaceTextSize.setOnPreferenceClickListener(this);
        }
        nightMode();
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = super.onCreateView(inflater, container, savedInstanceState);

        loadingDialog = new Dialog(requireContext());
        loadingDialog.setContentView(R.layout.dialog_loading); // Create this layout (see below)
        loadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // Make background transparent
        loadingDialog.setCancelable(false); // Prevent dismissing by touching outside

        return rootView;
    }

    private void nightMode() {
        if (nightNonNull()) {
            nightMode.setOnPreferenceClickListener(this);
            handler.post(updateSummary);
            nightModeBool = sharedPrefs.getBoolean(NIGHT_MODE, false);
            correctionCategory.setVisible(nightModeBool);
            sunriseCorrectionSeekBar.setVisible(nightModeBool);
            sunsetCorrectionSeekBar.setVisible(nightModeBool);
            sunriseTitleAndSummary.setVisible(nightModeBool);
            sunsetTitleAndSummary.setVisible(nightModeBool);
            correctionSeekBar(sunriseCorrectionSeekBar);
            correctionSeekBar(sunsetCorrectionSeekBar);
            wallpapersCategory.setVisible(nightModeBool);
            defaultWallpapers.setVisible(nightModeBool);
            brightnessCategory.setVisible(nightModeBool);            
        }
        if (wallpapersNonNull()) {
            defaultWallpapers.setOnPreferenceClickListener(this);
            saveDayWallpaper.setOnPreferenceClickListener(this);
            saveNightWallpaper.setOnPreferenceClickListener(this);
            defaultWallpapersBool = sharedPrefs.getBoolean(DEFAULT_WALLPAPERS, true);
            if (wallpaperBoolean()) {
                saveDayWallpaper.setVisible(true);
                saveNightWallpaper.setVisible(true);                
            } else {
                saveDayWallpaper.setVisible(false);
                saveNightWallpaper.setVisible(false);  
            }
        }
        if (brightnessNonNull()) {
            brightnessPref.setOnPreferenceClickListener(this);
            brightnessBool = sharedPrefs.getBoolean(BRIGHTNESS_PREF, false);
            daySeekBar.setVisible(brightnessBool);
            nightSeekBar.setVisible(brightnessBool);
            dayTitle.setVisible(brightnessBool);
            nightTitle.setVisible(brightnessBool);
            brightnessSeekBar(daySeekBar);
            brightnessSeekBar(nightSeekBar);  

        }            
    }

    private void dialogAllAppsTextSizeEditText() {
        allAppsTextSizeEditText = new EditText(this.getContext());
        allAppsTextSizeEditText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "50")});
        allAppsTextSizeEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        allAppsTextSizeEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        allAppsTextSizeEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveAllAppsTextSize();
                alertAllAppsTextSizeDialog.dismiss();
            }
            return false;
        });
    }

    private void dialogWorkspaceTextSizeEditText() {
        workspaceTextSizeEditText = new EditText(this.getContext());
        workspaceTextSizeEditText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "50")});
        workspaceTextSizeEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        workspaceTextSizeEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        workspaceTextSizeEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveWorkspaceTextSize();
                alertWorkspaceTextSizeDialog.dismiss();
            }
            return false;
        });
    }
    
    private void brightnessSeekBar(BrightnessSeekBarPreference seekPreference) {
        seekPreference.setOnSeekBarProgressChangeListener(new BrightnessSeekBarPreference.OnSeekBarProgressChangeListener() {
            @Override
            public void onProgressChanged(int progress) {
                //
            }
        });
    }
    
    private void correctionSeekBar(CorrectionSeekBarPreference seekPreference) {
        seekPreference.setOnSeekBarProgressChangeListener(new CorrectionSeekBarPreference.OnSeekBarProgressChangeListener() {
            @Override
            public void onProgressChanged(int progress) {
                handler.post(updateSummary);
                helpers.setCorrectionChanged(true);
            }
        });
    }

    private Runnable updateSummary = new Runnable() { 
        @Override
        public void run() {
            if (nightMode instanceof TwoStatePreference) {
                ((TwoStatePreference) nightMode).setSummaryOn(nightModeSumary());
            }
        }
    };
    
    private String nightModeSumary() {
        String sunriseStr = sharedPrefs.getString("sunrise", "");
        String sunsetStr = sharedPrefs.getString("sunset", "");
        String nightModeStr = getString(R.string.night_mode_summary, sunriseStr, sunsetStr);
        nightModeBool = sharedPrefs.getBoolean(NIGHT_MODE, false);
        if (nightModeBool) {
            long sunriseCorrectionValue = sharedPrefs.getInt(SUNRISE_CORRECTION, 0) * 60000L;
            long sunsetCorrectionValue = sharedPrefs.getInt(SUNSET_CORRECTION, 0) * 60000L;
            String correctionStr;
            if (sunriseCorrectionValue != 0 && sunsetCorrectionValue != 0) {
                sunriseTitleAndSummary.setSummary(getString(R.string.user_sunrise, correctTime(sunriseStr, sunriseCorrectionValue)));
                sunsetTitleAndSummary.setSummary(getString(R.string.user_sunset, correctTime(sunsetStr, sunsetCorrectionValue)));
                correctionStr = nightModeStr + getString(R.string.summary_correction_sunrise, correctTime(sunriseStr, sunriseCorrectionValue)) + getString(R.string.summary_correction_sunset, correctTime(sunsetStr, sunsetCorrectionValue));
                return correctionStr;
            } else if (sunriseCorrectionValue != 0 && sunsetCorrectionValue == 0) {
                sunriseTitleAndSummary.setSummary(getString(R.string.user_sunrise, correctTime(sunriseStr, sunriseCorrectionValue)));
                sunsetTitleAndSummary.setSummary(getString(R.string.user_sunset, sunsetStr));
                correctionStr = nightModeStr + getString(R.string.summary_correction_sunrise, correctTime(sunriseStr, sunriseCorrectionValue));
                return correctionStr;
            } else if (sunriseCorrectionValue == 0 && sunsetCorrectionValue != 0) {
                sunriseTitleAndSummary.setSummary(getString(R.string.user_sunrise, sunriseStr));
                sunsetTitleAndSummary.setSummary(getString(R.string.user_sunset, correctTime(sunsetStr, sunsetCorrectionValue)));
                correctionStr = nightModeStr + getString(R.string.summary_correction_sunset, correctTime(sunsetStr, sunsetCorrectionValue));
                return correctionStr;
            } else {
                sunriseTitleAndSummary.setSummary(getString(R.string.user_sunrise, sunriseStr));
                sunsetTitleAndSummary.setSummary(getString(R.string.user_sunset, sunsetStr));
            }
        }
        return nightModeStr;
    }
    
    public static String correctTime(String time, long milliseconds) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);

        long totalTimeMillis = TimeUnit.HOURS.toMillis(hours)
                + TimeUnit.MINUTES.toMillis(minutes)
                + TimeUnit.SECONDS.toMillis(seconds);

        totalTimeMillis += milliseconds;
        
        totalTimeMillis = totalTimeMillis % TimeUnit.DAYS.toMillis(1); // Ensure it stays within 24 hours
        if (totalTimeMillis < 0) {
            totalTimeMillis += TimeUnit.DAYS.toMillis(1); // Handle negative values
        }

        long hoursResult = TimeUnit.MILLISECONDS.toHours(totalTimeMillis);
        long minutesResult = TimeUnit.MILLISECONDS.toMinutes(totalTimeMillis) % 60;
        long secondsResult = TimeUnit.MILLISECONDS.toSeconds(totalTimeMillis) % 60;

        return String.format("%02d:%02d:%02d", hoursResult, minutesResult, secondsResult);
    }

    private boolean wallpaperBoolean() {
        return nightModeBool && !defaultWallpapersBool;
    }

    private boolean nightNonNull() {
        return nightMode != null 
        && correctionCategory != null 
        && sunriseCorrectionSeekBar != null 
        && sunsetCorrectionSeekBar != null 
        && wallpapersCategory != null 
        && defaultWallpapers != null 
        && brightnessCategory != null;
    }

    private boolean wallpapersNonNull() {
        return defaultWallpapers != null
        && saveDayWallpaper != null
        && saveNightWallpaper != null;
    }

    private boolean brightnessNonNull() {
        return brightnessPref != null
        && daySeekBar != null
        && nightSeekBar != null;
    }

    @Override
    public boolean onPreferenceClick(@NonNull Preference preference) {
        switch (preference.getKey()) {
            case USER_LAYOUT:
                userLayoutBool = sharedPrefs.getBoolean(preference.getKey(), false);
                getPreferenceScreen().findPreference(CREATOR_FIRST).setEnabled(userLayoutBool);
                break;
            case CREATOR_FIRST:
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFragmentFirst()).commit();
                break;
            case DEVICE_SETTINGS:
                Intent intentSettings = new Intent(Settings.ACTION_SETTINGS);
                intentSettings.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentSettings.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intentSettings.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                startActivity(intentSettings);
                break;
            case NOTIFICATION_SETTINGS:
                Intent intentNoti = new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
                intentNoti.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentNoti.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intentNoti.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                startActivity(intentNoti);
                break;
            case ACCESSIBILITY_SETTINGS:
                Intent intentAccessibility = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                intentAccessibility.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentAccessibility.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intentAccessibility.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                startActivity(intentAccessibility);
                break;
            case WALLPAPER_PICKER:
                onClickWallpaperPicker(rootView);
                break;
            case ALL_APPS_TEXT_SIZE:
                alertAllAppsTextSizeDialog = displayAllAppsTextSizeDialog().create();
                alertAllAppsTextSizeDialog.show();
                Button negativeButton = alertAllAppsTextSizeDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(0, 0, 80, 0);
                negativeButton.setLayoutParams(params);
                allAppsTextSizeEditText.requestFocus();
                InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(allAppsTextSizeEditText, InputMethodManager.SHOW_IMPLICIT);
                allAppsTextSizeEditText.setSelection(allAppsTextSizeEditText.getText().length());
                break;
            case WORKSPACE_TEXT_SIZE:
                alertWorkspaceTextSizeDialog = displayWorkspaceTextSizeDialog().create();
                alertWorkspaceTextSizeDialog.show();
                Button negativeButtonW = alertWorkspaceTextSizeDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                LinearLayout.LayoutParams paramsW = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                paramsW.setMargins(0, 0, 80, 0);
                negativeButtonW.setLayoutParams(paramsW);
                workspaceTextSizeEditText.requestFocus();
                InputMethodManager immW = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                immW.showSoftInput(workspaceTextSizeEditText, InputMethodManager.SHOW_IMPLICIT);
                workspaceTextSizeEditText.setSelection(workspaceTextSizeEditText.getText().length());
                break;
            case NIGHT_MODE:
                helpers.setOnCreateJobInit(false);
                nightModeBool = sharedPrefs.getBoolean(NIGHT_MODE, false);
                handler.post(updateSummary);
                correctionCategory.setVisible(nightModeBool);
                sunriseTitleAndSummary.setVisible(nightModeBool);
                sunsetTitleAndSummary.setVisible(nightModeBool);
                sunriseCorrectionSeekBar.setVisible(nightModeBool);
                sunsetCorrectionSeekBar.setVisible(nightModeBool);
                wallpapersCategory.setVisible(nightModeBool);
                defaultWallpapers.setVisible(nightModeBool);
                defaultWallpapersBool = sharedPrefs.getBoolean(DEFAULT_WALLPAPERS, true);
                if (wallpaperBoolean()) {
                    saveDayWallpaper.setVisible(true);
                    saveNightWallpaper.setVisible(true);                
                } else {
                    saveDayWallpaper.setVisible(false);
                    saveNightWallpaper.setVisible(false);  
                } 
                brightnessCategory.setVisible(nightModeBool);
                brightnessPref.setVisible(nightModeBool);
                brightnessBool = sharedPrefs.getBoolean(BRIGHTNESS_PREF, false);
                dayTitle.setVisible(nightModeBool && brightnessBool);
                nightTitle.setVisible(nightModeBool && brightnessBool);
                daySeekBar.setVisible(nightModeBool && brightnessBool);
                nightSeekBar.setVisible(nightModeBool && brightnessBool);
                break;
            case DEFAULT_WALLPAPERS:
                wallpaperSet = true;
                defaultWallpapersBool = sharedPrefs.getBoolean(DEFAULT_WALLPAPERS, true);
                if (wallpaperBoolean()) {
                    saveDayWallpaper.setVisible(true);
                    saveNightWallpaper.setVisible(true);                
                } else {
                    saveDayWallpaper.setVisible(false);
                    saveNightWallpaper.setVisible(false);  
                }
                break;
            case SAVE_DAY_WALLPAPER:
                wallpaperSet = true;
                new SaveWallpaperTask(this.mContext).execute("Day");
                break;
            case SAVE_NIGHT_WALLPAPER:
                wallpaperSet = true;
                new SaveWallpaperTask(this.mContext).execute("Night");
                break;
            case BRIGHTNESS_PREF:
                brightnessBool = sharedPrefs.getBoolean(BRIGHTNESS_PREF, false);
                dayTitle.setVisible(brightnessBool);
                nightTitle.setVisible(brightnessBool);
                daySeekBar.setVisible(brightnessBool);
                nightSeekBar.setVisible(brightnessBool);
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                userLayoutBool = sharedPrefs.getBoolean(USER_LAYOUT, false);
                userStatusbarBool = sharedPrefs.getBoolean(STATUSBAR, false);
                userFytBool = sharedPrefs.getBoolean(FYT_DATA, false);
                if (initLayout != userLayoutBool) {
                    helpers.setLayoutTypeChanged(true);
                }
                if (restartLauncher()) {
                    helpers.setBackFromCreator(false);
                    helpers.setFirstPreferenceWindow(true);
                } else {
                    helpers.setFirstPreferenceWindow(true);
                    setBrightness();
                }
                requireActivity().finish();
                Intent intentUpdateUserPage = new Intent("update.user.page");
                mContext.sendBroadcast(intentUpdateUserPage);
            }
        };
        
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    private AlertDialog.Builder displayAllAppsTextSizeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext());
        builder.setTitle(R.string.all_apps_textSize_str);
        if (allAppsTextSizeEditText.getParent() != null) {
            ((ViewGroup)allAppsTextSizeEditText.getParent()).removeView(allAppsTextSizeEditText);
        }
        builder.setView(allAppsTextSizeEditText);
        allAppsTextSizeEditText.setText(allAppsTextSize.getSummary());
        allAppsTextSizeEditText.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveAllAppsTextSize());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private AlertDialog.Builder displayWorkspaceTextSizeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext());
        builder.setTitle(R.string.workspace_textSize_str);
        if (workspaceTextSizeEditText.getParent() != null) {
            ((ViewGroup)workspaceTextSizeEditText.getParent()).removeView(workspaceTextSizeEditText);
        }
        builder.setView(workspaceTextSizeEditText);
        workspaceTextSizeEditText.setText(workspaceTextSize.getSummary());
        workspaceTextSizeEditText.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveWorkspaceTextSize());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private void saveAllAppsTextSize() {
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        grid.updateIconTextSize(Integer.parseInt(allAppsTextSizeEditText.getText().toString()));
        allAppsTextSize.setSummary(allAppsTextSizeEditText.getText().toString());
        editor.putString(ALL_APPS_TEXT_SIZE, allAppsTextSizeEditText.getText().toString());
        editor.apply();
    }

    private void saveWorkspaceTextSize() {
        workspaceTextSize.setSummary(workspaceTextSizeEditText.getText().toString());
        editor.putString(WORKSPACE_TEXT_SIZE, workspaceTextSizeEditText.getText().toString());
        editor.apply();
    }

    private boolean restartLauncher() {
        return (initLayout != userLayoutBool) 
        || initStatusbar != userStatusbarBool 
        || initFyt != userFytBool 
        || helpers.isBackFromCreator() 
        || wallpaperSet 
        || helpers.hasCorrectionChanged();
    }

    public void setBrightness() { 
        int brightness = 70;
        if (helpers.isDay() || helpers.isPolarDay()) {
            brightness = sharedPrefs.getInt(DAY_SEEK_BAR, 70);    
        } else if (!helpers.isDay() || helpers.isPerpetualNight()) {
            brightness = sharedPrefs.getInt(NIGHT_SEEK_BAR, 0);
        }
        Settings.System.putInt(this.mContext.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightness);
    }


    public void onClickWallpaperPicker(View v) {
        int pageScroll = Launcher.mWorkspace.getScrollForPage(Launcher.mWorkspace.getPageNearestToCenterOfScreen());
        Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);

        String pickerPackage = "com.android.wallpaper";
        boolean hasTargetPackage = !TextUtils.isEmpty(pickerPackage);
        try {
            if (hasTargetPackage && this.mContext.getPackageManager().getApplicationInfo(pickerPackage, 0).enabled) {
                intent.setPackage(pickerPackage);
            }
        } catch (PackageManager.NameNotFoundException ex) {
        }

        intent.setSourceBounds(getViewBounds(v));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this.mContext, "activity_not_found", Toast.LENGTH_SHORT).show();
        }
    }

    public Rect getViewBounds(View v) {
        int[] pos = new int[2];
        v.getLocationOnScreen(pos);
        return new Rect(pos[0], pos[1], pos[0] + v.getWidth(), pos[1] + v.getHeight());
    }

    @Override
    public void onStop() {
        super.onStop();
        mHomeWatcher.setOnHomePressedListener(null);
        mHomeWatcher.stopWatch();
    }

    public static void showLoading() {
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    public static void hideLoading() {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }
    
    private class SaveWallpaperTask extends AsyncTask<String, Void, Boolean> {
        private final Context mContext;
        private final WallpaperManager mWallpaperManager;
        private String daytime = "";
        
        public SaveWallpaperTask(Context context) {
            this.mContext = context;
            mWallpaperManager = WallpaperManager.getInstance(this.mContext);
        }

        @Override
        protected Boolean doInBackground(String[] input) {
            daytime = input[0];
            saveWallpaper(input[0]);
            return true;
        }

        private void saveWallpaper(String name) {
            requireActivity().runOnUiThread(() -> showLoading());
            Drawable mWallpaper = mWallpaperManager.getDrawable();
            Bitmap mBitmap = drawableToBitmap(mWallpaper);
            File mFile = new File(this.mContext.getFilesDir(), "wallpaper_img"); // dir: /data/user/0/com.android.launcher66/files/wallpaper_img
            Log.i("dir", String.valueOf(this.mContext.getFilesDir()));
            boolean doSave = true;
            if (!mFile.exists()) {
                doSave = mFile.mkdirs();
            }            
            if (doSave) {
                saveBitmapToFile(mFile, name + ".png", mBitmap);
            }  
            File image = new File(mFile, name + ".png");
            Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath());
            try {
                // setting wallpaper that has just been saved to file allows to get accurate hash code
                mWallpaperManager.setBitmap(bitmap);
                // get hash of newly saved and set wallpaper
                saveBitmapHash(daytime); 
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    
        public Bitmap drawableToBitmap(Drawable drawable) {
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        }

        public Bitmap normalizeBitmap(Bitmap bitmap) {
            Bitmap normalizedBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(normalizedBitmap);
            canvas.drawBitmap(bitmap, 0, 0, null);
            return normalizedBitmap;
        }

        public void saveBitmapHash(String name) {
            Drawable mWallpaper = mWallpaperManager.getDrawable();
            Bitmap currentWallpaperBitmap = drawableToBitmap(mWallpaper);

            Bitmap normalizedBitmap = normalizeBitmap(currentWallpaperBitmap);
            
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            normalizedBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();

            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                byte[] hashBytes = digest.digest(byteArray);

                StringBuilder hexString = new StringBuilder();
                for (byte b : hashBytes) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.putString(name + "_hash", hexString.toString());
                editor.apply();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        
        public void saveBitmapToFile(File dir, String fileName, Bitmap bm) {
            File imageFile = new File(dir, fileName);
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(imageFile);
                bm.compress(Bitmap.CompressFormat.PNG, 100, out);
                out.close();
            }
            catch (IOException e) {
                Log.e("SettingsFragment", Objects.requireNonNull(e.getMessage()));
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        
        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                requireActivity().runOnUiThread(() -> hideLoading());
                Log.d("SettingsFragment", "Wallpaper saved successfully.");
                showToast(this.mContext.getString(R.string.wallpaper_set, daytime));
            } else {
                requireActivity().runOnUiThread(() -> hideLoading());
                Log.d("SettingsFragment", "Wallpaper was not saved.");
                showToast(this.mContext.getString(R.string.wallpaper_not_set, daytime));
            }
        }
        
        @Override
        protected void onBackgroundError(Exception e) {
            Log.e("SettingsFragment", "Background error, wallpaper was not saved: " + e.getMessage());     
            showToast(this.mContext.getString(R.string.wallpaper_error, daytime) + e.getMessage());
        }

        private void showToast(String message) {
            LayoutInflater inflater = LayoutInflater.from(this.mContext);
            View toastLayout = inflater.inflate(R.layout.toast, null);
            TextView text = toastLayout.findViewById(R.id.toast_text);
            text.setText(message);
            text.setTextSize(30);
            Toast toast = Toast.makeText(this.mContext, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setView(toastLayout);
            toast.show();
        }
    }
}