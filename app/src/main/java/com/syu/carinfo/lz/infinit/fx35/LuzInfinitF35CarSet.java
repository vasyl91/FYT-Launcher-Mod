package com.syu.carinfo.lz.infinit.fx35;

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
public class LuzInfinitF35CarSet extends BaseActivity implements View.OnClickListener {
    public static LuzInfinitF35CarSet mInstance;
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.infinit.fx35.LuzInfinitF35CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 36:
                    LuzInfinitF35CarSet.this.setCheck((CheckedTextView) LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 37:
                    LuzInfinitF35CarSet.this.setCheck((CheckedTextView) LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext2), val != 0);
                    break;
                case 38:
                    LuzInfinitF35CarSet.this.setCheck((CheckedTextView) LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext3), val != 0);
                    break;
                case 39:
                    LuzInfinitF35CarSet.this.setCheck((CheckedTextView) LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext4), val != 0);
                    break;
                case 40:
                    switch (val) {
                        case 0:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text1)).setText("OFF");
                            break;
                        case 1:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text1)).setText("Unlock");
                            break;
                        case 2:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text1)).setText("Lock");
                            break;
                        case 3:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text1)).setText("Lock And Unlock");
                            break;
                    }
                case 41:
                    switch (val) {
                        case 0:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text2)).setText("OFF");
                            break;
                        case 1:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text2)).setText("1 min");
                            break;
                        case 2:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text2)).setText("5 min");
                            break;
                    }
                case 42:
                    switch (val) {
                        case 0:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text3)).setText("1");
                            break;
                        case 1:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text3)).setText("2");
                            break;
                        case 2:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text3)).setText("3");
                            break;
                        case 3:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text3)).setText("4");
                            break;
                    }
                case 43:
                    switch (val) {
                        case 0:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text4)).setText("OFF");
                            break;
                        case 1:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text4)).setText("30 sec");
                            break;
                        case 2:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text4)).setText("45 sec");
                            break;
                        case 3:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text4)).setText("60 sec");
                            break;
                        case 4:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text4)).setText("90 sec");
                            break;
                        case 5:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text4)).setText("120 sec");
                            break;
                        case 6:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text4)).setText("150 sec");
                            break;
                        case 7:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text4)).setText("180 sec");
                            break;
                    }
                case 44:
                    LuzInfinitF35CarSet.this.setCheck((CheckedTextView) LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext5), val != 0);
                    break;
                case 45:
                    switch (val) {
                        case 0:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text5)).setText("OFF");
                            break;
                        case 1:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text5)).setText("Beeper");
                            break;
                        case 2:
                            ((TextView) LuzInfinitF35CarSet.this.findViewById(R.id.tv_text5)).setText("Horn Chirp");
                            break;
                    }
                case 46:
                    LuzInfinitF35CarSet.this.setCheck((CheckedTextView) LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext6), val != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_infinit_settings);
        init();
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        ((CheckedTextView) findViewById(R.id.id_reset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.infinit.fx35.LuzInfinitF35CarSet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LuzInfinitF35CarSet.this.dialog();
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.infinit.fx35.LuzInfinitF35CarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.lz.infinit.fx35.LuzInfinitF35CarSet.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LuzInfinitF35CarSet.this.setCarInfo(255, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.infinit.fx35.LuzInfinitF35CarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value7 = DataCanbus.DATA[36];
                if (value7 == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                setCarInfo(0, value6, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[40];
                int value9 = value8 - 1;
                if (value9 < 0) {
                    value9 = 3;
                }
                setCarInfo(4, value9, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value10 = DataCanbus.DATA[40];
                int value11 = value10 + 1;
                if (value11 > 3) {
                    value11 = 0;
                }
                setCarInfo(4, value11, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value12 = DataCanbus.DATA[41];
                int value13 = value12 - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(5, value13, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value14 = DataCanbus.DATA[41];
                int value15 = value14 + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(5, value15, 0);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value16 = DataCanbus.DATA[42];
                int value17 = value16 - 1;
                if (value17 < 0) {
                    value17 = 3;
                }
                setCarInfo(6, value17, 0);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value18 = DataCanbus.DATA[42];
                int value19 = value18 + 1;
                if (value19 > 3) {
                    value19 = 0;
                }
                setCarInfo(6, value19, 0);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value20 = DataCanbus.DATA[43];
                int value21 = value20 - 1;
                if (value21 < 0) {
                    value21 = 7;
                }
                setCarInfo(7, value21, 0);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value22 = DataCanbus.DATA[43];
                int value23 = value22 + 1;
                if (value23 > 7) {
                    value23 = 0;
                }
                setCarInfo(7, value23, 0);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value24 = DataCanbus.DATA[45];
                int value25 = value24 - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(9, value25, 0);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value26 = DataCanbus.DATA[45];
                int value27 = value26 + 1;
                if (value27 > 2) {
                    value27 = 0;
                }
                setCarInfo(9, value27, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value28 = DataCanbus.DATA[37];
                if (value28 == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(1, value5, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value29 = DataCanbus.DATA[38];
                if (value29 == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(2, value4, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value30 = DataCanbus.DATA[39];
                if (value30 == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(3, value3, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value31 = DataCanbus.DATA[44];
                if (value31 == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(8, value2, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value32 = DataCanbus.DATA[46];
                if (value32 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(10, value, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{56}, null, null);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
    }
}
