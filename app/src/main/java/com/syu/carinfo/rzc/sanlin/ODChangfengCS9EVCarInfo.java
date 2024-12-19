package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ODChangfengCS9EVCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODChangfengCS9EVCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 23:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "/10");
                    break;
                case 24:
                    switch (value) {
                        case 0:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text2)).setText("停车状态");
                            break;
                        case 1:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text2)).setText("驱动状态");
                            break;
                        case 2:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text2)).setText("能量回收状态");
                            break;
                    }
                case 25:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                    break;
                case 26:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kmh/100km");
                    break;
                case 27:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kmh/100km");
                    break;
                case 28:
                    switch (value) {
                        case 0:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text6)).setText("行车状态");
                            break;
                        case 1:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text6)).setText("充电状态");
                            break;
                        case 2:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text6)).setText("快充状态");
                            break;
                        case 3:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text6)).setText("慢充状态");
                            break;
                        case 4:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text6)).setText("充电完成");
                            break;
                    }
                case 29:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "%");
                    break;
                case 30:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " A");
                    break;
                case 31:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 32:
                    if (value == 255) {
                        ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text10)).setText("----");
                        break;
                    } else {
                        ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value - 40) + " ℃");
                        break;
                    }
                case 33:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 34:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_changfengcs9_ev_carinfo);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
    }
}
