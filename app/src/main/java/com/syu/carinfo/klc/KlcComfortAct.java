package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class KlcComfortAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            switch (updateCode) {
                case 117:
                    KlcComfortAct.this.updateDriverSeatYiwei();
                    break;
                case 118:
                    KlcComfortAct.this.updateZhuangxiangGuanzhuYiwei();
                    break;
                case 119:
                    KlcComfortAct.this.updateAutoMirrorQingxie();
                    break;
                case 120:
                    KlcComfortAct.this.updateAutoMirrorFold();
                    break;
                case 121:
                    KlcComfortAct.this.updateDriverPersonalSet();
                    break;
                case 122:
                    KlcComfortAct.this.updateAutoYushuaSheading();
                    break;
                case 123:
                    KlcComfortAct.this.updateZhuangxiangGuanzhuQingxie();
                    break;
                case 166:
                    KlcComfortAct.this.updateAutoYugua();
                    break;
                case 168:
                case 170:
                    KlcComfortAct.this.updatelaneassist();
                    break;
                case 201:
                    if (enable == 0) {
                        KlcComfortAct.this.findViewById(R.id.layout_view10).setVisibility(8);
                        break;
                    } else if (enable == 1) {
                        KlcComfortAct.this.findViewById(R.id.layout_view10).setVisibility(0);
                        ((CheckedTextView) KlcComfortAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn != 0);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_klc_comfort_set);
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
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int valSteerColPre = DataCanbus.DATA[118] & 255;
                if (valSteerColPre == 0) {
                    KlcFunc.C_CAR_COMFORT(3, 3);
                    break;
                } else if (valSteerColPre == 1) {
                    KlcFunc.C_CAR_COMFORT(3, 0);
                    break;
                } else if (valSteerColPre == 2) {
                    KlcFunc.C_CAR_COMFORT(3, 1);
                    break;
                } else if (valSteerColPre == 3) {
                    KlcFunc.C_CAR_COMFORT(3, 2);
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                int valSteerColNext = DataCanbus.DATA[118] & 255;
                if (valSteerColNext == 0) {
                    KlcFunc.C_CAR_COMFORT(3, 1);
                    break;
                } else if (valSteerColNext == 1) {
                    KlcFunc.C_CAR_COMFORT(3, 2);
                    break;
                } else if (valSteerColNext == 2) {
                    KlcFunc.C_CAR_COMFORT(3, 3);
                    break;
                } else if (valSteerColNext == 3) {
                    KlcFunc.C_CAR_COMFORT(3, 0);
                    break;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                int i = DataCanbus.DATA[170] & 255;
                if ((DataCanbus.DATA[1000] & 65535) == 36) {
                    value2 = DataCanbus.DATA[170] & 255;
                } else if (DataCanbus.DATA[1000] == 357) {
                    value2 = DataCanbus.DATA[168] & 255;
                } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
                    value2 = DataCanbus.DATA[194] & 255;
                } else {
                    value2 = DataCanbus.DATA[170] & 255;
                }
                KlcFunc.C_CAR_COMFORT(9, value2 == 0 ? 1 : 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int i2 = DataCanbus.DATA[170] & 255;
                if ((DataCanbus.DATA[1000] & 65535) == 36) {
                    value = DataCanbus.DATA[170] & 255;
                } else if (DataCanbus.DATA[1000] == 357) {
                    value = DataCanbus.DATA[168] & 255;
                } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
                    value = DataCanbus.DATA[194] & 255;
                } else {
                    value = DataCanbus.DATA[170] & 255;
                }
                KlcFunc.C_CAR_CRASH(8, value == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int valseatPark = DataCanbus.DATA[117] & 255;
                KlcFunc.C_CAR_COMFORT(1, valseatPark == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int valMirrAuto = DataCanbus.DATA[119] & 255;
                KlcFunc.C_CAR_COMFORT(2, valMirrAuto == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int valAutoFlod = DataCanbus.DATA[120] & 255;
                KlcFunc.C_CAR_COMFORT(4, valAutoFlod == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int valPrefre = DataCanbus.DATA[121] & 255;
                KlcFunc.C_CAR_COMFORT(5, valPrefre == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int valRever = DataCanbus.DATA[122] & 255;
                KlcFunc.C_CAR_COMFORT(6, valRever == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int valTitlTeer = DataCanbus.DATA[123] & 255;
                KlcFunc.C_CAR_COMFORT(7, valTitlTeer == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value3 = DataCanbus.DATA[166] & 255;
                KlcFunc.C_CAR_COMFORT(8, value3 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value4 = DataCanbus.DATA[201] & 255;
                KlcFunc.C_CAR_COMFORT(9, value4 == 0 ? 1 : 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 308 || DataCanbus.DATA[1000] == 357) {
            findViewById(R.id.layout_view8).setVisibility(0);
        } else {
            findViewById(R.id.layout_view8).setVisibility(8);
        }
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 357) {
            DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
            DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
            return;
        }
        if (DataCanbus.DATA[1000] == 357) {
            DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
            DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void updateDriverSeatYiwei() {
        int val = DataCanbus.DATA[117];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
        }
    }

    
    public void updateZhuangxiangGuanzhuYiwei() {
        int val = DataCanbus.DATA[118];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view2).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_comfort_Steering_column_contraction_str);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_comfort_Steering_column_upgrade_str);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_comfort_Steering_column_enhance_steering_column);
            }
        }
    }

    
    public void updateAutoMirrorQingxie() {
        int val = DataCanbus.DATA[119];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view3).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
        }
    }

    
    public void updateAutoMirrorFold() {
        int val = DataCanbus.DATA[120];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view4).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view4).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
        }
    }

    
    public void updateDriverPersonalSet() {
        int val = DataCanbus.DATA[121];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view5).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view5).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
        }
    }

    
    public void updateAutoYushuaSheading() {
        int val = DataCanbus.DATA[122];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view6).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view6).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
        }
    }

    
    public void updateZhuangxiangGuanzhuQingxie() {
        int val = DataCanbus.DATA[123];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view7).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view7).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn != 0);
        }
    }

    
    public void updateAutoYugua() {
        int val = DataCanbus.DATA[166];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view8).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view8).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
        }
    }

    
    public void updatelaneassist() {
        int val;
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            val = DataCanbus.DATA[170];
        } else if (DataCanbus.DATA[1000] == 357) {
            val = DataCanbus.DATA[168];
        } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
            val = DataCanbus.DATA[194];
        } else {
            val = DataCanbus.DATA[170];
        }
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view9).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view9).setVisibility(0);
            if (((TextView) findViewById(R.id.tv_text2)) != null) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_stand_parking);
                } else if (switchOn == 1) {
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_incre_parking);
                }
            }
        }
    }
}
