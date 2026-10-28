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

@SuppressWarnings({"deprecation", "unchecked"})
public class ActAirSet_GM_SiBo extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 97:
                    ActAirSet_GM_SiBo.this.updaterAutoModeWild();
                    break;
                case 98:
                    ActAirSet_GM_SiBo.this.updaterAirQuality();
                    break;
                case 99:
                    ActAirSet_GM_SiBo.this.updaterZoonTemp();
                    break;
                case 100:
                    ActAirSet_GM_SiBo.this.updaterRearWindowDefog();
                    break;
                case 101:
                    ActAirSet_GM_SiBo.this.updaterFrontWindowDefog();
                    break;
                case 102:
                    ActAirSet_GM_SiBo.this.mUpdateBackAirState();
                    break;
                case 103:
                    ActAirSet_GM_SiBo.this.updaterAirStartMode();
                    break;
                case 136:
                    ActAirSet_GM_SiBo.this.uRemoteAirPower();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_sb_gm_air_set);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int AutoModeWildState = DataCanbus.DATA[97];
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
            case R.id.btn_plus1 /* 2131427457 */:
                int AutoModeWildState2 = DataCanbus.DATA[97];
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
            case R.id.btn_minus2 /* 2131427458 */:
                int AirQualityState = DataCanbus.DATA[98];
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
            case R.id.btn_plus2 /* 2131427460 */:
                int AirQualityState2 = DataCanbus.DATA[98];
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
            case R.id.btn_minus3 /* 2131427461 */:
                int ZoonTempState = DataCanbus.DATA[99];
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
            case R.id.btn_plus3 /* 2131427463 */:
                int ZoonTempState2 = DataCanbus.DATA[99];
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
            case R.id.btn_minus4 /* 2131427464 */:
                int AirStartModeState = DataCanbus.DATA[103];
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
            case R.id.btn_plus4 /* 2131427466 */:
                int AirStartModeState2 = DataCanbus.DATA[103];
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
            case R.id.btn_minus5 /* 2131427467 */:
                int mBackAir = DataCanbus.DATA[102];
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
            case R.id.btn_plus5 /* 2131427469 */:
                int mBackAir2 = DataCanbus.DATA[102];
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
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                XflCkFunc.CAR_AIR_CONTROL(22, DataCanbus.DATA[136] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                XflCkFunc.CAR_AIR_CONTROL(5, DataCanbus.DATA[100] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                XflCkFunc.CAR_AIR_CONTROL(6, DataCanbus.DATA[101] != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterAutoModeWild() {
        int AutoModeWildState = DataCanbus.DATA[97];
        if (AutoModeWildState == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
        } else if (AutoModeWildState == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
        } else if (AutoModeWildState == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
        }
    }

    protected void uRemoteAirPower() {
        int mRemoteStartAir = DataCanbus.DATA[136];
        if (((TextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            int[] resId = {R.string.klc_air_auto, R.string.klc_air_last_Set};
            ((TextView) findViewById(R.id.ctv_checkedtext1)).setText(resId[mRemoteStartAir]);
        }
    }

    
    public void updaterAirQuality() {
        int AirQualityState = DataCanbus.DATA[98];
        if (AirQualityState == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_Low_sensitivity);
        } else if (AirQualityState == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xfl_ck_middle_sensitivity);
        } else if (AirQualityState == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_high_sensitivity);
        }
    }

    
    public void updaterZoonTemp() {
        int ZoonTempState = DataCanbus.DATA[99];
        if (ZoonTempState == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
        } else if (ZoonTempState == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
        } else if (ZoonTempState == 2) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_last_Set);
        }
    }

    
    public void updaterRearWindowDefog() {
        int RearWindowAutoState = DataCanbus.DATA[100];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(RearWindowAutoState != 0);
    }

    
    public void updaterFrontWindowDefog() {
        int FrontWindowAutoState = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(FrontWindowAutoState != 0);
    }

    
    public void updaterAirStartMode() {
        int AirStartModeState = DataCanbus.DATA[103];
        if (AirStartModeState == 0) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (AirStartModeState == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_ON);
        } else if (AirStartModeState == 2) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_last_set);
        }
    }

    
    public void mUpdateBackAirState() {
        int mBackAir = DataCanbus.DATA[102];
        if (mBackAir == 0) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (mBackAir == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_sb_saiou3_str3);
        } else if (mBackAir == 2) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_sb_saiou3_str4);
        }
    }
}
