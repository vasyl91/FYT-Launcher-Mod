package com.android.recycler;

import static android.content.Context.MODE_PRIVATE;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
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

import org.litepal.LitePal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeftAppListAdapter extends RecyclerView.Adapter<LeftAppListHolder>
        implements AppListDialogFragment.ItemClickDataListener {

    private static final String TAG = "LeftAppListAdapter";
    private static final String RECYCLER_APP = "recycler.app";
    private static final String RECYCLER_APP_MAP = "recycler.app.map";
    private static final int APP_PICKER_STATE_RETRY_LIMIT = 4;
    private static final long APP_PICKER_STATE_RETRY_MS = 150L;

    private List<AppListBean> mData;
    private final Launcher mLauncher;
    private final Helpers helpers = new Helpers();
    private long mDataSignature;

    /**
     * Slot the picker was opened for. Set BEFORE the dialog is shown and consumed exactly
     * once in {@link #onClickData}, so no stale target can survive between two openings.
     */
    private int mPendingPosition = RecyclerView.NO_POSITION;
    private long mPendingRowId = -1L;

    public LeftAppListAdapter(Launcher launcher, List<AppListBean> data) {
        this.mData = data;
        this.mLauncher = launcher;
        this.mDataSignature = calculateDataSignature(data);
        setHasStableIds(true);
    }

    // =====================================================================================
    // APP PICKER
    // =====================================================================================

    private void showAppPickerDialog(int position) {
        showAppPickerDialog(position, 0);
    }

    private void showAppPickerDialog(int position, int attempt) {
        if (position == RecyclerView.NO_POSITION || mData == null || position >= mData.size()) {
            return;
        }

        AppListBean target = mData.get(position);
        if (target == null) {
            return;
        }

        // Remember the target FIRST - every early return below used to leave the previous
        // click's slot in place.
        mPendingPosition = position;
        mPendingRowId = target.rowId;

        FragmentManager fragmentManager = mLauncher.getSupportFragmentManager();
        if (fragmentManager.isStateSaved()) {
            View decor = mLauncher.getWindow() == null ? null : mLauncher.getWindow().getDecorView();
            if (decor != null && attempt < APP_PICKER_STATE_RETRY_LIMIT) {
                decor.postDelayed(
                        () -> showAppPickerDialog(position, attempt + 1),
                        APP_PICKER_STATE_RETRY_MS
                );
            } else {
                mPendingPosition = RecyclerView.NO_POSITION;
                mPendingRowId = -1L;
            }
            return;
        }

        if (AppListDialogFragment.isListDialogShowing(fragmentManager)) {
            return;
        }

        // Always a fresh instance - see the note in AppListAdapter.showAppPickerDialog().
        AppListDialogFragment dialog = AppListDialogFragment.newInstance(target.rowId);
        dialog.setItemClickDataListener(this);
        dialog.show(fragmentManager, AppListDialogFragment.TAG);
    }

    @Override
    public void onClickData(AppInfo appInfo, long rowId) {
        final int position = mPendingPosition;
        final long targetRowId = rowId > 0L ? rowId : mPendingRowId;

        mPendingPosition = RecyclerView.NO_POSITION;
        mPendingRowId = -1L;

        if (appInfo == null || mData == null
                || position == RecyclerView.NO_POSITION || position >= mData.size()) {
            Log.w(TAG, "onClickData: no valid target slot, ignoring selection");
            return;
        }

        AppListBean bean = new AppListBean(
                appInfo.title == null ? "" : appInfo.title.toString(),
                appInfo.iconBitmap,
                appInfo.getPackageName(),
                appInfo.getClassName()
        );
        bean.rowId = targetRowId;

        mData.set(position, bean);
        mDataSignature = calculateDataSignature(mData);
        notifyItemChanged(position);

        if (targetRowId <= 0L) {
            // No physical row behind this bean. Fall back to the ordering path, which
            // rewrites the whole left bar correctly, instead of the old
            // saveOrUpdate("index = ?", ...) - see the note below.
            Log.w(TAG, "onClickData: bean has no rowId, falling back to refreshLeftCycle()");
            mLauncher.refreshLeftCycle(bean);
            return;
        }

        // Update by primary key, exactly like Launcher.refreshLeftCycle() does.
        //
        // The old code did:
        //     new LeftAppMultiple(lastClickIndex, ...).saveOrUpdate("index = ?", ...)
        // which was broken in two different ways, because every LeftAppMultiple row is
        // created with index = 0:
        //   - position 0  -> "index = 0" matches EVERY row, so the whole left bar got
        //                    overwritten with the same app;
        //   - position > 0 -> nothing matches, so saveOrUpdate() INSERTED a new row.
        //                    refreshLeftBar() reads order("id asc").limit(MAX_LEFT), so
        //                    that row was never visible - the pick silently did nothing
        //                    while the table kept growing.
        ContentValues values = new ContentValues();
        values.put("name", bean.name == null ? "" : bean.name);
        values.put("packageName", bean.packageName == null ? "" : bean.packageName);
        values.put("className", bean.className == null ? "" : bean.className);
        try {
            LitePal.update(LeftAppMultiple.class, values, targetRowId);
        } catch (Exception e) {
            Log.e(TAG, "onClickData: failed to persist left slot rowId=" + targetRowId, e);
        }
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
                showAppPickerDialog(appListHolder.getBindingAdapterPosition());

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

        appListHolder.itemView.setOnLongClickListener(view -> {
            showAppPickerDialog(appListHolder.getBindingAdapterPosition());
            return true;
        });
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
                    LeftAppListAdapter.this.mLauncher.sendBroadcast(new Intent(RECYCLER_APP_MAP));
                } else {
                    LeftAppListAdapter.this.mLauncher.sendBroadcast(new Intent(RECYCLER_APP));
                }
            }
        }
    }
}
