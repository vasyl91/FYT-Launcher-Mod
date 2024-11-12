package com.android.launcher66;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class AddAdapter extends BaseAdapter {
    public static final int ITEM_APPLICATION = 2;
    public static final int ITEM_APPWIDGET = 1;
    public static final int ITEM_SHORTCUT = 0;
    public static final int ITEM_WALLPAPER = 3;
    private final LayoutInflater mInflater;
    private final ArrayList<ListItem> mItems = new ArrayList<>();

    public class ListItem {
        public final int actionTag;
        public final Drawable image;
        public final CharSequence text;

        public ListItem(Resources res, int textResourceId, int imageResourceId, int actionTag) {
            this.text = res.getString(textResourceId);
            if (imageResourceId != -1) {
                this.image = res.getDrawable(imageResourceId);
            } else {
                this.image = null;
            }
            this.actionTag = actionTag;
        }
    }

    public AddAdapter(Launcher launcher) {
        this.mInflater = (LayoutInflater) launcher.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resources res = launcher.getResources();
        this.mItems.add(new ListItem(res, R.string.group_wallpapers, R.mipmap.ic_launcher_wallpaper, 3));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItem item = (ListItem) getItem(position);
        if (convertView == null) {
            convertView = this.mInflater.inflate(R.layout.add_list_item, parent, false);
        }
        TextView textView = (TextView) convertView;
        textView.setTag(item);
        textView.setText(item.text);
        textView.setCompoundDrawablesWithIntrinsicBounds(item.image, (Drawable) null, (Drawable) null, (Drawable) null);
        return convertView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mItems.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.mItems.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }
}
