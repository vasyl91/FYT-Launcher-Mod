package com.syu.carinfo.xc.gongjue;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class XCTianLaiGjCdAct extends BaseActivity implements View.OnTouchListener {
    public static XCTianLaiGjCdAct mInstance;
    public static boolean mIsFront = false;
    int cmdId = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 105:
                    XCTianLaiGjCdAct.this.mUpdaterCdState(value);
                    break;
                case 106:
                    XCTianLaiGjCdAct.this.mUpdaterCdTrack();
                    break;
                case 107:
                case 108:
                    XCTianLaiGjCdAct.this.mUpdaterCdTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_tianlai_gj_cd_act);
        mInstance = this;
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_play)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_pause)).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(1, 1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(2, cmdId, touchState);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.cd_prev /* 2131427918 */:
                this.cmdId = 5;
                break;
            case R.id.cd_play /* 2131427920 */:
                this.cmdId = 1;
                break;
            case R.id.cd_pause /* 2131427921 */:
                this.cmdId = 2;
                break;
            case R.id.cd_next /* 2131427923 */:
                this.cmdId = 4;
                break;
        }
        if (this.cmdId != -1) {
            switch (event.getAction()) {
                case 0:
                    setCdControl(this.cmdId, 1);
                    break;
                case 1:
                    setCdControl(this.cmdId, 0);
                    break;
            }
        }
        return false;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCdState(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate2);
                break;
            case 1:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate7);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate6);
                break;
            case 3:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate11);
                break;
        }
    }

    
    public void mUpdaterCdTrack() {
        int value = DataCanbus.DATA[106];
        if (value == 0 || value == 255) {
            ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: ");
        } else {
            ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + value);
        }
    }

    
    public void mUpdaterCdTime() {
        int value1 = DataCanbus.DATA[107];
        int value2 = DataCanbus.DATA[108];
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(value1) + ":" + value2);
    }
}
