package com.syu.carinfo.od.ford.falcon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FordFalconCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.ford.falcon.FordFalconCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 24:
                    FordFalconCarSet.this.setCheck((CheckedTextView) FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 25:
                    FordFalconCarSet.this.setCheck((CheckedTextView) FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 26:
                    FordFalconCarSet.this.setCheck((CheckedTextView) FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 27:
                    FordFalconCarSet.this.setCheck((CheckedTextView) FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 28:
                    FordFalconCarSet.this.setCheck((CheckedTextView) FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 29:
                    FordFalconCarSet.this.setCheck((CheckedTextView) FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 30:
                    FordFalconCarSet.this.setCheck((CheckedTextView) FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 31:
                    FordFalconCarSet.this.setCheck((CheckedTextView) FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 32:
                    FordFalconCarSet.this.setCheck((CheckedTextView) FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 33:
                    FordFalconCarSet.this.setCheck((CheckedTextView) FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 34:
                    FordFalconCarSet.this.setCheck((CheckedTextView) FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 35:
                    FordFalconCarSet.this.updateText1(val);
                    break;
                case 36:
                    FordFalconCarSet.this.updateText2(val);
                    break;
                case 37:
                    FordFalconCarSet.this.updateText3(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_od_falcon_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[24];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(165, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[35] - 1;
                if (value2 < 0) {
                    value2 = 4;
                }
                setCarInfo(176, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[35] + 1;
                if (value3 > 4) {
                    value3 = 0;
                }
                setCarInfo(176, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[36] - 1;
                if (value4 < 0) {
                    value4 = 8;
                }
                setCarInfo(177, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[36] + 1;
                if (value5 > 8) {
                    value5 = 0;
                }
                setCarInfo(178, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[37] - 1;
                if (value6 < 0) {
                    value6 = 8;
                }
                setCarInfo(178, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[37] + 1;
                if (value7 > 8) {
                    value7 = 0;
                }
                setCarInfo(178, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value8 = DataCanbus.DATA[25];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(166, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value9 = DataCanbus.DATA[26];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(167, value9);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value10 = DataCanbus.DATA[27];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(168, value10);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value11 = DataCanbus.DATA[28];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(169, value11);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value12 = DataCanbus.DATA[29];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(170, value12);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value13 = DataCanbus.DATA[30];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(171, value13);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value14 = DataCanbus.DATA[31];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(172, value14);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value15 = DataCanbus.DATA[32];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(173, value15);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value16 = DataCanbus.DATA[33];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(174, value16);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value17 = DataCanbus.DATA[34];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(175, value17);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                setCarInfo(179, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                setCarInfo(179, 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                setCarInfo(179, 2);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                setCarInfo(180, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("0 min");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("1 min");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("2 min");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText("3 min");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text1)).setText("4 min");
                    break;
            }
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.ford.falcon.FordFalconCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.ford.falcon.FordFalconCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.ford.falcon.FordFalconCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
