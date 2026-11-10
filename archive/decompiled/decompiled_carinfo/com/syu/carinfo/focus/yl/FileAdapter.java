package com.syu.carinfo.focus.yl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.R;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class FileAdapter extends BaseAdapter {
    ArrayList<ListInfo> list;
    Context mContext;

    public FileAdapter(Context context, ArrayList<ListInfo> list) {
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
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.layout_yl_focus_cd_item, (ViewGroup) null);
            holder.mTextView = (TextView) convertView.findViewById(R.id.item_text);
            holder.mImageView = (ImageView) convertView.findViewById(R.id.item_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ListInfo info = this.list.get(position);
        if (info.getType() == 0) {
            holder.mImageView.setBackgroundResource(R.drawable.item_folder);
        } else {
            holder.mImageView.setBackgroundResource(R.drawable.item_audio);
        }
        holder.mTextView.setText(String.valueOf(position + 1) + ". " + info.getName());
        return convertView;
    }

    class ViewHolder {
        ImageView mImageView;
        TextView mTextView;

        ViewHolder() {
        }
    }

    public void addList(int index, ListInfo info) {
        if (index == 0) {
            this.list.clear();
        }
        this.list.add(info);
        notifyDataSetChanged();
    }
}
