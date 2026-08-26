package com.android.launcher66.settings;

import static android.content.Context.MODE_PRIVATE;

import android.app.Dialog;
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
import com.android.launcher66.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AppListStatsDialogFragment extends DialogFragment implements AdapterView.OnItemClickListener {

    /** Dialog window that displays apps which the user can select to display a stats window
     *  while the selected app is running in foreground
     */

    public static final String TAG = "AppListStatsDialog";
    private static final String PREFS_NAME = "AppStatsPrefs";
    private static final String KEY_STATS_APPS = "stats_apps";

    /** #FC6B03 with alpha 90 baked in - avoids the getBackground().setAlpha() NPE path. */
    private static final int COLOR_SELECTED = Color.argb(90, 0xFC, 0x6B, 0x03);

    private static WeakReference<AppListStatsDialogFragment> sInstance;

    ImageView currentAppIcon;
    TextView currentAppName;
    AppSelectAdapter mAdapter;
    ArrayList<AppInfo> mData;
    GridView mGridView;

    private View mRootView;
    private final Set<String> apps = new HashSet<>();
    private SharedPreferences statsPrefs;

    /** Set in onDestroyView so listeners never touch a dead view tree. */
    private volatile boolean mViewDestroyed;

    private OnBackPressedCallback mBackPressedCallback;

    /**
     * ALWAYS create the dialog through this factory - never reuse an instance that has
     * already been dismissed. A dismissed DialogFragment that is shown again becomes
     * strongly reachable after its onDestroy(), which is exactly what LeakCanary reports
     * as "two watch keys on one instance / mLifecycleRegistry.state is INITIALIZED".
     */
    public static AppListStatsDialogFragment newInstance() {
        return new AppListStatsDialogFragment();
    }

    // =====================================================================================
    // API FOR EXTERNAL CALLERS
    // =====================================================================================

    /** @return true if a dialog was open and got dismissed */
    public static boolean dismissListDialog(FragmentManager fm) {
        Fragment f = fm.findFragmentByTag(TAG);
        if (f instanceof AppListStatsDialogFragment && f.isAdded() && !f.isRemoving()) {
            try {
                // AllowStateLoss: the HOME broadcast can arrive after onSaveInstanceState
                ((AppListStatsDialogFragment) f).dismissAllowingStateLoss();
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
        return f instanceof AppListStatsDialogFragment && f.isAdded() && !f.isRemoving();
    }

    // =====================================================================================
    // LIFECYCLE
    // =====================================================================================

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewDestroyed = false;

        sInstance = new WeakReference<>(this);

        // Application context on purpose: the prefs object outlives single callbacks and
        // getActivity() can already be null by the time toggleSelection() runs.
        statsPrefs = LauncherApplication.sApp.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        apps.clear();
        apps.addAll(statsPrefs.getStringSet(KEY_STATS_APPS, new HashSet<>()));

        // attachToRoot MUST be false: DialogFragment adds the returned view itself.
        // The two-argument inflate() defaults to attachToRoot=true and made the view
        // land in the container twice on some recreation paths.
        View view = inflater.inflate(R.layout.dialog_applist, container, false);
        mRootView = view;

        // Snapshot instead of aliasing the global list. AllAppsList.data is rebuilt on
        // package add/remove/update; if that happened between binding and the tap, the
        // clicked position resolved to a DIFFERENT app than the one on screen.
        this.mData = AllAppsList.data == null
                ? new ArrayList<AppInfo>()
                : new ArrayList<AppInfo>(AllAppsList.data);

        this.currentAppIcon = view.findViewById(R.id.current_app_icon);
        this.currentAppName = view.findViewById(R.id.current_app_name);
        this.mGridView = view.findViewById(R.id.gridview);
        this.mAdapter = new AppSelectAdapter(this.mData, this.apps);
        this.mGridView.setAdapter(this.mAdapter);
        this.mGridView.setOnItemClickListener(this);

        // The old OnScrollListener repainted cells by index and fought the view recycler:
        // getView() now owns the highlight, so scrolling can no longer show a stale colour
        // and there is one less anonymous inner class holding the fragment.

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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mViewDestroyed || mData == null || position < 0 || position >= mData.size()) {
            return;
        }
        AppInfo allApp = this.mData.get(position);
        toggleSelection(allApp.getPackageName());

        // Repaint through the adapter instead of getChildAt(position - positionCorrector):
        // that arithmetic broke as soon as a cell was recycled or the grid was scrolled.
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
                AppListStatsDialogFragment.this.dismiss();
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
            // THE leak edge from the LeakCanary report:
            //   ConstraintLayout.mListenerInfo.mOnClickListener
            //     -> AppListStatsDialogFragment$$ExternalSyntheticLambda0.f$0
            //       -> AppListStatsDialogFragment
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

        if (sInstance != null && sInstance.get() == this) {
            sInstance = null;
        }
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
        if (statsPrefs == null) {
            return;
        }
        // Defensive copy: SharedPreferences keeps a reference to the stored Set, so writing
        // the live "apps" instance and mutating it afterwards corrupts the persisted value.
        // This also replaces the previous clear().commit() - commit() blocked the UI thread
        // on every single tap and was not needed, putStringSet overwrites the key anyway.
        statsPrefs.edit()
                .putStringSet(KEY_STATS_APPS, new HashSet<>(apps))
                .apply();
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

    /**
     * Static: a non-static adapter would keep an implicit reference to the fragment for as
     * long as the GridView lives. The selection set is passed in - it is a plain HashSet
     * and holds nothing back.
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
