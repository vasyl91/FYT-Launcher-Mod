package com.android.launcher66;

import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.syu.util.PackageManagers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import share.ResValue;

public class DeviceProfile {
    int allAppsNumCols;
    int allAppsNumRows;
    int availableHeightPx;
    int availableWidthPx;
    int cellHeightPx;
    int cellWidthPx;
    Rect defaultWidgetPadding;
    int desiredWorkspaceLeftRightMarginPx;
    int edgeMarginPx;
    int folderBackgroundOffset;
    int folderCellHeightPx;
    int folderCellWidthPx;
    int folderIconSizePx;
    int heightPx;
    int hotseatAllAppsRank;
    int hotseatBarHeightPx;
    int hotseatCellHeightPx;
    int hotseatCellWidthPx;
    float hotseatIconSize;
    int hotseatIconSizePx;
    float iconSize;
    int iconSizePx;
    float iconTextSize;
    int iconTextSizePx;
    boolean isLandscape;
    boolean isLargeTablet;
    boolean isTablet;
    float minHeightDps;
    float minWidthDps;
    String name;
    float numColumns;
    float numHotseatIcons;
    float numRows;
    int pageIndicatorHeightPx;
    int searchBarHeightPx;
    int searchBarSpaceHeightPx;
    int searchBarSpaceMaxWidthPx;
    int searchBarSpaceWidthPx;
    boolean transposeLayoutWithOrientation;
    int widthPx;
    HashMap<Integer, HashMap<String, Integer>> mDefualtIcons = new HashMap<>();
    String[] nameArray = {PackageManagers.NAVI, "com.syu.radio", "com.syu.bt"};
    int[] drawableArray = {ResValue.getInstance().car_navi_icon, ResValue.getInstance().car_radio_icon, ResValue.getInstance().car_bt_icon};

    DeviceProfile(String n, float w, float h, float r, float c, float is, float its, float hs, float his) {
        if (!AppsCustomizePagedView.DISABLE_ALL_APPS && hs % 2.0f == 0.0f) {
            throw new RuntimeException("All Device Profiles must have an odd number of hotseat spaces");
        }
        this.name = n;
        this.minWidthDps = w;
        this.minHeightDps = h;
        this.numRows = r;
        this.numColumns = c;
        this.iconSize = is;
        this.iconTextSize = its;
        this.numHotseatIcons = hs;
        this.hotseatIconSize = his;
    }

