package com.android.launcher66.settings;

import com.android.launcher66.SysCalls;
import android.SystemProperties;
import android.annotation.SuppressLint;
import android.app.Service;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.GradientDrawable;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.preference.PreferenceManager;

import com.android.launcher66.Folder;
import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.Workspace;
import com.syu.ipc.IModuleCallback;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HostAwait;
import com.syu.util.PaneWindows;
import com.syu.util.WindowHostVdClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class CanbusService extends Service implements PropertyChangeListener {

    private static final String TAG = "CanbusService";
    /** The apps the fuel statistics are shown over; read at the start, see LauncherApplication. */
    public static final String APP_STATS_PREFS = "AppStatsPrefs";
    private AccessibilityManager accessibilityManager;
    private DeviceLocation.Handle locationUpdates;
    private AccessibilityManager.AccessibilityStateChangeListener accessibilityListener;
    private SharedPreferences prefs;
    /** The last package of a Keys.ACCESIBILITY_SERVICE broadcast; see getCurrentActivityName(). */
    private String mLastReportedPackage;
    private Helpers helpers = new Helpers();
    private IBinder binder;
    private View absoluteStats;
    /**
     * The window of the stats on the home screen from Android 14 on: as wide as a page and left
     * where it is while the pages move, absoluteStats moving inside it (see addStatsView()). Null
     * before Android 14, where the stats are a window of their own size moved by WindowManager, and
     * for the stats over a map app.
     */
    private FrameLayout statsHost;
    private TextView consumptionTextView;
    private TextView mileageTextView;
    private WindowManager wm;  
    private String textColor = "#FFFFFFFF"; 
    private String curForegroundApp = "";
    private String prevView = "";
    private final PropertyChangeClass mPropertyChangeClass = new PropertyChangeClass();
    private boolean userLayout = false;
    private boolean userStats = false;
    private int statsWidthSelector;
    /** The codes of the settings; 0 = not set, the library's code (fuel, range) or the reader's (speed) is used then. */
    private volatile int fuel = 0;
    private volatile int range = 0;
    private volatile int rpm = 0;
    private volatile int speed = 0;
    /** The codes in use: those of the settings, else those the library knows for the car, else 0. */
    private volatile int fuelCode = 0;
    private volatile int rangeCode = 0;
    /** The speed code in use: that of the settings, else the one the code reader found, else 0 (the GPS). */
    private volatile int speedCode = 0;
    /** The RPM code in use: that of the settings, else the one the code reader found, else 0 (no RPM). */
    private volatile int rpmCode = 0;
    /**
     * Which pair of the library's fuel and range codes the radio reports (the codes moved between the versions of
     * the canbus module); null for a car the library has no pair for. The codes of the settings come before it.
     */
    private volatile CodePairChooser pairChooser;
    private int pairCarId;
    /** The choice last written to the settings, to write only a change. Main thread. */
    private String pairSaved = "";
    /** The last value of each code the service listens to, to show the values of a pair that has just been chosen. */
    private final Map<Integer, Integer> lastCodeValues = new ConcurrentHashMap<>();
    /**
     * Where the protocol of the car reports the unit of the instantaneous consumption (the U record of the canbus
     * library), or null: the library does not say, and the unit is then not known.
     */
    private volatile FuelUnit fuelUnit;
    /** The widget shows the car's value in litres per hour now (it must change back when the speed rises). Main thread. */
    private boolean fuelShownPerHour;
    /** The last values of the codes above, from the update of com.syu.ms (binder thread). */
    private volatile int fuelRaw = 0;
    private volatile int fuelValue = 0;
    private volatile int rangeValue = 0;
    private volatile int rpmValue = 0;
    private volatile int speedValue = 0;
    /**
     * The estimate of the consumption where the car gives none, learned from its own values; null without a
     * fuel code (no estimate then). Main thread.
     */
    private FuelModel fuelModel;
    private String fuelModelKey;
    private long fuelModelSavedAt;
    private FuelModel.SpeedScale speedScale = new FuelModel.SpeedScale(0);
    private static final long FUEL_MODEL_SAVE_MS = 60_000L;
    /** Above this speed (km/h) the car counts as driving, for the choice of the pair of codes. */
    private static final double DRIVING_KMH = 5.0;

    private Workspace workspaceRef = null;
    private ViewTreeObserver.OnScrollChangedListener workspaceScrollListener = null;
    private WindowManager.LayoutParams statsLayoutParams = null;
    private int statsAbsoluteBaseX = 0; // absolute X in pixels (page index * pageWidth + local offset)
    private int statsPageWidth = 0;
    int statsWidth;
    int statsHeight;
    int statsTopLeftX, statsTopLeftY;

    /** Set for the lifetime of the service; see Launcher.isServiceRunning(). */
    private static volatile boolean sRunning;

    /** The pair of codes in use for a car, for the settings. */
    private static final class PairInfo {
        final int carId;
        final CodePairChooser.Status status;

        PairInfo(int carId, CodePairChooser.Status status) {
            this.carId = carId;
            this.status = status;
        }
    }

    private static volatile PairInfo sPairInfo;

    /** The pair of fuel and range codes in use for the car (confirmed or not), from the running service; else null. */
    static CodePairChooser.Status pairStatus(int carId) {
        PairInfo info = sPairInfo;
        return info != null && info.carId == carId ? info.status : null;
    }

    /** The running service, for onPagesFrame(); main thread. */
    private static CanbusService sInstance;

    /**
     * Main thread, from Workspace in the animation phase of each frame the pages move in, with the
     * scroll the pages will be drawn with in that frame. The stats then move in the same frame as
     * the pages; from the workspace's scroll listener alone they came a frame later, as that runs
     * in the draw.
     */
    public static void onPagesFrame(int scrollX) {
        CanbusService service = sInstance;
        if (service != null) {
            service.updateStatsPositionForScroll(scrollX);
        }
    }

    public static boolean isRunning() {
        return sRunning;
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    public void onCreate() {
        super.onCreate();
        sRunning = true;
        sInstance = this;
        Log.d(TAG, "Service created");
        // The application's context: it has the file's path already, this service's would look it up
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
        userStats = prefs.getBoolean(Keys.USER_STATS, false);
        helpers = new Helpers();
        CanbusLibrary.preload(getApplicationContext());
        accessibilityManager = (AccessibilityManager) getSystemService(ACCESSIBILITY_SERVICE);
        registerAccessibilityEventListener();
        requestLocationUpdates();
        
        mPropertyChangeClass.addObserver(Keys.ALLAPPS, this);
        mPropertyChangeClass.addObserver(Keys.FUELSTATS, this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Keys.PIP_STARTED);
        filter.addAction(Keys.PIP_REMOVED);
        filter.addAction(Keys.LIST_OPEN);
        filter.addAction(Keys.LIST_CLOSE);
        filter.addAction(Keys.OVERVIEW_MODE_OPEN);
        filter.addAction(Keys.OVERVIEW_MODE_CLOSE);
        filter.addAction(Keys.STATS_APP_FOREGROUND);
        filter.addAction(Keys.ALL_APPS);
        filter.addAction(Keys.ALL_APPS_VISIBLE);
        filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        filter.addAction(Keys.RECYCLER_APP);
        filter.addAction(Keys.RECYCLER_APP_MAP);
        filter.addAction(Keys.ACCESIBILITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(pipReceiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(pipReceiver, filter);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service started");
        if (intent != null) {
            fuel = intent.getIntExtra("fuel", 0);
            range = intent.getIntExtra("range", 0);
            rpm = intent.getIntExtra("rpm", 0);
            speed = intent.getIntExtra("speed", 0);
            // Until the library says otherwise (mNotifyCar) the codes of the settings are the ones in use
            fuelCode = fuel;
            rangeCode = range;
            addStatsViewMainScreen();
            addNotify();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sRunning = false;
        if (sInstance == this) {
            sInstance = null;
            sPairInfo = null;
        }
        saveFuelModel();
        Log.d(TAG, "Service destroyed");
        removeLocationUpdates();
        unregisterAccessibilityEventListener();
        if (hostWait != null) {
            hostWait.cancel();
            hostWait = null;
        }
        ForegroundAppTracker.stop();
        mPropertyChangeClass.deleteObserver(Keys.ALLAPPS, this);
        mPropertyChangeClass.deleteObserver(Keys.FUELSTATS, this);
        try {
            unregisterReceiver(pipReceiver);
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "pipReceiver was not registered", e);
        }
        removeNotify();
        removeView();
        Intent broadcastIntent = new Intent(this, ServiceRestarter.class);
        SysCalls.sendBroadcast(CanbusService.this, broadcastIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    /*
     * Whether StateAccessibilityService is switched on is read from the settings, not from
     * AccessibilityManager.isEnabled(): after a restart the system binds the accessibility services
     * only ~25 s into the boot, and until then isEnabled() is false for a service the user switched
     * on long ago. At every cold boot this opened the accessibility settings over the launcher
     * (capture 05-10-2026 04:45:30), where they stayed until the user went back, ~23 s, with the
     * PiP panes waiting behind them.
     */
    private void registerAccessibilityEventListener() {
        // With system privileges, or a VD host (root or Shizuku), the foreground app comes from
        // the task stack, and the accessibility service (and its settings screen) is not needed.
        if (ForegroundAppTracker.start(this)) {
            return;
        }
        if (accessibilityManager == null) {
            return;
        }
        accessibilityManager.addAccessibilityStateChangeListener(accessibilityListener = enabled -> {
            if (enabled) {
                Log.d(TAG, "Accessibility service enabled");
            } else if (!isStateServiceSwitchedOn()) {
                Log.d(TAG, "Accessibility service disabled");
                openAccessibilitySettingsIfNeeded();
            }
        });
        if (!accessibilityManager.isEnabled() && !isStateServiceSwitchedOn()) {
            Log.d(TAG, "Accessibility service is not enabled");
            openAccessibilitySettingsIfNeeded();
        }
    }

    /**
     * Not while a VD host reports the foreground app, nor while one is on its way: Shizuku binds
     * a moment after the start, and ForegroundAppTracker takes over as soon as it is there.
     */
    private void openAccessibilitySettingsIfNeeded() {
        if (ForegroundAppTracker.isActive() || WindowHostVdClient.canHostPanes()) {
            Log.d(TAG, "Accessibility settings not opened: the VD host reports the foreground app");
            return;
        }
        if (HostAwait.isExpected(this)) {
            // Shizuku installed but not running yet (the 7870 starts it minutes after the launcher):
            // the settings opened over the launcher at the start, before it. The window is the boot's
            // for a start in the first minutes, a wake's later; a host that attaches ends the question
            // (canHostPanes() is true then), one that does not leaves what was done before.
            if (hostWait != null) return;
            hostWait = HostAwait.await(HostAwait.windowForUptime(SystemClock.elapsedRealtime()),
                    "accessibility settings", attached -> {
                hostWait = null;
                if (attached || ForegroundAppTracker.isActive() || WindowHostVdClient.canHostPanes()
                        || isStateServiceSwitchedOn()) {
                    Log.d(TAG, "Accessibility settings not opened: the VD host reports the foreground app");
                    return;
                }
                openAccessibilitySettings();
            });
            return;
        }
        openAccessibilitySettings();
    }

    /** The wait for a VD host before the accessibility settings are opened; main thread. */
    private HostAwait.Handle hostWait;

    /** StateAccessibilityService is on in the accessibility settings (bound or not yet). */
    private boolean isStateServiceSwitchedOn() {
        try {
            if (Settings.Secure.getInt(getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED, 0) != 1) {
                return false;
            }
            String enabled = Settings.Secure.getString(getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (enabled == null) {
                return false;
            }
            ComponentName ours = new ComponentName(this, StateAccessibilityService.class);
            for (String entry : enabled.split(":")) {
                ComponentName component = ComponentName.unflattenFromString(entry);
                if (ours.equals(component)) {
                    return true;
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "Could not read the accessibility settings", e);
        }
        return false;
    }

    private void openAccessibilitySettings() {
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        LauncherApplication.sApp.startActivity(intent);
    }
    
    private void unregisterAccessibilityEventListener() {
        if (accessibilityManager != null && accessibilityListener != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(accessibilityListener);
        }
    }
    
    private final Handler uiHandler = new Handler(Looper.getMainLooper());

    /**
     * The codes are read the way the code reader reads them: straight from com.syu.ms, whatever the
     * callback of the car (Callback_XXXX) registered. DataCanbus.DATA and NOTIFY_EVENTS only know the
     * codes that callback registered, and for a car the launcher has no callback for, only code 0.
     */
    private final IModuleCallback.Stub statsCallback = new IModuleCallback.Stub() {
        @Override
        public void update(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (ints == null || ints.length == 0) {
                return;
            }
            int value = ints[0];
            lastCodeValues.put(updateCode, value);
            CodePairChooser chooser = pairChooser;
            if (chooser != null && chooser.onValue(updateCode, value)) {
                uiHandler.post(CanbusService.this::onPairChanged);
            }
            if (updateCode == fuelCode) {
                fuelRaw = value;
                fuelValue = fuelFromRaw(value);
                uiHandler.post(CanbusService.this::mUpdaterOilExpend);
            }
            FuelUnit unit = fuelUnit;
            if (unit != null && unit.unitCode() == updateCode) {
                uiHandler.post(CanbusService.this::onFuelUnitChanged);
            }
            if (updateCode == rangeCode) {
                rangeValue = value;
                uiHandler.post(CanbusService.this::mUpdaterDrivingMileage);
            }
            if (updateCode == rpmCode) {
                rpmValue = value;
                uiHandler.post(CanbusService.this::mUpdaterRPM);
            }
            if (updateCode == speedCode) {
                speedValue = value;
                uiHandler.post(CanbusService.this::onSpeedCode);
            }
        }
    };

    /** The codes registered with statsCallback; main thread. */
    private final Set<Integer> statsCodesRegistered = new HashSet<>();

    /**
     * The car is known (it is zeroed when the connection to com.syu.ms drops, and set again when it
     * is back): register the codes, and send the car the request of its fuel screen if it has one.
     * The fuel and range codes are those of the settings; where none is set, those of the library.
     */
    private final IUiNotify mNotifyCar = (updateCode, ints, flts, strs) -> {
        int carId = DataCanbus.DATA[1000];
        if (carId == 0) {
            return;
        }
        final Context app = getApplicationContext();
        // The library may still be loading, and loading reads files: not on this thread
        CanbusLibrary.executor().execute(() -> {
            CanbusLibrary.Library library = CanbusLibrary.loadBlocking(app);
            List<CanbusLibrary.CarCodes> pairs = library.codePairsFor(carId);
            FuelUnit unit = library.unitFor(carId);
            uiHandler.post(() -> {
                if (sInstance != this) {
                    return;
                }
                fuelUnit = unit;
                fuelValue = fuelFromRaw(fuelRaw);
                setUpPairs(carId, pairs);
                applyPairCodes();
                // The speed for the estimate: the code of the settings, else the one the code reader found
                // (it followed the GPS, and its scale is known), else the GPS
                ReaderGuesses reader = ReaderGuesses.parse(prefs.getString(ReaderGuesses.key(carId), null));
                speedCode = speed > 0 ? speed : reader != null && reader.speed > 0 ? reader.speed : 0;
                speedScale = new FuelModel.SpeedScale(reader != null && speedCode == reader.speed ? reader.speedScale : 0);
                // and the RPM the same way: the model checks that the values look like revs
                rpmCode = rpm > 0 ? rpm : reader != null && reader.rpm > 0 ? reader.rpm : 0;
                loadFuelModel(carId);
                registerStatsCodes();
            });
        });
        CanbusLibrary.sendForCar(app, carId);
    };

    private final BroadcastReceiver pipReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if(intent.getAction() != null) {
                    switch (intent.getAction()) {
                        case Keys.PIP_STARTED:
                            curForegroundApp = "com.android.launcher66";
                            mPropertyChangeClass.setString(Keys.FUELSTATS, curForegroundApp);
                            if (absoluteStats != null && !"main".equals(absoluteStats.getTag())) {
                                //removeView();  
                                addStatsViewMainScreen();                          
                            } else {
                                addStatsViewMainScreen();
                            }
                            break;
                        case Keys.PIP_REMOVED, Keys.RECYCLER_APP:
                            removeView();
                            break;
                        case Keys.RECYCLER_APP_MAP, Keys.STATS_APP_FOREGROUND:
                            //removeView();
                            addStatsView(true);
                            break;
                        case Keys.LIST_OPEN, Keys.OVERVIEW_MODE_OPEN:
                            curForegroundApp = "com.android.launcher66";
                            mPropertyChangeClass.setString(Keys.FUELSTATS, curForegroundApp);
                            removeView();
                            break;
                        case Keys.LIST_CLOSE:
                            curForegroundApp = "com.android.launcher66";
                            mPropertyChangeClass.setString(Keys.FUELSTATS, curForegroundApp);
                            if (absoluteStats != null && !"main".equals(absoluteStats.getTag())) {
                                //removeView();
                                addStatsViewMainScreen();                                
                            }
                            break;
                        case Keys.OVERVIEW_MODE_CLOSE:
                            curForegroundApp = "com.android.launcher66";
                            mPropertyChangeClass.setString(Keys.FUELSTATS, curForegroundApp);
                            // needs a while to properly return current page id
                            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                if (absoluteStats != null && !"main".equals(absoluteStats.getTag())) {
                                    //removeView();
                                    addStatsViewMainScreen();
                                }
                            }, 1000);
                            break;
                        case Keys.ALL_APPS, Keys.ALL_APPS_VISIBLE:
                            curForegroundApp = "com.android.launcher66";
                            mPropertyChangeClass.setBoolean(Keys.ALLAPPS, true);
                            mPropertyChangeClass.setString(Keys.FUELSTATS, curForegroundApp);
                            removeView();
                            break;
                        case Intent.ACTION_CLOSE_SYSTEM_DIALOGS:
                            String reason = intent.getStringExtra(Keys.SYSTEM_DIALOG_REASON_KEY);
                            if (reason != null) {
                                if (reason.equals(Keys.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                                    // One reference: the static can be cleared while this runs.
                                    final Launcher launcher = Launcher.getLauncher();
                                    if (launcher == null || launcher.mWorkspace == null) {
                                        // Launcher not running, or mWorkspace not created yet
                                        return;
                                    }
                                    // PinnedPipFocus: false whenever the pinned PiP is shown,
                                    // also right after a touch on the launcher (PinnedPipFocus's
                                    // window has the focus then), as before PinnedPipFocus.
                                    final boolean alreadyOnHome = launcher.mHasFocus;
                                    Folder openFolder = launcher.getWorkspace().getOpenFolder();
                                    // In all these cases, only animate if we're already on home
                                    launcher.mWorkspace.exitWidgetResizeMode();
                                    if (alreadyOnHome && launcher.mState == Launcher.State.WORKSPACE && !launcher.mWorkspace.isTouchActive() &&
                                            openFolder == null) {
                                        curForegroundApp = "com.android.launcher66";
                                        mPropertyChangeClass.setString(Keys.FUELSTATS, curForegroundApp);
                                    }
                                } else if (reason.equals(Keys.SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                                    helpers.setWasInRecents(true);
                                    mPropertyChangeClass.setBoolean(Keys.ALLAPPS, false);
                                }                    
                            }
                            break;
                        case Keys.ACCESIBILITY_SERVICE:
                            String packageName = intent.getStringExtra("package_name");
                            if (packageName == null) {
                                break;
                            }
                            mLastReportedPackage = packageName;
                            if (packageName.equals("com.android.launcher3")) {
                                helpers.setInRecent(true);
                                helpers.setInAllApps(false);
                                helpers.setInWidgets(false);
                                helpers.setWasInRecents(true);
                                curForegroundApp = "com.android.launcher66";
                                mPropertyChangeClass.setString(Keys.FUELSTATS, curForegroundApp);
                                removeView();
                            } else {
                                helpers.setInRecent(false);
                            }
                            currentForegroundApplication(packageName);
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "Error receiving broadcast: " + e.getMessage());
            }
        }

        private void currentForegroundApplication(String packageName) {
            SharedPreferences statsPrefs = getApplicationContext().getSharedPreferences(APP_STATS_PREFS, MODE_PRIVATE);
            Set<String> apps = new HashSet<>(statsPrefs.getStringSet("stats_apps", new HashSet<>()));
            String appPackageName = SystemProperties.get("persist.launcher.packagename", "");
            if (packageName.contains(":")) {
                packageName = packageName.substring(0, packageName.indexOf(":"));
            }
            if (packageName.contains("com.android.launcher66") && !helpers.isForegroundAppOpened()) {
                curForegroundApp = "com.android.launcher66";
            } 
            if (!appPackageName.isEmpty() && packageName.contains(appPackageName) && (helpers.hasPipStarted() || helpers.isInRecent()) && !helpers.isForegroundAppOpened()) {
                curForegroundApp = "com.android.launcher66";
            }
            if (apps.contains(packageName)) {
                if (!appPackageName.isEmpty() && packageName.contains(appPackageName) && (helpers.hasPipStarted() || helpers.isInRecent() || helpers.isInOverviewMode()) && !helpers.isForegroundAppOpened()) {
                    curForegroundApp = "com.android.launcher66";
                } else if (!helpers.isInOverviewMode() || !helpers.isListOpen() || !helpers.isInRecent()) {
                    curForegroundApp = packageName;
                }
            }
            
            Launcher launcher = Launcher.getLauncher();
            if (launcher != null && launcher.mAppsCustomizeTabHost != null) {
                if (helpers.userWasInRecents() && !getCurrentActivityName().equals("com.android.launcher66")) {
                    helpers.setInRecent(false);
                    helpers.setInAllApps(false);
                    helpers.setInWidgets(false);
                    helpers.setWasInRecents(true);
                    mPropertyChangeClass.setBoolean(Keys.ALLAPPS, false);
                } else {
                    mPropertyChangeClass.setBoolean(Keys.ALLAPPS, helpers.allAppsVisibility(launcher.mAppsCustomizeTabHost.getVisibility()));
                }
            }  
            mPropertyChangeClass.setString(Keys.FUELSTATS, curForegroundApp);
        }
    };

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Keys.ALLAPPS:
                Log.i("allappsChange", "\t(" + evt.getOldValue() + " -> " + evt.getNewValue() + ")");
                String val = String.valueOf(evt.getNewValue());
                if (val.contains("true") || val.contains("false")) {
                    Log.i("val", val);
                    helpers.setInAllApps(Boolean.parseBoolean(val));
                    if (Boolean.parseBoolean(val) && !curForegroundApp.contains("com.android.launcher")) {
                        removeView();
                    }                
                }
                break;
            case Keys.FUELSTATS:
                Log.i("fuelStatsChange", "\t(" + evt.getOldValue() + " -> " + evt.getNewValue() + ")");
                if (String.valueOf(evt.getNewValue()).contains("com.android.launcher")) {
                    helpers.setForegroundAppOpened(false);
                }
                if (!String.valueOf(evt.getNewValue()).contains("com.android.launcher") 
                    && !helpers.isInAllApps() 
                    && !helpers.isInRecent() 
                    && !helpers.hasPipStarted() 
                    && !getCurrentActivityName().equals("com.android.settings")) {
                    helpers.setForegroundAppOpened(true);
                    removeView();
                    addStatsView(true);                   
                } else if (!helpers.hasPipStarted() || helpers.isInOverviewMode() || (helpers.isListOpen() && !helpers.isForegroundAppOpened())) {
                    removeView();
                }
                break;
            default:
                break;
        } 
    }   

    /**
     * The app in front: the one ForegroundAppTracker last reported when it runs (the task stack,
     * apps only), else the most recently used one by UsageStatsManager. That is a binder call
     * reading a day of usage, on the main thread: 2.3 s right after a boot (FYT, Android 10).
     */
    private String getCurrentActivityName() {
        String reported = mLastReportedPackage;
        if (reported != null && ForegroundAppTracker.isActive()) {
            return reported;
        }
        String currentApp = "NULL";
        UsageStatsManager usm = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
        long time = System.currentTimeMillis();
        List<UsageStats> appList = usm.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, time - 1000 * 1000, time);
        if (appList != null && !appList.isEmpty()) {
            SortedMap<Long, UsageStats> mySortedMap = new TreeMap<>();
            for (UsageStats usageStats : appList) {
                mySortedMap.put(usageStats.getLastTimeUsed(), usageStats);
            }
            if (!mySortedMap.isEmpty()) {
                currentApp = Objects.requireNonNull(mySortedMap.get(mySortedMap.lastKey())).getPackageName();
            }
        }
        return currentApp;
    }
    
    private void addStatsViewMainScreen() {
        userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
        new Handler(Looper.getMainLooper()).postDelayed(()-> {
            Launcher launcher = Launcher.getLauncher();
            if (launcher == null || launcher.mAppsCustomizeTabHost == null) {
                return;
            }
            // Over the home screen only. hasPipStarted() is a pref, still the one from before a
            // restart: at a cold boot with LAUNCHER_HOME_COLD_START off the last app was back in
            // front at 27.5 s, this service started at 29.5 s, and the home screen's stats came
            // up over that app (capture 13-10-2026 00:11). The panes coming up on the home screen
            // add them anyway (PIP_STARTED).
            if (!launcher.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                return;
            }
            if (userLayout 
                && prefs.getBoolean("main_screen_stats", true)
                && helpers.hasPipStarted()
                && !helpers.allAppsVisibility(launcher.mAppsCustomizeTabHost.getVisibility())) {

                addStatsView(false);
            }
        }, 200);
    }

    private void addStatsView(boolean mapApp) {
        if ((mapApp && prevView.equals("app"))
         || (!mapApp && prevView.equals("main"))) {
            return;
        }
        removeView();
        userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
        userStats = prefs.getBoolean(Keys.USER_STATS, false);
        if (userLayout && userStats) {
            textColor = prefs.getString("stats_color", "#FFFFFFFF");
            String bgColor = prefs.getString("bg_stats_color", "#FF000000");
            int bgAlpha = prefs.getInt(Keys.ALPHA_SEEK_BAR, 255);
            boolean background = prefs.getBoolean("stats_bg", true);
            boolean leftBar = prefs.getBoolean(Keys.LEFT_BAR, false);
            boolean drawableBg = prefs.getBoolean("bg_drawable", false);
            boolean colorBg = prefs.getBoolean("bg_color", false);
            int margin = Integer.parseInt(prefs.getString(Keys.LAYOUT_MARGIN, "5"));
            int radius;

            wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            int leftBarSize = Launcher.calculatedLeftBarWidth;
            if (mapApp) {
                statsWidthSelector = prefs.getInt(Keys.APP_STATS_WIDTH_SELECTOR, 0);
                statsWidth = prefs.getInt(Keys.APP_STATS_WIDTH, Launcher.calculatedStatsWidth);
            } else {
                statsWidthSelector = prefs.getInt(Keys.STATS_WIDTH_SELECTOR, 0);
                statsWidth = prefs.getInt(Keys.STATS_WIDTH, Launcher.calculatedStatsWidth);
            }
            statsHeight = Launcher.calculatedStatsHeight;

            if (getResources().getDisplayMetrics().widthPixels <= 1024
                || (getResources().getDisplayMetrics().heightPixels <= 1024 && getResources().getDisplayMetrics().heightPixels != 720)) {
                radius = 10;
            } else if (getResources().getDisplayMetrics().heightPixels == 720) {
                radius = 12;
            } else {
                radius = 14;            
            } 
            if (mapApp) {
                int maxBorderX = getScreenWidth();
                statsTopLeftX = prefs.getInt("appStatsTopLeftX", maxBorderX - statsWidth - margin);
                statsTopLeftY = prefs.getInt("appStatsTopLeftY", margin + getStatusBarHeight()) + getStatusBarHeight();
            } else {
                if (leftBar) {
                    statsTopLeftX = prefs.getInt("statsTopLeftX", margin + 10) + leftBarSize;
                } else {
                    statsTopLeftX = prefs.getInt("statsTopLeftX", margin + 10);
                }   
                statsTopLeftY = prefs.getInt("statsTopLeftY", margin + 10) + getStatusBarHeight();                 
            }
            
            absoluteStats = li.inflate(R.layout.absolute_stats, null); 

            TextView consumptionTV = absoluteStats.findViewById(R.id.instantaneous_consumption_str);
            TextView mileageTV = absoluteStats.findViewById(R.id.driving_mileage_str);

            if (statsWidthSelector == 1) {
                consumptionTV.setText(consumptionTV.getContext().getString(R.string.instantaneous_consumption_mini));
                mileageTV.setText(mileageTV.getContext().getString(R.string.driving_mileage_mini));
            } else if (statsWidthSelector == 2) {
                consumptionTV.setText("");
                mileageTV.setText(""); 
            }
            consumptionTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, Launcher.textSizeBasic);
            mileageTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, Launcher.textSizeBasic);

            consumptionTextView = absoluteStats.findViewById(R.id.instantaneous_consumption_val);
            mileageTextView = absoluteStats.findViewById(R.id.driving_mileage_val);

            if (statsWidthSelector == 2) {
                consumptionTextView.setText(consumptionTextView.getContext().getString(R.string.instantaneous_consumption_val_mini, "0.0"));
                mileageTextView.setText(mileageTextView.getContext().getString(R.string.driving_mileage_val_mini, "-.-"));      
            } else {
                consumptionTextView.setText(consumptionTextView.getContext().getString(R.string.instantaneous_consumption_val, "0.0"));
                mileageTextView.setText(mileageTextView.getContext().getString(R.string.driving_mileage_val, "-.-"));                
            }
            
            consumptionTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, Launcher.textSizeBasic); 
            mileageTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, Launcher.textSizeBasic);
            fitStatsText(statsWidth, statsHeight, consumptionTV, consumptionTextView, mileageTV, mileageTextView);
            if (background) {
                if (drawableBg) {
                    absoluteStats.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_custom));
                } else if (colorBg) {
                    GradientDrawable shape =  new GradientDrawable();
                    shape.setCornerRadius(radius);
                    shape.setColor(Color.parseColor(bgColor));
                    shape.setAlpha(bgAlpha);
                    absoluteStats.setBackground(shape);
                }
                
            }

            // --- compute workspace & page metrics early so we can compute final placement BEFORE adding view ---
            statsLayoutParams = new WindowManager.LayoutParams(
                    statsWidth,
                    statsHeight,
                    statsTopLeftX, // temporary; we'll overwrite below with safeLayoutX
                    statsTopLeftY,
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    // Display only: every touch (taps, swipes, long presses) goes through to the
                    // app or home screen underneath, which the stats would otherwise block.
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                            | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                            | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                    PixelFormat.TRANSLUCENT
            );
            statsLayoutParams.gravity = Gravity.TOP | Gravity.START;
            // The overlay follows the pages on every frame of a scroll; WindowManager would animate
            // each of those moves and the stats would trail the page (see PaneWindows).
            Log.i(TAG, "stats window move animation off (" + PaneWindows.disableMoveAnimation(statsLayoutParams) + ")");

            // tags / prevView (your existing code)
            if (mapApp) {
                prevView = "app";
                absoluteStats.setTag("app");
            } else {
                prevView = "main";
                absoluteStats.setTag("main");
            }

            // If this is the main/home stats, compute anchored coordinates BEFORE adding to WM
            if (!mapApp) {
                try {
                    // compute workspace & page metrics early
                    Launcher mainLauncher = Launcher.getLauncher();
                    workspaceRef = mainLauncher != null ? mainLauncher.getWorkspace() : null;
                    if (workspaceRef != null) {
                        try {
                            statsPageWidth = workspaceRef.getViewportWidth();
                        } catch (Exception e) {
                            statsPageWidth = workspaceRef.getWidth();
                        }
                    } else {
                        statsPageWidth = getResources().getDisplayMetrics().widthPixels;
                    }

                    int statsScreen = prefs.getInt(Keys.STATS_SCREEN, 1) - 1;

                    // try to read placeholderX/Y if available
                    int placeholderX = statsTopLeftX;
                    int placeholderY = statsTopLeftY;
                    try {
                        View pageView = workspaceRef != null ? workspaceRef.getChildAt(statsScreen) : null;
                        if (pageView instanceof com.android.launcher66.CellLayout) {
                            int[] pos = ((com.android.launcher66.CellLayout) pageView).getStatsPlaceholderPosition();
                            if (pos != null && pos.length >= 4) {
                                placeholderX = pos[0];
                                placeholderY = pos[1];
                            }
                        }
                    } catch (Exception ignored) {}

                    // compute base absolute X
                    statsAbsoluteBaseX = (statsScreen * Math.max(1, statsPageWidth)) + placeholderX;

                    // compute desired screenX using current workspace scroll (use mUnboundedScrollX if available)
                    int currentScroll = 0;
                    if (workspaceRef != null) {
                        // prefer mUnboundedScrollX if launcher exposes it (keeps overscroll info)
                        try { currentScroll = workspaceRef.mUnboundedScrollX; } catch (Throwable t) { currentScroll = workspaceRef.getScrollX(); }
                    }
                    int pipAbsoluteX = statsAbsoluteBaseX;
                    int desiredScreenX = pipAbsoluteX - currentScroll;

                    int pageWidth = Math.max(1, statsPageWidth);
                    if (PaneWindows.relayoutIsAsync(Build.VERSION.SDK_INT)) {
                        // From Android 14 on a move of the window is a relayoutAsync() that queued
                        // up behind the panes' on the A55, 0.4-0.5 s. So the window spans the page
                        // and stays where it is; the stats move inside it by translationX, in the
                        // frame the pages are drawn in, and the window's edges are the screen's.
                        // Not touchable, so its width takes no touch from the home screen.
                        statsLayoutParams.width = pageWidth;
                        statsLayoutParams.x = 0;
                        statsLayoutParams.y = placeholderY;
                        statsHost = new FrameLayout(this);
                        statsHost.addView(absoluteStats, new FrameLayout.LayoutParams(statsWidth, statsHeight));

                        wm.addView(statsHost, statsLayoutParams);
                        absoluteStats.setTranslationX(desiredScreenX);
                    } else {
                        // Before Android 14 relayout() waits for WindowManager, which places the
                        // window in the frame it is asked in. The stats are moved as the panes
                        // are: a window of their own size at their place, partly or wholly beside
                        // the screen as well (FLAG_LAYOUT_NO_LIMITS, which the panes have), from
                        // the animation phase (onPagesFrame()). Clamped to the screen, as it was,
                        // the window stopped at the screen's edge and the stats left it by
                        // translationX, a new frame of their own window: on the 7862 the one
                        // render thread draws that after the launcher's frame, a vsync after the
                        // page.
                        statsLayoutParams.flags |= WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
                        statsLayoutParams.x = desiredScreenX;
                        statsLayoutParams.y = placeholderY;

                        wm.addView(absoluteStats, statsLayoutParams);
                        absoluteStats.setTranslationX(0f);
                    }

                    // attach listener afterward (same as before)
                    if (!mapApp && workspaceRef != null) {
                        final Workspace wsFinal = workspaceRef;
                        workspaceScrollListener = () -> {
                            int scrollX;
                            try { scrollX = wsFinal.mUnboundedScrollX; } catch (Throwable t) { scrollX = wsFinal.getScrollX(); }
                            updateStatsPositionForScroll(scrollX);
                        };
                        workspaceRef.getViewTreeObserver().addOnScrollChangedListener(workspaceScrollListener);
                        // update once
                        updateStatsPositionForScroll(currentScroll);
                    }

                } catch (Exception e) {
                    Log.w(TAG, "Failed to attach workspace scroll listener or add view: " + e.getMessage());
                    // fallback: ensure the view is added so at least mapApp path works
                    try {
                        if (statsHost != null ? statsHost.getParent() == null
                                : absoluteStats.getParent() == null) {
                            // The window did not make it: the stats go in on their own and are
                            // moved as a window of their size.
                            if (statsHost != null) {
                                statsHost.removeView(absoluteStats);
                                statsHost = null;
                                statsLayoutParams.width = statsWidth;
                            }
                            wm.addView(absoluteStats, statsLayoutParams);
                        }
                    } catch (Exception ex) {
                        Log.w(TAG, "Fallback addView failed: " + ex.getMessage());
                    }
                }
            } else {
                // mapApp case (no workspace anchoring) — add as before
                try {
                    wm.addView(absoluteStats, statsLayoutParams);
                } catch (Exception e) {
                    Log.w(TAG, "addView(mapApp) failed: " + e.getMessage());
                }
            }

            // existing post-add calls
            mUpdaterOilExpend();
            mUpdaterDrivingMileage();
            mUpdaterRPM();
        }
    }

    public void removeView() {
        if (absoluteStats != null) {
            // detach listeners, remove from WM as before...
            try {
                if (workspaceRef != null && workspaceScrollListener != null) {
                    try { workspaceRef.getViewTreeObserver().removeOnScrollChangedListener(workspaceScrollListener); } catch (Exception ignored) {}
                    workspaceScrollListener = null;
                }
                if (wm != null) {
                    // reset translation before removing to leave the view in a known state
                    try { absoluteStats.setTranslationX(0f); } catch (Exception ignored) {}
                    wm.removeView(statsHost != null ? statsHost : absoluteStats);
                    if (statsHost != null) {
                        statsHost.removeView(absoluteStats);
                    }
                }
            } catch (Exception e) {
                Log.w(TAG, "Error removing stats view: " + e.getMessage());
            } finally {
                absoluteStats = null;
                statsHost = null;
                statsLayoutParams = null;
                workspaceRef = null;
                statsAbsoluteBaseX = 0;
                statsPageWidth = 0;
                consumptionTextView = null;
                mileageTextView = null;
                prevView = "";
            }
        }
    }

    /**
     * Update absoluteStats overlay position so it exactly matches the CellLayout stats placeholder
     * and smoothly moves off/on screen while avoiding OEM clamping of negative LayoutParams.x.
     */
    private void updateStatsPositionForScroll(int scrollOffset) {
        if (absoluteStats == null || statsLayoutParams == null || workspaceRef == null) return;

        // page metrics and clamping
        int pageCount = Math.max(1, workspaceRef.getChildCount());
        int pageWidth = Math.max(1, statsPageWidth > 0 ? statsPageWidth : workspaceRef.getWidth());
        int maxScroll = Math.max(0, (pageCount - 1) * pageWidth);
        int effectiveScroll = Math.max(0, Math.min(scrollOffset, maxScroll));

        // get placeholder (preferred) or fallback
        int statsScreen = prefs.getInt(Keys.STATS_SCREEN, 1) - 1;
        int placeholderX = Integer.MIN_VALUE;
        int placeholderY = Integer.MIN_VALUE;
        int placeholderW = 0;
        int placeholderH = 0;
        try {
            View pageView = workspaceRef.getChildAt(statsScreen);
            if (pageView instanceof com.android.launcher66.CellLayout) {
                com.android.launcher66.CellLayout cellLayout = (com.android.launcher66.CellLayout) pageView;
                int[] pos = null;
                try { pos = cellLayout.getStatsPlaceholderPosition(); } catch (Exception ignored) {}
                if (pos != null && pos.length >= 4) {
                    placeholderX = pos[0];
                    placeholderY = pos[1];
                    placeholderW = pos[2];
                    placeholderH = pos[3];
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to query stats placeholder: " + e.getMessage());
        }

        if (placeholderX == Integer.MIN_VALUE) {
            if (statsAbsoluteBaseX != 0 && pageWidth > 0) {
                int expectedPage = statsAbsoluteBaseX / pageWidth;
                placeholderX = statsAbsoluteBaseX - (expectedPage * pageWidth);
            } else {
                placeholderX = statsLayoutParams.x;
            }
        }
        if (placeholderY == Integer.MIN_VALUE) {
            placeholderY = statsLayoutParams.y;
        }
        if (placeholderW == 0) placeholderW = statsLayoutParams.width > 0 ? statsLayoutParams.width : absoluteStats.getWidth();
        if (placeholderH == 0) placeholderH = statsLayoutParams.height > 0 ? statsLayoutParams.height : absoluteStats.getHeight();

        // compute desired screen X
        int pipAbsoluteX = (statsScreen * pageWidth) + placeholderX;
        int desiredScreenX = pipAbsoluteX - effectiveScroll;

        // *** NEW: clamp anchor to viewport so WM won't clamp it unexpectedly ***
        int viewWidth = Math.max(1, placeholderW);
        int maxAnchorX = Math.max(0, pageWidth - viewWidth); // if viewWidth > pageWidth this becomes 0
        int safeLayoutX = Math.max(0, Math.min(desiredScreenX, maxAnchorX));

        float translationX = (float) (desiredScreenX - safeLayoutX);

        // desired Y - make sure to use placeholderY if that was stored in screen coordinates
        int desiredY = placeholderY;

        if ((statsLayoutParams.flags & WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS) != 0) {
            // A window of the stats' size at their place, moved as a pane is (see addStatsView()).
            // Beside the screen before and after, it is left where it is: the move would show
            // nothing and only cost a relayout.
            try {
                int width = statsLayoutParams.width > 0 ? statsLayoutParams.width : Math.max(1, placeholderW);
                int screenWidth = Math.max(pageWidth, getScreenWidth());
                int oldX = statsLayoutParams.x;
                boolean moved = oldX != desiredScreenX && !PaneWindows.staysOffScreen(oldX,
                        oldX + width, desiredScreenX, desiredScreenX + width, true, screenWidth);
                if ((moved || statsLayoutParams.y != desiredY) && wm != null) {
                    statsLayoutParams.x = desiredScreenX;
                    statsLayoutParams.y = desiredY;
                    wm.updateViewLayout(absoluteStats, statsLayoutParams);
                }
            } catch (Exception e) {
                Log.w(TAG, "Failed to update absoluteStats position: " + e.getMessage());
            }
            return;
        }

        if (statsHost != null) {
            // The page-wide window stays; only the stats move inside it, see addStatsView().
            try {
                if (statsLayoutParams.y != desiredY || statsLayoutParams.width != pageWidth) {
                    statsLayoutParams.x = 0;
                    statsLayoutParams.y = desiredY;
                    statsLayoutParams.width = pageWidth;
                    wm.updateViewLayout(statsHost, statsLayoutParams);
                }
                int current = Math.round(absoluteStats.getTranslationX());
                int width = absoluteStats.getWidth() > 0 ? absoluteStats.getWidth() : statsWidth;
                // Beside the window before and after: drawn again, the stats would show nothing
                // (HWUI: "Dirty ... doesn't intersect with 0 0 1080 117", on every frame of a swipe
                // on the A55, log 28-10-2026 02:01).
                if (current != desiredScreenX && !PaneWindows.staysOffScreen(current,
                        current + width, desiredScreenX, desiredScreenX + width, true, pageWidth)) {
                    absoluteStats.setTranslationX(desiredScreenX);
                }
            } catch (Exception e) {
                Log.w(TAG, "Failed to update absoluteStats position: " + e.getMessage());
            }
            return;
        }

        boolean needUpdateLayout = false;
        if (statsLayoutParams.x != safeLayoutX) {
            statsLayoutParams.x = safeLayoutX;
            needUpdateLayout = true;
        }
        if (statsLayoutParams.y != desiredY) {
            statsLayoutParams.y = desiredY;
            needUpdateLayout = true;
        }

        try {
            if (needUpdateLayout && wm != null && absoluteStats != null) {
                wm.updateViewLayout(absoluteStats, statsLayoutParams);
            }
            // always apply translation; positive or negative allowed -- unless the window stays
            // and the stats are beside it before and after: drawn again, they would show nothing
            int current = Math.round(absoluteStats.getTranslationX());
            int target = Math.round(translationX);
            int width = Math.max(1, absoluteStats.getWidth() > 0 ? absoluteStats.getWidth() : viewWidth);
            int windowWidth = statsLayoutParams.width > 0 ? statsLayoutParams.width : Integer.MAX_VALUE;
            boolean hidden = !needUpdateLayout && PaneWindows.staysOffScreen(current,
                    current + width, target, target + width, true, windowWidth);
            if (absoluteStats.getTranslationX() != translationX && !hidden) {
                absoluteStats.setTranslationX(translationX);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to update absoluteStats position: " + e.getMessage());
        }
    }

    public int getStatusBarHeight() { 
          int result = 0;
          int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
          if (resourceId > 0) {
              result = getResources().getDimensionPixelSize(resourceId);
          } 
          return result;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public void addNotify() {
        // The codes may differ from those of the last start
        unregisterStatsCodes();
        DataCanbus.NOTIFY_EVENTS[1000].addNotify(this.mNotifyCar, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1000].removeNotify(this.mNotifyCar);
        unregisterStatsCodes();
    }

    private void registerStatsCodes() {
        unregisterStatsCodes();
        // the codes of all the library's pairs: which one the radio reports is found out from their values
        Set<Integer> wanted = new LinkedHashSet<>(Arrays.asList(fuelCode, rangeCode, rpmCode, speedCode));
        FuelUnit unit = fuelUnit;
        if (unit != null && unit.unitCode() >= 0) {
            wanted.add(unit.unitCode());
        }
        CodePairChooser chooser = pairChooser;
        if (chooser != null) {
            wanted.addAll(chooser.codes());
        }
        for (int code : wanted) {
            if (code > 0 && statsCodesRegistered.add(code)) {
                DataCanbus.PROXY.unregister(statsCallback, code);
                DataCanbus.PROXY.register(statsCallback, code, 1);
            }
        }
    }

    /** The pairs of the library for the car: a new chooser, or the one that is there if nothing changed. Main thread. */
    private void setUpPairs(int carId, List<CanbusLibrary.CarCodes> pairs) {
        CodePairChooser chooser = pairChooser;
        if (chooser != null && pairCarId == carId && chooser.status().pairs.equals(pairs)) {
            return;
        }
        pairCarId = carId;
        lastCodeValues.clear();
        if (pairs.isEmpty()) {
            pairChooser = null;
            sPairInfo = null;
            return;
        }
        chooser = new CodePairChooser(pairs);
        String saved = prefs.getString(CodePairChooser.key(carId), null);
        pairSaved = saved == null ? "" : saved;
        CanbusLibrary.CarCodes before = CodePairChooser.decode(saved);
        if (before != null) {
            chooser.restore(before);
        }
        pairChooser = chooser;
        sPairInfo = new PairInfo(carId, chooser.status());
    }

    /**
     * The fuel and range codes in use: those of the settings, else those of the pair in use, else 0. Returns whether
     * the fuel code changed, which is another model of the estimate. Main thread.
     */
    private boolean applyPairCodes() {
        CodePairChooser chooser = pairChooser;
        CanbusLibrary.CarCodes pair = chooser == null ? null : chooser.status().pair();
        int newFuel = fuel > 0 ? fuel : pair != null && pair.fuel > 0 ? pair.fuel : 0;
        int newRange = range > 0 ? range : pair != null && pair.range > 0 ? pair.range : 0;
        boolean fuelChanged = newFuel != fuelCode;
        boolean rangeChanged = newRange != rangeCode;
        fuelCode = newFuel;
        rangeCode = newRange;
        if (fuelChanged) {
            Integer v = lastCodeValues.get(newFuel);
            fuelRaw = v == null ? 0 : v;
            fuelValue = fuelFromRaw(fuelRaw);
        }
        if (rangeChanged) {
            Integer v = lastCodeValues.get(newRange);
            rangeValue = v == null ? 0 : v;
        }
        return fuelChanged;
    }

    /** The pair in use changed (a value confirmed one, or the chosen one has been silent for long). Main thread. */
    private void onPairChanged() {
        CodePairChooser chooser = pairChooser;
        if (chooser == null || sInstance != this) {
            return;
        }
        CodePairChooser.Status status = chooser.status();
        sPairInfo = new PairInfo(pairCarId, status);
        boolean fuelChanged = applyPairCodes();
        if (fuelChanged) {
            loadFuelModel(pairCarId);
        }
        if (status.confirmed) {
            final String text = CodePairChooser.encode(status.index, status.pair());
            if (!text.equals(pairSaved)) {
                pairSaved = text;
                final String key = CodePairChooser.key(pairCarId);
                // apply() writes in the background, but it also takes the editor's lock: not here
                CanbusLibrary.executor().execute(() -> prefs.edit().putString(key, text).apply());
            }
        }
        if (fuelChanged && lastCodeValues.containsKey(fuelCode)) {
            mUpdaterOilExpend();
        }
        if (lastCodeValues.containsKey(rangeCode)) {
            mUpdaterDrivingMileage();
        }
    }

    private void unregisterStatsCodes() {
        for (int code : statsCodesRegistered) {
            DataCanbus.PROXY.unregister(statsCallback, code);
        }
        statsCodesRegistered.clear();
    }

    /**
     * After a wake the car may have lost its request (the canbus connection does not always drop and
     * come back, which is what sends it again): once more, when the unit has had a moment to settle.
     * Any thread.
     */
    public static void resendRequestAfterWake() {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            CanbusService service = sInstance;
            if (service == null) {
                return;
            }
            int carId = DataCanbus.DATA[1000];
            if (carId != 0) {
                CanbusLibrary.sendForCar(service.getApplicationContext(), carId);
            }
        }, 3000L);
    }

    /** The consumption in the raw value of the fuel code: masked where the protocol keeps the unit in a bit of it. */
    private int fuelFromRaw(int raw) {
        FuelUnit unit = fuelUnit;
        return unit != null ? unit.consumption(raw) : raw;
    }

    /**
     * The unit of the consumption the protocol reports now: L/100 km or L/h, or null when the library does not say, the
     * code of the unit has not been reported yet, or it is a unit the launcher does not use (gallons, mpg).
     */
    private FuelUnit.Unit protocolUnit() {
        FuelUnit unit = fuelUnit;
        if (unit == null) {
            return null;
        }
        return unit.unitNow(unit.unitCode() >= 0 ? lastCodeValues.get(unit.unitCode()) : null, fuelRaw);
    }

    public void mUpdaterOilExpend() {
        if (fuelModel != null) {
            long now = System.currentTimeMillis();
            touchRpm(now);
            fuelModel.onFuel(now, fuelValue);
            if (now - fuelModelSavedAt > FUEL_MODEL_SAVE_MS) {
                saveFuelModel();        // what it learned survives a restart, now and then
            }
        }
        showFuel();
    }

    /**
     * The consumption in the widget: the car's value in the unit {@link ConsumptionUnits} says (the unit of the protocol, or
     * litres per hour at a low speed), the estimate where the car gives none, else 0. Main thread.
     */
    private void showFuel() {
        if (!(userLayout && userStats && absoluteStats != null)
                || absoluteStats.findViewById(R.id.instantaneous_consumption_val) == null) {
            return;
        }
        int value = fuelValue;
        ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_str)).setTextColor(Color.parseColor(textColor));
        ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setTextColor(Color.parseColor(textColor));
        if (value > 0 && value < 3001) {
            setFuelText(value, carValueShown(value));
        } else if (!showFuelEstimate()) {
            // No value from the car, and no estimate (none learned yet, or no fuel code)
            setFuelText(0, value == 0 ? carValueShown(0) : null);
        }
    }

    /** What {@link ConsumptionUnits} makes of the car's value now; null = as it was shown before (L/100 km). */
    private ConsumptionUnits.Shown carValueShown(int value) {
        FuelModel model = fuelModel;
        FuelUnit.Unit reported = protocolUnit();
        ConsumptionUnits.Unit protocol = reported == null ? null
                : reported == FuelUnit.Unit.LH ? ConsumptionUnits.Unit.LH : ConsumptionUnits.Unit.L100;
        if (model == null) {
            return ConsumptionUnits.forCarValue(value, protocol, false, false, false, 0, false);
        }
        return ConsumptionUnits.forCarValue(value, protocol, model.thresholdCar(), model.lowSpeed(),
                model.speedKnown(System.currentTimeMillis()), model.speedKmh(), model.isMoving());
    }

    /** The text of a value of the car: {@code raw} as L/100 km (× 10) unless {@code shown} says litres per hour. */
    private void setFuelText(int raw, ConsumptionUnits.Shown shown) {
        boolean mini = statsWidthSelector == 2;
        Context context = consumptionTextView.getContext();
        fuelShownPerHour = shown != null && shown.unit == ConsumptionUnits.Unit.LH;
        if (fuelShownPerHour) {
            consumptionTextView.setText(context.getString(
                    mini ? R.string.instantaneous_consumption_per_hour_mini : R.string.instantaneous_consumption_per_hour,
                    String.format(Locale.ROOT, "%.1f", shown.value)));
            return;
        }
        // L/100 km: the value of the car (of the protocol: its own decimal), as it was
        int tenths = shown != null ? (int) Math.round(shown.value * 10) : raw;
        consumptionTextView.setText(context.getString(
                mini ? R.string.instantaneous_consumption_val_mini : R.string.instantaneous_consumption_val,
                String.format(Locale.getDefault(), "%d.%d", tenths / 10, tenths % 10)));
    }

    /**
     * The estimate in the widget, where the car gives no value and the model has learned enough of the car's
     * own values; false (nothing shown) otherwise. Main thread.
     */
    private boolean showFuelEstimate() {
        FuelModel.Estimate e = fuelModel != null ? fuelModel.estimate(System.currentTimeMillis()) : null;
        if (e == null || consumptionTextView == null) {
            return false;
        }
        boolean mini = statsWidthSelector == 2;
        int text = e.perHour
                ? (mini ? R.string.instantaneous_consumption_idle_mini : R.string.instantaneous_consumption_idle)
                : (mini ? R.string.instantaneous_consumption_estimated_mini : R.string.instantaneous_consumption_estimated);
        consumptionTextView.setText(consumptionTextView.getContext().getString(text, e.text()));
        return true;
    }

    /**
     * After a new speed: the estimate follows it while the car gives no value, and the car's own value changes its unit
     * at a low speed (litres per hour under 10 km/h, back to L/100 km above 13). Main thread.
     */
    private void refreshFuelEstimate() {
        if (fuelModel == null) {
            return;
        }
        if (!fuelModel.carGivesNoValue(System.currentTimeMillis())) {
            if (fuelModel.lowSpeed() || fuelShownPerHour) {
                showFuel();
            }
            return;
        }
        if (userLayout && userStats && absoluteStats != null
                && absoluteStats.findViewById(R.id.instantaneous_consumption_val) != null) {
            showFuelEstimate();
        }
    }

    /** The code of the unit changed (the car, or its screen, switched between L/100 km and L/h). Main thread. */
    private void onFuelUnitChanged() {
        if (fuelModel != null && fuelModel.carGivesNoValue(System.currentTimeMillis())) {
            refreshFuelEstimate();
        } else {
            showFuel();
        }
    }

    /** The model of the car and its fuel code, from the settings; none without a fuel code. Main thread. */
    private void loadFuelModel(int carId) {
        saveFuelModel();
        if (fuelCode <= 0) {
            fuelModel = null;
            fuelModelKey = null;
            return;
        }
        String key = FuelModel.key(carId, fuelCode);
        if (!key.equals(fuelModelKey)) {
            fuelModel = FuelModel.parse(prefs.getString(key, null));
            fuelModelKey = key;
        }
    }

    private void saveFuelModel() {
        fuelModelSavedAt = System.currentTimeMillis();
        if (fuelModel != null && fuelModelKey != null && prefs != null) {
            prefs.edit().putString(fuelModelKey, fuelModel.serialize()).apply();
        }
    }

    /** A value of the speed code: km/h once its scale is known. Main thread. */
    private void onSpeedCode() {
        speedScale.onValue(speedValue);
        int scale = speedScale.scale();
        if (scale > 0) {
            onDriving(speedValue / (double) scale);
        }
        if (scale > 0 && fuelModel != null) {
            long now = System.currentTimeMillis();
            fuelModel.onSpeed(now, speedValue / (double) scale, true);
            touchRpm(now);
            refreshFuelEstimate();
        }
    }

    public void mUpdaterDrivingMileage() {
        if (userLayout && userStats && absoluteStats != null) {
            int value = rangeValue;
            if (absoluteStats.findViewById(R.id.driving_mileage_val) != null) {
                ((TextView) absoluteStats.findViewById(R.id.driving_mileage_str)).setTextColor(Color.parseColor(textColor));
                ((TextView) absoluteStats.findViewById(R.id.driving_mileage_val)).setTextColor(Color.parseColor(textColor));
                if (value > -1 && value < 2001) {
                    if (statsWidthSelector == 2) {
                        mileageTextView.setText(mileageTextView.getContext().getString(R.string.driving_mileage_val_mini, String.valueOf(value)));
                    } else {
                        mileageTextView.setText(mileageTextView.getContext().getString(R.string.driving_mileage_val, String.valueOf(value)));              
                    }
                } else {
                    if (statsWidthSelector == 2) {
                        mileageTextView.setText(mileageTextView.getContext().getString(R.string.driving_mileage_val_mini, "-.-")); 
                    } else {
                        mileageTextView.setText(mileageTextView.getContext().getString(R.string.driving_mileage_val, "-.-"));               
                    }
                }
            }
        }
    }

    public void mUpdaterRPM() {
        if (fuelModel != null) {
            fuelModel.onRpm(System.currentTimeMillis(), rpmValue);
        }
    }

    /**
     * The RPM is only reported when it changes, and the model takes a value older than 5 s as unknown: with each
     * new speed or fuel value the last one is given again (at a stop with the engine off it stays 0). Main thread.
     */
    private void touchRpm(long now) {
        if (fuelModel != null && rpmCode > 0 && lastCodeValues.containsKey(rpmCode)) {
            fuelModel.onRpm(now, rpmValue);
        }
    }

    /**
     * The GPS speed, for the estimate of the consumption where the car gives none (FuelModel), when there is
     * no speed code, and to find the scale of the speed code.
     */
    private void requestLocationUpdates() {
        removeLocationUpdates();

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && 
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // The speed, about every half second: the GPS provider of the platform, Google Play
            // services only if the unit has none (see DeviceLocation).
            locationUpdates = DeviceLocation.requestUpdates(this, 500L, this::onLocation, Looper.getMainLooper());
        } else {            
            ActivityCompat.requestPermissions(
                    Launcher.getLauncher(),
                    new String[]{
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION
                    },
                    0
            );
        }
    }

    /** The speed (km/h) from either source: driving time for the choice of the pair of codes. Main thread. */
    private void onDriving(double kmh) {
        CodePairChooser chooser = pairChooser;
        if (chooser != null && chooser.onDriving(System.currentTimeMillis(), kmh > DRIVING_KMH)) {
            onPairChanged();
        }
    }

    /** A fix from the location updates: its speed, for the estimate and for the scale of the speed code. */
    private void onLocation(Location location) {
        if (location == null || !location.hasSpeed()) {
            return;
        }
        double kmh = location.getSpeed() * 3.6;
        onDriving(kmh);
        if (speedCode > 0) {
            speedScale.onGps(kmh);
        }
        // The speed code, once its scale is known, is the better speed: faster, and exactly 0 at a stop
        if (fuelModel != null && (speedCode <= 0 || speedScale.scale() == 0)) {
            long now = System.currentTimeMillis();
            fuelModel.onSpeed(now, kmh, false);
            touchRpm(now);
            refreshFuelEstimate();
        }
    }

    private void removeLocationUpdates() {
        if (locationUpdates != null) {
            locationUpdates.remove();
        }
        locationUpdates = null;
    }

    public static class PropertyChangeClass {
        private String pString = "initial";
        private boolean pBoolean;
        private final PropertyChangeSupport mPropertyChangeSupport = new PropertyChangeSupport(this);

        public void setString(String name, String str) {
            String old = pString;
            pString = str;
            mPropertyChangeSupport.firePropertyChange(name, old, str);
        }

        public void setBoolean(String name, boolean bool) {
            boolean old = pBoolean;
            pBoolean = bool;
            mPropertyChangeSupport.firePropertyChange(name, old, bool);
        }

        public void addObserver(String name, PropertyChangeListener listener) {
            mPropertyChangeSupport.addPropertyChangeListener(name, listener);
        }

        public void deleteObserver(String name, PropertyChangeListener listener) {
            mPropertyChangeSupport.removePropertyChangeListener(name, listener);
        }
    }

    /**
     * Fits the two rows (label + value each) into the window, which is a share of the screen:
     * Launcher.textSizeBasic stays as it is where they fit, as on the FYT units the sizes come
     * from, and shrinks where a sp is a larger share of the screen (a phone) or the window is
     * narrow. The values are measured two digits longer than they start.
     */
    private static void fitStatsText(int width, int height, TextView consumptionLabel,
            TextView consumptionValue, TextView mileageLabel, TextView mileageValue) {
        if (width <= 0 || height <= 0) return;
        float px = consumptionValue.getTextSize();
        if (px <= 0f) return;
        android.graphics.Paint.FontMetrics fm = consumptionValue.getPaint().getFontMetrics();
        float lineHeight = fm.bottom - fm.top;
        float rowWidth = Math.max(
                rowWidth(consumptionLabel, consumptionValue), rowWidth(mileageLabel, mileageValue));
        float scale = 1f;
        // Some room to spare: two rows exactly as tall as the window lost a pixel to rounding,
        // and the column then wrapped the second row out of the window (the narrowest window,
        // where the height decides).
        if (lineHeight > 0f) scale = Math.min(scale, (height * 0.9f / 2f) / lineHeight);
        if (rowWidth > 0f) scale = Math.min(scale, width * 0.95f / rowWidth);
        if (scale >= 1f) return;
        for (TextView view : new TextView[]{ consumptionLabel, consumptionValue, mileageLabel, mileageValue }) {
            view.setTextSize(TypedValue.COMPLEX_UNIT_PX, px * scale);
        }
    }

    private static float rowWidth(TextView label, TextView value) {
        return label.getPaint().measureText(label.getText().toString())
                + value.getPaint().measureText(value.getText() + "88");
    }

}