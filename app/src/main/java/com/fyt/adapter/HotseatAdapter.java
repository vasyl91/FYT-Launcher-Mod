package com.fyt.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import com.android.launcher66.Launcher;
import com.syu.log.LogPreview;

import java.util.ArrayList;

public class HotseatAdapter extends PagerAdapter implements View.OnClickListener {
    private final Launcher mLauncher;
    private final ArrayList<View> mPagerList;

    public HotseatAdapter(Launcher context, ArrayList<View> list) {
        this.mLauncher = context;
        this.mPagerList = list;
    }

    @Override
    public int getCount() {
        return this.mPagerList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = this.mPagerList.get(position);
        setViews(view);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        container.removeView(this.mPagerList.get(position));
    }

    private void setViews(View view) {
        LogPreview.show("setViews");
        if (view instanceof ViewGroup) {
            ViewGroup views = (ViewGroup) view;
            LogPreview.show("ViewGroup:" + views.getChildCount());
            for (int i = 0; i < views.getChildCount(); i++) {
                views.getChildAt(i).setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
    }
}
