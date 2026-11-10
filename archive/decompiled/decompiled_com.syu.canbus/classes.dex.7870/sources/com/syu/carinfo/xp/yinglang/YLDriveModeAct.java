package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class YLDriveModeAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLDriveModeAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 198:
                    if (((TextView) YLDriveModeAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) YLDriveModeAct.this.findViewById(R.id.tv_text2)).setText(R.string.travel_mode);
                                break;
                            case 1:
                                ((TextView) YLDriveModeAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_sport_mode_Engine_sport);
                                break;
                            case 3:
                                ((TextView) YLDriveModeAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_auto);
                                break;
                        }
                    }
                    break;
                case 203:
                    if (((TextView) YLDriveModeAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) YLDriveModeAct.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) YLDriveModeAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_auto);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_drive_mode_set);
        setUI();
    }

    private void setUI() {
        setClick((Button) findViewById(R.id.btn_minus1));
        setClick((Button) findViewById(R.id.btn_plus1));
        setClick((Button) findViewById(R.id.btn_minus2));
        setClick((Button) findViewById(R.id.btn_plus2));
    }

    private void setClick(View v) {
        if (v != null) {
            v.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427417 */:
                int valAutoVolPre = DataCanbus.DATA[203];
                if (valAutoVolPre == 0) {
                    YLFunc.CAR_COMM_CONTROL(38, 1);
                } else if (valAutoVolPre == 1) {
                    YLFunc.CAR_COMM_CONTROL(38, 0);
                }
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int valAutoVolNext = DataCanbus.DATA[203];
                if (valAutoVolNext == 0) {
                    YLFunc.CAR_COMM_CONTROL(38, 1);
                } else if (valAutoVolNext == 1) {
                    YLFunc.CAR_COMM_CONTROL(38, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int valAirConPre = DataCanbus.DATA[198];
                if (valAirConPre == 0) {
                    YLFunc.CAR_COMM_CONTROL(39, 2);
                } else if (valAirConPre == 1) {
                    YLFunc.CAR_COMM_CONTROL(39, 0);
                } else if (valAirConPre == 3) {
                    YLFunc.CAR_COMM_CONTROL(39, 1);
                }
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int valAirConNext = DataCanbus.DATA[198];
                if (valAirConNext == 0) {
                    YLFunc.CAR_COMM_CONTROL(39, 1);
                } else if (valAirConNext == 1) {
                    YLFunc.CAR_COMM_CONTROL(39, 2);
                } else if (valAirConNext == 3) {
                    YLFunc.CAR_COMM_CONTROL(39, 0);
                }
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
    }
}
