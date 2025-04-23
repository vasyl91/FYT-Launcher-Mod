package com.syu.carinfo.crv;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class WcCrvActiAll extends BaseActivity {
    public static WcCrvActiAll mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 175:
                    WcCrvActiAll.this.mUpdaterCurrSource();
                    break;
                case 176:
                    WcCrvActiAll.this.mUpdaterTrackTime();
                    break;
                case 177:
                    WcCrvActiAll.this.mUpdaterTrack();
                    break;
                case 178:
                    WcCrvActiAll.this.mUpdaterTrack();
                    break;
                case 179:
                    WcCrvActiAll.this.mUpdaterFolder();
                    break;
                case 180:
                    WcCrvActiAll.this.mUpdaterProgress();
                    break;
                case 181:
                    WcCrvActiAll.this.playstatus();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_12crv_wc);
        mInstance = this;
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.crv_btn_fb_wc)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(111, new int[]{7}, null, null);
            }
        });
        findViewById(R.id.crv_btn_ff_wc).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(111, new int[]{7, 1}, null, null);
            }
        });
        findViewById(R.id.crv_btn_play_wc).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(111, new int[]{1}, null, null);
            }
        });
        findViewById(R.id.crv_btn_stop_wc).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(111, new int[]{2}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[181] != 2) {
            DataCanbus.PROXY.cmd(111, new int[]{1}, null, null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCurrSource() {
        int value = DataCanbus.DATA[175];
        switch (value) {
            case 13:
                ((TextView) findViewById(R.id.crv_tv_source_wc)).setText(R.string.crv_source_usb);
                break;
            case 14:
                ((TextView) findViewById(R.id.crv_tv_source_wc)).setText(R.string.crv_source_ipod);
                break;
            default:
                ((TextView) findViewById(R.id.crv_tv_source_wc)).setText(R.string.crv_source_null);
                break;
        }
    }

    
    public void mUpdaterFolder() {
        int value = DataCanbus.DATA[179];
        ((TextView) findViewById(R.id.crv_tv_mdi_wc)).setText(value == 0 ? R.string.crv_mdi_unsupport : R.string.crv_mdi_support);
    }

    
    public void mUpdaterTrack() {
        int track = DataCanbus.DATA[177];
        int tarckTotal = DataCanbus.DATA[178];
        if (track == 65535 || tarckTotal == 65535) {
            ((TextView) findViewById(R.id.crv_tv_track_wc)).setText("--/--");
        } else {
            ((TextView) findViewById(R.id.crv_tv_track_wc)).setText(String.format("%d/%d", Integer.valueOf(track), Integer.valueOf(tarckTotal)));
        }
    }

    
    public void mUpdaterTrackTime() {
        int value = DataCanbus.DATA[176];
        int minute = (value >> 8) & 255;
        int second = value & 255;
        if (value == 16777215) {
            ((TextView) findViewById(R.id.crv_tv_time_wc)).setText("--:--");
        } else {
            ((TextView) findViewById(R.id.crv_tv_time_wc)).setText(String.format("%02d:%02d", Integer.valueOf(minute), Integer.valueOf(second)));
        }
    }

    
    public void mUpdaterProgress() {
        int progress = DataCanbus.DATA[180];
        if (progress < 0) {
            progress = 0;
        } else if (progress > 100) {
            progress = 100;
        }
        ((ProgressBar) findViewById(R.id.crv_progress_wc)).setProgress(progress);
    }

    
    public void playstatus() {
        int value = DataCanbus.DATA[181];
        switch (value) {
            case 1:
                FuncMain.tips(getResources().getString(R.string.crv_state_pause));
                break;
            case 2:
                FuncMain.tips(getResources().getString(R.string.crv_state_play));
                break;
            case 3:
                FuncMain.tips(getResources().getString(R.string.crv_state_ff));
                break;
            case 6:
                FuncMain.tips(getResources().getString(R.string.crv_state_stop));
                break;
            case 9:
                FuncMain.tips(getResources().getString(R.string.crv_state_fr));
                break;
            case 12:
                FuncMain.tips(getResources().getString(R.string.crv_state_eject));
                break;
            case 13:
                FuncMain.tips(getResources().getString(R.string.crv_state_loading));
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            DataCanbus.PROXY.cmd(111, new int[]{2}, null, null);
            finish();
            return true;
        }
        return true;
    }
}
