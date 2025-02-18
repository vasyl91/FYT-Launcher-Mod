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

import com.android.launcher66.AppInfo;
import com.android.launcher66.Launcher;
import com.android.launcher66.R;
import com.android.launcher66.settings.Helpers;
import com.syu.util.WindowUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppListAdapter extends RecyclerView.Adapter<AppListHolder> implements AppListDialogFragment.ItemClickDataListener
{
    private int lastClickIndex;
    private View mAddAppView;
    private List<AppListBean> mData;
    private AppListDialogFragment mDialog;
    private Launcher mLauncher;
    private int mMaxCount;
    private boolean showAddAppView;
    private Helpers helpers = new Helpers();
    private static final String RECYCLER_APP = "recycler.app";

    public AppListAdapter(final Launcher mLauncher, final List<AppListBean> mData) {
        this.mMaxCount = 8;
        this.mData = mData;
        this.mLauncher = mLauncher;
        (this.mDialog = new AppListDialogFragment()).setItemClickDataListener(this);
    }

    @Override
    public int getItemCount() {
        this.showAddAppView = (this.mData.size() > this.mMaxCount);
        return this.mData.size();
    }

    public void notifyDataSetChanged(final List<AppListBean> list) {
        this.mLauncher.runOnUiThread(() -> {
            AppListAdapter.this.mData = list;
            AppListAdapter.this.notifyDataSetChanged();
        });
    }

    @Override
    public void onBindViewHolder(final AppListHolder appListHolder, int position) {
        final AppListBean appListBean = this.mData.get(position);
        appListHolder.mAppName.setText(appListBean.name);
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
                        AppListAdapter.this.mDialog.show(AppListAdapter.this.mLauncher.getSupportFragmentManager(), "");
                        AppListAdapter.this.lastClickIndex = appListHolder.getBindingAdapterPosition();
                    }
                    else if (appListBean.packageName.equals("com.android.launcher66")) {
                        AppListAdapter.this.mLauncher.onClickAllAppsButton(view);
                    } else {
                        final Intent intent = new Intent();
                        intent.setComponent(new ComponentName(appListBean.packageName, appListBean.className));
                        AppListAdapter.this.mLauncher.startActivitySafely(view, intent, "");
                        AppListAdapter.this.mLauncher.refreshLeftCycle(appListBean);
                        helpers.setInOverviewMode(false);
                        helpers.setListOpen(false);
                        helpers.setAppOpenedByUser(true);
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.mLauncher);
                        boolean userLayout = prefs.getBoolean("user_layout", false);
                        boolean userStats = prefs.getBoolean("user_stats", false);
                        if (userLayout && userStats)  {  
                            SharedPreferences statsPrefs = AppListAdapter.this.mLauncher.getSharedPreferences("AppStatsPrefs", MODE_PRIVATE);
                            Set<String> apps = new HashSet<>(statsPrefs.getStringSet("stats_apps", new HashSet<String>()));
                            if (apps.contains(appListBean.packageName)) {
                                helpers.setForegroundAppOpened(true);
                                helpers.setInAllApps(false);
                                helpers.setInRecent(false);
                                Intent intentApps = new Intent(RECYCLER_APP);
                                AppListAdapter.this.mLauncher.sendBroadcast(intentApps);
                            }
                        }
                    }
        });
        appListHolder.itemView.setOnLongClickListener(view -> {
            AppListAdapter.this.mDialog.show(AppListAdapter.this.mLauncher.getSupportFragmentManager(), "");
            AppListAdapter.this.lastClickIndex = appListHolder.getBindingAdapterPosition();
            return true;
        });
    }

    @Override
    public void onClickData(final AppInfo appInfo) {
        final AppListBean appListBean = new AppListBean(appInfo.title.toString(), appInfo.iconBitmap, appInfo.getPackageName(), appInfo.getClassName());
        this.mData.remove(this.lastClickIndex);
        this.mData.add(this.lastClickIndex, appListBean);
        notifyDataSetChanged();
        new AppMultiple(this.lastClickIndex, appListBean.name, appListBean.packageName, appListBean.className).saveOrUpdate("index = ?", new StringBuilder(String.valueOf(this.lastClickIndex)).toString());
    }

    public AppListHolder onCreateViewHolder(final ViewGroup viewGroup, final int n) {
        return new AppListHolder(LayoutInflater.from(this.mLauncher).inflate(R.layout.item_app_list, viewGroup, false));
    }
}
