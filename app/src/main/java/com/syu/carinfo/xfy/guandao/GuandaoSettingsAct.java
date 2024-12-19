package com.syu.carinfo.xfy.guandao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.accord9.wc.AccordConfig;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GuandaoSettingsAct extends BaseActivity implements View.OnClickListener {
    private int[] mInt2 = {0, 1};
    private int[] mInt3 = {0, 1, 2};
    private int[] mInt4 = {0, 1, 2, 3};
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 34:
                    GuandaoSettingsAct.this.mUpdaterHeadLampsAutoOffTimer();
                    break;
                case 35:
                    GuandaoSettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 36:
                    GuandaoSettingsAct.this.mUpdaterD2B07();
                    break;
                case 37:
                    GuandaoSettingsAct.this.mUpdaterD2B06();
                    break;
                case 38:
                    GuandaoSettingsAct.this.mUpdaterD2B04();
                    break;
                case 39:
                    GuandaoSettingsAct.this.mUpdaterD2B02();
                    break;
                case 40:
                    GuandaoSettingsAct.this.mUpdaterD2B00();
                    break;
                case 41:
                    GuandaoSettingsAct.this.mUpdaterD3B07();
                    break;
                case 42:
                    GuandaoSettingsAct.this.mUpdaterD3B06();
                    break;
                case 43:
                    GuandaoSettingsAct.this.mUpdaterD3B05();
                    break;
                case 44:
                    GuandaoSettingsAct.this.mUpdaterD3B04();
                    break;
                case 45:
                    GuandaoSettingsAct.this.mUpdaterD4B07();
                    break;
                case 46:
                    GuandaoSettingsAct.this.mUpdaterD4B06();
                    break;
                case 47:
                    GuandaoSettingsAct.this.mUpdaterLoud();
                    break;
                case 48:
                    GuandaoSettingsAct.this.mUpdaterSpeedvol();
                    break;
                case 49:
                    GuandaoSettingsAct.this.mUpdaterDts();
                    break;
                case 50:
                    GuandaoSettingsAct.this.mUpdaterD0B02();
                    break;
                case 51:
                    GuandaoSettingsAct.this.mUpdaterD0B00();
                    break;
                case 52:
                    GuandaoSettingsAct.this.mUpdaterD5B06();
                    break;
                case 53:
                    GuandaoSettingsAct.this.mUpdaterD5B05();
                    break;
                case 54:
                    GuandaoSettingsAct.this.mUpdaterD5B04();
                    break;
                case 55:
                    GuandaoSettingsAct.this.mUpdaterD5B03();
                    break;
                case 56:
                    GuandaoSettingsAct.this.mUpdaterD5B02();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xfy_guandao);
        initView();
        setListener();
    }

    private void initView() {
        ((CheckedTextView) findViewById(R.id.guandao_TPMS_Calibration)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                GuandaoSettingsAct.this.dialog(R.string.str_other_set_TPMS_Calibration, 19);
            }
        });
        ((CheckedTextView) findViewById(R.id.guandao_Maintenance_Reset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                GuandaoSettingsAct.this.dialog(R.string.str_other_set_Maintenance_Reset, 18);
            }
        });
        if (DataCanbus.DATA[1000] == 425) {
            findViewById(R.id.guandao_amp_view).setVisibility(8);
            findViewById(R.id.guandao_amp_loud_view).setVisibility(8);
            findViewById(R.id.guandao_speed_view).setVisibility(8);
            findViewById(R.id.guandao_dts_view).setVisibility(8);
            return;
        }
        findViewById(R.id.guandao_amp_view).setVisibility(0);
        findViewById(R.id.guandao_amp_loud_view).setVisibility(0);
        findViewById(R.id.guandao_speed_view).setVisibility(0);
        findViewById(R.id.guandao_dts_view).setVisibility(0);
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.guandao_ctv_remote_latch_show)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.guandao_lock_remote_latch_show)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.guandao_keyless_access_beep)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.guandao_beep_lockLight)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.guandao_beep_start)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.guandao_dts)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_btn_auto_relock_time_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_btn_turn_off_time_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_btn_cytoreductive_time_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_btn_auto_lock_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_btn_auto_unlock_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_keyless_access_beep_volume_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_diandongshoub_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_remote_open_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_amp_loud_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_speed_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_btn_auto_relock_time_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_btn_turn_off_time_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_btn_cytoreductive_time_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_btn_auto_lock_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_btn_auto_unlock_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_keyless_access_beep_volume_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_remote_open_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_diandongshoub_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_amp_loud_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.guandao_speed_add)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.notifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(stringId));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD0B02() {
        int value = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.guandao_amp_loud)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.guandao_amp_loud)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD0B00() {
        int value = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.guandao_amp_loud)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.guandao_amp_loud)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD5B06() {
        int value = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.guandao_amp_loud)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.guandao_amp_loud)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD5B05() {
        int value = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.guandao_amp_loud)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.guandao_amp_loud)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD5B04() {
        int value = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.guandao_amp_loud)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.guandao_amp_loud)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD5B03() {
        int value = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.guandao_amp_loud)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.guandao_amp_loud)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD5B02() {
        int value = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.guandao_amp_loud)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.guandao_amp_loud)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLoud() {
        int value = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.guandao_amp_loud)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.guandao_amp_loud)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpeedvol() {
        int value = DataCanbus.DATA[48];
        if (((TextView) findViewById(R.id.guandao_speed)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.guandao_speed)).setText(R.string.klc_air_low);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.guandao_speed)).setText(R.string.klc_air_middle);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.guandao_speed)).setText(R.string.klc_air_high);
            } else {
                ((TextView) findViewById(R.id.guandao_speed)).setText(R.string.str_right_camera_close);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDts() {
        int value = DataCanbus.DATA[49];
        if (((CheckedTextView) findViewById(R.id.guandao_dts)) != null) {
            ((CheckedTextView) findViewById(R.id.guandao_dts)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD4B07() {
        int value = DataCanbus.DATA[45];
        if (((TextView) findViewById(R.id.guandao_diandongshoub)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.guandao_diandongshoub)).setText(R.string.str_right_camera_open);
            } else {
                ((TextView) findViewById(R.id.guandao_diandongshoub)).setText(R.string.str_right_camera_close);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD4B06() {
        int value = DataCanbus.DATA[46];
        if (((TextView) findViewById(R.id.guandao_remote_open)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.guandao_remote_open)).setText(R.string.str_guandao_remote_open2);
            } else {
                ((TextView) findViewById(R.id.guandao_remote_open)).setText(R.string.str_guandao_remote_open1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD3B07() {
        int value = DataCanbus.DATA[41];
        if (((TextView) findViewById(R.id.guandao_keyless_access_beep_volume)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.guandao_keyless_access_beep_volume)).setText(R.string.distance_far);
            } else {
                ((TextView) findViewById(R.id.guandao_keyless_access_beep_volume)).setText(R.string.distance_close);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD3B06() {
        int value = DataCanbus.DATA[42];
        if (((CheckedTextView) findViewById(R.id.guandao_keyless_access_beep)) != null) {
            ((CheckedTextView) findViewById(R.id.guandao_keyless_access_beep)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD3B05() {
        int value = DataCanbus.DATA[43];
        if (((CheckedTextView) findViewById(R.id.guandao_beep_lockLight)) != null) {
            ((CheckedTextView) findViewById(R.id.guandao_beep_lockLight)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD3B04() {
        int value = DataCanbus.DATA[44];
        if (((CheckedTextView) findViewById(R.id.guandao_beep_start)) != null) {
            ((CheckedTextView) findViewById(R.id.guandao_beep_start)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD2B07() {
        int mReceiverRemoteLatchShow = DataCanbus.DATA[36];
        if (((CheckedTextView) findViewById(R.id.guandao_ctv_remote_latch_show)) != null) {
            ((CheckedTextView) findViewById(R.id.guandao_ctv_remote_latch_show)).setChecked(mReceiverRemoteLatchShow != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD2B06() {
        int mGuanDaoLockShow = DataCanbus.DATA[37];
        if (((CheckedTextView) findViewById(R.id.guandao_lock_remote_latch_show)) != null) {
            ((CheckedTextView) findViewById(R.id.guandao_lock_remote_latch_show)).setChecked(mGuanDaoLockShow != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD2B04() {
        String[] mStrLockSetAutoTime = {"30s", "60s", "90s"};
        int mReceiverAutoRelockTime = DataCanbus.DATA[38];
        if (((TextView) findViewById(R.id.guandao_tv_auto_relock_time)) != null && mReceiverAutoRelockTime > -1 && mReceiverAutoRelockTime < 3) {
            ((TextView) findViewById(R.id.guandao_tv_auto_relock_time)).setText(mStrLockSetAutoTime[mReceiverAutoRelockTime]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD2B00() {
        int value = DataCanbus.DATA[40];
        if (((TextView) findViewById(R.id.guandao_tv_auto_lock)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.guandao_tv_auto_lock)).setText(R.string.guandao_lock1);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.guandao_tv_auto_lock)).setText(R.string.guandao_lock2);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.guandao_tv_auto_lock)).setText(R.string.guandao_lock3);
            } else {
                ((TextView) findViewById(R.id.guandao_tv_auto_lock)).setText(R.string.rzc_c4l_close);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD2B02() {
        int value = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.guandao_tv_auto_unlock)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.guandao_tv_auto_unlock)).setText(R.string.guandao_unlock1);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.guandao_tv_auto_unlock)).setText(R.string.guandao_unlock2);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.guandao_tv_auto_unlock)).setText(R.string.guandao_lock3);
            } else {
                ((TextView) findViewById(R.id.guandao_tv_auto_unlock)).setText(R.string.rzc_c4l_close);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsAutoOffTimer() {
        String[] mStrLightOffAutoTime = {"0", "15s", "30s", "60s"};
        int mReceiverTurnOffTime = DataCanbus.DATA[34];
        if (((TextView) findViewById(R.id.guandao_tv_turn_off_time)) != null && mReceiverTurnOffTime > -1 && mReceiverTurnOffTime < 4) {
            ((TextView) findViewById(R.id.guandao_tv_turn_off_time)).setText(mStrLightOffAutoTime[mReceiverTurnOffTime]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightOffTime() {
        String[] mStrLightOffAutoTime = {"15s", "30s", "60s"};
        int mReceiverCytoreductiveTime = DataCanbus.DATA[35];
        if (((TextView) findViewById(R.id.guandao_tv_cytoreductive_time)) != null && mReceiverCytoreductiveTime > -1 && mReceiverCytoreductiveTime < 3) {
            ((TextView) findViewById(R.id.guandao_tv_cytoreductive_time)).setText(mStrLightOffAutoTime[mReceiverCytoreductiveTime]);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.guandao_ctv_remote_latch_show /* 2131433284 */:
                int mSendRemoteLatchShow = (DataCanbus.DATA[36] + 1) % 2;
                DataCanbus.PROXY.cmd(1, new int[]{10, this.mInt2[mSendRemoteLatchShow]}, null, null);
                break;
            case R.id.guandao_lock_remote_latch_show /* 2131433285 */:
                int mGuanDaoLockShow = (DataCanbus.DATA[37] + 1) % 2;
                DataCanbus.PROXY.cmd(1, new int[]{9, this.mInt2[mGuanDaoLockShow]}, null, null);
                break;
            case R.id.guandao_btn_auto_relock_time_sub /* 2131433286 */:
                int mReceiverAutoRelockTime = DataCanbus.DATA[38] - 1;
                if (mReceiverAutoRelockTime < 0) {
                    mReceiverAutoRelockTime = 2;
                } else if (mReceiverAutoRelockTime > 2) {
                    mReceiverAutoRelockTime = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, this.mInt3[mReceiverAutoRelockTime]}, null, null);
                break;
            case R.id.guandao_btn_auto_relock_time_add /* 2131433288 */:
                int mReceiverAutoRelockTime2 = DataCanbus.DATA[38] + 1;
                if (mReceiverAutoRelockTime2 < 0) {
                    mReceiverAutoRelockTime2 = 2;
                } else if (mReceiverAutoRelockTime2 > 2) {
                    mReceiverAutoRelockTime2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, this.mInt3[mReceiverAutoRelockTime2]}, null, null);
                break;
            case R.id.guandao_btn_auto_lock_sub /* 2131433289 */:
                int value = DataCanbus.DATA[40] - 1;
                if (value > 2) {
                    value = 0;
                } else if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value}, null, null);
                break;
            case R.id.guandao_btn_auto_lock_add /* 2131433291 */:
                int value2 = DataCanbus.DATA[40] + 1;
                if (value2 > 2) {
                    value2 = 0;
                } else if (value2 < 0) {
                    value2 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value2}, null, null);
                break;
            case R.id.guandao_btn_auto_unlock_sub /* 2131433292 */:
                int value3 = DataCanbus.DATA[39] - 1;
                if (value3 > 2) {
                    value3 = 0;
                }
                if (value3 < 0) {
                    value3 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value3}, null, null);
                break;
            case R.id.guandao_btn_auto_unlock_add /* 2131433294 */:
                int value4 = DataCanbus.DATA[39] + 1;
                if (value4 > 2) {
                    value4 = 0;
                } else if (value4 < 0) {
                    value4 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value4}, null, null);
                break;
            case R.id.guandao_btn_turn_off_time_sub /* 2131433295 */:
                int mSendTurnOffTime = DataCanbus.DATA[34] - 1;
                if (mSendTurnOffTime < 0) {
                    mSendTurnOffTime = 3;
                } else if (mSendTurnOffTime > 3) {
                    mSendTurnOffTime = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, this.mInt4[mSendTurnOffTime]}, null, null);
                break;
            case R.id.guandao_btn_turn_off_time_add /* 2131433297 */:
                int mSendTurnOffTime2 = DataCanbus.DATA[34] + 1;
                if (mSendTurnOffTime2 < 0) {
                    mSendTurnOffTime2 = 3;
                } else if (mSendTurnOffTime2 > 3) {
                    mSendTurnOffTime2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, this.mInt4[mSendTurnOffTime2]}, null, null);
                break;
            case R.id.guandao_btn_cytoreductive_time_sub /* 2131433298 */:
                int mSendCytoreductiveTime = DataCanbus.DATA[35] - 1;
                if (mSendCytoreductiveTime < 0) {
                    mSendCytoreductiveTime = 2;
                } else if (mSendCytoreductiveTime > 2) {
                    mSendCytoreductiveTime = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, this.mInt3[mSendCytoreductiveTime]}, null, null);
                break;
            case R.id.guandao_btn_cytoreductive_time_add /* 2131433300 */:
                int mSendCytoreductiveTime2 = DataCanbus.DATA[35] + 1;
                if (mSendCytoreductiveTime2 < 0) {
                    mSendCytoreductiveTime2 = 2;
                } else if (mSendCytoreductiveTime2 > 2) {
                    mSendCytoreductiveTime2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, this.mInt3[mSendCytoreductiveTime2]}, null, null);
                break;
            case R.id.guandao_amp_loud_sub /* 2131433303 */:
                int value5 = DataCanbus.DATA[47] - 1;
                if (value5 > 12) {
                    value5 = 0;
                } else if (value5 < 0) {
                    value5 = 12;
                }
                DataCanbus.PROXY.cmd(2, new int[]{12, value5}, null, null);
                break;
            case R.id.guandao_amp_loud_add /* 2131433305 */:
                int value6 = DataCanbus.DATA[47] + 1;
                if (value6 > 12) {
                    value6 = 0;
                } else if (value6 < 0) {
                    value6 = 12;
                }
                DataCanbus.PROXY.cmd(2, new int[]{12, value6}, null, null);
                break;
            case R.id.guandao_speed_sub /* 2131433307 */:
                int value7 = DataCanbus.DATA[48] - 1;
                if (value7 > 3) {
                    value7 = 0;
                } else if (value7 < 0) {
                    value7 = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value7}, null, null);
                break;
            case R.id.guandao_speed_add /* 2131433309 */:
                int value8 = DataCanbus.DATA[48] + 1;
                if (value8 > 3) {
                    value8 = 0;
                } else if (value8 < 0) {
                    value8 = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value8}, null, null);
                break;
            case R.id.guandao_dts /* 2131433311 */:
                DataCanbus.PROXY.cmd(2, new int[]{13, (DataCanbus.DATA[49] + 1) % 2}, null, null);
                break;
            case R.id.guandao_keyless_access_beep_volume_sub /* 2131433312 */:
                int value9 = DataCanbus.DATA[41];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value9}, null, null);
                break;
            case R.id.guandao_keyless_access_beep_volume_add /* 2131433314 */:
                int value10 = DataCanbus.DATA[41];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value10}, null, null);
                break;
            case R.id.guandao_keyless_access_beep /* 2131433315 */:
                DataCanbus.PROXY.cmd(1, new int[]{13, (DataCanbus.DATA[42] + 1) % 2}, null, null);
                break;
            case R.id.guandao_beep_lockLight /* 2131433316 */:
                DataCanbus.PROXY.cmd(1, new int[]{14, (DataCanbus.DATA[43] + 1) % 2}, null, null);
                break;
            case R.id.guandao_beep_start /* 2131433317 */:
                DataCanbus.PROXY.cmd(1, new int[]{15, (DataCanbus.DATA[44] + 1) % 2}, null, null);
                break;
            case R.id.guandao_diandongshoub_sub /* 2131433319 */:
                int value11 = DataCanbus.DATA[45];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value11}, null, null);
                break;
            case R.id.guandao_diandongshoub_add /* 2131433321 */:
                int value12 = DataCanbus.DATA[45];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value12}, null, null);
                break;
            case R.id.guandao_remote_open_sub /* 2131433323 */:
                int value13 = DataCanbus.DATA[46];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value13}, null, null);
                break;
            case R.id.guandao_remote_open_add /* 2131433325 */:
                int value14 = DataCanbus.DATA[46];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value14}, null, null);
                break;
        }
    }
}
