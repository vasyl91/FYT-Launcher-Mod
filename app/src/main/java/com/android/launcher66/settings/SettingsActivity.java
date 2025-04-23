package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class SettingsActivity extends AppCompatActivity {

    // Settings main activity 

    private static final String USER_LAYOUT = "user_layout";
    private static final String USER_INIT_LAYOUT = "user_init_layout";
    static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    private final Helpers helpers = new Helpers(); 
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startWatch();

        // determine class likely containing canbus codes
        SharedPreferences mPrefs = getSharedPreferences("HelpersPrefs", Context.MODE_PRIVATE);
        String can = mPrefs.getString("canbus_class", "empty");
        if (can.equals("empty")) {
            new CanbusClasses().execute();
        }
        helpers.setSettingsOpenedBoolean(true);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();       
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public void startWatch() {
        IntentFilter mFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        if (mReceiver != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                registerReceiver(mReceiver, mFilter, Context.RECEIVER_EXPORTED);
            } else {
                registerReceiver(mReceiver, mFilter);
            }
        }
    }

    public void stopWatch() {
        if (mReceiver != null) {
            unregisterReceiver(mReceiver);
        }
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override 
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(action)) {
                String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
                if (SYSTEM_DIALOG_REASON_HOME_KEY.equals(reason)) {
                    stopWatch();
                    Log.i("Home Receiver", "home clicked"); 
                    helpers.setBackFromCreator(false);
                    SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
                    boolean initLayout = sharedPrefs.getBoolean(USER_INIT_LAYOUT, false);
                    boolean userLayoutBool = sharedPrefs.getBoolean(USER_LAYOUT, false);
                    if (initLayout != userLayoutBool) {
                        helpers.setLayoutTypeChanged(true);
                    }
                    helpers.setSettingsOpenedBoolean(false);
                    Intent intentUpdateUserPage = new Intent("update.user.page");
                    context.sendBroadcast(intentUpdateUserPage);
                }
            }
        }
    };
}