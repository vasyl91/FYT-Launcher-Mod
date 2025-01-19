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

public class ODNissanQuystCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                case 100:
                    ODNissanQuystCarSet.this.updateText1();
                    break;
                case 101:
                case 102:
                    ODNissanQuystCarSet.this.updateText2();
                    break;
                case 103:
                    ODNissanQuystCarSet.this.setCheck((CheckedTextView) ODNissanQuystCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 104:
                    ((TextView) ODNissanQuystCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val)).toString());
                    break;
                case 105:
                    if (((TextView) ODNissanQuystCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODNissanQuystCarSet.this.findViewById(R.id.tv_text4)).setText("0s");
                                break;
                            case 1:
                                ((TextView) ODNissanQuystCarSet.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODNissanQuystCarSet.this.findViewById(R.id.tv_text4)).setText("45s");
                                break;
                            case 3:
                                ((TextView) ODNissanQuystCarSet.this.findViewById(R.id.tv_text4)).setText("60s");
                                break;
                            case 4:
                                ((TextView) ODNissanQuystCarSet.this.findViewById(R.id.tv_text4)).setText("90s");
                                break;
                            case 5:
                                ((TextView) ODNissanQuystCarSet.this.findViewById(R.id.tv_text4)).setText("120s");
                                break;
                            case 6:
                                ((TextView) ODNissanQuystCarSet.this.findViewById(R.id.tv_text4)).setText("150s");
                                break;
                            case 7:
                                ((TextView) ODNissanQuystCarSet.this.findViewById(R.id.tv_text4)).setText("180s");
                                break;
                        }
                    }
                    break;
                case 106:
                    ODNissanQuystCarSet.this.setCheck((CheckedTextView) ODNissanQuystCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 107:
                    ODNissanQuystCarSet.this.setCheck((CheckedTextView) ODNissanQuystCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_nissan_quest_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[104] - 1;
                if (value < 1) {
                    value = 4;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[104] + 1;
                if (value2 > 4) {
                    value2 = 1;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[105] - 1;
                if (value3 < 0) {
                    value3 = 7;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[105] + 1;
                if (value4 > 7) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value5 = DataCanbus.DATA[103];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(1, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value6 = DataCanbus.DATA[106];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(4, value6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value7 = DataCanbus.DATA[107];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(5, value7);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                dialog(R.string.all_settings, 255);
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
        setCarInfo(0, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
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
    }

    
    public void updateText2() {
        int value = DataCanbus.DATA[102];
        int unit = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                    break;
            }
        }
    }

    
    public void updateText1() {
        int value = DataCanbus.DATA[100];
        int unit = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mi");
                    break;
            }
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
