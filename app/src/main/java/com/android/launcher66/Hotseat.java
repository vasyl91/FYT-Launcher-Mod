package com.android.launcher66;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.android.launcher66.CellLayout;
import com.syu.car.CarStates;
import com.syu.util.ActivityStartUtils;
import com.syu.util.JLog;
import com.syu.util.PackageManagers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import share.ResValue;

public class Hotseat extends FrameLayout {
    private static final String TAG = "Hotseat";
    private int mAllAppsButtonRank;
    private CellLayout mContent;
    private boolean mIsLandscape;
    private Launcher mLauncher;
    private boolean mTransposeLayoutWithOrientation;

    public Hotseat(Context context) {
        this(context, null);
    }

    public Hotseat(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Hotseat(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Resources r = context.getResources();
        this.mIsLandscape = r.getBoolean(R.bool.hotseat_landscape_layout);
        JLog.getInstance().e("Hotseat orientation mIsLandscape == " + this.mIsLandscape);
    }

    public void setup(Launcher launcher) {
        this.mLauncher = launcher;
        setOnKeyListener(new HotseatIconKeyEventListener());
    }

    CellLayout getLayout() {
        return this.mContent;
    }

    @Override
    public void setOnLongClickListener(View.OnLongClickListener l) {
        this.mContent.setOnLongClickListener(l);
    }

    private boolean hasVerticalHotseat() {
        return !this.mIsLandscape;
    }

    int getOrderInHotseat(int x, int y) {
        if (!hasVerticalHotseat()) {
            return x;
        }
        int x2 = (this.mContent.getCountY() - y) - 1;
        return x2;
    }

    int getCellXFromOrder(int rank) {
        if (hasVerticalHotseat()) {
            return 0;
        }
        return rank;
    }

    int getCellYFromOrder(int rank) {
        if (hasVerticalHotseat()) {
            return this.mContent.getCountY() - (rank + 1);
        }
        return 0;
    }

    public boolean isAllAppsButtonRank(int rank) {
        return !AppsCustomizePagedView.DISABLE_ALL_APPS && rank == this.mAllAppsButtonRank;
    }

    Rect getCellCoordinates(int cellX, int cellY) {
        Rect coords = new Rect();
        this.mContent.cellToRect(cellX, cellY, 1, 1, coords);
        int[] hotseatInParent = new int[2];
        Utilities.getDescendantCoordRelativeToParent(this, this.mLauncher.getDragLayer(), hotseatInParent, false);
        coords.offset(hotseatInParent[0], hotseatInParent[1]);
        int cWidth = this.mContent.getShortcutsAndWidgets().getCellContentWidth();
        int cHeight = this.mContent.getShortcutsAndWidgets().getCellContentHeight();
        int cellPaddingX = (int) Math.max(0.0f, (coords.width() - cWidth) / 2.0f);
        int cellPaddingY = (int) Math.max(0.0f, (coords.height() - cHeight) / 2.0f);
        coords.offset(cellPaddingX, cellPaddingY);
        return coords;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        this.mAllAppsButtonRank = grid.hotseatAllAppsRank;
        this.mContent = (CellLayout) findViewById(R.id.layout);
        if (!this.mIsLandscape) {
            this.mContent.setGridSize(1, (int) grid.numHotseatIcons);
        } else {
            this.mContent.setGridSize((int) grid.numHotseatIcons, 1);
        }
        this.mContent.setIsHotseat(true);
        JLog.getInstance().e("Cell width = " + this.mContent.getCellWidth() + " Cell Height = " + this.mContent.getHeight());
        resetLayout();
    }

    void resetLayout() {
        this.mContent.removeAllViewsInLayout();
        if (!AppsCustomizePagedView.DISABLE_ALL_APPS) {
            addDefultIcon(ResValue.getInstance().all_apps_button_icon, R.string.all_apps_button_label, this.mAllAppsButtonRank);
            if (!getResources().getBoolean(R.bool.hotseat_load_defualt_workspace)) {
                LauncherAppState app = LauncherAppState.getInstance();
                DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
                int count = grid.mDefualtIcons.size();
                if (count > 0) {
                    int index = 0;
                    for (int i = 0; i < count; i++) {
                        addDefultIcon(grid.drawableArray[i], grid.nameArray[i], index < this.mAllAppsButtonRank ? index : index + 1);
                        index++;
                    }
                }
            }
        }
    }

    void addDefultIcon(int icon, final String pkg, int index) {
        Context context = getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        final TextView newBtn = (TextView) inflater.inflate(R.layout.all_apps_button, (ViewGroup) this.mContent, false);
        Drawable d = ContextCompat.getDrawable(context, icon);
        Utilities.resizeHotseatIconDrawable(d);
        newBtn.setCompoundDrawables(null, d, null, null);
        newBtn.setTag(findIntentFromPackage(pkg));
        if (pkg.equals(PackageManagers.NAVI)) {
            newBtn.setText(getResources().getString(R.string.car_navi));
        } else if (pkg.equals("com.syu.radio")) {
            newBtn.setText(getResources().getString(R.string.car_radio));
        } else if (pkg.equals("com.syu.music")) {
            newBtn.setText(getResources().getString(R.string.car_music));
        } else if (pkg.equals("com.syu.video")) {
            newBtn.setText(getResources().getString(R.string.car_video));
        } else if (pkg.equals("com.syu.bt")) {
            newBtn.setText(getResources().getString(R.string.car_bt));
        } else if (pkg.equals("com.syu.settings")) {
            newBtn.setText(getResources().getString(R.string.car_settings));
        }
        newBtn.setTextSize(16.0f);
        if (this.mLauncher != null) {
            newBtn.setOnTouchListener(this.mLauncher.getHapticFeedbackTouchListener());
        }
        newBtn.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Hotseat.this.mLauncher != null) {
                    Intent intent = (Intent) v.getTag();
                    if (pkg != null && !pkg.equals("")) {
                        if (PackageManagers.NAVI.equals(pkg)) {
                            CarStates.getCar(Hotseat.this.mLauncher).mTools.sendInt(0, 24, 0);
                        } else {
                            ActivityStartUtils.startActivitySafely(Hotseat.this.mLauncher, newBtn, intent, pkg);
                        }
                    }
                }
            }
        });
        int x = getCellXFromOrder(index);
        int y = getCellYFromOrder(index);
        CellLayout.LayoutParams lp = new CellLayout.LayoutParams(x, y, 1, 1);
        lp.canReorder = false;
        this.mContent.addViewToCellLayout(newBtn, -1, 0, lp, true);
    }

    void addDefultIcon(int icon, int title, int index) {
        Context context = getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        TextView newBtn = (TextView) inflater.inflate(R.layout.all_apps_button, (ViewGroup) this.mContent, false);
        Drawable d = ContextCompat.getDrawable(context, icon);
        Utilities.resizeIconDrawable(d);
        newBtn.setCompoundDrawables(null, d, null, null);
        newBtn.setContentDescription(context.getString(title));
        if (this.mLauncher != null) {
            newBtn.setOnTouchListener(this.mLauncher.getHapticFeedbackTouchListener());
        }
        newBtn.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Hotseat.this.mLauncher != null) {
                    Hotseat.this.mLauncher.onClickAllAppsButton(v);
                }
            }
        });
        int x = getCellXFromOrder(index);
        int y = getCellYFromOrder(index);
        CellLayout.LayoutParams lp = new CellLayout.LayoutParams(x, y, 1, 1);
        lp.canReorder = false;
        this.mContent.addViewToCellLayout(newBtn, -1, 0, lp, true);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.mLauncher.getWorkspace().isSmall();
    }

    void addAllAppsFolder(IconCache iconCache, ArrayList<AppInfo> allApps, ArrayList<ComponentName> onWorkspace, Launcher launcher, Workspace workspace) {
        if (AppsCustomizePagedView.DISABLE_ALL_APPS) {
            FolderInfo fi = new FolderInfo();
            fi.cellX = getCellXFromOrder(this.mAllAppsButtonRank);
            fi.cellY = getCellYFromOrder(this.mAllAppsButtonRank);
            fi.spanX = 1;
            fi.spanY = 1;
            fi.container = -101L;
            fi.screenId = this.mAllAppsButtonRank;
            fi.itemType = 2;
            fi.title = "More Apps";
            LauncherModel.addItemToDatabase(launcher, fi, fi.container, fi.screenId, fi.cellX, fi.cellY, false);
            FolderIcon folder = FolderIcon.fromXml(R.layout.folder_icon, launcher, getLayout(), fi, iconCache);
            workspace.addInScreen(folder, fi.container, fi.screenId, fi.cellX, fi.cellY, fi.spanX, fi.spanY);
            Iterator<AppInfo> it = allApps.iterator();
            while (it.hasNext()) {
                AppInfo info = it.next();
                ComponentName cn2 = info.intent.getComponent();
                if (!onWorkspace.contains(cn2)) {
                    Log.d(TAG, "Adding to 'more apps': " + info.intent);
                    ShortcutInfo si = info.makeShortcut();
                    fi.add(si);
                }
            }
        }
    }

    void addAppsToAllAppsFolder(ArrayList<AppInfo> apps) {
        if (AppsCustomizePagedView.DISABLE_ALL_APPS) {
            View v = this.mContent.getChildAt(getCellXFromOrder(this.mAllAppsButtonRank), getCellYFromOrder(this.mAllAppsButtonRank));
            if (v instanceof FolderIcon) {
                FolderIcon fi = (FolderIcon) v;
                FolderInfo info = fi.getFolderInfo();
                Iterator<AppInfo> it = apps.iterator();
                while (it.hasNext()) {
                    AppInfo a = it.next();
                    Log.d("LZP", "AppInfo a : apps");
                    ShortcutInfo si = a.makeShortcut();
                    info.add(si);
                }
            }
        }
    }

    Intent findIntentFromPackage(String pkg) {
        Intent mainIntent = new Intent("android.intent.action.MAIN", (Uri) null);
        mainIntent.addCategory("android.intent.category.LAUNCHER");
        mainIntent.setPackage(pkg);
        PackageManager pm = getContext().getPackageManager();
        List<ResolveInfo> apps = pm.queryIntentActivities(mainIntent, 0);
        if (apps.size() <= 0) {
            return null;
        }
        ResolveInfo app = apps.get(0);
        Intent mainIntent2 = new Intent("android.intent.action.MAIN");
        mainIntent2.addCategory("android.intent.category.LAUNCHER");
        mainIntent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        mainIntent2.setComponent(new ComponentName(pkg, app.activityInfo.name));
        return mainIntent2;
    }
}
