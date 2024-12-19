package com.syu.carinfo.rzc.mingjueruiteng;

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
public class ActRongweiEi6CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActRongweiEi6CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 111:
                    switch (value) {
                        case 0:
                            ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("默认模式");
                            break;
                        case 1:
                            ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("怠速充电模式");
                            break;
                        case 2:
                            ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("行车充电模式");
                            break;
                        case 3:
                            ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("纯电充电模式");
                            break;
                        case 4:
                            ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("发动机驱动模式");
                            break;
                        case 5:
                            ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("串联驱动模式");
                            break;
                        case 6:
                            ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("并联驱动模式");
                            break;
                        case 7:
                            ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("能力回收模式");
                            break;
                    }
                case 112:
                    break;
                case 113:
                    ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                    return;
                case 114:
                    ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
                    return;
                case 115:
                    ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                    return;
                case 116:
                    ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    return;
                case 117:
                    ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " rpm");
                    return;
                case 118:
                    ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " V");
                    return;
                case 119:
                    if ((32768 & value) != 0) {
                        ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text9)).setText("-" + (65536 - value) + " A");
                        return;
                    }
                    ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + " A");
                    return;
                default:
                    return;
            }
            ((TextView) ActRongweiEi6CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0273_rzc_rongwei_ei6_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
                    intent.setClass(this, ActivityRongweiEi6EnergyStatistics.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, ActivityRongweiEi6OilStatistics.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
    }
}
