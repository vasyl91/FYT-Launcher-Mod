package com.android.launcher66;

import android.app.WallpaperInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.android.launcher66.WallpaperPickerActivity;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class LiveWallpaperListAdapter extends BaseAdapter implements ListAdapter {
    private static final String LOG_TAG = "LiveWallpaperListAdapter";
    private final LayoutInflater mInflater;
    private final PackageManager mPackageManager;
    private final List<LiveWallpaperTile> mWallpapers;

    public LiveWallpaperListAdapter(Context context) {
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mPackageManager = context.getPackageManager();
        List<ResolveInfo> list = this.mPackageManager.queryIntentServices(new Intent("android.service.wallpaper.WallpaperService"), 128);
        this.mWallpapers = new ArrayList<>();
        new LiveWallpaperEnumerator(context).execute(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mWallpapers == null) {
            return 0;
        }
        return this.mWallpapers.size();
    }

    @Override // android.widget.Adapter
    public LiveWallpaperTile getItem(int position) {
        return this.mWallpapers.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = this.mInflater.inflate(R.layout.wallpaper_picker_live_wallpaper_item, parent, false);
        } else {
            view = convertView;
        }
        WallpaperPickerActivity.setWallpaperItemPaddingToZero((FrameLayout) view);
        LiveWallpaperTile wallpaperInfo = this.mWallpapers.get(position);
        wallpaperInfo.setView(view);
        ImageView image = view.findViewById(R.id.wallpaper_image);
        ImageView icon = view.findViewById(R.id.wallpaper_icon);
        if (wallpaperInfo.mThumbnail != null) {
            image.setImageDrawable(wallpaperInfo.mThumbnail);
            icon.setVisibility(View.GONE);
        } else {
            icon.setImageDrawable(wallpaperInfo.mInfo.loadIcon(this.mPackageManager));
            icon.setVisibility(View.VISIBLE);
        }
        TextView label = view.findViewById(R.id.wallpaper_item_label);
        label.setText(wallpaperInfo.mInfo.loadLabel(this.mPackageManager));
        return view;
    }

    public static class LiveWallpaperTile extends WallpaperPickerActivity.WallpaperTileInfo {
        private final WallpaperInfo mInfo;
        private final Drawable mThumbnail;

        public LiveWallpaperTile(Drawable thumbnail, WallpaperInfo info, Intent intent) {
            this.mThumbnail = thumbnail;
            this.mInfo = info;
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public void onClick(WallpaperPickerActivity a) {
            Intent preview = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
            preview.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", this.mInfo.getComponent());
            a.onLiveWallpaperPickerLaunch();
            Utilities.startActivityForResultSafely(a, preview, 7);
        }
    }

    private class LiveWallpaperEnumerator extends AsyncTask<List<ResolveInfo>, LiveWallpaperTile, Void> {
        private final Context mContext;
        private int mWallpaperPosition = 0;

        public LiveWallpaperEnumerator(Context context) {
            this.mContext = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(List<ResolveInfo>... listArr) {
            final PackageManager packageManager = this.mContext.getPackageManager();
            List<ResolveInfo> list = listArr[0];
            Collections.sort(list, new Comparator<ResolveInfo>() { // from class: com.android.launcher66.LiveWallpaperListAdapter.LiveWallpaperEnumerator.1
                final Collator mCollator = Collator.getInstance();

                @Override // java.util.Comparator
                public int compare(ResolveInfo info1, ResolveInfo info2) {
                    return this.mCollator.compare(info1.loadLabel(packageManager), info2.loadLabel(packageManager));
                }
            });
            for (ResolveInfo resolveInfo : list) {
                try {
                    WallpaperInfo info = new WallpaperInfo(this.mContext, resolveInfo);
                    Drawable thumb = info.loadThumbnail(packageManager);
                    Intent launchIntent = new Intent("android.service.wallpaper.WallpaperService");
                    launchIntent.setClassName(info.getPackageName(), info.getServiceName());
                    LiveWallpaperTile wallpaper = new LiveWallpaperTile(thumb, info, launchIntent);
                    publishProgress(wallpaper);
                } catch (IOException | XmlPullParserException e) {
                    Log.w(LiveWallpaperListAdapter.LOG_TAG, "Skipping wallpaper " + resolveInfo.serviceInfo, e);
                }
            }
            publishProgress((LiveWallpaperTile) null);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(LiveWallpaperTile... infos) {
            for (LiveWallpaperTile info : infos) {
                if (info != null) {
                    info.mThumbnail.setDither(true);
                    if (this.mWallpaperPosition < LiveWallpaperListAdapter.this.mWallpapers.size()) {
                        LiveWallpaperListAdapter.this.mWallpapers.set(this.mWallpaperPosition, info);
                    } else {
                        LiveWallpaperListAdapter.this.mWallpapers.add(info);
                    }
                    this.mWallpaperPosition++;
                } else {
                    LiveWallpaperListAdapter.this.notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
