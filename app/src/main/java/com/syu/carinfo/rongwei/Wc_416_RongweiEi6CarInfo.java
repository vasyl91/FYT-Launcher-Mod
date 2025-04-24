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

@SuppressWarnings({"deprecation", "unchecked"})
public class Wc_416_RongweiEi6CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 163:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    return;
                case 164:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                    return;
                case 165:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                    return;
                case 166:
                    break;
                case 167:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
                    return;
                case 168:
                case 169:
                default:
                    return;
                case 170:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value * 0.1f) + " V");
                    return;
                case 171:
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
                case 172:
                    ((TextView) Wc_416_RongweiEi6CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " rpm");
                    return;
                case 173:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0273_rzc_rongwei_ei6_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
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
                    intent.setClass(this, Wc_416_RongweiEi6EnergyStatistics.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
    }
}
