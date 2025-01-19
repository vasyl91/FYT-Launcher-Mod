package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LuZBMW15MiniBaoYCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            String str;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 152:
                    LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view1).setVisibility(8);
                    LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view2).setVisibility(8);
                    LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view3).setVisibility(8);
                    LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view4).setVisibility(8);
                    LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view5).setVisibility(8);
                    LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view6).setVisibility(8);
                    LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view7).setVisibility(8);
                    LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view8).setVisibility(8);
                    ((TextView) LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.tv_text1)).setText(R.string.maintenance_information);
                    switch (value) {
                        case 0:
                            ((TextView) LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.tv_text1)).setText("无保养信息记录");
                            break;
                        case 1:
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                            break;
                        case 2:
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                            break;
                        case 3:
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                            break;
                        case 4:
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view4).setVisibility(0);
                            break;
                        case 5:
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view4).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view5).setVisibility(0);
                            break;
                        case 6:
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view4).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view5).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view6).setVisibility(0);
                            break;
                        case 7:
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view4).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view5).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view6).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view7).setVisibility(0);
                            break;
                        case 8:
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view4).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view5).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view6).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view7).setVisibility(0);
                            LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.layout_view8).setVisibility(0);
                            break;
                    }
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case 161:
                case 162:
                    int data1 = DataCanbus.DATA[153];
                    int data2 = DataCanbus.DATA[154];
                    int data3 = DataCanbus.DATA[155];
                    int data4 = DataCanbus.DATA[156];
                    int data5 = DataCanbus.DATA[157];
                    int data6 = DataCanbus.DATA[158];
                    int data7 = DataCanbus.DATA[159];
                    int data8 = DataCanbus.DATA[160];
                    int data9 = DataCanbus.DATA[161];
                    int data10 = DataCanbus.DATA[162];
                    String str2 = String.valueOf(String.valueOf("") + LuZBMW15MiniBaoYCarInfo.this.UpdateData2(data2)) + LuZBMW15MiniBaoYCarInfo.this.UpdateData3(data3);
                    if (data4 == 1) {
                        str2 = String.valueOf(String.valueOf(str2) + "_20" + (data7 / 10) + (data7 % 10)) + "_" + (data8 / 10) + (data8 % 10);
                    }
                    if (data5 == 1) {
                        if (data9 == 1) {
                            str = String.valueOf(str2) + "_超过" + data10;
                        } else {
                            str = String.valueOf(str2) + "_还剩" + data10;
                        }
                        if (data6 == 1) {
                            str2 = String.valueOf(str) + "miles";
                        } else {
                            str2 = String.valueOf(str) + "km";
                        }
                    }
                    switch (data1) {
                        case 1:
                            ((TextView) LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.tv_text3)).setText(str2);
                            break;
                        case 2:
                            ((TextView) LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.tv_text5)).setText(str2);
                            break;
                        case 3:
                            ((TextView) LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.tv_text7)).setText(str2);
                            break;
                        case 4:
                            ((TextView) LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.tv_text9)).setText(str2);
                            break;
                        case 5:
                            ((TextView) LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.tv_text11)).setText(str2);
                            break;
                        case 6:
                            ((TextView) LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.tv_text13)).setText(str2);
                            break;
                        case 7:
                            ((TextView) LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.tv_text15)).setText(str2);
                            break;
                        case 8:
                            ((TextView) LuZBMW15MiniBaoYCarInfo.this.findViewById(R.id.tv_text17)).setText(str2);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_luz_bmw_15mini_baoy_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{75}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
        v.getId();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
    }

    
    public String UpdateData2(int value) {
        switch (value) {
            case 1:
                return "机油";
            case 2:
                return "车辆检查";
            case 3:
                return "制动液";
            case 4:
                return "法定尾气检查";
            case 5:
                return "法定车辆检查";
            case 130:
                return "前部制动摩擦片";
            case 134:
                return "后部制动摩擦片";
            case 137:
                return "变速器油";
            case 149:
                return "磨合检查";
            default:
                return "";
        }
    }

    
    public String UpdateData3(int value) {
        switch (value) {
            case 0:
                return "_OK";
            case 1:
                return "_维修";
            case 2:
                return "_保养";
            default:
                return "未知";
        }
    }
}
