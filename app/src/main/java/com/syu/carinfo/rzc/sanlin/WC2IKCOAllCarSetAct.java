package com.syu.carinfo.rzc.sanlin;

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
import com.syu.module.canbus.FinalCanbus;

public class WC2IKCOAllCarSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text1)) != null) {
                        if (val == 65535) {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text1)).setText("----");
                            break;
                        } else {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(val / 10) + "." + (val % 10) + " L/100km");
                            break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text2)) != null) {
                        if (val == 65535) {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text2)).setText("----");
                            break;
                        } else {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(val) + " km");
                            break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (val == 16777215) {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text3)).setText("----");
                            break;
                        } else {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(val / 10) + "." + (val % 10) + " km");
                            break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (val == 255) {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text4)).setText("----");
                            break;
                        } else {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(val) + " km/h");
                            break;
                        }
                    }
                    break;
                case 103:
                    if (((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (val == 65535) {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text5)).setText("----");
                            break;
                        } else {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(val) + " km");
                            break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        if (val == 65535) {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text6)).setText("----");
                            break;
                        } else {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(val / 10) + "." + (val % 10) + " L/100km");
                            break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        if (val == 255) {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text7)).setText("----");
                            break;
                        } else {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(val) + " km/h");
                            break;
                        }
                    }
                    break;
                case 106:
                    if (((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text8)) != null) {
                        if (val == 65535) {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text8)).setText("----");
                            break;
                        } else {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(val) + " km");
                            break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text9)) != null) {
                        if (val == 65535) {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text9)).setText("----");
                            break;
                        } else {
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(val / 10) + "." + (val % 10) + " L/100km");
                            break;
                        }
                    }
                    break;
                case 108:
                    WC2IKCOAllCarSetAct.this.setCheck((CheckedTextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 109:
                    switch (val) {
                        case 0:
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text10)).setText("15s");
                            break;
                        case 2:
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text10)).setText("30s");
                            break;
                        case 3:
                            ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text10)).setText("45s");
                            break;
                    }
                case 110:
                    ((TextView) WC2IKCOAllCarSetAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(val)).toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0444_wc_ikco_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_IKCO_Tara_21 /* 1376700 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                break;
            case FinalCanbus.CAR_444_WC2_IKCO_Dena_15 /* 1442236 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[109] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(1, 2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[109] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(1, 2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[110] - 1;
                if (value3 < 0) {
                    value3 = 6;
                }
                setCarInfo(1, 3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[110] + 1;
                if (value4 > 6) {
                    value4 = 0;
                }
                setCarInfo(1, 3, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(1, 1, DataCanbus.DATA[108] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog(R.string.xp_yinglang_car_set_Second_str10, 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, WCSaipaShahinTireAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2, value3}, null, null);
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
                        DataCanbus.PROXY.cmd(0, new int[]{2, i, 1}, null, null);
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
    }
}
