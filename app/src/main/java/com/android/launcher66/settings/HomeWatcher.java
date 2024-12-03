package com.android.launcher66.settings;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;

import com.jakewharton.processphoenix.ProcessPhoenix;


public class HomeWatcher {

    private final Context mContext;
    private final IntentFilter mFilter;
    private OnHomePressedListener mListener;
    private InnerRecevier mRecevier;

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

    public void startWatch() {
        if (mRecevier != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                mContext.registerReceiver(mRecevier, mFilter, Context.RECEIVER_EXPORTED);
            } else {
                mContext.registerReceiver(mRecevier, mFilter, Context.RECEIVER_NOT_EXPORTED);
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
                            Helpers.backFromCreator = false;
                            ProcessPhoenix.triggerRebirth(context);
                        }
                    }
                }
            }
        }
    }
}