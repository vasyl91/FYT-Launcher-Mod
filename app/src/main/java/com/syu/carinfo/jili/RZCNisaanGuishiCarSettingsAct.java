package com.syu.carinfo.jili;

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

public class RZCNisaanGuishiCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 171:
                    RZCNisaanGuishiCarSettingsAct.this.setCheck((CheckedTextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 172:
                    if (((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("1");
                                break;
                            case 1:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("2");
                                break;
                            case 2:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("3");
                                break;
                            case 3:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("4");
                                break;
                        }
                    }
                    break;
                case 173:
                    RZCNisaanGuishiCarSettingsAct.this.setCheck((CheckedTextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 174:
                    if (((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("0s");
                                break;
                            case 1:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("45s");
                                break;
                            case 3:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 4:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("90s");
                                break;
                            case 5:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("120s");
                                break;
                            case 6:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("150s");
                                break;
                            case 7:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("180s");
                                break;
                        }
                    }
                    break;
                case 175:
                    RZCNisaanGuishiCarSettingsAct.this.setCheck((CheckedTextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 176:
                    RZCNisaanGuishiCarSettingsAct.this.setCheck((CheckedTextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 177:
                    RZCNisaanGuishiCarSettingsAct.this.setCheck((CheckedTextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 181:
                    if (((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_parksense_0);
                                break;
                            case 3:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 182:
                    if (((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_parksense_0);
                                break;
                            case 3:
                                ((TextView) RZCNisaanGuishiCarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_parksense_1);
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
        //setContentView(R.layout.layout_0190_rzc_nissan_guishi_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[172] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(85, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[172] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(85, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[174] - 1;
                if (value3 < 0) {
                    value3 = 7;
                }
                setCarInfo(87, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[174] + 1;
                if (value4 > 7) {
                    value4 = 0;
                }
                setCarInfo(87, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[181] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[181] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value6}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[182] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value7}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[182] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value8}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value9 = DataCanbus.DATA[171];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(84, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value10 = DataCanbus.DATA[173];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(86, value10);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value11 = DataCanbus.DATA[175];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(88, value11);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value12 = DataCanbus.DATA[176];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(89, value12);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value13 = DataCanbus.DATA[177];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(91, value13);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                dialog(R.string.all_settings, 90);
                break;
        }
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
                        DataCanbus.PROXY.cmd(2, new int[]{i, 1}, null, null);
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
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{149}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
    }
}
