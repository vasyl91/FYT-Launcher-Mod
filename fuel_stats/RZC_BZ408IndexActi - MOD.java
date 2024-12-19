package com.syu.carinfo.rzc.biaozhi408;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.ServiceRestarter;
import com.syu.util.WindowUtil;

public class RZC_BZ408IndexActi extends Service {

    private SharedPreferences prefs;
    private IBinder binder;
    private View absoluteStats;
    private WindowManager wm;  
    private String textColor = "#FFFFFFFF"; 

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
                        if (absoluteStats != null) {
                            wm.removeView(absoluteStats);
                        }
                        addStatsView();
                        mUpdaterOilExpend();
                        mUpdaterDrivingMileage();
                        break;
                    case WindowUtil.PIP_REMOVED: 
                        if (absoluteStats != null) {
                            wm.removeView(absoluteStats);
                        }
                        break;
                }
            }
        }
    };

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    public void onCreate() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(WindowUtil.PIP_STARTED);
        filter.addAction(WindowUtil.PIP_REMOVED);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(pipReceiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(pipReceiver, filter);
        }
        
        addStatsView();
        DataCanbus.PROXY.cmd(70, new int[]{51}, null, null);
    }

    private void addStatsView() {
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
                int radius;
                int isSystemApp = 0;
                try {
                    PackageManager pm = this.getPackageManager();
                    ApplicationInfo appInfo = pm.getApplicationInfo(this.getPackageName(), 0);
                    if (((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) || ((appInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0)) {
                        isSystemApp = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
                    } else {
                        isSystemApp = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                }
                wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                int statsTopLeftX, statsWidth, statsHeight, leftBarSize;

                if (getResources().getDisplayMetrics().widthPixels == 1024) {
                    leftBarSize = 100;
                    statsWidth = 240;
                    statsHeight = 55;
                    radius = 10;
                } else if (getResources().getDisplayMetrics().widthPixels == 1280
                        || getResources().getDisplayMetrics().widthPixels == 1920) {
                    leftBarSize = 110;
                    statsWidth = 240;
                    statsHeight = 55;
                    radius = 12;
                } else {
                    leftBarSize = 142;
                    statsWidth = 430;
                    statsHeight = 100;   
                    radius = 14;            
                } 

                if (leftBar) {
                    statsTopLeftX = prefs.getInt("statsTopLeftX", 20) + leftBarSize;
                } else {
                    statsTopLeftX = prefs.getInt("statsTopLeftX", 20);
                }
                int statsTopLeftY = prefs.getInt("statsTopLeftY", 20)  + getStatusBarHeight();

                WindowManager.LayoutParams parameters = new WindowManager.LayoutParams(
                        statsWidth,
                        statsHeight,
                        statsTopLeftX,
                        statsTopLeftY,
                        isSystemApp,
                        WindowManager.LayoutParams.TYPE_WALLPAPER | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                        PixelFormat.TRANSLUCENT
                );
                parameters.gravity = Gravity.TOP | Gravity.START;
                
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
                wm.addView(absoluteStats, parameters);
            }            
        }
    }

    public static boolean isAppSystem(final Context context, final String packageName) {
        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(packageName, 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
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

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        addNotify();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(pipReceiver);
        removeNotify();
        wm.removeView(absoluteStats);
        Intent broadcastIntent = new Intent(this, ServiceRestarter.class);
        sendBroadcast(broadcastIntent);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
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
                        ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setText(String.format("%d.%d", value / 10, value % 10) + " L/100KM");
                    } else {
                        ((TextView) absoluteStats.findViewById(R.id.instantaneous_consumption_val)).setText("~0.0 L/100KM");
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
                        ((TextView) absoluteStats.findViewById(R.id.driving_mileage_val)).setText(value + " KM");
                    } else {
                        ((TextView) absoluteStats.findViewById(R.id.driving_mileage_val)).setText("-.- KM");
                    }
                }
            }
        }
    }
}
