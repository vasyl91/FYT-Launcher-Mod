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
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreferenceCompat;

import com.android.launcher66.R;
import com.android.launcher66.colorpicker.ColorPicker;

public class CreatorFragmentFirst extends PreferenceFragmentCompat implements Preference.OnPreferenceClickListener, HomeWatcher.OnHomePressedListener {

    private static final String USER_DATE = "user_date";
    private static final String USER_MUSIC = "user_music";
    private static final String USER_RADIO = "user_radio";    
    private static final String USER_STATS = "user_stats";
    private static final String COLOR_PICKER = "color_picker";
    private static final String STATS_BG = "stats_bg";
    private static final String BG_DRAWABLE = "bg_drawable";
    private static final String BG_COLOR = "bg_color";
    private static final String BG_COLOR_PICKER = "bg_color_picker";
    private static final String APP_LIST = "app_list";
    private static final String APP_STATS_COORDINATES = "app_stats_coordinates";
    private static final String LEFT_BAR = "left_bar";
    private static final String LAYOUT_MARGIN = "layout_margin";
    private static final String CREATOR_SECOND = "launcher_creator_second";
    private static final String SHOW_AGAIN = "show_again";
    private String can;
    private int defaultColorR = 255;
    private int defaultColorG = 255;
    private int defaultColorB = 255;
    private int bgDefaultColorR = 255;
    private int bgDefaultColorG = 255;
    private int bgDefaultColorB = 255; 
    private boolean userStatsBool = false;
    private boolean showAgain = false;  
    private boolean backgroundBool = false;
    private boolean drawableBgBool = false;
    private boolean colorBgBool = false;    
    private SharedPreferences sharedPrefs;
    private HomeWatcher mHomeWatcher;    
    private SwitchPreferenceCompat userStats;
    private SwitchPreferenceCompat bgDrawable;
    private SwitchPreferenceCompat bgColor;
    private Preference statsBg;
    private Preference colorPickerPref;
    private Preference bgColorPickerPref;
    private Preference appList;
    private Preference appStatsCoordinates;    
    private Preference margin;
    private EditText editText;
    private AlertDialog alertDialog;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        mHomeWatcher = new HomeWatcher(getActivity());
        mHomeWatcher.setOnHomePressedListener(this);
        mHomeWatcher.startWatch();
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.requireContext());
        addPreferencesFromResource(R.xml.creator_preferences);
        Preference leftBar = findPreference(LEFT_BAR);
        Preference userDate = findPreference(USER_DATE);
        Preference userMusic = findPreference(USER_MUSIC);
        Preference userRadio = findPreference(USER_RADIO); 
        Preference launcherCreatorSecond = findPreference(CREATOR_SECOND);
        
        userStats = findPreference(USER_STATS); 
        colorPickerPref = findPreference(COLOR_PICKER);        
        statsBg = findPreference(STATS_BG); 
        bgDrawable = findPreference(BG_DRAWABLE);
        bgColor = findPreference(BG_COLOR);
        bgColorPickerPref = findPreference(BG_COLOR_PICKER); 
        appList = findPreference(APP_LIST);
        appStatsCoordinates = findPreference(APP_STATS_COORDINATES);
        margin = findPreference(LAYOUT_MARGIN);
        String marginStr = sharedPrefs.getString(LAYOUT_MARGIN, "10");
        margin.setSummary(marginStr);

        defaultColorR = sharedPrefs.getInt("red", 255);
        defaultColorG = sharedPrefs.getInt("green", 255);
        defaultColorB = sharedPrefs.getInt("blue", 255);
        bgDefaultColorR = sharedPrefs.getInt("bg_red", 255);
        bgDefaultColorG = sharedPrefs.getInt("bg_green", 255);
        bgDefaultColorB = sharedPrefs.getInt("bg_blue", 255);

        dialogEditText();

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
        showAgain = sharedPrefs.getBoolean(SHOW_AGAIN, true);
        if (colorPickerPref != null) {
            colorPickerPref.setVisible(statsAndAgainBool());
            colorPickerPref.setOnPreferenceClickListener(this);
        }
        if (statsBg != null) {
            statsBg.setVisible(statsAndAgainBool());
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
            appList.setVisible(statsAndAgainBool());
            appList.setOnPreferenceClickListener(this);
        } 
        if (appStatsCoordinates != null) {
            appStatsCoordinates.setVisible(statsAndAgainBool());
            appStatsCoordinates.setOnPreferenceClickListener(this);
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
            can = sharedPrefs.getString("canbus_class", "empty");
            if (!can.equals("empty")) {
                userStats.setVisible(true);
                userStats.setSummary(getString(R.string.stats_window_summary, can));
                userStats.setOnPreferenceClickListener(this);
            } else {              
                userStats.setChecked(false);
                userStats.setVisible(false);
            }
        }        
    }

    private void dialogEditText() {
        editText = new EditText(this.getContext());
        editText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "25")});
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        editText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveMargin();
                alertDialog.dismiss();
            }
            return false;
        });
    }

    @Override
    public boolean onPreferenceClick(@NonNull Preference preference) {
        userStatsBool = sharedPrefs.getBoolean(USER_STATS, false);
        showAgain = sharedPrefs.getBoolean(SHOW_AGAIN, true);
        backgroundBool = sharedPrefs.getBoolean(STATS_BG, false);
        drawableBgBool = sharedPrefs.getBoolean(BG_DRAWABLE, false);
        colorBgBool = sharedPrefs.getBoolean(BG_COLOR, false);
        switch (preference.getKey()) {
            case USER_STATS:
                userStatsSwitch();
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
            case LEFT_BAR:
                Helpers.leftBarHasChanged = sharedPrefs.getBoolean(LEFT_BAR, false);
                break;
            case LAYOUT_MARGIN:
                alertDialog = displayDialog().create();
                alertDialog.show();
                Button negativeButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(0, 0, 80, 0);
                negativeButton.setLayoutParams(params);
                editText.requestFocus();
                InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
                editText.setSelection(editText.getText().length());
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
        if (userStatsBool && showAgain) {
            AlertDialog alertDialogStats = displayDialogStats().create();
            alertDialogStats.show();
            Button negativeButton = alertDialogStats.getButton(AlertDialog.BUTTON_NEGATIVE);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 80, 0);
            negativeButton.setLayoutParams(params);
        }
        if (statsAndAgainBool()) {
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
            colorPickerPref.setVisible(false);
            statsBg.setVisible(false);
            appList.setVisible(false);
            appStatsCoordinates.setVisible(false);
            bgDrawable.setVisible(false);
            bgColor.setVisible(false);
            bgColorPickerPref.setVisible(false);
        }          
    }

    private boolean statsAndAgainBool() {
        return userStatsBool && !showAgain;
    }

    private boolean statsBackgroundBool() {
        return userStatsBool && !showAgain && backgroundBool;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Helpers.backFromCreator = true;
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public void onStop() {
        super.onStop();
        mHomeWatcher.setOnHomePressedListener(null);
        mHomeWatcher.stopWatch();
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

    private AlertDialog.Builder displayDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext());
        builder.setTitle(R.string.margins_title);
        if(editText.getParent() != null) {
            ((ViewGroup)editText.getParent()).removeView(editText);
        }
        builder.setView(editText);
        editText.setText(margin.getSummary());
        builder.setPositiveButton(R.string.set_btn, (dialog, which) -> saveMargin());
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());
        return builder;
    }

    private AlertDialog.Builder displayDialogStats() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.requireContext());
        builder.setTitle(R.string.stats_dialog_title);
        builder.setMessage(getString(R.string.stats_dialog_message) + can);
        builder.setPositiveButton(R.string.alert_stats_pos, (dialog, which) -> {
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putBoolean(SHOW_AGAIN, false);
            editor.apply();
            colorPickerPref.setVisible(true);
            statsBg.setVisible(true);
            if (backgroundBool) {
                bgDrawable.setVisible(true);
                bgColor.setVisible(true);
                appList.setVisible(true);
                appStatsCoordinates.setVisible(true);
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
                appList.setVisible(false);
                appStatsCoordinates.setVisible(false);
                bgColorPickerPref.setVisible(false);
            }
        });
        builder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> {
            userStats.setChecked(false);
            dialog.dismiss();
        });
        builder.setOnCancelListener(dialog -> {
            userStats.setChecked(false);
            dialog.dismiss();
        });
        return builder;
    }

    private void saveMargin() {
        margin.setSummary(String.valueOf(editText.getText()));
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(LAYOUT_MARGIN, String.valueOf(editText.getText()));
        editor.apply();
    }
}