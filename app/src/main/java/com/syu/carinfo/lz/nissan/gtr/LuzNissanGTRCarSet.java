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

public class LuzNissanGTRCarSet extends BaseActivity implements View.OnClickListener {
    public static LuzNissanGTRCarSet mInstance;
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 127:
                    LuzNissanGTRCarSet.this.setCheck(LuzNissanGTRCarSet.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 131:
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
                case 132:
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
                case 133:
                    LuzNissanGTRCarSet.this.setCheck(LuzNissanGTRCarSet.this.findViewById(R.id.ctv_checkedtext2), val != 0);
                    break;
                case 136:
                    LuzNissanGTRCarSet.this.setCheck(LuzNissanGTRCarSet.this.findViewById(R.id.ctv_checkedtext3), val != 0);
                    break;
                case 137:
                    LuzNissanGTRCarSet.this.setCheck(LuzNissanGTRCarSet.this.findViewById(R.id.ctv_checkedtext4), val != 0);
                    break;
                case 171:
                    ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(val));
                    break;
                case 172:
                    ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(val));
                    break;
                case 173:
                    ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(val));
                    break;
                case 174:
                    ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(val));
                    break;
                case 175:
                    ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(val));
                    break;
                case 177:
                    ((TextView) LuzNissanGTRCarSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(val));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_luz_nissan_gtr_settings);
        init();
        mInstance = this;
    }

    @Override
    public void init() {
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.btn_minus4), this);
        setSelfClick(findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.btn_minus5), this);
        setSelfClick(findViewById(R.id.btn_plus5), this);
        setSelfClick(findViewById(R.id.btn_minus6), this);
        setSelfClick(findViewById(R.id.btn_plus6), this);
        setSelfClick(findViewById(R.id.btn_minus7), this);
        setSelfClick(findViewById(R.id.btn_plus7), this);
        setSelfClick(findViewById(R.id.btn_minus8), this);
        setSelfClick(findViewById(R.id.btn_plus8), this);
        findViewById(R.id.id_reset).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                LuzNissanGTRCarSet.this.dialog();
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        LuzNissanGTRCarSet.this.setCarInfo(255, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value5 = DataCanbus.DATA[131] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(6, value5, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value6 = DataCanbus.DATA[131] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(6, value6, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value7 = DataCanbus.DATA[132] - 1;
                if (value7 < 0) {
                    value7 = 7;
                }
                setCarInfo(7, value7, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value8 = DataCanbus.DATA[132] + 1;
                if (value8 > 7) {
                    value8 = 0;
                }
                setCarInfo(7, value8, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarAmpInfo(0, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarAmpInfo(0, 1);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setCarAmpInfo(1, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCarAmpInfo(1, 1);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setCarAmpInfo(3, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCarAmpInfo(3, 1);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarAmpInfo(5, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarAmpInfo(5, 1);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setCarAmpInfo(4, 0);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarAmpInfo(4, 1);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setCarAmpInfo(6, 0);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCarAmpInfo(6, 1);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[127] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(2, value4, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[133] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(8, value3, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[136] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(11, value2, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[137] == 0) {
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

    public void setCarAmpInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(2, new int[]{56}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{57}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
    }
}
