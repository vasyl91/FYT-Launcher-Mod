package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.ScreenScale;
import com.fyt.skin.SkinAttribute;
import com.fyt.skin.SkinUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.lang.ref.WeakReference;
import java.time.ZoneId;
import java.util.concurrent.Executor;

public class SettingsActivity extends AppCompatActivity {

    // Settings main activity 
    private static WeakReference<SettingsActivity> mSettingsActivity;
    private SharedPreferences sharedPrefs;
    private static final String TAG = "SettingsActivity";
    private final Helpers helpers = new Helpers(); 
    private boolean isReceiverRegistered = false;
    public static boolean isPortrait = false;

    public static int orientation;
    public static int orientationDimension;
    public static int orientedWidth;
    public static int calculatedStatsWidth;
    public static int calculatedStatsHeight;
    public static int calculatedPipMinHeight;
    public static int calculatedPipMinWidth;
    public static int calculatedDateMinHeight; 
    public static int calculatedDateMinWidth;
    public static int calculatedMusicMinHeight;
    public static int calculatedMusicMinWidth;
    public static int calculatedRadioMinHeight;
    public static int calculatedRadioMinWidth;
    public static int statusBarHeight;
    public static int screenWidth;
    public static int screenHeight;
    public static int arrowLongDim;
    public static int arrowShortDim;
    public static int arrowTextSize;
    public static int selectionTextSize;
    public static int confirmTextSize;
    public static int barHeight;
    public static int progressWidth;
    public static int progressHeight;
    public static int nestedPaddingStart;
    public static int nestedPaddingEnd;
    public static int dialogTitle;
    public static int dialogTextView;
    public static int dialogMargin;
    public static int dialogPadding;
    public static int adaptiveCoordinatesSize;
    public static int adaptiveNameTextSize;
    
    /**
     * Non-FYT devices (phones): the sizes PreferenceScaleHelper and the creators' scaleView() used
     * to give the settings by shrinking every list row after it was already on screen (a visible
     * jump, a squeezed nested indent) -- now applied here, before anything is inflated, at the
     * density ScreenScale works out from the screen's size. On a 1080 x 2340 phone at 440 dpi:
     *   landscape: everything at 0.75 of the screen's density;
     *   portrait:  icons, switches, paddings and row heights at 0.5, text at 0.75 (fontScale 1.5).
     * Those shares of the screen are what every other phone and tablet gets.
     */
    private static final float NON_FYT_TEXT_SCALE_PORTRAIT = 1.5f;

    /** Orientation the density was chosen for; another one needs a recreate(). */
    private int mScaledForOrientation = Configuration.ORIENTATION_UNDEFINED;

    @Override
    protected void attachBaseContext(Context newBase) {
        if (LauncherApplication.isFytDevice()) {
            super.attachBaseContext(newBase);
            return;
        }
        mScaledForOrientation = newBase.getResources().getConfiguration().orientation;
        super.attachBaseContext(withScaledDensity(newBase));
    }

    private static Context withScaledDensity(Context base) {
        Configuration config = ScreenScale.scaledConfiguration(base.getResources());
        return config != null ? base.createConfigurationContext(config) : base;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // The activity handles rotation itself, but the scaled density depends on it.
        if (!LauncherApplication.isFytDevice()
                && mScaledForOrientation != Configuration.ORIENTATION_UNDEFINED
                && newConfig.orientation != mScaledForOrientation) {
            recreate();
        }
    }

    /**
     * Non-FYT: the PiP and widget rows size their buttons and the Window/PiP switch as a share of
     * the row's measured height. The old per-row shrink scaled those controls by 0.5 (portrait) /
     * 0.75 (landscape) of what they had at the screen's own density; at this activity's scaled
     * density the row is mostly text (0.75) and paddings (0.5), so a share of it comes out larger.
     * This factor turns it back into the old size: old row scale x the row height at the screen's
     * own density / the row height at the old scaled density, both estimated like the rows'
     * resolveRowHeightFallback(). The densities cancel out, so it is the same on every screen,
     * as the sizes the rows are a share of now are. 1 on FYT units.
     */
    public static float legacyControlScale(Context ctx) {
        if (!ScreenScale.applies() || ctx == null) return 1f;
        boolean portrait = ctx.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;
        float textScale = portrait ? NON_FYT_TEXT_SCALE_PORTRAIT : 1f;
        float fontScale = android.content.res.Resources.getSystem().getConfiguration().fontScale;
        // Row heights in units of the screen's own density: text lines + padding.
        float rowOwn = (16f + 14f) * 1.3f * fontScale + 32f;
        float rowScaledText = (16f + 14f) * 1.3f * fontScale * textScale + 32f;
        return rowOwn / rowScaledText;
    }

