package com.android.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.R;

public class AppListHolder extends RecyclerView.ViewHolder {
    public ImageView mAppIcon;
    public TextView mAppName;

    public AppListHolder(View view) {
        super(view);
        this.mAppIcon = (ImageView) view.findViewById(R.id.cycler_app_icon);
    }
}
