package com.syu.carinfo.rzc.biaozhi408;

import android.app.ActivityManager;
import android.app.Service;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemProperties;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.AppsCustomizePagedView;
import com.android.launcher66.Launcher;
import com.android.launcher66.R;
import com.android.launcher66.Workspace;
import com.android.launcher66.settings.Helpers;
import com.android.recycler.AppListDialogFragment;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.ServiceRestarter;
import com.syu.util.WindowUtil;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class RZC_BZ408IndexActi extends Service implements PropertyChangeListener {

    private SharedPreferences prefs;
    private IBinder binder;
    private View absoluteStats;
    private WindowManager wm;  
    private String textColor = "#FFFFFFFF"; 
    private String curForegroundApp = " ";
    private Handler handler = new Handler(Looper.getMainLooper());
    private Set<String> apps = new HashSet<String>();  
    private final String SYSTEM_DIALOG_REASON_KEY = "reason";
    private final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    private final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    private static final String RECYCLER_APP = "recycler.app";
    private PropertyChangeClass mPropertyChangeClass = new PropertyChangeClass();
    String curApp = "init";

    @Override
    public void onCreate() {
        mPropertyChangeClass.addObserver("allapps", this);
        mPropertyChangeClass.addObserver("fuelStats", this);
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
        registerReceiver(pipReceiver, filter, Context.RECEIVER_EXPORTED);
        
        addStatsView(false);
        DataCanbus.PROXY.cmd(70, new int[]{51}, null, null);
    }

    private IUiNotify mNotifyCanbus = (updateCode, ints, flts, strs) -> {
        switch (updateCode) {
            case 91:
                mUpdaterOilExpend();
                break;
            case 92:
                mUpdaterDrivingMileage();
                break;
        }
    };

    private final BroadcastReceiver pipReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction() != null) {
                switch (intent.getAction()) {
                    case WindowUtil.PIP_STARTED:
                        curForegroundApp = "com.android.launcher66";
                        mPropertyChangeClass.setBoolean("allapps", false);
                        mPropertyChangeClass.setString("fuelStats", curForegroundApp, System.currentTimeMillis(), true);
                        if (!Helpers.listOpen) {
                            removeView();
                            addStatsView(false);
                            mUpdaterOilExpend();
                            mUpdaterDrivingMileage();                            
                        }
                        break;
                    case WindowUtil.PIP_REMOVED: 
                        removeView();
                        break;
                    case RECYCLER_APP:
                        removeView();
                        addStatsView(true);
                        mUpdaterOilExpend();
                        mUpdaterDrivingMileage();
                        break;
                    case AppListDialogFragment.LIST_OPEN:
                        curForegroundApp = "com.android.launcher66";
                        mPropertyChangeClass.setBoolean("allapps", false);
                        mPropertyChangeClass.setString("fuelStats", curForegroundApp, System.currentTimeMillis(), true);
                        removeView();
                        break;
                    case AppListDialogFragment.LIST_CLOSE:
                        curForegroundApp = "com.android.launcher66";
                        mPropertyChangeClass.setBoolean("allapps", false);
                        mPropertyChangeClass.setString("fuelStats", curForegroundApp, System.currentTimeMillis(), true);
                        removeView();
                        addStatsView(false);
                        mUpdaterOilExpend();
                        mUpdaterDrivingMileage();
                        break;
                    case Workspace.OVERVIEW_MODE_OPEN:
                        curForegroundApp = "com.android.launcher66";
                        mPropertyChangeClass.setBoolean("allapps", false);
                        mPropertyChangeClass.setString("fuelStats", curForegroundApp, System.currentTimeMillis(), true);
                        removeView();
                        break;
                    case Workspace.OVERVIEW_MODE_CLOSE:
                        curForegroundApp = "com.android.launcher66";
                        mPropertyChangeClass.setBoolean("allapps", false);
                        mPropertyChangeClass.setString("fuelStats", curForegroundApp, System.currentTimeMillis(), true);
                        if (!Helpers.pipStarted) {
                            removeView();
                            addStatsView(false);
                            mUpdaterOilExpend();
                            mUpdaterDrivingMileage();                            
                        }
                        break;
                    case AppsCustomizePagedView.STATS_APP_FOREGROUND:
                        mPropertyChangeClass.setBoolean("allapps", false);
                        removeView();
                        addStatsView(true);
                        mUpdaterOilExpend();
                        mUpdaterDrivingMileage();
                        break;
                    case Launcher.ALL_APPS:
                        curForegroundApp = "com.android.launcher66";
                        mPropertyChangeClass.setBoolean("allapps", true);
                        mPropertyChangeClass.setString("fuelStats", curForegroundApp, System.currentTimeMillis(), true);
                        removeView();
                        break;
                    case Intent.ACTION_CLOSE_SYSTEM_DIALOGS:
                        String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
                        if (reason != null) {
                            if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
                                curForegroundApp = "com.android.launcher66";
                                mPropertyChangeClass.setBoolean("allapps", false);
                                mPropertyChangeClass.setString("fuelStats", curForegroundApp, System.currentTimeMillis(), true);
                            } else if (reason.equals(SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                                curForegroundApp = "com.android.launcher66";
                                mPropertyChangeClass.setBoolean("allapps", false);
                                mPropertyChangeClass.setString("fuelStats", curForegroundApp, System.currentTimeMillis(), true);
                                removeView();
                            }                        
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    };

    private Runnable runTask = new Runnable() {
        @Override
        public void run() {
            SharedPreferences statsPrefs = getSharedPreferences("AppStatsPrefs", MODE_PRIVATE);
            apps = new HashSet<>(statsPrefs.getStringSet("stats_apps", new HashSet<String>()));
            String appPackageName = SystemProperties.get("persist.launcher.packagename", "");
            if (Launcher.mAppsCustomizeTabHost != null) {
                mPropertyChangeClass.setBoolean("allapps", Launcher.mAppsCustomizeTabHost.getVisibility() == View.VISIBLE);
            }
            ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
            for(ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND 
                && appProcess.importanceReasonCode == ActivityManager.RunningAppProcessInfo.REASON_UNKNOWN) { 
                    if (appProcess.processName.contains(":")) {
                        appProcess.processName = appProcess.processName.substring(0, appProcess.processName.indexOf(":"));
                    }
                    if (appProcess.processName.contains("com.android.launcher") && !Helpers.foregroundAppOpened) {
                        curForegroundApp = "com.android.launcher66";
                    } 
                    if (appProcess.processName.contains(appPackageName) && (Helpers.pipStarted || Helpers.isInRecent) && !Helpers.foregroundAppOpened) {
                        curForegroundApp = "com.android.launcher66";
                    }
                    if (apps.contains(appProcess.processName)) {
                        if (appProcess.processName.contains(appPackageName) && (Helpers.pipStarted || Helpers.isInRecent || Helpers.overviewMode) && !Helpers.foregroundAppOpened) {
                            curForegroundApp = "com.android.launcher66";
                        } else if (!Helpers.overviewMode || !Helpers.listOpen || !Helpers.isInRecent) {
                            curForegroundApp = appProcess.processName;
                            if (!curForegroundApp.contains("com.android.launcher")) {
                                Helpers.isInRecent = false;
                                Helpers.inAllApps = false;
                            }
                        }
                    }
                    mPropertyChangeClass.setString("fuelStats", curForegroundApp, System.currentTimeMillis(), false);
                }
            }
            handler.postDelayed(this, 500); 
        }
    }; 

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "allapps":
                Log.i("allappsChange", "\t(" + evt.getOldValue() + " -> " + evt.getNewValue() + ")");
                String val = String.valueOf(evt.getNewValue());
                if (val.contains("true") || val.contains("false")) {
                    Log.i("val", val);
                    Helpers.inAllApps = Boolean.valueOf(val);
                    if (Boolean.valueOf(val)) {
                        removeView();
                    }                   
                }
                break;
            case "fuelStats":
                curApp = String.valueOf(evt.getNewValue());
                Log.i("fuelStatsChange", "\t(" + evt.getOldValue() + " -> " + evt.getNewValue() + ")" + " CurrentActivityName: " + getCurrentActivityName());
                if (String.valueOf(evt.getNewValue()).contains("com.android.launcher")) {
                    Helpers.foregroundAppOpened = false;
                }
                if (!String.valueOf(evt.getNewValue()).contains("com.android.launcher") && !Helpers.inAllApps && !Helpers.isInRecent && !Helpers.pipStarted) {
                    Helpers.foregroundAppOpened = true;
                    removeView();
                    addStatsView(true);
                    mUpdaterOilExpend();
                    mUpdaterDrivingMileage();                    
                } else if (!Helpers.pipStarted || Helpers.overviewMode || (Helpers.listOpen && !Helpers.foregroundAppOpened)) {
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

    private void addStatsView(boolean mapApp) {
        prefs = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        boolean userStats = prefs.getBoolean("user_stats", false);        
        boolean userLayout = prefs.getBoolean("user_layout", false);
        if (userLayout) {
            if (userStats) {
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
                } else if (getResources().getDisplayMetrics().widthPixels == 1280
                        || getResources().getDisplayMetrics().widthPixels == 1920) {
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
            }            
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

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.post(runTask);
        addNotify();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onDestroy() {
        mPropertyChangeClass.deleteObserver("allapps", this);
        mPropertyChangeClass.deleteObserver("fuelStats", this);
        handler.removeCallbacks(runTask);
        unregisterReceiver(pipReceiver);
        removeNotify();
        wm.removeView(absoluteStats);
        Intent broadcastIntent = new Intent(this, ServiceRestarter.class);
        sendBroadcast(broadcastIntent);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
    }

    public void mUpdaterOilExpend() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());        
        boolean userLayout = prefs.getBoolean("user_layout", false);
        boolean userStats = prefs.getBoolean("user_stats", false);
        if (userLayout) {
            if (userStats) {
                int value = DataCanbus.DATA[91];
                if (((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)) != null) {
                    ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_str)).setTextColor(Color.parseColor(textColor));
                    ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setTextColor(Color.parseColor(textColor));
                    if (value > -1 && value < 3001) {
                        ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setText(String.format("%d.%d", value / 10, value % 10) + " L/100KM\u0020");
                    } else {
                        ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setText("?.? L/100KM\u0020");
                    }
                }
            }            
        }
    }

    public void mUpdaterDrivingMileage() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());        
        boolean userLayout = prefs.getBoolean("user_layout", false);
        boolean userStats = prefs.getBoolean("user_stats", false);
        if (userLayout) {
            if (userStats) {
                int value = DataCanbus.DATA[92];
                if (absoluteStats.findViewById(R.id.driving_mileage_val) != null) {
                    ((TextView) absoluteStats.findViewById(R.id.driving_mileage_str)).setTextColor(Color.parseColor(textColor));
                    ((TextView) absoluteStats.findViewById(R.id.driving_mileage_val)).setTextColor(Color.parseColor(textColor));
                    if (value > -1 && value < 2001) {
                        ((TextView) absoluteStats.findViewById(R.id.driving_mileage_val)).setText(value + " KM\u0020");
                    } else {
                        ((TextView) absoluteStats.findViewById(R.id.driving_mileage_val)).setText("-.- KM\u0020");
                    }
                }
            }
        }
    }

    public class PropertyChangeClass {
        private String pString = "initial";
        private String old = "old";
        private boolean pBoolean;
        private List<String> values = new ArrayList<String>();
        private List<String> values2 = new ArrayList<String>();
        private final PropertyChangeSupport mPropertyChangeSupport = new  PropertyChangeSupport(this);

        public void setString(String name, String str, Long miliseconds, boolean certainApp) {
            if (!old.equals(str)) {
                old = pString;
                pString = str;

                if (values.size() == 0) {
                    values.add(str);
                    values.add(String.valueOf(miliseconds));
                } 
                if (values.size() > 0 && !(values.get(values.size() - 2)).equals(str)) {
                    if (values.size() < 6) {
                        values.add(str);
                        values.add(String.valueOf(miliseconds));
                    } else {
                        values.remove(0);
                        values.remove(0);
                        values.add(str);
                        values.add(String.valueOf(miliseconds));
                    }               
                }

                if (certainApp) {
                    mPropertyChangeSupport.firePropertyChange(name, old, str);
                } else {
                    if (values.size() == 6 && values.get(0).equals(values.get(4)) && (Long.parseLong(values.get(3)) + 500) < Long.parseLong(values.get(5))) {
                        mPropertyChangeSupport.firePropertyChange(name, old, str);
                    } else if (values.size() < 6 || (values.size() == 6 && !values.get(0).equals(values.get(4)))) {
                        mPropertyChangeSupport.firePropertyChange(name, old, str);
                    }                
                }                
            }
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
