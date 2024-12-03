package com.android.launcher66.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
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
import com.android.launcher66.R;

public class CreatorFragmentFirst extends PreferenceFragmentCompat implements Preference.OnPreferenceClickListener, HomeWatcher.OnHomePressedListener {

    private SharedPreferences sharedPrefs;
    private HomeWatcher mHomeWatcher;
    private static final String LEFT_BAR = "left_bar";
    private static final String USER_DATE = "user_date";
    private static final String USER_MUSIC = "user_music";
    private static final String USER_RADIO = "user_radio";
    private static final String MARGIN = "layout_margin";
    private static final String CREATOR_SECOND = "launcher_creator_second";
    private Preference margin;
    private EditText editText;
    private AlertDialog alertDialog;

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
        if (margin != null) {
            margin.setOnPreferenceClickListener(this);
        }
        if (launcherCreatorSecond != null) {
            launcherCreatorSecond.setOnPreferenceClickListener(this);
        }
    }

    @Override
    public boolean onPreferenceClick(@NonNull Preference preference) {
        switch (preference.getKey()) {
            case LEFT_BAR:
                boolean leftBarBool = sharedPrefs.getBoolean(LEFT_BAR, false);
                Helpers.leftBarHasChanged = leftBarBool;
                break;
            case CREATOR_SECOND:
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFragmentSecond()).commit();
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
        builder.setTitle("Margins (max. 25)");
        if(editText.getParent() != null) {
            ((ViewGroup)editText.getParent()).removeView(editText);
        }
        builder.setView(editText);
        editText.setText(margin.getSummary());
        builder.setPositiveButton("Set", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveMargin();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
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