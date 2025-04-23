package com.syu.carinfo.ksw.audiq5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RDWBenzSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 104:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text1)).setText("慢且弱");
                                break;
                            case 2:
                                ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text1)).setText("慢且强");
                                break;
                            case 3:
                                ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text1)).setText("快且弱");
                                break;
                            case 4:
                                ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text1)).setText("快且强");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 106:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 107:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 108:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 109:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text10)).setText("慢且弱");
                                break;
                            case 2:
                                ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text10)).setText("慢且强");
                                break;
                            case 3:
                                ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text10)).setText("快且弱");
                                break;
                            case 4:
                                ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text10)).setText("快且强");
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 111:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 112:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 113:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 114:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 115:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 116:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        if (value > 3) {
                            ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text8)).setText("+" + (value - 3));
                            break;
                        } else if (value < 3) {
                            ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text8)).setText("-" + (3 - value));
                            break;
                        } else {
                            ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text8)).setText("0");
                            break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 118:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 119:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 120:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        if (value > 3) {
                            ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text17)).setText("+" + (value - 3));
                            break;
                        } else if (value < 3) {
                            ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text17)).setText("-" + (3 - value));
                            break;
                        } else {
                            ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text17)).setText("0");
                            break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text18)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text18)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 122:
                    if (((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text19)) != null) {
                        ((TextView) RDWBenzSetFunc.this.findViewById(R.id.tv_text19)).setText(String.valueOf(value) + "km");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_rdw_benz_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[104] - 1;
                if (value < 0) {
                    value = 4;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[104] + 1;
                if (value2 > 4) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[105] - 1;
                if (value3 < 0) {
                    value3 = 10;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[105] + 1;
                if (value4 > 10) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[106] - 1;
                if (value5 < 0) {
                    value5 = 10;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[106] + 1;
                if (value6 > 10) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[107] - 1;
                if (value7 < 0) {
                    value7 = 10;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[107] + 1;
                if (value8 > 10) {
                    value8 = 0;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[108] - 1;
                if (value9 < 0) {
                    value9 = 10;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[108] + 1;
                if (value10 > 10) {
                    value10 = 0;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[114] - 1;
                if (value11 < 0) {
                    value11 = 10;
                }
                setCarInfo(11, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[114] + 1;
                if (value12 > 10) {
                    value12 = 0;
                }
                setCarInfo(11, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[115] - 1;
                if (value13 < 0) {
                    value13 = 10;
                }
                setCarInfo(12, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[115] + 1;
                if (value14 > 10) {
                    value14 = 0;
                }
                setCarInfo(12, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[116] - 1;
                if (value15 < 0) {
                    value15 = 10;
                }
                setCarInfo(13, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[116] + 1;
                if (value16 > 10) {
                    value16 = 0;
                }
                setCarInfo(13, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[117] - 1;
                if (value17 < 0) {
                    value17 = 10;
                }
                setCarInfo(14, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[117] + 1;
                if (value18 > 10) {
                    value18 = 0;
                }
                setCarInfo(14, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[109] - 1;
                if (value19 < 0) {
                    value19 = 4;
                }
                setCarInfo(6, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[109] + 1;
                if (value20 > 4) {
                    value20 = 0;
                }
                setCarInfo(6, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[110] - 1;
                if (value21 < 0) {
                    value21 = 10;
                }
                setCarInfo(7, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[110] + 1;
                if (value22 > 10) {
                    value22 = 0;
                }
                setCarInfo(7, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[111] - 1;
                if (value23 < 0) {
                    value23 = 10;
                }
                setCarInfo(8, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[111] + 1;
                if (value24 > 10) {
                    value24 = 0;
                }
                setCarInfo(8, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[112] - 1;
                if (value25 < 0) {
                    value25 = 10;
                }
                setCarInfo(9, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[112] + 1;
                if (value26 > 10) {
                    value26 = 0;
                }
                setCarInfo(9, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[113] - 1;
                if (value27 < 0) {
                    value27 = 10;
                }
                setCarInfo(10, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[113] + 1;
                if (value28 > 10) {
                    value28 = 0;
                }
                setCarInfo(10, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[118] - 1;
                if (value29 < 0) {
                    value29 = 10;
                }
                setCarInfo(15, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[118] + 1;
                if (value30 > 10) {
                    value30 = 0;
                }
                setCarInfo(15, value30);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = DataCanbus.DATA[119] - 1;
                if (value31 < 0) {
                    value31 = 10;
                }
                setCarInfo(16, value31);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = DataCanbus.DATA[119] + 1;
                if (value32 > 10) {
                    value32 = 0;
                }
                setCarInfo(16, value32);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value33 = DataCanbus.DATA[120] - 1;
                if (value33 < 0) {
                    value33 = 10;
                }
                setCarInfo(17, value33);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value34 = DataCanbus.DATA[120] + 1;
                if (value34 > 10) {
                    value34 = 0;
                }
                setCarInfo(17, value34);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RDWBenzPennelSetActi.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog(R.string.all_settings, 0);
                break;
            case R.id.btn_minus18 /* 2131427894 */:
                int value35 = DataCanbus.DATA[121] - 1;
                if (value35 < 0) {
                    value35 = 10;
                }
                setCarInfo(18, value35);
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                int value36 = DataCanbus.DATA[121] + 1;
                if (value36 > 10) {
                    value36 = 0;
                }
                setCarInfo(18, value36);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
