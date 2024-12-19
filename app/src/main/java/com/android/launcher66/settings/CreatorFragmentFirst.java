package com.android.launcher66.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreferenceCompat;

import com.android.launcher66.R;
import com.android.launcher66.colorpicker.ColorPicker;
import com.android.launcher66.colorpicker.ColorPickerCallback;

public class CreatorFragmentFirst extends PreferenceFragmentCompat implements Preference.OnPreferenceClickListener, HomeWatcher.OnHomePressedListener {

    private SharedPreferences sharedPrefs;
    private HomeWatcher mHomeWatcher;
    private static final String LEFT_BAR = "left_bar";
    private static final String USER_DATE = "user_date";
    private static final String USER_MUSIC = "user_music";
    private static final String USER_RADIO = "user_radio";
    private static final String USER_STATS = "user_stats";
    private static final String COLOR_PICKER = "color_picker";
    private static final String STATS_BG = "stats_bg";
    private static final String MARGIN = "layout_margin";
    private static final String CREATOR_SECOND = "launcher_creator_second";
    private Preference margin;
    private EditText editText;
    private AlertDialog alertDialog;
    private SwitchPreferenceCompat userStats;
    private boolean userStatsBool = false;
    private boolean showAgain = false;
    private AlertDialog alertDialogStats;
    private String can;
    private Preference colorPickerPref;
    private Preference statsBg;
    private ColorPicker colorPicker;
    private int defaultColorR = 255;
    private int defaultColorG = 255;
    private int defaultColorB = 255;
    private static final String BG_DRAWABLE = "bg_drawable";
    private static final String BG_COLOR = "bg_color";
    private static final String BG_COLOR_PICKER = "bg_color_picker";
    private SwitchPreferenceCompat bgDrawable;
    private SwitchPreferenceCompat bgColor;
    private Preference bgColorPickerPref;
    private ColorPicker bgColorPicker;
    private int bgDefaultColorR = 255;
    private int bgDefaultColorG = 255;
    private int bgDefaultColorB = 255;   
    private boolean backgroundBool = false;
    private boolean drawableBgBool = false;
    private boolean colorBgBool = false;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        mHomeWatcher = new HomeWatcher(getActivity());
        mHomeWatcher.setOnHomePressedListener(this);
        mHomeWatcher.startWatch();
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        addPreferencesFromResource(R.xml.creator_preferences);
        Preference leftBar = findPreference(LEFT_BAR);
        Preference userDate = findPreference(USER_DATE);
        Preference userMusic = findPreference(USER_MUSIC);
        Preference userRadio = findPreference(USER_RADIO); 
        
        userStats = findPreference(USER_STATS); 
        colorPickerPref = findPreference(COLOR_PICKER);
        defaultColorR = sharedPrefs.getInt("red", 255);
        defaultColorG = sharedPrefs.getInt("green", 255);
        defaultColorB = sharedPrefs.getInt("blue", 255);        
        statsBg = findPreference(STATS_BG); 
        bgDrawable = findPreference(BG_DRAWABLE);
        bgColor = findPreference(BG_COLOR);
        bgColorPickerPref = findPreference(BG_COLOR_PICKER);
        bgDefaultColorR = sharedPrefs.getInt("bg_red", 255);
        bgDefaultColorG = sharedPrefs.getInt("bg_green", 255);
        bgDefaultColorB = sharedPrefs.getInt("bg_blue", 255); 
        margin = findPreference(MARGIN);

