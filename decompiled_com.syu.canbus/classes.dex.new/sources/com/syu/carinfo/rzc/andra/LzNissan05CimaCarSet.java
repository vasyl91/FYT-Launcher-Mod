package com.syu.carinfo.rzc.andra;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LzNissan05CimaCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.andra.LzNissan05CimaCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    LzNissan05CimaCarSet.this.setCheck((CheckedTextView) LzNissan05CimaCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 111:
                    LzNissan05CimaCarSet.this.setCheck((CheckedTextView) LzNissan05CimaCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 112:
                    if (((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value + 1).toString());
                    }
                    break;
                case 113:
                    LzNissan05CimaCarSet.this.setCheck((CheckedTextView) LzNissan05CimaCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 114:
                    LzNissan05CimaCarSet.this.setCheck((CheckedTextView) LzNissan05CimaCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 115:
                    if (((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text7)).setText("15s");
                                break;
                            case 2:
                                ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text7)).setText("30s");
                                break;
                            case 3:
                                ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text7)).setText("45s");
                                break;
                        }
                    }
                    break;
                case 116:
                    if (((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 117:
                    if (((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (256 - value));
                        } else if (value == 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                        } else if (value > 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text3)).setText("+" + value);
                        }
                    }
                    break;
                case 118:
                    if (((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (256 - value));
                        } else if (value == 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                        } else if (value > 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text4)).setText("+" + value);
                        }
                    }
                    break;
                case 119:
                    if (((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text2)).setText("L" + (256 - value));
                        } else if (value == 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                        } else if (value > 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text2)).setText("R" + value);
                        }
                    }
                    break;
                case 120:
                    if (((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text1)).setText("F" + (256 - value));
                        } else if (value == 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text1)).setText("0");
                        } else if (value > 0) {
                            ((TextView) LzNissan05CimaCarSet.this.findViewById(R.id.tv_text1)).setText("R" + value);
                        }
                    }
                    break;
                case 121:
                    LzNissan05CimaCarSet.this.setCheck((CheckedTextView) LzNissan05CimaCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 122:
                    if (value == 1) {
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_text_view1).setVisibility(0);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view1).setVisibility(0);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view2).setVisibility(0);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view3).setVisibility(0);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view4).setVisibility(0);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view5).setVisibility(0);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view6).setVisibility(0);
                    } else {
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_text_view1).setVisibility(8);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view1).setVisibility(8);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view2).setVisibility(8);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view3).setVisibility(8);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view4).setVisibility(8);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view5).setVisibility(8);
                        LzNissan05CimaCarSet.this.findViewById(R.id.layout_view6).setVisibility(8);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_lz_nissan_05cima_amp_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                setCarAmpInfo(4, 1);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                setCarAmpInfo(4, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                setCarAmpInfo(5, 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                setCarAmpInfo(5, 1);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                setCarAmpInfo(1, 0);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                setCarAmpInfo(1, 1);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                setCarAmpInfo(3, 0);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                setCarAmpInfo(3, 1);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                setCarAmpInfo(0, 0);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                setCarAmpInfo(0, 1);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value = DataCanbus.DATA[112] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value2 = DataCanbus.DATA[112] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(6, value2);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value3 = DataCanbus.DATA[115] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(27, value3);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value4 = DataCanbus.DATA[115] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(27, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value5 = DataCanbus.DATA[121];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarAmpInfo(9, value5);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value6 = DataCanbus.DATA[113];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(25, value6);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value7 = DataCanbus.DATA[114];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(26, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value8 = DataCanbus.DATA[110];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(0, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value9 = DataCanbus.DATA[111];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(1, value9);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                dialog(R.string.all_settings, 255);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.LzNissan05CimaCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.andra.LzNissan05CimaCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(3, new int[]{i, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.LzNissan05CimaCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarAmpInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{59, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
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
    }

    @Override // com.syu.canbus.BaseActivity
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
    }
}
