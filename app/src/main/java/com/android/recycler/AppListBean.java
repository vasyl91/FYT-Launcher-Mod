package com.android.recycler;

import android.graphics.Bitmap;

public class AppListBean {
    public String className;
    public Bitmap icon;
    public String name;
    public String packageName;

    public AppListBean() {
    }

    public AppListBean(String name, Bitmap icon, String packageName, String className) {
        this.name = name;
        this.icon = icon;
        this.packageName = packageName;
        this.className = className;
    }

    public AppListBean(String name, Bitmap icon) {
        this.name = name;
        this.icon = icon;
    }

    public AppListBean(String name, String packageName, String className) {
        this.name = name;
        this.packageName = packageName;
        this.className = className;
    }
}
