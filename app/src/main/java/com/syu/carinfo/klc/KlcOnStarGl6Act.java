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
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KlcOnStarGl6Act extends Activity {
    StringBuffer buffer;
    int hour;
    int minute;
    int second;
    int[] showints;
    public static boolean mIsFront = false;
    public static boolean isChannle = true;
    boolean IsIntentOn = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcOnStarGl6Act.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 51:
                    KlcOnStarGl6Act.this.updateAnjixingState();
                    break;
                case 53:
                    KlcOnStarGl6Act.this.updateAnjixingPhoneFlag();
                    break;
                case 54:
                    KlcOnStarGl6Act.this.updateAnjixingPhoneHour();
                    break;
                case 55:
                    KlcOnStarGl6Act.this.updateAnjixingPhoneMinute();
                    break;
                case 56:
                    KlcOnStarGl6Act.this.updateAnjixingPhoneSecond();
                    break;
                case 62:
                    KlcOnStarGl6Act.this.updateAnjixingNumber();
                    break;
                case 139:
                    KlcOnStarGl6Act.this.updateOnStarTTS();
                    break;
                case 141:
                    KlcOnStarGl6Act.this.updateOnStarPhoneNumber();
                    break;
            }
        }
    };
    int OnStarState = -1;
    boolean IsChange = false;
    int OnCallFlag = -1;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_onstar_gl6);
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
            case R.id.callanswer /* 2131428621 */:
                if (this.OnStarState == 1) {
                    KlcFunc.C_CAR_ONSTAR_CMD(1, 0);
                    break;
                } else if (this.OnStarState == 4 || this.OnStarState == 0) {
                    if (((TextView) findViewById(R.id.showInputTv)).getText().toString().length() > 0) {
                        String callnum = ((TextView) findViewById(R.id.showInputTv)).getText().toString();
                        char[] vals = callnum.toCharArray();
                        this.showints = new int[vals.length];
                        for (int i = 0; i < vals.length; i++) {
                            this.showints[i] = vals[i];
                        }
                        KlcFunc.C_CAR_ONSTAR(this.showints);
                        KlcFunc.C_CAR_ONSTAR_CMD(1, 0);
                        break;
                    } else {
                        KlcFunc.C_CAR_ONSTAR_CMD(7, 0);
                        break;
                    }
                }
                break;
            case R.id.callhang /* 2131428622 */:
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
            case R.id.onStarDelete /* 2131430891 */:
                if (this.buffer != null && this.buffer.length() > 0) {
                    this.buffer.deleteCharAt(this.buffer.length() - 1);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                    break;
                }
            case R.id.btn1 /* 2131430892 */:
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
            case R.id.btn2 /* 2131430893 */:
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
            case R.id.btn3 /* 2131430894 */:
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
            case R.id.btn11 /* 2131430895 */:
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
            case R.id.btn4 /* 2131430896 */:
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
            case R.id.btn5 /* 2131430897 */:
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
            case R.id.btn6 /* 2131430898 */:
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
            case R.id.btn0 /* 2131430899 */:
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
            case R.id.btn7 /* 2131430900 */:
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
            case R.id.btn8 /* 2131430901 */:
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
            case R.id.btn9 /* 2131430902 */:
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
            case R.id.btn10 /* 2131430903 */:
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
            case R.id.Canclebt /* 2131430905 */:
                KlcFunc.C_CAR_BT(1, 0);
                break;
            case R.id.muteBt /* 2131430906 */:
                KlcFunc.C_CAR_ONSTAR_CMD(5, this.OnCallFlag == 0 ? 1 : 0);
                break;
            case R.id.deletebt /* 2131431960 */:
                KlcFunc.C_CAR_BT(2, 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        KlcFunc.C_CAR_ONSTAR_CMD(8, 1);
        mIsFront = true;
        if (!this.IsIntentOn) {
            KlcFunc.SWITCH_MAIN_STATE(12);
        }
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        KlcFunc.C_CAR_ONSTAR_CMD(3, 0);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        KlcFunc.C_CAR_ONSTAR_CMD(8, 0);
        super.onPause();
        removeUpdater();
        mIsFront = false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            KlcFunc.SWITCH_MAIN_STATE(0);
            moveTaskToBack(true);
        }
        return true;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOnStarPhoneNumber() {
        if (Callback_0036_WC2_GM.onStarPhoneNumber != null) {
            ((TextView) findViewById(R.id.btphone_number)).setText("Local:" + Callback_0036_WC2_GM.onStarPhoneNumber);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOnStarTTS() {
        if (Callback_0036_WC2_GM.onStarTTS != null) {
            if (DataCanbus.DATA[140] == 1) {
                ((TextView) findViewById(R.id.btphone_tts)).setText("TTS:" + Callback_0036_WC2_GM.onStarTTS);
            } else {
                ((TextView) findViewById(R.id.btphone_tts)).setText("TTS:");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAnjixingState() {
        this.OnStarState = DataCanbus.DATA[51];
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
        if (this.OnStarState == 0) {
            ((TextView) findViewById(R.id.btpassword)).setText(R.string.klc_onstar_close);
            return;
        }
        if (this.OnStarState == 1) {
            ((TextView) findViewById(R.id.btpassword)).setText(R.string.klc_onstar_on_call);
            return;
        }
        if (this.OnStarState == 2) {
            ((TextView) findViewById(R.id.btpassword)).setText(R.string.klc_onstar_going_out);
            return;
        }
        if (this.OnStarState == 3) {
            ((TextView) findViewById(R.id.btpassword)).setText(R.string.klc_onstar_Connected);
        } else if (this.OnStarState == 4) {
            ((TextView) findViewById(R.id.btpassword)).setText(R.string.klc_onstar_free);
        } else {
            ((TextView) findViewById(R.id.btpassword)).setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAnjixingPhoneFlag() {
        this.OnCallFlag = DataCanbus.DATA[53];
        if (this.OnCallFlag == 0) {
            ((Button) findViewById(R.id.muteBt)).setBackgroundResource(R.drawable.ic_klc_mute_n);
        } else if (this.OnCallFlag == 1) {
            ((Button) findViewById(R.id.muteBt)).setBackgroundResource(R.drawable.ic_klc_mute_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAnjixingNumber() {
        String str = GmConstData.anjixingNumber;
        if (str != null) {
            ((TextView) findViewById(R.id.showOnstarNum)).setText("Call In:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAnjixingPhoneHour() {
        this.hour = DataCanbus.DATA[54];
        ShowCallTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAnjixingPhoneMinute() {
        this.minute = DataCanbus.DATA[55];
        ShowCallTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAnjixingPhoneSecond() {
        this.second = DataCanbus.DATA[56];
        ShowCallTime();
    }

    private void ShowCallTime() {
        if (this.OnStarState == 3) {
            ((TextView) findViewById(R.id.onCallTimeTv)).setText(String.valueOf(this.hour) + ":" + this.minute + ":" + this.second);
        }
    }
}