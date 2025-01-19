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

public class FordFalconCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    FordFalconCarSet.this.setCheck(FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 100:
                    FordFalconCarSet.this.setCheck(FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 101:
                    FordFalconCarSet.this.setCheck(FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 102:
                    FordFalconCarSet.this.setCheck(FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 103:
                    FordFalconCarSet.this.setCheck(FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 104:
                    FordFalconCarSet.this.setCheck(FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 105:
                    FordFalconCarSet.this.setCheck(FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 106:
                    FordFalconCarSet.this.setCheck(FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 107:
                    FordFalconCarSet.this.setCheck(FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 108:
                    FordFalconCarSet.this.setCheck(FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 109:
                    FordFalconCarSet.this.setCheck(FordFalconCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 110:
                    FordFalconCarSet.this.updateText1(val);
                    break;
                case 111:
                    FordFalconCarSet.this.updateText2(val);
                    break;
                case 112:
                    FordFalconCarSet.this.updateText3(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_od_falcon_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[110] - 1;
                if (value < 0) {
                    value = 4;
                }
                setCarInfo(176, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[110] + 1;
                if (value2 > 4) {
                    value2 = 0;
                }
                setCarInfo(176, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[111] - 1;
                if (value3 < 0) {
                    value3 = 8;
                }
                setCarInfo(177, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[111] + 1;
                if (value4 > 8) {
                    value4 = 0;
                }
                setCarInfo(178, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[112] - 1;
                if (value5 < 0) {
                    value5 = 8;
                }
                setCarInfo(178, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[112] + 1;
                if (value6 > 8) {
                    value6 = 0;
                }
                setCarInfo(178, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value7 = DataCanbus.DATA[99];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(165, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value8 = DataCanbus.DATA[100];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(166, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value9 = DataCanbus.DATA[101];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(167, value9);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value10 = DataCanbus.DATA[102];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(168, value10);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value11 = DataCanbus.DATA[103];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(169, value11);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value12 = DataCanbus.DATA[104];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(170, value12);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value13 = DataCanbus.DATA[105];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(171, value13);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value14 = DataCanbus.DATA[106];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(172, value14);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value15 = DataCanbus.DATA[107];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(173, value15);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value16 = DataCanbus.DATA[108];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(174, value16);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value17 = DataCanbus.DATA[109];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(175, value17);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                setCarInfo(179, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                setCarInfo(179, 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                setCarInfo(179, 2);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                setCarInfo(180, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
    }

    @Override
    public void removeNotify() {
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
    }

    
    public void updateText3(int value) {
        if (findViewById(R.id.tv_text3) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value));
        }
    }

    
    public void updateText2(int value) {
        if (findViewById(R.id.tv_text2) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value));
        }
    }

    
    public void updateText1(int value) {
        if (findViewById(R.id.tv_text1) != null) {
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
        builder.setMessage(getResources().getString(R.string.confirm_reset) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
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
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
