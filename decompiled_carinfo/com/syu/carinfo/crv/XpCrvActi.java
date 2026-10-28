package com.syu.carinfo.crv;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XpCrvActi extends BaseActivity {
    public static XpCrvActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    XpCrvActi.this.mUpdaterStatus();
                    break;
                case 99:
                    XpCrvActi.this.mUpdaterCurrSource();
                    break;
                case 100:
                    XpCrvActi.this.mUpdaterTrackTime();
                    break;
                case 101:
                    XpCrvActi.this.mUpdaterTrack();
                    break;
                case 102:
                    XpCrvActi.this.mUpdaterTrack();
                    break;
                case 103:
                    XpCrvActi.this.mUpdaterFolder();
                    break;
                case 104:
                    XpCrvActi.this.mUpdaterProgress();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_12crv_xp);
        mInstance = this;
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.crv_btn_ff).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, 3);
            }
        });
        findViewById(R.id.crv_btn_fr).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, 4);
            }
        });
        findViewById(R.id.crv_btn_play).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, 1);
            }
        });
        findViewById(R.id.crv_btn_stop).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, 2);
            }
        });
        findViewById(R.id.xp_crv_compass).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.crv.XpCompassActi");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[98] != 4) {
            DataCanbus.PROXY.cmd(0, 1);
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

    
    public void mUpdaterCurrSource() {
        int value = DataCanbus.DATA[99];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_ipod);
                break;
            case 2:
                ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_usb);
                break;
            default:
                ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_null);
                break;
        }
    }

    
    public void mUpdaterFolder() {
        int value = DataCanbus.DATA[103];
        if (value == 16777215) {
            ((TextView) findViewById(R.id.crv_tv_mdi)).setText("----");
        } else {
            ((TextView) findViewById(R.id.crv_tv_mdi)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterTrack() {
        int track = DataCanbus.DATA[101];
        int tarckTotal = DataCanbus.DATA[102];
        if (track == 16777215 || tarckTotal == 16777215) {
            ((TextView) findViewById(R.id.crv_tv_track)).setText("--/--");
        } else {
            ((TextView) findViewById(R.id.crv_tv_track)).setText(String.format("%d/%d", Integer.valueOf(track), Integer.valueOf(tarckTotal)));
        }
    }

    
    public void mUpdaterTrackTime() {
        int value = DataCanbus.DATA[100];
        int minute = (value >> 8) & 255;
        int second = value & 255;
        if (value == 16777215) {
            ((TextView) findViewById(R.id.crv_tv_time)).setText("--:--");
        } else {
            ((TextView) findViewById(R.id.crv_tv_time)).setText(String.format("%02d:%02d", Integer.valueOf(minute), Integer.valueOf(second)));
        }
    }

    
    public void mUpdaterProgress() {
        int progress = DataCanbus.DATA[104];
        if (progress < 0) {
            progress = 0;
        } else if (progress > 100) {
            progress = 100;
        }
        ((ProgressBar) findViewById(R.id.crv_progress)).setProgress(progress);
    }

    
    public void mUpdaterStatus() {
        int value = DataCanbus.DATA[98];
        switch (value) {
            case 0:
                FuncMain.tips(getResources().getString(R.string.crv_state_stop));
                break;
            case 1:
                FuncMain.tips(getResources().getString(R.string.crv_state_loading));
                break;
            case 4:
                FuncMain.tips(getResources().getString(R.string.crv_state_play));
                break;
            case 5:
                FuncMain.tips(getResources().getString(R.string.crv_state_pause));
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            DataCanbus.PROXY.cmd(0, 2);
            finish();
            return true;
        }
        return true;
    }
}
