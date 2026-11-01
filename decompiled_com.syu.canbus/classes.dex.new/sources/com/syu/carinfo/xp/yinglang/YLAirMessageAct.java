package com.syu.carinfo.xp.yinglang;

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
public class YLAirMessageAct extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLAirMessageAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 97:
                    YLAirMessageAct.this.updaterAutoAirVo();
                    break;
                case 98:
                    YLAirMessageAct.this.updaterAirQualitySensor1();
                    break;
                case 99:
                    YLAirMessageAct.this.updaterAutoZoneCon();
                    break;
                case 100:
                    YLAirMessageAct.this.updaterAutoRearWindowDefogg();
                    break;
                case 101:
                    YLAirMessageAct.this.updaterAutoFrontWindowDefogg();
                    break;
                case 102:
                    YLAirMessageAct.this.updaterRemoteSeatAutoHeat();
                    break;
                case 103:
                    YLAirMessageAct.this.updaterAirConditioning();
                    break;
                case 154:
                    YLAirMessageAct.this.updaterFeeback();
                    break;
                case 155:
                    YLAirMessageAct.this.updaterAutoAc();
                    break;
                case 156:
                    YLAirMessageAct.this.updaterOpenBig();
                    break;
                case 157:
                    YLAirMessageAct.this.updaterNavi();
                    break;
                case 158:
                    YLAirMessageAct.this.updaterRuning();
                    break;
                case 159:
                    YLAirMessageAct.this.updaterClose();
                    break;
                case 160:
                    YLAirMessageAct.this.updaterRemoteSeatAutoHeatAble();
                    break;
                case 188:
                    YLAirMessageAct.this.updaterearairpower();
                    break;
                case 189:
                    YLAirMessageAct.this.updateremotepowerair();
                    break;
                case 190:
                    YLAirMessageAct.this.updateremotepowerseatblow();
                    break;
                case 191:
                    YLAirMessageAct.this.updateRemotepowerseatheat();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_air_message_set);
        setUI();
    }

    private boolean IsRzcGl8() {
        return DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 393479 || DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087;
    }

    private void setUI() {
        setClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        setClick((Button) findViewById(R.id.btn_minus3));
        setClick((Button) findViewById(R.id.btn_plus3));
        setClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
        setClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3));
        setClick((Button) findViewById(R.id.btn_minus1));
        setClick((Button) findViewById(R.id.btn_plus1));
        setClick((Button) findViewById(R.id.btn_minus2));
        setClick((Button) findViewById(R.id.btn_plus2));
        setClick((Button) findViewById(R.id.btn_minus4));
        setClick((Button) findViewById(R.id.btn_plus4));
        setClick(findViewById(R.id.layout_view9));
        setClick(findViewById(R.id.layout_view10));
        setClick(findViewById(R.id.layout_view11));
        setClick(findViewById(R.id.layout_view12));
        setClick((Button) findViewById(R.id.btn_minus5));
        setClick((Button) findViewById(R.id.btn_plus5));
        if (findViewById(R.id.layout_view9) != null) {
            findViewById(R.id.layout_view9).setVisibility(IsRzcGl8() ? 0 : 8);
        }
        if (findViewById(R.id.layout_view10) != null) {
            findViewById(R.id.layout_view10).setVisibility(IsRzcGl8() ? 0 : 8);
        }
        if (findViewById(R.id.layout_view11) != null) {
            findViewById(R.id.layout_view11).setVisibility(IsRzcGl8() ? 0 : 8);
        }
        if (findViewById(R.id.layout_view12) != null) {
            findViewById(R.id.layout_view12).setVisibility(IsRzcGl8() ? 0 : 8);
        }
    }

    private void setClick(View v) {
        if (v != null) {
            v.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int valAutoVolPre = DataCanbus.DATA[97];
                if (valAutoVolPre == 0) {
                    YLFunc.CAR_AIR_CONTROL(0, 2);
                } else if (valAutoVolPre == 1) {
                    YLFunc.CAR_AIR_CONTROL(0, 0);
                } else if (valAutoVolPre == 2) {
                    YLFunc.CAR_AIR_CONTROL(0, 1);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int valAutoVolNext = DataCanbus.DATA[97];
                if (valAutoVolNext == 0) {
                    YLFunc.CAR_AIR_CONTROL(0, 1);
                } else if (valAutoVolNext == 1) {
                    YLFunc.CAR_AIR_CONTROL(0, 2);
                } else if (valAutoVolNext == 2) {
                    YLFunc.CAR_AIR_CONTROL(0, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int valAirConPre = DataCanbus.DATA[103];
                if (valAirConPre == 0) {
                    YLFunc.CAR_AIR_CONTROL(6, 2);
                } else if (valAirConPre == 1) {
                    YLFunc.CAR_AIR_CONTROL(6, 0);
                } else if (valAirConPre == 2) {
                    YLFunc.CAR_AIR_CONTROL(6, 1);
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int valAirConNext = DataCanbus.DATA[103];
                if (valAirConNext == 0) {
                    YLFunc.CAR_AIR_CONTROL(6, 1);
                } else if (valAirConNext == 1) {
                    YLFunc.CAR_AIR_CONTROL(6, 2);
                } else if (valAirConNext == 2) {
                    YLFunc.CAR_AIR_CONTROL(6, 0);
                }
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value = DataCanbus.DATA[98];
                if (value == 0) {
                    YLFunc.CAR_AIR_CONTROL(1, 2);
                } else if (value == 1) {
                    YLFunc.CAR_AIR_CONTROL(1, 0);
                } else if (value == 2) {
                    YLFunc.CAR_AIR_CONTROL(1, 1);
                }
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int valueQualityNext = DataCanbus.DATA[98];
                if (valueQualityNext == 0) {
                    YLFunc.CAR_AIR_CONTROL(1, 1);
                } else if (valueQualityNext == 1) {
                    YLFunc.CAR_AIR_CONTROL(1, 2);
                } else if (valueQualityNext == 2) {
                    YLFunc.CAR_AIR_CONTROL(1, 0);
                }
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int valAutoZonePre = DataCanbus.DATA[99];
                if (valAutoZonePre == 0) {
                    YLFunc.CAR_AIR_CONTROL(2, 2);
                } else if (valAutoZonePre == 1) {
                    YLFunc.CAR_AIR_CONTROL(2, 0);
                } else if (valAutoZonePre == 2) {
                    YLFunc.CAR_AIR_CONTROL(2, 1);
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int valAutoZoneNext = DataCanbus.DATA[99];
                if (valAutoZoneNext == 0) {
                    YLFunc.CAR_AIR_CONTROL(2, 1);
                } else if (valAutoZoneNext == 1) {
                    YLFunc.CAR_AIR_CONTROL(2, 2);
                } else if (valAutoZoneNext == 2) {
                    YLFunc.CAR_AIR_CONTROL(2, 0);
                }
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int Heat_next = DataCanbus.DATA[102] - 1;
                if (Heat_next <= 0) {
                    Heat_next = 2;
                }
                YLFunc.CAR_AIR_CONTROL(5, Heat_next);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int Heat_pre = DataCanbus.DATA[102] + 1;
                if (Heat_pre >= 2) {
                    Heat_pre = 0;
                }
                YLFunc.CAR_AIR_CONTROL(5, Heat_pre);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int valRemoteSeatHeat = DataCanbus.DATA[102];
                YLFunc.CAR_AIR_CONTROL(5, valRemoteSeatHeat == 0 ? 1 : 0);
                break;
            case R.id.layout_view9 /* 2131427570 */:
                YLFunc.CAR_AIR_CONTROL(66, DataCanbus.DATA[190] == 0 ? 1 : 0);
                break;
            case R.id.layout_view10 /* 2131427571 */:
                YLFunc.CAR_AIR_CONTROL(65, DataCanbus.DATA[191] == 0 ? 1 : 0);
                break;
            case R.id.layout_view11 /* 2131427572 */:
                YLFunc.CAR_AIR_CONTROL(67, DataCanbus.DATA[189] == 0 ? 1 : 0);
                break;
            case R.id.layout_view12 /* 2131427573 */:
                int val = DataCanbus.DATA[188] + 1;
                if (val > 2) {
                    val = 0;
                }
                YLFunc.CAR_AIR_CONTROL(68, val);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int valAutFrontDefog = DataCanbus.DATA[101];
                YLFunc.CAR_AIR_CONTROL(4, valAutFrontDefog == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int valRearWindowDefog = DataCanbus.DATA[100];
                YLFunc.CAR_AIR_CONTROL(3, valRearWindowDefog == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
        mIsFront = true;
        if (DataCanbus.DATA[1000] == 2294139) {
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
        mIsFront = false;
    }

    private void addUpdater() {
        if ((DataCanbus.DATA[1000] & 65535) != 379) {
            DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        }
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        if (IsRzcGl8()) {
            DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        if (IsRzcGl8()) {
            DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFeeback() {
        if (findViewById(R.id.layout_view1) != null) {
            int enable = DataCanbus.DATA[154];
            if (enable == 0) {
                findViewById(R.id.layout_view1).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.layout_view1).setVisibility(0);
            }
        }
    }

    protected void updateRemotepowerseatheat() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            int val = DataCanbus.DATA[191];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(val != 0);
        }
    }

    protected void updateremotepowerseatblow() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            int val = DataCanbus.DATA[190];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(val != 0);
        }
    }

    protected void updaterearairpower() {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            int val = DataCanbus.DATA[188];
            int[] resId = {R.string.str_rzc_17gl8_str1, R.string.str_rzc_17gl8_str2, R.string.str_rzc_17gl8_str3};
            ((TextView) findViewById(R.id.tv_text8)).setText(resId[val]);
        }
    }

    protected void updateremotepowerair() {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            int val = DataCanbus.DATA[189];
            int[] resId = {R.string.klc_air_auto, R.string.klc_air_last_Set};
            ((TextView) findViewById(R.id.tv_text7)).setText(resId[val]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoAirVo() {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            int switchOn = DataCanbus.DATA[97];
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOpenBig() {
        if (findViewById(R.id.layout_view2) != null) {
            int enable = DataCanbus.DATA[156];
            if (enable == 0) {
                findViewById(R.id.layout_view2).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.layout_view2).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAirConditioning() {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            int switchOn = DataCanbus.DATA[103];
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_ON);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_last_set);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoAc() {
        if (findViewById(R.id.layout_view3) != null) {
            int enable = DataCanbus.DATA[155];
            if (enable == 0) {
                findViewById(R.id.layout_view3).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.layout_view3).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAirQualitySensor1() {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            int switchOn = DataCanbus.DATA[98];
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_Off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_Low_sensitivity);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_high_sensitivity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterClose() {
        if (findViewById(R.id.layout_view4) != null) {
            int enable = DataCanbus.DATA[159];
            if (enable == 0) {
                findViewById(R.id.layout_view4).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.layout_view4).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoZoneCon() {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            int switchOn = DataCanbus.DATA[99];
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_last_Set);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRemoteSeatAutoHeatAble() {
        if (findViewById(R.id.layout_view5) != null) {
            int enable = DataCanbus.DATA[160];
            if (DataCanbus.DATA[1000] == 327998) {
                findViewById(R.id.layout_view5).setVisibility(8);
                if (findViewById(R.id.layout_view6) != null) {
                    findViewById(R.id.layout_view6).setVisibility(enable != 0 ? 0 : 8);
                    return;
                }
                return;
            }
            findViewById(R.id.layout_view5).setVisibility(enable != 0 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRemoteSeatAutoHeat() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            int switchOn = DataCanbus.DATA[102];
            if (switchOn > 2 || switchOn < 0) {
                switchOn = 0;
            }
            if (DataCanbus.DATA[1000] == 327998) {
                int[] resId = {R.string.off, R.string.str_318_xp_heat_1, R.string.str_318_xp_heat_2};
                if (((TextView) findViewById(R.id.tv_text5)) != null && switchOn >= 0 && switchOn <= 2) {
                    ((TextView) findViewById(R.id.tv_text5)).setText(resId[switchOn]);
                    return;
                }
                return;
            }
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterNavi() {
        if (findViewById(R.id.layout_view7) != null) {
            int enable = DataCanbus.DATA[157];
            if (enable == 0) {
                findViewById(R.id.layout_view7).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.layout_view7).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoFrontWindowDefogg() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            int switchOn = DataCanbus.DATA[101];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRuning() {
        if (findViewById(R.id.layout_view8) != null) {
            int enable = DataCanbus.DATA[158];
            if (enable == 0) {
                findViewById(R.id.layout_view8).setVisibility(8);
            } else if (enable == 1) {
                findViewById(R.id.layout_view8).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoRearWindowDefogg() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            int switchOn = DataCanbus.DATA[100];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_air_Manual);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_air_auto);
            }
        }
    }
}
