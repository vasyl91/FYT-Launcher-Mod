package com.syu.carinfo.xbs.gs3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GS3EnergyFlowAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3EnergyFlowAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 126:
                    GS3EnergyFlowAct.this.updaterbattery();
                    break;
                case 127:
                    GS3EnergyFlowAct.this.updaterEnergyShow();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_165_xbs_gs3_energy);
        setUI();
    }

    private void setUI() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_plus1 /* 2131427458 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) GS3EnergySetAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{12}, null, null);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEnergyShow() {
        int EnergyShowInt = DataCanbus.DATA[127];
        switch (EnergyShowInt) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setBackgroundResource(R.drawable.ge3_energy_n);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setBackgroundResource(R.drawable.ge3_energy_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterbattery() {
        int val = DataCanbus.DATA[126];
        switch (val) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ge3_electricity_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ge3_electricity_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ge3_electricity_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ge3_electricity_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ge3_electricity_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ge3_electricity_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ge3_electricity_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ge3_electricity_7);
                break;
            case 8:
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ge3_electricity_8);
                break;
            case 9:
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ge3_electricity_9);
                break;
            case 10:
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ge3_electricity_10);
                break;
        }
    }
}
