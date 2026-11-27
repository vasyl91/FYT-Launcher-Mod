package com.android.launcher66.settings;

import com.android.launcher66.DoubleTapActions;
import com.android.launcher66.SysCalls;
import android.Manifest;
import android.app.AppOpsManager;
import android.app.Dialog;
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
import androidx.fragment.app.FragmentManager;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.TwoStatePreference;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.CustomElement;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.LauncherModel;
import com.android.launcher66.R;
import com.android.launcher66.ThemeAccent;
import com.android.launcher66.ServiceIntentGate;
import com.android.launcher66.WidgetBarPlan;
import com.android.launcher66.WorkspaceScreenPlan;
import com.android.launcher66.colorpicker.ColorPicker;
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
        FOLDERS,
        BAR,
        VERTICAL_BAR
    }
    private PendingDialog pendingDialog = PendingDialog.NONE;
    /** "Choose background for vertical bar": only with the vertical bar on. */
    private Preference verticalBarBackground;
    /** "Vertical bar side": only with the vertical bar on. */
    private Preference verticalBarSide;
    /** "Auto-hide handle": only with auto-hide on. */
    private Preference edgeHandleSide;

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
    private boolean displayCanbusReaderBool = false;
    private boolean tickRunnableBool = false;
    private boolean countDownTimerBool = false;
    private Preference startPage;
    /** The sizes of the icon labels, which came here from the first screen with their keys (IconTextSizeRows). */
    private IconTextSizeRows iconTextSizeRows;
    /** The order of the horizontal bar's elements: its row in "Bars" and its dialog. */
    private BarOrderDialog barOrderDialog;
    private EditText startPageEditText;
    private AlertDialog alertStartPageDialog;
    private SwitchPreferenceCompat autoHidePreference;
    private AutoHideSeekBarPreference autoHideSeekBar;
    private Preference everyPagePreference;
    private Preference verticalEveryPagePreference;
    private CustomSwitchPreference widgetBarNoCoverPreference;
    private CustomSwitchPreference widgetBarNoDatePreference;
    private CustomSwitchPreference widgetBarNoWeatherPreference;
    /** "Hide the apps" and "Fit the apps to their icons": with the widget bar only (WidgetBarPlan). */
    private CustomSwitchPreference widgetBarNoAppsPreference;
    private CustomSwitchPreference widgetBarFitAppsPreference;
    private CustomSwitchPreference widgetBarLargeTextPreference;
    private Preference widgetBarLineModePreference;
    private CustomSwitchPreference widgetBarButtonsOneLinePreference;
    private CustomSwitchPreference widgetBarButtonsBesidePreference;
    private SwitchPreferenceCompat resizableBarPreference;
    private HorizontalBarHeightSeekBarPreference barHeightSeekBar;
    private SwitchPreferenceCompat resizableVerticalBarPreference;
    private BarIconsSeekBarPreference horizontalIconsSlider;
    private Preference horizontalIconsTitle;
    private BarIconsSeekBarPreference verticalIconsSlider;
    private Preference verticalIconsTitle;
    private VerticalBarWidthSeekBarPreference verticalBarWidthSeekBar;
    private Preference margin;
    private EditText marginEditText;
    private SwitchPreferenceCompat userStats;
    private CustomWidgetPreference statsScreen;
    private Preference statsCodes;
    private Preference extraStatsCodes;
    private EditText fuelCodeInt;
    private String fuelCodeStr;
    private String rangeCodeStr;
    private String cmdIntCodeStr;
    private String cmdArrCodeStr;
    private String speedCodeStr;
    private String rpmCodeStr;
    /** Saves every field of the Canbus codes window; set while the window is open. */
    private Runnable saveCodesWindow;
    private Runnable saveExtraCodesWindow;
    private EditText inspectorTimeoutEdit;
    private String codeInspectorTimeoutStr;
    private SwitchPreferenceCompat mainScreenStats;
    private Preference statsBg;
    private Preference colorPickerPref;
    private Preference appList;
    private Preference appStatsCoordinates;
    private Preference codesGuide;
    private Preference skipCodes;
    private Preference canbusLibraryImport;
    private Preference canbusLibraryExport;
    private Preference canbusLibraryReset;
    /** The import in progress (main thread); null when there is none. */
    private CanbusLibraryImport.Job libraryImportJob;
    private AlertDialog libraryImportDialog;
    private AlertDialog libraryImportDoneDialog;
    /** What the import's result dialog says, kept across a turn of the screen. */
    private String libraryImportDoneMessage;
    private AlertDialog libraryResetDialog;
    private TextView libraryImportStatus;
    private ProgressBar libraryImportBar;
    /**
     * The import of the CAN bus library, through a turn of the screen (HandedWork has the rule). Sent to the
     * background (by "Run in background", or by a screen left for good), its result comes as a toast.
     */
    static final HandedWork<CanbusLibraryImport.Job, SettingsFragmentSecond> IMPORT = new HandedWork<>();
    private PreferenceCategory inspectorCategory;
    private Preference codeInspector;
    private Preference codeInspectorData;
    private Preference skipZeroCodes;
    private CountDownTimer countDownTimer;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Handler handler = new Handler(Looper.getMainLooper());
    /** The result of an import of the CAN bus library, which no row opens: its name across a turn. */
    private static final String TURN_LIBRARY_IMPORT_DONE = "canbus_library_import_done";
    /**
     * The plain dialogs of this screen that are open again after a turn of the screen (SettingsDialogMemory), by
     * the key of the row that opens them.
     */
    private static final String[] TURN_DIALOGS = {
            Keys.START_PAGE, Keys.LAYOUT_MARGIN, Keys.STATS_CODES, Keys.EXTRA_STATS_CODES, Keys.SKIP_CODES,
            Keys.CODE_INSPECTOR_DATA, Keys.CANBUS_LIBRARY_RESET, TURN_LIBRARY_IMPORT_DONE,
            Keys.ALL_APPS_TEXT_SIZE, Keys.WORKSPACE_TEXT_SIZE, Keys.HORIZONTAL_BAR_ORDER
    };
    private EditText skipCodesEditText;
    private AlertDialog alertPipDialog;
    private AlertDialog alertMarginsDialog;
    private AlertDialog alertCodesDialog;
    private AlertDialog alertExtraCodesDialog;
    private AlertDialog alertSkipCodesDialog;
    private AlertDialog alertCodesInspectorDialog;
    private WeakReference<AppListStatsDialogFragment> appListStatsDialog;
    private WeakReference<ColorPicker> colorPicker;
    private WeakReference<ColorPicker> tintPicker;
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

    /** The options the most icons of a bar depends on (BarIconLimits): the sliders' ends follow them at once. */
    private static final java.util.Set<String> BAR_ICON_INPUTS = new java.util.HashSet<>(java.util.Arrays.asList(
            Keys.HORIZONTAL_BAR_HEIGHT_PORT, Keys.HORIZONTAL_BAR_HEIGHT_LAND, Keys.RESIZABLE_HORIZONTAL_BAR,
            Keys.VERTICAL_BAR_WIDTH_PORT, Keys.VERTICAL_BAR_WIDTH_LAND, Keys.RESIZABLE_VERTICAL_BAR,
            Keys.WIDGET_BAR, Keys.VERTICAL_BAR, Keys.AUTO_HIDE_HORIZONTAL_BAR, Keys.HORIZONTAL_BAR_TOP,
            Keys.VERTICAL_BAR_RIGHT, Keys.EDGE_HANDLE_RIGHT, Keys.USER_LAYOUT, Keys.HORIZONTAL_BAR_EVERY_PAGE,
            Keys.VERTICAL_BAR_EVERY_PAGE, Keys.BAR_ROOT_BOX_PORTRAIT, Keys.BAR_ROOT_BOX_LANDSCAPE,
            Keys.WIDGET_BAR_NO_APPS));

    private final SharedPreferences.OnSharedPreferenceChangeListener barIconsListener = (prefs, key) -> {
        if (key != null && BAR_ICON_INPUTS.contains(key)) {
            // After the preference has finished its own work (a switch's click listener runs after it is stored)
            handler.post(this::updateBarIconSliders);
        }
    };

    /**
     * The sliders of the number of icons: the horizontal one unless its apps list is hidden, the vertical one with
     * the vertical bar, with or without their bar's "Resizable" switch (the owner, 2026-11-21); their end the most
     * the bar has room for now, a chosen number above it lowered (BarIconLimits, BarIconCount).
     */
    private void updateBarIconSliders() {
        if (!isAdded() || sharedPrefs == null) {
            return;
        }
        // Without its apps list the horizontal bar has no icons to count (WidgetBarPlan.appsHidden)
        boolean horizontal = !WidgetBarPlan.appsHidden(sharedPrefs.getBoolean(Keys.USER_LAYOUT, false),
                sharedPrefs.getBoolean(Keys.WIDGET_BAR, false), sharedPrefs.getBoolean(Keys.WIDGET_BAR_NO_APPS, false));
        boolean vertical = sharedPrefs.getBoolean(Keys.VERTICAL_BAR, false);
        bindBarIcons(horizontalIconsSlider, horizontalIconsTitle, true, horizontal);
        bindBarIcons(verticalIconsSlider, verticalIconsTitle, false, vertical);
    }

    private void bindBarIcons(BarIconsSeekBarPreference slider, Preference title, boolean horizontal,
                              boolean visible) {
        if (slider == null || title == null) {
            return;
        }
        slider.setVisible(visible);
        title.setVisible(visible);
        if (!visible) {
            return;
        }
        Context context = requireContext();
        int max = BarIconLimits.max(context, sharedPrefs, horizontal);
        int shown = BarIconLimits.shownAfterLowering(context, sharedPrefs, horizontal, max);
        slider.setRange(max, shown);
        title.setTitle(getString(R.string.bar_icons_count, shown));
    }

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
    public void onResume() {
        super.onResume();
        // A list that was kept has its position; what was kept for it is not needed (SettingsScrollMemory)
        SettingsScrollMemory.takeFor(2);
    }

    @Override
    public void onPause() {
        SettingsScroll.keep(this, 2);
        super.onPause();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // The accent of the settings (ThemeAccent) on every row as it is attached, and again when it is changed
        com.android.launcher66.AccentPainter.attach(getListView());
        bindAccentChange();
        // Back from a window this screen was left for: where it was (SettingsScrollMemory)
        SettingsScroll.restore(this, 2);
        // Created again for a turn of the screen: the dialog that was open is open again (SettingsDialogMemory),
        // and an import that goes on shows its dialog here (HandedWork)
        handler.post(this::reopenAfterTurn);
        handler.post(this::takeOverImport);
        // A colour picker the settings brought back stores its colour as before (ColorPickerTargets)
        handler.post(this::rebindColorPickers);

        setDivider(null);
        setDividerHeight(0);

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
                SettingsScrollMemory.betweenScreens();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragmentFirst()).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    /** The rows are drawn dimmed while they are off (SettingsRowDim). */
    @NonNull
    @Override
    protected RecyclerView.Adapter onCreateAdapter(@NonNull androidx.preference.PreferenceScreen preferenceScreen) {
        return new DimmingPreferenceAdapter(preferenceScreen);
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
        extraStatsCodes = findPreference(Keys.EXTRA_STATS_CODES);
        fuelCodeStr = sharedPrefs.getString("fuel_code_int", "0");
        rangeCodeStr = sharedPrefs.getString("range_code_int", "0");
        cmdIntCodeStr = sharedPrefs.getString(Keys.CMD_INT, "0");
        cmdArrCodeStr = sharedPrefs.getString(Keys.CMD_ARR, "0");
        speedCodeStr = sharedPrefs.getString(Keys.SPEED_CODE, "0");
        rpmCodeStr = sharedPrefs.getString("rpm_code_int", "0");

        mainScreenStats = findPreference(Keys.MAIN_SCREEN_STATS);
        colorPickerPref = findPreference(Keys.COLOR_PICKER);
        statsBg = findPreference(Keys.STATS_BACKGROUND);
        appList = findPreference(Keys.APP_LIST);
        appStatsCoordinates = findPreference(Keys.APP_STATS_COORDINATES);

        SwitchPreferenceCompat displayCanbusReader = findPreference(Keys.DISPLAY_CANBUS_READER);
        codesGuide = findPreference(Keys.CODES_GUIDE);
        skipCodes = findPreference(Keys.SKIP_CODES);
        canbusLibraryImport = findPreference(Keys.CANBUS_LIBRARY_IMPORT);
        canbusLibraryExport = findPreference(Keys.CANBUS_LIBRARY_EXPORT);
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
        Preference foldersBackground = findPreference(Keys.FOLDERS_BACKGROUND);
        Preference widgetsTint = findPreference(Keys.WIDGETS_TINT);
        Preference accentRow = findPreference(ThemeAccent.KEY);
        Preference iconTextRow = findPreference(Keys.WORKSPACE_TEXT_COLOR);
        Preference drawerTextRow = findPreference(Keys.ALL_APPS_TEXT_COLOR);
        bindDoubleTap();
        bindDrawerTabs();
        bindWidgetOverlap();
        // On an FYT unit the framework shows its panel of quick settings for this swipe, not the notifications
        SwitchPreferenceCompat swipeDown = findPreference(Keys.SWIPE_DOWN_NOTIFICATIONS);
        if (swipeDown != null && LauncherApplication.isFytDevice()) {
            swipeDown.setSummaryOn(R.string.swipe_down_notifications_on_fyt);
        }
        Preference barTint = findPreference(Keys.BAR_TINT);
        iconTextSizeRows = new IconTextSizeRows(this, sharedPrefs, helpers);
        iconTextSizeRows.bind();
        barOrderDialog = new BarOrderDialog(this, sharedPrefs, helpers);
        barOrderDialog.bind();
        bindGridSlider(GridSeekBarPreference.ROWS, "workspace_grid_rows_title", R.string.workspace_grid_rows);
        bindGridSlider(GridSeekBarPreference.COLUMNS, "workspace_grid_columns_title", R.string.workspace_grid_columns);
        bindAppsGridSlider(Keys.ALL_APPS_GRID_ROWS, "all_apps_grid_rows_title", R.string.workspace_grid_rows);
        bindAppsGridSlider(Keys.ALL_APPS_GRID_COLUMNS, "all_apps_grid_columns_title", R.string.workspace_grid_columns);
        startPage = findPreference(Keys.START_PAGE);
        // The page that is really used: a stored number that names no page shows as the first page
        String startPageStr = sharedPrefs.getString(Keys.START_PAGE, "1");
        int startPagePages = knownPages();
        startPage.setSummary(startPagePages > 0
                ? String.valueOf(StartPageRule.effective(startPageStr, startPagePages)) : startPageStr);

        everyPagePreference = findPreference(Keys.HORIZONTAL_BAR_EVERY_PAGE);
        verticalEveryPagePreference = findPreference(Keys.VERTICAL_BAR_EVERY_PAGE);
        autoHidePreference = findPreference(Keys.AUTO_HIDE_HORIZONTAL_BAR);
        autoHideSeekBar = findPreference(Keys.AUTO_HIDE_TIMEOUT);
        resizableBarPreference = findPreference(Keys.RESIZABLE_HORIZONTAL_BAR);
        barHeightSeekBar = findPreference(Keys.HORIZONTAL_BAR_HEIGHT);
        resizableVerticalBarPreference = findPreference(Keys.RESIZABLE_VERTICAL_BAR);
        verticalBarWidthSeekBar = findPreference(Keys.VERTICAL_BAR_WIDTH);
        horizontalIconsSlider = findPreference(Keys.HORIZONTAL_BAR_ICONS);
        horizontalIconsTitle = findPreference(Keys.HORIZONTAL_BAR_ICONS + "_title");
        verticalIconsSlider = findPreference(Keys.VERTICAL_BAR_ICONS);
        verticalIconsTitle = findPreference(Keys.VERTICAL_BAR_ICONS + "_title");

        Preference verticalBar = findPreference(Keys.VERTICAL_BAR);
        Preference widgetBar = findPreference(Keys.WIDGET_BAR);
        widgetBarNoCoverPreference = findPreference(Keys.WIDGET_BAR_NO_COVER);
        widgetBarNoDatePreference = findPreference(Keys.WIDGET_BAR_NO_DATE);
        widgetBarNoWeatherPreference = findPreference(Keys.WIDGET_BAR_NO_WEATHER);
        widgetBarNoAppsPreference = findPreference(Keys.WIDGET_BAR_NO_APPS);
        widgetBarFitAppsPreference = findPreference(Keys.WIDGET_BAR_FIT_APPS);
        widgetBarLargeTextPreference = findPreference(Keys.WIDGET_BAR_LARGE_TEXT);
        widgetBarLineModePreference = findPreference(Keys.WIDGET_BAR_LINE_MODE);
        widgetBarButtonsOneLinePreference = findPreference(Keys.WIDGET_BAR_BUTTONS_ONE_LINE);
        widgetBarButtonsBesidePreference = findPreference(Keys.WIDGET_BAR_BUTTONS_BESIDE);

        margin = findPreference(Keys.LAYOUT_MARGIN);
        String marginStr = sharedPrefs.getString(Keys.LAYOUT_MARGIN, "5");
        margin.setSummary(marginStr);


        updatePipSummaries();
        sharedPrefs.registerOnSharedPreferenceChangeListener(pipPkgListener);        
        sharedPrefs.registerOnSharedPreferenceChangeListener(barIconsListener);
        for (BarIconsSeekBarPreference slider : new BarIconsSeekBarPreference[] {horizontalIconsSlider,
                verticalIconsSlider}) {
            if (slider != null) {
                slider.setOnValueChangeListener(value -> {
                    updateBarIconSliders();
                    helpers.setBarSettingsChanged(true);
                });
            }
        }
        updateBarIconSliders();

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
        pipBool = sharedPrefs.getBoolean(Keys.DISPLAY_PIP, true);
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
        if (foldersBackground != null) {
            foldersBackground.setOnPreferenceClickListener(preference -> {
                checkAndShowFoldersBackgroundSelector();
                return true;
            });
        }
        if (widgetsTint != null) {
            widgetsTint.setOnPreferenceClickListener(preference -> {
                showTintPicker(Keys.WIDGETS_TINT_COLOR);
                return true;
            });
        }
        if (accentRow != null) {
            accentRow.setOnPreferenceClickListener(preference -> {
                showAccentPicker();
                return true;
            });
        }
        if (iconTextRow != null) {
            iconTextRow.setOnPreferenceClickListener(preference -> {
                showIconTextPicker();
                return true;
            });
        }
        if (drawerTextRow != null) {
            drawerTextRow.setOnPreferenceClickListener(preference -> {
                showDrawerTextPicker();
                return true;
            });
        }
        if (barBackground != null) {
            barBackground.setOnPreferenceClickListener(preference -> {
                checkAndShowBarBackgroundSelector();
                return true;
            });
        }
        if (barTint != null) {
            barTint.setOnPreferenceClickListener(preference -> {
                showTintPicker(Keys.BAR_TINT_COLOR);
                return true;
            });
        }
        Preference horizontalBarTop = findPreference(Keys.HORIZONTAL_BAR_TOP);
        if (horizontalBarTop != null) {
            horizontalBarTop.setOnPreferenceClickListener(this);
        }
        edgeHandleSide = findPreference(Keys.EDGE_HANDLE_RIGHT);
        if (edgeHandleSide != null) {
            edgeHandleSide.setVisible(sharedPrefs.getBoolean(Keys.AUTO_HIDE_HORIZONTAL_BAR, false));
            edgeHandleSide.setOnPreferenceClickListener(this);
        }
        verticalBarSide = findPreference(Keys.VERTICAL_BAR_RIGHT);
        if (verticalBarSide != null) {
            verticalBarSide.setVisible(sharedPrefs.getBoolean(Keys.VERTICAL_BAR, false));
            verticalBarSide.setOnPreferenceClickListener(this);
        }
        verticalBarBackground = findPreference(Keys.VERTICAL_BAR_BACKGROUND);
        if (verticalBarBackground != null) {
            verticalBarBackground.setVisible(sharedPrefs.getBoolean(Keys.VERTICAL_BAR, false));
            verticalBarBackground.setOnPreferenceClickListener(preference -> {
                checkAndShowVerticalBarBackgroundSelector();
                return true;
            });
        }
        if (startPage != null) {
            startPage.setOnPreferenceClickListener(this);
        }
        if (everyPagePreference != null) {
            everyPagePreference.setOnPreferenceClickListener(this);
            updateEveryPageSummary();
        }
        if (verticalEveryPagePreference != null) {
            verticalEveryPagePreference.setVisible(sharedPrefs.getBoolean(Keys.VERTICAL_BAR, false));
            verticalEveryPagePreference.setOnPreferenceClickListener(this);
            updateEveryPageSummary();
        }
        autoHideBool = sharedPrefs.getBoolean(Keys.AUTO_HIDE_HORIZONTAL_BAR, false);
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
        resizableBarBool = sharedPrefs.getBoolean(Keys.RESIZABLE_HORIZONTAL_BAR, false);
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
        if (resizableVerticalBarPreference != null) {
            resizableVerticalBarPreference.setOnPreferenceClickListener(this);
            // Formatted right away, as the horizontal bar's: summaryOn holds the raw format until then
            updateVerticalBarWidthSummary.run();
        }
        if (verticalBarWidthSeekBar != null) {
            verticalBarWidthSeekBar.setOnPreferenceChangeListener((preference, newValue) -> {
                // Stored by the slider after this returns: the width is worked out again once it is
                handler.post(this::verticalBarWidthChanged);
                return true;
            });
        }
        updateVerticalBarWidthRows();
        if (verticalBar != null) {
            verticalBar.setOnPreferenceClickListener(this);
        }
        if (widgetBar != null) {
            widgetBar.setOnPreferenceClickListener(this);
        }
        if (widgetBarNoCoverPreference != null) {
            widgetBarNoCoverPreference.setOnPreferenceClickListener(this);
        }
        if (widgetBarNoDatePreference != null) {
            widgetBarNoDatePreference.setOnPreferenceClickListener(this);
        }
        if (widgetBarNoAppsPreference != null) {
            widgetBarNoAppsPreference.setOnPreferenceClickListener(this);
        }
        if (widgetBarFitAppsPreference != null) {
            widgetBarFitAppsPreference.setOnPreferenceClickListener(this);
        }
        if (widgetBarNoWeatherPreference != null) {
            widgetBarNoWeatherPreference.setOnPreferenceClickListener(this);
        }
        if (widgetBarLargeTextPreference != null) {
            widgetBarLargeTextPreference.setOnPreferenceClickListener(this);
        }
        if (widgetBarLineModePreference != null) {
            widgetBarLineModePreference.setOnPreferenceClickListener(this);
        }
        if (widgetBarButtonsOneLinePreference != null) {
            widgetBarButtonsOneLinePreference.setOnPreferenceClickListener(this);
        }
        if (widgetBarButtonsBesidePreference != null) {
            widgetBarButtonsBesidePreference.setOnPreferenceClickListener(this);
        }
        updateWidgetBarRows();
        for (String key : new String[] {Keys.DISPLAY_HORIZONTAL_BAR, Keys.HORIZONTAL_BAR_NO_DRAWER,
                Keys.WIDGET_BAR_NO_MUSIC}) {
            Preference row = findPreference(key);
            if (row != null) {
                row.setOnPreferenceClickListener(this);
            }
        }
        updateHorizontalBarRows();
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
            extraStatsCodes.setSummary(extraStatsCodesSummary());
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
            // "Choose background for statistics": the selector the widgets and the bars have
            statsBg.setOnPreferenceClickListener(preference -> {
                BackgroundSelectorDialog.showWithLoadedBackground(getParentFragmentManager(), requireContext(),
                        "stats", "bg_custom");
                return true;
            });
            statsBg.setVisible(userStatsBool);
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
        if (canbusLibraryExport != null) {
            canbusLibraryExport.setOnPreferenceClickListener(this);
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
        displayCanbusReaderBool = sharedPrefs.getBoolean(Keys.DISPLAY_CANBUS_READER, false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 80, 0);
        switch (preference.getKey()) {
            case Keys.DISPLAY_PIP:
                pipBool = sharedPrefs.getBoolean(Keys.DISPLAY_PIP, true);
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

                // One field: the keyboard opens with the dialog (DialogKeyboard)
                DialogKeyboard.openFor(alertStartPageDialog, startPageEditText);
                alertStartPageDialog.show();
                break;
            case Keys.HORIZONTAL_BAR_EVERY_PAGE:
            case Keys.VERTICAL_BAR_EVERY_PAGE:
                updateEveryPageSummary();
                helpers.setBarSettingsChanged(true);
                break;
            case Keys.AUTO_HIDE_HORIZONTAL_BAR:
                autoHideBool = sharedPrefs.getBoolean(Keys.AUTO_HIDE_HORIZONTAL_BAR, false);
                if (autoHideBool) {
                    handler.post(updateSummary);
                } else {
                    autoHidePreference.setSummary(null);    
                }                
                autoHideSeekBar.setVisible(autoHideBool);
                if (edgeHandleSide != null) {
                    edgeHandleSide.setVisible(autoHideBool);
                }
                helpers.setBarSettingsChanged(true);
                break;
            case Keys.RESIZABLE_HORIZONTAL_BAR:
                // Click listeners run after the switch persisted its new state.
                resizableBarBool = sharedPrefs.getBoolean(Keys.RESIZABLE_HORIZONTAL_BAR, false);
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
            case Keys.RESIZABLE_VERTICAL_BAR:
                // On or off: the old width or the slider's; the page is built again with it
                updateVerticalBarWidthRows();
                verticalBarWidthChanged();
                break;
            case Keys.EDGE_HANDLE_RIGHT:
                // The handle's window is placed again at the next update; no rebuild of the page
                helpers.setBarSettingsChanged(true);
                break;
            case Keys.DISPLAY_HORIZONTAL_BAR:
                // The bar's rows go and come with it; the launcher builds the first page again without it or with it
                updateHorizontalBarRows();
                helpers.setBarSettingsChanged(true);
                break;
            case Keys.HORIZONTAL_BAR_TOP:
            case Keys.VERTICAL_BAR_RIGHT:
                // The bars are laid out again, and the rectangles of the widgets are fitted to the new bands
                helpers.setBarSettingsChanged(true);
                break;
            case Keys.VERTICAL_BAR:
                if (verticalBarSide != null) {
                    verticalBarSide.setVisible(sharedPrefs.getBoolean(Keys.VERTICAL_BAR, false));
                }
                if (verticalBarBackground != null) {
                    verticalBarBackground.setVisible(sharedPrefs.getBoolean(Keys.VERTICAL_BAR, false));
                }
                if (verticalEveryPagePreference != null) {
                    verticalEveryPagePreference.setVisible(sharedPrefs.getBoolean(Keys.VERTICAL_BAR, false));
                }
                updateVerticalBarWidthRows();
                helpers.setBarSettingsChanged(true);
                break;
            case Keys.WIDGET_BAR:
                // The rows that belong to the widget bar appear and disappear with it.
                updateWidgetBarRows();
                // The elements of the bar's order change with it
                if (barOrderDialog != null) {
                    barOrderDialog.updateSummary();
                }
                break;
            case Keys.HORIZONTAL_BAR_NO_DRAWER:
            case Keys.WIDGET_BAR_NO_MUSIC:
            case Keys.WIDGET_BAR_NO_COVER:
            case Keys.WIDGET_BAR_NO_DATE:
            case Keys.WIDGET_BAR_NO_WEATHER:
            case Keys.WIDGET_BAR_NO_APPS:
            case Keys.WIDGET_BAR_FIT_APPS:
                // The layout row below appears (or goes) at once with the first hidden widget; with the apps
                // hidden, their fitting and their number of icons go too
                turnOffEmptyBar();
                updateWidgetBarRows();
                // After the widget bar's rows: a bar that was just turned off hides them all
                updateHorizontalBarRows();
                updateBarIconSliders();
                if (barOrderDialog != null) {
                    barOrderDialog.updateSummary();
                }
                helpers.setBarSettingsChanged(true);
                break;
            case Keys.WIDGET_BAR_BUTTONS_BESIDE:
                // The two rows below belong to that layout and appear and go with it
                updateWidgetBarRows();
                helpers.setBarSettingsChanged(true);
                break;
            case Keys.WIDGET_BAR_LARGE_TEXT:
            case Keys.WIDGET_BAR_LINE_MODE:
            case Keys.WIDGET_BAR_BUTTONS_ONE_LINE:
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

                // One field: the keyboard opens with the dialog (DialogKeyboard)
                DialogKeyboard.openFor(alertMarginsDialog, marginEditText);
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
                speedCodeStr = sharedPrefs.getString(Keys.SPEED_CODE, "0");
                rpmCodeStr = sharedPrefs.getString("rpm_code_int", "0");

                alertCodesDialog = displayCodesDialog().create();

                alertCodesDialog.setOnShowListener(dialog -> {
                    Button negativeCodesButton = alertCodesDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                    negativeCodesButton.setLayoutParams(params);
                    fuelCodeInt.requestFocus();
                    imm.showSoftInput(fuelCodeInt, InputMethodManager.SHOW_IMPLICIT);
                    fuelCodeInt.setSelection(fuelCodeInt.getText().length());
                });

                alertCodesDialog.show();
                fitDialogWindow(alertCodesDialog);
                break;
            case Keys.EXTRA_STATS_CODES:
                alertExtraCodesDialog = displayExtraCodesDialog().create();

                alertExtraCodesDialog.setOnShowListener(dialog -> {
                    Button negativeExtraCodesButton = alertExtraCodesDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                    negativeExtraCodesButton.setLayoutParams(params);
                });

                alertExtraCodesDialog.show();
                fitDialogWindow(alertExtraCodesDialog);
                break;
            case Keys.COLOR_PICKER:
                // "Statistics text color": the colour picker in its text mode. The colour is stored as text
                // under "stats_color", as it always was; nothing is stored unless "Select" is pressed.
                ColorPicker picker = ColorPicker.newTextInstance(
                        StatsBackgroundMigration.parse(sharedPrefs.getString("stats_color", "#FFFFFFFF")), false);
                colorPicker = new WeakReference<>(picker);

                picker.enableAutoClose();
                // Bound again after a turn of the screen (ColorPickerTargets)
                ColorPickerTargets.bindStats(picker, sharedPrefs);
                picker.show(getParentFragmentManager(), ColorPickerTargets.TAG_STATS);
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

                // One field: the keyboard opens with the dialog (DialogKeyboard)
                DialogKeyboard.openFor(alertSkipCodesDialog, skipCodesEditText);
                alertSkipCodesDialog.show();
                break;
            case Keys.CANBUS_LIBRARY_IMPORT:
                if (libraryImportJob == null) {
                    canbusLibraryPicker.launch(new String[]{"text/plain", "application/octet-stream", "*/*"});
                }
                break;
            case Keys.CANBUS_LIBRARY_EXPORT:
                exportCanbusLibrary();
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

                // One field: the keyboard opens with the dialog (DialogKeyboard)
                DialogKeyboard.openFor(alertCodesInspectorDialog, inspectorTimeoutEdit);
                alertCodesInspectorDialog.show();
                break;
            default:
                break;
        }
        return false;
    }

    /**
     * "Widget text and button color" / "Horizontal bar text and button color": the colour picker in its text
     * mode. "Select" stores the colour, "Default" forgets it (the views get their own look back), and a picker
     * closed any other way changes nothing. The home screen follows at once (WidgetStyler.isLookSetting).
     *
     * @param colorKey Keys.WIDGETS_TINT_COLOR or Keys.BAR_TINT_COLOR
     */
    private void showTintPicker(String colorKey) {
        int current = sharedPrefs.contains(colorKey) ? sharedPrefs.getInt(colorKey, Color.WHITE) : Color.WHITE;
        ColorPicker picker = ColorPicker.newTextInstance(current, true);
        tintPicker = new WeakReference<>(picker);
        picker.enableAutoClose();
        // Bound again after a turn of the screen (ColorPickerTargets)
        ColorPickerTargets.bindTint(picker, sharedPrefs, colorKey);
        picker.show(getParentFragmentManager(), ColorPickerTargets.TAG_TINT);
    }

    /**
     * "Set global theme color": the colour picker in its text mode. "Select" stores the colour, "Default" forgets it, a
     * picker closed another way changes nothing. The settings are painted again at once (accentListener), the
     * launcher's views when the settings are left (Helpers.setBarSettingsChanged).
     */
    private void showAccentPicker() {
        ColorPicker picker = ColorPicker.newTextInstance(ThemeAccent.color(requireContext()), true);
        tintPicker = new WeakReference<>(picker);
        picker.enableAutoClose();
        ColorPickerTargets.bindAccent(picker, sharedPrefs);
        picker.show(getParentFragmentManager(), ColorPickerTargets.TAG_ACCENT);
    }

    /**
     * "Set icon text color": the colour picker in its text mode, as for the tints ("Select" stores the opaque colour,
     * "Default" forgets it and the names are white again). The home screen follows at once (WidgetStyler.isLookSetting).
     */
    private void showIconTextPicker() {
        int current = sharedPrefs.contains(Keys.WORKSPACE_TEXT_COLOR)
                ? sharedPrefs.getInt(Keys.WORKSPACE_TEXT_COLOR, Color.WHITE) : Color.WHITE;
        ColorPicker picker = ColorPicker.newTextInstance(current, true);
        tintPicker = new WeakReference<>(picker);
        picker.enableAutoClose();
        ColorPickerTargets.bindTint(picker, sharedPrefs, Keys.WORKSPACE_TEXT_COLOR);
        picker.show(getParentFragmentManager(), ColorPickerTargets.TAG_ICON_TEXT);
    }

    /**
     * "App drawer": "Set icon text color": the colour picker in its text mode ("Select" stores the opaque colour, "Default"
     * forgets it and the names are white again). The drawer takes it when its icons are made, at each opening.
     */
    private void showDrawerTextPicker() {
        int current = sharedPrefs.contains(Keys.ALL_APPS_TEXT_COLOR)
                ? sharedPrefs.getInt(Keys.ALL_APPS_TEXT_COLOR, Color.WHITE) : Color.WHITE;
        ColorPicker picker = ColorPicker.newTextInstance(current, true);
        tintPicker = new WeakReference<>(picker);
        picker.enableAutoClose();
        ColorPickerTargets.bindTint(picker, sharedPrefs, Keys.ALL_APPS_TEXT_COLOR);
        picker.show(getParentFragmentManager(), ColorPickerTargets.TAG_DRAWER_TEXT);
    }

    /**
     * "Allow widgets to overlap": turning it on is as any switch; turning it off asks first, because the widgets that
     * overlap other items are put on the grid again and the ones with no room are removed (Workspace.refitWidgetsToGrid,
     * done by the launcher when the setting changes). Cancel leaves the switch on.
     */
    private void bindWidgetOverlap() {
        final SwitchPreferenceCompat row = findPreference(Keys.WIDGET_OVERLAP);
        if (row == null) {
            return;
        }
        row.setOnPreferenceChangeListener((preference, value) -> {
            if (Boolean.TRUE.equals(value) || !row.isChecked()) {
                return true;
            }
            SettingsDialogs.builder(requireContext())
                    .setTitle(R.string.widget_overlap_off_title)
                    .setMessage(R.string.widget_overlap_off_message)
                    .setNegativeButton(R.string.cancel_btn, null)
                    .setPositiveButton(android.R.string.ok, (dialog, which) -> row.setChecked(false))
                    .show();
            return false;
        });
    }

    /**
     * "App drawer": "Tabs" opens the tab creator (DrawerTabsFragment). The screen keeps the place this list was at, as it
     * does for the other screens that are left for a window to come back from (SettingsScrollMemory).
     */
    private void bindDrawerTabs() {
        Preference row = findPreference(Keys.DRAWER_TABS);
        if (row == null) {
            return;
        }
        row.setVisible(true);
        row.setOnPreferenceClickListener(preference -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new DrawerTabsFragment()).commit();
            return true;
        });
    }

    /**
     * "Double-tap action": below Android 9 the choices are nothing and "Turn off screen" (the global action that locks
     * is from Android 9). Choosing "Lock screen" asks for the accessibility service at the next return to the home screen
     * (the permission flow), and "Turn off screen" says that the same double tap brings the screen back.
     */
    private void bindDoubleTap() {
        ListPreference row = findPreference(Keys.DOUBLE_TAP_ACTION);
        if (row == null) {
            return;
        }
        if (!DoubleTapActions.lockAvailable()) {
            row.setEntries(new CharSequence[] {getString(R.string.double_tap_none), getString(R.string.double_tap_screen_off)});
            row.setEntryValues(new CharSequence[] {DoubleTapActions.NONE,
                    DoubleTapActions.SCREEN_OFF});
        }
        row.setOnPreferenceChangeListener((preference, value) -> {
            if (DoubleTapActions.LOCK.equals(value)) {
                DoubleTapActions.lockChosen();
            } else if (DoubleTapActions.SCREEN_OFF.equals(value)) {
                Toast.makeText(requireContext().getApplicationContext(), R.string.double_tap_screen_off_hint,
                        Toast.LENGTH_LONG).show();
            }
            return true;
        });
    }

    /** The settings follow every change of the accent, or of the stock layout that turns it off. */
    private final SharedPreferences.OnSharedPreferenceChangeListener accentListener = (prefs, key) -> {
        if (ThemeAccent.KEY.equals(key) || Keys.USER_LAYOUT.equals(key)) {
            com.android.launcher66.AccentPainter.repaint(getListView());
            helpers.setBarSettingsChanged(true);
        }
    };

    private void bindAccentChange() {
        sharedPrefs.registerOnSharedPreferenceChangeListener(accentListener);
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

    private void checkAndShowFoldersBackgroundSelector() {
        List<String> perms = getMissingReadWallpaperPermissions(requireContext());
        if (perms.isEmpty()) {
            BackgroundSelectorDialog.showWithLoadedBackground(getParentFragmentManager(), requireContext(), "folders", "bg_custom");
            pendingDialog = PendingDialog.NONE;
        } else {
            pendingDialog = PendingDialog.FOLDERS;
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

    private void checkAndShowVerticalBarBackgroundSelector() {
        List<String> perms = getMissingReadWallpaperPermissions(requireContext());
        if (perms.isEmpty()) {
            BackgroundSelectorDialog.showWithLoadedBackground(getParentFragmentManager(), requireContext(), "vertical_bar", "app_list_bg");
            pendingDialog = PendingDialog.NONE;
        } else {
            pendingDialog = PendingDialog.VERTICAL_BAR;
            requestPermissions(perms.toArray(new String[0]), REQ_READ_WALLPAPER);
        }
    }

    /**
     * The permission to ask for before a background selector, so that it can show the wallpaper behind its
     * tiles: the old storage permission, and only where it exists and helps (WallpaperAccess: below Android
     * 13, and not for the system version). From Android 13 neither it nor the permission for pictures lets an
     * app read the wallpaper; asking for them there put a request, or its refusal, before every opening of a
     * selector. The selector reads the wallpaper through HomeWallpaperSource and has its own fallback.
     */
    private static List<String> getMissingReadWallpaperPermissions(@NonNull Context ctx) {
        List<String> perms = new ArrayList<>();
        boolean systemApp = android.os.Process.myUid() == android.os.Process.SYSTEM_UID;
        if (WallpaperAccess.storagePermissionHelps(Build.VERSION.SDK_INT, systemApp)
                && ContextCompat.checkSelfPermission(ctx, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            perms.add(Manifest.permission.READ_EXTERNAL_STORAGE);
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
            case FOLDERS:
                BackgroundSelectorDialog.showWithLoadedBackground(getParentFragmentManager(), requireContext(), "folders", "bg_custom");
                break;
            case BAR:
                BackgroundSelectorDialog.showWithLoadedBackground(getParentFragmentManager(), requireContext(), "bar", "app_list_bg");
                break;
            case VERTICAL_BAR:
                BackgroundSelectorDialog.showWithLoadedBackground(getParentFragmentManager(), requireContext(), "vertical_bar", "app_list_bg");
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
        if (verticalBarWidthSeekBar != null) {
            verticalBarWidthSeekBar.refresh();
        }
        handler.post(updateVerticalBarWidthSummary);
        handler.post(this::updateBarIconSliders);
        // Also while the switch is off, so its summary is current when it is turned on.
        handler.post(updateBarHeightSummary);
        // The order is stored per orientation: show the new one's, in the row and in an open dialog
        if (barOrderDialog != null) {
            handler.post(barOrderDialog::onOrientationChanged);
        }
    }

    @Override
    public void onDestroyView() {
        if (sharedPrefs != null) {
            sharedPrefs.unregisterOnSharedPreferenceChangeListener(accentListener);
        }
        // Gone for a turn of the screen: the dialog that is open comes back with the new screen
        DialogTurn.keep(this, 2, TURN_DIALOGS, this::turnDialog, this::turnArg);
        // An import goes on: for the new screen after a turn, else in the background (its result as a toast)
        if (getActivity() == null || !getActivity().isChangingConfigurations()) {
            IMPORT.toBackground();
        }
        IMPORT.leave(this);
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
            sharedPrefs.unregisterOnSharedPreferenceChangeListener(barIconsListener);
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
        extraStatsCodes = null;
        autoHidePreference = null;
        autoHideSeekBar = null;
        everyPagePreference = null;
        verticalEveryPagePreference = null;
        widgetBarNoCoverPreference = null;
        widgetBarNoDatePreference = null;
        widgetBarNoAppsPreference = null;
        widgetBarFitAppsPreference = null;
        widgetBarNoWeatherPreference = null;
        widgetBarLargeTextPreference = null;
        widgetBarLineModePreference = null;
        widgetBarButtonsOneLinePreference = null;
        widgetBarButtonsBesidePreference = null;
        resizableBarPreference = null;
        barHeightSeekBar = null;
        resizableVerticalBarPreference = null;
        verticalBarWidthSeekBar = null;
        horizontalIconsSlider = null;
        horizontalIconsTitle = null;
        verticalIconsSlider = null;
        verticalIconsTitle = null;
        imm = null;
    }

    /**
     * The bar on the other pages (and the handle that reveals it) is a window over the apps. Without
     * the permission for that (the standard version before it is given) nothing shows there, so the
     * summary of the switch says what is missing instead of promising the bar.
     */
    private void updateEveryPageSummary() {
        updateEveryPageSummary(everyPagePreference);
        updateEveryPageSummary(verticalEveryPagePreference);
    }

    /** The same texts for both bars: they say "the bar on every page", whichever bar it is. */
    private void updateEveryPageSummary(Preference preference) {
        if (!(preference instanceof TwoStatePreference)) {
            return;
        }
        TwoStatePreference every = (TwoStatePreference) preference;
        boolean missing = every.isChecked() && !android.provider.Settings.canDrawOverlays(requireContext());
        every.setSummaryOn(getString(missing ? R.string.horizontal_bar_every_page_no_overlay
                : R.string.horizontal_bar_every_page_on));
    }

    /**
     * The rows under "Widget horizontal bar" are shown only while it is on. The date is hidden in
     * landscape only: the portrait bar has no date. "Buttons beside the title" is shown only
     * while something (the cover, the date or the weather) is hidden (that is when the music widget has room to put them there), and
     * "Buttons in one line" only while the buttons are beside. "Title and artist arrangement"
     * and "Large text" are always shown. Their order is the order in creator_preferences.xml.
     */
    /** The rows of the horizontal bar and of the widget bar: hidden while "Display horizontal bar" is off. */
    private static final String[] HORIZONTAL_BAR_ROWS = {
            Keys.HORIZONTAL_BAR_TOP, Keys.HORIZONTAL_BAR_EVERY_PAGE, Keys.AUTO_HIDE_HORIZONTAL_BAR, "auto_hide_timeout",
            Keys.EDGE_HANDLE_RIGHT, "resizable_bottom_bar", "bottom_bar_height", "horizontal_bar_icons_title",
            "horizontal_bar_icons", "choose_bar_background", "choose_bar_tint", Keys.HORIZONTAL_BAR_ORDER,
            "widget_bar_separator", Keys.WIDGET_BAR, Keys.WIDGET_BAR_NO_COVER, Keys.WIDGET_BAR_NO_DATE,
            Keys.WIDGET_BAR_NO_WEATHER, Keys.WIDGET_BAR_NO_APPS, "widget_bar_fit_apps", Keys.WIDGET_BAR_BUTTONS_BESIDE,
            "widget_bar_buttons_one_line", "widget_bar_line_mode", "widget_bar_large_text",
            Keys.HORIZONTAL_BAR_NO_DRAWER, Keys.WIDGET_BAR_NO_MUSIC};

    /** How each bar row was shown before "Display horizontal bar" hid it; given back when the bar is shown again. */
    private final java.util.Map<String, Boolean> barRowsBefore = new java.util.HashMap<>();
    private CharSequence swipeUpSummaryOn;

    /**
     * "Display horizontal bar" (the owner, 2026-11-25; HorizontalBarPlacement): off, every row of the horizontal bar and
     * of the widget bar is hidden; on, each comes back as it was. Without the bar the swipe up is the way to the drawer
     * (DrawerAccess): its row is on and cannot be turned off, and says why.
     */
    /**
     * A bar with every part hidden (its drawer button too) is no bar: "Display horizontal bar" is turned off and a toast
     * says so (the owner's rule for E3 of round 28, BarShares.empty).
     */
    private void turnOffEmptyBar() {
        if (!sharedPrefs.getBoolean(Keys.DISPLAY_HORIZONTAL_BAR, true)
                || !sharedPrefs.getBoolean(Keys.HORIZONTAL_BAR_NO_DRAWER, false)
                || !sharedPrefs.getBoolean(Keys.WIDGET_BAR, false)) {
            return;   // the bar is off already, or its button or its apps list (without widgets) is there
        }
        boolean portrait = getResources().getConfiguration().orientation
                == android.content.res.Configuration.ORIENTATION_PORTRAIT;
        boolean empty = com.android.launcher66.BarShares.empty(portrait, true,
                WidgetBarPlan.appsHidden(true, true, sharedPrefs.getBoolean(Keys.WIDGET_BAR_NO_APPS, false)),
                sharedPrefs.getBoolean(Keys.WIDGET_BAR_NO_MUSIC, false),
                WidgetBarPlan.dateHidden(sharedPrefs.getBoolean(Keys.WIDGET_BAR_NO_DATE, false), portrait),
                sharedPrefs.getBoolean(Keys.WIDGET_BAR_NO_WEATHER, false));
        if (!empty) {
            return;
        }
        sharedPrefs.edit().putBoolean(Keys.DISPLAY_HORIZONTAL_BAR, false).apply();
        Preference display = findPreference(Keys.DISPLAY_HORIZONTAL_BAR);
        if (display instanceof TwoStatePreference) {
            ((TwoStatePreference) display).setChecked(false);
        }
        Toast.makeText(requireContext().getApplicationContext(), R.string.horizontal_bar_turned_off,
                Toast.LENGTH_LONG).show();
    }

    private void updateHorizontalBarRows() {
        boolean shown = sharedPrefs.getBoolean(Keys.DISPLAY_HORIZONTAL_BAR, true);
        for (String key : HORIZONTAL_BAR_ROWS) {
            Preference row = findPreference(key);
            if (row == null) {
                continue;
            }
            if (!shown) {
                if (!barRowsBefore.containsKey(key)) {
                    barRowsBefore.put(key, row.isVisible());
                }
                row.setVisible(false);
            } else if (barRowsBefore.containsKey(key)) {
                row.setVisible(Boolean.TRUE.equals(barRowsBefore.remove(key)));
            }
        }
        if (shown) {
            updateWidgetBarRows();
        }
        Preference swipe = findPreference(Keys.SWIPE_UP_APP_DRAWER);
        if (swipe instanceof TwoStatePreference) {
            TwoStatePreference row = (TwoStatePreference) swipe;
            if (swipeUpSummaryOn == null) {
                swipeUpSummaryOn = row.getSummaryOn();
            }
            if (com.android.launcher66.DrawerAccess.swipeUpRequired(shown,
                    sharedPrefs.getBoolean(Keys.HORIZONTAL_BAR_NO_DRAWER, false))) {
                row.setChecked(true);
                row.setEnabled(false);
                row.setSummaryOn(R.string.swipe_up_app_drawer_required);
            } else {
                row.setEnabled(true);
                row.setSummaryOn(swipeUpSummaryOn);
            }
        }
    }

    private void updateWidgetBarRows() {
        boolean widgetBar = sharedPrefs.getBoolean(Keys.WIDGET_BAR, false);
        boolean portrait = getResources().getConfiguration().orientation
                == android.content.res.Configuration.ORIENTATION_PORTRAIT;
        boolean noMusic = sharedPrefs.getBoolean(Keys.WIDGET_BAR_NO_MUSIC, false);
        Preference noMusicRow = findPreference(Keys.WIDGET_BAR_NO_MUSIC);
        if (noMusicRow != null) {
            noMusicRow.setVisible(widgetBar);
        }
        if (widgetBarNoCoverPreference != null) {
            // Without the music widget there is no cover to hide
            widgetBarNoCoverPreference.setVisible(widgetBar && !noMusic);
        }
        if (widgetBarNoDatePreference != null) {
            widgetBarNoDatePreference.setVisible(widgetBar && !portrait);
        }
        if (widgetBarNoWeatherPreference != null) {
            widgetBarNoWeatherPreference.setVisible(widgetBar);
        }
        boolean appsHidden = WidgetBarPlan.appsHidden(true, widgetBar,
                sharedPrefs.getBoolean(Keys.WIDGET_BAR_NO_APPS, false));
        if (widgetBarNoAppsPreference != null) {
            widgetBarNoAppsPreference.setVisible(widgetBar);
        }
        if (widgetBarFitAppsPreference != null) {
            widgetBarFitAppsPreference.setVisible(widgetBar && !appsHidden);
        }
        boolean dateHidden = WidgetBarPlan.dateHidden(
                sharedPrefs.getBoolean(Keys.WIDGET_BAR_NO_DATE, false), portrait);
        boolean weatherHidden = sharedPrefs.getBoolean(Keys.WIDGET_BAR_NO_WEATHER, false);
        boolean coverHidden = sharedPrefs.getBoolean(Keys.WIDGET_BAR_NO_COVER, false);
        boolean wide = WidgetBarPlan.wide(dateHidden, weatherHidden, coverHidden);
        if (widgetBarButtonsBesidePreference != null) {
            widgetBarButtonsBesidePreference.setVisible(widgetBar && wide);
        }
        if (widgetBarLargeTextPreference != null) {
            widgetBarLargeTextPreference.setVisible(widgetBar);
        }
        boolean beside = WidgetBarPlan.buttonsBeside(dateHidden, weatherHidden, coverHidden,
                sharedPrefs.getBoolean(Keys.WIDGET_BAR_BUTTONS_BESIDE, true));
        if (widgetBarLineModePreference != null) {
            widgetBarLineModePreference.setVisible(widgetBar);
        }
        if (widgetBarButtonsOneLinePreference != null) {
            widgetBarButtonsOneLinePreference.setVisible(widgetBar && beside);
        }
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
            } else if (p instanceof GridSeekBarPreference) {
                ((GridSeekBarPreference) p).setOnValueChangeListener(null);
            }

            if (p instanceof PreferenceGroup) {
                clearPreferenceListeners((PreferenceGroup) p);
            }
        }
    }

    /** The dialog of this screen opened with that key (TURN_DIALOGS); null when it is not open. */
    private Dialog turnDialog(String key) {
        switch (key) {
            case Keys.START_PAGE:
                return alertStartPageDialog;
            case Keys.LAYOUT_MARGIN:
                return alertMarginsDialog;
            case Keys.STATS_CODES:
                return alertCodesDialog;
            case Keys.EXTRA_STATS_CODES:
                return alertExtraCodesDialog;
            case Keys.SKIP_CODES:
                return alertSkipCodesDialog;
            case Keys.CODE_INSPECTOR_DATA:
                return alertCodesInspectorDialog;
            case Keys.CANBUS_LIBRARY_RESET:
                return libraryResetDialog;
            case TURN_LIBRARY_IMPORT_DONE:
                return libraryImportDoneDialog;
            case Keys.ALL_APPS_TEXT_SIZE:
            case Keys.WORKSPACE_TEXT_SIZE:
                return iconTextSizeRows != null ? iconTextSizeRows.openDialog(key) : null;
            case Keys.HORIZONTAL_BAR_ORDER:
                return barOrderDialog != null ? barOrderDialog.openDialog() : null;
            default:
                return null;
        }
    }

    /** What the dialog with that key was opened for: the message of an import's result. */
    private String turnArg(String key) {
        return TURN_LIBRARY_IMPORT_DONE.equals(key) ? libraryImportDoneMessage : null;
    }

    /**
     * The screen was created again for a turn: the dialog that was open is opened as before, with its texts. The
     * order of the bar's elements opens the list of the new orientation (moves not confirmed with OK are dropped).
     */
    private void reopenAfterTurn() {
        SettingsDialogMemory.Kept kept = SettingsDialogMemory.takeFor(2);
        if (kept == null || !isAdded()) {
            return;
        }
        if (TURN_LIBRARY_IMPORT_DONE.equals(kept.dialog)) {
            showLibraryImportDone(kept.arg);
        } else {
            DialogTurn.tap(findPreference(kept.dialog));
        }
        DialogTurn.fill(turnDialog(kept.dialog), kept.fields);
    }

    /** The colour pickers that came back with the screen after a turn: bound again, and closed with it for good. */
    private void rebindColorPickers() {
        if (!isAdded()) {
            return;
        }
        FragmentManager fragments = getParentFragmentManager();
        ColorPickerTargets.rebind(fragments, sharedPrefs, requireContext().getApplicationContext());
        ColorPicker stats = ColorPickerTargets.find(fragments, ColorPickerTargets.TAG_STATS);
        if (stats != null) {
            colorPicker = new WeakReference<>(stats);
        }
        ColorPicker tint = ColorPickerTargets.find(fragments, ColorPickerTargets.TAG_TINT);
        if (tint != null) {
            tintPicker = new WeakReference<>(tint);
        }
    }

    private void dismissDialogs() {
        // A DialogFragment comes back by itself after a turn of the screen: left open then. Removed without
        // executePendingTransactions(): called while the FragmentManager replaces this screen, that threw
        // "FragmentManager is already executing transactions"; the removal runs right after.
        boolean turning = getActivity() != null && getActivity().isChangingConfigurations();
        if (iconTextSizeRows != null) {
            iconTextSizeRows.dismiss();
        }
        if (barOrderDialog != null) {
            barOrderDialog.dismiss();
        }
        if (libraryImportDialog != null && libraryImportDialog.isShowing()) {
            // The work goes on without this screen (IMPORT, onDestroyView)
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
            if (!turning && dialog != null && dialog.isAdded()) {
                dialog.dismissAllowingStateLoss();
            }
            colorPicker = null;
        }
        if (tintPicker != null) {
            ColorPicker tintDialog = tintPicker.get();
            if (!turning && tintDialog != null && tintDialog.isAdded()) {
                tintDialog.dismissAllowingStateLoss();
            }
            tintPicker = null;
        }
        if (!turning) {
            // The background selector's picker, which this screen did not keep a reference to
            ColorPicker backgroundPicker = ColorPickerTargets.find(getParentFragmentManager(),
                    ColorPickerTargets.TAG_BACKGROUND);
            if (backgroundPicker != null) {
                backgroundPicker.dismissAllowingStateLoss();
            }
        }
        if (appListStatsDialog != null) {
            AppListStatsDialogFragment statsDialog = appListStatsDialog.get();
            if (!turning && statsDialog != null && statsDialog.isAdded()) {
                statsDialog.dismissAllowingStateLoss();
            }
            appListStatsDialog = null;
        }
        Fragment pipPicker = requireActivity()
                .getSupportFragmentManager()
                .findFragmentByTag(AppListPipDialogFragment.TAG);
        if (!turning && pipPicker instanceof AppListPipDialogFragment && pipPicker.isAdded()) {
            ((AppListPipDialogFragment) pipPicker).dismissAllowingStateLoss();
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
    
    /**
     * The row above a slider of the grid shows the number the slider is at: the rows or the columns of a
     * page without bars. The launcher builds its pages for the new grid when the settings are left.
     */
    /** The sliders of the app drawer's grid: the title says the number, as the home screen's do. */
    private void bindAppsGridSlider(String sliderKey, String titleKey, int titleRes) {
        AppsGridSeekBarPreference slider = findPreference(sliderKey);
        Preference title = findPreference(titleKey);
        if (slider == null || title == null) {
            return;
        }
        title.setTitle(getString(titleRes, slider.getValue()));
        slider.setOnValueChangeListener(value -> title.setTitle(getString(titleRes, value)));
    }

    private void bindGridSlider(String sliderKey, String titleKey, int titleRes) {
        GridSeekBarPreference slider = findPreference(sliderKey);
        Preference title = findPreference(titleKey);
        if (slider == null || title == null) {
            return;
        }
        title.setTitle(getString(titleRes, slider.getValue()));
        slider.setOnValueChangeListener(value -> title.setTitle(getString(titleRes, value)));
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

    private void barHeightSeekBarProgress(HorizontalBarHeightSeekBarPreference heightPreference) {
        // Called by the preference only when the user really moves the slider to a new value
        // (never when the row is bound); the value is then stored under Keys.HORIZONTAL_BAR_HEIGHT_PORT
        // or Keys.HORIZONTAL_BAR_HEIGHT_LAND, whichever matches the current orientation.
        heightPreference.setOnPreferenceChangeListener((preference, newValue) -> {
            helpers.setBarSettingsChanged(true);
            handler.post(updateBarHeightSummary);
            return true;
        });
    }

    /**
     * The rows of the vertical bar's width: the switch with the vertical bar, the slider with the switch too.
     */
    private void updateVerticalBarWidthRows() {
        boolean verticalBarOn = sharedPrefs.getBoolean(Keys.VERTICAL_BAR, false);
        boolean resizable = sharedPrefs.getBoolean(Keys.RESIZABLE_VERTICAL_BAR, false);
        if (resizableVerticalBarPreference != null) {
            resizableVerticalBarPreference.setVisible(verticalBarOn);
        }
        if (verticalBarWidthSeekBar != null) {
            verticalBarWidthSeekBar.setVisible(verticalBarOn && resizable);
        }
    }

    /**
     * The width of the vertical bar changed: the launcher's value is worked out again at once (the creators of
     * this process count with it), and the launcher builds its pages again when it comes back.
     */
    private void verticalBarWidthChanged() {
        com.android.launcher66.Launcher.refreshVerticalBarWidth(sharedPrefs);
        helpers.setBarSettingsChanged(true);
        updateVerticalBarWidthSummary.run();
    }

    private final Runnable updateVerticalBarWidthSummary = new Runnable() {
        @Override
        public void run() {
            if (resizableVerticalBarPreference == null || !isAdded()) {
                return;
            }
            boolean portrait = HorizontalBarDimensions.isPortrait(requireContext());
            float share = VerticalBarWidthSeekBarPreference.readShare(sharedPrefs, portrait);
            resizableVerticalBarPreference.setSummaryOn(getString(R.string.resizable_vertical_bar_summary,
                    HorizontalBarHeightSeekBarPreference.formatPercent(share),
                    getString(portrait
                            ? R.string.horizontal_bar_height_portrait
                            : R.string.horizontal_bar_height_landscape)));
        }
    };

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
            boolean portrait = HorizontalBarDimensions.isPortrait(requireContext());
            float multiplier = HorizontalBarDimensions.getConfiguredMultiplier(sharedPrefs, portrait);
            return getString(R.string.resizable_horizontal_bar_summary,
                    HorizontalBarHeightSeekBarPreference.formatPercent(multiplier),
                    getString(portrait
                            ? R.string.horizontal_bar_height_portrait
                            : R.string.horizontal_bar_height_landscape));
        }
    };

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
                // Every field, not only this one: Done closes the window
                if (saveCodesWindow != null) {
                    saveCodesWindow.run();
                } else {
                    saveCode(codesEditText);
                }
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
        } else {
            statsScreen.setVisible(false);
            statsCodes.setVisible(false);
            extraStatsCodes.setVisible(false);
            mainScreenStats.setVisible(false);
            colorPickerPref.setVisible(false);
            statsBg.setVisible(false);
            appList.setVisible(false);
            appStatsCoordinates.setVisible(false);
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
        AlertDialog.Builder builder = SettingsDialogs.builder(this.requireContext());
        builder.setTitle(R.string.start_page_str);
        if(startPageEditText.getParent() != null) {
            ((ViewGroup)startPageEditText.getParent()).removeView(startPageEditText);
        }
        builder.setView(startPageEditText);
        startPageEditText.setText(startPage.getSummary());
        SettingsDialogs.styleField(startPageEditText);
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveStartPage());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private AlertDialog.Builder displayMarginsDialog() {
        AlertDialog.Builder builder = SettingsDialogs.builder(this.requireContext());
        builder.setTitle(R.string.margins_str);
        if(marginEditText.getParent() != null) {
            ((ViewGroup)marginEditText.getParent()).removeView(marginEditText);
        }
        builder.setView(marginEditText);
        marginEditText.setText(margin.getSummary());
        SettingsDialogs.styleField(marginEditText);
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
        if (canbusLibraryExport != null) {
            canbusLibraryExport.setVisible(displayCanbusReaderBool);
            canbusLibraryExport.setEnabled(libraryImportJob == null && !libraryExportRunning);
        }
        if (statsCodes != null) {
            statsCodes.setSummary(statsCodesSummary());
        }
    }

    /** The export runs on the library's thread; the preference is off until it reports back. Main thread. */
    private boolean libraryExportRunning = false;

    private void exportCanbusLibrary() {
        if (libraryImportJob != null || libraryExportRunning) {
            return;
        }
        libraryExportRunning = true;
        updateCanbusLibraryPrefs();
        final Context app = LauncherApplication.sApp;
        CanbusLibraryExport.start(requireContext(), result -> {
            libraryExportRunning = false;
            if (isAdded()) {
                updateCanbusLibraryPrefs();
            }
            Toast.makeText(app, result.ok()
                    ? app.getString(R.string.canbus_library_export_done, result.path())
                    : app.getString(R.string.canbus_library_export_failed, result.error), Toast.LENGTH_LONG).show();
        });
    }

    private void onCanbusLibraryPicked(Uri uri) {
        if (uri == null || libraryImportJob != null || IMPORT.running() || !isAdded()) {
            return;
        }
        showCanbusLibraryImportDialog();
        libraryImportJob = CanbusLibraryImport.start(requireContext(), uri, IMPORT_TO_SCREEN);
        IMPORT.start(libraryImportJob, null, this);
        updateCanbusLibraryPrefs();
    }

    private void showCanbusLibraryImportDialog() {
        AlertDialog.Builder builder = SettingsDialogs.builder(requireContext());
        View dialogView = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_canbus_library_import, null);
        libraryImportStatus = dialogView.findViewById(R.id.canbus_library_import_status);
        libraryImportBar = dialogView.findViewById(R.id.canbus_library_import_progress);
        ConstraintLayout constraint = dialogView.findViewById(R.id.constraint_library_import);
        constraint.setPadding(padding, padding, padding, padding);
        setCalculatedSizes(dialogView, R.id.canbus_library_import_title, true, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.canbus_library_import_status, false, SettingsActivity.dialogMargin);

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
                IMPORT.toBackground();
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

    /**
     * The import's callbacks, on the main thread. They keep no screen: they ask IMPORT for the screen of now, which a
     * turn of the screen replaces (HandedWork). Package-private for its test.
     */
    static final CanbusLibraryImport.Listener IMPORT_TO_SCREEN = new CanbusLibraryImport.Listener() {
        @Override
        public void onProgress(int phase, int percent, int line, int totalLines) {
            // A phase without a percent keeps the bar where it was
            int[] last = IMPORT.lastProgress();
            int bar = percent >= 0 ? percent : (last != null ? last[1] : -1);
            IMPORT.progress(phase, bar, line, totalLines);
            SettingsFragmentSecond screen = IMPORT.screen();
            if (screen != null) {
                screen.showImportProgress(phase, percent, line, totalLines);
            }
        }

        @Override
        public void onSaving() {
            SettingsFragmentSecond screen = IMPORT.screen();
            if (screen != null) {
                screen.showImportSaving();
            }
        }

        @Override
        public void onFinished(CanbusLibraryImport.Outcome outcome) {
            SettingsFragmentSecond screen = IMPORT.screen();
            boolean background = IMPORT.inBackground();
            IMPORT.end();
            if (screen != null) {
                screen.onCanbusLibraryImportFinished(outcome, background);
            } else {
                importEndToast(outcome);
            }
        }
    };

    /** What the import is doing, in its dialog. */
    private void showImportProgress(int phase, int percent, int line, int totalLines) {
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

    /** Saving has begun: the import can no longer be cancelled. */
    private void showImportSaving() {
        if (libraryImportDialog != null && libraryImportDialog.isShowing()) {
            libraryImportDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setEnabled(false);
        }
    }

    /**
     * The screen is new (after a turn, or back on this screen): an import that goes on is this screen's again; its
     * rows stay off, and its dialog comes back with the last phase unless it was sent to the background (HandedWork).
     */
    private void takeOverImport() {
        if (!isAdded()) {
            return;
        }
        CanbusLibraryImport.Job job = IMPORT.join(this);
        if (job == null) {
            return;
        }
        libraryImportJob = job;
        updateCanbusLibraryPrefs();
        if (IMPORT.inBackground()) {
            return;
        }
        showCanbusLibraryImportDialog();
        int[] last = IMPORT.lastProgress();
        if (last != null && last.length == 4) {
            showImportProgress(last[0], last[1], last[2], last[3]);
        }
        if (job.isSaving()) {
            showImportSaving();
        }
    }

    private void onCanbusLibraryImportFinished(CanbusLibraryImport.Outcome outcome, boolean background) {
        libraryImportJob = null;
        // A screen that is gone behaves as "Run in background"
        final boolean showDialog = !background && isAdded() && libraryImportDialog != null;
        dismissCanbusLibraryImportDialog();
        if (isAdded()) {
            updateCanbusLibraryPrefs();
            initUserStats();
        }
        if (!showDialog || outcome.kind == CanbusLibraryImport.Kind.CANCELLED) {
            importEndToast(outcome);
            return;
        }
        final boolean success = outcome.kind == CanbusLibraryImport.Kind.SUCCESS;
        String report = outcome.reportPath() != null ? outcome.reportPath()
                : getString(R.string.canbus_library_report_not_saved);
        String message = success
                ? getString(R.string.canbus_library_import_done, outcome.added, outcome.duplicates, outcome.replaced, report)
                : getString(R.string.canbus_library_import_failed, outcome.firstError, report);
        showLibraryImportDone(message);
    }

    /** The end of an import as a toast: it was cancelled, or no dialog of a screen shows it. */
    private static void importEndToast(CanbusLibraryImport.Outcome outcome) {
        final Context app = LauncherApplication.sApp;
        if (outcome.kind == CanbusLibraryImport.Kind.CANCELLED) {
            Toast.makeText(app, R.string.canbus_library_cancelled, Toast.LENGTH_LONG).show();
            return;
        }
        final boolean success = outcome.kind == CanbusLibraryImport.Kind.SUCCESS;
        int text;
        if (outcome.reportFolder != null) {
            text = success ? R.string.canbus_library_toast_success : R.string.canbus_library_toast_failed;
            Toast.makeText(app, app.getString(text, outcome.reportFolder), Toast.LENGTH_LONG).show();
        } else {
            text = success ? R.string.canbus_library_toast_success_no_report : R.string.canbus_library_toast_failed_no_report;
            Toast.makeText(app, text, Toast.LENGTH_LONG).show();
        }
    }

    /** The result of an import: what was added, or why nothing was. */
    private void showLibraryImportDone(String message) {
        if (message == null || !isAdded()) {
            return;
        }
        libraryImportDoneMessage = message;
        libraryImportDoneDialog = SettingsDialogs.builder(requireContext())
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    private void confirmCanbusLibraryReset() {
        if (libraryImportJob != null) {
            return;
        }
        libraryResetDialog = SettingsDialogs.builder(requireContext())
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
        EditText speedCodeInt;
        EditText rpmCodeInt;
        AlertDialog.Builder builder = SettingsDialogs.builder(requireContext());
        // With the dialog's theme: the text is dark on its light background (with the settings' one it was white)
        View dialogView = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_codes_layout, null);

        fuelCodeInt = dialogView.findViewById(R.id.fuel_code_int);
        rangeCodeInt = dialogView.findViewById(R.id.range_code_int);
        speedCodeInt = dialogView.findViewById(R.id.speed_code_int);
        rpmCodeInt = dialogView.findViewById(R.id.rpm_code_int);
        cmdIntCodeInt = dialogView.findViewById(R.id.cmdInt_code_int);
        cmdArrCodeInt = dialogView.findViewById(R.id.cmdArr_code_int);

        ConstraintLayout constraintInspector = dialogView.findViewById(R.id.constraint_codes);
        constraintInspector.setPadding(padding, padding, padding, padding);

        setCalculatedSizes(dialogView, R.id.stats_dialog_title, true, SettingsActivity.dialogMargin);
        // A label may wrap; it takes at most a part of the window and the field the rest
        int labelWidth = Math.round(dialogWidth() * 0.4f);
        for (int id : new int[]{R.id.fuel_code_text, R.id.range_code_text, R.id.speed_code_text, R.id.rpm_code_text,
                R.id.cmdInt_code_text, R.id.cmdArr_code_text}) {
            setCalculatedSizes(dialogView, id, false, SettingsActivity.dialogMargin);
            ((TextView) dialogView.findViewById(id)).setMaxWidth(labelWidth);
        }
        setCalculatedSizes(dialogView, R.id.known_requests_text, false, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.codes_info_text, false, SettingsActivity.dialogMargin);

        dialogCodesEditText(fuelCodeInt);
        dialogCodesEditText(rangeCodeInt);
        dialogCodesEditText(speedCodeInt);
        dialogCodesEditText(rpmCodeInt);

        // Nothing written (or "0") means the code of the library (fuel, range) or of the code reader (speed):
        // empty field, that code as the hint
        ReaderGuesses reader = readerGuesses();
        showCode(fuelCodeInt, fuelCodeStr, libraryCode(true));
        showCode(rangeCodeInt, rangeCodeStr, libraryCode(false));
        showCode(speedCodeInt, speedCodeStr, reader != null ? reader.speed : -1);
        if (codeUnset(speedCodeStr) && (reader == null || reader.speed < 0)) {
            speedCodeInt.setHint(R.string.speed_code_gps);
        }
        showCode(rpmCodeInt, rpmCodeStr, reader != null ? reader.rpm : -1);
        for (EditText field : new EditText[]{fuelCodeInt, rangeCodeInt, speedCodeInt, rpmCodeInt}) {
            SettingsDialogs.styleField(field);
        }
        ((TextView) dialogView.findViewById(R.id.codes_info_text)).setText(codesInfoText(reader));

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
            SettingsDialogs.styleField(cmdIntCodeInt);
            SettingsDialogs.styleField(cmdArrCodeInt);
            ((TextView) dialogView.findViewById(R.id.known_requests_text)).setText(
                    getString(R.string.stats_codes_known_requests, CanbusLibrary.knownRequestsText(library, carId)));
        }

        final Runnable save = () -> {
                fuelCodeStr = fuelCodeInt.getText().toString();
                rangeCodeStr = rangeCodeInt.getText().toString();
                speedCodeStr = speedCodeInt.getText().toString();
                rpmCodeStr = rpmCodeInt.getText().toString();
                saveCode(fuelCodeInt);
                saveCode(rangeCodeInt);
                saveCode(speedCodeInt);
                saveCode(rpmCodeInt);
                if (needsRequest) {
                    saveCmdFields(cmdIntCodeInt, cmdArrCodeInt);
                }
            };
        saveCodesWindow = save;
        builder.setView(dialogView).setPositiveButton(R.string.set_btn, (dialog, which) -> save.run());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        builder.setOnCancelListener(dialog -> {
                save.run();
                dialog.dismiss();
            });
        builder.setOnDismissListener(dialog -> saveCodesWindow = null);
        return builder;
    }

    /**
     * The car's mass and engine displacement, optional: with them the estimate of the consumption starts from a car like
     * this one and is shown sooner. Built like the Canbus codes window.
     */
    private AlertDialog.Builder displayExtraCodesDialog() {
        AlertDialog.Builder builder = SettingsDialogs.builder(requireContext());
        View dialogView = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_extra_codes_layout, null);

        EditText vehicleMassInt = dialogView.findViewById(R.id.vehicle_mass_code_int);
        EditText engineDisplacementInt = dialogView.findViewById(R.id.engine_displacement_code_int);

        ConstraintLayout constraintExtra = dialogView.findViewById(R.id.constraint_extra);
        constraintExtra.setPadding(padding, padding, padding, padding);

        setCalculatedSizes(dialogView, R.id.canbus_optional, true, SettingsActivity.dialogMargin);
        // A label may wrap; it takes at most a part of the window and the field the rest
        int labelWidth = Math.round(dialogWidth() * 0.4f);
        for (int id : new int[]{R.id.vehicle_mass_code_text, R.id.engine_displacement_code_text}) {
            setCalculatedSizes(dialogView, id, false, SettingsActivity.dialogMargin);
            ((TextView) dialogView.findViewById(id)).setMaxWidth(labelWidth);
        }
        setCalculatedSizes(dialogView, R.id.canbus_optional_description, false, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.car_data_source, false, SettingsActivity.dialogMargin);

        dialogExtraCodesEditText(vehicleMassInt);
        dialogExtraCodesEditText(engineDisplacementInt);
        vehicleMassInt.setText(carDataUnset(Keys.VEHICLE_MASS) ? "" : sharedPrefs.getString(Keys.VEHICLE_MASS, ""));
        engineDisplacementInt.setText(carDataUnset(Keys.ENGINE_DISPLACEMENT) ? "" : sharedPrefs.getString(Keys.ENGINE_DISPLACEMENT, ""));
        vehicleMassInt.setHint("1300");
        engineDisplacementInt.setHint("1598");
        SettingsDialogs.styleField(vehicleMassInt);
        SettingsDialogs.styleField(engineDisplacementInt);

        final Runnable save = () -> {
            saveExtraCode(vehicleMassInt);
            saveExtraCode(engineDisplacementInt);
            // the model of the car takes the new values at once
            CanbusService.carDataChanged();
        };
        saveExtraCodesWindow = save;
        builder.setView(dialogView).setPositiveButton(R.string.set_btn, (dialog, which) -> save.run());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        builder.setOnCancelListener(dialog -> {
                save.run();
                dialog.dismiss();
            });
        builder.setOnDismissListener(dialog -> saveExtraCodesWindow = null);
        return builder;
    }

    /** A number field of the car data window: Done saves both fields and closes the window. */
    private void dialogExtraCodesEditText(EditText field) {
        field.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "99999")});
        field.setInputType(InputType.TYPE_CLASS_NUMBER);
        field.setImeOptions(EditorInfo.IME_ACTION_DONE);
        field.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (saveExtraCodesWindow != null) {
                    saveExtraCodesWindow.run();
                } else {
                    saveExtraCode(field);
                    CanbusService.carDataChanged();
                }
                alertExtraCodesDialog.dismiss();
            }
            return false;
        });
    }

    /** Saved under the name of the field's id, like the codes; empty is 0 (not given). */
    private void saveExtraCode(EditText field) {
        String valueStr = field.getText().toString().trim();
        if (valueStr.isEmpty()) valueStr = "0";
        editor.putString(field.getResources().getResourceEntryName(field.getId()), valueStr);
        editor.apply();
        if (extraStatsCodes != null) {
            extraStatsCodes.setSummary(extraStatsCodesSummary());
        }
    }

    /** Nothing, empty or 0 was given for a car datum. */
    private boolean carDataUnset(String key) {
        String saved = sharedPrefs.getString(key, "0");
        return saved == null || saved.trim().isEmpty() || saved.trim().equals("0");
    }

    private String extraStatsCodesSummary() {
        String notSet = getString(R.string.stats_codes_not_set);
        String mass = carDataUnset(Keys.VEHICLE_MASS) ? notSet : sharedPrefs.getString(Keys.VEHICLE_MASS, "").trim() + " kg";
        String displacement = carDataUnset(Keys.ENGINE_DISPLACEMENT) ? notSet
                : sharedPrefs.getString(Keys.ENGINE_DISPLACEMENT, "").trim() + " cm³";
        return getString(R.string.extra_stats_codes_summary, mass, displacement);
    }

    /** The width the codes window gets: most of the screen, so that a label and its field fit side by side. */
    private int dialogWidth() {
        android.util.DisplayMetrics dm = getResources().getDisplayMetrics();
        boolean landscape = dm.widthPixels > dm.heightPixels;
        return Math.round(dm.widthPixels * (landscape ? 0.85f : 0.95f));
    }

    /** After show(): the window takes {@link #dialogWidth()}; its height follows the content (it scrolls). */
    private void fitDialogWindow(AlertDialog dialog) {
        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(dialogWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    /** The codes the code reader found for this car, or null. */
    private ReaderGuesses readerGuesses() {
        int carId = DataCanbus.DATA[1000];
        return carId == 0 ? null : ReaderGuesses.parse(sharedPrefs.getString(ReaderGuesses.key(carId), null));
    }

    /** What an empty field uses, and the codes the reader found for this car. */
    private String codesInfoText(ReaderGuesses reader) {
        String text = getString(R.string.stats_codes_empty_fields);
        CodePairChooser.Status pairs = libraryPairs();
        if (pairs != null) {
            text += "\n" + getString(R.string.stats_codes_pairs_line, pairs.pairsText(),
                    CodePairChooser.pairText(pairs.pair()),
                    getString(pairs.confirmed ? R.string.stats_codes_pair_confirmed : R.string.stats_codes_pair_unconfirmed));
        }
        if (reader != null && !reader.codesText().isEmpty()) {
            text += "\n" + getString(R.string.stats_codes_reader_line, reader.dateText(), reader.codesText());
        }
        return text;
    }

    private AlertDialog.Builder displaySkipCodesDialog() {
        AlertDialog.Builder builder = SettingsDialogs.builder(this.requireContext());
        builder.setTitle(R.string.skip_codes_dialog_str);
        if(skipCodesEditText.getParent() != null) {
            ((ViewGroup)skipCodesEditText.getParent()).removeView(skipCodesEditText);
        }
        builder.setView(skipCodesEditText);
        Set<String> skipCodesSet = sharedPrefs.getStringSet(Keys.SKIP_CODES, Collections.singleton(""));
        String skipCodesStr = skipCodesSet != null ? String.join(", ", skipCodesSet) : "";
        skipCodesEditText.setText(skipCodesStr);
        SettingsDialogs.styleField(skipCodesEditText);
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveSkipCodes());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private AlertDialog.Builder displayCodesInspectorDialog() {
        AlertDialog.Builder builder = SettingsDialogs.builder(requireContext());
        View dialogView = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_inspector_codes_layout, null);

        inspectorTimeoutEdit = dialogView.findViewById(R.id.code_inspector_timeout);

        ConstraintLayout constraintInspector = dialogView.findViewById(R.id.constraint_inspector);
        constraintInspector.setPadding(padding, padding, padding, padding);

        setCalculatedSizes(dialogView, R.id.code_inspector_data_title, true, SettingsActivity.dialogMargin);
        setCalculatedSizes(dialogView, R.id.code_inspector_timeout_text, false, SettingsActivity.dialogMargin);

        dialogCodesInspectorEditText(inspectorTimeoutEdit);
        inspectorTimeoutEdit.setText(codeInspectorTimeoutStr);
        SettingsDialogs.styleField(inspectorTimeoutEdit);

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

    /** A text of a dialog at the size of the settings' rows (DialogText), a title a quarter larger, and its margin. */
    private void setCalculatedSizes(View view, int textViewId, boolean title, int margin) {
        TextView textView = view.findViewById(textViewId);
        if (title) {
            DialogText.title(textView);
        } else {
            DialogText.body(textView);
        }

        if (textView.getLayoutParams() instanceof ConstraintLayout.LayoutParams params) {
            if (textViewId == R.id.code_inspector_data_title
             || textViewId == R.id.canbus_library_import_title
             || textViewId == R.id.stats_dialog_title) {
                params.bottomMargin = margin;
            } else {
                params.topMargin = margin;
            }
            textView.setLayoutParams(params);
        }
    }

    /**
     * The pages the start page may name now (StartPageRule.knownPages): those of the launcher and those the
     * elements switched on in this visit will add. 0 while the launcher's pages are not known yet.
     */
    private int knownPages() {
        WorkspaceScreenPlan.Snapshot snapshot = LauncherModel.getScreenSnapshot();
        if (snapshot == null || !snapshot.isReady()) {
            return 0;
        }
        int highest = 0;
        for (CustomElement element : CustomElement.values()) {
            if (sharedPrefs.getBoolean(element.enabledKey, element.defaultEnabled)) {
                highest = Math.max(highest, sharedPrefs.getInt(element.screenKey, 1));
            }
        }
        return StartPageRule.knownPages(snapshot.pageCount(), highest);
    }

    private void saveStartPage() {
        int typed = StartPageRule.parse(startPageEditText.getText().toString());
        if (typed < StartPageRule.FIRST_PAGE) {
            typed = StartPageRule.FIRST_PAGE;   // empty or not a number, as before: the first page
        }
        int pages = knownPages();
        if (pages > 0 && !StartPageRule.accepts(typed, pages)) {
            // A page that does not exist is refused: the stored page and the summary stay as they are
            Log.i("SettingsFragmentSecond", "Start page " + typed + " refused: the home screen has " + pages + " pages");
            Toast.makeText(requireContext().getApplicationContext(), getString(R.string.start_page_missing, typed, pages),
                    Toast.LENGTH_LONG).show();
            return;
        }
        String valueStr = String.valueOf(typed);
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
        // The running service chooses its codes again; it used to read them only when it started
        CanbusService.readerGuessesChanged();
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

    /**
     * The code the library gives this car, fuel or range, or -1: that of the pair the radio reports when the library
     * has several (the choice of CanbusService, else the one saved, else the first).
     */
    private int libraryCode(boolean fuel) {
        CodePairChooser.Status status = libraryPairs();
        if (status == null) {
            return -1;
        }
        CanbusLibrary.CarCodes codes = status.pair();
        return fuel ? codes.fuel : codes.range;
    }

    /** The pairs of the library for this car and the one in use; null if the library has none. */
    private CodePairChooser.Status libraryPairs() {
        CanbusLibrary.Library library = CanbusLibrary.cached();
        int carId = DataCanbus.DATA[1000];
        if (library == null || carId == 0) {
            return null;
        }
        CodePairChooser.Status running = CanbusService.pairStatus(carId);
        if (running != null) {
            return running;
        }
        List<CanbusLibrary.CarCodes> pairs = library.codePairsFor(carId);
        if (pairs.isEmpty()) {
            return null;
        }
        CanbusLibrary.CarCodes saved = CodePairChooser.decode(sharedPrefs.getString(CodePairChooser.key(carId), null));
        int at = saved == null ? -1 : pairs.indexOf(saved);
        return new CodePairChooser.Status(pairs, Math.max(at, 0), at >= 0);
    }

    /** A saved code in its field; none (or "0") leaves the field empty, with the code used then as the hint. */
    private void showCode(EditText field, String saved, int automaticCode) {
        if (codeUnset(saved)) {
            field.setText("");
            if (automaticCode >= 0) {
                field.setHint(String.valueOf(automaticCode));
            }
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
        String speedAndRpm = getString(R.string.stats_codes_summary_speed_rpm, speedForSummary(),
                rpmForSummary());
        if (!carNeedsRequest()) {
            return getString(R.string.stats_codes_summary_no_request, fuel, range) + speedAndRpm;
        }
        CanbusLibrary.Request user = CanbusLibrary.userRequest(sharedPrefs);
        String request = user != null ? user.toString()
                : getString(R.string.stats_codes_request_auto,
                        CanbusLibrary.firstRequest(CanbusLibrary.cached(), DataCanbus.DATA[1000]));
        return getString(R.string.stats_codes_summary_request, fuel, range, request) + speedAndRpm;
    }

    /** The RPM code for the summary: the one written, else the code reader's ("513 (reader)"), else not set. */
    private String rpmForSummary() {
        String saved = sharedPrefs.getString("rpm_code_int", "0");
        if (!codeUnset(saved)) {
            return saved;
        }
        ReaderGuesses reader = readerGuesses();
        return reader != null && reader.rpm >= 0
                ? getString(R.string.stats_codes_reader_code, String.valueOf(reader.rpm))
                : getString(R.string.stats_codes_not_set);
    }

    /** The speed code for the summary: the one written, else the code reader's ("510 (reader)"), else the GPS. */
    private String speedForSummary() {
        String saved = sharedPrefs.getString(Keys.SPEED_CODE, "0");
        if (!codeUnset(saved)) {
            return saved;
        }
        ReaderGuesses reader = readerGuesses();
        return reader != null && reader.speed >= 0
                ? getString(R.string.stats_codes_reader_code, String.valueOf(reader.speed))
                : getString(R.string.speed_code_gps);
    }

    /**
     * Saves the cmd fields of the Canbus codes window: empty stays empty (the first screen's request is
     * sent), cmdArr is written as plain numbers ("74,3"). A bad text is not saved, with a toast.
     */
    private void saveCmdFields(EditText cmdInt, EditText cmdArr) {
        String cmd = cmdInt.getText().toString().trim();
        int[] ints = CanbusLibrary.parseInts(cmdArr.getText().toString());
        if (ints == null || (!cmd.isEmpty() && !cmd.matches("[0-9]{1,4}"))) {
            Toast.makeText(this.requireContext().getApplicationContext(), R.string.stats_codes_cmd_invalid, Toast.LENGTH_LONG).show();
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
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, CreatorScreen.newInstance(selectedScreen)).commit();
    }
}
