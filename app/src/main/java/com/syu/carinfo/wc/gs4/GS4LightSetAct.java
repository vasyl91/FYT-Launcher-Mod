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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS4LightSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4LightSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 20:
                    GS4LightSetAct.this.updaterWithMeHome();
                    break;
                case 21:
                    GS4LightSetAct.this.updaterWudengHelp();
                    break;
                case 22:
                    GS4LightSetAct.this.updaterDayLight();
                    break;
                case 23:
                    GS4LightSetAct.this.updaterlightAsitly();
                    break;
                case 54:
                    GS4LightSetAct.this.updaterAtmosphereLight();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_289_wc_gs4_light_set);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_with_me_home_lighting_pre /* 2131429092 */:
                int mWithMeHomeInt = DataCanbus.DATA[20];
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
            case R.id.wc_gs4_with_me_home_lighting_next /* 2131429094 */:
                int mWithMeHomeInt2 = DataCanbus.DATA[20];
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
            case R.id.wc_gs4_wudeng_turn_around_help_check /* 2131429095 */:
                int mWuDengHelpInt = DataCanbus.DATA[21];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 19;
                iArr[1] = mWuDengHelpInt == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.wc_gs4_day_light_check /* 2131429096 */:
                int mDayLightInt = DataCanbus.DATA[22];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 20;
                iArr2[1] = mDayLightInt == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.wc_gs4_light_sensitivity_pre /* 2131429097 */:
                int mLightAsistyInt = DataCanbus.DATA[23];
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
            case R.id.wc_gs4_light_sensitivity_next /* 2131429099 */:
                int mLightAsistyInt2 = DataCanbus.DATA[23];
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
            case R.id.wc_gs4_atmosphere_light_check /* 2131429156 */:
                int value = DataCanbus.DATA[54];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 27;
                iArr3[1] = value == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWithMeHome() {
        int mWithMeHomeInt = DataCanbus.DATA[20];
        if (mWithMeHomeInt == 0) {
            ((TextView) findViewById(R.id.wc_gs4_with_me_home_lighting_TV)).setText(R.string.off);
        } else if (mWithMeHomeInt == 1) {
            ((TextView) findViewById(R.id.wc_gs4_with_me_home_lighting_TV)).setText(R.string.wc_gs4_only_near_light);
        } else if (mWithMeHomeInt == 2) {
            ((TextView) findViewById(R.id.wc_gs4_with_me_home_lighting_TV)).setText(R.string.wc_gs4_near_light_forgost);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAtmosphereLight() {
        int value = DataCanbus.DATA[54];
        ((CheckedTextView) findViewById(R.id.wc_gs4_atmosphere_light_check)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWudengHelp() {
        int mWuDengHelpInt = DataCanbus.DATA[21];
        ((CheckedTextView) findViewById(R.id.wc_gs4_wudeng_turn_around_help_check)).setChecked(mWuDengHelpInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDayLight() {
        int mDayLightInt = DataCanbus.DATA[22];
        ((CheckedTextView) findViewById(R.id.wc_gs4_day_light_check)).setChecked(mDayLightInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightAsitly() {
        int mLightAsistyInt = DataCanbus.DATA[23];
        if (mLightAsistyInt == 0) {
            ((TextView) findViewById(R.id.wc_gs4_light_sensitivity_TV)).setText(R.string.klc_air_low);
        } else if (mLightAsistyInt == 1) {
            ((TextView) findViewById(R.id.wc_gs4_light_sensitivity_TV)).setText(R.string.klc_air_middle);
        } else if (mLightAsistyInt == 2) {
            ((TextView) findViewById(R.id.wc_gs4_light_sensitivity_TV)).setText(R.string.klc_air_high);
        }
    }
}
