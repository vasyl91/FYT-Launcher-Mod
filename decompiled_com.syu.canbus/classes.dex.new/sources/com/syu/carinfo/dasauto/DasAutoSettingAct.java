package com.syu.carinfo.dasauto;

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
public class DasAutoSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.DasAutoSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 106:
                    DasAutoSettingAct.this.sideParking();
                    break;
                case 107:
                    DasAutoSettingAct.this.storageParking();
                    break;
                case 108:
                    DasAutoSettingAct.this.radarMute();
                    break;
                case 123:
                    ((TextView) DasAutoSettingAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 124:
                    ((TextView) DasAutoSettingAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    break;
                case 125:
                    ((TextView) DasAutoSettingAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dasauto_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value0 = DataCanbus.DATA[123];
                int value1 = DataCanbus.DATA[124];
                int value2 = DataCanbus.DATA[125];
                if (value0 > 0) {
                    value0--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value0, value1, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value3 = DataCanbus.DATA[123];
                int value4 = DataCanbus.DATA[124];
                int value5 = DataCanbus.DATA[125];
                if (value3 < 255) {
                    value3++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value3, value4, value5}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value6 = DataCanbus.DATA[123];
                int value7 = DataCanbus.DATA[124];
                int value8 = DataCanbus.DATA[125];
                if (value7 > 0) {
                    value7--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value6, value7, value8}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value9 = DataCanbus.DATA[123];
                int value10 = DataCanbus.DATA[124];
                int value11 = DataCanbus.DATA[125];
                if (value10 < 255) {
                    value10++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value9, value10, value11}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value12 = DataCanbus.DATA[123];
                int value13 = DataCanbus.DATA[124];
                int value14 = DataCanbus.DATA[125];
                if (value14 > 0) {
                    value14--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value12, value13, value14}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value15 = DataCanbus.DATA[123];
                int value16 = DataCanbus.DATA[124];
                int value17 = DataCanbus.DATA[125];
                if (value17 < 255) {
                    value17++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value15, value16, value17}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                TimeSyncialog();
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value = DataCanbus.DATA[108];
                DataCanbus.PROXY.cmd(2, value != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value18 = DataCanbus.DATA[106];
                DataCanbus.PROXY.cmd(0, value18 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value19 = DataCanbus.DATA[107];
                DataCanbus.PROXY.cmd(1, value19 == 0 ? 1 : 0);
                break;
        }
    }

    private void TimeSyncialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_cartime_sync));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.dasauto.DasAutoSettingAct.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.dasauto.DasAutoSettingAct.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(3, 1);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.dasauto.DasAutoSettingAct.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sideParking() {
        int value = DataCanbus.DATA[106];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storageParking() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void radarMute() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }
}
