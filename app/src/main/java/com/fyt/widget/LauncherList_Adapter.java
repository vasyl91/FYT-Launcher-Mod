package com.fyt.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import share.ResValue;

public class LauncherList_Adapter extends BaseAdapter {
    private final Context context;
    private ArrayList<String> list;
    private long sum = 0;
    private int focus_id = 0;

    public LauncherList_Adapter(ArrayList<String> string_AppName, Context context2) {
        this.list = null;
        this.list = string_AppName;
        this.context = context2;
    }

    @Override
    public int getCount() {
        if (this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setfocus(int position) {
        this.focus_id = position;
    }

    public int getfocus() {
        return this.focus_id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        long star = System.nanoTime();
        if (convertView == null) {
            ViewHolder viewHolder = new ViewHolder();
            convertView = View.inflate(this.context, ResValue.getInstance().item_applist, null);
            viewHolder.appbtn_bg = convertView.findViewById(ResValue.getInstance().appbtn_bg);
            viewHolder.AppName = convertView.findViewById(ResValue.getInstance().app_name);
            convertView.setTag(viewHolder);
        }
        ViewHolder viewHolder2 = (ViewHolder) convertView.getTag();
        String myString = this.list.get(position);
        viewHolder2.AppName.setText(myString);
        if (this.focus_id == position) {
            viewHolder2.appbtn_bg.setBackgroundResource(ResValue.getInstance().applist_f);
        } else {
            viewHolder2.appbtn_bg.setBackgroundResource(ResValue.getInstance().applist_n);
        }
        Log.d("adapter", "  ** getView ** position = " + position + " focus_id " + this.focus_id);
        long end = System.nanoTime();
        this.sum += end - star;
        Log.d("main", "app list sum = " + this.sum);
        return convertView;
    }

    class ViewHolder {
        private TextView AppName;
        public ImageView appbtn_bg;

        ViewHolder() {
        }
    }
}
