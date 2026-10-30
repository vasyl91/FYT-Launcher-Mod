package com.syu.carinfo.rzc.xima;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class OD_NissanCarNewInfAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.OD_NissanCarNewInfAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 199:
                    if ((value & 128) != 0) {
                        ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text1)).setText("-" + (256 - value) + "℃");
                    } else {
                        ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "℃");
                    }
                    break;
                case 200:
                    ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km/l");
                    break;
                case 201:
                    ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 202:
                    ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/l");
                    break;
                case 203:
                    ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 204:
                    ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/l");
                    break;
                case 205:
                    ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/l");
                    break;
                case 206:
                    ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 207:
                    if (value == 1) {
                        ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_driving_sport);
                    } else if (value == 2) {
                        ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_driving_normal);
                    } else {
                        ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_driving_eco);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0080_od_nissan_carinfo);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.OD_NissanCarNewInfAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(OD_NissanCarNewInfAct.this, OD_NissanTireAct.class);
                    OD_NissanCarNewInfAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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
        v.getId();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
    }
}
