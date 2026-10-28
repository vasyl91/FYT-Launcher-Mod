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

@SuppressWarnings({"deprecation", "unchecked"})
public class BNR_QiChenT70Act extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    BNR_QiChenT70Act.this.updaterSmartInsert();
                    break;
                case 99:
                    BNR_QiChenT70Act.this.updaterFirstStart();
                    break;
                case 100:
                    BNR_QiChenT70Act.this.updaterAvmAnima();
                    break;
                case 101:
                    BNR_QiChenT70Act.this.updaterAvmD03();
                    break;
                case 102:
                    BNR_QiChenT70Act.this.updaterAvmD02();
                    break;
                case 103:
                    BNR_QiChenT70Act.this.updaterAvmD01();
                    break;
                case 104:
                    BNR_QiChenT70Act.this.updaterAvmD00();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_t70_set);
        init();
        setUI();
    }

    @Override
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterAvmD03() {
        int value = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D03)).setChecked(value != 0);
    }

    
    public void updaterAvmD02() {
        int value = DataCanbus.DATA[102];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D02)).setChecked(value != 0);
    }

    
    public void updaterAvmD01() {
        int value = DataCanbus.DATA[103];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D01)).setChecked(value != 0);
    }

    
    public void updaterAvmD00() {
        int value = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_D00)).setChecked(value != 0);
    }

    
    public void updaterSmartInsert() {
        int mSmartInsertState = DataCanbus.DATA[98];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_intelligent_insert_check)).setChecked(mSmartInsertState != 0);
    }

    
    public void updaterFirstStart() {
        int mFirstStartState = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_first_forward_speed_automatic_start_check)).setChecked(mFirstStartState != 0);
    }

    
    public void updaterAvmAnima() {
        int mAvmAnimState = DataCanbus.DATA[100];
        ((CheckedTextView) findViewById(R.id.rzc_qicheng_t70_atm_animation_check)).setChecked(mAvmAnimState != 0);
    }

    @Override
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.rzc_qicheng_t70_intelligent_insert_check /* 2131432761 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = DataCanbus.DATA[98] == 0 ? 1 : 0;
                remoteModuleProxy.cmd(0, iArr, null, null);
                break;
            case R.id.rzc_qicheng_t70_first_forward_speed_automatic_start_check /* 2131432763 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 2;
                iArr2[1] = DataCanbus.DATA[99] == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(0, iArr2, null, null);
                break;
            case R.id.rzc_qicheng_t70_atm_animation_check /* 2131432764 */:
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 3;
                iArr3[1] = DataCanbus.DATA[100] == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(0, iArr3, null, null);
                break;
            case R.id.rzc_qicheng_t70_atm_D03 /* 2131432766 */:
                int value = DataCanbus.DATA[101];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 5;
                iArr4[1] = value == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(0, iArr4, null, null);
                break;
            case R.id.rzc_qicheng_t70_atm_D02 /* 2131432768 */:
                int value2 = DataCanbus.DATA[102];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 6;
                iArr5[1] = value2 == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(0, iArr5, null, null);
                break;
            case R.id.rzc_qicheng_t70_atm_D01 /* 2131432770 */:
                int value3 = DataCanbus.DATA[103];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 7;
                iArr6[1] = value3 == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(0, iArr6, null, null);
                break;
            case R.id.rzc_qicheng_t70_atm_D00 /* 2131432772 */:
                int value4 = DataCanbus.DATA[104];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 8;
                iArr7[1] = value4 == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(0, iArr7, null, null);
                break;
            case R.id.rzc_qicheng_t70_default_check /* 2131432773 */:
                dialog(R.string.all_settings);
                break;
        }
    }

    protected void dialog(int stringId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{4, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
