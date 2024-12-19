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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LuZBMW15MiniCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LuZBMW15MiniCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 9:
                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "L");
                    break;
                case 10:
                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                    break;
                case 11:
                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "km");
                    break;
                case 20:
                case 36:
                    int unit = DataCanbus.DATA[20];
                    int data = DataCanbus.DATA[36];
                    switch (unit) {
                        case 0:
                            ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(data / 10) + "." + (data % 10) + "L/100km");
                            break;
                        case 1:
                            ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(data / 10) + "." + (data % 10) + "Km/L");
                            break;
                    }
                case 35:
                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "km");
                    break;
                case 37:
                    ((TextView) LuZBMW15MiniCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/h");
                    break;
                case 57:
                case 58:
                case 60:
                    int sys = DataCanbus.DATA[57];
                    int state = DataCanbus.DATA[58];
                    int data2 = DataCanbus.DATA[60];
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
                case 59:
                    LuZBMW15MiniCarInfo.this.findViewById(R.id.layout_view1).setVisibility(value == 1 ? 0 : 8);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_luz_bmw_15mini_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LuzBMW15MiniTireAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                dialog(R.string.str_engine_oil_measurement, 161, 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, LuZBMW15MiniBaoYCarInfo.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                dialog(R.string.bsd_klj_str15, 145, 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                dialog(R.string.trip_info, 129, 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                dialog(R.string.average_speed, 129, 2);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd, final int value) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LuZBMW15MiniCarInfo.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                final int i2 = value;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.LuZBMW15MiniCarInfo.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, i2}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LuZBMW15MiniCarInfo.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
    }
}
