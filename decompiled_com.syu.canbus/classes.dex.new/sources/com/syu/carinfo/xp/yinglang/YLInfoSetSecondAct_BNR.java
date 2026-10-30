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
public class YLInfoSetSecondAct_BNR extends Activity implements View.OnClickListener {
    int[] ids = {185, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetSecondAct_BNR.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            YLInfoSetSecondAct_BNR.this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 117:
                    YLInfoSetSecondAct_BNR.this.updaternearCarUnlock();
                    break;
                case 118:
                    YLInfoSetSecondAct_BNR.this.updaterForgotKey();
                    break;
                case 119:
                    YLInfoSetSecondAct_BNR.this.updaterDriverStyle();
                    break;
                case 120:
                    YLInfoSetSecondAct_BNR.this.updaterRelockDoor();
                    break;
                case 121:
                    YLInfoSetSecondAct_BNR.this.updaterautoWipers();
                    break;
                case 122:
                    YLInfoSetSecondAct_BNR.this.updaterblindZone();
                    break;
                case 123:
                    YLInfoSetSecondAct_BNR.this.updaterleaveCarLock();
                    break;
                case 124:
                    YLInfoSetSecondAct_BNR.this.updaterhandTraffic();
                    break;
                case 125:
                    YLInfoSetSecondAct_BNR.this.updateradaptiveForwardLight();
                    break;
                case 126:
                    YLInfoSetSecondAct_BNR.this.updaterMirrorAutoFold();
                    break;
                case 127:
                    YLInfoSetSecondAct_BNR.this.updaterReverTiltMirror();
                    break;
                case 128:
                    YLInfoSetSecondAct_BNR.this.updatereasyExitCar();
                    break;
                case 129:
                    YLInfoSetSecondAct_BNR.this.updaterAutoMemory();
                    break;
                case 185:
                    YLInfoSetSecondAct_BNR.this.uCrashPrepare(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 189:
                    YLInfoSetSecondAct_BNR.this.uRampStartAssist(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 190:
                    YLInfoSetSecondAct_BNR.this.uRemoteDoorWindow(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 191:
                    YLInfoSetSecondAct_BNR.this.uCarState(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 192:
                    YLInfoSetSecondAct_BNR.this.uRemoteAirPower(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 193:
                    YLInfoSetSecondAct_BNR.this.uRemoteRearAirPower(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 194:
                    YLInfoSetSecondAct_BNR.this.uRemoteRearDefrog(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 195:
                    YLInfoSetSecondAct_BNR.this.uAcc(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 196:
                    YLInfoSetSecondAct_BNR.this.uRearSeat(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 197:
                    YLInfoSetSecondAct_BNR.this.uCrashType(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 198:
                    YLInfoSetSecondAct_BNR.this.uWalker(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 199:
                    YLInfoSetSecondAct_BNR.this.uChangeLane(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 200:
                    YLInfoSetSecondAct_BNR.this.uEasyExit(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 201:
                    YLInfoSetSecondAct_BNR.this.uRearCarPass(YLInfoSetSecondAct_BNR.this.value);
                    break;
            }
        }
    };
    int value;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_info_second_set_bnr);
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        findViewById(R.id.layout_view18).setOnClickListener(this);
        findViewById(R.id.layout_view19).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
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
            case R.id.btn_plus2 /* 2131427461 */:
                int value1 = DataCanbus.DATA[185] + 1;
                if (value1 == 4) {
                    value1 = 3;
                }
                YLFunc.CAR_COMM_CONTROL(25, value1 % 3);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
            case R.id.btn_plus3 /* 2131427464 */:
                int value2 = DataCanbus.DATA[189];
                YLFunc.CAR_COMM_CONTROL(28, value2 == 0 ? 1 : 0);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
            case R.id.btn_plus4 /* 2131427467 */:
                int value3 = DataCanbus.DATA[198] + 1;
                YLFunc.CAR_COMM_CONTROL(99, value3 % 3);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value4 = DataCanbus.DATA[117];
                YLFunc.CAR_COMM_CONTROL(12, value4 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value5 = DataCanbus.DATA[120];
                YLFunc.CAR_COMM_CONTROL(15, value5 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value6 = DataCanbus.DATA[121];
                YLFunc.CAR_COMM_CONTROL(24, value6 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value7 = DataCanbus.DATA[118];
                YLFunc.CAR_COMM_CONTROL(13, value7 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value8 = DataCanbus.DATA[119];
                YLFunc.CAR_COMM_CONTROL(14, value8 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value9 = DataCanbus.DATA[122];
                YLFunc.CAR_COMM_CONTROL(22, value9 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value10 = DataCanbus.DATA[124];
                YLFunc.CAR_COMM_CONTROL(16, value10 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value11 = DataCanbus.DATA[125];
                YLFunc.CAR_COMM_CONTROL(17, value11 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value12 = DataCanbus.DATA[126];
                YLFunc.CAR_COMM_CONTROL(18, value12 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value15 = DataCanbus.DATA[127];
                YLFunc.CAR_COMM_CONTROL(19, value15 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value16 = DataCanbus.DATA[128];
                YLFunc.CAR_COMM_CONTROL(20, value16 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value17 = DataCanbus.DATA[129];
                YLFunc.CAR_COMM_CONTROL(21, value17 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value18 = DataCanbus.DATA[190];
                YLFunc.CAR_COMM_CONTROL(27, value18 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value19 = DataCanbus.DATA[191];
                YLFunc.CAR_COMM_CONTROL(26, value19 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value20 = DataCanbus.DATA[194];
                YLFunc.CAR_AIR_CONTROL(98, value20 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                int value21 = DataCanbus.DATA[195];
                YLFunc.CAR_COMM_CONTROL(96, value21 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int value22 = DataCanbus.DATA[196];
                YLFunc.CAR_COMM_CONTROL(97, value22 == 0 ? 1 : 0);
                break;
            case R.id.layout_view18 /* 2131427755 */:
                int value23 = DataCanbus.DATA[192];
                YLFunc.CAR_AIR_CONTROL(96, value23 == 0 ? 1 : 0);
                break;
            case R.id.layout_view19 /* 2131427756 */:
                int value24 = DataCanbus.DATA[193] + 1;
                YLFunc.CAR_AIR_CONTROL(97, value24 % 3);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int value25 = DataCanbus.DATA[197];
                YLFunc.CAR_COMM_CONTROL(98, value25 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int value26 = DataCanbus.DATA[199];
                YLFunc.CAR_COMM_CONTROL(100, value26 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int value27 = DataCanbus.DATA[201];
                YLFunc.CAR_COMM_CONTROL(102, value27 == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
        if (DataCanbus.DATA[1000] == 2294139) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(8);
            findViewById(R.id.layout_view13).setVisibility(8);
            findViewById(R.id.layout_view14).setVisibility(8);
            findViewById(R.id.layout_view15).setVisibility(8);
            findViewById(R.id.layout_view17).setVisibility(8);
            findViewById(R.id.layout_view18).setVisibility(8);
            findViewById(R.id.layout_view19).setVisibility(8);
            findViewById(R.id.layout_view20).setVisibility(8);
            findViewById(R.id.layout_view21).setVisibility(8);
            findViewById(R.id.layout_view22).setVisibility(8);
            findViewById(R.id.layout_view23).setVisibility(8);
            findViewById(R.id.layout_view24).setVisibility(8);
            findViewById(R.id.layout_view25).setVisibility(8);
        }
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
        for (int i = 0; i < this.ids.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.ids[i]].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        for (int i = 0; i < this.ids.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.ids[i]].removeNotify(this.mNotifyCanbus);
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

    protected void uRearCarPass(int val) {
        setcheck((CheckedTextView) findViewById(R.id.ctv_checkedtext20), val != 0);
    }

    protected void uEasyExit(int val) {
        setcheck((CheckedTextView) findViewById(R.id.ctv_checkedtext11), val != 0);
    }

    protected void uChangeLane(int val) {
        setcheck((CheckedTextView) findViewById(R.id.ctv_checkedtext19), val != 0);
    }

    protected void uWalker(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text9);
        if (v != null) {
            int id = R.string.off;
            if (val == 1) {
                id = R.string.wc_weilang_auto_fangzhuang_warn;
            } else if (val == 2) {
                id = R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong;
            }
            v.setText(id);
        }
    }

    protected void uCrashType(int val) {
        setcheck((CheckedTextView) findViewById(R.id.ctv_checkedtext18), val != 0);
        TextView v = (TextView) findViewById(R.id.tv_text8);
        if (v != null) {
            v.setText(val == 0 ? R.string.str_379_str_2 : R.string.str_379_str_3);
        }
    }

    protected void uRearSeat(int val) {
        setcheck((CheckedTextView) findViewById(R.id.ctv_checkedtext17), val != 0);
    }

    protected void uAcc(int val) {
        setcheck((CheckedTextView) findViewById(R.id.ctv_checkedtext16), val != 0);
    }

    protected void uRemoteRearDefrog(int val) {
        setcheck((CheckedTextView) findViewById(R.id.ctv_checkedtext15), val == 1);
    }

    private void setcheck(CheckedTextView v, boolean on) {
        if (v != null) {
            v.setChecked(on);
        }
    }

    protected void uRemoteAirPower(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text7);
        if (v != null) {
            v.setText(val == 0 ? R.string.klc_air_auto : R.string.klc_air_last_set);
        }
    }

    protected void uRemoteRearAirPower(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text18);
        if (v != null) {
            int id = R.string.str_rzc_17gl8_str1;
            if (val == 1) {
                id = R.string.str_rzc_17gl8_str2;
            } else if (val == 2) {
                id = R.string.str_rzc_17gl8_str3;
            }
            v.setText(id);
        }
    }

    protected void uCarState(int val) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext14)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked(val != 0);
        }
    }

    protected void uRemoteDoorWindow(int val) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(val != 0);
        }
    }

    protected void uRampStartAssist(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text6);
        if (v != null) {
            v.setText(val == 0 ? R.string.xp_yl_lane_assist_str2 : R.string.xp_yl_lane_assist_str1);
        }
    }

    protected void uCrashPrepare(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text5);
        if (v != null) {
            int s = R.string.off;
            if (val == 1) {
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(switchOn != 0);
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
