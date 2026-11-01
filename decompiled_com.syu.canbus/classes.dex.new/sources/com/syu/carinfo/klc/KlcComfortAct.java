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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KlcComfortAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcComfortAct.1
        @Override // com.syu.module.IUiNotify
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
                case 170:
                    KlcComfortAct.this.updatelaneassist();
                    break;
                case 201:
                    if (enable == 0) {
                        KlcComfortAct.this.findViewById(R.id.layout_view10).setVisibility(8);
                    } else if (enable == 1) {
                        KlcComfortAct.this.findViewById(R.id.layout_view10).setVisibility(0);
                        ((CheckedTextView) KlcComfortAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn != 0);
                    }
                    break;
                case 209:
                    if (enable == 0) {
                        KlcComfortAct.this.findViewById(R.id.layout_view11).setVisibility(8);
                    } else if (enable == 1) {
                        KlcComfortAct.this.findViewById(R.id.layout_view11).setVisibility(0);
                        if (switchOn == 0) {
                            ((TextView) KlcComfortAct.this.findViewById(R.id.tv_text3)).setText("Off");
                        } else if (switchOn == 1) {
                            ((TextView) KlcComfortAct.this.findViewById(R.id.tv_text3)).setText("On");
                        } else if (switchOn == 2) {
                            ((TextView) KlcComfortAct.this.findViewById(R.id.tv_text3)).setText("Extended");
                        }
                    }
                    break;
                case 210:
                    if (enable == 0) {
                        KlcComfortAct.this.findViewById(R.id.layout_view12).setVisibility(8);
                    } else if (enable == 1) {
                        KlcComfortAct.this.findViewById(R.id.layout_view12).setVisibility(0);
                        ((CheckedTextView) KlcComfortAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(switchOn != 0);
                    }
                    break;
                case 211:
                    if (enable == 0) {
                        KlcComfortAct.this.findViewById(R.id.layout_view13).setVisibility(8);
                    } else if (enable == 1) {
                        KlcComfortAct.this.findViewById(R.id.layout_view13).setVisibility(0);
                        if (switchOn == 0) {
                            ((TextView) KlcComfortAct.this.findViewById(R.id.tv_text4)).setText("Off");
                        } else if (switchOn == 1) {
                            ((TextView) KlcComfortAct.this.findViewById(R.id.tv_text4)).setText("Driver&Passenger");
                        } else if (switchOn == 2) {
                            ((TextView) KlcComfortAct.this.findViewById(R.id.tv_text4)).setText("Driver");
                        } else if (switchOn == 3) {
                            ((TextView) KlcComfortAct.this.findViewById(R.id.tv_text4)).setText("Passenger");
                        }
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_comfort_set);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int valSteerColPre = DataCanbus.DATA[118] & 255;
                if (valSteerColPre == 0) {
                    KlcFunc.C_CAR_COMFORT(3, 3);
                } else if (valSteerColPre == 1) {
                    KlcFunc.C_CAR_COMFORT(3, 0);
                } else if (valSteerColPre == 2) {
                    KlcFunc.C_CAR_COMFORT(3, 1);
                } else if (valSteerColPre == 3) {
                    KlcFunc.C_CAR_COMFORT(3, 2);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int valSteerColNext = DataCanbus.DATA[118] & 255;
                if (valSteerColNext == 0) {
                    KlcFunc.C_CAR_COMFORT(3, 1);
                } else if (valSteerColNext == 1) {
                    KlcFunc.C_CAR_COMFORT(3, 2);
                } else if (valSteerColNext == 2) {
                    KlcFunc.C_CAR_COMFORT(3, 3);
                } else if (valSteerColNext == 3) {
                    KlcFunc.C_CAR_COMFORT(3, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int i = DataCanbus.DATA[170] & 255;
                if ((DataCanbus.DATA[1000] & 65535) == 36) {
                    value2 = DataCanbus.DATA[170] & 255;
                } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
                    value2 = DataCanbus.DATA[194] & 255;
                } else {
                    value2 = DataCanbus.DATA[170] & 255;
                }
                KlcFunc.C_CAR_COMFORT(9, value2 == 0 ? 1 : 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int i2 = DataCanbus.DATA[170] & 255;
                if ((DataCanbus.DATA[1000] & 65535) == 36) {
                    value = DataCanbus.DATA[170] & 255;
                } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
                    value = DataCanbus.DATA[194] & 255;
                } else {
                    value = DataCanbus.DATA[170] & 255;
                }
                KlcFunc.C_CAR_CRASH(8, value == 0 ? 1 : 0);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value3 = (DataCanbus.DATA[209] & 255) - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                KlcFunc.C_CAR_COMFORT(10, value3);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value4 = (DataCanbus.DATA[209] & 255) + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                KlcFunc.C_CAR_COMFORT(10, value4);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value5 = (DataCanbus.DATA[211] & 255) - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                KlcFunc.C_CAR_COMFORT(12, value5);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value6 = (DataCanbus.DATA[211] & 255) + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                KlcFunc.C_CAR_COMFORT(12, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int valseatPark = DataCanbus.DATA[117] & 255;
                KlcFunc.C_CAR_COMFORT(1, valseatPark == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int valPrefre = DataCanbus.DATA[121] & 255;
                KlcFunc.C_CAR_COMFORT(5, valPrefre == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int valRever = DataCanbus.DATA[122] & 255;
                KlcFunc.C_CAR_COMFORT(6, valRever == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int valMirrAuto = DataCanbus.DATA[119] & 255;
                KlcFunc.C_CAR_COMFORT(2, valMirrAuto == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int valAutoFlod = DataCanbus.DATA[120] & 255;
                KlcFunc.C_CAR_COMFORT(4, valAutoFlod == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int valTitlTeer = DataCanbus.DATA[123] & 255;
                KlcFunc.C_CAR_COMFORT(7, valTitlTeer == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                KlcFunc.C_CAR_COMFORT(8, (DataCanbus.DATA[166] & 255) == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                KlcFunc.C_CAR_COMFORT(9, (DataCanbus.DATA[201] & 255) == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                KlcFunc.C_CAR_COMFORT(11, (DataCanbus.DATA[210] & 255) == 0 ? 1 : 0);
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
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
            DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updatelaneassist() {
        int val;
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            val = DataCanbus.DATA[170];
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
