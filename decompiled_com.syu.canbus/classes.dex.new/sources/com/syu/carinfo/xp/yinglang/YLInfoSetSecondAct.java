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
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class YLInfoSetSecondAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetSecondAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 117:
                    YLInfoSetSecondAct.this.updaternearCarUnlock();
                    break;
                case 118:
                    YLInfoSetSecondAct.this.updaterForgotKey();
                    break;
                case 119:
                    YLInfoSetSecondAct.this.updaterDriverStyle();
                    break;
                case 120:
                    YLInfoSetSecondAct.this.updaterRelockDoor();
                    break;
                case 121:
                    YLInfoSetSecondAct.this.updaterautoWipers();
                    break;
                case 122:
                    YLInfoSetSecondAct.this.updaterblindZone();
                    break;
                case 123:
                    YLInfoSetSecondAct.this.updaterleaveCarLock();
                    break;
                case 124:
                    YLInfoSetSecondAct.this.updaterhandTraffic();
                    break;
                case 125:
                    YLInfoSetSecondAct.this.updateradaptiveForwardLight();
                    break;
                case 126:
                    YLInfoSetSecondAct.this.updaterMirrorAutoFold();
                    break;
                case 127:
                    YLInfoSetSecondAct.this.updaterReverTiltMirror();
                    break;
                case 128:
                    YLInfoSetSecondAct.this.updatereasyExitCar();
                    break;
                case 129:
                    YLInfoSetSecondAct.this.updaterAutoMemory();
                    break;
                case 163:
                    YLInfoSetSecondAct.this.updaterblindZoneAble();
                    break;
                case 165:
                    YLInfoSetSecondAct.this.updaterDriverStyleAble();
                    break;
                case 166:
                    YLInfoSetSecondAct.this.updaterAutoMemoryAble();
                    break;
                case 167:
                    YLInfoSetSecondAct.this.updatereasyExitCarAble();
                    break;
                case 168:
                    YLInfoSetSecondAct.this.updaterReverTiltMirrorAble();
                    break;
                case 169:
                    YLInfoSetSecondAct.this.updaterMirrorAutoFoldAble();
                    break;
                case 170:
                    YLInfoSetSecondAct.this.updaterautoWipersAble();
                    break;
                case 180:
                    YLInfoSetSecondAct.this.updaterRelockDoorAble();
                    break;
                case 181:
                    YLInfoSetSecondAct.this.updaternearCarUnlockAble();
                    break;
                case 182:
                    YLInfoSetSecondAct.this.updaterForgotKeyAble();
                    break;
                case 183:
                    YLInfoSetSecondAct.this.updaterleaveCarLockAble();
                    break;
                case 185:
                    YLInfoSetSecondAct.this.uCrashPrepare(DataCanbus.DATA[185]);
                    break;
                case 186:
                    YLInfoSetSecondAct.this.updaterAutoAnticrashPrepare();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_info_second_set);
        setUI();
    }

    private boolean IsRzcGl8() {
        return DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087 || DataCanbus.DATA[1000] == 393479;
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493) {
            findViewById(R.id.layout_view12).setVisibility(0);
            findViewById(R.id.layout_view13).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(0);
            findViewById(R.id.layout_view9).setVisibility(0);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_XP1_GM_Silverado_14_Hand /* 458777 */:
            case FinalCanbus.CAR_XP1_GM_Silverado_14_Auto /* 524313 */:
                findViewById(R.id.layout_view11).setVisibility(8);
                findViewById(R.id.layout_view15).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(8);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value13 = DataCanbus.DATA[123];
                if (value13 == 0) {
                    YLFunc.CAR_COMM_CONTROL(23, 2);
                } else if (value13 == 1) {
                    YLFunc.CAR_COMM_CONTROL(23, 0);
                } else if (value13 == 2) {
                    YLFunc.CAR_COMM_CONTROL(23, 1);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value14 = DataCanbus.DATA[123];
                if (value14 == 0) {
                    YLFunc.CAR_COMM_CONTROL(23, 1);
                } else if (value14 == 1) {
                    YLFunc.CAR_COMM_CONTROL(23, 2);
                } else if (value14 == 2) {
                    YLFunc.CAR_COMM_CONTROL(23, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493 || IsRzcGl8() || (DataCanbus.DATA[1000] & 65535) == 61) {
                    int value1 = DataCanbus.DATA[185] - 1;
                    if (value1 < 0) {
                        value1 = 2;
                    }
                    YLFunc.CAR_COMM_CONTROL(24, value1);
                } else {
                    int value2 = DataCanbus.DATA[185] + 1;
                    if (value2 == 4) {
                        value2 = 3;
                    }
                    YLFunc.CAR_COMM_CONTROL(25, value2 % 3);
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value3 = DataCanbus.DATA[185] + 1;
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493 || IsRzcGl8() || (DataCanbus.DATA[1000] & 65535) == 61) {
                    if (value3 > 2) {
                        value3 = 0;
                    }
                    YLFunc.CAR_COMM_CONTROL(24, value3);
                } else {
                    if (value3 == 4) {
                        value3 = 3;
                    }
                    YLFunc.CAR_COMM_CONTROL(25, value3 % 3);
                }
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value15 = DataCanbus.DATA[127] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                YLFunc.CAR_COMM_CONTROL(19, value15);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value16 = DataCanbus.DATA[127] + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                YLFunc.CAR_COMM_CONTROL(19, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                YLFunc.CAR_COMM_CONTROL(12, DataCanbus.DATA[117] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value4 = DataCanbus.DATA[120];
                YLFunc.CAR_COMM_CONTROL(15, value4 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value5 = DataCanbus.DATA[121];
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493 || IsRzcGl8() || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(26, value5 == 0 ? 1 : 0);
                } else {
                    YLFunc.CAR_COMM_CONTROL(24, value5 == 0 ? 1 : 0);
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value6 = DataCanbus.DATA[118];
                YLFunc.CAR_COMM_CONTROL(13, value6 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value7 = DataCanbus.DATA[119];
                YLFunc.CAR_COMM_CONTROL(14, value7 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value8 = DataCanbus.DATA[122];
                YLFunc.CAR_COMM_CONTROL(22, value8 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value9 = DataCanbus.DATA[124];
                YLFunc.CAR_COMM_CONTROL(16, value9 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value10 = DataCanbus.DATA[125];
                YLFunc.CAR_COMM_CONTROL(17, value10 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value11 = DataCanbus.DATA[126];
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493 || IsRzcGl8() || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(91, value11 == 0 ? 1 : 0);
                } else {
                    YLFunc.CAR_COMM_CONTROL(18, value11 == 0 ? 1 : 0);
                }
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value12 = DataCanbus.DATA[127];
                YLFunc.CAR_COMM_CONTROL(19, value12 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value17 = DataCanbus.DATA[128];
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493 || IsRzcGl8() || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(89, value17 == 0 ? 1 : 0);
                } else {
                    YLFunc.CAR_COMM_CONTROL(20, value17 == 0 ? 1 : 0);
                }
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value18 = DataCanbus.DATA[129];
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493 || IsRzcGl8() || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(88, value18 == 0 ? 1 : 0);
                } else {
                    YLFunc.CAR_COMM_CONTROL(21, value18 == 0 ? 1 : 0);
                }
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
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaternearCarUnlockAble() {
        int enable = DataCanbus.DATA[181];
        if (enable == 0) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterForgotKeyAble() {
        int enable = DataCanbus.DATA[182];
        if (enable == 0) {
            findViewById(R.id.layout_view2).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDriverStyleAble() {
        int enable = DataCanbus.DATA[165];
        if (enable == 0) {
            findViewById(R.id.layout_view3).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRelockDoorAble() {
        int enable = DataCanbus.DATA[180];
        if (enable == 0) {
            findViewById(R.id.layout_view4).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view4).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterautoWipersAble() {
        int enable = DataCanbus.DATA[170];
        if (enable == 0) {
            findViewById(R.id.layout_view5).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view5).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterblindZoneAble() {
        int enable = DataCanbus.DATA[163];
        if (enable == 0) {
            findViewById(R.id.layout_view6).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view6).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterleaveCarLockAble() {
        int enable = DataCanbus.DATA[123];
        if (IsRzcGl8()) {
            enable = DataCanbus.DATA[183];
        }
        if (enable == 0) {
            findViewById(R.id.layout_view7).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view7).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMirrorAutoFoldAble() {
        int enable = DataCanbus.DATA[126];
        if (enable == 0) {
            findViewById(R.id.layout_view10).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view10).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterReverTiltMirrorAble() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatereasyExitCarAble() {
        int enable = DataCanbus.DATA[167];
        if (enable == 0 || enable == 1) {
            findViewById(R.id.layout_view12).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493) {
            findViewById(R.id.layout_view12).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoMemoryAble() {
        int enable = DataCanbus.DATA[166];
        if (enable == 0 || enable == 1) {
            findViewById(R.id.layout_view13).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493) {
            findViewById(R.id.layout_view13).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoAnticrashPrepare() {
        int enable = DataCanbus.DATA[186];
        if (enable == 0) {
            findViewById(R.id.layout_view14).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view14).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaternearCarUnlock() {
        int switchOn = DataCanbus.DATA[117];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        }
    }

    protected void uCrashPrepare(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text5);
        if (v != null) {
            int s = R.string.off;
            if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493 || IsRzcGl8() || (DataCanbus.DATA[1000] & 65535) == 61) {
                if (val == 1) {
                    s = R.string.wc_weilang_auto_fangzhuang_warn;
                } else if (val == 2) {
                    s = R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong;
                }
            } else if (val == 1) {
                s = R.string.wc_weilang_auto_fangzhuang_warn;
            } else if (val == 3) {
                s = R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong;
            }
            v.setText(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterForgotKey() {
        int switchOn = DataCanbus.DATA[118];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDriverStyle() {
        int switchOn = DataCanbus.DATA[119];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRelockDoor() {
        int switchOn = DataCanbus.DATA[120];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterautoWipers() {
        int switchOn = DataCanbus.DATA[121];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterblindZone() {
        int switchOn = DataCanbus.DATA[122];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterleaveCarLock() {
        int switchOn = DataCanbus.DATA[123];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_onstar_close);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_yinglang_car_set_Second_str9);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_from_the_car_latch_Speaker_tweet_enabled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterhandTraffic() {
        int switchOn = DataCanbus.DATA[124];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_yinglang_car_set_Second_str2);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_yinglang_car_set_Second_str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateradaptiveForwardLight() {
        int switchOn = DataCanbus.DATA[125];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.xp_yinglang_car_set_Second_str5);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.xp_yinglang_car_set_Second_str6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMirrorAutoFold() {
        int switchOn = DataCanbus.DATA[126];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterReverTiltMirror() {
        int switchOn = DataCanbus.DATA[127];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_XP1_GM_Silverado_14_Hand /* 458777 */:
            case FinalCanbus.CAR_XP1_GM_Silverado_14_Auto /* 524313 */:
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.off);
                } else if (switchOn == 1) {
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.jeep_comfortsystems_2);
                } else if (switchOn == 2) {
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.wc_weilang_driver);
                } else if (switchOn == 3) {
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_sbd_x80_zuijiatingyinwei_1);
                }
                break;
            default:
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(switchOn != 0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatereasyExitCar() {
        int switchOn = DataCanbus.DATA[128];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoMemory() {
        int switchOn = DataCanbus.DATA[129];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(switchOn != 0);
    }
}
