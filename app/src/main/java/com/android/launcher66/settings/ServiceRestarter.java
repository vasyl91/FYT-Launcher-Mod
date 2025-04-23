package com.android.launcher66.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.preference.PreferenceManager;

public class ServiceRestarter extends BroadcastReceiver {
    private static final String TAG = "ServiceRestarter";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Canbus service Stops!");
        try {
            Helpers helpers = new Helpers();
            if (helpers.displayStateBoolean()) {
                startCanbusService(context);
            }
        } catch (Exception e) {
            Log.e(TAG, "Restarting service caused an error: " + e.getMessage());
        }
    }

    private void startCanbusService(Context context) {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        Intent intent = new Intent(context, CanbusService.class);
        Bundle extras = new Bundle();
        extras.putInt("fuel", Integer.parseInt(mPrefs.getString("fuel_code_int", "0")));
        extras.putInt("range", Integer.parseInt(mPrefs.getString("range_code_int", "0")));
        extras.putInt("rpm", Integer.parseInt(mPrefs.getString("rpm_code_int", "0")));
        extras.putInt("cmdInt", Integer.parseInt(mPrefs.getString("cmdInt_code_int", "0")));
        extras.putInt("cmdArr", Integer.parseInt(mPrefs.getString("cmdArr_code_int", "0")));
        intent.putExtras(extras);
        context.startService(intent);
    }
}