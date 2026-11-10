package com.syu.carinfo.jili;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODJiliXingyuanCarEVInfAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODJiliXingyuanCarEVInfAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 309:
                    int hour = (value >> 8) & 255;
                    int min = value & 255;
                    ((TextView) ODJiliXingyuanCarEVInfAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(hour) + "小时" + min + "分钟");
                    break;
                case 310:
                    ((TextView) ODJiliXingyuanCarEVInfAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 311:
                    ((TextView) ODJiliXingyuanCarEVInfAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "km/h");
                    break;
                case 312:
                    int hour2 = (value >> 8) & 255;
                    int min2 = value & 255;
                    ((TextView) ODJiliXingyuanCarEVInfAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(hour2) + "小时" + min2 + "分钟");
                    break;
                case 313:
                    ((TextView) ODJiliXingyuanCarEVInfAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 314:
                    ((TextView) ODJiliXingyuanCarEVInfAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "km/h");
                    break;
                case 315:
                    ((TextView) ODJiliXingyuanCarEVInfAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + "KWh/100km");
                    break;
                case 316:
                    ((TextView) ODJiliXingyuanCarEVInfAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "%");
                    break;
                case 317:
                    ((TextView) ODJiliXingyuanCarEVInfAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "%");
                    break;
                case 318:
                    ((TextView) ODJiliXingyuanCarEVInfAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + "%");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_jili_xingyuan_ev_info);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(13, 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(14, 1);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(6, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{97, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[309].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[310].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[311].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[312].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[313].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[314].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[315].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[316].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[317].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[318].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[319].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[309].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[310].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[311].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[312].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[313].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[314].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[315].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[316].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[317].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[318].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[319].removeNotify(this.mNotifyCanbus);
    }
}
