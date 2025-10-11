package com.android.launcher66.settings;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreferenceCompat;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.colorpicker.ColorPicker;
import com.fyt.skin.SkinAttribute;
import com.fyt.skin.SkinUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class SettingsFragmentSecond extends PreferenceFragmentCompat implements Preference.OnPreferenceClickListener {

    // Fragment for the second window in the settings - Layout creator

    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor editor;
    private final Helpers helpers = new Helpers();

    private int defaultColorR = 255;
    private int defaultColorG = 255;
    private int defaultColorB = 255;
    private int bgDefaultColorR = 255;
    private int bgDefaultColorG = 255;
    private int bgDefaultColorB = 255;
    private static final int TIMER_DURATION = 1000;
    private int padding;
    private boolean pipBool = true;
    private boolean dualPipGuard = false;
    private boolean userStatsBool = false;
    private boolean backgroundBool = false;
    private boolean drawableBgBool = false;
    private boolean colorBgBool = false;
    private boolean displayCanbusReaderBool = false;
    private boolean tickRunnableBool = false;
    private boolean loggerTickRunnableBool = false;
    private boolean countDownTimerBool = false;
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
    private String engineVolCodeStr;
    private String numberOfCylindersCodeStr;
    private EditText startingInt;
    private String startingCmdInt;
    private String startingCmdArr;
    private String maxCmdInt;
    private String maxCmdArr;
    private String codeLoggerTimeoutStr;
    private EditText inspectorInt;
    private String inspectorCmdInt;
    private String inspectorCmdArr;
    private String codeInspectorTimeoutStr;
    private SwitchPreferenceCompat mainScreenStats;
    private SwitchPreferenceCompat bgDrawable;
    private SwitchPreferenceCompat bgColor;
    private Preference statsBg;
    private Preference colorPickerPref;
    private Preference bgColorPickerPref;
    private Preference appList;
    private Preference appStatsCoordinates;
    private Preference codesGuide;
    private Preference skipCodes;
    private PreferenceCategory loggerCategory;
    private Preference codeLogger;
    private Preference codeLoggerData;
    private Preference omitDigits;
    private PreferenceCategory inspectorCategory;
    private Preference codeInspector;
    private Preference codeInspectorData;
    private CountDownTimer countDownTimer;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private static final Handler loggerTickHandler = new Handler(Looper.getMainLooper());
    private Preference margin;
    private EditText marginEditText;
    private EditText skipCodesEditText;
    private AlertDialog alertPipDialog;
    private AlertDialog alertMarginsDialog;
    private AlertDialog alertCodesDialog;
    private AlertDialog alertExtraCodesDialog;
    private AlertDialog alertCodesLoggerDialog;
    private AlertDialog alertSkipCodesDialog;
    private AlertDialog alertCodesInspectorDialog;
    private Preference startPage;
    private EditText startPageEditText;
    private AlertDialog alertStartPageDialog;
    private AppListStatsDialogFragment appListStatsDialog;
    private ColorPicker colorPicker;
    private ColorPicker bgColorPicker;
    private InputMethodManager imm;

    private CustomDualPipPreference pipDualPref;
    private CustomPipSwitchPreference pipFirstPref;
    private CustomPipSwitchPreference pipSecondPref;
    private CustomPipSwitchPreference pipThirdPref;
    private CustomPipSwitchPreference pipFourthPref;

    private final SharedPreferences.OnSharedPreferenceChangeListener pipPkgListener =
            (prefs, key) -> {
                if (Keys.PIP_FIRST_PACKAGE.equals(key) || Keys.PIP_SECOND_PACKAGE.equals(key)
                        || Keys.PIP_THIRD_PACKAGE.equals(key) || Keys.PIP_FOURTH_PACKAGE.equals(key)) {
                    updatePipSummaries();
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
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.requireContext());
        editor = sharedPrefs.edit();
        addPreferencesFromResource(R.xml.creator_preferences);
        padding = SettingsActivity.dialogPadding;

        Preference displayPip = findPreference(Keys.DISPLAY_PIP);
        pipDualPref   = findPreference(Keys.PIP_DUAL);
        pipFirstPref  = findPreference(Keys.PIP_FIRST);
        pipSecondPref = findPreference(Keys.PIP_SECOND);
        pipThirdPref  = findPreference(Keys.PIP_THIRD);
        pipFourthPref = findPreference(Keys.PIP_FOURTH);
        CustomWidgetSwitchPreference userDate = findPreference(Keys.USER_DATE);
        CustomWidgetSwitchPreference userMusic = findPreference(Keys.USER_MUSIC);
        CustomWidgetSwitchPreference userRadio = findPreference(Keys.USER_RADIO);
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
        engineVolCodeStr = sharedPrefs.getString("engine_volume_code_int", "0");
        numberOfCylindersCodeStr = sharedPrefs.getString("cylinders_number_code_int", "0");

        mainScreenStats = findPreference(Keys.MAIN_SCREEN_STATS);
        colorPickerPref = findPreference(Keys.COLOR_PICKER);
        statsBg = findPreference(Keys.STATS_BG);
        bgDrawable = findPreference(Keys.BG_DRAWABLE);
        bgColor = findPreference(Keys.BG_COLOR);
        bgColorPickerPref = findPreference(Keys.BG_COLOR_PICKER);
        appList = findPreference(Keys.APP_LIST);
        appStatsCoordinates = findPreference(Keys.APP_STATS_COORDINATES);

        SwitchPreferenceCompat displayCanbusReader = findPreference(Keys.DISPLAY_CANBUS_READER);
        codesGuide = findPreference(Keys.CODES_GUIDE);
        loggerCategory = findPreference("logger_category");
        codeLogger = findPreference(Keys.CODE_LOGGER);
        codeLoggerData = findPreference(Keys.CODE_LOGGER_DATA);
        startingCmdInt = sharedPrefs.getString(Keys.STARTING_CMD_INT, "0");
        startingCmdArr = sharedPrefs.getString(Keys.STARTING_CMD_ARR, "0");
        maxCmdInt = sharedPrefs.getString(Keys.MAX_CMD_INT, "10");
        maxCmdArr = sharedPrefs.getString(Keys.MAX_CMD_ARR, "10");
        codeLoggerTimeoutStr = sharedPrefs.getString(Keys.CODE_LOGGER_TIMEOUT, "1");
        skipCodes = findPreference(Keys.SKIP_CODES);
        omitDigits = findPreference(Keys.OMIT_DIGITS);
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
        inspectorCmdInt = sharedPrefs.getString(Keys.INSPECTOR_CMD_INT, "0");
        inspectorCmdArr = sharedPrefs.getString(Keys.INSPECTOR_CMD_ARR, "0");
        codeInspectorTimeoutStr = sharedPrefs.getString(Keys.CODE_INSPECTOR_TIMEOUT, "30");

        startPage = findPreference(Keys.START_PAGE);
        String startPageStr = sharedPrefs.getString(Keys.START_PAGE, "1");
        startPage.setSummary(startPageStr);

        Preference leftBar = findPreference(Keys.LEFT_BAR);

        margin = findPreference(Keys.LAYOUT_MARGIN);
        String marginStr = sharedPrefs.getString(Keys.LAYOUT_MARGIN, "10");
        margin.setSummary(marginStr);

        defaultColorR = sharedPrefs.getInt("red", 255);
        defaultColorG = sharedPrefs.getInt("green", 255);
        defaultColorB = sharedPrefs.getInt("blue", 255);
        bgDefaultColorR = sharedPrefs.getInt("bg_red", 255);
        bgDefaultColorG = sharedPrefs.getInt("bg_green", 255);
        bgDefaultColorB = sharedPrefs.getInt("bg_blue", 255);

        setPipGroupVisible(pipBool);
        updatePipSummaries();
        sharedPrefs.registerOnSharedPreferenceChangeListener(pipPkgListener);        

        dialogStartPageEditText();
        dialogMarginEditText();
        dialogSkipCodesEditText();

        if (displayPip != null) {
            displayPip.setOnPreferenceClickListener(this);
        }
        if (pipDualPref != null) {
            pipDualPref.setScreenValuePrefKey(Keys.PIP_DUAL_SCREEN);
            pipDualPref.setOnPositionClickListener(pref -> openPipAdjuster(Keys.PIP_DUAL_SCREEN));            
            pipDualPref.setOnPreferenceChangeListener((p, v) -> {
                enforceDualPiP(/*changedByDual=*/true, /*newState=*/(Boolean) v);
                return true;
            });
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
        }
        if (pipThirdPref != null) {
            pipThirdPref.setScreenValuePrefKey(Keys.PIP_THIRD_SCREEN);
            pipThirdPref.setOnPositionClickListener(pref -> openPipAdjuster(Keys.PIP_THIRD_SCREEN));

            pipThirdPref.setOnPreferenceClickListener(p -> { showAppPicker(Keys.PIP_THIRD_PACKAGE); return true; });
            pipThirdPref.setOnModeSwitchChangeListener(isPip -> enforceSinglePiP(pipThirdPref, isPip));
            pipThirdPref.setOnPreferenceChangeListener((p, v) -> true);
        }
        if (pipFourthPref != null) {
            pipFourthPref.setScreenValuePrefKey(Keys.PIP_FOURTH_SCREEN);
            pipFourthPref.setOnPositionClickListener(pref -> openPipAdjuster(Keys.PIP_FOURTH_SCREEN));

            pipFourthPref.setOnPreferenceClickListener(p -> { showAppPicker(Keys.PIP_FOURTH_PACKAGE); return true; });
            pipFourthPref.setOnModeSwitchChangeListener(isPip -> enforceSinglePiP(pipFourthPref, isPip));
            pipFourthPref.setOnPreferenceChangeListener((p, v) -> true);
        }
        pipBool = sharedPrefs.getBoolean(Keys.DISPLAY_PIP, false);
        if (userDate != null) {
            userDate.setOnPreferenceClickListener(this);
            userDate.setScreenValuePrefKey(Keys.DATE_SCREEN);
            userDate.setOnPositionClickListener(pref -> openPipAdjuster(Keys.DATE_SCREEN));      
        }
        if (userMusic != null) {
            userMusic.setOnPreferenceClickListener(this);
            userMusic.setScreenValuePrefKey(Keys.MUSIC_SCREEN);
            userMusic.setOnPositionClickListener(pref -> openPipAdjuster(Keys.MUSIC_SCREEN));
        }
        if (userRadio != null) {
            userRadio.setOnPreferenceClickListener(this);
            userRadio.setScreenValuePrefKey(Keys.RADIO_SCREEN);
            userRadio.setOnPositionClickListener(pref -> openPipAdjuster(Keys.RADIO_SCREEN));
        }
        initUserStats();
        userStatsBool = sharedPrefs.getBoolean(Keys.USER_STATS, false);
        if (statsScreen != null) {
            statsScreen.setVisible(userStatsBool);
            statsScreen.setOnPreferenceClickListener(this);
            statsScreen.setScreenValuePrefKey(Keys.STATS_SCREEN);
            statsScreen.setOnPositionClickListener(pref -> openPipAdjuster(Keys.STATS_SCREEN));    
        }
        if (statsCodes != null) {
            statsCodes.setVisible(userStatsBool);
            statsCodes.setSummary(getString(R.string.stats_codes_summary, fuelCodeStr, rangeCodeStr, cmdIntCodeStr, cmdArrCodeStr));
            statsCodes.setOnPreferenceClickListener(this);
        }
        if (extraStatsCodes != null) {
            extraStatsCodes.setVisible(userStatsBool);
            extraStatsCodes.setSummary(getString(R.string.extra_stats_codes_summary, rpmCodeStr, horsePowerCodeStr, vehicleMassCodeStr, engineVolCodeStr, numberOfCylindersCodeStr));
            extraStatsCodes.setOnPreferenceClickListener(this);
        }
        if (mainScreenStats != null) {
            mainScreenStats.setVisible(userStatsBool);
            mainScreenStats.setOnPreferenceClickListener(this);
        }
        if (colorPickerPref != null) {
            colorPickerPref.setVisible(userStatsBool);
            colorPickerPref.setOnPreferenceClickListener(this);
        }
        if (statsBg != null) {
            statsBg.setVisible(userStatsBool);
            statsBg.setOnPreferenceClickListener(this);
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
        if (bgColorPickerPref != null) {
            colorBgBool = sharedPrefs.getBoolean(Keys.BG_COLOR, false);
            bgColorPickerPref.setVisible(statsBackgroundBool() && colorBgBool);
            bgColorPickerPref.setOnPreferenceClickListener(this);
        }
        if (appList != null) {
            appList.setVisible(userStatsBool);
            appList.setOnPreferenceClickListener(this);
        }
        if (appStatsCoordinates != null) {
            appStatsCoordinates.setVisible(userStatsBool);
            appStatsCoordinates.setOnPreferenceClickListener(this);
        }
        if (displayCanbusReader != null) {
            displayCanbusReader.setOnPreferenceClickListener(this);
        }
        displayCanbusReaderBool = sharedPrefs.getBoolean(Keys.DISPLAY_CANBUS_READER, false);
        loggerCategory.setVisible(displayCanbusReaderBool);
        inspectorCategory.setVisible(displayCanbusReaderBool);
        if (codesGuide != null) {
            codesGuide.setVisible(displayCanbusReaderBool);
            codesGuide.setOnPreferenceClickListener(this);
        }
        if (skipCodes != null) {
            skipCodes.setVisible(displayCanbusReaderBool);
            skipCodes.setOnPreferenceClickListener(this);
        }
        if (codeLogger != null) {
            codeLogger.setVisible(displayCanbusReaderBool);
            codeLogger.setOnPreferenceClickListener(this);
            if (helpers.codeLoggerBoolean()) {
                setLoggerTickRunnable();
            } else {
                codeLogger.setSummary(getString(R.string.code_logger_summary));
                helpers.setCountDownLogger(0);
            }
        }
        if (codeLoggerData != null) {
            codeLoggerData.setVisible(displayCanbusReaderBool);
            codeLoggerData.setOnPreferenceClickListener(this);
            codeLoggerData.setSummary(getString(R.string.code_logger_data_summary, startingCmdInt, startingCmdArr, maxCmdInt, maxCmdArr, codeLoggerTimeoutStr));
        }
        if (omitDigits != null) {
            omitDigits.setVisible(displayCanbusReaderBool);
            omitDigits.setOnPreferenceClickListener(this);
        }
        if (codeInspector != null) {
            codeInspector.setVisible(displayCanbusReaderBool);
            codeInspector.setOnPreferenceClickListener(this);
            if (helpers.codeInspectorBoolean()) {
                int inspectorTimeout = Integer.parseInt(sharedPrefs.getString(Keys.CODE_INSPECTOR_TIMEOUT, "30")) * 1000;
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
            codeInspectorData.setSummary(getString(R.string.code_inspector_data_summary, inspectorCmdInt, inspectorCmdArr, codeInspectorTimeoutStr));
        }
        if (startPage != null) {
            startPage.setOnPreferenceClickListener(this);
        }
        if (leftBar != null) {
            leftBar.setOnPreferenceClickListener(this);
        }
        if (margin != null) {
            margin.setOnPreferenceClickListener(this);
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
                if (statsScreen != null) statsScreen.setVisible(pipBool);
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
                engineVolCodeStr = sharedPrefs.getString("engine_volume_code_int", "0");
                numberOfCylindersCodeStr = sharedPrefs.getString("cylinders_number_code_int", "0");

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
                colorPicker = new ColorPicker(requireActivity(), defaultColorR, defaultColorG, defaultColorB);
                colorPicker.enableAutoClose();
                colorPicker.setCallback(color -> {
                    defaultColorR = Color.red(color);
                    defaultColorG = Color.green(color);
                    defaultColorB = Color.blue(color);
                    editor.putString("stats_color", String.format("#%06X", (0xFFFFFF & color)));
                    editor.putInt("red", Color.red(color));
                    editor.putInt("green", Color.green(color));
                    editor.putInt("blue", Color.blue(color));
                    editor.apply();
                });
                colorPicker.show();
                break;
            case Keys.STATS_BG:
                bgDrawable.setVisible(backgroundBool);
                bgColor.setVisible(backgroundBool);
                bgColorPickerPref.setVisible(backgroundBool && colorBgBool);
                break;
            case Keys.BG_DRAWABLE:
                bgColor.setChecked(!drawableBgBool);
                bgColorPickerPref.setVisible(!drawableBgBool);
                break;
            case Keys.BG_COLOR:
                bgDrawable.setChecked(!colorBgBool);
                bgColorPickerPref.setVisible(colorBgBool);
                break;
            case Keys.BG_COLOR_PICKER:
                bgColorPicker = new ColorPicker(requireActivity(), bgDefaultColorR, bgDefaultColorG, bgDefaultColorB);
                bgColorPicker.enableAutoClose();
                bgColorPicker.setCallback(color -> {
                    bgDefaultColorR = Color.red(color);
                    bgDefaultColorG = Color.green(color);
                    bgDefaultColorB = Color.blue(color);
                    editor.putString("bg_stats_color", String.format("#%06X", (0xFFFFFF & color)));
                    editor.putInt("bg_red", Color.red(color));
                    editor.putInt("bg_green", Color.green(color));
                    editor.putInt("bg_blue", Color.blue(color));
                    editor.apply();
                });
                bgColorPicker.show();
                break;
            case Keys.APP_LIST:
                Log.i("checkStatsPermission()", String.valueOf(checkStatsPermission()));
                if (checkStatsPermission()) {
                    if (appListStatsDialog != null && appListStatsDialog.isShowing()) {
                        appListStatsDialog.dismiss();
                    }
                    appListStatsDialog = new AppListStatsDialogFragment();
                    appListStatsDialog.show(requireActivity().getSupportFragmentManager(), "");
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
            case Keys.CODE_LOGGER:
                if (!helpers.codeLoggerBoolean()) {
                    // start the service
                    startLoggerService();
                    setLoggerTickRunnable();
                } else {
                    // stop the service
                    stopLoggerService();
                }
                break;
            case Keys.CODE_LOGGER_DATA:
                startingCmdInt = sharedPrefs.getString(Keys.STARTING_CMD_INT, "0");
                startingCmdArr = sharedPrefs.getString(Keys.STARTING_CMD_ARR, "0");
                maxCmdInt = sharedPrefs.getString(Keys.MAX_CMD_INT, "10");
                maxCmdArr = sharedPrefs.getString(Keys.MAX_CMD_ARR, "10");
                codeLoggerTimeoutStr = sharedPrefs.getString(Keys.CODE_LOGGER_TIMEOUT, "1");

                alertCodesLoggerDialog = displayCodesLoggerDialog().create();

                alertCodesLoggerDialog.setOnShowListener(dialog -> {
                    Button negativeLoggerButton = alertCodesLoggerDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                    negativeLoggerButton.setLayoutParams(params);
                    startingInt.requestFocus();
                    imm.showSoftInput(startingInt, InputMethodManager.SHOW_IMPLICIT);
                    startingInt.setSelection(startingInt.getText().length());
                });

                alertCodesLoggerDialog.show();
                break;
            case Keys.CODE_INSPECTOR:
                if (!helpers.codeInspectorBoolean()) {
                    // start the service
                    int inspectorTimeout = Integer.parseInt(sharedPrefs.getString(Keys.CODE_INSPECTOR_TIMEOUT, "30")) * 1000;
                    startCanbusCodeInspector();
                    setCountDownTimer(inspectorTimeout);
                    setTickRunnable(inspectorTimeout + 1000);
                } else {
                    // stop the service
                    stopCanbusCodeInspector();
                }
                break;
            case Keys.CODE_INSPECTOR_DATA:
                inspectorCmdInt = sharedPrefs.getString(Keys.INSPECTOR_CMD_INT, "0");
                inspectorCmdArr = sharedPrefs.getString(Keys.INSPECTOR_CMD_ARR, "0");
                codeInspectorTimeoutStr = sharedPrefs.getString(Keys.CODE_INSPECTOR_TIMEOUT, "30");

                alertCodesInspectorDialog = displayCodesInspectorDialog().create();

                alertCodesInspectorDialog.setOnShowListener(dialog -> {
                    Button negativeInspectorButtonI = alertCodesInspectorDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                    negativeInspectorButtonI.setLayoutParams(params);
                    inspectorInt.requestFocus();
                    imm.showSoftInput(inspectorInt, InputMethodManager.SHOW_IMPLICIT);
                    inspectorInt.setSelection(inspectorInt.getText().length());
                });

                alertCodesInspectorDialog.show();
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
            case Keys.LEFT_BAR:
                helpers.setLeftBarChanged(true);
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
            default:
                break;
        }
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        clearPreferenceListeners(getPreferenceScreen());
        mHandler.removeCallbacksAndMessages(null);
        loggerTickHandler.removeCallbacksAndMessages(null);
        dismissDialogs();
        removeTickRunnable();
        removeLoggerTickRunnable();
        cancelCountDownTimer();
        SkinAttribute skinAttribute = SkinUtils.getSkinAttr();
        if (skinAttribute != null) {
            skinAttribute.clear();
        }
        if (sharedPrefs != null) {
            sharedPrefs.unregisterOnSharedPreferenceChangeListener(pipPkgListener);
        }
    }

    private void initUserStats() {
        if (userStats != null) {
            SharedPreferences mPrefs = LauncherApplication.sApp.getSharedPreferences("HelpersPrefs", Context.MODE_PRIVATE);
            String can = mPrefs.getString("canbus_class", "empty");
            if (!can.equals("empty")) {
                userStats.setVisible(true);
                String formattedText = getString(R.string.stats_window_summary, can.replace("class ", ""));
                userStats.setSummary(Html.fromHtml(formattedText, Html.FROM_HTML_MODE_LEGACY));
                userStats.setOnPreferenceClickListener(this);
            } else {
                userStats.setChecked(false);
                userStats.setVisible(false);
            }
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

    private void dismissDialogs() {
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
        if (colorPicker != null && colorPicker.isShowing()) {
            colorPicker.dismiss();
        }
        if (bgColorPicker != null && bgColorPicker.isShowing()) {
            bgColorPicker.dismiss();
        }
        if (appListStatsDialog != null && appListStatsDialog.isShowing()) {
            appListStatsDialog.dismiss();
            appListStatsDialog = null;
        }
        if (alertSkipCodesDialog != null && alertSkipCodesDialog.isShowing()) {
            alertSkipCodesDialog.dismiss();
            alertSkipCodesDialog = null;
        }
        if (alertCodesLoggerDialog != null && alertCodesLoggerDialog.isShowing()) {
            alertCodesLoggerDialog.dismiss();
            alertCodesLoggerDialog = null;
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

    public void setLoggerTickRunnable() {
        if (!loggerTickRunnableBool) {
            loggerTickHandler.postDelayed(loggerTickRunnable, TIMER_DURATION);
            loggerTickRunnableBool = true;
        }
    }

    public void removeLoggerTickRunnable() {
        if (loggerTickRunnableBool) {
            loggerTickHandler.removeCallbacks(loggerTickRunnable);
            loggerTickRunnableBool = false;
        }
    }

    private final Runnable loggerTickRunnable = new Runnable() {
        @Override
        public void run() {
            if (helpers.returnCountDownLogger() > 0) {
                int remainingTime = helpers.returnCountDownLogger();
                int hours = remainingTime / 3600;
                int remainingSeconds = remainingTime % 3600;
                int minutes = remainingSeconds / 60;
                int seconds = remainingSeconds % 60;
                String timeFormat = String.format(Locale.ROOT, "%02d:%02d:%02d", hours, minutes, seconds);
                codeLogger.setSummary(getString(
                        R.string.code_logger_summary_working,
                        timeFormat
                ));
                loggerTickHandler.postDelayed(this, TIMER_DURATION);
            } else {
                codeLogger.setSummary(getString(R.string.code_logger_summary));
                loggerTickRunnableBool = false;
                loggerTickHandler.removeCallbacks(loggerTickRunnable);
            }
        }
    };

    public void startCanbusCodeInspector() {
        Intent intent = new Intent(this.requireContext(), CanbusCodeInspector.class);
        Bundle extras = new Bundle();
        extras.putInt("cmdInt", Integer.parseInt(sharedPrefs.getString(Keys.CMD_INT, "0")));
        extras.putInt("cmdArr", Integer.parseInt(sharedPrefs.getString(Keys.CMD_ARR, "0")));
        intent.putExtras(extras);
        this.requireContext().startService(intent);
    }

    public void stopCanbusCodeInspector() {
        Intent intent = new Intent(this.requireContext(), CanbusCodeInspector.class);
        this.requireContext().stopService(intent);
        removeTickRunnable();
        cancelCountDownTimer();
        codeInspector.setSummary(getString(R.string.code_inspector_summary));
    }

    private void startLoggerService() {
        Intent loggerIntent = new Intent(this.requireContext(), CanbusCommandLogger.class);
        this.requireContext().startService(loggerIntent);
    }

    private void stopLoggerService() {
        CanbusCommandLogger.stopLogging();
        removeLoggerTickRunnable();
        codeLogger.setSummary(getString(R.string.code_logger_summary));
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

    private void dialogCodesLoggerEditText(EditText codesEditText) {
        codesEditText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "1199")});
        codesEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        codesEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        codesEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveLoggerCode(codesEditText);
                alertCodesLoggerDialog.dismiss();
            }
            return false;
        });
    }

    private void dialogCodesLoggerTimeoutEditText(EditText codesEditText) {
        codesEditText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "5")});
        codesEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        codesEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        codesEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveLoggerCode(codesEditText);
                alertCodesLoggerDialog.dismiss();
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
                } else {
                    bgDrawable.setChecked(true);
                    bgColorPickerPref.setVisible(false);
                }
            } else {
                bgDrawable.setVisible(false);
                bgColor.setVisible(false);
                bgColorPickerPref.setVisible(false);
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
        }
    }

    private void displayCanbusReaderSwitch() {
        if (displayCanbusReaderBool) {
            codesGuide.setVisible(true);
            loggerCategory.setVisible(true);
            codeLogger.setVisible(true);
            codeLoggerData.setVisible(true);
            omitDigits.setVisible(true);
            skipCodes.setVisible(true);
            inspectorCategory.setVisible(true);
            codeInspector.setVisible(true);
            codeInspectorData.setVisible(true);
        } else {
            codesGuide.setVisible(false);
            loggerCategory.setVisible(false);
            codeLogger.setVisible(false);
            codeLoggerData.setVisible(false);
            omitDigits.setVisible(false);
            skipCodes.setVisible(false);
            inspectorCategory.setVisible(false);
            codeInspector.setVisible(false);
            codeInspectorData.setVisible(false);
        }
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

        dialogCodesEditText(fuelCodeInt);
        dialogCodesEditText(rangeCodeInt);
        dialogCodesEditText(cmdIntCodeInt);
        dialogCodesEditText(cmdArrCodeInt);

        fuelCodeInt.setText(fuelCodeStr);
        rangeCodeInt.setText(rangeCodeStr);
        cmdIntCodeInt.setText(cmdIntCodeStr);
        cmdArrCodeInt.setText(cmdArrCodeStr);

        fuelCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        rangeCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        cmdIntCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        cmdArrCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));

        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setView(dialogView).setPositiveButton(R.string.set_btn, (dialog, which) -> {
                fuelCodeStr = fuelCodeInt.getText().toString();
                rangeCodeStr = rangeCodeInt.getText().toString();
                cmdIntCodeStr = cmdIntCodeInt.getText().toString();
                cmdArrCodeStr = cmdArrCodeInt.getText().toString();
                saveCode(fuelCodeInt);
                saveCode(rangeCodeInt);
                saveCode(cmdIntCodeInt);
                saveCode(cmdArrCodeInt);
            });
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        builder.setOnCancelListener(dialog -> {
                fuelCodeStr = fuelCodeInt.getText().toString();
                rangeCodeStr = rangeCodeInt.getText().toString();
                cmdIntCodeStr = cmdIntCodeInt.getText().toString();
                cmdArrCodeStr = cmdArrCodeInt.getText().toString();
                saveCode(fuelCodeInt);
                saveCode(rangeCodeInt);
                saveCode(cmdIntCodeInt);
                saveCode(cmdArrCodeInt);
                dialog.dismiss();
            });
        return builder;
    }

    private AlertDialog.Builder displayExtraCodesDialog() {
        EditText numberOfCylindersCodeInt;
        EditText engineVolCodeInt;
        EditText vehicleMassCodeInt;
        EditText horsePowerCodeInt;
        LayoutInflater inflater = LayoutInflater.from(this.requireContext());
        View dialogView = inflater.inflate(R.layout.dialog_extra_codes_layout, null);

        rpmCodeInt = dialogView.findViewById(R.id.rpm_code_int);
        horsePowerCodeInt = dialogView.findViewById(R.id.horse_power_code_int);
        vehicleMassCodeInt = dialogView.findViewById(R.id.vehicle_mass_code_int);
        engineVolCodeInt = dialogView.findViewById(R.id.engine_volume_code_int);
        numberOfCylindersCodeInt = dialogView.findViewById(R.id.cylinders_number_code_int);

        ConstraintLayout constraintInspector = dialogView.findViewById(R.id.constraint_extra);
        constraintInspector.setPadding(padding, padding, padding, padding);

        setCalculatedSizes(dialogView, R.id.canbus_optional, SettingsActivity.dialogTitle, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.canbus_optional_description, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.rpm_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.horse_power_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.vehicle_mass_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.engine_volume_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.cylinders_number_code_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);

        dialogExtraCodesEditText(rpmCodeInt);
        dialogExtraCodesEditText(horsePowerCodeInt);
        dialogExtraCodesEditText(vehicleMassCodeInt);
        dialogExtraCodesEditText(engineVolCodeInt);
        dialogExtraCodesEditText(numberOfCylindersCodeInt);

        rpmCodeInt.setText(rpmCodeStr);
        horsePowerCodeInt.setText(horsePowerCodeStr);
        vehicleMassCodeInt.setText(vehicleMassCodeStr);
        engineVolCodeInt.setText(engineVolCodeStr);
        numberOfCylindersCodeInt.setText(numberOfCylindersCodeStr);

        rpmCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        horsePowerCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        vehicleMassCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        engineVolCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        numberOfCylindersCodeInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));

        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setView(dialogView).setPositiveButton(R.string.set_btn, (dialog, which) -> {
                rpmCodeStr = rpmCodeInt.getText().toString();
                horsePowerCodeStr = horsePowerCodeInt.getText().toString();
                vehicleMassCodeStr = vehicleMassCodeInt.getText().toString();
                engineVolCodeStr = engineVolCodeInt.getText().toString();
                numberOfCylindersCodeStr = numberOfCylindersCodeInt.getText().toString();
                saveExtraCode(rpmCodeInt);
                saveExtraCode(horsePowerCodeInt);
                saveExtraCode(vehicleMassCodeInt);
                saveExtraCode(engineVolCodeInt);
                saveExtraCode(numberOfCylindersCodeInt);
                dialog.dismiss();
            });
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        builder.setOnCancelListener(dialog -> {
                rpmCodeStr = rpmCodeInt.getText().toString();
                horsePowerCodeStr = horsePowerCodeInt.getText().toString();
                vehicleMassCodeStr = vehicleMassCodeInt.getText().toString();
                engineVolCodeStr = engineVolCodeInt.getText().toString();
                numberOfCylindersCodeStr = numberOfCylindersCodeInt.getText().toString();
                saveExtraCode(rpmCodeInt);
                saveExtraCode(horsePowerCodeInt);
                saveExtraCode(vehicleMassCodeInt);
                saveExtraCode(engineVolCodeInt);
                saveExtraCode(numberOfCylindersCodeInt);
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

    private AlertDialog.Builder displayCodesLoggerDialog() {
        EditText startingArr;
        EditText maxInt;
        EditText maxArr;
        EditText loggerTimeout;
        LayoutInflater inflater = LayoutInflater.from(this.requireContext());
        View dialogView = inflater.inflate(R.layout.dialog_logger_codes_layout, null);

        startingInt = dialogView.findViewById(R.id.starting_cmd_int);
        startingArr = dialogView.findViewById(R.id.starting_cmd_arr);
        maxInt = dialogView.findViewById(R.id.max_cmd_int);
        maxArr = dialogView.findViewById(R.id.max_cmd_arr);
        loggerTimeout = dialogView.findViewById(R.id.code_logger_timeout);

        ConstraintLayout constraintInspector = dialogView.findViewById(R.id.constraint_logger);
        constraintInspector.setPadding(padding, padding, padding, padding);

        setCalculatedSizes(dialogView, R.id.code_logger_data_title, SettingsActivity.dialogTitle, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.starting_cmd_int_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.starting_cmd_arr_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.max_cmd_int_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.max_cmd_arr_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.code_logger_timeout_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);

        dialogCodesLoggerEditText(startingInt);
        dialogCodesLoggerEditText(startingArr);
        dialogCodesLoggerEditText(maxInt);
        dialogCodesLoggerEditText(maxArr);
        dialogCodesLoggerTimeoutEditText(loggerTimeout);

        startingInt.setText(startingCmdInt);
        startingArr.setText(startingCmdArr);
        maxInt.setText(maxCmdInt);
        maxArr.setText(maxCmdArr);
        loggerTimeout.setText(codeLoggerTimeoutStr);

        startingInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        startingArr.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        maxInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        maxArr.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        loggerTimeout.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));

        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setView(dialogView).setPositiveButton(R.string.set_btn, (dialog, which) -> {
                startingCmdInt = startingInt.getText().toString();
                startingCmdArr = startingArr.getText().toString();
                maxCmdInt = maxInt.getText().toString();
                maxCmdArr = maxArr.getText().toString();
                codeLoggerTimeoutStr = loggerTimeout.getText().toString();
                saveLoggerCode(startingInt);
                saveLoggerCode(startingArr);
                saveLoggerCode(maxInt);
                saveLoggerCode(maxArr);
                saveLoggerCode(loggerTimeout);
            });
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        builder.setOnCancelListener(dialog -> {
                startingCmdInt = startingInt.getText().toString();
                startingCmdArr = startingArr.getText().toString();
                maxCmdInt = maxInt.getText().toString();
                maxCmdArr = maxArr.getText().toString();
                codeLoggerTimeoutStr = loggerTimeout.getText().toString();
                saveLoggerCode(startingInt);
                saveLoggerCode(startingArr);
                saveLoggerCode(maxInt);
                saveLoggerCode(maxArr);
                saveLoggerCode(loggerTimeout);
                dialog.dismiss();
            });
        return builder;
    }

    private AlertDialog.Builder displayCodesInspectorDialog() {
        EditText inspectorArr;
        EditText inspectorTimeout;
        LayoutInflater inflater = LayoutInflater.from(this.requireContext());
        View dialogView = inflater.inflate(R.layout.dialog_inspector_codes_layout, null);

        inspectorInt = dialogView.findViewById(R.id.inspector_cmd_int);
        inspectorArr = dialogView.findViewById(R.id.inspector_cmd_arr);
        inspectorTimeout = dialogView.findViewById(R.id.code_inspector_timeout);

        ConstraintLayout constraintInspector = dialogView.findViewById(R.id.constraint_inspector);
        constraintInspector.setPadding(padding, padding, padding, padding);

        setCalculatedSizes(dialogView, R.id.code_inspector_data_title, SettingsActivity.dialogTitle, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.inspector_cmd_int_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.inspector_cmd_arr_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.code_inspector_timeout_text, SettingsActivity.dialogTextView, SettingsActivity.dialogMargin);

        dialogCodesInspectorEditText(inspectorInt);
        dialogCodesInspectorEditText(inspectorArr);
        dialogCodesInspectorEditText(inspectorTimeout);

        inspectorInt.setText(inspectorCmdInt);
        inspectorArr.setText(inspectorCmdArr);
        inspectorTimeout.setText(codeInspectorTimeoutStr);

        inspectorInt.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        inspectorArr.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));
        inspectorTimeout.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black));

        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setView(dialogView).setPositiveButton(R.string.set_btn, (dialog, which) -> {
                inspectorCmdInt = inspectorInt.getText().toString();
                inspectorCmdArr = inspectorArr.getText().toString();
                codeInspectorTimeoutStr = inspectorTimeout.getText().toString();
                saveInspectorCode(inspectorInt);
                saveInspectorCode(inspectorArr);
                saveInspectorCode(inspectorTimeout);
            });
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        builder.setOnCancelListener(dialog -> {
                inspectorCmdInt = inspectorInt.getText().toString();
                inspectorCmdArr = inspectorArr.getText().toString();
                codeInspectorTimeoutStr = inspectorTimeout.getText().toString();
                saveInspectorCode(inspectorInt);
                saveInspectorCode(inspectorArr);
                saveInspectorCode(inspectorTimeout);
                dialog.dismiss();
            });
        return builder;
    }

    private void setCalculatedSizes(View view, int textViewId, int textSize, int margin) {
        TextView textView = view.findViewById(textViewId);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);

        if (textView.getLayoutParams() instanceof ConstraintLayout.LayoutParams params) {
            if (textViewId == R.id.code_inspector_data_title
             || textViewId == R.id.code_logger_data_title
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
        if (valueStr.isEmpty()) valueStr = "10";
        margin.setSummary(valueStr);
        editor.putString(Keys.LAYOUT_MARGIN, valueStr);
        editor.apply();
    }

    private void saveCode(EditText code) {
        String valueStr = code.getText().toString();
        if (valueStr.isEmpty()) valueStr = "0";
        editor.putString(code.getResources().getResourceEntryName(code.getId()), valueStr);
        editor.apply();
        statsCodes.setSummary(getString(R.string.stats_codes_summary,
            sharedPrefs.getString("fuel_code_int", "0"),
            sharedPrefs.getString("range_code_int", "0"),
            sharedPrefs.getString(Keys.CMD_INT, "0"),
            sharedPrefs.getString(Keys.CMD_ARR, "0")));
    }

    private void saveExtraCode(EditText code) {
        String valueStr = code.getText().toString();
        if (valueStr.isEmpty()) valueStr = "0";
        editor.putString(code.getResources().getResourceEntryName(code.getId()), valueStr);
        editor.apply();
        extraStatsCodes.setSummary(getString(R.string.extra_stats_codes_summary,
            sharedPrefs.getString("rpm_code_int", "0"),
            sharedPrefs.getString("horse_power_code_int", "0"),
            sharedPrefs.getString("vehicle_mass_code_int", "0"),
            sharedPrefs.getString("engine_volume_code_int", "0"),
            sharedPrefs.getString("cylinders_number_code_int", "0")));
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

    private void saveLoggerCode(EditText code) {
        String codeToSaveStr = code.getResources().getResourceEntryName(code.getId());
        String valueStr = code.getText().toString();
        if (valueStr.isEmpty()) valueStr = "0";
        int codeToSaveVal = Integer.parseInt(valueStr);

        if ((codeToSaveStr.equals(Keys.STARTING_CMD_INT) && codeToSaveVal >= getIntFromPrefs(Keys.MAX_CMD_INT, "10"))
            || (codeToSaveStr.equals(Keys.MAX_CMD_INT) && codeToSaveVal <= getIntFromPrefs(Keys.STARTING_CMD_INT, "0"))) {
            editor.putString(code.getResources().getResourceEntryName(code.getId()), "0");
            editor.putString(Keys.STARTING_CMD_INT, "0");
            editor.putString(Keys.MAX_CMD_INT, "10");
            editor.apply();
            startingCmdInt = "0";
            maxCmdInt = "10";
            codeLoggerData.setSummary(getString(R.string.code_logger_data_summary,
                sharedPrefs.getString(Keys.STARTING_CMD_INT, "0"),
                sharedPrefs.getString(Keys.STARTING_CMD_ARR, "0"),
                sharedPrefs.getString(Keys.MAX_CMD_INT, "10"),
                sharedPrefs.getString(Keys.MAX_CMD_ARR, "10"),
                sharedPrefs.getString(Keys.CODE_LOGGER_TIMEOUT, "1")));
            Toast.makeText(
                this.requireContext(),
                R.string.code_logger_dialog_toast,
                Toast.LENGTH_LONG
            ).show();
        } else if ((codeToSaveStr.equals(Keys.STARTING_CMD_ARR) && codeToSaveVal >= getIntFromPrefs(Keys.MAX_CMD_ARR, "10"))
            || (codeToSaveStr.equals(Keys.MAX_CMD_ARR) && codeToSaveVal <= getIntFromPrefs(Keys.STARTING_CMD_ARR, "0"))) {
            editor.putString(code.getResources().getResourceEntryName(code.getId()), "0");
            editor.putString(Keys.STARTING_CMD_ARR, "0");
            editor.putString(Keys.MAX_CMD_ARR, "10");
            editor.apply();
            startingCmdArr = "0";
            maxCmdArr = "10";
            codeLoggerData.setSummary(getString(R.string.code_logger_data_summary,
                sharedPrefs.getString(Keys.STARTING_CMD_INT, "0"),
                sharedPrefs.getString(Keys.STARTING_CMD_ARR, "0"),
                sharedPrefs.getString(Keys.MAX_CMD_INT, "10"),
                sharedPrefs.getString(Keys.MAX_CMD_ARR, "10"),
                sharedPrefs.getString(Keys.CODE_LOGGER_TIMEOUT, "1")));
            Toast.makeText(
                this.requireContext(),
                R.string.code_logger_dialog_toast,
                Toast.LENGTH_LONG
            ).show();
        } else if (valueStr.equals("0") && codeToSaveStr.equals(Keys.CODE_LOGGER_TIMEOUT)) {
            valueStr = "1";
            editor.putString(code.getResources().getResourceEntryName(code.getId()), valueStr);
            editor.apply();
            codeLoggerData.setSummary(getString(R.string.code_logger_data_summary,
                sharedPrefs.getString(Keys.STARTING_CMD_INT, "0"),
                sharedPrefs.getString(Keys.STARTING_CMD_ARR, "0"),
                sharedPrefs.getString(Keys.MAX_CMD_INT, "10"),
                sharedPrefs.getString(Keys.MAX_CMD_ARR, "10"),
                sharedPrefs.getString(Keys.CODE_LOGGER_TIMEOUT, "1")));
        } else {
            saveVerifiedLoggerCode(code);
        }
    }

    private int getIntFromPrefs(String key, String defaultValue) {
        String value = sharedPrefs.getString(key, defaultValue);
        return value.isEmpty() ? Integer.parseInt(defaultValue) : Integer.parseInt(value);
    }

    private void saveVerifiedLoggerCode(EditText code) {
        editor.putString(code.getResources().getResourceEntryName(code.getId()), code.getText().toString());
        editor.apply();
        codeLoggerData.setSummary(getString(R.string.code_logger_data_summary,
            sharedPrefs.getString(Keys.STARTING_CMD_INT, "0"),
            sharedPrefs.getString(Keys.STARTING_CMD_ARR, "0"),
            sharedPrefs.getString(Keys.MAX_CMD_INT, "10"),
            sharedPrefs.getString(Keys.MAX_CMD_ARR, "10"),
            sharedPrefs.getString(Keys.CODE_LOGGER_TIMEOUT, "1")));
    }

    private void saveInspectorCode(EditText code) {
        String codeToSaveStr = code.getResources().getResourceEntryName(code.getId());
        String valueStr = code.getText().toString();
        if ((valueStr.isEmpty() || valueStr.equals("0")) && codeToSaveStr.equals(Keys.CODE_INSPECTOR_TIMEOUT)) {
            valueStr = "30";
        } else if (valueStr.isEmpty()) {
            valueStr = "0";
        }
        editor.putString(code.getResources().getResourceEntryName(code.getId()), valueStr);
        editor.apply();
        codeInspectorData.setSummary(getString(R.string.code_inspector_data_summary,
            sharedPrefs.getString(Keys.INSPECTOR_CMD_INT, "0"),
            sharedPrefs.getString(Keys.INSPECTOR_CMD_ARR, "0"),
            sharedPrefs.getString(Keys.CODE_INSPECTOR_TIMEOUT, "30")));
    }

    private void setPipGroupVisible(boolean visible) {
        if (pipDualPref != null)   pipDualPref.setVisible(visible);
        if (pipFirstPref != null)  pipFirstPref.setVisible(visible);
        if (pipSecondPref != null) pipSecondPref.setVisible(visible);
        if (pipThirdPref != null)  pipThirdPref.setVisible(visible);
        if (pipFourthPref != null) pipFourthPref.setVisible(visible);
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
        dlg.show(requireActivity().getSupportFragmentManager(), "AppListPipDialog");
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
                    if (pipFirstPref  != null) { pipFirstPref.setChecked(false);  pipFirstPref.setModeChecked(false); }
                    if (pipSecondPref != null) { pipSecondPref.setChecked(false); pipSecondPref.setModeChecked(false); }
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
        Log.i("PipPositioner", "Adjust: " + pipScreenKey + " screen: " + String.valueOf(selectedScreen));
        if (selectedScreen == 0) {
            requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFirstScreen()).commit();
        } else {
            requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorOtherScreens(selectedScreen)).commit();
        }
    }
}
