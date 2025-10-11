package com.android.launcher66.settings;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.AllAppsList;
import com.android.launcher66.AppInfo;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AppListPipDialogFragment extends DialogFragment implements AdapterView.OnItemClickListener {

    /** Single-select dialog to choose one app for a PiP slot (saved to DefaultSharedPreferences). */

    ImageView currentAppIcon;
    TextView currentAppName;
    AppSelectAdapter mAdapter;
    ArrayList<AppInfo> mData;
    GridView mGridView;
    private ItemClickDataListener mItemClickDataListener;
    private HashSet<Integer> selectedPositions = new HashSet<>();
    private int positionCorrector = 0;
    private Set<String> apps = new HashSet<String>();
    private SharedPreferences statsPrefs;
    private String pipKey;
    private static final Set<String> EXCLUDED_PACKAGES = new HashSet<String>() {{
        add("com.android.launcher66.settings.SettingsActivity");
        add("com.syu.settings");
        add("com.syu.onekeynavi");
        add("ru.fytmods.frontapp");
    }};

    public interface ItemClickDataListener {
        void onClickData(AppInfo appInfo);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        pipKey = (getArguments() != null) ? getArguments().getString("pip_key", "") : "";
        statsPrefs = PreferenceManager.getDefaultSharedPreferences(requireContext());

        // Seed current selection into the "apps" set to reuse original highlighting logic
        apps.clear();
        String preselected = statsPrefs.getString(pipKey, "");
        if (preselected != null && !preselected.isEmpty()) {
            apps.add(preselected);
        }

        View view = inflater.inflate(R.layout.dialog_piplist, container);
        
        // Initialize UI components
        this.currentAppIcon = (ImageView) view.findViewById(R.id.current_app_icon);
        this.currentAppName = (TextView) view.findViewById(R.id.current_app_name);
        this.mGridView = (GridView) view.findViewById(R.id.gridview);
        
        // Start background task to filter apps
        new FilterAppsTask().execute();
        
        view.setOnClickListener(v -> {
            AppListPipDialogFragment.this.dismiss();
        });
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().requestFeature(1);
        }
        return view;
    }

    private class FilterAppsTask extends AsyncTask<Void, Void, ArrayList<AppInfo>> {
        @Override
        protected void onProgress(Void[] progress) {
            //
        }

        @Override
        protected ArrayList<AppInfo> doInBackground(Void... voids) {
            // Get packages selected in other PiP slots
            Set<String> otherSelectedPackages = getOtherSelectedPackages(pipKey);
            String currentSelection = statsPrefs.getString(pipKey, "");

            // Create filtered list excluding other selected apps (keep current selection)
            ArrayList<AppInfo> filteredData = new ArrayList<>();
            for (AppInfo app : AllAppsList.data) {
                String packageName = app.getPackageName();
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
            mData = filteredData;
            mAdapter = new AppSelectAdapter(mData);
            mGridView.setAdapter(mAdapter);
            mGridView.setOnItemClickListener(AppListPipDialogFragment.this);
            mGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    // Re-read saved single selection to keep highlight in sync while scrolling
                    apps.clear();
                    String saved = statsPrefs.getString(pipKey, "");
                    if (saved != null && !saved.isEmpty()) {
                        apps.add(saved);
                    }
                    for (int i = 0; i < totalItemCount; i++) {
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
                    // No implementation needed
                }
            });
        }

        @Override
        protected void onBackgroundError(Exception e) {

        }
    }
    
    private String getAppNameFromPackage(String packageName) {
        try {
            PackageManager packageManager = LauncherApplication.sApp.getPackageManager();
            ApplicationInfo appInfo = packageManager.getApplicationInfo(packageName, 0);
            return packageManager.getApplicationLabel(appInfo).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setType(2999);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getDialog().getWindow().setLayout(-1, -1);
            getDialog().setCanceledOnTouchOutside(true);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
        AppInfo allApp = this.mData.get(position);
        View cellView = (View) this.mGridView.getChildAt(position - positionCorrector);
        cellView.setBackgroundColor(colorToSet(allApp.getPackageName()));
        cellView.getBackground().setAlpha(alphaToSet(allApp.getPackageName()));
        toggleSelection(allApp.getPackageName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mGridView != null) {
            mGridView.setAdapter(null);
        }
        mAdapter = null;
        currentAppIcon = null;
        currentAppName = null;
        mGridView = null;
    }

    /**
     * Single-select behavior: choose exactly one package, save it, and dismiss.
     */
    public void toggleSelection(String packageName) {
        // Keep only the latest selection in the highlight set
        apps.clear();
        apps.add(packageName);

        // Persist into DefaultSharedPreferences under the pipKey
        if (pipKey != null && !pipKey.isEmpty()) {
            SharedPreferences.Editor editor = statsPrefs.edit();
            editor.putString(pipKey, packageName);
            editor.apply();
        }

        // Notify optional listener
        if (mItemClickDataListener != null) {
            // Find the AppInfo to pass back
            for (AppInfo info : mData) {
                if (packageName.equals(info.getPackageName())) {
                    mItemClickDataListener.onClickData(info);
                    break;
                }
            }
        }

        // Close after single selection
        dismiss();
    }

    private Set<String> getOtherSelectedPackages(String currentKey) {
        Set<String> otherSelected = new HashSet<>();
        Map<String, ?> allPrefs = statsPrefs.getAll();
        for (String key : allPrefs.keySet()) {
            if (key.startsWith("pip_") && !key.equals(currentKey)) {
                Object value = allPrefs.get(key);
                if (value instanceof String) {
                    String packageName = (String) value;
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
                viewHolder = new ViewHolder();
                viewHolder.appIcon = (ImageView) convertView.findViewById(R.id.app_icon);
                viewHolder.appName = (TextView) convertView.findViewById(R.id.app_name);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.appIcon.setImageBitmap(data.iconBitmap);
            viewHolder.appName.setText(data.title);

            // Apply highlight based on current single selection
            if (apps.contains(String.valueOf(data.getPackageName()))) {
                convertView.setBackgroundColor(Color.parseColor("#FC6B03"));
                convertView.getBackground().setAlpha(90);
            } else {
                convertView.setBackgroundColor(Color.TRANSPARENT);
            }

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
