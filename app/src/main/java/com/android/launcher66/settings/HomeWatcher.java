package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.preference.PreferenceManager;

public class HomeWatcher {

    // This class allows to do specified actions while user presses the home button
    
    private static final String USER_LAYOUT = "user_layout";
    private static final String USER_INIT_LAYOUT = "user_init_layout";
    private final Context mContext;
    private final IntentFilter mFilter;
    private OnHomePressedListener mListener;
    private InnerRecevier mRecevier;
    private Helpers helpers = new Helpers();

    public interface OnHomePressedListener {
        //
    }

    public HomeWatcher(Context context) {
        mContext = context;
        mRecevier = new InnerRecevier();
        mFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
    }

    public void setOnHomePressedListener(OnHomePressedListener listener) {
        mListener = listener;
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public void startWatch() {
        if (mRecevier != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                mContext.registerReceiver(mRecevier, mFilter, Context.RECEIVER_EXPORTED);
            } else {
                mContext.registerReceiver(mRecevier, mFilter);
            }
        }
    }

    public void stopWatch() {
        if (mRecevier != null) {
            mContext.unregisterReceiver(mRecevier);
            mRecevier = null;//
        }
    }
    class InnerRecevier extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_KEY = "reason";
        final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
                String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
                if (reason != null) {
                    if (mListener != null) {
                        if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {                         
                            helpers.setBackFromCreator(false);
                            SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
                            boolean initLayout = sharedPrefs.getBoolean(USER_INIT_LAYOUT, false);
                            boolean userLayoutBool = sharedPrefs.getBoolean(USER_LAYOUT, false);
                            if (initLayout != userLayoutBool) {
                                helpers.setLayoutTypeChanged(true);
                            }
                            Intent intentUpdateUserPage = new Intent("update.user.page");
                            context.sendBroadcast(intentUpdateUserPage);  
                        }
                    }
                }
            }
        }
    }
}