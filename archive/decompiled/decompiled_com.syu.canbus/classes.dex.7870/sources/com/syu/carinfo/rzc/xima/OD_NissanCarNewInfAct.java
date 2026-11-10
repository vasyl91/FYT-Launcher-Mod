package com.syu.carinfo.rzc.xima;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0080_RZC_XP1_QiJun;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class OD_NissanCarNewInfAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.OD_NissanCarNewInfAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 155:
                    if (((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) OD_NissanCarNewInfAct.this.findViewById(R.id.tv_text11)).setText(Callback_0080_RZC_XP1_QiJun.CarNum);
                    }
                    break;
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_OD_NISSAN_Qijun_L /* 655440 */:
            case FinalCanbus.CAR_OD_NISSAN_Tianlai_L /* 786512 */:
            case FinalCanbus.CAR_OD_NISSAN_Xuanyi_L /* 917584 */:
            case FinalCanbus.CAR_OD_NISSAN_Xima_L /* 1048656 */:
            case FinalCanbus.CAR_OD_NISSAN_Loulan_L /* 1179728 */:
            case FinalCanbus.CAR_OD_NISSAN_Gongjue_L /* 1310800 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail /* 1704016 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke /* 1835088 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_L /* 1966160 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_L /* 2097232 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_L /* 2228304 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_L /* 2359376 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Lanniao_L /* 2490448 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_L /* 2621520 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_L /* 2752592 */:
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.OD_NissanCarNewInfAct.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DataCanbus.PROXY.cmd(1003, new int[]{1}, null, null);
                    }
                });
                break;
            default:
                findViewById(R.id.layout_view5).setVisibility(8);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
    }
}
