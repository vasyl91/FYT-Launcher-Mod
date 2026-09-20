package com.android.launcher66.settings;

import static android.content.Context.MODE_PRIVATE;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

import com.android.launcher66.AllAppsList;
import com.android.launcher66.AppInfo;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.MediaFavoriteController;
import com.android.launcher66.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Picks the players whose favorite state the launcher may keep in its own cache.
 *
 * Replaces the old global favorite-cache switch: the cache is opt-in per player now,
 * and MediaFavoriteController reads this list through {@link #isPackageSelected}.
 * Twin of {@link AppListStatsDialogFragment} - same layouts, same lifecycle hygiene -
 * with one difference: players whose like status a signed-in account owns are not
 * offered at all.
 *
 *   - YouTube ReVanced and YT Music ReVanced while fYT Rating holds an account;
 *   - Spotify while SpotifyRating holds one.
 *
 * Hiding them is only the visible half. The binding half is the hard block in
 * MediaFavoriteController.isFavoriteCacheUsable, which refuses the cache for those
 * players whatever is stored here - including a tick made before the account was
 * connected. Both halves ask the same predicate,
 * {@link MediaFavoriteController#isFavoriteCacheBlockedByAccount}, so this list can
 * never offer a player the controller would refuse.
 *
 * Opened from the settings screen the same way as the stats list:
 * <pre>
 * AppListCacheDialogFragment.newInstance()
 *         .show(getParentFragmentManager(), AppListCacheDialogFragment.TAG);
 * </pre>
 */
public class AppListCacheDialogFragment extends DialogFragment
        implements AdapterView.OnItemClickListener {

    public static final String TAG = "AppListCacheDialog";

    /** The store MediaFavoriteController reads; see {@link #isPackageSelected}. */
    public static final String PREFS_NAME = "AppCachePrefs";
    public static final String KEY_CACHE_APPS = "cache_apps";

    /** #FC6B03 with alpha 90 baked in, as in the stats list. */
    private static final int COLOR_SELECTED = Color.argb(90, 0xFC, 0x6B, 0x03);

    /** Application-context prefs, shared by the dialog and the read side. */
    private static volatile SharedPreferences sPrefs;

    private AppSelectAdapter mAdapter;

    /**
     * What is on screen: a snapshot of AllAppsList.data minus the players an account
     * owns. Changed in place on refresh, because the adapter holds this same list.
     */
    private ArrayList<AppInfo> mData;
    private GridView mGridView;
    private View mRootView;

    /**
     * Everything the user ticked, players hidden right now included. Those are kept,
     * not dropped: the tick is the user's choice, the block is the account's, and
     * signing out gives the old choice back. While the account is there the controller
     * ignores them, so keeping them costs nothing.
     */
    private final Set<String> apps = new HashSet<>();

    /** Set in onDestroyView so listeners never touch a dead view tree. */
    private volatile boolean mViewDestroyed;

    private OnBackPressedCallback mBackPressedCallback;

    /** Always a fresh instance; see AppListStatsDialogFragment.newInstance for why. */
    public static AppListCacheDialogFragment newInstance() {
        return new AppListCacheDialogFragment();
    }

    // =====================================================================================
    // READ SIDE - MediaFavoriteController
    // =====================================================================================

    /**
     * Whether the user put this player on the list.
     *
     * The opt-in only. Whether the cache may actually be used is
     * MediaFavoriteController.isFavoriteCacheUsable, which puts the account block on top.
     *
     * Asked on the main thread several times per widget draw, so it is one in-memory
     * lookup: no copy, and no disk after the first load. apply() updates the in-memory
     * map before it returns, so a tick counts here at once.
     */
    public static boolean isPackageSelected(String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            return false;
        }
        SharedPreferences prefs = prefs();
        if (prefs == null) {
            return false;
        }
        // Read only: SharedPreferences hands out the very instance it stores.
        Set<String> selected = prefs.getStringSet(KEY_CACHE_APPS, null);
        return selected != null && selected.contains(packageName);
    }

    /** Null only before the application object exists; the cache is off until then. */
    private static SharedPreferences prefs() {
        SharedPreferences prefs = sPrefs;
        if (prefs == null && LauncherApplication.sApp != null) {
            prefs = LauncherApplication.sApp.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            sPrefs = prefs;
        }
        return prefs;
    }

    // =====================================================================================
    // API FOR EXTERNAL CALLERS
    // =====================================================================================

    /** @return true if a dialog was open and got dismissed */
    public static boolean dismissListDialog(FragmentManager fm) {
        Fragment f = fm.findFragmentByTag(TAG);
        if (f instanceof AppListCacheDialogFragment && f.isAdded() && !f.isRemoving()) {
            try {
                // AllowStateLoss: the HOME broadcast can arrive after onSaveInstanceState
                ((AppListCacheDialogFragment) f).dismissAllowingStateLoss();
                return true;
            } catch (Throwable t) {
                Log.w(TAG, "dismissListDialog() failed", t);
            }
        }
        return false;
    }

    /** Whether the list dialog is currently on screen. */
    public static boolean isListDialogShowing(FragmentManager fm) {
        Fragment f = fm.findFragmentByTag(TAG);
        return f instanceof AppListCacheDialogFragment && f.isAdded() && !f.isRemoving();
    }

    // =====================================================================================
    // FILTERING
    // =====================================================================================

    /**
     * The players offered: every launcher app, minus the ones a signed-in account owns.
     *
     *   - YouTube ReVanced and YT Music ReVanced: hidden while fYT Rating holds an account;
     *   - Spotify: hidden while SpotifyRating holds one.
     *
     * The rule itself is MediaFavoriteController.isFavoriteCacheBlockedByAccount, the
     * predicate its hard block uses, so the two cannot drift apart. It is also wider
     * than a bare isLoggedIn(): ReVanced stays hidden while fYT Rating is only unsure of
     * an account it had confirmed, and Spotify while a refusal is being rechecked.
     *
     * Works on a snapshot: AllAppsList.data is rebuilt on package add, remove and update,
     * and a tap has to resolve to the app that was drawn in that cell.
     */
    static ArrayList<AppInfo> buildVisibleApps() {
        ArrayList<AppInfo> source = AllAppsList.data == null
                ? new ArrayList<AppInfo>()
                : new ArrayList<AppInfo>(AllAppsList.data);
        ArrayList<AppInfo> visible = new ArrayList<>(source.size());
        for (AppInfo app : source) {
            if (app == null) {
                continue;
            }
            String packageName = app.getPackageName();
            if (packageName == null || packageName.isEmpty()) {
                continue;
            }
            if (MediaFavoriteController.isFavoriteCacheBlockedByAccount(packageName)) {
                continue;
            }
            visible.add(app);
        }
        return visible;
    }

    /**
     * Filters the grid again, in place.
     *
     * Signing in happens outside this dialog - in fYT Rating, or in the browser for
     * Spotify - so an account can appear while the list is open.
     */
    private void refreshVisibleApps() {
        if (mViewDestroyed || mData == null || mAdapter == null) {
            return;
        }
        ArrayList<AppInfo> visible = buildVisibleApps();
        mData.clear();
        mData.addAll(visible);
        mAdapter.notifyDataSetChanged();
    }

    // =====================================================================================
    // LIFECYCLE
    // =====================================================================================

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewDestroyed = false;

        apps.clear();
        SharedPreferences prefs = prefs();
        if (prefs != null) {
            apps.addAll(prefs.getStringSet(KEY_CACHE_APPS, Collections.<String>emptySet()));
        }

        // attachToRoot false: DialogFragment adds the returned view itself.
        View view = inflater.inflate(R.layout.dialog_applist, container, false);
        mRootView = view;

        mData = buildVisibleApps();

        mGridView = view.findViewById(R.id.gridview);
        mAdapter = new AppSelectAdapter(mData, apps);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);

        view.setOnClickListener(v -> dismiss());

        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getDialog().getWindow().setLayout(-1, -1);
            getDialog().setCanceledOnTouchOutside(true);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Coming back from another app is exactly when an account may have appeared.
        refreshVisibleApps();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mViewDestroyed || mData == null || position < 0 || position >= mData.size()) {
            return;
        }
        String packageName = mData.get(position).getPackageName();

        // A row drawn before an account was connected. It is not ticked; the list is
        // filtered again instead. A tick the controller would ignore looks like it
        // does something and does not.
        if (MediaFavoriteController.isFavoriteCacheBlockedByAccount(packageName)) {
            refreshVisibleApps();
            return;
        }

        toggleSelection(packageName);
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ComponentDialog dialog = (ComponentDialog) super.onCreateDialog(savedInstanceState);
        mBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AppListCacheDialogFragment.this.dismiss();
            }
        };
        dialog.getOnBackPressedDispatcher().addCallback(this, mBackPressedCallback);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    /**
     * The one place every way out of this dialog passes through.
     *
     * A tap outside, the back button, the HOME broadcast through dismissListDialog,
     * or the fragment being torn down: androidx calls this from onDestroyView as
     * well, for the dismissal it performs itself. The widget is redrawn here so the
     * favorite button always matches the list that was just closed, whatever route
     * the user took out of it.
     */
    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Context context = getContext();
        MediaFavoriteController.refreshWidget(context != null ? context : LauncherApplication.sApp);
    }

    @Override
    public void onDestroyView() {
        // First thing: any callback still in flight must bail out immediately.
        mViewDestroyed = true;

        if (mBackPressedCallback != null) {
            mBackPressedCallback.remove();
            mBackPressedCallback = null;
        }

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnCancelListener(null);
            dialog.setOnDismissListener(null);

            if (dialog.getWindow() != null) {
                View decorView = dialog.getWindow().getDecorView();
                ViewTreeLifecycleOwner.set(decorView, null);
                ViewTreeViewModelStoreOwner.set(decorView, null);
                ViewTreeSavedStateRegistryOwner.set(decorView, null);
                decorView.setTag(androidx.fragment.R.id.fragment_container_view_tag, null);
            }
        }

        View view = mRootView != null ? mRootView : getView();
        if (view != null) {
            // The leak edge the stats list documents: the root's click listener holds
            // the fragment, and the dialog's ViewRootImpl outlives dismiss() briefly.
            view.setOnClickListener(null);
            view.setOnLongClickListener(null);
            view.setTag(androidx.fragment.R.id.fragment_container_view_tag, null);
            ViewTreeLifecycleOwner.set(view, null);
            ViewTreeViewModelStoreOwner.set(view, null);
            ViewTreeSavedStateRegistryOwner.set(view, null);
        }

        if (mGridView != null) {
            mGridView.setOnItemClickListener(null);
            mGridView.setOnScrollListener(null);
            mGridView.setAdapter(null);
        }

        super.onDestroyView();

        mAdapter = null;
        mGridView = null;
        mRootView = null;
        mData = null;
    }

    // =====================================================================================

    public void toggleSelection(String packageName) {
        if (packageName == null) {
            return;
        }
        if (apps.contains(packageName)) {
            apps.remove(packageName);
        } else {
            apps.add(packageName);
        }
        SharedPreferences prefs = prefs();
        if (prefs == null) {
            return;
        }
        // Defensive copy, as in the stats list: SharedPreferences keeps the Set it is
        // given, and isPackageSelected reads that very instance.
        prefs.edit()
                .putStringSet(KEY_CACHE_APPS, new HashSet<>(apps))
                .apply();

        // The controller already reads the new list; the redraw makes the button
        // follow now rather than on the next tick.
        MediaFavoriteController.refreshWidget(LauncherApplication.sApp);
    }

    public boolean isShowing() {
        return getDialog() != null && getDialog().isShowing();
    }

    /**
     * Static for the reason the stats list gives: a non-static adapter would hold the
     * fragment for as long as the GridView lives.
     */
    static class AppSelectAdapter extends BaseAdapter {
        final ArrayList<AppInfo> mData;
        final Set<String> mSelected;

        AppSelectAdapter(ArrayList<AppInfo> data, Set<String> selected) {
            this.mData = data;
            this.mSelected = selected;
        }

        @Override
        public int getCount() {
            return this.mData == null ? 0 : this.mData.size();
        }

        @Override
        public Object getItem(int position) {
            return this.mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            AppInfo data = this.mData.get(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_app_select, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.appIcon = convertView.findViewById(R.id.app_icon);
                viewHolder.appName = convertView.findViewById(R.id.app_name);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.appIcon.setImageBitmap(data.iconBitmap);
            viewHolder.appName.setText(data.title);

            // A recycled cell must always be repainted, or it keeps the colour of the
            // row it was used for before.
            convertView.setBackgroundColor(
                    mSelected.contains(data.getPackageName()) ? COLOR_SELECTED : Color.TRANSPARENT);
            return convertView;
        }
    }

    static class ViewHolder {
        ImageView appIcon;
        TextView appName;
    }
}
