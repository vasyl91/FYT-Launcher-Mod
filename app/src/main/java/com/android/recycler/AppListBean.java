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

    public long stableId(int position) {
        boolean hasIdentity = !isEmpty(packageName) || !isEmpty(className);
        long id = 1125899906842597L;
        id = appendHash(id, hasIdentity ? packageName : "empty");
        id = appendHash(id, hasIdentity ? className : "");
        return (id * 31L) + position;
    }

    public long contentSignature(int position) {
        long id = stableId(position);
        id = appendHash(id, name);
        id = appendHash(id, packageName);
        id = appendHash(id, className);
        return id;
    }

    private static long appendHash(long seed, String value) {
        if (value == null) {
            return seed * 31L;
        }
        long result = seed;
        for (int i = 0; i < value.length(); i++) {
            result = (result * 31L) + value.charAt(i);
        }
        return result;
    }

    private static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
