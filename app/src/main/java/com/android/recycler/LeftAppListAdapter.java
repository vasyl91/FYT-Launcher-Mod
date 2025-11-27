package com.android.recycler;

import static android.content.Context.MODE_PRIVATE;

import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.launcher66.Launcher;
import com.android.launcher66.R;
import com.android.launcher66.settings.Helpers;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.SettingsActivity;
import com.syu.util.WindowUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeftAppListAdapter extends RecyclerView.Adapter<LeftAppListHolder> {
    private int lastClickIndex;
    private View mAddAppView;
    private List<AppListBean> mData;
    private AppListDialogFragment mDialog;
    private Launcher mLauncher;
    private int mMaxCount;
    private boolean showAddAppView;
    private Helpers helpers = new Helpers();
    private static final String RECYCLER_APP = "recycler.app";
    private static final String RECYCLER_APP_MAP = "recycler.app.map";

    public LeftAppListAdapter(Launcher launcher, List<AppListBean> data) {
        this.mMaxCount = 5;
        this.mData = data;
        this.mLauncher = launcher;
    }

    public void notifyDataSetChanged(final List<AppListBean> data) {
        this.mLauncher.runOnUiThread(() -> {
            LeftAppListAdapter.this.mData = data;
            LeftAppListAdapter.this.notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        this.showAddAppView = (this.mData.size() > this.mMaxCount);
        return this.mData.size();
    }

    public void onBindViewHolder(final LeftAppListHolder appListHolder, int position) {
        final AppListBean appListBean = this.mData.get(position);
        appListHolder.mAppIcon.setImageBitmap(appListBean.icon);
        appListHolder.itemView.setOnClickListener(view -> {
            final String packageName = appListBean.packageName;
            switch (packageName.hashCode()) {
                case -1958346218: {
                    if (!packageName.equals("com.google.android.googlequicksearchbox")) {
                        break;
                    }
                }
                case 877333343: {
                    if (packageName.equals("net.easyconn")) {
                        WindowUtil.removePip(null);
                    }
                    break;
                }
                case 1489048446: {
                    if (packageName.equals("com.nng.igo.primong.igoworld")) {
                        WindowUtil.removePip(null);
                    }
                    break;
                }
            }
            if (TextUtils.isEmpty(appListBean.packageName) || TextUtils.isEmpty(appListBean.className)) {
                LeftAppListAdapter.this.mDialog.show(LeftAppListAdapter.this.mLauncher.getSupportFragmentManager(), "");
                LeftAppListAdapter.this.lastClickIndex = appListHolder.getBindingAdapterPosition();
            } else if (appListBean.packageName.equals("com.android.launcher66") && !appListBean.className.equals("com.android.launcher66.settings.SettingsActivity")) {
                LeftAppListAdapter.this.mLauncher.onClickAllAppsButton();
            } else if (appListBean.className.equals("com.android.launcher66.settings.SettingsActivity")) {
                WindowUtil.removePip(null);
                LeftAppListAdapter.this.mLauncher.refreshLeftCycle(appListBean);
                Intent settingsIntent = new Intent(LeftAppListAdapter.this.mLauncher, SettingsActivity.class);
                settingsIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                LeftAppListAdapter.this.mLauncher.startActivity(settingsIntent);
                onClickIcon(appListBean);
            } else if (appListBean.className.contains("com.syu.radio")) {
                LeftAppListAdapter.this.mLauncher.stopMusic();
                final Intent intent = new Intent();
                intent.setComponent(new ComponentName(appListBean.packageName, appListBean.className));
                LeftAppListAdapter.this.mLauncher.startActivitySafely(view, intent, "");
                LeftAppListAdapter.this.mLauncher.refreshLeftCycle(appListBean);
                onClickIcon(appListBean);
            } else {
                final Intent intent = new Intent();
                intent.setComponent(new ComponentName(appListBean.packageName, appListBean.className));
                LeftAppListAdapter.this.mLauncher.startActivitySafely(view, intent, "");
                LeftAppListAdapter.this.mLauncher.refreshLeftCycle(appListBean);
                onClickIcon(appListBean);
            }
        });
    }

    private void onClickIcon(AppListBean appListBean) {
        WindowUtil.removePip(null);
        helpers.setInOverviewMode(false);
        helpers.setListOpen(false);
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this.mLauncher);
        boolean userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        if (userLayout)  {  
            helpers.setForegroundAppOpened(true);
            helpers.setInAllApps(false);
            helpers.setInWidgets(false);
            helpers.setInRecent(false);
            boolean autoHideBottomBar = mPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false);
            if (autoHideBottomBar) {
                LeftAppListAdapter.this.mLauncher.getWorkspace().hideBottomBar();
            }
            boolean userStats = mPrefs.getBoolean(Keys.USER_STATS, false);
            if (userStats) {
                SharedPreferences statsPrefs = LeftAppListAdapter.this.mLauncher.getSharedPreferences("AppStatsPrefs", MODE_PRIVATE);
                Set<String> apps = new HashSet<>(statsPrefs.getStringSet("stats_apps", new HashSet<String>()));  
                if (apps.contains(appListBean.packageName)) {
                    Intent intentLeftAppMap = new Intent(RECYCLER_APP_MAP);
                    LeftAppListAdapter.this.mLauncher.sendBroadcast(intentLeftAppMap);
                } else {
                    Intent intentLeftApp = new Intent(RECYCLER_APP);
                    LeftAppListAdapter.this.mLauncher.sendBroadcast(intentLeftApp);
                }   
            }
        }   
    }

    @Override
    public LeftAppListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LeftAppListHolder(LayoutInflater.from(this.mLauncher).inflate(R.layout.item_left_app_list, parent, false));
    }
}
