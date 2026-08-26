package com.android.recycler;

import android.graphics.Bitmap;

public class AppListBean {
    public String className;
    public Bitmap icon;
    public String name;
    public String packageName;

    /**
     * Primary key of the AppMultiple row this bean was built from, or -1 when the bean
     * has no database backing (defaults built in memory, left-bar beans, ...).
     *
     * This is what makes "adapter position -> database index" arithmetic unnecessary:
     * the bean already knows which row it came from, even when the visible list is
     * compacted because widgetBar hides some slots.
     */
    public long rowId = -1L;

    /** AppMultiple.index (logical slot) of the source row, or -1. Diagnostics only. */
    public int slot = -1;

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

    /**
     * Stable across rebinds. When the bean is database backed the row id already is a
     * stable identity, so use it directly instead of hashing the component name.
     */
    public long stableId(int position) {
        if (rowId > 0L) {
            return rowId;
        }
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
        id = (id * 31L) + rowId;
        return (id * 31L) + slot;
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
