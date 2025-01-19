package com.syu.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;

import com.android.launcher66.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class CustomIcons {
    static CustomIcons instance = null;
    public static List<Entry> mCustomIcons;

    static {
        mCustomIcons = null;
        mCustomIcons = new ArrayList();
    }

    public static CustomIcons getInstance() {
        if (instance == null) {
            instance = new CustomIcons();
        }
        return instance;
    }

    public static void addCustomIcon(String pkg, String clazz, int resid) {
        Entry entry = new Entry(pkg, clazz, resid);
        if (!mCustomIcons.contains(entry)) {
            mCustomIcons.add(entry);
        }
    }

    public static int getIcon(ActivityInfo info) {
        int index;
        Entry entry = new Entry(info.packageName, info.name, 0);
        if (!mCustomIcons.contains(entry) || (index = mCustomIcons.indexOf(entry)) < 0) {
            return 0;
        }
        Entry app = mCustomIcons.get(index);
        Log.e("lunch", String.format("pkg:%s, clazz:%s, icon:%d", app.pkgName, app.clazzName, Integer.valueOf(app.resid)));
        return app.resid;
    }

    public static void loadIcons(Context context, int resid) {
        try {
            XmlResourceParser parser = context.getResources().getXml(resid);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            beginDocument(parser, "customicons");
            int depth = parser.getDepth();
            while (true) {
                int type = parser.next();
                if ((type != 3 || parser.getDepth() > depth) && type != 1) {
                    if (type == 2) {
                        String name = parser.getName();
                        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Entry);
                        if ("entry".equals(name)) {
                            String pkg = a.getString(0);
                            String clazz = a.getString(R.styleable.Entry_eclazz);
                            int iconid = a.getResourceId(R.styleable.Entry_eicon, 0);
                            addCustomIcon(pkg, clazz, iconid);
                        }
                        a.recycle();
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void beginDocument(XmlPullParser parser, String firstElementName) throws XmlPullParserException, IOException {
        int type;
        do {
            type = parser.next();
            if (type == 2) {
                break;
            }
        } while (type != 1);
        if (type != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (!parser.getName().equals(firstElementName)) {
            throw new XmlPullParserException("Unexpected start tag: found " + parser.getName() + ", expected " + firstElementName);
        }
    }

    public static class Entry {
        String clazzName;
        String pkgName;
        int resid;

        public Entry(String pkg, String clazz, int res) {
            this.pkgName = pkg;
            this.clazzName = clazz;
            this.resid = res;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Entry)) {
                return super.equals(o);
            }
            Entry other = (Entry) o;
            boolean checkPkg = false;
            if (other.pkgName != null) {
                checkPkg = this.pkgName.equals(other.pkgName);
                if (this.clazzName != null || other.clazzName != null) {
                    if (this.clazzName != null) {
                        boolean checkClazz = false;
                        if (other.clazzName != null) {
                            checkClazz = this.clazzName.equals(other.clazzName);
                        }
                        return checkPkg && checkClazz;
                    }
                    boolean checkClazz2 = other.clazzName == null;
                    return checkPkg && checkClazz2;
                }
            }
            return checkPkg;
        }
    }
}
