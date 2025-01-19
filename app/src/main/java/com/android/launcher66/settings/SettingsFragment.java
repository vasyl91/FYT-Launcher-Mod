package com.android.launcher66.settings;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SeekBarPreference;
import androidx.preference.TwoStatePreference;

import com.android.launcher66.R;
import com.syu.util.WindowUtil;
import com.jakewharton.processphoenix.ProcessPhoenix;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class SettingsFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceClickListener, HomeWatcher.OnHomePressedListener {

    private SharedPreferences sharedPrefs;
    private HomeWatcher mHomeWatcher;
    private Context mContext;
    private static final String TAG = "BRIGHTNESS";
    private static final String STATUSBAR = "transparent_statusbar";
    private static final String USER_LAYOUT = "user_layout";
    private static final String CREATOR_FIRST = "launcher_creator_first";
    private static final String FYT_DATA = "fyt_data"; 
    private static final String DEVICE_SETTINGS = "device_settings";
    private static final String NOTI = "noti_settings";    
    private static final String NIGHT_MODE = "night_mode";     
    private static final String DEFAULT_WALLPAPERS = "default_wallpapers";
    private static final String SAVE_DAY_WALLPAPER = "save_day_wallpaper";    
    private static final String SAVE_NIGHT_WALLPAPER = "save_night_wallpaper";
    private static final String BRIGHTNESS_PREF = TAG;
    private static final String DAY_SEEK_BAR = "day_seek_bar";
    private static final String NIGHT_SEEK_BAR = "night_seek_bar";
    private boolean initLayout;
    private boolean userLayoutBool;
    private boolean initStatusbar;
    private boolean userStatusbarBool;
    private boolean initFyt;
    private boolean userFytBool;
    private boolean nightModeBool;
    private boolean defaultWallpapersBool;
    private boolean wallpaperSet = false;
    private boolean brightnessBool;
    private Preference nightMode;
    private Preference defaultWallpapers;
    private Preference saveDayWallpaper;
    private Preference saveNightWallpaper;
    private Preference brightness;
    private SeekBarPreference daySeekBar;
    private SeekBarPreference nightSeekBar;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        this.mContext = this.getContext();
        mHomeWatcher = new HomeWatcher(getActivity());
        mHomeWatcher.setOnHomePressedListener(this);
        mHomeWatcher.startWatch();
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.requireContext());
        initStatusbar = sharedPrefs.getBoolean(STATUSBAR, false);
        initLayout = sharedPrefs.getBoolean(USER_LAYOUT, false);
        initFyt = sharedPrefs.getBoolean(FYT_DATA, false);
        addPreferencesFromResource(R.xml.launcher_preferences);
        Preference transparentStatusbar = findPreference(STATUSBAR);
        Preference userLayout = findPreference(USER_LAYOUT);
        Preference launcherCreatorFirst = findPreference(CREATOR_FIRST);
        Preference fytData = findPreference(FYT_DATA);
        Preference deviceSettings = findPreference(DEVICE_SETTINGS);
        Preference noti = findPreference(NOTI);
        nightMode = findPreference(NIGHT_MODE);
        defaultWallpapers = findPreference(DEFAULT_WALLPAPERS);
        saveDayWallpaper = findPreference(SAVE_DAY_WALLPAPER);
        saveNightWallpaper = findPreference(SAVE_NIGHT_WALLPAPER);        
        brightness = findPreference(BRIGHTNESS_PREF);
        daySeekBar = findPreference(DAY_SEEK_BAR);
        nightSeekBar = findPreference(NIGHT_SEEK_BAR);

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
        if (deviceSettings != null) {
            deviceSettings.setOnPreferenceClickListener(this);
        }
        if (noti != null) {
            noti.setOnPreferenceClickListener(this);
        }
        nightMode();
    }

    private void nightMode() {
        if (nightMode != null) {
            nightMode.setOnPreferenceClickListener(this);
            if (nightMode instanceof TwoStatePreference) {
                ((TwoStatePreference) nightMode).setSummaryOn(getString(R.string.night_mode_summary, sharedPrefs.getString("sunrise", ""), sharedPrefs.getString("sunset", "")));
            }
            nightModeBool = sharedPrefs.getBoolean(NIGHT_MODE, false);
            defaultWallpapers.setVisible(nightModeBool);  
        }
        if (defaultWallpapers != null) {
            defaultWallpapers.setOnPreferenceClickListener(this);
            defaultWallpapersBool = sharedPrefs.getBoolean(DEFAULT_WALLPAPERS, true);
            if (wallpaperBoolean()) {
                saveDayWallpaper.setVisible(true);
                saveNightWallpaper.setVisible(true);                
            } else {
                saveDayWallpaper.setVisible(false);
                saveNightWallpaper.setVisible(false);  
            }
        }
        if (saveDayWallpaper != null) {
            saveDayWallpaper.setOnPreferenceClickListener(this);
        }
        if (saveNightWallpaper != null) {
            saveNightWallpaper.setOnPreferenceClickListener(this);
        }
        if (brightness != null) {
            brightness.setOnPreferenceClickListener(this);
            brightnessBool = sharedPrefs.getBoolean(BRIGHTNESS_PREF, false);
            daySeekBar.setVisible(brightnessBool);
            nightSeekBar.setVisible(brightnessBool);
        }
        seekBar(daySeekBar, DAY_SEEK_BAR);
        seekBar(nightSeekBar, NIGHT_SEEK_BAR);      
    }

    private void seekBar(SeekBarPreference seekPreference, String state) {
        if (seekPreference != null) {
            seekPreference.setOnPreferenceChangeListener((preference, newValue) -> {
                if (newValue instanceof Integer) {
                    int newValueInt;
                    try {
                        newValueInt = (Integer) newValue;
                    } catch (NumberFormatException nfe) {
                        Log.e(TAG, "SeekBarPreference is an Integer, but it caused a NumberFormatException");
                        return false;
                    }
                    preference.getContext();
                    final SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putInt(state, newValueInt);
                    editor.apply();
                    return true;
                } else {
                    String objType = newValue.getClass().getName();
                    Log.e(TAG, "SeekBarPreference is not an Integer, it is " + objType);
                    return false;
                }
            });
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
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFragmentFirst()).commit();
                break;
            case DEVICE_SETTINGS:
                Intent intentSettings = new Intent(Settings.ACTION_SETTINGS);
                intentSettings.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentSettings);
                break;
            case NOTI:
                Intent intentNoti = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                intentNoti.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentNoti.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intentNoti.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                startActivity(intentNoti);
                break;
            case NIGHT_MODE:
                Helpers.onCreateJobInit = false;
                nightModeBool = sharedPrefs.getBoolean(NIGHT_MODE, false);
                defaultWallpapers.setVisible(nightModeBool);
                defaultWallpapersBool = sharedPrefs.getBoolean(DEFAULT_WALLPAPERS, true);
                if (wallpaperBoolean()) {
                    saveDayWallpaper.setVisible(true);
                    saveNightWallpaper.setVisible(true);                
                } else {
                    saveDayWallpaper.setVisible(false);
                    saveNightWallpaper.setVisible(false);  
                } 
                brightness.setVisible(nightModeBool);
                daySeekBar.setVisible(nightModeBool);
                nightSeekBar.setVisible(nightModeBool);
                break;
            case DEFAULT_WALLPAPERS:
                wallpaperSet = true;
                defaultWallpapersBool = sharedPrefs.getBoolean(DEFAULT_WALLPAPERS, true);
                if (wallpaperBoolean()) {
                    saveDayWallpaper.setVisible(true);
                    saveNightWallpaper.setVisible(true);                
                } else {
                    saveDayWallpaper.setVisible(false);
                    saveNightWallpaper.setVisible(false);  
                }
                break;
            case SAVE_DAY_WALLPAPER:
                wallpaperSet = true;
                saveWallpaper("wallpaper_day", "Day");
                break;
            case SAVE_NIGHT_WALLPAPER:
                wallpaperSet = true;
                saveWallpaper("wallpaper_night", "Night");
                break;
            case BRIGHTNESS_PREF:
                brightnessBool = sharedPrefs.getBoolean(BRIGHTNESS_PREF, false);
                daySeekBar.setVisible(brightnessBool);
                nightSeekBar.setVisible(nightModeBool);
                break;
            default:
                break;
        }
        return false;
    }

    private boolean wallpaperBoolean() {
        return nightModeBool && !defaultWallpapersBool;
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
                if ((initLayout != userLayoutBool) || initStatusbar != userStatusbarBool || initFyt != userFytBool || Helpers.backFromCreator || wallpaperSet) {
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
                    requireActivity().finish();
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

    private void saveWallpaper(String name, String daytime) {
        final WallpaperManager mWallpaperManager = WallpaperManager.getInstance(this.mContext);
        Drawable mWallpaper = mWallpaperManager.getDrawable();
        Bitmap mBitmap = drawableToBitmap(mWallpaper);
        File mFile = new File(Environment.getExternalStorageDirectory() + File.separator + "Launcher_drawable");
        boolean doSave = true;
        if (!mFile.exists()) {
            doSave = mFile.mkdirs();
        }            
        if (doSave) {
            SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);
            SharedPreferences.Editor editor = mPrefs.edit();
            saveBitmapToFile(mFile, name + ".png", mBitmap);
            editor.putString("last_wallpaper", name);
            editor.apply();
            Toast.makeText(this.mContext, mContext.getString(R.string.wallpaper_set, daytime), Toast.LENGTH_LONG).show();
        }    
    }

    public Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * @param dir      you can get from many places like Environment.getExternalStorageDirectory() or mContext.getFilesDir() depending on where you want to save the image.
     * @param fileName The file name.
     * @param bm       The Bitmap you want to save.
     */
    void saveBitmapToFile(File dir, String fileName, Bitmap bm) {
        File imageFile = new File(dir, fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(imageFile);
            bm.compress(Bitmap.CompressFormat.PNG, 100,fos);
            fos.close();
        }
        catch (IOException e) {
            Log.e("app", Objects.requireNonNull(e.getMessage()));
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}