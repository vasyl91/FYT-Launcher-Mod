package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLOnStarAct extends Activity {
    StringBuffer buffer;
    int[] showints;
    public static boolean mIsFront = false;
    public static boolean isChannle = true;
    boolean IsIntentOn = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLOnStarAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 18:
                    YLOnStarAct.this.updaterOnStarNum();
                    break;
                case 19:
                    YLOnStarAct.this.updaterOnStarState();
                    break;
            }
        }
    };
    int OnStarState = -1;
    boolean IsChange = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_onstar);
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
            case R.id.xp_yl_onStarDelete /* 2131433570 */:
                if (this.buffer != null && this.buffer.length() > 0) {
                    this.buffer.deleteCharAt(this.buffer.length() - 1);
                    ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                    break;
                }
            case R.id.xp_yl_btn1 /* 2131433571 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(1);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(129);
                        break;
                    } else {
                        this.buffer.append(1);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_btn2 /* 2131433572 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(2);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(130);
                        break;
                    } else {
                        this.buffer.append(2);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_btn3 /* 2131433573 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(3);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(131);
                        break;
                    } else {
                        this.buffer.append(3);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_btn11 /* 2131433574 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append('*');
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(138);
                        break;
                    } else {
                        this.buffer.append('*');
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_btn4 /* 2131433575 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(4);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(132);
                        break;
                    } else {
                        this.buffer.append(4);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_btn5 /* 2131433576 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(5);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(133);
                        break;
                    } else {
                        this.buffer.append(5);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_btn6 /* 2131433577 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(6);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(134);
                        break;
                    } else {
                        this.buffer.append(6);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_btn0 /* 2131433578 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(0);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(128);
                        break;
                    } else {
                        this.buffer.append(0);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_btn7 /* 2131433579 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(7);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(135);
                        break;
                    } else {
                        this.buffer.append(7);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_btn8 /* 2131433580 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(8);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(136);
                        break;
                    } else {
                        this.buffer.append(8);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_btn9 /* 2131433581 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append(9);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(137);
                        break;
                    } else {
                        this.buffer.append(9);
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_btn10 /* 2131433582 */:
                if (this.buffer != null) {
                    if (this.OnStarState == 4) {
                        this.buffer.append('#');
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(139);
                        break;
                    } else {
                        this.buffer.append('#');
                        ((TextView) findViewById(R.id.xp_yl_showInputTv)).setText(this.buffer.toString());
                        break;
                    }
                }
                break;
            case R.id.xp_yl_callanswer /* 2131433583 */:
                if (this.OnStarState == 2) {
                    YLFunc.CAR_ON_START_CTL(2);
                    break;
                } else if ((this.OnStarState == 0 || this.OnStarState == 1) && ((TextView) findViewById(R.id.xp_yl_showInputTv)).getText().toString() != null) {
                    String callnum = ((TextView) findViewById(R.id.xp_yl_showInputTv)).getText().toString();
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
                    YLFunc.CAR_ON_START_CALL(this.showints);
                    break;
                }
            case R.id.xp_yl_callhang /* 2131433584 */:
                if (this.OnStarState == 1) {
                    YLFunc.CAR_ON_START_CTL(3);
                    break;
                } else if (this.OnStarState == 2) {
                    YLFunc.CAR_ON_START_CTL(3);
                    break;
                } else if (this.OnStarState == 3) {
                    YLFunc.CAR_ON_START_CTL(3);
                    break;
                } else if (this.OnStarState == 4) {
                    YLFunc.CAR_ON_START_CTL(3);
                    break;
                }
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        if (!this.IsIntentOn) {
            YLFunc.SWITCH_MAIN_STATE(12);
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
            YLFunc.SWITCH_MAIN_STATE(0);
            moveTaskToBack(true);
        }
        return true;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOnStarState() {
        this.OnStarState = DataCanbus.DATA[19];
        if (this.OnStarState == 0 && this.IsChange && this.IsIntentOn) {
            YLFunc.SWITCH_MAIN_STATE(0);
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
            ((TextView) findViewById(R.id.xp_yl_showOnstarNum)).setText("Call In:" + str);
        }
    }
}