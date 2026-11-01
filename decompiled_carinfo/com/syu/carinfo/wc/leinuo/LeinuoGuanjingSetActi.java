package com.syu.carinfo.wc.leinuo;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class LeinuoGuanjingSetActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 132:
                    if (((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value * 5).toString());
                        break;
                    }
                case 150:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 153:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 154:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 155:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 156:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 157:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 158:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 160:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 161:
                    if (((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km/h");
                        break;
                    }
                case 162:
                case 163:
                    int msb = DataCanbus.DATA[162];
                    int lsb = DataCanbus.DATA[163];
                    int data = ((msb << 8) & 65280) | (lsb & 255);
                    if (((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text3)).setText(String.valueOf(data) + "km");
                        break;
                    }
                case 164:
                    LeinuoGuanjingSetActi.this.setCheck((CheckedTextView) LeinuoGuanjingSetActi.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 165:
                    if (((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            case 2:
                                ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)).setText("60s");
                                break;
                            case 3:
                                ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)).setText("90s");
                                break;
                            case 4:
                                ((TextView) LeinuoGuanjingSetActi.this.findViewById(R.id.tv_text4)).setText("120s");
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
        //setContentView(R.layout.layout_0352_wc_guanjing_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
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
                int value = DataCanbus.DATA[132];
                if (value > 0) {
                    value--;
                }
                setCarInfo(24, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[132];
                if (value2 < 20) {
                    value2++;
                }
                setCarInfo(24, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[161];
                if (value3 > 30) {
                    value3 -= 5;
                }
                setCarInfo(59, value3, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[161];
                if (value4 < 220) {
                    value4 += 5;
                }
                setCarInfo(59, value4, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value5 = DataCanbus.DATA[165] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarInfo(62, value5, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value6 = DataCanbus.DATA[165] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarInfo(62, value6, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                CreatDialog();
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value7 = DataCanbus.DATA[150];
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarInfo(44, value7, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value8 = DataCanbus.DATA[153];
                if (value8 == 0) {
                    value8 = 1;
                } else if (value8 == 1) {
                    value8 = 0;
                }
                setCarInfo(53, value8, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value9 = DataCanbus.DATA[154];
                if (value9 == 0) {
                    value9 = 1;
                } else if (value9 == 1) {
                    value9 = 0;
                }
                setCarInfo(54, value9, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value10 = DataCanbus.DATA[155];
                if (value10 == 0) {
                    value10 = 1;
                } else if (value10 == 1) {
                    value10 = 0;
                }
                setCarInfo(55, value10, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value11 = DataCanbus.DATA[156];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(56, value11, 0, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value12 = DataCanbus.DATA[157];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(57, value12, 0, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value13 = DataCanbus.DATA[158];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(58, value13, 0, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                CreatDialog1();
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value14 = DataCanbus.DATA[160];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(63, value14, 0, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value15 = DataCanbus.DATA[164];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(61, value15, 0, 0);
                break;
        }
    }

    private void CreatDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        LeinuoGuanjingSetActi.this.setCarInfo(31, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LeinuoGuanjingSetActi.this.setCarInfo(31, 0, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void CreatDialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_321_repair_reset));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        LeinuoGuanjingSetActi.this.setCarInfo(60, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LeinuoGuanjingSetActi.this.setCarInfo(60, 0, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
    }
}
