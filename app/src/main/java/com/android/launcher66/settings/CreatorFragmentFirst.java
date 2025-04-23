package com.android.launcher66.settings;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreferenceCompat;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.colorpicker.ColorPicker;

public class CreatorFragmentFirst extends PreferenceFragmentCompat implements Preference.OnPreferenceClickListener {

    // Fragment for the second window in the settings - Layout creator

    private static final String USER_MAP = "user_map";
    private static final String USER_DATE = "user_date";
    private static final String USER_MUSIC = "user_music";
    private static final String USER_RADIO = "user_radio";    
    private static final String USER_STATS = "user_stats";
    private static final String STATS_CODES = "stats_codes";
    private static final String EXTRA_STATS_CODES = "extra_stats_codes";
    private static final String MAIN_SCREEN_STATS = "main_screen_stats";
    private static final String COLOR_PICKER = "color_picker";
    private static final String STATS_BG = "stats_bg";
    private static final String BG_DRAWABLE = "bg_drawable";
    private static final String BG_COLOR = "bg_color";
    private static final String BG_COLOR_PICKER = "bg_color_picker";
    private static final String APP_LIST = "app_list";
    private static final String APP_STATS_COORDINATES = "app_stats_coordinates";
    private static final String LEFT_BAR = "left_bar";
    private static final String START_PAGE = "start_page";
    private static final String LAYOUT_MARGIN = "layout_margin";
    private static final String PIP_SCREEN = "pip_screen";
    private static final String CREATOR_SECOND = "launcher_creator_second";
    private int defaultColorR = 255;
    private int defaultColorG = 255;
    private int defaultColorB = 255;
    private int bgDefaultColorR = 255;
    private int bgDefaultColorG = 255;
    private int bgDefaultColorB = 255;
    private boolean mapBool = true; 
    private boolean userStatsBool = false;
    private boolean backgroundBool = false;
    private boolean drawableBgBool = false;
    private boolean colorBgBool = false;    
    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor editor;
    private final Helpers helpers = new Helpers();
    private SwitchPreferenceCompat userStats;
    private Preference statsCodes;
    private EditText fuelCodeInt;
    private EditText rangeCodeInt;
    private EditText cmdIntCodeInt;
    private EditText cmdArrCodeInt;
    private String fuelCodeStr;
    private String rangeCodeStr;
    private String cmdIntCodeStr;
    private String cmdArrCodeStr;
    private Preference extraStatsCodes; 
    private EditText rpmCodeInt;
    private EditText horsePowerCodeInt;
    private EditText vehicleMassCodeInt;
    private EditText engineVolCodeInt;
    private EditText numberOfCylindersCodeInt;
    private String rpmCodeStr;
    private String horsePowerCodeStr;
    private String vehicleMassCodeStr;
    private String engineVolCodeStr;
    private String numberOfCylindersCodeStr;
    private SwitchPreferenceCompat mainScreenStats;
    private SwitchPreferenceCompat bgDrawable;
    private SwitchPreferenceCompat bgColor;
    private Preference pipScreen;
    private Preference statsBg;
    private Preference colorPickerPref;
    private Preference bgColorPickerPref;
    private Preference appList;
    private Preference appStatsCoordinates;    
    private Preference margin;
    private EditText pipEditText;
    private EditText marginEditText;
    private AlertDialog alertPipDialog;
    private AlertDialog alertMarginsDialog;
    private AlertDialog alertCodesDialog;
    private AlertDialog alertExtraCodesDialog;
    private Preference startPage;
    private EditText startPageEditText;
    private AlertDialog alertStartPageDialog;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.requireContext());
        editor = sharedPrefs.edit();
        addPreferencesFromResource(R.xml.creator_preferences);
        Preference leftBar = findPreference(LEFT_BAR);

        Preference userMap = findPreference(USER_MAP);
        pipScreen = findPreference(PIP_SCREEN);
        String pipScreenStr = sharedPrefs.getString(PIP_SCREEN, "1");
        pipScreen.setSummary(pipScreenStr);

        Preference userDate = findPreference(USER_DATE);
        Preference userMusic = findPreference(USER_MUSIC);
        Preference userRadio = findPreference(USER_RADIO); 
        Preference launcherCreatorSecond = findPreference(CREATOR_SECOND);
        
        userStats = findPreference(USER_STATS); 
        statsCodes = findPreference(STATS_CODES); 
        fuelCodeStr = sharedPrefs.getString("fuel_code_int", "0");
        rangeCodeStr = sharedPrefs.getString("range_code_int", "0");
        cmdIntCodeStr = sharedPrefs.getString("cmdInt_code_int", "0");
        cmdArrCodeStr = sharedPrefs.getString("cmdArr_code_int", "0");
        extraStatsCodes = findPreference(EXTRA_STATS_CODES);
        rpmCodeStr = sharedPrefs.getString("rpm_code_int", "0");
        horsePowerCodeStr = sharedPrefs.getString("horse_power_code_int", "0");
        vehicleMassCodeStr = sharedPrefs.getString("vehicle_mass_code_int", "0");
        engineVolCodeStr = sharedPrefs.getString("engine_volume_code_int", "0");
        numberOfCylindersCodeStr = sharedPrefs.getString("cylinders_number_code_int", "0");

        mainScreenStats = findPreference(MAIN_SCREEN_STATS); 
        colorPickerPref = findPreference(COLOR_PICKER);        
        statsBg = findPreference(STATS_BG); 
        bgDrawable = findPreference(BG_DRAWABLE);
        bgColor = findPreference(BG_COLOR);
        bgColorPickerPref = findPreference(BG_COLOR_PICKER); 
        appList = findPreference(APP_LIST);
        appStatsCoordinates = findPreference(APP_STATS_COORDINATES);

        startPage = findPreference(START_PAGE);
        String startPageStr = sharedPrefs.getString(START_PAGE, "1");
        startPage.setSummary(startPageStr);

        margin = findPreference(LAYOUT_MARGIN);
        String marginStr = sharedPrefs.getString(LAYOUT_MARGIN, "10");
        margin.setSummary(marginStr);

        defaultColorR = sharedPrefs.getInt("red", 255);
        defaultColorG = sharedPrefs.getInt("green", 255);
        defaultColorB = sharedPrefs.getInt("blue", 255);
        bgDefaultColorR = sharedPrefs.getInt("bg_red", 255);
        bgDefaultColorG = sharedPrefs.getInt("bg_green", 255);
        bgDefaultColorB = sharedPrefs.getInt("bg_blue", 255);

        dialogPipEditText();
        dialogStartPageEditText();
        dialogMarginEditText();

        if (userMap != null) {
            userMap.setOnPreferenceClickListener(this);
        } 
        mapBool = sharedPrefs.getBoolean(USER_MAP, true);
        if (pipScreen != null) {
            pipScreen.setVisible(mapBool);
            pipScreen.setOnPreferenceClickListener(this);
        }
        if (userDate != null) {
            userDate.setOnPreferenceClickListener(this);
        }
        if (userMusic != null) {
            userMusic.setOnPreferenceClickListener(this);
        }
        if (userRadio != null) {
            userRadio.setOnPreferenceClickListener(this);
        }
        initUserStats();
        userStatsBool = sharedPrefs.getBoolean(USER_STATS, false);
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
        backgroundBool = sharedPrefs.getBoolean(STATS_BG, false);
        if (bgDrawable != null) {
            bgDrawable.setVisible(statsBackgroundBool());
            bgDrawable.setOnPreferenceClickListener(this);
        }
        if (bgColor != null) {
            bgColor.setVisible(statsBackgroundBool());
            bgColor.setOnPreferenceClickListener(this);
        }
        if (bgColorPickerPref != null) {
            colorBgBool = sharedPrefs.getBoolean(BG_COLOR, false);
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
        if (startPage != null) {
            startPage.setOnPreferenceClickListener(this);
        }
        if (leftBar != null) {
            leftBar.setOnPreferenceClickListener(this);
        } 
        if (margin != null) {
            margin.setOnPreferenceClickListener(this);
        }
        if (launcherCreatorSecond != null) {
            launcherCreatorSecond.setOnPreferenceClickListener(this);
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

    private void dialogPipEditText() {
        pipEditText = new EditText(this.getContext());
        pipEditText.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "99")});
        pipEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        pipEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        pipEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                savePip();
                alertPipDialog.dismiss();
            }
            return false;
        });
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
        EditText finalCodesEditText = codesEditText;
        codesEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveCode(finalCodesEditText);
                alertCodesDialog.dismiss();
            }
            return false;
        });
    }

    private void dialogExtraCodesEditText(EditText codesEditText) {
        codesEditText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "9999")});
        codesEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        codesEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        EditText finalCodesEditText = codesEditText;
        codesEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveExtraCode(finalCodesEditText);
                alertExtraCodesDialog.dismiss();
            }
            return false;
        });
    }

    @Override
    public boolean onPreferenceClick(@NonNull Preference preference) {
        userStatsBool = sharedPrefs.getBoolean(USER_STATS, false);
        backgroundBool = sharedPrefs.getBoolean(STATS_BG, false);
        drawableBgBool = sharedPrefs.getBoolean(BG_DRAWABLE, false);
        colorBgBool = sharedPrefs.getBoolean(BG_COLOR, false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 80, 0);
        InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        switch (preference.getKey()) {
            case USER_MAP:
                mapBool = sharedPrefs.getBoolean(USER_MAP, true);
                pipScreen.setVisible(mapBool);
                break;
            case PIP_SCREEN:
                alertPipDialog = displayPipDialog().create();
                alertPipDialog.show();
                Button negativePipButton = alertPipDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                negativePipButton.setLayoutParams(params);
                pipEditText.requestFocus();
                imm.showSoftInput(pipEditText, InputMethodManager.SHOW_IMPLICIT);
                pipEditText.setSelection(pipEditText.getText().length());
                break;
            case USER_STATS:
                userStatsSwitch();
                break;
            case STATS_CODES:
                alertCodesDialog = displayCodesDialog().create();
                alertCodesDialog.show();
                Button negativeCodesButton = alertCodesDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                negativeCodesButton.setLayoutParams(params);
                fuelCodeInt.requestFocus();
                imm.showSoftInput(fuelCodeInt, InputMethodManager.SHOW_IMPLICIT);
                fuelCodeInt.setSelection(fuelCodeInt.getText().length());
                break;
            case EXTRA_STATS_CODES:
                alertExtraCodesDialog = displayExtraCodesDialog().create();
                alertExtraCodesDialog.show();
                Button negativeExtraCodesButton = alertExtraCodesDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                negativeExtraCodesButton.setLayoutParams(params);
                rpmCodeInt.requestFocus();
                imm.showSoftInput(rpmCodeInt, InputMethodManager.SHOW_IMPLICIT);
                rpmCodeInt.setSelection(rpmCodeInt.getText().length());
                break;
            case COLOR_PICKER:
                ColorPicker colorPicker = new ColorPicker(requireActivity(), defaultColorR, defaultColorG, defaultColorB);
                colorPicker.enableAutoClose();
                colorPicker.setCallback(color -> {
                    defaultColorR = Color.red(color);
                    defaultColorG = Color.green(color);
                    defaultColorB = Color.blue(color);
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString("stats_color", String.format("#%06X", (0xFFFFFF & color)));
                    editor.putInt("red", Color.red(color));
                    editor.putInt("green", Color.green(color));
                    editor.putInt("blue", Color.blue(color));
                    editor.apply();
                });
                colorPicker.show();
                break;
            case STATS_BG:            
                bgDrawable.setVisible(backgroundBool);
                bgColor.setVisible(backgroundBool);
                bgColorPickerPref.setVisible(backgroundBool && colorBgBool);                 
                break;
            case BG_DRAWABLE:
                bgColor.setChecked(!drawableBgBool);
                bgColorPickerPref.setVisible(!drawableBgBool);             
                break;
            case BG_COLOR:             
                bgDrawable.setChecked(!colorBgBool);
                bgColorPickerPref.setVisible(colorBgBool);           
                break;
            case BG_COLOR_PICKER:
                ColorPicker bgColorPicker = new ColorPicker(requireActivity(), bgDefaultColorR, bgDefaultColorG, bgDefaultColorB);
                bgColorPicker.enableAutoClose();
                bgColorPicker.setCallback(color -> {
                    bgDefaultColorR = Color.red(color);
                    bgDefaultColorG = Color.green(color);
                    bgDefaultColorB = Color.blue(color);
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString("bg_stats_color", String.format("#%06X", (0xFFFFFF & color)));
                    editor.putInt("bg_red", Color.red(color));
                    editor.putInt("bg_green", Color.green(color));
                    editor.putInt("bg_blue", Color.blue(color));
                    editor.apply();
                });
                bgColorPicker.show();                
                break;
            case APP_LIST:
                Log.i("checkStatsPermission()", String.valueOf(checkStatsPermission()));
                if (checkStatsPermission()) {
                    new AppListStatsDialogFragment().show(requireActivity().getSupportFragmentManager(), "");
                } else {
                    Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
                    startActivity(intent);
                }
                break;
            case APP_STATS_COORDINATES:
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFragmentAppStats()).commit();
                break;
            case START_PAGE:
                alertStartPageDialog = displayStartPageDialog().create();
                alertStartPageDialog.show();
                Button negativeButtonPage = alertStartPageDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                negativeButtonPage.setLayoutParams(params);
                startPageEditText.requestFocus();
                imm.showSoftInput(startPageEditText, InputMethodManager.SHOW_IMPLICIT);
                startPageEditText.setSelection(startPageEditText.getText().length());
                break;
            case LEFT_BAR:
                helpers.setLeftBarChanged(true);
                break;
            case LAYOUT_MARGIN:
                alertMarginsDialog = displayMarginsDialog().create();
                alertMarginsDialog.show();
                Button negativeButtonMargin = alertMarginsDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                negativeButtonMargin.setLayoutParams(params);
                marginEditText.requestFocus();
                imm.showSoftInput(marginEditText, InputMethodManager.SHOW_IMPLICIT);
                marginEditText.setSelection(marginEditText.getText().length());
                break;
            case CREATOR_SECOND:
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFragmentSecond()).commit();
                break;
            default:
                break;
        }
        return false;
    }

    private void userStatsSwitch() {
        if (userStatsBool) {
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

    private boolean statsBackgroundBool() {
        return userStatsBool && backgroundBool;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                helpers.setBackFromCreator(true);     
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
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

    private AlertDialog.Builder displayPipDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(R.string.pip_dialog_str);
        if(pipEditText.getParent() != null) {
            ((ViewGroup)pipEditText.getParent()).removeView(pipEditText);
        }
        builder.setView(pipEditText);
        pipEditText.setText(pipScreen.getSummary());
        pipEditText.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> savePip());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private AlertDialog.Builder displayStartPageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(R.string.start_page_str);
        if(startPageEditText.getParent() != null) {
            ((ViewGroup)startPageEditText.getParent()).removeView(startPageEditText);
        }
        builder.setView(startPageEditText);
        startPageEditText.setText(startPage.getSummary());
        startPageEditText.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
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
        marginEditText.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveMargin());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private AlertDialog.Builder displayCodesDialog() {
        LayoutInflater inflater = LayoutInflater.from(this.requireContext());
        View dialogView = inflater.inflate(R.layout.dialog_codes_layout, null);

        fuelCodeInt = dialogView.findViewById(R.id.fuel_code_int);
        rangeCodeInt = dialogView.findViewById(R.id.range_code_int);
        cmdIntCodeInt = dialogView.findViewById(R.id.cmdInt_code_int);
        cmdArrCodeInt = dialogView.findViewById(R.id.cmdArr_code_int);
        
        dialogCodesEditText(fuelCodeInt);
        dialogCodesEditText(rangeCodeInt);
        dialogCodesEditText(cmdIntCodeInt);
        dialogCodesEditText(cmdArrCodeInt);

        fuelCodeInt.setText(fuelCodeStr);
        rangeCodeInt.setText(rangeCodeStr);
        cmdIntCodeInt.setText(cmdIntCodeStr);
        cmdArrCodeInt.setText(cmdArrCodeStr);

        fuelCodeInt.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        rangeCodeInt.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        cmdIntCodeInt.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        cmdArrCodeInt.setTextColor(ContextCompat.getColor(getContext(), R.color.black));

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
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> {
                dialog.dismiss();
            });
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
        LayoutInflater inflater = LayoutInflater.from(this.requireContext());
        View dialogView = inflater.inflate(R.layout.dialog_extra_codes_layout, null);

        rpmCodeInt = dialogView.findViewById(R.id.rpm_code_int);
        horsePowerCodeInt = dialogView.findViewById(R.id.horse_power_code_int);
        vehicleMassCodeInt = dialogView.findViewById(R.id.vehicle_mass_code_int);
        engineVolCodeInt = dialogView.findViewById(R.id.engine_volume_code_int);
        numberOfCylindersCodeInt = dialogView.findViewById(R.id.cylinders_number_code_int);

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

        rpmCodeInt.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        horsePowerCodeInt.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        vehicleMassCodeInt.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        engineVolCodeInt.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        numberOfCylindersCodeInt.setTextColor(ContextCompat.getColor(getContext(), R.color.black));

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
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> {
                dialog.dismiss();
            });
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

    private void savePip() {
        pipScreen.setSummary(pipEditText.getText().toString());
        editor.putString(PIP_SCREEN, pipEditText.getText().toString());
        editor.apply();
    }

    private void saveStartPage() {
        startPage.setSummary(startPageEditText.getText().toString());
        editor.putString(START_PAGE, startPageEditText.getText().toString());
        editor.apply();
    }

    private void saveMargin() {
        margin.setSummary(marginEditText.getText().toString());
        editor.putString(LAYOUT_MARGIN, marginEditText.getText().toString());
        editor.apply();
    }

    private void saveCode(EditText code) {
        editor.putString(code.getResources().getResourceEntryName(code.getId()), code.getText().toString());
        editor.apply();
        statsCodes.setSummary(getString(R.string.stats_codes_summary, 
            sharedPrefs.getString("fuel_code_int", "0"), 
            sharedPrefs.getString("range_code_int", "0"), 
            sharedPrefs.getString("cmdInt_code_int", "0"), 
            sharedPrefs.getString("cmdArr_code_int", "0")));
    }    

    private void saveExtraCode(EditText code) {
        editor.putString(code.getResources().getResourceEntryName(code.getId()), code.getText().toString());
        editor.apply();
        extraStatsCodes.setSummary(getString(R.string.extra_stats_codes_summary,  
            sharedPrefs.getString("rpm_code_int", "0"),
            sharedPrefs.getString("horse_power_code_int", "0"), 
            sharedPrefs.getString("vehicle_mass_code_int", "0"), 
            sharedPrefs.getString("engine_volume_code_int", "0"), 
            sharedPrefs.getString("cylinders_number_code_int", "0")));
    }
}