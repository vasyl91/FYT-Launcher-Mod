package com.syu.carinfo.daojun.b70;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DaojunB70LowCarSettingAct extends BaseActivity {
    public static DaojunB70LowCarSettingAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.b70.DaojunB70LowCarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 24:
                    DaojunB70LowCarSettingAct.this.mUpdaterCarType(DataCanbus.DATA[updateCode]);
                    break;
                case 25:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioBand((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_band), DataCanbus.DATA[updateCode]);
                    break;
                case 26:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioNum(DataCanbus.DATA[updateCode]);
                    break;
                case 27:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq), DataCanbus.DATA[updateCode]);
                    break;
                case 28:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq1), DataCanbus.DATA[updateCode]);
                    break;
                case 29:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq2), DataCanbus.DATA[updateCode]);
                    break;
                case 30:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq3), DataCanbus.DATA[updateCode]);
                    break;
                case 31:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq4), DataCanbus.DATA[updateCode]);
                    break;
                case 32:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq5), DataCanbus.DATA[updateCode]);
                    break;
                case 33:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq6), DataCanbus.DATA[updateCode]);
                    break;
                case 34:
                    DaojunB70LowCarSettingAct.this.mUpdaterCDTrack((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_cd_track), DataCanbus.DATA[updateCode]);
                    break;
                case 36:
                    DaojunB70LowCarSettingAct.this.mUpdaterCDCycleMode((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_cd_cycle_mode), DataCanbus.DATA[updateCode]);
                    break;
                case 37:
                    DaojunB70LowCarSettingAct.this.mUpdaterCDPalystate((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_cd_play_state), DataCanbus.DATA[updateCode]);
                    break;
                case 38:
                case 39:
                    DaojunB70LowCarSettingAct.this.mUpdaterCDTime((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_cd_time));
                    break;
                case 40:
                case 41:
                    DaojunB70LowCarSettingAct.this.mUpdaterCarVol((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_vol));
                    break;
                case 48:
                    DaojunB70LowCarSettingAct.this.mUpdaterOntherInfo((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_Otherinfo), DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInit = this;
        setContentView(R.layout.layout_0439_daojunlow14b70_time_setting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.btn_b70_tv_car_setinfo).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.b70.DaojunB70LowCarSettingAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(DaojunB70LowCarSettingAct.this, DaojunB70LowCarSettingInfoAct.class);
                    DaojunB70LowCarSettingAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(13);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            finish();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioNum(int value) {
        ((TextView) findViewById(R.id.b70_tv_car_radio_freq1)).setTextColor(-1);
        ((TextView) findViewById(R.id.b70_tv_car_radio_freq2)).setTextColor(-1);
        ((TextView) findViewById(R.id.b70_tv_car_radio_freq3)).setTextColor(-1);
        ((TextView) findViewById(R.id.b70_tv_car_radio_freq4)).setTextColor(-1);
        ((TextView) findViewById(R.id.b70_tv_car_radio_freq5)).setTextColor(-1);
        ((TextView) findViewById(R.id.b70_tv_car_radio_freq6)).setTextColor(-1);
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.b70_tv_car_radio_freq1)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.b70_tv_car_radio_freq2)).setTextColor(-65536);
                break;
            case 3:
                ((TextView) findViewById(R.id.b70_tv_car_radio_freq3)).setTextColor(-65536);
                break;
            case 4:
                ((TextView) findViewById(R.id.b70_tv_car_radio_freq4)).setTextColor(-65536);
                break;
            case 5:
                ((TextView) findViewById(R.id.b70_tv_car_radio_freq5)).setTextColor(-65536);
                break;
            case 6:
                ((TextView) findViewById(R.id.b70_tv_car_radio_freq6)).setTextColor(-65536);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioBand(TextView tvView, int value) {
        if (tvView != null) {
            switch (value) {
                case 1:
                    tvView.setText(String.format("FM1", new Object[0]));
                    break;
                case 2:
                    tvView.setText(String.format("FM2", new Object[0]));
                    break;
                case 3:
                    tvView.setText(String.format("FM3", new Object[0]));
                    break;
                case 17:
                    tvView.setText(String.format("AM1", new Object[0]));
                    break;
                case 18:
                    tvView.setText(String.format("AM2", new Object[0]));
                    break;
                default:
                    tvView.setText(String.format("FM1", new Object[0]));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioFreq(TextView tvView, int value) {
        if (tvView != null) {
            if (DataCanbus.DATA[25] == 1 || DataCanbus.DATA[25] == 2 || DataCanbus.DATA[25] == 3) {
                tvView.setText(String.format("%d.%d Mhz", Integer.valueOf(value / 100), Integer.valueOf((value % 100) / 10)));
            } else if (DataCanbus.DATA[25] == 17 || DataCanbus.DATA[25] == 18) {
                tvView.setText(String.format("%d Khz", Integer.valueOf(value)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCDTrack(TextView tvView, int value) {
        if (tvView != null) {
            tvView.setText(String.format(" Track %d", Integer.valueOf(value)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCDCycleMode(TextView tvView, int value) {
        if (tvView != null) {
            switch (value) {
                case 1:
                    tvView.setText(String.format("顺序播放", new Object[0]));
                    break;
                case 2:
                    tvView.setText(String.format("重复播放", new Object[0]));
                    break;
                case 3:
                    tvView.setText(String.format("扫描", new Object[0]));
                    break;
                case 4:
                    tvView.setText(String.format("随机播放", new Object[0]));
                    break;
                default:
                    tvView.setText(String.format("顺序播放", new Object[0]));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCDTime(TextView tvView) {
        if (tvView != null) {
            int cdtimeMin = DataCanbus.DATA[38];
            int cdtimeSec = DataCanbus.DATA[39];
            tvView.setText(String.format("%d : %d", Integer.valueOf(cdtimeMin), Integer.valueOf(cdtimeSec)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarVol(TextView tvView) {
        if (tvView != null) {
            int value = DataCanbus.DATA[40];
            int mutevalue = DataCanbus.DATA[41];
            if (mutevalue == 2) {
                tvView.setText(String.format("0", new Object[0]));
            } else {
                tvView.setText(String.format("%d", Integer.valueOf(value)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarType(int value) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOntherInfo(TextView tvView, int value) {
        if (tvView != null) {
            switch (value) {
                case 1:
                    tvView.setText(String.format("开机界面", new Object[0]));
                    break;
                case 2:
                    tvView.setText(String.format("音量界面", new Object[0]));
                    break;
                case 3:
                    tvView.setText(String.format("正在读碟", new Object[0]));
                    break;
                case 4:
                    tvView.setText(String.format("正在出碟", new Object[0]));
                    break;
                case 5:
                    tvView.setText(String.format("碟片错误", new Object[0]));
                    break;
                case 6:
                    tvView.setText(String.format("无碟片", new Object[0]));
                    break;
                case 7:
                    tvView.setText(String.format("AUX界面", new Object[0]));
                    break;
                case 8:
                    tvView.setText(String.format("无媒体资源", new Object[0]));
                    break;
                case 9:
                    tvView.setText(String.format("已经关机", new Object[0]));
                    break;
                case 10:
                    tvView.setText(String.format("蓝牙线路故障", new Object[0]));
                    break;
                default:
                    tvView.setText(String.format("播放", new Object[0]));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCDPalystate(TextView tvView, int value) {
        if (tvView != null) {
            switch (value) {
                case 1:
                    tvView.setText(String.format("播放", new Object[0]));
                    break;
                case 2:
                    tvView.setText(String.format("暂停", new Object[0]));
                    break;
                default:
                    tvView.setText(String.format("播放", new Object[0]));
                    break;
            }
        }
    }
}
