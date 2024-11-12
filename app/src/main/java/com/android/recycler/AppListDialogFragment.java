package com.android.recycler;

import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.android.launcher66.AllAppsList;
import com.android.launcher66.AppInfo;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.util.ArrayList;

public class AppListDialogFragment extends DialogFragment implements AdapterView.OnItemClickListener {
    ImageView currentAppIcon;
    TextView currentAppName;
    AppSelectAdapter mAdapter;
    ArrayList<AppInfo> mData;
    GridView mGridView;
    private ItemClickDataListener mItemClickDataListener;

    public interface ItemClickDataListener {
        void onClickData(AppInfo appInfo);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_applist, container);
        this.mData = AllAppsList.data;
        this.currentAppIcon = (ImageView) view.findViewById(R.id.current_app_icon);
        this.currentAppName = (TextView) view.findViewById(R.id.current_app_name);
        this.mGridView = (GridView) view.findViewById(R.id.gridview);
        this.mAdapter = new AppSelectAdapter(this.mData);
        this.mGridView.setAdapter((ListAdapter) this.mAdapter);
        this.mGridView.setOnItemClickListener(this);
        view.setOnClickListener(v -> AppListDialogFragment.this.dismiss());
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setType(2999);
        super.onActivityCreated(savedInstanceState);
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
