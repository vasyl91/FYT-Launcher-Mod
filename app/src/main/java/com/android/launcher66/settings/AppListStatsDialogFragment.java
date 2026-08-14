package com.android.launcher66.settings;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.android.launcher66.AllAppsList;
import com.android.launcher66.AppInfo;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

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

    ImageView currentAppIcon;
    TextView currentAppName;
    AppSelectAdapter mAdapter;
    ArrayList<AppInfo> mData;
    GridView mGridView;
    private ItemClickDataListener mItemClickDataListener;
    private int positionCorrector = 0;
    private Set<String> apps = new HashSet<String>();
    private SharedPreferences statsPrefs;

    /** Set in onDestroyView so listeners never touch a dead view tree. */
    private volatile boolean mViewDestroyed;

    public interface ItemClickDataListener {
        void onClickData(AppInfo appInfo);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewDestroyed = false;

        // Application context on purpose: the prefs object outlives single callbacks and
        // getActivity() can already be null by the time toggleSelection() runs.
        statsPrefs = LauncherApplication.sApp.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        apps = new HashSet<>(statsPrefs.getStringSet(KEY_STATS_APPS, new HashSet<String>()));

        View view = inflater.inflate(R.layout.dialog_applist, container);
        this.mData = AllAppsList.data;
        this.currentAppIcon = (ImageView) view.findViewById(R.id.current_app_icon);
        this.currentAppName = (TextView) view.findViewById(R.id.current_app_name);
        this.mGridView = (GridView) view.findViewById(R.id.gridview);
        this.mAdapter = new AppSelectAdapter(this.mData);
        this.mGridView.setAdapter((ListAdapter) this.mAdapter);
        this.mGridView.setOnItemClickListener(this);
        this.mGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (mViewDestroyed || mGridView == null || mData == null) {
                    return;
                }
                apps = new HashSet<>(statsPrefs.getStringSet(KEY_STATS_APPS, new HashSet<String>()));
                for (int i = 0; i < totalItemCount && i < mData.size(); i++) {
                    View cellView = mGridView.getChildAt(i - firstVisibleItem);
                    positionCorrector = firstVisibleItem;
                    if (cellView == null) {
                        continue;
                    }
                    AppInfo allApp = mData.get(i);
                    if (apps.contains(String.valueOf(allApp.getPackageName()))) {
                        cellView.setBackgroundColor(Color.parseColor("#FC6B03"));
                        cellView.getBackground().setAlpha(90);
                    } else {
                        cellView.setBackgroundColor(Color.TRANSPARENT);
                    }
                }
            }

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //
            }
        });
        view.setOnClickListener(v -> AppListStatsDialogFragment.this.dismiss());
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().requestFeature(1);
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
    public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
        if (mData == null || position < 0 || position >= mData.size()) {
            return;
        }
        AppInfo allApp = this.mData.get(position);
        // getChildAt() returns null for recycled/off-screen cells - the click itself
        // must still be handled, only the immediate highlight is skipped.
        View cellView = this.mGridView.getChildAt(position - positionCorrector);
        if (cellView != null) {
            cellView.setBackgroundColor(colorToSet(allApp.getPackageName()));
            if (cellView.getBackground() != null) {
                cellView.getBackground().setAlpha(alphaToSet(allApp.getPackageName()));
            }
        }
        toggleSelection(allApp.getPackageName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewDestroyed = true;
        if (mGridView != null) {
            mGridView.setOnItemClickListener(null);
            mGridView.setOnScrollListener(null);
            mGridView.setAdapter(null);
        }
        mAdapter = null;
        currentAppIcon = null;
        currentAppName = null;
        mGridView = null;
        // mData points at the shared AllAppsList.data - drop the reference, never clear it
        mData = null;
        // Public API - the caller has no hook to clear it, so release it here
        mItemClickDataListener = null;
    }

    public void toggleSelection(String packageName) {
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

    class AppSelectAdapter extends BaseAdapter {
        ArrayList<AppInfo> mData;
        int positionCorrector = 0;

        public AppSelectAdapter(ArrayList<AppInfo> data) {
            this.mData = data;
        }

        public void updateView(int posCorrector) {
            this.positionCorrector = posCorrector;
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
                viewHolder = AppListStatsDialogFragment.this.new ViewHolder();
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
