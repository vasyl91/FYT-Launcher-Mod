package com.syu.carinfo.xbs.gs3;

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
public class GS3LightSetAct extends BaseActivity implements View.OnClickListener {
    CheckedTextView mDayLightCheck;
    Button mLightAsistyBtnNext;
    Button mLightAsistyBtnPre;
    TextView mLightAsistyTV;
    Button mWithMeHomeBtnNext;
    Button mWithMeHomeBtnPre;
    TextView mWithMeHomeTV;
    CheckedTextView mWuDengHelpCheck;
    int mWithMeHomeInt = -1;
    int mLightAsistyInt = -1;
    int mWuDengHelpInt = -1;
    int mDayLightInt = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3LightSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 21:
                    GS3LightSetAct.this.updaterWithMeHome();
                    break;
                case 22:
                    GS3LightSetAct.this.updaterWudengHelp();
                    break;
                case 23:
                    GS3LightSetAct.this.updaterDayLight();
                    break;
                case 24:
                    GS3LightSetAct.this.updaterlightAsitly();
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
        DataCanbus.PROXY.cmd(3, new int[]{10}, null, null);
        this.mWithMeHomeBtnPre = (Button) findViewById(R.id.wc_gs4_with_me_home_lighting_pre);
        this.mWithMeHomeBtnNext = (Button) findViewById(R.id.wc_gs4_with_me_home_lighting_next);
        this.mWithMeHomeTV = (TextView) findViewById(R.id.wc_gs4_with_me_home_lighting_TV);
        this.mLightAsistyBtnPre = (Button) findViewById(R.id.wc_gs4_light_sensitivity_pre);
        this.mLightAsistyBtnNext = (Button) findViewById(R.id.wc_gs4_light_sensitivity_next);
        this.mLightAsistyTV = (TextView) findViewById(R.id.wc_gs4_light_sensitivity_TV);
        this.mWuDengHelpCheck = (CheckedTextView) findViewById(R.id.wc_gs4_wudeng_turn_around_help_check);
        this.mDayLightCheck = (CheckedTextView) findViewById(R.id.wc_gs4_day_light_check);
        setSelfClick(this.mWithMeHomeBtnPre, this);
        setSelfClick(this.mWithMeHomeBtnNext, this);
        setSelfClick(this.mLightAsistyBtnPre, this);
        setSelfClick(this.mLightAsistyBtnNext, this);
        setSelfClick(this.mWuDengHelpCheck, this);
        setSelfClick(this.mDayLightCheck, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_with_me_home_lighting_pre /* 2131429092 */:
                if (this.mWithMeHomeInt == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, 2}, null, null);
                    break;
                } else if (this.mWithMeHomeInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{9}, null, null);
                    break;
                } else if (this.mWithMeHomeInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, 1}, null, null);
                    break;
                }
            case R.id.wc_gs4_with_me_home_lighting_next /* 2131429094 */:
                if (this.mWithMeHomeInt == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, 1}, null, null);
                    break;
                } else if (this.mWithMeHomeInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, 2}, null, null);
                    break;
                } else if (this.mWithMeHomeInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{9}, null, null);
                    break;
                }
            case R.id.wc_gs4_wudeng_turn_around_help_check /* 2131429095 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 13;
                iArr[1] = this.mWuDengHelpInt == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.wc_gs4_day_light_check /* 2131429096 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 15;
                iArr2[1] = this.mDayLightInt == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.wc_gs4_light_sensitivity_pre /* 2131429097 */:
                if (this.mLightAsistyInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 2}, null, null);
                    break;
                } else if (this.mLightAsistyInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 3}, null, null);
                    break;
                } else if (this.mLightAsistyInt == 3) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 1}, null, null);
                    break;
                }
            case R.id.wc_gs4_light_sensitivity_next /* 2131429099 */:
                if (this.mLightAsistyInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 3}, null, null);
                    break;
                } else if (this.mLightAsistyInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 1}, null, null);
                    break;
                } else if (this.mLightAsistyInt == 3) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 2}, null, null);
                    break;
                }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWithMeHome() {
        this.mWithMeHomeInt = DataCanbus.DATA[21];
        if (this.mWithMeHomeTV != null) {
            if (this.mWithMeHomeInt == 0) {
                this.mWithMeHomeTV.setText(R.string.off);
            } else if (this.mWithMeHomeInt == 1) {
                this.mWithMeHomeTV.setText(R.string.wc_gs4_only_near_light);
            } else if (this.mWithMeHomeInt == 2) {
                this.mWithMeHomeTV.setText(R.string.wc_gs4_near_light_forgost);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWudengHelp() {
        this.mWuDengHelpInt = DataCanbus.DATA[22];
        setCheck(this.mWuDengHelpCheck, this.mWuDengHelpInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDayLight() {
        this.mDayLightInt = DataCanbus.DATA[23];
        setCheck(this.mDayLightCheck, this.mDayLightInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightAsitly() {
        this.mLightAsistyInt = DataCanbus.DATA[24];
        if (this.mLightAsistyTV != null) {
            if (this.mLightAsistyInt == 3) {
                this.mLightAsistyTV.setText(R.string.klc_air_low);
            } else if (this.mLightAsistyInt == 2) {
                this.mLightAsistyTV.setText(R.string.klc_air_middle);
            } else if (this.mLightAsistyInt == 1) {
                this.mLightAsistyTV.setText(R.string.klc_air_high);
            }
        }
    }
}
