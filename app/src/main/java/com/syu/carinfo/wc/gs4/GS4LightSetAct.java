package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class GS4LightSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 118:
                    GS4LightSetAct.this.updaterWithMeHome();
                    break;
                case 119:
                    GS4LightSetAct.this.updaterWudengHelp();
                    break;
                case 120:
                    GS4LightSetAct.this.updaterDayLight();
                    break;
                case 121:
                    GS4LightSetAct.this.updaterlightAsitly();
                    break;
                case 127:
                    GS4LightSetAct.this.updaterAtmosphereLight();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_289_wc_gs4_light_set);
        setUI();
    }

    private void setUI() {
        ((Button) findViewById(R.id.wc_gs4_with_me_home_lighting_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_with_me_home_lighting_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_light_sensitivity_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_light_sensitivity_next)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_gs4_wudeng_turn_around_help_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_gs4_day_light_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_gs4_atmosphere_light_check)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_with_me_home_lighting_pre /* 2131429057 */:
                int mWithMeHomeInt = DataCanbus.DATA[118];
                if (mWithMeHomeInt == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 2}, null, null);
                    break;
                } else if (mWithMeHomeInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{18}, null, null);
                    break;
                } else if (mWithMeHomeInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 1}, null, null);
                    break;
                }
            case R.id.wc_gs4_with_me_home_lighting_next /* 2131429059 */:
                int mWithMeHomeInt2 = DataCanbus.DATA[118];
                if (mWithMeHomeInt2 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 1}, null, null);
                    break;
                } else if (mWithMeHomeInt2 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 2}, null, null);
                    break;
                } else if (mWithMeHomeInt2 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{18}, null, null);
                    break;
                }
            case R.id.wc_gs4_wudeng_turn_around_help_check /* 2131429060 */:
                int mWuDengHelpInt = DataCanbus.DATA[119];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 19;
                iArr[1] = mWuDengHelpInt == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.wc_gs4_day_light_check /* 2131429061 */:
                int mDayLightInt = DataCanbus.DATA[120];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 20;
                iArr2[1] = mDayLightInt == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.wc_gs4_light_sensitivity_pre /* 2131429062 */:
                int mLightAsistyInt = DataCanbus.DATA[121];
                if (mLightAsistyInt == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{21, 2}, null, null);
                    break;
                } else if (mLightAsistyInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{21}, null, null);
                    break;
                } else if (mLightAsistyInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{21, 1}, null, null);
                    break;
                }
            case R.id.wc_gs4_light_sensitivity_next /* 2131429064 */:
                int mLightAsistyInt2 = DataCanbus.DATA[121];
                if (mLightAsistyInt2 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{21, 1}, null, null);
                    break;
                } else if (mLightAsistyInt2 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{21, 2}, null, null);
                    break;
                } else if (mLightAsistyInt2 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{21}, null, null);
                    break;
                }
            case R.id.wc_gs4_atmosphere_light_check /* 2131429116 */:
                int value = DataCanbus.DATA[127];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 27;
                iArr3[1] = value == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterWithMeHome() {
        int mWithMeHomeInt = DataCanbus.DATA[118];
        if (mWithMeHomeInt == 0) {
            ((TextView) findViewById(R.id.wc_gs4_with_me_home_lighting_TV)).setText(R.string.off);
        } else if (mWithMeHomeInt == 1) {
            ((TextView) findViewById(R.id.wc_gs4_with_me_home_lighting_TV)).setText(R.string.wc_gs4_only_near_light);
        } else if (mWithMeHomeInt == 2) {
            ((TextView) findViewById(R.id.wc_gs4_with_me_home_lighting_TV)).setText(R.string.wc_gs4_near_light_forgost);
        }
    }

    
    public void updaterAtmosphereLight() {
        int value = DataCanbus.DATA[127];
        ((CheckedTextView) findViewById(R.id.wc_gs4_atmosphere_light_check)).setChecked(value != 0);
    }

    
    public void updaterWudengHelp() {
        int mWuDengHelpInt = DataCanbus.DATA[119];
        ((CheckedTextView) findViewById(R.id.wc_gs4_wudeng_turn_around_help_check)).setChecked(mWuDengHelpInt != 0);
    }

    
    public void updaterDayLight() {
        int mDayLightInt = DataCanbus.DATA[120];
        ((CheckedTextView) findViewById(R.id.wc_gs4_day_light_check)).setChecked(mDayLightInt != 0);
    }

    
    public void updaterlightAsitly() {
        int mLightAsistyInt = DataCanbus.DATA[121];
        if (mLightAsistyInt == 0) {
            ((TextView) findViewById(R.id.wc_gs4_light_sensitivity_TV)).setText(R.string.klc_air_low);
        } else if (mLightAsistyInt == 1) {
            ((TextView) findViewById(R.id.wc_gs4_light_sensitivity_TV)).setText(R.string.klc_air_middle);
        } else if (mLightAsistyInt == 2) {
            ((TextView) findViewById(R.id.wc_gs4_light_sensitivity_TV)).setText(R.string.klc_air_high);
        }
    }
}
