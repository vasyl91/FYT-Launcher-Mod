package com.syu.carinfo.rzc.xima;

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

public class LZ_NissanInfinitiCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 111:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 112:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("45s");
                                break;
                            case 3:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 4:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("90s");
                                break;
                            case 5:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("120s");
                                break;
                            case 6:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("150s");
                                break;
                            case 7:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("180s");
                                break;
                        }
                    }
                    break;
                case 113:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 114:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 115:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 116:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 117:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 118:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 119:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 120:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 121:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 122:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 123:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 127:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text6)).setText("Type1");
                                break;
                            case 1:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text6)).setText("Type2");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_nissaninfiniti_settings);
        init();
    }

    @Override
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[111] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(6, value, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[111] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(6, value2, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[112] - 1;
                if (value3 < 0) {
                    value3 = 7;
                }
                setCarInfo(7, value3, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[112] + 1;
                if (value4 > 7) {
                    value4 = 0;
                }
                setCarInfo(7, value4, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[121] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(17, value5, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[121] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(17, value6, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[122] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(19, value7, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[122] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(19, value8, 0);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[123] - 1;
                if (value9 < 0) {
                    value9 = 3;
                }
                setCarInfo(20, value9, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[123] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(20, value10, 0);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[127] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(255, value11, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[127] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(255, value12, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value13 = DataCanbus.DATA[110];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(2, value13, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value14 = DataCanbus.DATA[113];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(8, value14, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value15 = DataCanbus.DATA[114];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(11, value15, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value16 = DataCanbus.DATA[115];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(12, value16, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value17 = DataCanbus.DATA[116];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(15, value17, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value18 = DataCanbus.DATA[117];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(16, value18, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value19 = DataCanbus.DATA[118];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(21, value19, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value20 = DataCanbus.DATA[119];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(22, value20, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value21 = DataCanbus.DATA[120];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(23, value21, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                dialog(R.string.str_298_default_all, 255);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2}, null, null);
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
                        DataCanbus.PROXY.cmd(1, new int[]{i}, null, null);
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
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{56}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
    }
}
