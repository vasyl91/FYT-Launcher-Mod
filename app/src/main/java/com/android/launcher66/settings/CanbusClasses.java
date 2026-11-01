package com.android.launcher66.settings;

import android.content.SharedPreferences;

import com.android.async.AsyncTask;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Finds the class of FYT's canbus app that serves the user's car, for Fuel statistics to name. The name comes
 * only from {@link CanbusLibrary}: the built-in library with the one the user imported merged in. The built-in
 * one is made by canbus_library/build_canbus_library.py --launcher from its own asset (the classes) and from
 * decompiled_carinfo (the pages); to add a car to it, add a C record to the asset and run the script.
 */
public class CanbusClasses extends AsyncTask<Void, Void, Void> {

	// Checks if there is an existing class for user's car model

    public CanbusClasses() {
    }

    @Override
    protected Void doInBackground(Void[] input) throws Exception {
    	determineClassName();
        return null;
    }

    @Override
    protected void onProgress(Void[] progress) {
        //
    }

    @Override
    protected void onBackgroundError(Exception e) {
        // Posted to the main thread, where the library must not be read: once more on its own thread
        CanbusLibrary.executor().execute(this::determineClassName);
    }
    
    public void determineClassName() {
        int carId = DataCanbus.DATA[1000];
        if (hasNoScreenOfItsOwn(carId)) {
            // These cars have no screen of their own to name: the unit's settings are opened
            // instead, and nothing is saved.
            DataCanbus.PROXY.cmd(2, new int[]{241, 255}, null, null);
            return;
        }
        saveClassName(carId);
    }

    /**
     * The name again after the library changed (an import, a reset), without opening the unit's settings
     * for the cars that have no screen of their own. Off the main thread.
     */
    static void refresh() {
        int carId = DataCanbus.DATA[1000];
        if (!hasNoScreenOfItsOwn(carId)) {
            new CanbusClasses().saveClassName(carId);
        }
    }

    private static boolean hasNoScreenOfItsOwn(int carId) {
        return carId == 411 || carId == FinalCanbus.CAR_WC2_LandRover_H /* 65947 */;
    }

    private void saveClassName(int carId) {
        // Off the main thread, as the AsyncTask runs it: the library reads its files.
        String name = CanbusLibrary.loadBlocking(LauncherApplication.sApp)
                .classNameFor(carId, LauncherApplication.isPortrait(), readFile("/sys/fytver/fyt_bin_version"));

    	SharedPreferences mPrefs = SessionPrefs.get();
        SharedPreferences.Editor editor = mPrefs.edit();  
        if (name != null) {
            // What String.valueOf(Class) gave, which the settings read back: "class " + the name.
            editor.putString("canbus_class", "class " + name);     
        } else {
        	editor.putString("canbus_class", "vehicle_not_exist");    
        }
        editor.apply();
    }

    static String readFile(String path) {
        String strInfo = "";
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    sb.append(String.valueOf(str) + "\n");
                } else {
                    br.close();
                    strInfo = sb.toString();
                    return strInfo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return strInfo;
        }
    }
}