package com.syu.carinfo.rzc.t70;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BNR_QiChenT70Act extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.t70.BNR_QiChenT70Act.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 22:
                    BNR_QiChenT70Act.this.updaterSmartInsert();
                    break;
                case 23:
                    BNR_QiChenT70Act.this.updaterFirstStart();
                    break;
                case 24:
                    BNR_QiChenT70Act.this.updaterAvmAnima();
                    break;
                case 25:
                    BNR_QiChenT70Act.this.updaterAvmD03();
                    break;
                case 26:
                    BNR_QiChenT70Act.this.updaterAvmD02();
                    break;
                case 27:
                    BNR_QiChenT70Act.this.updaterAvmD01();
                    break;
                case 28:
                    BNR_QiChenT70Act.this.updaterAvmD00();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_t70_set);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_intelligent_insert_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_first_forward_speed_automatic_start_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_animation_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D03)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D02)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D01)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D00)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_default_check)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAvmD03() {
        int value = DataCanbus.DATA[25];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D03)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAvmD02() {
        int value = DataCanbus.DATA[26];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D02)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAvmD01() {
        int value = DataCanbus.DATA[27];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D01)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAvmD00() {
        int value = DataCanbus.DATA[28];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D00)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSmartInsert() {
        int mSmartInsertState = DataCanbus.DATA[22];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_intelligent_insert_check)).setChecked(mSmartInsertState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFirstStart() {
        int mFirstStartState = DataCanbus.DATA[23];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_first_forward_speed_automatic_start_check)).setChecked(mFirstStartState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAvmAnima() {
        int mAvmAnimState = DataCanbus.DATA[24];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_animation_check)).setChecked(mAvmAnimState != 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.rzc_qicheng_t70_intelligent_insert_check /* 2131432835 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = DataCanbus.DATA[22] == 0 ? 1 : 0;
                remoteModuleProxy.cmd(0, iArr, null, null);
                break;
            case R.id.rzc_qicheng_t70_first_forward_speed_automatic_start_check /* 2131432837 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 2;
                iArr2[1] = DataCanbus.DATA[23] == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(0, iArr2, null, null);
                break;
            case R.id.rzc_qicheng_t70_atm_animation_check /* 2131432838 */:
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 3;
                iArr3[1] = DataCanbus.DATA[24] == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(0, iArr3, null, null);
                break;
            case R.id.rzc_qicheng_t70_atm_D03 /* 2131432840 */:
                int value = DataCanbus.DATA[25];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 5;
                iArr4[1] = value == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(0, iArr4, null, null);
                break;
            case R.id.rzc_qicheng_t70_atm_D02 /* 2131432842 */:
                int value2 = DataCanbus.DATA[26];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 6;
                iArr5[1] = value2 == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(0, iArr5, null, null);
                break;
            case R.id.rzc_qicheng_t70_atm_D01 /* 2131432844 */:
                int value3 = DataCanbus.DATA[27];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 7;
                iArr6[1] = value3 == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(0, iArr6, null, null);
                break;
            case R.id.rzc_qicheng_t70_atm_D00 /* 2131432846 */:
                int value4 = DataCanbus.DATA[28];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 8;
                iArr7[1] = value4 == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(0, iArr7, null, null);
                break;
            case R.id.rzc_qicheng_t70_default_check /* 2131432847 */:
                dialog(R.string.all_settings);
                break;
        }
    }

    protected void dialog(int stringId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.t70.BNR_QiChenT70Act.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.t70.BNR_QiChenT70Act.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{4, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.t70.BNR_QiChenT70Act.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.t70.BNR_QiChenT70Act.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}