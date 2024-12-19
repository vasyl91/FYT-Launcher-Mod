package com.syu.carinfo.rongwei;

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
public class Wc_416_RongweiEi6CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rongwei.Wc_416_RongweiEi6CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 151:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    return;
                case 152:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                    return;
                case 153:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                    return;
                case 154:
                    break;
                case 155:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
                    return;
                case 156:
                case 157:
                default:
                    return;
                case 158:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value * 0.1f) + " V");
                    return;
                case 159:
                    switch (value) {
                        case 0:
                            ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("默认模式");
                            break;
                        case 1:
                            ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("怠速充电模式");
                            break;
                        case 2:
                            ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("行车充电模式");
                            break;
                        case 3:
                            ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("纯电充电模式");
                            break;
                        case 4:
                            ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("发动机驱动模式");
                            break;
                        case 5:
                            ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("串联驱动模式");
                            break;
                        case 6:
                            ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("并联驱动模式");
                            break;
                        case 7:
                            ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text1)).setText("能力回收模式");
                            break;
                    }
                case 160:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " rpm");
                    return;
                case 161:
                    if ((32768 & value) != 0) {
                        ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text9)).setText("-" + ((65536 - value) * 0.1f) + " A");
                        return;
                    } else {
                        ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value * 0.1f) + " A");
                        return;
                    }
            }
            ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
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
                    intent.setClass(this, Wc_416_RongweiEi6EnergyStatistics.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, Wc_416_RongweiEi6OilStatistics.class);
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
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
    }
}
