package com.android.recycler;

import org.litepal.crud.LitePalSupport;

public class LeftAppMultiple extends LitePalSupport {
    public String className;
    public int id;
    public int index;
    public String name;
    public String packageName;

    public LeftAppMultiple(int index, String name, String packageName, String className) {
        this.index = index;
        this.name = name;
        this.packageName = packageName;
        this.className = className;
    }
}
