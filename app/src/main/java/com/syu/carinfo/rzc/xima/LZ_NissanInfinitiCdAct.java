package com.syu.carinfo.rzc.xima;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LZ_NissanInfinitiCdAct extends BaseActivity implements View.OnTouchListener {
    public static LZ_NissanInfinitiCdAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 133:
                    LZ_NissanInfinitiCdAct.this.mUpdaterCdState(value);
                    break;
                case 134:
                    LZ_NissanInfinitiCdAct.this.mUpdaterCdTrack();
                    break;
                case 135:
                case 136:
                case 137:
                    LZ_NissanInfinitiCdAct.this.mUpdaterCdTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_lz_infiniti_qx56_cd_act);
        mInstance = this;
        ((Button) findViewById(R.id.cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_fb)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_play)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_pause)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_ff)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(7, cmdId, touchState);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int cmdId = -1;
        int flag = 0;
        int id = v.getId();
        switch (id) {
            case R.id.cd_prev /* 2131427918 */:
                cmdId = 3;
                break;
            case R.id.cd_fb /* 2131427919 */:
                flag = 1;
                cmdId = 5;
                break;
            case R.id.cd_play /* 2131427920 */:
                cmdId = 0;
                break;
            case R.id.cd_pause /* 2131427921 */:
                cmdId = 1;
                break;
            case R.id.cd_ff /* 2131427922 */:
                flag = 1;
                cmdId = 4;
                break;
            case R.id.cd_next /* 2131427923 */:
                cmdId = 2;
                break;
        }
        if (flag == 1) {
            switch (event.getAction()) {
                case 0:
                    setCdControl(cmdId, 1);
                case 1:
                    setCdControl(cmdId, 0);
            }
        } else {
            switch (event.getAction()) {
                case 0:
                    setCdControl(cmdId, 0);
                default:
                    return false;
            }
        }
        return false;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCdState(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.str_status_idle);
                break;
            case 1:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate2);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate6);
                break;
            case 3:
                ((TextView) findViewById(R.id.cd_state)).setText("FF");
                break;
            case 4:
                ((TextView) findViewById(R.id.cd_state)).setText("FB");
                break;
            case 5:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate3);
                break;
            case 6:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate4);
                break;
            case 7:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate5);
                break;
            case 8:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate1);
                break;
            case 9:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate9);
                break;
        }
    }

    
    public void mUpdaterCdTrack() {
        int value = DataCanbus.DATA[134];
        ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + value);
    }

    
    public void mUpdaterCdTime() {
        int min = DataCanbus.DATA[135];
        int sec = DataCanbus.DATA[136];
        int hour = DataCanbus.DATA[137];
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(hour / 10) + (hour % 10) + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
    }
}
