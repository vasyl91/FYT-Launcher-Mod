package com.android.launcher66.settings;

import static android.content.Context.MODE_PRIVATE;

import android.app.Dialog;
import android.content.Context;
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
import com.android.launcher66.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Picks the apps the launcher starts by itself after a cold boot, once the boot-time stall is
 * over (LauncherApplication.scheduleBootAutostart() reads {@link #getSelectedPackages}).
 *
 * Meant for apps that would otherwise be on FYT's own autostart list. FYT SystemUI starts those
 * about three seconds after BOOT_COMPLETED, right into the boot-time stall, and the launcher then
 * stays frozen for ~11 s inside the framework's activityTopResumedStateLost(). An app belongs on
 * one of the two lists, not on both.
 */
public class AppListAutostartDialogFragment extends DialogFragment
        implements AdapterView.OnItemClickListener {

    public static final String TAG = "AppListAutostartDialog";

    /** The store LauncherApplication reads at every cold boot; see {@link #getSelectedPackages}. */
    public static final String PREFS_NAME = "AppAutostartPrefs";
    /** Comma-separated package names, in start order. */
    public static final String KEY_AUTOSTART_APPS = "boot_autostart_packages";

    /** #FC6B03 with alpha 90 baked in, as in the other lists. */
    private static final int COLOR_SELECTED = Color.argb(90, 0xFC, 0x6B, 0x03);

    /** Application-context prefs, shared by the dialog and the read side. */
    private static volatile SharedPreferences sPrefs;

    private AppSelectAdapter mAdapter;

    /** What is on screen: a snapshot of AllAppsList.data, one cell per package. */
    private ArrayList<AppInfo> mData;
    private GridView mGridView;
    private View mRootView;

    /**
     * Everything the user ticked, in start order. Apps that are not installed any more stay on
     * it: reinstalling one gives the old choice back, and the boot autostart skips what it
     * cannot launch.
     */
    private final List<String> apps = new ArrayList<>();

    /** Set in onDestroyView so listeners never touch a dead view tree. */
    private volatile boolean mViewDestroyed;

    private OnBackPressedCallback mBackPressedCallback;

    /** Always a fresh instance; see AppListStatsDialogFragment.newInstance for why. */
    public static AppListAutostartDialogFragment newInstance() {
        return new AppListAutostartDialogFragment();
    }

    // =====================================================================================
    // READ SIDE - LauncherApplication
    // =====================================================================================

    /** The apps to start after a cold boot, in start order. Never null. */
    public static List<String> getSelectedPackages(@Nullable Context context) {
        SharedPreferences prefs = prefs(context);
        return prefs == null ? new ArrayList<String>() : parse(prefs.getString(KEY_AUTOSTART_APPS, ""));
    }

    /** Null only before any context exists; the list is empty until then. */
    private static SharedPreferences prefs(@Nullable Context context) {
        SharedPreferences prefs = sPrefs;
        if (prefs == null) {
            Context base = context != null ? context : LauncherApplication.sApp;
            if (base != null) {
                prefs = base.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                sPrefs = prefs;
            }
        }
        return prefs;
    }

    // =====================================================================================
    // STORED FORMAT
    // =====================================================================================

    /** "a, b,,a " -> [a, b]: trimmed, no empty entries, no duplicates, order kept. */
    static List<String> parse(@Nullable String raw) {
        List<String> out = new ArrayList<>();
        if (raw == null) {
            return out;
        }
        for (String part : raw.split(",")) {
            String pkg = part.trim();
            if (!pkg.isEmpty() && !out.contains(pkg)) {
                out.add(pkg);
            }
        }
        return out;
    }

    /** The inverse of {@link #parse}. */
    static String join(List<String> packages) {
        StringBuilder sb = new StringBuilder();
        for (String pkg : packages) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(pkg);
        }
        return sb.toString();
    }

    /** Ticks or unticks; a new tick goes to the end of the start order. */
    static void toggle(List<String> selected, String packageName) {
        if (!selected.remove(packageName)) {
            selected.add(packageName);
        }
    }

    // =====================================================================================
    // API FOR EXTERNAL CALLERS
    // =====================================================================================

    /** @return true if a dialog was open and got dismissed */
    public static boolean dismissListDialog(FragmentManager fm) {
        Fragment f = fm.findFragmentByTag(TAG);
        if (f instanceof AppListAutostartDialogFragment && f.isAdded() && !f.isRemoving()) {
            try {
                // AllowStateLoss: the HOME broadcast can arrive after onSaveInstanceState
                ((AppListAutostartDialogFragment) f).dismissAllowingStateLoss();
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
        return f instanceof AppListAutostartDialogFragment && f.isAdded() && !f.isRemoving();
    }

    // =====================================================================================
    // FILTERING
    // =====================================================================================

    /**
     * Every launcher app except the launcher itself, one cell per package: the boot autostart
     * starts a package's own launch activity, so a second cell of the same package would only
     * mirror the first one's tick.
     *
     * Works on a snapshot: AllAppsList.data is rebuilt on package add, remove and update, and a
     * tap has to resolve to the app that was drawn in that cell.
     */
    static ArrayList<AppInfo> buildVisibleApps(@Nullable String ownPackage) {
        ArrayList<AppInfo> source = AllAppsList.data == null
                ? new ArrayList<AppInfo>()
                : new ArrayList<AppInfo>(AllAppsList.data);
        ArrayList<AppInfo> visible = new ArrayList<>(source.size());
        Set<String> seen = new HashSet<>();
        for (AppInfo app : source) {
            if (app == null) {
                continue;
            }
            String packageName = app.getPackageName();
            if (packageName == null || packageName.isEmpty() || packageName.equals(ownPackage)) {
                continue;
            }
            if (seen.add(packageName)) {
                visible.add(app);
            }
        }
        return visible;
    }

    /** Rebuilds the grid in place: apps may have been installed or removed meanwhile. */
    private void refreshVisibleApps() {
        if (mViewDestroyed || mData == null || mAdapter == null) {
            return;
        }
        ArrayList<AppInfo> visible = buildVisibleApps(ownPackage());
        mData.clear();
        mData.addAll(visible);
        mAdapter.notifyDataSetChanged();
    }

    @Nullable
    private String ownPackage() {
        Context context = getContext();
        if (context == null) {
            context = LauncherApplication.sApp;
        }
        return context != null ? context.getPackageName() : null;
    }

    // =====================================================================================
    // LIFECYCLE
    // =====================================================================================

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewDestroyed = false;

        apps.clear();
        apps.addAll(getSelectedPackages(inflater.getContext()));

        // attachToRoot false: DialogFragment adds the returned view itself.
        View view = inflater.inflate(R.layout.dialog_bootlist, container, false);
        mRootView = view;

        mData = buildVisibleApps(inflater.getContext().getPackageName());

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
        refreshVisibleApps();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mViewDestroyed || mData == null || position < 0 || position >= mData.size()) {
            return;
        }
        toggleSelection(mData.get(position).getPackageName());
        if (mAdapter != null) {
            // Every ticked cell shows its place in the order, so all of them may change.
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
                AppListAutostartDialogFragment.this.dismiss();
            }
        };
        dialog.getOnBackPressedDispatcher().addCallback(this, mBackPressedCallback);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
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
            // The leak edge the stats list documents: the root's click listener holds the
            // fragment, and the dialog's ViewRootImpl outlives dismiss() briefly.
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
        toggle(apps, packageName);
        SharedPreferences prefs = prefs(getContext());
        if (prefs == null) {
            return;
        }
        prefs.edit()
                .putString(KEY_AUTOSTART_APPS, join(apps))
                .apply();
    }

    public boolean isShowing() {
        return getDialog() != null && getDialog().isShowing();
    }

    /**
     * Static for the reason the stats list gives: a non-static adapter would hold the fragment
     * for as long as the GridView lives.
     */
    static class AppSelectAdapter extends BaseAdapter {
        final ArrayList<AppInfo> mData;
        /** The fragment's own list, so ticks show up without copying. */
        final List<String> mSelected;

        AppSelectAdapter(ArrayList<AppInfo> data, List<String> selected) {
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

            // A recycled cell must always be repainted and relabelled, or it keeps the colour
            // and the number of the row it was used for before.
            int order = mSelected.indexOf(data.getPackageName());
            viewHolder.appName.setText(order >= 0 ? (order + 1) + ". " + data.title : data.title);
            convertView.setBackgroundColor(order >= 0 ? COLOR_SELECTED : Color.TRANSPARENT);
            return convertView;
        }
    }

    static class ViewHolder {
        ImageView appIcon;
        TextView appName;
    }
}
