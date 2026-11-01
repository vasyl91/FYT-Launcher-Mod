package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.carinfo.wc2.tata.LZBMW15MiniAirSetAct;
import com.syu.carinfo.wc2.tata.LZBMWMiniFenweiLightAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LuZBMW15MiniCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "L");
                    break;
                case 101:
                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                    break;
                case 102:
                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "km");
                    break;
                case 111:
                case 127:
                    int unit = DataCanbus.DATA[111];
                    int data = DataCanbus.DATA[127];
                    switch (unit) {
                        case 0:
                            ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(data / 10) + "." + (data % 10) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                            break;
                        case 1:
                            ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(data / 10) + "." + (data % 10) + "Km/L");
                            break;
                    }
                case 126:
                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "km");
                    break;
                case 128:
                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/h");
                    break;
                case 148:
                case 149:
                case 151:
                    int sys = DataCanbus.DATA[148];
                    int state = DataCanbus.DATA[149];
                    int data2 = DataCanbus.DATA[151];
                    if (sys == 0) {
                        ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                        break;
                    } else {
                        switch (state) {
                            case 0:
                                ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                                break;
                            case 1:
                                if (data2 >= 7) {
                                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text7)).setText(R.string.str_effluence);
                                    break;
                                } else if (data2 == 0) {
                                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text7)).setText(R.string.crv_source_null);
                                    break;
                                } else {
                                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(data2 * 16) + "%");
                                    break;
                                }
                            case 4:
                                ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text7)).setText("measuring");
                                break;
                        }
                    }
                    break;
                case 150:
                    LuZBMW15MiniCarInfo.this.findViewById(R.id.layout_view1).setVisibility(value == 1 ? 0 : 8);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_luz_bmw_15mini_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{18}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{64}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{72}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{74}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LuzBMW15MiniTireAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog(R.string.str_engine_oil_measurement, 161, 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, LuZBMW15MiniBaoYCarInfo.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                dialog(R.string.bsd_klj_str15, 145, 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                dialog(R.string.trip_info, 129, 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                dialog(R.string.average_speed, 129, 2);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, LZBMWMiniFenweiLightAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                try {
                    Intent intent4 = new Intent();
                    intent4.setClass(this, LZBMW15MiniAirSetAct.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
        }
    }

    protected void dialog(int stringId, final int cmd, final int value) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                final int i2 = value;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, i2}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
    }
}
