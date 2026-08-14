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
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.preference.PreferenceManager;

import com.android.launcher66.AllAppsList;
import com.android.launcher66.AppInfo;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.settings.Helpers;
import com.android.launcher66.settings.Keys;
import com.syu.util.WindowUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class AppListDialogFragment extends DialogFragment implements AdapterView.OnItemClickListener {
    public static final String TAG = "AppListDialogFragment";

    /**
     * Reference to the currently visible dialog so it can be closed from the outside
     * (e.g. from the HOME button handler in Launcher). Weak because the field is static
     * and a fragment holds the activity Context - a strong reference would leak.
     */
    private static WeakReference<AppListDialogFragment> sInstance;

    ImageView currentAppIcon;
    TextView currentAppName;
    AppSelectAdapter mAdapter;
    ArrayList<AppInfo> mData;
    GridView mGridView;
    private ItemClickDataListener mItemClickDataListener;
    private final Helpers helpers = new Helpers();

    /** Guards against clearing the state twice. */
    private boolean mListStateCleared;

    public interface ItemClickDataListener {
        void onClickData(AppInfo appInfo);
    }

    // =====================================================================================
    // API FOR EXTERNAL CALLERS (Launcher: HOME handler, onPause)
    // =====================================================================================

    /** @return true if a dialog was open and got dismissed */
    public static boolean dismissListDialog() {
        AppListDialogFragment f = (sInstance != null) ? sInstance.get() : null;
        sInstance = null;
        if (f != null && f.isAdded() && !f.isRemoving()) {
            try {
                // AllowStateLoss: the HOME broadcast can arrive after onSaveInstanceState
                f.dismissAllowingStateLoss();
                return true;
            } catch (Throwable t) {
                Log.w(TAG, "dismissListDialog() failed", t);
            }
        }
        // No dialog around - clean up only if the flag was actually left dangling,
        // otherwise every onPause would fire another LIST_CLOSE broadcast.
        if (new Helpers().isListOpen()) {
            clearListFlags();
        }
        return false;
    }

    /** Whether the list dialog is currently on screen. */
    public static boolean isListDialogShowing() {
        AppListDialogFragment f = (sInstance != null) ? sInstance.get() : null;
        return f != null && f.isAdded() && !f.isRemoving();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        WindowUtil.removePinnedPip();

        mListStateCleared = false;
        sInstance = new WeakReference<>(this);

        helpers.setListOpen(true);
        helpers.setInOverviewMode(false);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean userStats = prefs.getBoolean(Keys.USER_STATS, false);
        if (userLayout && userStats) {
            helpers.setForegroundAppOpened(false);
            helpers.setInAllApps(false);
            helpers.setInWidgets(false);
            helpers.setInRecent(false);
            Intent intentOpen = new Intent(Keys.LIST_OPEN);
            LauncherApplication.sApp.sendBroadcast(intentOpen);
        }

        View view = inflater.inflate(R.layout.dialog_fragment_applist, container);
        this.mData = AllAppsList.data;
        this.currentAppIcon = (ImageView) view.findViewById(R.id.current_app_icon);
        this.currentAppName = (TextView) view.findViewById(R.id.current_app_name);
        this.mGridView = (GridView) view.findViewById(R.id.gridview);
        this.mAdapter = new AppSelectAdapter(this.mData);
        this.mGridView.setAdapter((ListAdapter) this.mAdapter);
        this.mGridView.setOnItemClickListener(this);

        // Background tap: dismiss only. Flags and broadcast come from onDismiss().
        view.setOnClickListener(v -> dismiss());

        getDialog().getWindow().requestFeature(1);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setLayout(-1, -1);
        getDialog().setCanceledOnTouchOutside(true);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
        if (this.mItemClickDataListener != null) {
            this.mItemClickDataListener.onClickData(this.mData.get(position));
        }
        dismiss();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ComponentDialog dialog = (ComponentDialog) super.onCreateDialog(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Dismiss only. Flags and broadcast come from onDismiss().
                AppListDialogFragment.this.dismiss();
            }
        };
        dialog.getOnBackPressedDispatcher().addCallback(this, callback);

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
        if (!mListStateCleared) {
            mListStateCleared = true;
            if (sInstance != null && sInstance.get() == this) {
                sInstance = null;
            }
            clearListFlags();
        }
        super.onDismiss(dialog);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mGridView != null) {
            mGridView.setAdapter(null);
        }
        currentAppIcon = null;
        currentAppName = null;
        mGridView = null;
        mAdapter = null;

        // Safety net: if the view is destroyed without onDismiss()
        // (e.g. activity killed), the flag still must not survive.
        if (!mListStateCleared) {
            mListStateCleared = true;
            if (sInstance != null && sInstance.get() == this) {
                sInstance = null;
            }
            clearListFlags();
        }

        WindowUtil.openPinnedPip();
    }

    // =====================================================================================

    public void clearReferences() {

    }

    class AppSelectAdapter extends BaseAdapter {
        ArrayList<AppInfo> mData;

        public AppSelectAdapter(ArrayList<AppInfo> data) {
            this.mData = data;
        }

        @Override
        public int getCount() {
            if (this.mData != null) {
                return this.mData.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int arg0) {
            return this.mData.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            AppInfo data = this.mData.get(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(LauncherApplication.sApp).inflate(R.layout.item_app_select, (ViewGroup) null);
                viewHolder = AppListDialogFragment.this.new ViewHolder();
                viewHolder.appIcon = (ImageView) convertView.findViewById(R.id.app_icon);
                viewHolder.appName = (TextView) convertView.findViewById(R.id.app_name);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.appIcon.setImageBitmap(data.iconBitmap);
            viewHolder.appName.setText(data.title);
            return convertView;
        }
    }

    class ViewHolder {
        ImageView appIcon;
        TextView appName;

        ViewHolder() {
        }
    }

    public void setItemClickDataListener(ItemClickDataListener listener) {
        this.mItemClickDataListener = listener;
    }
}