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

@SuppressWarnings({"deprecation", "unchecked"})
public class GS3EnergyFlowAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    TextView mBatteryShow;
    Button mEnergySetBtn;
    TextView mEnergyShow;
    int EnergyShowInt = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_165_xbs_gs3_energy);
        setUI();
    }

    private void setUI() {
        this.mEnergySetBtn = (Button) findViewById(R.id.energy_set_btn);
        this.mEnergyShow = (TextView) findViewById(R.id.energy_show_view);
        this.mBatteryShow = (TextView) findViewById(R.id.battery_show_view);
        this.mEnergySetBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.energy_set_btn /* 2131428732 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) GS3EnergySetAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{12}, null, null);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterEnergyShow() {
        this.EnergyShowInt = DataCanbus.DATA[127];
        switch (this.EnergyShowInt) {
            case 0:
                this.mEnergyShow.setBackgroundResource(R.drawable.ge3_energy_n);
                break;
            case 1:
                this.mEnergyShow.setBackgroundResource(R.drawable.ge3_energy_p);
                break;
        }
    }

    
    public void updaterbattery() {
        int val = DataCanbus.DATA[126];
        switch (val) {
            case 0:
                this.mBatteryShow.setBackgroundResource(R.drawable.ge3_electricity_0);
                break;
            case 1:
                this.mBatteryShow.setBackgroundResource(R.drawable.ge3_electricity_1);
                break;
            case 2:
                this.mBatteryShow.setBackgroundResource(R.drawable.ge3_electricity_2);
                break;
            case 3:
                this.mBatteryShow.setBackgroundResource(R.drawable.ge3_electricity_3);
                break;
            case 4:
                this.mBatteryShow.setBackgroundResource(R.drawable.ge3_electricity_4);
                break;
            case 5:
                this.mBatteryShow.setBackgroundResource(R.drawable.ge3_electricity_5);
                break;
            case 6:
                this.mBatteryShow.setBackgroundResource(R.drawable.ge3_electricity_6);
                break;
            case 7:
                this.mBatteryShow.setBackgroundResource(R.drawable.ge3_electricity_7);
                break;
            case 8:
                this.mBatteryShow.setBackgroundResource(R.drawable.ge3_electricity_8);
                break;
            case 9:
                this.mBatteryShow.setBackgroundResource(R.drawable.ge3_electricity_9);
                break;
            case 10:
                this.mBatteryShow.setBackgroundResource(R.drawable.ge3_electricity_10);
                break;
        }
    }
}
