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

@SuppressWarnings({"deprecation", "unchecked"})
public class DaojunB70LowCarSettingAct extends BaseActivity {
    public static DaojunB70LowCarSettingAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    DaojunB70LowCarSettingAct.this.mUpdaterCarType(DataCanbus.DATA[updateCode]);
                    break;
                case 99:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioBand((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_band), DataCanbus.DATA[updateCode]);
                    break;
                case 100:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioNum(DataCanbus.DATA[updateCode]);
                    break;
                case 101:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq), DataCanbus.DATA[updateCode]);
                    break;
                case 102:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq1), DataCanbus.DATA[updateCode]);
                    break;
                case 103:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq2), DataCanbus.DATA[updateCode]);
                    break;
                case 104:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq3), DataCanbus.DATA[updateCode]);
                    break;
                case 105:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq4), DataCanbus.DATA[updateCode]);
                    break;
                case 106:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq5), DataCanbus.DATA[updateCode]);
                    break;
                case 107:
                    DaojunB70LowCarSettingAct.this.mUpdaterRadioFreq((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_radio_freq6), DataCanbus.DATA[updateCode]);
                    break;
                case 108:
                    DaojunB70LowCarSettingAct.this.mUpdaterCDTrack((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_cd_track), DataCanbus.DATA[updateCode]);
                    break;
                case 110:
                    DaojunB70LowCarSettingAct.this.mUpdaterCDCycleMode((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_cd_cycle_mode), DataCanbus.DATA[updateCode]);
                    break;
                case 111:
                    DaojunB70LowCarSettingAct.this.mUpdaterCDPalystate((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_cd_play_state), DataCanbus.DATA[updateCode]);
                    break;
                case 112:
                case 113:
                    DaojunB70LowCarSettingAct.this.mUpdaterCDTime((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_cd_time));
                    break;
                case 114:
                case 115:
                    DaojunB70LowCarSettingAct.this.mUpdaterCarVol((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_vol));
                    break;
                case 122:
                    DaojunB70LowCarSettingAct.this.mUpdaterOntherInfo((TextView) DaojunB70LowCarSettingAct.this.findViewById(R.id.b70_tv_car_Otherinfo), DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInit = this;
        //setContentView(R.layout.layout_0439_daojunlow14b70_time_setting);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.btn_b70_tv_car_setinfo).setOnClickListener(new View.OnClickListener() { 
            @Override
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(13);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            finish();
            return true;
        }
        return true;
    }

    
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

    
    public void mUpdaterRadioFreq(TextView tvView, int value) {
        if (tvView != null) {
            if (DataCanbus.DATA[99] == 1 || DataCanbus.DATA[99] == 2 || DataCanbus.DATA[99] == 3) {
                tvView.setText(String.format("%d.%d Mhz", Integer.valueOf(value / 100), Integer.valueOf((value % 100) / 10)));
            } else if (DataCanbus.DATA[99] == 17 || DataCanbus.DATA[99] == 18) {
                tvView.setText(String.format("%d Khz", Integer.valueOf(value)));
            }
        }
    }

    
    public void mUpdaterCDTrack(TextView tvView, int value) {
        if (tvView != null) {
            tvView.setText(String.format(" Track %d", Integer.valueOf(value)));
        }
    }

    
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

    
    public void mUpdaterCDTime(TextView tvView) {
        if (tvView != null) {
            int cdtimeMin = DataCanbus.DATA[112];
            int cdtimeSec = DataCanbus.DATA[113];
            tvView.setText(String.format("%d : %d", Integer.valueOf(cdtimeMin), Integer.valueOf(cdtimeSec)));
        }
    }

    
    public void mUpdaterCarVol(TextView tvView) {
        if (tvView != null) {
            int value = DataCanbus.DATA[114];
            int mutevalue = DataCanbus.DATA[115];
            if (mutevalue == 2) {
                tvView.setText(String.format("0", new Object[0]));
            } else {
                tvView.setText(String.format("%d", Integer.valueOf(value)));
            }
        }
    }

    
    public void mUpdaterCarType(int value) {
    }

    
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
