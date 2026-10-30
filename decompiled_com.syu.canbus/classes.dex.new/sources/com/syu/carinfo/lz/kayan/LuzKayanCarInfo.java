package com.syu.carinfo.lz.kayan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzKayanCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.kayan.LuzKayanCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 152:
                    int hour = (value >> 8) & 65535;
                    int min = value & 255;
                    ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(hour) + "H" + (min / 10) + (min % 10) + "M");
                    break;
                case 153:
                    if (value == 16777215) {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                    } else {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 154:
                    if (value == 65535) {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                    } else {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                    }
                    break;
                case 155:
                    if (value == 65535) {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                    } else {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/h");
                    }
                    break;
                case 156:
                    int hour2 = (value >> 8) & 65535;
                    int min2 = value & 255;
                    ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(hour2) + "H" + (min2 / 10) + (min2 % 10) + "M");
                    break;
                case 157:
                    if (value == 16777215) {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                    } else {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 158:
                    if (value == 65535) {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                    } else {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                    }
                    break;
                case 159:
                    if (value == 65535) {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text8)).setText("----");
                    } else {
                        ((TextView) LuzKayanCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/h");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_luz_kayan_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                dialog(R.string.str_current_journey, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                dialog(R.string.wc_ruiteng_string_oil_sum_travel, 1);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanCarInfo.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.lz.kayan.LuzKayanCarInfo.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{13, i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanCarInfo.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.notifyCanbus);
    }
}
