package com.android.launcher66;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class AddAdapter extends BaseAdapter {
    public static final int ITEM_APPLICATION = 2;
    public static final int ITEM_APPWIDGET = 1;
    public static final int ITEM_SHORTCUT = 0;
    public static final int ITEM_WALLPAPER = 3;
    private final LayoutInflater mInflater;
    private final ArrayList<ListItem> mItems = new ArrayList<>();
    private Context mContext;

    public class ListItem {
        public final int actionTag;
        public final Drawable image;
        public final CharSequence text;

        public ListItem(Resources res, int textResourceId, int imageResourceId, int actionTag) {
            this.text = res.getString(textResourceId);
            if (imageResourceId != -1) {
                this.image = ContextCompat.getDrawable(mContext, imageResourceId);
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
        mContext = convertView.getContext();
        ListItem item = (ListItem) getItem(position);
        if (convertView == null) {
            convertView = this.mInflater.inflate(R.layout.add_list_item, parent, false);
        }
        TextView textView = (TextView) convertView;
        textView.setTag(item);
        textView.setText(item.text);
        textView.setCompoundDrawablesWithIntrinsicBounds(item.image, null, null, null);
        return convertView;
    }

    @Override
    public int getCount() {
        return this.mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
