package com.syu.carinfo.rzc.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcKlcAirAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RzcKlcAirAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 0:
                    RzcKlcAirAct.this.updaterAutoModeWild();
                    break;
                case 1:
                    RzcKlcAirAct.this.updaterAirQuality();
                    break;
                case 2:
                    RzcKlcAirAct.this.updaterZoonTemp();
                    break;
                case 3:
                    RzcKlcAirAct.this.updaterRearWindowDefog();
                    break;
                case 4:
                    RzcKlcAirAct.this.updaterFrontWindowDefog();
                    break;
                case 5:
                    RzcKlcAirAct.this.updaterRemoteSeatHeat();
                    break;
                case 6:
                    RzcKlcAirAct.this.updaterAirStartMode();
                    break;
                case 101:
                    ((CheckedTextView) RzcKlcAirAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    break;
                case 102:
                    ((CheckedTextView) RzcKlcAirAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_klc_air_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                RzcKlcFunc.CAR_AIR_CONTROL(9, DataCanbus.DATA[101] != 0 ? 0 : 1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int AutoModeWildState = DataCanbus.DATA[0];
                if (AutoModeWildState == 0) {
                    RzcKlcFunc.CAR_AIR_CONTROL(0, 2);
                    break;
                } else if (AutoModeWildState == 1) {
                    RzcKlcFunc.CAR_AIR_CONTROL(0, 0);
                    break;
                } else if (AutoModeWildState == 2) {
                    RzcKlcFunc.CAR_AIR_CONTROL(0, 1);
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                int AutoModeWildState2 = DataCanbus.DATA[0];
                if (AutoModeWildState2 == 0) {
                    RzcKlcFunc.CAR_AIR_CONTROL(0, 1);
                    break;
                } else if (AutoModeWildState2 == 1) {
                    RzcKlcFunc.CAR_AIR_CONTROL(0, 2);
                    break;
                } else if (AutoModeWildState2 == 2) {
                    RzcKlcFunc.CAR_AIR_CONTROL(0, 0);
                    break;
                }
            case R.id.btn_minus2 /* 2131427484 */:
                int AirQualityState = DataCanbus.DATA[1];
                if (AirQualityState == 0) {
                    RzcKlcFunc.CAR_AIR_CONTROL(1, 2);
                    break;
                } else if (AirQualityState == 1) {
                    RzcKlcFunc.CAR_AIR_CONTROL(1, 0);
                    break;
                } else if (AirQualityState == 2) {
                    RzcKlcFunc.CAR_AIR_CONTROL(1, 1);
                    break;
                }
            case R.id.btn_plus2 /* 2131427486 */:
                int AirQualityState2 = DataCanbus.DATA[1];
                if (AirQualityState2 == 0) {
                    RzcKlcFunc.CAR_AIR_CONTROL(1, 1);
                    break;
                } else if (AirQualityState2 == 1) {
                    RzcKlcFunc.CAR_AIR_CONTROL(1, 2);
                    break;
                } else if (AirQualityState2 == 2) {
                    RzcKlcFunc.CAR_AIR_CONTROL(1, 0);
                    break;
                }
            case R.id.btn_minus3 /* 2131427488 */:
                int ZoonTempState = DataCanbus.DATA[2];
                if (ZoonTempState == 0) {
                    RzcKlcFunc.CAR_AIR_CONTROL(2, 2);
                    break;
                } else if (ZoonTempState == 1) {
                    RzcKlcFunc.CAR_AIR_CONTROL(2, 0);
                    break;
                } else if (ZoonTempState == 2) {
                    RzcKlcFunc.CAR_AIR_CONTROL(2, 1);
                    break;
                }
            case R.id.btn_plus3 /* 2131427490 */:
                int ZoonTempState2 = DataCanbus.DATA[2];
                if (ZoonTempState2 == 0) {
                    RzcKlcFunc.CAR_AIR_CONTROL(2, 1);
                    break;
                } else if (ZoonTempState2 == 1) {
                    RzcKlcFunc.CAR_AIR_CONTROL(2, 2);
                    break;
                } else if (ZoonTempState2 == 2) {
                    RzcKlcFunc.CAR_AIR_CONTROL(2, 0);
                    break;
                }
            case R.id.btn_minus4 /* 2131427492 */:
                int AirStartModeState = DataCanbus.DATA[6];
                if (AirStartModeState == 0) {
                    RzcKlcFunc.CAR_AIR_CONTROL(6, 2);
                    break;
                } else if (AirStartModeState == 1) {
                    RzcKlcFunc.CAR_AIR_CONTROL(6, 0);
                    break;
                } else if (AirStartModeState == 2) {
                    RzcKlcFunc.CAR_AIR_CONTROL(6, 1);
                    break;
                }
            case R.id.btn_plus4 /* 2131427494 */:
                int AirStartModeState2 = DataCanbus.DATA[6];
                if (AirStartModeState2 == 0) {
                    RzcKlcFunc.CAR_AIR_CONTROL(6, 1);
                    break;
                } else if (AirStartModeState2 == 1) {
                    RzcKlcFunc.CAR_AIR_CONTROL(6, 2);
                    break;
                } else if (AirStartModeState2 == 2) {
                    RzcKlcFunc.CAR_AIR_CONTROL(6, 0);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                RzcKlcFunc.CAR_AIR_CONTROL(8, DataCanbus.DATA[102] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                RzcKlcFunc.CAR_AIR_CONTROL(3, DataCanbus.DATA[3] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                RzcKlcFunc.CAR_AIR_CONTROL(4, DataCanbus.DATA[4] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                RzcKlcFunc.CAR_AIR_CONTROL(5, DataCanbus.DATA[5] != 0 ? 0 : 1);
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
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAirQuality() {
        int AirQualityState = DataCanbus.DATA[1];
        if (AirQualityState == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_onstar_close);
        } else if (AirQualityState == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_Low_sensitivity);
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(RearWindowAutoState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFrontWindowDefog() {
        int FrontWindowAutoState = DataCanbus.DATA[4];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(FrontWindowAutoState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRemoteSeatHeat() {
        int RemoteSeatHeatState = DataCanbus.DATA[5];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(RemoteSeatHeatState != 0);
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
}
