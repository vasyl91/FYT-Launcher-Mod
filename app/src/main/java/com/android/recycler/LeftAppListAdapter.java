package com.android.recycler;

import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.launcher66.Launcher;
import com.android.launcher66.R;
import com.syu.util.FytPackage;
import com.syu.util.WindowUtil;

import java.util.List;

public class LeftAppListAdapter extends RecyclerView.Adapter<LeftAppListHolder> {
    private int lastClickIndex;
    private View mAddAppView;
    private List<AppListBean> mData;
    private AppListDialogFragment mDialog;
    private Launcher mLauncher;
    private int mMaxCount = 4;
    private boolean showAddAppView;

    public LeftAppListAdapter(Launcher launcher, List<AppListBean> data) {
        this.mData = data;
        this.mLauncher = launcher;
    }

    @Override
    public int getItemCount() {
        this.showAddAppView = this.mData.size() > this.mMaxCount;
        return this.mData.size();
    }

    public void onBindViewHolder(final LeftAppListHolder appListHolder, int position) {
        final AppListBean appListBean = this.mData.get(position);
        appListHolder.mAppIcon.setImageBitmap(appListBean.icon);
        appListHolder.itemView.setOnClickListener(view -> {
            final String packageName = appListBean.packageName;
            switch (packageName.hashCode()) {
                case -1958346218: {
                    if (!packageName.equals("com.google.android.googlequicksearchbox")) {
                        break;
                    }
                }
                case 877333343: {
                    if (packageName.equals("net.easyconn")) {
                        WindowUtil.removePip(null);
                    }
                    break;
                }
                case 1489048446: {
                    if (packageName.equals("com.nng.igo.primong.igoworld")) {
                        WindowUtil.removePip(null);
                    }
                    break;
                }
            }
            if (TextUtils.isEmpty(appListBean.packageName) || TextUtils.isEmpty(appListBean.className)) {
                LeftAppListAdapter.this.mDialog.show(LeftAppListAdapter.this.mLauncher.getFragmentManager(), "");
                LeftAppListAdapter.this.lastClickIndex = appListHolder.getBindingAdapterPosition();
            }
            else if (appListBean.packageName.equals("com.android.launcher66")) {
                LeftAppListAdapter.this.mLauncher.onClickAllAppsButton(view);
            } else {
                final Intent intent = new Intent();
                intent.setComponent(new ComponentName(appListBean.packageName, appListBean.className));
                LeftAppListAdapter.this.mLauncher.startActivitySafely(view, intent, "");
                LeftAppListAdapter.this.mLauncher.refreshLeftCycle(appListBean);
            }
        });
        appListHolder.itemView.setOnLongClickListener(view -> {
            LeftAppListAdapter.this.mDialog.show(LeftAppListAdapter.this.mLauncher.getFragmentManager(), "");
            LeftAppListAdapter.this.lastClickIndex = appListHolder.getBindingAdapterPosition();
            return true;
        });
    }

    @Override
    public LeftAppListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LeftAppListHolder(LayoutInflater.from(this.mLauncher).inflate(R.layout.item_left_app_list, parent, false));
    }

    public void notifyDataSetChanged(final List<AppListBean> data) {
        this.mLauncher.runOnUiThread(() -> {
            LeftAppListAdapter.this.mData = data;
            LeftAppListAdapter.this.notifyDataSetChanged();
        });
    }
}
