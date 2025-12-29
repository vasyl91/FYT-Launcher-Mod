package com.android.recycler;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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

import java.util.ArrayList;

public class AppListDialogFragment extends DialogFragment implements AdapterView.OnItemClickListener {
    ImageView currentAppIcon;
    TextView currentAppName;
    AppSelectAdapter mAdapter;
    ArrayList<AppInfo> mData;
    GridView mGridView;
    private ItemClickDataListener mItemClickDataListener;
    private Helpers helpers = new Helpers();

    public interface ItemClickDataListener {
        void onClickData(AppInfo appInfo);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        WindowUtil.removePinnedPip();
        helpers.setListOpen(true);
        helpers.setInOverviewMode(false);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean userStats = prefs.getBoolean(Keys.USER_STATS, false);
        if (userLayout && userStats)  { 
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
        view.setOnClickListener(v -> {
            AppListDialogFragment.this.dismiss(); 
            helpers.setListOpen(false);
            Intent intentClose = new Intent(Keys.LIST_CLOSE);
            LauncherApplication.sApp.sendBroadcast(intentClose);        
        });
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
                AppListDialogFragment.this.dismiss(); 
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                boolean userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
                boolean userStats = prefs.getBoolean(Keys.USER_STATS, false);
                if (userLayout && userStats)  {  
                    helpers.setListOpen(false);
                    helpers.setInRecent(false);
                    Intent intentClose = new Intent(Keys.LIST_CLOSE);
                    LauncherApplication.sApp.sendBroadcast(intentClose);  
                }    
            }
        };
        dialog.getOnBackPressedDispatcher().addCallback(this, callback);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
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
        WindowUtil.openPinnedPip();
    }

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