    DeviceProfile(Context context, ArrayList<DeviceProfile> profiles, float minWidth, float minHeight, int wPx, int hPx, int awPx, int ahPx, Resources resources) {
        DisplayMetrics dm = resources.getDisplayMetrics();
        ArrayList<DeviceProfileQuery> points = new ArrayList<>();
        this.transposeLayoutWithOrientation = resources.getBoolean(R.bool.hotseat_transpose_layout_with_orientation);
        this.minWidthDps = minWidth;
        this.minHeightDps = minHeight;
        ComponentName cn2 = new ComponentName(context.getPackageName(), getClass().getName());
        this.defaultWidgetPadding = AppWidgetHostView.getDefaultPaddingForWidget(context, cn2, null);
        this.edgeMarginPx = resources.getDimensionPixelSize(R.dimen.dynamic_grid_edge_margin);
        this.desiredWorkspaceLeftRightMarginPx = this.edgeMarginPx * 2;
        this.pageIndicatorHeightPx = resources.getDimensionPixelSize(R.dimen.dynamic_grid_page_indicator_height);
        Iterator<DeviceProfile> it = profiles.iterator();
        while (it.hasNext()) {
            DeviceProfile p = it.next();
            points.add(new DeviceProfileQuery(p.minWidthDps, p.minHeightDps, p.numRows));
        }
        this.numRows = Math.round(invDistWeightedInterpolate(minWidth, minHeight, points));
        points.clear();
        Iterator<DeviceProfile> it2 = profiles.iterator();
        while (it2.hasNext()) {
            DeviceProfile p2 = it2.next();
            points.add(new DeviceProfileQuery(p2.minWidthDps, p2.minHeightDps, p2.numColumns));
        }
        this.numColumns = Math.round(invDistWeightedInterpolate(minWidth, minHeight, points));
        points.clear();
        Iterator<DeviceProfile> it3 = profiles.iterator();
        while (it3.hasNext()) {
            DeviceProfile p3 = it3.next();
            points.add(new DeviceProfileQuery(p3.minWidthDps, p3.minHeightDps, p3.iconSize));
        }
        this.iconSize = invDistWeightedInterpolate(minWidth, minHeight, points);
        this.iconSizePx = DynamicGrid.pxFromDp(this.iconSize, dm);
        points.clear();
        Iterator<DeviceProfile> it4 = profiles.iterator();
        while (it4.hasNext()) {
            DeviceProfile p4 = it4.next();
            points.add(new DeviceProfileQuery(p4.minWidthDps, p4.minHeightDps, p4.iconTextSize));
        }
        this.iconTextSize = invDistWeightedInterpolate(minWidth, minHeight, points);
        this.iconTextSizePx = DynamicGrid.pxFromSp(this.iconTextSize, dm);
        points.clear();
        Iterator<DeviceProfile> it5 = profiles.iterator();
        while (it5.hasNext()) {
            DeviceProfile p5 = it5.next();
            points.add(new DeviceProfileQuery(p5.minWidthDps, p5.minHeightDps, p5.numHotseatIcons));
        }
        this.numHotseatIcons = Math.round(invDistWeightedInterpolate(minWidth, minHeight, points));
        points.clear();
        Iterator<DeviceProfile> it6 = profiles.iterator();
        while (it6.hasNext()) {
            DeviceProfile p6 = it6.next();
            points.add(new DeviceProfileQuery(p6.minWidthDps, p6.minHeightDps, p6.hotseatIconSize));
        }
        this.hotseatIconSize = invDistWeightedInterpolate(minWidth, minHeight, points);
        this.hotseatIconSizePx = DynamicGrid.pxFromDp(this.hotseatIconSize, dm);
        this.hotseatAllAppsRank = (int) (this.numHotseatIcons / 2.0f);
        updateFromConfiguration(resources, wPx, hPx, awPx, ahPx);
        this.searchBarSpaceMaxWidthPx = resources.getDimensionPixelSize(R.dimen.dynamic_grid_search_bar_max_width);
        this.searchBarHeightPx = resources.getDimensionPixelSize(R.dimen.dynamic_grid_search_bar_height);
        this.searchBarSpaceWidthPx = Math.min(this.searchBarSpaceMaxWidthPx, this.widthPx);
        this.searchBarSpaceHeightPx = this.searchBarHeightPx + (this.edgeMarginPx * 2);
        Paint textPaint = new Paint();
        textPaint.setTextSize(this.iconTextSizePx);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        this.cellWidthPx = this.iconSizePx;
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.istextPaint_abroad)) {
            this.cellHeightPx = (this.iconSizePx + ((int) Math.ceil(fontMetrics.bottom - fontMetrics.top))) - LauncherApplication.sApp.getResources().getDimensionPixelSize(R.dimen.istextPaint_abroad);
        } else {
            this.cellHeightPx = this.iconSizePx;
        }
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.hotseat_layout)) {
            this.hotseatBarHeightPx = this.edgeMarginPx * 4;
        } else {
            this.hotseatBarHeightPx = (int) (this.hotseatIconSize + (this.edgeMarginPx * 4));
        }
        this.hotseatCellWidthPx = ((int) this.hotseatIconSize) + this.edgeMarginPx;
        this.hotseatCellHeightPx = (int) this.hotseatIconSize;
        this.folderCellWidthPx = this.cellWidthPx + (this.edgeMarginPx * 3);
        this.folderCellHeightPx = this.cellHeightPx + ((int) (1.5f * this.edgeMarginPx));
        this.folderBackgroundOffset = -this.edgeMarginPx;
        this.folderIconSizePx = this.iconSizePx + ((-this.folderBackgroundOffset) * 2);
        if (!resources.getBoolean(R.bool.hotseat_load_defualt_workspace)) {
            for (int i = 0; i < this.nameArray.length; i++) {
                HashMap<String, Integer> mDefaultIcon = new HashMap<>();
                mDefaultIcon.put(this.nameArray[i], Integer.valueOf(this.drawableArray[i]));
                this.mDefualtIcons.put(Integer.valueOf(i), mDefaultIcon);
            }
        }
    }

    void updateFromConfiguration(Resources resources, int wPx, int hPx, int awPx, int ahPx) {
        this.isLandscape = resources.getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        this.isTablet = resources.getBoolean(R.bool.is_tablet);
        this.isLargeTablet = resources.getBoolean(R.bool.is_large_tablet);
        this.widthPx = wPx;
        this.heightPx = hPx;
        this.availableWidthPx = awPx;
        this.availableHeightPx = ahPx;
        int orientation = resources.getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            this.allAppsNumRows = 7;
            this.allAppsNumCols = 4;
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            this.allAppsNumRows = 4;
            this.allAppsNumCols = 7;
        }
    }

    public void updateIconTextSize(int iSize) {
        this.iconTextSize = iSize;
    }

    
    public float dist(PointF p0, PointF p1) {
        return (float) Math.sqrt(((p1.x - p0.x) * (p1.x - p0.x)) + ((p1.y - p0.y) * (p1.y - p0.y)));
    }

    private float weight(PointF a, PointF b, float pow) {
        float d = dist(a, b);
        if (d == 0.0f) {
            return Float.POSITIVE_INFINITY;
        }
        return (float) (1.0d / Math.pow(d, pow));
    }

    private float invDistWeightedInterpolate(float width, float height, ArrayList<DeviceProfileQuery> points) {
        float sum = 0.0f;
        float weights = 0.0f;
        final PointF xy = new PointF(width, height);
        Collections.sort(points, new Comparator<DeviceProfileQuery>() { 
            @Override
            public int compare(DeviceProfileQuery a, DeviceProfileQuery b) {
                return (int) (DeviceProfile.this.dist(xy, a.dimens) - DeviceProfile.this.dist(xy, b.dimens));
            }
        });
        for (int i = 0; i < points.size(); i++) {
            DeviceProfileQuery p = points.get(i);
            if (i < 3.0f) {
                float w = weight(xy, p.dimens, 5.0f);
                if (w == Float.POSITIVE_INFINITY) {
                    return p.value;
                }
                weights += w;
            }
        }
        for (int i2 = 0; i2 < points.size(); i2++) {
            DeviceProfileQuery p2 = points.get(i2);
            if (i2 < 3.0f) {
                sum += (p2.value * weight(xy, p2.dimens, 5.0f)) / weights;
            }
        }
        return sum;
    }

    Rect getWorkspacePadding(int orientation) {
        Rect padding = new Rect();
        int width = orientation == 0 ? Math.max(this.widthPx, this.heightPx) : Math.min(this.widthPx, this.heightPx);
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.isHotseatHeight)) {
            int hotseatHeightPx = LauncherApplication.sApp.getResources().getDimensionPixelSize(R.dimen.hotseat_btn_height);
            padding.set(LauncherApplication.sApp.getResources().getDimensionPixelSize(R.dimen.workspace_paddingLeft), LauncherApplication.sApp.getResources().getDimensionPixelSize(R.dimen.workspace_paddingTop), LauncherApplication.sApp.getResources().getDimensionPixelSize(R.dimen.workspace_paddingRight), LauncherApplication.sApp.getResources().getDimensionPixelSize(R.dimen.workspace_paddingBottom) + hotseatHeightPx);
        } else {
            padding.set(LauncherApplication.sApp.getResources().getDimensionPixelSize(R.dimen.workspace_paddingLeft), LauncherApplication.sApp.getResources().getDimensionPixelSize(R.dimen.workspace_paddingTop), LauncherApplication.sApp.getResources().getDimensionPixelSize(R.dimen.workspace_paddingRight), LauncherApplication.sApp.getResources().getDimensionPixelSize(R.dimen.workspace_paddingBottom));
        }
        return padding;
    }

    Rect getHotseatRect() {
        return new Rect(0, this.availableHeightPx - this.hotseatBarHeightPx, this.availableWidthPx, Integer.MAX_VALUE);
    }

    int calculateCellWidth(int width, int countX) {
        return width / countX;
    }

    int calculateCellHeight(int height, int countY) {
        return height / countY;
    }

    boolean isPhone() {
        return (this.isTablet || this.isLargeTablet) ? false : true;
    }

    boolean isTablet() {
        return this.isTablet;
    }

    boolean isLargeTablet() {
        return this.isLargeTablet;
    }

    boolean isVerticalBarLayout() {
        return false;
    }

    public void layout(Launcher launcher) {
        View qsbBar = launcher.getQsbBar();
        if (qsbBar != null) {
            ViewGroup.LayoutParams vglp = qsbBar.getLayoutParams();
            vglp.width = -1;
            vglp.height = -1;
            qsbBar.setLayoutParams(vglp);
        }
        View voiceButtonProxy = launcher.findViewById(R.id.voice_button_proxy);
        if (voiceButtonProxy != null) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) voiceButtonProxy.getLayoutParams();
            lp.gravity = 8388661;
            lp.width = ((this.widthPx - this.searchBarSpaceWidthPx) / 2) + (this.iconSizePx * 2);
            lp.height = this.searchBarSpaceHeightPx;
        }
        View workspace = launcher.findViewById(R.id.workspace);
        if (workspace != null) {
            FrameLayout.LayoutParams lp2 = (FrameLayout.LayoutParams) workspace.getLayoutParams();
            lp2.gravity = 17;
            Rect padding = getWorkspacePadding(this.isLandscape ? 0 : 1);
            workspace.setPadding(padding.left, padding.top, padding.right, padding.bottom);
            workspace.setLayoutParams(lp2);
        }
        View pageIndicator = launcher.findViewById(R.id.page_indicator);
        if (pageIndicator != null) {
            FrameLayout.LayoutParams lp3 = (FrameLayout.LayoutParams) pageIndicator.getLayoutParams();
            lp3.gravity = 81;
            lp3.width = -2;
            lp3.height = -2;
            lp3.bottomMargin = this.hotseatBarHeightPx + LauncherApplication.sApp.getResources().getDimensionPixelSize(R.dimen.pageindicator_mariginBottom);
            pageIndicator.setLayoutParams(lp3);
        }
    }
}
