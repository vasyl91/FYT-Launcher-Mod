package com.syu.carinfo.lz.landrover;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LandRoverCarSet extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int val = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            LandRoverCarSet.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 14:
                    LandRoverCarSet.this.updateSpeedWarning();
                    break;
                case 15:
                    LandRoverCarSet.this.updateSpeedWarningOnoff();
                    break;
                case 16:
                    LandRoverCarSet.this.updateTempunit();
                    break;
                case 17:
                    LandRoverCarSet.this.updateOilunit();
                    break;
                case 18:
                    LandRoverCarSet.this.updateDistanceunit();
                    break;
                case 21:
                    LandRoverCarSet.this.updateInstrumentDisplay();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_landrover_settings);
        setListener();
    }

    private void setListener() {
        setSelfClick(findViewById(R.id.lz_landrover_btn_tempunit_minus), this);
        setSelfClick(findViewById(R.id.lz_landrover_btn_tempunit_plus), this);
        setSelfClick(findViewById(R.id.lz_landrover_btn_oilunit_minus), this);
        setSelfClick(findViewById(R.id.lz_landrover_btn_oilunit_plus), this);
        setSelfClick(findViewById(R.id.lz_landrover_btn_distanceunit_minus), this);
        setSelfClick(findViewById(R.id.lz_landrover_btn_distanceunit_plus), this);
        setSelfClick(findViewById(R.id.lz_landrover_btn_speedwarning_minus), this);
        setSelfClick(findViewById(R.id.lz_landrover_btn_speedwarning_plus), this);
        setSelfClick(findViewById(R.id.ctv_lz_landrover_speedwarning_onoff), this);
        setSelfClick(findViewById(R.id.ctv_lz_landrover_limit_onoff), this);
        setSelfClick(findViewById(R.id.ctv_lz_landrover_range_onoff), this);
        setSelfClick(findViewById(R.id.ctv_lz_landrover_time_onoff), this);
        setSelfClick(findViewById(R.id.ctv_lz_landrover_consumption1_onoff), this);
        setSelfClick(findViewById(R.id.ctv_lz_landrover_consumption2_onoff), this);
        setSelfClick(findViewById(R.id.ctv_lz_landrover_avgspeed_onoff), this);
        setSelfClick(findViewById(R.id.ctv_lz_landrover_date_onoff), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lz_landrover_btn_tempunit_minus /* 2131427907 */:
                int value = DataCanbus.DATA[16] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(2, value);
                break;
            case R.id.lz_landrover_btn_tempunit_plus /* 2131427909 */:
                int value2 = DataCanbus.DATA[16] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.lz_landrover_btn_oilunit_minus /* 2131428231 */:
                int value3 = DataCanbus.DATA[17] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(3, value3);
                break;
            case R.id.lz_landrover_btn_oilunit_plus /* 2131428233 */:
                int value4 = DataCanbus.DATA[17] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.lz_landrover_btn_distanceunit_minus /* 2131428234 */:
                int value5 = DataCanbus.DATA[18] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(4, value5);
                break;
            case R.id.lz_landrover_btn_distanceunit_plus /* 2131428236 */:
                int value6 = DataCanbus.DATA[18] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.lz_landrover_btn_speedwarning_minus /* 2131428237 */:
                int value7 = DataCanbus.DATA[14] - 1;
                int max = 250;
                int min = 16;
                if (DataCanbus.DATA[18] == 1) {
                    max = 156;
                    min = 10;
                }
                if (value7 < min) {
                    value7 = max;
                }
                setCarInfo(0, value7);
                break;
            case R.id.lz_landrover_btn_speedwarning_plus /* 2131428239 */:
                int value8 = DataCanbus.DATA[14] + 1;
                int max2 = 250;
                int min2 = 16;
                if (DataCanbus.DATA[18] == 1) {
                    max2 = 156;
                    min2 = 10;
                }
                if (value8 > max2) {
                    value8 = min2;
                }
                setCarInfo(0, value8);
                break;
            case R.id.ctv_lz_landrover_speedwarning_onoff /* 2131428240 */:
                int value9 = DataCanbus.DATA[15];
                if (value9 == 0) {
                    value9 = 1;
                } else if (value9 == 1) {
                    value9 = 0;
                }
                setCarInfo(1, value9);
                break;
            case R.id.ctv_lz_landrover_limit_onoff /* 2131428241 */:
                int value10 = DataCanbus.DATA[21];
                int valuedata = (value10 >> 7) & 1;
                if (valuedata == 0) {
                    value10 |= 128;
                } else if (valuedata == 1) {
                    value10 &= 127;
                }
                setCarInfo(10, value10);
                break;
            case R.id.ctv_lz_landrover_range_onoff /* 2131428242 */:
                int value11 = DataCanbus.DATA[21];
                int valuedata2 = (value11 >> 6) & 1;
                if (valuedata2 == 0) {
                    value11 |= 64;
                } else if (valuedata2 == 1) {
                    value11 &= 191;
                }
                setCarInfo(10, value11);
                break;
            case R.id.ctv_lz_landrover_time_onoff /* 2131428243 */:
                int value12 = DataCanbus.DATA[21];
                int valuedata3 = (value12 >> 5) & 1;
                if (valuedata3 == 0) {
                    value12 |= 32;
                } else if (valuedata3 == 1) {
                    value12 &= 223;
                }
                setCarInfo(10, value12);
                break;
            case R.id.ctv_lz_landrover_consumption1_onoff /* 2131428244 */:
                int value13 = DataCanbus.DATA[21];
                int valuedata4 = (value13 >> 4) & 1;
                if (valuedata4 == 0) {
                    value13 |= 16;
                } else if (valuedata4 == 1) {
                    value13 &= 239;
                }
                setCarInfo(10, value13);
                break;
            case R.id.ctv_lz_landrover_consumption2_onoff /* 2131428245 */:
                int value14 = DataCanbus.DATA[21];
                int valuedata5 = (value14 >> 3) & 1;
                if (valuedata5 == 0) {
                    value14 |= 8;
                } else if (valuedata5 == 1) {
                    value14 &= 247;
                }
                setCarInfo(10, value14);
                break;
            case R.id.ctv_lz_landrover_avgspeed_onoff /* 2131428246 */:
                int value15 = DataCanbus.DATA[21];
                int valuedata6 = (value15 >> 2) & 1;
                if (valuedata6 == 0) {
                    value15 |= 4;
                } else if (valuedata6 == 1) {
                    value15 &= 251;
                }
                setCarInfo(10, value15);
                break;
            case R.id.ctv_lz_landrover_date_onoff /* 2131428247 */:
                int value16 = DataCanbus.DATA[21];
                int valuedata7 = (value16 >> 1) & 1;
                if (valuedata7 == 0) {
                    value16 |= 2;
                } else if (valuedata7 == 1) {
                    value16 &= 253;
                }
                setCarInfo(10, value16);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, value1, value2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateInstrumentDisplay() {
        int value = DataCanbus.DATA[21];
        if (findViewById(R.id.ctv_lz_landrover_limit_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_lz_landrover_limit_onoff)).setChecked(((value >> 7) & 1) == 1);
        }
        if (findViewById(R.id.ctv_lz_landrover_range_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_lz_landrover_range_onoff)).setChecked(((value >> 6) & 1) == 1);
        }
        if (findViewById(R.id.ctv_lz_landrover_time_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_lz_landrover_time_onoff)).setChecked(((value >> 5) & 1) == 1);
        }
        if (findViewById(R.id.ctv_lz_landrover_consumption1_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_lz_landrover_consumption1_onoff)).setChecked(((value >> 4) & 1) == 1);
        }
        if (findViewById(R.id.ctv_lz_landrover_consumption2_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_lz_landrover_consumption2_onoff)).setChecked(((value >> 3) & 1) == 1);
        }
        if (findViewById(R.id.ctv_lz_landrover_avgspeed_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_lz_landrover_avgspeed_onoff)).setChecked(((value >> 2) & 1) == 1);
        }
        if (findViewById(R.id.ctv_lz_landrover_date_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_lz_landrover_date_onoff)).setChecked(((value >> 1) & 1) == 1);
        }
    }

    
    public void updateSpeedWarningOnoff() {
        int value = DataCanbus.DATA[15];
        if (findViewById(R.id.ctv_lz_landrover_speedwarning_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_lz_landrover_speedwarning_onoff)).setChecked(value == 1);
        }
    }

    
    public void updateSpeedWarning() {
        int value = DataCanbus.DATA[14];
        if (findViewById(R.id.tv_lz_landrover_speedwarning) != null) {
            if (DataCanbus.DATA[18] == 0) {
                ((TextView) findViewById(R.id.tv_lz_landrover_speedwarning)).setText(value + "km/h");
            } else if (DataCanbus.DATA[18] == 1) {
                ((TextView) findViewById(R.id.tv_lz_landrover_speedwarning)).setText(value + "mph");
            }
        }
    }

    
    public void updateDistanceunit() {
        int value = DataCanbus.DATA[18];
        if (findViewById(R.id.tv_lz_landrover_distanceunit) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_lz_landrover_distanceunit)).setText("km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_lz_landrover_distanceunit)).setText("mil");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_lz_landrover_distanceunit)).setText("km");
                    break;
            }
        }
    }

    
    public void updateTempunit() {
        int value = DataCanbus.DATA[16];
        if (findViewById(R.id.tv_lz_landrover_tempunit) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_lz_landrover_tempunit)).setText("℃");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_lz_landrover_tempunit)).setText("℉");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_lz_landrover_tempunit)).setText("℃");
                    break;
            }
        }
    }

    
    public void updateOilunit() {
        int value = DataCanbus.DATA[17];
        if (findViewById(R.id.tv_lz_landrover_oilunit) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_lz_landrover_oilunit)).setText("l/100km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_lz_landrover_oilunit)).setText("mpg");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_lz_landrover_oilunit)).setText("km/l");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_lz_landrover_oilunit)).setText("l/100km");
                    break;
            }
        }
    }
}