    /**
     * Fits a label into its button: the text shrinks (down to 6 sp) until it fits, never grows
     * past maxSp. The creators' CONFIRM button is a share of the bar, its text was not.
     */
    public static void fitTextToView(TextView view, float maxSp) {
        if (view == null) return;
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, maxSp);
        view.setMinWidth(0);
        view.setMinHeight(0);
        view.setMinimumWidth(0);
        view.setMinimumHeight(0);
        view.setMaxLines(1);
        androidx.core.widget.TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                view, 6, Math.max(7, Math.round(maxSp)), 1, TypedValue.COMPLEX_UNIT_SP);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (!LauncherApplication.isFytDevice()) {
            // Before anything is inflated, fragments restored by super.onCreate() included.
            getTheme().applyStyle(R.style.SettingsTheme_PhoneRows, true);
        }
        super.onCreate(savedInstanceState);
        calculateLayoutDimensions();
        mSettingsActivity = new WeakReference<>(this);
        if (!LauncherApplication.isFytDevice()) {
            setupEdgeToEdge();
        }
        /**
         *  Update the sunrise and sunset times if the night mode feature is disabled.
         *  This prevents an error related to empty strings and gives more accurate results if the function 
         *  had been used at least once and then wasn't used for longer time.
        */
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean nightMode = sharedPrefs.getBoolean("night_mode", false); 
        if (!nightMode) {
            getSunriseAndSunsetTimes();
        }

        // determine class likely containing canbus codes
        SharedPreferences mPrefs = SessionPrefs.get();
        String can = mPrefs.getString("canbus_class", "empty");
        if (can.equals("empty")) {
            new CanbusClasses().execute();
        }
        helpers.setSettingsOpenedBoolean(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new SettingsFragmentFirst())
                .commit();
        }     
    }   

    public static SettingsActivity getSettingsActivity() {
        return mSettingsActivity != null ? mSettingsActivity.get() : null;
    }

    private void setupEdgeToEdge() {
        Window window = getWindow();
        
        // Make the status bar and navigation bar transparent
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Android 11+ (API 30+)
            window.setDecorFitsSystemWindows(false);
        } else {
            // Android 8-10 (API 26-29)
            View decorView = window.getDecorView();
            int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
            decorView.setSystemUiVisibility(flags);
        }
        
        Log.i(TAG, "Edge-to-edge setup complete");
    }

    private void calculateLayoutDimensions() {
        statusBarHeight = getStatusBarHeight();
        screenWidth = LauncherApplication.getScreenWidth(); 
        screenHeight = LauncherApplication.getScreenHeight(); 

        orientation = getResources().getConfiguration().orientation;
        // Static, so it has to be set both ways: it stayed true after a single portrait start.
        isPortrait = orientation == Configuration.ORIENTATION_PORTRAIT;
        if (isPortrait) {
            orientationDimension = screenHeight;
            orientedWidth = screenWidth;
        } else {
            // Landscape, and also an undefined orientation, which left both values unset (0 on the
            // first start), so calculateDimension() below threw.
            orientationDimension = screenWidth;
            orientedWidth = screenHeight;
        }

        calculatedStatsWidth = calculateDimension(orientationDimension, 21.75);
        calculatedStatsHeight = calculateDimension(orientationDimension, 5.0);
        calculatedPipMinHeight = calculateDimension(orientationDimension, 18.0);
        calculatedPipMinWidth = calculateDimension(orientedWidth, 44.0);
        calculatedDateMinHeight = calculateDimension(orientationDimension, 7.2);
        calculatedDateMinWidth = calculateDimension(orientedWidth, 44.0);
        calculatedMusicMinHeight = calculateDimension(orientationDimension, 18.0);
        calculatedMusicMinWidth = calculateDimension(orientedWidth, 25.1);
        calculatedRadioMinHeight = calculateDimension(orientationDimension, 7.2);
        calculatedRadioMinWidth = calculateDimension(orientedWidth, 25.1);    
        
        arrowLongDim = calculateDimension(orientationDimension, 8.5);
        arrowShortDim = calculateDimension(orientationDimension, 3.5);
        // Text sizes in sp, which the scaled density already makes a share of the screen on
        // non-FYT devices: they are taken from the reference phone instead of this screen,
        // which would count its size twice.
        boolean proportional = ScreenScale.applies();
        int textWidth = !proportional ? screenWidth : isPortrait
                ? ScreenScale.REFERENCE_SHORT_SIDE_PX : ScreenScale.REFERENCE_LONG_SIDE_PX;
        arrowTextSize = calculateAdaptiveTextSize(textWidth, 14);
        
        selectionTextSize = calculateAdaptiveTextSize(textWidth, 20);
        confirmTextSize = calculateAdaptiveTextSize(textWidth, 22);

        barHeight = calculateDimension(orientationDimension, 9.0);

        progressWidth = calculateDimension(orientationDimension, 35.0);
        progressHeight = calculateDimension(orientationDimension, 13.75);

        // The indents are shares of the row width. In landscape that is the longer side they
        // are taken from; in portrait they were the longer side's share too, so they grew with
        // the screen's height: now the same share of the width a 1080 x 2340 phone had.
        int indentBase = proportional && isPortrait
                ? Math.round(screenWidth * (float) ScreenScale.REFERENCE_LONG_SIDE_PX
                        / ScreenScale.REFERENCE_SHORT_SIDE_PX)
                : orientationDimension;
        nestedPaddingStart = calculateDimension(indentBase, 6.5);
        nestedPaddingEnd = calculateDimension(indentBase, 0.8);

        dialogTitle = calculateAdaptiveTextSize(textWidth, 20);
        dialogTextView = calculateAdaptiveTextSize(textWidth, 16);
        dialogMargin = calculateDimension(orientationDimension, 0.95);
        dialogPadding = calculateDimension(orientationDimension, 0.9);

        adaptiveCoordinatesSize = calculateAdaptiveTextSize(orientationDimension, 50);
        // In pixels of the creator canvas: the reference phone's size, grown with the screen.
        adaptiveNameTextSize = !proportional ? calculateAdaptiveTextSize(orientationDimension, 40)
                : Math.round(calculateAdaptiveTextSize(ScreenScale.REFERENCE_LONG_SIDE_PX, 40)
                        * orientationDimension / (float) ScreenScale.REFERENCE_LONG_SIDE_PX);
    }

    public int calculateDimension(int dimension, double percentage) {
        if (dimension <= 0 || percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid input: dimension must be positive, and percentage must be between 0 and 100.");
        }
        double result = (percentage / 100.0) * dimension;
        return (int) result;
    }

    public int calculateAdaptiveTextSize(int screenWidth, double baseSize) {
        if (screenWidth <= 0 || baseSize <= 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        double ratio = screenWidth / 2000.0;
        double scaleFactor = Math.pow(ratio, 0.5); 
        
        return (int) (baseSize * scaleFactor);
    }

    /**
     * Pads a creator screen on every side by the system bars (and the display cutout) its window
     * really lies under, so whatever it constrains to its parent stays clear of them. These are
     * the window's own insets, not the status_bar_height / navigation_bar_height dimensions: those
     * say how big a bar is, not whether this window is under it, nor on which side the navigation
     * bar is. Read from the window once the screen is attached: dispatched insets never reach it,
     * AppCompat's (hidden) action bar layout takes them on the way, and the screen is added after
     * they went out.
     */
    static void padForSystemBars(@NonNull View root) {
        final int left = root.getPaddingLeft();
        final int top = root.getPaddingTop();
        final int right = root.getPaddingRight();
        final int bottom = root.getPaddingBottom();
        final Runnable apply = () -> {
            WindowInsetsCompat insets = ViewCompat.getRootWindowInsets(root);
            if (insets == null) return;
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars()
                    | WindowInsetsCompat.Type.displayCutout());
            root.setPadding(left + bars.left, top + bars.top, right + bars.right, bottom + bars.bottom);
            Log.d(TAG, "Creator insets: " + bars);
        };
        if (root.isAttachedToWindow()) apply.run();
        root.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(@NonNull View v) {
                apply.run();
            }

            @Override
            public void onViewDetachedFromWindow(@NonNull View v) {
            }
        });
    }

    public int getStatusBarHeight() {
        int result = 0;
        // The system bars are drawn at the screen's real density, not at this activity's
        // reference density (see attachBaseContext()).
        android.content.res.Resources res = getApplicationContext().getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        Log.i(TAG, "Status bar height: " + result);
        return result;
    }

    public int getNavigationBarHeight() {
        int result = 0;
        // The system bars are drawn at the screen's real density, not at this activity's
        // reference density (see attachBaseContext()).
        android.content.res.Resources res = getApplicationContext().getResources();
        int resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        Log.i(TAG, "Navigation bar height: " + result);
        return result;
    }

    public int getActionBarHeight() {
        TypedValue tv = new TypedValue();
        if (this.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            int height = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
            Log.i(TAG, "ActionBar height: " + height);
            return height;
        }
        Log.i(TAG, "ActionBar height: 0 (not found)");
        return 0;
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public void startWatch() {
        if (mReceiver != null && !isReceiverRegistered) {
            IntentFilter mFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    registerReceiver(mReceiver, mFilter, Context.RECEIVER_EXPORTED);
                } else {
                    registerReceiver(mReceiver, mFilter);
                }
                isReceiverRegistered = true; 
            } catch (Exception e) {
                Log.e(TAG, "Error registering receiver", e);
            }
        }
    }

    public void stopWatch() {
        if (isReceiverRegistered && mReceiver != null) {
            try {
                unregisterReceiver(mReceiver);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "Receiver not registered", e);
            }
            isReceiverRegistered = false; 
        }
    }

    @SuppressWarnings("FieldMayBeFinal")
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override 
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(action)) {
                String reason = intent.getStringExtra(Keys.SYSTEM_DIALOG_REASON_KEY);
                if (Keys.SYSTEM_DIALOG_REASON_HOME_KEY.equals(reason)) {
                    AppListStatsDialogFragment.dismissListDialog(getSupportFragmentManager());
                    AppListPipDialogFragment.dismissListDialog(getSupportFragmentManager());
                    stopWatch();
                    Log.i("Home Receiver", "home clicked"); 
                    helpers.setBackFromCreator(false);
                    boolean initLayout = sharedPrefs.getBoolean(Keys.USER_INIT_LAYOUT, false);
                    boolean userLayoutBool = sharedPrefs.getBoolean(Keys.USER_LAYOUT, false);
                    if (initLayout != userLayoutBool) {
                        helpers.setLayoutTypeChanged(true);
                    }
                    helpers.checkAndResetIfOverlappingOnScreen(-1);
                    new VersionChecker().cancelDownload();
                    // Brightness: SettingsFragmentFirst.onStop() applies it, after a home press too.

                    long updateOnce = SystemClock.uptimeMillis();
                    Log.d(TAG, "Saving pending updateOnce=" + updateOnce);
                    getSharedPreferences("LauncherPrefs", Context.MODE_PRIVATE)
                        .edit()
                        .putLong(Keys.UPDATE_USER_PAGE, updateOnce)
                        .apply();
                }
            }
        }
    };

    private void getSunriseAndSunsetTimes() {
        if (ActivityCompat.checkSelfPermission(LauncherApplication.sApp, 
                android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(LauncherApplication.sApp, 
                android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            FusedLocationProviderClient fusedLocationClient = 
                LocationServices.getFusedLocationProviderClient(LauncherApplication.sApp);
            Executor executor = ContextCompat.getMainExecutor(LauncherApplication.sApp);
            
            fusedLocationClient.getLastLocation()
                .addOnSuccessListener(executor, new LocationSuccessListener());
        }
    }

    private static class LocationSuccessListener implements OnSuccessListener<Location> {
        @Override
        public void onSuccess(Location location) {
            SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            double lat;
            double longt;
            if (location != null) {
                SharedPreferences.Editor editor = mPrefs.edit();
                lat = location.getLatitude();
                longt = location.getLongitude();
                editor.putString("latiude", String.valueOf(lat));
                editor.putString("longitude", String.valueOf(longt));
                editor.apply();
            } else {
                String latStr = mPrefs.getString("latiude", null);
                String lngStr = mPrefs.getString("longitude", null);
                if (latStr != null && lngStr != null) {
                    lat = Double.parseDouble(latStr);
                    longt = Double.parseDouble(lngStr);   
                } else return;
            }
            String urlString = "https://api.sunrise-sunset.org/json?lat=" + lat + "&lng=" + longt + 
                "&date=today" + "&tzid=" + String.valueOf(ZoneId.systemDefault());

            SunTask sunTask = new SunTask(LauncherApplication.sApp, lat, longt, true);
            sunTask.execute(urlString);
        }
    }

    private void clearSkinReferences() {
        try {
            SkinAttribute skinAttribute = SkinUtils.getSkinAttr();
            if (skinAttribute != null) {
                skinAttribute.clear();
            }
        } catch (Exception e) {
            Log.w(TAG, "Error clearing skin references", e);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppListStatsDialogFragment.dismissListDialog(getSupportFragmentManager());
        AppListPipDialogFragment.dismissListDialog(getSupportFragmentManager());
        System.gc();
    }

    @Override
    protected void onStart() {
        super.onStart();
        startWatch();
    }

    @Override
    protected void onStop() {
        stopWatch();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        stopWatch();
        helpers.setSettingsOpenedBoolean(false);
        clearSkinReferences();
        mReceiver = null;
        sharedPrefs = null;

        if (mSettingsActivity != null && mSettingsActivity.get() == this) {
            mSettingsActivity.clear();
            mSettingsActivity = null;
        }
        super.onDestroy();
    }
}