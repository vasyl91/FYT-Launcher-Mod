package com.syu.carinfo.rzc.ziyouguang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.syu.canbus.R;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class FileAdapter extends BaseAdapter {
    ArrayList<CDInfo> list;
    Context mContext;

    public FileAdapter(Context context, ArrayList<CDInfo> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public int getCount() {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.layout_371_bagoo_ziyouguang_cd_item, (ViewGroup) null);
            holder.mTextView = (TextView) convertView.findViewById(R.id.item_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CDInfo info = this.list.get(position);
        holder.mTextView.setText(String.valueOf(position + 1) + ". " + info.getStr());
        return convertView;
    }

    class ViewHolder {
        TextView mTextView;

        ViewHolder() {
        }
    }

    public void addList(int index, CDInfo info) {
        if (index == 0) {
            this.list.clear();
        }
        this.list.add(info);
        notifyDataSetChanged();
    }
}
