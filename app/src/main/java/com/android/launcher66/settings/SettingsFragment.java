package com.android.launcher66.settings;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.syu.util.WindowUtil;
import com.jakewharton.processphoenix.ProcessPhoenix;

public class SettingsFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceClickListener, HomeWatcher.OnHomePressedListener {

    private SharedPreferences sharedPrefs;
    private HomeWatcher mHomeWatcher;
    private Context mContext;
    private static final String USER_LAYOUT = "user_layout";
    private static final String CREATOR_FIRST = "launcher_creator_first";
    private static final String STATUSBAR = "transparent_statusbar";
    private static final String FYT_DATA = "fyt_data";    
    private static final String NOTI = "noti_settings";
    private boolean initLayout;
    private boolean userLayoutBool;
    private boolean initStatusbar;
    private boolean userStatusbarBool;
    private boolean initFyt;
    private boolean userFytBool;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        this.mContext = this.getContext();
        mHomeWatcher = new HomeWatcher(getActivity());
        mHomeWatcher.setOnHomePressedListener(this);
        mHomeWatcher.startWatch();
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        initLayout = sharedPrefs.getBoolean(USER_LAYOUT, false);
        initStatusbar = sharedPrefs.getBoolean(STATUSBAR, false);
        initFyt = sharedPrefs.getBoolean(FYT_DATA, false);
        addPreferencesFromResource(R.xml.launcher_preferences);
        Preference userLayout = findPreference(USER_LAYOUT);
        Preference launcherCreatorFirst = findPreference(CREATOR_FIRST);
        Preference transparentStatusbar = findPreference(STATUSBAR);
        Preference fytData = findPreference(FYT_DATA);
        Preference noti = findPreference(NOTI);

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
        if (noti != null) {
            noti.setOnPreferenceClickListener(this);
        }
    }

    @Override
    public boolean onPreferenceClick(@NonNull Preference preference) {
        switch (preference.getKey()) {
            case USER_LAYOUT:
                userLayoutBool = sharedPrefs.getBoolean(preference.getKey(), false);
                getPreferenceScreen().findPreference(CREATOR_FIRST).setEnabled(userLayoutBool);
                break;
            case CREATOR_FIRST:
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFragmentFirst()).commit();
                break;
            case NOTI:
                Intent intentNoti = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                intentNoti.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentNoti.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intentNoti.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                startActivity(intentNoti);
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
                if ((initLayout != userLayoutBool) || initStatusbar != userStatusbarBool || initFyt != userFytBool || Helpers.backFromCreator) {
                    Helpers.backFromCreator = false;
                    WindowUtil.restartPipApp();
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(startMain);
                    ProcessPhoenix.triggerRebirth(mContext);
                } else {
                    Helpers.firstPreferenceWindow = true;
                    getActivity().finish();                    
                }
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
}