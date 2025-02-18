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
    private int mMaxCount = 4;
    private boolean showAddAppView;
    private Helpers helpers = new Helpers();
    private static final String RECYCLER_APP = "recycler.app";

    public LeftAppListAdapter(Launcher launcher, List<AppListBean> data) {
        this.mData = data;
        this.mLauncher = launcher;
    }

    @Override
    public int getItemCount() {
        this.showAddAppView = this.mData.size() > this.mMaxCount;
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
            }
            else if (appListBean.packageName.equals("com.android.launcher66")) {
                LeftAppListAdapter.this.mLauncher.onClickAllAppsButton(view);
            } else {
                final Intent intent = new Intent();
                intent.setComponent(new ComponentName(appListBean.packageName, appListBean.className));
                LeftAppListAdapter.this.mLauncher.startActivitySafely(view, intent, "");
                LeftAppListAdapter.this.mLauncher.refreshLeftCycle(appListBean);
                helpers.setInOverviewMode(false);
                helpers.setListOpen(false);
                helpers.setAppOpenedByUser(true);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.mLauncher);
                boolean userLayout = prefs.getBoolean("user_layout", false);
                boolean userStats = prefs.getBoolean("user_stats", false);
                if (userLayout && userStats)  {  
                    SharedPreferences statsPrefs = LeftAppListAdapter.this.mLauncher.getSharedPreferences("AppStatsPrefs", MODE_PRIVATE);
                    Set<String> apps = new HashSet<>(statsPrefs.getStringSet("stats_apps", new HashSet<String>()));
                    if (apps.contains(appListBean.packageName)) {
                        helpers.setForegroundAppOpened(true);
                        helpers.setInAllApps(false);
                        helpers.setInRecent(false);
                        Intent intentLeftApps = new Intent(RECYCLER_APP);
                        LeftAppListAdapter.this.mLauncher.sendBroadcast(intentLeftApps);
                    }  
                }              
            }
        });
    }

    @Override
    public LeftAppListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LeftAppListHolder(LayoutInflater.from(this.mLauncher).inflate(R.layout.item_left_app_list, parent, false));
    }

    public void notifyDataSetChanged(final List<AppListBean> data) {
        this.mLauncher.runOnUiThread(() -> {
            LeftAppListAdapter.this.mData = data;
            LeftAppListAdapter.this.notifyDataSetChanged();
        });
    }
}
