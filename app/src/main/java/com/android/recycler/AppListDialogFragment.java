package com.android.recycler;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.preference.PreferenceManager;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

import com.android.launcher66.AllAppsList;
import com.android.launcher66.AppInfo;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.settings.Helpers;
import com.android.launcher66.settings.Keys;
import com.syu.util.WindowUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;

public class AppListDialogFragment extends DialogFragment implements AdapterView.OnItemClickListener {
    public static final String TAG = "AppListDialogFragment";

    /** AppMultiple.rowId() of the bottom-bar slot this picker was opened for. */
    private static final String ARG_TARGET_ROW_ID = "target_row_id";

    ImageView currentAppIcon;
    TextView currentAppName;
    AppSelectAdapter mAdapter;
    ArrayList<AppInfo> mData;
    GridView mGridView;

    private View mRootView;
    private ItemClickDataListener mItemClickDataListener;
    private final Helpers helpers = new Helpers();

    /** Guards against clearing the state twice. */
    private boolean mListStateCleared;

    private OnBackPressedCallback mBackPressedCallback;

    /**
     * The instance is single-use: set once it closes, and any further show() is refused.
     *
     * In the heap dumps one instance carried two ObjectWatcher keys (watchDurationMillis
     * 6065 and 3724) and mLifecycleRegistry = RESUMED despite having received
     * Fragment#onDestroy() - the signature of a dismissed fragment being shown again,
     * which orphans the first showing's window tag for the life of the Activity.
     */
    private boolean mConsumed;

    /** Activity window decor, kept so tags can be cleared once getActivity() is null. */
    private WeakReference<View> mHostDecorRef;

    /**
     * The DIALOG window's decor, captured as soon as it exists.
     *
     * DialogFragment.setupViewTreeOwners() puts three keyed tags on that view
     * (view_tree_lifecycle_owner, view_tree_view_model_store_owner,
     * view_tree_saved_state_registry_owner), all pointing at this fragment - the
     * three-object SparseArray from the LeakCanary report.
     *
     * Cleaning up via getDialog() is not enough: on some close paths mDialog is already
     * null by the time onDestroyView() runs and the tags survive. Hence our own weak ref.
     */
    private WeakReference<View> mDialogDecorRef;

    public interface ItemClickDataListener {
        /**
         * @param appInfo the app the user picked
         * @param rowId   AppMultiple row the picker was opened for, or -1 if unknown.
         *                Passing it back makes the target explicit instead of relying on
         *                a field in the adapter that can go stale between two openings.
         */
        void onClickData(AppInfo appInfo, long rowId);
    }

