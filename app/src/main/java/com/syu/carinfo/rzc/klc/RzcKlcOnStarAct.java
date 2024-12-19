package com.syu.carinfo.rzc.klc;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.klc.KlcFunc;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcKlcOnStarAct extends BaseActivity {
    Button BtnMute;
    StringBuffer buffer;
    TextView showInputTv;
    TextView showOnstarNumTv;
    int[] showints;
    public static boolean mIsFront = false;
    public static boolean isChannle = true;
    boolean IsIntentOn = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RzcKlcOnStarAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 7471556) {
                switch (updateCode) {
                    case 31:
                        RzcKlcOnStarAct.this.updaterOnStarNum();
                        break;
                    case 32:
                        RzcKlcOnStarAct.this.updaterOnStarState();
                        break;
                }
            }
            switch (updateCode) {
                case 20:
                    RzcKlcOnStarAct.this.updaterOnStarNum();
                    break;
                case 21:
                    RzcKlcOnStarAct.this.updaterOnStarState();
                    break;
            }
        }
    };
    int OnStarState = -1;
    boolean IsChange = false;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_klc_onstar_set);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (getIntent().getStringExtra("onstar") != null && getIntent().getStringExtra("onstar").equals("on")) {
            this.IsIntentOn = true;
        } else {
            this.IsIntentOn = false;
        }
        this.buffer = new StringBuffer();
        this.showInputTv = (TextView) findViewById(R.id.rzc_showInputTv);
        this.showOnstarNumTv = (TextView) findViewById(R.id.rzc_showOnstarNum);
    }

    private void setUI() {
    }

    public void onExtraClik(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.rzc_onStarDelete /* 2131432759 */:
                if (this.buffer != null && this.buffer.length() > 0) {
                    this.buffer.deleteCharAt(this.buffer.length() - 1);
                    this.showInputTv.setText(this.buffer.toString());
                    break;
                }
            case R.id.rzc_btn1 /* 2131432760 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(1);
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(129);
                        break;
                    } else {
                        this.buffer.append(1);
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_btn2 /* 2131432761 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(2);
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(130);
                        break;
                    } else {
                        this.buffer.append(2);
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_btn3 /* 2131432762 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(3);
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(131);
                        break;
                    } else {
                        this.buffer.append(3);
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_btn11 /* 2131432763 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append('*');
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(138);
                        break;
                    } else {
                        this.buffer.append('*');
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_btn4 /* 2131432764 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(4);
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(132);
                        break;
                    } else {
                        this.buffer.append(4);
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_btn5 /* 2131432765 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(5);
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(133);
                        break;
                    } else {
                        this.buffer.append(5);
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_btn6 /* 2131432766 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(6);
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(134);
                        break;
                    } else {
                        this.buffer.append(6);
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_btn0 /* 2131432767 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(0);
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(128);
                        break;
                    } else {
                        this.buffer.append(0);
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_btn7 /* 2131432768 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(7);
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(135);
                        break;
                    } else {
                        this.buffer.append(7);
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_btn8 /* 2131432769 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(8);
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(136);
                        break;
                    } else {
                        this.buffer.append(8);
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_btn9 /* 2131432770 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(9);
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(137);
                        break;
                    } else {
                        this.buffer.append(9);
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_btn10 /* 2131432771 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append('#');
                        this.showInputTv.setText(this.buffer.toString());
                        RzcKlcFunc.CAR_ON_START_CTL(139);
                        break;
                    } else {
                        this.buffer.append('#');
                        this.showInputTv.setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.rzc_callanswer /* 2131432772 */:
                if (this.OnStarState == 2) {
                    RzcKlcFunc.CAR_ON_START_CTL(2);
                    break;
                } else if ((this.OnStarState == 0 || this.OnStarState == 1) && this.showInputTv.getText().toString() != null) {
                    String callnum = this.showInputTv.getText().toString();
                    char[] vals = callnum.toCharArray();
                    int dataNum = (vals.length / 2) + 1;
                    this.showints = new int[dataNum];
                    for (int i = 0; i < vals.length; i++) {
                        if (vals[i] == '*') {
                            vals[i] = ':';
                        } else if (vals[i] == '#') {
                            vals[i] = ';';
                        }
                    }
                    for (int i2 = 0; i2 < dataNum; i2++) {
                        int j = i2 * 2;
                        if (j + 1 < vals.length) {
                            this.showints[i2] = (((vals[j] - '0') & 255) << 4) | ((vals[j + 1] - '0') & 255);
                        }
                        if (vals.length % 2 == 0) {
                            this.showints[dataNum - 1] = 240;
                        } else if (vals.length % 2 == 1) {
                            this.showints[dataNum - 1] = (((vals[vals.length - 1] - '0') & 255) << 4) | 15;
                        }
                    }
                    RzcKlcFunc.CAR_ON_START_CALL(this.showints);
                    break;
                }
            case R.id.rzc_callhang /* 2131432773 */:
                if (this.OnStarState == 1) {
                    RzcKlcFunc.CAR_ON_START_CTL(3);
                    break;
                } else if (this.OnStarState == 2) {
                    RzcKlcFunc.CAR_ON_START_CTL(3);
                    break;
                } else if (this.OnStarState == 3) {
                    RzcKlcFunc.CAR_ON_START_CTL(3);
                    break;
                } else if (this.OnStarState == 4) {
                    RzcKlcFunc.CAR_ON_START_CTL(3);
                    break;
                }
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        if (!this.IsIntentOn) {
            KlcFunc.SWITCH_MAIN_STATE(12);
        }
        addUpdater();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            KlcFunc.SWITCH_MAIN_STATE(0);
            moveTaskToBack(true);
        }
        return true;
    }

    private void addUpdater() {
        if (DataCanbus.DATA[1000] == 7471556) {
            DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        } else {
            DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        if (DataCanbus.DATA[1000] == 7471556) {
            DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        } else {
            DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOnStarState() {
        this.OnStarState = DataCanbus.DATA[21];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOnStarNum() {
        String str = GmConstData.anjixingNumber;
        if (str != null) {
            this.showOnstarNumTv.setText("Call In:" + str);
        }
    }
}
