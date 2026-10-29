package com.android.launcher66.settings;

import com.android.launcher66.SysCalls;
import android.Manifest;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.net.Uri;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.TwoStatePreference;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.ServiceIntentGate;
import com.android.launcher66.colorpicker.ColorPicker;
import com.android.launcher66.colorpicker.ColorPickerCallback;
import com.fyt.skin.SkinAttribute;
import com.fyt.skin.SkinUtils;
import com.syu.module.canbus.DataCanbus;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class SettingsFragmentSecond extends PreferenceFragmentCompat implements Preference.OnPreferenceClickListener {

    // Fragment for the second window in the settings - Layout creator

    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor editor;
    private final Helpers helpers = new Helpers();

    private static final int REQ_READ_WALLPAPER = 9001;
    private enum PendingDialog {
        NONE,
        WIDGETS,
        BAR
    }
    private PendingDialog pendingDialog = PendingDialog.NONE;

    private int defaultColorR = 255;
    private int defaultColorG = 255;
    private int defaultColorB = 255;
    private int bgDefaultColorR = 255;
    private int bgDefaultColorG = 255;
    private int bgDefaultColorB = 255;
    private static final int TIMER_DURATION = 1000;
    private int padding;
    private boolean pipBool = true;
    /**
     * Whether the PiP options show: panes can work here (LauncherApplication.canHostPips()),
     * or this is a debug build.
     */
    private boolean pipsPossible = true;
    private boolean autoHideBool = false;
    private boolean resizableBarBool = false;
    private boolean dualPipGuard = false;
    private boolean userStatsBool = false;
    private boolean backgroundBool = false;
    private boolean drawableBgBool = false;
    private boolean colorBgBool = false;
    private boolean displayCanbusReaderBool = false;
    private boolean tickRunnableBool = false;
    private boolean countDownTimerBool = false;
    private Preference startPage;
    private EditText startPageEditText;
    private AlertDialog alertStartPageDialog;
    private SwitchPreferenceCompat autoHidePreference;
    private AutoHideSeekBarPreference autoHideSeekBar;
    private SwitchPreferenceCompat resizableBarPreference;
    private BottomBarHeightSeekBarPreference barHeightSeekBar;
    private Preference margin;
    private EditText marginEditText;
    private SwitchPreferenceCompat userStats;
    private CustomWidgetPreference statsScreen;
    private Preference statsCodes;
    private EditText fuelCodeInt;
    private String fuelCodeStr;
    private String rangeCodeStr;
    private String cmdIntCodeStr;
    private String cmdArrCodeStr;
    private Preference extraStatsCodes;
    private EditText rpmCodeInt;
    private String rpmCodeStr;
    private String horsePowerCodeStr;
    private String vehicleMassCodeStr;
    private EditText inspectorTimeoutEdit;
    private String codeInspectorTimeoutStr;
    private SwitchPreferenceCompat mainScreenStats;
    private SwitchPreferenceCompat bgDrawable;
    private SwitchPreferenceCompat bgColor;
    private Preference statsBg;
    private Preference colorPickerPref;
    private Preference bgColorPickerPref;
    private Preference bgAlpha;
    private AlphaSeekBarPreference alphaSeekBar;
    private Preference appList;
    private Preference appStatsCoordinates;
    private Preference codesGuide;
    private Preference skipCodes;
    private Preference canbusLibraryImport;
    private Preference canbusLibraryReset;
    /** The import in progress (main thread); null when there is none. */
    private CanbusLibraryImport.Job libraryImportJob;
    private AlertDialog libraryImportDialog;
    private AlertDialog libraryImportDoneDialog;
    private AlertDialog libraryResetDialog;
    private TextView libraryImportStatus;
    private ProgressBar libraryImportBar;
    /** The user chose "Run in background", or the screen is gone: the result comes as a toast. */
    private boolean libraryImportBackground;
    private PreferenceCategory inspectorCategory;
    private Preference codeInspector;
    private Preference codeInspectorData;
    private Preference skipZeroCodes;
    private CountDownTimer countDownTimer;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Handler handler = new Handler(Looper.getMainLooper());
    private EditText skipCodesEditText;
    private AlertDialog alertPipDialog;
    private AlertDialog alertMarginsDialog;
    private AlertDialog alertCodesDialog;
    private AlertDialog alertExtraCodesDialog;
    private AlertDialog alertSkipCodesDialog;
    private AlertDialog alertCodesInspectorDialog;
    private WeakReference<AppListStatsDialogFragment> appListStatsDialog;
    private WeakReference<ColorPicker> colorPicker;
    private WeakReference<ColorPicker> bgColorPicker;
    private InputMethodManager imm;
    private RecyclerView recyclerView;

    private CustomDualPipPreference pipDualPref;
    private CustomPipSwitchPreference pipFirstPref;
    private CustomPipSwitchPreference pipSecondPref;
    private CustomPipSwitchPreference pipThirdPref;
    private CustomPipSwitchPreference pipFourthPref;
    private CustomPipRestartPreference restartPip;
    private CustomSwitchPreference fabPreference;
    private CustomSwitchPreference leftFabPreference;
    private CustomSwitchPreference rightFabPreference;
    private CustomSwitchPreference extendedDivider;
    private CustomNestedThreePreference coverSplash;
    private CustomSwitchPreference swipeDetector;
    private CustomWidgetSwitchPreference userDate;
    private CustomWidgetSwitchPreference userMusic;
    private CustomWidgetSwitchPreference userRadio;

    private final SharedPreferences.OnSharedPreferenceChangeListener pipPkgListener =
            (prefs, key) -> {
                if (Keys.PIP_FIRST_PACKAGE.equals(key) || Keys.PIP_SECOND_PACKAGE.equals(key)
                        || Keys.PIP_THIRD_PACKAGE.equals(key) || Keys.PIP_FOURTH_PACKAGE.equals(key)) {
                    updatePipSummaries();
                    if (restartPip != null) {
                        restartPip.refreshButtons();
                    }
                }
            };

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;
        rootView = super.onCreateView(inflater, container, savedInstanceState);

        imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.launcher_creator));
        }

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (!LauncherApplication.isFytDevice()) {
            // Only the system bar insets: the proportions come from SettingsActivity's
            // reference density, before anything is inflated.
            recyclerView = findRecyclerView(view);
            PreferenceScaleHelper.applySystemBarInsets(recyclerView);
        }
    }

    private RecyclerView findRecyclerView(View view) {
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        if (view instanceof ViewGroup viewGroup) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                RecyclerView found = findRecyclerView(viewGroup.getChildAt(i));
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                helpers.setBackFromCreator(true);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragmentFirst()).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        CanbusLibrary.preload(requireContext());
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.requireContext());
        editor = sharedPrefs.edit();
        addPreferencesFromResource(R.xml.creator_preferences);
        padding = SettingsActivity.dialogPadding;
        if (!LauncherApplication.showsFytOptions()) {
            for (String key : new String[]{ Keys.USER_RADIO, "stats_category", "canbus_reader" }) {
                hideWithSeparator(findPreference(key));
            }
        }
        // Shizuku installed but not started yet counts: the panes come with it.
        pipsPossible = LauncherApplication.showsPrivilegedOption(LauncherApplication.canHostPips()
                || com.syu.util.WindowHostVdClient.isShizukuInstalled(requireContext()));

        Preference displayPip = findPreference(Keys.DISPLAY_PIP);
        pipDualPref   = findPreference(Keys.PIP_DUAL);
        pipFirstPref  = findPreference(Keys.PIP_FIRST);
        pipSecondPref = findPreference(Keys.PIP_SECOND);
        pipThirdPref  = findPreference(Keys.PIP_THIRD);
        pipFourthPref = findPreference(Keys.PIP_FOURTH);
        restartPip = findPreference(Keys.RESTART_PIP);
        fabPreference = findPreference(Keys.FAB_OVERLAY_BUTTON);
        leftFabPreference = findPreference(Keys.FAB_OVERLAY_BUTTON_LEFT);
        rightFabPreference = findPreference(Keys.FAB_OVERLAY_BUTTON_RIGHT);
        extendedDivider = findPreference(Keys.EXTENDED_DIVIDER);
        coverSplash = findPreference(Keys.COVER_SPLASH_MODE);
        swipeDetector = findPreference(Keys.SWIPE_DETECTOR);
        userDate = findPreference(Keys.USER_DATE);
        userMusic = findPreference(Keys.USER_MUSIC);
        userRadio = findPreference(Keys.USER_RADIO);
        userStats = findPreference(Keys.USER_STATS);
        statsScreen = findPreference(Keys.STATS_DISPLAY);
        statsCodes = findPreference(Keys.STATS_CODES);
        fuelCodeStr = sharedPrefs.getString("fuel_code_int", "0");
        rangeCodeStr = sharedPrefs.getString("range_code_int", "0");
        cmdIntCodeStr = sharedPrefs.getString(Keys.CMD_INT, "0");
        cmdArrCodeStr = sharedPrefs.getString(Keys.CMD_ARR, "0");
        extraStatsCodes = findPreference(Keys.EXTRA_STATS_CODES);
        rpmCodeStr = sharedPrefs.getString("rpm_code_int", "0");
        horsePowerCodeStr = sharedPrefs.getString("horse_power_code_int", "0");
        vehicleMassCodeStr = sharedPrefs.getString("vehicle_mass_code_int", "0");

        mainScreenStats = findPreference(Keys.MAIN_SCREEN_STATS);
        colorPickerPref = findPreference(Keys.COLOR_PICKER);
        statsBg = findPreference(Keys.STATS_BG);
        bgDrawable = findPreference(Keys.BG_DRAWABLE);
        bgColor = findPreference(Keys.BG_COLOR);
        bgColorPickerPref = findPreference(Keys.BG_COLOR_PICKER);
        bgAlpha = findPreference("bg_alpha");
        alphaSeekBar = findPreference(Keys.ALPHA_SEEK_BAR);
        appList = findPreference(Keys.APP_LIST);
        appStatsCoordinates = findPreference(Keys.APP_STATS_COORDINATES);

        SwitchPreferenceCompat displayCanbusReader = findPreference(Keys.DISPLAY_CANBUS_READER);
        codesGuide = findPreference(Keys.CODES_GUIDE);
        skipCodes = findPreference(Keys.SKIP_CODES);
        canbusLibraryImport = findPreference(Keys.CANBUS_LIBRARY_IMPORT);
        canbusLibraryReset = findPreference(Keys.CANBUS_LIBRARY_RESET);
        Set<String> skipCodesSet = sharedPrefs.getStringSet(Keys.SKIP_CODES, Collections.singleton(""));
        String skipCodesStr = skipCodesSet != null ? String.join(", ", skipCodesSet) : "";
        if (skipCodesStr.isEmpty()) {
            skipCodes.setSummary(getString(R.string.skip_codes_empty_summary));
        } else {
            skipCodes.setSummary(getString(R.string.skip_codes_summary, skipCodesStr));
        }

        inspectorCategory = findPreference("inspector_category");
        codeInspector = findPreference(Keys.CODE_INSPECTOR);
        codeInspectorData = findPreference(Keys.CODE_INSPECTOR_DATA);
        skipZeroCodes = findPreference(Keys.SKIP_ZERO_CODES);
        codeInspectorTimeoutStr = sharedPrefs.getString(Keys.CODE_INSPECTOR_TIMEOUT, "300");

        Preference widgetsBackground = findPreference(Keys.WIDGETS_BACKGROUND);
        Preference barBackground = findPreference(Keys.BAR_BACKGROUND);
        CustomNoSwitchPreference widgetsTintBlack = findPreference(Keys.BLACK_WIDGETS);
        CustomNoSwitchPreference barTintBlack = findPreference(Keys.BLACK_BAR);
        startPage = findPreference(Keys.START_PAGE);
        String startPageStr = sharedPrefs.getString(Keys.START_PAGE, "1");
        startPage.setSummary(startPageStr);

        autoHidePreference = findPreference(Keys.AUTO_HIDE_BOTTOM_BAR);
        autoHideSeekBar = findPreference(Keys.AUTO_HIDE_TIMEOUT);
        resizableBarPreference = findPreference(Keys.RESIZABLE_BOTTOM_BAR);
        barHeightSeekBar = findPreference(Keys.BOTTOM_BAR_HEIGHT);

        Preference leftBar = findPreference(Keys.LEFT_BAR);
        Preference widgetBar = findPreference(Keys.WIDGET_BAR);

        margin = findPreference(Keys.LAYOUT_MARGIN);
        String marginStr = sharedPrefs.getString(Keys.LAYOUT_MARGIN, "5");
        margin.setSummary(marginStr);

        defaultColorR = sharedPrefs.getInt("red", 255);
        defaultColorG = sharedPrefs.getInt("green", 255);
        defaultColorB = sharedPrefs.getInt("blue", 255);
        bgDefaultColorR = sharedPrefs.getInt("bg_red", 255);
        bgDefaultColorG = sharedPrefs.getInt("bg_green", 255);
        bgDefaultColorB = sharedPrefs.getInt("bg_blue", 255);

        updatePipSummaries();
        sharedPrefs.registerOnSharedPreferenceChangeListener(pipPkgListener);        

        dialogStartPageEditText();
        dialogMarginEditText();
        dialogSkipCodesEditText();

        if (displayPip != null) {
            displayPip.setOnPreferenceClickListener(this);
            displayPip.setVisible(pipsPossible);
        }
        if (pipDualPref != null) {
            pipDualPref.setScreenValuePrefKey(Keys.PIP_DUAL_SCREEN);
            pipDualPref.setOnPositionClickListener(pref -> openPipAdjuster(Keys.PIP_DUAL_SCREEN));            
            pipDualPref.setOnPreferenceChangeListener((p, v) -> {
                enforceDualPiP(/*changedByDual=*/true, /*newState=*/(Boolean) v);
                return true;
            });
            pipDualPref.setOnPreferenceValuesChangedListener(this::refreshAllWidgetPreferences);
            pipDualPref.setOnMainSwitchClickListener(newValue -> { if (restartPip != null) restartPip.refreshButtons(); });
        }
        if (pipFirstPref != null) {
            pipFirstPref.setScreenValuePrefKey(Keys.PIP_FIRST_SCREEN);
            pipFirstPref.setOnPositionClickListener(pref -> openPipAdjuster(Keys.PIP_FIRST_SCREEN));
            // Optional anywhere: change the "Position the PiP" button color
            // pipFirstPref.setPositionButtonTextColor(Color.MAGENTA);

            pipFirstPref.setOnPreferenceClickListener(p -> { showAppPicker(Keys.PIP_FIRST_PACKAGE); return true; });
            pipFirstPref.setOnModeSwitchChangeListener(isPip -> {
                enforceSinglePiP(pipFirstPref, isPip);
                if (isPip) enforceDualPiP(false, true);    // child → PiP => Dual PiP OFF
            });
            pipFirstPref.setOnPreferenceChangeListener((p, v) -> {
                boolean checked = (Boolean) v;
                if (checked) enforceDualPiP(false, true);  // main switch ON => Dual PiP OFF
                return true;
            });
            pipFirstPref.setOnPreferenceValuesChangedListener(this::refreshAllWidgetPreferences);
            pipFirstPref.setOnMainSwitchClickListener(newValue -> { if (restartPip != null) restartPip.refreshButtons(); });
        }
        if (pipSecondPref != null) {
            pipSecondPref.setScreenValuePrefKey(Keys.PIP_SECOND_SCREEN);
            pipSecondPref.setOnPositionClickListener(pref -> openPipAdjuster(Keys.PIP_SECOND_SCREEN));

            pipSecondPref.setOnPreferenceClickListener(p -> { showAppPicker(Keys.PIP_SECOND_PACKAGE); return true; });
            pipSecondPref.setOnModeSwitchChangeListener(isPip -> {
                enforceSinglePiP(pipSecondPref, isPip);
                if (isPip) enforceDualPiP(false, true);
            });
            pipSecondPref.setOnPreferenceChangeListener((p, v) -> {
                boolean checked = (Boolean) v;
                if (checked) enforceDualPiP(false, true);
                return true;
            });
            pipSecondPref.setOnPreferenceValuesChangedListener(this::refreshAllWidgetPreferences);
            pipSecondPref.setOnMainSwitchClickListener(newValue -> { if (restartPip != null) restartPip.refreshButtons(); });
        }
        if (pipThirdPref != null) {
            pipThirdPref.setScreenValuePrefKey(Keys.PIP_THIRD_SCREEN);
            pipThirdPref.setOnPositionClickListener(pref -> openPipAdjuster(Keys.PIP_THIRD_SCREEN));

            pipThirdPref.setOnPreferenceClickListener(p -> { showAppPicker(Keys.PIP_THIRD_PACKAGE); return true; });
            pipThirdPref.setOnModeSwitchChangeListener(isPip -> enforceSinglePiP(pipThirdPref, isPip));
            pipThirdPref.setOnPreferenceChangeListener((p, v) -> true);
            pipThirdPref.setOnPreferenceValuesChangedListener(this::refreshAllWidgetPreferences);
            pipThirdPref.setOnMainSwitchClickListener(newValue -> { if (restartPip != null) restartPip.refreshButtons(); });
        }
        if (pipFourthPref != null) {
            pipFourthPref.setScreenValuePrefKey(Keys.PIP_FOURTH_SCREEN);
            pipFourthPref.setOnPositionClickListener(pref -> openPipAdjuster(Keys.PIP_FOURTH_SCREEN));

            pipFourthPref.setOnPreferenceClickListener(p -> { showAppPicker(Keys.PIP_FOURTH_PACKAGE); return true; });
            pipFourthPref.setOnModeSwitchChangeListener(isPip -> enforceSinglePiP(pipFourthPref, isPip));
            pipFourthPref.setOnPreferenceChangeListener((p, v) -> true);
            pipFourthPref.setOnPreferenceValuesChangedListener(this::refreshAllWidgetPreferences);
            pipFourthPref.setOnMainSwitchClickListener(newValue -> { if (restartPip != null) restartPip.refreshButtons(); });
        }
        if (restartPip != null) {
            restartPip.setOnPreferenceClickListener(this);
        }
        if (fabPreference != null) {
            fabPreference.setOnPreferenceClickListener(this);
        }  
        if (leftFabPreference != null) {
            leftFabPreference.setOnPreferenceClickListener(this);
        }  
        if (rightFabPreference != null) {
            rightFabPreference.setOnPreferenceClickListener(this);
        }  
        if (extendedDivider != null) {
            extendedDivider.setOnPreferenceClickListener(this);
        }   
        if (coverSplash != null) {
            coverSplash.setOnPreferenceClickListener(this);
        }
        if (swipeDetector != null) {
            swipeDetector.setOnPreferenceClickListener(this);
            if (!LauncherApplication.showsPrivilegedOption(LauncherApplication.hasSystemPrivileges())) {
                swipeDetector.setVisible(false);
            }
        }  
        pipBool = sharedPrefs.getBoolean(Keys.DISPLAY_PIP, false);
        setPipGroupVisible(pipBool);
        if (userDate != null) {
            userDate.setOnPreferenceClickListener(this);
            userDate.setScreenValuePrefKey(Keys.DATE_SCREEN);
            userDate.setOnPositionClickListener(pref -> openPipAdjuster(Keys.DATE_SCREEN));  
            userDate.setOnPreferenceValuesChangedListener(this::refreshAllWidgetPreferences);    
        }
        if (userMusic != null) {
            userMusic.setOnPreferenceClickListener(this);
            userMusic.setScreenValuePrefKey(Keys.MUSIC_SCREEN);
            userMusic.setOnPositionClickListener(pref -> openPipAdjuster(Keys.MUSIC_SCREEN));
            userMusic.setOnPreferenceValuesChangedListener(this::refreshAllWidgetPreferences);
        }
        if (userRadio != null) {
            userRadio.setOnPreferenceClickListener(this);
            userRadio.setScreenValuePrefKey(Keys.RADIO_SCREEN);
            userRadio.setOnPositionClickListener(pref -> openPipAdjuster(Keys.RADIO_SCREEN));
            userRadio.setOnPreferenceValuesChangedListener(this::refreshAllWidgetPreferences);
        }
        if (widgetsBackground != null) {
            widgetsBackground.setOnPreferenceClickListener(preference -> {
                checkAndShowWidgetsBackgroundSelector();
                return true;
            });
        }
        if (widgetsTintBlack != null) {
            widgetsTintBlack.setOnPreferenceClickListener(this);
        }
        if (barBackground != null) {
            barBackground.setOnPreferenceClickListener(preference -> {
                checkAndShowBarBackgroundSelector();
                return true;
            });
        }
        if (barTintBlack != null) {
            barTintBlack.setOnPreferenceClickListener(this);
        }
        if (startPage != null) {
            startPage.setOnPreferenceClickListener(this);
        }
        autoHideBool = sharedPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false);
        if (autoHidePreference != null) {
            autoHidePreference.setOnPreferenceClickListener(this);
            if (autoHideBool) {
                handler.post(updateSummary);
            } else {
                autoHidePreference.setSummary(null);    
            }
        } 
        if (autoHideSeekBar != null) {
            autoHideSeekBar.setVisible(autoHideBool);
            autoHideSeekBarProgress(autoHideSeekBar);
        }
        resizableBarBool = sharedPrefs.getBoolean(Keys.RESIZABLE_BOTTOM_BAR, false);
        if (resizableBarPreference != null) {
            resizableBarPreference.setOnPreferenceClickListener(this);
            // Formatted right away (there is no list yet), even while the switch is off: summaryOn
            // still holds the raw "%1$s" format and would flash when the switch is turned on.
            updateBarHeightSummary.run();
            if (!resizableBarBool) {
                resizableBarPreference.setSummary(null);
            }
        }
        if (barHeightSeekBar != null) {
            barHeightSeekBar.setVisible(resizableBarBool);
            barHeightSeekBarProgress(barHeightSeekBar);
        }
        if (leftBar != null) {
            leftBar.setOnPreferenceClickListener(this);
        }
        if (widgetBar != null) {
            widgetBar.setOnPreferenceClickListener(this);
        }
        if (margin != null) {
            margin.setOnPreferenceClickListener(this);
        }
        initUserStats();
        userStatsBool = sharedPrefs.getBoolean(Keys.USER_STATS, false);
        if (statsScreen != null) {
            statsScreen.setOnPreferenceClickListener(this);
            statsScreen.setScreenValuePrefKey(Keys.STATS_SCREEN);
            statsScreen.setOnPositionClickListener(pref -> openPipAdjuster(Keys.STATS_SCREEN));  
            statsScreen.setOnPreferenceValuesChangedListener(this::refreshAllWidgetPreferences);  
            statsScreen.setVisible(userStatsBool);
        }
        if (statsCodes != null) {
            statsCodes.setSummary(statsCodesSummary());
            // The library loads in the background: the request of the car joins the summary when it is there
            CanbusLibrary.whenLoaded(requireContext(), () -> {
                if (isAdded() && statsCodes != null) {
                    statsCodes.setSummary(statsCodesSummary());
                }
            });
            statsCodes.setOnPreferenceClickListener(this);
            statsCodes.setVisible(userStatsBool);
        }
        if (extraStatsCodes != null) {
            extraStatsCodes.setSummary(getString(R.string.extra_stats_codes_summary, rpmCodeStr, horsePowerCodeStr, vehicleMassCodeStr));
            extraStatsCodes.setOnPreferenceClickListener(this);
            extraStatsCodes.setVisible(userStatsBool);
        }
        if (mainScreenStats != null) {
            mainScreenStats.setOnPreferenceClickListener(this);
            mainScreenStats.setVisible(userStatsBool);
        }
        if (colorPickerPref != null) {
            colorPickerPref.setOnPreferenceClickListener(this);
            colorPickerPref.setVisible(userStatsBool);
        }
        if (statsBg != null) {
            statsBg.setOnPreferenceClickListener(this);
            statsBg.setVisible(userStatsBool);
        }
        backgroundBool = sharedPrefs.getBoolean(Keys.STATS_BG, false);
        if (bgDrawable != null) {
            bgDrawable.setVisible(statsBackgroundBool());
            bgDrawable.setOnPreferenceClickListener(this);
        }
        if (bgColor != null) {
            bgColor.setVisible(statsBackgroundBool());
            bgColor.setOnPreferenceClickListener(this);
        }
        colorBgBool = sharedPrefs.getBoolean(Keys.BG_COLOR, false);
        if (bgColorPickerPref != null) {   
            bgColorPickerPref.setVisible(statsBackgroundBool() && colorBgBool);
            bgColorPickerPref.setOnPreferenceClickListener(this);
        }
        if (bgAlpha != null) {   
            bgAlpha.setVisible(statsBackgroundBool() && colorBgBool);
            bgAlpha.setOnPreferenceClickListener(this);
        }
        if (alphaSeekBar != null) {   
            alphaSeekBar.setVisible(statsBackgroundBool() && colorBgBool);
            alphaSeekBar.setOnPreferenceClickListener(this);
            storeAlphaDefault(alphaSeekBar, Keys.ALPHA_SEEK_BAR, 255);
        }
        if (appList != null) {
            appList.setOnPreferenceClickListener(this);
            appList.setVisible(userStatsBool);
        }
        if (appStatsCoordinates != null) {
            appStatsCoordinates.setOnPreferenceClickListener(this);
            appStatsCoordinates.setVisible(userStatsBool);
        }
        if (displayCanbusReader != null) {
            displayCanbusReader.setOnPreferenceClickListener(this);
        }
        displayCanbusReaderBool = sharedPrefs.getBoolean(Keys.DISPLAY_CANBUS_READER, false);
        inspectorCategory.setVisible(displayCanbusReaderBool);
        if (codesGuide != null) {
            codesGuide.setVisible(displayCanbusReaderBool);
            codesGuide.setOnPreferenceClickListener(this);
        }
        if (skipCodes != null) {
            skipCodes.setVisible(displayCanbusReaderBool);
            skipCodes.setOnPreferenceClickListener(this);
        }
        if (canbusLibraryImport != null) {
            canbusLibraryImport.setOnPreferenceClickListener(this);
        }
        if (canbusLibraryReset != null) {
            canbusLibraryReset.setOnPreferenceClickListener(this);
        }
        updateCanbusLibraryPrefs();
        // The library loads in the background: its numbers join the summary when it is there
        CanbusLibrary.whenLoaded(requireContext(), () -> {
            if (isAdded()) {
                updateCanbusLibraryPrefs();
            }
        });
        if (codeInspector != null) {
            codeInspector.setVisible(displayCanbusReaderBool);
            codeInspector.setOnPreferenceClickListener(this);
            if (helpers.codeInspectorBoolean()) {
                int inspectorTimeout = Integer.parseInt(sharedPrefs.getString(Keys.CODE_INSPECTOR_TIMEOUT, "300")) * 1000;
                setCountDownTimer(inspectorTimeout);
                setTickRunnable(inspectorTimeout + 1000);
            } else {
                codeInspector.setSummary(getString(R.string.code_inspector_summary));
                helpers.setCountDownInspector(0);
            }
        }
        if (codeInspectorData != null) {
            codeInspectorData.setVisible(displayCanbusReaderBool);
            codeInspectorData.setOnPreferenceClickListener(this);
            codeInspectorData.setSummary(getString(R.string.code_inspector_data_summary_time, codeInspectorTimeoutStr));
        }
        if (skipZeroCodes != null) {
            skipZeroCodes.setVisible(displayCanbusReaderBool);
        }
    }

    @Override
    public boolean onPreferenceClick(@NonNull Preference preference) {
        userStatsBool = sharedPrefs.getBoolean(Keys.USER_STATS, false);
        backgroundBool = sharedPrefs.getBoolean(Keys.STATS_BG, false);
        drawableBgBool = sharedPrefs.getBoolean(Keys.BG_DRAWABLE, false);
        colorBgBool = sharedPrefs.getBoolean(Keys.BG_COLOR, false);
        displayCanbusReaderBool = sharedPrefs.getBoolean(Keys.DISPLAY_CANBUS_READER, false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 80, 0);
        switch (preference.getKey()) {
            case Keys.DISPLAY_PIP:
                pipBool = sharedPrefs.getBoolean(Keys.DISPLAY_PIP, false);
                setPipGroupVisible(pipBool);
                if (!pipBool) {
                    // Turn off all PiP switches when hidden
                    if (pipDualPref != null) pipDualPref.setChecked(false);
                    if (pipFirstPref != null) pipFirstPref.setChecked(false);
                    if (pipSecondPref != null) pipSecondPref.setChecked(false);
                    if (pipThirdPref != null) pipThirdPref.setChecked(false);
                    if (pipFourthPref != null) pipFourthPref.setChecked(false);
                }
                break;
            case Keys.START_PAGE:
                alertStartPageDialog = displayStartPageDialog().create();

                alertStartPageDialog.setOnShowListener(dialog -> {
                    Button negativeButtonPage = alertStartPageDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                    negativeButtonPage.setLayoutParams(params);

                    ViewGroup.LayoutParams editStartPageTextParams = startPageEditText.getLayoutParams();
                    if (editStartPageTextParams instanceof ViewGroup.MarginLayoutParams marginParams) {
                        marginParams.setMargins(padding, padding, padding, padding);
                        startPageEditText.setLayoutParams(marginParams);
                    }

                    startPageEditText.requestFocus();
                    imm.showSoftInput(startPageEditText, InputMethodManager.SHOW_IMPLICIT);
                    startPageEditText.setSelection(startPageEditText.getText().length());
                });

                alertStartPageDialog.show();
                break;
            case Keys.AUTO_HIDE_BOTTOM_BAR:
                autoHideBool = sharedPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false);
                if (autoHideBool) {
                    handler.post(updateSummary);
                } else {
                    autoHidePreference.setSummary(null);    
                }                
                autoHideSeekBar.setVisible(autoHideBool);
                helpers.setBarSettingsChanged(true);
                break;
            case Keys.RESIZABLE_BOTTOM_BAR:
                // Click listeners run after the switch persisted its new state.
                resizableBarBool = sharedPrefs.getBoolean(Keys.RESIZABLE_BOTTOM_BAR, false);
                if (resizableBarBool) {
                    handler.post(updateBarHeightSummary);
                } else {
                    preference.setSummary(null);
                }
                if (barHeightSeekBar != null) {
                    barHeightSeekBar.setVisible(resizableBarBool);
                }
                // On or off, the launcher has to rebuild the bar (dynamic height <-> XML height).
                helpers.setBarSettingsChanged(true);
                break;
            case Keys.LEFT_BAR:
                helpers.setBarSettingsChanged(true);
                break;
            case Keys.LAYOUT_MARGIN:
                alertMarginsDialog = displayMarginsDialog().create();

                alertMarginsDialog.setOnShowListener(dialog -> {
                    Button negativeButtonMargin = alertMarginsDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                    negativeButtonMargin.setLayoutParams(params);

                    ViewGroup.LayoutParams editMarginTextParams = marginEditText.getLayoutParams();
                    if (editMarginTextParams instanceof ViewGroup.MarginLayoutParams marginParams) {
                        marginParams.setMargins(padding, padding, padding, padding);
                        marginEditText.setLayoutParams(marginParams);
                    }

                    marginEditText.requestFocus();
                    imm.showSoftInput(marginEditText, InputMethodManager.SHOW_IMPLICIT);
                    marginEditText.setSelection(marginEditText.getText().length());
                });

                alertMarginsDialog.show();
                break;
            case Keys.USER_STATS:
                userStatsSwitch();
                break;
            case Keys.STATS_CODES:
                fuelCodeStr = sharedPrefs.getString("fuel_code_int", "0");
                rangeCodeStr = sharedPrefs.getString("range_code_int", "0");
                cmdIntCodeStr = sharedPrefs.getString(Keys.CMD_INT, "0");
                cmdArrCodeStr = sharedPrefs.getString(Keys.CMD_ARR, "0");

                alertCodesDialog = displayCodesDialog().create();

                alertCodesDialog.setOnShowListener(dialog -> {
                    Button negativeCodesButton = alertCodesDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                    negativeCodesButton.setLayoutParams(params);
                    fuelCodeInt.requestFocus();
                    imm.showSoftInput(fuelCodeInt, InputMethodManager.SHOW_IMPLICIT);
                    fuelCodeInt.setSelection(fuelCodeInt.getText().length());
                });

                alertCodesDialog.show();
                break;
            case Keys.EXTRA_STATS_CODES:
                rpmCodeStr = sharedPrefs.getString("rpm_code_int", "0");
                horsePowerCodeStr = sharedPrefs.getString("horse_power_code_int", "0");
                vehicleMassCodeStr = sharedPrefs.getString("vehicle_mass_code_int", "0");

                alertExtraCodesDialog = displayExtraCodesDialog().create();

                alertExtraCodesDialog.setOnShowListener(dialog -> {
                    Button negativeExtraCodesButton = alertExtraCodesDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                    negativeExtraCodesButton.setLayoutParams(params);
                    rpmCodeInt.requestFocus();
                    imm.showSoftInput(rpmCodeInt, InputMethodManager.SHOW_IMPLICIT);
                    rpmCodeInt.setSelection(rpmCodeInt.getText().length());
                });

                alertExtraCodesDialog.show();
                break;
            case Keys.COLOR_PICKER:
                ColorPicker picker = ColorPicker.newInstance(defaultColorR, defaultColorG, defaultColorB);
                colorPicker = new WeakReference<>(picker);

                picker.enableAutoClose();

                ColorPickerCallback callback = color -> {
                    defaultColorR = Color.red(color);
                    defaultColorG = Color.green(color);
                    defaultColorB = Color.blue(color);
                    editor.putString("stats_color", String.format("#%06X", (0xFFFFFF & color)));
                    editor.putInt("red", Color.red(color));
                    editor.putInt("green", Color.green(color));
                    editor.putInt("blue", Color.blue(color));
                    editor.apply();
                };
                picker.setCallback(callback);
                picker.show(getParentFragmentManager(), "ColorPicker");
                break;
            case Keys.STATS_BG:
                bgDrawable.setVisible(backgroundBool);
                bgColor.setVisible(backgroundBool);
                bgColorPickerPref.setVisible(backgroundBool && colorBgBool);
                bgAlpha.setVisible(backgroundBool && colorBgBool);
                alphaSeekBar.setVisible(backgroundBool && colorBgBool);
                break;
            case Keys.BG_DRAWABLE:
                bgColor.setChecked(!drawableBgBool);
                bgColorPickerPref.setVisible(!drawableBgBool);
                bgAlpha.setVisible(!drawableBgBool);
                alphaSeekBar.setVisible(!drawableBgBool);
                break;
            case Keys.BG_COLOR:
                bgDrawable.setChecked(!colorBgBool);
                bgColorPickerPref.setVisible(colorBgBool);
                bgAlpha.setVisible(colorBgBool);
                alphaSeekBar.setVisible(colorBgBool);
                break;
            case Keys.BG_COLOR_PICKER:
                ColorPicker bgPicker = ColorPicker.newInstance(bgDefaultColorR, bgDefaultColorG, bgDefaultColorB);
                bgColorPicker = new WeakReference<>(bgPicker);

                bgPicker.enableAutoClose();

                ColorPickerCallback bgCallback = color -> {
                    bgDefaultColorR = Color.red(color);
                    bgDefaultColorG = Color.green(color);
                    bgDefaultColorB = Color.blue(color);
                    editor.putString("bg_stats_color", String.format("#%06X", (0xff4285f4 & color)));
                    editor.putInt("bg_red", Color.red(color));
                    editor.putInt("bg_green", Color.green(color));
                    editor.putInt("bg_blue", Color.blue(color));
                    editor.apply();
                };
                bgPicker.setCallback(bgCallback);
                bgPicker.show(getParentFragmentManager(), "ColorPicker");
                break;
            case Keys.APP_LIST:
                Log.i("checkStatsPermission()", String.valueOf(checkStatsPermission()));
                if (checkStatsPermission()) {
                    AppListStatsDialogFragment previous =
                            (appListStatsDialog != null) ? appListStatsDialog.get() : null;
                    if (previous != null && previous.isShowing()) {
                        previous.dismiss();
                    }
                    AppListStatsDialogFragment dialog = new AppListStatsDialogFragment();
                    appListStatsDialog = new WeakReference<>(dialog);
                    dialog.show(requireActivity().getSupportFragmentManager(),
                            AppListStatsDialogFragment.TAG);
                } else {
                    Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
                    startActivity(intent);
                }
                break;
            case Keys.APP_STATS_COORDINATES:
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorAppStats()).commit();
                break;
            case Keys.DISPLAY_CANBUS_READER:
                displayCanbusReaderSwitch();
                break;
            case Keys.CODES_GUIDE:
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CanbusGuide()).commit();
                break;
            case Keys.SKIP_CODES:
                alertSkipCodesDialog = displaySkipCodesDialog().create();

                alertSkipCodesDialog.setOnShowListener(dialog -> {
                    Button negativeSkipButton = alertSkipCodesDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                    negativeSkipButton.setLayoutParams(params);

                    ViewGroup.LayoutParams editSkipTextParams = skipCodesEditText.getLayoutParams();
                    if (editSkipTextParams instanceof ViewGroup.MarginLayoutParams skipParams) {
                        skipParams.setMargins(padding, padding, padding, padding);
                        skipCodesEditText.setLayoutParams(skipParams);
                    }

                    skipCodesEditText.requestFocus();
                    imm.showSoftInput(skipCodesEditText, InputMethodManager.SHOW_IMPLICIT);
                    skipCodesEditText.setSelection(skipCodesEditText.getText().length());
                });

                alertSkipCodesDialog.show();
                break;
            case Keys.CANBUS_LIBRARY_IMPORT:
                if (libraryImportJob == null) {
                    canbusLibraryPicker.launch(new String[]{"text/plain", "application/octet-stream", "*/*"});
                }
                break;
            case Keys.CANBUS_LIBRARY_RESET:
                confirmCanbusLibraryReset();
                break;
            case Keys.CODE_INSPECTOR:
                if (!helpers.codeInspectorBoolean()) {
                    // start the service
                    int inspectorTimeout = Integer.parseInt(sharedPrefs.getString(Keys.CODE_INSPECTOR_TIMEOUT, "300")) * 1000;
                    startCanbusCodeInspector();
                    setCountDownTimer(inspectorTimeout);
                    setTickRunnable(inspectorTimeout + 1000);
                } else {
                    // stop the service
                    stopCanbusCodeInspector();
                }
                break;
            case Keys.CODE_INSPECTOR_DATA:
                codeInspectorTimeoutStr = sharedPrefs.getString(Keys.CODE_INSPECTOR_TIMEOUT, "300");

                alertCodesInspectorDialog = displayCodesInspectorDialog().create();

                alertCodesInspectorDialog.setOnShowListener(dialog -> {
                    Button negativeInspectorButtonI = alertCodesInspectorDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                    negativeInspectorButtonI.setLayoutParams(params);
                    inspectorTimeoutEdit.requestFocus();
                    imm.showSoftInput(inspectorTimeoutEdit, InputMethodManager.SHOW_IMPLICIT);
                    inspectorTimeoutEdit.setSelection(inspectorTimeoutEdit.getText().length());
                });

                alertCodesInspectorDialog.show();
                break;
            default:
                break;
        }
        return false;
    }

    private void checkAndShowWidgetsBackgroundSelector() {
        List<String> perms = getMissingReadWallpaperPermissions(requireContext());
        if (perms.isEmpty()) {
            BackgroundSelectorDialog.showWithLoadedBackground(getParentFragmentManager(), requireContext(), "widgets", "bg_custom");
            pendingDialog = PendingDialog.NONE;
        } else {
            pendingDialog = PendingDialog.WIDGETS;
            requestPermissions(perms.toArray(new String[0]), REQ_READ_WALLPAPER);
        }
    }

    private void checkAndShowBarBackgroundSelector() {
        List<String> perms = getMissingReadWallpaperPermissions(requireContext());
        if (perms.isEmpty()) {
            BackgroundSelectorDialog.showWithLoadedBackground(getParentFragmentManager(), requireContext(), "bar", "app_list_bg");
            pendingDialog = PendingDialog.NONE;
        } else {
            pendingDialog = PendingDialog.BAR;
            requestPermissions(perms.toArray(new String[0]), REQ_READ_WALLPAPER);
        }
    }

    private static List<String> getMissingReadWallpaperPermissions(@NonNull Context ctx) {
        List<String> perms = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.READ_MEDIA_IMAGES)
                    != PackageManager.PERMISSION_GRANTED) {
                perms.add(Manifest.permission.READ_MEDIA_IMAGES);
            }
            // Some OEM/Platform implementations still require legacy READ_EXTERNAL_STORAGE; request it if not granted.
            if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                perms.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        } else {
            if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                perms.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        }
        return perms;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode != REQ_READ_WALLPAPER) return;

        boolean anyGranted = false;
        for (int r : grantResults) {
            if (r == PackageManager.PERMISSION_GRANTED) {
                anyGranted = true;
                break;
            }
        }
        Log.i("SettingsFragmentSecond", "onRequestPermissionsResult: anyGranted=" + anyGranted + " pendingDialog=" + pendingDialog);

        switch (pendingDialog) {
            case WIDGETS:
                BackgroundSelectorDialog.showWithLoadedBackground(getParentFragmentManager(), requireContext(), "widgets", "bg_custom");
                break;
            case BAR:
                BackgroundSelectorDialog.showWithLoadedBackground(getParentFragmentManager(), requireContext(), "bar", "app_list_bg");
                break;
            case NONE:
            default:
                break;
        }
        pendingDialog = PendingDialog.NONE;
    }



    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Only reached when the activity handles the change itself (no recreation). The bar height
        // is stored per orientation, so show the value of the new one.
        if (barHeightSeekBar != null) {
            barHeightSeekBar.refresh();
        }
        // Also while the switch is off, so its summary is current when it is turned on.
        handler.post(updateBarHeightSummary);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recyclerView = null;
        handler.removeCallbacksAndMessages(null);
        mHandler.removeCallbacksAndMessages(null);
        dismissDialogs();
        removeTickRunnable();
        cancelCountDownTimer();
        SkinAttribute skinAttribute = SkinUtils.getSkinAttr();
        if (skinAttribute != null) {
            skinAttribute.clear();
        }
        if (sharedPrefs != null) {
            sharedPrefs.unregisterOnSharedPreferenceChangeListener(pipPkgListener);
        }
    }

    @Override
    public void onDestroy() {
        clearPreferenceListeners(getPreferenceScreen());
        clearPreferenceRefs();
        super.onDestroy();
    }

    private void clearPreferenceRefs() {
        pipDualPref = null;
        pipFirstPref = null;
        pipSecondPref = null;
        pipThirdPref = null;
        pipFourthPref = null;
        restartPip = null;
        fabPreference = null;
        leftFabPreference = null;
        rightFabPreference = null;
        extendedDivider = null;
        coverSplash = null;
        swipeDetector = null;
        userDate = null;
        userMusic = null;
        userRadio = null;
        userStats = null;
        statsScreen = null;
        statsCodes = null;
        autoHidePreference = null;
        autoHideSeekBar = null;
        resizableBarPreference = null;
        barHeightSeekBar = null;
        imm = null;
    }

    private void refreshAllWidgetPreferences() {
        if (pipDualPref != null) { pipDualPref.refreshDisplayedValue(); }
        if (pipFirstPref != null) { pipFirstPref.refreshDisplayedValue(); }
        if (pipSecondPref != null) { pipSecondPref.refreshDisplayedValue(); }
        if (pipThirdPref != null) { pipThirdPref.refreshDisplayedValue(); }
        if (pipFourthPref != null) { pipFourthPref.refreshDisplayedValue(); }
        if (userDate != null) { userDate.refreshDisplayedValue(); }
        if (userMusic != null) { userMusic.refreshDisplayedValue(); }
        if (userRadio != null) { userRadio.refreshDisplayedValue(); }
        if (statsScreen != null) { statsScreen.refreshDisplayedValue(); }
    }

    private void initUserStats() {
        if (userStats != null) {
            SharedPreferences mPrefs = SessionPrefs.get();
            String can = mPrefs.getString("canbus_class", "vehicle_not_exist");
            if (!can.equals("vehicle_not_exist")) {
                userStats.setSummary(Html.fromHtml(
                    getString(R.string.stats_window_summary, can.replace("class ", "")), 
                    Html.FROM_HTML_MODE_LEGACY));
            } else {
                userStats.setSummary(getString(R.string.stats_window_summary_vehicle_not_exist));
            }
            userStats.setOnPreferenceClickListener(this);  
        }
    }

    private void clearPreferenceListeners(PreferenceGroup group) {
        if (group == null) return;

        for (int i = 0; i < group.getPreferenceCount(); i++) {
            Preference p = group.getPreference(i);
            p.setOnPreferenceClickListener(null);
            p.setOnPreferenceChangeListener(null);
            if (p instanceof CustomDualPipPreference) {
                CustomDualPipPreference dp = (CustomDualPipPreference) p;
                dp.setOnPositionClickListener(null);
                dp.setOnPreferenceValuesChangedListener(null);
                dp.setOnMainSwitchClickListener(null);
            } else if (p instanceof CustomPipSwitchPreference) {
                CustomPipSwitchPreference sp = (CustomPipSwitchPreference) p;
                sp.setOnPositionClickListener(null);
                sp.setOnPreferenceValuesChangedListener(null);
                sp.setOnMainSwitchClickListener(null);
                sp.setOnModeSwitchChangeListener(null);
            } else if (p instanceof CustomWidgetSwitchPreference) {
                CustomWidgetSwitchPreference wp = (CustomWidgetSwitchPreference) p;
                wp.setOnPositionClickListener(null);
                wp.setOnPreferenceValuesChangedListener(null);
            } else if (p instanceof CustomWidgetPreference) {
                CustomWidgetPreference wp = (CustomWidgetPreference) p;
                wp.setOnPositionClickListener(null);
                wp.setOnPreferenceValuesChangedListener(null);
            } else if (p instanceof AutoHideSeekBarPreference) {
                ((AutoHideSeekBarPreference) p).setOnSeekBarProgressChangeListener(null);
            }

            if (p instanceof PreferenceGroup) {
                clearPreferenceListeners((PreferenceGroup) p);
            }
        }
    }

    private void dismissDialogs() {
        if (libraryImportDialog != null && libraryImportDialog.isShowing()) {
            // The work goes on without this screen: its result comes as a toast
            libraryImportBackground = true;
            libraryImportDialog.dismiss();
        }
        libraryImportDialog = null;
        if (libraryImportDoneDialog != null && libraryImportDoneDialog.isShowing()) {
            libraryImportDoneDialog.dismiss();
        }
        libraryImportDoneDialog = null;
        if (libraryResetDialog != null && libraryResetDialog.isShowing()) {
            libraryResetDialog.dismiss();
        }
        libraryResetDialog = null;
        if (alertPipDialog != null && alertPipDialog.isShowing()) {
            alertPipDialog.dismiss();
            alertPipDialog = null;
        }
        if (alertCodesDialog != null && alertCodesDialog.isShowing()) {
            alertCodesDialog.dismiss();
            alertCodesDialog = null;
        }
        if (alertExtraCodesDialog != null && alertExtraCodesDialog.isShowing()) {
            alertExtraCodesDialog.dismiss();
            alertExtraCodesDialog = null;
        }
        if (colorPicker != null) {
            ColorPicker dialog = colorPicker.get();
            if (dialog != null && dialog.isAdded()) {
                dialog.dismissAllowingStateLoss();
                getParentFragmentManager().executePendingTransactions();
            }
            colorPicker = null;
        }
        if (bgColorPicker != null) {
            ColorPicker bgDialog = bgColorPicker.get();
            if (bgDialog != null && bgDialog.isAdded()) {
                bgDialog.dismissAllowingStateLoss();
                getParentFragmentManager().executePendingTransactions();
            }
            bgColorPicker = null;
        }
        if (appListStatsDialog != null) {
            AppListStatsDialogFragment statsDialog = appListStatsDialog.get();
            if (statsDialog != null && statsDialog.isAdded()) {
                statsDialog.dismissAllowingStateLoss();
                getParentFragmentManager().executePendingTransactions();
            }
            appListStatsDialog = null;
        }
        Fragment pipPicker = requireActivity()
                .getSupportFragmentManager()
                .findFragmentByTag(AppListPipDialogFragment.TAG);
        if (pipPicker instanceof AppListPipDialogFragment && pipPicker.isAdded()) {
            ((AppListPipDialogFragment) pipPicker).dismissAllowingStateLoss();
            requireActivity().getSupportFragmentManager().executePendingTransactions();
        }
        if (alertSkipCodesDialog != null && alertSkipCodesDialog.isShowing()) {
            alertSkipCodesDialog.dismiss();
            alertSkipCodesDialog = null;
        }
        if (alertCodesInspectorDialog != null && alertCodesInspectorDialog.isShowing()) {
            alertCodesInspectorDialog.dismiss();
            alertCodesInspectorDialog = null;
        }
        if (alertStartPageDialog != null && alertStartPageDialog.isShowing()) {
            alertStartPageDialog.dismiss();
            alertStartPageDialog = null;
        }
        if (alertMarginsDialog != null && alertMarginsDialog.isShowing()) {
            alertMarginsDialog.dismiss();
            alertMarginsDialog = null;
        }
    }
    
    private void autoHideSeekBarProgress(AutoHideSeekBarPreference autoHidePreference) {
        autoHidePreference.setOnSeekBarProgressChangeListener(new AutoHideSeekBarPreference.OnSeekBarProgressChangeListener() {
            @Override
            public void onProgressChanged(int progress) {
                handler.post(updateSummary);
            }
        });
    }

    private Runnable updateSummary = new Runnable() { 
        @Override
        public void run() {
            if (autoHidePreference instanceof TwoStatePreference) {
                ((TwoStatePreference) autoHidePreference).setSummaryOn(autoHideSumary());
            }
        }        

        private String autoHideSumary() {
            int progress = sharedPrefs.getInt(Keys.AUTO_HIDE_TIMEOUT, 3);
            String autoHideStr = getString(R.string.auto_hide_timeout, String.valueOf(progress));
            return autoHideStr;
        }
    };

    private void barHeightSeekBarProgress(BottomBarHeightSeekBarPreference heightPreference) {
        // Called by the preference only when the user really moves the slider to a new value
        // (never when the row is bound); the value is then stored under Keys.BOTTOM_BAR_HEIGHT_PORT
        // or Keys.BOTTOM_BAR_HEIGHT_LAND, whichever matches the current orientation.
        heightPreference.setOnPreferenceChangeListener((preference, newValue) -> {
            helpers.setBarSettingsChanged(true);
            handler.post(updateBarHeightSummary);
            return true;
        });
    }

    private final Runnable updateBarHeightSummary = new Runnable() {
        @Override
        public void run() {
            if (resizableBarPreference != null && isAdded()) {
                resizableBarPreference.setSummaryOn(barHeightSummary());
            }
        }

        private String barHeightSummary() {
            // Straight from the preferences, for the current orientation - the same value the
            // launcher will use.
            boolean portrait = BottomBarDimensions.isPortrait(requireContext());
            float multiplier = BottomBarDimensions.getConfiguredMultiplier(sharedPrefs, portrait);
            return getString(R.string.resizable_bottom_bar_summary,
                    BottomBarHeightSeekBarPreference.formatPercent(multiplier),
                    getString(portrait
                            ? R.string.bottom_bar_height_portrait
                            : R.string.bottom_bar_height_landscape));
        }
    };

    /**
     * AlphaSeekBarPreference shows 0 for a value that was never saved (it ignores
     * android:defaultValue).
     * Saving the shared default once makes the bar show the value that is actually applied.
     */
    private void storeAlphaDefault(AlphaSeekBarPreference seekPreference, String key, int value) {
        if (!sharedPrefs.contains(key)) {
            seekPreference.resetPosition(value);
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
                String timeFormat = String.format(Locale.ROOT, "%02d:%02d:%02d", hours, minutes, seconds);
                codeInspector.setSummary(getString(
                        R.string.code_inspector_summary_working,
                        timeFormat
                ));
            }

            public void onFinish() {
                codeInspector.setSummary(getString(
                        R.string.code_inspector_summary_working,
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
            codeInspector.setEnabled(true);
            codeInspector.setSummary(getString(R.string.code_inspector_summary));
            removeTickRunnable();
        }
    };

    public void startCanbusCodeInspector() {
        Intent intent = new Intent(this.requireContext(), CanbusCodeInspector.class);
        ServiceIntentGate.startIfAvailable(this.requireContext(), intent, "canbus code inspector");
    }

    public void stopCanbusCodeInspector() {
        Intent intent = new Intent(this.requireContext(), CanbusCodeInspector.class);
        SysCalls.stopService(this.requireContext(), intent);
        removeTickRunnable();
        cancelCountDownTimer();
        codeInspector.setSummary(getString(R.string.code_inspector_summary));
    }

    private void dialogStartPageEditText() {
        startPageEditText = new EditText(this.getContext());
        startPageEditText.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "99")});
        startPageEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        startPageEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        startPageEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveStartPage();
                alertStartPageDialog.dismiss();
            }
            return false;
        });
    }

    private void dialogMarginEditText() {
        marginEditText = new EditText(this.getContext());
        marginEditText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "25")});
        marginEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        marginEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        marginEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveMargin();
                alertMarginsDialog.dismiss();
            }
            return false;
        });
    }

    private void dialogCodesEditText(EditText codesEditText) {
        codesEditText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "9999")});
        codesEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        codesEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        codesEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveCode(codesEditText);
                alertCodesDialog.dismiss();
            }
            return false;
        });
    }

    /** A cmd field of the Canbus codes window: cmdInt is a number, cmdArr numbers separated by commas. */
    private void dialogCmdEditText(EditText field, EditText cmdInt, EditText cmdArr, boolean list) {
        if (list) {
            field.setInputType(InputType.TYPE_CLASS_TEXT);
            field.setKeyListener(DigitsKeyListener.getInstance("0123456789,-"));
        } else {
            field.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "9999")});
            field.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        field.setImeOptions(EditorInfo.IME_ACTION_DONE);
        field.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveCmdFields(cmdInt, cmdArr);
                alertCodesDialog.dismiss();
            }
            return false;
        });
    }

    private void dialogExtraCodesEditText(EditText codesEditText) {
        codesEditText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "9999")});
        codesEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        codesEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        codesEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveExtraCode(codesEditText);
                alertExtraCodesDialog.dismiss();
            }
            return false;
        });
    }

    private void dialogSkipCodesEditText() {
        skipCodesEditText = new EditText(this.getContext());
        skipCodesEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        skipCodesEditText.setKeyListener(DigitsKeyListener.getInstance("0123456789, "));
        skipCodesEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        skipCodesEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveSkipCodes();
                alertSkipCodesDialog.dismiss();
            }
            return false;
        });
    }

    private void dialogCodesInspectorEditText(EditText codesEditText) {
        codesEditText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "9999")});
        codesEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        codesEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        codesEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveInspectorCode(codesEditText);
                alertCodesInspectorDialog.dismiss();
            }
            return false;
        });
    }

    private void userStatsSwitch() {
        if (userStatsBool) {
            statsScreen.setVisible(true);
            statsCodes.setVisible(true);
            extraStatsCodes.setVisible(true);
            mainScreenStats.setVisible(true);
            colorPickerPref.setVisible(true);
            statsBg.setVisible(true);
            appList.setVisible(true);
            appStatsCoordinates.setVisible(true);
            if (backgroundBool) {
                bgDrawable.setVisible(true);
                bgColor.setVisible(true);
                if (colorBgBool && !drawableBgBool) {
                    bgColor.setChecked(true);
                    bgDrawable.setChecked(false);
                    bgColorPickerPref.setVisible(true);
                    bgAlpha.setVisible(true);
                    alphaSeekBar.setVisible(true);
                } else {
                    bgDrawable.setChecked(true);
                    bgColorPickerPref.setVisible(false);
                    bgAlpha.setVisible(false);
                    alphaSeekBar.setVisible(false);
                }
            } else {
                bgDrawable.setVisible(false);
                bgColor.setVisible(false);
                bgColorPickerPref.setVisible(false);
                bgAlpha.setVisible(false);
                alphaSeekBar.setVisible(false);
            }
        } else {
            statsScreen.setVisible(false);
            statsCodes.setVisible(false);
            extraStatsCodes.setVisible(false);
            mainScreenStats.setVisible(false);
            colorPickerPref.setVisible(false);
            statsBg.setVisible(false);
            appList.setVisible(false);
            appStatsCoordinates.setVisible(false);
            bgDrawable.setVisible(false);
            bgColor.setVisible(false);
            bgColorPickerPref.setVisible(false);
            bgAlpha.setVisible(false);
            alphaSeekBar.setVisible(false);
        }
    }

    private void displayCanbusReaderSwitch() {
        if (displayCanbusReaderBool) {
            codesGuide.setVisible(true);
            skipCodes.setVisible(true);
            inspectorCategory.setVisible(true);
            codeInspector.setVisible(true);
            codeInspectorData.setVisible(true);
            skipZeroCodes.setVisible(true);
        } else {
            codesGuide.setVisible(false);
            skipCodes.setVisible(false);
            inspectorCategory.setVisible(false);
            codeInspector.setVisible(false);
            codeInspectorData.setVisible(false);
            skipZeroCodes.setVisible(false);
        }
        updateCanbusLibraryPrefs();
    }

    private boolean statsBackgroundBool() {
        return userStatsBool && backgroundBool;
    }

    private boolean checkStatsPermission() {
        try {
            PackageManager packageManager = requireActivity().getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(requireActivity().getPackageName(), 0);
            AppOpsManager appOpsManager = (AppOpsManager) requireActivity().getSystemService(Context.APP_OPS_SERVICE);
            int mode = appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, applicationInfo.uid, applicationInfo.packageName);
            boolean granted;
            if (mode == AppOpsManager.MODE_DEFAULT) {
                granted = (requireActivity().checkCallingOrSelfPermission(android.Manifest.permission.PACKAGE_USAGE_STATS) == PackageManager.PERMISSION_GRANTED);
            } else {
                granted = (mode == AppOpsManager.MODE_ALLOWED);
            }
            return granted;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private AlertDialog.Builder displayStartPageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(R.string.start_page_str);
        if(startPageEditText.getParent() != null) {
            ((ViewGroup)startPageEditText.getParent()).removeView(startPageEditText);
        }
        builder.setView(startPageEditText);
        startPageEditText.setText(startPage.getSummary());
        startPageEditText.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveStartPage());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private AlertDialog.Builder displayMarginsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(R.string.margins_str);
        if(marginEditText.getParent() != null) {
            ((ViewGroup)marginEditText.getParent()).removeView(marginEditText);
        }
        builder.setView(marginEditText);
        marginEditText.setText(margin.getSummary());
        marginEditText.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveMargin());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    // ---- Canbus library: import and reset ---------------------------------------------------

    private final ActivityResultLauncher<String[]> canbusLibraryPicker =
            registerForActivityResult(new ActivityResultContracts.OpenDocument(), this::onCanbusLibraryPicked);

    /** The numbers in the summary of the import, whether the reset is there, and both off while an import runs. */
    private void updateCanbusLibraryPrefs() {
        if (canbusLibraryImport == null || canbusLibraryReset == null) {
            return;
        }
        CanbusLibrary.Library effective = CanbusLibrary.cached();
        CanbusLibrary.Library overlay = CanbusLibrary.overlayCached();
        canbusLibraryImport.setVisible(displayCanbusReaderBool);
        canbusLibraryImport.setEnabled(libraryImportJob == null);
        if (effective != null && overlay != null) {
            canbusLibraryImport.setSummary(getString(R.string.canbus_library_import_summary,
                    effective.carsWithClass(), effective.carsWithRequest(), overlay.recordCount()));
        }
        canbusLibraryReset.setVisible(displayCanbusReaderBool && overlay != null && !overlay.isEmpty());
        canbusLibraryReset.setEnabled(libraryImportJob == null);
        if (statsCodes != null) {
            statsCodes.setSummary(statsCodesSummary());
        }
    }

    private void onCanbusLibraryPicked(Uri uri) {
        if (uri == null || libraryImportJob != null || !isAdded()) {
            return;
        }
        libraryImportBackground = false;
        showCanbusLibraryImportDialog();
        libraryImportJob = CanbusLibraryImport.start(requireContext(), uri, canbusLibraryImportListener);
        updateCanbusLibraryPrefs();
    }

    private void showCanbusLibraryImportDialog() {
        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_canbus_library_import, null);
        libraryImportStatus = dialogView.findViewById(R.id.canbus_library_import_status);
        libraryImportBar = dialogView.findViewById(R.id.canbus_library_import_progress);
        ConstraintLayout constraint = dialogView.findViewById(R.id.constraint_library_import);
        constraint.setPadding(padding, padding, padding, padding);
        setCalculatedSizes(dialogView, R.id.canbus_library_import_title, SettingsActivity.dialogTitle, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.canbus_library_import_status, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setView(dialogView)
                .setCancelable(false)
                .setNegativeButton(R.string.canbus_library_cancel, null)
                .setNeutralButton(R.string.canbus_library_background, null);
        libraryImportDialog = builder.create();
        libraryImportDialog.setCanceledOnTouchOutside(false);
        libraryImportDialog.setOnShowListener(dialog -> {
            // Their own click handlers: the dialog stays until the work reports back
            final Button cancel = libraryImportDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
            cancel.setOnClickListener(v -> {
                if (libraryImportJob != null) {
                    libraryImportJob.cancel();
                    cancel.setEnabled(false);
                }
            });
            libraryImportDialog.getButton(DialogInterface.BUTTON_NEUTRAL).setOnClickListener(v -> {
                libraryImportBackground = true;
                dismissCanbusLibraryImportDialog();
            });
        });
        libraryImportDialog.show();
    }

    private void dismissCanbusLibraryImportDialog() {
        if (libraryImportDialog != null && libraryImportDialog.isShowing()) {
            libraryImportDialog.dismiss();
        }
        libraryImportDialog = null;
    }

    private final CanbusLibraryImport.Listener canbusLibraryImportListener = new CanbusLibraryImport.Listener() {
        @Override
        public void onProgress(int phase, int percent, int line, int totalLines) {
            if (!isAdded() || libraryImportDialog == null || !libraryImportDialog.isShowing()) {
                return;
            }
            if (percent >= 0) {
                libraryImportBar.setProgress(percent);
            }
            switch (phase) {
                case CanbusLibraryImport.PHASE_READ:
                    libraryImportStatus.setText(R.string.canbus_library_phase_read);
                    break;
                case CanbusLibraryImport.PHASE_VALIDATE:
                    libraryImportStatus.setText(getString(R.string.canbus_library_phase_validate,
                            line, Math.max(totalLines, line)));
                    break;
                case CanbusLibraryImport.PHASE_MERGE:
                    libraryImportStatus.setText(R.string.canbus_library_phase_merge);
                    break;
                default:
                    libraryImportStatus.setText(R.string.canbus_library_phase_save);
                    break;
            }
        }

        @Override
        public void onSaving() {
            if (libraryImportDialog != null && libraryImportDialog.isShowing()) {
                libraryImportDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setEnabled(false);
            }
        }

        @Override
        public void onFinished(CanbusLibraryImport.Outcome outcome) {
            onCanbusLibraryImportFinished(outcome);
        }
    };

    private void onCanbusLibraryImportFinished(CanbusLibraryImport.Outcome outcome) {
        libraryImportJob = null;
        final Context app = LauncherApplication.sApp;
        // A screen that is gone behaves as "Run in background"
        final boolean showDialog = !libraryImportBackground && isAdded() && libraryImportDialog != null;
        dismissCanbusLibraryImportDialog();
        if (isAdded()) {
            updateCanbusLibraryPrefs();
            initUserStats();
        }
        if (outcome.kind == CanbusLibraryImport.Kind.CANCELLED) {
            Toast.makeText(app, R.string.canbus_library_cancelled, Toast.LENGTH_LONG).show();
            return;
        }
        final boolean success = outcome.kind == CanbusLibraryImport.Kind.SUCCESS;
        if (showDialog) {
            String report = outcome.reportPath() != null ? outcome.reportPath()
                    : getString(R.string.canbus_library_report_not_saved);
            String message = success
                    ? getString(R.string.canbus_library_import_done, outcome.added, outcome.duplicates, outcome.replaced, report)
                    : getString(R.string.canbus_library_import_failed, outcome.firstError, report);
            libraryImportDoneDialog = new AlertDialog.Builder(requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert)
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
        } else {
            int text;
            if (outcome.reportFolder != null) {
                text = success ? R.string.canbus_library_toast_success : R.string.canbus_library_toast_failed;
                Toast.makeText(app, app.getString(text, outcome.reportFolder), Toast.LENGTH_LONG).show();
            } else {
                text = success ? R.string.canbus_library_toast_success_no_report : R.string.canbus_library_toast_failed_no_report;
                Toast.makeText(app, text, Toast.LENGTH_LONG).show();
            }
        }
    }

    private void confirmCanbusLibraryReset() {
        if (libraryImportJob != null) {
            return;
        }
        libraryResetDialog = new AlertDialog.Builder(requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert)
                .setMessage(R.string.canbus_library_reset_confirm)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    final Context app = LauncherApplication.sApp;
                    CanbusLibraryImport.reset(requireContext(), () -> {
                        Toast.makeText(app, R.string.canbus_library_reset_done, Toast.LENGTH_LONG).show();
                        if (isAdded()) {
                            updateCanbusLibraryPrefs();
                            initUserStats();
                        }
                    });
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    private AlertDialog.Builder displayCodesDialog() {
        EditText cmdArrCodeInt;
        EditText cmdIntCodeInt;
        EditText rangeCodeInt;
        LayoutInflater inflater = LayoutInflater.from(this.requireContext());
        View dialogView = inflater.inflate(R.layout.dialog_codes_layout, null);

        fuelCodeInt = dialogView.findViewById(R.id.fuel_code_int);
        rangeCodeInt = dialogView.findViewById(R.id.range_code_int);
        cmdIntCodeInt = dialogView.findViewById(R.id.cmdInt_code_int);
        cmdArrCodeInt = dialogView.findViewById(R.id.cmdArr_code_int);

        ConstraintLayout constraintInspector = dialogView.findViewById(R.id.constraint_codes);
        constraintInspector.setPadding(padding, padding, padding, padding);

        setCalculatedSizes(dialogView, R.id.stats_dialog_title, SettingsActivity.dialogTitle, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.fuel_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.range_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.cmdInt_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.cmdArr_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.known_requests_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);

        dialogCodesEditText(fuelCodeInt);
        dialogCodesEditText(rangeCodeInt);

        // Nothing written (or "0") means the code of the library: empty field, the code as the hint
        showCode(fuelCodeInt, fuelCodeStr, libraryCode(true));
        showCode(rangeCodeInt, rangeCodeStr, libraryCode(false));
        fuelCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        rangeCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));

        // The cmd fields are for the cars whose original fuel screen sends a request when it opens (the
        // library knows them); for any other car they are not there, and nothing is sent to it.
        final boolean needsRequest = carNeedsRequest();
        final View[] cmdViews = {
                dialogView.findViewById(R.id.cmdInt_code_text), cmdIntCodeInt,
                dialogView.findViewById(R.id.cmdArr_code_text), cmdArrCodeInt,
                dialogView.findViewById(R.id.known_requests_text)};
        for (View v : cmdViews) {
            v.setVisibility(needsRequest ? View.VISIBLE : View.GONE);
        }
        if (needsRequest) {
            CanbusLibrary.Library library = CanbusLibrary.cached();
            int carId = DataCanbus.DATA[1000];
            dialogCmdEditText(cmdIntCodeInt, cmdIntCodeInt, cmdArrCodeInt, false);
            dialogCmdEditText(cmdArrCodeInt, cmdIntCodeInt, cmdArrCodeInt, true);
            // Nothing written (or the old "0" and "0") shows empty fields with the first request as the hint
            boolean written = CanbusLibrary.userRequest(sharedPrefs) != null;
            cmdIntCodeInt.setText(written ? cmdIntCodeStr : "");
            cmdArrCodeInt.setText(written ? cmdArrCodeStr : "");
            CanbusLibrary.Request first = CanbusLibrary.firstRequest(library, carId);
            if (first != null) {
                cmdIntCodeInt.setHint(String.valueOf(first.cmd));
                cmdArrCodeInt.setHint(first.intsText());
            }
            cmdIntCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
            cmdArrCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
            ((TextView) dialogView.findViewById(R.id.known_requests_text)).setText(
                    getString(R.string.stats_codes_known_requests, CanbusLibrary.knownRequestsText(library, carId)));
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        final Runnable save = () -> {
                fuelCodeStr = fuelCodeInt.getText().toString();
                rangeCodeStr = rangeCodeInt.getText().toString();
                saveCode(fuelCodeInt);
                saveCode(rangeCodeInt);
                if (needsRequest) {
                    saveCmdFields(cmdIntCodeInt, cmdArrCodeInt);
                }
            };
        builder.setView(dialogView).setPositiveButton(R.string.set_btn, (dialog, which) -> save.run());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        builder.setOnCancelListener(dialog -> {
                save.run();
                dialog.dismiss();
            });
        return builder;
    }

    private AlertDialog.Builder displayExtraCodesDialog() {
        EditText vehicleMassCodeInt;
        EditText horsePowerCodeInt;
        LayoutInflater inflater = LayoutInflater.from(this.requireContext());
        View dialogView = inflater.inflate(R.layout.dialog_extra_codes_layout, null);

        rpmCodeInt = dialogView.findViewById(R.id.rpm_code_int);
        horsePowerCodeInt = dialogView.findViewById(R.id.horse_power_code_int);
        vehicleMassCodeInt = dialogView.findViewById(R.id.vehicle_mass_code_int);

        ConstraintLayout constraintInspector = dialogView.findViewById(R.id.constraint_extra);
        constraintInspector.setPadding(padding, padding, padding, padding);

        setCalculatedSizes(dialogView, R.id.canbus_optional, SettingsActivity.dialogTitle, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.canbus_optional_description, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.rpm_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.horse_power_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.vehicle_mass_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);

        dialogExtraCodesEditText(rpmCodeInt);
        dialogExtraCodesEditText(horsePowerCodeInt);
        dialogExtraCodesEditText(vehicleMassCodeInt);

        rpmCodeInt.setText(rpmCodeStr);
        horsePowerCodeInt.setText(horsePowerCodeStr);
        vehicleMassCodeInt.setText(vehicleMassCodeStr);

        rpmCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        horsePowerCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        vehicleMassCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));

        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setView(dialogView).setPositiveButton(R.string.set_btn, (dialog, which) -> {
                rpmCodeStr = rpmCodeInt.getText().toString();
                horsePowerCodeStr = horsePowerCodeInt.getText().toString();
                vehicleMassCodeStr = vehicleMassCodeInt.getText().toString();
                saveExtraCode(rpmCodeInt);
                saveExtraCode(horsePowerCodeInt);
                saveExtraCode(vehicleMassCodeInt);
                dialog.dismiss();
            });
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        builder.setOnCancelListener(dialog -> {
                rpmCodeStr = rpmCodeInt.getText().toString();
                horsePowerCodeStr = horsePowerCodeInt.getText().toString();
                vehicleMassCodeStr = vehicleMassCodeInt.getText().toString();
                saveExtraCode(rpmCodeInt);
                saveExtraCode(horsePowerCodeInt);
                saveExtraCode(vehicleMassCodeInt);
                dialog.dismiss();
            });
        return builder;
    }

    private AlertDialog.Builder displaySkipCodesDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(R.string.skip_codes_dialog_str);
        if(skipCodesEditText.getParent() != null) {
            ((ViewGroup)skipCodesEditText.getParent()).removeView(skipCodesEditText);
        }
        builder.setView(skipCodesEditText);
        Set<String> skipCodesSet = sharedPrefs.getStringSet(Keys.SKIP_CODES, Collections.singleton(""));
        String skipCodesStr = skipCodesSet != null ? String.join(", ", skipCodesSet) : "";
        skipCodesEditText.setText(skipCodesStr);
        skipCodesEditText.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveSkipCodes());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private AlertDialog.Builder displayCodesInspectorDialog() {
        LayoutInflater inflater = LayoutInflater.from(this.requireContext());
        View dialogView = inflater.inflate(R.layout.dialog_inspector_codes_layout, null);

        inspectorTimeoutEdit = dialogView.findViewById(R.id.code_inspector_timeout);

        ConstraintLayout constraintInspector = dialogView.findViewById(R.id.constraint_inspector);
        constraintInspector.setPadding(padding, padding, padding, padding);

        setCalculatedSizes(dialogView, R.id.code_inspector_data_title, SettingsActivity.dialogTitle, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.code_inspector_timeout_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);

        dialogCodesInspectorEditText(inspectorTimeoutEdit);
        inspectorTimeoutEdit.setText(codeInspectorTimeoutStr);
        inspectorTimeoutEdit.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));

        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setView(dialogView).setPositiveButton(R.string.set_btn, (dialog, which) -> {
                codeInspectorTimeoutStr = inspectorTimeoutEdit.getText().toString();
                saveInspectorCode(inspectorTimeoutEdit);
            });
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        builder.setOnCancelListener(dialog -> {
                codeInspectorTimeoutStr = inspectorTimeoutEdit.getText().toString();
                saveInspectorCode(inspectorTimeoutEdit);
                dialog.dismiss();
            });
        return builder;
    }

    private void setCalculatedSizes(View view, int textViewId, int textSize, int margin) {
        TextView textView = view.findViewById(textViewId);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);

        if (textView.getLayoutParams() instanceof ConstraintLayout.LayoutParams params) {
            if (textViewId == R.id.code_inspector_data_title
             || textViewId == R.id.canbus_library_import_title
             || textViewId == R.id.stats_dialog_title
             || textViewId == R.id.canbus_optional) {
                params.bottomMargin = margin;
            } else {
                params.topMargin = margin;
            }
            textView.setLayoutParams(params);
        }
    }

    private void saveStartPage() {
        String valueStr = startPageEditText.getText().toString();
        if (valueStr.isEmpty()) valueStr = "1";
        startPage.setSummary(valueStr);
        editor.putString(Keys.START_PAGE, valueStr);
        editor.apply();
    }

    private void saveMargin() {
        String valueStr = marginEditText.getText().toString();
        if (valueStr.isEmpty()) valueStr = "5";
        margin.setSummary(valueStr);
        editor.putString(Keys.LAYOUT_MARGIN, valueStr);
        editor.apply();
    }

    private void saveCode(EditText code) {
        String valueStr = code.getText().toString();
        if (valueStr.isEmpty()) valueStr = "0";
        editor.putString(code.getResources().getResourceEntryName(code.getId()), valueStr);
        editor.apply();
        statsCodes.setSummary(statsCodesSummary());
    }

    /** Whether the library says this car needs a request: the cmd fields are for such cars only. */
    private boolean carNeedsRequest() {
        CanbusLibrary.Library library = CanbusLibrary.cached();
        int carId = DataCanbus.DATA[1000];
        return library != null && carId != 0 && !library.pagesFor(carId).isEmpty();
    }

    /** Whether a saved code is not set: empty or "0" (the library's code is used then). */
    private static boolean codeUnset(String saved) {
        return saved == null || saved.trim().isEmpty() || saved.trim().equals("0");
    }

    /** The code the library knows for this car, fuel or range, or -1. */
    private static int libraryCode(boolean fuel) {
        CanbusLibrary.Library library = CanbusLibrary.cached();
        int carId = DataCanbus.DATA[1000];
        CanbusLibrary.CarCodes codes = library == null || carId == 0 ? null : library.codesFor(carId);
        return codes == null ? -1 : fuel ? codes.fuel : codes.range;
    }

    private void showCode(EditText field, String saved, int libraryCode) {
        if (codeUnset(saved) && libraryCode >= 0) {
            field.setText("");
            field.setHint(String.valueOf(libraryCode));
        } else {
            field.setText(saved);
        }
    }

    /** The saved code for the summary; "91 (library)" when none is set and the library knows one. */
    private String codeForSummary(String saved, boolean fuel) {
        int fromLibrary = libraryCode(fuel);
        return codeUnset(saved) && fromLibrary >= 0
                ? getString(R.string.stats_codes_library_code, String.valueOf(fromLibrary)) : saved;
    }

    private String statsCodesSummary() {
        String fuel = codeForSummary(sharedPrefs.getString("fuel_code_int", "0"), true);
        String range = codeForSummary(sharedPrefs.getString("range_code_int", "0"), false);
        if (!carNeedsRequest()) {
            return getString(R.string.stats_codes_summary_no_request, fuel, range);
        }
        CanbusLibrary.Request user = CanbusLibrary.userRequest(sharedPrefs);
        String request = user != null ? user.toString()
                : getString(R.string.stats_codes_request_auto,
                        CanbusLibrary.firstRequest(CanbusLibrary.cached(), DataCanbus.DATA[1000]));
        return getString(R.string.stats_codes_summary_request, fuel, range, request);
    }

    /**
     * Saves the cmd fields of the Canbus codes window: empty stays empty (the first screen's request is
     * sent), cmdArr is written as plain numbers ("74,3"). A bad text is not saved, with a toast.
     */
    private void saveCmdFields(EditText cmdInt, EditText cmdArr) {
        String cmd = cmdInt.getText().toString().trim();
        int[] ints = CanbusLibrary.parseInts(cmdArr.getText().toString());
        if (ints == null || (!cmd.isEmpty() && !cmd.matches("[0-9]{1,4}"))) {
            Toast.makeText(this.requireContext(), R.string.stats_codes_cmd_invalid, Toast.LENGTH_LONG).show();
            return;
        }
        StringBuilder arr = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            if (i > 0) {
                arr.append(',');
            }
            arr.append(ints[i]);
        }
        editor.putString(Keys.CMD_INT, cmd);
        editor.putString(Keys.CMD_ARR, arr.toString());
        editor.apply();
        cmdIntCodeStr = cmd;
        cmdArrCodeStr = arr.toString();
        statsCodes.setSummary(statsCodesSummary());
    }

    private void saveExtraCode(EditText code) {
        String valueStr = code.getText().toString();
        if (valueStr.isEmpty()) valueStr = "0";
        editor.putString(code.getResources().getResourceEntryName(code.getId()), valueStr);
        editor.apply();
        extraStatsCodes.setSummary(getString(R.string.extra_stats_codes_summary,
            sharedPrefs.getString("rpm_code_int", "0"),
            sharedPrefs.getString("horse_power_code_int", "0"),
            sharedPrefs.getString("vehicle_mass_code_int", "0")));
    }

    private void saveSkipCodes() {
        String input = skipCodesEditText.getText().toString().trim();

        Set<String> stringSet = new HashSet<>();

        if (input.isEmpty()) {
            skipCodes.setSummary(getString(R.string.skip_codes_empty_summary));
            editor.putStringSet(Keys.SKIP_CODES, stringSet);
            editor.apply();
            return;
        }

        // Split input and convert to Set<String>
        String[] codes = input.split(",");

        for (String code : codes) {
            try {
                // Validate & trim each code
                String trimmedCode = code.trim();
                Integer.parseInt(trimmedCode); // Ensure it's a valid integer
                stringSet.add(trimmedCode);
            } catch (NumberFormatException e) {
                // Handle invalid numbers
                Log.e("TAG", "Invalid number: " + code);
            }
        }

        String skipCodesString = stringSet != null ? String.join(", ", stringSet) : "";
        skipCodes.setSummary(getString(R.string.skip_codes_summary, skipCodesString));

        editor.putStringSet(Keys.SKIP_CODES, stringSet);
        editor.apply();
    }

    private void saveInspectorCode(EditText code) {
        String codeToSaveStr = code.getResources().getResourceEntryName(code.getId());
        String valueStr = code.getText().toString();
        if ((valueStr.isEmpty() || valueStr.equals("0")) && codeToSaveStr.equals(Keys.CODE_INSPECTOR_TIMEOUT)) {
            valueStr = "300";
        } else if (valueStr.isEmpty()) {
            valueStr = "0";
        }
        editor.putString(code.getResources().getResourceEntryName(code.getId()), valueStr);
        editor.apply();
        codeInspectorData.setSummary(getString(R.string.code_inspector_data_summary_time,
            sharedPrefs.getString(Keys.CODE_INSPECTOR_TIMEOUT, "300")));
    }

    /**
     * Hides a preference, and with a category the separator above it, so no two separators
     * meet.
     */
    private void hideWithSeparator(@Nullable Preference preference) {
        if (preference == null) return;
        preference.setVisible(false);
        if (!(preference instanceof PreferenceCategory)) return;
        androidx.preference.PreferenceGroup parent = preference.getParent();
        if (parent == null) return;
        for (int i = 1; i < parent.getPreferenceCount(); i++) {
            if (parent.getPreference(i) != preference) continue;
            Preference above = parent.getPreference(i - 1);
            if (above.getLayoutResource() == R.layout.preference_separator) above.setVisible(false);
            return;
        }
    }

    private void setPipGroupVisible(boolean visible) {
        // Without a VD host (a plain user app: no root, no Shizuku) there are no panes to set.
        visible &= pipsPossible;
        if (pipDualPref != null)   pipDualPref.setVisible(visible);
        if (pipFirstPref != null)  pipFirstPref.setVisible(visible);
        if (pipSecondPref != null) pipSecondPref.setVisible(visible);
        if (pipThirdPref != null)  pipThirdPref.setVisible(visible);
        if (pipFourthPref != null) pipFourthPref.setVisible(visible);
        if (restartPip != null)    restartPip.setVisible(visible);
        if (fabPreference != null) fabPreference.setVisible(visible);
        if (leftFabPreference != null) leftFabPreference.setVisible(visible);
        if (rightFabPreference != null) rightFabPreference.setVisible(visible);
        if (extendedDivider != null) extendedDivider.setVisible(visible);
        if (coverSplash != null) coverSplash.setVisible(visible);
        if (swipeDetector != null && LauncherApplication.showsPrivilegedOption(
                LauncherApplication.hasSystemPrivileges())) swipeDetector.setVisible(visible);
    }

    private void updatePipSummaries() {
        if (pipFirstPref != null) {
            String pkg = sharedPrefs.getString(Keys.PIP_FIRST_PACKAGE, "");
            pipFirstPref.setSummary(pkg == null || pkg.isEmpty() ? getString(R.string.pref_no_app_selected) : getAppLabel(pkg));
        }
        if (pipSecondPref != null) {
            String pkg = sharedPrefs.getString(Keys.PIP_SECOND_PACKAGE, "");
            pipSecondPref.setSummary(pkg == null || pkg.isEmpty() ? getString(R.string.pref_no_app_selected) : getAppLabel(pkg));
        }
        if (pipThirdPref != null) {
            String pkg = sharedPrefs.getString(Keys.PIP_THIRD_PACKAGE, "");
            pipThirdPref.setSummary(pkg == null || pkg.isEmpty() ? getString(R.string.pref_no_app_selected) : getAppLabel(pkg));
        }
        if (pipFourthPref != null) {
            String pkg = sharedPrefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
            pipFourthPref.setSummary(pkg == null || pkg.isEmpty() ? getString(R.string.pref_no_app_selected) : getAppLabel(pkg));
        }
    }

    private String getAppLabel(String pkg) {
        try {
            PackageManager pm = requireContext().getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(pkg, 0);
            CharSequence label = pm.getApplicationLabel(ai);
            return label != null ? label.toString() : pkg;
        } catch (Exception e) {
            return pkg != null ? pkg : "";
        }
    }

    private void showAppPicker(String whichKey) {
        AppListPipDialogFragment dlg = new AppListPipDialogFragment();
        Bundle args = new Bundle();
        args.putString("pip_key", whichKey);
        dlg.setArguments(args);
        dlg.show(requireActivity().getSupportFragmentManager(), AppListPipDialogFragment.TAG);
    }

    private void enforceSinglePiP(@Nullable CustomPipSwitchPreference source, boolean isPip) {
        if (!isPip) return; 

        CustomPipSwitchPreference[] all = new CustomPipSwitchPreference[] {
                pipFirstPref, pipSecondPref, pipThirdPref, pipFourthPref
        };

        for (CustomPipSwitchPreference pref : all) {
            if (pref == null || pref == source) continue;
            if (pref.isModeChecked()) {
                pref.setModeChecked(false);
                // Optional: persist here if you store per-slot mode
                // persistModeFor(pref, /*isPip=*/false);
            }
        }
    }

    private void enforceDualPiP(boolean changedByDual, boolean newState) {
        if (dualPipGuard) return;
        dualPipGuard = true;
        try {
            if (changedByDual) {
                // Dual PiP toggled
                if (newState) {
                    // Dual PiP = ON → disable First/Second and set their custom switches to Window
                    if (pipFirstPref  != null) { pipFirstPref.setChecked(false);  pipFirstPref.setModeChecked(false); restartPip.refreshButtons(); }
                    if (pipSecondPref != null) { pipSecondPref.setChecked(false); pipSecondPref.setModeChecked(false); restartPip.refreshButtons(); }
                }
            } else {
                // A child (First/Second) was turned ON or its custom mode set to PiP
                if (newState && pipDualPref != null && pipDualPref.isChecked()) {
                    pipDualPref.setChecked(false); // Dual PiP = OFF
                }
            }
        } finally {
            dualPipGuard = false;
        }
    }

    private void openPipAdjuster(String pipScreenKey) {
        int selectedScreen = sharedPrefs.getInt(pipScreenKey, 1) - 1;
        Log.i("PipPositioner", "Adjust: " + pipScreenKey + " screen: " + selectedScreen);
        helpers.checkAndResetIfOverlappingOnScreen(-1);
        if (selectedScreen == 0) {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new CreatorFirstScreen()).commit();
        } else {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, CreatorOtherScreens.newInstance(selectedScreen))
                    .commit();
        }
    }
}
