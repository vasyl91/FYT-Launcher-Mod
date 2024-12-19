package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ408FuncParkingActi extends BaseActivity {
    private int[] idTempStr = {R.string.wc_15ruijie_temp_unit_c_set, R.string.wc_15ruijie_temp_unit_f_set};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                    RZC_BZ408FuncParkingActi.this.mUpdaterValue3();
                    break;
                case 115:
                    RZC_BZ408FuncParkingActi.this.mUpdaterValue4();
                    break;
                case 123:
                    int value = DataCanbus.DATA[updateCode];
                    if (((TextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_temp_unit_text)) != null && value > -1 && value < RZC_BZ408FuncParkingActi.this.idTempStr.length) {
                        ((TextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_temp_unit_text)).setText(RZC_BZ408FuncParkingActi.this.idTempStr[value]);
                        break;
                    }
                case 156:
                    RZC_BZ408FuncParkingActi.this.mUpdaterValue1();
                    break;
                case 157:
                    RZC_BZ408FuncParkingActi.this.mUpdaterValue2();
                    break;
                case 160:
                    RZC_BZ408FuncParkingActi.this.mUpdaterValue5();
                    break;
                case 170:
                    int value2 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_driver_assist)) != null) {
                        ((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_driver_assist)).setChecked(value2 != 0);
                        break;
                    }
                case 171:
                    int value3 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_turn_light_bydriver)) != null) {
                        ((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_turn_light_bydriver)).setChecked(value3 != 0);
                        break;
                    }
                case 172:
                    int value4 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_only_unlock_backdoor)) != null) {
                        ((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_only_unlock_backdoor)).setChecked(value4 != 0);
                        break;
                    }
                case 173:
                    int value5 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_pilao)) != null) {
                        ((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_pilao)).setChecked(value5 != 0);
                        break;
                    }
                case 174:
                    int value6 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_pullcontrol_sys)) != null) {
                        ((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.rzc_bz4008_pullcontrol_sys)).setChecked(value6 != 0);
                        break;
                    }
            }
        }
    };
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rzc_bz4008_turn_light_bydriver /* 2131432592 */:
                    int value = DataCanbus.DATA[171];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(73, iArr, null, null);
                    break;
                case R.id.rzc_bz4008_only_unlock_backdoor /* 2131432594 */:
                    int value2 = DataCanbus.DATA[172];
                    RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                    int[] iArr2 = new int[1];
                    iArr2[0] = value2 != 0 ? 0 : 1;
                    remoteModuleProxy2.cmd(74, iArr2, null, null);
                    break;
                case R.id.rzc_bz4008_temp_unit /* 2131432596 */:
                    int value3 = DataCanbus.DATA[123];
                    RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                    int[] iArr3 = new int[1];
                    iArr3[0] = value3 != 0 ? 0 : 1;
                    remoteModuleProxy3.cmd(75, iArr3, null, null);
                    break;
                case R.id.rzc_bz4008_pilao /* 2131432599 */:
                    int value4 = DataCanbus.DATA[173];
                    RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                    int[] iArr4 = new int[1];
                    iArr4[0] = value4 != 0 ? 0 : 1;
                    remoteModuleProxy4.cmd(76, iArr4, null, null);
                    break;
                case R.id.rzc_bz4008_pullcontrol_sys /* 2131432601 */:
                    int value5 = DataCanbus.DATA[174];
                    RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                    int[] iArr5 = new int[1];
                    iArr5[0] = value5 != 0 ? 0 : 1;
                    remoteModuleProxy5.cmd(77, iArr5, null, null);
                    break;
                case R.id.rzc_bz4008_driver_assist /* 2131432603 */:
                    int value6 = DataCanbus.DATA[170];
                    RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                    int[] iArr6 = new int[1];
                    iArr6[0] = value6 != 0 ? 0 : 1;
                    remoteModuleProxy6.cmd(78, iArr6, null, null);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_func_parking);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_blind_zone)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[156];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(17, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_start_stop)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[157];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(18, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_welcome_fun)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[100];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(19, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_open_door)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[115];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(20, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_radar1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[160];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(27, iArr, null, null);
            }
        });
        if (DataCanbus.DATA[1000] == 439) {
            if (findViewById(R.id.rzc_bz408_parking_start_stop) != null) {
                findViewById(R.id.rzc_bz408_parking_start_stop).setVisibility(8);
            }
            if (findViewById(R.id.rzc_bz408_parking_welcom) != null) {
                findViewById(R.id.rzc_bz408_parking_welcom).setVisibility(8);
            }
            if (findViewById(R.id.rzc_bz408_parking_open_door) != null) {
                findViewById(R.id.rzc_bz408_parking_open_door).setVisibility(8);
            }
        } else {
            if (findViewById(R.id.rzc_bz408_parking_start_stop) != null) {
                findViewById(R.id.rzc_bz408_parking_start_stop).setVisibility(0);
            }
            if (findViewById(R.id.rzc_bz408_parking_welcom) != null) {
                findViewById(R.id.rzc_bz408_parking_welcom).setVisibility(0);
            }
            if (findViewById(R.id.rzc_bz408_parking_open_door) != null) {
                findViewById(R.id.rzc_bz408_parking_open_door).setVisibility(0);
            }
        }
        findViewById(R.id.rzc_bz4008_turn_light_bydriver_view).setVisibility(0);
        findViewById(R.id.rzc_bz4008_temp_unit_view).setVisibility(0);
        findViewById(R.id.rzc_bz4008_driver_assist_view).setVisibility(0);
        findViewById(R.id.rzc_bz4008_pilao_view).setVisibility(0);
        findViewById(R.id.rzc_bz4008_only_unlock_backdoor_view).setVisibility(0);
        findViewById(R.id.rzc_bz4008_pullcontrol_sys_view).setVisibility(0);
        ((CheckedTextView) findViewById(R.id.rzc_bz4008_turn_light_bydriver)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.rzc_bz4008_temp_unit)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.rzc_bz4008_driver_assist)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.rzc_bz4008_pilao)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.rzc_bz4008_only_unlock_backdoor)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.rzc_bz4008_pullcontrol_sys)).setOnClickListener(this.mClick);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        for (int i = 170; i < 226; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        for (int i = 170; i < 226; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[156];
        if (((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_blind_zone)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_blind_zone)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[157];
        if (((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_start_stop)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_start_stop)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[100];
        if (((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_welcome_fun)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_welcome_fun)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[115];
        if (((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_open_door)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_open_door)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.rzc_bz408_func_tv_door_open)) != null) {
            ((TextView) findViewById(R.id.rzc_bz408_func_tv_door_open)).setText(value != 0 ? R.string.xp_psa_all_string_door_open_1 : R.string.xp_psa_all_string_door_open_0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[160];
        if (((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_radar1)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_parking_radar1)).setChecked(value != 0);
        }
    }
}
