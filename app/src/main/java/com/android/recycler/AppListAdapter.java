package com.android.recycler;

import static android.content.Context.MODE_PRIVATE;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class AppListAdapter extends RecyclerView.Adapter<AppListHolder> implements AppListDialogFragment.ItemClickDataListener
{
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

    public AppListAdapter(Launcher mLauncher, List<AppListBean> mData) {
        this.mMaxCount = 8;
        this.mData = mData;
        this.mLauncher = mLauncher;
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

    public void notifyDataSetChanged(final List<AppListBean> list) {
        this.mLauncher.runOnUiThread(() -> {
            AppListAdapter.this.mData = list;
            AppListAdapter.this.notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        this.showAddAppView = (this.mData.size() > this.mMaxCount);
        return this.mData.size();
    }

    @Override
    public void onBindViewHolder(final AppListHolder appListHolder, int position) {
        final AppListBean appListBean = this.mData.get(position);
        if (appListBean.className.equals("com.android.launcher66.settings.SettingsActivity")) {
            appListHolder.mAppIcon.setImageBitmap(drawableToBitmap(ContextCompat.getDrawable(AppListAdapter.this.mLauncher, R.drawable.icon_settings)));
        } else {
            appListHolder.mAppIcon.setImageBitmap(appListBean.icon);
        }
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
                        AppListDialogFragment dialog = getDialog();
                        dialog.show(AppListAdapter.this.mLauncher.getSupportFragmentManager(), "");
                        AppListAdapter.this.lastClickIndex = appListHolder.getBindingAdapterPosition();
                    } else if (appListBean.packageName.equals("com.android.launcher66") && !appListBean.className.equals("com.android.launcher66.settings.SettingsActivity")) {
                        AppListAdapter.this.mLauncher.onClickAllAppsButton(view);
                    } else if (appListBean.className.equals("com.android.launcher66.settings.SettingsActivity")) {
                        AppListAdapter.this.mLauncher.refreshLeftCycle(appListBean);
                        Intent settingsIntent = new Intent(AppListAdapter.this.mLauncher, SettingsActivity.class);
                        settingsIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        AppListAdapter.this.mLauncher.startActivity(settingsIntent);
                        onClickIcon(appListBean);
                    } else if (appListBean.className.contains("com.syu.radio")) {
                        AppListAdapter.this.mLauncher.stopMusic();
                        final Intent intent = new Intent();
                        intent.setComponent(new ComponentName(appListBean.packageName, appListBean.className));
                        AppListAdapter.this.mLauncher.startActivitySafely(view, intent, "");
                        onClickIcon(appListBean);
                    } else {
                        final Intent intent = new Intent();
                        intent.setComponent(new ComponentName(appListBean.packageName, appListBean.className));
                        AppListAdapter.this.mLauncher.startActivitySafely(view, intent, "");
                        onClickIcon(appListBean);
                    }
        });
        appListHolder.itemView.setOnLongClickListener(view -> {
            AppListDialogFragment dialog = getDialog();
            dialog.show(AppListAdapter.this.mLauncher.getSupportFragmentManager(), "");
            AppListAdapter.this.lastClickIndex = appListHolder.getBindingAdapterPosition();
            return true;
        });
    }

    private void onClickIcon(AppListBean appListBean) {
        WindowUtil.removePip(null);
        helpers.setInOverviewMode(false);
        helpers.setListOpen(false);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.mLauncher);
        boolean userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean userStats = prefs.getBoolean(Keys.USER_STATS, false);
        AppListAdapter.this.mLauncher.refreshLeftCycle(appListBean);
        if (userLayout && userStats)  {  
            SharedPreferences statsPrefs = AppListAdapter.this.mLauncher.getSharedPreferences("AppStatsPrefs", MODE_PRIVATE);
            Set<String> apps = new HashSet<>(statsPrefs.getStringSet("stats_apps", new HashSet<String>()));
            helpers.setForegroundAppOpened(true);
            helpers.setInAllApps(false);
            helpers.setInWidgets(false);
            helpers.setInRecent(false);
            if (apps.contains(appListBean.packageName)) {
                Intent intentAppMap = new Intent(RECYCLER_APP_MAP);
                AppListAdapter.this.mLauncher.sendBroadcast(intentAppMap);
            } else {
                Intent intentApp = new Intent(RECYCLER_APP);
                AppListAdapter.this.mLauncher.sendBroadcast(intentApp);
            }
        }        
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
    
    public Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}