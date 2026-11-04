package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0036_WC2_GM;
import com.syu.module.canbus.Callback_0345_WC2_ShuPingJunWei;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.module.main.DataMain;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class KlcOnStarAct extends Activity {
    StringBuffer buffer;
    int[] showints;
    public static boolean mIsFront = false;
    public static boolean isChannle = true;
    boolean IsIntentOn = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcOnStarAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 148:
                    KlcOnStarAct.this.updateAnjixingState();
                    break;
                case 150:
                    KlcOnStarAct.this.updateAnjixingPhoneFlag();
                    break;
                case 151:
                case 152:
                case 153:
                    KlcOnStarAct.this.ShowCallTime();
                    break;
                case 159:
                    KlcOnStarAct.this.updateAnjixingNumber();
                    break;
                case 160:
                    KlcOnStarAct.this.updateBtPassWord();
                    break;
                case 161:
                    KlcOnStarAct.this.updateBtNumber();
                    break;
            }
        }
    };
    boolean IsChange = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_onstar);
        init();
        setUI();
    }

    private void init() {
        if (getIntent().getStringExtra("onstar") != null && getIntent().getStringExtra("onstar").equals("on")) {
            this.IsIntentOn = true;
        } else {
            this.IsIntentOn = false;
        }
        this.buffer = new StringBuffer();
    }

    private void setUI() {
    }

    public void onExtraClik(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_plus1 /* 2131427419 */:
                if (this.buffer != null && this.buffer.length() > 0) {
                    this.buffer.deleteCharAt(this.buffer.length() - 1);
                    ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    break;
                }
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append(1);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 49);
                    } else {
                        this.buffer.append(1);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append(2);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 50);
                    } else {
                        this.buffer.append(2);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append(3);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 51);
                    } else {
                        this.buffer.append(3);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append('*');
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 42);
                    } else {
                        this.buffer.append('*');
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append(4);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 52);
                    } else {
                        this.buffer.append(4);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append(5);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 53);
                    } else {
                        this.buffer.append(5);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append(6);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 54);
                    } else {
                        this.buffer.append(6);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append(0);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 48);
                    } else {
                        this.buffer.append(0);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append(7);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 55);
                    } else {
                        this.buffer.append(7);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append(8);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 56);
                    } else {
                        this.buffer.append(8);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append(9);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 57);
                    } else {
                        this.buffer.append(9);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[148] == 3) {
                        this.buffer.append('#');
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 35);
                    } else {
                        this.buffer.append('#');
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus15 /* 2131427439 */:
                if (DataCanbus.DATA[148] == 1) {
                    KlcFunc.C_CAR_ONSTAR_CMD(2, 0);
                } else if (DataCanbus.DATA[148] == 2) {
                    KlcFunc.C_CAR_ONSTAR_CMD(3, 0);
                } else if (DataCanbus.DATA[148] == 3) {
                    KlcFunc.C_CAR_ONSTAR_CMD(3, 0);
                } else if (DataCanbus.DATA[148] == 4) {
                    KlcFunc.C_CAR_ONSTAR_CMD(3, 0);
                }
                break;
            case R.id.btn_plus16 /* 2131427440 */:
                KlcFunc.C_CAR_BT(1, 0);
                break;
            case R.id.btn_plus17 /* 2131427500 */:
                KlcFunc.C_CAR_BT(2, 0);
                break;
            case R.id.btn_plus18 /* 2131427503 */:
                KlcFunc.C_CAR_ONSTAR_CMD(5, DataCanbus.DATA[150] == 0 ? 1 : 0);
                break;
            case R.id.callanswer /* 2131428632 */:
                if (DataCanbus.DATA[148] == 1) {
                    KlcFunc.C_CAR_ONSTAR_CMD(1, 0);
                } else if ((DataCanbus.DATA[148] == 4 || DataCanbus.DATA[148] == 0) && ((TextView) findViewById(R.id.tv_text2)).getText().toString() != null) {
                    String callnum = ((TextView) findViewById(R.id.tv_text2)).getText().toString();
                    char[] vals = callnum.toCharArray();
                    this.showints = new int[vals.length];
                    for (int i = 0; i < vals.length; i++) {
                        this.showints[i] = vals[i];
                    }
                    KlcFunc.C_CAR_ONSTAR(this.showints);
                    KlcFunc.C_CAR_ONSTAR_CMD(1, 0);
                }
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        if (!this.IsIntentOn) {
            KlcFunc.SWITCH_MAIN_STATE(12);
            DataMain.PROXY.getI(0, 0);
        }
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
        mIsFront = false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            KlcFunc.SWITCH_MAIN_STATE(0);
            moveTaskToBack(true);
            KlcFunc.C_CAR_ONSTAR_CMD(8, 0);
        } else if (keyCode == 3) {
            KlcFunc.C_CAR_ONSTAR_CMD(8, 0);
        }
        return true;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtPassWord() {
        String str;
        int value = DataCanbus.DATA[1000];
        switch (value) {
            case 345:
            case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
            case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                str = Callback_0345_WC2_ShuPingJunWei.btPassWord;
                break;
            default:
                str = Callback_0036_WC2_GM.btPassWord;
                break;
        }
        if (str != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText("PWD:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtNumber() {
        String str;
        int value = DataCanbus.DATA[1000];
        switch (value) {
            case 345:
            case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
            case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                str = Callback_0345_WC2_ShuPingJunWei.btNumber;
                break;
            default:
                str = Callback_0036_WC2_GM.btNumber;
                break;
        }
        if (str != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAnjixingState() {
        if (DataCanbus.DATA[148] == 0 && this.IsChange && this.IsIntentOn) {
            KlcFunc.SWITCH_MAIN_STATE(0);
            moveTaskToBack(true);
            this.IsChange = false;
        }
        if (DataCanbus.DATA[148] == 0) {
            this.IsChange = false;
        } else if (DataCanbus.DATA[148] != 0) {
            this.IsChange = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAnjixingPhoneFlag() {
        if (DataCanbus.DATA[150] == 0) {
            ((Button) findViewById(R.id.btn_plus18)).setBackgroundResource(R.drawable.ic_klc_mute_n);
        } else if (DataCanbus.DATA[150] == 1) {
            ((Button) findViewById(R.id.btn_plus18)).setBackgroundResource(R.drawable.ic_klc_mute_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAnjixingNumber() {
        String str = GmConstData.anjixingNumber;
        if (str != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText("Call In:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ShowCallTime() {
        int hour = DataCanbus.DATA[151];
        int min = DataCanbus.DATA[152];
        int sec = DataCanbus.DATA[153];
        if (DataCanbus.DATA[148] == 3) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10) + ":" + (sec / 10) + (sec % 10));
        }
    }
}
