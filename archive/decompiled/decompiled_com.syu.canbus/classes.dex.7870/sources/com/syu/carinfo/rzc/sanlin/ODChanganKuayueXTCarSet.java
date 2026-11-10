package com.syu.carinfo.rzc.sanlin;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ODChanganKuayueXTCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODChanganKuayueXTCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 108:
                    if (((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text1)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text1)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text1)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 109:
                    ODChanganKuayueXTCarSet.this.setCheck((CheckedTextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 110:
                    ODChanganKuayueXTCarSet.this.setCheck((CheckedTextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 111:
                    ODChanganKuayueXTCarSet.this.setCheck((CheckedTextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 112:
                    if (((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 113:
                    ODChanganKuayueXTCarSet.this.setCheck((CheckedTextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 114:
                    ODChanganKuayueXTCarSet.this.setCheck((CheckedTextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 115:
                    ODChanganKuayueXTCarSet.this.setCheck((CheckedTextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 116:
                    if (((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.driver_system_standard);
                                break;
                            case 1:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.driver_system_sports);
                                break;
                            case 2:
                                ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.driver_system_economics);
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 119:
                    if (((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ODChanganKuayueXTCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "km");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_od_changan_kuayuext_settings);
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
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[108] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[108] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[112] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[112] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value5 = DataCanbus.DATA[117] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(9, value5);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value6 = DataCanbus.DATA[117] - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(9, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value7 = DataCanbus.DATA[109];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(2, value7);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int value8 = DataCanbus.DATA[113];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(6, value8);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int value9 = DataCanbus.DATA[114];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(7, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value10 = DataCanbus.DATA[110];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(3, value10);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value11 = DataCanbus.DATA[111];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(4, value11);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int value12 = DataCanbus.DATA[115];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(8, value12);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                dialog(R.string.tire_pressure, 10);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.ODChanganKuayueXTCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.ODChanganKuayueXTCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.ODChanganKuayueXTCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{102, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
    }
}
