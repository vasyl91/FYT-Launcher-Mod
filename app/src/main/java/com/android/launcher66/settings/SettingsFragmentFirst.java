package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.WallpaperManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
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
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.Html;
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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.TwoStatePreference;
import androidx.recyclerview.widget.RecyclerView;

import com.android.async.AsyncTask;
import com.android.launcher66.BuildConfig;
import com.android.launcher66.DeviceProfile;
import com.android.launcher66.LauncherAppState;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.WallpaperPickerActivity;
import com.fyt.skin.SkinAttribute;
import com.fyt.skin.SkinUtils;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SettingsFragmentFirst extends PreferenceFragmentCompat implements Preference.OnPreferenceClickListener, PropertyChangeListener {

    // Fragment for the first window in the settings

    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor editor;
    private Context mContext;
    private final Helpers helpers = new Helpers();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private View rootView;
    private final PropertyChangeClass mPropertyChangeClass = new PropertyChangeClass();
    private ProgressDialog progressDialog;
    private CustomPreferenceColorAdapter customAdapter;
    private static final String TAG = "SettingsFragmentFirst";
    private int padding;
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
    private boolean logcatServiceBool;  
    private boolean tickRunnableBool = false;   
    private boolean countDownTimerBool = false;  
    private Preference settingsSecondFragment;
    private Preference allAppsTextSize; 
    private EditText allAppsTextSizeEditText;
    private AlertDialog alertAllAppsTextSizeDialog;
    private Preference workspaceTextSize;
    private EditText workspaceTextSizeEditText;
    private AlertDialog alertWorkspaceTextSizeDialog;
    private Preference nightMode;
    private PreferenceCategory wallpapersCategory;
    private SwitchPreferenceCompat defaultWallpapers;
    private Preference saveDayWallpaper;
    private Preference saveNightWallpaper;
    private SwitchPreferenceCompat brightnessPref;
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
    private PreferenceCategory resetNightModeCategory;
    private Preference resetNightMode;
    private Dialog loadingDialog;
    private AlertDialog alertUpdateDialog;
    private Preference logcatService;
    private Preference logcatRun;
    private Preference logcatServiceTimeout;
    private AlertDialog alertLogcatServiceTimeoutDialog;
    private EditText logcatServiceTimeoutEditText;
    private CountDownTimer countDownTimer;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private VersionChecker versionChecker;
    private String latestAppVersion;
    private InputMethodManager imm;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = super.onCreateView(inflater, container, savedInstanceState);

        imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.launcher_settings)); 
        }

        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }

        loadingDialog = new Dialog(requireContext());
        loadingDialog.setContentView(R.layout.dialog_loading); 
        loadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        loadingDialog.setCancelable(false); // Prevent dismissing by touching outside

        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                userLayoutBool = sharedPrefs.getBoolean(Keys.USER_LAYOUT, false);
                userStatusbarBool = sharedPrefs.getBoolean(Keys.STATUSBAR, false);
                userFytBool = sharedPrefs.getBoolean(Keys.FYT_DATA, false);
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
                long updateOnce = SystemClock.uptimeMillis();
                Log.d(TAG, "Saving pending updateOnce=" + updateOnce);
                mContext.getSharedPreferences("LauncherPrefs", Context.MODE_PRIVATE)
                    .edit()
                    .putLong(Keys.UPDATE_USER_PAGE, updateOnce)
                    .apply();
                requireActivity().finish();
            }
        };
        
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        this.mContext = this.getContext();
        helpers.setLayoutTypeChanged(false);
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.requireContext());
        editor = sharedPrefs.edit();
        mPropertyChangeClass.addObserver(Keys.DOWNLOAD_PERCENTAGE, this);
        initStatusbar = sharedPrefs.getBoolean(Keys.STATUSBAR, false);
        initLayout = sharedPrefs.getBoolean(Keys.USER_INIT_LAYOUT, false);
        initFyt = sharedPrefs.getBoolean(Keys.FYT_DATA, false);
        addPreferencesFromResource(R.xml.launcher_preferences);
        padding = SettingsActivity.dialogPadding;
        Preference transparentStatusbar = findPreference(Keys.STATUSBAR);
        Preference userLayout = findPreference(Keys.USER_LAYOUT);
        settingsSecondFragment = findPreference(Keys.CREATOR_FIRST);
        Preference fytData = findPreference(Keys.FYT_DATA);
        Preference deviceSettings = findPreference(Keys.DEVICE_SETTINGS);
        Preference notificationPreference = findPreference(Keys.NOTIFICATION_SETTINGS);
        Preference accessibilityPreference = findPreference(Keys.ACCESSIBILITY_SETTINGS);
        Preference wallpaperPicker = findPreference(Keys.WALLPAPER_PICKER);
        Preference wallpaperPickerSource = findPreference(Keys.WALLPAPER_PICKER_SOURCE);

        allAppsTextSize = findPreference(Keys.ALL_APPS_TEXT_SIZE);
        String allAppsTextSizeStr = sharedPrefs.getString(Keys.ALL_APPS_TEXT_SIZE, "18");
        allAppsTextSize.setSummary(allAppsTextSizeStr);
        dialogAllAppsTextSizeEditText();


        workspaceTextSize = findPreference(Keys.WORKSPACE_TEXT_SIZE);
        String workspaceTextSizeStr = sharedPrefs.getString(Keys.WORKSPACE_TEXT_SIZE, "28");
        workspaceTextSize.setSummary(workspaceTextSizeStr);
        dialogWorkspaceTextSizeEditText();

        nightMode = findPreference(Keys.NIGHT_MODE);
        wallpapersCategory = findPreference("wallpapers_category");
        defaultWallpapers = findPreference(Keys.DEFAULT_WALLPAPERS);
        saveDayWallpaper = findPreference(Keys.SAVE_DAY_WALLPAPER);
        saveNightWallpaper = findPreference(Keys.SAVE_NIGHT_WALLPAPER);
        brightnessPref = findPreference(Keys.BRIGHTNESS_PREF);
        brightnessCategory = findPreference("brightness_category");
        dayTitle = findPreference("day_title");
        nightTitle = findPreference("night_title");
        daySeekBar = findPreference(Keys.DAY_SEEK_BAR);
        nightSeekBar = findPreference(Keys.NIGHT_SEEK_BAR);
        correctionCategory = findPreference("correction_category");
        sunriseTitleAndSummary = findPreference("sunrise_title_and_summary");
        sunsetTitleAndSummary = findPreference("sunset_title_and_summary");
        sunriseCorrectionSeekBar = findPreference(Keys.SUNRISE_CORRECTION);
        sunsetCorrectionSeekBar = findPreference(Keys.SUNSET_CORRECTION);
        resetNightModeCategory = findPreference("reset_night_mode_category");
        resetNightMode = findPreference(Keys.RESET_NIGHT_MODE);

        PreferenceCategory logcatCategory = findPreference("logcat_category");
        logcatService = findPreference(Keys.LOGCAT_SERVICE);
        logcatRun = findPreference(Keys.LOGCAT_SERVICE_RUN);
        logcatServiceTimeout = findPreference(Keys.LOGCAT_SERVICE_TIMEOUT);
        String logcatServiceTimeoutStr = sharedPrefs.getString(Keys.LOGCAT_SERVICE_TIMEOUT, "30");
        logcatServiceTimeout.setSummary(logcatServiceTimeoutStr);
        logcatServiceTimeoutEditText();
        boolean isDebug = BuildConfig.DEBUG;

        versionChecker = new VersionChecker();
        PreferenceCategory appVersion = findPreference("app_version");
        Preference appVersionUpdate = findPreference(Keys.APP_VERSION_UPDATE);

        if (userLayout != null) {
            userLayout.setOnPreferenceClickListener(this);
        }
        if (settingsSecondFragment != null) {
            settingsSecondFragment.setOnPreferenceClickListener(this);
            userLayoutBool = sharedPrefs.getBoolean(Keys.USER_LAYOUT, false);
            settingsSecondFragment.setEnabled(userLayoutBool);
            if (userLayoutBool) {
                String summaryText = getString(R.string.layout_summary_enabled);
                settingsSecondFragment.setSummary(Html.fromHtml(summaryText, Html.FROM_HTML_MODE_LEGACY));
            } else {
                String summaryText = getString(R.string.layout_summary_disabled);
                settingsSecondFragment.setSummary(Html.fromHtml(summaryText, Html.FROM_HTML_MODE_LEGACY));
            }
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
        if (wallpaperPickerSource != null) {
            wallpaperPickerSource.setOnPreferenceClickListener(this);
        }
        if (allAppsTextSize != null) {
            allAppsTextSize.setOnPreferenceClickListener(this);
        }
        if (workspaceTextSize != null) {
            workspaceTextSize.setOnPreferenceClickListener(this);
        }
        nightMode();
        if (logcatCategory != null) {
            logcatCategory.setVisible(isDebug);
        }
        
        if (logcatService != null) {
            logcatService.setOnPreferenceClickListener(this);
            //logcatService.setVisible(isDebug);
            logcatServiceBool = sharedPrefs.getBoolean(Keys.LOGCAT_SERVICE, false);
            if (logcatServiceBool && isDebug) {
                String summaryText = getString(R.string.logcat_service_summary);
                logcatService.setSummary(Html.fromHtml(summaryText, Html.FROM_HTML_MODE_LEGACY));
            } else {
                logcatService.setSummary(null);
            }
        }
        if (logcatRun != null) {
            logcatRun.setVisible(isDebug);
            logcatRun.setOnPreferenceClickListener(this);     
            if (helpers.logcatRunBoolean()) {
                int delay = helpers.returnCountDownLogcat() * 1000;
                setCountDownTimer(delay);
                setTickRunnable(delay + 1000);
            } else {
                logcatRun.setSummary(getString(R.string.logcat_service_run_summary));
                helpers.setCountDownLogcat(0);
            }
        } 
        if (logcatServiceTimeout != null) {
            logcatServiceTimeout.setVisible(isDebug);
            logcatServiceTimeout.setOnPreferenceClickListener(this);
        }
        if (appVersion != null) {
            String currentVersion = Helpers.getAppVersion(LauncherApplication.sApp);
            appVersion.setTitle(getString(R.string.app_version, currentVersion));
            versionChecker.checkForUpdate(currentVersion, new VersionChecker.VersionCheckCallback() {
                @Override
                public void onUpdateAvailable(String latestVersion) {
                    if (isAdded()) { 
                        appVersion.setTitle(getString(R.string.app_version_update, currentVersion, latestVersion));
                        latestAppVersion = latestVersion;
                        if (appVersionUpdate != null) {
                            appVersionUpdate.setVisible(true);
                        }
                    }
                }

                @Override
                public void onUpToDate() {
                    if (isAdded()) { 
                        appVersion.setTitle(getString(R.string.app_version, currentVersion));
                        if (appVersionUpdate != null) {
                            appVersionUpdate.setVisible(false);
                        }
                    }
                }

                @Override
                public void onError(String error) {
                    if (isAdded()) { 
                        appVersion.setTitle(getString(R.string.app_version, currentVersion));
                        if (appVersionUpdate != null) {
                            appVersionUpdate.setVisible(false);
                        }
                    }
                    Log.e(TAG, error); 
                }
            });
        }
        if (appVersionUpdate != null) {
            appVersionUpdate.setOnPreferenceClickListener(this);
        }
    }

    private void nightMode() {
        if (nightNonNull()) {
            nightMode.setOnPreferenceClickListener(this);
            handler.post(updateSummary);
            nightModeBool = sharedPrefs.getBoolean(Keys.NIGHT_MODE, false);
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
            defaultWallpapersBool = sharedPrefs.getBoolean(Keys.DEFAULT_WALLPAPERS, true);
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
            brightnessBool = sharedPrefs.getBoolean(Keys.BRIGHTNESS_PREF, false);
            daySeekBar.setVisible(brightnessBool);
            nightSeekBar.setVisible(brightnessBool);
            dayTitle.setVisible(brightnessBool);
            nightTitle.setVisible(brightnessBool);
            brightnessSeekBar(daySeekBar);
            brightnessSeekBar(nightSeekBar);  

        }   
        if (resetNightMode != null && resetNightModeCategory != null) {
            resetNightMode.setOnPreferenceClickListener(this);
            resetNightMode.setVisible(nightModeBool);
            resetNightModeCategory.setVisible(nightModeBool);
        }         
    }

    @Override
    protected RecyclerView.Adapter onCreateAdapter(PreferenceScreen preferenceScreen) {
        customAdapter = new CustomPreferenceColorAdapter(this);
        if (settingsSecondFragment != null) {
            if (userLayoutBool) {
                customAdapter.setPreferenceTitleColor(Keys.CREATOR_FIRST, Color.WHITE);
            } else {
                customAdapter.setPreferenceTitleColor(Keys.CREATOR_FIRST, Color.GRAY);
            }
        }
        return customAdapter;
    }

    @Override
    public boolean onPreferenceClick(@NonNull Preference preference) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 80, 0);
        switch (preference.getKey()) {
            case Keys.USER_LAYOUT:
                userLayoutBool = sharedPrefs.getBoolean(Keys.USER_LAYOUT, false);
                settingsSecondFragment.setEnabled(userLayoutBool);
                if (userLayoutBool) {
                    String summaryText = getString(R.string.layout_summary_enabled);
                    settingsSecondFragment.setSummary(Html.fromHtml(summaryText, Html.FROM_HTML_MODE_LEGACY));
                    customAdapter.setPreferenceTitleColor(Keys.CREATOR_FIRST, Color.WHITE);
                } else {
                    String summaryText = getString(R.string.layout_summary_disabled);
                    settingsSecondFragment.setSummary(Html.fromHtml(summaryText, Html.FROM_HTML_MODE_LEGACY));
                    customAdapter.setPreferenceTitleColor(Keys.CREATOR_FIRST, Color.GRAY);
                    editor.putString(Keys.START_PAGE, "1");
                    editor.putInt(Keys.PIP_FIRST_SCREEN, 1);
                    editor.apply(); 
                }
                break;
            case Keys.CREATOR_FIRST:
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragmentSecond()).commit();
                break;
            case Keys.DEVICE_SETTINGS:
                Intent intentSettings = new Intent(Settings.ACTION_SETTINGS);
                intentSettings.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                startActivity(intentSettings);
                break;
            case Keys.NOTIFICATION_SETTINGS:
                Intent intentNoti = new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
                intentNoti.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                startActivity(intentNoti);
                break;
            case Keys.ACCESSIBILITY_SETTINGS:
                Intent intentAccessibility = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                intentAccessibility.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                startActivity(intentAccessibility);
                break;
            case Keys.WALLPAPER_PICKER:
                onClickWallpaperPicker(rootView);
                break;
            case Keys.ALL_APPS_TEXT_SIZE:
                alertAllAppsTextSizeDialog = displayAllAppsTextSizeDialog().create();
                alertAllAppsTextSizeDialog.show();

                Button negativeButton = alertAllAppsTextSizeDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                negativeButton.setLayoutParams(params);

                ViewGroup.LayoutParams editAllAppsTextParams = allAppsTextSizeEditText.getLayoutParams();
                if (editAllAppsTextParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) editAllAppsTextParams;
                    marginParams.setMargins(padding, padding, padding, padding);
                    allAppsTextSizeEditText.setLayoutParams(marginParams);
                }

                allAppsTextSizeEditText.requestFocus();
                imm.showSoftInput(allAppsTextSizeEditText, InputMethodManager.SHOW_IMPLICIT);
                allAppsTextSizeEditText.setSelection(allAppsTextSizeEditText.getText().length());
                break;
            case Keys.WORKSPACE_TEXT_SIZE:
                alertWorkspaceTextSizeDialog = displayWorkspaceTextSizeDialog().create();
                alertWorkspaceTextSizeDialog.show();

                Button negativeButtonW = alertWorkspaceTextSizeDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                negativeButtonW.setLayoutParams(params);

                ViewGroup.LayoutParams editWorkspaceTextParams = workspaceTextSizeEditText.getLayoutParams();
                if (editWorkspaceTextParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) editWorkspaceTextParams;
                    marginParams.setMargins(padding, padding, padding, padding);
                    workspaceTextSizeEditText.setLayoutParams(marginParams);
                }

                workspaceTextSizeEditText.requestFocus();
                imm.showSoftInput(workspaceTextSizeEditText, InputMethodManager.SHOW_IMPLICIT);
                workspaceTextSizeEditText.setSelection(workspaceTextSizeEditText.getText().length());
                break;
            case Keys.NIGHT_MODE:
                nightModeBool = sharedPrefs.getBoolean(Keys.NIGHT_MODE, false);
                handler.post(updateSummary);
                correctionCategory.setVisible(nightModeBool);
                sunriseTitleAndSummary.setVisible(nightModeBool);
                sunsetTitleAndSummary.setVisible(nightModeBool);
                sunriseCorrectionSeekBar.setVisible(nightModeBool);
                sunsetCorrectionSeekBar.setVisible(nightModeBool);
                wallpapersCategory.setVisible(nightModeBool);
                defaultWallpapers.setVisible(nightModeBool);
                defaultWallpapersBool = sharedPrefs.getBoolean(Keys.DEFAULT_WALLPAPERS, true);
                if (wallpaperBoolean()) {
                    saveDayWallpaper.setVisible(true);
                    saveNightWallpaper.setVisible(true);                
                } else {
                    saveDayWallpaper.setVisible(false);
                    saveNightWallpaper.setVisible(false);  
                } 
                brightnessCategory.setVisible(nightModeBool);
                brightnessPref.setVisible(nightModeBool);
                brightnessBool = sharedPrefs.getBoolean(Keys.BRIGHTNESS_PREF, false);
                dayTitle.setVisible(nightModeBool && brightnessBool);
                nightTitle.setVisible(nightModeBool && brightnessBool);
                daySeekBar.setVisible(nightModeBool && brightnessBool);
                nightSeekBar.setVisible(nightModeBool && brightnessBool);
                resetNightModeCategory.setVisible(nightModeBool);
                resetNightMode.setVisible(nightModeBool);
                break;
            case Keys.DEFAULT_WALLPAPERS:
                wallpaperSet = true;
                defaultWallpapersBool = sharedPrefs.getBoolean(Keys.DEFAULT_WALLPAPERS, true);
                if (wallpaperBoolean()) {
                    saveDayWallpaper.setVisible(true);
                    saveNightWallpaper.setVisible(true);                
                } else {
                    saveDayWallpaper.setVisible(false);
                    saveNightWallpaper.setVisible(false);  
                }
                break;
            case Keys.SAVE_DAY_WALLPAPER:
                helpers.setCorrectionChanged(true);
                wallpaperSet = true;
                new SaveWallpaperTask().execute("Day");
                break;
            case Keys.SAVE_NIGHT_WALLPAPER:
                helpers.setCorrectionChanged(true);
                wallpaperSet = true;
                new SaveWallpaperTask().execute("Night");
                break;
            case Keys.BRIGHTNESS_PREF:
                brightnessBool = sharedPrefs.getBoolean(Keys.BRIGHTNESS_PREF, false);
                dayTitle.setVisible(brightnessBool);
                nightTitle.setVisible(brightnessBool);
                daySeekBar.setVisible(brightnessBool);
                nightSeekBar.setVisible(brightnessBool);
                break;
            case Keys.RESET_NIGHT_MODE:
                sunriseCorrectionSeekBar.resetPosition();
                sunsetCorrectionSeekBar.resetPosition();
                daySeekBar.resetPosition(255);
                nightSeekBar.resetPosition(0);
                handler.post(updateSummary);
                helpers.setCorrectionChanged(true);
                helpers.setLayoutTypeChanged(true);
                daySeekBar.setVisible(false);
                nightSeekBar.setVisible(false);
                saveDayWallpaper.setVisible(false);
                saveNightWallpaper.setVisible(false); 
                defaultWallpapers.setChecked(true);
                brightnessPref.setChecked(false);
                break;
            case Keys.LOGCAT_SERVICE:
                logcatServiceBool = sharedPrefs.getBoolean(Keys.LOGCAT_SERVICE, false);
                if (logcatServiceBool) {
                    String summaryText = getString(R.string.logcat_service_summary);
                    logcatService.setSummary(Html.fromHtml(summaryText, Html.FROM_HTML_MODE_LEGACY));
                } else {
                    logcatService.setSummary(null);
                }
                break;
            case Keys.LOGCAT_SERVICE_RUN:
                if (!helpers.logcatRunBoolean()) {
                    // start the service
                    int logcatTimeout = Integer.parseInt(sharedPrefs.getString(Keys.LOGCAT_SERVICE_TIMEOUT, "30")) * 1000;
                    startLogcatRun();
                    setCountDownTimer(logcatTimeout);
                    setTickRunnable(logcatTimeout + 1000);
                } else {
                    // stop the service
                    stopLogcatRun();
                }
                break;
            case Keys.LOGCAT_SERVICE_TIMEOUT:
                alertLogcatServiceTimeoutDialog = displayLogcatServiceTimeoutDialog().create();
                alertLogcatServiceTimeoutDialog.show();

                Button negativeButtonL = alertLogcatServiceTimeoutDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                negativeButtonL.setLayoutParams(params);

                ViewGroup.LayoutParams editLogcatTextParams = logcatServiceTimeoutEditText.getLayoutParams();
                if (editLogcatTextParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) editLogcatTextParams;
                    marginParams.setMargins(padding, padding, padding, padding);
                    logcatServiceTimeoutEditText.setLayoutParams(marginParams);
                }

                logcatServiceTimeoutEditText.requestFocus();
                imm.showSoftInput(logcatServiceTimeoutEditText, InputMethodManager.SHOW_IMPLICIT);
                logcatServiceTimeoutEditText.setSelection(logcatServiceTimeoutEditText.getText().length());
                break;
            case Keys.APP_VERSION_UPDATE:
                alertUpdateDialog = displayDownloadConfirmationDialog().create();
                alertUpdateDialog.show();
                Button negativeUpdateButton = alertUpdateDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                LinearLayout.LayoutParams paramsUpdate = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                paramsUpdate.setMargins(0, 0, 80, 0);
                negativeUpdateButton.setLayoutParams(paramsUpdate);
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        clearPreferenceListeners(getPreferenceScreen());
        handler.removeCallbacksAndMessages(null);
        mHandler.removeCallbacksAndMessages(null);
        versionChecker.cancelCheck();
        versionChecker.cancelDownload();
        versionChecker.cancelInstall();
        progressDialogDismiss();
        removeTickRunnable();
        cancelCountDownTimer();
        dismissDialogs();
        mPropertyChangeClass.deleteObserver(Keys.DOWNLOAD_PERCENTAGE, this);
        SkinAttribute skinAttribute = SkinUtils.getSkinAttr();
        if (skinAttribute != null) {
            skinAttribute.clear();
        }
    }

    private void clearPreferenceListeners(PreferenceGroup group) {
        if (group == null) return;
        
        for (int i = 0; i < group.getPreferenceCount(); i++) {
            Preference p = group.getPreference(i);
            p.setOnPreferenceClickListener(null);
            
            if (p instanceof PreferenceGroup) {
                clearPreferenceListeners((PreferenceGroup) p);
            }
        }
    }

    public void setCountDownTimer(int delay) {
        countDownTimerBool = true;
        countDownTimer = new CountDownTimer(delay, 1000) {
            public void onTick(long millisUntilFinished) {
                int remainingTime = (int) (millisUntilFinished / 1000);
                int hours = remainingTime / 3600;
                int remainingSeconds = remainingTime % 3600;
                int minutes = remainingSeconds / 60;
                int seconds = remainingSeconds % 60;
                String timeFormat = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                logcatRun.setSummary(getString(
                    R.string.logcat_service_run_working, 
                    timeFormat
                ));
            }

            public void onFinish() {
                logcatRun.setSummary(getString(
                    R.string.logcat_service_run_working, 
                    "00:00:00"
                ));
            }
        }.start();
    }

    public void cancelCountDownTimer() {
        if (countDownTimerBool) {
            countDownTimerBool = false;
            countDownTimer.cancel();
        }
    }

    public void setTickRunnable(int delay) {
        if (!tickRunnableBool) {
            mHandler.postDelayed(tickRunnable, delay);
            tickRunnableBool = true;
        } 
    }

    public void removeTickRunnable() {
        if (tickRunnableBool) {
            mHandler.removeCallbacks(tickRunnable);
            tickRunnableBool = false; 
        } 
    }

    private final Runnable tickRunnable = new Runnable() {
        @Override
        public void run() {
            cancelCountDownTimer();
            logcatRun.setEnabled(true);
            logcatRun.setSummary(getString(R.string.logcat_service_run_summary));
            removeTickRunnable();
        }
    };

    public void startLogcatRun() {
        Intent intent = new Intent(this.requireContext(), LogcatService.class);
        this.requireContext().startService(intent);
    }

    public void stopLogcatRun() {
        Intent intent = new Intent(this.requireContext(), LogcatService.class);
        this.requireContext().stopService(intent);
        removeTickRunnable();
        cancelCountDownTimer();
        logcatRun.setSummary(getString(R.string.logcat_service_run_summary));
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

    private void logcatServiceTimeoutEditText() {
        logcatServiceTimeoutEditText = new EditText(this.getContext());
        logcatServiceTimeoutEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        logcatServiceTimeoutEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        logcatServiceTimeoutEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveLogcatServiceTimeout();
                alertLogcatServiceTimeoutDialog.dismiss();
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

        private String nightModeSumary() {
            String sunriseStr = sharedPrefs.getString("sunrise", "");
            String sunsetStr = sharedPrefs.getString("sunset", "");
            String nightModeStr = getString(R.string.night_mode_summary, sunriseStr, sunsetStr);
            nightModeBool = sharedPrefs.getBoolean(Keys.NIGHT_MODE, false);
            if (nightModeBool) {
                long sunriseCorrectionValue = sharedPrefs.getInt(Keys.SUNRISE_CORRECTION, 0) * 60000L;
                long sunsetCorrectionValue = sharedPrefs.getInt(Keys.SUNSET_CORRECTION, 0) * 60000L;
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
    };
    
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
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Keys.DOWNLOAD_PERCENTAGE:
                int progress = (int) evt.getNewValue(); 
                if (progressDialog != null) {
                    progressDialog.updateProgress(progress);
                }
                break;
            default:
                break;
        } 
    }

    private void downloadAndInstall() {
        versionChecker.downloadAndInstallApk(LauncherApplication.sApp, latestAppVersion, new VersionChecker.DownloadCallback() {
            @Override
            public void onDownloadStarted(String fileName) {
                requireActivity().runOnUiThread(() -> progrssDialogShow());
            }

            @Override
            public void onDownloadProgress(int progress) {
                mPropertyChangeClass.setInt(Keys.DOWNLOAD_PERCENTAGE, progress);
            }

            @Override
            public void onDownloadComplete() {
                requireActivity().runOnUiThread(() -> progressDialogDismiss());
            }

            @Override
            public void onDownloadError(String error) {
                new Handler(Looper.getMainLooper()).post(() -> showErrorToast(error));
            }
        });  
    }

    private void progrssDialogShow() {
        progressDialog = new ProgressDialog();        
        progressDialog.setOnCancelListener(() -> {
            versionChecker.cancelDownload();
        });
        progressDialog.show(this.requireContext(), latestAppVersion);
    }

    private void progressDialogDismiss() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    private void showErrorToast(String error) {
        Toast.makeText(LauncherApplication.sApp, error, Toast.LENGTH_LONG).show();
    }

    private AlertDialog.Builder displayDownloadConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(getString(R.string.confirmation_dialog, latestAppVersion));
        builder.setPositiveButton(R.string.update_btn, (dialog, which) -> downloadAndInstall());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private AlertDialog.Builder displayAllAppsTextSizeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(R.string.all_apps_textSize_str);
        if (allAppsTextSizeEditText.getParent() != null) {
            ((ViewGroup)allAppsTextSizeEditText.getParent()).removeView(allAppsTextSizeEditText);
        }
        builder.setView(allAppsTextSizeEditText);
        allAppsTextSizeEditText.setText(allAppsTextSize.getSummary());
        allAppsTextSizeEditText.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveAllAppsTextSize());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private AlertDialog.Builder displayWorkspaceTextSizeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(R.string.workspace_textSize_str);
        if (workspaceTextSizeEditText.getParent() != null) {
            ((ViewGroup)workspaceTextSizeEditText.getParent()).removeView(workspaceTextSizeEditText);
        }
        builder.setView(workspaceTextSizeEditText);
        workspaceTextSizeEditText.setText(workspaceTextSize.getSummary());
        workspaceTextSizeEditText.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveWorkspaceTextSize());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private AlertDialog.Builder displayLogcatServiceTimeoutDialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(R.string.logcat_service_timeout_str);
        if (logcatServiceTimeoutEditText.getParent() != null) {
            ((ViewGroup)logcatServiceTimeoutEditText.getParent()).removeView(logcatServiceTimeoutEditText);
        }
        builder.setView(logcatServiceTimeoutEditText);
        logcatServiceTimeoutEditText.setText(logcatServiceTimeout.getSummary());
        logcatServiceTimeoutEditText.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveLogcatServiceTimeout());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private void dismissDialogs() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
            loadingDialog = null;
        } 
        if (alertAllAppsTextSizeDialog != null && alertAllAppsTextSizeDialog.isShowing()) {
            alertAllAppsTextSizeDialog.dismiss();
            alertAllAppsTextSizeDialog = null;
        }
        if (alertWorkspaceTextSizeDialog != null && alertWorkspaceTextSizeDialog.isShowing()) {
            alertWorkspaceTextSizeDialog.dismiss();
            alertWorkspaceTextSizeDialog = null;
        }
        if (alertLogcatServiceTimeoutDialog != null && alertLogcatServiceTimeoutDialog.isShowing()) {
            alertLogcatServiceTimeoutDialog.dismiss();
            alertLogcatServiceTimeoutDialog = null;
        }
        if (alertUpdateDialog != null && alertUpdateDialog.isShowing()) {
            alertUpdateDialog.dismiss();
            alertUpdateDialog = null;
        }
    }

    private void saveAllAppsTextSize() {
        helpers.allAppsTextSizeChanged(true);
        String valueStr = allAppsTextSizeEditText.getText().toString();
        if (valueStr.isEmpty()) valueStr = "18";
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        grid.updateIconTextSize(Integer.parseInt(valueStr));
        allAppsTextSize.setSummary(valueStr);
        editor.putString(Keys.ALL_APPS_TEXT_SIZE, valueStr);
        editor.apply();
    }

    private void saveWorkspaceTextSize() {
        helpers.workspaceTextSizeChanged(true);
        String valueStr = workspaceTextSizeEditText.getText().toString();
        if (valueStr.isEmpty()) valueStr = "28";
        workspaceTextSize.setSummary(valueStr);
        editor.putString(Keys.WORKSPACE_TEXT_SIZE, valueStr);
        editor.apply();
    }

    private void saveLogcatServiceTimeout() {
        String valueStr = logcatServiceTimeoutEditText.getText().toString();
        if (valueStr.isEmpty()) valueStr = "30";
        logcatServiceTimeout.setSummary(valueStr);
        editor.putString(Keys.LOGCAT_SERVICE_TIMEOUT, valueStr);
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

    private void setBrightness() {
        final int dayBrightness = sharedPrefs.getInt(Keys.DAY_SEEK_BAR, 70);
        final int nightBrightness = sharedPrefs.getInt(Keys.NIGHT_SEEK_BAR, 0);
        final boolean isDay = helpers.isDay();
        final boolean isPolarDay = helpers.isPolarDay();
        final boolean isPerpetualNight = helpers.isPerpetualNight();

        new Thread(() -> {
            int brightness = 70;
            if (isDay || isPolarDay) {
                brightness = dayBrightness;
            } else if (!isDay || isPerpetualNight) {
                brightness = nightBrightness;
            }
            try {
                Settings.System.putInt(
                    LauncherApplication.sApp.getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS,
                    brightness
                );
            } catch (Exception e) {
                Log.e(TAG, "Error setting brightness", e);
            }
        }).start();
    }

    public void onClickWallpaperPicker(View v) {
        if (sharedPrefs.getBoolean(Keys.WALLPAPER_PICKER_SOURCE, false)) {
            startWallpaperSystem(v);
        } else {
            startWallpaperInApp();
        }
    }

    protected void startWallpaperSystem(View v) {
        Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);

        String pickerPackage = "com.android.wallpaper";
        boolean hasTargetPackage = !TextUtils.isEmpty(pickerPackage);
        try {
            if (hasTargetPackage && LauncherApplication.sApp.getPackageManager().getApplicationInfo(pickerPackage, 0).enabled) {
                intent.setPackage(pickerPackage);
            }
        } catch (PackageManager.NameNotFoundException ex) {
            Log.e(TAG, "Error on startWallpaperSystem: " + ex.getMessage());
        }

        intent.setSourceBounds(getViewBounds(v));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            LauncherApplication.sApp.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this.mContext, "activity_not_found", Toast.LENGTH_SHORT).show();
        }
    }

    protected void startWallpaperInApp() {
        final Intent pickWallpaper = new Intent(Intent.ACTION_SET_WALLPAPER);
        pickWallpaper.setComponent(getWallpaperPickerComponent());
        pickWallpaper.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        LauncherApplication.sApp.startActivity(pickWallpaper);
    }

    protected ComponentName getWallpaperPickerComponent() {
        return new ComponentName(LauncherApplication.sApp.getPackageName(), WallpaperPickerActivity.class.getName());
    }

    public Rect getViewBounds(View v) {
        int[] pos = new int[2];
        v.getLocationOnScreen(pos);
        return new Rect(pos[0], pos[1], pos[0] + v.getWidth(), pos[1] + v.getHeight());
    }

    public void showLoading(String state) {
        if (!loadingDialog.isShowing()) {
            TextView loadingDialogTextView = loadingDialog.findViewById(R.id.dialog_loading_text);
            if (state.equals("Day")) {
                loadingDialogTextView.setText(getString(R.string.save_day_wallpaper_dialog)); 
            } else {
                loadingDialogTextView.setText(getString(R.string.save_night_wallpaper_dialog)); 
            }
            
            loadingDialog.show();
        }
    }

    public void hideLoading() {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    private class SaveWallpaperTask extends AsyncTask<String, Void, Boolean> {
        private final WallpaperManager mWallpaperManager;
        private String daytime = "";
        
        public SaveWallpaperTask() {
            mWallpaperManager = WallpaperManager.getInstance(LauncherApplication.sApp);
        }

        @Override
        protected Boolean doInBackground(String[] input) {
            daytime = input[0];
            saveWallpaper(input[0]);
            return true;
        }

        @Override
        protected void onProgress(Void[] progress) {
            //
        }

        private void saveWallpaper(String name) {
            requireActivity().runOnUiThread(() -> showLoading(name));
            Drawable mWallpaper = mWallpaperManager.getDrawable();
            Bitmap mBitmap = drawableToBitmap(mWallpaper);
            File mFile = new File(LauncherApplication.sApp.getFilesDir(), "wallpaper_img"); // dir: /data/user/0/com.android.launcher66/files/wallpaper_img
            Log.i("dir", String.valueOf(LauncherApplication.sApp.getFilesDir()));
            boolean doSave = true;
            if (!mFile.exists()) {
                doSave = mFile.mkdirs();
            }            
            if (doSave) {
                saveBitmapToFile(mFile, name + ".webp", mBitmap);
            }  
            File image = new File(mFile, name + ".webp");
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
            normalizedBitmap.compress(getWebPFormat(), 100, byteArrayOutputStream);
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
                Bitmap normalizedBitmap = normalizeBitmap(bm);
                normalizedBitmap.compress(getWebPFormat(), 100, out);
                out.close();
            }
            catch (IOException e) {
                Log.e(TAG, Objects.requireNonNull(e.getMessage()));
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }

        @SuppressLint("NewApi")
        private Bitmap.CompressFormat getWebPFormat() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                return Bitmap.CompressFormat.WEBP_LOSSLESS;
            } else {
                return Bitmap.CompressFormat.WEBP;
            }
        }
        
        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                hideLoadingSafely(1, "");
                Log.d(TAG, "Wallpaper saved successfully.");
                
            } else {
                hideLoadingSafely(2, "");
                Log.d(TAG, "Wallpaper was not saved.");
                showToast(LauncherApplication.sApp.getString(R.string.wallpaper_not_set, daytime));
            }
        }
        
        @Override
        protected void onBackgroundError(Exception e) {
            Log.e("SettingsFragmentFirst", "Background error, wallpaper was not saved: " + e.getMessage());     
            hideLoadingSafely(3, String.valueOf(e.getMessage()));
        }

        private void showToast(String message) {
            LayoutInflater inflater = LayoutInflater.from(LauncherApplication.sApp);
            View toastLayout = inflater.inflate(R.layout.toast, null);
            TextView text = toastLayout.findViewById(R.id.toast_text);
            text.setText(message);
            text.setTextSize(30);
            Toast toast = Toast.makeText(LauncherApplication.sApp, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setView(toastLayout);
            toast.show();
        }

        private void hideLoadingSafely(int where, String e) {
            Activity activity = getActivity();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                activity.runOnUiThread(() -> {
                    // Re-check activity validity and fragment's state
                    Activity currentActivity = getActivity();
                    if (currentActivity != null && !currentActivity.isFinishing() 
                            && !currentActivity.isDestroyed() && isAdded()) {
                        hideLoading();
                        if (where == 1) {
                            showToast(LauncherApplication.sApp.getString(R.string.wallpaper_set, daytime));
                        } else if (where == 2) {
                            showToast(LauncherApplication.sApp.getString(R.string.wallpaper_not_set, daytime));
                        } else if (where == 3) {
                            showToast(LauncherApplication.sApp.getString(R.string.wallpaper_error, daytime) + e);
                        }
                        
                    }
                });
            }
        }
    }

    public static class PropertyChangeClass {
        private int pInt = 0;
        private final PropertyChangeSupport mPropertyChangeSupport = new PropertyChangeSupport(this);

        public void setInt(String name, int value) {
            int old = pInt;
            pInt = value;
            mPropertyChangeSupport.firePropertyChange(name, old, value);
        }

        public void addObserver(String name, PropertyChangeListener listener) {
            mPropertyChangeSupport.addPropertyChangeListener(name, listener);
        }

        public void deleteObserver(String name, PropertyChangeListener listener) {
            mPropertyChangeSupport.removePropertyChangeListener(name, listener);
        }
    }
}