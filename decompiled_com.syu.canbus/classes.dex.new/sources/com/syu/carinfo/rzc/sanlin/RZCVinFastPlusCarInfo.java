package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCVinFastPlusCarInfo extends BaseActivity implements View.OnClickListener {
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.RZCVinFastPlusCarInfo.1
        @Override // java.lang.Runnable
        public void run() {
            ((TextView) RZCVinFastPlusCarInfo.this.findViewById(R.id.tv_text3)).setText("Normal Charging");
            HandlerUI.getInstance().removeCallbacks(RZCVinFastPlusCarInfo.this.mCalTime);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCVinFastPlusCarInfo.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 117:
                    if (((TextView) RZCVinFastPlusCarInfo.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZCVinFastPlusCarInfo.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 118:
                    if (((TextView) RZCVinFastPlusCarInfo.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RZCVinFastPlusCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                        ((ProgressBar) RZCVinFastPlusCarInfo.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value);
                        ((ProgressBar) RZCVinFastPlusCarInfo.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                    }
                    break;
                case 119:
                    if (((TextView) RZCVinFastPlusCarInfo.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 1) {
                            ((TextView) RZCVinFastPlusCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(RZCVinFastPlusCarInfo.this.getResources().getString(R.string.str_charging_gun_state)) + ": " + RZCVinFastPlusCarInfo.this.getResources().getString(R.string.str_connected));
                            HandlerUI.getInstance().removeCallbacks(RZCVinFastPlusCarInfo.this.mCalTime);
                            HandlerUI.getInstance().postDelayed(RZCVinFastPlusCarInfo.this.mCalTime, 2000L);
                        } else {
                            ((TextView) RZCVinFastPlusCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(RZCVinFastPlusCarInfo.this.getResources().getString(R.string.str_charging_gun_state)) + ": " + RZCVinFastPlusCarInfo.this.getResources().getString(R.string.str_unconnected));
                        }
                    }
                    break;
                case 120:
                    if (((TextView) RZCVinFastPlusCarInfo.this.findViewById(R.id.tv_text5)) != null) {
                        if ((value & 255) == 255) {
                            ((TextView) RZCVinFastPlusCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                        } else {
                            int hour = value / 60;
                            int min = value % 60;
                            ((TextView) RZCVinFastPlusCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(hour) + "h " + min + "min");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_rzc_vinfast_ev_carinfo);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{64, 0}, null, null);
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
            case R.id.btn_plus1 /* 2131427458 */:
                dialog(R.string.str_stop_charging, 51);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm)) + " " + getResources().getString(stringId));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.RZCVinFastPlusCarInfo.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.RZCVinFastPlusCarInfo.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.RZCVinFastPlusCarInfo.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
    }
}
