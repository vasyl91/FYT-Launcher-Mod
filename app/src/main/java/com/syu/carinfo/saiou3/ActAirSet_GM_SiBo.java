package com.syu.carinfo.saiou3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.xfl.chuangku.XflCkFunc;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActAirSet_GM_SiBo extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.saiou3.ActAirSet_GM_SiBo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    ActAirSet_GM_SiBo.this.updaterAutoModeWild();
                    break;
                case 1:
                    ActAirSet_GM_SiBo.this.updaterAirQuality();
                    break;
                case 2:
                    ActAirSet_GM_SiBo.this.updaterZoonTemp();
                    break;
                case 3:
                    ActAirSet_GM_SiBo.this.updaterRearWindowDefog();
                    break;
                case 4:
                    ActAirSet_GM_SiBo.this.updaterFrontWindowDefog();
                    break;
                case 5:
                    ActAirSet_GM_SiBo.this.mUpdateBackAirState();
                    break;
                case 6:
                    ActAirSet_GM_SiBo.this.updaterAirStartMode();
                    break;
                case 77:
                    ActAirSet_GM_SiBo.this.uRemoteAirPower();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sb_gm_air_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                XflCkFunc.CAR_AIR_CONTROL(22, DataCanbus.DATA[77] != 0 ? 0 : 1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int AutoModeWildState = DataCanbus.DATA[0];
                if (AutoModeWildState == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 2);
                    break;
                } else if (AutoModeWildState == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 0);
                    break;
                } else if (AutoModeWildState == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 1);
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                int AutoModeWildState2 = DataCanbus.DATA[0];
                if (AutoModeWildState2 == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 1);
                    break;
                } else if (AutoModeWildState2 == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 2);
                    break;
                } else if (AutoModeWildState2 == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 0);
                    break;
                }
            case R.id.btn_minus2 /* 2131427484 */:
                int AirQualityState = DataCanbus.DATA[1];
                if (AirQualityState == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 2);
                    break;
                } else if (AirQualityState == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 0);
                    break;
                } else if (AirQualityState == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 1);
                    break;
                }
            case R.id.btn_plus2 /* 2131427486 */:
                int AirQualityState2 = DataCanbus.DATA[1];
                if (AirQualityState2 == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 1);
                    break;
                } else if (AirQualityState2 == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 2);
                    break;
                } else if (AirQualityState2 == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 0);
                    break;
                }
            case R.id.btn_minus3 /* 2131427488 */:
                int ZoonTempState = DataCanbus.DATA[2];
                if (ZoonTempState == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 2);
                    break;
                } else if (ZoonTempState == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 0);
                    break;
                } else if (ZoonTempState == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 1);
                    break;
                }
            case R.id.btn_plus3 /* 2131427490 */:
                int ZoonTempState2 = DataCanbus.DATA[2];
                if (ZoonTempState2 == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 1);
                    break;
                } else if (ZoonTempState2 == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 2);
                    break;
                } else if (ZoonTempState2 == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 0);
                    break;
                }
            case R.id.btn_minus4 /* 2131427492 */:
                int AirStartModeState = DataCanbus.DATA[6];
                if (AirStartModeState == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 2);
                    break;
                } else if (AirStartModeState == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 0);
                    break;
                } else if (AirStartModeState == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 1);
                    break;
                }
            case R.id.btn_plus4 /* 2131427494 */:
                int AirStartModeState2 = DataCanbus.DATA[6];
                if (AirStartModeState2 == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 1);
                    break;
                } else if (AirStartModeState2 == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 2);
                    break;
                } else if (AirStartModeState2 == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 0);
                    break;
                }
            case R.id.btn_minus5 /* 2131427496 */:
                int mBackAir = DataCanbus.DATA[5];
                if (mBackAir == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 2);
                    break;
                } else if (mBackAir == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 0);
                    break;
                } else if (mBackAir == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 1);
                    break;
                }
            case R.id.btn_plus5 /* 2131427498 */:
                int mBackAir2 = DataCanbus.DATA[5];
                if (mBackAir2 == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 2);
                    break;
                } else if (mBackAir2 == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 0);
                    break;
                } else if (mBackAir2 == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 1);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                XflCkFunc.CAR_AIR_CONTROL(5, DataCanbus.DATA[3] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                XflCkFunc.CAR_AIR_CONTROL(6, DataCanbus.DATA[4] != 0 ? 0 : 1);
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

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoModeWild() {
        int AutoModeWildState = DataCanbus.DATA[0];
        if (AutoModeWildState == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
        } else if (AutoModeWildState == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
        } else if (AutoModeWildState == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
        }
    }

    protected void uRemoteAirPower() {
        int mRemoteStartAir = DataCanbus.DATA[77];
        if (((TextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            int[] resId = {R.string.klc_air_auto, R.string.klc_air_last_Set};
            ((TextView) findViewById(R.id.ctv_checkedtext1)).setText(resId[mRemoteStartAir]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAirQuality() {
        int AirQualityState = DataCanbus.DATA[1];
        if (AirQualityState == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_Low_sensitivity);
        } else if (AirQualityState == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xfl_ck_middle_sensitivity);
        } else if (AirQualityState == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_high_sensitivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterZoonTemp() {
        int ZoonTempState = DataCanbus.DATA[2];
        if (ZoonTempState == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
        } else if (ZoonTempState == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
        } else if (ZoonTempState == 2) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_last_Set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRearWindowDefog() {
        int RearWindowAutoState = DataCanbus.DATA[3];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(RearWindowAutoState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFrontWindowDefog() {
        int FrontWindowAutoState = DataCanbus.DATA[4];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(FrontWindowAutoState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAirStartMode() {
        int AirStartModeState = DataCanbus.DATA[6];
        if (AirStartModeState == 0) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (AirStartModeState == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_ON);
        } else if (AirStartModeState == 2) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_last_set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackAirState() {
        int mBackAir = DataCanbus.DATA[5];
        if (mBackAir == 0) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (mBackAir == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_sb_saiou3_str3);
        } else if (mBackAir == 2) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_sb_saiou3_str4);
        }
    }
}
