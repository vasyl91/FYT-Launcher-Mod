package com.syu.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

public abstract class Widget {
    protected int id;
    protected Context mContext;
    private RemoteViews mRemoteViews;
    protected Resources res;
    protected AppWidgetManager widgetManager;
    protected static SparseArray<Widget> mWidgets = new SparseArray<>();
    protected static HashMap<Class<? extends WidgetProvider>, Class<? extends Widget>> clazzs = new HashMap<>();
    protected int layoutId = 0;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable refresh = new Runnable() { 
        @Override
        public void run() {
            RemoteViews views = Widget.this.getRemoteViews();
            if (views != null) {
                Widget.this.updateViews(views);
                Widget.this.addLisenter(views);
                Widget.this.update(views);
            }
        }
    };

    abstract void addLisenter(RemoteViews remoteViews);

    abstract void getLayoutId();

    abstract void updateViews(RemoteViews remoteViews);

    static {
        clazzs.put(DateMusicProvider.class, DateMusicWidget.class);
        clazzs.put(DateTimeProvider.class, DateTimeWidget.class);
        clazzs.put(DateNaviProvider.class, DateNaviWidget.class);
        clazzs.put(DateRadioProvider.class, DateRadioWidget.class);
    }

    public static Widget getWidget(int key) {
        return mWidgets.get(key);
    }

    public static void check(Context context, AppWidgetManager manager) {
        for (Class<?> clazz : clazzs.keySet()) {
            int[] ids = manager.getAppWidgetIds(new ComponentName(context, clazz));
            if (ids != null) {
                for (int id : ids) {
                    if (getWidget(id) == null) {
                        try {
                            clazz = clazzs.get(clazz);
                            Constructor<?> constructor = clazz.getConstructor(Context.class, Integer.TYPE);
                            constructor.newInstance(context, Integer.valueOf(id));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void update(Context context) {
        AppWidgetManager manager = AppWidgetManager.getInstance(LauncherApplication.sApp);
        for (Class<?> clazz : clazzs.keySet()) {
            int[] ids = manager.getAppWidgetIds(new ComponentName(context, clazz));
            if (ids != null) {
                for (int id : ids) {
                    Widget widget = getWidget(id);
                    if (widget != null) {
                        widget.update(300);
                    }
                }
            }
        }
    }

    public static void widgetUpdate(Context context, Class<?> clazz) {
        int[] ids;
        AppWidgetManager manager = AppWidgetManager.getInstance(LauncherApplication.sApp);
        if (clazzs.get(clazz) != null && (ids = manager.getAppWidgetIds(new ComponentName(context, clazz))) != null) {
            for (int id : ids) {
                Widget widget = getWidget(id);
                if (widget != null) {
                    Log.d("LZP", "widgetUpdate...");
                    widget.update();
                }
            }
        }
    }

    public static RemoteViews getViewsByName(Context context, Class<?> clazz) {
        int[] ids;
        AppWidgetManager manager = AppWidgetManager.getInstance(LauncherApplication.sApp);
        if (clazzs.get(clazz) != null && (ids = manager.getAppWidgetIds(new ComponentName(context, clazz))) != null) {
            for (int id : ids) {
                Widget widget = getWidget(id);
                if (widget != null) {
                    return widget.getRemoteViews();
                }
            }
        }
        return null;
    }

    public static void naviStateChange(Context context, Class<?> clazz, int visible) {
        int[] ids;
        RemoteViews views;
        AppWidgetManager manager = AppWidgetManager.getInstance(LauncherApplication.sApp);
        if (clazzs.get(clazz) != null && (ids = manager.getAppWidgetIds(new ComponentName(context, clazz))) != null) {
            for (int id : ids) {
                Widget widget = getWidget(id);
                if (widget != null && (views = widget.getRemoteViews()) != null) {
                    views.setViewVisibility(R.id.widget_navi_img, visible);
                    widget.updateViews(views);
                    widget.addLisenter(views);
                    widget.update(views);
                }
            }
        }
    }

    public Widget(Context context, int id) {
        this.res = null;
        this.widgetManager = null;
        this.mContext = context;
        this.widgetManager = AppWidgetManager.getInstance(this.mContext);
        this.res = context.getResources();
        this.id = id;
        getLayoutId();
        add();
    }

    public void update() {
        update(0);
    }

    public void update(int delay) {
        this.mHandler.removeCallbacks(this.refresh);
        this.mHandler.postDelayed(this.refresh, delay);
    }

    protected void add() {
        synchronized (mWidgets) {
            mWidgets.put(this.id, this);
        }
    }

    public void delete() {
        synchronized (mWidgets) {
            mWidgets.remove(this.id);
        }
    }

    public RemoteViews getRemoteViews() {
        if (this.layoutId == 0) {
            return null;
        }
        RemoteViews views = new RemoteViews(this.mContext.getPackageName(), this.layoutId);
        return views;
    }

    public void update(RemoteViews views) {
        if (this.id != 0 && views != null) {
            this.widgetManager.updateAppWidget(this.id, views);
        }
    }

    public String getPackageName() {
        return this.mContext.getPackageName();
    }

    public int getLayoutId(String name) {
        return getResourceId(name, "layout");
    }

    public int getId(String name) {
        return getResourceId(name, "id");
    }

    public int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return -1;
        }
    }

    public int getResourceId(String name, String type) {
        switch (type) {
            case "string":
                return getResId(name, R.string.class);
            case "bool":
                return getResId(name, R.bool.class);
            case "integer":
                return getResId(name, R.integer.class);
            case "layout":
                return getResId(name, R.layout.class);
            case "drawable":
                return getResId(name, R.drawable.class);
            case "id":
                return getResId(name, R.id.class);
            case "xml":
                return getResId(name, R.xml.class);
            default:
                return -1;
        }
    }

    public RemoteViews getRemoteViews(int layoutId) {
        return new RemoteViews(this.mContext.getPackageName(), layoutId);
    }

    protected void saveBitmap(Bitmap bitmap, String bitmapName) throws Exception {
        this.mContext.deleteFile(bitmapName);
        try (FileOutputStream fos = this.mContext.openFileOutput(bitmapName, Context.MODE_PRIVATE)) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
