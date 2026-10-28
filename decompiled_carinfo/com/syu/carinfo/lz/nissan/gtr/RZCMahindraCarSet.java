package com.syu.carinfo.lz.nissan.gtr;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCMahindraCarSet extends BaseActivity implements View.OnClickListener {
    public static RZCMahindraCarSet mInstance;
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 106:
                    RZCMahindraCarSet.this.setCheck(RZCMahindraCarSet.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 107:
                    switch (val) {
                        case 0:
                            ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text1)).setText("30s");
                            break;
                        case 2:
                            ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text1)).setText("60s");
                            break;
                        case 4:
                            ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text1)).setText("90s");
                            break;
                    }
                case 108:
                    switch (val) {
                        case 0:
                            ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text2)).setText("0s");
                            break;
                        case 5:
                            ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text2)).setText("5s");
                            break;
                        case 10:
                            ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text2)).setText("10s");
                            break;
                    }
                case 109:
                    ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(val));
                    break;
                case 110:
                    switch (val) {
                        case 0:
                            ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text4)).setText("Tone 1");
                            break;
                        case 1:
                            ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text4)).setText("Tone 2");
                            break;
                        case 2:
                            ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text4)).setText("Tone 3");
                            break;
                    }
                case 111:
                    RZCMahindraCarSet.this.setCheck(RZCMahindraCarSet.this.findViewById(R.id.ctv_checkedtext2), val != 0);
                    break;
                case 112:
                    switch (val) {
                        case 0:
                            ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text5)).setText("All doors");
                            break;
                        case 1:
                            ((TextView) RZCMahindraCarSet.this.findViewById(R.id.tv_text5)).setText("Driver Door");
                            break;
                    }
                case 113:
                    RZCMahindraCarSet.this.setCheck(RZCMahindraCarSet.this.findViewById(R.id.ctv_checkedtext3), val != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_rzc_mahindra_settings);
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
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value4 = DataCanbus.DATA[107];
                if (value4 == 0) {
                    value4 = 4;
                } else if (value4 == 2) {
                    value4 = 0;
                } else if (value4 == 4) {
                    value4 = 2;
                }
                setCarInfo(17, value4);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value5 = DataCanbus.DATA[107];
                if (value5 == 0) {
                    value5 = 2;
                } else if (value5 == 2) {
                    value5 = 4;
                } else if (value5 == 4) {
                    value5 = 0;
                }
                setCarInfo(17, value5);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value6 = DataCanbus.DATA[108];
                if (value6 == 0) {
                    value6 = 10;
                } else if (value6 == 5) {
                    value6 = 0;
                } else if (value6 == 10) {
                    value6 = 5;
                }
                setCarInfo(32, value6);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value7 = DataCanbus.DATA[108];
                if (value7 == 0) {
                    value7 = 5;
                } else if (value7 == 5) {
                    value7 = 10;
                } else if (value7 == 10) {
                    value7 = 0;
                }
                setCarInfo(32, value7);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value8 = DataCanbus.DATA[109];
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(33, value8);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value9 = DataCanbus.DATA[109];
                if (value9 < 15) {
                    value9++;
                }
                setCarInfo(33, value9);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value10 = DataCanbus.DATA[110] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(34, value10);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value11 = DataCanbus.DATA[110] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(34, value11);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value12 = DataCanbus.DATA[112] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(49, value12);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value13 = DataCanbus.DATA[112] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(49, value13);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[106] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(16, value3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[111] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(48, value2);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[113] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(50, value);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                dialog("Car Information", 241);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                dialog("AVG Fuel", 242);
                break;
        }
    }

    protected void dialog(String stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.confirm_reset) + " " + stringId + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
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
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{63, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
    }
}
