package com.android.recycler;

import com.android.launcher66.SysCalls;
import static android.content.Context.MODE_PRIVATE;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.Launcher;
import com.android.launcher66.R;
import com.android.launcher66.settings.Helpers;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.SettingsActivity;
import com.syu.util.WindowUtil;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The left bar: the apps opened last, each opened again by a tap. Choosing its apps (the app
 * picker) is the bottom bar's alone (AppListAdapter).
 */
public class LeftAppListAdapter extends RecyclerView.Adapter<LeftAppListHolder> {

    private static final String RECYCLER_APP = "recycler.app";
    private static final String RECYCLER_APP_MAP = "recycler.app.map";

    private List<AppListBean> mData;
    private final Launcher mLauncher;
    private final Helpers helpers = new Helpers();
    private long mDataSignature;

    public LeftAppListAdapter(Launcher launcher, List<AppListBean> data) {
        this.mData = data;
        this.mLauncher = launcher;
        this.mDataSignature = calculateDataSignature(data);
        setHasStableIds(true);
    }

    // =====================================================================================
    // ADAPTER
    // =====================================================================================

    public void notifyDataSetChanged(final List<AppListBean> data) {
        this.mLauncher.runOnUiThread(() -> {
            long newSignature = calculateDataSignature(data);
            if (LeftAppListAdapter.this.mDataSignature == newSignature) {
                LeftAppListAdapter.this.mData = data;
                return;
            }
            LeftAppListAdapter.this.mData = data;
            LeftAppListAdapter.this.mDataSignature = newSignature;
            LeftAppListAdapter.this.notifyDataSetChanged();
        });
    }

    private long calculateDataSignature(List<AppListBean> data) {
        long signature = 1125899906842597L;
        if (data == null) {
            return signature;
        }
        signature = (signature * 31L) + data.size();
        for (int i = 0; i < data.size(); i++) {
            AppListBean bean = data.get(i);
            signature = (signature * 31L) + (bean == null ? 0L : bean.contentSignature(i));
        }
        return signature;
    }

    @Override
    public int getItemCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    @Override
    public long getItemId(int position) {
        if (mData == null || position < 0 || position >= this.mData.size()) {
            return RecyclerView.NO_ID;
        }
        return this.mData.get(position).stableId(position);
    }

    @Override
    public LeftAppListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LeftAppListHolder(
                LayoutInflater.from(this.mLauncher).inflate(R.layout.item_left_app_list, parent, false));
    }

    @Override
    public void onBindViewHolder(final LeftAppListHolder appListHolder, int position) {
        final AppListBean appListBean = this.mData.get(position);
        appListHolder.mAppIcon.setImageBitmap(appListBean.icon);

        appListHolder.itemView.setOnClickListener(view -> {
            final String packageName = appListBean.packageName;
            if ("net.easyconn".equals(packageName)
                    || "com.nng.igo.primong.igoworld".equals(packageName)
                    || "com.google.android.googlequicksearchbox".equals(packageName)) {
                WindowUtil.removePip();
            }

            if (TextUtils.isEmpty(appListBean.packageName) || TextUtils.isEmpty(appListBean.className)) {
                // An empty slot: nothing opened there yet.
                return;

            } else if ("com.android.launcher66".equals(appListBean.packageName)
                    && !"com.android.launcher66.settings.SettingsActivity".equals(appListBean.className)) {
                LeftAppListAdapter.this.mLauncher.onClickAllAppsButton();

            } else if ("com.android.launcher66.settings.SettingsActivity".equals(appListBean.className)) {
                WindowUtil.removePip();
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

        appListHolder.itemView.setOnLongClickListener(null);
    }

    private void onClickIcon(AppListBean appListBean) {
        WindowUtil.removePip();
        helpers.setInOverviewMode(false);
        helpers.setListOpen(false);
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this.mLauncher);
        boolean userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        if (userLayout) {
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
                SharedPreferences statsPrefs =
                        LeftAppListAdapter.this.mLauncher.getSharedPreferences("AppStatsPrefs", MODE_PRIVATE);
                Set<String> apps = new HashSet<>(statsPrefs.getStringSet("stats_apps", new HashSet<String>()));
                if (apps.contains(appListBean.packageName)) {
                    SysCalls.sendBroadcast(LeftAppListAdapter.this.mLauncher, new Intent(RECYCLER_APP_MAP));
                } else {
                    SysCalls.sendBroadcast(LeftAppListAdapter.this.mLauncher, new Intent(RECYCLER_APP));
                }
            }
        }
    }
}
