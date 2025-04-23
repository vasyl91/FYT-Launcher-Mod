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

public class RzcKlcAirAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    RzcKlcAirAct.this.updaterAutoModeWild();
                    break;
                case 99:
                    RzcKlcAirAct.this.updaterAirQuality();
                    break;
                case 100:
                    RzcKlcAirAct.this.updaterZoonTemp();
                    break;
                case 101:
                    RzcKlcAirAct.this.updaterRearWindowDefog();
                    break;
                case 102:
                    RzcKlcAirAct.this.updaterFrontWindowDefog();
                    break;
                case 103:
                    RzcKlcAirAct.this.updaterRemoteSeatHeat();
                    break;
                case 104:
                    RzcKlcAirAct.this.updaterAirStartMode();
                    break;
                case 162:
                    ((CheckedTextView) RzcKlcAirAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    break;
                case 163:
                    ((CheckedTextView) RzcKlcAirAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                    break;
                case 209:
                    ((CheckedTextView) RzcKlcAirAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
                    break;
                case 210:
                    ((CheckedTextView) RzcKlcAirAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                    break;
                case 211:
                    switch (value) {
                        case 0:
                            ((TextView) RzcKlcAirAct.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                            break;
                        case 1:
                            ((TextView) RzcKlcAirAct.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_last_set);
                            break;
                    }
                case 212:
                    switch (value) {
                        case 0:
                            ((TextView) RzcKlcAirAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_rzc_17gl8_str1);
                            break;
                        case 1:
                            ((TextView) RzcKlcAirAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_rzc_17gl8_str2);
                            break;
                        case 2:
                            ((TextView) RzcKlcAirAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_rzc_17gl8_str3);
                            break;
                    }
                case 213:
                    switch (value) {
                        case 0:
                            ((TextView) RzcKlcAirAct.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) RzcKlcAirAct.this.findViewById(R.id.tv_text7)).setText(R.string.wc_weilang_driver_and_customer);
                            break;
                        case 2:
                            ((TextView) RzcKlcAirAct.this.findViewById(R.id.tv_text7)).setText(R.string.wc_weilang_driver);
                            break;
                    }
                case 214:
                    switch (value) {
                        case 0:
                            ((TextView) RzcKlcAirAct.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) RzcKlcAirAct.this.findViewById(R.id.tv_text8)).setText(R.string.wc_weilang_driver_and_customer);
                            break;
                        case 2:
                            ((TextView) RzcKlcAirAct.this.findViewById(R.id.tv_text8)).setText(R.string.wc_weilang_driver);
                            break;
                    }
                case 215:
                    ((CheckedTextView) RzcKlcAirAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                    break;
                case 216:
                    ((CheckedTextView) RzcKlcAirAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_klc_air_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
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
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int AutoModeWildState = DataCanbus.DATA[98];
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
            case R.id.btn_plus1 /* 2131427457 */:
                int AutoModeWildState2 = DataCanbus.DATA[98];
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
            case R.id.btn_minus2 /* 2131427458 */:
                int AirQualityState = DataCanbus.DATA[99];
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
            case R.id.btn_plus2 /* 2131427460 */:
                int AirQualityState2 = DataCanbus.DATA[99];
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
            case R.id.btn_minus3 /* 2131427461 */:
                int ZoonTempState = DataCanbus.DATA[100];
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
            case R.id.btn_plus3 /* 2131427463 */:
                int ZoonTempState2 = DataCanbus.DATA[100];
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
            case R.id.btn_minus4 /* 2131427464 */:
                int AirStartModeState = DataCanbus.DATA[104];
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
            case R.id.btn_plus4 /* 2131427466 */:
                int AirStartModeState2 = DataCanbus.DATA[104];
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
            case R.id.btn_minus5 /* 2131427467 */:
                int value = DataCanbus.DATA[211] - 1;
                if (value < 0) {
                    value = 1;
                }
                RzcKlcFunc.CAR_AIR_CONTROL(67, value);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value2 = DataCanbus.DATA[211] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                RzcKlcFunc.CAR_AIR_CONTROL(67, value2);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value3 = DataCanbus.DATA[212] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                RzcKlcFunc.CAR_AIR_CONTROL(68, value3);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value4 = DataCanbus.DATA[212] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                RzcKlcFunc.CAR_AIR_CONTROL(68, value4);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value5 = DataCanbus.DATA[213] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                RzcKlcFunc.CAR_AIR_CONTROL(69, value5);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value6 = DataCanbus.DATA[213] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                RzcKlcFunc.CAR_AIR_CONTROL(69, value6);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value7 = DataCanbus.DATA[214] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                RzcKlcFunc.CAR_AIR_CONTROL(70, value7);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value8 = DataCanbus.DATA[214] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                RzcKlcFunc.CAR_AIR_CONTROL(70, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                RzcKlcFunc.CAR_AIR_CONTROL(9, DataCanbus.DATA[162] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                RzcKlcFunc.CAR_AIR_CONTROL(8, DataCanbus.DATA[163] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                RzcKlcFunc.CAR_AIR_CONTROL(3, DataCanbus.DATA[101] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                RzcKlcFunc.CAR_AIR_CONTROL(4, DataCanbus.DATA[102] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                RzcKlcFunc.CAR_AIR_CONTROL(5, DataCanbus.DATA[103] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                RzcKlcFunc.CAR_AIR_CONTROL(65, DataCanbus.DATA[209] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                RzcKlcFunc.CAR_AIR_CONTROL(66, DataCanbus.DATA[210] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                RzcKlcFunc.CAR_AIR_CONTROL(10, DataCanbus.DATA[215] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                RzcKlcFunc.CAR_AIR_CONTROL(11, DataCanbus.DATA[216] != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(8, new int[]{68}, null, null);
        DataCanbus.PROXY.cmd(8, new int[]{5}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterAutoModeWild() {
        int AutoModeWildState = DataCanbus.DATA[98];
        if (AutoModeWildState == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
        } else if (AutoModeWildState == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
        } else if (AutoModeWildState == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
        }
    }

    
    public void updaterAirQuality() {
        int AirQualityState = DataCanbus.DATA[99];
        if (AirQualityState == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_onstar_close);
        } else if (AirQualityState == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_Low_sensitivity);
        } else if (AirQualityState == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_high_sensitivity);
        }
    }

    
    public void updaterZoonTemp() {
        int ZoonTempState = DataCanbus.DATA[100];
        if (ZoonTempState == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
        } else if (ZoonTempState == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
        } else if (ZoonTempState == 2) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_last_Set);
        }
    }

    
    public void updaterRearWindowDefog() {
        int RearWindowAutoState = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(RearWindowAutoState != 0);
    }

    
    public void updaterFrontWindowDefog() {
        int FrontWindowAutoState = DataCanbus.DATA[102];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(FrontWindowAutoState != 0);
    }

    
    public void updaterRemoteSeatHeat() {
        int RemoteSeatHeatState = DataCanbus.DATA[103];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(RemoteSeatHeatState != 0);
    }

    
    public void updaterAirStartMode() {
        int AirStartModeState = DataCanbus.DATA[104];
        if (AirStartModeState == 0) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (AirStartModeState == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_ON);
        } else if (AirStartModeState == 2) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_last_set);
        }
    }
}
