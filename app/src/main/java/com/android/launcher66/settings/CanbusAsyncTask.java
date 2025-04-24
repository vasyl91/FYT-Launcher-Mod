package com.android.launcher66.settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.R;
import com.syu.canbus.FuncMain;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.FinalShare;

public class CanbusAsyncTask extends AsyncTask<Void, Void, Void> {

	// Runs the canbus service in background
	
    private final Context mContext;
    private final SharedPreferences mPrefs;

    public CanbusAsyncTask(Context context) {
        this.mContext = context;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    protected Void doInBackground(Void[] input) throws Exception {
    	launchCanbus();
        return null;
    }

    @Override
    protected void onBackgroundError(Exception e) {
    	launchCanbus();
    }
    
    public void launchCanbus() {
        boolean userStats = mPrefs.getBoolean("user_stats", false);
        boolean userLayout = mPrefs.getBoolean("user_layout", false);
        if (userLayout && userStats) {
            if (DataCanbus.DATA[1000] == 76 || DataCanbus.DATA[1000] == 67) {
                if (DataCanbus.DATA[11] != 13 && DataCanbus.DATA[11] != 14 && FinalShare.CUSTOMER_ID != 31) {
                    FuncMain.tips(this.mContext.getString(R.string.vehicle_not_exist));
                    return;
                } else {
                    startCanbusService();
                    return;
                }
            }
            startCanbusService();
        }
        
    }

    public void startCanbusService() {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
	        Intent intent = new Intent(this.mContext, CanbusService.class);
	        Bundle extras = new Bundle();
	        extras.putInt("fuel", Integer.parseInt(mPrefs.getString("fuel_code_int", "0")));
	        extras.putInt("range", Integer.parseInt(mPrefs.getString("range_code_int", "0")));
	        extras.putInt("rpm", Integer.parseInt(mPrefs.getString("rpm_code_int", "0")));
	        extras.putInt("cmdInt", Integer.parseInt(mPrefs.getString("cmdInt_code_int", "0")));
	        extras.putInt("cmdArr", Integer.parseInt(mPrefs.getString("cmdArr_code_int", "0")));
	        intent.putExtras(extras);
	        this.mContext.startService(intent);
        }, 1000);
    }
}