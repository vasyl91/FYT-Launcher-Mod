package com.syu.carinfo.crv;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0188_XBS_XP1_CRV2012;
import com.syu.module.canbus.DataCanbus;

public class CrvXBSActi extends BaseActivity {
    public static CrvXBSActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 7:
                    CrvXBSActi.this.mUpdaterStatus();
                    break;
                case 8:
                    CrvXBSActi.this.mUpdaterCurrSource();
                    break;
                case 9:
                    CrvXBSActi.this.mUpdaterMdi();
                    break;
                case 10:
                    CrvXBSActi.this.mUpdaterTrackTime();
                    break;
                case 11:
                    CrvXBSActi.this.mUpdaterTrack();
                    break;
                case 12:
                    CrvXBSActi.this.mUpdaterProgress();
                    break;
            }
        }
    };
    Toast toast = null;
    TextView view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_crv);
        mInstance = this;
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.crv_btn_ff).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 4);
            }
        });
        findViewById(R.id.crv_btn_fr).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 3);
            }
        });
        findViewById(R.id.crv_btn_play).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 1);
            }
        });
        findViewById(R.id.crv_btn_scan).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 2);
            }
        });
        findViewById(R.id.crv_btn_folderb).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 9);
            }
        });
        findViewById(R.id.crv_btn_folderf).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 9);
            }
        });
        findViewById(R.id.crv_btn_playmode).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 10);
            }
        });
        findViewById(R.id.crv_btn_random).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 11);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[7] != 1) {
            DataCanbus.PROXY.cmd(1, 1);
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
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCurrSource() {
        int value = DataCanbus.DATA[8];
        if (value == 0) {
            ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_usb);
            return;
        }
        if (value == -128) {
            ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_ipod);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_BT);
        } else {
            ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_null);
        }
    }

    
    public void mUpdaterMdi() {
        int value = DataCanbus.DATA[9];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.crv_tv_mdi)).setText(R.string.crv_playstate_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.crv_tv_mdi)).setText(R.string.crv_playstate_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.crv_tv_mdi)).setText(R.string.crv_playstate_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.crv_tv_mdi)).setText(R.string.crv_playstate_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.crv_tv_mdi)).setText(R.string.crv_playstate_4);
                break;
        }
    }

    
    public void mUpdaterTrack() {
        int track = Callback_0188_XBS_XP1_CRV2012.mTRACK_INFO[0];
        int tarckTotal = Callback_0188_XBS_XP1_CRV2012.mTRACK_INFO[1];
        ((TextView) findViewById(R.id.crv_tv_track)).setText(String.format("%d/%d", Integer.valueOf(track), Integer.valueOf(tarckTotal)));
    }

    
    public void mUpdaterTrackTime() {
        int minute = Callback_0188_XBS_XP1_CRV2012.mTRACK_TIME_INFO[0];
        int second = Callback_0188_XBS_XP1_CRV2012.mTRACK_TIME_INFO[1];
        ((TextView) findViewById(R.id.crv_tv_time)).setText(String.format("%02d:%02d:%02d", Integer.valueOf(minute / 60), Integer.valueOf(minute % 60), Integer.valueOf(second)));
    }

    
    public void mUpdaterProgress() {
        int progress = DataCanbus.DATA[12];
        if (progress < 0) {
            progress = 0;
        } else if (progress > 100) {
            progress = 100;
        }
        ((ProgressBar) findViewById(R.id.crv_progress)).setProgress(progress);
    }

    
    public void mUpdaterStatus() {
        int value = DataCanbus.DATA[7];
        switch (value) {
            case 0:
                tips(getResources().getString(R.string.crv_state_stop));
                break;
            case 1:
                tips(getResources().getString(R.string.crv_state_play));
                break;
            case 2:
                tips(getResources().getString(R.string.crv_state_pause));
                break;
            case 3:
            case 4:
            default:
                tips(getResources().getString(R.string.crv_state_stop));
                break;
            case 5:
                tips(getResources().getString(R.string.crv_state_ScanFile));
                break;
            case 6:
                tips(getResources().getString(R.string.crv_state_ScanFld));
                break;
            case 7:
                tips(getResources().getString(R.string.crv_state_loading));
                break;
        }
    }

    public void tips(String str) {
        this.toast = new Toast(this);
        this.toast.setGravity(17, 0, 0);
        this.toast.setDuration(0);
        this.view = new TextView(this);
        this.view.setText(str);
        this.view.setWidth(200);
        this.view.setHeight(100);
        this.view.setGravity(17);
        this.view.setBackgroundResource(R.drawable.d_popwindow);
        this.view.setTextSize(24.0f);
        this.toast.setView(this.view);
        this.toast.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            DataCanbus.PROXY.cmd(1, 2);
            finish();
        }
        return true;
    }
}
