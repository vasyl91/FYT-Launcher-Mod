package com.syu.adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.entity.CarInfo;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;
import com.syu.util.ToastInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AdapterCarInfo extends BaseAdapter {
    LayoutInflater inflater;
    Context mContext;
    public SharedPreferences sp;
    List<CarInfo> list = new ArrayList();
    int VehicleIdentifyFlag = 1;

    public AdapterCarInfo(Context context, List<CarInfo> list) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.list.addAll(list);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        return position;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        CarInfo carInfo = this.list.get(position);
        carInfo.getValue();
        if (convertView == null && (holder = new ViewHolder()) != null) {
            switch (carInfo.type) {
                case 0:
                    convertView = this.inflater.inflate(R.layout.layout_item_switch, (ViewGroup) null, false);
                    holder.mCvtSwitch = (CheckedTextView) convertView.findViewById(R.id.ctv_switch);
                    holder.mTextTitle = (TextView) convertView.findViewById(R.id.tv_title);
                    break;
                case 1:
                    convertView = this.inflater.inflate(R.layout.layout_item_btn, (ViewGroup) null, false);
                    holder.mCvtSwitch = (CheckedTextView) convertView.findViewById(R.id.ctv_switch);
                    holder.mTextTitle = (TextView) convertView.findViewById(R.id.tv_title);
                    holder.mTextValue = (TextView) convertView.findViewById(R.id.tv_value);
                    holder.mBtnMinus = (Button) convertView.findViewById(R.id.btn_minus);
                    holder.mBtnPlus = (Button) convertView.findViewById(R.id.btn_plus);
                    break;
                case 2:
                    convertView = this.inflater.inflate(R.layout.layout_item_display_cmd, (ViewGroup) null, false);
                    holder.mCvtSwitch = (CheckedTextView) convertView.findViewById(R.id.ctv_switch);
                    holder.mTextTitle = (TextView) convertView.findViewById(R.id.tv_title);
                    holder.mTextValue = (TextView) convertView.findViewById(R.id.tv_value);
                    break;
                case 3:
                    convertView = this.inflater.inflate(R.layout.layout_item_switch_display, (ViewGroup) null, false);
                    holder.mCvtSwitch = (CheckedTextView) convertView.findViewById(R.id.ctv_switch);
                    holder.mTextTitle = (TextView) convertView.findViewById(R.id.tv_title);
                    holder.mTextValue = (TextView) convertView.findViewById(R.id.tv_value);
                    break;
                case 4:
                case 11:
                    convertView = this.inflater.inflate(R.layout.layout_item_activity, (ViewGroup) null, false);
                    holder.mCvtSwitch = (CheckedTextView) convertView.findViewById(R.id.ctv_switch);
                    holder.mTextTitle = (TextView) convertView.findViewById(R.id.tv_title);
                    break;
                case 5:
                    convertView = this.inflater.inflate(R.layout.layout_item_mode, (ViewGroup) null, false);
                    holder.mTextTitle = (TextView) convertView.findViewById(R.id.tv_title);
                    break;
                case 6:
                    convertView = this.inflater.inflate(R.layout.layout_item_display_cmd, (ViewGroup) null, false);
                    holder.mCvtSwitch = (CheckedTextView) convertView.findViewById(R.id.ctv_switch);
                    holder.mTextTitle = (TextView) convertView.findViewById(R.id.tv_title);
                    break;
                case 7:
                    convertView = this.inflater.inflate(R.layout.layout_item_display_cmd, (ViewGroup) null, false);
                    holder.mTextTitle = (TextView) convertView.findViewById(R.id.tv_title);
                    holder.mTextValue = (TextView) convertView.findViewById(R.id.tv_value);
                    break;
                case 9:
                    convertView = this.inflater.inflate(R.layout.layout_item_display_cmd, (ViewGroup) null, false);
                    holder.mCvtSwitch = (CheckedTextView) convertView.findViewById(R.id.ctv_switch);
                    holder.mTextTitle = (TextView) convertView.findViewById(R.id.tv_title);
                    holder.mTextValue = (TextView) convertView.findViewById(R.id.tv_value);
                    break;
                case 10:
                    convertView = this.inflater.inflate(R.layout.layout_item_btn, (ViewGroup) null, false);
                    holder.mCvtSwitch = (CheckedTextView) convertView.findViewById(R.id.ctv_switch);
                    holder.mTextTitle = (TextView) convertView.findViewById(R.id.tv_title);
                    holder.mTextValue = (TextView) convertView.findViewById(R.id.tv_value);
                    holder.mBtnMinus = (Button) convertView.findViewById(R.id.btn_minus);
                    holder.mBtnPlus = (Button) convertView.findViewById(R.id.btn_plus);
                    this.sp = carInfo.getSharedPreferences();
                    this.VehicleIdentifyFlag = carInfo.getVehicleIdentifyValue();
                    break;
            }
            convertView.setTag(holder);
        }
        ViewHolder holder2 = (ViewHolder) convertView.getTag();
        if (holder2 != null) {
            initListener(convertView, carInfo, holder2);
        }
        return convertView;
    }

    private void initListener(View convertView, final CarInfo carInfo, final ViewHolder holder) {
        final int value = carInfo.getValue();
        if (carInfo.getTitleId() > 0) {
            holder.mTextTitle.setText(this.mContext.getString(carInfo.getTitleId()));
        } else {
            holder.mTextTitle.setText(carInfo.getTitle());
        }
        switch (carInfo.type) {
            case 0:
                if (holder.mCvtSwitch != null) {
                    holder.mCvtSwitch.setChecked(value == 1);
                    holder.mCvtSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.syu.adapter.AdapterCarInfo.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            DataCanbus.PROXY.cmd(carInfo.getCmdType(), carInfo.getCmdCode(), value == 1 ? 0 : 1);
                        }
                    });
                    break;
                }
            case 1:
                String[] display = carInfo.getDiplsys();
                if (display != null && value <= display.length - 1 && holder.mTextValue != null) {
                    holder.mTextValue.setText(display[value]);
                }
                holder.mBtnPlus = (Button) convertView.findViewById(R.id.btn_plus);
                holder.mBtnMinus = (Button) convertView.findViewById(R.id.btn_minus);
                if (holder.mBtnMinus != null && holder.mBtnPlus != null) {
                    holder.mBtnMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.adapter.AdapterCarInfo.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            int value2 = DataCanbus.DATA[carInfo.getUpdateCode()] - 1;
                            if (carInfo.isHasDiableOptionForWC()) {
                                value2 = (DataCanbus.DATA[carInfo.getUpdateCode()] & 255) - 1;
                            }
                            if (value2 < 0) {
                                if (carInfo.isCanCycleChange()) {
                                    value2 = carInfo.getDiplsys().length - 1;
                                } else {
                                    value2 = 0;
                                }
                            }
                            DataCanbus.PROXY.cmd(carInfo.getCmdType(), carInfo.getCmdCode(), value2);
                        }
                    });
                    holder.mBtnPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.adapter.AdapterCarInfo.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            int value2 = DataCanbus.DATA[carInfo.getUpdateCode()] + 1;
                            if (carInfo.isHasDiableOptionForWC()) {
                                value2 = (DataCanbus.DATA[carInfo.getUpdateCode()] & 255) + 1;
                            }
                            if (value2 > carInfo.getDiplsys().length - 1) {
                                if (carInfo.isCanCycleChange()) {
                                    value2 = 0;
                                } else {
                                    value2 = carInfo.getDiplsys().length - 1;
                                }
                            }
                            DataCanbus.PROXY.cmd(carInfo.getCmdType(), carInfo.getCmdCode(), value2);
                        }
                    });
                    break;
                }
            case 2:
                holder.mTextValue.setText(carInfo.getDiplsys()[value]);
                holder.mCvtSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.syu.adapter.AdapterCarInfo.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        int value2 = DataCanbus.DATA[carInfo.getUpdateCode()];
                        if (carInfo.isHasDiableOptionForWC()) {
                            value2 &= 255;
                        }
                        DataCanbus.PROXY.cmd(carInfo.getCmdType(), carInfo.getCmdCode(), value2 == 1 ? 0 : 1);
                    }
                });
                break;
            case 3:
                if (holder.mTextValue != null) {
                    holder.mTextValue.setText(carInfo.getDiplsys()[value]);
                }
                if (holder.mCvtSwitch != null) {
                    holder.mCvtSwitch.setChecked(value == 1);
                    holder.mCvtSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.syu.adapter.AdapterCarInfo.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            int value2 = DataCanbus.DATA[carInfo.getUpdateCode()];
                            if (carInfo.isHasDiableOptionForWC()) {
                                value2 &= 255;
                            }
                            DataCanbus.PROXY.cmd(carInfo.getCmdType(), carInfo.getCmdCode(), value2 == 1 ? 0 : 1);
                        }
                    });
                    break;
                }
            case 4:
                holder.mCvtSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.syu.adapter.AdapterCarInfo.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (carInfo.getCls() == null) {
                            DataCanbus.PROXY.cmd(carInfo.getCmdType(), carInfo.getCmdCode(), 1);
                        } else {
                            AdapterCarInfo.this.mContext.startActivity(new Intent(LauncherApplication.getInstance(), carInfo.getCls()));
                        }
                    }
                });
                break;
            case 6:
                holder.mCvtSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.syu.adapter.AdapterCarInfo.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                    }
                });
                break;
            case 7:
                holder.mTextValue.setText(carInfo.getDiplsys()[value]);
                break;
            case 9:
                holder.mTextValue.setText("");
                holder.mCvtSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.syu.adapter.AdapterCarInfo.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DataCanbus.PROXY.cmd(carInfo.getCmdType(), carInfo.getCmdCode(), 1);
                    }
                });
                break;
            case 10:
                if (holder.mTextValue != null) {
                    holder.mTextValue.setText(carInfo.getDiplsys()[this.VehicleIdentifyFlag]);
                }
                holder.mBtnPlus = (Button) convertView.findViewById(R.id.btn_plus);
                holder.mBtnMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.adapter.AdapterCarInfo.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (AdapterCarInfo.this.VehicleIdentifyFlag == 0) {
                            AdapterCarInfo.this.VehicleIdentifyFlag = 1;
                        } else if (AdapterCarInfo.this.VehicleIdentifyFlag == 1) {
                            AdapterCarInfo.this.VehicleIdentifyFlag = 0;
                        }
                        AdapterCarInfo.this.sp.edit().putInt("vehicleidentify", AdapterCarInfo.this.VehicleIdentifyFlag).commit();
                        holder.mTextValue.setText(carInfo.getDiplsys()[AdapterCarInfo.this.VehicleIdentifyFlag]);
                        DataCanbus.PROXY.cmd(carInfo.getCmdType(), AdapterCarInfo.this.VehicleIdentifyFlag);
                        DataMain.PROXY.cmd(19, 1);
                        ToastInfo.showToast(v.getContext(), carInfo.getDiplsys()[2]);
                    }
                });
                holder.mBtnPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.adapter.AdapterCarInfo.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (AdapterCarInfo.this.VehicleIdentifyFlag == 0) {
                            AdapterCarInfo.this.VehicleIdentifyFlag = 1;
                        } else if (AdapterCarInfo.this.VehicleIdentifyFlag == 1) {
                            AdapterCarInfo.this.VehicleIdentifyFlag = 0;
                        }
                        holder.mTextValue.setText(carInfo.getDiplsys()[AdapterCarInfo.this.VehicleIdentifyFlag]);
                        AdapterCarInfo.this.sp.edit().putInt("vehicleidentify", AdapterCarInfo.this.VehicleIdentifyFlag).commit();
                        DataCanbus.PROXY.cmd(carInfo.getCmdType(), AdapterCarInfo.this.VehicleIdentifyFlag);
                        DataMain.PROXY.cmd(19, 1);
                        ToastInfo.showToast(v.getContext(), carInfo.getDiplsys()[2]);
                    }
                });
                break;
            case 11:
                holder.mCvtSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.syu.adapter.AdapterCarInfo.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        FragmentManager fragmentManager = ((Activity) AdapterCarInfo.this.mContext).getFragmentManager();
                        if (fragmentManager != null && carInfo.getFragment() != null) {
                            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                            beginTransaction.replace(android.R.id.content, carInfo.getFragment());
                            beginTransaction.setTransition(4099);
                            beginTransaction.addToBackStack("FUCTION");
                            beginTransaction.commit();
                        }
                    }
                });
                break;
        }
    }

    class ViewHolder {
        Button mBtnMinus;
        Button mBtnPlus;
        CheckedTextView mCvtSwitch;
        View mLayout;
        TextView mTextTitle;
        TextView mTextValue;

        ViewHolder() {
        }
    }

    public void setValue(int updateCode, int value) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getUpdateCode() == updateCode) {
                this.list.get(i).setValue(value);
                notifyDataSetChanged();
            }
        }
    }

    public void updateList(List<CarInfo> lists) {
        this.list.clear();
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).isShowable()) {
                this.list.add(lists.get(i));
            }
        }
        notifyDataSetChanged();
    }
}
