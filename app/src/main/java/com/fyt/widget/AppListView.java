package com.fyt.widget;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.launcher66.R;
import com.android.launcher66.settings.Helpers;
import com.syu.car.CarStates;
import com.syu.util.FytPackage;
import com.syu.utils.W3Utils;

import java.util.ArrayList;

import share.Config;
import share.ResValue;

public class AppListView extends ListView {
    public static LauncherList_Adapter Adapter_AppList;
    public static ListView View_AppList;
    private static Context context;
    BroadcastReceiver receiver;
    public static int hide_num = 0;
    public static ArrayList<String> Array_AppList = new ArrayList<>();
    public static int[] StringId_Action = {R.string.car_dvr, R.string.car_bt, R.string.car_settings, R.string.car_file, R.string.car_video, R.string.car_radio, R.string.car_music, R.string.car_setting, R.string.car_navi};
    private static final String[][] String_ActionPack = {new String[]{FytPackage.INNER_DVR, "com.syu.dvr.activity.MainActivity"}, new String[]{"com.syu.bt", "com.syu.bt.BtAct"}, new String[]{FytPackage.sysSetAction, "com.android.settings.Settings"}, new String[]{FytPackage.filemanagerAction, "com.syu.filemanager.FileManagerActivity"}, new String[]{"com.syu.video", "com.syu.video.main.VideoListActivity"}, new String[]{"com.syu.radio", "com.syu.radio.Launch"}, new String[]{"com.syu.music", "com.syu.music.MAct"}, new String[]{"com.syu.settings", "com.syu.settings.MainActivity"}, new String[]{FytPackage.naviAction, "com.syu.onekeynavi.MainActivity"}};

    public AppListView(Context context2, AttributeSet arg1, int arg2) {
        super(context2, arg1, arg2);
        this.receiver = new BroadcastReceiver() { 
            @Override
            public void onReceive(Context arg0, Intent arg12) {
                AppListView.this.updateStr();
            }
        };
        context = context2;
        init(context2);
    }

    public AppListView(Context context2, AttributeSet arg1) {
        super(context2, arg1);
        this.receiver = new BroadcastReceiver() { 
            @Override
            public void onReceive(Context arg0, Intent arg12) {
                AppListView.this.updateStr();
            }
        };
        context = context2;
        init(context2);
    }

    public AppListView(Context context2) {
        super(context2);
        this.receiver = new BroadcastReceiver() { 
            @Override
            public void onReceive(Context arg0, Intent arg12) {
                AppListView.this.updateStr();
            }
        };
        context = context2;
        init(context2);
    }

    private void init(Context context2) {
        View_AppList = findViewById(ResValue.getInstance().Collect_AppList);
        Log.d("adapter", "  ***  init  *** ");
        for (int i = 0; i < StringId_Action.length; i++) {
            Log.d("adapter", " appname = " + StringId_Action[i] + " i = " + i);
            Array_AppList.add(getResources().getString(StringId_Action[i]));
        }
        Adapter_AppList = new LauncherList_Adapter(Array_AppList, context2);
        View_AppList.setAdapter(Adapter_AppList);
        View_AppList.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                AppListView.ItemClick(arg2);
            }
        });
        View_AppList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { 
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Log.d("gandy", " ** LongClick  ");
                return false;
            }
        });
        View_AppList.setOnScrollListener(new AbsListView.OnScrollListener() { 
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case 0:
                        AppListView.hide_num = AppListView.View_AppList.getFirstVisiblePosition();
                        if (AppListView.View_AppList.getChildAt(0).getTop() < -42) {
                            AppListView.hide_num = AppListView.View_AppList.getFirstVisiblePosition() + 1;
                        }
                        AppListView.View_AppList.setSelection(AppListView.hide_num);
                        Log.d("gdy", " ** kong xian getFirstVisiblePosition = " + AppListView.View_AppList.getFirstVisiblePosition() + "  hide_num = " + AppListView.hide_num);
                        break;
                    case 1:
                        Log.d("gdy", " ** chu mo hou gun dong");
                        break;
                    case 2:
                        Log.d("gdy", " ** gun dong");
                        AppListView.View_AppList.clearFocus();
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }

    static void ItemClick(int arg) {
        Adapter_AppList.setfocus(arg);
        Adapter_AppList.notifyDataSetChanged();
        if (arg == 8) {
            if (Config.EXISTAMPAUTO) {
                String str = SystemProperties.get("persist.sys.navi.packagename", "");
                PackageManager packageManager = context.getPackageManager();
                if ((str.equals("") || str == null || str.equals(FytPackage.GaodeACTION)) && Helpers.isPackageInstalled(FytPackage.GaodeACTION, packageManager)) {
                    SystemProperties.set("persist.sys.navi.packagename", FytPackage.GaodeACTION);
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(FytPackage.GaodeACTION, "com.autonavi.auto.remote.fill.UsbFillActivity"));
                    startActivitySafely(intent);
                    return;
                } 
                CarStates.getCar(context).mTools.sendInt(0, 24, 0);
                return;
            }
            CarStates.getCar(context).mTools.sendInt(0, 24, 0);
            return;
        }
        if (arg < String_ActionPack.length) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(String_ActionPack[arg][0], String_ActionPack[arg][1]));
            startActivitySafely(intent2);
        }
    }

    static void startActivitySafely(Intent intent) {
        if (intent == null) {
            Toast.makeText(context, R.string.activity_not_found, Toast.LENGTH_LONG).show();
        }
        W3Utils.getUtils().check(intent, "Hint (translated from Chinese)", "If the current network is unavailable or the card has been deactivated, go to the recharge screen to recharge or change the subscription.", "OK", "Cancel");
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, R.string.activity_not_found, Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter filter = new IntentFilter("android.intent.action.LOCALE_CHANGED");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            getContext().registerReceiver(this.receiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            getContext().registerReceiver(this.receiver, filter);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterReceiver(this.receiver);
    }

    public void updateStr() {
        Log.i("AppListView", "updateStr");
        if (Adapter_AppList != null) {
            Adapter_AppList.notifyDataSetChanged();
        }
    }
}
