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
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODBentNATCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODBentNATCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                                break;
                            case 1:
                                ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                                break;
                        }
                    }
                    break;
                case 99:
                    ODBentNATCarSet.this.setCheck((CheckedTextView) ODBentNATCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 100:
                    ODBentNATCarSet.this.setCheck((CheckedTextView) ODBentNATCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 101:
                    ODBentNATCarSet.this.setCheck((CheckedTextView) ODBentNATCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 102:
                    ODBentNATCarSet.this.setCheck((CheckedTextView) ODBentNATCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 103:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text2)).setText("0s");
                                break;
                            case 1:
                                ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text2)).setText("10s");
                                break;
                            case 2:
                                ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text2)).setText("25s");
                                break;
                            case 3:
                                ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                        }
                    }
                    break;
                case 104:
                    ODBentNATCarSet.this.setCheck((CheckedTextView) ODBentNATCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 105:
                    ODBentNATCarSet.this.setCheck((CheckedTextView) ODBentNATCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 106:
                    ODBentNATCarSet.this.setCheck((CheckedTextView) ODBentNATCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 107:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(val / 10) + "." + (val % 10) + "kWh/100Km");
                    }
                    break;
                case 108:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(val) + "W");
                    }
                    break;
                case 109:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(val / 10) + "." + (val % 10) + "km");
                    }
                    break;
                case 110:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(val) + "km");
                    }
                    break;
                case 111:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(val * 5) + "min");
                    }
                    break;
                case 112:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(val) + "V");
                    }
                    break;
                case 113:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(val - 500) + "A");
                    }
                    break;
                case 114:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        if (val == 1) {
                            ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text10)).setText("故障");
                        } else {
                            ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text10)).setText("正常");
                        }
                    }
                    break;
                case 115:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text11)).setText(String.valueOf(val - 40) + "℃");
                    }
                    break;
                case 116:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text12)).setText(String.valueOf(val) + "%");
                    }
                    break;
                case 117:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text13)).setText(String.valueOf(val - 14000) + " RPM");
                    }
                    break;
                case 118:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text14)).setText(String.valueOf((val / 4) - 350) + " NM");
                    }
                    break;
                case 119:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        if (val == 1) {
                            ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text15)).setText("故障");
                        } else {
                            ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text15)).setText("正常");
                        }
                    }
                    break;
                case 120:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text16)).setText(String.valueOf(val) + "kW");
                    }
                    break;
                case 121:
                    if (((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) ODBentNATCarSet.this.findViewById(R.id.tv_text17)).setText(String.valueOf(val) + "kW");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_od_bent_nat_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_456_OD_Bent_B30EV /* 655816 */:
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                break;
            case FinalCanbus.CAR_453_OD_Bent_NAT /* 1049029 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[103] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(6, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[103] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(6, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value5 = DataCanbus.DATA[99];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(2, value5);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value6 = DataCanbus.DATA[102];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(5, value6);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                dialog(R.string.str_416_reset_tire, 7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value7 = DataCanbus.DATA[100];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(3, value7);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value8 = DataCanbus.DATA[101];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(4, value8);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value9 = DataCanbus.DATA[104];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(8, value9);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value10 = DataCanbus.DATA[105];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(9, value10);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value11 = DataCanbus.DATA[106];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(10, value11);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.ODBentNATCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.ODBentNATCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.ODBentNATCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
