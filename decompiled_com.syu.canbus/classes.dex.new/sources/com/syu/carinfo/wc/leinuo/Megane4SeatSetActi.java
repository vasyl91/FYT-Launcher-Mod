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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Megane4SeatSetActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.Megane4SeatSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 120:
                    if (((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text8)).setText("Relaxing");
                                break;
                            case 1:
                                ((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text8)).setText("Lumbar");
                                break;
                            case 2:
                                ((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text8)).setText("Tonic");
                                break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 122:
                    if (((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 123:
                    Megane4SeatSetActi.this.setCheck((CheckedTextView) Megane4SeatSetActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 181:
                    Megane4SeatSetActi.this.setCheck((CheckedTextView) Megane4SeatSetActi.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 208:
                    Megane4SeatSetActi.this.setCheck((CheckedTextView) Megane4SeatSetActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 209:
                    if (((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 210:
                    if (((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 211:
                    if (((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text1)).setText("Relaxing");
                                break;
                            case 1:
                                ((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text1)).setText("Lumbar");
                                break;
                            case 2:
                                ((TextView) Megane4SeatSetActi.this.findViewById(R.id.tv_text1)).setText("Tonic");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0352_wc_magane_seat_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
    }

    private void SavePositionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_save_seat_position));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SeatSetActi.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.leinuo.Megane4SeatSetActi.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Megane4SeatSetActi.this.setCarInfo(80, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SeatSetActi.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Megane4SeatSetActi.this.setCarInfo(80, 0, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void LoadPositionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_load_seat_position));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SeatSetActi.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.leinuo.Megane4SeatSetActi.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Megane4SeatSetActi.this.setCarInfo(81, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SeatSetActi.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Megane4SeatSetActi.this.setCarInfo(81, 0, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[211] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(77, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[211] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(77, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[209] - 1;
                if (value3 < 1) {
                    value3 = 5;
                }
                setCarInfo(78, value3, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[209] + 1;
                if (value4 > 5) {
                    value4 = 1;
                }
                setCarInfo(78, value4, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[210] - 1;
                if (value5 < 1) {
                    value5 = 5;
                }
                setCarInfo(79, value5, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[210] + 1;
                if (value6 > 5) {
                    value6 = 1;
                }
                setCarInfo(79, value6, 0, 0);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value7 = DataCanbus.DATA[120] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(13, value7, 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value8 = DataCanbus.DATA[120] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(13, value8, 0, 0);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value9 = DataCanbus.DATA[121] - 1;
                if (value9 < 1) {
                    value9 = 5;
                }
                setCarInfo(14, value9, 0, 0);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value10 = DataCanbus.DATA[121] + 1;
                if (value10 > 5) {
                    value10 = 1;
                }
                setCarInfo(14, value10, 0, 0);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value11 = DataCanbus.DATA[122] - 1;
                if (value11 < 1) {
                    value11 = 5;
                }
                setCarInfo(15, value11, 0, 0);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value12 = DataCanbus.DATA[122] + 1;
                if (value12 > 5) {
                    value12 = 1;
                }
                setCarInfo(15, value12, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value13 = DataCanbus.DATA[208];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(76, value13, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                SavePositionDialog();
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                LoadPositionDialog();
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value14 = DataCanbus.DATA[123];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(12, value14, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value15 = DataCanbus.DATA[181];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(71, value15, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
    }
}
