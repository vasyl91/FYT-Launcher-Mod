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

public class LuzInfinitF35CarSet extends BaseActivity implements View.OnClickListener {
    public static LuzInfinitF35CarSet mInstance;
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 111:
                    LuzInfinitF35CarSet.this.setCheck(LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 112:
                    LuzInfinitF35CarSet.this.setCheck(LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext2), val != 0);
                    break;
                case 113:
                    LuzInfinitF35CarSet.this.setCheck(LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext3), val != 0);
                    break;
                case 114:
                    LuzInfinitF35CarSet.this.setCheck(LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext4), val != 0);
                    break;
                case 115:
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
                case 116:
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
                case 117:
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
                case 118:
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
                case 119:
                    LuzInfinitF35CarSet.this.setCheck(LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext5), val != 0);
                    break;
                case 120:
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
                case 121:
                    LuzInfinitF35CarSet.this.setCheck(LuzInfinitF35CarSet.this.findViewById(R.id.ctv_checkedtext6), val != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_luz_infinit_settings);
        init();
        mInstance = this;
    }

    @Override
    public void init() {
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext6), this);
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
        findViewById(R.id.id_reset).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                LuzInfinitF35CarSet.this.dialog();
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
                        LuzInfinitF35CarSet.this.setCarInfo(255, 0, 0);
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
        int value5;
        int value6;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value7 = DataCanbus.DATA[115];
                int value8 = value7 - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(4, value8, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value9 = DataCanbus.DATA[115];
                int value10 = value9 + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(4, value10, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value11 = DataCanbus.DATA[116];
                int value12 = value11 - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                setCarInfo(5, value12, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value13 = DataCanbus.DATA[116];
                int value14 = value13 + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(5, value14, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value15 = DataCanbus.DATA[117];
                int value16 = value15 - 1;
                if (value16 < 0) {
                    value16 = 3;
                }
                setCarInfo(6, value16, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value17 = DataCanbus.DATA[117];
                int value18 = value17 + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setCarInfo(6, value18, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value19 = DataCanbus.DATA[118];
                int value20 = value19 - 1;
                if (value20 < 0) {
                    value20 = 7;
                }
                setCarInfo(7, value20, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value21 = DataCanbus.DATA[118];
                int value22 = value21 + 1;
                if (value22 > 7) {
                    value22 = 0;
                }
                setCarInfo(7, value22, 0);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value23 = DataCanbus.DATA[120];
                int value24 = value23 - 1;
                if (value24 < 0) {
                    value24 = 2;
                }
                setCarInfo(9, value24, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value25 = DataCanbus.DATA[120];
                int value26 = value25 + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(9, value26, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value27 = DataCanbus.DATA[111];
                if (value27 == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                setCarInfo(0, value6, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value28 = DataCanbus.DATA[112];
                if (value28 == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(1, value5, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value29 = DataCanbus.DATA[113];
                if (value29 == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(2, value4, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value30 = DataCanbus.DATA[114];
                if (value30 == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(3, value3, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value31 = DataCanbus.DATA[119];
                if (value31 == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(8, value2, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value32 = DataCanbus.DATA[121];
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

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
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
        DataCanbus.PROXY.cmd(2, new int[]{56}, null, null);
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

    @Override
    public void removeNotify() {
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
}
