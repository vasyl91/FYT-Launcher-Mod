package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
                case 115:
                    YLOnStarAct.this.updaterOnStarNum();
                    break;
                case 116:
                    YLOnStarAct.this.updaterOnStarState();
                    break;
            }
        }
    };
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
            case R.id.btn_plus1 /* 2131427458 */:
                if (this.buffer != null && this.buffer.length() > 0) {
                    this.buffer.deleteCharAt(this.buffer.length() - 1);
                    ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    break;
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append(1);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(129);
                    } else {
                        this.buffer.append(1);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append(2);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(130);
                    } else {
                        this.buffer.append(2);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append(3);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(131);
                    } else {
                        this.buffer.append(3);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append('*');
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(138);
                    } else {
                        this.buffer.append('*');
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append(4);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(132);
                    } else {
                        this.buffer.append(4);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append(5);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(133);
                    } else {
                        this.buffer.append(5);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append(6);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(134);
                    } else {
                        this.buffer.append(6);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append(0);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(128);
                    } else {
                        this.buffer.append(0);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append(7);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(135);
                    } else {
                        this.buffer.append(7);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append(8);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(136);
                    } else {
                        this.buffer.append(8);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append(9);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(137);
                    } else {
                        this.buffer.append(9);
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                if (this.buffer != null) {
                    if (DataCanbus.DATA[116] == 4) {
                        this.buffer.append('#');
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                        YLFunc.CAR_ON_START_CTL(139);
                    } else {
                        this.buffer.append('#');
                        ((TextView) findViewById(R.id.tv_text2)).setText(this.buffer.toString());
                    }
                }
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                if (DataCanbus.DATA[116] == 2) {
                    YLFunc.CAR_ON_START_CTL(2);
                } else if ((DataCanbus.DATA[116] == 0 || DataCanbus.DATA[116] == 1) && ((TextView) findViewById(R.id.tv_text2)).getText().toString() != null) {
                    String callnum = ((TextView) findViewById(R.id.tv_text2)).getText().toString();
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
                }
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                if (DataCanbus.DATA[116] == 1) {
                    YLFunc.CAR_ON_START_CTL(3);
                } else if (DataCanbus.DATA[116] == 2) {
                    YLFunc.CAR_ON_START_CTL(3);
                } else if (DataCanbus.DATA[116] == 3) {
                    YLFunc.CAR_ON_START_CTL(3);
                } else if (DataCanbus.DATA[116] == 4) {
                    YLFunc.CAR_ON_START_CTL(3);
                }
                break;
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
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOnStarState() {
        if (DataCanbus.DATA[116] == 0 && this.IsChange && this.IsIntentOn) {
            YLFunc.SWITCH_MAIN_STATE(0);
            moveTaskToBack(true);
            this.IsChange = false;
        }
        if (DataCanbus.DATA[116] == 0) {
            this.IsChange = false;
        } else if (DataCanbus.DATA[116] != 0) {
            this.IsChange = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOnStarNum() {
        String str = GmConstData.anjixingNumber;
        if (str != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText("Call In:" + str);
        }
    }
}
