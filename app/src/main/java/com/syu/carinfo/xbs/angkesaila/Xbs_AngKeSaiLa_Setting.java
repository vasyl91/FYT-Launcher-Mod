package com.syu.carinfo.xbs.angkesaila;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Xbs_AngKeSaiLa_Setting extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.d("LG", "MupdateCode::" + updateCode);
            switch (updateCode) {
                case 16:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D07();
                    break;
                case 17:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D04();
                    break;
                case 18:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D02();
                    break;
                case 19:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D00();
                    break;
                case 20:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D17();
                    break;
                case 21:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D16();
                    break;
                case 22:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D15();
                    break;
                case 23:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D14();
                    break;
                case 24:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D12();
                    break;
                case 25:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D10();
                    break;
                case 26:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D27();
                    break;
                case 27:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D26();
                    break;
                case 28:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D25();
                    break;
                case 29:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D24();
                    break;
                case 30:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D23();
                    break;
                case 31:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D22();
                    break;
                case 32:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D20();
                    break;
                case 33:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D36();
                    break;
                case 34:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D33();
                    break;
                case 35:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D30();
                    break;
                case 36:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D40();
                    break;
                case 37:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D50();
                    break;
                case 38:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D60();
                    break;
                case 45:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D77();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_418_xbs_angkesaila);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.jeep_rain_sense_wipers)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[16];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_nokey_enter_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[18];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_nokey_enter_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[18];
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_autolock_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[17];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_autolock_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[17];
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_relock_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[19];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_relock_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[19];
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_unlock_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[20];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_unlock_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[20];
                if (value2 < 1) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_leave_lock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[21];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_flash_light)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[22];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_turn_sign_vol_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[23];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_turn_sign_vol_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[23];
                if (value2 < 1) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_open_light_off_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[24];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_open_light_off_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[24];
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_close_light_off_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[25];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_close_light_off_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[25];
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{9, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_light_system)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[26];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 10;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_bright_con_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[27];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{15, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_bright_con_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[27];
                if (value2 < 1) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{15, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_drive_dis)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[28];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 17;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_drive_nav)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[29];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 18;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_smart_break)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[30];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 20;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_eco_sync)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[31];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 22;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_blind_vol_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[32];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{21, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_blind_vol_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[32];
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{21, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_no_release_remind_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[33];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_no_release_remind_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[33];
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_light_off_time_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[34];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_light_off_time_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[34];
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_auto_light_open_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[35];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_auto_light_open_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[35];
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_drive_high_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[36];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_drive_high_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[36];
                if (value2 < 26) {
                    value = value2 + 1;
                } else {
                    value = 26;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_drive_bright_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[37];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_drive_bright_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[37];
                if (value2 < 40) {
                    value = value2 + 1;
                } else {
                    value = 40;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_dirve_cal_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[38];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_dirve_cal_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[38];
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_functional_factory_eco)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Xbs_AngKeSaiLa_Setting.this.dialog(R.string.str_418_reset_eco, 23);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_leaving_home)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[45];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 48;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_functional_factory_all_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Xbs_AngKeSaiLa_Setting.this.dialog(R.string.all_settings, 24);
            }
        });
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
                        DataCanbus.PROXY.cmd(1, new int[]{i}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
    }

    
    public void mSetting_09D07() {
        int value = DataCanbus.DATA[16];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.jeep_rain_sense_wipers)).setChecked(switchOn != 0);
    }

    
    public void mSetting_09D04() {
        int value = DataCanbus.DATA[17];
        if (((TextView) findViewById(R.id.xbs_autolock_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_autolock_set_show)).setText(R.string.str_418_relock1);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xbs_autolock_set_show)).setText(R.string.str_418_relock2);
                return;
            }
            if (value == 3) {
                ((TextView) findViewById(R.id.xbs_autolock_set_show)).setText(R.string.str_418_relock3);
            } else if (value == 4) {
                ((TextView) findViewById(R.id.xbs_autolock_set_show)).setText(R.string.str_418_relock4);
            } else {
                ((TextView) findViewById(R.id.xbs_autolock_set_show)).setText(R.string.off);
            }
        }
    }

    
    public void mSetting_09D02() {
        int value = DataCanbus.DATA[18];
        if (((TextView) findViewById(R.id.xbs_nokey_enter_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_nokey_enter_set_show)).setText(R.string.wc_372_low);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xbs_nokey_enter_set_show)).setText(R.string.wc_372_mid);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.xbs_nokey_enter_set_show)).setText(R.string.wc_372_high);
            } else {
                ((TextView) findViewById(R.id.xbs_nokey_enter_set_show)).setText(R.string.wc_372_volumestr0);
            }
        }
    }

    
    public void mSetting_09D00() {
        int value = DataCanbus.DATA[19];
        if (((TextView) findViewById(R.id.xbs_relock_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_relock_set_show)).setText("60S");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.xbs_relock_set_show)).setText("90S");
            } else {
                ((TextView) findViewById(R.id.xbs_relock_set_show)).setText("30S");
            }
        }
    }

    
    public void mSetting_09D17() {
        int value = DataCanbus.DATA[20];
        if (((TextView) findViewById(R.id.xbs_unlock_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_unlock_set_show)).setText(R.string.str_418_unlock2);
            } else {
                ((TextView) findViewById(R.id.xbs_unlock_set_show)).setText(R.string.str_418_unlock1);
            }
        }
    }

    
    public void mSetting_09D16() {
        int value = DataCanbus.DATA[21];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_leave_lock)).setChecked(switchOn != 0);
    }

    
    public void mSetting_09D15() {
        int value = DataCanbus.DATA[22];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_flash_light)).setChecked(switchOn != 0);
    }

    
    public void mSetting_09D14() {
        int value = DataCanbus.DATA[23];
        if (((TextView) findViewById(R.id.xbs_turn_sign_vol_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_turn_sign_vol_set_show)).setText(R.string.klc_air_high);
            } else {
                ((TextView) findViewById(R.id.xbs_turn_sign_vol_set_show)).setText(R.string.klc_air_low);
            }
        }
    }

    
    public void mSetting_09D12() {
        int value = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.xbs_open_light_off_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_open_light_off_set_show)).setText("30Min");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.xbs_open_light_off_set_show)).setText("60Min");
            } else {
                ((TextView) findViewById(R.id.xbs_open_light_off_set_show)).setText("10Min");
            }
        }
    }

    
    public void mSetting_09D10() {
        int value = DataCanbus.DATA[25];
        if (((TextView) findViewById(R.id.xbs_close_light_off_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_close_light_off_set_show)).setText("15 S");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xbs_close_light_off_set_show)).setText("30 S");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.xbs_close_light_off_set_show)).setText("60 S");
            } else {
                ((TextView) findViewById(R.id.xbs_close_light_off_set_show)).setText("7.5 S");
            }
        }
    }

    
    public void mSetting_09D27() {
        int value = DataCanbus.DATA[26];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_light_system)).setChecked(switchOn != 0);
    }

    
    public void mSetting_09D26() {
        int value = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.xbs_bright_con_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_bright_con_set_show)).setText(R.string.klc_air_Manual);
            } else {
                ((TextView) findViewById(R.id.xbs_bright_con_set_show)).setText(R.string.klc_air_auto);
            }
        }
    }

    
    public void mSetting_09D25() {
        int value = DataCanbus.DATA[28];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_drive_dis)).setChecked(switchOn != 0);
    }

    
    public void mSetting_09D24() {
        int value = DataCanbus.DATA[29];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_drive_nav)).setChecked(switchOn != 0);
    }

    
    public void mSetting_09D23() {
        int value = DataCanbus.DATA[30];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_smart_break)).setChecked(switchOn != 0);
    }

    
    public void mSetting_09D22() {
        int value = DataCanbus.DATA[31];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_eco_sync)).setChecked(switchOn != 0);
    }

    
    public void mSetting_09D20() {
        int value = DataCanbus.DATA[32];
        if (((TextView) findViewById(R.id.xbs_blind_vol_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_blind_vol_set_show)).setText(R.string.klc_air_low);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.xbs_blind_vol_set_show)).setText(R.string.klc_air_high);
            } else {
                ((TextView) findViewById(R.id.xbs_blind_vol_set_show)).setText(R.string.off);
            }
        }
    }

    
    public void mSetting_09D36() {
        int value = DataCanbus.DATA[33];
        if (((TextView) findViewById(R.id.xbs_no_release_remind_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_no_release_remind_set_show)).setText(R.string.klc_air_low);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.xbs_no_release_remind_set_show)).setText(R.string.klc_air_high);
            } else {
                ((TextView) findViewById(R.id.xbs_no_release_remind_set_show)).setText(R.string.off);
            }
        }
    }

    
    public void mSetting_09D33() {
        int value = DataCanbus.DATA[34];
        if (((TextView) findViewById(R.id.xbs_light_off_time_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_light_off_time_set_show)).setText("30 S");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xbs_light_off_time_set_show)).setText("60 S");
                return;
            }
            if (value == 3) {
                ((TextView) findViewById(R.id.xbs_light_off_time_set_show)).setText("90 S");
            } else if (value == 4) {
                ((TextView) findViewById(R.id.xbs_light_off_time_set_show)).setText("120 S");
            } else {
                ((TextView) findViewById(R.id.xbs_light_off_time_set_show)).setText(R.string.off);
            }
        }
    }

    
    public void mSetting_09D30() {
        int value = DataCanbus.DATA[35];
        if (((TextView) findViewById(R.id.xbs_auto_light_open_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_auto_light_open_set_show)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_3);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xbs_auto_light_open_set_show)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_2);
                return;
            }
            if (value == 3) {
                ((TextView) findViewById(R.id.xbs_auto_light_open_set_show)).setText(R.string.str_wc_mzd_cx5_auto_headlight_on_1);
            } else if (value == 4) {
                ((TextView) findViewById(R.id.xbs_auto_light_open_set_show)).setText(R.string.str_screen_bright_brightest);
            } else {
                ((TextView) findViewById(R.id.xbs_auto_light_open_set_show)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_4);
            }
        }
    }

    
    public void mSetting_09D40() {
        int value = DataCanbus.DATA[36] & 255;
        int value2 = value - 13;
        if (((TextView) findViewById(R.id.xbs_drive_high_set_show)) != null) {
            ((TextView) findViewById(R.id.xbs_drive_high_set_show)).setText(new StringBuilder().append(value2).toString());
        }
    }

    
    public void mSetting_09D50() {
        int value = DataCanbus.DATA[37] & 255;
        int value2 = value - 20;
        if (((TextView) findViewById(R.id.xbs_drive_bright_set_show)) != null) {
            ((TextView) findViewById(R.id.xbs_drive_bright_set_show)).setText(new StringBuilder().append(value2).toString());
        }
    }

    
    public void mSetting_09D60() {
        int value = DataCanbus.DATA[38] & 255;
        int value2 = value - 2;
        if (((TextView) findViewById(R.id.xbs_dirve_cal_set_show)) != null) {
            ((TextView) findViewById(R.id.xbs_dirve_cal_set_show)).setText(new StringBuilder().append(value2).toString());
        }
    }

    
    public void mSetting_09D77() {
        int value = DataCanbus.DATA[45];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_leaving_home)).setChecked(switchOn != 0);
    }
}
