package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.lz.jaguar.WCSanlinChargeIndexActi;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WC2SanlinCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WC2SanlinCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 115:
                    WC2SanlinCarInfo.this.updateCarinfo1();
                    break;
                case 116:
                    WC2SanlinCarInfo.this.updateCarinfo2();
                    break;
                case 117:
                    if (value == 16777215) {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                    } else {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10.0f) + " km");
                    }
                    break;
                case 118:
                    if (value == 65535) {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                    } else {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10.0f) + " km/L");
                    }
                    break;
                case 119:
                    if (value == 255) {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                    } else {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10.0f) + " V");
                    }
                    break;
                case 120:
                    if (value == 255) {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                    } else {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value - 40) + " ℃");
                    }
                    break;
                case 121:
                    if (value == 255) {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                    } else {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10.0f) + " cc/s");
                    }
                    break;
                case 146:
                    WC2SanlinCarInfo.this.findViewById(R.id.layout_view4).setVisibility(value == 1 ? 0 : 8);
                    break;
                case 157:
                    if (value == 65535) {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text8)).setText("----");
                    } else {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 158:
                    if (value == 65535) {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text9)).setText("----");
                    } else {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10.0f) + " km/kWh");
                    }
                    break;
                case 159:
                    if (value == 65535) {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text10)).setText("----");
                    } else {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 160:
                    if (value == 255) {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text11)).setText("----");
                    } else {
                        ((TextView) WC2SanlinCarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "%");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_sanlin_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_XForce_24 /* 6357436 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                break;
        }
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                dialog(getResources().getString(R.string.bmw_cleanoil), 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, WC2SanlinXForceCarSet.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, WC2SanlinElectricActi.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, WC2SanlinTireAct.class);
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                try {
                    Intent intent4 = new Intent();
                    intent4.setClass(this, WC2SanlinXForceCarInfo.class);
                    startActivity(intent4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                try {
                    Intent intent5 = new Intent();
                    intent5.setClass(this, WC2SanlinAHDActi.class);
                    startActivity(intent5);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                dialog("Trip-Auto", 2);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                try {
                    Intent intent6 = new Intent();
                    intent6.setClass(this, WCSanlinChargeIndexActi.class);
                    startActivity(intent6);
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
                break;
        }
    }

    protected void dialog(String string, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + string + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.WC2SanlinCarInfo.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.WC2SanlinCarInfo.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.WC2SanlinCarInfo.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[116];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10.0f) + " km/L");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[115];
        if (value == 16777215) {
            ((TextView) findViewById(R.id.tv_text1)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " km");
        }
    }
}