    /**
     * ALWAYS create the dialog through this factory - never reuse an instance that has
     * already been dismissed. A dismissed DialogFragment that is shown again becomes
     * strongly reachable after its onDestroy(), which is exactly what LeakCanary reports
     * as "two watch keys on one instance / mLifecycleRegistry.state is INITIALIZED", and
     * its listener has already been nulled in onDestroyView().
     */
    public static AppListDialogFragment newInstance(long targetRowId) {
        AppListDialogFragment fragment = new AppListDialogFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_TARGET_ROW_ID, targetRowId);
        fragment.setArguments(args);
        return fragment;
    }

    private long getTargetRowId() {
        return getArguments() == null ? -1L : getArguments().getLong(ARG_TARGET_ROW_ID, -1L);
    }

    /**
     * The only correct way to open the list: always a fresh instance, with any previous
     * one removed from the FragmentManager so a dismissed fragment is never recycled.
     *
     * @return the new instance, or null if it could not be shown
     */
    public static AppListDialogFragment showListDialog(FragmentManager fm, long targetRowId,
                                                       ItemClickDataListener listener) {
        if (fm == null || fm.isDestroyed() || fm.isStateSaved()) {
            Log.w(TAG, "showListDialog: FragmentManager unavailable (destroyed/stateSaved)");
            return null;
        }

        Fragment prev = fm.findFragmentByTag(TAG);
        if (prev != null) {
            if (prev instanceof AppListDialogFragment) {
                try {
                    ((AppListDialogFragment) prev).dismissAllowingStateLoss();
                } catch (Throwable t) {
                    Log.w(TAG, "showListDialog: failed to dismiss the previous instance", t);
                }
            }
            try {
                fm.beginTransaction().remove(prev).commitAllowingStateLoss();
                fm.executePendingTransactions();
            } catch (Throwable t) {
                Log.w(TAG, "showListDialog: failed to remove the previous instance", t);
            }
        }

        AppListDialogFragment fragment = newInstance(targetRowId);
        fragment.setItemClickDataListener(listener);
        try {
            fragment.show(fm, TAG);
        } catch (Throwable t) {
            Log.w(TAG, "showListDialog: show() failed", t);
            return null;
        }
        return fragment;
    }

    @Override
    public void show(@NonNull FragmentManager manager, @Nullable String tag) {
        if (!claimForShow()) {
            return;
        }
        super.show(manager, tag);
    }

    @Override
    public void showNow(@NonNull FragmentManager manager, @Nullable String tag) {
        if (!claimForShow()) {
            return;
        }
        super.showNow(manager, tag);
    }

    @Override
    public int show(@NonNull FragmentTransaction transaction, @Nullable String tag) {
        if (!claimForShow()) {
            return -1;
        }
        return super.show(transaction, tag);
    }

    private boolean claimForShow() {
        if (mConsumed) {
            Log.w(TAG, "show(): this instance was already dismissed, skipping. "
                    + "Use AppListDialogFragment.showListDialog() or newInstance().");
            return false;
        }
        return true;
    }

    // =====================================================================================
    // API FOR EXTERNAL CALLERS (Launcher: HOME handler, onPause)
    // =====================================================================================

    /** @return true if a dialog was open and got dismissed */
    public static boolean dismissListDialog(FragmentManager fm) {
        Fragment f = fm.findFragmentByTag(TAG);
        if (f instanceof AppListDialogFragment && f.isAdded() && !f.isRemoving()) {
            try {
                // AllowStateLoss: the HOME broadcast can arrive after onSaveInstanceState
                ((AppListDialogFragment) f).dismissAllowingStateLoss();
                return true;
            } catch (Throwable t) {
                Log.w(TAG, "dismissListDialog() failed", t);
            }
        }

        // No dialog around - clean up only if the flag was actually left dangling
        if (new Helpers().isListOpen()) {
            clearListFlags();
        }
        return false;
    }

    /** Whether the list dialog is currently on screen. */
    public static boolean isListDialogShowing(FragmentManager fm) {
        Fragment f = fm.findFragmentByTag(TAG);
        return f instanceof AppListDialogFragment && f.isAdded() && !f.isRemoving();
    }

    /**
     * Resets the list state flags. Called only from onDismiss() or as a fallback
     * cleanup from dismissListDialog().
     */
    private static void clearListFlags() {
        Helpers h = new Helpers();
        h.setListOpen(false);
        h.setInRecent(false);

        SharedPreferences prefs =
                PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        boolean userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean userStats = prefs.getBoolean(Keys.USER_STATS, false);
        if (userLayout && userStats) {
            // Mirrors LIST_OPEN from onCreateView - same condition, so LIST_CLOSE is
            // never sent without a preceding LIST_OPEN.
            LauncherApplication.sApp.sendBroadcast(new Intent(Keys.LIST_CLOSE));
        }
    }

    // =====================================================================================
    // LIFECYCLE
    // =====================================================================================

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        WindowUtil.removePinnedPip();

        mListStateCleared = false;

        helpers.setListOpen(true);
        helpers.setInOverviewMode(false);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        boolean userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean userStats = prefs.getBoolean(Keys.USER_STATS, false);
        if (userLayout && userStats) {
            helpers.setForegroundAppOpened(false);
            helpers.setInAllApps(false);
            helpers.setInWidgets(false);
            helpers.setInRecent(false);
            LauncherApplication.sApp.sendBroadcast(new Intent(Keys.LIST_OPEN));
        }

        if (getActivity() != null && getActivity().getWindow() != null) {
            mHostDecorRef = new WeakReference<View>(getActivity().getWindow().getDecorView());
        }

        // attachToRoot MUST be false: DialogFragment adds the returned view itself.
        View view = inflater.inflate(R.layout.dialog_fragment_applist, container, false);
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
        this.mAdapter = new AppSelectAdapter(this.mData);
        this.mGridView.setAdapter(this.mAdapter);
        this.mGridView.setOnItemClickListener(this);

        // Background tap: dismiss only. Flags and broadcast come from onDismiss().
        view.setOnClickListener(v -> dismiss());

        assert getDialog() != null;
        Objects.requireNonNull(getDialog().getWindow()).requestFeature(Window.FEATURE_NO_TITLE);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getDialog() != null;
        Objects.requireNonNull(getDialog().getWindow()).setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setLayout(-1, -1);
        getDialog().setCanceledOnTouchOutside(true);
        rememberDialogDecor();
    }

    @Override
    public void onStart() {
        super.onStart();
        // setupViewTreeOwners() runs in onStart(), so capture the decor here as well.
        rememberDialogDecor();
    }

    private void rememberDialogDecor() {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            mDialogDecorRef = new WeakReference<View>(dialog.getWindow().getDecorView());
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mData == null || position < 0 || position >= mData.size()) {
            dismiss();
            return;
        }
        if (this.mItemClickDataListener != null) {
            this.mItemClickDataListener.onClickData(this.mData.get(position), getTargetRowId());
        } else {
            // Happens when the system recreated the fragment (process death, config
            // change) - there is nobody left to receive the selection.
            Log.w(TAG, "onItemClick: no listener attached, selection dropped");
        }
        dismiss();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ComponentDialog dialog = (ComponentDialog) super.onCreateDialog(savedInstanceState);
        mBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AppListDialogFragment.this.dismiss();
            }
        };
        dialog.getOnBackPressedDispatcher().addCallback(this, mBackPressedCallback);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    /**
     * THE ONLY cleanup point for the list state. Every close path goes through here:
     * background tap, app selection, back press, touch outside
     * (setCanceledOnTouchOutside), dismissListDialog() from the HOME handler and
     * activity teardown. This is what keeps isListOpen in sync with the actual UI.
     */
    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        mConsumed = true;
        if (!mListStateCleared) {
            mListStateCleared = true;
            clearListFlags();
        }
        super.onDismiss(dialog);
    }

    @Override
    public void onDestroyView() {
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
            //     -> AppListDialogFragment$$ExternalSyntheticLambda0.f$0
            //       -> AppListDialogFragment
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
            mGridView.setAdapter(null);
        }

        super.onDestroyView();

        mItemClickDataListener = null;
        mGridView = null;
        mRootView = null;
        currentAppIcon = null;
        currentAppName = null;
        mAdapter = null;
        mData = null;

        if (!mListStateCleared) {
            mListStateCleared = true;
            clearListFlags();
        }

        detachFromWindowTags();

        WindowUtil.openPinnedPip();
    }

    @Override
    public void onDestroy() {
        mConsumed = true;
        mItemClickDataListener = null;
        detachFromWindowTags();
        mHostDecorRef = null;
        super.onDestroy();
    }

    /**
     * Detaches this fragment from the windows' keyed tags. From the LeakCanary report:
     *   InputMethodManager.sInstance -> mNextServedView -> DecorView (live Activity)
     *     -> View.mKeyedTags -> SparseArray -> Object[0] -> AppListDialogFragment
     * The DecorView outlives the dialog, so an orphaned tag holds the dismissed fragment
     * indefinitely. Only tags that actually point at THIS fragment are cleared.
     */
    private void detachFromWindowTags() {
        View hostDecor = mHostDecorRef != null ? mHostDecorRef.get() : null;
        if (hostDecor == null && getActivity() != null && getActivity().getWindow() != null) {
            hostDecor = getActivity().getWindow().getDecorView();
        }
        clearOwnerTags(hostDecor);

        View dialogDecor = mDialogDecorRef != null ? mDialogDecorRef.get() : null;
        if (dialogDecor == null) {
            Dialog dialog = getDialog();
            if (dialog != null && dialog.getWindow() != null) {
                dialogDecor = dialog.getWindow().getDecorView();
            }
        }
        clearOwnerTags(dialogDecor);

        clearOwnerTags(mRootView);

        if (mDialogDecorRef != null) {
            mDialogDecorRef.clear();
            mDialogDecorRef = null;
        }
    }

    /** Clears every tag on the view that could point back at this fragment. */
    private void clearOwnerTags(View view) {
        if (view == null) {
            return;
        }
        clearFragmentTag(view);
        try {
            ViewTreeLifecycleOwner.set(view, null);
            ViewTreeViewModelStoreOwner.set(view, null);
            ViewTreeSavedStateRegistryOwner.set(view, null);
        } catch (Throwable t) {
            Log.w(TAG, "clearOwnerTags failed", t);
        }
    }

    private void clearFragmentTag(View view) {
        if (view == null) {
            return;
        }
        try {
            if (view.getTag(androidx.fragment.R.id.fragment_container_view_tag) == this) {
                view.setTag(androidx.fragment.R.id.fragment_container_view_tag, null);
            }
        } catch (Throwable t) {
            Log.w(TAG, "clearFragmentTag failed", t);
        }
    }

    // =====================================================================================

    static class AppSelectAdapter extends BaseAdapter {
        ArrayList<AppInfo> mData;

        public AppSelectAdapter(ArrayList<AppInfo> data) {
            this.mData = data;
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
            return convertView;
        }
    }

    static class ViewHolder {
        ImageView appIcon;
        TextView appName;

        ViewHolder() {
        }
    }

    public void setItemClickDataListener(ItemClickDataListener listener) {
        this.mItemClickDataListener = listener;
    }
}
