package com.syu.carinfo.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FordCarInfo2 extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.FordCarInfo2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 74:
                    ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
                    break;
                case 75:
                    if (value > 999) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text2)).setText("-- km");
                        break;
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 76:
                    int value2 = (value * 2) + 1;
                    if (value2 > 300) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text1)).setText("---- L/100km");
                        break;
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " L/100km");
                        break;
                    }
                case 77:
                    int temp = value / 2;
                    if (temp > 100) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text3)).setText("-- L");
                        break;
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text3)).setText(String.format("%d L", Integer.valueOf(temp)));
                        break;
                    }
                case 176:
                    if (value == 255) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text8)).setText("-- km/h");
                        break;
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " km/h");
                        break;
                    }
                case 177:
                    ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 2) + " km");
                    break;
                case 178:
                    if (value > 100) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text6)).setText("-- ");
                        break;
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 179:
                    ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text7)).setText(String.valueOf((((value * 470) / 755) + 30) / 10.0f) + " V");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0334_rzc_ford_carinfo2);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{66}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{105}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
    }
}
