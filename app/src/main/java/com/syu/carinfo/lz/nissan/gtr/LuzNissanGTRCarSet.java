package com.syu.carinfo.lz.nissan.gtr;

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
public class LuzNissanGTRCarSet extends BaseActivity implements View.OnClickListener {
    public static LuzNissanGTRCarSet mInstance;
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 53:
                    LuzNissanGTRCarSet.this.setCheck((CheckedTextView) LuzNissanGTRCarSet.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 57:
                    switch (val) {
                        case 0:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text1)).setText("1");
                            break;
                        case 1:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text1)).setText("2");
                            break;
                        case 2:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text1)).setText("3");
                            break;
                        case 3:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text1)).setText("4");
                            break;
                    }
                case 58:
                    switch (val) {
                        case 0:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text2)).setText("OFF");
                            break;
                        case 1:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text2)).setText("30 S");
                            break;
                        case 2:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text2)).setText("45 S");
                            break;
                        case 3:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text2)).setText("60 S");
                            break;
                        case 4:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text2)).setText("90 S");
                            break;
                        case 5:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text2)).setText("120 S");
                            break;
                        case 6:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text2)).setText("150 S");
                            break;
                        case 7:
                            ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text2)).setText("180 S");
                            break;
                    }
                case 59:
                    LuzNissanGTRCarSet.this.setCheck((CheckedTextView) LuzNissanGTRCarSet.this.findViewById(R.id.ctv_checkedtext2), val != 0);
                    break;
                case 62:
                    LuzNissanGTRCarSet.this.setCheck((CheckedTextView) LuzNissanGTRCarSet.this.findViewById(R.id.ctv_checkedtext3), val != 0);
                    break;
                case 63:
                    LuzNissanGTRCarSet.this.setCheck((CheckedTextView) LuzNissanGTRCarSet.this.findViewById(R.id.ctv_checkedtext4), val != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_nissan_gtr_settings);
        init();
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        ((CheckedTextView) findViewById(R.id.id_reset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRCarSet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LuzNissanGTRCarSet.this.dialog();
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRCarSet.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LuzNissanGTRCarSet.this.setCarInfo(255, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRCarSet.4
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
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[53] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(2, value4, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value5 = DataCanbus.DATA[57] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(6, value5, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value6 = DataCanbus.DATA[57] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(6, value6, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value7 = DataCanbus.DATA[58] - 1;
                if (value7 < 0) {
                    value7 = 7;
                }
                setCarInfo(7, value7, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value8 = DataCanbus.DATA[58] + 1;
                if (value8 > 7) {
                    value8 = 0;
                }
                setCarInfo(7, value8, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[59] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(8, value3, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                if (DataCanbus.DATA[62] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(11, value2, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                if (DataCanbus.DATA[63] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(12, value, 0);
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
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
    }
}