        String marginStr = sharedPrefs.getString("layout_margin", "10");
        margin.setSummary(marginStr);
        editText = new EditText(this.getContext());
        editText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "25")});
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    saveMargin();
                    alertDialog.dismiss();
                }
                return false;
            }
        });

        Preference launcherCreatorSecond = findPreference(CREATOR_SECOND);

        if (leftBar != null) {
            leftBar.setOnPreferenceClickListener(this);
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
        if (userStats != null) {
            can = sharedPrefs.getString("canbus_class", "empty");
            if (!can.equals("empty")) {
                userStats.setVisible(true);
                userStats.setSummary(getString(R.string.stats_window_summary) + can + getString(R.string.stats_window_summary_second));
                userStats.setOnPreferenceClickListener(this);
            } else {              
                userStats.setChecked(false);
                userStats.setVisible(false);
            }
        }
        userStatsBool = sharedPrefs.getBoolean(USER_STATS, false);
        showAgain = sharedPrefs.getBoolean("show_again", true);
        if (colorPickerPref != null) {
            if (userStatsBool && !showAgain) {
                colorPickerPref.setVisible(true);
            } else {
                colorPickerPref.setVisible(false);
            }
            colorPickerPref.setOnPreferenceClickListener(this);
        }
        if (statsBg != null) {
            if (userStatsBool && !showAgain) {
                statsBg.setVisible(true);
            } else {
                statsBg.setVisible(false);
            }
            statsBg.setOnPreferenceClickListener(this);
        }
        backgroundBool = sharedPrefs.getBoolean(STATS_BG, false);
        if (bgDrawable != null) {
            if (userStatsBool && !showAgain && backgroundBool) {
                bgDrawable.setVisible(true);
            } else {
                bgDrawable.setVisible(false);
            }
            bgDrawable.setOnPreferenceClickListener(this);
        }
        if (bgColor != null) {
            if (userStatsBool && !showAgain && backgroundBool) {
                bgColor.setVisible(true);
            } else {
                bgColor.setVisible(false);
            }
            bgColor.setOnPreferenceClickListener(this);
        }
        if (bgColorPickerPref != null) {
            Boolean colorBgBool = sharedPrefs.getBoolean(BG_COLOR, false);
            if (userStatsBool && !showAgain && backgroundBool && colorBgBool) {
                bgColorPickerPref.setVisible(true);
            } else {
                bgColorPickerPref.setVisible(false);
            }
            bgColorPickerPref.setOnPreferenceClickListener(this);
        }  
        if (margin != null) {
            margin.setOnPreferenceClickListener(this);
        }
        if (launcherCreatorSecond != null) {
            launcherCreatorSecond.setOnPreferenceClickListener(this);
        }
    }

    @Override
    public boolean onPreferenceClick(@NonNull Preference preference) {
        userStatsBool = sharedPrefs.getBoolean(USER_STATS, false);
        showAgain = sharedPrefs.getBoolean("show_again", true);
        backgroundBool = sharedPrefs.getBoolean(STATS_BG, false);
        drawableBgBool = sharedPrefs.getBoolean(BG_DRAWABLE, false);
        colorBgBool = sharedPrefs.getBoolean(BG_COLOR, false);
        switch (preference.getKey()) {
            case LEFT_BAR:
                boolean leftBarBool = sharedPrefs.getBoolean(LEFT_BAR, false);
                Helpers.leftBarHasChanged = leftBarBool;
                break;
            case CREATOR_SECOND:
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFragmentSecond()).commit();
                break;
            case USER_STATS:
                if (userStatsBool && showAgain) {
                    alertDialogStats = displayDialogStats().create();
                    alertDialogStats.show();
                    Button negativeButton = alertDialogStats.getButton(AlertDialog.BUTTON_NEGATIVE);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    params.setMargins(0, 0, 80, 0);
                    negativeButton.setLayoutParams(params);
                }
                if (userStatsBool && !showAgain) {
                    colorPickerPref.setVisible(true);
                    statsBg.setVisible(true);
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
                    bgDrawable.setVisible(false);
                    bgColor.setVisible(false);
                    bgColorPickerPref.setVisible(false);
                }                  
                break;
            case COLOR_PICKER:
                colorPicker = new ColorPicker(getActivity(), defaultColorR, defaultColorG, defaultColorB);
                colorPicker.enableAutoClose();
                colorPicker.setCallback(new ColorPickerCallback() {
                    @Override
                    public void onColorChosen(int color) {
                        defaultColorR = Color.red(color);
                        defaultColorG = Color.green(color);
                        defaultColorB = Color.blue(color);
                        SharedPreferences.Editor editor = sharedPrefs.edit();
                        editor.putString("stats_color", String.format("#%06X", (0xFFFFFF & color)));
                        editor.putInt("red", Color.red(color));
                        editor.putInt("green", Color.green(color));
                        editor.putInt("blue", Color.blue(color));
                        editor.apply();
                    }
                });
                colorPicker.show();
                break;
            case STATS_BG:            
                if (backgroundBool) {
                    bgDrawable.setVisible(true);
                    bgColor.setVisible(true);
                } else {
                    bgDrawable.setVisible(false);
                    bgColor.setVisible(false);
                    bgColorPickerPref.setVisible(false);
                }                  
                break;
            case BG_DRAWABLE:
                if (drawableBgBool) {
                    bgColor.setChecked(false);
                    bgColorPickerPref.setVisible(false);
                } else {
                    bgColor.setChecked(true);
                    bgColorPickerPref.setVisible(true);
                }              
                break;
            case BG_COLOR:              
                if (colorBgBool) {       
                    bgDrawable.setChecked(false);
                    bgColorPickerPref.setVisible(true);
                } else {
                    bgDrawable.setChecked(true);
                    bgColorPickerPref.setVisible(false);
                }             
                break;
            case BG_COLOR_PICKER:
                bgColorPicker = new ColorPicker(getActivity(), bgDefaultColorR, bgDefaultColorG, bgDefaultColorB);
                bgColorPicker.enableAutoClose();
                bgColorPicker.setCallback(new ColorPickerCallback() {
                    @Override
                    public void onColorChosen(int color) {
                        bgDefaultColorR = Color.red(color);
                        bgDefaultColorG = Color.green(color);
                        bgDefaultColorB = Color.blue(color);
                        SharedPreferences.Editor editor = sharedPrefs.edit();
                        editor.putString("bg_stats_color", String.format("#%06X", (0xFFFFFF & color)));
                        editor.putInt("bg_red", Color.red(color));
                        editor.putInt("bg_green", Color.green(color));
                        editor.putInt("bg_blue", Color.blue(color));
                        editor.apply();
                    }
                });
                bgColorPicker.show();                
                break;
            case MARGIN:
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
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
                editText.setSelection(editText.getText().length());
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
                Helpers.backFromCreator = true;
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
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

    private AlertDialog.Builder displayDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle(R.string.margins_title);
        if(editText.getParent() != null) {
            ((ViewGroup)editText.getParent()).removeView(editText);
        }
        builder.setView(editText);
        editText.setText(margin.getSummary());
        builder.setPositiveButton(R.string.set_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveMargin();
            }
        });
        builder.setNegativeButton(R.string.cancel_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder;
    }

    private AlertDialog.Builder displayDialogStats() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle(R.string.stats_dialog_title);
        builder.setMessage(getString(R.string.stats_dialog_message) + can);
        builder.setPositiveButton(R.string.alert_stats_pos, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.putBoolean("show_again", false);             
                editor.commit();
                colorPickerPref.setVisible(true);
                statsBg.setVisible(true);
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
            }
        });
        builder.setNegativeButton(R.string.cancel_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                userStats.setChecked(false);
                dialog.dismiss();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                userStats.setChecked(false);
                dialog.dismiss();
            }
        });
        return builder;
    }

    private void saveMargin() {
        margin.setSummary(String.valueOf(editText.getText()));
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("layout_margin", String.valueOf(editText.getText()));             
        editor.commit();
    }
}