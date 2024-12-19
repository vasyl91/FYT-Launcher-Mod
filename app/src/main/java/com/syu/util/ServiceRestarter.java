package com.syu.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.preference.PreferenceManager;

public class ServiceRestarter extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(ServiceRestarter.class.getSimpleName(), "Canbus service Stops!");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String className = prefs.getString("canbus_class", "empty");
        try {
            if (!className.equals("empty")) {
                Class<?> klazz = Class.forName(className);
                context.startService(new Intent(context, klazz));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}