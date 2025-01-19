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
import com.syu.module.canbus.Callback_0254_WC2_15YingLang;
import com.syu.module.canbus.Callback_0308_WC2_GM_WEILANG;
import com.syu.module.canbus.Callback_0345_WC2_ShuPingJunWei;
import com.syu.module.canbus.Callback_0357_WC2_MaiRuiBao16;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.module.main.DataMain;

public class KlcOnStarAct extends Activity {
    StringBuffer buffer;
    int hour;
    int minute;
    int second;
    int[] showints;
    public static boolean mIsFront = false;
    public static boolean isChannle = true;
    boolean IsIntentOn = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 148:
                    KlcOnStarAct.this.updateAnjixingState();
                    break;
                case 150:
                    KlcOnStarAct.this.updateAnjixingPhoneFlag();
                    break;
                case 151:
                    KlcOnStarAct.this.updateAnjixingPhoneHour();
                    break;
                case 152:
                    KlcOnStarAct.this.updateAnjixingPhoneMinute();
                    break;
                case 153:
                    KlcOnStarAct.this.updateAnjixingPhoneSecond();
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
    int OnStarState = -1;
    boolean IsChange = false;
    int OnCallFlag = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_klc_onstar);
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
            case R.id.callanswer /* 2131428629 */:
                if (this.OnStarState == 1) {
                    KlcFunc.C_CAR_ONSTAR_CMD(1, 0);
                    break;
                } else if ((this.OnStarState == 4 || this.OnStarState == 0) && ((TextView) findViewById(R.id.showInputTv)).getText().toString() != null) {
                    String callnum = ((TextView) findViewById(R.id.showInputTv)).getText().toString();
                    char[] vals = callnum.toCharArray();
                    this.showints = new int[vals.length];
                    for (int i = 0; i < vals.length; i++) {
                        this.showints[i] = vals[i];
                    }
                    KlcFunc.C_CAR_ONSTAR(this.showints);
                    KlcFunc.C_CAR_ONSTAR_CMD(1, 0);
                    break;
                }
            case R.id.callhang /* 2131428630 */:
                if (this.OnStarState == 1) {
                    KlcFunc.C_CAR_ONSTAR_CMD(2, 0);
                    break;
                } else if (this.OnStarState == 2) {
                    KlcFunc.C_CAR_ONSTAR_CMD(3, 0);
                    break;
                } else if (this.OnStarState == 3) {
                    KlcFunc.C_CAR_ONSTAR_CMD(3, 0);
                    break;
                } else if (this.OnStarState == 4) {
                    KlcFunc.C_CAR_ONSTAR_CMD(3, 0);
                    break;
                }
            case R.id.onStarDelete /* 2131430867 */:
                if (this.buffer != null && this.buffer.length() > 0) {
                    this.buffer.deleteCharAt(this.buffer.length() - 1);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                    break;
                }
            case R.id.btn1 /* 2131430868 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append(1);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 49);
                        break;
                    } else {
                        this.buffer.append(1);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.btn2 /* 2131430869 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append(2);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 50);
                        break;
                    } else {
                        this.buffer.append(2);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.btn3 /* 2131430870 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append(3);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 51);
                        break;
                    } else {
                        this.buffer.append(3);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.btn11 /* 2131430871 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append('*');
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 42);
                        break;
                    } else {
                        this.buffer.append('*');
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.btn4 /* 2131430872 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append(4);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 52);
                        break;
                    } else {
                        this.buffer.append(4);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.btn5 /* 2131430873 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append(5);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 53);
                        break;
                    } else {
                        this.buffer.append(5);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.btn6 /* 2131430874 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append(6);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 54);
                        break;
                    } else {
                        this.buffer.append(6);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.btn0 /* 2131430875 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append(0);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 48);
                        break;
                    } else {
                        this.buffer.append(0);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.btn7 /* 2131430876 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append(7);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 55);
                        break;
                    } else {
                        this.buffer.append(7);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.btn8 /* 2131430877 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append(8);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 56);
                        break;
                    } else {
                        this.buffer.append(8);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.btn9 /* 2131430878 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append(9);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 57);
                        break;
                    } else {
                        this.buffer.append(9);
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.btn10 /* 2131430879 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 3) {
                        this.buffer.append('#');
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        KlcFunc.C_CAR_ONSTAR_CMD(4, 35);
                        break;
                    } else {
                        this.buffer.append('#');
                        ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.Canclebt /* 2131430881 */:
                KlcFunc.C_CAR_BT(1, 0);
                break;
            case R.id.muteBt /* 2131430882 */:
                KlcFunc.C_CAR_ONSTAR_CMD(5, this.OnCallFlag == 0 ? 1 : 0);
                break;
            case R.id.deletebt /* 2131431910 */:
                KlcFunc.C_CAR_BT(2, 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        if (!this.IsIntentOn) {
            KlcFunc.SWITCH_MAIN_STATE(12);
            DataMain.PROXY.getI(0, 0);
        }
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
        mIsFront = false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            KlcFunc.SWITCH_MAIN_STATE(0);
            moveTaskToBack(true);
        } else if (keyCode != 3 || this.OnStarState != 0) {
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

    
    public void updateBtPassWord() {
        String str;
        int value = DataCanbus.DATA[1000];
        switch (value) {
            case 254:
                str = Callback_0254_WC2_15YingLang.btPassWord;
                break;
            case 308:
                str = Callback_0308_WC2_GM_WEILANG.btPassWord;
                break;
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
            case 357:
                str = Callback_0357_WC2_MaiRuiBao16.btPassWord;
                break;
            default:
                str = Callback_0036_WC2_GM.btPassWord;
                break;
        }
        if (str != null) {
            ((TextView) findViewById(R.id.btpassword)).setText("PWD:" + str);
        }
    }

    
    public void updateBtNumber() {
        String str;
        int value = DataCanbus.DATA[1000];
        switch (value) {
            case 254:
                str = Callback_0254_WC2_15YingLang.btNumber;
                break;
            case 308:
                str = Callback_0308_WC2_GM_WEILANG.btNumber;
                break;
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
            case 357:
                str = Callback_0357_WC2_MaiRuiBao16.btNumber;
                break;
            default:
                str = Callback_0036_WC2_GM.btNumber;
                break;
        }
        if (str != null) {
            ((TextView) findViewById(R.id.btphone)).setText(str);
        }
    }

    
    public void updateAnjixingState() {
        this.OnStarState = DataCanbus.DATA[148];
        if (this.OnStarState == 0 && this.IsChange && this.IsIntentOn) {
            KlcFunc.SWITCH_MAIN_STATE(0);
            moveTaskToBack(true);
            this.IsChange = false;
        }
        if (this.OnStarState == 0) {
            this.IsChange = false;
        } else if (this.OnStarState != 0) {
            this.IsChange = true;
        }
    }

    
    public void updateAnjixingPhoneFlag() {
        this.OnCallFlag = DataCanbus.DATA[150];
        if (this.OnCallFlag == 0) {
            ((Button) findViewById(R.id.muteBt)).setBackgroundResource(R.drawable.ic_klc_mute_n);
        } else if (this.OnCallFlag == 1) {
            ((Button) findViewById(R.id.muteBt)).setBackgroundResource(R.drawable.ic_klc_mute_p);
        }
    }

    
    public void updateAnjixingNumber() {
        String str = GmConstData.anjixingNumber;
        if (str != null) {
            ((TextView) findViewById(R.id.showOnstarNum)).setText("Call In:" + str);
        }
    }

    
    public void updateAnjixingPhoneHour() {
        this.hour = DataCanbus.DATA[151];
        ShowCallTime();
    }

    
    public void updateAnjixingPhoneMinute() {
        this.minute = DataCanbus.DATA[152];
        ShowCallTime();
    }

    
    public void updateAnjixingPhoneSecond() {
        this.second = DataCanbus.DATA[153];
        ShowCallTime();
    }

    private void ShowCallTime() {
        if (this.OnStarState == 3) {
            ((TextView) findViewById(R.id.onCallTimeTv)).setText(String.valueOf(this.hour) + ":" + this.minute + ":" + this.second);
        }
    }
}
