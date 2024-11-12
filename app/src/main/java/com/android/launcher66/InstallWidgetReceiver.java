package com.android.launcher66;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class InstallWidgetReceiver {
    public static final String ACTION_INSTALL_WIDGET = "com.android.launcher66.action.INSTALL_WIDGET";
    public static final String ACTION_SUPPORTS_CLIPDATA_MIMETYPE = "com.android.launcher66.action.SUPPORTS_CLIPDATA_MIMETYPE";
    public static final String EXTRA_APPWIDGET_COMPONENT = "com.android.launcher66.extra.widget.COMPONENT";
    public static final String EXTRA_APPWIDGET_CONFIGURATION_DATA = "com.android.launcher66.extra.widget.CONFIGURATION_DATA";
    public static final String EXTRA_APPWIDGET_CONFIGURATION_DATA_MIME_TYPE = "com.android.launcher66.extra.widget.CONFIGURATION_DATA_MIME_TYPE";

    public static class WidgetMimeTypeHandlerData {
        public ResolveInfo resolveInfo;
        public AppWidgetProviderInfo widgetInfo;

        public WidgetMimeTypeHandlerData(ResolveInfo rInfo, AppWidgetProviderInfo wInfo) {
            this.resolveInfo = rInfo;
            this.widgetInfo = wInfo;
        }
    }

    public static class WidgetListAdapter implements ListAdapter, DialogInterface.OnClickListener {
        private List<WidgetMimeTypeHandlerData> mActivities;
        private ClipData mClipData;
        private LayoutInflater mInflater;
        private Launcher mLauncher;
        private String mMimeType;
        private int[] mTargetLayoutPos;
        private int mTargetLayoutScreen;

        public WidgetListAdapter(Launcher l, String mimeType, ClipData data, List<WidgetMimeTypeHandlerData> list, int targetScreen, int[] targetPos) {
            this.mLauncher = l;
            this.mMimeType = mimeType;
            this.mClipData = data;
            this.mActivities = list;
            this.mTargetLayoutScreen = targetScreen;
            this.mTargetLayoutPos = targetPos;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver observer) {
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver observer) {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mActivities.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            Context context = parent.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(context);
            }
            if (convertView == null) {
                convertView = this.mInflater.inflate(R.layout.external_widget_drop_list_item, parent, false);
            }
            WidgetMimeTypeHandlerData data = this.mActivities.get(position);
            ResolveInfo resolveInfo = data.resolveInfo;
            AppWidgetProviderInfo widgetInfo = data.widgetInfo;
            Drawable d = resolveInfo.loadIcon(packageManager);
            ImageView i = (ImageView) convertView.findViewById(R.id.provider_icon);
            i.setImageDrawable(d);
            CharSequence component = resolveInfo.loadLabel(packageManager);
            int[] widgetSpan = new int[2];
            CellLayout.rectToCell(widgetInfo.minWidth, widgetInfo.minHeight, widgetSpan);
            TextView t = (TextView) convertView.findViewById(R.id.provider);
            t.setText(context.getString(R.string.external_drop_widget_pick_format, component, Integer.valueOf(widgetSpan[0]), Integer.valueOf(widgetSpan[1])));
            return convertView;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return this.mActivities.isEmpty();
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int position) {
            return true;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            AppWidgetProviderInfo widgetInfo = this.mActivities.get(which).widgetInfo;
            PendingAddWidgetInfo createInfo = new PendingAddWidgetInfo(widgetInfo, this.mMimeType, this.mClipData);
            this.mLauncher.addAppWidgetFromDrop(createInfo, -100L, this.mTargetLayoutScreen, null, null, this.mTargetLayoutPos);
        }
    }
}
