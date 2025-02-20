package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import java.util.List;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.GradientDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.os.SystemProperties;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.AppsCustomizePagedView;
import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.Workspace;
import com.android.recycler.AppListDialogFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.ServiceRestarter;
import com.syu.util.WindowUtil;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class CanbusService extends Service implements PropertyChangeListener, LocationListener {

    private static final String TAG = "CanbusService";
    private AccessibilityManager accessibilityManager;
    private AccessibilityManager.AccessibilityStateChangeListener accessibilityListener;
    private FusedLocationProviderClient fusedLocationClient;
    private SharedPreferences prefs;
    private Helpers helpers = new Helpers();
    private IBinder binder;
    private View absoluteStats;
    private WindowManager wm;  
    private String textColor = "#FFFFFFFF"; 
    private String curForegroundApp = "";
    private Set<String> apps = new HashSet<String>();  
    private static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    private static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    private static final String RECYCLER_APP = "recycler.app";
    private static final String ACCESIBILITY_SERVICE = "accesibility.service";
    private static final String ALLAPPS = "allapps";
    private static final String FUELSTATS = "fuelStats";
    private PropertyChangeClass mPropertyChangeClass = new PropertyChangeClass();
    private String curApp = "init";
    private boolean estimateOil = false;
    private int fuel = 0;
    private int range = 0;
    private int rpm = 0;
    private double velocity = 0;
    private int horsePower = 0;
    private int vehicleMass = 0;
    private int engineVolume = 0;
    private int numberOfCylinders = 0;

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service created");
        prefs = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        horsePower = Integer.parseInt(prefs.getString("horse_power_code_int", "0"));
        vehicleMass = Integer.parseInt(prefs.getString("vehicle_mass_code_int", "0")); // in kg
        engineVolume = Integer.parseInt(prefs.getString("engine_volume_code_int", "0")); // in cm³
        numberOfCylinders = Integer.parseInt(prefs.getString("cylinders_number_code_int", "0"));
        helpers = new Helpers();
        accessibilityManager = (AccessibilityManager) getSystemService(ACCESSIBILITY_SERVICE);
        registerAccessibilityEventListener();
        requestLocationUpdates();
        
        mPropertyChangeClass.addObserver(ALLAPPS, this);
        mPropertyChangeClass.addObserver(FUELSTATS, this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(WindowUtil.PIP_STARTED);
        filter.addAction(WindowUtil.PIP_REMOVED);
        filter.addAction(AppListDialogFragment.LIST_OPEN);
        filter.addAction(AppListDialogFragment.LIST_CLOSE);
        filter.addAction(Workspace.OVERVIEW_MODE_OPEN);
        filter.addAction(Workspace.OVERVIEW_MODE_CLOSE);
        filter.addAction(AppsCustomizePagedView.STATS_APP_FOREGROUND);
        filter.addAction(Launcher.ALL_APPS);
        filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        filter.addAction(RECYCLER_APP);
        filter.addAction(ACCESIBILITY_SERVICE);
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
            int cmdInt = intent.getIntExtra("cmdInt", 0);
            int cmdArr = intent.getIntExtra("cmdArr", 0);
            DataCanbus.PROXY.cmd(cmdInt, new int[]{cmdArr}, null, null);
            addStatsViewMainScreen();
            addNotify();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service destroyed");
        unregisterAccessibilityEventListener();
        mPropertyChangeClass.deleteObserver(ALLAPPS, this);
        mPropertyChangeClass.deleteObserver(FUELSTATS, this);
        unregisterReceiver(pipReceiver);
        removeNotify();
        wm.removeView(absoluteStats);
        Intent broadcastIntent = new Intent(this, ServiceRestarter.class);
        sendBroadcast(broadcastIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private void registerAccessibilityEventListener() {
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            accessibilityManager.addAccessibilityStateChangeListener(accessibilityListener = enabled -> {
                if (enabled) {
                    Log.d(TAG, "Accessibility service enabled");
                } else {
                    Log.d(TAG, "Accessibility service disabled");
                    openAccessibilitySettings();
                }
            });
        } else {
            Log.d(TAG, "Accessibility service is not enabled");
            openAccessibilitySettings();
        }
    }

    private void openAccessibilitySettings() {
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        LauncherApplication.sApp.startActivity(intent);
    }
    
    private void unregisterAccessibilityEventListener() {
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(accessibilityListener);
        }
    }
    
    private IUiNotify mNotifyCanbus = (updateCode, ints, flts, strs) -> {
        if (updateCode == fuel) {
            mUpdaterOilExpend();
        } else if (updateCode == range) {
            mUpdaterDrivingMileage();
        } else if (updateCode == rpm) {
            mUpdaterRPM();
        }
    };

    private final BroadcastReceiver pipReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if(intent.getAction() != null) {
                    switch (intent.getAction()) {
                        case WindowUtil.PIP_STARTED:
                            curForegroundApp = "com.android.launcher66";
                            mPropertyChangeClass.setString(FUELSTATS, curForegroundApp);
                            if (!helpers.isListOpen()) {
                                removeView();
                                addStatsViewMainScreen();
                            }
                            break;
                        case WindowUtil.PIP_REMOVED: 
                            removeView();
                            break;
                        case RECYCLER_APP:
                            removeView();
                            addStatsView(true);
                            break;
                        case AppListDialogFragment.LIST_OPEN:
                            curForegroundApp = "com.android.launcher66";
                            mPropertyChangeClass.setString(FUELSTATS, curForegroundApp);
                            removeView();
                            break;
                        case AppListDialogFragment.LIST_CLOSE:
                            curForegroundApp = "com.android.launcher66";
                            mPropertyChangeClass.setString(FUELSTATS, curForegroundApp);
                            removeView();
                            addStatsViewMainScreen();
                            break;
                        case Workspace.OVERVIEW_MODE_OPEN:
                            curForegroundApp = "com.android.launcher66";
                            mPropertyChangeClass.setString(FUELSTATS, curForegroundApp);
                            removeView();
                            break;
                        case Workspace.OVERVIEW_MODE_CLOSE:
                            curForegroundApp = "com.android.launcher66";
                            mPropertyChangeClass.setString(FUELSTATS, curForegroundApp);
                            if (!helpers.hasPipStarted()) {
                                removeView();
                                addStatsViewMainScreen();
                            }
                            break;
                        case AppsCustomizePagedView.STATS_APP_FOREGROUND:
                            removeView();
                            addStatsView(true);
                            break;
                        case Launcher.ALL_APPS:
                            curForegroundApp = "com.android.launcher66";
                            mPropertyChangeClass.setBoolean(ALLAPPS, true);
                            mPropertyChangeClass.setString(FUELSTATS, curForegroundApp);
                            removeView();
                            break;
                        case Intent.ACTION_CLOSE_SYSTEM_DIALOGS:
                            String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
                            if (reason != null) {
                                if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
                                    curForegroundApp = "com.android.launcher66";
                                    mPropertyChangeClass.setString(FUELSTATS, curForegroundApp);
                                }                       
                            }
                            break;
                        case ACCESIBILITY_SERVICE:
                            String packageName = intent.getStringExtra("package_name");
                            if (packageName.equals("com.android.launcher3")) {
                                helpers.setInRecent(true);
                                helpers.setInAllApps(false);
                                helpers.setWasInRecents(true);
                                curForegroundApp = "com.android.launcher66";
                                mPropertyChangeClass.setString(FUELSTATS, curForegroundApp);
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
    };

    private void currentForegroundApplication(String packageName) {
        SharedPreferences statsPrefs = getSharedPreferences("AppStatsPrefs", MODE_PRIVATE);
        apps = new HashSet<>(statsPrefs.getStringSet("stats_apps", new HashSet<String>()));
        String appPackageName = SystemProperties.get("persist.launcher.packagename", "");
        if (packageName.contains(":")) {
            packageName = packageName.substring(0, packageName.indexOf(":"));
        }
        if ((packageName.contains("com.android.launcher66") || packageName.contains("com.android.launcher66")) && !helpers.isForegroundAppOpened()) {
            curForegroundApp = "com.android.launcher66";
        } 
        if (packageName.contains(appPackageName) && (helpers.hasPipStarted() || helpers.isInRecent()) && !helpers.isForegroundAppOpened()) {
            curForegroundApp = "com.android.launcher66";
        }
        if (apps.contains(packageName)) {
            if (packageName.contains(appPackageName) && (helpers.hasPipStarted() || helpers.isInRecent() || helpers.isInOverviewMode()) && !helpers.isForegroundAppOpened()) {
                curForegroundApp = "com.android.launcher66";
            } else if (!helpers.isInOverviewMode() || !helpers.isListOpen() || !helpers.isInRecent()) {
                curForegroundApp = packageName;
            }
        }
        mPropertyChangeClass.setString(FUELSTATS, curForegroundApp);
        if (Launcher.mAppsCustomizeTabHost != null) {
            mPropertyChangeClass.setBoolean(ALLAPPS, allAppsVisibility(Launcher.mAppsCustomizeTabHost.getVisibility(), packageName));
        }      
    }

    private boolean allAppsVisibility(int visivility, String packageName) {
        if (visivility == View.INVISIBLE || visivility == View.GONE) {
            return false;
        } else if (!helpers.isInRecent() && !helpers.userWasInRecents()) {
            return true;
        }
        return false;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case ALLAPPS:
                Log.i("allappsChange", "\t(" + evt.getOldValue() + " -> " + evt.getNewValue() + ")");
                String val = String.valueOf(evt.getNewValue());
                if (val.contains("true") || val.contains("false")) {
                    Log.i("val", val);
                    helpers.setInAllApps(Boolean.valueOf(val));
                    if (Boolean.valueOf(val) && !curForegroundApp.contains("com.android.launcher")) {
                        removeView();
                    }                
                }
                break;
            case FUELSTATS:
                curApp = String.valueOf(evt.getNewValue());
                Log.i("fuelStatsChange", "\t(" + evt.getOldValue() + " -> " + evt.getNewValue() + ")" + " CurrentActivityName: " + getCurrentActivityName());
                if (String.valueOf(evt.getNewValue()).contains("com.android.launcher")) {
                    helpers.setForegroundAppOpened(false);
                }
                if (!String.valueOf(evt.getNewValue()).contains("com.android.launcher") && !helpers.isInAllApps() && !helpers.isInRecent() && !helpers.hasPipStarted() && !getCurrentActivityName().equals("com.android.settings")) {
                    helpers.setForegroundAppOpened(true);
                    removeView();
                    addStatsView(true);                   
                } else if (!helpers.hasPipStarted() || helpers.isInOverviewMode() || (helpers.isListOpen() && !helpers.isForegroundAppOpened())) {
                    removeView();
                }
                break;
        } 
    }   

    private String getCurrentActivityName() {
        String currentApp = "NULL";
        UsageStatsManager usm = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
        long time = System.currentTimeMillis();
        List<UsageStats> appList = usm.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, time - 1000 * 1000, time);
        if (appList != null && appList.size() > 0) {
            SortedMap<Long, UsageStats> mySortedMap = new TreeMap<>();
            for (UsageStats usageStats : appList) {
                mySortedMap.put(usageStats.getLastTimeUsed(), usageStats);
            }
            if (!mySortedMap.isEmpty()) {
                currentApp = mySortedMap.get(mySortedMap.lastKey()).getPackageName();
            }
        }
        return currentApp;
    }
    
    private void addStatsViewMainScreen() {
        if (prefs.getBoolean("main_screen_stats", true)) {
            addStatsView(false);
        }
    }

    private void addStatsView(boolean mapApp) {
        removeView();
        boolean userStats = prefs.getBoolean("user_stats", false);        
        boolean userLayout = prefs.getBoolean("user_layout", false);
        if (userLayout && userStats) {
            textColor = prefs.getString("stats_color", "#FFFFFFFF");
            String bgColor = prefs.getString("bg_stats_color", "#FF000000");
            boolean background = prefs.getBoolean("stats_bg", true);
            boolean leftBar = prefs.getBoolean("left_bar", false);
            boolean drawableBg = prefs.getBoolean("bg_drawable", false);
            boolean colorBg = prefs.getBoolean("bg_color", false);
            int margin = Integer.parseInt(prefs.getString("layout_margin", "10"));
            int radius;
            int flagParam = 0;
            wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            int statsTopLeftX, statsTopLeftY, statsWidth, statsHeight, leftBarSize;

            if (getResources().getDisplayMetrics().widthPixels == 1024) {
                leftBarSize = 100;
                statsWidth = 245;
                statsHeight = 55;
                radius = 10;
            } else if (getResources().getDisplayMetrics().heightPixels == 720) {
                leftBarSize = 110;
                statsWidth = 245;
                statsHeight = 55;
                radius = 12;
            } else {
                leftBarSize = 142;
                statsWidth = 435;
                statsHeight = 100;   
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
                statsTopLeftY = prefs.getInt("statsTopLeftY", margin + 10)  + getStatusBarHeight();                 
            }
            
            absoluteStats = li.inflate(R.layout.absolute_stats, null); 
            if (background) {
                if (drawableBg) {
                    absoluteStats.setBackground(ContextCompat.getDrawable(this, R.drawable.stats_bg));
                } else if (colorBg) {
                    GradientDrawable shape =  new GradientDrawable();
                    shape.setCornerRadius(radius);
                    shape.setColor(Color.parseColor(bgColor));
                    absoluteStats.setBackground(shape);
                }
                
            }
            WindowManager.LayoutParams parameters = new WindowManager.LayoutParams(
                    statsWidth,
                    statsHeight,
                    statsTopLeftX,
                    statsTopLeftY,
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                    PixelFormat.TRANSLUCENT
            );
            parameters.gravity = Gravity.TOP | Gravity.START;
            wm.addView(absoluteStats, parameters);
            mUpdaterOilExpend();
            mUpdaterDrivingMileage();
            mUpdaterRPM();
        }
    }

    public void removeView() {   
        if (absoluteStats != null) {
            wm.removeView(absoluteStats);
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
        DataCanbus.NOTIFY_EVENTS[fuel].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[range].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[rpm].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[fuel].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[range].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[rpm].removeNotify(this.mNotifyCanbus);
    }

    public void mUpdaterOilExpend() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());        
        boolean userLayout = prefs.getBoolean("user_layout", false);
        boolean userStats = prefs.getBoolean("user_stats", false);
        if (userLayout && userStats && absoluteStats != null) {
            int value = DataCanbus.DATA[fuel];
            if (((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)) != null) {
                ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_str)).setTextColor(Color.parseColor(textColor));
                ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setTextColor(Color.parseColor(textColor));
                if (value > 0 && value < 3001) {
                    estimateOil = false;
                    ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setText(String.format("%d.%d", value / 10, value % 10) + " L/100km\u0020");
                } else {
                    if (horsePower > 0 && vehicleMass > 0 && engineVolume > 0 && numberOfCylinders > 0) {
                        estimateOil = true;
                    } else {
                        ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setText("0.0 L/100km\u0020");
                    }
                }
            }         
        }
    }

    public void mUpdaterDrivingMileage() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());        
        boolean userLayout = prefs.getBoolean("user_layout", false);
        boolean userStats = prefs.getBoolean("user_stats", false);
        if (userLayout && userStats && absoluteStats != null) {
            int value = DataCanbus.DATA[range];
            if (absoluteStats.findViewById(R.id.driving_mileage_val) != null) {
                ((TextView) absoluteStats.findViewById(R.id.driving_mileage_str)).setTextColor(Color.parseColor(textColor));
                ((TextView) absoluteStats.findViewById(R.id.driving_mileage_val)).setTextColor(Color.parseColor(textColor));
                if (value > -1 && value < 2001) {
                    ((TextView) absoluteStats.findViewById(R.id.driving_mileage_val)).setText(value + " km\u0020");
                } else {
                    ((TextView) absoluteStats.findViewById(R.id.driving_mileage_val)).setText("-.- km\u0020");
                }
            }
        }
    }
    
    /**
     * In my case canbus stops sending the fuel consumption when the speed drops below ~40km/h.
     * This is an attemp to ROUGHLY estimate the fuel consumption to provide some insight even though it undoubtedly is an inaccurate calculation.
     * */    
    private void requestLocationUpdates() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        LocationRequest locationRequest = new LocationRequest.Builder(1000)  // Initial interval
                .setMinUpdateIntervalMillis(500)  
                .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
                .build();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.requestLocationUpdates(locationRequest, new LocationCallback() {
                @Override
                public void onLocationResult(@NonNull LocationResult locationResult) {
                    if (locationResult == null) {
                        return;
                    }
                    for (Location location : locationResult.getLocations()) {
                        float speed = location.getSpeed(); // m/s
                        velocity = speed * 3.6f; // in km/h
                        mUpdaterRPM();
                    }
                }
            }, Looper.getMainLooper());
        }
    }

    @Override
    public void onLocationChanged(Location location) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}

    @Override
    public void onProviderEnabled(@NonNull String provider) {}

    @Override
    public void onProviderDisabled(@NonNull String provider) {}

    public void mUpdaterRPM() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());        
        boolean userLayout = prefs.getBoolean("user_layout", false);
        boolean userStats = prefs.getBoolean("user_stats", false);
        if (estimateOil && userLayout && userStats && absoluteStats != null) {
            int revolutionsPerMinute = DataCanbus.DATA[rpm];          
            if (((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)) != null) {
                ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_str)).setTextColor(Color.parseColor(textColor));
                ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setTextColor(Color.parseColor(textColor));
                if (revolutionsPerMinute > 0 && revolutionsPerMinute < 9001) {
                    double fuelConsumption = 0; 
                    if (velocity > 0) {
                        fuelConsumption = calculateFuelConsumption(velocity, revolutionsPerMinute, horsePower, vehicleMass, engineVolume, numberOfCylinders);
                    } else {
                        fuelConsumption = 0;
                    }
                    ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setText(String.format("%.1f", fuelConsumption) + " L/100KM\u0020");
                } else {
                    ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setText("0.0 L/100km\u0020");
                }
            }
        }
    }

    // AI generated
    private static final double FUEL_DENSITY = 0.84; // kg/L (Average gasoline density)
    private static final double AIR_FUEL_RATIO = 14.7; // Stoichiometric air-fuel ratio for gasoline

    public static double calculateFuelConsumption(double speedVal, int rpmVal, int horsePowerVal, int vehicleMassVal, int engineVolumeVal, int numCylindersVal) {
        // Calculate torque (approximation)
        double torque = (horsePowerVal * 7121) / rpmVal; // 7121 is a constant for unit conversion

        // Calculate engine power based on torque and rpm.
        double calculatedhorsePowerVal = (torque * rpmVal) / 7121;

        // Calculate theoretical air intake (using engine volume and rpmVal).
        double airIntake_stage1 = engineVolumeVal * rpmVal;
        double airIntake_stage2 = airIntake_stage1 / 2.0; // Use 2.0 to ensure double division
        double airIntake_stage3 = airIntake_stage2 / 1000000.0; // Use 1000000.0
        double airIntake = airIntake_stage3 * numCylindersVal;

        //Calculate fuel consumption in kg/hour
        double fuelConsumptionKgPerHour = (airIntake / AIR_FUEL_RATIO) * FUEL_DENSITY;

        // More realistic road resistance calculation (simplified)
        double roadResistanceForce = 0.01 * 9.81 * vehicleMassVal; // Rolling resistance + some aerodynamic drag

        // Calculate power needed to overcome road resistance
        double powerForResistance = roadResistanceForce * (speedVal/3.6);

        // Add a factor related to acceleration (simplified)
        double accelerationFactor = 0.0;
        if (speedVal > 2) {
            accelerationFactor = 0.001 * vehicleMassVal * (speedVal/3.6);
        }

        double totalPowerNeeded = powerForResistance + (horsePowerVal * 745.7) * accelerationFactor; // convert HP to Watts

        // Adjust fuel consumption based on total power needed (very simplified)
        double adjustedFuelConsumptionKgPerHour = fuelConsumptionKgPerHour * (1 + (totalPowerNeeded / (horsePowerVal * 745.7))); // 745.7 is the conversion from HP to HP to Watts

        // Convert fuel consumption to L/100km
        double finalFuelConsumption = (adjustedFuelConsumptionKgPerHour / FUEL_DENSITY) * (100 / speedVal);
        return finalFuelConsumption;
    }

    public class PropertyChangeClass {
        private String pString = "initial";
        private boolean pBoolean;
        private final PropertyChangeSupport mPropertyChangeSupport = new  PropertyChangeSupport(this);

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
}