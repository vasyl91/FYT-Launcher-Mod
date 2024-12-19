package com.syu.carinfo.wc.leinuo;

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
public class LeinuoGuanjingSetActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.LeinuoGuanjingSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 120:
                    if (((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value * 5).toString());
                        break;
                    }
                case 138:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 141:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 142:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 143:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 144:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 145:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 146:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 148:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 149:
                    if (((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km/h");
                        break;
                    }
                case 150:
                case 151:
                    int msb = DataCanbus.DATA[150];
                    int lsb = DataCanbus.DATA[151];
                    int data = ((msb << 8) & 65280) | (lsb & 255);
                    if (((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text3)).setText(String.valueOf(data) + "km");
                        break;
                    }
                case 152:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 153:
                    if (((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            case 2:
                                ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)).setText("60s");
                                break;
                            case 3:
                                ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)).setText("90s");
                                break;
                            case 4:
                                ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)).setText("120s");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0352_wc_guanjing_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                CreatDialog();
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[120];
                if (value > 0) {
                    value--;
                }
                setCarInfo(24, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[120];
                if (value2 < 20) {
                    value2++;
                }
                setCarInfo(24, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[149];
                if (value3 > 30) {
                    value3 -= 5;
                }
                setCarInfo(59, value3, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[149];
                if (value4 < 220) {
                    value4 += 5;
                }
                setCarInfo(59, value4, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value5 = DataCanbus.DATA[153] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarInfo(62, value5, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value6 = DataCanbus.DATA[153] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarInfo(62, value6, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value7 = DataCanbus.DATA[138];
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarInfo(44, value7, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value8 = DataCanbus.DATA[141];
                if (value8 == 0) {
                    value8 = 1;
                } else if (value8 == 1) {
                    value8 = 0;
                }
                setCarInfo(53, value8, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value9 = DataCanbus.DATA[142];
                if (value9 == 0) {
                    value9 = 1;
                } else if (value9 == 1) {
                    value9 = 0;
                }
                setCarInfo(54, value9, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value10 = DataCanbus.DATA[143];
                if (value10 == 0) {
                    value10 = 1;
                } else if (value10 == 1) {
                    value10 = 0;
                }
                setCarInfo(55, value10, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value11 = DataCanbus.DATA[144];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(56, value11, 0, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value12 = DataCanbus.DATA[145];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(57, value12, 0, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value13 = DataCanbus.DATA[146];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(58, value13, 0, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                CreatDialog1();
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value14 = DataCanbus.DATA[148];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(63, value14, 0, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value15 = DataCanbus.DATA[152];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(61, value15, 0, 0);
                break;
        }
    }

    private void CreatDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.LeinuoGuanjingSetActi.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.leinuo.LeinuoGuanjingSetActi.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LeinuoGuanjingSetActi.this.setCarInfo(31, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.LeinuoGuanjingSetActi.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                LeinuoGuanjingSetActi.this.setCarInfo(31, 0, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void CreatDialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_321_repair_reset));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.LeinuoGuanjingSetActi.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.leinuo.LeinuoGuanjingSetActi.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LeinuoGuanjingSetActi.this.setCarInfo(60, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.LeinuoGuanjingSetActi.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                LeinuoGuanjingSetActi.this.setCarInfo(60, 0, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
    }
}
