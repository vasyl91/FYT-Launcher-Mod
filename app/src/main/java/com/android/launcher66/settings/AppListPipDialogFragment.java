package com.android.launcher66.settings;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
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
import androidx.preference.PreferenceManager;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

import com.android.async.AsyncTask;
import com.android.launcher66.AllAppsList;
import com.android.launcher66.AppInfo;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AppListPipDialogFragment extends DialogFragment implements AdapterView.OnItemClickListener {

    /** Single-select dialog to choose one app for a PiP slot (saved to DefaultSharedPreferences). */

    public static final String TAG = "AppListPipDialog";

    /** Argument key - also the SharedPreferences key the selection is written to. */
    private static final String ARG_PIP_KEY = "pip_key";

    /** #FC6B03 with alpha 90 baked in - avoids the getBackground().setAlpha() NPE path. */
    private static final int COLOR_SELECTED = Color.argb(90, 0xFC, 0x6B, 0x03);

    private static WeakReference<AppListPipDialogFragment> sInstance;

    ImageView currentAppIcon;
    TextView currentAppName;
    AppSelectAdapter mAdapter;
    ArrayList<AppInfo> mData;
    GridView mGridView;

    private View mRootView;
    private ItemClickDataListener mItemClickDataListener;
    private final Set<String> apps = new HashSet<>();
    private SharedPreferences pipsPrefs;
    private String pipKey;

    /** Set in onDestroyView so the background task never touches a dead view tree. */
    private volatile boolean mViewDestroyed;

    private OnBackPressedCallback mBackPressedCallback;

    private static final Set<String> EXCLUDED_PACKAGES = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList(
                    "com.android.launcher66.settings.SettingsActivity",
                    "com.syu.settings",
                    "com.syu.onekeynavi",
                    "ru.fytmods.frontapp",
                    "vasyl.titles",
                    "com.syu.widget.music",
                    "com.syu.screensaver",
                    "com.ava.car",
                    "cn.teyes.online",
                    "com.syu.gallery",
                    "com.syu.radio",
                    "com.syu.video",
                    "com.syu.av",
                    "com.syu.steer",
                    "com.syu.eq",
                    "com.syu.filemanager",
                    "com.syu.fourcamera2",
                    "com.syu.carlink",
                    "com.topjohnwu.magisk",
                    "app.revanced.android.gms",
                    "org.lsposed.manager")));

    public interface ItemClickDataListener {
        void onClickData(AppInfo appInfo);
    }

    /**
     * ALWAYS create the dialog through this factory - never reuse an instance that has
     * already been dismissed. A dismissed DialogFragment that is shown again becomes
     * strongly reachable after its onDestroy(), and its listener has already been nulled
     * in onDestroyView().
     */
    public static AppListPipDialogFragment newInstance(String pipKey) {
        AppListPipDialogFragment fragment = new AppListPipDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PIP_KEY, pipKey);
        fragment.setArguments(args);
        return fragment;
    }

    // =====================================================================================
    // API FOR EXTERNAL CALLERS
    // =====================================================================================

    /** @return true if a dialog was open and got dismissed */
    public static boolean dismissListDialog(FragmentManager fm) {
        Fragment f = fm.findFragmentByTag(TAG);
        if (f instanceof AppListPipDialogFragment && f.isAdded() && !f.isRemoving()) {
            try {
                // AllowStateLoss: the HOME broadcast can arrive after onSaveInstanceState
                ((AppListPipDialogFragment) f).dismissAllowingStateLoss();
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
        return f instanceof AppListPipDialogFragment && f.isAdded() && !f.isRemoving();
    }

    // =====================================================================================
    // LIFECYCLE
    // =====================================================================================

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewDestroyed = false;

        sInstance = new WeakReference<>(this);

        pipKey = (getArguments() != null) ? getArguments().getString(ARG_PIP_KEY, "") : "";
        // Application context on purpose: the prefs object outlives single callbacks and
        // getActivity() can already be null by the time toggleSelection() runs.
        pipsPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);

        // Seed current selection into the "apps" set to reuse original highlighting logic
        apps.clear();
        String preselected = pipsPrefs.getString(pipKey, "");
        if (preselected != null && !preselected.isEmpty()) {
            apps.add(preselected);
        }

        // attachToRoot MUST be false: DialogFragment adds the returned view itself.
        // The two-argument inflate() defaults to attachToRoot=true and made the view
        // land in the container twice on some recreation paths.
        View view = inflater.inflate(R.layout.dialog_piplist, container, false);
        mRootView = view;

        // Initialize UI components
        this.currentAppIcon = view.findViewById(R.id.current_app_icon);
        this.currentAppName = view.findViewById(R.id.current_app_name);
        this.mGridView = view.findViewById(R.id.gridview);

        // Snapshot on the main thread. AllAppsList.data is rebuilt on package
        // add/remove/update, so iterating it from doInBackground() could throw
        // ConcurrentModificationException or filter against a half-rebuilt list.
        ArrayList<AppInfo> snapshot = AllAppsList.data == null
                ? new ArrayList<AppInfo>()
                : new ArrayList<AppInfo>(AllAppsList.data);

        // Start background task to filter apps
        new FilterAppsTask(this, snapshot, pipsPrefs, pipKey).execute();

        view.setOnClickListener(v -> dismiss());

        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return view;
    }

    /**
     * Static so it does not hold an implicit reference to the fragment. The weak reference
     * is resolved only in onPostExecute and yields null once the dialog is gone, which both
     * prevents the leak and the NPE on the already nulled GridView.
     */
    private static class FilterAppsTask extends AsyncTask<Void, Void, ArrayList<AppInfo>> {
        private final WeakReference<AppListPipDialogFragment> fragmentRef;
        private final ArrayList<AppInfo> source;
        private final SharedPreferences prefs;
        private final String key;

        FilterAppsTask(AppListPipDialogFragment fragment,
                       ArrayList<AppInfo> source,
                       SharedPreferences prefs,
                       String key) {
            this.fragmentRef = new WeakReference<>(fragment);
            this.source = source;
            this.prefs = prefs;
            this.key = key;
        }

        @Override
        protected void onProgress(Void[] progress) {
            //
        }

        @Override
        protected ArrayList<AppInfo> doInBackground(Void... voids) {
            // Get packages selected in other PiP slots
            Set<String> otherSelectedPackages = getOtherSelectedPackages(prefs, key);
            String currentSelection = prefs.getString(key, "");

            // Create filtered list excluding other selected apps (keep current selection)
            ArrayList<AppInfo> filteredData = new ArrayList<>();
            for (AppInfo app : source) {
                if (app == null) {
                    continue;
                }
                String packageName = app.getPackageName();
                if (packageName == null) {
                    continue;
                }
                if (packageName.equals(currentSelection)) {
                    filteredData.add(app);
                } else if (!otherSelectedPackages.contains(packageName)
                        && !EXCLUDED_PACKAGES.contains(packageName)
                        && !packageName.toLowerCase().contains("launcher")) {
                    // Check for launcher in app name (in background)
                    String appName = getAppNameFromPackage(packageName);
                    if (appName != null && !appName.toLowerCase().contains("launcher")) {
                        filteredData.add(app);
                    }
                }
            }
            return filteredData;
        }

        @Override
        protected void onPostExecute(ArrayList<AppInfo> filteredData) {
            AppListPipDialogFragment f = fragmentRef.get();
            if (f == null || f.mViewDestroyed || f.mGridView == null || !f.isAdded()) {
                // Dialog was closed while filtering - nothing to bind to
                return;
            }
            f.bindFilteredApps(filteredData);
        }

        @Override
        protected void onBackgroundError(Exception e) {
            Log.w(TAG, "FilterAppsTask failed", e);
        }
    }

    /** Called from FilterAppsTask once the view tree is confirmed alive. */
    private void bindFilteredApps(ArrayList<AppInfo> filteredData) {
        if (mViewDestroyed || mGridView == null) {
            return;
        }
        mData = filteredData != null ? filteredData : new ArrayList<AppInfo>();
        mAdapter = new AppSelectAdapter(mData, apps);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);

        // The old OnScrollListener repainted cells by index and fought the view recycler:
        // getView() now owns the highlight, so scrolling can no longer show a stale colour
        // and there is one less anonymous inner class holding the fragment.
    }

    private static String getAppNameFromPackage(String packageName) {
        try {
            PackageManager packageManager = LauncherApplication.sApp.getPackageManager();
            ApplicationInfo appInfo = packageManager.getApplicationInfo(packageName, 0);
            return packageManager.getApplicationLabel(appInfo).toString();
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mViewDestroyed || mData == null || position < 0 || position >= mData.size()) {
            return;
        }
        AppInfo allApp = this.mData.get(position);
        toggleSelection(allApp.getPackageName());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ComponentDialog dialog = (ComponentDialog) super.onCreateDialog(savedInstanceState);
        mBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AppListPipDialogFragment.this.dismiss();
            }
        };
        dialog.getOnBackPressedDispatcher().addCallback(this, mBackPressedCallback);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        if (sInstance != null && sInstance.get() == this) {
            sInstance = null;
        }
        super.onDismiss(dialog);
    }

    @Override
    public void onDestroyView() {
        // First thing: the filter task and any pending callback must bail out immediately.
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
            // THE leak edge from the LeakCanary report:
            //   ConstraintLayout.mListenerInfo.mOnClickListener
            //     -> AppListPipDialogFragment$$ExternalSyntheticLambda0.f$0
            //       -> AppListPipDialogFragment
            // The dialog's ViewRootImpl outlives dismiss() by a couple of seconds
            // (pending framework message), and without this the fragment goes with it.
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
        currentAppIcon = null;
        currentAppName = null;
        mGridView = null;
        mRootView = null;
        mData = null;
        // Public API - the caller has no hook to clear it, so release it here
        mItemClickDataListener = null;

        if (sInstance != null && sInstance.get() == this) {
            sInstance = null;
        }
    }

    // =====================================================================================

    /**
     * Single-select behavior: choose exactly one package, save it, and dismiss.
     */
    public void toggleSelection(String packageName) {
        if (packageName == null) {
            return;
        }

        // Keep only the latest selection in the highlight set
        apps.clear();
        apps.add(packageName);

        // Persist into DefaultSharedPreferences under the pipKey
        if (pipKey != null && !pipKey.isEmpty() && pipsPrefs != null) {
            pipsPrefs.edit()
                    .putString(pipKey, packageName)
                    .apply();
        }

        // Notify optional listener. Snapshot the listener first: dismiss() runs the
        // teardown that nulls the field, so reading it twice is a race.
        ItemClickDataListener listener = mItemClickDataListener;
        if (listener != null && mData != null) {
            // Find the AppInfo to pass back
            for (AppInfo info : mData) {
                if (packageName.equals(info.getPackageName())) {
                    listener.onClickData(info);
                    break;
                }
            }
        } else if (listener == null) {
            // Happens when the system recreated the fragment (process death, config
            // change) - there is nobody left to receive the selection.
            Log.w(TAG, "toggleSelection: no listener attached, selection only persisted");
        }

        // Close after single selection
        dismiss();
    }

    private static Set<String> getOtherSelectedPackages(SharedPreferences prefs, String currentKey) {
        Set<String> otherSelected = new HashSet<>();
        Map<String, ?> allPrefs = prefs.getAll();
        for (String key : allPrefs.keySet()) {
            if (key.startsWith("pip_") && !key.equals(currentKey)) {
                Object value = allPrefs.get(key);
                if (value instanceof String packageName) {
                    if (!packageName.isEmpty()) {
                        otherSelected.add(packageName);
                    }
                }
            }
        }
        return otherSelected;
    }

    public int colorToSet(String packageName) {
        if (apps.contains(packageName)) return Color.TRANSPARENT;
        else return Color.parseColor("#FC6B03");
    }

    public int alphaToSet(String packageName) {
        if (apps.contains(packageName)) return 0;
        else return 90;
    }

    public boolean isShowing() {
        return getDialog() != null && getDialog().isShowing();
    }

    public void setItemClickDataListener(ItemClickDataListener listener) {
        this.mItemClickDataListener = listener;
    }

    /**
     * Static: as an inner class it kept an implicit reference to the fragment for as long
     * as the GridView lived. The selection set is passed in - it is a plain HashSet and
     * holds nothing back.
     */
    static class AppSelectAdapter extends BaseAdapter {
        final ArrayList<AppInfo> mData;
        final Set<String> mSelected;

        public AppSelectAdapter(ArrayList<AppInfo> data, Set<String> selected) {
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
                // parent.getContext() + attachToRoot=false: inflating with a null parent
                // dropped the cell LayoutParams and left the grid measuring by guesswork.
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

            // Highlight belongs here: a recycled cell must always be repainted, otherwise
            // it inherits the colour of whatever row it was used for before.
            convertView.setBackgroundColor(
                    mSelected.contains(data.getPackageName()) ? COLOR_SELECTED : Color.TRANSPARENT);

            return convertView;
        }
    }

    static class ViewHolder {
        ImageView appIcon;
        TextView appName;

        ViewHolder() {
        }
    }
}
