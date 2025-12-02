package com.android.recycler;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.R;

public class LeftAppListHolder extends RecyclerView.ViewHolder {
    public ImageView mAppIcon;

    public LeftAppListHolder(View view) {
        super(view);
        this.mAppIcon = (ImageView) view.findViewById(R.id.cycler_left_app_icon);
    }
}
