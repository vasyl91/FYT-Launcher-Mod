package com.android.recycler;

import static android.content.Context.MODE_PRIVATE;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.AppInfo;
import com.android.launcher66.Launcher;
import com.android.launcher66.R;
import com.android.launcher66.settings.Helpers;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.SettingsActivity;
import com.syu.util.WindowUtil;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeftAppListAdapter extends RecyclerView.Adapter<LeftAppListHolder> implements AppListDialogFragment.ItemClickDataListener {
    private int lastClickIndex;
    private View mAddAppView;
    private List<AppListBean> mData;
    private WeakReference<AppListDialogFragment> mDialogRef;
    private Launcher mLauncher;
    private int mMaxCount;
    private boolean showAddAppView;
    private Helpers helpers = new Helpers();
    private static final String RECYCLER_APP = "recycler.app";
    private static final String RECYCLER_APP_MAP = "recycler.app.map";
    private long mDataSignature;

    public LeftAppListAdapter(Launcher launcher, List<AppListBean> data) {
        this.mMaxCount = 5;
        this.mData = data;
        this.mLauncher = launcher;
        this.mDataSignature = calculateDataSignature(data);
        setHasStableIds(true);
    }

    private AppListDialogFragment getDialog() {
        AppListDialogFragment dialog = mDialogRef != null ? mDialogRef.get() : null;
        if (dialog == null) {
            dialog = new AppListDialogFragment();
            dialog.setItemClickDataListener(this);
            mDialogRef = new WeakReference<>(dialog);
        }
        return dialog;
    }

    public void clearDialogReference() {
        if (mDialogRef != null) {
            mDialogRef.clear();
            mDialogRef = null;
        }
    }

    private void showAppPickerDialog(int position) {
        FragmentManager fragmentManager = mLauncher.getSupportFragmentManager();
        if (fragmentManager.isStateSaved()) {
            return;
        }
        AppListDialogFragment dialog = getDialog();
        if (dialog.isAdded()) {
            return;
        }
        dialog.show(fragmentManager, AppListDialogFragment.TAG);
        lastClickIndex = position;
    }

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
        this.showAddAppView = (this.mData.size() > this.mMaxCount);
        return this.mData.size();
    }

    @Override
    public long getItemId(int position) {
        if (position < 0 || position >= this.mData.size()) {
            return RecyclerView.NO_ID;
        }
        return this.mData.get(position).stableId(position);
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
                        WindowUtil.removePip();
                    }
                    break;
                }
                case 1489048446: {
                    if (packageName.equals("com.nng.igo.primong.igoworld")) {
                        WindowUtil.removePip();
                    }
                    break;
                }
            }
            if (TextUtils.isEmpty(appListBean.packageName) || TextUtils.isEmpty(appListBean.className)) {
                showAppPickerDialog(appListHolder.getBindingAdapterPosition());
            } else if (appListBean.packageName.equals("com.android.launcher66") && !appListBean.className.equals("com.android.launcher66.settings.SettingsActivity")) {
                LeftAppListAdapter.this.mLauncher.onClickAllAppsButton();
            } else if (appListBean.className.equals("com.android.launcher66.settings.SettingsActivity")) {
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
    }

    private void onClickIcon(AppListBean appListBean) {
        WindowUtil.removePip();
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
    public void onClickData(AppInfo appInfo) {
        if (appInfo == null || lastClickIndex < 0 || lastClickIndex >= mData.size()) {
            return;
        }
        AppListBean appListBean = new AppListBean(
                appInfo.title.toString(),
                appInfo.iconBitmap,
                appInfo.getPackageName(),
                appInfo.getClassName());
        mData.remove(lastClickIndex);
        mData.add(lastClickIndex, appListBean);
        mDataSignature = calculateDataSignature(mData);
        notifyDataSetChanged();
        clearDialogReference();
        new LeftAppMultiple(lastClickIndex, appListBean.name, appListBean.packageName, appListBean.className)
                .saveOrUpdate("index = ?", String.valueOf(lastClickIndex));
    }

    @Override
    public LeftAppListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LeftAppListHolder(LayoutInflater.from(this.mLauncher).inflate(R.layout.item_left_app_list, parent, false));
    }
}
