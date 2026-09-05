package com.android.recycler;

import static android.content.Context.MODE_PRIVATE;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
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

public class AppListAdapter extends RecyclerView.Adapter<AppListHolder>
        implements AppListDialogFragment.ItemClickDataListener {

    private static final String TAG = "AppListAdapter";
    private static final String RECYCLER_APP = "recycler.app";
    private static final String RECYCLER_APP_MAP = "recycler.app.map";
    private static final int APP_PICKER_STATE_RETRY_LIMIT = 4;
    private static final long APP_PICKER_STATE_RETRY_MS = 150L;

    private List<AppListBean> mData;
    private final Launcher mLauncher;
    private final Helpers helpers = new Helpers();
    private SharedPreferences mPrefs;
    private Bitmap mSettingsIconBitmap;
    private long mDataSignature;

    // Recycler width as a fraction of the screen, mirroring the values that
    // Workspace.forceOriginalSizesLayoutOne/Two() force onto the views.
    private static final float RECYCLER_W_WIDGET_PORTRAIT  = 0.4385f;
    private static final float RECYCLER_W_WIDGET_LANDSCAPE = 0.4395f;
    private static final float RECYCLER_W_PLAIN            = 0.8795f;

    // Recycler height as a fraction of its own width (portrait only; landscape fills the bar).
    private static final float RECYCLER_H_WIDGET_PORTRAIT = 0.295f;
    private static final float RECYCLER_H_PLAIN_PORTRAIT  = 0.142f;

    /** Share of the tile taken by the icon; the rest is breathing room. */
    private static final float ICON_FILL = 0.80f;

    /**
     * Slot the picker was opened for. Set BEFORE the dialog is shown and consumed exactly
     * once in {@link #onClickData}, so no stale target can survive between two openings.
     */
    private int mPendingPosition = RecyclerView.NO_POSITION;
    private long mPendingRowId = -1L;

    /**
     * Pending retry of the picker, used when the FragmentManager had saved its state.
     * Held explicitly because decor.postDelayed() ties the lambda to the Activity's view:
     * without cancellation the adapter, and through mLauncher the whole Activity, survives
     * for up to 4 x 150 ms after destruction.
     */
    private Runnable mPickerRetryRunnable;
    private View mPickerRetryHost;

    public AppListAdapter(Launcher mLauncher, List<AppListBean> mData) {
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(mLauncher);
        this.mData = mData;
        this.mLauncher = mLauncher;
        this.mDataSignature = calculateDataSignature(mData);
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

        // Remember the target FIRST. Every early return below used to leave the previous
        // click's slot in place, which is what made selections land on the wrong app.
        mPendingPosition = position;
        mPendingRowId = target.rowId;

        if (mLauncher.isFinishing() || mLauncher.isDestroyed()) {
            cancelPickerRetry();
            mPendingPosition = RecyclerView.NO_POSITION;
            mPendingRowId = -1L;
            return;
        }

        FragmentManager fragmentManager = mLauncher.getSupportFragmentManager();
        if (fragmentManager.isStateSaved()) {
            View decor = mLauncher.getWindow() == null ? null : mLauncher.getWindow().getDecorView();
            if (decor != null && attempt < APP_PICKER_STATE_RETRY_LIMIT) {
                schedulePickerRetry(decor, position, attempt + 1);
            } else {
                cancelPickerRetry();
                mPendingPosition = RecyclerView.NO_POSITION;
                mPendingRowId = -1L;
            }
            return;
        }

        cancelPickerRetry();

        if (AppListDialogFragment.isListDialogShowing(fragmentManager)) {
            return;
        }

        // showListDialog() always builds a fresh instance and removes any previous one
        // under the same tag, flushing pending transactions on the way.
        //
        // newInstance() + show() was not enough because show() commits asynchronously:
        // two quick taps (or a tap plus a long-click on a tile) both passed
        // isListDialogShowing() before the first transaction ran, and two instances ended
        // up added under the same tag. findFragmentByTag() only sees one of them, so
        // dismissListDialog() closed one while the other stayed added with its window and
        // ViewTree tags - and that one is what shows up as retained.
        AppListDialogFragment.showListDialog(fragmentManager, target.rowId, this);
    }

    private void schedulePickerRetry(View decor, final int position, final int attempt) {
        cancelPickerRetry();
        mPickerRetryHost = decor;
        mPickerRetryRunnable = new Runnable() {
            @Override
            public void run() {
                mPickerRetryRunnable = null;
                mPickerRetryHost = null;
                if (mLauncher.isFinishing() || mLauncher.isDestroyed()) {
                    return;
                }
                showAppPickerDialog(position, attempt);
            }
        };
        decor.postDelayed(mPickerRetryRunnable, APP_PICKER_STATE_RETRY_MS);
    }

    private void cancelPickerRetry() {
        if (mPickerRetryRunnable != null && mPickerRetryHost != null) {
            mPickerRetryHost.removeCallbacks(mPickerRetryRunnable);
        }
        mPickerRetryRunnable = null;
        mPickerRetryHost = null;
    }

    /**
     * Called by RecyclerView on setAdapter(null), e.g. from Workspace.onWorkspaceDestroy().
     * Last chance to drop delayed work that still holds the Activity.
     */
    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        cancelPickerRetry();
        mSettingsIconBitmap = null;
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public void onClickData(AppInfo appInfo, long rowId) {
        final int position = mPendingPosition;
        final long targetRowId = rowId > 0L ? rowId : mPendingRowId;

        // Consume the target: one dialog opening assigns exactly one slot.
        mPendingPosition = RecyclerView.NO_POSITION;
        mPendingRowId = -1L;

        if (appInfo == null || mData == null
                || position == RecyclerView.NO_POSITION || position >= mData.size()) {
            Log.w(TAG, "onClickData: no valid target slot, ignoring selection");
            return;
        }

        AppListBean previous = mData.get(position);
        AppListBean bean = new AppListBean(
                appInfo.title == null ? "" : appInfo.title.toString(),
                appInfo.iconBitmap,
                appInfo.getPackageName(),
                appInfo.getClassName()
        );
        bean.rowId = targetRowId;
        bean.slot = previous == null ? -1 : previous.slot;

        mData.set(position, bean);
        mDataSignature = calculateDataSignature(mData);
        notifyItemChanged(position);

        if (targetRowId <= 0L) {
            Log.w(TAG, "onClickData: bean has no rowId, cannot persist slot " + position);
            return;
        }

        // Update by primary key. The old code used saveOrUpdate("index = ?", ...): "index"
        // is a SQLite reserved keyword and must be quoted, AppMultiple.index is not
        // guaranteed unique, and LitePal skips fields left at their default value when it
        // builds an UPDATE - so a slot could never be cleared back to "".
        ContentValues values = new ContentValues();
        values.put("name", bean.name == null ? "" : bean.name);
        values.put("packageName", bean.packageName == null ? "" : bean.packageName);
        values.put("className", bean.className == null ? "" : bean.className);
        try {
            LitePal.update(AppMultiple.class, values, targetRowId);
        } catch (Exception e) {
            Log.e(TAG, "onClickData: failed to persist slot rowId=" + targetRowId, e);
        }
    }

    // =====================================================================================
    // ADAPTER
    // =====================================================================================

    public void notifyDataSetChanged(final List<AppListBean> list) {
        this.mLauncher.runOnUiThread(() -> {
            long newSignature = calculateDataSignature(list);
            if (AppListAdapter.this.mDataSignature == newSignature) {
                AppListAdapter.this.mData = list;
                return;
            }
            AppListAdapter.this.mData = list;
            AppListAdapter.this.mDataSignature = newSignature;
            AppListAdapter.this.notifyDataSetChanged();
        });
    }

    private long calculateDataSignature(List<AppListBean> list) {
        long signature = 1125899906842597L;
        if (list == null) {
            return signature;
        }
        signature = (signature * 31L) + list.size();
        for (int i = 0; i < list.size(); i++) {
            AppListBean bean = list.get(i);
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
    public AppListHolder onCreateViewHolder(final ViewGroup viewGroup, final int viewType) {
        return new AppListHolder(
                LayoutInflater.from(this.mLauncher).inflate(R.layout.item_app_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(final AppListHolder appListHolder, int position) {
        final AppListBean appListBean = this.mData.get(position);

        applyTileMetrics(appListHolder);

        if ("com.android.launcher66.settings.SettingsActivity".equals(appListBean.className)) {
            appListHolder.mAppIcon.setImageBitmap(getSettingsIconBitmap());
        } else {
            appListHolder.mAppIcon.setImageBitmap(appListBean.icon);
        }

        appListHolder.itemView.setOnClickListener(view -> {
            if (!isComponentAvailable(appListBean.packageName, appListBean.className)) {
                if (!TextUtils.isEmpty(appListBean.packageName) || !TextUtils.isEmpty(appListBean.className)) {
                    appListBean.packageName = "";
                    appListBean.className = "";
                    int pos = appListHolder.getBindingAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        notifyItemChanged(pos);
                    }
                }
                showAppPickerDialog(appListHolder.getBindingAdapterPosition());
                return;
            }

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
                AppListAdapter.this.mLauncher.onClickAllAppsButton();

            } else if ("com.android.launcher66.settings.SettingsActivity".equals(appListBean.className)) {
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
            showAppPickerDialog(appListHolder.getBindingAdapterPosition());
            return true;
        });
    }

    private void onClickIcon(AppListBean appListBean) {
        WindowUtil.removePip();
        helpers.setInOverviewMode(false);
        helpers.setListOpen(false);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this.mLauncher);
        boolean userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        AppListAdapter.this.mLauncher.refreshLeftCycle(appListBean);
        if (userLayout) {
            helpers.setForegroundAppOpened(true);
            helpers.setInAllApps(false);
            helpers.setInWidgets(false);
            helpers.setInRecent(false);
            boolean autoHideBottomBar = mPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false);
            if (autoHideBottomBar) {
                AppListAdapter.this.mLauncher.getWorkspace().hideBottomBar();
            }
            boolean userStats = mPrefs.getBoolean(Keys.USER_STATS, false);
            if (userStats) {
                SharedPreferences statsPrefs =
                        AppListAdapter.this.mLauncher.getSharedPreferences("AppStatsPrefs", MODE_PRIVATE);
                Set<String> apps = new HashSet<>(statsPrefs.getStringSet("stats_apps", new HashSet<String>()));
                if (apps.contains(appListBean.packageName)) {
                    AppListAdapter.this.mLauncher.sendBroadcast(new Intent(RECYCLER_APP_MAP));
                } else {
                    AppListAdapter.this.mLauncher.sendBroadcast(new Intent(RECYCLER_APP));
                }
            }
        }
        AppListAdapter.this.mLauncher.cleanWidgetBar();
    }

    public Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    private Bitmap getSettingsIconBitmap() {
        if (mSettingsIconBitmap == null) {
            mSettingsIconBitmap = drawableToBitmap(
                    ContextCompat.getDrawable(AppListAdapter.this.mLauncher, R.drawable.icon_settings));
        }
        return mSettingsIconBitmap;
    }

    private boolean isComponentAvailable(String packageName, String className) {
        if (TextUtils.isEmpty(packageName) || TextUtils.isEmpty(className)) {
            return false;
        }
        if ("com.android.launcher66".equals(packageName)) {
            return true;
        }
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(packageName, className));
            return mLauncher.getPackageManager().resolveActivity(intent, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }    

    /**
     * Divides the recycler width evenly between the tiles instead of letting each tile keep
     * its intrinsic width and hoping they fit.
     *
     * In portrait + widgetBar the recycler is only ~0.4385 of the screen, which is not
     * enough for four natural-width tiles: the fourth used to be clipped in the inline bar
     * and was squeezed in by NEGATIVE item offsets in the overlay bar. Sizing the tiles to
     * available/itemCount makes all four fit properly, identically in both bars - they
     * share this adapter, so both pick up the same metrics.
     *
     * Orientation is read on every bind, so a rotation no longer leaves stale sizes behind.
     */
    private void applyTileMetrics(AppListHolder holder) {
        int itemCount = getItemCount();
        if (itemCount <= 0) {
            return;
        }

        mPrefs = PreferenceManager.getDefaultSharedPreferences(this.mLauncher);
        boolean userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean widgetBar = mPrefs.getBoolean(Keys.WIDGET_BAR, false);
        boolean portrait = mLauncher.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;
        boolean widgetMode = userLayout && widgetBar;

        float widthFraction;
        if (widgetMode) {
            widthFraction = portrait ? RECYCLER_W_WIDGET_PORTRAIT : RECYCLER_W_WIDGET_LANDSCAPE;
        } else {
            widthFraction = RECYCLER_W_PLAIN;
        }

        int recyclerWidth = (int) (Launcher.screenWidth * widthFraction);
        if (recyclerWidth <= 0) {
            return;
        }

        int tileWidth = recyclerWidth / itemCount;
        if (tileWidth <= 0) {
            return;
        }

        // Height limit, so the icon never grows taller than the bar itself.
        int recyclerHeight;
        if (portrait) {
            recyclerHeight = (int) (recyclerWidth * (widgetMode
                    ? RECYCLER_H_WIDGET_PORTRAIT
                    : RECYCLER_H_PLAIN_PORTRAIT));
        } else {
            recyclerHeight = tileWidth;
        }

        int iconSize = (int) (Math.min(tileWidth, recyclerHeight) * ICON_FILL);
        if (iconSize <= 0) {
            return;
        }

        ViewGroup.LayoutParams itemParams = holder.itemView.getLayoutParams();
        if (itemParams != null && itemParams.width != tileWidth) {
            itemParams.width = tileWidth;
            holder.itemView.setLayoutParams(itemParams);
        }

        if (holder.mAppIcon != null) {
            ViewGroup.LayoutParams iconParams = holder.mAppIcon.getLayoutParams();
            if (iconParams != null && (iconParams.width != iconSize || iconParams.height != iconSize)) {
                iconParams.width = iconSize;
                iconParams.height = iconSize;
                holder.mAppIcon.setLayoutParams(iconParams);
            }
        }
    }
}
