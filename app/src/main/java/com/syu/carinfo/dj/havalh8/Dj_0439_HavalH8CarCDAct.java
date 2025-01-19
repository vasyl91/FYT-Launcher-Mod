package com.syu.carinfo.dj.havalh8;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Dj_0439_HavalH8CarCDAct extends Activity implements View.OnTouchListener {
    public static Dj_0439_HavalH8CarCDAct mInstance;
    public static boolean mIsFront = false;
    int cmdId = -1;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 134:
                    Dj_0439_HavalH8CarCDAct.this.mUpdaterCdTrack();
                    break;
                case 135:
                case 136:
                    Dj_0439_HavalH8CarCDAct.this.mUpdaterCdRepeatState();
                    break;
                case 137:
                    Dj_0439_HavalH8CarCDAct.this.mUpdaterCdState(value);
                    break;
                case 138:
                case 139:
                    Dj_0439_HavalH8CarCDAct.this.mUpdaterCdTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_dj_havalh8_carcd);
        mInstance = this;
        init();
    }

    private void init() {
        findViewById(R.id.cd_prev).setOnTouchListener(this);
        findViewById(R.id.cd_next).setOnTouchListener(this);
        findViewById(R.id.cd_play).setOnTouchListener(this);
        findViewById(R.id.cd_pause).setOnTouchListener(this);
        findViewById(R.id.cd_rpt_random).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        setCdControl(7, 1, 0);
        setCdControl(7, 0, 0);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int touchState, int type) {
        if (type == 1) {
            DataCanbus.PROXY.cmd(5, cmdId, touchState);
        } else {
            DataCanbus.PROXY.cmd(4, cmdId, touchState);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int type = 0;
        switch (id) {
            case R.id.cd_prev /* 2131427918 */:
                this.cmdId = 9;
                break;
            case R.id.cd_play /* 2131427920 */:
                type = 1;
                this.cmdId = 17;
                break;
            case R.id.cd_pause /* 2131427921 */:
                type = 1;
                this.cmdId = 16;
                break;
            case R.id.cd_next /* 2131427923 */:
                this.cmdId = 8;
                break;
            case R.id.cd_rpt_random /* 2131428193 */:
                int value = DataCanbus.DATA[135];
                int value1 = DataCanbus.DATA[136];
                if (value == 0 && value1 == 0) {
                    this.cmdId = 1;
                } else if (value == 1 && value1 == 0) {
                    this.cmdId = 2;
                } else if (value == 0 && value1 == 1) {
                    this.cmdId = 0;
                }
                type = 1;
                break;
        }
        if (this.cmdId != -1) {
            switch (event.getAction()) {
                case 0:
                    setCdControl(this.cmdId, 1, type);
                    break;
                case 1:
                    setCdControl(this.cmdId, 0, type);
                    break;
            }
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCdState(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate6);
                break;
            case 1:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate2);
                break;
        }
    }

    
    public void mUpdaterCdRepeatState() {
        int value = DataCanbus.DATA[135];
        int value1 = DataCanbus.DATA[136];
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.xp_380_playmode1);
            findViewById(R.id.cd_rpt_random).setBackgroundResource(R.drawable.ic_cd_repeat_n);
        } else if (value == 1 && value1 == 0) {
            ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.xp_380_playmode2);
            findViewById(R.id.cd_rpt_random).setBackgroundResource(R.drawable.ic_cd_repeat_p);
        } else if (value == 0 && value1 == 1) {
            ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.xp_380_playmode4);
            findViewById(R.id.cd_rpt_random).setBackgroundResource(R.drawable.ic_cd_random2_p);
        }
    }

    
    public void mUpdaterCdTrack() {
        int value = DataCanbus.DATA[134];
        ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + value);
    }

    
    public void mUpdaterCdTime() {
        int value1 = DataCanbus.DATA[138];
        int value2 = DataCanbus.DATA[139];
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(value1 / 16) + (value1 % 16) + ":" + (value2 / 16) + (value2 % 16));
    }
}
